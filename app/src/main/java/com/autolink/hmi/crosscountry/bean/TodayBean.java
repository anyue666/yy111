package com.autolink.hmi.crosscountry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TodayBean implements Parcelable {
    public static final Parcelable.Creator<TodayBean> CREATOR = new Parcelable.Creator<TodayBean>() { // from class: com.autolink.hmi.crosscountry.bean.TodayBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TodayBean createFromParcel(Parcel parcel) {
            return new TodayBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TodayBean[] newArray(int i) {
            return new TodayBean[i];
        }
    };
    int codeDay;
    int codeNight;
    String date;
    String high;
    int humidity;
    String low;
    float rainfall;
    String textDay;
    String textNight;
    String windDirection;
    int windDirectionDegree;
    int windScale;
    float windSpeed;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TodayBean(Parcel parcel) {
        this.date = parcel.readString();
        this.rainfall = parcel.readFloat();
        this.codeDay = parcel.readInt();
        this.windDirectionDegree = parcel.readInt();
        this.textDay = parcel.readString();
        this.high = parcel.readString();
        this.codeNight = parcel.readInt();
        this.low = parcel.readString();
        this.textNight = parcel.readString();
        this.humidity = parcel.readInt();
        this.windDirection = parcel.readString();
        this.windSpeed = parcel.readFloat();
        this.windScale = parcel.readInt();
    }

    public TodayBean() {
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public float getRainfall() {
        return this.rainfall;
    }

    public void setRainfall(float f) {
        this.rainfall = f;
    }

    public int getCodeDay() {
        return this.codeDay;
    }

    public void setCodeDay(int i) {
        this.codeDay = i;
    }

    public int getWindDirectionDegree() {
        return this.windDirectionDegree;
    }

    public void setWindDirectionDegree(int i) {
        this.windDirectionDegree = i;
    }

    public String getTextDay() {
        return this.textDay;
    }

    public void setTextDay(String str) {
        this.textDay = str;
    }

    public String getHigh() {
        return this.high;
    }

    public void setHigh(String str) {
        this.high = str;
    }

    public int getCodeNight() {
        return this.codeNight;
    }

    public void setCodeNight(int i) {
        this.codeNight = i;
    }

    public String getLow() {
        return this.low;
    }

    public void setLow(String str) {
        this.low = str;
    }

    public String getTextNight() {
        return this.textNight;
    }

    public void setTextNight(String str) {
        this.textNight = str;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setHumidity(int i) {
        this.humidity = i;
    }

    public String getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(String str) {
        this.windDirection = str;
    }

    public float getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(float f) {
        this.windSpeed = f;
    }

    public int getWindScale() {
        return this.windScale;
    }

    public void setWindScale(int i) {
        this.windScale = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.date);
        parcel.writeFloat(this.rainfall);
        parcel.writeInt(this.codeDay);
        parcel.writeInt(this.windDirectionDegree);
        parcel.writeString(this.textDay);
        parcel.writeString(this.high);
        parcel.writeInt(this.codeNight);
        parcel.writeString(this.low);
        parcel.writeString(this.textNight);
        parcel.writeInt(this.humidity);
        parcel.writeString(this.windDirection);
        parcel.writeFloat(this.windSpeed);
        parcel.writeInt(this.windScale);
    }
}
