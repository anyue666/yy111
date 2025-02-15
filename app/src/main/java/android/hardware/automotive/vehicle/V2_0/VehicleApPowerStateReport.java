package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleApPowerStateReport {
    public static final int DEEP_SLEEP_ENTRY = 2;
    public static final int DEEP_SLEEP_EXIT = 3;
    public static final int ON = 6;
    public static final int SHUTDOWN_CANCELLED = 8;
    public static final int SHUTDOWN_POSTPONE = 4;
    public static final int SHUTDOWN_PREPARE = 7;
    public static final int SHUTDOWN_START = 5;
    public static final int WAIT_FOR_VHAL = 1;

    public static final String toString(int i) {
        return i == 1 ? "WAIT_FOR_VHAL" : i == 2 ? "DEEP_SLEEP_ENTRY" : i == 3 ? "DEEP_SLEEP_EXIT" : i == 4 ? "SHUTDOWN_POSTPONE" : i == 5 ? "SHUTDOWN_START" : i == 6 ? "ON" : i == 7 ? "SHUTDOWN_PREPARE" : i == 8 ? "SHUTDOWN_CANCELLED" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("WAIT_FOR_VHAL");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("DEEP_SLEEP_ENTRY");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("DEEP_SLEEP_EXIT");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("SHUTDOWN_POSTPONE");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("SHUTDOWN_START");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("ON");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("SHUTDOWN_PREPARE");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("SHUTDOWN_CANCELLED");
            i2 |= 8;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
