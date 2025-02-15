package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ChargeSetReqeust implements Parcelable {
    public static final Parcelable.Creator<ChargeSetReqeust> CREATOR = new Parcelable.Creator<ChargeSetReqeust>() { // from class: com.autolink.adapterinterface.ChargeSetReqeust.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChargeSetReqeust createFromParcel(Parcel parcel) {
            return new ChargeSetReqeust(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChargeSetReqeust[] newArray(int i) {
            return new ChargeSetReqeust[i];
        }
    };
    public int chargeSOC;
    public int chargeTaskId;
    public int chargeTimeBegin;
    public int chargeTimeBeginMin;
    public int chargeTimeEnd;
    public int chargeTimeEndMin;
    public int chargeType;
    public int repeatType;
    public int reserveType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ChargeSetReqeust() {
    }

    protected ChargeSetReqeust(Parcel parcel) {
        this.chargeType = parcel.readInt();
        this.reserveType = parcel.readInt();
        this.chargeTaskId = parcel.readInt();
        this.chargeSOC = parcel.readInt();
        this.chargeTimeBegin = parcel.readInt();
        this.chargeTimeBeginMin = parcel.readInt();
        this.chargeTimeEnd = parcel.readInt();
        this.chargeTimeEndMin = parcel.readInt();
        this.repeatType = parcel.readInt();
    }

    public void readFromParcel(Parcel parcel) {
        this.chargeType = parcel.readInt();
        this.reserveType = parcel.readInt();
        this.chargeTaskId = parcel.readInt();
        this.chargeSOC = parcel.readInt();
        this.chargeTimeBegin = parcel.readInt();
        this.chargeTimeBeginMin = parcel.readInt();
        this.chargeTimeEnd = parcel.readInt();
        this.chargeTimeEndMin = parcel.readInt();
        this.repeatType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.chargeType);
        parcel.writeInt(this.reserveType);
        parcel.writeInt(this.chargeTaskId);
        parcel.writeInt(this.chargeSOC);
        parcel.writeInt(this.chargeTimeBegin);
        parcel.writeInt(this.chargeTimeBeginMin);
        parcel.writeInt(this.chargeTimeEnd);
        parcel.writeInt(this.chargeTimeEndMin);
        parcel.writeInt(this.repeatType);
    }

    public String toString() {
        return "ChargeSetReqeust{chargeType=" + this.chargeType + ", reserveType=" + this.reserveType + ", chargeTaskId=" + this.chargeTaskId + ", chargeSOC=" + this.chargeSOC + ", chargeTimeBegin=" + this.chargeTimeBegin + ", chargeTimeBeginMin=" + this.chargeTimeBeginMin + ", chargeTimeEnd=" + this.chargeTimeEnd + ", chargeTimeEndMin=" + this.chargeTimeEndMin + ", repeatType=" + this.repeatType + '}';
    }
}
