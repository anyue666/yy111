package com.autolink.adaptermanager.tbox2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.remote.IRemote;
import com.autolink.adapterinterface.tbox2.remote.IRemoteCallback;
import com.autolink.adapterinterface.tbox2.remote.TboxEcuVersion;
import com.autolink.adapterinterface.tbox2.remote.UploadLogInfo;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class TboxRemoteManager extends TboxManagerBase {
    private final HandlerThread mHandlerThread;
    IRemoteCallback mIRemoteCallback;
    private final Object mLock;
    private RemoteListener mRemoteListener;
    private final RemoteManagerHandler mRemoteManagerHandler;
    private IRemote mService;

    public interface RemoteListener {
        void ecuVersion(List<TboxEcuVersion> list);

        void lightShowCtrlReq(byte b);

        void uploadLogReq(UploadLogInfo uploadLogInfo);

        void uploadLogReq(String str, long j);
    }

    public TboxRemoteManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        this.mLock = new Object();
        HandlerThread handlerThread = TboxManagerUtils.getHandlerThread("TboxRemoteManager");
        this.mHandlerThread = handlerThread;
        this.mRemoteManagerHandler = new RemoteManagerHandler(handlerThread.getLooper(), this);
        this.mIRemoteCallback = new IRemoteCallback.Stub() { // from class: com.autolink.adaptermanager.tbox2.TboxRemoteManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
            public void lightShowCtrlReq(byte b) {
                TboxRemoteManager.this.mRemoteManagerHandler.sendMessage(Message.obtain(TboxRemoteManager.this.mRemoteManagerHandler, 0, b, 0));
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
            public void ecuVersion(List<TboxEcuVersion> list) {
                TboxRemoteManager.this.mRemoteManagerHandler.sendMessage(Message.obtain(TboxRemoteManager.this.mRemoteManagerHandler, 1, list));
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
            public void uploadLogReq(UploadLogInfo uploadLogInfo) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = uploadLogInfo;
                TboxRemoteManager.this.mRemoteManagerHandler.sendMessage(obtain);
            }
        };
        this.mService = IRemote.Stub.asInterface(iBinder);
    }

    /* renamed from: com.autolink.adaptermanager.tbox2.TboxRemoteManager$1 */
    class AnonymousClass1 extends IRemoteCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
        public void lightShowCtrlReq(byte b) {
            TboxRemoteManager.this.mRemoteManagerHandler.sendMessage(Message.obtain(TboxRemoteManager.this.mRemoteManagerHandler, 0, b, 0));
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
        public void ecuVersion(List<TboxEcuVersion> list) {
            TboxRemoteManager.this.mRemoteManagerHandler.sendMessage(Message.obtain(TboxRemoteManager.this.mRemoteManagerHandler, 1, list));
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
        public void uploadLogReq(UploadLogInfo uploadLogInfo) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = uploadLogInfo;
            TboxRemoteManager.this.mRemoteManagerHandler.sendMessage(obtain);
        }
    }

    private static final class RemoteManagerHandler extends Handler {
        private static final int MSG_ECU_VERSION = 1;
        private static final int MSG_LIGHTSHOW_CTRL_REQ = 0;
        private static final int MSG_UPLOAD_LOG_REQ = 2;
        private final WeakReference<TboxRemoteManager> mManager;

        /* synthetic */ RemoteManagerHandler(Looper looper, TboxRemoteManager tboxRemoteManager, AnonymousClass1 anonymousClass1) {
            this(looper, tboxRemoteManager);
        }

        private RemoteManagerHandler(Looper looper, TboxRemoteManager tboxRemoteManager) {
            super(looper);
            Log.i("TboxManager", "USBManagerHandler start");
            this.mManager = new WeakReference<>(tboxRemoteManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TboxRemoteManager tboxRemoteManager = this.mManager.get();
            if (tboxRemoteManager == null) {
                Log.e("TboxManager", "handleMessage manager is null");
                return;
            }
            int i = message.what;
            if (i == 0) {
                tboxRemoteManager.notifyLightShowCtrlReq((byte) message.arg1);
            } else if (i == 1) {
                tboxRemoteManager.notifyEcuVersion((List) message.obj);
            } else {
                if (i != 2) {
                    return;
                }
                tboxRemoteManager.notifyUploadLogReq((UploadLogInfo) message.obj);
            }
        }
    }

    public void lightShowCtrlResp(byte b, byte b2) {
        Log.i("TboxManager", "lightShowCtrlResp in manager start >>> res = " + ((int) b) + " err_code = " + ((int) b2));
        try {
            this.mService.lightShowCtrlResp(b, b2);
        } catch (RemoteException e) {
            Log.e("TboxManager", "lightShowCtrlResp RemoteException " + e);
        }
    }

    public void getEcuVersion(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            Log.i("TboxManager", "getEcuVersion in manager start >>> ecuIds[" + i + "] = " + iArr[i]);
        }
        try {
            this.mService.getEcuVersion(iArr);
        } catch (RemoteException e) {
            Log.e("TboxManager", "getEcuVersion RemoteException " + e);
        }
    }

    public void uploadResult(long j) {
        Log.i("TboxManager", "uploadResult in manager start >>> msgId = " + j);
        try {
            this.mService.uploadResult(j);
        } catch (RemoteException e) {
            Log.e("TboxManager", "uploadResult RemoteException " + e);
        }
    }

    public void setListener(RemoteListener remoteListener) {
        Log.i("TboxManager", "setListener in TboxRemoteManager start ");
        synchronized (this.mLock) {
            if (this.mRemoteListener == null) {
                registerCallback(this.mIRemoteCallback);
            }
            this.mRemoteListener = remoteListener;
        }
    }

    public void removeListener() {
        Log.i("TboxManager", "removeListener in TboxRemoteManager start ");
        synchronized (this.mLock) {
            this.mRemoteListener = null;
            unregisterCallback(this.mIRemoteCallback);
        }
    }

    private void registerCallback(IRemoteCallback iRemoteCallback) {
        Log.i("TboxManager", "registerCallback in TboxRemoteManager start");
        try {
            this.mService.registerCallback(iRemoteCallback);
        } catch (RemoteException e) {
            Log.e("TboxManager", "registerCallback RemoteException " + e);
        }
    }

    private void unregisterCallback(IRemoteCallback iRemoteCallback) {
        Log.i("TboxManager", "unregisterCallback in TboxRemoteManager start");
        try {
            IRemote iRemote = this.mService;
            if (iRemote != null) {
                iRemote.unregisterCallback(iRemoteCallback);
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "unregisterCallback RemoteException " + e);
        }
    }

    public void notifyLightShowCtrlReq(byte b) {
        RemoteListener remoteListener;
        synchronized (this.mLock) {
            remoteListener = this.mRemoteListener;
        }
        remoteListener.lightShowCtrlReq(b);
    }

    public void notifyEcuVersion(List<TboxEcuVersion> list) {
        RemoteListener remoteListener;
        synchronized (this.mLock) {
            remoteListener = this.mRemoteListener;
        }
        remoteListener.ecuVersion(list);
    }

    public void notifyUploadLogReq(UploadLogInfo uploadLogInfo) {
        RemoteListener remoteListener;
        synchronized (this.mLock) {
            remoteListener = this.mRemoteListener;
        }
        remoteListener.uploadLogReq(uploadLogInfo);
    }

    @Override // com.autolink.adaptermanager.tbox2.TboxManagerBase
    protected void clearDeadBinder() {
        if (this.mService != null) {
            Log.d("TboxManager", "TboxRemoteManager clearDeadBinder");
            this.mService = null;
        }
    }
}
