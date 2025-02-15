package com.autolink.adaptermanager.tbox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.autolink.adapterinterface.IRpaServiceListener;
import com.autolink.adapterinterface.ITBoxManager;
import com.autolink.adaptermanager.ALLog;

/* loaded from: classes.dex */
public class ALRpaManager {
    public static final String LOG_TAG = "ALRpaManager-";
    public static final String PACKAGE_NAME = "com.autolink.tboxservice";
    public static final String SERVICE_NAME = "com.autolink.tboxservice.TBoxService";
    private static ALRpaManager instance;
    private Context mContext;
    private IRpaListener mRpaListener;
    private ITBoxManager mService;
    private final ServiceConnection mConnect = new ServiceConnection() { // from class: com.autolink.adaptermanager.tbox.ALRpaManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALRpaManager.this.mService = ITBoxManager.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALRpaManager.this.mService = null;
        }
    };
    private IRpaServiceListener mRpaServiceListener = new IRpaServiceListener.Stub() { // from class: com.autolink.adaptermanager.tbox.ALRpaManager.2
        @Override // com.autolink.adapterinterface.IRpaServiceListener
        public void onRpaResp(int i, byte[] bArr) throws RemoteException {
            if (ALRpaManager.this.mRpaListener != null) {
                ALRpaManager.this.logi("onRpaResp send to apk");
                ALRpaManager.this.mRpaListener.onRpaResp(i, bArr);
            }
        }

        @Override // com.autolink.adapterinterface.IRpaServiceListener
        public void onHeartBeatResp(int i, boolean z) throws RemoteException {
            if (ALRpaManager.this.mRpaListener != null) {
                ALRpaManager.this.logi("onHeartBeatResp send to apk");
                ALRpaManager.this.mRpaListener.onHeartBeatResp(i, z);
            }
        }
    };

    public interface IRpaListener {
        void onHeartBeatResp(int i, boolean z);

        void onRpaResp(int i, byte[] bArr);
    }

    private ALRpaManager(Context context) {
        this.mContext = context;
    }

    public static ALRpaManager getInstance(Context context) {
        if (instance == null) {
            instance = new ALRpaManager(context);
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

    private String getCallPackageName() {
        Context context = this.mContext;
        return context != null ? context.getPackageName() : "null";
    }

    private int getCallUid() {
        return Binder.getCallingUid();
    }

    public boolean registerRpaListner(IRpaListener iRpaListener) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[registerRpaListner]TBoxManagerService-instance is null, return false");
            return false;
        }
        if (iRpaListener == null) {
            loge("[registerRpaListner] param-listener is null, return");
            return false;
        }
        try {
            this.mRpaListener = iRpaListener;
            return iTBoxManager.registerRpaListner(getCallUid(), this.mRpaServiceListener);
        } catch (RemoteException e) {
            loge("[error]registerRpaListner");
            e.printStackTrace();
            return false;
        }
    }

    public void unregisterRpaListner() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[unregisterRpaListner]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            this.mRpaListener = null;
            iTBoxManager.unregisterRpaListner(getCallUid(), this.mRpaServiceListener);
        } catch (RemoteException e) {
            loge("[error]unregisterRpaListner");
            e.printStackTrace();
        }
    }

    public void sendRpaResp(boolean z) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendRpaResp]TBoxManagerService-instance is null, return false");
            return;
        }
        try {
            iTBoxManager.sendRpaResp(getCallUid(), 2, z);
        } catch (RemoteException e) {
            loge("[error]sendRpaResp");
            e.printStackTrace();
        }
    }

    public void sendRpaReport(byte[] bArr) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendRpaReport]TBoxManagerService-instance is null, return false");
            return;
        }
        try {
            iTBoxManager.sendRpaReport(getCallUid(), 3, bArr);
        } catch (RemoteException e) {
            loge("[error]sendRpaReport");
            e.printStackTrace();
        }
    }

    public void sendSlotReport1(byte[] bArr) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendSlotReport1]TBoxManagerService-instance is null, return false");
            return;
        }
        try {
            iTBoxManager.sendSlotReport1(getCallUid(), 4, bArr);
        } catch (RemoteException e) {
            loge("[error]sendSlotReport1");
            e.printStackTrace();
        }
    }

    public void sendSlotReport2(byte[] bArr) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendSlotReport2]TBoxManagerService-instance is null, return false");
            return;
        }
        try {
            iTBoxManager.sendSlotReport2(getCallUid(), 5, bArr);
        } catch (RemoteException e) {
            loge("[error]sendSlotReport2");
            e.printStackTrace();
        }
    }

    private void logv(String str) {
        ALLog.v(LOG_TAG + str);
    }

    private void logd(String str) {
        ALLog.d(LOG_TAG + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logi(String str) {
        ALLog.i(LOG_TAG + str);
    }

    private void loge(String str) {
        ALLog.e(LOG_TAG + str);
    }
}
