package com.autolink.buryservice.bury.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class LocationGPSBean implements Parcelable {
    public static final Parcelable.Creator<LocationGPSBean> CREATOR = new Parcelable.Creator<LocationGPSBean>() { // from class: com.autolink.buryservice.bury.bean.LocationGPSBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationGPSBean createFromParcel(Parcel parcel) {
            return new LocationGPSBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationGPSBean[] newArray(int i) {
            return new LocationGPSBean[i];
        }
    };
    private int m4GNetwork;
    private String mEvent;
    private int mGpsNetwork;
    private String mGpsPositioning;
    private int mHeartLink;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationGPSBean(String str, int i, int i2, int i3, String str2) {
        this.mEvent = str;
        this.mGpsNetwork = i;
        this.mHeartLink = i2;
        this.m4GNetwork = i3;
        this.mGpsPositioning = str2;
    }

    protected LocationGPSBean(Parcel parcel) {
        this.mEvent = parcel.readString();
        this.mGpsNetwork = parcel.readInt();
        this.mHeartLink = parcel.readInt();
        this.m4GNetwork = parcel.readInt();
        this.mGpsPositioning = parcel.readString();
    }

    public String getEvent() {
        return this.mEvent;
    }

    public void setEvent(String str) {
        this.mEvent = str;
    }

    public int getGpsNetwork() {
        return this.mGpsNetwork;
    }

    public void setmGpsNetwork(int i) {
        this.mGpsNetwork = i;
    }

    public int getHeartLink() {
        return this.mHeartLink;
    }

    public void setHeartLink(int i) {
        this.mHeartLink = i;
    }

    public int get4GNetwork() {
        return this.m4GNetwork;
    }

    public void set4GNetwork(int i) {
        this.m4GNetwork = i;
    }

    public String getGpsPositioning() {
        return this.mGpsPositioning;
    }

    public void setGpsPositioning(String str) {
        this.mGpsPositioning = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEvent);
        parcel.writeInt(this.mGpsNetwork);
        parcel.writeInt(this.mHeartLink);
        parcel.writeInt(this.m4GNetwork);
        parcel.writeString(this.mGpsPositioning);
    }

    public String toString() {
        return "LocationGPSBean{mEvent='" + this.mEvent + "', mGpsNetwork=" + this.mGpsNetwork + ", mHeartLink=" + this.mHeartLink + ", m4GNetwork=" + this.m4GNetwork + ", mGpsPositioning='" + this.mGpsPositioning + "'}";
    }
}
