package android.car.storagemonitoring;

import android.annotation.SystemApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

@SystemApi
/* loaded from: classes.dex */
public final class LifetimeWriteInfo implements Parcelable {
    public static final Parcelable.Creator<IoStats> CREATOR = new Parcelable.Creator<IoStats>() { // from class: android.car.storagemonitoring.LifetimeWriteInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IoStats createFromParcel(Parcel parcel) {
            return new IoStats(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IoStats[] newArray(int i) {
            return new IoStats[i];
        }
    };
    public final String fstype;
    public final String partition;
    public final long writtenBytes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LifetimeWriteInfo(String str, String str2, long j) {
        this.partition = (String) Objects.requireNonNull(str);
        this.fstype = (String) Objects.requireNonNull(str2);
        if (j < 0) {
            throw new IllegalArgumentException("writtenBytes must be non-negative");
        }
        this.writtenBytes = j;
    }

    public LifetimeWriteInfo(Parcel parcel) {
        this.partition = parcel.readString();
        this.fstype = parcel.readString();
        this.writtenBytes = parcel.readLong();
    }

    public LifetimeWriteInfo(JSONObject jSONObject) throws JSONException {
        this.partition = jSONObject.getString("partition");
        this.fstype = jSONObject.getString("fstype");
        this.writtenBytes = jSONObject.getLong("writtenBytes");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.partition);
        parcel.writeString(this.fstype);
        parcel.writeLong(this.writtenBytes);
    }

    public void writeToJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("partition").value(this.partition);
        jsonWriter.name("fstype").value(this.fstype);
        jsonWriter.name("writtenBytes").value(this.writtenBytes);
        jsonWriter.endObject();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LifetimeWriteInfo)) {
            return false;
        }
        LifetimeWriteInfo lifetimeWriteInfo = (LifetimeWriteInfo) obj;
        return this.partition.equals(lifetimeWriteInfo.partition) && this.fstype.equals(lifetimeWriteInfo.fstype) && this.writtenBytes == lifetimeWriteInfo.writtenBytes;
    }

    public String toString() {
        return String.format("for partition %s of type %s, %d bytes were written", this.partition, this.fstype, Long.valueOf(this.writtenBytes));
    }
}
