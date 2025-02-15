package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SwitchUserMessageType {
    public static final int ANDROID_POST_SWITCH = 5;
    public static final int ANDROID_SWITCH = 2;
    public static final int LEGACY_ANDROID_SWITCH = 1;
    public static final int VEHICLE_REQUEST = 4;
    public static final int VEHICLE_RESPONSE = 3;

    public static final String toString(int i) {
        return i == 1 ? "LEGACY_ANDROID_SWITCH" : i == 2 ? "ANDROID_SWITCH" : i == 3 ? "VEHICLE_RESPONSE" : i == 4 ? "VEHICLE_REQUEST" : i == 5 ? "ANDROID_POST_SWITCH" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("LEGACY_ANDROID_SWITCH");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("ANDROID_SWITCH");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("VEHICLE_RESPONSE");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("VEHICLE_REQUEST");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("ANDROID_POST_SWITCH");
            i2 |= 5;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
