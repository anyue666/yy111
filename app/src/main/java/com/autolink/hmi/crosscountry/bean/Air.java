package com.autolink.hmi.crosscountry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Air implements Parcelable {
    public static final Parcelable.Creator<Air> CREATOR = new Parcelable.Creator<Air>() { // from class: com.autolink.hmi.crosscountry.bean.Air.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Air createFromParcel(Parcel parcel) {
            return new Air(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Air[] newArray(int i) {
            return new Air[i];
        }
    };
    int aqi;
    float co;
    int no2;
    int o3;
    int pm10;
    int pm25;
    String primaryPollutant;
    String quality;
    int so2;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getNo2() {
        return this.no2;
    }

    public void setNo2(int i) {
        this.no2 = i;
    }

    public int getPm25() {
        return this.pm25;
    }

    public void setPm25(int i) {
        this.pm25 = i;
    }

    public int getO3() {
        return this.o3;
    }

    public void setO3(int i) {
        this.o3 = i;
    }

    public int getSo2() {
        return this.so2;
    }

    public void setSo2(int i) {
        this.so2 = i;
    }

    public int getAqi() {
        return this.aqi;
    }

    public void setAqi(int i) {
        this.aqi = i;
    }

    public int getPm10() {
        return this.pm10;
    }

    public void setPm10(int i) {
        this.pm10 = i;
    }

    public String getPrimaryPollutant() {
        return this.primaryPollutant;
    }

    public void setPrimaryPollutant(String str) {
        this.primaryPollutant = str;
    }

    public float getCo() {
        return this.co;
    }

    public void setCo(float f) {
        this.co = f;
    }

    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    protected Air(Parcel parcel) {
        this.no2 = parcel.readInt();
        this.pm25 = parcel.readInt();
        this.o3 = parcel.readInt();
        this.so2 = parcel.readInt();
        this.aqi = parcel.readInt();
        this.pm10 = parcel.readInt();
        this.primaryPollutant = parcel.readString();
        this.co = parcel.readInt();
        this.quality = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.no2);
        parcel.writeInt(this.pm25);
        parcel.writeInt(this.o3);
        parcel.writeInt(this.so2);
        parcel.writeInt(this.aqi);
        parcel.writeInt(this.pm10);
        parcel.writeString(this.primaryPollutant);
        parcel.writeFloat(this.co);
        parcel.writeString(this.quality);
    }
}
