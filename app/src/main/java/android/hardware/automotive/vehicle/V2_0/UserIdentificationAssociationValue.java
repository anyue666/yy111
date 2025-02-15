package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class UserIdentificationAssociationValue {
    public static final int ASSOCIATED_ANOTHER_USER = 3;
    public static final int ASSOCIATED_CURRENT_USER = 2;
    public static final int NOT_ASSOCIATED_ANY_USER = 4;
    public static final int UNKNOWN = 1;

    public static final String toString(int i) {
        return i == 1 ? "UNKNOWN" : i == 2 ? "ASSOCIATED_CURRENT_USER" : i == 3 ? "ASSOCIATED_ANOTHER_USER" : i == 4 ? "NOT_ASSOCIATED_ANY_USER" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("UNKNOWN");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("ASSOCIATED_CURRENT_USER");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("ASSOCIATED_ANOTHER_USER");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("NOT_ASSOCIATED_ANY_USER");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
