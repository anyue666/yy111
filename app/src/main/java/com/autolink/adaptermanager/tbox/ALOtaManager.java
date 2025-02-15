package com.autolink.adaptermanager.tbox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.autolink.adapterinterface.FotaStateDisplayReq;
import com.autolink.adapterinterface.FotaUserComfResp;
import com.autolink.adapterinterface.FotaUserComfirmReq;
import com.autolink.adapterinterface.IOtaStateListener;
import com.autolink.adapterinterface.ITBoxManager;
import com.autolink.adapterinterface.OtaSubNodeInfo;
import com.autolink.adapterinterface.OtaSubNodeState;
import com.autolink.adapterinterface.SubNodeEnter;
import com.autolink.adaptermanager.ALLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ALOtaManager {
    public static final String LOG_TAG = "ALOtaManager-";
    public static final String PACKAGE_NAME = "com.autolink.tboxservice";
    public static final String SERVICE_NAME = "com.autolink.tboxservice.TBoxService";
    private static ALOtaManager instance;
    private final Context mContext;
    private IOtaListener mOtaListener;
    private ITBoxManager mService;
    private IOtaStateListener mOtaStateListener = new IOtaStateListener.Stub() { // from class: com.autolink.adaptermanager.tbox.ALOtaManager.1
        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void otaSubNodeReq(OtaSubNodeInfo otaSubNodeInfo) throws RemoteException {
            if (ALOtaManager.this.mOtaListener != null) {
                ALOtaManager.this.mOtaListener.otaSubNodeReq(new ALOtaSubNodeInfo(otaSubNodeInfo));
            }
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void otaSubNodeStateReportAck(int i) throws RemoteException {
            if (ALOtaManager.this.mOtaListener != null) {
                ALOtaManager.this.mOtaListener.otaSubNodeStateReportAck(i);
            }
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void fotaUserComfirmRequest(FotaUserComfirmReq fotaUserComfirmReq) throws RemoteException {
            if (ALOtaManager.this.mOtaListener != null) {
                ALOtaManager.this.mOtaListener.fotaUserComfirmRequest(new ALFotaUserComfirmReq(fotaUserComfirmReq));
            }
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void otaSubNodeRefreshNowRequest(long j, String str, int i, int i2) throws RemoteException {
            if (ALOtaManager.this.mOtaListener != null) {
                ALOtaManager.this.mOtaListener.otaSubNodeRefreshNowRequest(j, str, i, i2);
            }
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void fotaStateDisplayRequest(FotaStateDisplayReq fotaStateDisplayReq) throws RemoteException {
            if (ALOtaManager.this.mOtaListener != null) {
                ALOtaManager.this.mOtaListener.fotaStateDisplayRequest(new ALFotaStateDisplayReq(fotaStateDisplayReq));
            }
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void SubNodeReqEnterFactoryAck(boolean z) throws RemoteException {
            if (ALOtaManager.this.mOtaListener != null) {
                ALOtaManager.this.mOtaListener.SubNodeReqEnterFactoryAck(z);
            }
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void SubNodeReqStartFactoryAck(boolean z) throws RemoteException {
            if (ALOtaManager.this.mOtaListener != null) {
                ALOtaManager.this.mOtaListener.SubNodeReqStartFactoryAck(z);
            }
        }
    };
    private final ServiceConnection mConnect = new ServiceConnection() { // from class: com.autolink.adaptermanager.tbox.ALOtaManager.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALOtaManager.this.mService = ITBoxManager.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALOtaManager.this.mService = null;
        }
    };

    public interface IOtaListener {
        void SubNodeReqEnterFactoryAck(boolean z);

        void SubNodeReqStartFactoryAck(boolean z);

        void fotaStateDisplayRequest(ALFotaStateDisplayReq aLFotaStateDisplayReq);

        void fotaUserComfirmRequest(ALFotaUserComfirmReq aLFotaUserComfirmReq);

        void otaSubNodeRefreshNowRequest(long j, String str, int i, int i2);

        void otaSubNodeReq(ALOtaSubNodeInfo aLOtaSubNodeInfo);

        void otaSubNodeStateReportAck(int i);
    }

    private ALOtaManager(Context context) {
        this.mContext = context;
        connectService();
    }

    public static ALOtaManager getInstance(Context context) {
        if (instance == null) {
            instance = new ALOtaManager(context);
        }
        return instance;
    }

    public void reportOtaSubNodeState(ALOtaSubNodeState aLOtaSubNodeState) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            loge("[reportOtaSubNodeState]TBoxManagerService-instance is null, return");
            return;
        }
        if (aLOtaSubNodeState == null) {
            loge("[reportOtaSubNodeState]msgbody ALOtaSubNodeState is null, return");
            return;
        }
        try {
            iTBoxManager.reportOtaSubNodeState(getCallUid(), aLOtaSubNodeState.getAidlMessage());
        } catch (RemoteException e) {
            loge("[error]reportOtaSubNodeState");
            e.printStackTrace();
        }
    }

    public void fotaUserComfirmResponse(ALFotaUserComfResp aLFotaUserComfResp) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            loge("[fotaUserComfirmResponse]TBoxManagerService-instance is null, return");
            return;
        }
        if (aLFotaUserComfResp == null) {
            loge("[fotaUserComfirmResponse]msgbody ALFotaUserComfResp is null, return");
            return;
        }
        try {
            iTBoxManager.fotaUserComfirmResponse(getCallUid(), aLFotaUserComfResp.getAidlMessage());
        } catch (RemoteException e) {
            loge("[error]fotaUserComfirmResponse");
            e.printStackTrace();
        }
    }

    public void otaSubNodeRefreshNowResponse(long j, String str) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[otaSubNodeRefreshNowResponse]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.otaSubNodeRefreshNowResponse(getCallUid(), j, str);
        } catch (RemoteException e) {
            loge("[error]otaSubNodeRefreshNowResponse");
            e.printStackTrace();
        }
    }

    public void sendSubNodeEnterFactory(ALSubNodeEnter aLSubNodeEnter) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendSubNodeEnterFactory]TBoxManagerService-instance is null, return");
            return;
        }
        if (aLSubNodeEnter == null) {
            logi("[sendSubNodeEnterFactory]msbody ALSubNodeEnter is null, return");
            return;
        }
        try {
            iTBoxManager.sendSubNodeEnterFactory(getCallUid(), aLSubNodeEnter.getAidlMessage());
        } catch (RemoteException e) {
            loge("[error]sendSubNodeEnterFactory");
            e.printStackTrace();
        }
    }

    public void sendSubNodeStartFactory(boolean z) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[sendSubNodeStartFactory]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            iTBoxManager.sendSubNodeStartFactory(getCallUid(), z);
        } catch (RemoteException e) {
            loge("[error]sendSubNodeStartFactory");
            e.printStackTrace();
        }
    }

    public boolean registerFotaListener(IOtaListener iOtaListener) {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            loge("[registerFotaListener]TBoxManagerService-instance is null, return false");
            return false;
        }
        if (iOtaListener != null) {
            loge("[registerFotaListener]param listener is null, return false");
            return false;
        }
        try {
            this.mOtaListener = iOtaListener;
            return iTBoxManager.registerFotaListener(getCallUid(), this.mOtaStateListener);
        } catch (RemoteException e) {
            loge("[error]registerFotaListener");
            e.printStackTrace();
            return false;
        }
    }

    public void unregisterFotaListener() {
        ITBoxManager iTBoxManager = this.mService;
        if (iTBoxManager == null) {
            logi("[unregisterFotaListener]TBoxManagerService-instance is null, return");
            return;
        }
        try {
            this.mOtaListener = null;
            iTBoxManager.unregisterFotaListener(getCallUid(), this.mOtaStateListener);
        } catch (RemoteException e) {
            loge("[error]unregisterFotaListener");
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

    public static class ALFotaStateDisplayReq {
        public int ackCode;
        public String afterVersion;
        public String beforeVersion;
        public int ecuId;
        public String ecuName;
        public long taskId;
        public int updateModel;
        public int updateProgress;
        public int updateResult;

        public ALFotaStateDisplayReq() {
        }

        ALFotaStateDisplayReq(FotaStateDisplayReq fotaStateDisplayReq) {
            this.updateModel = fotaStateDisplayReq.updateModel;
            this.ecuId = fotaStateDisplayReq.ecuId;
            this.updateProgress = fotaStateDisplayReq.updateProgress;
            this.updateResult = fotaStateDisplayReq.updateResult;
            this.ackCode = fotaStateDisplayReq.ackCode;
            this.taskId = fotaStateDisplayReq.taskId;
            this.beforeVersion = fotaStateDisplayReq.beforeVersion;
            this.afterVersion = fotaStateDisplayReq.afterVersion;
            this.ecuName = fotaStateDisplayReq.ecuName;
        }

        FotaStateDisplayReq getAidlMessage() {
            FotaStateDisplayReq fotaStateDisplayReq = new FotaStateDisplayReq();
            fotaStateDisplayReq.updateModel = this.updateModel;
            fotaStateDisplayReq.ecuId = this.ecuId;
            fotaStateDisplayReq.updateProgress = this.updateProgress;
            fotaStateDisplayReq.updateResult = this.updateResult;
            fotaStateDisplayReq.ackCode = this.ackCode;
            fotaStateDisplayReq.taskId = this.taskId;
            fotaStateDisplayReq.beforeVersion = this.beforeVersion;
            fotaStateDisplayReq.afterVersion = this.afterVersion;
            fotaStateDisplayReq.ecuName = this.ecuName;
            return fotaStateDisplayReq;
        }

        public String toString() {
            return "ALFotaStateDisplayReq{updateModel=" + this.updateModel + ", ecuId=" + this.ecuId + ", updateProgress=" + this.updateProgress + ", updateResult=" + this.updateResult + ", ackCode=" + this.ackCode + ", taskId=" + this.taskId + ", beforeVersion='" + this.beforeVersion + "', afterVersion='" + this.afterVersion + "', ecuName='" + this.ecuName + "'}";
        }
    }

    public static class ALFotaUserComfResp {
        public int confirmType;
        public long eventTime;
        public int orderTime;
        public String sessionId;
        public long taskId;

        public ALFotaUserComfResp() {
        }

        ALFotaUserComfResp(FotaUserComfResp fotaUserComfResp) {
            this.taskId = fotaUserComfResp.taskId;
            this.sessionId = fotaUserComfResp.sessionId;
            this.confirmType = fotaUserComfResp.confirmType;
            this.orderTime = fotaUserComfResp.orderTime;
            this.eventTime = fotaUserComfResp.eventTime;
        }

        FotaUserComfResp getAidlMessage() {
            FotaUserComfResp fotaUserComfResp = new FotaUserComfResp();
            fotaUserComfResp.taskId = this.taskId;
            fotaUserComfResp.sessionId = this.sessionId;
            fotaUserComfResp.confirmType = this.confirmType;
            fotaUserComfResp.orderTime = this.orderTime;
            fotaUserComfResp.eventTime = this.eventTime;
            return fotaUserComfResp;
        }

        public String toString() {
            return "ALFotaUserComfResp{taskId=" + this.taskId + ", sessionId='" + this.sessionId + "', confirmType=" + this.confirmType + ", orderTime=" + this.orderTime + ", eventTime=" + this.eventTime + '}';
        }
    }

    public static class ALFotaUserComfirmReq {
        public ArrayList<ALUpdateEcuMessage> alUpdateEcuMessages = new ArrayList<>();
        public int ecuNumber;
        public String sessionId;
        public long taskId;

        public ALFotaUserComfirmReq() {
        }

        ALFotaUserComfirmReq(FotaUserComfirmReq fotaUserComfirmReq) {
            this.taskId = fotaUserComfirmReq.taskId;
            this.sessionId = fotaUserComfirmReq.sessionId;
            this.ecuNumber = fotaUserComfirmReq.ecuNumber;
            if (fotaUserComfirmReq.updateEcuMsgs == null || fotaUserComfirmReq.updateEcuMsgs.isEmpty()) {
                this.ecuNumber = 0;
                return;
            }
            if (fotaUserComfirmReq.updateEcuMsgs.size() != this.ecuNumber) {
                this.ecuNumber = fotaUserComfirmReq.updateEcuMsgs.size();
            }
            Iterator<FotaUserComfirmReq.UpdateEcuMessage> it = fotaUserComfirmReq.updateEcuMsgs.iterator();
            while (it.hasNext()) {
                this.alUpdateEcuMessages.add(new ALUpdateEcuMessage(it.next()));
            }
        }

        FotaUserComfirmReq getAidlMessage() {
            FotaUserComfirmReq fotaUserComfirmReq = new FotaUserComfirmReq();
            fotaUserComfirmReq.updateEcuMsgs = new ArrayList<>();
            fotaUserComfirmReq.taskId = this.taskId;
            fotaUserComfirmReq.sessionId = this.sessionId;
            fotaUserComfirmReq.ecuNumber = this.ecuNumber;
            ArrayList<ALUpdateEcuMessage> arrayList = this.alUpdateEcuMessages;
            if (arrayList == null || arrayList.isEmpty()) {
                fotaUserComfirmReq.ecuNumber = 0;
                return fotaUserComfirmReq;
            }
            if (this.alUpdateEcuMessages.size() != this.ecuNumber) {
                fotaUserComfirmReq.ecuNumber = this.alUpdateEcuMessages.size();
            }
            for (int i = 0; i < this.ecuNumber; i++) {
                fotaUserComfirmReq.updateEcuMsgs.add(this.alUpdateEcuMessages.get(i).getAidlMessage());
            }
            return fotaUserComfirmReq;
        }

        public String toString() {
            return "ALFotaUserComfirmReq{taskId=" + this.taskId + ", sessionId='" + this.sessionId + "', ecuNumber=" + this.ecuNumber + ", alUpdateEcuMessages=" + this.alUpdateEcuMessages + '}';
        }
    }

    public static class ALUpdateEcuMessage {
        public String ecuName;
        public int estimateUpgradeTime;
        public String partNo;
        public String releaseNote;
        public String targetVersion;
        public int updateModel;

        public ALUpdateEcuMessage() {
        }

        ALUpdateEcuMessage(FotaUserComfirmReq.UpdateEcuMessage updateEcuMessage) {
            this.updateModel = updateEcuMessage.updateModel;
            this.targetVersion = updateEcuMessage.targetVersion;
            this.partNo = updateEcuMessage.partNo;
            this.releaseNote = updateEcuMessage.releaseNote;
            this.estimateUpgradeTime = updateEcuMessage.estimateUpgradeTime;
            this.ecuName = updateEcuMessage.ecuName;
        }

        FotaUserComfirmReq.UpdateEcuMessage getAidlMessage() {
            FotaUserComfirmReq.UpdateEcuMessage updateEcuMessage = new FotaUserComfirmReq.UpdateEcuMessage();
            updateEcuMessage.updateModel = this.updateModel;
            updateEcuMessage.targetVersion = this.targetVersion;
            updateEcuMessage.partNo = this.partNo;
            updateEcuMessage.releaseNote = this.releaseNote;
            updateEcuMessage.estimateUpgradeTime = this.estimateUpgradeTime;
            updateEcuMessage.ecuName = this.ecuName;
            return updateEcuMessage;
        }

        public String toString() {
            return "ALUpdateEcuMessage{updateModel=" + this.updateModel + ", targetVersion='" + this.targetVersion + "', partNo='" + this.partNo + "', releaseNote='" + this.releaseNote + "', estimateUpgradeTime=" + this.estimateUpgradeTime + ", ecuName='" + this.ecuName + "'}";
        }
    }

    public static class ALSubNodeEnter {
        public int checkMethod;
        public String checkSumCode;
        public int ecuId;
        public String fileName;
        public long fileSize;
        public int model;
        public long taskId;

        public ALSubNodeEnter() {
        }

        ALSubNodeEnter(SubNodeEnter subNodeEnter) {
            this.model = subNodeEnter.model;
            this.ecuId = subNodeEnter.ecuId;
            this.checkMethod = subNodeEnter.checkMethod;
            this.taskId = subNodeEnter.taskId;
            this.fileSize = subNodeEnter.fileSize;
            this.fileName = subNodeEnter.fileName;
            this.checkSumCode = subNodeEnter.checkSumCode;
        }

        SubNodeEnter getAidlMessage() {
            SubNodeEnter subNodeEnter = new SubNodeEnter();
            subNodeEnter.model = this.model;
            subNodeEnter.ecuId = this.ecuId;
            subNodeEnter.checkMethod = this.checkMethod;
            subNodeEnter.taskId = this.taskId;
            subNodeEnter.fileSize = this.fileSize;
            subNodeEnter.fileName = this.fileName;
            subNodeEnter.checkSumCode = this.checkSumCode;
            return subNodeEnter;
        }

        public String toString() {
            return "ALSubNodeEnter{model=" + this.model + ", ecuId=" + this.ecuId + ", checkMethod=" + this.checkMethod + ", taskId=" + this.taskId + ", fileSize=" + this.fileSize + ", fileName='" + this.fileName + "', checkSumCode='" + this.checkSumCode + "'}";
        }
    }

    public static class ALOtaSubNodeState {
        public int code;
        public int ecuId;
        public String hardwareAfterVersion;
        public String hardwareBeforeVersion;
        public int result;
        public String sessionId;
        public String softwareAfterVersion;
        public String softwareBeforeVersion;
        public long taskId;
        public int updateProgress;
        public int updateState;

        public ALOtaSubNodeState() {
        }

        ALOtaSubNodeState(OtaSubNodeState otaSubNodeState) {
            this.ecuId = otaSubNodeState.ecuId;
            this.updateState = otaSubNodeState.updateState;
            this.updateProgress = otaSubNodeState.updateProgress;
            this.result = otaSubNodeState.result;
            this.code = otaSubNodeState.code;
            this.taskId = otaSubNodeState.taskId;
            this.sessionId = otaSubNodeState.sessionId;
            this.hardwareBeforeVersion = otaSubNodeState.hardwareBeforeVersion;
            this.softwareBeforeVersion = otaSubNodeState.softwareBeforeVersion;
            this.hardwareAfterVersion = otaSubNodeState.hardwareAfterVersion;
            this.softwareAfterVersion = otaSubNodeState.softwareAfterVersion;
        }

        OtaSubNodeState getAidlMessage() {
            OtaSubNodeState otaSubNodeState = new OtaSubNodeState();
            otaSubNodeState.ecuId = this.ecuId;
            otaSubNodeState.updateState = this.updateState;
            otaSubNodeState.updateProgress = this.updateProgress;
            otaSubNodeState.result = this.result;
            otaSubNodeState.code = this.code;
            otaSubNodeState.taskId = this.taskId;
            otaSubNodeState.sessionId = this.sessionId;
            otaSubNodeState.hardwareBeforeVersion = this.hardwareBeforeVersion;
            otaSubNodeState.softwareBeforeVersion = this.softwareBeforeVersion;
            otaSubNodeState.hardwareAfterVersion = this.hardwareAfterVersion;
            otaSubNodeState.softwareAfterVersion = this.softwareAfterVersion;
            return otaSubNodeState;
        }

        public String toString() {
            return "ALOtaSubNodeState{ecuId=" + this.ecuId + ", updateState=" + this.updateState + ", updateProgress=" + this.updateProgress + ", result=" + this.result + ", code=" + this.code + ", taskId=" + this.taskId + ", sessionId='" + this.sessionId + "', hardwareBeforeVersion='" + this.hardwareBeforeVersion + "', softwareBeforeVersion='" + this.softwareBeforeVersion + "', hardwareAfterVersion='" + this.hardwareAfterVersion + "', softwareAfterVersion='" + this.softwareAfterVersion + "'}";
        }
    }

    public static class ALOtaSubNodeInfo {
        public String apnName;
        public String checkSumCode;
        public int checkmethod;
        public int diffType;
        public int ecuId;
        public int estimateUpgradeTime;
        public long fileSize;
        public int fileType;
        public int forceUpdate;
        public String hardwareversion;
        public int needUploadLog;
        public int otaModel;
        public String partNo;
        public byte[] preconditionList;
        public String releaseNote;
        public String rollbackFileDownloadAddr;
        public String rollbackTargetVersion;
        public String sessionId;
        public String sid;
        public String targetUdsAddress;
        public String targetVersion;
        public long taskId;
        public int updateModel;
        public String updateSourceVersion;
        public String upgradeUrl;

        public ALOtaSubNodeInfo() {
        }

        ALOtaSubNodeInfo(OtaSubNodeInfo otaSubNodeInfo) {
            this.updateModel = otaSubNodeInfo.updateModel;
            this.checkmethod = otaSubNodeInfo.checkmethod;
            this.forceUpdate = otaSubNodeInfo.forceUpdate;
            this.fileType = otaSubNodeInfo.fileType;
            this.diffType = otaSubNodeInfo.diffType;
            this.taskId = otaSubNodeInfo.taskId;
            this.otaModel = otaSubNodeInfo.otaModel;
            this.estimateUpgradeTime = otaSubNodeInfo.estimateUpgradeTime;
            this.ecuId = otaSubNodeInfo.ecuId;
            this.needUploadLog = otaSubNodeInfo.needUploadLog;
            this.fileSize = otaSubNodeInfo.fileSize;
            this.checkSumCode = otaSubNodeInfo.checkSumCode;
            this.apnName = otaSubNodeInfo.apnName;
            this.targetVersion = otaSubNodeInfo.targetVersion;
            this.upgradeUrl = otaSubNodeInfo.upgradeUrl;
            this.hardwareversion = otaSubNodeInfo.hardwareversion;
            this.sid = otaSubNodeInfo.sid;
            this.updateSourceVersion = otaSubNodeInfo.updateSourceVersion;
            this.targetUdsAddress = otaSubNodeInfo.targetUdsAddress;
            this.sessionId = otaSubNodeInfo.sessionId;
            this.rollbackTargetVersion = otaSubNodeInfo.rollbackTargetVersion;
            this.partNo = otaSubNodeInfo.partNo;
            this.releaseNote = otaSubNodeInfo.releaseNote;
            this.rollbackFileDownloadAddr = otaSubNodeInfo.rollbackFileDownloadAddr;
            this.preconditionList = otaSubNodeInfo.preconditionList;
        }

        OtaSubNodeInfo getAidlMessage() {
            OtaSubNodeInfo otaSubNodeInfo = new OtaSubNodeInfo();
            otaSubNodeInfo.updateModel = this.updateModel;
            otaSubNodeInfo.checkmethod = this.checkmethod;
            otaSubNodeInfo.forceUpdate = this.forceUpdate;
            otaSubNodeInfo.fileType = this.fileType;
            otaSubNodeInfo.diffType = this.diffType;
            otaSubNodeInfo.taskId = this.taskId;
            otaSubNodeInfo.otaModel = this.otaModel;
            otaSubNodeInfo.estimateUpgradeTime = this.estimateUpgradeTime;
            otaSubNodeInfo.ecuId = this.ecuId;
            otaSubNodeInfo.needUploadLog = this.needUploadLog;
            otaSubNodeInfo.fileSize = this.fileSize;
            otaSubNodeInfo.checkSumCode = this.checkSumCode;
            otaSubNodeInfo.apnName = this.apnName;
            otaSubNodeInfo.targetVersion = this.targetVersion;
            otaSubNodeInfo.upgradeUrl = this.upgradeUrl;
            otaSubNodeInfo.hardwareversion = this.hardwareversion;
            otaSubNodeInfo.sid = this.sid;
            otaSubNodeInfo.updateSourceVersion = this.updateSourceVersion;
            otaSubNodeInfo.targetUdsAddress = this.targetUdsAddress;
            otaSubNodeInfo.sessionId = this.sessionId;
            otaSubNodeInfo.rollbackTargetVersion = this.rollbackTargetVersion;
            otaSubNodeInfo.partNo = this.partNo;
            otaSubNodeInfo.releaseNote = this.releaseNote;
            otaSubNodeInfo.rollbackFileDownloadAddr = this.rollbackFileDownloadAddr;
            otaSubNodeInfo.preconditionList = this.preconditionList;
            return otaSubNodeInfo;
        }

        public String toString() {
            return "ALOtaSubNodeInfo{updateModel=" + this.updateModel + ", checkmethod=" + this.checkmethod + ", forceUpdate=" + this.forceUpdate + ", fileType=" + this.fileType + ", diffType=" + this.diffType + ", taskId=" + this.taskId + ", otaModel=" + this.otaModel + ", estimateUpgradeTime=" + this.estimateUpgradeTime + ", ecuId=" + this.ecuId + ", needUploadLog=" + this.needUploadLog + ", fileSize=" + this.fileSize + ", checkSumCode='" + this.checkSumCode + "', apnName='" + this.apnName + "', targetVersion='" + this.targetVersion + "', upgradeUrl='" + this.upgradeUrl + "', hardwareversion='" + this.hardwareversion + "', sid='" + this.sid + "', updateSourceVersion='" + this.updateSourceVersion + "', targetUdsAddress='" + this.targetUdsAddress + "', sessionId='" + this.sessionId + "', rollbackTargetVersion='" + this.rollbackTargetVersion + "', partNo='" + this.partNo + "', releaseNote='" + this.releaseNote + "', rollbackFileDownloadAddr=" + this.rollbackFileDownloadAddr + "', preconditionList=" + Arrays.toString(this.preconditionList) + '}';
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
