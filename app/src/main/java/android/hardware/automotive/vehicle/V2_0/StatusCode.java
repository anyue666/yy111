package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class StatusCode {
    public static final int ACCESS_DENIED = 4;
    public static final int INTERNAL_ERROR = 5;
    public static final int INVALID_ARG = 2;
    public static final int NOT_AVAILABLE = 3;
    public static final int OK = 0;
    public static final int TRY_AGAIN = 1;

    public static final String toString(int i) {
        return i == 0 ? "OK" : i == 1 ? "TRY_AGAIN" : i == 2 ? "INVALID_ARG" : i == 3 ? "NOT_AVAILABLE" : i == 4 ? "ACCESS_DENIED" : i == 5 ? "INTERNAL_ERROR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("OK");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("TRY_AGAIN");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("INVALID_ARG");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("NOT_AVAILABLE");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("ACCESS_DENIED");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("INTERNAL_ERROR");
            i2 |= 5;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
