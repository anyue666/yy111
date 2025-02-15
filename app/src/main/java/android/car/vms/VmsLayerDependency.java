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
public final class VmsLayerDependency implements Parcelable {
    public static final Parcelable.Creator<VmsLayerDependency> CREATOR = new Parcelable.Creator<VmsLayerDependency>() { // from class: android.car.vms.VmsLayerDependency.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsLayerDependency[] newArray(int i) {
            return new VmsLayerDependency[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VmsLayerDependency createFromParcel(Parcel parcel) {
            return new VmsLayerDependency(parcel);
        }
    };
    private Set<VmsLayer> mDependencies;
    private final VmsLayer mLayer;

    @Deprecated
    private void __metadata() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private void onConstructed() {
        this.mDependencies = Collections.unmodifiableSet(this.mDependencies);
    }

    private void parcelDependencies(Parcel parcel, int i) {
        parcel.writeArraySet(new ArraySet(this.mDependencies));
    }

    private Set<VmsLayer> unparcelDependencies(Parcel parcel) {
        return parcel.readArraySet(VmsLayer.class.getClassLoader());
    }

    public VmsLayerDependency(VmsLayer vmsLayer) {
        this(vmsLayer, Collections.emptySet());
    }

    public VmsLayerDependency(VmsLayer vmsLayer, Set<VmsLayer> set) {
        this.mLayer = vmsLayer;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, vmsLayer);
        this.mDependencies = set;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, set);
        onConstructed();
    }

    public VmsLayer getLayer() {
        return this.mLayer;
    }

    public Set<VmsLayer> getDependencies() {
        return this.mDependencies;
    }

    public String toString() {
        return "VmsLayerDependency { layer = " + this.mLayer + ", dependencies = " + this.mDependencies + " }";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VmsLayerDependency vmsLayerDependency = (VmsLayerDependency) obj;
        return Objects.equals(this.mLayer, vmsLayerDependency.mLayer) && Objects.equals(this.mDependencies, vmsLayerDependency.mDependencies);
    }

    public int hashCode() {
        return ((Objects.hashCode(this.mLayer) + 31) * 31) + Objects.hashCode(this.mDependencies);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedObject(this.mLayer, i);
        parcelDependencies(parcel, i);
    }

    VmsLayerDependency(Parcel parcel) {
        VmsLayer vmsLayer = (VmsLayer) parcel.readTypedObject(VmsLayer.CREATOR);
        Set<VmsLayer> unparcelDependencies = unparcelDependencies(parcel);
        this.mLayer = vmsLayer;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, vmsLayer);
        this.mDependencies = unparcelDependencies;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, unparcelDependencies);
        onConstructed();
    }
}
