package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class FotaUserComfResp implements Parcelable {
    public static final Parcelable.Creator<FotaUserComfResp> CREATOR = new Parcelable.Creator<FotaUserComfResp>() { // from class: com.autolink.adapterinterface.FotaUserComfResp.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaUserComfResp createFromParcel(Parcel parcel) {
            return new FotaUserComfResp(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaUserComfResp[] newArray(int i) {
            return new FotaUserComfResp[i];
        }
    };
    public int confirmType;
    public long eventTime;
    public int orderTime;
    public String sessionId;
    public long taskId;
    public int uid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FotaUserComfResp() {
    }

    protected FotaUserComfResp(Parcel parcel) {
        this.uid = parcel.readInt();
        this.taskId = parcel.readLong();
        this.sessionId = parcel.readString();
        this.confirmType = parcel.readInt();
        this.orderTime = parcel.readInt();
        this.eventTime = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uid);
        parcel.writeLong(this.taskId);
        parcel.writeString(this.sessionId);
        parcel.writeInt(this.confirmType);
        parcel.writeInt(this.orderTime);
        parcel.writeLong(this.eventTime);
    }

    public void readFromParcel(Parcel parcel) {
        this.uid = parcel.readInt();
        this.taskId = parcel.readLong();
        this.sessionId = parcel.readString();
        this.confirmType = parcel.readInt();
        this.orderTime = parcel.readInt();
        this.eventTime = parcel.readLong();
    }

    public String toString() {
        return "FotaUserComfResp{uid=" + this.uid + ", taskId=" + this.taskId + ", sessionId='" + this.sessionId + "', confirmType=" + this.confirmType + ", orderTime=" + this.orderTime + ", eventTime=" + this.eventTime + '}';
    }
}
