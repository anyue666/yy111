package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VmsStartSessionMessageIntegerValuesIndex {
    public static final int CLIENT_ID = 2;
    public static final int MESSAGE_TYPE = 0;
    public static final int SERVICE_ID = 1;

    public static final String toString(int i) {
        return i == 0 ? "MESSAGE_TYPE" : i == 1 ? "SERVICE_ID" : i == 2 ? "CLIENT_ID" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MESSAGE_TYPE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SERVICE_ID");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("CLIENT_ID");
            i2 |= 2;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
