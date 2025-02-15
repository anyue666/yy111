package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class VehiclePropConfig {
    public int prop = 0;
    public int access = 0;
    public int changeMode = 0;
    public ArrayList<VehicleAreaConfig> areaConfigs = new ArrayList<>();
    public ArrayList<Integer> configArray = new ArrayList<>();
    public String configString = new String();
    public float minSampleRate = 0.0f;
    public float maxSampleRate = 0.0f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != VehiclePropConfig.class) {
            return false;
        }
        VehiclePropConfig vehiclePropConfig = (VehiclePropConfig) obj;
        return this.prop == vehiclePropConfig.prop && this.access == vehiclePropConfig.access && this.changeMode == vehiclePropConfig.changeMode && HidlSupport.deepEquals(this.areaConfigs, vehiclePropConfig.areaConfigs) && HidlSupport.deepEquals(this.configArray, vehiclePropConfig.configArray) && HidlSupport.deepEquals(this.configString, vehiclePropConfig.configString) && this.minSampleRate == vehiclePropConfig.minSampleRate && this.maxSampleRate == vehiclePropConfig.maxSampleRate;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.prop))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.access))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.changeMode))), Integer.valueOf(HidlSupport.deepHashCode(this.areaConfigs)), Integer.valueOf(HidlSupport.deepHashCode(this.configArray)), Integer.valueOf(HidlSupport.deepHashCode(this.configString)), Integer.valueOf(HidlSupport.deepHashCode(Float.valueOf(this.minSampleRate))), Integer.valueOf(HidlSupport.deepHashCode(Float.valueOf(this.maxSampleRate))));
    }

    public final String toString() {
        return "{.prop = " + this.prop + ", .access = " + VehiclePropertyAccess.toString(this.access) + ", .changeMode = " + VehiclePropertyChangeMode.toString(this.changeMode) + ", .areaConfigs = " + this.areaConfigs + ", .configArray = " + this.configArray + ", .configString = " + this.configString + ", .minSampleRate = " + this.minSampleRate + ", .maxSampleRate = " + this.maxSampleRate + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(72L), 0L);
    }

    public static final ArrayList<VehiclePropConfig> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<VehiclePropConfig> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 72, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            VehiclePropConfig vehiclePropConfig = new VehiclePropConfig();
            vehiclePropConfig.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 72);
            arrayList.add(vehiclePropConfig);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.prop = hwBlob.getInt32(j + 0);
        this.access = hwBlob.getInt32(j + 4);
        this.changeMode = hwBlob.getInt32(j + 8);
        long j2 = j + 16;
        int int32 = hwBlob.getInt32(j2 + 8);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 40, hwBlob.handle(), j2 + 0, true);
        this.areaConfigs.clear();
        for (int i = 0; i < int32; i++) {
            VehicleAreaConfig vehicleAreaConfig = new VehicleAreaConfig();
            vehicleAreaConfig.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 40);
            this.areaConfigs.add(vehicleAreaConfig);
        }
        long j3 = j + 32;
        int int322 = hwBlob.getInt32(8 + j3);
        HwBlob readEmbeddedBuffer2 = hwParcel.readEmbeddedBuffer(int322 * 4, hwBlob.handle(), j3 + 0, true);
        this.configArray.clear();
        for (int i2 = 0; i2 < int322; i2++) {
            this.configArray.add(Integer.valueOf(readEmbeddedBuffer2.getInt32(i2 * 4)));
        }
        long j4 = j + 48;
        this.configString = hwBlob.getString(j4);
        hwParcel.readEmbeddedBuffer(r6.getBytes().length + 1, hwBlob.handle(), j4 + 0, false);
        this.minSampleRate = hwBlob.getFloat(j + 64);
        this.maxSampleRate = hwBlob.getFloat(j + 68);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(72);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<VehiclePropConfig> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 72);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 72);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(j + 0, this.prop);
        hwBlob.putInt32(j + 4, this.access);
        hwBlob.putInt32(j + 8, this.changeMode);
        int size = this.areaConfigs.size();
        long j2 = j + 16;
        hwBlob.putInt32(j2 + 8, size);
        hwBlob.putBool(j2 + 12, false);
        HwBlob hwBlob2 = new HwBlob(size * 40);
        for (int i = 0; i < size; i++) {
            this.areaConfigs.get(i).writeEmbeddedToBlob(hwBlob2, i * 40);
        }
        hwBlob.putBlob(j2 + 0, hwBlob2);
        int size2 = this.configArray.size();
        long j3 = j + 32;
        hwBlob.putInt32(8 + j3, size2);
        hwBlob.putBool(j3 + 12, false);
        HwBlob hwBlob3 = new HwBlob(size2 * 4);
        for (int i2 = 0; i2 < size2; i2++) {
            hwBlob3.putInt32(i2 * 4, this.configArray.get(i2).intValue());
        }
        hwBlob.putBlob(j3 + 0, hwBlob3);
        hwBlob.putString(j + 48, this.configString);
        hwBlob.putFloat(j + 64, this.minSampleRate);
        hwBlob.putFloat(j + 68, this.maxSampleRate);
    }
}
