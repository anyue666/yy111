package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Obd2IgnitionMonitorKind {
    public static final int COMPRESSION = 1;
    public static final int SPARK = 0;

    public static final String toString(int i) {
        return i == 0 ? "SPARK" : i == 1 ? "COMPRESSION" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("SPARK");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("COMPRESSION");
        } else {
            i2 = 0;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
