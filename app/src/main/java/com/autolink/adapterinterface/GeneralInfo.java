package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GeneralInfo implements Parcelable {
    public static final Parcelable.Creator<GeneralInfo> CREATOR = new Parcelable.Creator<GeneralInfo>() { // from class: com.autolink.adapterinterface.GeneralInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeneralInfo createFromParcel(Parcel parcel) {
            return new GeneralInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GeneralInfo[] newArray(int i) {
            return new GeneralInfo[i];
        }
    };
    public int carModalType;
    public byte[] carModelConfig;
    public String hardwareVersion;
    public String iccid;
    public String imei;
    public String imsi;
    public int manufactureDate;
    public String partNumber;
    public String sn;
    public String softwareVersion;
    public String supplierIdertifier;
    public String vinCode;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GeneralInfo() {
    }

    protected GeneralInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public GeneralInfo(GeneralInfo generalInfo) {
        if (generalInfo == null) {
            return;
        }
        this.manufactureDate = generalInfo.manufactureDate;
        this.carModalType = generalInfo.carModalType;
        this.vinCode = generalInfo.vinCode;
        this.sn = generalInfo.sn;
        this.iccid = generalInfo.iccid;
        this.hardwareVersion = generalInfo.hardwareVersion;
        this.softwareVersion = generalInfo.softwareVersion;
        this.supplierIdertifier = generalInfo.supplierIdertifier;
        this.partNumber = generalInfo.partNumber;
        this.imsi = generalInfo.imsi;
        this.imei = generalInfo.imei;
        this.carModelConfig = generalInfo.carModelConfig;
    }

    public void readFromParcel(Parcel parcel) {
        this.manufactureDate = parcel.readInt();
        this.carModalType = parcel.readInt();
        this.vinCode = parcel.readString();
        this.sn = parcel.readString();
        this.iccid = parcel.readString();
        this.hardwareVersion = parcel.readString();
        this.softwareVersion = parcel.readString();
        this.supplierIdertifier = parcel.readString();
        this.partNumber = parcel.readString();
        this.imsi = parcel.readString();
        this.imei = parcel.readString();
        this.carModelConfig = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.manufactureDate);
        parcel.writeInt(this.carModalType);
        parcel.writeString(this.vinCode);
        parcel.writeString(this.sn);
        parcel.writeString(this.iccid);
        parcel.writeString(this.hardwareVersion);
        parcel.writeString(this.softwareVersion);
        parcel.writeString(this.supplierIdertifier);
        parcel.writeString(this.partNumber);
        parcel.writeString(this.imsi);
        parcel.writeString(this.imei);
        parcel.writeByteArray(this.carModelConfig);
    }

    public String toString() {
        return "GeneralInfo{manufactureDate=" + this.manufactureDate + ", carModalType=" + this.carModalType + ", vinCode='" + this.vinCode + "', sn='" + this.sn + "', iccid='" + this.iccid + "', hardwareVersion='" + this.hardwareVersion + "', softwareVersion='" + this.softwareVersion + "', supplierIdertifier='" + this.supplierIdertifier + "', partNumber='" + this.partNumber + "', imsi='" + this.imsi + "', imei='" + this.imei + "', carModelConfig=" + Arrays.toString(this.carModelConfig) + '}';
    }
}
