package com.autolink.adapterinterface.tbox2.ota;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TboxFotaUserComfirm implements Parcelable {
    private int confirmType;
    private long eventTime;
    private int orderTime;
    private String sessionId;
    private long taskId;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<TboxFotaUserComfirm> CREATOR = new Parcelable.Creator<TboxFotaUserComfirm>() { // from class: com.autolink.adapterinterface.tbox2.ota.TboxFotaUserComfirm.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxFotaUserComfirm createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            builder.setTaskId(parcel.readLong());
            builder.setConfirmType(parcel.readInt());
            builder.setOrderTime(parcel.readInt());
            builder.setEventTime(parcel.readLong());
            if (parcel.readInt() == 1) {
                builder.setSessionId(parcel.readString());
            }
            return builder.build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxFotaUserComfirm[] newArray(int i) {
            return new TboxFotaUserComfirm[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxFotaUserComfirm(long j, String str, int i, int i2, long j2) {
        this.taskId = j;
        if (str == null) {
            this.sessionId = "";
        } else {
            this.sessionId = str;
        }
        this.confirmType = i;
        this.orderTime = i2;
        this.eventTime = j2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.confirmType);
        parcel.writeInt(this.orderTime);
        parcel.writeLong(this.eventTime);
        parcel.writeInt(this.sessionId == null ? 0 : 1);
        String str = this.sessionId;
        if (str != null) {
            parcel.writeString(str);
        }
    }

    public static final class Builder {
        private int mConfirmType;
        private long mEventTime;
        private int mOrderTime;
        private String mSessionId;
        private long mTaskId;

        public Builder setTaskId(long j) {
            this.mTaskId = j;
            return this;
        }

        public Builder setSessionId(String str) {
            if (str == null) {
                this.mSessionId = "";
            } else {
                this.mSessionId = str;
            }
            return this;
        }

        public Builder setConfirmType(int i) {
            this.mConfirmType = i;
            return this;
        }

        public Builder setOrderTime(int i) {
            this.mOrderTime = i;
            return this;
        }

        public Builder setEventTime(long j) {
            this.mEventTime = j;
            return this;
        }

        public TboxFotaUserComfirm build() {
            return new TboxFotaUserComfirm(this.mTaskId, this.mSessionId, this.mConfirmType, this.mOrderTime, this.mEventTime);
        }
    }

    public String toString() {
        return "TboxFotaUserComfirm {taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", confirmType=" + this.confirmType + ", orderTime=" + this.orderTime + ", eventTime=" + this.eventTime + "}";
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getConfirmType() {
        return this.confirmType;
    }

    public int getOrderTime() {
        return this.orderTime;
    }

    public long getEventTime() {
        return this.eventTime;
    }
}
