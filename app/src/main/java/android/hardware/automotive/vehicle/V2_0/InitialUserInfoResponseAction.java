package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class InitialUserInfoResponseAction {
    public static final int CREATE = 2;
    public static final int DEFAULT = 0;
    public static final int SWITCH = 1;

    public static final String toString(int i) {
        return i == 0 ? "DEFAULT" : i == 1 ? "SWITCH" : i == 2 ? "CREATE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("DEFAULT");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SWITCH");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CREATE");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
