package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class PortLocationType {
    public static final int FRONT = 5;
    public static final int FRONT_LEFT = 1;
    public static final int FRONT_RIGHT = 2;
    public static final int REAR = 6;
    public static final int REAR_LEFT = 4;
    public static final int REAR_RIGHT = 3;
    public static final int UNKNOWN = 0;

    public static final String toString(int i) {
        return i == 0 ? "UNKNOWN" : i == 1 ? "FRONT_LEFT" : i == 2 ? "FRONT_RIGHT" : i == 3 ? "REAR_RIGHT" : i == 4 ? "REAR_LEFT" : i == 5 ? "FRONT" : i == 6 ? "REAR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UNKNOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("FRONT_LEFT");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("FRONT_RIGHT");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("REAR_RIGHT");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("REAR_LEFT");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("FRONT");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("REAR");
            i2 |= 6;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
