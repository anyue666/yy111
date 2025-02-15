package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleApPowerStateReq {
    public static final int CANCEL_SHUTDOWN = 2;
    public static final int FINISHED = 3;
    public static final int ON = 0;
    public static final int SHUTDOWN_PREPARE = 1;

    public static final String toString(int i) {
        return i == 0 ? "ON" : i == 1 ? "SHUTDOWN_PREPARE" : i == 2 ? "CANCEL_SHUTDOWN" : i == 3 ? "FINISHED" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ON");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SHUTDOWN_PREPARE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CANCEL_SHUTDOWN");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("FINISHED");
            i2 |= 3;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
