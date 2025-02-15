package com.autolink.adapterinterface.diag;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DiagListInfo implements Parcelable {
    public static final Parcelable.Creator<DiagListInfo> CREATOR = new Parcelable.Creator<DiagListInfo>() { // from class: com.autolink.adapterinterface.diag.DiagListInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiagListInfo createFromParcel(Parcel parcel) {
            return new DiagListInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiagListInfo[] newArray(int i) {
            return new DiagListInfo[i];
        }
    };
    private int[] dids;
    private int[] iodids;
    private int[] rids;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DiagListInfo() {
    }

    public DiagListInfo(int[] iArr, int[] iArr2, int[] iArr3) {
        this.dids = iArr;
        this.rids = iArr2;
        this.iodids = iArr3;
    }

    protected DiagListInfo(Parcel parcel) {
        this.dids = parcel.createIntArray();
        this.rids = parcel.createIntArray();
        this.iodids = parcel.createIntArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.dids);
        parcel.writeIntArray(this.rids);
        parcel.writeIntArray(this.iodids);
    }

    public int[] getDids() {
        return this.dids;
    }

    public void setDids(int[] iArr) {
        this.dids = iArr;
    }

    public int[] getRids() {
        return this.rids;
    }

    public void setRids(int[] iArr) {
        this.rids = iArr;
    }

    public int[] getIodids() {
        return this.iodids;
    }

    public void setIodids(int[] iArr) {
        this.iodids = iArr;
    }
}
