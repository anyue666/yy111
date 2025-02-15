package com.autolink.adaptermanager.car;

import android.hardware.automotive.vehicle.V2_0.VehicleProperty;

/* loaded from: classes.dex */
public final class CarUtils {
    private static final int DEFAULT_HAL_AREAID = 0;
    private static final int HAL_PROPID_INVALID = -1;
    private static final int MANAGER_PROPID_INVALID = -1;
    private static final String TAG = "ALCAR.UTIL";

    public static int halToManagerAVMPropId(int i) {
        switch (i) {
            case 557843105:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_GB_Positoion;
            case 557843106:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LEVER_MODE;
            case 557843702:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_ON_T1P;
            case 557843806:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_APA_SOFT_SWITCH;
            case 557844737:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_SPEED_VALID;
            case 557844770:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_DISPLAY;
            case 557844776:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_360;
            case 559941888:
                return ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_SPEED;
            default:
                return -1;
        }
    }

    public static int halToManagerExtPropId(int i) {
        switch (i) {
            case 557842711:
                return 2002;
            case VehicleProperty.CLUSTER_POWERSTATE_T1J_DRIVE_DOOR_STS /* 557842724 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVE_DOOR;
            case 557842959:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AIRBAG_FAIL;
            case VehicleProperty.CLUSTER_PSNGR_DOOR_STATUS /* 557842978 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PSNGR_DOOR;
            case VehicleProperty.CLUSTER_HOOD_STATUS /* 557842979 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_HOOD;
            case VehicleProperty.CLUSTER_RHR_DOOR_STATUS /* 557842980 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_RHR_DOOR;
            case VehicleProperty.CLUSTER_LHR_DOOR_STATUS /* 557842981 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_LHR_DOOR;
            case VehicleProperty.CLUSTER_TRUNK_DOOR_STATUS /* 557842982 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR_DOOR_TRUNK_T1N;
            case 557842984:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AVAS;
            case 557843612:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_ENERGY_FLOW;
            case 557843613:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CHARGE_MEM;
            case 557843615:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CST;
            case 557843708:
                return 2001;
            case 557843725:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_ALL_WEATHER_LIGHT;
            case 557843731:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DIRTY;
            case 557843745:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BRAKE_MODE;
            case 557843749:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MAX_TEMP;
            case 557843750:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MIN_TEMP;
            case 557843751:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MAX;
            case 557843752:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MAX_NUM;
            case 557843753:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MIN;
            case 557843754:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MIN_NUM;
            case 557843755:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_INSULATION_RESIS;
            case 557843756:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PACK_CHARGE;
            case 557843757:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PACK_DC_CHARGE;
            case 557843764:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_START_HOUR;
            case 557843765:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_START_MINUTE;
            case 557843766:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_STOP_HOUR;
            case 557843767:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_STOP_MINUTE;
            case 557843768:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_SET_SOC_LIMIT;
            case 557843769:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_LEFT_CHARGE_TIME;
            case 557843772:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DISCHG;
            case 557843773:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_RANGE_AVAL;
            case 557843774:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MAX_TEMP_NUM;
            case 557843775:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MIN_TEMP_NUM;
            case 557843776:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_MODE;
            case 557843781:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_NAVI;
            case 557843784:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_LED;
            case 557843787:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG;
            case 557843789:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG_SAS;
            case 557843793:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DISCHARGE_CONNECT_STATE;
            case 557843794:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR_DOOR;
            case 557843795:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVER_SEAT_MEM;
            case 557843808:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PACK_POWER;
            case 557843811:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_GALLERY_MODE;
            case VehicleProperty.VC_EXT_VENDOR_REAR_DOOR_STS_T1N_READ /* 557843850 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR_DOOR_STS_T1N;
            case VehicleProperty.VC_EXT_VENDOR_REAR_DOOR_PLG_T1N_READ /* 557843851 */:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG_SAS_T1N;
            case 557844035:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR;
            case 557844059:
                return 2003;
            case 557844060:
                return 2004;
            case 557844061:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_FR_SEAT_HEAT;
            case 557844062:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_FR_SEAT_BLOW;
            case 557844505:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AEB_MODE;
            case 557844515:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CC_CONNECT;
            case 557844538:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CC2STS;
            case 557844739:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVER_HIGH_BEAM;
            case 557844740:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVER_LOW_BEAM;
            case 557847101:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_TBOX_MUTE;
            case 559940899:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_SINGLE_CHARGE_ENERGY;
            case 559940900:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_SINGLE_DISCHARGE_ENERGY;
            case 559940910:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BATTERY_VOLT;
            case 559940911:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BATTERY_CUERRENT;
            case 559940961:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BATTERY_DIS_CUERRENT;
            case 559940962:
                return ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BATTERY_DIS_VOLT;
            default:
                return -1;
        }
    }

