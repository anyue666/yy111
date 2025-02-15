package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VmsSubscriptionsStateIntegerValuesIndex {
    public static final int MESSAGE_TYPE = 0;
    public static final int NUMBER_OF_ASSOCIATED_LAYERS = 3;
    public static final int NUMBER_OF_LAYERS = 2;
    public static final int SEQUENCE_NUMBER = 1;
    public static final int SUBSCRIPTIONS_START = 4;

    public static final String toString(int i) {
        return i == 0 ? "MESSAGE_TYPE" : i == 1 ? "SEQUENCE_NUMBER" : i == 2 ? "NUMBER_OF_LAYERS" : i == 3 ? "NUMBER_OF_ASSOCIATED_LAYERS" : i == 4 ? "SUBSCRIPTIONS_START" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MESSAGE_TYPE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SEQUENCE_NUMBER");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("NUMBER_OF_LAYERS");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("NUMBER_OF_ASSOCIATED_LAYERS");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("SUBSCRIPTIONS_START");
            i2 |= 4;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
