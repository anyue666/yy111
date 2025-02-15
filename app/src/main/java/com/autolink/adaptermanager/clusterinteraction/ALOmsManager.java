package com.autolink.adaptermanager.clusterinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.clusterinteraction.IClusterInteraction;
import com.autolink.adapterinterface.clusterinteraction.IOmsCallback;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ALOmsManager extends ALBaseManager implements IALManager {
    private static final String TAG = "ALOmsManager";
    private HandlerThread handlerThread;
    private IOmsCallback mCallback;
    private ALOmsDataListener mListener;
    private ManagerHandler mManagerHandler;
    private IClusterInteraction mService;

    public interface ALOmsDataListener {
        void cameraStatusResp(OmsStatus omsStatus, FunctionRoler functionRoler);

        void isHaveChildResp(boolean z, int i);

        void isHavePetResp(boolean z, int i);

        void isSafetySeatResp(boolean z, int i);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    public enum OmsFunctionStatus {
        STATUS_ON(1),
        STATUS_OFF(2);

        private final int value;

        OmsFunctionStatus(int i) {
            this.value = i;
        }

        public static OmsFunctionStatus forNumber(int i) {
            if (i == 1) {
                return STATUS_ON;
            }
            if (i != 2) {
                return null;
            }
            return STATUS_OFF;
        }

        public final int getNumber() {
            return this.value;
        }
    }

    public enum OmsStatus {
        OMS_STATUS_DEFAULT(1),
        OMS_SDK_INIT_SUCCESS(2),
        OMS_SDK_INIT_ERROR(3),
        OMS_CAMERA_OK(4),
        OMS_CAMERA_ERROR(5),
        ACTIVATION_CODE_NOT_EXIST(6);

        private final int value;

        OmsStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static OmsStatus forNumber(int i) {
            switch (i) {
                case 1:
                    return OMS_STATUS_DEFAULT;
                case 2:
                    return OMS_SDK_INIT_SUCCESS;
                case 3:
                    return OMS_SDK_INIT_ERROR;
                case 4:
                    return OMS_CAMERA_OK;
                case 5:
                    return OMS_CAMERA_ERROR;
                case 6:
                    return ACTIVATION_CODE_NOT_EXIST;
                default:
                    return null;
            }
        }
    }

    public enum FunctionRoler {
        QNX_ROLER(1),
        ANDROID_ACCOUNT_ROLER(2),
        ANDROID_HEATLTH_ROLER(3),
        ANDROID_DRIVER_ROLER(4),
        ANDROID_OMS_ROLER(5),
        ROLER_ALL(6);

        private final int value;

        FunctionRoler(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static FunctionRoler forNumber(int i) {
            switch (i) {
                case 1:
                    return QNX_ROLER;
                case 2:
                    return ANDROID_ACCOUNT_ROLER;
                case 3:
                    return ANDROID_HEATLTH_ROLER;
                case 4:
                    return ANDROID_DRIVER_ROLER;
                case 5:
                    return ANDROID_OMS_ROLER;
                case 6:
                    return ROLER_ALL;
                default:
                    return null;
            }
        }
    }

    @Deprecated
    public ALOmsManager(Context context) {
        super(context);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mCallback = new IOmsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALOmsManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHavePetResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isHavePetResp isValid=" + z + " numberOfPet=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 1, z ? 1 : 0, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHaveChildResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isHaveChildResp isValid=" + z + " numberOfChild=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 2, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isSafetySeatResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isSafetySeatResp isValid=" + z + " numberOfSafetySeat=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 3, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Log.i(ALOmsManager.TAG, "cameraStatusResp status= " + i + " roler= " + i2);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 4, i, i2));
            }
        };
        bindService();
    }

    @Deprecated
    public ALOmsManager(Context context, IALManager.ServiceConnectionListener serviceConnectionListener) {
        super(context, serviceConnectionListener);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mCallback = new IOmsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALOmsManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHavePetResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isHavePetResp isValid=" + z + " numberOfPet=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 1, z ? 1 : 0, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHaveChildResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isHaveChildResp isValid=" + z + " numberOfChild=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 2, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isSafetySeatResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isSafetySeatResp isValid=" + z + " numberOfSafetySeat=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 3, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Log.i(ALOmsManager.TAG, "cameraStatusResp status= " + i + " roler= " + i2);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 4, i, i2));
            }
        };
        bindService();
    }

    public ALOmsManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mCallback = new IOmsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALOmsManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHavePetResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isHavePetResp isValid=" + z + " numberOfPet=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 1, z ? 1 : 0, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHaveChildResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isHaveChildResp isValid=" + z + " numberOfChild=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 2, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isSafetySeatResp(boolean z, int i) throws RemoteException {
                Log.i(ALOmsManager.TAG, "isSafetySeatResp isValid=" + z + " numberOfSafetySeat=" + i);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 3, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Log.i(ALOmsManager.TAG, "cameraStatusResp status= " + i + " roler= " + i2);
                ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 4, i, i2));
            }
        };
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent("com.autolink.clusterinteraction.CiService");
        intent.setPackage("com.autolink.clusterinteraction");
        intent.setClassName("com.autolink.clusterinteraction", "com.autolink.clusterinteraction.CiService");
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        IClusterInteraction asInterface = IClusterInteraction.Stub.asInterface(iBinder);
        this.mService = asInterface;
        try {
            asInterface.registerOmsCallback(this.mCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        this.mService = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        this.mService = null;
    }

    public void registerListener(ALOmsDataListener aLOmsDataListener) {
        this.mListener = aLOmsDataListener;
    }

    public void unregisterCallback(ALOmsDataListener aLOmsDataListener) {
        this.mListener = null;
    }

    public void omsMonitoringReq(OmsFunctionStatus omsFunctionStatus) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.omsMonitoringReq(omsFunctionStatus.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private static final class ManagerHandler extends Handler {
        private static final int MSG_CAMERA_STATUS_RESP = 4;
        private static final int MSG_IS_HAVE_CHILD_RESP = 2;
        private static final int MSG_IS_HAVE_PET_RESP = 1;
        private static final int MSG_IS_SAFETY_SEAT_RESP = 3;
        private final WeakReference<ALOmsManager> mManager;

        public ManagerHandler(Looper looper, ALOmsManager aLOmsManager) {
            super(looper);
            this.mManager = new WeakReference<>(aLOmsManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ALOmsManager aLOmsManager = this.mManager.get();
            if (aLOmsManager == null) {
                Log.e(ALOmsManager.TAG, "handleMessage in ALOmsManager is null");
                return;
            }
            int i = message.what;
            if (i == 1) {
                aLOmsManager.notifyIsHavePetResp(message.arg1 == 1, message.arg2);
                return;
            }
            if (i == 2) {
                aLOmsManager.notifyIsHaveChildResp(message.arg1 == 1, message.arg2);
            } else if (i == 3) {
                aLOmsManager.notifyIsSafetySeatResp(message.arg1 == 1, message.arg2);
            } else {
                if (i != 4) {
                    return;
                }
                aLOmsManager.notifyCameraStatusResp(message.arg1, message.arg2);
            }
        }
    }

    public void notifyIsHavePetResp(boolean z, int i) {
        ALOmsDataListener aLOmsDataListener = this.mListener;
        if (aLOmsDataListener != null) {
            aLOmsDataListener.isHavePetResp(z, i);
        }
    }

    public void notifyIsHaveChildResp(boolean z, int i) {
        ALOmsDataListener aLOmsDataListener = this.mListener;
        if (aLOmsDataListener != null) {
            aLOmsDataListener.isHaveChildResp(z, i);
        }
    }

    public void notifyIsSafetySeatResp(boolean z, int i) {
        ALOmsDataListener aLOmsDataListener = this.mListener;
        if (aLOmsDataListener != null) {
            aLOmsDataListener.isSafetySeatResp(z, i);
        }
    }

    public void notifyCameraStatusResp(int i, int i2) {
        ALOmsDataListener aLOmsDataListener = this.mListener;
        if (aLOmsDataListener != null) {
            aLOmsDataListener.cameraStatusResp(OmsStatus.forNumber(i), FunctionRoler.forNumber(i2));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALOmsManager$1 */
    class AnonymousClass1 extends IOmsCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void isHavePetResp(boolean z, int i) throws RemoteException {
            Log.i(ALOmsManager.TAG, "isHavePetResp isValid=" + z + " numberOfPet=" + i);
            ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 1, z ? 1 : 0, i));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void isHaveChildResp(boolean z, int i) throws RemoteException {
            Log.i(ALOmsManager.TAG, "isHaveChildResp isValid=" + z + " numberOfChild=" + i);
            ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 2, !z ? 0 : 1, i));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void isSafetySeatResp(boolean z, int i) throws RemoteException {
            Log.i(ALOmsManager.TAG, "isSafetySeatResp isValid=" + z + " numberOfSafetySeat=" + i);
            ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 3, !z ? 0 : 1, i));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void cameraStatusResp(int i, int i2) throws RemoteException {
            Log.i(ALOmsManager.TAG, "cameraStatusResp status= " + i + " roler= " + i2);
            ALOmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALOmsManager.this.mManagerHandler, 4, i, i2));
        }
    }
}
