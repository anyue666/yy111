package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleTurnSignal {
    public static final int LEFT = 2;
    public static final int NONE = 0;
    public static final int RIGHT = 1;

    public static final String toString(int i) {
        return i == 0 ? "NONE" : i == 1 ? "RIGHT" : i == 2 ? "LEFT" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("NONE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("RIGHT");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("LEFT");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
