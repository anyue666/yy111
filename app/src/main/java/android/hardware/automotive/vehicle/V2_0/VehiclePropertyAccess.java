package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehiclePropertyAccess {
    public static final int NONE = 0;
    public static final int READ = 1;
    public static final int READ_WRITE = 3;
    public static final int WRITE = 2;

    public static final String toString(int i) {
        return i == 0 ? "NONE" : i == 1 ? "READ" : i == 2 ? "WRITE" : i == 3 ? "READ_WRITE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("NONE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("READ");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("WRITE");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("READ_WRITE");
            i2 |= 3;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
