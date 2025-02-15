package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleAreaDoor {
    public static final int HOOD = 268435456;
    public static final int REAR = 536870912;
    public static final int ROW_1_LEFT = 1;
    public static final int ROW_1_RIGHT = 4;
    public static final int ROW_2_LEFT = 16;
    public static final int ROW_2_RIGHT = 64;
    public static final int ROW_3_LEFT = 256;
    public static final int ROW_3_RIGHT = 1024;

    public static final String toString(int i) {
        return i == 1 ? "ROW_1_LEFT" : i == 4 ? "ROW_1_RIGHT" : i == 16 ? "ROW_2_LEFT" : i == 64 ? "ROW_2_RIGHT" : i == 256 ? "ROW_3_LEFT" : i == 1024 ? "ROW_3_RIGHT" : i == 268435456 ? "HOOD" : i == 536870912 ? "REAR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ROW_1_LEFT");
        } else {
            i2 = 0;
        }
        if ((i & 4) == 4) {
            arrayList.add("ROW_1_RIGHT");
            i2 |= 4;
        }
        if ((i & 16) == 16) {
            arrayList.add("ROW_2_LEFT");
            i2 |= 16;
        }
        if ((i & 64) == 64) {
            arrayList.add("ROW_2_RIGHT");
            i2 |= 64;
        }
        if ((i & 256) == 256) {
            arrayList.add("ROW_3_LEFT");
            i2 |= 256;
        }
        if ((i & 1024) == 1024) {
            arrayList.add("ROW_3_RIGHT");
            i2 |= 1024;
        }
        if ((i & 268435456) == 268435456) {
            arrayList.add("HOOD");
            i2 |= 268435456;
        }
        if ((i & 536870912) == 536870912) {
            arrayList.add("REAR");
            i2 |= 536870912;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
