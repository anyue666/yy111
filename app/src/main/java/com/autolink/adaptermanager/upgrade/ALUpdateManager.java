package com.autolink.adaptermanager.upgrade;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.upgrade.IUpgradeCallback;
import com.autolink.adapterinterface.upgrade.IUpgradeResultCallback;
import com.autolink.adapterinterface.upgrade.IUpgradeService;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.ALManagerFactory;
import com.autolink.adaptermanager.IALManager;
import com.autolink.adaptermanager.power.ALPowerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ALUpdateManager extends ALBaseManager implements IALManager {
    private static final String PACKAGE_NAME = "com.autolink.otaservice";
    private static final String TAG = "ALUpdateManager";
    private static final String UPDATE_SERVICE_NAME = "com.autolink.otaservice.UpdateManagerService";
    private ALManagerFactory alManagerFactory;
    private boolean isServiceConnected;
    private List<ALUpdateServiceConnectedListener> listenerList;
    private ALPowerManager mALPowerManager;
    private final IALManager.ServiceConnectionListener mListener;
    private IUpgradeService mService;
    private CopyOnWriteArrayList<ALUpdateResultListener> mUpdateResultListeners;
    private IUpgradeCallback mUpgradeCallback;
    private IUpgradeResultCallback mUpgradeResultCallback;
    private CopyOnWriteArrayList<ALUpdateStatusListener> mUpgradeStatusListeners;

    public interface ALUpdateResultListener {
        void onUpdateResult(int i);
    }

    public interface ALUpdateServiceConnectedListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public interface ALUpdateStatusListener {
        void onStatusUpdate(UpdateStatusConstants updateStatusConstants, int i);

        void onUpdateComplete(ErrorCodeConstants errorCodeConstants);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    /* renamed from: com.autolink.adaptermanager.upgrade.ALUpdateManager$1 */
    class AnonymousClass1 implements IALManager.ServiceConnectionListener {
        AnonymousClass1() {
        }

        @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
        public void onServiceConnected() {
            ALUpdateManager.this.isServiceConnected = true;
            Log.d(ALUpdateManager.TAG, "onPowerServiceConnected");
        }

        @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
        public void onServiceDisconnected() {
            ALUpdateManager.this.isServiceConnected = false;
            Log.d(ALUpdateManager.TAG, "onPowerServiceDisconnected");
        }
    }

    public void registerOTAServiceConnectedListener(ALUpdateServiceConnectedListener aLUpdateServiceConnectedListener) {
        if (this.listenerList.contains(aLUpdateServiceConnectedListener)) {
            return;
        }
        this.listenerList.add(aLUpdateServiceConnectedListener);
    }

    public void unregisterOTAServiceConnectedListener(ALUpdateServiceConnectedListener aLUpdateServiceConnectedListener) {
        if (this.listenerList.contains(aLUpdateServiceConnectedListener)) {
            this.listenerList.remove(aLUpdateServiceConnectedListener);
        }
    }

    public enum UpdateStatusConstants {
        NTF_InstallProgress(101),
        NTF_RebootResult(102),
        NTF_SwitchSlotResult(103),
        NTF_TeeVerifyResult(104);

        private final int value;

        UpdateStatusConstants(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static UpdateStatusConstants forNumber(int i) {
            switch (i) {
                case 101:
                    return NTF_InstallProgress;
                case 102:
                    return NTF_RebootResult;
                case 103:
                    return NTF_SwitchSlotResult;
                case 104:
                    return NTF_TeeVerifyResult;
                default:
                    return null;
            }
        }
    }

    public enum ErrorCodeConstants {
        INSTALL_SUCCESS(0),
        INSTALL_FAILED(1),
        INSTALL_SIGNATURE_VERIFY_FAILED(2),
        INSTALL_NO_SPACE_FAILED(3),
        INSTALL_ACCESS_STORAGE_FAILED(4),
        INSTALL_INVALID_SIGNATURE(5),
        INSTALL_OUT_OF_TIME_FAILED(6),
        INSTALL_INTERNAL_ERROR_FAILED(7);

        private final int value;

        ErrorCodeConstants(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ErrorCodeConstants forNumber(int i) {
            switch (i) {
                case 0:
                    return INSTALL_SUCCESS;
                case 1:
                    return INSTALL_FAILED;
                case 2:
                    return INSTALL_SIGNATURE_VERIFY_FAILED;
                case 3:
                    return INSTALL_NO_SPACE_FAILED;
                case 4:
                    return INSTALL_ACCESS_STORAGE_FAILED;
                case 5:
                    return INSTALL_INVALID_SIGNATURE;
                case 6:
                    return INSTALL_OUT_OF_TIME_FAILED;
                case 7:
                    return INSTALL_INTERNAL_ERROR_FAILED;
                default:
                    return null;
            }
        }
    }

    @Deprecated
    public ALUpdateManager(Context context) {
        super(context);
        this.listenerList = new ArrayList();
        this.isServiceConnected = false;
        AnonymousClass1 anonymousClass1 = new IALManager.ServiceConnectionListener() { // from class: com.autolink.adaptermanager.upgrade.ALUpdateManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
            public void onServiceConnected() {
                ALUpdateManager.this.isServiceConnected = true;
                Log.d(ALUpdateManager.TAG, "onPowerServiceConnected");
            }

            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
            public void onServiceDisconnected() {
                ALUpdateManager.this.isServiceConnected = false;
                Log.d(ALUpdateManager.TAG, "onPowerServiceDisconnected");
            }
        };
        this.mListener = anonymousClass1;
        this.mUpgradeCallback = new IUpgradeCallback.Stub() { // from class: com.autolink.adaptermanager.upgrade.ALUpdateManager.2
            AnonymousClass2() {
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
            public void onStatusUpdate(int i, int i2) throws RemoteException {
                Log.d(ALUpdateManager.TAG, "onUpgrade status: " + i + "percent: " + i2);
                Iterator it = ALUpdateManager.this.mUpgradeStatusListeners.iterator();
                while (it.hasNext()) {
                    ((ALUpdateStatusListener) it.next()).onStatusUpdate(UpdateStatusConstants.forNumber(i), i2);
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
            public void onUpdateComplete(int i) throws RemoteException {
                Log.d(ALUpdateManager.TAG, "onUpgradeComplete result: " + i);
                Iterator it = ALUpdateManager.this.mUpgradeStatusListeners.iterator();
                while (it.hasNext()) {
                    ((ALUpdateStatusListener) it.next()).onUpdateComplete(ErrorCodeConstants.forNumber(i));
                }
                if (i == ErrorCodeConstants.INSTALL_FAILED.getNumber()) {
                    ALUpdateManager.this.mALPowerManager.exitUpgradeState();
                    Log.d(ALUpdateManager.TAG, "onUpgradeComplete failed, power mode exit upgrade state.");
                }
            }
        };
        this.mUpgradeResultCallback = new IUpgradeResultCallback.Stub() { // from class: com.autolink.adaptermanager.upgrade.ALUpdateManager.3
            AnonymousClass3() {
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeResultCallback
            public void onUpgradeResult(int i) throws RemoteException {
                Log.d(ALUpdateManager.TAG, "onUpgradeResult result : " + i);
                Iterator it = ALUpdateManager.this.mUpdateResultListeners.iterator();
                while (it.hasNext()) {
                    ((ALUpdateResultListener) it.next()).onUpdateResult(i);
                }
            }
        };
        this.mUpgradeStatusListeners = new CopyOnWriteArrayList<>();
        this.mUpdateResultListeners = new CopyOnWriteArrayList<>();
        bindService();
        ALManagerFactory aLManagerFactory = ALManagerFactory.getInstance(this.mContext);
        this.alManagerFactory = aLManagerFactory;
        this.mALPowerManager = (ALPowerManager) aLManagerFactory.getManager("power", anonymousClass1);
    }

    public ALUpdateManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.listenerList = new ArrayList();
        this.isServiceConnected = false;
        AnonymousClass1 anonymousClass1 = new IALManager.ServiceConnectionListener() { // from class: com.autolink.adaptermanager.upgrade.ALUpdateManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
            public void onServiceConnected() {
                ALUpdateManager.this.isServiceConnected = true;
                Log.d(ALUpdateManager.TAG, "onPowerServiceConnected");
            }

            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
            public void onServiceDisconnected() {
                ALUpdateManager.this.isServiceConnected = false;
                Log.d(ALUpdateManager.TAG, "onPowerServiceDisconnected");
            }
        };
        this.mListener = anonymousClass1;
        this.mUpgradeCallback = new IUpgradeCallback.Stub() { // from class: com.autolink.adaptermanager.upgrade.ALUpdateManager.2
            AnonymousClass2() {
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
            public void onStatusUpdate(int i, int i2) throws RemoteException {
                Log.d(ALUpdateManager.TAG, "onUpgrade status: " + i + "percent: " + i2);
                Iterator it = ALUpdateManager.this.mUpgradeStatusListeners.iterator();
                while (it.hasNext()) {
                    ((ALUpdateStatusListener) it.next()).onStatusUpdate(UpdateStatusConstants.forNumber(i), i2);
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
            public void onUpdateComplete(int i) throws RemoteException {
                Log.d(ALUpdateManager.TAG, "onUpgradeComplete result: " + i);
                Iterator it = ALUpdateManager.this.mUpgradeStatusListeners.iterator();
                while (it.hasNext()) {
                    ((ALUpdateStatusListener) it.next()).onUpdateComplete(ErrorCodeConstants.forNumber(i));
                }
                if (i == ErrorCodeConstants.INSTALL_FAILED.getNumber()) {
                    ALUpdateManager.this.mALPowerManager.exitUpgradeState();
                    Log.d(ALUpdateManager.TAG, "onUpgradeComplete failed, power mode exit upgrade state.");
                }
            }
        };
        this.mUpgradeResultCallback = new IUpgradeResultCallback.Stub() { // from class: com.autolink.adaptermanager.upgrade.ALUpdateManager.3
            AnonymousClass3() {
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeResultCallback
            public void onUpgradeResult(int i) throws RemoteException {
                Log.d(ALUpdateManager.TAG, "onUpgradeResult result : " + i);
                Iterator it = ALUpdateManager.this.mUpdateResultListeners.iterator();
                while (it.hasNext()) {
                    ((ALUpdateResultListener) it.next()).onUpdateResult(i);
                }
            }
        };
        this.mUpgradeStatusListeners = new CopyOnWriteArrayList<>();
        this.mUpdateResultListeners = new CopyOnWriteArrayList<>();
        bindService();
        ALManagerFactory aLManagerFactory = ALManagerFactory.getInstance(this.mContext);
        this.alManagerFactory = aLManagerFactory;
        this.mALPowerManager = (ALPowerManager) aLManagerFactory.getManager("power", anonymousClass1);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent(UPDATE_SERVICE_NAME);
        intent.setPackage(PACKAGE_NAME);
        intent.setClassName(PACKAGE_NAME, UPDATE_SERVICE_NAME);
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        IUpgradeService asInterface = IUpgradeService.Stub.asInterface(iBinder);
        this.mService = asInterface;
        try {
            asInterface.registerUpgradeCallback(this.mUpgradeCallback);
            this.mService.registerUpgradeResultCallback(this.mUpgradeResultCallback);
            if (this.listenerList.isEmpty()) {
                return;
            }
            for (ALUpdateServiceConnectedListener aLUpdateServiceConnectedListener : this.listenerList) {
                Log.d(TAG, "=============onServiceConnected=============");
                aLUpdateServiceConnectedListener.onServiceConnected();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        try {
            this.mService.unregisterUpgradeCallback(this.mUpgradeCallback);
            this.mService.unregisterUpgradeResultCallback(this.mUpgradeResultCallback);
            if (!this.listenerList.isEmpty()) {
                for (ALUpdateServiceConnectedListener aLUpdateServiceConnectedListener : this.listenerList) {
                    Log.d(TAG, "=============onServiceDisconnected=============");
                    aLUpdateServiceConnectedListener.onServiceDisconnected();
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.mService = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        this.mService = null;
    }

    /* renamed from: com.autolink.adaptermanager.upgrade.ALUpdateManager$2 */
    class AnonymousClass2 extends IUpgradeCallback.Stub {
        AnonymousClass2() {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
        public void onStatusUpdate(int i, int i2) throws RemoteException {
            Log.d(ALUpdateManager.TAG, "onUpgrade status: " + i + "percent: " + i2);
            Iterator it = ALUpdateManager.this.mUpgradeStatusListeners.iterator();
            while (it.hasNext()) {
                ((ALUpdateStatusListener) it.next()).onStatusUpdate(UpdateStatusConstants.forNumber(i), i2);
            }
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
        public void onUpdateComplete(int i) throws RemoteException {
            Log.d(ALUpdateManager.TAG, "onUpgradeComplete result: " + i);
            Iterator it = ALUpdateManager.this.mUpgradeStatusListeners.iterator();
            while (it.hasNext()) {
                ((ALUpdateStatusListener) it.next()).onUpdateComplete(ErrorCodeConstants.forNumber(i));
            }
            if (i == ErrorCodeConstants.INSTALL_FAILED.getNumber()) {
                ALUpdateManager.this.mALPowerManager.exitUpgradeState();
                Log.d(ALUpdateManager.TAG, "onUpgradeComplete failed, power mode exit upgrade state.");
            }
        }
    }

    /* renamed from: com.autolink.adaptermanager.upgrade.ALUpdateManager$3 */
    class AnonymousClass3 extends IUpgradeResultCallback.Stub {
        AnonymousClass3() {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeResultCallback
        public void onUpgradeResult(int i) throws RemoteException {
            Log.d(ALUpdateManager.TAG, "onUpgradeResult result : " + i);
            Iterator it = ALUpdateManager.this.mUpdateResultListeners.iterator();
            while (it.hasNext()) {
                ((ALUpdateResultListener) it.next()).onUpdateResult(i);
            }
        }
    }

    public void registerUpgradeCallback(ALUpdateStatusListener aLUpdateStatusListener) {
        IUpgradeService iUpgradeService = this.mService;
        if (iUpgradeService != null) {
            try {
                iUpgradeService.registerUpgradeCallback(this.mUpgradeCallback);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.mUpgradeStatusListeners.contains(aLUpdateStatusListener)) {
            return;
        }
        this.mUpgradeStatusListeners.add(aLUpdateStatusListener);
    }

    public void unregisterUpgradeCallback(ALUpdateStatusListener aLUpdateStatusListener) {
        if (this.mUpgradeStatusListeners.contains(aLUpdateStatusListener)) {
            this.mUpgradeStatusListeners.remove(aLUpdateStatusListener);
        }
    }

    public void registerUpdateResultCallback(ALUpdateResultListener aLUpdateResultListener) {
        if (this.mUpdateResultListeners.contains(aLUpdateResultListener)) {
            return;
        }
        this.mUpdateResultListeners.add(aLUpdateResultListener);
    }

    public void unregisterUpdateResultCallback(ALUpdateResultListener aLUpdateResultListener) {
        if (this.mUpdateResultListeners.contains(aLUpdateResultListener)) {
            this.mUpdateResultListeners.remove(aLUpdateResultListener);
        }
    }

    public void applyOTAPayload(Bundle bundle) {
        Log.i(TAG, "applyOTAPayload, bundle: " + bundle.toString());
        if (this.mService != null) {
            try {
                if (this.isServiceConnected) {
                    this.mALPowerManager.enterUpgradeState();
                    Log.d(TAG, "Notify PowerService into upgrade status.");
                }
                this.mService.applyOTAPayload(bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void applyUSBPayload(Bundle bundle) {
        Log.i(TAG, "applyUSBPayload, bundle: " + bundle.toString());
        if (this.mService != null) {
            try {
                if (this.isServiceConnected) {
                    this.mALPowerManager.enterUpgradeState();
                    Log.d(TAG, "Notify PowerService into upgrade status.");
                }
                this.mService.applyUSBPayload(bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void applyDisplayPayload(Bundle bundle) {
        Log.i(TAG, "applyDisplayPayload, bundle: " + bundle.toString());
        IUpgradeService iUpgradeService = this.mService;
        if (iUpgradeService != null) {
            try {
                iUpgradeService.applyDisplayPayload(bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int requestUpgradeResult(int i, String str) {
        Log.i(TAG, "requestUpgradeResult");
        IUpgradeService iUpgradeService = this.mService;
        if (iUpgradeService == null) {
            return -1;
        }
        try {
            return iUpgradeService.requestUpgradeResult(i, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
