package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class VehiclePropValue {
    public long timestamp = 0;
    public int areaId = 0;
    public int prop = 0;
    public int status = 0;
    public RawValue value = new RawValue();

    public static final class RawValue {
        public ArrayList<Integer> int32Values = new ArrayList<>();
        public ArrayList<Float> floatValues = new ArrayList<>();
        public ArrayList<Long> int64Values = new ArrayList<>();
        public ArrayList<Byte> bytes = new ArrayList<>();
        public String stringValue = new String();

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != RawValue.class) {
                return false;
            }
            RawValue rawValue = (RawValue) obj;
            return HidlSupport.deepEquals(this.int32Values, rawValue.int32Values) && HidlSupport.deepEquals(this.floatValues, rawValue.floatValues) && HidlSupport.deepEquals(this.int64Values, rawValue.int64Values) && HidlSupport.deepEquals(this.bytes, rawValue.bytes) && HidlSupport.deepEquals(this.stringValue, rawValue.stringValue);
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(this.int32Values)), Integer.valueOf(HidlSupport.deepHashCode(this.floatValues)), Integer.valueOf(HidlSupport.deepHashCode(this.int64Values)), Integer.valueOf(HidlSupport.deepHashCode(this.bytes)), Integer.valueOf(HidlSupport.deepHashCode(this.stringValue)));
        }

        public final String toString() {
            return "{.int32Values = " + this.int32Values + ", .floatValues = " + this.floatValues + ", .int64Values = " + this.int64Values + ", .bytes = " + this.bytes + ", .stringValue = " + this.stringValue + "}";
        }

        public final void readFromParcel(HwParcel hwParcel) {
            readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(80L), 0L);
        }

        public static final ArrayList<RawValue> readVectorFromParcel(HwParcel hwParcel) {
            ArrayList<RawValue> arrayList = new ArrayList<>();
            HwBlob readBuffer = hwParcel.readBuffer(16L);
            int int32 = readBuffer.getInt32(8L);
            HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 80, readBuffer.handle(), 0L, true);
            arrayList.clear();
            for (int i = 0; i < int32; i++) {
                RawValue rawValue = new RawValue();
                rawValue.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 80);
                arrayList.add(rawValue);
            }
            return arrayList;
        }

        public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
            long j2 = j + 0;
            int int32 = hwBlob.getInt32(j2 + 8);
            HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 4, hwBlob.handle(), j2 + 0, true);
            this.int32Values.clear();
            for (int i = 0; i < int32; i++) {
                this.int32Values.add(Integer.valueOf(readEmbeddedBuffer.getInt32(i * 4)));
            }
            long j3 = j + 16;
            int int322 = hwBlob.getInt32(j3 + 8);
            HwBlob readEmbeddedBuffer2 = hwParcel.readEmbeddedBuffer(int322 * 4, hwBlob.handle(), j3 + 0, true);
            this.floatValues.clear();
            for (int i2 = 0; i2 < int322; i2++) {
                this.floatValues.add(Float.valueOf(readEmbeddedBuffer2.getFloat(i2 * 4)));
            }
            long j4 = j + 32;
            int int323 = hwBlob.getInt32(j4 + 8);
            HwBlob readEmbeddedBuffer3 = hwParcel.readEmbeddedBuffer(int323 * 8, hwBlob.handle(), j4 + 0, true);
            this.int64Values.clear();
            for (int i3 = 0; i3 < int323; i3++) {
                this.int64Values.add(Long.valueOf(readEmbeddedBuffer3.getInt64(i3 * 8)));
            }
            long j5 = j + 48;
            int int324 = hwBlob.getInt32(8 + j5);
            HwBlob readEmbeddedBuffer4 = hwParcel.readEmbeddedBuffer(int324 * 1, hwBlob.handle(), j5 + 0, true);
            this.bytes.clear();
            for (int i4 = 0; i4 < int324; i4++) {
                this.bytes.add(Byte.valueOf(readEmbeddedBuffer4.getInt8(i4 * 1)));
            }
            long j6 = j + 64;
            this.stringValue = hwBlob.getString(j6);
            hwParcel.readEmbeddedBuffer(r6.getBytes().length + 1, hwBlob.handle(), j6 + 0, false);
        }

        public final void writeToParcel(HwParcel hwParcel) {
            HwBlob hwBlob = new HwBlob(80);
            writeEmbeddedToBlob(hwBlob, 0L);
            hwParcel.writeBuffer(hwBlob);
        }

        public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<RawValue> arrayList) {
            HwBlob hwBlob = new HwBlob(16);
            int size = arrayList.size();
            hwBlob.putInt32(8L, size);
            hwBlob.putBool(12L, false);
            HwBlob hwBlob2 = new HwBlob(size * 80);
            for (int i = 0; i < size; i++) {
                arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 80);
            }
            hwBlob.putBlob(0L, hwBlob2);
            hwParcel.writeBuffer(hwBlob);
        }

        public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
            int size = this.int32Values.size();
            long j2 = j + 0;
            hwBlob.putInt32(j2 + 8, size);
            hwBlob.putBool(j2 + 12, false);
            HwBlob hwBlob2 = new HwBlob(size * 4);
            for (int i = 0; i < size; i++) {
                hwBlob2.putInt32(i * 4, this.int32Values.get(i).intValue());
            }
            hwBlob.putBlob(j2 + 0, hwBlob2);
            int size2 = this.floatValues.size();
            long j3 = j + 16;
            hwBlob.putInt32(j3 + 8, size2);
            hwBlob.putBool(j3 + 12, false);
            HwBlob hwBlob3 = new HwBlob(size2 * 4);
            for (int i2 = 0; i2 < size2; i2++) {
                hwBlob3.putFloat(i2 * 4, this.floatValues.get(i2).floatValue());
            }
            hwBlob.putBlob(j3 + 0, hwBlob3);
            int size3 = this.int64Values.size();
            long j4 = j + 32;
            hwBlob.putInt32(j4 + 8, size3);
            hwBlob.putBool(j4 + 12, false);
            HwBlob hwBlob4 = new HwBlob(size3 * 8);
            for (int i3 = 0; i3 < size3; i3++) {
                hwBlob4.putInt64(i3 * 8, this.int64Values.get(i3).longValue());
            }
            hwBlob.putBlob(j4 + 0, hwBlob4);
            int size4 = this.bytes.size();
            long j5 = j + 48;
            hwBlob.putInt32(8 + j5, size4);
            hwBlob.putBool(j5 + 12, false);
            HwBlob hwBlob5 = new HwBlob(size4 * 1);
            for (int i4 = 0; i4 < size4; i4++) {
                hwBlob5.putInt8(i4 * 1, this.bytes.get(i4).byteValue());
            }
            hwBlob.putBlob(j5 + 0, hwBlob5);
            hwBlob.putString(j + 64, this.stringValue);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != VehiclePropValue.class) {
            return false;
        }
        VehiclePropValue vehiclePropValue = (VehiclePropValue) obj;
        return this.timestamp == vehiclePropValue.timestamp && this.areaId == vehiclePropValue.areaId && this.prop == vehiclePropValue.prop && this.status == vehiclePropValue.status && HidlSupport.deepEquals(this.value, vehiclePropValue.value);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Long.valueOf(this.timestamp))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.areaId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.prop))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.status))), Integer.valueOf(HidlSupport.deepHashCode(this.value)));
    }

    public final String toString() {
        return "{.timestamp = " + this.timestamp + ", .areaId = " + this.areaId + ", .prop = " + this.prop + ", .status = " + VehiclePropertyStatus.toString(this.status) + ", .value = " + this.value + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(104L), 0L);
    }

    public static final ArrayList<VehiclePropValue> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<VehiclePropValue> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 104, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            VehiclePropValue vehiclePropValue = new VehiclePropValue();
            vehiclePropValue.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 104);
            arrayList.add(vehiclePropValue);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.timestamp = hwBlob.getInt64(0 + j);
        this.areaId = hwBlob.getInt32(8 + j);
        this.prop = hwBlob.getInt32(12 + j);
        this.status = hwBlob.getInt32(16 + j);
        this.value.readEmbeddedFromParcel(hwParcel, hwBlob, j + 24);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(104);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<VehiclePropValue> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 104);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 104);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt64(0 + j, this.timestamp);
        hwBlob.putInt32(8 + j, this.areaId);
        hwBlob.putInt32(12 + j, this.prop);
        hwBlob.putInt32(16 + j, this.status);
        this.value.writeEmbeddedToBlob(hwBlob, j + 24);
    }
}
