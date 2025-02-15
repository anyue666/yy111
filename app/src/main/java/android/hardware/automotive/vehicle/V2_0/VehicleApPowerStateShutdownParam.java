package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleApPowerStateShutdownParam {
    public static final int CAN_SLEEP = 2;
    public static final int SHUTDOWN_IMMEDIATELY = 1;
    public static final int SHUTDOWN_ONLY = 3;
    public static final int SLEEP_IMMEDIATELY = 4;

    public static final String toString(int i) {
        return i == 1 ? "SHUTDOWN_IMMEDIATELY" : i == 2 ? "CAN_SLEEP" : i == 3 ? "SHUTDOWN_ONLY" : i == 4 ? "SLEEP_IMMEDIATELY" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SHUTDOWN_IMMEDIATELY");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CAN_SLEEP");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("SHUTDOWN_ONLY");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("SLEEP_IMMEDIATELY");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
