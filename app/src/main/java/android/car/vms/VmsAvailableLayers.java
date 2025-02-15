package android.car.vms;

import android.annotation.NonNull;
import android.annotation.SystemApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArraySet;
import com.android.internal.util.AnnotationValidations;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@SystemApi
/* loaded from: classes.dex */
public final class VmsAvailableLayers implements Parcelable {
    public static final Parcelable.Creator<VmsAvailableLayers> CREATOR = new Parcelable.Creator<VmsAvailableLayers>() { // from class: android.car.vms.VmsAvailableLayers.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsAvailableLayers[] newArray(int i) {
            return new VmsAvailableLayers[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsAvailableLayers createFromParcel(Parcel parcel) {
            return new VmsAvailableLayers(parcel);
        }
    };
    private Set<VmsAssociatedLayer> mAssociatedLayers;
    private final int mSequenceNumber;

    @Deprecated
    private void __metadata() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private void onConstructed() {
        this.mAssociatedLayers = Collections.unmodifiableSet(this.mAssociatedLayers);
    }

    private void parcelAssociatedLayers(Parcel parcel, int i) {
        parcel.writeArraySet(new ArraySet(this.mAssociatedLayers));
    }

    private Set<VmsAssociatedLayer> unparcelAssociatedLayers(Parcel parcel) {
        return parcel.readArraySet(VmsAssociatedLayer.class.getClassLoader());
    }

    @Deprecated
    public VmsAvailableLayers(Set<VmsAssociatedLayer> set, int i) {
        this(i, set);
    }

    @Deprecated
    public int getSequence() {
        return this.mSequenceNumber;
    }

    public VmsAvailableLayers(int i, Set<VmsAssociatedLayer> set) {
        this.mSequenceNumber = i;
        this.mAssociatedLayers = set;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, set);
        onConstructed();
    }

    public int getSequenceNumber() {
        return this.mSequenceNumber;
    }

    public Set<VmsAssociatedLayer> getAssociatedLayers() {
        return this.mAssociatedLayers;
    }

    public String toString() {
        return "VmsAvailableLayers { sequenceNumber = " + this.mSequenceNumber + ", associatedLayers = " + this.mAssociatedLayers + " }";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VmsAvailableLayers vmsAvailableLayers = (VmsAvailableLayers) obj;
        return this.mSequenceNumber == vmsAvailableLayers.mSequenceNumber && Objects.equals(this.mAssociatedLayers, vmsAvailableLayers.mAssociatedLayers);
    }

    public int hashCode() {
        return ((this.mSequenceNumber + 31) * 31) + Objects.hashCode(this.mAssociatedLayers);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSequenceNumber);
        parcelAssociatedLayers(parcel, i);
    }

    VmsAvailableLayers(Parcel parcel) {
        int readInt = parcel.readInt();
        Set<VmsAssociatedLayer> unparcelAssociatedLayers = unparcelAssociatedLayers(parcel);
        this.mSequenceNumber = readInt;
        this.mAssociatedLayers = unparcelAssociatedLayers;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, unparcelAssociatedLayers);
        onConstructed();
    }
}
