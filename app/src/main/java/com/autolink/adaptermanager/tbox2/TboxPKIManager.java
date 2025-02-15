package com.autolink.adaptermanager.tbox2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.pki.IPKI;
import com.autolink.adapterinterface.tbox2.pki.IPKICallback;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TboxPKIManager extends TboxManagerBase {
    private static final boolean DBG = true;
    private final HandlerThread mHandlerThread;
    IPKICallback mIPKICallback;
    private final Object mLock;
    private PKIListener mPKIListener;
    private final PKIManagerHandler mPKIManagerHandler;
    private IPKI mService;

    public interface PKIListener {
        void certReq();

        void certificateStatusReq();
    }

    /* renamed from: com.autolink.adaptermanager.tbox2.TboxPKIManager$1 */
    class AnonymousClass1 extends IPKICallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.tbox2.pki.IPKICallback
        public void certReq() {
            TboxPKIManager.this.mPKIManagerHandler.sendMessage(Message.obtain(TboxPKIManager.this.mPKIManagerHandler, 1));
        }

        @Override // com.autolink.adapterinterface.tbox2.pki.IPKICallback
        public void certificateStatusReq() {
            TboxPKIManager.this.mPKIManagerHandler.sendMessage(Message.obtain(TboxPKIManager.this.mPKIManagerHandler, 2));
        }
    }

    private static final class PKIManagerHandler extends Handler {
        private static final int MSG_CERTIFICATE_STATUS_REQ_RESPONSE = 2;
        private static final int MSG_CERT_REQ_RESPONSE = 1;
        private final WeakReference<TboxPKIManager> mManager;

        /* synthetic */ PKIManagerHandler(Looper looper, TboxPKIManager tboxPKIManager, AnonymousClass1 anonymousClass1) {
            this(looper, tboxPKIManager);
        }

        private PKIManagerHandler(Looper looper, TboxPKIManager tboxPKIManager) {
            super(looper);
            Log.i("TboxManager", "USBManagerHandler start");
            this.mManager = new WeakReference<>(tboxPKIManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TboxPKIManager tboxPKIManager = this.mManager.get();
            if (tboxPKIManager == null) {
                Log.e("TboxManager", "handleMessage manager is null");
                return;
            }
            int i = message.what;
            if (i == 1) {
                tboxPKIManager.notifyCertReq();
            } else {
                if (i != 2) {
                    return;
                }
                tboxPKIManager.notifyCertificateStatusReq();
            }
        }
    }

    public TboxPKIManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        this.mLock = new Object();
        HandlerThread handlerThread = TboxManagerUtils.getHandlerThread("TboxPKIManager");
        this.mHandlerThread = handlerThread;
        this.mPKIManagerHandler = new PKIManagerHandler(handlerThread.getLooper(), this);
        this.mIPKICallback = new IPKICallback.Stub() { // from class: com.autolink.adaptermanager.tbox2.TboxPKIManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.tbox2.pki.IPKICallback
            public void certReq() {
                TboxPKIManager.this.mPKIManagerHandler.sendMessage(Message.obtain(TboxPKIManager.this.mPKIManagerHandler, 1));
            }

            @Override // com.autolink.adapterinterface.tbox2.pki.IPKICallback
            public void certificateStatusReq() {
                TboxPKIManager.this.mPKIManagerHandler.sendMessage(Message.obtain(TboxPKIManager.this.mPKIManagerHandler, 2));
            }
        };
        this.mService = IPKI.Stub.asInterface(iBinder);
    }

    public void setListener(PKIListener pKIListener) {
        Log.i("TboxManager", "setListener in TboxRemoteManager start ");
        synchronized (this.mLock) {
            if (this.mPKIListener == null) {
                registerCallback(this.mIPKICallback);
            }
            this.mPKIListener = pKIListener;
        }
    }

    public void removeListener() {
        Log.i("TboxManager", "removeListener in TboxRemoteManager start ");
        synchronized (this.mLock) {
            this.mPKIListener = null;
            unregisterCallback(this.mIPKICallback);
        }
    }

    public void certificateRltReport(int i) {
        Log.i("TboxManager", "certificateRltReport in manager >>> result = " + i);
        try {
            this.mService.certificateRltReport(i);
        } catch (RemoteException e) {
            Log.e("TboxManager", "certificateRltReport RemoteException " + e);
        }
    }

    public void CertificateStatusResponse(int i) {
        Log.i("TboxManager", "CertificateStatusResponse in manager >>> certificateStatus = " + i);
        try {
            this.mService.CertificateStatusResponse(i);
        } catch (RemoteException e) {
            Log.e("TboxManager", "CertificateStatusResponse RemoteException " + e);
        }
    }

    private void registerCallback(IPKICallback iPKICallback) {
        Log.i("TboxManager", "registerCallback in TboxPKIManager start");
        try {
            this.mService.registerPKICallback(iPKICallback);
        } catch (RemoteException e) {
            Log.e("TboxManager", "registerCallback RemoteException " + e);
        }
    }

    private void unregisterCallback(IPKICallback iPKICallback) {
        Log.i("TboxManager", "unregisterCallback in TboxPKIManager start");
        try {
            IPKI ipki = this.mService;
            if (ipki != null) {
                ipki.unregisterPKICallback(iPKICallback);
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "unregisterCallback RemoteException " + e);
        }
    }

    public void notifyCertReq() {
        PKIListener pKIListener;
        Log.i("TboxManager", "notifyCertReq start");
        synchronized (this.mLock) {
            pKIListener = this.mPKIListener;
        }
        pKIListener.certReq();
    }

    public void notifyCertificateStatusReq() {
        PKIListener pKIListener;
        Log.i("TboxManager", "notifyCertificateStatusReq start");
        synchronized (this.mLock) {
            pKIListener = this.mPKIListener;
        }
        pKIListener.certificateStatusReq();
    }

    @Override // com.autolink.adaptermanager.tbox2.TboxManagerBase
    protected void clearDeadBinder() {
        if (this.mService != null) {
            Log.d("TboxManager", "TboxPKIManager clearDeadBinder");
            this.mService = null;
        }
    }
}
