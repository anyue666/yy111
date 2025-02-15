package android.car.storagemonitoring;

import android.annotation.SystemApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonReader;
import android.util.JsonWriter;
import androidx.core.os.EnvironmentCompat;
import java.io.IOException;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

@SystemApi
/* loaded from: classes.dex */
public final class WearEstimate implements Parcelable {
    public static final int UNKNOWN = -1;
    public final int typeA;
    public final int typeB;
    public static final WearEstimate UNKNOWN_ESTIMATE = new WearEstimate(-1, -1);
    public static final Parcelable.Creator<WearEstimate> CREATOR = new Parcelable.Creator<WearEstimate>() { // from class: android.car.storagemonitoring.WearEstimate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WearEstimate createFromParcel(Parcel parcel) {
            return new WearEstimate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WearEstimate[] newArray(int i) {
            return new WearEstimate[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private static int validateWearValue(int i) {
        if (i == -1) {
            return i;
        }
        if (i < 0 || i > 100) {
            throw new IllegalArgumentException(i + " is not a valid wear estimate");
        }
        return i;
    }

    public WearEstimate(int i, int i2) {
        this.typeA = validateWearValue(i);
        this.typeB = validateWearValue(i2);
    }

    public WearEstimate(Parcel parcel) {
        this.typeA = validateWearValue(parcel.readInt());
        this.typeB = validateWearValue(parcel.readInt());
    }

    public WearEstimate(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        int i = -1;
        int i2 = -1;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("wearEstimateTypeA")) {
                i = validateWearValue(jsonReader.nextInt());
            } else if (nextName.equals("wearEstimateTypeB")) {
                i2 = validateWearValue(jsonReader.nextInt());
            }
        }
        jsonReader.endObject();
        this.typeA = i;
        this.typeB = i2;
    }

    public WearEstimate(JSONObject jSONObject) throws JSONException {
        this.typeA = jSONObject.getInt("wearEstimateTypeA");
        this.typeB = jSONObject.getInt("wearEstimateTypeB");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.typeA);
        parcel.writeInt(this.typeB);
    }

    public void writeToJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("wearEstimateTypeA").value(this.typeA);
        jsonWriter.name("wearEstimateTypeB").value(this.typeB);
        jsonWriter.endObject();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WearEstimate)) {
            return false;
        }
        WearEstimate wearEstimate = (WearEstimate) obj;
        return wearEstimate.typeA == this.typeA && wearEstimate.typeB == this.typeB;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.typeA), Integer.valueOf(this.typeB));
    }

    private static String wearValueToString(int i) {
        return i == -1 ? EnvironmentCompat.MEDIA_UNKNOWN : i + "%";
    }

    public String toString() {
        return "type A: " + wearValueToString(this.typeA) + ", type B: " + wearValueToString(this.typeB);
    }
}
