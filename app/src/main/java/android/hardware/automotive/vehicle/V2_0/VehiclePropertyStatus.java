package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehiclePropertyStatus {
    public static final int AVAILABLE = 0;
    public static final int ERROR = 2;
    public static final int UNAVAILABLE = 1;

    public static final String toString(int i) {
        return i == 0 ? "AVAILABLE" : i == 1 ? "UNAVAILABLE" : i == 2 ? "ERROR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("AVAILABLE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("UNAVAILABLE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("ERROR");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
