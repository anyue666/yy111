package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VmsBaseMessageIntegerValuesIndex {
    public static final int MESSAGE_TYPE = 0;

    public static final String toString(int i) {
        return i == 0 ? "MESSAGE_TYPE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MESSAGE_TYPE");
        if (i != 0) {
            arrayList.add("0x" + Integer.toHexString(i & (-1)));
        }
        return String.join(" | ", arrayList);
    }
}
