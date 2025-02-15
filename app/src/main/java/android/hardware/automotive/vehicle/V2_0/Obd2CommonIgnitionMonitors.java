package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Obd2CommonIgnitionMonitors {
    public static final int COMPONENTS_AVAILABLE = 1;
    public static final int COMPONENTS_INCOMPLETE = 2;
    public static final int FUEL_SYSTEM_AVAILABLE = 4;
    public static final int FUEL_SYSTEM_INCOMPLETE = 8;
    public static final int MISFIRE_AVAILABLE = 16;
    public static final int MISFIRE_INCOMPLETE = 32;

    public static final String toString(int i) {
        return i == 1 ? "COMPONENTS_AVAILABLE" : i == 2 ? "COMPONENTS_INCOMPLETE" : i == 4 ? "FUEL_SYSTEM_AVAILABLE" : i == 8 ? "FUEL_SYSTEM_INCOMPLETE" : i == 16 ? "MISFIRE_AVAILABLE" : i == 32 ? "MISFIRE_INCOMPLETE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("COMPONENTS_AVAILABLE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("COMPONENTS_INCOMPLETE");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("FUEL_SYSTEM_AVAILABLE");
            i2 |= 4;
        }
        if ((i & 8) == 8) {
            arrayList.add("FUEL_SYSTEM_INCOMPLETE");
            i2 |= 8;
        }
        if ((i & 16) == 16) {
            arrayList.add("MISFIRE_AVAILABLE");
            i2 |= 16;
        }
        if ((i & 32) == 32) {
            arrayList.add("MISFIRE_INCOMPLETE");
            i2 |= 32;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
