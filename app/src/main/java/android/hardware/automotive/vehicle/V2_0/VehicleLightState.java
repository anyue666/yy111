package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleLightState {
    public static final int DAYTIME_RUNNING = 2;
    public static final int OFF = 0;
    public static final int ON = 1;

    public static final String toString(int i) {
        return i == 0 ? "OFF" : i == 1 ? "ON" : i == 2 ? "DAYTIME_RUNNING" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("OFF");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ON");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("DAYTIME_RUNNING");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
