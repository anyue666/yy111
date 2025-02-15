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
public final class VmsSubscriptionState implements Parcelable {
    public static final Parcelable.Creator<VmsSubscriptionState> CREATOR = new Parcelable.Creator<VmsSubscriptionState>() { // from class: android.car.vms.VmsSubscriptionState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsSubscriptionState[] newArray(int i) {
            return new VmsSubscriptionState[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsSubscriptionState createFromParcel(Parcel parcel) {
            return new VmsSubscriptionState(parcel);
        }
    };
    private Set<VmsAssociatedLayer> mAssociatedLayers;
    private Set<VmsLayer> mLayers;
    private final int mSequenceNumber;

    @Deprecated
    private void __metadata() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private void onConstructed() {
        this.mLayers = Collections.unmodifiableSet(this.mLayers);
        this.mAssociatedLayers = Collections.unmodifiableSet(this.mAssociatedLayers);
    }

    private void parcelLayers(Parcel parcel, int i) {
        parcel.writeArraySet(new ArraySet(this.mLayers));
    }

    private Set<VmsLayer> unparcelLayers(Parcel parcel) {
        return parcel.readArraySet(VmsLayer.class.getClassLoader());
    }

    private void parcelAssociatedLayers(Parcel parcel, int i) {
        parcel.writeArraySet(new ArraySet(this.mAssociatedLayers));
    }

    private Set<VmsAssociatedLayer> unparcelAssociatedLayers(Parcel parcel) {
        return parcel.readArraySet(VmsAssociatedLayer.class.getClassLoader());
    }

    public VmsSubscriptionState(int i, Set<VmsLayer> set, Set<VmsAssociatedLayer> set2) {
        this.mSequenceNumber = i;
        this.mLayers = set;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, set);
        this.mAssociatedLayers = set2;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, set2);
        onConstructed();
    }

    public int getSequenceNumber() {
        return this.mSequenceNumber;
    }

    public Set<VmsLayer> getLayers() {
        return this.mLayers;
    }

    public Set<VmsAssociatedLayer> getAssociatedLayers() {
        return this.mAssociatedLayers;
    }

    public String toString() {
        return "VmsSubscriptionState { sequenceNumber = " + this.mSequenceNumber + ", layers = " + this.mLayers + ", associatedLayers = " + this.mAssociatedLayers + " }";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VmsSubscriptionState vmsSubscriptionState = (VmsSubscriptionState) obj;
        return this.mSequenceNumber == vmsSubscriptionState.mSequenceNumber && Objects.equals(this.mLayers, vmsSubscriptionState.mLayers) && Objects.equals(this.mAssociatedLayers, vmsSubscriptionState.mAssociatedLayers);
    }

    public int hashCode() {
        return ((((this.mSequenceNumber + 31) * 31) + Objects.hashCode(this.mLayers)) * 31) + Objects.hashCode(this.mAssociatedLayers);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mSequenceNumber);
        parcelLayers(parcel, i);
        parcelAssociatedLayers(parcel, i);
    }

    VmsSubscriptionState(Parcel parcel) {
        int readInt = parcel.readInt();
        Set<VmsLayer> unparcelLayers = unparcelLayers(parcel);
        Set<VmsAssociatedLayer> unparcelAssociatedLayers = unparcelAssociatedLayers(parcel);
        this.mSequenceNumber = readInt;
        this.mLayers = unparcelLayers;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, unparcelLayers);
        this.mAssociatedLayers = unparcelAssociatedLayers;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, unparcelAssociatedLayers);
        onConstructed();
    }
}
