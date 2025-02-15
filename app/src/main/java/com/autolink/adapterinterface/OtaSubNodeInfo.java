package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class OtaSubNodeInfo implements Parcelable {
    public static final Parcelable.Creator<OtaSubNodeInfo> CREATOR = new Parcelable.Creator<OtaSubNodeInfo>() { // from class: com.autolink.adapterinterface.OtaSubNodeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OtaSubNodeInfo createFromParcel(Parcel parcel) {
            return new OtaSubNodeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OtaSubNodeInfo[] newArray(int i) {
            return new OtaSubNodeInfo[i];
        }
    };
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OtaSubNodeInfo() {
    }

    protected OtaSubNodeInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.updateModel = parcel.readInt();
        this.checkmethod = parcel.readInt();
        this.forceUpdate = parcel.readInt();
        this.fileType = parcel.readInt();
        this.fileSize = parcel.readLong();
        this.diffType = parcel.readInt();
        this.taskId = parcel.readLong();
        this.otaModel = parcel.readInt();
        this.estimateUpgradeTime = parcel.readInt();
        this.ecuId = parcel.readInt();
        this.needUploadLog = parcel.readInt();
        this.checkSumCode = parcel.readString();
        this.apnName = parcel.readString();
        this.targetVersion = parcel.readString();
        this.upgradeUrl = parcel.readString();
        this.hardwareversion = parcel.readString();
        this.sid = parcel.readString();
        this.updateSourceVersion = parcel.readString();
        this.targetUdsAddress = parcel.readString();
        this.sessionId = parcel.readString();
        this.rollbackTargetVersion = parcel.readString();
        this.partNo = parcel.readString();
        this.releaseNote = parcel.readString();
        this.rollbackFileDownloadAddr = parcel.readString();
        this.preconditionList = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.updateModel);
        parcel.writeInt(this.checkmethod);
        parcel.writeInt(this.forceUpdate);
        parcel.writeInt(this.fileType);
        parcel.writeInt(this.diffType);
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.otaModel);
        parcel.writeInt(this.estimateUpgradeTime);
        parcel.writeInt(this.ecuId);
        parcel.writeInt(this.needUploadLog);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.targetVersion);
        parcel.writeString(this.upgradeUrl);
        parcel.writeString(this.checkSumCode);
        parcel.writeString(this.apnName);
        parcel.writeString(this.hardwareversion);
        parcel.writeString(this.sid);
        parcel.writeString(this.updateSourceVersion);
        parcel.writeString(this.targetUdsAddress);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.rollbackTargetVersion);
        parcel.writeString(this.partNo);
        parcel.writeString(this.releaseNote);
        parcel.writeString(this.rollbackFileDownloadAddr);
        parcel.writeByteArray(this.preconditionList);
    }

    public String toString() {
        return "OtaSubNodeInfo{updateModel=" + this.updateModel + ", checkmethod=" + this.checkmethod + ", forceUpdate=" + this.forceUpdate + ", fileType=" + this.fileType + ", diffType=" + this.diffType + ", taskId=" + this.taskId + ", otaModel=" + this.otaModel + ", estimateUpgradeTime=" + this.estimateUpgradeTime + ", ecuId=" + this.ecuId + ", needUploadLog=" + this.needUploadLog + ", fileSize=" + this.fileSize + ", checkSumCode='" + this.checkSumCode + "', apnName='" + this.apnName + "', targetVersion='" + this.targetVersion + "', upgradeUrl='" + this.upgradeUrl + "', hardwareversion='" + this.hardwareversion + "', sid='" + this.sid + "', updateSourceVersion='" + this.updateSourceVersion + "', targetUdsAddress='" + this.targetUdsAddress + "', sessionId='" + this.sessionId + "', rollbackTargetVersion='" + this.rollbackTargetVersion + "', partNo='" + this.partNo + "', releaseNote='" + this.releaseNote + "', rollbackFileDownloadAddr=" + this.rollbackFileDownloadAddr + "', preconditionList=" + Arrays.toString(this.preconditionList) + '}';
    }
}
