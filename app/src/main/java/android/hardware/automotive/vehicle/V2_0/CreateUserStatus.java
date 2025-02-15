package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CreateUserStatus {
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;

    public static final String toString(int i) {
        return i == 1 ? "SUCCESS" : i == 2 ? "FAILURE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SUCCESS");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("FAILURE");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
