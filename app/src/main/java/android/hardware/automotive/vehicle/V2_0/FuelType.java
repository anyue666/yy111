package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class FuelType {
    public static final int FUEL_TYPE_BIODIESEL = 5;
    public static final int FUEL_TYPE_CNG = 8;
    public static final int FUEL_TYPE_DIESEL_1 = 3;
    public static final int FUEL_TYPE_DIESEL_2 = 4;
    public static final int FUEL_TYPE_E85 = 6;
    public static final int FUEL_TYPE_ELECTRIC = 10;
    public static final int FUEL_TYPE_HYDROGEN = 11;
    public static final int FUEL_TYPE_LEADED = 2;
    public static final int FUEL_TYPE_LNG = 9;
    public static final int FUEL_TYPE_LPG = 7;
    public static final int FUEL_TYPE_OTHER = 12;
    public static final int FUEL_TYPE_UNKNOWN = 0;
    public static final int FUEL_TYPE_UNLEADED = 1;

    public static final String toString(int i) {
        return i == 0 ? "FUEL_TYPE_UNKNOWN" : i == 1 ? "FUEL_TYPE_UNLEADED" : i == 2 ? "FUEL_TYPE_LEADED" : i == 3 ? "FUEL_TYPE_DIESEL_1" : i == 4 ? "FUEL_TYPE_DIESEL_2" : i == 5 ? "FUEL_TYPE_BIODIESEL" : i == 6 ? "FUEL_TYPE_E85" : i == 7 ? "FUEL_TYPE_LPG" : i == 8 ? "FUEL_TYPE_CNG" : i == 9 ? "FUEL_TYPE_LNG" : i == 10 ? "FUEL_TYPE_ELECTRIC" : i == 11 ? "FUEL_TYPE_HYDROGEN" : i == 12 ? "FUEL_TYPE_OTHER" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("FUEL_TYPE_UNKNOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("FUEL_TYPE_UNLEADED");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("FUEL_TYPE_LEADED");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("FUEL_TYPE_DIESEL_1");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("FUEL_TYPE_DIESEL_2");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("FUEL_TYPE_BIODIESEL");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("FUEL_TYPE_E85");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("FUEL_TYPE_LPG");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("FUEL_TYPE_CNG");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("FUEL_TYPE_LNG");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("FUEL_TYPE_ELECTRIC");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("FUEL_TYPE_HYDROGEN");
            i2 |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("FUEL_TYPE_OTHER");
            i2 |= 12;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
