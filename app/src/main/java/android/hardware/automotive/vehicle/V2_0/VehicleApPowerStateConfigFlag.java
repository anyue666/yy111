package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleApPowerStateConfigFlag {
    public static final int CONFIG_SUPPORT_TIMER_POWER_ON_FLAG = 2;
    public static final int ENABLE_DEEP_SLEEP_FLAG = 1;

    public static final String toString(int i) {
        return i == 1 ? "ENABLE_DEEP_SLEEP_FLAG" : i == 2 ? "CONFIG_SUPPORT_TIMER_POWER_ON_FLAG" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ENABLE_DEEP_SLEEP_FLAG");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CONFIG_SUPPORT_TIMER_POWER_ON_FLAG");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
