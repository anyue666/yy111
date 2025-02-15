package android.car.vms;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VmsProviderInfo implements Parcelable {
    public static final Parcelable.Creator<VmsProviderInfo> CREATOR = new Parcelable.Creator<VmsProviderInfo>() { // from class: android.car.vms.VmsProviderInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsProviderInfo[] newArray(int i) {
            return new VmsProviderInfo[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsProviderInfo createFromParcel(Parcel parcel) {
            return new VmsProviderInfo(parcel);
        }
    };
    private final byte[] mDescription;

    @Deprecated
    private void __metadata() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VmsProviderInfo(byte[] bArr) {
        this.mDescription = bArr;
    }

    public byte[] getDescription() {
        return this.mDescription;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.mDescription, ((VmsProviderInfo) obj).mDescription);
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.mDescription);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mDescription != null ? (byte) 1 : (byte) 0);
        byte[] bArr = this.mDescription;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    protected VmsProviderInfo(Parcel parcel) {
        this.mDescription = (parcel.readByte() & 1) == 0 ? null : parcel.createByteArray();
    }
}
