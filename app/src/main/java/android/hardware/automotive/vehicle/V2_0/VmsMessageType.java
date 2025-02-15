package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VmsMessageType {
    public static final int AVAILABILITY_CHANGE = 9;
    public static final int AVAILABILITY_REQUEST = 6;
    public static final int AVAILABILITY_RESPONSE = 8;
    public static final int DATA = 12;
    public static final int LAST_VMS_MESSAGE_TYPE = 17;
    public static final int OFFERING = 5;
    public static final int PUBLISHER_ID_REQUEST = 13;
    public static final int PUBLISHER_ID_RESPONSE = 14;
    public static final int PUBLISHER_INFORMATION_REQUEST = 15;
    public static final int PUBLISHER_INFORMATION_RESPONSE = 16;
    public static final int START_SESSION = 17;
    public static final int SUBSCRIBE = 1;
    public static final int SUBSCRIBE_TO_PUBLISHER = 2;
    public static final int SUBSCRIPTIONS_CHANGE = 11;
    public static final int SUBSCRIPTIONS_REQUEST = 7;
    public static final int SUBSCRIPTIONS_RESPONSE = 10;
    public static final int UNSUBSCRIBE = 3;
    public static final int UNSUBSCRIBE_TO_PUBLISHER = 4;

    public static final String toString(int i) {
        return i == 1 ? "SUBSCRIBE" : i == 2 ? "SUBSCRIBE_TO_PUBLISHER" : i == 3 ? "UNSUBSCRIBE" : i == 4 ? "UNSUBSCRIBE_TO_PUBLISHER" : i == 5 ? "OFFERING" : i == 6 ? "AVAILABILITY_REQUEST" : i == 7 ? "SUBSCRIPTIONS_REQUEST" : i == 8 ? "AVAILABILITY_RESPONSE" : i == 9 ? "AVAILABILITY_CHANGE" : i == 10 ? "SUBSCRIPTIONS_RESPONSE" : i == 11 ? "SUBSCRIPTIONS_CHANGE" : i == 12 ? "DATA" : i == 13 ? "PUBLISHER_ID_REQUEST" : i == 14 ? "PUBLISHER_ID_RESPONSE" : i == 15 ? "PUBLISHER_INFORMATION_REQUEST" : i == 16 ? "PUBLISHER_INFORMATION_RESPONSE" : i == 17 ? "START_SESSION" : i == 17 ? "LAST_VMS_MESSAGE_TYPE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("SUBSCRIBE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("SUBSCRIBE_TO_PUBLISHER");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("UNSUBSCRIBE");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("UNSUBSCRIBE_TO_PUBLISHER");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("OFFERING");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("AVAILABILITY_REQUEST");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("SUBSCRIPTIONS_REQUEST");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("AVAILABILITY_RESPONSE");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("AVAILABILITY_CHANGE");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("SUBSCRIPTIONS_RESPONSE");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("SUBSCRIPTIONS_CHANGE");
            i2 |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("DATA");
            i2 |= 12;
        }
        if ((i & 13) == 13) {
            arrayList.add("PUBLISHER_ID_REQUEST");
            i2 |= 13;
        }
        if ((i & 14) == 14) {
            arrayList.add("PUBLISHER_ID_RESPONSE");
            i2 |= 14;
        }
        if ((i & 15) == 15) {
            arrayList.add("PUBLISHER_INFORMATION_REQUEST");
            i2 |= 15;
        }
        if ((i & 16) == 16) {
            arrayList.add("PUBLISHER_INFORMATION_RESPONSE");
            i2 |= 16;
        }
        int i3 = i & 17;
        if (i3 == 17) {
            arrayList.add("START_SESSION");
            i2 |= 17;
        }
        if (i3 == 17) {
            arrayList.add("LAST_VMS_MESSAGE_TYPE");
            i2 |= 17;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
