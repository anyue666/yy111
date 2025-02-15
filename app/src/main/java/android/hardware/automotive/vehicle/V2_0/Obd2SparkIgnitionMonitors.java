package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Obd2SparkIgnitionMonitors {
    public static final int AC_REFRIGERANT_AVAILABLE = 4096;
    public static final int AC_REFRIGERANT_INCOMPLETE = 8192;
    public static final int CATALYST_AVAILABLE = 1048576;
    public static final int CATALYST_INCOMPLETE = 2097152;
    public static final int COMPONENTS_AVAILABLE = 1;
    public static final int COMPONENTS_INCOMPLETE = 2;
    public static final int EGR_AVAILABLE = 64;
    public static final int EGR_INCOMPLETE = 128;
    public static final int EVAPORATIVE_SYSTEM_AVAILABLE = 65536;
    public static final int EVAPORATIVE_SYSTEM_INCOMPLETE = 131072;
    public static final int FUEL_SYSTEM_AVAILABLE = 4;
    public static final int FUEL_SYSTEM_INCOMPLETE = 8;
    public static final int HEATED_CATALYST_AVAILABLE = 262144;
    public static final int HEATED_CATALYST_INCOMPLETE = 524288;
    public static final int MISFIRE_AVAILABLE = 16;
    public static final int MISFIRE_INCOMPLETE = 32;
    public static final int OXYGEN_SENSOR_AVAILABLE = 1024;
    public static final int OXYGEN_SENSOR_HEATER_AVAILABLE = 256;
    public static final int OXYGEN_SENSOR_HEATER_INCOMPLETE = 512;
    public static final int OXYGEN_SENSOR_INCOMPLETE = 2048;
    public static final int SECONDARY_AIR_SYSTEM_AVAILABLE = 16384;
    public static final int SECONDARY_AIR_SYSTEM_INCOMPLETE = 32768;

    public static final String toString(int i) {
        return i == 1 ? "COMPONENTS_AVAILABLE" : i == 2 ? "COMPONENTS_INCOMPLETE" : i == 4 ? "FUEL_SYSTEM_AVAILABLE" : i == 8 ? "FUEL_SYSTEM_INCOMPLETE" : i == 16 ? "MISFIRE_AVAILABLE" : i == 32 ? "MISFIRE_INCOMPLETE" : i == 64 ? "EGR_AVAILABLE" : i == 128 ? "EGR_INCOMPLETE" : i == 256 ? "OXYGEN_SENSOR_HEATER_AVAILABLE" : i == 512 ? "OXYGEN_SENSOR_HEATER_INCOMPLETE" : i == 1024 ? "OXYGEN_SENSOR_AVAILABLE" : i == 2048 ? "OXYGEN_SENSOR_INCOMPLETE" : i == 4096 ? "AC_REFRIGERANT_AVAILABLE" : i == 8192 ? "AC_REFRIGERANT_INCOMPLETE" : i == 16384 ? "SECONDARY_AIR_SYSTEM_AVAILABLE" : i == 32768 ? "SECONDARY_AIR_SYSTEM_INCOMPLETE" : i == 65536 ? "EVAPORATIVE_SYSTEM_AVAILABLE" : i == 131072 ? "EVAPORATIVE_SYSTEM_INCOMPLETE" : i == 262144 ? "HEATED_CATALYST_AVAILABLE" : i == 524288 ? "HEATED_CATALYST_INCOMPLETE" : i == 1048576 ? "CATALYST_AVAILABLE" : i == 2097152 ? "CATALYST_INCOMPLETE" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("COMPONENTS_AVAILABLE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("COMPONENTS_INCOMPLETE");
            i2 |= 2;
        }
        if ((i & 4) == 4) {
            arrayList.add("FUEL_SYSTEM_AVAILABLE");
            i2 |= 4;
        }
        if ((i & 8) == 8) {
            arrayList.add("FUEL_SYSTEM_INCOMPLETE");
            i2 |= 8;
        }
        if ((i & 16) == 16) {
            arrayList.add("MISFIRE_AVAILABLE");
            i2 |= 16;
        }
        if ((i & 32) == 32) {
            arrayList.add("MISFIRE_INCOMPLETE");
            i2 |= 32;
        }
        if ((i & 64) == 64) {
            arrayList.add("EGR_AVAILABLE");
            i2 |= 64;
        }
        if ((i & 128) == 128) {
            arrayList.add("EGR_INCOMPLETE");
            i2 |= 128;
        }
        if ((i & 256) == 256) {
            arrayList.add("OXYGEN_SENSOR_HEATER_AVAILABLE");
            i2 |= 256;
        }
        if ((i & 512) == 512) {
            arrayList.add("OXYGEN_SENSOR_HEATER_INCOMPLETE");
            i2 |= 512;
        }
        if ((i & 1024) == 1024) {
            arrayList.add("OXYGEN_SENSOR_AVAILABLE");
            i2 |= 1024;
        }
        if ((i & 2048) == 2048) {
            arrayList.add("OXYGEN_SENSOR_INCOMPLETE");
            i2 |= 2048;
        }
        if ((i & 4096) == 4096) {
            arrayList.add("AC_REFRIGERANT_AVAILABLE");
            i2 |= 4096;
        }
        if ((i & 8192) == 8192) {
            arrayList.add("AC_REFRIGERANT_INCOMPLETE");
            i2 |= 8192;
        }
        if ((i & 16384) == 16384) {
            arrayList.add("SECONDARY_AIR_SYSTEM_AVAILABLE");
            i2 |= 16384;
        }
        if ((i & 32768) == 32768) {
            arrayList.add("SECONDARY_AIR_SYSTEM_INCOMPLETE");
            i2 |= 32768;
        }
        if ((i & 65536) == 65536) {
            arrayList.add("EVAPORATIVE_SYSTEM_AVAILABLE");
            i2 |= 65536;
        }
        if ((i & 131072) == 131072) {
            arrayList.add("EVAPORATIVE_SYSTEM_INCOMPLETE");
            i2 |= 131072;
        }
        if ((i & 262144) == 262144) {
            arrayList.add("HEATED_CATALYST_AVAILABLE");
            i2 |= 262144;
        }
        if ((i & 524288) == 524288) {
            arrayList.add("HEATED_CATALYST_INCOMPLETE");
            i2 |= 524288;
        }
        if ((i & 1048576) == 1048576) {
            arrayList.add("CATALYST_AVAILABLE");
            i2 |= 1048576;
        }
        if ((i & 2097152) == 2097152) {
            arrayList.add("CATALYST_INCOMPLETE");
            i2 |= 2097152;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
