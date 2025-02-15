package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class UserIdentificationAssociationType {
    public static final int CUSTOM_1 = 101;
    public static final int CUSTOM_2 = 102;
    public static final int CUSTOM_3 = 103;
    public static final int CUSTOM_4 = 104;
    public static final int KEY_FOB = 1;

    public static final String toString(int i) {
        return i == 1 ? "KEY_FOB" : i == 101 ? "CUSTOM_1" : i == 102 ? "CUSTOM_2" : i == 103 ? "CUSTOM_3" : i == 104 ? "CUSTOM_4" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("KEY_FOB");
        } else {
            i2 = 0;
        }
        if ((i & 101) == 101) {
            arrayList.add("CUSTOM_1");
            i2 |= 101;
        }
        if ((i & 102) == 102) {
            arrayList.add("CUSTOM_2");
            i2 |= 102;
        }
        if ((i & 103) == 103) {
            arrayList.add("CUSTOM_3");
            i2 |= 103;
        }
        if ((i & 104) == 104) {
            arrayList.add("CUSTOM_4");
            i2 |= 104;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
