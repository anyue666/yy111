package com.autolink.hmi.crosscountry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class LocationBean implements Parcelable {
    public static final Parcelable.Creator<LocationBean> CREATOR = new Parcelable.Creator<LocationBean>() { // from class: com.autolink.hmi.crosscountry.bean.LocationBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationBean createFromParcel(Parcel parcel) {
            return new LocationBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationBean[] newArray(int i) {
            return new LocationBean[i];
        }
    };
    private String country;
    private String name;
    private String path;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    protected LocationBean(Parcel parcel) {
        this.country = parcel.readString();
        this.path = parcel.readString();
        this.name = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.country);
        parcel.writeString(this.path);
        parcel.writeString(this.name);
    }
}
