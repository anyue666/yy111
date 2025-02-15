package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class InitialUserInfoRequestType {
    public static final int COLD_BOOT = 3;
    public static final int FIRST_BOOT = 1;
    public static final int FIRST_BOOT_AFTER_OTA = 2;
    public static final int RESUME = 4;

    public static final String toString(int i) {
        return i == 1 ? "FIRST_BOOT" : i == 2 ? "FIRST_BOOT_AFTER_OTA" : i == 3 ? "COLD_BOOT" : i == 4 ? "RESUME" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("FIRST_BOOT");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("FIRST_BOOT_AFTER_OTA");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("COLD_BOOT");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("RESUME");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
