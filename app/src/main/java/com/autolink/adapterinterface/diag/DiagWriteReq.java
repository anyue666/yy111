package com.autolink.adapterinterface.diag;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DiagWriteReq implements Parcelable {
    public static final Parcelable.Creator<DiagWriteReq> CREATOR = new Parcelable.Creator<DiagWriteReq>() { // from class: com.autolink.adapterinterface.diag.DiagWriteReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiagWriteReq createFromParcel(Parcel parcel) {
            return new DiagWriteReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DiagWriteReq[] newArray(int i) {
            return new DiagWriteReq[i];
        }
    };
    private List<Byte> data;
    private short dataLength;
    private short did;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DiagWriteReq() {
        this.did = (short) 0;
        this.dataLength = (short) 0;
        this.data = new ArrayList();
    }

    public DiagWriteReq(short s, short s2, List<Byte> list) {
        this.did = (short) 0;
        this.dataLength = (short) 0;
        new ArrayList();
        this.did = s;
        this.dataLength = s2;
        this.data = list;
    }

    protected DiagWriteReq(Parcel parcel) {
        this.did = (short) 0;
        this.dataLength = (short) 0;
        this.data = new ArrayList();
        this.did = (short) parcel.readInt();
        this.dataLength = (short) parcel.readInt();
        int readInt = parcel.readInt();
        this.data = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.data.add(Byte.valueOf((byte) parcel.readInt()));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.did);
        parcel.writeInt(this.dataLength);
        parcel.writeInt(this.data.size());
        Iterator<Byte> it = this.data.iterator();
        while (it.hasNext()) {
            parcel.writeInt(it.next().intValue());
        }
    }

    public short getDid() {
        return this.did;
    }

    public void setDid(short s) {
        this.did = s;
    }

    public short getDataLength() {
        return this.dataLength;
    }

    public void setDataLength(short s) {
        this.dataLength = s;
    }

    public List<Byte> getData() {
        return this.data;
    }

    public void setData(List<Byte> list) {
        this.data = list;
    }

    public String toString() {
        return "DiagWriteReq{did=" + ((int) this.did) + ", dataLength=" + ((int) this.dataLength) + ", data=" + this.data + '}';
    }
}
