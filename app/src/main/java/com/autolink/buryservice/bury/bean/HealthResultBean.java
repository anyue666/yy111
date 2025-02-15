package com.autolink.buryservice.bury.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class HealthResultBean implements Parcelable {
    public static final Parcelable.Creator<HealthResultBean> CREATOR = new Parcelable.Creator<HealthResultBean>() { // from class: com.autolink.buryservice.bury.bean.HealthResultBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HealthResultBean createFromParcel(Parcel parcel) {
            return new HealthResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HealthResultBean[] newArray(int i) {
            return new HealthResultBean[i];
        }
    };
    private int mAge;
    private int mBrate;
    private int mDPres;
    private String mEvent;
    private int mGend;
    private int mHVar;
    private int mHrate;
    private int mID;
    private int mSPres;
    private int mTall;
    private int mWeigh;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public HealthResultBean(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.mEvent = str;
        this.mHrate = i;
        this.mHVar = i3;
        this.mBrate = i2;
        this.mSPres = i4;
        this.mDPres = i5;
        this.mID = i6;
        this.mGend = i7;
        this.mAge = i8;
        this.mTall = i9;
        this.mWeigh = i10;
    }

    protected HealthResultBean(Parcel parcel) {
        this.mEvent = parcel.readString();
        this.mHrate = parcel.readInt();
        this.mHVar = parcel.readInt();
        this.mBrate = parcel.readInt();
        this.mSPres = parcel.readInt();
        this.mDPres = parcel.readInt();
        this.mID = parcel.readInt();
        this.mGend = parcel.readInt();
        this.mAge = parcel.readInt();
        this.mTall = parcel.readInt();
        this.mWeigh = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEvent);
        parcel.writeInt(this.mHrate);
        parcel.writeInt(this.mHVar);
        parcel.writeInt(this.mBrate);
        parcel.writeInt(this.mSPres);
        parcel.writeInt(this.mDPres);
        parcel.writeInt(this.mID);
        parcel.writeInt(this.mGend);
        parcel.writeInt(this.mAge);
        parcel.writeInt(this.mTall);
        parcel.writeInt(this.mWeigh);
    }

    public int getHrate() {
        return this.mHrate;
    }

    public void setHrate(int i) {
        this.mHrate = i;
    }

    public int getHVar() {
        return this.mHVar;
    }

    public void setHVar(int i) {
        this.mHVar = i;
    }

    public String getEvent() {
        return this.mEvent;
    }

    public void setEvent(String str) {
        this.mEvent = str;
    }

    public int getBrate() {
        return this.mBrate;
    }

    public void setBrate(int i) {
        this.mBrate = i;
    }

    public int getSPres() {
        return this.mSPres;
    }

    public void setSPres(int i) {
        this.mSPres = i;
    }

    public int getDPres() {
        return this.mDPres;
    }

    public void setDPres(int i) {
        this.mDPres = i;
    }

    public int getID() {
        return this.mID;
    }

    public void setID(int i) {
        this.mID = i;
    }

    public int getGend() {
        return this.mGend;
    }

    public void setGend(int i) {
        this.mGend = i;
    }

    public int getAge() {
        return this.mAge;
    }

    public void setAge(int i) {
        this.mAge = i;
    }

    public int getTall() {
        return this.mTall;
    }

    public void setTall(int i) {
        this.mTall = i;
    }

    public int getWeigh() {
        return this.mWeigh;
    }

    public void setWeigh(int i) {
        this.mWeigh = i;
    }

    public String toString() {
        return "HealthResultBean{mEvent='" + this.mEvent + "', mHrate=" + this.mHrate + ", mHVar=" + this.mHVar + ", mBrate=" + this.mBrate + ", mSPres=" + this.mSPres + ", mDPres=" + this.mDPres + ", mID=" + this.mID + ", mGend=" + this.mGend + ", mAge=" + this.mAge + ", mTall=" + this.mTall + ", mWeigh=" + this.mWeigh + '}';
    }
}
