package com.autolink.adapterinterface.tbox2.remote;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TboxEcuVersion implements Parcelable {
    public int ecuId;
    public String hardVer;
    public String softVer;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<TboxEcuVersion> CREATOR = new Parcelable.Creator<TboxEcuVersion>() { // from class: com.autolink.adapterinterface.tbox2.remote.TboxEcuVersion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxEcuVersion createFromParcel(Parcel parcel) {
            return new TboxEcuVersion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxEcuVersion[] newArray(int i) {
            return new TboxEcuVersion[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxEcuVersion(int i, String str, String str2) {
        this.ecuId = i;
        this.softVer = str;
        this.hardVer = str2;
    }

    protected TboxEcuVersion(Parcel parcel) {
        this.ecuId = parcel.readInt();
        this.softVer = parcel.readString();
        this.hardVer = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ecuId);
        parcel.writeString(this.softVer);
        parcel.writeString(this.hardVer);
    }

    public String toString() {
        return "TboxEcuVersion{ecuId=" + this.ecuId + ", softVer='" + this.softVer + "', hardVer='" + this.hardVer + "'}";
    }

    public int getEcuId() {
        return this.ecuId;
    }

    public void setEcuId(int i) {
        this.ecuId = i;
    }

    public String getSoftVer() {
        return this.softVer;
    }

    public void setSoftVer(String str) {
        this.softVer = str;
    }

    public String getHardVer() {
        return this.hardVer;
    }

    public void setHardVer(String str) {
        this.hardVer = str;
    }
}
