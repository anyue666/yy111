package com.autolink.adaptermanager.tbox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.MotionEventCompat;
import com.autolink.adapterinterface.GeneralInfo;
import com.autolink.adapterinterface.ITBoxBaseListener;
import com.autolink.adapterinterface.ITBoxManager;
import com.autolink.adapterinterface.TBoxCommandMsg;
import com.autolink.adaptermanager.ALLog;
import com.autolink.adaptermanager.hardkey.KeyCodeExt;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ALTBoxManager {
    public static final int HU_COMMAND_ACK_SUCCEED = 1;
    public static final int HU_REQUEST_CALL_CALLCOMMAND_ANSWER = 1;
    public static final int HU_REQUEST_CALL_CALLCOMMAND_DIAL = 0;
    public static final int HU_REQUEST_CALL_CALLCOMMAND_HANGUP = 2;
    public static final int HU_REQUEST_CALL_CALLTYPE_BCALL = 2;
    public static final int HU_REQUEST_CALL_CALLTYPE_SOS = 1;
    public static final String LOG_TAG = "ALTBoxManager-";
    public static final String PACKAGE_NAME = "com.autolink.tboxservice";
    public static final String SERVICE_NAME = "com.autolink.tboxservice.TBoxService";
    private static ALTBoxManager instance;
    private IBaseListener mBaseListener;
    private final Context mContext;
    private ITBoxManager mService;
    private ITBoxBaseListener mTBoxBaseListener = new ITBoxBaseListener.Stub() { // from class: com.autolink.adaptermanager.tbox.ALTBoxManager.1
        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onGeneralInfoResp(GeneralInfo generalInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onNetworkStateReport(int i, int i2) throws RemoteException {
            if (ALTBoxManager.this.mBaseListener != null) {
                ALTBoxManager.this.mBaseListener.onNetworkStateReport(i, i2);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onSignalStrengthChanged(int i) throws RemoteException {
            if (ALTBoxManager.this.mBaseListener != null) {
                ALTBoxManager.this.mBaseListener.onSignalStrengthChanged(i);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onCallStateChanged(int i, int i2) throws RemoteException {
            if (ALTBoxManager.this.mBaseListener != null) {
                ALTBoxManager.this.mBaseListener.onCallStateChanged(i, i2);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onCallCommandResp(boolean z) throws RemoteException {
            if (ALTBoxManager.this.mBaseListener != null) {
                ALTBoxManager.this.mBaseListener.onCallCommandResp(z);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onConnectStatusChanged(int i) throws RemoteException {
            if (ALTBoxManager.this.mBaseListener != null) {
                ALTBoxManager.this.mBaseListener.onConnectStatusChanged(i);
            }
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onFaultStateReport(int i) throws RemoteException {
            if (ALTBoxManager.this.mBaseListener != null) {
                ALTBoxManager.this.mBaseListener.onFaultStateReport((i & 1) == 1, (i & 2) == 1, (i & 4) == 1, i);
            }
        }
    };
    private final ServiceConnection mConnect = new ServiceConnection() { // from class: com.autolink.adaptermanager.tbox.ALTBoxManager.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALTBoxManager.this.mService = ITBoxManager.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALTBoxManager.this.mService = null;
        }
    };
    private int manufactureDate = -1;

    public interface IBaseListener {
        void onCallCommandResp(boolean z);

        void onCallStateChanged(int i, int i2);

        void onConnectStatusChanged(int i);

        void onFaultStateReport(boolean z, boolean z2, boolean z3, int i);

        void onNetworkStateReport(int i, int i2);

        void onSignalStrengthChanged(int i);
    }

    public static ALTBoxManager getInstance(Context context) {
        ALTBoxManager aLTBoxManager = instance;
        if (aLTBoxManager != null) {
            return aLTBoxManager;
        }
        ALTBoxManager aLTBoxManager2 = new ALTBoxManager(context);
        instance = aLTBoxManager2;
        return aLTBoxManager2;
    }

    private ALTBoxManager(Context context) {
        this.mContext = context;
        connectService();
    }

    public void sendCommand(ALTBoxCommandMsg aLTBoxCommandMsg) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendCommand]TBoxManagerService-instance is null return");
            return;
        }
        try {
            iTBoxManager.sendCommand(getCallUid(), aLTBoxCommandMsg.getAidlMessage());
        } catch (RemoteException e) {
            loge("[error]sendCommand, return null");
            e.printStackTrace();
        }
    }

    public GeneralInfo getGeneralInfo() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return null GeneralInfo");
            return null;
        }
        try {
            return iTBoxManager.getGeneralInfo();
        } catch (RemoteException e) {
            loge("[error]get GeneralInfo from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getVinCode() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty VinCode");
            return "";
        }
        try {
            return iTBoxManager.getVinCode();
        } catch (RemoteException e) {
            loge("[error]get VinCode from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public int getManufactureDateYear() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return invalid ManufactureDate");
            return -1;
        }
        try {
            if (this.manufactureDate == -1) {
                this.manufactureDate = iTBoxManager.getManufactureDate();
            }
            return ((this.manufactureDate & 16711680) >> 16) + KeyCodeExt.KEYCODE_AL_R_LEFT;
        } catch (RemoteException e) {
            loge("[error]get ManufactureDate from instance, return invalid value");
            e.printStackTrace();
            return -1;
        }
    }

    public int getManufactureDateMonth() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return invalid ManufactureDate");
            return -1;
        }
        try {
            if (this.manufactureDate == -1) {
                this.manufactureDate = iTBoxManager.getManufactureDate();
            }
            int i = (this.manufactureDate & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
            if (i <= 12) {
                return i;
            }
            return -1;
        } catch (RemoteException e) {
            loge("[error]get ManufactureDate from instance, return invalid value");
            e.printStackTrace();
            return -1;
        }
    }

    public int getManufactureDateDay() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return invalid ManufactureDate");
            return -1;
        }
        try {
            if (this.manufactureDate == -1) {
                this.manufactureDate = iTBoxManager.getManufactureDate();
            }
            int i = this.manufactureDate & 255;
            if (i <= 32) {
                return i;
            }
            return -1;
        } catch (RemoteException e) {
            loge("[error]get ManufactureDate from instance, return invalid value");
            e.printStackTrace();
            return -1;
        }
    }

    public String getSN() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty SN");
            return "";
        }
        try {
            return iTBoxManager.getSN();
        } catch (RemoteException e) {
            loge("[error]get SN from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getICCID() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty ICCID");
            return "";
        }
        try {
            return iTBoxManager.getICCID();
        } catch (RemoteException e) {
            loge("[error]get ICCID from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getHardwareVersion() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty HardwareVersion");
            return "";
        }
        try {
            return iTBoxManager.getHardwareVersion();
        } catch (RemoteException e) {
            loge("[error]get HardwareVersion from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getSoftVersion() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty SoftVersion");
            return "";
        }
        try {
            return iTBoxManager.getSoftVersion();
        } catch (RemoteException e) {
            loge("[error]get SoftVersion from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getSupplierIdertifier() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty SupplierIdertifier");
            return "";
        }
        try {
            return iTBoxManager.getSupplierIdertifier();
        } catch (RemoteException e) {
            loge("[error]get SupplierIdertifier from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getPartNumber() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty PartNumber");
            return "";
        }
        try {
            return iTBoxManager.getPartNumber();
        } catch (RemoteException e) {
            loge("[error]get PartNumber from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getIMSI() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty IMSI");
            return "";
        }
        try {
            return iTBoxManager.getIMSI();
        } catch (RemoteException e) {
            loge("[error]get IMSI from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public String getIMEI() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty IMEI");
            return "";
        }
        try {
            return iTBoxManager.getIMEI();
        } catch (RemoteException e) {
            loge("[error]get IMEI from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public byte[] getCarModelConfig() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return empty CarModelConfig");
            return new byte[0];
        }
        try {
            return iTBoxManager.getCarModelConfig();
        } catch (RemoteException e) {
            loge("[error]get CarModelConfig from instance, return null");
            e.printStackTrace();
            return null;
        }
    }

    public void sendGetGeneralInfoRequest() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendGetGeneralInfoRequest]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.sendGetGeneralInfoRequest(getCallUid());
        } catch (RemoteException e) {
            loge("[error]sendGetGeneralInfoRequest");
            e.printStackTrace();
        }
    }

    public int getNetworkType() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return invalid NetworkType");
            return -1;
        }
        try {
            return iTBoxManager.getNetworkType();
        } catch (RemoteException e) {
            loge("[error]get NetworkType from instance, return invalid value");
            e.printStackTrace();
            return -1;
        }
    }

    public int getSignalStrength() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("TBoxManagerService-instance is null return invalid SignalStrength");
            return -1;
        }
        try {
            return iTBoxManager.getSignalStrength();
        } catch (RemoteException e) {
            loge("[error]get SignalStrength from instance, return invalid value");
            e.printStackTrace();
            return -1;
        }
    }

    public void networkStateRequest(boolean z, int i) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[networkStateRequest]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.networkStateRequest(getCallUid(), z, i);
        } catch (RemoteException e) {
            loge("[error]networkStateRequest");
            e.printStackTrace();
        }
    }

    public void changeCallStateRequest(int i, int i2) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[changeCallStateRequest]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.changeCallStateRequest(getCallUid(), i, i2);
        } catch (RemoteException e) {
            loge("[error]changeCallStateRequest");
            e.printStackTrace();
        }
    }

    public void dial_BCall() {
        changeCallStateRequest(2, 0);
    }

    public void answer_BCall() {
        changeCallStateRequest(2, 1);
    }

    public void hangup_BCall() {
        changeCallStateRequest(2, 2);
    }

    public boolean registerTBoxCallback(IBaseListener iBaseListener) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[registerTBoxCallback]TBoxManagerService-instance is null, return false");
            return false;
        }
        if (iBaseListener == null) {
            loge("[registerTBoxCallback] param-listener is null, return");
            return false;
        }
        try {
            this.mBaseListener = iBaseListener;
            return iTBoxManager.registerTBoxCallback(getCallUid(), this.mTBoxBaseListener);
        } catch (RemoteException e) {
            loge("[error]registerTBoxCallback");
            e.printStackTrace();
            return false;
        }
    }

    public void unregisterTBoxCallback() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[unregisterTBoxCallback]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            this.mBaseListener = null;
            iTBoxManager.unregisterTBoxCallback(getCallUid(), this.mTBoxBaseListener);
        } catch (RemoteException e) {
            loge("[error]unregisterTBoxCallback");
            e.printStackTrace();
        }
    }

    public static class ALGeneralInfo {
        public int carModalType;
        public byte[] carModelConfig;
        public String hardwareVersion;
        public String iccid;
        public String imei;
        public String imsi;
        public int manufacture_day;
        public int manufacture_month;
        public int manufacture_year;
        public String partNumber;
        public String sn;
        public String softwareVersion;
        public String supplierIdertifier;
        public String vinCode;

        public ALGeneralInfo() {
        }

        ALGeneralInfo(GeneralInfo generalInfo) {
            int i = generalInfo.manufactureDate;
            this.manufacture_month = (65280 & i) >> 8;
            this.manufacture_day = i & 255;
            this.manufacture_year = (i & 16711680) >> 16;
            this.carModalType = generalInfo.carModalType;
            this.vinCode = generalInfo.vinCode;
            this.sn = generalInfo.sn;
            this.iccid = generalInfo.iccid;
            this.hardwareVersion = generalInfo.hardwareVersion;
            this.softwareVersion = generalInfo.softwareVersion;
            this.supplierIdertifier = generalInfo.supplierIdertifier;
            this.partNumber = generalInfo.partNumber;
            this.imsi = generalInfo.imsi;
            this.imei = generalInfo.imei;
            this.carModelConfig = generalInfo.carModelConfig;
        }

        GeneralInfo getAidlMessage() {
            GeneralInfo generalInfo = new GeneralInfo();
            generalInfo.manufactureDate = this.manufacture_day & 255;
            generalInfo.manufactureDate += (this.manufacture_month & 255) << 8;
            generalInfo.manufactureDate += (this.manufacture_year & 255) << 16;
            generalInfo.carModalType = this.carModalType;
            generalInfo.vinCode = this.vinCode;
            generalInfo.sn = this.sn;
            generalInfo.iccid = this.iccid;
            generalInfo.hardwareVersion = this.hardwareVersion;
            generalInfo.softwareVersion = this.softwareVersion;
            generalInfo.supplierIdertifier = this.supplierIdertifier;
            generalInfo.partNumber = this.partNumber;
            generalInfo.imsi = this.imsi;
            generalInfo.imei = this.imei;
            generalInfo.carModelConfig = this.carModelConfig;
            return generalInfo;
        }
    }

    public static class ALTBoxCommandMsg {
        public int applicationId;
        public byte[] cmd;
        public int messageId;

        public ALTBoxCommandMsg() {
        }

        ALTBoxCommandMsg(TBoxCommandMsg tBoxCommandMsg) {
            this.applicationId = tBoxCommandMsg.applicationId;
            this.messageId = tBoxCommandMsg.messageId;
            this.cmd = tBoxCommandMsg.cmd;
        }

        TBoxCommandMsg getAidlMessage() {
            TBoxCommandMsg tBoxCommandMsg = new TBoxCommandMsg();
            tBoxCommandMsg.applicationId = this.applicationId;
            tBoxCommandMsg.messageId = this.messageId;
            tBoxCommandMsg.cmd = this.cmd;
            return tBoxCommandMsg;
        }

        public String toString() {
            return "ALTBoxCommandMsg{applicationId=" + this.applicationId + ", messageId=" + this.messageId + ", cmd=" + Arrays.toString(this.cmd) + '}';
        }
    }

    private String getCallPackageName() {
        Context context = this.mContext;
        return context != null ? context.getPackageName() : "null";
    }

    private int getCallUid() {
        return Binder.getCallingUid();
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
