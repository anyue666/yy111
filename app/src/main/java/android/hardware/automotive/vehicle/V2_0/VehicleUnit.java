package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleUnit {
    public static final int AMPERE_HOURS = 100;
    public static final int BAR = 114;
    public static final int CELSIUS = 48;
    public static final int DEGREES = 128;
    public static final int FAHRENHEIT = 49;
    public static final int GALLON = 66;
    public static final int HERTZ = 3;
    public static final int IMPERIAL_GALLON = 67;
    public static final int KELVIN = 50;
    public static final int KILOMETER = 35;
    public static final int KILOMETERS_PER_HOUR = 145;
    public static final int KILOPASCAL = 112;
    public static final int KILOWATT_HOUR = 101;
    public static final int LITER = 65;
    public static final int METER = 33;
    public static final int METER_PER_SEC = 1;
    public static final int MILE = 36;
    public static final int MILES_PER_HOUR = 144;
    public static final int MILLIAMPERE = 97;
    public static final int MILLILITER = 64;
    public static final int MILLIMETER = 32;
    public static final int MILLIVOLT = 98;
    public static final int MILLIWATTS = 99;
    public static final int NANO_SECS = 80;
    public static final int PERCENTILE = 16;
    public static final int PSI = 113;
    public static final int RPM = 2;
    public static final int SECS = 83;
    public static final int SHOULD_NOT_USE = 0;
    public static final int US_GALLON = 66;
    public static final int WATT_HOUR = 96;
    public static final int YEAR = 89;

    public static final String toString(int i) {
        return i == 0 ? "SHOULD_NOT_USE" : i == 1 ? "METER_PER_SEC" : i == 2 ? "RPM" : i == 3 ? "HERTZ" : i == 16 ? "PERCENTILE" : i == 32 ? "MILLIMETER" : i == 33 ? "METER" : i == 35 ? "KILOMETER" : i == 36 ? "MILE" : i == 48 ? "CELSIUS" : i == 49 ? "FAHRENHEIT" : i == 50 ? "KELVIN" : i == 64 ? "MILLILITER" : i == 65 ? "LITER" : i == 66 ? "GALLON" : i == 66 ? "US_GALLON" : i == 67 ? "IMPERIAL_GALLON" : i == 80 ? "NANO_SECS" : i == 83 ? "SECS" : i == 89 ? "YEAR" : i == 96 ? "WATT_HOUR" : i == 97 ? "MILLIAMPERE" : i == 98 ? "MILLIVOLT" : i == 99 ? "MILLIWATTS" : i == 100 ? "AMPERE_HOURS" : i == 101 ? "KILOWATT_HOUR" : i == 112 ? "KILOPASCAL" : i == 113 ? "PSI" : i == 114 ? "BAR" : i == 128 ? "DEGREES" : i == 144 ? "MILES_PER_HOUR" : i == 145 ? "KILOMETERS_PER_HOUR" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("SHOULD_NOT_USE");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("METER_PER_SEC");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("RPM");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("HERTZ");
            i2 |= 3;
        }
        if ((i & 16) == 16) {
            arrayList.add("PERCENTILE");
            i2 |= 16;
        }
        if ((i & 32) == 32) {
            arrayList.add("MILLIMETER");
            i2 |= 32;
        }
        if ((i & 33) == 33) {
            arrayList.add("METER");
            i2 |= 33;
        }
        if ((i & 35) == 35) {
            arrayList.add("KILOMETER");
            i2 |= 35;
        }
        if ((i & 36) == 36) {
            arrayList.add("MILE");
            i2 |= 36;
        }
        if ((i & 48) == 48) {
            arrayList.add("CELSIUS");
            i2 |= 48;
        }
        if ((i & 49) == 49) {
            arrayList.add("FAHRENHEIT");
            i2 |= 49;
        }
        if ((i & 50) == 50) {
            arrayList.add("KELVIN");
            i2 |= 50;
        }
        if ((i & 64) == 64) {
            arrayList.add("MILLILITER");
            i2 |= 64;
        }
        if ((i & 65) == 65) {
            arrayList.add("LITER");
            i2 |= 65;
        }
        int i3 = i & 66;
        if (i3 == 66) {
            arrayList.add("GALLON");
            i2 |= 66;
        }
        if (i3 == 66) {
            arrayList.add("US_GALLON");
            i2 |= 66;
        }
        if ((i & 67) == 67) {
            arrayList.add("IMPERIAL_GALLON");
            i2 |= 67;
        }
        if ((i & 80) == 80) {
            arrayList.add("NANO_SECS");
            i2 |= 80;
        }
        if ((i & 83) == 83) {
            arrayList.add("SECS");
            i2 |= 83;
        }
        if ((i & 89) == 89) {
            arrayList.add("YEAR");
            i2 |= 89;
        }
        if ((i & 96) == 96) {
            arrayList.add("WATT_HOUR");
            i2 |= 96;
        }
        if ((i & 97) == 97) {
            arrayList.add("MILLIAMPERE");
            i2 |= 97;
        }
        if ((i & 98) == 98) {
            arrayList.add("MILLIVOLT");
            i2 |= 98;
        }
        if ((i & 99) == 99) {
            arrayList.add("MILLIWATTS");
            i2 |= 99;
        }
        if ((i & 100) == 100) {
            arrayList.add("AMPERE_HOURS");
            i2 |= 100;
        }
        if ((i & 101) == 101) {
            arrayList.add("KILOWATT_HOUR");
            i2 |= 101;
        }
        if ((i & 112) == 112) {
            arrayList.add("KILOPASCAL");
            i2 |= 112;
        }
        if ((i & 113) == 113) {
            arrayList.add("PSI");
            i2 |= 113;
        }
        if ((i & 114) == 114) {
            arrayList.add("BAR");
            i2 |= 114;
        }
        if ((i & 128) == 128) {
            arrayList.add("DEGREES");
            i2 |= 128;
        }
        if ((i & 144) == 144) {
            arrayList.add("MILES_PER_HOUR");
            i2 |= 144;
        }
        if ((i & 145) == 145) {
            arrayList.add("KILOMETERS_PER_HOUR");
            i2 |= 145;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
