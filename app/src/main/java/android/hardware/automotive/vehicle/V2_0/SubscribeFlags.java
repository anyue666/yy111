package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SubscribeFlags {
    public static final int EVENTS_FROM_ANDROID = 2;
    public static final int EVENTS_FROM_CAR = 1;
    public static final int UNDEFINED = 0;

    public static final String toString(int i) {
        return i == 0 ? "UNDEFINED" : i == 1 ? "EVENTS_FROM_CAR" : i == 2 ? "EVENTS_FROM_ANDROID" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UNDEFINED");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("EVENTS_FROM_CAR");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("EVENTS_FROM_ANDROID");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
