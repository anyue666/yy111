package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleSeatOccupancyState {
    public static final int OCCUPIED = 2;
    public static final int UNKNOWN = 0;
    public static final int VACANT = 1;

    public static final String toString(int i) {
        return i == 0 ? "UNKNOWN" : i == 1 ? "VACANT" : i == 2 ? "OCCUPIED" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UNKNOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("VACANT");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("OCCUPIED");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
