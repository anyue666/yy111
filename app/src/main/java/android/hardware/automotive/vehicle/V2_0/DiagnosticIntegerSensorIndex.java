package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DiagnosticIntegerSensorIndex {
    public static final int ABSOLUTE_BAROMETRIC_PRESSURE = 11;
    public static final int AMBIENT_AIR_TEMPERATURE = 13;
    public static final int COMMANDED_SECONDARY_AIR_STATUS = 5;
    public static final int CONTROL_MODULE_VOLTAGE = 12;
    public static final int DISTANCE_TRAVELED_SINCE_CODES_CLEARED = 10;
    public static final int DISTANCE_TRAVELED_WITH_MALFUNCTION_INDICATOR_LIGHT_ON = 8;
    public static final int DRIVER_DEMAND_PERCENT_TORQUE = 24;
    public static final int ENGINE_ACTUAL_PERCENT_TORQUE = 25;
    public static final int ENGINE_OIL_TEMPERATURE = 23;
    public static final int ENGINE_PERCENT_TORQUE_DATA_IDLE = 27;
    public static final int ENGINE_PERCENT_TORQUE_DATA_POINT1 = 28;
    public static final int ENGINE_PERCENT_TORQUE_DATA_POINT2 = 29;
    public static final int ENGINE_PERCENT_TORQUE_DATA_POINT3 = 30;
    public static final int ENGINE_PERCENT_TORQUE_DATA_POINT4 = 31;
    public static final int ENGINE_REFERENCE_PERCENT_TORQUE = 26;
    public static final int FUEL_RAIL_ABSOLUTE_PRESSURE = 22;
    public static final int FUEL_SYSTEM_STATUS = 0;
    public static final int FUEL_TYPE = 21;
    public static final int IGNITION_MONITORS_SUPPORTED = 2;
    public static final int IGNITION_SPECIFIC_MONITORS = 3;
    public static final int INTAKE_AIR_TEMPERATURE = 4;
    public static final int LAST_SYSTEM_INDEX = 31;
    public static final int MALFUNCTION_INDICATOR_LIGHT_ON = 1;
    public static final int MAX_AIR_FLOW_RATE_FROM_MASS_AIR_FLOW_SENSOR = 20;
    public static final int MAX_FUEL_AIR_EQUIVALENCE_RATIO = 16;
    public static final int MAX_INTAKE_MANIFOLD_ABSOLUTE_PRESSURE = 19;
    public static final int MAX_OXYGEN_SENSOR_CURRENT = 18;
    public static final int MAX_OXYGEN_SENSOR_VOLTAGE = 17;
    public static final int NUM_OXYGEN_SENSORS_PRESENT = 6;
    public static final int RUNTIME_SINCE_ENGINE_START = 7;
    public static final int TIME_SINCE_TROUBLE_CODES_CLEARED = 15;
    public static final int TIME_WITH_MALFUNCTION_LIGHT_ON = 14;
    public static final int WARMUPS_SINCE_CODES_CLEARED = 9;

    public static final String toString(int i) {
        return i == 0 ? "FUEL_SYSTEM_STATUS" : i == 1 ? "MALFUNCTION_INDICATOR_LIGHT_ON" : i == 2 ? "IGNITION_MONITORS_SUPPORTED" : i == 3 ? "IGNITION_SPECIFIC_MONITORS" : i == 4 ? "INTAKE_AIR_TEMPERATURE" : i == 5 ? "COMMANDED_SECONDARY_AIR_STATUS" : i == 6 ? "NUM_OXYGEN_SENSORS_PRESENT" : i == 7 ? "RUNTIME_SINCE_ENGINE_START" : i == 8 ? "DISTANCE_TRAVELED_WITH_MALFUNCTION_INDICATOR_LIGHT_ON" : i == 9 ? "WARMUPS_SINCE_CODES_CLEARED" : i == 10 ? "DISTANCE_TRAVELED_SINCE_CODES_CLEARED" : i == 11 ? "ABSOLUTE_BAROMETRIC_PRESSURE" : i == 12 ? "CONTROL_MODULE_VOLTAGE" : i == 13 ? "AMBIENT_AIR_TEMPERATURE" : i == 14 ? "TIME_WITH_MALFUNCTION_LIGHT_ON" : i == 15 ? "TIME_SINCE_TROUBLE_CODES_CLEARED" : i == 16 ? "MAX_FUEL_AIR_EQUIVALENCE_RATIO" : i == 17 ? "MAX_OXYGEN_SENSOR_VOLTAGE" : i == 18 ? "MAX_OXYGEN_SENSOR_CURRENT" : i == 19 ? "MAX_INTAKE_MANIFOLD_ABSOLUTE_PRESSURE" : i == 20 ? "MAX_AIR_FLOW_RATE_FROM_MASS_AIR_FLOW_SENSOR" : i == 21 ? "FUEL_TYPE" : i == 22 ? "FUEL_RAIL_ABSOLUTE_PRESSURE" : i == 23 ? "ENGINE_OIL_TEMPERATURE" : i == 24 ? "DRIVER_DEMAND_PERCENT_TORQUE" : i == 25 ? "ENGINE_ACTUAL_PERCENT_TORQUE" : i == 26 ? "ENGINE_REFERENCE_PERCENT_TORQUE" : i == 27 ? "ENGINE_PERCENT_TORQUE_DATA_IDLE" : i == 28 ? "ENGINE_PERCENT_TORQUE_DATA_POINT1" : i == 29 ? "ENGINE_PERCENT_TORQUE_DATA_POINT2" : i == 30 ? "ENGINE_PERCENT_TORQUE_DATA_POINT3" : i == 31 ? "ENGINE_PERCENT_TORQUE_DATA_POINT4" : i == 31 ? "LAST_SYSTEM_INDEX" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("FUEL_SYSTEM_STATUS");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("MALFUNCTION_INDICATOR_LIGHT_ON");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("IGNITION_MONITORS_SUPPORTED");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("IGNITION_SPECIFIC_MONITORS");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("INTAKE_AIR_TEMPERATURE");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("COMMANDED_SECONDARY_AIR_STATUS");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("NUM_OXYGEN_SENSORS_PRESENT");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("RUNTIME_SINCE_ENGINE_START");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("DISTANCE_TRAVELED_WITH_MALFUNCTION_INDICATOR_LIGHT_ON");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("WARMUPS_SINCE_CODES_CLEARED");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("DISTANCE_TRAVELED_SINCE_CODES_CLEARED");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("ABSOLUTE_BAROMETRIC_PRESSURE");
            i2 |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("CONTROL_MODULE_VOLTAGE");
            i2 |= 12;
        }
        if ((i & 13) == 13) {
            arrayList.add("AMBIENT_AIR_TEMPERATURE");
            i2 |= 13;
        }
        if ((i & 14) == 14) {
            arrayList.add("TIME_WITH_MALFUNCTION_LIGHT_ON");
            i2 |= 14;
        }
        if ((i & 15) == 15) {
            arrayList.add("TIME_SINCE_TROUBLE_CODES_CLEARED");
            i2 |= 15;
        }
        if ((i & 16) == 16) {
            arrayList.add("MAX_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 16;
        }
        if ((i & 17) == 17) {
            arrayList.add("MAX_OXYGEN_SENSOR_VOLTAGE");
            i2 |= 17;
        }
        if ((i & 18) == 18) {
            arrayList.add("MAX_OXYGEN_SENSOR_CURRENT");
            i2 |= 18;
        }
        if ((i & 19) == 19) {
            arrayList.add("MAX_INTAKE_MANIFOLD_ABSOLUTE_PRESSURE");
            i2 |= 19;
        }
        if ((i & 20) == 20) {
            arrayList.add("MAX_AIR_FLOW_RATE_FROM_MASS_AIR_FLOW_SENSOR");
            i2 |= 20;
        }
        if ((i & 21) == 21) {
            arrayList.add("FUEL_TYPE");
            i2 |= 21;
        }
        if ((i & 22) == 22) {
            arrayList.add("FUEL_RAIL_ABSOLUTE_PRESSURE");
            i2 |= 22;
        }
        if ((i & 23) == 23) {
            arrayList.add("ENGINE_OIL_TEMPERATURE");
            i2 |= 23;
        }
        if ((i & 24) == 24) {
            arrayList.add("DRIVER_DEMAND_PERCENT_TORQUE");
            i2 |= 24;
        }
        if ((i & 25) == 25) {
            arrayList.add("ENGINE_ACTUAL_PERCENT_TORQUE");
            i2 |= 25;
        }
        if ((i & 26) == 26) {
            arrayList.add("ENGINE_REFERENCE_PERCENT_TORQUE");
            i2 |= 26;
        }
        if ((i & 27) == 27) {
            arrayList.add("ENGINE_PERCENT_TORQUE_DATA_IDLE");
            i2 |= 27;
        }
        if ((i & 28) == 28) {
            arrayList.add("ENGINE_PERCENT_TORQUE_DATA_POINT1");
            i2 |= 28;
        }
        if ((i & 29) == 29) {
            arrayList.add("ENGINE_PERCENT_TORQUE_DATA_POINT2");
            i2 |= 29;
        }
        if ((i & 30) == 30) {
            arrayList.add("ENGINE_PERCENT_TORQUE_DATA_POINT3");
            i2 |= 30;
        }
        int i3 = i & 31;
        if (i3 == 31) {
            arrayList.add("ENGINE_PERCENT_TORQUE_DATA_POINT4");
            i2 |= 31;
        }
        if (i3 == 31) {
            arrayList.add("LAST_SYSTEM_INDEX");
            i2 |= 31;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
