package com.autolink.adapterinterface.tbox2.ota;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TboxOtaSubNodeState implements Parcelable {
    private byte ackCode;
    private int ecuId;
    private String hardwareAfterVersion;
    private String hardwareBeforeVersion;
    private String sessionId;
    private String softwareAfterVersion;
    private String softwareBeforeVersion;
    private long taskId;
    private byte updateProgress;
    private byte updateRusult;
    private byte updateState;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<TboxOtaSubNodeState> CREATOR = new Parcelable.Creator<TboxOtaSubNodeState>() { // from class: com.autolink.adapterinterface.tbox2.ota.TboxOtaSubNodeState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxOtaSubNodeState createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            builder.setTaskId(parcel.readLong());
            builder.setEcuId(parcel.readInt());
            builder.setUpdateState(parcel.readByte());
            builder.setUpdateProgress(parcel.readByte());
            builder.setUpdateRusult(parcel.readByte());
            builder.setAckCode(parcel.readByte());
            if (parcel.readInt() == 1) {
                builder.setSessionId(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setHardwareBeforeVersion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setSoftwareBeforeVersion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setHardwareAfterVersion(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setSoftwareAfterVersion(parcel.readString());
            }
            return builder.build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxOtaSubNodeState[] newArray(int i) {
            return new TboxOtaSubNodeState[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxOtaSubNodeState(long j, String str, int i, byte b, byte b2, byte b3, byte b4, String str2, String str3, String str4, String str5) {
        this.taskId = j;
        this.sessionId = str;
        this.ecuId = i;
        this.updateState = b;
        this.updateProgress = b2;
        this.updateRusult = b3;
        this.ackCode = b4;
        this.hardwareBeforeVersion = str2;
        this.softwareBeforeVersion = str3;
        this.hardwareAfterVersion = str4;
        this.softwareAfterVersion = str5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.ecuId);
        parcel.writeByte(this.updateState);
        parcel.writeByte(this.updateProgress);
        parcel.writeByte(this.updateRusult);
        parcel.writeByte(this.ackCode);
        parcel.writeInt(this.sessionId == null ? 0 : 1);
        String str = this.sessionId;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.hardwareBeforeVersion == null ? 0 : 1);
        String str2 = this.hardwareBeforeVersion;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.softwareBeforeVersion == null ? 0 : 1);
        String str3 = this.softwareBeforeVersion;
        if (str3 != null) {
            parcel.writeString(str3);
        }
        parcel.writeInt(this.hardwareAfterVersion == null ? 0 : 1);
        String str4 = this.hardwareAfterVersion;
        if (str4 != null) {
            parcel.writeString(str4);
        }
        parcel.writeInt(this.softwareAfterVersion != null ? 1 : 0);
        String str5 = this.softwareAfterVersion;
        if (str5 != null) {
            parcel.writeString(str5);
        }
    }

    public static final class Builder {
        private byte mAckCode;
        private int mEcuId;
        private String mHardwareAfterVersion;
        private String mHardwareBeforeVersion;
        private String mSessionId;
        private String mSoftwareAfterVersion;
        private String mSoftwareBeforeVersion;
        private long mTaskId;
        private byte mUpdateProgress;
        private byte mUpdateRusult;
        private byte mUpdateState;

        public Builder setTaskId(long j) {
            this.mTaskId = j;
            return this;
        }

        public Builder setSessionId(String str) {
            this.mSessionId = str;
            return this;
        }

        public Builder setEcuId(int i) {
            this.mEcuId = i;
            return this;
        }

        public Builder setUpdateState(byte b) {
            this.mUpdateState = b;
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

        public Builder setAckCode(byte b) {
            this.mAckCode = b;
            return this;
        }

        public Builder setHardwareBeforeVersion(String str) {
            this.mHardwareBeforeVersion = str;
            return this;
        }

        public Builder setSoftwareBeforeVersion(String str) {
            this.mSoftwareBeforeVersion = str;
            return this;
        }

        public Builder setHardwareAfterVersion(String str) {
            this.mHardwareAfterVersion = str;
            return this;
        }

        public Builder setSoftwareAfterVersion(String str) {
            this.mSoftwareAfterVersion = str;
            return this;
        }

        public TboxOtaSubNodeState build() {
            return new TboxOtaSubNodeState(this.mTaskId, this.mSessionId, this.mEcuId, this.mUpdateState, this.mUpdateProgress, this.mUpdateRusult, this.mAckCode, this.mHardwareBeforeVersion, this.mSoftwareBeforeVersion, this.mHardwareAfterVersion, this.mSoftwareAfterVersion);
        }
    }

    public String toString() {
        return "TboxOtaSubNodeReq {taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", ecuId=" + this.ecuId + ", updateState=" + ((int) this.updateState) + ", updateProgress=" + ((int) this.updateProgress) + ", updateRusult=" + ((int) this.updateRusult) + ", ackCode=" + ((int) this.ackCode) + ", hardwareBeforeVersion=" + this.hardwareBeforeVersion + ", softwareBeforeVersion=" + this.softwareBeforeVersion + ", hardwareAfterVersion=" + this.hardwareAfterVersion + ", softwareAfterVersion=" + this.softwareAfterVersion + "}";
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getEcuId() {
        return this.ecuId;
    }

    public byte getUpdateState() {
        return this.updateState;
    }

    public byte getUpdateProgress() {
        return this.updateProgress;
    }

    public byte getUpdateRusult() {
        return this.updateRusult;
    }

    public byte getAckCode() {
        return this.ackCode;
    }

    public String getHardwareBeforeVersion() {
        return this.hardwareBeforeVersion;
    }

    public String getSoftwareBeforeVersion() {
        return this.softwareBeforeVersion;
    }

    public String getHardwareAfterVersion() {
        return this.hardwareAfterVersion;
    }

    public String getSoftwareAfterVersion() {
        return this.softwareAfterVersion;
    }
}
