package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehiclePropertyGroup {
    public static final int MASK = -268435456;
    public static final int SYSTEM = 268435456;
    public static final int VENDOR = 536870912;

    public static final String toString(int i) {
        return i == 268435456 ? "SYSTEM" : i == 536870912 ? "VENDOR" : i == -268435456 ? "MASK" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 268435456;
        if ((i & 268435456) == 268435456) {
            arrayList.add("SYSTEM");
        } else {
            i2 = 0;
        }
        if ((i & 536870912) == 536870912) {
            arrayList.add("VENDOR");
            i2 |= 536870912;
        }
        if ((i & (-268435456)) == -268435456) {
            arrayList.add("MASK");
            i2 |= -268435456;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
