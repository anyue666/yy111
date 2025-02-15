package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Obd2FuelType {
    public static final int BIFUEL_RUNNING_CNG = 13;
    public static final int BIFUEL_RUNNING_DIESEL = 23;
    public static final int BIFUEL_RUNNING_ELECTRIC = 15;
    public static final int BIFUEL_RUNNING_ELECTRIC_AND_COMBUSTION = 16;
    public static final int BIFUEL_RUNNING_ETHANOL = 11;
    public static final int BIFUEL_RUNNING_GASOLINE = 9;
    public static final int BIFUEL_RUNNING_LPG = 12;
    public static final int BIFUEL_RUNNING_METHANOL = 10;
    public static final int BIFUEL_RUNNING_PROPANE = 14;
    public static final int CNG = 6;
    public static final int DIESEL = 4;
    public static final int ELECTRIC = 8;
    public static final int ETHANOL = 3;
    public static final int GASOLINE = 1;
    public static final int HYBRID_DIESEL = 19;
    public static final int HYBRID_ELECTRIC = 20;
    public static final int HYBRID_ETHANOL = 18;
    public static final int HYBRID_GASOLINE = 17;
    public static final int HYBRID_REGENERATIVE = 22;
    public static final int HYBRID_RUNNING_ELECTRIC_AND_COMBUSTION = 21;
    public static final int LPG = 5;
    public static final int METHANOL = 2;
    public static final int NOT_AVAILABLE = 0;
    public static final int PROPANE = 7;

    public static final String toString(int i) {
        return i == 0 ? "NOT_AVAILABLE" : i == 1 ? "GASOLINE" : i == 2 ? "METHANOL" : i == 3 ? "ETHANOL" : i == 4 ? "DIESEL" : i == 5 ? "LPG" : i == 6 ? "CNG" : i == 7 ? "PROPANE" : i == 8 ? "ELECTRIC" : i == 9 ? "BIFUEL_RUNNING_GASOLINE" : i == 10 ? "BIFUEL_RUNNING_METHANOL" : i == 11 ? "BIFUEL_RUNNING_ETHANOL" : i == 12 ? "BIFUEL_RUNNING_LPG" : i == 13 ? "BIFUEL_RUNNING_CNG" : i == 14 ? "BIFUEL_RUNNING_PROPANE" : i == 15 ? "BIFUEL_RUNNING_ELECTRIC" : i == 16 ? "BIFUEL_RUNNING_ELECTRIC_AND_COMBUSTION" : i == 17 ? "HYBRID_GASOLINE" : i == 18 ? "HYBRID_ETHANOL" : i == 19 ? "HYBRID_DIESEL" : i == 20 ? "HYBRID_ELECTRIC" : i == 21 ? "HYBRID_RUNNING_ELECTRIC_AND_COMBUSTION" : i == 22 ? "HYBRID_REGENERATIVE" : i == 23 ? "BIFUEL_RUNNING_DIESEL" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("NOT_AVAILABLE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("GASOLINE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("METHANOL");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("ETHANOL");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("DIESEL");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("LPG");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("CNG");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("PROPANE");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("ELECTRIC");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("BIFUEL_RUNNING_GASOLINE");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("BIFUEL_RUNNING_METHANOL");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("BIFUEL_RUNNING_ETHANOL");
            i2 |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("BIFUEL_RUNNING_LPG");
            i2 |= 12;
        }
        if ((i & 13) == 13) {
            arrayList.add("BIFUEL_RUNNING_CNG");
            i2 |= 13;
        }
        if ((i & 14) == 14) {
            arrayList.add("BIFUEL_RUNNING_PROPANE");
            i2 |= 14;
        }
        if ((i & 15) == 15) {
            arrayList.add("BIFUEL_RUNNING_ELECTRIC");
            i2 |= 15;
        }
        if ((i & 16) == 16) {
            arrayList.add("BIFUEL_RUNNING_ELECTRIC_AND_COMBUSTION");
            i2 |= 16;
        }
        if ((i & 17) == 17) {
            arrayList.add("HYBRID_GASOLINE");
            i2 |= 17;
        }
        if ((i & 18) == 18) {
            arrayList.add("HYBRID_ETHANOL");
            i2 |= 18;
        }
        if ((i & 19) == 19) {
            arrayList.add("HYBRID_DIESEL");
            i2 |= 19;
        }
        if ((i & 20) == 20) {
            arrayList.add("HYBRID_ELECTRIC");
            i2 |= 20;
        }
        if ((i & 21) == 21) {
            arrayList.add("HYBRID_RUNNING_ELECTRIC_AND_COMBUSTION");
            i2 |= 21;
        }
        if ((i & 22) == 22) {
            arrayList.add("HYBRID_REGENERATIVE");
            i2 |= 22;
        }
        if ((i & 23) == 23) {
            arrayList.add("BIFUEL_RUNNING_DIESEL");
            i2 |= 23;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
