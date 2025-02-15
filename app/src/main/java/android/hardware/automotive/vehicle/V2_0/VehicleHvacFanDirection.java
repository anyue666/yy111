package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleHvacFanDirection {
    public static final int DEFROST = 4;
    public static final int DEFROST_AND_FLOOR = 6;
    public static final int FACE = 1;
    public static final int FACE_AND_FLOOR = 3;
    public static final int FLOOR = 2;
    public static final int UNKNOWN = 0;

    public static final String toString(int i) {
        return i == 0 ? "UNKNOWN" : i == 1 ? "FACE" : i == 2 ? "FLOOR" : i == 3 ? "FACE_AND_FLOOR" : i == 4 ? "DEFROST" : i == 6 ? "DEFROST_AND_FLOOR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UNKNOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("FACE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("FLOOR");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("FACE_AND_FLOOR");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("DEFROST");
            i2 |= 4;
        }
        if ((i & 6) == 6) {
            arrayList.add("DEFROST_AND_FLOOR");
            i2 |= 6;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
