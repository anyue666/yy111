package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleHwKeyInputAction {
    public static final int ACTION_DOWN = 0;
    public static final int ACTION_UP = 1;

    public static final String toString(int i) {
        return i == 0 ? "ACTION_DOWN" : i == 1 ? "ACTION_UP" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ACTION_DOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ACTION_UP");
        } else {
            i2 = 0;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
