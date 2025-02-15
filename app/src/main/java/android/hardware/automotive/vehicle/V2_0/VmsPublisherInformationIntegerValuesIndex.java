package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VmsPublisherInformationIntegerValuesIndex {
    public static final int MESSAGE_TYPE = 0;
    public static final int PUBLISHER_ID = 1;

    public static final String toString(int i) {
        return i == 0 ? "MESSAGE_TYPE" : i == 1 ? "PUBLISHER_ID" : "0x" + Integer.toHexString(i);
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
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
