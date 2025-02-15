package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VmsMessageWithLayerAndPublisherIdIntegerValuesIndex {
    public static final int LAYER_SUBTYPE = 2;
    public static final int LAYER_TYPE = 1;
    public static final int LAYER_VERSION = 3;
    public static final int MESSAGE_TYPE = 0;
    public static final int PUBLISHER_ID = 4;

    public static final String toString(int i) {
        return i == 0 ? "MESSAGE_TYPE" : i == 1 ? "LAYER_TYPE" : i == 2 ? "LAYER_SUBTYPE" : i == 3 ? "LAYER_VERSION" : i == 4 ? "PUBLISHER_ID" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MESSAGE_TYPE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("LAYER_TYPE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("LAYER_SUBTYPE");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("LAYER_VERSION");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("PUBLISHER_ID");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
