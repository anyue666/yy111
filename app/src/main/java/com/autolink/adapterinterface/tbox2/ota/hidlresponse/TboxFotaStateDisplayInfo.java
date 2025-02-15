package com.autolink.adapterinterface.tbox2.ota.hidlresponse;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TboxFotaStateDisplayInfo implements Parcelable {
    private int ackCode;
    private String afterUpgradeVersion;
    private String beforeUpgradeVersion;
    private int ecuId;
    private String ecuName;
    private byte[] preconditionList;
    private long taskId;
    private byte updateModel;
    private byte updateProgress;
    private byte updateRusult;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<TboxFotaStateDisplayInfo> CREATOR = new Parcelable.Creator<TboxFotaStateDisplayInfo>() { // from class: com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxFotaStateDisplayInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxFotaStateDisplayInfo createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            builder.setUpdateModel(parcel.readByte());
            builder.setUpdateProgress(parcel.readByte());
            builder.setUpdateRusult(parcel.readByte());
            builder.setAckCode(parcel.readByte());
            builder.setEcuId(parcel.readInt());
            builder.setTaskId(parcel.readLong());
            if (parcel.readInt() == 1) {
                builder.setEcuName(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setBeforeUpgradeVersion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setAfterUpgradeVersion(parcel.readString());
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
        public TboxFotaStateDisplayInfo[] newArray(int i) {
            return new TboxFotaStateDisplayInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxFotaStateDisplayInfo(byte b, byte b2, byte b3, int i, int i2, long j, String str, String str2, String str3, byte[] bArr) {
        this.updateModel = b;
        this.updateProgress = b2;
        this.updateRusult = b3;
        if (i < 0) {
            this.ackCode = i & 255;
        } else {
            this.ackCode = i;
        }
        this.ecuId = i2;
        this.taskId = j;
        this.ecuName = str;
        this.beforeUpgradeVersion = str2;
        this.afterUpgradeVersion = str3;
        this.preconditionList = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.updateModel);
        parcel.writeByte(this.updateProgress);
        parcel.writeByte(this.updateRusult);
        parcel.writeInt(this.ackCode);
        parcel.writeInt(this.ecuId);
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.ecuName == null ? 0 : 1);
        String str = this.ecuName;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.beforeUpgradeVersion == null ? 0 : 1);
        String str2 = this.beforeUpgradeVersion;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.afterUpgradeVersion == null ? 0 : 1);
        String str3 = this.afterUpgradeVersion;
        if (str3 != null) {
            parcel.writeString(str3);
        }
        parcel.writeInt(this.preconditionList != null ? 1 : 0);
        byte[] bArr = this.preconditionList;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.preconditionList);
        }
    }

    public static final class Builder {
        private int mAckCode;
        private String mAfterUpgradeVersion;
        private String mBeforeUpgradeVersion;
        private int mEcuId;
        private String mEcuName;
        private byte[] mPreconditionList;
        private long mTaskId;
        private byte mUpdateModel;
        private byte mUpdateProgress;
        private byte mUpdateRusult;

        public Builder setUpdateModel(byte b) {
            this.mUpdateModel = b;
            return this;
        }

        public Builder setUpdateProgress(byte b) {
            this.mUpdateProgress = b;
            return this;
        }

        public Builder setUpdateRusult(byte b) {
            this.mUpdateRusult = b;
            return this;
        }

        public Builder setAckCode(int i) {
            this.mAckCode = i;
            return this;
        }

        public Builder setEcuId(int i) {
            this.mEcuId = i;
            return this;
        }

        public Builder setTaskId(long j) {
            this.mTaskId = j;
            return this;
        }

        public Builder setEcuName(String str) {
            this.mEcuName = str;
            return this;
        }

        public Builder setBeforeUpgradeVersion(String str) {
            this.mBeforeUpgradeVersion = str;
            return this;
        }

        public Builder setAfterUpgradeVersion(String str) {
            this.mAfterUpgradeVersion = str;
            return this;
        }

        public Builder setPreconditionList(byte[] bArr) {
            this.mPreconditionList = bArr;
            return this;
        }

        public TboxFotaStateDisplayInfo build() {
            return new TboxFotaStateDisplayInfo(this.mUpdateModel, this.mUpdateProgress, this.mUpdateRusult, this.mAckCode, this.mEcuId, this.mTaskId, this.mEcuName, this.mBeforeUpgradeVersion, this.mAfterUpgradeVersion, this.mPreconditionList);
        }
    }

    public String toString() {
        return "TboxFotaStateDisplayInfo {updateModel=" + ((int) this.updateModel) + ", updateProgress=" + ((int) this.updateProgress) + ", updateRusult=" + ((int) this.updateRusult) + ", ackCode=" + this.ackCode + ", ecuId=" + this.ecuId + ", taskId=" + this.taskId + ", ecuName=" + this.ecuName + ", beforeUpgradeVersion=" + this.beforeUpgradeVersion + ", afterUpgradeVersion=" + this.afterUpgradeVersion + ", preconditionList=" + this.preconditionList + "}";
    }

    public byte getUpdateModel() {
        return this.updateModel;
    }

    public byte getUpdateProgress() {
        return this.updateProgress;
    }

    public byte getUpdateRusult() {
        return this.updateRusult;
    }

    public int getAckCode() {
        return this.ackCode;
    }

    public int getEcuId() {
        return this.ecuId;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getEcuName() {
        return this.ecuName;
    }

    public String getBeforeUpgradeVersion() {
        return this.beforeUpgradeVersion;
    }

    public String getAfterUpgradeVersion() {
        return this.afterUpgradeVersion;
    }

    public byte[] getPreconditionList() {
        return this.preconditionList;
    }
}
