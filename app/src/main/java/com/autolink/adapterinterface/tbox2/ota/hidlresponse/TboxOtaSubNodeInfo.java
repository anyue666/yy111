package com.autolink.adapterinterface.tbox2.ota.hidlresponse;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TboxOtaSubNodeInfo implements Parcelable {
    private String apnName;
    private String checkSumCode;
    private byte checkmethod;
    private byte diffType;
    private int ecuId;
    private int estimateUpgradeTime;
    private long fileSize;
    private byte fileType;
    private byte forceUpdate;
    private String hardwareversion;
    private byte needUploadLog;
    private byte otaModel;
    private String partNo;
    private byte[] preconditionList;
    private String releaseNote;
    private String rollbackFileDownloadAddr;
    private String rollbackTargetVersion;
    private String sessionId;
    private String sid;
    private String targetUdsAddress;
    private String targetVersion;
    private long taskId;
    private byte updateModel;
    private String updateSourceVersion;
    private String upgradeUrl;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<TboxOtaSubNodeInfo> CREATOR = new Parcelable.Creator<TboxOtaSubNodeInfo>() { // from class: com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxOtaSubNodeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxOtaSubNodeInfo createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            builder.setUpdateModel(parcel.readByte());
            builder.setCheckmethod(parcel.readByte());
            builder.setForceUpdate(parcel.readByte());
            builder.setFileType(parcel.readByte());
            builder.setDiffType(parcel.readByte());
            builder.setOtaModel(parcel.readByte());
            builder.setNeedUploadLog(parcel.readByte());
            builder.setEstimateUpgradeTime(parcel.readInt());
            builder.setEcuId(parcel.readInt());
            builder.setFileSize(parcel.readLong());
            builder.setTaskId(parcel.readLong());
            if (parcel.readInt() == 1) {
                builder.setTargetVersion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setUpgradeUrl(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setApnName(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setHardwareversion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setSid(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setUpdateSourceVersion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setTargetUdsAddress(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setSessionId(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setRollbackTargetVersion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setRollbackFileDownloadAddr(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setPartNo(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setReleaseNote(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setCheckSumCode(parcel.readString());
            }
            if (parcel.readInt() == 0) {
                builder.setPreconditionList(null);
            } else {
                byte[] bArr = new byte[parcel.readInt()];
                parcel.readByteArray(bArr);
                builder.setPreconditionList(bArr);
            }
            return builder.build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxOtaSubNodeInfo[] newArray(int i) {
            return new TboxOtaSubNodeInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.updateModel);
        parcel.writeByte(this.checkmethod);
        parcel.writeByte(this.forceUpdate);
        parcel.writeByte(this.fileType);
        parcel.writeByte(this.diffType);
        parcel.writeByte(this.otaModel);
        parcel.writeByte(this.needUploadLog);
        parcel.writeInt(this.estimateUpgradeTime);
        parcel.writeInt(this.ecuId);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.targetVersion == null ? 0 : 1);
        String str = this.targetVersion;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.upgradeUrl == null ? 0 : 1);
        String str2 = this.upgradeUrl;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.apnName == null ? 0 : 1);
        String str3 = this.apnName;
        if (str3 != null) {
            parcel.writeString(str3);
        }
        parcel.writeInt(this.hardwareversion == null ? 0 : 1);
        String str4 = this.hardwareversion;
        if (str4 != null) {
            parcel.writeString(str4);
        }
        parcel.writeInt(this.sid == null ? 0 : 1);
        String str5 = this.sid;
        if (str5 != null) {
            parcel.writeString(str5);
        }
        parcel.writeInt(this.updateSourceVersion == null ? 0 : 1);
        String str6 = this.updateSourceVersion;
        if (str6 != null) {
            parcel.writeString(str6);
        }
        parcel.writeInt(this.targetUdsAddress == null ? 0 : 1);
        String str7 = this.targetUdsAddress;
        if (str7 != null) {
            parcel.writeString(str7);
        }
        parcel.writeInt(this.sessionId == null ? 0 : 1);
        String str8 = this.sessionId;
        if (str8 != null) {
            parcel.writeString(str8);
        }
        parcel.writeInt(this.rollbackTargetVersion == null ? 0 : 1);
        String str9 = this.rollbackTargetVersion;
        if (str9 != null) {
            parcel.writeString(str9);
        }
        parcel.writeInt(this.rollbackFileDownloadAddr == null ? 0 : 1);
        String str10 = this.rollbackFileDownloadAddr;
        if (str10 != null) {
            parcel.writeString(str10);
        }
        parcel.writeInt(this.partNo == null ? 0 : 1);
        String str11 = this.partNo;
        if (str11 != null) {
            parcel.writeString(str11);
        }
        parcel.writeInt(this.releaseNote == null ? 0 : 1);
        String str12 = this.releaseNote;
        if (str12 != null) {
            parcel.writeString(str12);
        }
        parcel.writeInt(this.checkSumCode == null ? 0 : 1);
        String str13 = this.checkSumCode;
        if (str13 != null) {
            parcel.writeString(str13);
        }
        parcel.writeInt(this.preconditionList != null ? 1 : 0);
        byte[] bArr = this.preconditionList;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.preconditionList);
        }
    }

    public static final class Builder {
        private String mApnName;
        private String mCheckSumCode;
        private byte mCheckmethod;
        private byte mDiffType;
        private int mEcuId;
        private int mEstimateUpgradeTime;
        private long mFileSize;
        private byte mFileType;
        private byte mForceUpdate;
        private String mHardwareversion;
        private byte mNeedUploadLog;
        private byte mOtaModel;
        private String mPartNo;
        private byte[] mPreconditionList;
        private String mReleaseNote;
        private String mRollbackFileDownloadAddr;
        private String mRollbackTargetVersion;
        private String mSessionId;
        private String mSid;
        private String mTargetUdsAddress;
        private String mTargetVersion;
        private long mTaskId;
        private byte mUpdateModel;
        private String mUpdateSourceVersion;
        private String mUpgradeUrl;

        public Builder setUpdateModel(byte b) {
            this.mUpdateModel = b;
            return this;
        }

        public Builder setCheckmethod(byte b) {
            this.mCheckmethod = b;
            return this;
        }

        public Builder setForceUpdate(byte b) {
            this.mForceUpdate = b;
            return this;
        }

        public Builder setFileType(byte b) {
            this.mFileType = b;
            return this;
        }

        public Builder setDiffType(byte b) {
            this.mDiffType = b;
            return this;
        }

        public Builder setOtaModel(byte b) {
            this.mOtaModel = b;
            return this;
        }

        public Builder setNeedUploadLog(byte b) {
            this.mNeedUploadLog = b;
            return this;
        }

        public Builder setEstimateUpgradeTime(int i) {
            this.mEstimateUpgradeTime = i;
            return this;
        }

        public Builder setEcuId(int i) {
            this.mEcuId = i;
            return this;
        }

        public Builder setFileSize(long j) {
            this.mFileSize = j;
            return this;
        }

        public Builder setTaskId(long j) {
            this.mTaskId = j;
            return this;
        }

        public Builder setTargetVersion(String str) {
            this.mTargetVersion = str;
            return this;
        }

        public Builder setUpgradeUrl(String str) {
            this.mUpgradeUrl = str;
            return this;
        }

        public Builder setApnName(String str) {
            this.mApnName = str;
            return this;
        }

        public Builder setHardwareversion(String str) {
            this.mHardwareversion = str;
            return this;
        }

        public Builder setSid(String str) {
            this.mSid = str;
            return this;
        }

        public Builder setUpdateSourceVersion(String str) {
            this.mUpdateSourceVersion = str;
            return this;
        }

        public Builder setTargetUdsAddress(String str) {
            this.mTargetUdsAddress = str;
            return this;
        }

        public Builder setSessionId(String str) {
            this.mSessionId = str;
            return this;
        }

        public Builder setRollbackTargetVersion(String str) {
            this.mRollbackTargetVersion = str;
            return this;
        }

        public Builder setRollbackFileDownloadAddr(String str) {
            this.mRollbackFileDownloadAddr = str;
            return this;
        }

        public Builder setPartNo(String str) {
            this.mPartNo = str;
            return this;
        }

        public Builder setReleaseNote(String str) {
            this.mReleaseNote = str;
            return this;
        }

        public Builder setCheckSumCode(String str) {
            this.mCheckSumCode = str;
            return this;
        }

        public Builder setPreconditionList(byte[] bArr) {
            this.mPreconditionList = bArr;
            return this;
        }

        public TboxOtaSubNodeInfo build() {
            TboxOtaSubNodeInfo tboxOtaSubNodeInfo = new TboxOtaSubNodeInfo();
            tboxOtaSubNodeInfo.setUpdateModel(this.mUpdateModel);
            tboxOtaSubNodeInfo.setCheckmethod(this.mCheckmethod);
            tboxOtaSubNodeInfo.setForceUpdate(this.mForceUpdate);
            tboxOtaSubNodeInfo.setFileType(this.mFileType);
            tboxOtaSubNodeInfo.setDiffType(this.mDiffType);
            tboxOtaSubNodeInfo.setOtaModel(this.mOtaModel);
            tboxOtaSubNodeInfo.setNeedUploadLog(this.mNeedUploadLog);
            tboxOtaSubNodeInfo.setEstimateUpgradeTime(this.mEstimateUpgradeTime);
            tboxOtaSubNodeInfo.setEcuId(this.mEcuId);
            tboxOtaSubNodeInfo.setFileSize(this.mFileSize);
            tboxOtaSubNodeInfo.setTaskId(this.mTaskId);
            tboxOtaSubNodeInfo.setTargetVersion(this.mTargetVersion);
            tboxOtaSubNodeInfo.setUpgradeUrl(this.mUpgradeUrl);
            tboxOtaSubNodeInfo.setApnName(this.mApnName);
            tboxOtaSubNodeInfo.setHardwareversion(this.mHardwareversion);
            tboxOtaSubNodeInfo.setSid(this.mSid);
            tboxOtaSubNodeInfo.setUpdateSourceVersion(this.mUpdateSourceVersion);
            tboxOtaSubNodeInfo.setTargetUdsAddress(this.mTargetUdsAddress);
            tboxOtaSubNodeInfo.setSessionId(this.mSessionId);
            tboxOtaSubNodeInfo.setRollbackTargetVersion(this.mRollbackTargetVersion);
            tboxOtaSubNodeInfo.setRollbackFileDownloadAddr(this.mRollbackFileDownloadAddr);
            tboxOtaSubNodeInfo.setPartNo(this.mPartNo);
            tboxOtaSubNodeInfo.setReleaseNote(this.mReleaseNote);
            tboxOtaSubNodeInfo.setCheckSumCode(this.mCheckSumCode);
            tboxOtaSubNodeInfo.setPreconditionList(this.mPreconditionList);
            return tboxOtaSubNodeInfo;
        }
    }

    public String toString() {
        return "TboxFotaUserComfirm {updateModel=" + ((int) this.updateModel) + ", checkmethod=" + ((int) this.checkmethod) + ", forceUpdate=" + ((int) this.forceUpdate) + ", fileType=" + ((int) this.fileType) + ", diffType=" + ((int) this.diffType) + ", otaModel=" + ((int) this.otaModel) + ", needUploadLog=" + ((int) this.needUploadLog) + ", estimateUpgradeTime=" + this.estimateUpgradeTime + ", ecuId=" + this.ecuId + ", fileSize=" + this.fileSize + ", taskId=" + this.taskId + ", targetVersion=" + this.targetVersion + ", upgradeUrl=" + this.upgradeUrl + ", apnName=" + this.apnName + ", hardwareversion=" + this.hardwareversion + ", sid=" + this.sid + ", updateSourceVersion=" + this.updateSourceVersion + ", targetUdsAddress=" + this.targetUdsAddress + ", sessionId=" + this.sessionId + ", rollbackTargetVersion=" + this.rollbackTargetVersion + ", rollbackFileDownloadAddr=" + this.rollbackFileDownloadAddr + ", partNo=" + this.partNo + ", releaseNote=" + this.releaseNote + ", checkSumCode=" + this.checkSumCode + ", preconditionList=" + this.preconditionList + "}";
    }

    public byte getUpdateModel() {
        return this.updateModel;
    }

    public void setUpdateModel(byte b) {
        this.updateModel = b;
    }

    public byte getCheckmethod() {
        return this.checkmethod;
    }

    public void setCheckmethod(byte b) {
        this.checkmethod = b;
    }

    public byte getForceUpdate() {
        return this.forceUpdate;
    }

    public void setForceUpdate(byte b) {
        this.forceUpdate = b;
    }

    public byte getFileType() {
        return this.fileType;
    }

    public void setFileType(byte b) {
        this.fileType = b;
    }

    public byte getDiffType() {
        return this.diffType;
    }

    public void setDiffType(byte b) {
        this.diffType = b;
    }

    public byte getOtaModel() {
        return this.otaModel;
    }

    public void setOtaModel(byte b) {
        this.otaModel = b;
    }

    public byte getNeedUploadLog() {
        return this.needUploadLog;
    }

    public void setNeedUploadLog(byte b) {
        this.needUploadLog = b;
    }

    public int getEstimateUpgradeTime() {
        return this.estimateUpgradeTime;
    }

    public void setEstimateUpgradeTime(int i) {
        this.estimateUpgradeTime = i;
    }

    public int getEcuId() {
        return this.ecuId;
    }

    public void setEcuId(int i) {
        this.ecuId = i;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public String getTargetVersion() {
        return this.targetVersion;
    }

    public void setTargetVersion(String str) {
        this.targetVersion = str;
    }

    public String getUpgradeUrl() {
        return this.upgradeUrl;
    }

    public void setUpgradeUrl(String str) {
        this.upgradeUrl = str;
    }

    public String getApnName() {
        return this.apnName;
    }

    public void setApnName(String str) {
        this.apnName = str;
    }

    public String getHardwareversion() {
        return this.hardwareversion;
    }

    public void setHardwareversion(String str) {
        this.hardwareversion = str;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public String getUpdateSourceVersion() {
        return this.updateSourceVersion;
    }

    public void setUpdateSourceVersion(String str) {
        this.updateSourceVersion = str;
    }

    public String getTargetUdsAddress() {
        return this.targetUdsAddress;
    }

    public void setTargetUdsAddress(String str) {
        this.targetUdsAddress = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getRollbackTargetVersion() {
        return this.rollbackTargetVersion;
    }

    public void setRollbackTargetVersion(String str) {
        this.rollbackTargetVersion = str;
    }

    public String getRollbackFileDownloadAddr() {
        return this.rollbackFileDownloadAddr;
    }

    public void setRollbackFileDownloadAddr(String str) {
        this.rollbackFileDownloadAddr = str;
    }

    public String getPartNo() {
        return this.partNo;
    }

    public void setPartNo(String str) {
        this.partNo = str;
    }

    public String getReleaseNote() {
        return this.releaseNote;
    }

    public void setReleaseNote(String str) {
        this.releaseNote = str;
    }

    public String getCheckSumCode() {
        return this.checkSumCode;
    }

    public void setCheckSumCode(String str) {
        this.checkSumCode = str;
    }

    public byte[] getPreconditionList() {
        return this.preconditionList;
    }

    public void setPreconditionList(byte[] bArr) {
        this.preconditionList = bArr;
    }
}
