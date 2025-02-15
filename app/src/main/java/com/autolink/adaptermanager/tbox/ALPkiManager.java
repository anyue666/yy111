package com.autolink.adaptermanager.tbox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.autolink.adapterinterface.IPkiServiceListener;
import com.autolink.adapterinterface.ITBoxManager;
import com.autolink.adaptermanager.ALLog;

/* loaded from: classes.dex */
public class ALPkiManager {
    public static final String LOG_TAG = "ALPkiManager-";
    public static final String PACKAGE_NAME = "com.autolink.tboxservice";
    public static final String SERVICE_NAME = "com.autolink.tboxservice.TBoxService";
    private static ALPkiManager instance;
    private Context mContext;
    private IPkiListener mPkiListener;
    private ITBoxManager mService;
    private final ServiceConnection mConnect = new ServiceConnection() { // from class: com.autolink.adaptermanager.tbox.ALPkiManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALPkiManager.this.mService = ITBoxManager.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALPkiManager.this.mService = null;
        }
    };
    private IPkiServiceListener mPkiServiceListener = new IPkiServiceListener.Stub() { // from class: com.autolink.adaptermanager.tbox.ALPkiManager.2
        @Override // com.autolink.adapterinterface.IPkiServiceListener
        public void onRecvGetCertReq() throws RemoteException {
            if (ALPkiManager.this.mPkiListener != null) {
                ALPkiManager.this.mPkiListener.onRecvGetCertReq();
            }
        }

        @Override // com.autolink.adapterinterface.IPkiServiceListener
        public void onRecvDownloadCertificateRltAck(boolean z) throws RemoteException {
            if (ALPkiManager.this.mPkiListener != null) {
                ALPkiManager.this.mPkiListener.onRecvDownloadCertificateRltAck(z);
            }
        }

        @Override // com.autolink.adapterinterface.IPkiServiceListener
        public void onRecvCertificateStatusReq() throws RemoteException {
            if (ALPkiManager.this.mPkiListener != null) {
                ALPkiManager.this.mPkiListener.onRecvCertificateStatusReq();
            }
        }
    };

    public interface IPkiListener {
        void onRecvCertificateStatusReq();

        void onRecvDownloadCertificateRltAck(boolean z);

        void onRecvGetCertReq();
    }

    private ALPkiManager(Context context) {
        this.mContext = context;
    }

    public static ALPkiManager getInstance(Context context) {
        if (instance == null) {
            instance = new ALPkiManager(context);
        }
        return instance;
    }

    private void connectService() {
        Intent intent = new Intent("com.autolink.tboxservice.TBoxService");
        intent.setPackage("com.autolink.tboxservice");
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        context.bindService(intent, this.mConnect, 1);
    }

    public void sendGetCertResp(boolean z) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendGetCertResp]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.sendGetCertResp(getCallUid(), z);
        } catch (RemoteException e) {
            loge("[error]sendGetCertResp");
            e.printStackTrace();
        }
    }

    public void sendDownloadCertificateRltReport(int i) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendDownloadCertificateRltReport]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.sendDownloadCertificateRltReport(getCallUid(), i);
        } catch (RemoteException e) {
            loge("[error]sendDownloadCertificateRltReport");
            e.printStackTrace();
        }
    }

    public void sendCertificateStatusResp(int i) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendCertificateStatusResp]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.sendCertificateStatusResp(getCallUid(), i);
        } catch (RemoteException e) {
            loge("[error]sendCertificateStatusResp");
            e.printStackTrace();
        }
    }

    public boolean registerPkiListner(IPkiListener iPkiListener) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[registerPkiListner]TBoxManagerService-instance is null, return false");
            return false;
        }
        if (iPkiListener == null) {
            loge("[registerPkiListner] param-listener is null, return");
            return false;
        }
        try {
            this.mPkiListener = iPkiListener;
            return iTBoxManager.registerPkiListner(getCallUid(), this.mPkiServiceListener);
        } catch (RemoteException e) {
            loge("[error]registerPkiListner");
            e.printStackTrace();
            return false;
        }
    }

    public void unregisterPkiListner() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[unregisterPkiListner]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            this.mPkiListener = null;
            iTBoxManager.unregisterPkiListner(getCallUid(), this.mPkiServiceListener);
        } catch (RemoteException e) {
            loge("[error]unregisterPkiListner");
            e.printStackTrace();
        }
    }

    private String getCallPackageName() {
        Context context = this.mContext;
        return context != null ? context.getPackageName() : "null";
    }

    private int getCallUid() {
        return Binder.getCallingUid();
    }

    private void logv(String str) {
        ALLog.v(LOG_TAG + str);
    }

    private void logd(String str) {
        ALLog.d(LOG_TAG + str);
    }

    private void logi(String str) {
        ALLog.i(LOG_TAG + str);
    }

    private void loge(String str) {
        ALLog.e(LOG_TAG + str);
    }
}
