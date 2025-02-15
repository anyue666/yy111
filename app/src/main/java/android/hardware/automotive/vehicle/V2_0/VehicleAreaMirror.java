package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleAreaMirror {
    public static final int DRIVER_CENTER = 4;
    public static final int DRIVER_LEFT = 1;
    public static final int DRIVER_RIGHT = 2;

    public static final String toString(int i) {
        return i == 1 ? "DRIVER_LEFT" : i == 2 ? "DRIVER_RIGHT" : i == 4 ? "DRIVER_CENTER" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("DRIVER_LEFT");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("DRIVER_RIGHT");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("DRIVER_CENTER");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
