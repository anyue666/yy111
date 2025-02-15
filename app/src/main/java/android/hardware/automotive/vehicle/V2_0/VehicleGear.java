package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleGear {
    public static final int GEAR_1 = 16;
    public static final int GEAR_2 = 32;
    public static final int GEAR_3 = 64;
    public static final int GEAR_4 = 128;
    public static final int GEAR_5 = 256;
    public static final int GEAR_6 = 512;
    public static final int GEAR_7 = 1024;
    public static final int GEAR_8 = 2048;
    public static final int GEAR_9 = 4096;
    public static final int GEAR_DRIVE = 8;
    public static final int GEAR_NEUTRAL = 1;
    public static final int GEAR_PARK = 4;
    public static final int GEAR_REVERSE = 2;
    public static final int GEAR_UNKNOWN = 0;

    public static final String toString(int i) {
        return i == 0 ? "GEAR_UNKNOWN" : i == 1 ? "GEAR_NEUTRAL" : i == 2 ? "GEAR_REVERSE" : i == 4 ? "GEAR_PARK" : i == 8 ? "GEAR_DRIVE" : i == 16 ? "GEAR_1" : i == 32 ? "GEAR_2" : i == 64 ? "GEAR_3" : i == 128 ? "GEAR_4" : i == 256 ? "GEAR_5" : i == 512 ? "GEAR_6" : i == 1024 ? "GEAR_7" : i == 2048 ? "GEAR_8" : i == 4096 ? "GEAR_9" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("GEAR_UNKNOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("GEAR_NEUTRAL");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("GEAR_REVERSE");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("GEAR_PARK");
            i2 |= 4;
        }
        if ((i & 8) == 8) {
            arrayList.add("GEAR_DRIVE");
            i2 |= 8;
        }
        if ((i & 16) == 16) {
            arrayList.add("GEAR_1");
            i2 |= 16;
        }
        if ((i & 32) == 32) {
            arrayList.add("GEAR_2");
            i2 |= 32;
        }
        if ((i & 64) == 64) {
            arrayList.add("GEAR_3");
            i2 |= 64;
        }
        if ((i & 128) == 128) {
            arrayList.add("GEAR_4");
            i2 |= 128;
        }
        if ((i & 256) == 256) {
            arrayList.add("GEAR_5");
            i2 |= 256;
        }
        if ((i & 512) == 512) {
            arrayList.add("GEAR_6");
            i2 |= 512;
        }
        if ((i & 1024) == 1024) {
            arrayList.add("GEAR_7");
            i2 |= 1024;
        }
        if ((i & 2048) == 2048) {
            arrayList.add("GEAR_8");
            i2 |= 2048;
        }
        if ((i & 4096) == 4096) {
            arrayList.add("GEAR_9");
            i2 |= 4096;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
