package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleVendorPermission {
    public static final int PERMISSION_DEFAULT = 0;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_1 = 69632;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_10 = 659456;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_2 = 135168;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_3 = 200704;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_4 = 266240;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_5 = 331776;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_6 = 397312;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_7 = 462848;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_8 = 528384;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_9 = 593920;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_DOOR = 4;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_ENGINE = 12;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_HVAC = 14;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_INFO = 10;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_LIGHT = 16;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_MIRROR = 8;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_SEAT = 6;
    public static final int PERMISSION_GET_VENDOR_CATEGORY_WINDOW = 2;
    public static final int PERMISSION_NOT_ACCESSIBLE = -268435456;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_1 = 65536;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_10 = 655360;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_2 = 131072;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_3 = 196608;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_4 = 262144;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_5 = 327680;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_6 = 393216;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_7 = 458752;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_8 = 524288;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_9 = 589824;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_DOOR = 3;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_ENGINE = 11;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_HVAC = 13;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_INFO = 9;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_LIGHT = 15;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_MIRROR = 7;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_SEAT = 5;
    public static final int PERMISSION_SET_VENDOR_CATEGORY_WINDOW = 1;

    public static final String toString(int i) {
        return i == 0 ? "PERMISSION_DEFAULT" : i == 1 ? "PERMISSION_SET_VENDOR_CATEGORY_WINDOW" : i == 2 ? "PERMISSION_GET_VENDOR_CATEGORY_WINDOW" : i == 3 ? "PERMISSION_SET_VENDOR_CATEGORY_DOOR" : i == 4 ? "PERMISSION_GET_VENDOR_CATEGORY_DOOR" : i == 5 ? "PERMISSION_SET_VENDOR_CATEGORY_SEAT" : i == 6 ? "PERMISSION_GET_VENDOR_CATEGORY_SEAT" : i == 7 ? "PERMISSION_SET_VENDOR_CATEGORY_MIRROR" : i == 8 ? "PERMISSION_GET_VENDOR_CATEGORY_MIRROR" : i == 9 ? "PERMISSION_SET_VENDOR_CATEGORY_INFO" : i == 10 ? "PERMISSION_GET_VENDOR_CATEGORY_INFO" : i == 11 ? "PERMISSION_SET_VENDOR_CATEGORY_ENGINE" : i == 12 ? "PERMISSION_GET_VENDOR_CATEGORY_ENGINE" : i == 13 ? "PERMISSION_SET_VENDOR_CATEGORY_HVAC" : i == 14 ? "PERMISSION_GET_VENDOR_CATEGORY_HVAC" : i == 15 ? "PERMISSION_SET_VENDOR_CATEGORY_LIGHT" : i == 16 ? "PERMISSION_GET_VENDOR_CATEGORY_LIGHT" : i == 65536 ? "PERMISSION_SET_VENDOR_CATEGORY_1" : i == 69632 ? "PERMISSION_GET_VENDOR_CATEGORY_1" : i == 131072 ? "PERMISSION_SET_VENDOR_CATEGORY_2" : i == 135168 ? "PERMISSION_GET_VENDOR_CATEGORY_2" : i == 196608 ? "PERMISSION_SET_VENDOR_CATEGORY_3" : i == 200704 ? "PERMISSION_GET_VENDOR_CATEGORY_3" : i == 262144 ? "PERMISSION_SET_VENDOR_CATEGORY_4" : i == 266240 ? "PERMISSION_GET_VENDOR_CATEGORY_4" : i == 327680 ? "PERMISSION_SET_VENDOR_CATEGORY_5" : i == 331776 ? "PERMISSION_GET_VENDOR_CATEGORY_5" : i == 393216 ? "PERMISSION_SET_VENDOR_CATEGORY_6" : i == 397312 ? "PERMISSION_GET_VENDOR_CATEGORY_6" : i == 458752 ? "PERMISSION_SET_VENDOR_CATEGORY_7" : i == 462848 ? "PERMISSION_GET_VENDOR_CATEGORY_7" : i == 524288 ? "PERMISSION_SET_VENDOR_CATEGORY_8" : i == 528384 ? "PERMISSION_GET_VENDOR_CATEGORY_8" : i == 589824 ? "PERMISSION_SET_VENDOR_CATEGORY_9" : i == 593920 ? "PERMISSION_GET_VENDOR_CATEGORY_9" : i == 655360 ? "PERMISSION_SET_VENDOR_CATEGORY_10" : i == 659456 ? "PERMISSION_GET_VENDOR_CATEGORY_10" : i == -268435456 ? "PERMISSION_NOT_ACCESSIBLE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("PERMISSION_DEFAULT");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_WINDOW");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_WINDOW");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_DOOR");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_DOOR");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_SEAT");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_SEAT");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_MIRROR");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_MIRROR");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_INFO");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_INFO");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_ENGINE");
            i2 |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_ENGINE");
            i2 |= 12;
        }
        if ((i & 13) == 13) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_HVAC");
            i2 |= 13;
        }
        if ((i & 14) == 14) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_HVAC");
            i2 |= 14;
        }
        if ((i & 15) == 15) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_LIGHT");
            i2 |= 15;
        }
        if ((i & 16) == 16) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_LIGHT");
            i2 |= 16;
        }
        if ((i & 65536) == 65536) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_1");
            i2 |= 65536;
        }
        if ((i & PERMISSION_GET_VENDOR_CATEGORY_1) == 69632) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_1");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_1;
        }
        if ((i & 131072) == 131072) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_2");
            i2 |= 131072;
        }
        if ((i & PERMISSION_GET_VENDOR_CATEGORY_2) == 135168) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_2");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_2;
        }
        if ((i & PERMISSION_SET_VENDOR_CATEGORY_3) == 196608) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_3");
            i2 |= PERMISSION_SET_VENDOR_CATEGORY_3;
        }
        if ((i & PERMISSION_GET_VENDOR_CATEGORY_3) == 200704) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_3");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_3;
        }
        if ((262144 & i) == 262144) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_4");
            i2 |= 262144;
        }
        if ((266240 & i) == 266240) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_4");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_4;
        }
        if ((327680 & i) == 327680) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_5");
            i2 |= PERMISSION_SET_VENDOR_CATEGORY_5;
        }
        if ((331776 & i) == 331776) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_5");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_5;
        }
        if ((393216 & i) == 393216) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_6");
            i2 |= PERMISSION_SET_VENDOR_CATEGORY_6;
        }
        if ((397312 & i) == 397312) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_6");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_6;
        }
        if ((458752 & i) == 458752) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_7");
            i2 |= PERMISSION_SET_VENDOR_CATEGORY_7;
        }
        if ((462848 & i) == 462848) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_7");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_7;
        }
        if ((524288 & i) == 524288) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_8");
            i2 |= 524288;
        }
        if ((528384 & i) == 528384) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_8");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_8;
        }
        if ((589824 & i) == 589824) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_9");
            i2 |= PERMISSION_SET_VENDOR_CATEGORY_9;
        }
        if ((593920 & i) == 593920) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_9");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_9;
        }
        if ((655360 & i) == 655360) {
            arrayList.add("PERMISSION_SET_VENDOR_CATEGORY_10");
            i2 |= PERMISSION_SET_VENDOR_CATEGORY_10;
        }
        if ((659456 & i) == 659456) {
            arrayList.add("PERMISSION_GET_VENDOR_CATEGORY_10");
            i2 |= PERMISSION_GET_VENDOR_CATEGORY_10;
        }
        if (((-268435456) & i) == -268435456) {
            arrayList.add("PERMISSION_NOT_ACCESSIBLE");
            i2 |= -268435456;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
