package android.car.vms;

import android.annotation.SystemApi;
import android.os.Parcel;
import android.os.Parcelable;

@SystemApi
/* loaded from: classes.dex */
public final class VmsLayer implements Parcelable {
    public static final Parcelable.Creator<VmsLayer> CREATOR = new Parcelable.Creator<VmsLayer>() { // from class: android.car.vms.VmsLayer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsLayer[] newArray(int i) {
            return new VmsLayer[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsLayer createFromParcel(Parcel parcel) {
            return new VmsLayer(parcel);
        }
    };
    private int mChannel;
    private int mType;
    private int mVersion;

    @Deprecated
    private void __metadata() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public int getSubtype() {
        return this.mChannel;
    }

    public VmsLayer(int i, int i2, int i3) {
        this.mType = i;
        this.mChannel = i2;
        this.mVersion = i3;
    }

    public int getType() {
        return this.mType;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String toString() {
        return "VmsLayer { type = " + this.mType + ", channel = " + this.mChannel + ", version = " + this.mVersion + " }";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VmsLayer vmsLayer = (VmsLayer) obj;
        return this.mType == vmsLayer.mType && this.mChannel == vmsLayer.mChannel && this.mVersion == vmsLayer.mVersion;
    }

    public int hashCode() {
        return ((((this.mType + 31) * 31) + this.mChannel) * 31) + this.mVersion;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mChannel);
        parcel.writeInt(this.mVersion);
    }

    VmsLayer(Parcel parcel) {
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        this.mType = readInt;
        this.mChannel = readInt2;
        this.mVersion = readInt3;
    }
}