    public static int managerToHalAVMAreaId_Get(int i) {
        return 0;
    }

    public static int managerToHalAVMAreaId_Set(int i) {
        return 0;
    }

    public static int managerToHalAVMPropId_Get(int i) {
        if (i == 819) {
            return 557843106;
        }
        switch (i) {
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_SPEED /* 803 */:
                return 559941888;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_SPEED_VALID /* 804 */:
                return 557844737;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_GB_Positoion /* 805 */:
                return 557843105;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_ON_T1P /* 806 */:
                return 557843702;
            default:
                switch (i) {
                    case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_360 /* 808 */:
                        return 557844776;
                    case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_DISPLAY /* 809 */:
                        return 557844770;
                    case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_APA_SOFT_SWITCH /* 810 */:
                        return 557843806;
                    default:
                        return -1;
                }
        }
    }

    public static int managerToHalAVMPropId_Set(int i) {
        if (i == 801) {
            return 557844764;
        }
        if (i == 802) {
            return 557844765;
        }
        if (i == 806) {
            return 557843703;
        }
        if (i == 807) {
            return 557842710;
        }
        if (i == 820) {
            return 557844782;
        }
        switch (i) {
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_1 /* 811 */:
                return 557843798;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_2 /* 812 */:
                return 557843799;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_3 /* 813 */:
                return 557843800;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_4 /* 814 */:
                return 557843801;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_5 /* 815 */:
                return 557843802;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_6 /* 816 */:
                return 557843803;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_7 /* 817 */:
                return 557843804;
            case ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_LPN_8 /* 818 */:
                return 557843805;
            default:
                return -1;
        }
    }

    public static int managerToHalExtAreaId_Get(int i) {
        return 0;
    }

    public static int managerToHalExtAreaId_Set(int i) {
        return 0;
    }

