package com.autolink.adaptermanager.tbox2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.ota.IOTA;
import com.autolink.adapterinterface.tbox2.ota.IOTACallback;
import com.autolink.adapterinterface.tbox2.ota.TboxFotaUserComfirm;
import com.autolink.adapterinterface.tbox2.ota.TboxOtaSubNodeState;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxFotaStateDisplayInfo;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxFotaUserComfirmInfo;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxOtaSubNodeInfo;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxOtaSubNodeRefreshNowInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TboxOTAManager extends TboxManagerBase {
    private static final boolean DBG = true;
    private final HandlerThread mHandlerThread;
    IOTACallback mIOTACallback;
    private final Object mLock;
    private OTAListener mOTAListener;
    private final OTAManagerHandler mOTAManagerHandler;
    private IOTA mService;

    public interface OTAListener {
        void onCancelFotaReq();

        void onFotaStateDisplayReq(TboxFotaStateDisplayInfo tboxFotaStateDisplayInfo);

        void onFotaUserComfirmReq(TboxFotaUserComfirmInfo tboxFotaUserComfirmInfo);

        void onOtaSubNodeRefreshNowReq(TboxOtaSubNodeRefreshNowInfo tboxOtaSubNodeRefreshNowInfo);

        void onOtaSubNodeReq(TboxOtaSubNodeInfo tboxOtaSubNodeInfo);
    }

    /* renamed from: com.autolink.adaptermanager.tbox2.TboxOTAManager$1 */
    class AnonymousClass1 extends IOTACallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onOtaSubNodeReq(TboxOtaSubNodeInfo tboxOtaSubNodeInfo) {
            TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 1, tboxOtaSubNodeInfo));
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onFotaUserComfirmReq(TboxFotaUserComfirmInfo tboxFotaUserComfirmInfo) {
            TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 2, tboxFotaUserComfirmInfo));
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onOtaSubNodeRefreshNowReq(TboxOtaSubNodeRefreshNowInfo tboxOtaSubNodeRefreshNowInfo) {
            TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 3, tboxOtaSubNodeRefreshNowInfo));
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onFotaStateDisplayReq(TboxFotaStateDisplayInfo tboxFotaStateDisplayInfo) {
            TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 4, tboxFotaStateDisplayInfo));
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onCancelFotaReq() {
            TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 5));
        }
    }

    private static final class OTAManagerHandler extends Handler {
        private static final int MSG_CANCEL_FOTA_REQ = 5;
        private static final int MSG_STATE_DISPLAY_REQ = 4;
        private static final int MSG_SUB_NODE_REFRESH_NOW_REQ = 3;
        private static final int MSG_SUB_NODE_REQ = 1;
        private static final int MSG_USER_CONFIRM_REQ = 2;
        private final WeakReference<TboxOTAManager> mManager;

        /* synthetic */ OTAManagerHandler(Looper looper, TboxOTAManager tboxOTAManager, AnonymousClass1 anonymousClass1) {
            this(looper, tboxOTAManager);
        }

        private OTAManagerHandler(Looper looper, TboxOTAManager tboxOTAManager) {
            super(looper);
            Log.i("TboxManager", "ManagerHandler start");
            this.mManager = new WeakReference<>(tboxOTAManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TboxOTAManager tboxOTAManager = this.mManager.get();
            if (tboxOTAManager == null) {
                Log.e("TboxManager", "handleMessage manager is null");
                return;
            }
            int i = message.what;
            if (i == 1) {
                tboxOTAManager.notifyListenerOtaSubNodeReq((TboxOtaSubNodeInfo) message.obj);
                return;
            }
            if (i == 2) {
                tboxOTAManager.notifyListenerFotaUserComfirmReq((TboxFotaUserComfirmInfo) message.obj);
                return;
            }
            if (i == 3) {
                tboxOTAManager.notifyListenerOtaSubNodeRefreshNowReq((TboxOtaSubNodeRefreshNowInfo) message.obj);
            } else if (i == 4) {
                tboxOTAManager.notifyListenerFotaStateDisplayReq((TboxFotaStateDisplayInfo) message.obj);
            } else {
                if (i != 5) {
                    return;
                }
                tboxOTAManager.notifyListenerCancelFotaReq();
            }
        }
    }

    public TboxOTAManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        this.mLock = new Object();
        HandlerThread handlerThread = TboxManagerUtils.getHandlerThread("TboxOTAManager");
        this.mHandlerThread = handlerThread;
        this.mOTAManagerHandler = new OTAManagerHandler(handlerThread.getLooper(), this);
        this.mIOTACallback = new IOTACallback.Stub() { // from class: com.autolink.adaptermanager.tbox2.TboxOTAManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onOtaSubNodeReq(TboxOtaSubNodeInfo tboxOtaSubNodeInfo) {
                TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 1, tboxOtaSubNodeInfo));
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onFotaUserComfirmReq(TboxFotaUserComfirmInfo tboxFotaUserComfirmInfo) {
                TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 2, tboxFotaUserComfirmInfo));
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onOtaSubNodeRefreshNowReq(TboxOtaSubNodeRefreshNowInfo tboxOtaSubNodeRefreshNowInfo) {
                TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 3, tboxOtaSubNodeRefreshNowInfo));
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onFotaStateDisplayReq(TboxFotaStateDisplayInfo tboxFotaStateDisplayInfo) {
                TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 4, tboxFotaStateDisplayInfo));
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onCancelFotaReq() {
                TboxOTAManager.this.mOTAManagerHandler.sendMessage(Message.obtain(TboxOTAManager.this.mOTAManagerHandler, 5));
            }
        };
        this.mService = IOTA.Stub.asInterface(iBinder);
    }

    public void setListener(OTAListener oTAListener) {
        Log.i("TboxManager", "setListener in TboxOTAManager start ");
        synchronized (this.mLock) {
            if (this.mOTAListener == null) {
                registerCallback(this.mIOTACallback);
            }
            this.mOTAListener = oTAListener;
        }
    }

    public void removeListener() {
        synchronized (this.mLock) {
            this.mOTAListener = null;
            unregisterCallback(this.mIOTACallback);
        }
    }

    public void notifyListenerOtaSubNodeReq(TboxOtaSubNodeInfo tboxOtaSubNodeInfo) {
        OTAListener oTAListener;
        synchronized (this.mLock) {
            oTAListener = this.mOTAListener;
        }
        oTAListener.onOtaSubNodeReq(tboxOtaSubNodeInfo);
    }

    public void notifyListenerFotaUserComfirmReq(TboxFotaUserComfirmInfo tboxFotaUserComfirmInfo) {
        OTAListener oTAListener;
        synchronized (this.mLock) {
            oTAListener = this.mOTAListener;
        }
        oTAListener.onFotaUserComfirmReq(tboxFotaUserComfirmInfo);
    }

    public void notifyListenerOtaSubNodeRefreshNowReq(TboxOtaSubNodeRefreshNowInfo tboxOtaSubNodeRefreshNowInfo) {
        OTAListener oTAListener;
        synchronized (this.mLock) {
            oTAListener = this.mOTAListener;
        }
        oTAListener.onOtaSubNodeRefreshNowReq(tboxOtaSubNodeRefreshNowInfo);
    }

    public void notifyListenerFotaStateDisplayReq(TboxFotaStateDisplayInfo tboxFotaStateDisplayInfo) {
        OTAListener oTAListener;
        synchronized (this.mLock) {
            oTAListener = this.mOTAListener;
        }
        oTAListener.onFotaStateDisplayReq(tboxFotaStateDisplayInfo);
    }

    public void notifyListenerCancelFotaReq() {
        OTAListener oTAListener;
        synchronized (this.mLock) {
            oTAListener = this.mOTAListener;
        }
        oTAListener.onCancelFotaReq();
    }

    public void otaSubNodeStateReport(TboxOtaSubNodeState tboxOtaSubNodeState) {
        Log.i("TboxManager", "otaSubNodeStateReport in manager " + tboxOtaSubNodeState.toString());
        try {
            this.mService.otaSubNodeStateReport(tboxOtaSubNodeState);
        } catch (RemoteException e) {
            Log.e("TboxManager", "otaSubNodeStateReport RemoteException " + e);
        }
    }

    public void fotaUserComfirmResponse(TboxFotaUserComfirm tboxFotaUserComfirm) {
        Log.i("TboxManager", "fotaUserComfirmResponse in manager " + tboxFotaUserComfirm.toString());
        try {
            this.mService.fotaUserComfirmResponse(tboxFotaUserComfirm);
        } catch (RemoteException e) {
            Log.e("TboxManager", "fotaUserComfirmResponse RemoteException " + e);
        }
    }

    public void otaSubNodeRefreshNowResponse(long j, String str) {
        Log.i("TboxManager", "otaSubNodeRefreshNowResponse in manager taskId " + j + " sessionId " + str);
        try {
            this.mService.otaSubNodeRefreshNowResponse(j, str);
        } catch (RemoteException e) {
            Log.e("TboxManager", "otaSubNodeRefreshNowResponse RemoteException " + e);
        }
    }

    public void cancelFotaAck(byte b) {
        Log.i("TboxManager", "cancelFotaAck in manager ack " + ((int) b));
        IOTA iota = this.mService;
        if (iota == null) {
            Log.e("TboxManager", "mService is null,return");
            return;
        }
        try {
            iota.cancelFotaAck(b);
        } catch (RemoteException e) {
            Log.e("TboxManager", "otaSubNodeRefreshNowResponse RemoteException " + e);
        }
    }

    private void registerCallback(IOTACallback iOTACallback) {
        Log.i("TboxManager", "registerCallback in TboxOTAManager start");
        try {
            this.mService.registerCallback(iOTACallback);
        } catch (RemoteException e) {
            Log.e("TboxManager", "registerCallback RemoteException " + e);
        }
    }

    private void unregisterCallback(IOTACallback iOTACallback) {
        Log.i("TboxManager", "unregisterCallback in TboxOTAManager start");
        try {
            IOTA iota = this.mService;
            if (iota != null) {
                iota.unregisterCallback(iOTACallback);
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "unregisterCallback RemoteException " + e);
        }
    }

    @Override // com.autolink.adaptermanager.tbox2.TboxManagerBase
    protected void clearDeadBinder() {
        if (this.mService != null) {
            Log.d("TboxManager", "TboxOTAManager clearDeadBinder");
            this.mService = null;
        }
    }
}
