package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleIgnitionState {
    public static final int ACC = 3;
    public static final int LOCK = 1;
    public static final int OFF = 2;
    public static final int ON = 4;
    public static final int START = 5;
    public static final int UNDEFINED = 0;

    public static final String toString(int i) {
        return i == 0 ? "UNDEFINED" : i == 1 ? "LOCK" : i == 2 ? "OFF" : i == 3 ? "ACC" : i == 4 ? "ON" : i == 5 ? "START" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UNDEFINED");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("LOCK");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("OFF");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("ACC");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("ON");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("START");
            i2 |= 5;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
