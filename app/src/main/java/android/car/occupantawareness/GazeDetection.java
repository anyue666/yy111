package android.car.occupantawareness;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class GazeDetection implements Parcelable {
    public static final Parcelable.Creator<GazeDetection> CREATOR = new Parcelable.Creator<GazeDetection>() { // from class: android.car.occupantawareness.GazeDetection.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GazeDetection createFromParcel(Parcel parcel) {
            return new GazeDetection(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GazeDetection[] newArray(int i) {
            return new GazeDetection[i];
        }
    };
    public static final int VEHICLE_REGION_CENTER_INSTRUMENT_CLUSTER = 1;
    public static final int VEHICLE_REGION_FORWARD_ROADWAY = 5;
    public static final int VEHICLE_REGION_HEAD_UNIT_DISPLAY = 8;
    public static final int VEHICLE_REGION_LEFT_ROADWAY = 6;
    public static final int VEHICLE_REGION_LEFT_SIDE_MIRROR = 3;
    public static final int VEHICLE_REGION_REAR_VIEW_MIRROR = 2;
    public static final int VEHICLE_REGION_RIGHT_ROADWAY = 7;
    public static final int VEHICLE_REGION_RIGHT_SIDE_MIRROR = 4;
    public static final int VEHICLE_REGION_UNKNOWN = 0;
    public final int confidenceLevel;
    public final long durationOnTargetMillis;
    public final Point3D gazeAngleUnitVector;
    public final int gazeTarget;
    public final Point3D headAngleUnitVector;
    public final Point3D leftEyePosition;
    public final Point3D rightEyePosition;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VehicleRegion {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GazeDetection(int i, Point3D point3D, Point3D point3D2, Point3D point3D3, Point3D point3D4, int i2, long j) {
        this.confidenceLevel = i;
        this.leftEyePosition = point3D;
        this.rightEyePosition = point3D2;
        this.headAngleUnitVector = point3D3;
        this.gazeAngleUnitVector = point3D4;
        this.gazeTarget = i2;
        this.durationOnTargetMillis = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.confidenceLevel);
        parcel.writeParcelable(this.leftEyePosition, i);
        parcel.writeParcelable(this.rightEyePosition, i);
        parcel.writeParcelable(this.headAngleUnitVector, i);
        parcel.writeParcelable(this.gazeAngleUnitVector, i);
        parcel.writeInt(this.gazeTarget);
        parcel.writeLong(this.durationOnTargetMillis);
    }

    public String toString() {
        StringBuilder append = new StringBuilder("GazeDetection{confidenceLevel=").append(this.confidenceLevel).append(", leftEyePosition=");
        Object obj = this.leftEyePosition;
        if (obj == null) {
            obj = "(null)";
        }
        StringBuilder append2 = append.append(obj).append(", rightEyePosition=");
        Object obj2 = this.rightEyePosition;
        if (obj2 == null) {
            obj2 = "(null)";
        }
        StringBuilder append3 = append2.append(obj2).append(", headAngleUnitVector=");
        Object obj3 = this.headAngleUnitVector;
        if (obj3 == null) {
            obj3 = "(null)";
        }
        StringBuilder append4 = append3.append(obj3).append(", gazeAngleUnitVector=");
        Point3D point3D = this.gazeAngleUnitVector;
        return append4.append(point3D != null ? point3D : "(null)").append(", gazeTarget=").append(this.gazeTarget).append(", durationOnTargetMillis=").append(this.durationOnTargetMillis).append("}").toString();
    }

    private GazeDetection(Parcel parcel) {
        this.confidenceLevel = parcel.readInt();
        this.leftEyePosition = (Point3D) parcel.readParcelable(Point3D.class.getClassLoader());
        this.rightEyePosition = (Point3D) parcel.readParcelable(Point3D.class.getClassLoader());
        this.headAngleUnitVector = (Point3D) parcel.readParcelable(Point3D.class.getClassLoader());
        this.gazeAngleUnitVector = (Point3D) parcel.readParcelable(Point3D.class.getClassLoader());
        this.gazeTarget = parcel.readInt();
        this.durationOnTargetMillis = parcel.readLong();
    }
}
