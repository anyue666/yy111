package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VmsOfferingMessageIntegerValuesIndex {
    public static final int MESSAGE_TYPE = 0;
    public static final int NUMBER_OF_OFFERS = 2;
    public static final int OFFERING_START = 3;
    public static final int PUBLISHER_ID = 1;

    public static final String toString(int i) {
        return i == 0 ? "MESSAGE_TYPE" : i == 1 ? "PUBLISHER_ID" : i == 2 ? "NUMBER_OF_OFFERS" : i == 3 ? "OFFERING_START" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MESSAGE_TYPE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("PUBLISHER_ID");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("NUMBER_OF_OFFERS");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("OFFERING_START");
            i2 |= 3;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
