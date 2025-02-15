package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class SubNodeEnter implements Parcelable {
    public static final Parcelable.Creator<SubNodeEnter> CREATOR = new Parcelable.Creator<SubNodeEnter>() { // from class: com.autolink.adapterinterface.SubNodeEnter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubNodeEnter createFromParcel(Parcel parcel) {
            return new SubNodeEnter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubNodeEnter[] newArray(int i) {
            return new SubNodeEnter[i];
        }
    };
    public int checkMethod;
    public String checkSumCode;
    public int ecuId;
    public String fileName;
    public long fileSize;
    public int model;
    public long taskId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SubNodeEnter() {
    }

    protected SubNodeEnter(Parcel parcel) {
        this.model = parcel.readInt();
        this.ecuId = parcel.readInt();
        this.checkMethod = parcel.readInt();
        this.taskId = parcel.readLong();
        this.fileSize = parcel.readLong();
        this.fileName = parcel.readString();
        this.checkSumCode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.model);
        parcel.writeInt(this.ecuId);
        parcel.writeInt(this.checkMethod);
        parcel.writeLong(this.taskId);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.fileName);
        parcel.writeString(this.checkSumCode);
    }

    public void readFromParcel(Parcel parcel) {
        this.model = parcel.readInt();
        this.ecuId = parcel.readInt();
        this.checkMethod = parcel.readInt();
        this.taskId = parcel.readLong();
        this.fileSize = parcel.readLong();
        this.fileName = parcel.readString();
        this.checkSumCode = parcel.readString();
    }

    public String toString() {
        return "SubNodeEnter{model=" + this.model + ", ecuId=" + this.ecuId + ", checkMethod=" + this.checkMethod + ", taskId=" + this.taskId + ", fileSize=" + this.fileSize + ", fileName='" + this.fileName + "', checkSumCode='" + this.checkSumCode + "'}";
    }
}
