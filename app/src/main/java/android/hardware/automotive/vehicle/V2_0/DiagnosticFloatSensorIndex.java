package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DiagnosticFloatSensorIndex {
    public static final int ABSOLUTE_EVAPORATION_SYSTEM_VAPOR_PRESSURE = 58;
    public static final int ABSOLUTE_LOAD_VALUE = 48;
    public static final int ABSOLUTE_THROTTLE_POSITION_B = 51;
    public static final int ABSOLUTE_THROTTLE_POSITION_C = 52;
    public static final int ACCELERATOR_PEDAL_POSITION_D = 53;
    public static final int ACCELERATOR_PEDAL_POSITION_E = 54;
    public static final int ACCELERATOR_PEDAL_POSITION_F = 55;
    public static final int CALCULATED_ENGINE_LOAD = 0;
    public static final int CATALYST_TEMPERATURE_BANK1_SENSOR1 = 44;
    public static final int CATALYST_TEMPERATURE_BANK1_SENSOR2 = 46;
    public static final int CATALYST_TEMPERATURE_BANK2_SENSOR1 = 45;
    public static final int CATALYST_TEMPERATURE_BANK2_SENSOR2 = 47;
    public static final int COMMANDED_EVAPORATIVE_PURGE = 41;
    public static final int COMMANDED_EXHAUST_GAS_RECIRCULATION = 39;
    public static final int COMMANDED_THROTTLE_ACTUATOR = 56;
    public static final int ENGINE_COOLANT_TEMPERATURE = 1;
    public static final int ENGINE_FUEL_RATE = 70;
    public static final int ENGINE_RPM = 8;
    public static final int ETHANOL_FUEL_PERCENTAGE = 57;
    public static final int EVAPORATION_SYSTEM_VAPOR_PRESSURE = 43;
    public static final int EXHAUST_GAS_RECIRCULATION_ERROR = 40;
    public static final int FUEL_AIR_COMMANDED_EQUIVALENCE_RATIO = 49;
    public static final int FUEL_INJECTION_TIMING = 69;
    public static final int FUEL_PRESSURE = 6;
    public static final int FUEL_RAIL_GAUGE_PRESSURE = 38;
    public static final int FUEL_RAIL_PRESSURE = 37;
    public static final int FUEL_TANK_LEVEL_INPUT = 42;
    public static final int HYBRID_BATTERY_PACK_REMAINING_LIFE = 68;
    public static final int INTAKE_MANIFOLD_ABSOLUTE_PRESSURE = 7;
    public static final int LAST_SYSTEM_INDEX = 70;
    public static final int LONG_TERM_FUEL_TRIM_BANK1 = 3;
    public static final int LONG_TERM_FUEL_TRIM_BANK2 = 5;
    public static final int LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK1 = 63;
    public static final int LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK2 = 64;
    public static final int LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK3 = 65;
    public static final int LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK4 = 66;
    public static final int MAF_AIR_FLOW_RATE = 11;
    public static final int OXYGEN_SENSOR1_FUEL_AIR_EQUIVALENCE_RATIO = 15;
    public static final int OXYGEN_SENSOR1_SHORT_TERM_FUEL_TRIM = 14;
    public static final int OXYGEN_SENSOR1_VOLTAGE = 13;
    public static final int OXYGEN_SENSOR2_FUEL_AIR_EQUIVALENCE_RATIO = 18;
    public static final int OXYGEN_SENSOR2_SHORT_TERM_FUEL_TRIM = 17;
    public static final int OXYGEN_SENSOR2_VOLTAGE = 16;
    public static final int OXYGEN_SENSOR3_FUEL_AIR_EQUIVALENCE_RATIO = 21;
    public static final int OXYGEN_SENSOR3_SHORT_TERM_FUEL_TRIM = 20;
    public static final int OXYGEN_SENSOR3_VOLTAGE = 19;
    public static final int OXYGEN_SENSOR4_FUEL_AIR_EQUIVALENCE_RATIO = 24;
    public static final int OXYGEN_SENSOR4_SHORT_TERM_FUEL_TRIM = 23;
    public static final int OXYGEN_SENSOR4_VOLTAGE = 22;
    public static final int OXYGEN_SENSOR5_FUEL_AIR_EQUIVALENCE_RATIO = 27;
    public static final int OXYGEN_SENSOR5_SHORT_TERM_FUEL_TRIM = 26;
    public static final int OXYGEN_SENSOR5_VOLTAGE = 25;
    public static final int OXYGEN_SENSOR6_FUEL_AIR_EQUIVALENCE_RATIO = 30;
    public static final int OXYGEN_SENSOR6_SHORT_TERM_FUEL_TRIM = 29;
    public static final int OXYGEN_SENSOR6_VOLTAGE = 28;
    public static final int OXYGEN_SENSOR7_FUEL_AIR_EQUIVALENCE_RATIO = 33;
    public static final int OXYGEN_SENSOR7_SHORT_TERM_FUEL_TRIM = 32;
    public static final int OXYGEN_SENSOR7_VOLTAGE = 31;
    public static final int OXYGEN_SENSOR8_FUEL_AIR_EQUIVALENCE_RATIO = 36;
    public static final int OXYGEN_SENSOR8_SHORT_TERM_FUEL_TRIM = 35;
    public static final int OXYGEN_SENSOR8_VOLTAGE = 34;
    public static final int RELATIVE_ACCELERATOR_PEDAL_POSITION = 67;
    public static final int RELATIVE_THROTTLE_POSITION = 50;
    public static final int SHORT_TERM_FUEL_TRIM_BANK1 = 2;
    public static final int SHORT_TERM_FUEL_TRIM_BANK2 = 4;
    public static final int SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK1 = 59;
    public static final int SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK2 = 60;
    public static final int SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK3 = 61;
    public static final int SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK4 = 62;
    public static final int THROTTLE_POSITION = 12;
    public static final int TIMING_ADVANCE = 10;
    public static final int VEHICLE_SPEED = 9;

    public static final String toString(int i) {
        return i == 0 ? "CALCULATED_ENGINE_LOAD" : i == 1 ? "ENGINE_COOLANT_TEMPERATURE" : i == 2 ? "SHORT_TERM_FUEL_TRIM_BANK1" : i == 3 ? "LONG_TERM_FUEL_TRIM_BANK1" : i == 4 ? "SHORT_TERM_FUEL_TRIM_BANK2" : i == 5 ? "LONG_TERM_FUEL_TRIM_BANK2" : i == 6 ? "FUEL_PRESSURE" : i == 7 ? "INTAKE_MANIFOLD_ABSOLUTE_PRESSURE" : i == 8 ? "ENGINE_RPM" : i == 9 ? "VEHICLE_SPEED" : i == 10 ? "TIMING_ADVANCE" : i == 11 ? "MAF_AIR_FLOW_RATE" : i == 12 ? "THROTTLE_POSITION" : i == 13 ? "OXYGEN_SENSOR1_VOLTAGE" : i == 14 ? "OXYGEN_SENSOR1_SHORT_TERM_FUEL_TRIM" : i == 15 ? "OXYGEN_SENSOR1_FUEL_AIR_EQUIVALENCE_RATIO" : i == 16 ? "OXYGEN_SENSOR2_VOLTAGE" : i == 17 ? "OXYGEN_SENSOR2_SHORT_TERM_FUEL_TRIM" : i == 18 ? "OXYGEN_SENSOR2_FUEL_AIR_EQUIVALENCE_RATIO" : i == 19 ? "OXYGEN_SENSOR3_VOLTAGE" : i == 20 ? "OXYGEN_SENSOR3_SHORT_TERM_FUEL_TRIM" : i == 21 ? "OXYGEN_SENSOR3_FUEL_AIR_EQUIVALENCE_RATIO" : i == 22 ? "OXYGEN_SENSOR4_VOLTAGE" : i == 23 ? "OXYGEN_SENSOR4_SHORT_TERM_FUEL_TRIM" : i == 24 ? "OXYGEN_SENSOR4_FUEL_AIR_EQUIVALENCE_RATIO" : i == 25 ? "OXYGEN_SENSOR5_VOLTAGE" : i == 26 ? "OXYGEN_SENSOR5_SHORT_TERM_FUEL_TRIM" : i == 27 ? "OXYGEN_SENSOR5_FUEL_AIR_EQUIVALENCE_RATIO" : i == 28 ? "OXYGEN_SENSOR6_VOLTAGE" : i == 29 ? "OXYGEN_SENSOR6_SHORT_TERM_FUEL_TRIM" : i == 30 ? "OXYGEN_SENSOR6_FUEL_AIR_EQUIVALENCE_RATIO" : i == 31 ? "OXYGEN_SENSOR7_VOLTAGE" : i == 32 ? "OXYGEN_SENSOR7_SHORT_TERM_FUEL_TRIM" : i == 33 ? "OXYGEN_SENSOR7_FUEL_AIR_EQUIVALENCE_RATIO" : i == 34 ? "OXYGEN_SENSOR8_VOLTAGE" : i == 35 ? "OXYGEN_SENSOR8_SHORT_TERM_FUEL_TRIM" : i == 36 ? "OXYGEN_SENSOR8_FUEL_AIR_EQUIVALENCE_RATIO" : i == 37 ? "FUEL_RAIL_PRESSURE" : i == 38 ? "FUEL_RAIL_GAUGE_PRESSURE" : i == 39 ? "COMMANDED_EXHAUST_GAS_RECIRCULATION" : i == 40 ? "EXHAUST_GAS_RECIRCULATION_ERROR" : i == 41 ? "COMMANDED_EVAPORATIVE_PURGE" : i == 42 ? "FUEL_TANK_LEVEL_INPUT" : i == 43 ? "EVAPORATION_SYSTEM_VAPOR_PRESSURE" : i == 44 ? "CATALYST_TEMPERATURE_BANK1_SENSOR1" : i == 45 ? "CATALYST_TEMPERATURE_BANK2_SENSOR1" : i == 46 ? "CATALYST_TEMPERATURE_BANK1_SENSOR2" : i == 47 ? "CATALYST_TEMPERATURE_BANK2_SENSOR2" : i == 48 ? "ABSOLUTE_LOAD_VALUE" : i == 49 ? "FUEL_AIR_COMMANDED_EQUIVALENCE_RATIO" : i == 50 ? "RELATIVE_THROTTLE_POSITION" : i == 51 ? "ABSOLUTE_THROTTLE_POSITION_B" : i == 52 ? "ABSOLUTE_THROTTLE_POSITION_C" : i == 53 ? "ACCELERATOR_PEDAL_POSITION_D" : i == 54 ? "ACCELERATOR_PEDAL_POSITION_E" : i == 55 ? "ACCELERATOR_PEDAL_POSITION_F" : i == 56 ? "COMMANDED_THROTTLE_ACTUATOR" : i == 57 ? "ETHANOL_FUEL_PERCENTAGE" : i == 58 ? "ABSOLUTE_EVAPORATION_SYSTEM_VAPOR_PRESSURE" : i == 59 ? "SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK1" : i == 60 ? "SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK2" : i == 61 ? "SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK3" : i == 62 ? "SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK4" : i == 63 ? "LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK1" : i == 64 ? "LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK2" : i == 65 ? "LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK3" : i == 66 ? "LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK4" : i == 67 ? "RELATIVE_ACCELERATOR_PEDAL_POSITION" : i == 68 ? "HYBRID_BATTERY_PACK_REMAINING_LIFE" : i == 69 ? "FUEL_INJECTION_TIMING" : i == 70 ? "ENGINE_FUEL_RATE" : i == 70 ? "LAST_SYSTEM_INDEX" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("CALCULATED_ENGINE_LOAD");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ENGINE_COOLANT_TEMPERATURE");
        } else {
            i2 = 0;
        }
        if ((i & 2) == 2) {
            arrayList.add("SHORT_TERM_FUEL_TRIM_BANK1");
            i2 |= 2;
        }
        if ((i & 3) == 3) {
            arrayList.add("LONG_TERM_FUEL_TRIM_BANK1");
            i2 |= 3;
        }
        if ((i & 4) == 4) {
            arrayList.add("SHORT_TERM_FUEL_TRIM_BANK2");
            i2 |= 4;
        }
        if ((i & 5) == 5) {
            arrayList.add("LONG_TERM_FUEL_TRIM_BANK2");
            i2 |= 5;
        }
        if ((i & 6) == 6) {
            arrayList.add("FUEL_PRESSURE");
            i2 |= 6;
        }
        if ((i & 7) == 7) {
            arrayList.add("INTAKE_MANIFOLD_ABSOLUTE_PRESSURE");
            i2 |= 7;
        }
        if ((i & 8) == 8) {
            arrayList.add("ENGINE_RPM");
            i2 |= 8;
        }
        if ((i & 9) == 9) {
            arrayList.add("VEHICLE_SPEED");
            i2 |= 9;
        }
        if ((i & 10) == 10) {
            arrayList.add("TIMING_ADVANCE");
            i2 |= 10;
        }
        if ((i & 11) == 11) {
            arrayList.add("MAF_AIR_FLOW_RATE");
            i2 |= 11;
        }
        if ((i & 12) == 12) {
            arrayList.add("THROTTLE_POSITION");
            i2 |= 12;
        }
        if ((i & 13) == 13) {
            arrayList.add("OXYGEN_SENSOR1_VOLTAGE");
            i2 |= 13;
        }
        if ((i & 14) == 14) {
            arrayList.add("OXYGEN_SENSOR1_SHORT_TERM_FUEL_TRIM");
            i2 |= 14;
        }
        if ((i & 15) == 15) {
            arrayList.add("OXYGEN_SENSOR1_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 15;
        }
        if ((i & 16) == 16) {
            arrayList.add("OXYGEN_SENSOR2_VOLTAGE");
            i2 |= 16;
        }
        if ((i & 17) == 17) {
            arrayList.add("OXYGEN_SENSOR2_SHORT_TERM_FUEL_TRIM");
            i2 |= 17;
        }
        if ((i & 18) == 18) {
            arrayList.add("OXYGEN_SENSOR2_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 18;
        }
        if ((i & 19) == 19) {
            arrayList.add("OXYGEN_SENSOR3_VOLTAGE");
            i2 |= 19;
        }
        if ((i & 20) == 20) {
            arrayList.add("OXYGEN_SENSOR3_SHORT_TERM_FUEL_TRIM");
            i2 |= 20;
        }
        if ((i & 21) == 21) {
            arrayList.add("OXYGEN_SENSOR3_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 21;
        }
        if ((i & 22) == 22) {
            arrayList.add("OXYGEN_SENSOR4_VOLTAGE");
            i2 |= 22;
        }
        if ((i & 23) == 23) {
            arrayList.add("OXYGEN_SENSOR4_SHORT_TERM_FUEL_TRIM");
            i2 |= 23;
        }
        if ((i & 24) == 24) {
            arrayList.add("OXYGEN_SENSOR4_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 24;
        }
        if ((i & 25) == 25) {
            arrayList.add("OXYGEN_SENSOR5_VOLTAGE");
            i2 |= 25;
        }
        if ((i & 26) == 26) {
            arrayList.add("OXYGEN_SENSOR5_SHORT_TERM_FUEL_TRIM");
            i2 |= 26;
        }
        if ((i & 27) == 27) {
            arrayList.add("OXYGEN_SENSOR5_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 27;
        }
        if ((i & 28) == 28) {
            arrayList.add("OXYGEN_SENSOR6_VOLTAGE");
            i2 |= 28;
        }
        if ((i & 29) == 29) {
            arrayList.add("OXYGEN_SENSOR6_SHORT_TERM_FUEL_TRIM");
            i2 |= 29;
        }
        if ((i & 30) == 30) {
            arrayList.add("OXYGEN_SENSOR6_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 30;
        }
        if ((i & 31) == 31) {
            arrayList.add("OXYGEN_SENSOR7_VOLTAGE");
            i2 |= 31;
        }
        if ((i & 32) == 32) {
            arrayList.add("OXYGEN_SENSOR7_SHORT_TERM_FUEL_TRIM");
            i2 |= 32;
        }
        if ((i & 33) == 33) {
            arrayList.add("OXYGEN_SENSOR7_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 33;
        }
        if ((i & 34) == 34) {
            arrayList.add("OXYGEN_SENSOR8_VOLTAGE");
            i2 |= 34;
        }
        if ((i & 35) == 35) {
            arrayList.add("OXYGEN_SENSOR8_SHORT_TERM_FUEL_TRIM");
            i2 |= 35;
        }
        if ((i & 36) == 36) {
            arrayList.add("OXYGEN_SENSOR8_FUEL_AIR_EQUIVALENCE_RATIO");
            i2 |= 36;
        }
        if ((i & 37) == 37) {
            arrayList.add("FUEL_RAIL_PRESSURE");
            i2 |= 37;
        }
        if ((i & 38) == 38) {
            arrayList.add("FUEL_RAIL_GAUGE_PRESSURE");
            i2 |= 38;
        }
        if ((i & 39) == 39) {
            arrayList.add("COMMANDED_EXHAUST_GAS_RECIRCULATION");
            i2 |= 39;
        }
        if ((i & 40) == 40) {
            arrayList.add("EXHAUST_GAS_RECIRCULATION_ERROR");
            i2 |= 40;
        }
        if ((i & 41) == 41) {
            arrayList.add("COMMANDED_EVAPORATIVE_PURGE");
            i2 |= 41;
        }
        if ((i & 42) == 42) {
            arrayList.add("FUEL_TANK_LEVEL_INPUT");
            i2 |= 42;
        }
        if ((i & 43) == 43) {
            arrayList.add("EVAPORATION_SYSTEM_VAPOR_PRESSURE");
            i2 |= 43;
        }
        if ((i & 44) == 44) {
            arrayList.add("CATALYST_TEMPERATURE_BANK1_SENSOR1");
            i2 |= 44;
        }
        if ((i & 45) == 45) {
            arrayList.add("CATALYST_TEMPERATURE_BANK2_SENSOR1");
            i2 |= 45;
        }
        if ((i & 46) == 46) {
            arrayList.add("CATALYST_TEMPERATURE_BANK1_SENSOR2");
            i2 |= 46;
        }
        if ((i & 47) == 47) {
            arrayList.add("CATALYST_TEMPERATURE_BANK2_SENSOR2");
            i2 |= 47;
        }
        if ((i & 48) == 48) {
            arrayList.add("ABSOLUTE_LOAD_VALUE");
            i2 |= 48;
        }
        if ((i & 49) == 49) {
            arrayList.add("FUEL_AIR_COMMANDED_EQUIVALENCE_RATIO");
            i2 |= 49;
        }
        if ((i & 50) == 50) {
            arrayList.add("RELATIVE_THROTTLE_POSITION");
            i2 |= 50;
        }
        if ((i & 51) == 51) {
            arrayList.add("ABSOLUTE_THROTTLE_POSITION_B");
            i2 |= 51;
        }
        if ((i & 52) == 52) {
            arrayList.add("ABSOLUTE_THROTTLE_POSITION_C");
            i2 |= 52;
        }
        if ((i & 53) == 53) {
            arrayList.add("ACCELERATOR_PEDAL_POSITION_D");
            i2 |= 53;
        }
        if ((i & 54) == 54) {
            arrayList.add("ACCELERATOR_PEDAL_POSITION_E");
            i2 |= 54;
        }
        if ((i & 55) == 55) {
            arrayList.add("ACCELERATOR_PEDAL_POSITION_F");
            i2 |= 55;
        }
        if ((i & 56) == 56) {
            arrayList.add("COMMANDED_THROTTLE_ACTUATOR");
            i2 |= 56;
        }
        if ((i & 57) == 57) {
            arrayList.add("ETHANOL_FUEL_PERCENTAGE");
            i2 |= 57;
        }
        if ((i & 58) == 58) {
            arrayList.add("ABSOLUTE_EVAPORATION_SYSTEM_VAPOR_PRESSURE");
            i2 |= 58;
        }
        if ((i & 59) == 59) {
            arrayList.add("SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK1");
            i2 |= 59;
        }
        if ((i & 60) == 60) {
            arrayList.add("SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK2");
            i2 |= 60;
        }
        if ((i & 61) == 61) {
            arrayList.add("SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK3");
            i2 |= 61;
        }
        if ((i & 62) == 62) {
            arrayList.add("SHORT_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK4");
            i2 |= 62;
        }
        if ((i & 63) == 63) {
            arrayList.add("LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK1");
            i2 |= 63;
        }
        if ((i & 64) == 64) {
            arrayList.add("LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK2");
            i2 |= 64;
        }
        if ((i & 65) == 65) {
            arrayList.add("LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK3");
            i2 |= 65;
        }
        if ((i & 66) == 66) {
            arrayList.add("LONG_TERM_SECONDARY_OXYGEN_SENSOR_TRIM_BANK4");
            i2 |= 66;
        }
        if ((i & 67) == 67) {
            arrayList.add("RELATIVE_ACCELERATOR_PEDAL_POSITION");
            i2 |= 67;
        }
        if ((i & 68) == 68) {
            arrayList.add("HYBRID_BATTERY_PACK_REMAINING_LIFE");
            i2 |= 68;
        }
        if ((i & 69) == 69) {
            arrayList.add("FUEL_INJECTION_TIMING");
            i2 |= 69;
        }
        int i3 = i & 70;
        if (i3 == 70) {
            arrayList.add("ENGINE_FUEL_RATE");
            i2 |= 70;
        }
        if (i3 == 70) {
            arrayList.add("LAST_SYSTEM_INDEX");
            i2 |= 70;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
