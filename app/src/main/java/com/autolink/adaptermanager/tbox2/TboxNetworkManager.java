package com.autolink.adaptermanager.tbox2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.network.INetwork;
import com.autolink.adapterinterface.tbox2.network.INetworkCallback;
import com.autolink.adapterinterface.tbox2.network.TboxNetworkRestartResultInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TboxNetworkManager extends TboxManagerBase {
    private static final boolean DBG = true;
    private final HandlerThread mHandlerThread;
    INetworkCallback mINetworkCallback;
    private final Object mLock;
    private final NetworkManagerHandler mNetworkManagerHandler;
    private INetwork mService;
    private TboxNetworkListener mTboxNetworkListener;
    private TboxNetworkRestartlistener mTboxNetworkRestartlistener;

    public interface TboxNetworkListener {
        void onNetworkResponse(byte b, byte b2);
    }

    public interface TboxNetworkRestartlistener {
        void onNetworkRestartResult(TboxNetworkRestartResultInfo tboxNetworkRestartResultInfo);
    }

    /* renamed from: com.autolink.adaptermanager.tbox2.TboxNetworkManager$1 */
    class AnonymousClass1 extends INetworkCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
        public void onNetworkResponse(byte b, byte b2) {
            TboxNetworkManager.this.mNetworkManagerHandler.sendMessage(Message.obtain(TboxNetworkManager.this.mNetworkManagerHandler, 1, b, b2, null));
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
        public void onNetworkRestartResult(TboxNetworkRestartResultInfo tboxNetworkRestartResultInfo) {
            TboxNetworkManager.this.mNetworkManagerHandler.sendMessage(Message.obtain(TboxNetworkManager.this.mNetworkManagerHandler, 2, tboxNetworkRestartResultInfo));
        }
    }

    private static final class NetworkManagerHandler extends Handler {
        private static final int MSG_NETWORK_RESPONSE = 1;
        private static final int MSG_NETWORK_RESTART_RESULT = 2;
        private final WeakReference<TboxNetworkManager> mManager;

        /* synthetic */ NetworkManagerHandler(Looper looper, TboxNetworkManager tboxNetworkManager, AnonymousClass1 anonymousClass1) {
            this(looper, tboxNetworkManager);
        }

        private NetworkManagerHandler(Looper looper, TboxNetworkManager tboxNetworkManager) {
            super(looper);
            Log.i("TboxManager", "NetworkManagerHandler start");
            this.mManager = new WeakReference<>(tboxNetworkManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TboxNetworkManager tboxNetworkManager = this.mManager.get();
            if (tboxNetworkManager == null) {
                Log.e("TboxManager", "handleMessage manager is null");
                return;
            }
            int i = message.what;
            if (i == 1) {
                tboxNetworkManager.notifyListenerNetworkResponse((byte) message.arg1, (byte) message.arg2);
            } else {
                if (i != 2) {
                    return;
                }
                tboxNetworkManager.notifyListenerNetworkRestartResult((TboxNetworkRestartResultInfo) message.obj);
            }
        }
    }

    public void notifyListenerNetworkResponse(byte b, byte b2) {
        TboxNetworkListener tboxNetworkListener;
        Log.i("TboxManager", "TboxNetworkManager notifyListenerNetworkResponse networksate = " + ((int) b) + " csq = " + ((int) b2));
        synchronized (this.mLock) {
            tboxNetworkListener = this.mTboxNetworkListener;
        }
        tboxNetworkListener.onNetworkResponse(b, b2);
    }

    public void notifyListenerNetworkRestartResult(TboxNetworkRestartResultInfo tboxNetworkRestartResultInfo) {
        TboxNetworkRestartlistener tboxNetworkRestartlistener;
        Log.e("TboxManager", "TboxNetworkManager notifyListenerNetworkRestartResult info : " + tboxNetworkRestartResultInfo.toString());
        synchronized (this.mLock) {
            tboxNetworkRestartlistener = this.mTboxNetworkRestartlistener;
        }
        if (tboxNetworkRestartlistener != null) {
            tboxNetworkRestartlistener.onNetworkRestartResult(tboxNetworkRestartResultInfo);
        }
    }

    public TboxNetworkManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        this.mLock = new Object();
        HandlerThread handlerThread = TboxManagerUtils.getHandlerThread("TboxNetworkManager");
        this.mHandlerThread = handlerThread;
        this.mNetworkManagerHandler = new NetworkManagerHandler(handlerThread.getLooper(), this);
        this.mINetworkCallback = new INetworkCallback.Stub() { // from class: com.autolink.adaptermanager.tbox2.TboxNetworkManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
            public void onNetworkResponse(byte b, byte b2) {
                TboxNetworkManager.this.mNetworkManagerHandler.sendMessage(Message.obtain(TboxNetworkManager.this.mNetworkManagerHandler, 1, b, b2, null));
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
            public void onNetworkRestartResult(TboxNetworkRestartResultInfo tboxNetworkRestartResultInfo) {
                TboxNetworkManager.this.mNetworkManagerHandler.sendMessage(Message.obtain(TboxNetworkManager.this.mNetworkManagerHandler, 2, tboxNetworkRestartResultInfo));
            }
        };
        this.mService = INetwork.Stub.asInterface(iBinder);
    }

    public void setListener(TboxNetworkListener tboxNetworkListener) {
        Log.i("TboxManager", "TboxNetworkManager setListener in manager start ");
        synchronized (this.mLock) {
            if (this.mTboxNetworkListener == null) {
                registerCallback(this.mINetworkCallback);
            }
            this.mTboxNetworkListener = tboxNetworkListener;
        }
    }

    public void removeListener() {
        Log.i("TboxManager", "TboxNetworkManager removeListener in manager start ");
        synchronized (this.mLock) {
            this.mTboxNetworkListener = null;
            unregisterCallback(this.mINetworkCallback);
        }
    }

    public void setTboxNetworkRestartlistener(TboxNetworkRestartlistener tboxNetworkRestartlistener) {
        synchronized (this.mLock) {
            if (this.mTboxNetworkListener == null) {
                registerCallback(this.mINetworkCallback);
            }
            this.mTboxNetworkRestartlistener = tboxNetworkRestartlistener;
        }
    }

    public void removeTboxNetworkRestartlistener() {
        synchronized (this.mLock) {
            this.mTboxNetworkRestartlistener = null;
            unregisterCallback(this.mINetworkCallback);
        }
    }

    public byte getNetworkState() {
        try {
            return this.mService.getNetworkState();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getNetworkState RemoteException " + e);
            return (byte) -1;
        }
    }

    public void networkDnsReq(int i) {
        try {
            this.mService.networkDnsReq(i);
        } catch (RemoteException e) {
            Log.e("TboxManager", "networkDnsReq RemoteException " + e);
        }
    }

    public void networkRestartReq(int i, byte b) {
        try {
            this.mService.networkRestartReq(i, b);
        } catch (RemoteException e) {
            Log.e("TboxManager", "networkRestartReq RemoteException " + e);
        }
    }

    public byte getCsq() {
        try {
            return this.mService.getCsq();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getCsq in TboxNetworkManager RemoteException " + e);
            return (byte) -1;
        }
    }

    private void registerCallback(INetworkCallback iNetworkCallback) {
        Log.i("TboxManager", "registerCallback in TboxNetworkManager start");
        try {
            this.mService.registerCallback(iNetworkCallback);
        } catch (RemoteException e) {
            Log.e("TboxManager", "registerCallback RemoteException " + e);
        }
    }

    private void unregisterCallback(INetworkCallback iNetworkCallback) {
        Log.i("TboxManager", "unregisterCallback in TboxNetworkManager start");
        try {
            INetwork iNetwork = this.mService;
            if (iNetwork != null) {
                iNetwork.unregisterCallback(iNetworkCallback);
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "unregisterCallback RemoteException " + e);
        }
    }

    @Override // com.autolink.adaptermanager.tbox2.TboxManagerBase
    protected void clearDeadBinder() {
        if (this.mService != null) {
            Log.d("TboxManager", "TboxNetworkManager clearDeadBinder");
            this.mService = null;
        }
    }
}
