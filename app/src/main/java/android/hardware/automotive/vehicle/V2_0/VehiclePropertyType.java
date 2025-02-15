package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehiclePropertyType {
    public static final int BOOLEAN = 2097152;
    public static final int BYTES = 7340032;
    public static final int FLOAT = 6291456;
    public static final int FLOAT_VEC = 6356992;
    public static final int INT32 = 4194304;
    public static final int INT32_VEC = 4259840;
    public static final int INT64 = 5242880;
    public static final int INT64_VEC = 5308416;
    public static final int MASK = 16711680;
    public static final int MIXED = 14680064;
    public static final int STRING = 1048576;

    public static final String toString(int i) {
        return i == 1048576 ? "STRING" : i == 2097152 ? "BOOLEAN" : i == 4194304 ? "INT32" : i == 4259840 ? "INT32_VEC" : i == 5242880 ? "INT64" : i == 5308416 ? "INT64_VEC" : i == 6291456 ? "FLOAT" : i == 6356992 ? "FLOAT_VEC" : i == 7340032 ? "BYTES" : i == 14680064 ? "MIXED" : i == 16711680 ? "MASK" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1048576;
        if ((i & 1048576) == 1048576) {
            arrayList.add("STRING");
        } else {
            i2 = 0;
        }
        if ((i & 2097152) == 2097152) {
            arrayList.add("BOOLEAN");
            i2 |= 2097152;
        }
        if ((i & 4194304) == 4194304) {
            arrayList.add("INT32");
            i2 |= 4194304;
        }
        if ((i & 4259840) == 4259840) {
            arrayList.add("INT32_VEC");
            i2 |= 4259840;
        }
        if ((i & 5242880) == 5242880) {
            arrayList.add("INT64");
            i2 |= 5242880;
        }
        if ((i & 5308416) == 5308416) {
            arrayList.add("INT64_VEC");
            i2 |= 5308416;
        }
        if ((i & 6291456) == 6291456) {
            arrayList.add("FLOAT");
            i2 |= 6291456;
        }
        if ((i & 6356992) == 6356992) {
            arrayList.add("FLOAT_VEC");
            i2 |= 6356992;
        }
        if ((i & 7340032) == 7340032) {
            arrayList.add("BYTES");
            i2 |= 7340032;
        }
        if ((i & 14680064) == 14680064) {
            arrayList.add("MIXED");
            i2 |= 14680064;
        }
        if ((i & 16711680) == 16711680) {
            arrayList.add("MASK");
            i2 |= 16711680;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
