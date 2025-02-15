package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleAreaWindow {
    public static final int FRONT_WINDSHIELD = 1;
    public static final int REAR_WINDSHIELD = 2;
    public static final int ROOF_TOP_1 = 65536;
    public static final int ROOF_TOP_2 = 131072;
    public static final int ROW_1_LEFT = 16;
    public static final int ROW_1_RIGHT = 64;
    public static final int ROW_2_LEFT = 256;
    public static final int ROW_2_RIGHT = 1024;
    public static final int ROW_3_LEFT = 4096;
    public static final int ROW_3_RIGHT = 16384;

    public static final String toString(int i) {
        return i == 1 ? "FRONT_WINDSHIELD" : i == 2 ? "REAR_WINDSHIELD" : i == 16 ? "ROW_1_LEFT" : i == 64 ? "ROW_1_RIGHT" : i == 256 ? "ROW_2_LEFT" : i == 1024 ? "ROW_2_RIGHT" : i == 4096 ? "ROW_3_LEFT" : i == 16384 ? "ROW_3_RIGHT" : i == 65536 ? "ROOF_TOP_1" : i == 131072 ? "ROOF_TOP_2" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("FRONT_WINDSHIELD");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("REAR_WINDSHIELD");
            i2 |= 2;
        }
        if ((i & 16) == 16) {
            arrayList.add("ROW_1_LEFT");
            i2 |= 16;
        }
        if ((i & 64) == 64) {
            arrayList.add("ROW_1_RIGHT");
            i2 |= 64;
        }
        if ((i & 256) == 256) {
            arrayList.add("ROW_2_LEFT");
            i2 |= 256;
        }
        if ((i & 1024) == 1024) {
            arrayList.add("ROW_2_RIGHT");
            i2 |= 1024;
        }
        if ((i & 4096) == 4096) {
            arrayList.add("ROW_3_LEFT");
            i2 |= 4096;
        }
        if ((i & 16384) == 16384) {
            arrayList.add("ROW_3_RIGHT");
            i2 |= 16384;
        }
        if ((i & 65536) == 65536) {
            arrayList.add("ROOF_TOP_1");
            i2 |= 65536;
        }
        if ((i & 131072) == 131072) {
            arrayList.add("ROOF_TOP_2");
            i2 |= 131072;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
