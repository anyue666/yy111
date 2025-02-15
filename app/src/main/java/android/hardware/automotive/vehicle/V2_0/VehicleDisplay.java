package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleDisplay {
    public static final int INSTRUMENT_CLUSTER = 1;
    public static final int MAIN = 0;

    public static final String toString(int i) {
        return i == 0 ? "MAIN" : i == 1 ? "INSTRUMENT_CLUSTER" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MAIN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("INSTRUMENT_CLUSTER");
        } else {
            i2 = 0;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
