package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehiclePropertyChangeMode {
    public static final int CONTINUOUS = 2;
    public static final int ON_CHANGE = 1;
    public static final int STATIC = 0;

    public static final String toString(int i) {
        return i == 0 ? "STATIC" : i == 1 ? "ON_CHANGE" : i == 2 ? "CONTINUOUS" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("STATIC");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ON_CHANGE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CONTINUOUS");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
