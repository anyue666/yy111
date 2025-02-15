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
public final class VmsAssociatedLayer implements Parcelable {
    public static final Parcelable.Creator<VmsAssociatedLayer> CREATOR = new Parcelable.Creator<VmsAssociatedLayer>() { // from class: android.car.vms.VmsAssociatedLayer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsAssociatedLayer[] newArray(int i) {
            return new VmsAssociatedLayer[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsAssociatedLayer createFromParcel(Parcel parcel) {
            return new VmsAssociatedLayer(parcel);
        }
    };
    private Set<Integer> mProviderIds;
    private final VmsLayer mVmsLayer;

    @Deprecated
    private void __metadata() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private void onConstructed() {
        this.mProviderIds = Collections.unmodifiableSet(this.mProviderIds);
    }

    private void parcelProviderIds(Parcel parcel, int i) {
        parcel.writeArraySet(new ArraySet(this.mProviderIds));
    }

    private Set<Integer> unparcelProviderIds(Parcel parcel) {
        return parcel.readArraySet(Integer.class.getClassLoader());
    }

    @Deprecated
    public Set<Integer> getPublisherIds() {
        return this.mProviderIds;
    }

    public VmsAssociatedLayer(VmsLayer vmsLayer, Set<Integer> set) {
        this.mVmsLayer = vmsLayer;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, vmsLayer);
        this.mProviderIds = set;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, set);
        onConstructed();
    }

    public VmsLayer getVmsLayer() {
        return this.mVmsLayer;
    }

    public Set<Integer> getProviderIds() {
        return this.mProviderIds;
    }

    public String toString() {
        return "VmsAssociatedLayer { vmsLayer = " + this.mVmsLayer + ", providerIds = " + this.mProviderIds + " }";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VmsAssociatedLayer vmsAssociatedLayer = (VmsAssociatedLayer) obj;
        return Objects.equals(this.mVmsLayer, vmsAssociatedLayer.mVmsLayer) && Objects.equals(this.mProviderIds, vmsAssociatedLayer.mProviderIds);
    }

    public int hashCode() {
        return ((Objects.hashCode(this.mVmsLayer) + 31) * 31) + Objects.hashCode(this.mProviderIds);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedObject(this.mVmsLayer, i);
        parcelProviderIds(parcel, i);
    }

    VmsAssociatedLayer(Parcel parcel) {
        VmsLayer vmsLayer = (VmsLayer) parcel.readTypedObject(VmsLayer.CREATOR);
        Set<Integer> unparcelProviderIds = unparcelProviderIds(parcel);
        this.mVmsLayer = vmsLayer;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, vmsLayer);
        this.mProviderIds = unparcelProviderIds;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, unparcelProviderIds);
        onConstructed();
    }
}
