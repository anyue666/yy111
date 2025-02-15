package android.car.content.pm;

import android.annotation.SystemApi;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Arrays;

@SystemApi
/* loaded from: classes.dex */
public final class CarAppBlockingPolicy implements Parcelable {
    public static final Parcelable.Creator<CarAppBlockingPolicy> CREATOR;
    private static final String TAG = "CarAppBlockingPolicy";
    private static final Method sReadBlobMethod;
    private static final Method sWriteBlobMethod;
    public final AppBlockingPackageInfo[] blacklists;
    public final AppBlockingPackageInfo[] whitelists;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Method method;
        Method method2;
        try {
            method = Parcel.class.getMethod("readBlob", new Class[0]);
            method2 = Parcel.class.getMethod("writeBlob", byte[].class);
        } catch (NoSuchMethodException unused) {
            method = null;
            method2 = null;
        }
        sReadBlobMethod = method;
        sWriteBlobMethod = method2;
        CREATOR = new Parcelable.Creator<CarAppBlockingPolicy>() { // from class: android.car.content.pm.CarAppBlockingPolicy.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CarAppBlockingPolicy createFromParcel(Parcel parcel) {
                return new CarAppBlockingPolicy(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CarAppBlockingPolicy[] newArray(int i) {
                return new CarAppBlockingPolicy[i];
            }
        };
    }

    public CarAppBlockingPolicy(AppBlockingPackageInfo[] appBlockingPackageInfoArr, AppBlockingPackageInfo[] appBlockingPackageInfoArr2) {
        this.whitelists = appBlockingPackageInfoArr;
        this.blacklists = appBlockingPackageInfoArr2;
    }

    public CarAppBlockingPolicy(Parcel parcel) {
        byte[] readBlob = parcel.readBlob();
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(readBlob, 0, readBlob.length);
        obtain.setDataPosition(0);
        this.whitelists = (AppBlockingPackageInfo[]) obtain.createTypedArray(AppBlockingPackageInfo.CREATOR);
        this.blacklists = (AppBlockingPackageInfo[]) obtain.createTypedArray(AppBlockingPackageInfo.CREATOR);
        obtain.recycle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Parcel obtain = Parcel.obtain();
        obtain.writeTypedArray(this.whitelists, 0);
        obtain.writeTypedArray(this.blacklists, 0);
        parcel.writeBlob(obtain.marshall());
        obtain.recycle();
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.blacklists) + 31) * 31) + Arrays.hashCode(this.whitelists);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarAppBlockingPolicy carAppBlockingPolicy = (CarAppBlockingPolicy) obj;
        return Arrays.equals(this.blacklists, carAppBlockingPolicy.blacklists) && Arrays.equals(this.whitelists, carAppBlockingPolicy.whitelists);
    }

    public String toString() {
        return "CarAppBlockingPolicy [whitelists=" + Arrays.toString(this.whitelists) + ", blacklists=" + Arrays.toString(this.blacklists) + "]";
    }
}
