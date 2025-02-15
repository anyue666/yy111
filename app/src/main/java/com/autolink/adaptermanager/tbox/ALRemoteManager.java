package com.autolink.adaptermanager.tbox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.autolink.adapterinterface.ChargeReserveSync;
import com.autolink.adapterinterface.ChargeSetReqeust;
import com.autolink.adapterinterface.ITBoxManager;
import com.autolink.adapterinterface.ITBoxRemoteListner;
import com.autolink.adapterinterface.InquireCharge;
import com.autolink.adaptermanager.ALLog;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ALRemoteManager {
    public static final String LOG_TAG = "ALRemoteManager-";
    public static final String PACKAGE_NAME = "com.autolink.tboxservice";
    public static final String SERVICE_NAME = "com.autolink.tboxservice.TBoxService";
    private static ALRemoteManager instance;
    private final Context mContext;
    private IRemoteListener mRemoteListener;
    private ITBoxManager mService;
    private ITBoxRemoteListner mTBoxRemoteListener = new ITBoxRemoteListner.Stub() { // from class: com.autolink.adaptermanager.tbox.ALRemoteManager.1
        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onRemoteHuAwkReq(byte[] bArr) throws RemoteException {
            if (ALRemoteManager.this.mRemoteListener != null) {
                ALRemoteManager.this.mRemoteListener.onRemoteHuAwkReq(bArr);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onChargeReserveSetResp(boolean z) throws RemoteException {
            if (ALRemoteManager.this.mRemoteListener != null) {
                ALRemoteManager.this.mRemoteListener.onChargeReserveSetResp(z);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onPhoneChargeReserveSyncReq(ChargeReserveSync chargeReserveSync) throws RemoteException {
            if (ALRemoteManager.this.mRemoteListener != null) {
                ALRemoteManager.this.mRemoteListener.onPhoneChargeReserveSyncReq(new ALChargeReserveSync(chargeReserveSync));
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onPhoneChargeReserveStatuReport(int i, int i2) throws RemoteException {
            if (ALRemoteManager.this.mRemoteListener != null) {
                ALRemoteManager.this.mRemoteListener.onPhoneChargeReserveStatuReport(i, i2);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onInquireChargeReserveResp(InquireCharge inquireCharge) throws RemoteException {
            if (ALRemoteManager.this.mRemoteListener != null) {
                ALRemoteManager.this.mRemoteListener.onInquireChargeReserveResp(new ALInquireCharge(inquireCharge));
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void lightShowCtrlReq(int i) throws RemoteException {
            if (ALRemoteManager.this.mRemoteListener != null) {
                ALRemoteManager.this.mRemoteListener.lightShowCtrlReq(i);
            }
        }
    };
    private final ServiceConnection mConnect = new ServiceConnection() { // from class: com.autolink.adaptermanager.tbox.ALRemoteManager.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALRemoteManager.this.mService = ITBoxManager.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALRemoteManager.this.mService = null;
        }
    };

    public interface IRemoteListener {
        void lightShowCtrlReq(int i);

        void onChargeReserveSetResp(boolean z);

        void onInquireChargeReserveResp(ALInquireCharge aLInquireCharge);

        void onPhoneChargeReserveStatuReport(int i, int i2);

        void onPhoneChargeReserveSyncReq(ALChargeReserveSync aLChargeReserveSync);

        void onRemoteHuAwkReq(byte[] bArr);
    }

    private ALRemoteManager(Context context) {
        this.mContext = context;
    }

    public static ALRemoteManager getInstance(Context context) {
        if (instance == null) {
            instance = new ALRemoteManager(context);
        }
        return instance;
    }

    public void chargeReserveSetRequest(ALChargeSetReqeust aLChargeSetReqeust) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[chargeReserveSetRequest]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.chargeReserveSetRequest(getCallUid(), aLChargeSetReqeust.getAidlMessage());
        } catch (RemoteException e) {
            loge("[error]chargeReserveSetRequest");
            e.printStackTrace();
        }
    }

    public void chargeReserveSyncResponse(int i) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[chargeReserveSyncResponse]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.chargeReserveSyncResponse(getCallUid(), i);
        } catch (RemoteException e) {
            loge("[error]chargeReserveSyncResponse");
            e.printStackTrace();
        }
    }

    public void chargeReserveStatuReportResponse(int i) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[chargeReserveStatuReportResponse]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.chargeReserveStatuReportResponse(getCallUid(), i);
        } catch (RemoteException e) {
            loge("[error]chargeReserveStatuReportResponse");
            e.printStackTrace();
        }
    }

    public void inquireChargeReserveRequest() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[inquireChargeReserveRequest]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.inquireChargeReserveRequest(getCallUid());
        } catch (RemoteException e) {
            loge("[error]inquireChargeReserveRequest");
            e.printStackTrace();
        }
    }

    public void lightShowCtrlResponse(int i, int i2) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[lightShowCtrlResponse]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.lightShowCtrlResponse(getCallUid(), i, i2);
        } catch (RemoteException e) {
            loge("[error]lightShowCtrlResponse");
            e.printStackTrace();
        }
    }

    public boolean registerRemoteListner(IRemoteListener iRemoteListener) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            loge("[registerRemoteListner]TBoxManagerService-instance is null, return false");
            return false;
        }
        if (iRemoteListener == null) {
            loge("[registerTBoxCallback] param-listener is null, return");
            return false;
        }
        try {
            this.mRemoteListener = iRemoteListener;
            return iTBoxManager.registerRemoteListner(getCallUid(), this.mTBoxRemoteListener);
        } catch (RemoteException e) {
            loge("[error]registerRemoteListner");
            e.printStackTrace();
            return false;
        }
    }

    public void unregisterRemoteListner() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[unregisterRemoteListner]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            this.mRemoteListener = null;
            iTBoxManager.unregisterRemoteListner(getCallUid(), this.mTBoxRemoteListener);
        } catch (RemoteException e) {
            loge("[error]unregisterRemoteListner");
            e.printStackTrace();
        }
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

    public static class ALChargeReserveSync {
        public int chargeSOC;
        public int chargeTaskId;
        public int chargeTimeBegin;
        public int chargeTimeBeginMin;
        public int chargeTimeEnd;
        public int chargeTimeEndMin;
        public int chargeType;
        public int[] repeatType;
        public int reserveType;

        public ALChargeReserveSync() {
        }

        ALChargeReserveSync(ChargeReserveSync chargeReserveSync) {
            this.chargeType = chargeReserveSync.chargeType;
            this.reserveType = chargeReserveSync.reserveType;
            this.chargeTaskId = chargeReserveSync.chargeTaskId;
            this.chargeSOC = chargeReserveSync.chargeSOC;
            this.chargeTimeBegin = chargeReserveSync.chargeTimeBegin;
            this.chargeTimeBeginMin = chargeReserveSync.chargeTimeBeginMin;
            this.chargeTimeEnd = chargeReserveSync.chargeTimeEnd;
            this.chargeTimeEndMin = chargeReserveSync.chargeTimeEndMin;
            this.repeatType = chargeReserveSync.repeatType;
        }

        ChargeReserveSync getAidlMessage() {
            ChargeReserveSync chargeReserveSync = new ChargeReserveSync();
            chargeReserveSync.chargeType = this.chargeType;
            chargeReserveSync.reserveType = this.reserveType;
            chargeReserveSync.chargeTaskId = this.chargeTaskId;
            chargeReserveSync.chargeSOC = this.chargeSOC;
            chargeReserveSync.chargeTimeBegin = this.chargeTimeBegin;
            chargeReserveSync.chargeTimeBeginMin = this.chargeTimeBeginMin;
            chargeReserveSync.chargeTimeEnd = this.chargeTimeEnd;
            chargeReserveSync.chargeTimeEndMin = this.chargeTimeEndMin;
            chargeReserveSync.repeatType = this.repeatType;
            return chargeReserveSync;
        }

        public String toString() {
            return "ALChargeReserveSync{chargeType=" + this.chargeType + ", reserveType=" + this.reserveType + ", chargeTaskId=" + this.chargeTaskId + ", chargeSOC=" + this.chargeSOC + ", chargeTimeBegin=" + this.chargeTimeBegin + ", chargeTimeBeginMin=" + this.chargeTimeBeginMin + ", chargeTimeEnd=" + this.chargeTimeEnd + ", chargeTimeEndMin=" + this.chargeTimeEndMin + ", repeatType=" + Arrays.toString(this.repeatType) + '}';
        }
    }

    public static class ALInquireCharge {
        public int chargeMode;
        public int chargeSOC;
        public int chargeTaskId;
        public int chargeTimeBegin;
        public int chargeTimeBeginMin;
        public int chargeTimeEnd;
        public int chargeTimeEndMin;
        public int reserveType;

        public ALInquireCharge() {
        }

        ALInquireCharge(InquireCharge inquireCharge) {
            this.chargeMode = inquireCharge.chargeMode;
            this.reserveType = inquireCharge.reserveType;
            this.chargeTaskId = inquireCharge.chargeTaskId;
            this.chargeSOC = inquireCharge.chargeSOC;
            this.chargeTimeBegin = inquireCharge.chargeTimeBegin;
            this.chargeTimeBeginMin = inquireCharge.chargeTimeBeginMin;
            this.chargeTimeEnd = inquireCharge.chargeTimeEnd;
            this.chargeTimeEndMin = inquireCharge.chargeTimeEndMin;
        }

        InquireCharge getAidlMessage() {
            InquireCharge inquireCharge = new InquireCharge();
            inquireCharge.chargeMode = this.chargeMode;
            inquireCharge.reserveType = this.reserveType;
            inquireCharge.chargeTaskId = this.chargeTaskId;
            inquireCharge.chargeSOC = this.chargeSOC;
            inquireCharge.chargeTimeBegin = this.chargeTimeBegin;
            inquireCharge.chargeTimeBeginMin = this.chargeTimeBeginMin;
            inquireCharge.chargeTimeEnd = this.chargeTimeEnd;
            inquireCharge.chargeTimeEndMin = this.chargeTimeEndMin;
            return inquireCharge;
        }

        public String toString() {
            return "ALInquireCharge{chargeMode=" + this.chargeMode + ", reserveType=" + this.reserveType + ", chargeTaskId=" + this.chargeTaskId + ", chargeSOC=" + this.chargeSOC + ", chargeTimeBegin=" + this.chargeTimeBegin + ", chargeTimeBeginMin=" + this.chargeTimeBeginMin + ", chargeTimeEnd=" + this.chargeTimeEnd + ", chargeTimeEndMin=" + this.chargeTimeEndMin + '}';
        }
    }

    public static class ALChargeSetReqeust {
        public int chargeSOC;
        public int chargeTaskId;
        public int chargeTimeBegin;
        public int chargeTimeBeginMin;
        public int chargeTimeEnd;
        public int chargeTimeEndMin;
        public int chargeType;
        public int repeatType;
        public int reserveType;

        public ALChargeSetReqeust() {
        }

        ALChargeSetReqeust(ChargeSetReqeust chargeSetReqeust) {
            this.chargeType = chargeSetReqeust.chargeType;
            this.reserveType = chargeSetReqeust.reserveType;
            this.chargeTaskId = chargeSetReqeust.chargeTaskId;
            this.chargeSOC = chargeSetReqeust.chargeSOC;
            this.chargeTimeBegin = chargeSetReqeust.chargeTimeBegin;
            this.chargeTimeBeginMin = chargeSetReqeust.chargeTimeBeginMin;
            this.chargeTimeEnd = chargeSetReqeust.chargeTimeEnd;
            this.chargeTimeEndMin = chargeSetReqeust.chargeTimeEndMin;
            this.repeatType = chargeSetReqeust.repeatType;
        }

        ChargeSetReqeust getAidlMessage() {
            ChargeSetReqeust chargeSetReqeust = new ChargeSetReqeust();
            chargeSetReqeust.chargeType = this.chargeType;
            chargeSetReqeust.reserveType = this.reserveType;
            chargeSetReqeust.chargeTaskId = this.chargeTaskId;
            chargeSetReqeust.chargeSOC = this.chargeSOC;
            chargeSetReqeust.chargeTimeBegin = this.chargeTimeBegin;
            chargeSetReqeust.chargeTimeBeginMin = this.chargeTimeBeginMin;
            chargeSetReqeust.chargeTimeEnd = this.chargeTimeEnd;
            chargeSetReqeust.chargeTimeEndMin = this.chargeTimeEndMin;
            chargeSetReqeust.repeatType = this.repeatType;
            return chargeSetReqeust;
        }

        public String toString() {
            return "ALChargeSetReqeust{chargeType=" + this.chargeType + ", reserveType=" + this.reserveType + ", chargeTaskId=" + this.chargeTaskId + ", chargeSOC=" + this.chargeSOC + ", chargeTimeBegin=" + this.chargeTimeBegin + ", chargeTimeBeginMin=" + this.chargeTimeBeginMin + ", chargeTimeEnd=" + this.chargeTimeEnd + ", chargeTimeEndMin=" + this.chargeTimeEndMin + ", repeatType=" + this.repeatType + '}';
        }
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
