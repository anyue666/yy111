package com.autolink.hmi.crosscountry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class NowData implements Parcelable {
    public static final Parcelable.Creator<NowData> CREATOR = new Parcelable.Creator<NowData>() { // from class: com.autolink.hmi.crosscountry.bean.NowData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NowData createFromParcel(Parcel parcel) {
            return new NowData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NowData[] newArray(int i) {
            return new NowData[i];
        }
    };
    private String code;
    private String feelsLike;
    private String humidity;
    private String pressure;
    private String temperature;
    private String text;
    private String visibility;
    private String windDirection;
    private String windDirectionDegree;
    private String windScale;
    private String windSpeed;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NowData() {
    }

    public String getFeelsLike() {
        return this.feelsLike;
    }

    public void setFeelsLike(String str) {
        this.feelsLike = str;
    }

    public String getWindDirectionDegree() {
        return this.windDirectionDegree;
    }

    public void setWindDirectionDegree(String str) {
        this.windDirectionDegree = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public void setVisibility(String str) {
        this.visibility = str;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String str) {
        this.temperature = str;
    }

    public String getHumidity() {
        return this.humidity;
    }

    public void setHumidity(String str) {
        this.humidity = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getPressure() {
        return this.pressure;
    }

    public void setPressure(String str) {
        this.pressure = str;
    }

    public String getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(String str) {
        this.windDirection = str;
    }

    public String getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(String str) {
        this.windSpeed = str;
    }

    public String getWindScale() {
        return this.windScale;
    }

    public void setWindScale(String str) {
        this.windScale = str;
    }

    protected NowData(Parcel parcel) {
        this.feelsLike = parcel.readString();
        this.windDirectionDegree = parcel.readString();
        this.code = parcel.readString();
        this.visibility = parcel.readString();
        this.temperature = parcel.readString();
        this.humidity = parcel.readString();
        this.text = parcel.readString();
        this.pressure = parcel.readString();
        this.windDirection = parcel.readString();
        this.windSpeed = parcel.readString();
        this.windScale = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.feelsLike);
        parcel.writeString(this.windDirectionDegree);
        parcel.writeString(this.code);
        parcel.writeString(this.visibility);
        parcel.writeString(this.temperature);
        parcel.writeString(this.humidity);
        parcel.writeString(this.text);
        parcel.writeString(this.pressure);
        parcel.writeString(this.windDirection);
        parcel.writeString(this.windScale);
        parcel.writeString(this.windScale);
    }
}
