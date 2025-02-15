package com.autolink.adaptermanager.tbox2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.callcommand.ICallCommand;
import com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback;
import com.autolink.adapterinterface.tbox2.callcommand.TboxCallInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TboxCallCommandManager extends TboxManagerBase {
    private static final boolean DBG = true;
    private CallCommandListener mCallCommandListener;
    private CallCommandV18Listener mCallCommandV18Listener;
    private final HandlerThread mHandlerThread;
    ICallCommandCallback mICallCommandCallback;
    private INTMuteNotifyListener mINTMuteNotifyListener;
    private final Object mLock;
    private final ManagerHandler mManagerHandler;
    private ICallCommand mService;

    public interface CallCommandListener {
        void onCallCommandResponse(byte b, byte b2);
    }

    public interface CallCommandV18Listener {
        void onCallCommandResponse(byte b, byte b2, byte b3);
    }

    public interface INTMuteNotifyListener {
        void onINTMuteNotify(boolean z);
    }

    /* renamed from: com.autolink.adaptermanager.tbox2.TboxCallCommandManager$1 */
    class AnonymousClass1 extends ICallCommandCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
        public void onCallCommandResponse(TboxCallInfo tboxCallInfo) {
            TboxCallCommandManager.this.mManagerHandler.sendMessage(Message.obtain(TboxCallCommandManager.this.mManagerHandler, 1, tboxCallInfo));
        }

        @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
        public void onMuteNotify(boolean z) {
            TboxCallCommandManager.this.mManagerHandler.sendMessage(Message.obtain(TboxCallCommandManager.this.mManagerHandler, 2, z ? 1 : 0, 0));
        }
    }

    private static final class ManagerHandler extends Handler {
        private static final int MSG_CALL_COMMAND_RESPONSE = 1;
        private static final int MSG_INT_MUTE_NOTIFY = 2;
        private final WeakReference<TboxCallCommandManager> mManager;

        /* synthetic */ ManagerHandler(Looper looper, TboxCallCommandManager tboxCallCommandManager, AnonymousClass1 anonymousClass1) {
            this(looper, tboxCallCommandManager);
        }

        private ManagerHandler(Looper looper, TboxCallCommandManager tboxCallCommandManager) {
            super(looper);
            Log.i("TboxManager", "ManagerHandler start");
            this.mManager = new WeakReference<>(tboxCallCommandManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            boolean z = TboxCallCommandManager.DBG;
            if (i == 1) {
                TboxCallCommandManager tboxCallCommandManager = this.mManager.get();
                if (tboxCallCommandManager != null) {
                    tboxCallCommandManager.notifyListenerCallCommandResponse((TboxCallInfo) message.obj);
                    return;
                } else {
                    Log.e("TboxManager", "handleMessage manager is null");
                    return;
                }
            }
            if (i != 2) {
                return;
            }
            TboxCallCommandManager tboxCallCommandManager2 = this.mManager.get();
            if (tboxCallCommandManager2 == null) {
                Log.e("TboxManager", "handleMessage callCommandManager is null");
                return;
            }
            if (message.arg1 != 1) {
                z = false;
            }
            tboxCallCommandManager2.notifyListenerINTMute(z);
        }
    }

    public TboxCallCommandManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        HandlerThread handlerThread = TboxManagerUtils.getHandlerThread("TboxCallCommandManager");
        this.mHandlerThread = handlerThread;
        this.mManagerHandler = new ManagerHandler(handlerThread.getLooper(), this);
        this.mLock = new Object();
        this.mICallCommandCallback = new ICallCommandCallback.Stub() { // from class: com.autolink.adaptermanager.tbox2.TboxCallCommandManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
            public void onCallCommandResponse(TboxCallInfo tboxCallInfo) {
                TboxCallCommandManager.this.mManagerHandler.sendMessage(Message.obtain(TboxCallCommandManager.this.mManagerHandler, 1, tboxCallInfo));
            }

            @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
            public void onMuteNotify(boolean z) {
                TboxCallCommandManager.this.mManagerHandler.sendMessage(Message.obtain(TboxCallCommandManager.this.mManagerHandler, 2, z ? 1 : 0, 0));
            }
        };
        this.mService = ICallCommand.Stub.asInterface(iBinder);
    }

    public void setListener(CallCommandListener callCommandListener) {
        Log.i("TboxManager", "setListener in TboxCallCommandManager start ");
        synchronized (this.mLock) {
            if (this.mCallCommandListener == null) {
                registerCallback(this.mICallCommandCallback);
            }
            this.mCallCommandListener = callCommandListener;
        }
    }

    public void setListener(CallCommandV18Listener callCommandV18Listener) {
        Log.i("TboxManager", "setListener v1.8 in TboxCallCommandManager start ");
        synchronized (this.mLock) {
            if (this.mCallCommandV18Listener == null) {
                registerCallback(this.mICallCommandCallback);
            }
            this.mCallCommandV18Listener = callCommandV18Listener;
        }
    }

    public void removeListener() {
        Log.i("TboxManager", "removeListener in TboxCallCommandManager start ");
        synchronized (this.mLock) {
            this.mCallCommandListener = null;
            this.mCallCommandV18Listener = null;
            unregisterCallback(this.mICallCommandCallback);
        }
    }

    public void setINTMuteListener(INTMuteNotifyListener iNTMuteNotifyListener) {
        synchronized (this.mLock) {
            if (this.mINTMuteNotifyListener == null) {
                registerCallback(this.mICallCommandCallback);
            }
            this.mINTMuteNotifyListener = iNTMuteNotifyListener;
        }
    }

    public void removeINTMuteListener(INTMuteNotifyListener iNTMuteNotifyListener) {
        synchronized (this.mLock) {
            this.mINTMuteNotifyListener = null;
            unregisterCallback(this.mICallCommandCallback);
        }
    }

    public void notifyListenerCallCommandResponse(TboxCallInfo tboxCallInfo) {
        CallCommandListener callCommandListener;
        synchronized (this.mLock) {
            callCommandListener = this.mCallCommandListener;
        }
        if (callCommandListener != null) {
            callCommandListener.onCallCommandResponse(tboxCallInfo.getCallComm(), tboxCallInfo.getCallType());
        }
        notifyListenerCallCommandResponseV18(tboxCallInfo);
    }

    private void notifyListenerCallCommandResponseV18(TboxCallInfo tboxCallInfo) {
        CallCommandV18Listener callCommandV18Listener;
        synchronized (this.mLock) {
            callCommandV18Listener = this.mCallCommandV18Listener;
        }
        if (callCommandV18Listener != null) {
            callCommandV18Listener.onCallCommandResponse(tboxCallInfo.getCallComm(), tboxCallInfo.getCallType(), tboxCallInfo.getAckCode());
        }
    }

    public void notifyListenerINTMute(boolean z) {
        INTMuteNotifyListener iNTMuteNotifyListener;
        Log.i("TboxManager", "notifyListenerINTMute in TboxCallCommandManager >>> isMute = " + z);
        synchronized (this.mLock) {
            iNTMuteNotifyListener = this.mINTMuteNotifyListener;
        }
        if (iNTMuteNotifyListener != null) {
            iNTMuteNotifyListener.onINTMuteNotify(z);
        }
    }

    public void callRequest(byte b, byte b2) {
        Log.i("TboxManager", "callRequest in manager start " + ((int) b) + " " + ((int) b2));
        try {
            this.mService.callRequest(b, b2);
        } catch (RemoteException e) {
            Log.e("TboxManager", "callRequest RemoteException " + e);
        }
    }

    private void registerCallback(ICallCommandCallback iCallCommandCallback) {
        Log.i("TboxManager", "registerCallback in TboxCallCommandManager  " + iCallCommandCallback);
        try {
            this.mService.registerCallback(iCallCommandCallback);
        } catch (RemoteException e) {
            Log.e("TboxManager", "registerCallback RemoteException " + e);
        }
    }

    private void unregisterCallback(ICallCommandCallback iCallCommandCallback) {
        Log.i("TboxManager", "unregisterCallback in TboxCallCommandManager  " + iCallCommandCallback);
        try {
            ICallCommand iCallCommand = this.mService;
            if (iCallCommand != null) {
                iCallCommand.unregisterCallback(iCallCommandCallback);
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "unregisterCallback RemoteException " + e);
        }
    }

    @Override // com.autolink.adaptermanager.tbox2.TboxManagerBase
    protected void clearDeadBinder() {
        if (this.mService != null) {
            Log.d("TboxManager", "TboxCallCommandManager clearDeadBinder");
            this.mService = null;
        }
    }
}
