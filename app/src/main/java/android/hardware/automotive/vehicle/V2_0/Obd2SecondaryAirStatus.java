package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Obd2SecondaryAirStatus {
    public static final int DOWNSTREAM_OF_CATALYCIC_CONVERTER = 2;
    public static final int FROM_OUTSIDE_OR_OFF = 4;
    public static final int PUMP_ON_FOR_DIAGNOSTICS = 8;
    public static final int UPSTREAM = 1;

    public static final String toString(int i) {
        return i == 1 ? "UPSTREAM" : i == 2 ? "DOWNSTREAM_OF_CATALYCIC_CONVERTER" : i == 4 ? "FROM_OUTSIDE_OR_OFF" : i == 8 ? "PUMP_ON_FOR_DIAGNOSTICS" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("UPSTREAM");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("DOWNSTREAM_OF_CATALYCIC_CONVERTER");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("FROM_OUTSIDE_OR_OFF");
            i2 |= 4;
        }
        if ((i & 8) == 8) {
            arrayList.add("PUMP_ON_FOR_DIAGNOSTICS");
            i2 |= 8;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
