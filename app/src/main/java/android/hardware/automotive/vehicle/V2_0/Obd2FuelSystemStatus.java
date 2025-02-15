package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Obd2FuelSystemStatus {
    public static final int CLOSED_LOOP = 2;
    public static final int CLOSED_LOOP_BUT_FEEDBACK_FAULT = 16;
    public static final int OPEN_ENGINE_LOAD_OR_DECELERATION = 4;
    public static final int OPEN_INSUFFICIENT_ENGINE_TEMPERATURE = 1;
    public static final int OPEN_SYSTEM_FAILURE = 8;

    public static final String toString(int i) {
        return i == 1 ? "OPEN_INSUFFICIENT_ENGINE_TEMPERATURE" : i == 2 ? "CLOSED_LOOP" : i == 4 ? "OPEN_ENGINE_LOAD_OR_DECELERATION" : i == 8 ? "OPEN_SYSTEM_FAILURE" : i == 16 ? "CLOSED_LOOP_BUT_FEEDBACK_FAULT" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("OPEN_INSUFFICIENT_ENGINE_TEMPERATURE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CLOSED_LOOP");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("OPEN_ENGINE_LOAD_OR_DECELERATION");
            i2 |= 4;
        }
        if ((i & 8) == 8) {
            arrayList.add("OPEN_SYSTEM_FAILURE");
            i2 |= 8;
        }
        if ((i & 16) == 16) {
            arrayList.add("CLOSED_LOOP_BUT_FEEDBACK_FAULT");
            i2 |= 16;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