    public static int managerToHalExtPropId_Get(int i) {
        if (i == 2023) {
            return 557847101;
        }
        if (i == 2024) {
            return 557843811;
        }
        if (i == 2221) {
            return 559940910;
        }
        if (i == 2222) {
            return 559940911;
        }
        switch (i) {
            case 2001:
                return 557843708;
            case 2002:
                return 557842711;
            case 2003:
                return 557844059;
            case 2004:
                return 557844060;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_FR_SEAT_HEAT /* 2005 */:
                return 557844061;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_FR_SEAT_BLOW /* 2006 */:
                return 557844062;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR /* 2007 */:
                return 557844035;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DIRTY /* 2008 */:
                return 557843731;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_ALL_WEATHER_LIGHT /* 2009 */:
                return 557843725;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AIRBAG_FAIL /* 2010 */:
                return 557842959;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AEB_MODE /* 2011 */:
                return 557844505;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG /* 2012 */:
                return 557843787;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG_SAS /* 2013 */:
                return 557843789;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_NAVI /* 2014 */:
                return 557843781;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_LED /* 2015 */:
                return 557843784;
            default:
                switch (i) {
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR_DOOR /* 2017 */:
                        return 557843794;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DISCHARGE_CONNECT_STATE /* 2018 */:
                        return 557843793;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVER_SEAT_MEM /* 2019 */:
                        return 557843795;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVER_LOW_BEAM /* 2020 */:
                        return 557844740;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVER_HIGH_BEAM /* 2021 */:
                        return 557844739;
                    default:
                        switch (i) {
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG_SAS_T1N /* 2029 */:
                                return VehicleProperty.VC_EXT_VENDOR_REAR_DOOR_PLG_T1N_READ;
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR_DOOR_STS_T1N /* 2030 */:
                                return VehicleProperty.VC_EXT_VENDOR_REAR_DOOR_STS_T1N_READ;
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR_DOOR_TRUNK_T1N /* 2031 */:
                                return VehicleProperty.CLUSTER_TRUNK_DOOR_STATUS;
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DRIVE_DOOR /* 2032 */:
                                return VehicleProperty.CLUSTER_POWERSTATE_T1J_DRIVE_DOOR_STS;
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PSNGR_DOOR /* 2033 */:
                                return VehicleProperty.CLUSTER_PSNGR_DOOR_STATUS;
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_LHR_DOOR /* 2034 */:
                                return VehicleProperty.CLUSTER_LHR_DOOR_STATUS;
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_RHR_DOOR /* 2035 */:
                                return VehicleProperty.CLUSTER_RHR_DOOR_STATUS;
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_HOOD /* 2036 */:
                                return VehicleProperty.CLUSTER_HOOD_STATUS;
                            default:
                                switch (i) {
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_ENERGY_FLOW /* 2201 */:
                                        return 557843612;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CHARGE_MEM /* 2202 */:
                                        return 557843613;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CST /* 2203 */:
                                        return 557843615;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BRAKE_MODE /* 2204 */:
                                        return 557843745;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AVAS /* 2205 */:
                                        return 557842984;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_SINGLE_CHARGE_ENERGY /* 2206 */:
                                        return 559940899;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_SINGLE_DISCHARGE_ENERGY /* 2207 */:
                                        return 559940900;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MAX_TEMP /* 2208 */:
                                        return 557843749;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MAX_TEMP_NUM /* 2209 */:
                                        return 557843774;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MIN_TEMP /* 2210 */:
                                        return 557843750;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_MIN_TEMP_NUM /* 2211 */:
                                        return 557843775;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MAX /* 2212 */:
                                        return 557843751;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MAX_NUM /* 2213 */:
                                        return 557843752;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MIN /* 2214 */:
                                        return 557843753;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CELL_VOLT_MIN_NUM /* 2215 */:
                                        return 557843754;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_INSULATION_RESIS /* 2216 */:
                                        return 557843755;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CC_CONNECT /* 2217 */:
                                        return 557844515;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PACK_CHARGE /* 2218 */:
                                        return 557843756;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PACK_DC_CHARGE /* 2219 */:
                                        return 557843757;
                                    default:
                                        switch (i) {
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_START_HOUR /* 2224 */:
                                                return 557843764;
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_START_MINUTE /* 2225 */:
                                                return 557843765;
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_STOP_HOUR /* 2226 */:
                                                return 557843766;
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_STOP_MINUTE /* 2227 */:
                                                return 557843767;
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_LEFT_CHARGE_TIME /* 2228 */:
                                                return 557843769;
                                            default:
                                                switch (i) {
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_DISCHG /* 2230 */:
                                                        return 557843772;
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_RANGE_AVAL /* 2231 */:
                                                        return 557843773;
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_SET_SOC_LIMIT /* 2232 */:
                                                        return 557843768;
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_MODE /* 2233 */:
                                                        return 557843776;
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CC2STS /* 2234 */:
                                                        return 557844538;
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PACK_POWER /* 2235 */:
                                                        return 557843808;
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BATTERY_DIS_VOLT /* 2236 */:
                                                        return 559940962;
                                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BATTERY_DIS_CUERRENT /* 2237 */:
                                                        return 559940961;
                                                    default:
                                                        return -1;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static int managerToHalExtPropId_Set(int i) {
        if (i == 2001) {
            return 557843709;
        }
        if (i == 2009) {
            return 557843792;
        }
        if (i == 2019) {
            return 557843796;
        }
        if (i == 2022) {
            return 557843797;
        }
        if (i == 2229 || i == 2230) {
            return 557843771;
        }
        if (i == 2232) {
            return 557843779;
        }
        if (i == 2233) {
            return 557843780;
        }
        switch (i) {
            case 2003:
            case 2004:
                return 557843989;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_FR_SEAT_HEAT /* 2005 */:
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_FR_SEAT_BLOW /* 2006 */:
                return 557843991;
            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_REAR /* 2007 */:
                return 557844036;
            default:
                switch (i) {
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG /* 2012 */:
                        return 557843788;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_PLG_SAS /* 2013 */:
                        return 557843790;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_NAVI /* 2014 */:
                        return 557843782;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_LED /* 2015 */:
                        return 557843785;
                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_NAVI_TURN /* 2016 */:
                        return 557843783;
                    default:
                        switch (i) {
                            case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_GALLERY_MODE /* 2024 */:
                                return 557843812;
                            case ALExtProperty.VC_EXT_VENDOR_NAV_STS /* 2025 */:
                                return VehicleProperty.VC_EXT_VENDOR_NAV_STS_WRITE;
                            case ALExtProperty.VC_EXT_VENDOR_TRAFFIC_STS /* 2026 */:
                                return VehicleProperty.VC_EXT_VENDOR_TRAFFIC_STS_WRITE;
                            case ALExtProperty.VC_EXT_VENDOR_NEXT_TRAFFIC_STS /* 2027 */:
                                return VehicleProperty.VC_EXT_VENDOR_NEXT_TRAFFIC_STS_WRITE;
                            case ALExtProperty.VC_EXT_VENDOR_NAV_DISTANCE /* 2028 */:
                                return VehicleProperty.VC_EXT_VENDOR_NAV_DISTANCE_WRITE;
                            default:
                                switch (i) {
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CHARGE_MEM /* 2202 */:
                                        return 557843614;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_CST /* 2203 */:
                                        return 557843744;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_BRAKE_MODE /* 2204 */:
                                        return 557843777;
                                    case ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AVAS /* 2205 */:
                                        return 557843746;
                                    default:
                                        switch (i) {
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_START_HOUR /* 2224 */:
                                                return 557843760;
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_START_MINUTE /* 2225 */:
                                                return 557843761;
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_STOP_HOUR /* 2226 */:
                                                return 557843762;
                                            case ALExtProperty.VEHICLE_PROPERTY_EXT_CHARGE_STOP_MINUTE /* 2227 */:
                                                return 557843763;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int managerToHalMusicLoudnessAreaId_Set(int i) {
        return 0;
    }

    public static int managerToHalMusicLoudnessPropId_Set(int i) {
        switch (i) {
            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC_LOUDNESS_120HZ /* 545 */:
                return VehicleProperty.VC_VENDOR_MUSIC_LOUDNESS_120HZ_WRITE;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC_LOUDNESS_250HZ /* 546 */:
                return VehicleProperty.VC_VENDOR_MUSIC_LOUDNESS_250HZ_WRITE;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC_LOUDNESS_500HZ /* 547 */:
                return VehicleProperty.VC_VENDOR_MUSIC_LOUDNESS_500HZ_WRITE;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC_LOUDNESS_1000HZ /* 548 */:
                return VehicleProperty.VC_VENDOR_MUSIC_LOUDNESS_1000HZ_WRITE;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC_LOUDNESS_1500HZ /* 549 */:
                return VehicleProperty.VC_VENDOR_MUSIC_LOUDNESS_1500HZ_WRITE;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC_LOUDNESS_2000HZ /* 550 */:
                return VehicleProperty.VC_VENDOR_MUSIC_LOUDNESS_2000HZ_WRITE;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC_LOUDNESS_6000HZ /* 551 */:
                return VehicleProperty.VC_VENDOR_MUSIC_LOUDNESS_6000HZ_WRITE;
            default:
                return -1;
        }
    }

    public static int managerToHalPowerAreaId_Set(int i) {
        return 0;
    }

    public static int managerToHalPowerPropId_Set(int i) {
        switch (i) {
            case 1001:
                return 557842728;
            case 1002:
                return 557842729;
            case 1003:
                return 557842730;
            case 1004:
                return 557842731;
            default:
                return -1;
        }
    }

    private CarUtils() {
    }
}
