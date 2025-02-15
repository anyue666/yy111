package com.autolink.adapterinterface.car;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class ALCarPropertyEvent<T> implements Parcelable {
    private int id;
    private T value;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<ALCarPropertyEvent> CREATOR = new Parcelable.Creator<ALCarPropertyEvent>() { // from class: com.autolink.adapterinterface.car.ALCarPropertyEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ALCarPropertyEvent createFromParcel(Parcel parcel) {
            return new ALCarPropertyEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ALCarPropertyEvent[] newArray(int i) {
            return new ALCarPropertyEvent[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ALCarPropertyEvent(int i, T t) {
        this.id = i;
        this.value = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ALCarPropertyEvent(Parcel parcel) {
        this.id = parcel.readInt();
        String readString = parcel.readString();
        try {
            Class<?> cls = Class.forName(readString);
            if (String.class.equals(cls)) {
                this.value = (T) new String(parcel.readBlob(), DEFAULT_CHARSET);
            } else if (byte[].class.equals(cls)) {
                this.value = (T) parcel.readBlob();
            } else {
                this.value = (T) parcel.readValue(cls.getClassLoader());
            }
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("class not found " + readString);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        T t = this.value;
        Class<?> cls = t == null ? null : t.getClass();
        parcel.writeString(cls != null ? cls.getName() : null);
        if (String.class.equals(cls)) {
            parcel.writeBlob(((String) this.value).getBytes(DEFAULT_CHARSET));
        } else if (byte[].class.equals(cls)) {
            parcel.writeBlob((byte[]) this.value);
        } else {
            parcel.writeValue(this.value);
        }
    }

    public int getId() {
        return this.id;
    }

    public T getValue() {
        return this.value;
    }
}
