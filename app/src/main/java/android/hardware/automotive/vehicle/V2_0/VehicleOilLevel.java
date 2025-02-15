package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleOilLevel {
    public static final int CRITICALLY_LOW = 0;
    public static final int ERROR = 4;
    public static final int HIGH = 3;
    public static final int LOW = 1;
    public static final int NORMAL = 2;

    public static final String toString(int i) {
        return i == 0 ? "CRITICALLY_LOW" : i == 1 ? "LOW" : i == 2 ? "NORMAL" : i == 3 ? "HIGH" : i == 4 ? "ERROR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("CRITICALLY_LOW");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("LOW");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("NORMAL");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("HIGH");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("ERROR");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
