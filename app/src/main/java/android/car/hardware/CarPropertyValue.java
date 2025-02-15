package android.car.hardware;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class CarPropertyValue<T> implements Parcelable {
    public static final int STATUS_AVAILABLE = 0;
    public static final int STATUS_ERROR = 2;
    public static final int STATUS_UNAVAILABLE = 1;
    private final int mAreaId;
    private final int mPropertyId;
    private final int mStatus;
    private final long mTimestamp;
    private final T mValue;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<CarPropertyValue> CREATOR = new Parcelable.Creator<CarPropertyValue>() { // from class: android.car.hardware.CarPropertyValue.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarPropertyValue createFromParcel(Parcel parcel) {
            return new CarPropertyValue(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarPropertyValue[] newArray(int i) {
            return new CarPropertyValue[i];
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface PropertyStatus {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CarPropertyValue(int i, int i2, T t) {
        this(i, i2, 0, 0L, t);
    }

    public CarPropertyValue(int i, int i2, int i3, long j, T t) {
        this.mPropertyId = i;
        this.mAreaId = i2;
        this.mStatus = i3;
        this.mTimestamp = j;
        this.mValue = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CarPropertyValue(Parcel parcel) {
        this.mPropertyId = parcel.readInt();
        this.mAreaId = parcel.readInt();
        this.mStatus = parcel.readInt();
        this.mTimestamp = parcel.readLong();
        String readString = parcel.readString();
        try {
            Class<?> cls = Class.forName(readString);
            if (String.class.equals(cls)) {
                this.mValue = (T) new String(parcel.readBlob(), DEFAULT_CHARSET);
            } else if (byte[].class.equals(cls)) {
                this.mValue = (T) parcel.readBlob();
            } else {
                this.mValue = (T) parcel.readValue(cls.getClassLoader());
            }
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("Class not found: " + readString);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPropertyId);
        parcel.writeInt(this.mAreaId);
        parcel.writeInt(this.mStatus);
        parcel.writeLong(this.mTimestamp);
        T t = this.mValue;
        Class<?> cls = t == null ? null : t.getClass();
        parcel.writeString(cls != null ? cls.getName() : null);
        if (String.class.equals(cls)) {
            parcel.writeBlob(((String) this.mValue).getBytes(DEFAULT_CHARSET));
        } else if (byte[].class.equals(cls)) {
            parcel.writeBlob((byte[]) this.mValue);
        } else {
            parcel.writeValue(this.mValue);
        }
    }

    public int getPropertyId() {
        return this.mPropertyId;
    }

    public int getAreaId() {
        return this.mAreaId;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public T getValue() {
        return this.mValue;
    }

    public String toString() {
        return "CarPropertyValue{mPropertyId=0x" + Integer.toHexString(this.mPropertyId) + ", mAreaId=0x" + Integer.toHexString(this.mAreaId) + ", mStatus=" + this.mStatus + ", mTimestamp=" + this.mTimestamp + ", mValue=" + this.mValue + '}';
    }
}
