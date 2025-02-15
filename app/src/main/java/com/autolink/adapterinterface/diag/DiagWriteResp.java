package com.autolink.adapterinterface.diag;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DiagWriteResp implements Parcelable {
    public static final Parcelable.Creator<DiagWriteResp> CREATOR = new Parcelable.Creator<DiagWriteResp>() { // from class: com.autolink.adapterinterface.diag.DiagWriteResp.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiagWriteResp createFromParcel(Parcel parcel) {
            return new DiagWriteResp(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiagWriteResp[] newArray(int i) {
            return new DiagWriteResp[i];
        }
    };
    private short did;
    private int res;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DiagWriteResp() {
        this.did = (short) 0;
        this.res = 0;
    }

    public DiagWriteResp(short s, int i) {
        this.did = s;
        this.res = i;
    }

    protected DiagWriteResp(Parcel parcel) {
        this.did = (short) 0;
        this.res = 0;
        this.did = (short) parcel.readInt();
        this.res = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.did);
        parcel.writeInt(this.res);
    }

    public short getDid() {
        return this.did;
    }

    public void setDid(short s) {
        this.did = s;
    }

    public int getRes() {
        return this.res;
    }

    public void setRes(int i) {
        this.res = i;
    }

    public String toString() {
        return "DiagWriteResp{did=" + ((int) this.did) + ", res=" + this.res + '}';
    }
}
