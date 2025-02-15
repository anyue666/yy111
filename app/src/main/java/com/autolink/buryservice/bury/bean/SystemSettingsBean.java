package com.autolink.buryservice.bury.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class SystemSettingsBean implements Parcelable {
    public static final Parcelable.Creator<SystemSettingsBean> CREATOR = new Parcelable.Creator<SystemSettingsBean>() { // from class: com.autolink.buryservice.bury.bean.SystemSettingsBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemSettingsBean createFromParcel(Parcel parcel) {
            return new SystemSettingsBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SystemSettingsBean[] newArray(int i) {
            return new SystemSettingsBean[i];
        }
    };
    private String mEvent;
    private String mHardwareVersion;
    private String mIVIVersion;
    private String mInstrumentVersion;
    private String mSocVersion;
    private String mTboxHardwareVersion;
    private String mTboxSoftwareVersion;
    private String mTotalMemory;
    private String mUsedMemory;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SystemSettingsBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.mEvent = str;
        this.mTotalMemory = str2;
        this.mUsedMemory = str3;
        this.mSocVersion = str4;
        this.mHardwareVersion = str5;
        this.mInstrumentVersion = str6;
        this.mIVIVersion = str7;
        this.mTboxSoftwareVersion = str8;
        this.mTboxHardwareVersion = str9;
    }

    protected SystemSettingsBean(Parcel parcel) {
        this.mEvent = parcel.readString();
        this.mTotalMemory = parcel.readString();
        this.mUsedMemory = parcel.readString();
        this.mSocVersion = parcel.readString();
        this.mHardwareVersion = parcel.readString();
        this.mInstrumentVersion = parcel.readString();
        this.mIVIVersion = parcel.readString();
        this.mTboxSoftwareVersion = parcel.readString();
        this.mTboxHardwareVersion = parcel.readString();
    }

    public String getEvent() {
        return this.mEvent;
    }

    public void setEvent(String str) {
        this.mEvent = str;
    }

    public String getTotalMemory() {
        return this.mTotalMemory;
    }

    public void setTotalMemory(String str) {
        this.mTotalMemory = str;
    }

    public String getUsedMemory() {
        return this.mUsedMemory;
    }

    public void setUsedMemory(String str) {
        this.mUsedMemory = str;
    }

    public String getSocVersion() {
        return this.mSocVersion;
    }

    public void setSocVersion(String str) {
        this.mSocVersion = str;
    }

    public String getHardwareVersion() {
        return this.mHardwareVersion;
    }

    public void setHardwareVersion(String str) {
        this.mHardwareVersion = str;
    }

    public String getInstrumentVersion() {
        return this.mInstrumentVersion;
    }

    public void setInstrumentVersion(String str) {
        this.mInstrumentVersion = str;
    }

    public String getIVIVersion() {
        return this.mIVIVersion;
    }

    public void setIVIVersion(String str) {
        this.mIVIVersion = str;
    }

    public String getTboxSoftwareVersion() {
        return this.mTboxSoftwareVersion;
    }

    public void setTboxSoftwareVersion(String str) {
        this.mTboxSoftwareVersion = str;
    }

    public String getTboxHardwareVersion() {
        return this.mTboxHardwareVersion;
    }

    public void setTboxHardwareVersion(String str) {
        this.mTboxHardwareVersion = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mEvent);
        parcel.writeString(this.mTotalMemory);
        parcel.writeString(this.mUsedMemory);
        parcel.writeString(this.mSocVersion);
        parcel.writeString(this.mHardwareVersion);
        parcel.writeString(this.mInstrumentVersion);
        parcel.writeString(this.mIVIVersion);
        parcel.writeString(this.mTboxSoftwareVersion);
        parcel.writeString(this.mTboxHardwareVersion);
    }

    public String toString() {
        return "SystemSettingsBean{mEvent='" + this.mEvent + "', mTotalMemory='" + this.mTotalMemory + "', mUsedMemory='" + this.mUsedMemory + "', mSocVersion='" + this.mSocVersion + "', mHardwareVersion='" + this.mHardwareVersion + "', mInstrumentVersion='" + this.mInstrumentVersion + "', mIVIVersion='" + this.mIVIVersion + "', mTboxSoftwareVersion='" + this.mTboxSoftwareVersion + "', mTboxHardwareVersion='" + this.mTboxHardwareVersion + "'}";
    }
}
