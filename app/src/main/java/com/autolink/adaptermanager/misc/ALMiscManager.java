package com.autolink.adaptermanager.misc;

import android.car.Car;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StatFs;
import android.util.Log;
import com.autolink.adapterinterface.misc.IALMisc;
import com.autolink.adapterinterface.misc.IMiscCustomSettingCallback;
import com.autolink.adapterinterface.misc.INetspeedCallback;
import com.autolink.adapterinterface.misc.IPitchRollAngleCallback;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ALMiscManager extends ALBaseManager implements IALManager {
    public static final String ALMISC_SERVICE_BINDER_SERVICE_NAME = "almisc_service";
    private static final String ALMISC_SERVICE_INTERFACE_NAME = "android.autolink.IAutoLinkMisc";
    private static final String ALMISC_SERVICE_PACKAGE = "com.autolink.miscservice";
    private static final float EPSILON = 0.01f;
    private static final long MISC_SERVICE_BINDER_POLLING_INTERVAL_MS = 50;
    private static final long MISC_SERVICE_BINDER_POLLING_MAX_RETRY = 100;
    private static final long MISC_SERVICE_BIND_MAX_RETRY = 20;
    private static final long MISC_SERVICE_BIND_RETRY_INTERVAL_MS = 500;
    private static final int PARAM_GET_SERIAL_NO = 3;
    private static final int PARAM_GET_SN = 2;
    private static final int PARAM_GET_VEHICLE_MODEL = 1;
    private static final int PARAM_GET_VIN = 0;
    private static int STATE_CONNECTED = 2;
    private static int STATE_CONNECTING = 1;
    private static int STATE_DISCONNECTED = 0;
    private static final String TAG = "ALMiscManager";
    public static final String[] VEHICLE_MODES = {"CX62B款", "9521款", "X90PRO", "X50", "T-1", "T1H"};
    private static float prePitchValue;
    private static float preRollValue;
    private Car mCar;
    private int mConnectionState;
    private final Object mLockForMiscService;
    private final IMiscCustomSettingCallback mMiscCustomSettingCallbackImpl;
    private final CopyOnWriteArrayList<MiscCustomSettingCallback> mMiscCustomSettingCallbacks;
    private final INetspeedCallback mNetspeedCallback;
    private final CopyOnWriteArrayList<NetspeedCallback> mNetspeedListeners;
    private final IPitchRollAngleCallback mPitchRollAngleCallback;
    private final CopyOnWriteArrayList<ALPitchRollAngleListener> mPitchRollAngleListeners;
    private IALMisc mService;
    private boolean mServiceBound;

    public interface ALPitchRollAngleListener {
        void onPitchRollAngleChanged(float f, float f2);
    }

    public static abstract class MiscCustomSettingCallback {
        public void onValueChanged(int i, String[] strArr) {
        }
    }

    public interface NetspeedCallback {
        void onNetspeedChanged(String str);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    /* renamed from: com.autolink.adaptermanager.misc.ALMiscManager$1 */
    class AnonymousClass1 extends IMiscCustomSettingCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.misc.IMiscCustomSettingCallback
        public void onValueChanged(int i, String[] strArr) {
            Iterator it = ALMiscManager.this.mMiscCustomSettingCallbacks.iterator();
            while (it.hasNext()) {
                MiscCustomSettingCallback miscCustomSettingCallback = (MiscCustomSettingCallback) it.next();
                Log.i(ALMiscManager.TAG, "onValueChanged callback=" + miscCustomSettingCallback);
                miscCustomSettingCallback.onValueChanged(i, strArr);
            }
        }
    }

    /* renamed from: com.autolink.adaptermanager.misc.ALMiscManager$2 */
    class AnonymousClass2 extends IPitchRollAngleCallback.Stub {
        AnonymousClass2() {
        }

        @Override // com.autolink.adapterinterface.misc.IPitchRollAngleCallback
        public void onPitchRollAngleChanged(float f, float f2) throws RemoteException {
            if (Math.abs(f - ALMiscManager.prePitchValue) > ALMiscManager.EPSILON || Math.abs(f2 - ALMiscManager.preRollValue) > ALMiscManager.EPSILON) {
                Log.i(ALMiscManager.TAG, "onPitchRollAngleChanged pitch = " + f + " roll = " + f2);
                float unused = ALMiscManager.prePitchValue = f;
                float unused2 = ALMiscManager.preRollValue = f2;
            }
            Iterator it = ALMiscManager.this.mPitchRollAngleListeners.iterator();
            while (it.hasNext()) {
                ((ALPitchRollAngleListener) it.next()).onPitchRollAngleChanged(f, f2);
            }
        }
    }

    /* renamed from: com.autolink.adaptermanager.misc.ALMiscManager$3 */
    class AnonymousClass3 extends INetspeedCallback.Stub {
        AnonymousClass3() {
        }

        @Override // com.autolink.adapterinterface.misc.INetspeedCallback
        public void onNetspeedChanged(String str) throws RemoteException {
            Iterator it = ALMiscManager.this.mNetspeedListeners.iterator();
            while (it.hasNext()) {
                ((NetspeedCallback) it.next()).onNetspeedChanged(str);
            }
        }
    }

    @Deprecated
    public ALMiscManager(Context context) {
        super(context);
        this.mLockForMiscService = new Object();
        this.mMiscCustomSettingCallbackImpl = new IMiscCustomSettingCallback.Stub() { // from class: com.autolink.adaptermanager.misc.ALMiscManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.misc.IMiscCustomSettingCallback
            public void onValueChanged(int i, String[] strArr) {
                Iterator it = ALMiscManager.this.mMiscCustomSettingCallbacks.iterator();
                while (it.hasNext()) {
                    MiscCustomSettingCallback miscCustomSettingCallback = (MiscCustomSettingCallback) it.next();
                    Log.i(ALMiscManager.TAG, "onValueChanged callback=" + miscCustomSettingCallback);
                    miscCustomSettingCallback.onValueChanged(i, strArr);
                }
            }
        };
        this.mPitchRollAngleCallback = new IPitchRollAngleCallback.Stub() { // from class: com.autolink.adaptermanager.misc.ALMiscManager.2
            AnonymousClass2() {
            }

            @Override // com.autolink.adapterinterface.misc.IPitchRollAngleCallback
            public void onPitchRollAngleChanged(float f, float f2) throws RemoteException {
                if (Math.abs(f - ALMiscManager.prePitchValue) > ALMiscManager.EPSILON || Math.abs(f2 - ALMiscManager.preRollValue) > ALMiscManager.EPSILON) {
                    Log.i(ALMiscManager.TAG, "onPitchRollAngleChanged pitch = " + f + " roll = " + f2);
                    float unused = ALMiscManager.prePitchValue = f;
                    float unused2 = ALMiscManager.preRollValue = f2;
                }
                Iterator it = ALMiscManager.this.mPitchRollAngleListeners.iterator();
                while (it.hasNext()) {
                    ((ALPitchRollAngleListener) it.next()).onPitchRollAngleChanged(f, f2);
                }
            }
        };
        this.mNetspeedCallback = new INetspeedCallback.Stub() { // from class: com.autolink.adaptermanager.misc.ALMiscManager.3
            AnonymousClass3() {
            }

            @Override // com.autolink.adapterinterface.misc.INetspeedCallback
            public void onNetspeedChanged(String str) throws RemoteException {
                Iterator it = ALMiscManager.this.mNetspeedListeners.iterator();
                while (it.hasNext()) {
                    ((NetspeedCallback) it.next()).onNetspeedChanged(str);
                }
            }
        };
        this.mCar = Car.createCar(this.mContext);
        this.mMiscCustomSettingCallbacks = new CopyOnWriteArrayList<>();
        this.mPitchRollAngleListeners = new CopyOnWriteArrayList<>();
        this.mNetspeedListeners = new CopyOnWriteArrayList<>();
    }

    public ALMiscManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.mLockForMiscService = new Object();
        this.mMiscCustomSettingCallbackImpl = new IMiscCustomSettingCallback.Stub() { // from class: com.autolink.adaptermanager.misc.ALMiscManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.misc.IMiscCustomSettingCallback
            public void onValueChanged(int i, String[] strArr) {
                Iterator it = ALMiscManager.this.mMiscCustomSettingCallbacks.iterator();
                while (it.hasNext()) {
                    MiscCustomSettingCallback miscCustomSettingCallback = (MiscCustomSettingCallback) it.next();
                    Log.i(ALMiscManager.TAG, "onValueChanged callback=" + miscCustomSettingCallback);
                    miscCustomSettingCallback.onValueChanged(i, strArr);
                }
            }
        };
        this.mPitchRollAngleCallback = new IPitchRollAngleCallback.Stub() { // from class: com.autolink.adaptermanager.misc.ALMiscManager.2
            AnonymousClass2() {
            }

            @Override // com.autolink.adapterinterface.misc.IPitchRollAngleCallback
            public void onPitchRollAngleChanged(float f, float f2) throws RemoteException {
                if (Math.abs(f - ALMiscManager.prePitchValue) > ALMiscManager.EPSILON || Math.abs(f2 - ALMiscManager.preRollValue) > ALMiscManager.EPSILON) {
                    Log.i(ALMiscManager.TAG, "onPitchRollAngleChanged pitch = " + f + " roll = " + f2);
                    float unused = ALMiscManager.prePitchValue = f;
                    float unused2 = ALMiscManager.preRollValue = f2;
                }
                Iterator it = ALMiscManager.this.mPitchRollAngleListeners.iterator();
                while (it.hasNext()) {
                    ((ALPitchRollAngleListener) it.next()).onPitchRollAngleChanged(f, f2);
                }
            }
        };
        this.mNetspeedCallback = new INetspeedCallback.Stub() { // from class: com.autolink.adaptermanager.misc.ALMiscManager.3
            AnonymousClass3() {
            }

            @Override // com.autolink.adapterinterface.misc.INetspeedCallback
            public void onNetspeedChanged(String str) throws RemoteException {
                Iterator it = ALMiscManager.this.mNetspeedListeners.iterator();
                while (it.hasNext()) {
                    ((NetspeedCallback) it.next()).onNetspeedChanged(str);
                }
            }
        };
        this.mCar = Car.createCar(this.mContext);
        this.mMiscCustomSettingCallbacks = new CopyOnWriteArrayList<>();
        this.mPitchRollAngleListeners = new CopyOnWriteArrayList<>();
        this.mNetspeedListeners = new CopyOnWriteArrayList<>();
    }

    private void setService(IALMisc iALMisc) {
        this.mService = iALMisc;
        if (iALMisc != null) {
            this.mConnectionState = STATE_CONNECTED;
        } else {
            this.mConnectionState = STATE_DISCONNECTED;
        }
    }

    @Deprecated
    public static ALMiscManager createMisc(Context context) {
        boolean z = false;
        ALMiscManager aLMiscManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(ALMISC_SERVICE_BINDER_SERVICE_NAME);
            if (aLMiscManager == null) {
                aLMiscManager = new ALMiscManager(context);
                aLMiscManager.setService(IALMisc.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createMisc before startMiscService first");
                    aLMiscManager.bindService();
                    return aLMiscManager;
                }
                Log.i(TAG, "createMisc end");
                return aLMiscManager;
            }
            if (!z) {
                Log.i(TAG, "createMisc before startMiscService second");
                aLMiscManager.bindService();
                z = true;
            }
            i++;
            if (i > MISC_SERVICE_BINDER_POLLING_MAX_RETRY) {
                Log.i(TAG, "retryCount > MISC_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(MISC_SERVICE_BINDER_POLLING_INTERVAL_MS);
            } catch (Exception e) {
                Log.e(TAG, "createMisc Exception: " + e);
                return null;
            }
        }
    }

    public static ALMiscManager createMisc(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        boolean z = false;
        ALMiscManager aLMiscManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(ALMISC_SERVICE_BINDER_SERVICE_NAME);
            if (aLMiscManager == null) {
                aLMiscManager = new ALMiscManager(context, serviceConnectionListenerNew);
                aLMiscManager.setService(IALMisc.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createMisc before startMiscService first");
                    aLMiscManager.bindService();
                    return aLMiscManager;
                }
                Log.i(TAG, "createMisc end");
                return aLMiscManager;
            }
            if (!z) {
                Log.i(TAG, "createMisc before startMiscService second");
                aLMiscManager.bindService();
                z = true;
            }
            i++;
            if (i > MISC_SERVICE_BINDER_POLLING_MAX_RETRY) {
                Log.i(TAG, "retryCount > MISC_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(MISC_SERVICE_BINDER_POLLING_INTERVAL_MS);
            } catch (Exception e) {
                Log.e(TAG, "createMisc Exception: " + e);
                return null;
            }
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent();
        intent.setPackage(ALMISC_SERVICE_PACKAGE);
        intent.setAction(ALMISC_SERVICE_INTERFACE_NAME);
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.mLockForMiscService) {
            IALMisc asInterface = IALMisc.Stub.asInterface(iBinder);
            if (asInterface == null) {
                return;
            }
            IALMisc iALMisc = this.mService;
            if (iALMisc != null && iALMisc.asBinder().equals(asInterface.asBinder())) {
                Log.i(TAG, "onServiceConnected mService " + this.mService);
                return;
            }
            this.mConnectionState = STATE_CONNECTED;
            this.mService = asInterface;
            registerCustomSettingCallback();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        Log.e(TAG, "onServiceDisconnected");
        synchronized (this.mLockForMiscService) {
            if (this.mConnectionState == STATE_DISCONNECTED) {
                return;
            }
            handleMiscDisconnectLocked();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        Log.e(TAG, "ALMiscManager->onBinderDied: ");
    }

    private void handleMiscDisconnectLocked() {
        Log.i(TAG, "handleMiscDisconnectLocked start");
        unbindService();
        this.mService = null;
        this.mConnectionState = STATE_DISCONNECTED;
    }

    public void registerMiscCustomSettingCallback(MiscCustomSettingCallback miscCustomSettingCallback) {
        Objects.requireNonNull(miscCustomSettingCallback);
        Log.i(TAG, "registerCarCustomSettingCallback callback=" + miscCustomSettingCallback);
        this.mMiscCustomSettingCallbacks.add(miscCustomSettingCallback);
    }

    public void unregisterMiscCustomSettingCallback(MiscCustomSettingCallback miscCustomSettingCallback) {
        Objects.requireNonNull(miscCustomSettingCallback);
        if (this.mMiscCustomSettingCallbacks.remove(miscCustomSettingCallback) && this.mMiscCustomSettingCallbacks.isEmpty()) {
            unregisterCustomSettingCallback();
        }
    }

    private void registerCustomSettingCallback() {
        try {
            this.mService.registerCustomSettingCallback(this.mMiscCustomSettingCallbackImpl.asBinder());
        } catch (RemoteException e) {
            Log.e(TAG, "registerCustomSettingCallback failed", e);
        }
    }

    private void unregisterCustomSettingCallback() {
        try {
            this.mService.unregisterCustomSettingCallback(this.mMiscCustomSettingCallbackImpl.asBinder());
        } catch (RemoteException e) {
            Log.e(TAG, "unregisterCustomSettingCallback failed", e);
        }
    }

    public void registerPitchRollAngleCallback(ALPitchRollAngleListener aLPitchRollAngleListener) {
        if (this.mPitchRollAngleListeners.isEmpty()) {
            if (this.mService == null) {
                try {
                    Thread.sleep(200L);
                } catch (Exception e) {
                    Log.i(TAG, "sleep Exception: " + e);
                }
            }
            try {
                this.mService.registerPitchRollAngleCallback(this.mPitchRollAngleCallback);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        if (this.mPitchRollAngleListeners.contains(aLPitchRollAngleListener)) {
            return;
        }
        this.mPitchRollAngleListeners.add(aLPitchRollAngleListener);
    }

    public void unregisterPitchRollAngleCallback(ALPitchRollAngleListener aLPitchRollAngleListener) {
        if (this.mPitchRollAngleListeners.contains(aLPitchRollAngleListener)) {
            this.mPitchRollAngleListeners.remove(aLPitchRollAngleListener);
            if (this.mPitchRollAngleListeners.isEmpty()) {
                IALMisc iALMisc = this.mService;
                if (iALMisc == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iALMisc.unregisterPitchRollAngleCallback(this.mPitchRollAngleCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerNetspeedCallback(NetspeedCallback netspeedCallback) {
        IALMisc iALMisc;
        Log.i(TAG, "registerNetspeedCallback " + Debug.getCallers(10));
        Objects.requireNonNull(netspeedCallback);
        if (this.mNetspeedListeners.isEmpty() && (iALMisc = this.mService) != null) {
            try {
                iALMisc.registerNetspeedCallback(this.mNetspeedCallback);
            } catch (RemoteException e) {
                Log.e(TAG, "registerNetspeedCallback failed", e);
            }
        }
        this.mNetspeedListeners.add(netspeedCallback);
    }

    public void unregisterNetspeedCallback(NetspeedCallback netspeedCallback) {
        IALMisc iALMisc;
        Objects.requireNonNull(netspeedCallback);
        if (this.mNetspeedListeners.remove(netspeedCallback) && this.mNetspeedListeners.isEmpty() && (iALMisc = this.mService) != null) {
            try {
                iALMisc.unregisterNetspeedCallback(this.mNetspeedCallback);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterNetspeedCallback failed", e);
            }
        }
    }

    public String getDeviceID() {
        Log.i(TAG, "getDeviceID");
        if (getSN() == null || "".equals(getSN())) {
            String serialNo = getSerialNo();
            if (serialNo != null) {
                return UUID.nameUUIDFromBytes(serialNo.getBytes()).toString().replaceAll("-", "");
            }
            Log.e(TAG, "Both SN and serialNo are null");
            return "";
        }
        return getSN();
    }

    public String getVIN() {
        String[] strArr;
        try {
            strArr = this.mService.getCustomSetting(0, new String[]{""});
        } catch (RemoteException e) {
            Log.e(TAG, "getVIN failed", e);
            strArr = null;
        }
        Log.i(TAG, "getVIN vin=" + strArr[0]);
        return strArr[0];
    }

    public String getVehicleModel() {
        String[] strArr;
        try {
            strArr = this.mService.getCustomSetting(1, new String[]{""});
        } catch (RemoteException e) {
            Log.e(TAG, "getVIN failed", e);
            strArr = null;
        }
        String vehicleModoeName = getVehicleModoeName(strArr[0]);
        Log.i(TAG, "getVehicleModel vehicleMode" + vehicleModoeName);
        return vehicleModoeName;
    }

    private String getVehicleModoeName(String str) {
        if (str == null) {
            return "invalid";
        }
        if (str.equals("0")) {
            return VEHICLE_MODES[0];
        }
        if (str.equals("1")) {
            return VEHICLE_MODES[1];
        }
        if (str.equals("2")) {
            return VEHICLE_MODES[2];
        }
        if (str.equals("3")) {
            return VEHICLE_MODES[3];
        }
        if (str.equals("4")) {
            return VEHICLE_MODES[4];
        }
        return str.equals("5") ? VEHICLE_MODES[5] : "invalid";
    }

    public float getDataTotal() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        return ((float) Math.round(((((((double) statFs.getBlockCount()) * ((double) statFs.getBlockSize())) / 1024.0d) / 1024.0d) / 1024.0d) * 10.0d)) / 10.0f > 40.0f ? 256.0f : 128.0f;
    }

    public float getDataAvail() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        return Math.round(((((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024.0d) / 1024.0d) / 1024.0d) * 10.0d) / 10.0f;
    }

    public String getSN() {
        int i = 0;
        while (this.mService == null) {
            try {
                Thread.sleep(200L);
            } catch (Exception e) {
                Log.i(TAG, "sleep Exception: " + e);
            }
            i++;
            if (i > 5) {
                Log.e(TAG, "IALMisc  is not connect");
                return null;
            }
        }
        return getSNInternal();
    }

    public String getSerialNo() {
        int i = 0;
        while (this.mService == null) {
            try {
                Thread.sleep(200L);
            } catch (Exception e) {
                Log.i(TAG, "sleep Exception: " + e);
            }
            i++;
            if (i > 5) {
                Log.e(TAG, "IALMisc  is not connect");
                return null;
            }
        }
        return getSerialNoInternal();
    }

    private String getSNInternal() {
        String[] strArr;
        try {
            strArr = this.mService.getCustomSetting(2, new String[]{""});
        } catch (RemoteException e) {
            Log.e(TAG, "getSNInternal failed", e);
            strArr = null;
        }
        Log.i(TAG, "getSNInternal sn=" + strArr[0]);
        return strArr[0];
    }

    private String getSerialNoInternal() {
        String[] strArr;
        try {
            strArr = this.mService.getCustomSetting(3, new String[]{""});
        } catch (RemoteException e) {
            Log.e(TAG, "getSerialNoInternal failed", e);
            strArr = null;
        }
        Log.i(TAG, "getSerialNoInternal SerialNo=" + strArr[0]);
        return strArr[0];
    }
}
