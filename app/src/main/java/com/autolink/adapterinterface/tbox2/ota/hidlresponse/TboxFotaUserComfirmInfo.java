package com.autolink.adapterinterface.tbox2.ota.hidlresponse;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class TboxFotaUserComfirmInfo implements Parcelable {
    public static final Parcelable.Creator<TboxFotaUserComfirmInfo> CREATOR = new Parcelable.Creator<TboxFotaUserComfirmInfo>() { // from class: com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxFotaUserComfirmInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxFotaUserComfirmInfo createFromParcel(Parcel parcel) {
            return new TboxFotaUserComfirmInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxFotaUserComfirmInfo[] newArray(int i) {
            return new TboxFotaUserComfirmInfo[i];
        }
    };
    public List<TboxUpdateEcuMessage> ecuMsgList;
    public byte ecuNum;
    public byte[] preconditionList;
    public String releaseNote;
    public String sessionId;
    public long taskId;
    public String userDisclaimer;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxFotaUserComfirmInfo(long j, String str, byte b, byte[] bArr, String str2, String str3, List<TboxUpdateEcuMessage> list) {
        this.taskId = j;
        this.sessionId = str;
        this.ecuNum = b;
        this.preconditionList = bArr;
        this.releaseNote = str2;
        this.userDisclaimer = str3;
        this.ecuMsgList = list;
    }

    protected TboxFotaUserComfirmInfo(Parcel parcel) {
        this.taskId = parcel.readLong();
        this.sessionId = parcel.readString();
        this.ecuNum = parcel.readByte();
        this.preconditionList = parcel.createByteArray();
        this.releaseNote = parcel.readString();
        this.userDisclaimer = parcel.readString();
        this.ecuMsgList = parcel.createTypedArrayList(TboxUpdateEcuMessage.CREATOR);
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public byte getEcuNum() {
        return this.ecuNum;
    }

    public void setEcuNum(byte b) {
        this.ecuNum = b;
    }

    public byte[] getPreconditionList() {
        return this.preconditionList;
    }

    public void setPreconditionList(byte[] bArr) {
        this.preconditionList = bArr;
    }

    public List<TboxUpdateEcuMessage> getEcuMsgList() {
        return this.ecuMsgList;
    }

    public void setEcuMsgList(List<TboxUpdateEcuMessage> list) {
        this.ecuMsgList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.taskId);
        parcel.writeString(this.sessionId);
        parcel.writeByte(this.ecuNum);
        parcel.writeByteArray(this.preconditionList);
        parcel.writeString(this.releaseNote);
        parcel.writeString(this.userDisclaimer);
        parcel.writeTypedList(this.ecuMsgList);
    }

    public String toString() {
        return "TboxFotaUserComfirmInfo{taskId=" + this.taskId + ", sessionId='" + this.sessionId + "', ecuNum=" + ((int) this.ecuNum) + ", preconditionList=" + Arrays.toString(this.preconditionList) + ", ecuMsgList=" + this.ecuMsgList + '}';
    }

    public static class TboxUpdateEcuMessage implements Parcelable {
        public static final Parcelable.Creator<TboxUpdateEcuMessage> CREATOR = new Parcelable.Creator<TboxUpdateEcuMessage>() { // from class: com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxFotaUserComfirmInfo.TboxUpdateEcuMessage.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TboxUpdateEcuMessage createFromParcel(Parcel parcel) {
                return new TboxUpdateEcuMessage(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TboxUpdateEcuMessage[] newArray(int i) {
                return new TboxUpdateEcuMessage[i];
            }
        };
        public String Part_No;
        public String ecuName;
        public int estimateUpgradeTime;
        public String releaseNote;
        public String targetVersion;
        public byte updateModel;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public TboxUpdateEcuMessage(byte b, String str, String str2, String str3, int i, String str4) {
            this.updateModel = b;
            this.targetVersion = str;
            this.Part_No = str2;
            this.releaseNote = str3;
            this.estimateUpgradeTime = i;
            this.ecuName = str4;
        }

        protected TboxUpdateEcuMessage(Parcel parcel) {
            this.updateModel = parcel.readByte();
            this.targetVersion = parcel.readString();
            this.Part_No = parcel.readString();
            this.releaseNote = parcel.readString();
            this.estimateUpgradeTime = parcel.readInt();
            this.ecuName = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte(this.updateModel);
            parcel.writeString(this.targetVersion);
            parcel.writeString(this.Part_No);
            parcel.writeString(this.releaseNote);
            parcel.writeInt(this.estimateUpgradeTime);
            parcel.writeString(this.ecuName);
        }

        public String toString() {
            return "TboxUpdateEcuMessage{updateModel=" + ((int) this.updateModel) + ", targetVersion='" + this.targetVersion + "', Part_No='" + this.Part_No + "', releaseNote='" + this.releaseNote + "', estimateUpgradeTime=" + this.estimateUpgradeTime + ", ecuName='" + this.ecuName + "'}";
        }

        public byte getUpdateModel() {
            return this.updateModel;
        }

        public void setUpdateModel(byte b) {
            this.updateModel = b;
        }

        public String getTargetVersion() {
            return this.targetVersion;
        }

        public void setTargetVersion(String str) {
            this.targetVersion = str;
        }

        public String getPart_No() {
            return this.Part_No;
        }

        public void setPart_No(String str) {
            this.Part_No = str;
        }

        public String getReleaseNote() {
            return this.releaseNote;
        }

        public void setReleaseNote(String str) {
            this.releaseNote = str;
        }

        public int getEstimateUpgradeTime() {
            return this.estimateUpgradeTime;
        }

        public void setEstimateUpgradeTime(int i) {
            this.estimateUpgradeTime = i;
        }

        public String getEcuName() {
            return this.ecuName;
        }

        public void setEcuName(String str) {
            this.ecuName = str;
        }
    }
}
