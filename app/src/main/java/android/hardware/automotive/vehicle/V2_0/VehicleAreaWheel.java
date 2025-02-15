package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleAreaWheel {
    public static final int LEFT_FRONT = 1;
    public static final int LEFT_REAR = 4;
    public static final int RIGHT_FRONT = 2;
    public static final int RIGHT_REAR = 8;
    public static final int UNKNOWN = 0;

    public static final String toString(int i) {
        return i == 0 ? "UNKNOWN" : i == 1 ? "LEFT_FRONT" : i == 2 ? "RIGHT_FRONT" : i == 4 ? "LEFT_REAR" : i == 8 ? "RIGHT_REAR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UNKNOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("LEFT_FRONT");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("RIGHT_FRONT");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("LEFT_REAR");
            i2 |= 4;
        }
        if ((i & 8) == 8) {
            arrayList.add("RIGHT_REAR");
            i2 |= 8;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
