package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class UserFlags {
    public static final int ADMIN = 8;
    public static final int DISABLED = 16;
    public static final int EPHEMERAL = 4;
    public static final int GUEST = 2;
    public static final int NONE = 0;
    public static final int PROFILE = 32;
    public static final int SYSTEM = 1;

    public static final String toString(int i) {
        return i == 0 ? "NONE" : i == 1 ? "SYSTEM" : i == 2 ? "GUEST" : i == 4 ? "EPHEMERAL" : i == 8 ? "ADMIN" : i == 16 ? "DISABLED" : i == 32 ? "PROFILE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("NONE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SYSTEM");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("GUEST");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("EPHEMERAL");
            i2 |= 4;
        }
        if ((i & 8) == 8) {
            arrayList.add("ADMIN");
            i2 |= 8;
        }
        if ((i & 16) == 16) {
            arrayList.add("DISABLED");
            i2 |= 16;
        }
        if ((i & 32) == 32) {
            arrayList.add("PROFILE");
            i2 |= 32;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
