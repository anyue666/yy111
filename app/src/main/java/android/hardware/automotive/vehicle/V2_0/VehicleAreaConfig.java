package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class VehicleAreaConfig {
    public int areaId = 0;
    public int minInt32Value = 0;
    public int maxInt32Value = 0;
    public long minInt64Value = 0;
    public long maxInt64Value = 0;
    public float minFloatValue = 0.0f;
    public float maxFloatValue = 0.0f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != VehicleAreaConfig.class) {
            return false;
        }
        VehicleAreaConfig vehicleAreaConfig = (VehicleAreaConfig) obj;
        return this.areaId == vehicleAreaConfig.areaId && this.minInt32Value == vehicleAreaConfig.minInt32Value && this.maxInt32Value == vehicleAreaConfig.maxInt32Value && this.minInt64Value == vehicleAreaConfig.minInt64Value && this.maxInt64Value == vehicleAreaConfig.maxInt64Value && this.minFloatValue == vehicleAreaConfig.minFloatValue && this.maxFloatValue == vehicleAreaConfig.maxFloatValue;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.areaId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.minInt32Value))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.maxInt32Value))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.minInt64Value))), Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.maxInt64Value))), Integer.valueOf(HidlSupport.deepHashCode(Float.valueOf(this.minFloatValue))), Integer.valueOf(HidlSupport.deepHashCode(Float.valueOf(this.maxFloatValue))));
    }

    public final String toString() {
        return "{.areaId = " + this.areaId + ", .minInt32Value = " + this.minInt32Value + ", .maxInt32Value = " + this.maxInt32Value + ", .minInt64Value = " + this.minInt64Value + ", .maxInt64Value = " + this.maxInt64Value + ", .minFloatValue = " + this.minFloatValue + ", .maxFloatValue = " + this.maxFloatValue + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(40L), 0L);
    }

    public static final ArrayList<VehicleAreaConfig> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<VehicleAreaConfig> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 40, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            VehicleAreaConfig vehicleAreaConfig = new VehicleAreaConfig();
            vehicleAreaConfig.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 40);
            arrayList.add(vehicleAreaConfig);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.areaId = hwBlob.getInt32(0 + j);
        this.minInt32Value = hwBlob.getInt32(4 + j);
        this.maxInt32Value = hwBlob.getInt32(8 + j);
        this.minInt64Value = hwBlob.getInt64(16 + j);
        this.maxInt64Value = hwBlob.getInt64(24 + j);
        this.minFloatValue = hwBlob.getFloat(32 + j);
        this.maxFloatValue = hwBlob.getFloat(j + 36);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(40);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<VehicleAreaConfig> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 40);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 40);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(0 + j, this.areaId);
        hwBlob.putInt32(4 + j, this.minInt32Value);
        hwBlob.putInt32(8 + j, this.maxInt32Value);
        hwBlob.putInt64(16 + j, this.minInt64Value);
        hwBlob.putInt64(24 + j, this.maxInt64Value);
        hwBlob.putFloat(32 + j, this.minFloatValue);
        hwBlob.putFloat(j + 36, this.maxFloatValue);
    }
}
