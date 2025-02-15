package com.autolink.buryservice.bury.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CarUpdateBean implements Parcelable {
    public static final Parcelable.Creator<CarUpdateBean> CREATOR = new Parcelable.Creator<CarUpdateBean>() { // from class: com.autolink.buryservice.bury.bean.CarUpdateBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarUpdateBean createFromParcel(Parcel parcel) {
            return new CarUpdateBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarUpdateBean[] newArray(int i) {
            return new CarUpdateBean[i];
        }
    };
    private int mAway;
    private String mEvent;
    private int mMod;
    private String mUpBefore;
    private String mUpBehind;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CarUpdateBean(String str, int i, int i2, String str2, String str3) {
        this.mEvent = str;
        this.mAway = i;
        this.mMod = i2;
        this.mUpBefore = str2;
        this.mUpBehind = str3;
    }

    protected CarUpdateBean(Parcel parcel) {
        this.mEvent = parcel.readString();
        this.mAway = parcel.readInt();
        this.mMod = parcel.readInt();
        this.mUpBefore = parcel.readString();
        this.mUpBehind = parcel.readString();
    }

    public String getEvent() {
        return this.mEvent;
    }

    public void setEvent(String str) {
        this.mEvent = str;
    }

    public int getAway() {
        return this.mAway;
    }

    public void setAway(int i) {
        this.mAway = i;
    }

    public int getMod() {
        return this.mMod;
    }

    public void setMod(int i) {
        this.mMod = i;
    }

    public String getUpBefore() {
        return this.mUpBefore;
    }

    public void setUpBefore(String str) {
        this.mUpBefore = str;
    }

    public String getUpBehind() {
        return this.mUpBehind;
    }

    public void setUpBehind(String str) {
        this.mUpBehind = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEvent);
        parcel.writeInt(this.mAway);
        parcel.writeInt(this.mMod);
        parcel.writeString(this.mUpBefore);
        parcel.writeString(this.mUpBehind);
    }

    public String toString() {
        return "CarUpdateBean{mEvent='" + this.mEvent + "', mAway=" + this.mAway + ", mMod=" + this.mMod + ", mUpBefore='" + this.mUpBefore + "', mUpBehind='" + this.mUpBehind + "'}";
    }
}
