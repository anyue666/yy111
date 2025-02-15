package com.autolink.adapterinterface.tbox2.callcommand;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TboxCallInfo implements Parcelable {
    public static final Parcelable.Creator<TboxCallInfo> CREATOR = new Parcelable.Creator<TboxCallInfo>() { // from class: com.autolink.adapterinterface.tbox2.callcommand.TboxCallInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxCallInfo createFromParcel(Parcel parcel) {
            return new TboxCallInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxCallInfo[] newArray(int i) {
            return new TboxCallInfo[i];
        }
    };
    private byte ackCode;
    private byte callComm;
    private byte callType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxCallInfo() {
    }

    protected TboxCallInfo(Parcel parcel) {
        this.callComm = parcel.readByte();
        this.callType = parcel.readByte();
        this.ackCode = parcel.readByte();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.callComm);
        parcel.writeByte(this.callType);
        parcel.writeByte(this.ackCode);
    }

    public byte getCallComm() {
        return this.callComm;
    }

    public void setCallComm(byte b) {
        this.callComm = b;
    }

    public byte getCallType() {
        return this.callType;
    }

    public void setCallType(byte b) {
        this.callType = b;
    }

    public byte getAckCode() {
        return this.ackCode;
    }

    public void setAckCode(byte b) {
        this.ackCode = b;
    }

    public String toString() {
        return "TboxCallInfo{callComm=" + ((int) this.callComm) + ", callType=" + ((int) this.callType) + ", ackCode=" + ((int) this.ackCode) + '}';
    }
}
