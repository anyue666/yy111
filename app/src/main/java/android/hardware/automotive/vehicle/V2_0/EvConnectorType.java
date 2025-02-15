package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class EvConnectorType {
    public static final int GBT_AC = 10;
    public static final int GBT_DC = 11;
    public static final int IEC_TYPE_1_AC = 1;
    public static final int IEC_TYPE_1_CCS_DC = 5;
    public static final int IEC_TYPE_2_AC = 2;
    public static final int IEC_TYPE_2_CCS_DC = 6;
    public static final int IEC_TYPE_3_AC = 3;
    public static final int IEC_TYPE_4_DC = 4;
    public static final int OTHER = 101;
    public static final int TESLA_HPWC = 8;
    public static final int TESLA_ROADSTER = 7;
    public static final int TESLA_SUPERCHARGER = 9;
    public static final int UNKNOWN = 0;

    public static final String toString(int i) {
        return i == 0 ? "UNKNOWN" : i == 1 ? "IEC_TYPE_1_AC" : i == 2 ? "IEC_TYPE_2_AC" : i == 3 ? "IEC_TYPE_3_AC" : i == 4 ? "IEC_TYPE_4_DC" : i == 5 ? "IEC_TYPE_1_CCS_DC" : i == 6 ? "IEC_TYPE_2_CCS_DC" : i == 7 ? "TESLA_ROADSTER" : i == 8 ? "TESLA_HPWC" : i == 9 ? "TESLA_SUPERCHARGER" : i == 10 ? "GBT_AC" : i == 11 ? "GBT_DC" : i == 101 ? "OTHER" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("UNKNOWN");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("IEC_TYPE_1_AC");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("IEC_TYPE_2_AC");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("IEC_TYPE_3_AC");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("IEC_TYPE_4_DC");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("IEC_TYPE_1_CCS_DC");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("IEC_TYPE_2_CCS_DC");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("TESLA_ROADSTER");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("TESLA_HPWC");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("TESLA_SUPERCHARGER");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("GBT_AC");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("GBT_DC");
            i2 |= 11;
        }
        if ((i & 101) == 101) {
            arrayList.add("OTHER");
            i2 |= 101;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
