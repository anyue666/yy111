package com.autolink.adapterinterface.tbox2.network;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class TboxNetworkRestartResultInfo implements Parcelable {
    public static final Parcelable.Creator<TboxNetworkRestartResultInfo> CREATOR = new Parcelable.Creator<TboxNetworkRestartResultInfo>() { // from class: com.autolink.adapterinterface.tbox2.network.TboxNetworkRestartResultInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxNetworkRestartResultInfo createFromParcel(Parcel parcel) {
            return new TboxNetworkRestartResultInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxNetworkRestartResultInfo[] newArray(int i) {
            return new TboxNetworkRestartResultInfo[i];
        }
    };
    private byte errorCode;
    private short msgId;
    private byte restartType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxNetworkRestartResultInfo(short s, byte b, byte b2) {
        this.msgId = s;
        this.restartType = b;
        this.errorCode = b2;
    }

    protected TboxNetworkRestartResultInfo(Parcel parcel) {
        this.msgId = (short) parcel.readInt();
        this.restartType = parcel.readByte();
        this.errorCode = parcel.readByte();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.msgId);
        parcel.writeByte(this.restartType);
        parcel.writeByte(this.errorCode);
    }

    public String toString() {
        return "TboxNetworkRestartResultInfo{msgId=" + ((int) this.msgId) + ", restartType=" + ((int) this.restartType) + ", errorCode=" + ((int) this.errorCode) + '}';
    }

    public short getMsgId() {
        return this.msgId;
    }

    public void setMsgId(short s) {
        this.msgId = s;
    }

    public byte getRestartType() {
        return this.restartType;
    }

    public void setRestartType(byte b) {
        this.restartType = b;
    }

    public byte getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(byte b) {
        this.errorCode = b;
    }
}
