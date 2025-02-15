package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class UserIdentificationAssociationSetValue {
    public static final int ASSOCIATE_CURRENT_USER = 1;
    public static final int DISASSOCIATE_ALL_USERS = 3;
    public static final int DISASSOCIATE_CURRENT_USER = 2;

    public static final String toString(int i) {
        return i == 1 ? "ASSOCIATE_CURRENT_USER" : i == 2 ? "DISASSOCIATE_CURRENT_USER" : i == 3 ? "DISASSOCIATE_ALL_USERS" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ASSOCIATE_CURRENT_USER");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("DISASSOCIATE_CURRENT_USER");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("DISASSOCIATE_ALL_USERS");
            i2 |= 3;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
