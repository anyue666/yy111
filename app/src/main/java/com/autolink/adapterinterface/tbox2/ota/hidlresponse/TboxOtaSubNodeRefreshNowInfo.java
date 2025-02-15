package com.autolink.adapterinterface.tbox2.ota.hidlresponse;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TboxOtaSubNodeRefreshNowInfo implements Parcelable {
    private int estimateUpgradeTime;
    private String sessionId;
    private long taskId;
    private byte updateModel;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<TboxOtaSubNodeRefreshNowInfo> CREATOR = new Parcelable.Creator<TboxOtaSubNodeRefreshNowInfo>() { // from class: com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxOtaSubNodeRefreshNowInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxOtaSubNodeRefreshNowInfo createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            builder.setUpdateModel(parcel.readByte());
            builder.setEstimateUpgradeTime(parcel.readInt());
            builder.setTaskId(parcel.readLong());
            if (parcel.readInt() == 1) {
                builder.setSessionId(parcel.readString());
            }
            return builder.build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxOtaSubNodeRefreshNowInfo[] newArray(int i) {
            return new TboxOtaSubNodeRefreshNowInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxOtaSubNodeRefreshNowInfo(byte b, long j, String str, int i) {
        this.updateModel = b;
        this.taskId = j;
        this.sessionId = str;
        this.estimateUpgradeTime = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.updateModel);
        parcel.writeInt(this.estimateUpgradeTime);
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.sessionId == null ? 0 : 1);
        String str = this.sessionId;
        if (str != null) {
            parcel.writeString(str);
        }
    }

    public static final class Builder {
        private int mEstimateUpgradeTime;
        private String mSessionId;
        private long mTaskId;
        private byte mUpdateModel;

        public Builder setUpdateModel(byte b) {
            this.mUpdateModel = b;
            return this;
        }

        public Builder setTaskId(long j) {
            this.mTaskId = j;
            return this;
        }

        public Builder setSessionId(String str) {
            this.mSessionId = str;
            return this;
        }

        public Builder setEstimateUpgradeTime(int i) {
            this.mEstimateUpgradeTime = i;
            return this;
        }

        public TboxOtaSubNodeRefreshNowInfo build() {
            return new TboxOtaSubNodeRefreshNowInfo(this.mUpdateModel, this.mTaskId, this.mSessionId, this.mEstimateUpgradeTime);
        }
    }

    public String toString() {
        return "TboxFotaUserComfirm {updateModel=" + ((int) this.updateModel) + ", taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", estimateUpgradeTime=" + this.estimateUpgradeTime + "}";
    }

    public byte getUpdateModel() {
        return this.updateModel;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getEstimateUpgradeTime() {
        return this.estimateUpgradeTime;
    }
}
