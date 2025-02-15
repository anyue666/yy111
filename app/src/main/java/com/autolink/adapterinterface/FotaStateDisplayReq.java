package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class FotaStateDisplayReq implements Parcelable {
    public static final Parcelable.Creator<FotaStateDisplayReq> CREATOR = new Parcelable.Creator<FotaStateDisplayReq>() { // from class: com.autolink.adapterinterface.FotaStateDisplayReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaStateDisplayReq createFromParcel(Parcel parcel) {
            return new FotaStateDisplayReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaStateDisplayReq[] newArray(int i) {
            return new FotaStateDisplayReq[i];
        }
    };
    public int ackCode;
    public String afterVersion;
    public String beforeVersion;
    public int ecuId;
    public String ecuName;
    public long taskId;
    public int updateModel;
    public int updateProgress;
    public int updateResult;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FotaStateDisplayReq() {
    }

    protected FotaStateDisplayReq(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.updateModel = parcel.readInt();
        this.ecuId = parcel.readInt();
        this.updateProgress = parcel.readInt();
        this.updateResult = parcel.readInt();
        this.ackCode = parcel.readInt();
        this.taskId = parcel.readLong();
        this.beforeVersion = parcel.readString();
        this.afterVersion = parcel.readString();
        this.ecuName = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.updateModel);
        parcel.writeInt(this.ecuId);
        parcel.writeInt(this.updateProgress);
        parcel.writeInt(this.updateResult);
        parcel.writeInt(this.ackCode);
        parcel.writeLong(this.taskId);
        parcel.writeString(this.beforeVersion);
        parcel.writeString(this.afterVersion);
        parcel.writeString(this.ecuName);
    }

    public String toString() {
        return "FotaStateDisplayReq{updateModel=" + this.updateModel + ", ecuId=" + this.ecuId + ", updateProgress=" + this.updateProgress + ", updateResult=" + this.updateResult + ", ackCode=" + this.ackCode + ", taskId=" + this.taskId + ", beforeVersion='" + this.beforeVersion + "', afterVersion='" + this.afterVersion + "', ecuName='" + this.ecuName + "'}";
    }
}
