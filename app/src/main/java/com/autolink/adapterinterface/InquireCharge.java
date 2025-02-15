package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class InquireCharge implements Parcelable {
    public static final Parcelable.Creator<InquireCharge> CREATOR = new Parcelable.Creator<InquireCharge>() { // from class: com.autolink.adapterinterface.InquireCharge.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InquireCharge createFromParcel(Parcel parcel) {
            return new InquireCharge(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InquireCharge[] newArray(int i) {
            return new InquireCharge[i];
        }
    };
    public int chargeMode;
    public int chargeSOC;
    public int chargeTaskId;
    public int chargeTimeBegin;
    public int chargeTimeBeginMin;
    public int chargeTimeEnd;
    public int chargeTimeEndMin;
    public int reserveType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public InquireCharge() {
    }

    protected InquireCharge(Parcel parcel) {
        this.chargeMode = parcel.readInt();
        this.reserveType = parcel.readInt();
        this.chargeTaskId = parcel.readInt();
        this.chargeSOC = parcel.readInt();
        this.chargeTimeBegin = parcel.readInt();
        this.chargeTimeBeginMin = parcel.readInt();
        this.chargeTimeEnd = parcel.readInt();
        this.chargeTimeEndMin = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.chargeMode);
        parcel.writeInt(this.reserveType);
        parcel.writeInt(this.chargeTaskId);
        parcel.writeInt(this.chargeSOC);
        parcel.writeInt(this.chargeTimeBegin);
        parcel.writeInt(this.chargeTimeBeginMin);
        parcel.writeInt(this.chargeTimeEnd);
        parcel.writeInt(this.chargeTimeEndMin);
    }

    public void readFromParcel(Parcel parcel) {
        this.chargeMode = parcel.readInt();
        this.reserveType = parcel.readInt();
        this.chargeTaskId = parcel.readInt();
        this.chargeSOC = parcel.readInt();
        this.chargeTimeBegin = parcel.readInt();
        this.chargeTimeBeginMin = parcel.readInt();
        this.chargeTimeEnd = parcel.readInt();
        this.chargeTimeEndMin = parcel.readInt();
    }

    public String toString() {
        return "InquireCharge{chargeMode=" + this.chargeMode + ", reserveType=" + this.reserveType + ", chargeTaskId=" + this.chargeTaskId + ", chargeSOC=" + this.chargeSOC + ", chargeTimeBegin=" + this.chargeTimeBegin + ", chargeTimeBeginMin=" + this.chargeTimeBeginMin + ", chargeTimeEnd=" + this.chargeTimeEnd + ", chargeTimeEndMin=" + this.chargeTimeEndMin + '}';
    }
}
