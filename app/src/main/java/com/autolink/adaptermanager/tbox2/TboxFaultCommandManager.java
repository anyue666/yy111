package com.autolink.adaptermanager.tbox2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand;
import com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TboxFaultCommandManager extends TboxManagerBase {
    private static final int INVALID_STATE = 255;
    private IFaultCommandCallback mFaultCommandCallback;
    private FaultCommandHandler mFaultCommandHandler;
    private FaultCommandListener mFaultCommandListener;
    private final HandlerThread mHandlerThread;
    private final Object mLock;
    private IFaultCommand mService;
    private TboxDisconnectedListener mTboxDisconnectedListener;

    public interface FaultCommandListener {
        void onFaultCommandResponse(int i);
    }

    public interface TboxDisconnectedListener {
        void onTboxDisconnected(int i);
    }

    public TboxFaultCommandManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        this.mLock = new Object();
        HandlerThread handlerThread = TboxManagerUtils.getHandlerThread("TboxFaultCommandManager");
        this.mHandlerThread = handlerThread;
        this.mFaultCommandHandler = new FaultCommandHandler(handlerThread.getLooper(), this);
        this.mFaultCommandCallback = new IFaultCommandCallback.Stub() { // from class: com.autolink.adaptermanager.tbox2.TboxFaultCommandManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
            public void onFaultCommandResponse(int i) {
                TboxFaultCommandManager.this.mFaultCommandHandler.sendMessage(Message.obtain(TboxFaultCommandManager.this.mFaultCommandHandler, 0, i, 0));
            }

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
            public void onTboxDisconnected(int i) {
                TboxFaultCommandManager.this.mFaultCommandHandler.sendMessage(Message.obtain(TboxFaultCommandManager.this.mFaultCommandHandler, 1, i, 0));
            }
        };
        this.mService = IFaultCommand.Stub.asInterface(iBinder);
    }

    public void setListener(FaultCommandListener faultCommandListener) {
        Log.i("TboxManager", "setListener in TboxFaultCommandManager start ");
        synchronized (this.mLock) {
            if (this.mFaultCommandListener == null) {
                registerCallback(this.mFaultCommandCallback);
            }
            this.mFaultCommandListener = faultCommandListener;
            if (faultCommandListener != null) {
                faultCommandListener.onFaultCommandResponse(getFaultCommand());
            }
        }
    }

    public void removeListener() {
        Log.i("TboxManager", "removeListener in TboxFaultCommandManager start ");
        synchronized (this.mLock) {
            this.mFaultCommandListener = null;
            unregisterCallback(this.mFaultCommandCallback);
        }
    }

    public void setTboxDisconnectedListener(TboxDisconnectedListener tboxDisconnectedListener) {
        Log.i("TboxManager", "setTboxDisconnectedListener in TboxFaultCommandManager start ");
        synchronized (this.mLock) {
            if (this.mTboxDisconnectedListener == null) {
                registerCallback(this.mFaultCommandCallback);
            }
            this.mTboxDisconnectedListener = tboxDisconnectedListener;
        }
    }

    public void removeTboxDisconnectedListener() {
        synchronized (this.mLock) {
            this.mTboxDisconnectedListener = null;
            unregisterCallback(this.mFaultCommandCallback);
        }
    }

    public int getFaultCommand() {
        Log.i("TboxManager", "getFaultCommand in TboxFaultCommandManager start ");
        try {
            IFaultCommand iFaultCommand = this.mService;
            if (iFaultCommand != null) {
                return iFaultCommand.getFaultCommand();
            }
            return 255;
        } catch (RemoteException e) {
            Log.e("TboxManager", "getFaultCommand RemoteException " + e);
            return 255;
        }
    }

    public int getTboxConnectedState() {
        int i = 255;
        try {
            IFaultCommand iFaultCommand = this.mService;
            if (iFaultCommand != null) {
                i = iFaultCommand.getTboxConnectedState();
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "getFaultCommand RemoteException " + e);
        }
        Log.i("TboxManager", "getTboxConnectedState in TboxFaultCommandManager state = " + i);
        return i;
    }

    /* renamed from: com.autolink.adaptermanager.tbox2.TboxFaultCommandManager$1 */
    class AnonymousClass1 extends IFaultCommandCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
        public void onFaultCommandResponse(int i) {
            TboxFaultCommandManager.this.mFaultCommandHandler.sendMessage(Message.obtain(TboxFaultCommandManager.this.mFaultCommandHandler, 0, i, 0));
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
        public void onTboxDisconnected(int i) {
            TboxFaultCommandManager.this.mFaultCommandHandler.sendMessage(Message.obtain(TboxFaultCommandManager.this.mFaultCommandHandler, 1, i, 0));
        }
    }

    private class FaultCommandHandler extends Handler {
        private static final int MSG_ON_FAULT_COMMAND_RESPONSE = 0;
        private static final int MSG_ON_TBOX_DISCONNECTED = 1;
        private final WeakReference<TboxFaultCommandManager> mManager;

        /* synthetic */ FaultCommandHandler(TboxFaultCommandManager tboxFaultCommandManager, Looper looper, TboxFaultCommandManager tboxFaultCommandManager2, AnonymousClass1 anonymousClass1) {
            this(looper, tboxFaultCommandManager2);
        }

        private FaultCommandHandler(Looper looper, TboxFaultCommandManager tboxFaultCommandManager) {
            super(looper);
            Log.i("TboxManager", "USBManagerHandler in TboxFaultCommandManager start");
            this.mManager = new WeakReference<>(tboxFaultCommandManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TboxFaultCommandManager tboxFaultCommandManager = this.mManager.get();
            if (tboxFaultCommandManager == null) {
                Log.e("TboxManager", "handleMessage in TboxFaultCommandManager is null");
                return;
            }
            int i = message.what;
            if (i == 0) {
                tboxFaultCommandManager.notifyFaultCommandResponse(message.arg1);
            } else {
                if (i != 1) {
                    return;
                }
                tboxFaultCommandManager.notifyTboxDisconnected(message.arg1);
            }
        }
    }

    public void notifyFaultCommandResponse(int i) {
        FaultCommandListener faultCommandListener;
        Log.i("TboxManager", "notifyFaultCommandResponse in TboxFaultCommandManager start");
        synchronized (this.mLock) {
            faultCommandListener = this.mFaultCommandListener;
        }
        if (faultCommandListener != null) {
            faultCommandListener.onFaultCommandResponse(i);
        }
    }

    public void notifyTboxDisconnected(int i) {
        TboxDisconnectedListener tboxDisconnectedListener;
        Log.i("TboxManager", "notifyTboxDisconnected in TboxFaultCommandManager start >>> state = " + i);
        synchronized (this.mLock) {
            tboxDisconnectedListener = this.mTboxDisconnectedListener;
        }
        if (tboxDisconnectedListener != null) {
            tboxDisconnectedListener.onTboxDisconnected(i);
        }
    }

    private void registerCallback(IFaultCommandCallback iFaultCommandCallback) {
        Log.i("TboxManager", "registerCallback in TboxFaultCommandManager start");
        try {
            this.mService.registerCallback(iFaultCommandCallback);
        } catch (RemoteException e) {
            Log.e("TboxManager", "registerCallback RemoteException " + e);
        }
    }

    private void unregisterCallback(IFaultCommandCallback iFaultCommandCallback) {
        Log.i("TboxManager", "unregisterCallback in TboxFaultCommandManager start");
        try {
            IFaultCommand iFaultCommand = this.mService;
            if (iFaultCommand != null) {
                iFaultCommand.unregisterCallback(iFaultCommandCallback);
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "unregisterCallback RemoteException " + e);
        }
    }

    @Override // com.autolink.adaptermanager.tbox2.TboxManagerBase
    protected void clearDeadBinder() {
        if (this.mService != null) {
            Log.d("TboxManager", "TboxFaultCommandManager clearDeadBinder");
            this.mService = null;
        }
    }
}
