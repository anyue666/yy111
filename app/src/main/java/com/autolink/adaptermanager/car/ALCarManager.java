package com.autolink.adaptermanager.car;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.automotive.vehicle.V2_0.VehicleProperty;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import com.autolink.adapterinterface.car.ALCarPropertyEvent;
import com.autolink.adapterinterface.car.IALCar;
import com.autolink.adapterinterface.car.IALCarAVMPropertyListener;
import com.autolink.adapterinterface.car.IALCarEngineSpeedListener;
import com.autolink.adapterinterface.car.IALCarExtPropertyListener;
import com.autolink.adapterinterface.car.IALCarHvacPropertyListener;
import com.autolink.adapterinterface.car.IALCarSpeedListener;
import com.autolink.adapterinterface.car.IALCarSteerListener;
import com.autolink.adapterinterface.car.IALCarTyreListener;
import com.autolink.adapterinterface.car.IALCarVehicleControlPropertyListener;
import com.autolink.adapterinterface.car.IALCarWindListener;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class ALCarManager extends ALBaseManager implements IALManager {
    public static final String ALCAR_SERVICE_BINDER_SERVICE_NAME = "alcar_service";
    private static final String ALCAR_SERVICE_INTERFACE_NAME = "android.autolink.IAutoLinkCar";
    private static final String ALCAR_SERVICE_PACKAGE = "com.autolink.carservice";
    private static final byte BYTE_HVAC_AND_VEHICLECONTROL_MODULAR = 24;
    public static int CAR_GET_PROPERTY_RESULT_CODE_FAIL = -1;
    private static final long CAR_SERVICE_BINDER_POLLING_INTERVAL_MS = 50;
    private static final long CAR_SERVICE_BINDER_POLLING_MAX_RETRY = 100;
    private static final long CAR_SERVICE_BIND_MAX_RETRY = 20;
    private static final long CAR_SERVICE_BIND_RETRY_INTERVAL_MS = 500;
    public static final int CAR_SET_PROPERTY_RESULT_CODE_FAIL = -1;
    public static final int CAR_SET_PROPERTY_RESULT_CODE_SUCCESS = 1;
    private static final boolean DBG = true;
    private static final int DEFAULT_HAL_AREAID = 0;
    private static final int HAL_PROPID_INVALID = -1;
    private static final int HAL_PROP_FLOAT_TYPE_FLAG = 6291456;
    private static final int HAL_PROP_FLOAT_TYPE_MASK = 6291456;
    private static final int HAL_PROP_INT32_TYPE_FLAG = 4194304;
    private static final int HVAC_AND_VEHICLECONTROL_MODULAR = 24;
    private static final int HVAC_FRAG_BOXA = 1;
    private static final int HVAC_FRAG_BOXB = 2;
    private static final int HVAC_FRAG_BOXC = 3;
    private static final int MANAGER_PROPID_INVALID = -1;
    private static final String PROJECT_T1L = "T1L";
    private static final String PROJECT_T1P_INT = "T1P_INT";
    private static final int REAR_DEFROST_SIGNAL_VALUE = 4;
    private static final int SHORT_MAX_VALUE = 32767;
    private static final int SHORT_MIN_VALUE = -32768;
    private static int STATE_CONNECTED = 2;
    private static int STATE_CONNECTING = 1;
    private static int STATE_DISCONNECTED = 0;
    private static String TAG = "ACM";
    private static String currentProject = null;
    private static int mCountForCarSpeed = 0;
    private static int mCountForCarSteer = 0;
    private static int mCountForEngineSpeed = 0;
    private static float mRecordForCarSpeed = -1.0f;
    private static float mRecordForCarSteer = -1.0f;
    private static float mRecordForEngineSpeed = -1.0f;
    private static int mRecordForIsCarSpeedValid = -1;
    private static int mRecordForIsEngineSpeedValid = -1;
    private boolean flagRegisterHvacPropertyListener;
    private boolean flagRegisterVehicleControlPropertyListener;
    private ALCanPM25 mALCanPM25;
    private ALCanVehicleFrag mALCanVehicleFrag;
    private CarEngineSpeedListener mCarEngineSpeedListener;
    private final CarHandler mCarHandler;
    private CarSpeedListener mCarSpeedListener;
    private CarSteerListener mCarSteerListener;
    private CarTyreListener mCarTyreListener;
    private CarWindPropListener mCarWindPropListener;
    private int mConnectionState;
    private final HandlerThread mHandlerThread;
    private IALAirPurgeListener mIALAirPurgeListener;
    private final IALCarAVMPropertyListener mIALCarAVMPropertyListener;
    private IALCarAllTypesVehicleControlPropListener mIALCarAllTypesVehicleControlPropListener;
    private final IALCarEngineSpeedListener mIALCarEngineSpeedListener;
    private final IALCarExtPropertyListener mIALCarExtPropertyListener;
    private final IALCarHvacPropertyListener mIALCarHvacPropertyListener;
    private IALCarPropListener mIALCarPropListener;
    private final IALCarSpeedListener mIALCarSpeedListener;
    private final IALCarSteerListener mIALCarSteerListener;
    private final IALCarTyreListener mIALCarTyreListener;
    private final IALCarVehicleControlPropertyListener mIALCarVehicleControlPropertyListener;
    private final IALCarWindListener mIALCarWindListener;
    private final Map<Integer, IALCmdListener> mIALCmdListenerMap;
    private IALExtCarPropListener mIALExtCarPropListener;
    private final Runnable mInitDataTask;
    private final Object mLockForCarService;
    private final Object mLockForListener;
    private IALCar mService;
    private boolean mServiceBound;
    private final Runnable mTaskToReduceLog;

    public interface CarEngineSpeedListener {
        void onCarEngineSpeedChanged(float f, int i);
    }

    public interface CarSpeedListener {
        void onCarSpeedChanged(float f, int i);
    }

    public interface CarSteerListener {
        void onCarSteerChanged(float f);
    }

    public interface CarTyreListener {
        void onTyreDataChanged(int i, int i2);

        void onTyreFloatDataChanged(int i, float f);
    }

    public interface CarWindPropListener {
        void onALCarWindEventChanged(ALCarPropertyEvent aLCarPropertyEvent);
    }

    public interface IALAirPurgeListener {
        void onPMChanged(ALCanPM25 aLCanPM25);

        void onVehicleLFrag(ALCanVehicleFrag aLCanVehicleFrag);
    }

    public interface IALCarAllTypesVehicleControlPropListener {
        void onALCarVehicleControlPropChanged(ALCarPropertyEvent aLCarPropertyEvent);
    }

    public interface IALCarPropListener {
        void onALCarPropChanged(ALCarPropertyEvent aLCarPropertyEvent);
    }

    public interface IALCmdListener {
        void onCmdChanged(byte b, byte b2, short s, int i);
    }

    public interface IALExtCarPropListener {
        void onALCarEventChanged(ALCarPropertyEvent aLCarPropertyEvent);
    }

    private int halToManagerPropId(int i) {
        switch (i) {
            case VehicleProperty.CLUSTER_POWERSTATE_T1J_KEYSTS /* 557842714 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_KEY_STS;
            case VehicleProperty.CLUSTER_ILLUMINATION_T1J_PARK_TAIL_LIGHT_STS /* 557842725 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PARK_TAIL_LIGHT;
            case VehicleProperty.ALARM_MODE_T1J /* 557842727 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_ALARM_MODE;
            case VehicleProperty.CLUSTER_EPS_FAIL_OIL /* 557842968 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_MODE;
            case VehicleProperty.CLUSTER_HCU_PT_READY /* 557842983 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_PTREADY;
            case VehicleProperty.CLUSTER_CGW_HCU_1_G_POWER_MODE_FED /* 557843113 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_POWER_MODE;
            case VehicleProperty.CLUSTER_FCM_FRM_6_ACC_MODE /* 557843132 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_ACC_MODE;
            case VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_LF /* 557843165 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_LF;
            case VehicleProperty.CLUSTER_LDP_SYS /* 557843333 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_LDP_MODE;
            case VehicleProperty.VC_VENDOR_ADAS_AEB_READ /* 557843457 */:
                return 501;
            case VehicleProperty.VC_VENDOR_ADAS_FCW_SEN_READ /* 557843459 */:
                return 502;
            case VehicleProperty.VC_VENDOR_ADAS_FCW_ON_OFF_READ /* 557843461 */:
                return 503;
            case VehicleProperty.VC_VENDOR_ADAS_IF_EXIT_READ /* 557843463 */:
                return 504;
            case VehicleProperty.VC_VENDOR_ADAS_SLA_ON_OFF_READ /* 557843465 */:
                return 505;
            case VehicleProperty.VC_VENDOR_ADAS_SCF_READ /* 557843467 */:
                return 506;
            case VehicleProperty.VC_VENDOR_ADAS_DAI_READ /* 557843469 */:
                return 507;
            case VehicleProperty.VC_VENDOR_ADAS_IES_READ /* 557843471 */:
                return 508;
            case VehicleProperty.VC_VENDOR_ADAS_TSI_READ /* 557843473 */:
                return 509;
            case VehicleProperty.VC_VENDOR_ADAS_LDW_READ /* 557843477 */:
                return 511;
            case VehicleProperty.VC_VENDOR_ADAS_LDP_READ /* 557843481 */:
                return 513;
            case VehicleProperty.VC_VENDOR_ADAS_LDP_SEN_READ /* 557843483 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDP_SEN;
            case VehicleProperty.VC_VENDOR_ADAS_ELK_READ /* 557843485 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_ELK;
            case VehicleProperty.VC_VENDOR_ADAS_DWD_READ /* 557843487 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DWD;
            case VehicleProperty.VC_VENDOR_ADAS_BSD_READ /* 557843489 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_BSD;
            case VehicleProperty.VC_VENDOR_ADAS_DOW_READ /* 557843491 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DOW;
            case VehicleProperty.VC_VENDOR_ADAS_RCW_READ /* 557843493 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_RCW;
            case VehicleProperty.VC_VENDOR_ESP_READ /* 557843499 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ESP;
            case VehicleProperty.VC_VENDOR_HDC_READ /* 557843501 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HDC;
            case VehicleProperty.VC_VENDOR_AVH_READ /* 557843503 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_AVH;
            case VehicleProperty.VC_VENDOR_MIRROR_HOLD_SWITCH_READ /* 557843505 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_HOLD_SWITCH;
            case VehicleProperty.VC_VENDOR_MIRROR_FLIP_READ /* 557843507 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_FLIP;
            case VehicleProperty.VC_VENDOR_MIRROR_LEFT_READ /* 557843510 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_LEFT;
            case VehicleProperty.VC_VENDOR_MIRROR_RIGHT_READ /* 557843512 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_RIGHT;
            case VehicleProperty.VC_VENDOR_MIRROR_DRIVER_READ /* 557843514 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_DRIVER;
            case VehicleProperty.VC_VENDOR_FL_WINDOW_READ /* 557843516 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FL_WINDOW;
            case VehicleProperty.VC_VENDOR_FR_WINDOW_READ /* 557843518 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FR_WINDOW;
            case VehicleProperty.VC_VENDOR_RL_WINDOW_READ /* 557843520 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_RL_WINDOW;
            case VehicleProperty.VC_VENDOR_RR_WINDOW_READ /* 557843522 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_RR_WINDOW;
            case VehicleProperty.VC_VENDOR_SKYLIGHT_READ /* 557843524 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SKYLIGHT;
            case VehicleProperty.VC_VENDOR_SKYLIGHT_PERCENTAGE_READ /* 557843526 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SKYLIGHT_PERCENTAGE;
            case VehicleProperty.VC_VENDOR_SUNSHADE_READ /* 557843528 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SUNSHADE;
            case VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_READ /* 557843530 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT;
            case VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_BRIGHTNESS_READ /* 557843532 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT_BRIGHTNESS;
            case VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_COLOR_READ /* 557843534 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT_COLOR;
            case VehicleProperty.VC_VENDOR_STATIC_MODE_READ /* 557843536 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_STATIC_MODE;
            case VehicleProperty.VC_VENDOR_MUSIC_READ /* 557843538 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC;
            case VehicleProperty.VC_VENDOR_DMS_READ /* 557843540 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DMS;
            case VehicleProperty.VC_VENDOR_AUTOLOCK_READ /* 557843549 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AUTOLOCK;
            case VehicleProperty.VC_VENDOR_AUTOUNLOCK_READ /* 557843551 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AUTOUNLOCK;
            case VehicleProperty.VC_VENDOR_REMOTELOCK_READ /* 557843553 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_REMOTELOCK;
            case VehicleProperty.VC_VENDOR_WELCOME_READ /* 557843555 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME;
            case VehicleProperty.VC_VENDOR_WELCOME_FL_READ /* 557843557 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME_FL;
            case VehicleProperty.VC_VENDOR_REAR_WIPER_READ /* 557843559 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_REAR_WIPER;
            case VehicleProperty.VC_VENDOR_PAS_READ /* 557843561 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_PAS;
            case VehicleProperty.VC_VENDOR_DRIVER_SEAT_FR_READ /* 557843566 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEAT_FR;
            case VehicleProperty.VC_VENDOR_DRIVER_SEAT_BACK_FR_READ /* 557843568 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEAT_BACK_FR;
            case VehicleProperty.VC_VENDOR_DRIVER_SEATF_UD_READ /* 557843570 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEATF_UD;
            case VehicleProperty.VC_VENDOR_DRIVER_SEATR_UD_READ /* 557843572 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEATR_UD;
            case VehicleProperty.VC_VENDOR_DRIVER_LUMBART_FR_READ /* 557843574 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_LUMBART_FR;
            case VehicleProperty.VC_VENDOR_DRIVER_LUMBART_UD_READ /* 557843576 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_LUMBART_UD;
            case VehicleProperty.VC_VENDOR_PASSENGER_SEAT_FR_READ /* 557843578 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_FR;
            case VehicleProperty.VC_VENDOR_PASSENGER_SEAT_BACK_FR_READ /* 557843580 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_BACK_FR;
            case VehicleProperty.VC_VENDOR_PASSENGER_SEAT_LEG_FR_READ /* 557843582 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_LEG_FR;
            case VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_READ /* 557843584 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE;
            case VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_INTENSITY_READ /* 557843586 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE_INTENSITY;
            case VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_MODE_READ /* 557843588 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE_MODE;
            case VehicleProperty.VC_VENDOR_MFS_HEAT_READ /* 557843592 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MFS_HEAT;
            case VehicleProperty.VC_VENDOR_MFS_SHAKE_READ /* 557843594 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MFS_SHAKE;
            case VehicleProperty.VC_VENDOR_EPS_DRIVER_MODE_READ /* 557843598 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_DRIVER_MODE;
            case VehicleProperty.VC_VENDOR_LIGHT_HEIGHT_READ /* 557843600 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_LIGHT_HEIGHT;
            case VehicleProperty.VC_VENDOR_FOLLOW_ME_HOME_READ /* 557843602 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FOLLOW_ME_HOME;
            case VehicleProperty.VC_VENDOR_BLINK_NO_READ /* 557843604 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_BLINK_NO;
            case VehicleProperty.VC_VENDOR_HMA_READ /* 557843606 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HMA;
            case VehicleProperty.VC_VENDOR_HMA_ON_READ /* 557843608 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HMA_ON;
            case VehicleProperty.VC_VENDOR_ISS_READ /* 557843610 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ISS;
            case VehicleProperty.VC_VENDOR_WARNING_DISTANCE_READ /* 557843616 */:
                return 607;
            case VehicleProperty.VC_VENDOR_MIRROR_HOLD_READ /* 557843617 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_HOLD;
            case VehicleProperty.SCENE_VENDOR_KEY_STS_READ /* 557843618 */:
                return 608;
            case VehicleProperty.SCENE_VENDOR_ENGINE_STS_READ /* 557843619 */:
                return 609;
            case VehicleProperty.SCENE_VENDOR_DRIVER_DOOR_STS_READ /* 557843620 */:
                return 610;
            case VehicleProperty.SCENE_VENDOR_PASSENGER_DOOR_STS_READ /* 557843621 */:
                return 611;
            case VehicleProperty.SCENE_VENDOR_RHR_DOOR_STS_READ /* 557843622 */:
                return 612;
            case VehicleProperty.SCENE_VENDOR_LHR_DOOR_STS_READ /* 557843623 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_LHR_DOOR;
            case VehicleProperty.SCENE_VENDOR_CO_STS_READ /* 557843624 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_CO_STS;
            case VehicleProperty.SCENE_VENDOR_CO_ERR_READ /* 557843625 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_CO_ERR;
            case VehicleProperty.VC_VENDOR_WELCOME_PASSENGER_READ /* 557843637 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME_FR;
            case VehicleProperty.VC_EXT_VENDOR_CURVE_DEC_READ /* 557843670 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_CURVE_DEC;
            case VehicleProperty.VC_EXT_VENDOR_AEB_T1P_READ /* 557843675 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AEB_T1P;
            case VehicleProperty.VC_EXT_VENDOR_FCW_OPTION_T1P_READ /* 557843677 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCW_OPTION_T1P;
            case VehicleProperty.VC_EXT_VENDOR_FCW_ON_T1P_READ /* 557843679 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCW_T1P;
            case VehicleProperty.VC_VENDOR_WINDOW_INHIBIT_READ /* 557843684 */:
                return 768;
            case VehicleProperty.VC_EXT_VENDOR_TJA_T1P_READ /* 557843698 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TJA_ICA_T1P;
            case VehicleProperty.VC_EXT_VENDOR_DISTANCE_WARNING_T1P_READ /* 557843700 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DISTANCE_WARN_T1P;
            case VehicleProperty.VC_EXT_VENDOR_LDW_LKA_SEN_T1P_READ /* 557843706 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDW_SEN_T1P;
            case VehicleProperty.CLUSTER_LKA_STATUS /* 557843733 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_LDP_MODE_CR2407;
            case VehicleProperty.VC_VENDOR_ADAS_RCTB_ZDC_READ /* 557843820 */:
                return 704;
            case VehicleProperty.VC_VENDOR_ADAS_RCW_ZDC_READ /* 557843822 */:
                return 705;
            case VehicleProperty.VC_VENDOR_ADAS_PAS_ZDC_READ /* 557843829 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_PAS_ZDC;
            case VehicleProperty.CLUSTER_EPS_FAIL_OIL_PHEV /* 557843841 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_MODE_PHEV;
            case VehicleProperty.VC_VENDOR_ATMOSPHERE_STATIC_LIGHT_COLOR_READ /* 557843843 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_STATIC_COLOR;
            case VehicleProperty.VC_VENDOR_MIRROR_FLIP_T1K_READ /* 557843847 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_FLIP_T1K;
            case 557843849:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_WIND_SCREEN_HEAT;
            case VehicleProperty.VC_VENDOR_CST_SEN_READ /* 557843854 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_CST_SEN;
            case VehicleProperty.VC_VENDOR_IPB_READ /* 557843856 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_IPB;
            case VehicleProperty.VC_VENDOR_DRIVE_ATMOSPHERE_LIGHT_READ /* 557843858 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVE_ATMOSPHERE_LIGHT;
            case VehicleProperty.VC_VENDOR_PM25_ATMOSPHERE_LIGHT_READ /* 557843860 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PM25_ATMOSPHERE_LIGHT;
            case VehicleProperty.VC_VENDOR_DOOR_KNOB_TIME_READ /* 557843868 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DOOR_KNOB_TIME;
            case VehicleProperty.VC_VENDOR_DOOR_KNOB_MODE_READ /* 557843870 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DOOR_KNOB_MODE;
            case VehicleProperty.VC_VENDOR_HUD_READ /* 557843872 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_HUD;
            case VehicleProperty.VC_VENDOR_HUD_MODE_READ /* 557843874 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_MODE;
            case VehicleProperty.VC_VENDOR_HUD_HEIGHT_READ /* 557843876 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_HEIGHT;
            case VehicleProperty.VC_VENDOR_HUD_BRIGHTNESS_MODE_READ /* 557843878 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_BRIGHTNESS_MODE;
            case VehicleProperty.VC_VENDOR_HUD_BRIGHTNESS_READ /* 557843880 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_BRIGHTNESS;
            case VehicleProperty.VC_VENDOR_BLUETOOTH_DISPLAY_READ /* 557843882 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_BLUETOOTH_DISPLAY;
            case VehicleProperty.VC_VENDOR_DAS_DISPLAY_READ /* 557843884 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DAS_DISPLAY;
            case VehicleProperty.DVR_IHU_DATA0_T1L /* 557843897 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA0_T1L;
            case VehicleProperty.DVR_IHU_DATA1_T1L /* 557843898 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA1_T1L;
            case VehicleProperty.DVR_IHU_DATA2_T1L /* 557843899 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA2_T1L;
            case VehicleProperty.DVR_IHU_DATA3_T1L /* 557843900 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA3_T1L;
            case VehicleProperty.DVR_IHU_DATA4_T1L /* 557843901 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA4_T1L;
            case VehicleProperty.DVR_IHU_DATA5_T1L /* 557843902 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA5_T1L;
            case VehicleProperty.DVR_IHU_DATA6_T1L /* 557843903 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA6_T1L;
            case VehicleProperty.DVR_IHU_DATA7_T1L /* 557843904 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA7_T1L;
            case VehicleProperty.DVR_IHU_SYSTEMSTS_T1L /* 557843905 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_SYSTEMSTS_T1L;
            case VehicleProperty.VC_VENDOR_HAZARD_READ /* 557843908 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_HAZARD;
            case 557843968:
                return 90;
            case 557843970:
                return 401;
            case 557843972:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ACMAX;
            case 557843974:
                return 110;
            case 557843976:
                return 39;
            case 557843978:
                return 38;
            case 557843980:
                return 40;
            case 557843982:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_DEFROSTER_T1K;
            case 557843984:
                return 94;
            case 557843988:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_HEAT_AND_WIND;
            case 557843990:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_HEAT_AND_WIND;
            case 557843992:
                return 42;
            case 557843994:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION;
            case 557843996:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION_INTENSITY;
            case 557843998:
                return 52;
            case 557844000:
                return 51;
            case 557844002:
                return 53;
            case 557844004:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_AUTO_VENTILATION;
            case 557844010:
                return 33;
            case 557844012:
                return 34;
            case 557844018:
                return 35;
            case 557844020:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_CUSTOM;
            case 557844024:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_IN_PM25_LEVEL;
            case 557844025:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_OUT_PM25_LEVEL;
            case 557844029:
                return 41;
            case 557844037:
                return 301;
            case 557844039:
                return 302;
            case 557844041:
                return 303;
            case 557844043:
                return 304;
            case 557844045:
                return 305;
            case 557844047:
                return 306;
            case 557844049:
                return 307;
            case 557844051:
                return 308;
            case 557844053:
                return 309;
            case 557844055:
                return 310;
            case 557844057:
                return 311;
            case 557844063:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_COOL_PHEV;
            case 557844066:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION_PHEV;
            case 557844067:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION_INTENSITY_PHEV;
            case 557844069:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_AC_MAX_STATUS_PHEV;
            case 557844071:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_PARK_AIR;
            case 557844073:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_ELEC_TEMP;
            case 557844075:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_HEAT;
            case 557844077:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_HEAT;
            case VehicleProperty.HVAC_VENDOR_PANEL_AC_READ /* 557844080 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_AC;
            case VehicleProperty.HVAC_VENDOR_PANEL_FRONT_BLOW_SPEED_READ /* 557844081 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FRONT_BLOW_SPEED;
            case VehicleProperty.HVAC_VENDOR_PANEL_FRONT_BLOW_MODE_READ /* 557844082 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FRONT_BLOW_MODE;
            case VehicleProperty.HVAC_VENDOR_PANEL_FRONT_AUTO_READ /* 557844083 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FRONT_AUTO;
            case VehicleProperty.HVAC_VENDOR_PANEL_RECY_MODE_READ /* 557844084 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_RECY_MODE;
            case VehicleProperty.HVAC_VENDOR_PANEL_REAR_DEFROST_READ /* 557844085 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_REAR_DEFROST;
            case VehicleProperty.CLUSTER_CEM_2_DRL_STS /* 557844481 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVER_LIGHT;
            case VehicleProperty.CLUSTER_CEM_2_FRONT_FOG_LIGHT_STS /* 557844482 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FRONT_FOG_LIGHT;
            case VehicleProperty.CLUSTER_CEM_2_REAR_FOG_LIGHT_STS /* 557844483 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_REAR_FOG_LIGHT;
            case 557844505:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_AEB_MODE;
            case VehicleProperty.CLUSTER_TJA_ICA_MODE /* 557844507 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_TJA_MODE;
            case VehicleProperty.CLUSTER_BSD_1_SYSTEM_STATE /* 557844508 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_BSD_MODE;
            case VehicleProperty.CLUSTER_FCM_10_SLA_ONOFF_STS /* 557844509 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCM_10_SLA_ON_OFF;
            case VehicleProperty.CLUSTER_HCU_SOC_MANAGE_FED /* 557844517 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_SOC_MANAGE;
            case VehicleProperty.CLUSTER_FRM_3_ACCMODE /* 557844527 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_ACC_MODE_CR2407;
            case VehicleProperty.CLUSTER_FRM_3_AEBMODE /* 557844530 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_AEB_MODE_CR2407;
            case VehicleProperty.CLUSTER_LDW_LKA_LANE_ASSITFEE /* 557844533 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDW_T1P;
            case VehicleProperty.CLUSTER_SLA_ONOFF_STS /* 557844534 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_SLA_T1P;
            case VehicleProperty.CLUSTER_AVM_BREAK_LIGHT_STS /* 557844738 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_BRAKE;
            case 557844740:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_LOW_BEAM_T1K;
            case 557844770:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_AVM_DISPLAY;
            case 557844776:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_AVM_360;
            case VehicleProperty.CLUSTER_AVM_ESP_TANKS_TAB /* 557844800 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_ESP_TANKS_TAB;
            case VehicleProperty.STAT_AMP_SOUND_EFFECT_BASSMID /* 557847103 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_SOUND_EFFECT_MID;
            case VehicleProperty.STAT_AMP_SOUND_EFFECT_MIDTREBLE /* 557847105 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_SOUND_EFFECT_MIDTREBLE;
            case VehicleProperty.CLUSTER_BATT_LOW_ALARM /* 559940102 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_POWER_DISTANCE;
            case VehicleProperty.CLUSTER_CEM_IPM_3_TMM_2_EXTERNAL_TEMPERATURE_RAW /* 559940264 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_EXTEMP;
            case VehicleProperty.CLUSTER_CEM_5_TIRE_LF /* 559940275 */:
                return 603;
            case VehicleProperty.CLUSTER_CEM_5_TIRE_RF /* 559940276 */:
                return 604;
            case VehicleProperty.CLUSTER_CEM_5_TIRE_LR /* 559940277 */:
                return 605;
            case VehicleProperty.CLUSTER_CEM_5_TIRE_RR /* 559940278 */:
                return 606;
            case VehicleProperty.YAS_VENDOR_LATERA_ACCALELERATION_READ /* 559940787 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_LATERA_ACCALELERATION;
            case 559941158:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_TEMPERATURE_FLOAT;
            case 559941160:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_TEMPERATURE_FLOAT;
            case 559941222:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_SOC;
            case VehicleProperty.HVAC_VENDOR_PANEL_FLTEMP_READ /* 559941231 */:
                return ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FLTEMP;
            case VehicleProperty.CLUSTER_AVM_STEER_ANGLE /* 559941893 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_STEERING_ANGLE;
            case VehicleProperty.LONGITUDINALACCELERATION /* 559944249 */:
                return ALVehicleControlProperty.VEHICLE_PROPERTY_LONGITUDINAL_ACCALELERATION;
            default:
                switch (i) {
                    case VehicleProperty.CLUSTER_ENGINE_RECOVERY_LEVEL /* 557842985 */:
                        return ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_REGEBERATE_LEVEL;
                    case VehicleProperty.CLUSTER_LH_TURN_SOUND /* 557842986 */:
                        return ALVehicleControlProperty.VEHICLE_PROPERTY_LEFT_TURN_LIGHT;
                    case VehicleProperty.CLUSTER_RH_TURN_SOUND /* 557842987 */:
                        return ALVehicleControlProperty.VEHICLE_PROPERTY_RIGHT_TURN_LIGHT;
                    default:
                        switch (i) {
                            case VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_RF /* 557843118 */:
                                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_RF;
                            case VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_LR /* 557843119 */:
                                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_LR;
                            case VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_RR /* 557843120 */:
                                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_RR;
                            case VehicleProperty.CLUSTER_CEM_5_TIRE_POSTION /* 557843121 */:
                                return 601;
                            case VehicleProperty.CLUSTER_CEM_5_TIRE_TEMPERATURE /* 557843122 */:
                                return 602;
                            default:
                                switch (i) {
                                    case VehicleProperty.CLUSTER_CHILD_LOCK /* 557843343 */:
                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_CHILD_LOCK;
                                    case VehicleProperty.CLUSTER_VENDOR_CRASH_READ /* 557843344 */:
                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_AIR_BAG;
                                    case VehicleProperty.CLUSTER_VENDOR_AEB_DEC_READ /* 557843345 */:
                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_AEB_DEC;
                                    case VehicleProperty.CLUSTER_VENDOR_HAZARD_LIGHT_READ /* 557843346 */:
                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_RIGHT_HAZARD_LIGHT;
                                    default:
                                        switch (i) {
                                            case VehicleProperty.SCENE_VENDOR_POWER_LIMIT_READ /* 557843629 */:
                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_POWER_LIMIT;
                                            case VehicleProperty.SCENE_VENDOR_LIGHT_SHOW_READ /* 557843630 */:
                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_LIGHT_SHOW;
                                            case VehicleProperty.SCENE_VENDOR_EMS_ENGINE_STS_READ /* 557843631 */:
                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_ENGINE_STS;
                                            case VehicleProperty.SCENE_VENDOR_PM25_STS_READ /* 557843632 */:
                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_PM25_STS;
                                            case VehicleProperty.WIRELESS_VENDOR_CHARGING_STS_READ /* 557843633 */:
                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_WIRELESS_CHARGING;
                                            case VehicleProperty.WIRELESS_VENDOR_ENTER_SFCHARGE_READ /* 557843634 */:
                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_WIRELESS_FAST_CHARGE;
                                            default:
                                                switch (i) {
                                                    case VehicleProperty.VC_VENDOR_PHEV_HV_READ /* 557843644 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_HV;
                                                    case VehicleProperty.SCENE_VENDOR_LH_TURN_LIGHT_READ /* 557843645 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_LH_TURN_LIGHT;
                                                    case VehicleProperty.SCENE_VENDOR_RH_TURN_LIGHT_READ /* 557843646 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_RH_TURN_LIGHT;
                                                    case VehicleProperty.SCENE_VENDOR_LOW_BEAM_READ /* 557843647 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_LOW_BEAM;
                                                    case VehicleProperty.SCENE_VENDOR_HIGH_BEAM_READ /* 557843648 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_HIGH_BEAM;
                                                    case VehicleProperty.VC_VENDOR_PASSENGER_MIRROR_LOCATION_READ /* 557843649 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MIRROR_LOCATION;
                                                    case VehicleProperty.VC_VENDOR_PASSENGER_SEAT_READ /* 557843650 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_SEAT_FR;
                                                    case VehicleProperty.VC_VENDOR_PASSENGER_SEAT_BACK_READ /* 557843651 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_SEAT_BACK_FR;
                                                    case VehicleProperty.VC_VENDOR_PASSENGER_SEAT_LEG_READ /* 557843652 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_SEAT_LEG_FR;
                                                    case VehicleProperty.VC_VENDOR_DRIVER_UNLOCK_READ /* 557843653 */:
                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVER_UNLOCK;
                                                    default:
                                                        switch (i) {
                                                            case VehicleProperty.VC_VENDOR_ADAS_LDW_ZDC_READ /* 557843816 */:
                                                                return 701;
                                                            case VehicleProperty.VC_VENDOR_ADAS_LDP_ZDC_READ /* 557843817 */:
                                                                return 702;
                                                            case VehicleProperty.VC_VENDOR_ADAS_IES_ZDC_READ /* 557843818 */:
                                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_IES_ZDC;
                                                            default:
                                                                switch (i) {
                                                                    case VehicleProperty.VC_VENDOR_ADAS_DCLC_ZDC_READ /* 557843824 */:
                                                                        return 706;
                                                                    case VehicleProperty.VC_VENDOR_ADAS_IF_EXIT_ZDC_READ /* 557843825 */:
                                                                        return 707;
                                                                    case VehicleProperty.VC_VENDOR_ADAS_DAI_ZDC_READ /* 557843826 */:
                                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DAI_ZDC;
                                                                    case VehicleProperty.VC_VENDOR_ADAS_ELK_ZDC_READ /* 557843827 */:
                                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_ELK_ZDC;
                                                                    default:
                                                                        switch (i) {
                                                                            case VehicleProperty.VC_VENDOR_WIPER_MODE_READ /* 557843863 */:
                                                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_WIPER_MODE;
                                                                            case VehicleProperty.VC_VENDOR_PDOOR_BUTTON_READ /* 557843864 */:
                                                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_PDOOR_BUTTON;
                                                                            case VehicleProperty.VC_VENDOR_LHRDOOR_BUTTON_READ /* 557843865 */:
                                                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_LHRDOOR_BUTTON;
                                                                            case VehicleProperty.VC_VENDOR_RHRDOOR_BUTTON_READ /* 557843866 */:
                                                                                return ALVehicleControlProperty.VEHICLE_PROPERTY_RHRDOOR_BUTTON;
                                                                            default:
                                                                                switch (i) {
                                                                                    case VehicleProperty.VC_VENDOR_NAV_DISPLAY_READ /* 557843886 */:
                                                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_NAV_DISPLAY;
                                                                                    case VehicleProperty.VC_EXT_VENDOR_HOME_CONNECT_READ /* 557843887 */:
                                                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_EXT_VENDOR_HOME_CONNECT;
                                                                                    case VehicleProperty.VC_EXT_VENDOR_APA_FAIL_READ /* 557843888 */:
                                                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_VC_EXT_VENDOR_APA_FAIL;
                                                                                    case VehicleProperty.VC_VENDOR_MFS_SHAKE_7_READ /* 557843889 */:
                                                                                        return ALVehicleControlProperty.VEHICLE_PROPERTY_MFS_SHAKE_7;
                                                                                    default:
                                                                                        return -1;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    private int managerToHalAreaId_Get(int i) {
        return 0;
    }

    private int managerToHalAreaId_Set(int i) {
        return 0;
    }

    private int managerToHalPropId_Get(int i) {
        if (i == 164) {
            return 557843994;
        }
        if (i == 165) {
            return 557843996;
        }
        switch (i) {
            case 33:
                return 557844010;
            case 34:
                return 557844012;
            case 35:
                return 557844018;
            default:
                switch (i) {
                    case 38:
                        return 557843978;
                    case 39:
                        return 557843976;
                    case 40:
                        return 557843980;
                    case 41:
                        return 557844029;
                    case 42:
                        return 557843992;
                    default:
                        switch (i) {
                            case 51:
                                return 557844000;
                            case 52:
                                return 557843998;
                            case 53:
                                return 557844002;
                            default:
                                switch (i) {
                                    case 90:
                                        return 557843968;
                                    case 94:
                                        return 557843984;
                                    case 110:
                                        return 557843974;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_IN_PM25 /* 209 */:
                                        return 557843986;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_OUT_PM25 /* 210 */:
                                        return 557843987;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FRCE_BOXA /* 211 */:
                                        return 557844014;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FRCE_BOXB /* 212 */:
                                        return 557844015;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FRCE_BOXC /* 213 */:
                                        return 557844016;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION_PHEV /* 214 */:
                                        return 557844066;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION_INTENSITY_PHEV /* 215 */:
                                        return 557844067;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_COOL_PHEV /* 216 */:
                                        return 557844063;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_PARK_AIR /* 217 */:
                                        return 557844071;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ENGINE_SPEED /* 218 */:
                                        return 559944245;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ENGINE_SPEED_VALID /* 219 */:
                                        return 557843813;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_SOC /* 220 */:
                                        return 559941222;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_AC_MAX_STATUS_PHEV /* 221 */:
                                        return 557844069;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_ELEC_TEMP /* 222 */:
                                        return 557844073;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_HEAT /* 223 */:
                                        return 557844075;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_HEAT /* 224 */:
                                        return 557844077;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_WIND_SCREEN_HEAT /* 225 */:
                                        return 557843849;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_DEFROSTER_T1K /* 226 */:
                                        return 557843982;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FLTEMP /* 227 */:
                                        return VehicleProperty.HVAC_VENDOR_PANEL_FLTEMP_READ;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ACMAX /* 228 */:
                                        return 557843972;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FRONT_BLOW_SPEED /* 229 */:
                                        return VehicleProperty.HVAC_VENDOR_PANEL_FRONT_BLOW_SPEED_READ;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FRONT_BLOW_MODE /* 230 */:
                                        return VehicleProperty.HVAC_VENDOR_PANEL_FRONT_BLOW_MODE_READ;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_FRONT_AUTO /* 231 */:
                                        return VehicleProperty.HVAC_VENDOR_PANEL_FRONT_AUTO_READ;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_RECY_MODE /* 232 */:
                                        return VehicleProperty.HVAC_VENDOR_PANEL_RECY_MODE_READ;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_REAR_DEFROST /* 233 */:
                                        return VehicleProperty.HVAC_VENDOR_PANEL_REAR_DEFROST_READ;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_PANEL_AC /* 234 */:
                                        return VehicleProperty.HVAC_VENDOR_PANEL_AC_READ;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_EXTEMP /* 235 */:
                                        return VehicleProperty.CLUSTER_CEM_IPM_3_TMM_2_EXTERNAL_TEMPERATURE_RAW;
                                    case 401:
                                        return 557843970;
                                    case 511:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDW_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ESP /* 522 */:
                                        return VehicleProperty.VC_VENDOR_ESP_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HDC /* 523 */:
                                        return VehicleProperty.VC_VENDOR_HDC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_AVH /* 524 */:
                                        return VehicleProperty.VC_VENDOR_AVH_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ISS /* 525 */:
                                        return VehicleProperty.VC_VENDOR_ISS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_HOLD_SWITCH /* 526 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_HOLD_SWITCH_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_FLIP /* 527 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_FLIP_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_HOLD /* 528 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_HOLD_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_LEFT /* 529 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_LEFT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_RIGHT /* 530 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_RIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_DRIVER /* 531 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_DRIVER_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FL_WINDOW /* 532 */:
                                        return VehicleProperty.VC_VENDOR_FL_WINDOW_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FR_WINDOW /* 533 */:
                                        return VehicleProperty.VC_VENDOR_FR_WINDOW_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_RL_WINDOW /* 534 */:
                                        return VehicleProperty.VC_VENDOR_RL_WINDOW_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_RR_WINDOW /* 535 */:
                                        return VehicleProperty.VC_VENDOR_RR_WINDOW_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SKYLIGHT /* 536 */:
                                        return VehicleProperty.VC_VENDOR_SKYLIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SKYLIGHT_PERCENTAGE /* 537 */:
                                        return VehicleProperty.VC_VENDOR_SKYLIGHT_PERCENTAGE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SUNSHADE /* 538 */:
                                        return VehicleProperty.VC_VENDOR_SUNSHADE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT /* 539 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT_BRIGHTNESS /* 540 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_BRIGHTNESS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT_COLOR /* 541 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_COLOR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_STATIC_MODE /* 542 */:
                                        return VehicleProperty.VC_VENDOR_STATIC_MODE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC /* 543 */:
                                        return VehicleProperty.VC_VENDOR_MUSIC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DMS /* 544 */:
                                        return VehicleProperty.VC_VENDOR_DMS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AUTOLOCK /* 552 */:
                                        return VehicleProperty.VC_VENDOR_AUTOLOCK_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AUTOUNLOCK /* 553 */:
                                        return VehicleProperty.VC_VENDOR_AUTOUNLOCK_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_REMOTELOCK /* 554 */:
                                        return VehicleProperty.VC_VENDOR_REMOTELOCK_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME /* 555 */:
                                        return VehicleProperty.VC_VENDOR_WELCOME_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME_FL /* 556 */:
                                        return VehicleProperty.VC_VENDOR_WELCOME_FL_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_REAR_WIPER /* 557 */:
                                        return VehicleProperty.VC_VENDOR_REAR_WIPER_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_PAS /* 558 */:
                                        return VehicleProperty.VC_VENDOR_PAS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_CHILD_LOCK /* 560 */:
                                        return VehicleProperty.CLUSTER_CHILD_LOCK;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEAT_FR /* 561 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEAT_FR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEAT_BACK_FR /* 562 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEAT_BACK_FR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEATF_UD /* 563 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEATF_UD_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEATR_UD /* 564 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEATR_UD_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_LUMBART_FR /* 565 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_LUMBART_FR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_LUMBART_UD /* 566 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_LUMBART_UD_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_SEAT_FR /* 567 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_SEAT_BACK_FR /* 568 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_BACK_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_SEAT_LEG_FR /* 569 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_LEG_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE /* 570 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE_INTENSITY /* 571 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_INTENSITY_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE_MODE /* 572 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_MODE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MIRROR_LOCATION /* 573 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MIRROR_LOCATION_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MFS_HEAT /* 574 */:
                                        return VehicleProperty.VC_VENDOR_MFS_HEAT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MFS_SHAKE /* 575 */:
                                        return VehicleProperty.VC_VENDOR_MFS_SHAKE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_MODE /* 576 */:
                                        return VehicleProperty.CLUSTER_EPS_FAIL_OIL;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_DRIVER_MODE /* 577 */:
                                        return VehicleProperty.VC_VENDOR_EPS_DRIVER_MODE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_LIGHT_HEIGHT /* 578 */:
                                        return VehicleProperty.VC_VENDOR_LIGHT_HEIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FOLLOW_ME_HOME /* 579 */:
                                        return VehicleProperty.VC_VENDOR_FOLLOW_ME_HOME_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_BLINK_NO /* 580 */:
                                        return VehicleProperty.VC_VENDOR_BLINK_NO_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HMA /* 581 */:
                                        return VehicleProperty.VC_VENDOR_HMA_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HMA_ON /* 582 */:
                                        return VehicleProperty.VC_VENDOR_HMA_ON_READ;
                                    case 601:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_POSTION;
                                    case 602:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_TEMPERATURE;
                                    case 603:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_LF;
                                    case 604:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_RF;
                                    case 605:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_LR;
                                    case 606:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_RR;
                                    case 607:
                                        return VehicleProperty.VC_VENDOR_WARNING_DISTANCE_READ;
                                    case 608:
                                        return VehicleProperty.SCENE_VENDOR_KEY_STS_READ;
                                    case 609:
                                        return VehicleProperty.SCENE_VENDOR_ENGINE_STS_READ;
                                    case 610:
                                        return VehicleProperty.SCENE_VENDOR_DRIVER_DOOR_STS_READ;
                                    case 611:
                                        return VehicleProperty.SCENE_VENDOR_PASSENGER_DOOR_STS_READ;
                                    case 612:
                                        return VehicleProperty.SCENE_VENDOR_RHR_DOOR_STS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_LHR_DOOR /* 613 */:
                                        return VehicleProperty.SCENE_VENDOR_LHR_DOOR_STS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_CO_STS /* 614 */:
                                        return VehicleProperty.SCENE_VENDOR_CO_STS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_CO_ERR /* 615 */:
                                        return VehicleProperty.SCENE_VENDOR_CO_ERR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_POWER_LIMIT /* 619 */:
                                        return VehicleProperty.SCENE_VENDOR_POWER_LIMIT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_LIGHT_SHOW /* 620 */:
                                        return VehicleProperty.SCENE_VENDOR_LIGHT_SHOW_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_ENGINE_STS /* 621 */:
                                        return VehicleProperty.SCENE_VENDOR_EMS_ENGINE_STS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_PM25_STS /* 622 */:
                                        return VehicleProperty.SCENE_VENDOR_PM25_STS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_WIRELESS_CHARGING /* 624 */:
                                        return VehicleProperty.WIRELESS_VENDOR_CHARGING_STS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_WIRELESS_FAST_CHARGE /* 625 */:
                                        return VehicleProperty.WIRELESS_VENDOR_ENTER_SFCHARGE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_AVM_360 /* 626 */:
                                        return 557844776;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_AVM_DISPLAY /* 627 */:
                                        return 557844770;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PARK_TAIL_LIGHT /* 629 */:
                                        return VehicleProperty.CLUSTER_ILLUMINATION_T1J_PARK_TAIL_LIGHT_STS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_ALARM_MODE /* 630 */:
                                        return VehicleProperty.ALARM_MODE_T1J;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_AIR_BAG /* 631 */:
                                        return VehicleProperty.CLUSTER_VENDOR_CRASH_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LEFT_TURN_LIGHT /* 632 */:
                                        return VehicleProperty.CLUSTER_LH_TURN_SOUND;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_RIGHT_TURN_LIGHT /* 633 */:
                                        return VehicleProperty.CLUSTER_RH_TURN_SOUND;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_RIGHT_HAZARD_LIGHT /* 634 */:
                                        return VehicleProperty.CLUSTER_VENDOR_HAZARD_LIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LATERA_ACCALELERATION /* 635 */:
                                        return VehicleProperty.YAS_VENDOR_LATERA_ACCALELERATION_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LONGITUDINAL_ACCALELERATION /* 636 */:
                                        return VehicleProperty.LONGITUDINALACCELERATION;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_POWER_MODE /* 637 */:
                                        return VehicleProperty.CLUSTER_CGW_HCU_1_G_POWER_MODE_FED;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_REGEBERATE_LEVEL /* 638 */:
                                        return VehicleProperty.CLUSTER_ENGINE_RECOVERY_LEVEL;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_HV /* 639 */:
                                        return VehicleProperty.VC_VENDOR_PHEV_HV_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_PTREADY /* 640 */:
                                        return VehicleProperty.CLUSTER_HCU_PT_READY;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_POWER_DISTANCE /* 641 */:
                                        return VehicleProperty.CLUSTER_BATT_LOW_ALARM;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVER_LIGHT /* 642 */:
                                        return VehicleProperty.CLUSTER_CEM_2_DRL_STS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LH_TURN_LIGHT /* 643 */:
                                        return VehicleProperty.SCENE_VENDOR_LH_TURN_LIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_RH_TURN_LIGHT /* 644 */:
                                        return VehicleProperty.SCENE_VENDOR_RH_TURN_LIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LOW_BEAM /* 645 */:
                                        return VehicleProperty.SCENE_VENDOR_LOW_BEAM_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HIGH_BEAM /* 646 */:
                                        return VehicleProperty.SCENE_VENDOR_HIGH_BEAM_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_BRAKE /* 647 */:
                                        return VehicleProperty.CLUSTER_AVM_BREAK_LIGHT_STS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME_FR /* 648 */:
                                        return VehicleProperty.VC_VENDOR_WELCOME_PASSENGER_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_AEB_DEC /* 649 */:
                                        return VehicleProperty.CLUSTER_VENDOR_AEB_DEC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_KEY_STS /* 650 */:
                                        return VehicleProperty.CLUSTER_POWERSTATE_T1J_KEYSTS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_SOC_MANAGE /* 651 */:
                                        return VehicleProperty.CLUSTER_HCU_SOC_MANAGE_FED;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_STEERING_ANGLE /* 653 */:
                                        return VehicleProperty.CLUSTER_AVM_STEER_ANGLE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AEB_T1P /* 657 */:
                                        return VehicleProperty.VC_EXT_VENDOR_AEB_T1P_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCW_OPTION_T1P /* 658 */:
                                        return VehicleProperty.VC_EXT_VENDOR_FCW_OPTION_T1P_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCW_T1P /* 659 */:
                                        return VehicleProperty.VC_EXT_VENDOR_FCW_ON_T1P_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_SLA_T1P /* 660 */:
                                        return VehicleProperty.CLUSTER_SLA_ONOFF_STS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDW_T1P /* 661 */:
                                        return VehicleProperty.CLUSTER_LDW_LKA_LANE_ASSITFEE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDW_SEN_T1P /* 662 */:
                                        return VehicleProperty.VC_EXT_VENDOR_LDW_LKA_SEN_T1P_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TJA_ICA_T1P /* 663 */:
                                        return VehicleProperty.VC_EXT_VENDOR_TJA_T1P_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DISTANCE_WARN_T1P /* 664 */:
                                        return VehicleProperty.VC_EXT_VENDOR_DISTANCE_WARNING_T1P_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_LF /* 665 */:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_LF;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_RF /* 666 */:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_RF;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_LR /* 667 */:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_LR;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_RR /* 668 */:
                                        return VehicleProperty.CLUSTER_CEM_5_TIRE_PRESSURE_WARNING_RR;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_CURVE_DEC /* 669 */:
                                        return VehicleProperty.VC_EXT_VENDOR_CURVE_DEC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_MODE_PHEV /* 671 */:
                                        return VehicleProperty.CLUSTER_EPS_FAIL_OIL_PHEV;
                                    case 701:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDW_ZDC_READ;
                                    case 702:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDP_ZDC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_IES_ZDC /* 703 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_IES_ZDC_READ;
                                    case 704:
                                        return VehicleProperty.VC_VENDOR_ADAS_RCTB_ZDC_READ;
                                    case 705:
                                        return VehicleProperty.VC_VENDOR_ADAS_RCW_ZDC_READ;
                                    case 706:
                                        return VehicleProperty.VC_VENDOR_ADAS_DCLC_ZDC_READ;
                                    case 707:
                                        return VehicleProperty.VC_VENDOR_ADAS_IF_EXIT_ZDC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DAI_ZDC /* 708 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_DAI_ZDC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_ELK_ZDC /* 709 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_ELK_ZDC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_PAS_ZDC /* 710 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_PAS_ZDC_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_REAR_FOG_LIGHT /* 712 */:
                                        return VehicleProperty.CLUSTER_CEM_2_REAR_FOG_LIGHT_STS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FRONT_FOG_LIGHT /* 713 */:
                                        return VehicleProperty.CLUSTER_CEM_2_FRONT_FOG_LIGHT_STS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_FLIP_T1K /* 714 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_FLIP_T1K_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_STATIC_COLOR /* 715 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_STATIC_LIGHT_COLOR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_CST_SEN /* 716 */:
                                        return VehicleProperty.VC_VENDOR_CST_SEN_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_IPB /* 717 */:
                                        return VehicleProperty.VC_VENDOR_IPB_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_EXT_VENDOR_HOME_CONNECT /* 718 */:
                                        return VehicleProperty.VC_EXT_VENDOR_HOME_CONNECT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_EXT_VENDOR_APA_FAIL /* 719 */:
                                        return VehicleProperty.VC_EXT_VENDOR_APA_FAIL_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_MFS_SHAKE_7 /* 720 */:
                                        return VehicleProperty.VC_VENDOR_MFS_SHAKE_7_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_AEB_MODE /* 721 */:
                                        return 557844505;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_ACC_MODE /* 722 */:
                                        return VehicleProperty.CLUSTER_FCM_FRM_6_ACC_MODE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LDP_MODE /* 723 */:
                                        return VehicleProperty.CLUSTER_LDP_SYS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_TJA_MODE /* 724 */:
                                        return VehicleProperty.CLUSTER_TJA_ICA_MODE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_BSD_MODE /* 725 */:
                                        return VehicleProperty.CLUSTER_BSD_1_SYSTEM_STATE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SOUND_EFFECT_MID /* 726 */:
                                        return VehicleProperty.STAT_AMP_SOUND_EFFECT_BASSMID;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SOUND_EFFECT_MIDTREBLE /* 727 */:
                                        return VehicleProperty.STAT_AMP_SOUND_EFFECT_MIDTREBLE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVE_ATMOSPHERE_LIGHT /* 728 */:
                                        return VehicleProperty.VC_VENDOR_DRIVE_ATMOSPHERE_LIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PM25_ATMOSPHERE_LIGHT /* 729 */:
                                        return VehicleProperty.VC_VENDOR_PM25_ATMOSPHERE_LIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_WIPER_MODE /* 731 */:
                                        return VehicleProperty.VC_VENDOR_WIPER_MODE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PDOOR_BUTTON /* 732 */:
                                        return VehicleProperty.VC_VENDOR_PDOOR_BUTTON_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LHRDOOR_BUTTON /* 733 */:
                                        return VehicleProperty.VC_VENDOR_LHRDOOR_BUTTON_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_RHRDOOR_BUTTON /* 734 */:
                                        return VehicleProperty.VC_VENDOR_RHRDOOR_BUTTON_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DOOR_KNOB_TIME /* 735 */:
                                        return VehicleProperty.VC_VENDOR_DOOR_KNOB_TIME_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DOOR_KNOB_MODE /* 736 */:
                                        return VehicleProperty.VC_VENDOR_DOOR_KNOB_MODE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD /* 737 */:
                                        return VehicleProperty.VC_VENDOR_HUD_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_MODE /* 738 */:
                                        return VehicleProperty.VC_VENDOR_HUD_MODE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_HEIGHT /* 739 */:
                                        return VehicleProperty.VC_VENDOR_HUD_HEIGHT_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_BRIGHTNESS_MODE /* 740 */:
                                        return VehicleProperty.VC_VENDOR_HUD_BRIGHTNESS_MODE_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_BRIGHTNESS /* 741 */:
                                        return VehicleProperty.VC_VENDOR_HUD_BRIGHTNESS_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_BLUETOOTH_DISPLAY /* 742 */:
                                        return VehicleProperty.VC_VENDOR_BLUETOOTH_DISPLAY_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DAS_DISPLAY /* 743 */:
                                        return VehicleProperty.VC_VENDOR_DAS_DISPLAY_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_NAV_DISPLAY /* 744 */:
                                        return VehicleProperty.VC_VENDOR_NAV_DISPLAY_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA0_T1L /* 745 */:
                                        return VehicleProperty.DVR_IHU_DATA0_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA1_T1L /* 746 */:
                                        return VehicleProperty.DVR_IHU_DATA1_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA2_T1L /* 747 */:
                                        return VehicleProperty.DVR_IHU_DATA2_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA3_T1L /* 748 */:
                                        return VehicleProperty.DVR_IHU_DATA3_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA4_T1L /* 749 */:
                                        return VehicleProperty.DVR_IHU_DATA4_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA5_T1L /* 750 */:
                                        return VehicleProperty.DVR_IHU_DATA5_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA6_T1L /* 751 */:
                                        return VehicleProperty.DVR_IHU_DATA6_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_DATA7_T1L /* 752 */:
                                        return VehicleProperty.DVR_IHU_DATA7_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DVR_IHU_SYSTEMSTS_T1L /* 753 */:
                                        return VehicleProperty.DVR_IHU_SYSTEMSTS_T1L;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HAZARD /* 754 */:
                                        return VehicleProperty.VC_VENDOR_HAZARD_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCM_10_SLA_ON_OFF /* 755 */:
                                        return VehicleProperty.CLUSTER_FCM_10_SLA_ONOFF_STS;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_FR /* 756 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_FR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_BACK_FR /* 757 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_BACK_FR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_LEG_FR /* 758 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_LEG_FR_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LOW_BEAM_T1K /* 759 */:
                                        return 557844740;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVER_UNLOCK /* 760 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_UNLOCK_READ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_ESP_TANKS_TAB /* 761 */:
                                        return VehicleProperty.CLUSTER_AVM_ESP_TANKS_TAB;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_AEB_MODE_CR2407 /* 762 */:
                                        return VehicleProperty.CLUSTER_FRM_3_AEBMODE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_ACC_MODE_CR2407 /* 763 */:
                                        return VehicleProperty.CLUSTER_FRM_3_ACCMODE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_LDP_MODE_CR2407 /* 764 */:
                                        return VehicleProperty.CLUSTER_LKA_STATUS;
                                    case 768:
                                        return VehicleProperty.VC_VENDOR_WINDOW_INHIBIT_READ;
                                    default:
                                        switch (i) {
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_HEAT_AND_WIND /* 138 */:
                                                return 557843988;
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_HEAT_AND_WIND /* 139 */:
                                                return 557843990;
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_CUSTOM /* 140 */:
                                                return 557844020;
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_AUTO_VENTILATION /* 141 */:
                                                return 557844004;
                                            default:
                                                switch (i) {
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_IN_PM25_LEVEL /* 201 */:
                                                        return 557844024;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_OUT_PM25_LEVEL /* 202 */:
                                                        return 557844025;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_TEMPERATURE_FLOAT /* 203 */:
                                                        return 559941158;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_TEMPERATURE_FLOAT /* 204 */:
                                                        return 559941160;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FRCE_SURPLUS1 /* 205 */:
                                                        return 557844017;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FRCE_SURPLUS2 /* 206 */:
                                                        return 557844022;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FRCE_SURPLUS3 /* 207 */:
                                                        return 557844023;
                                                    default:
                                                        switch (i) {
                                                            case 301:
                                                                return 557844037;
                                                            case 302:
                                                                return 557844039;
                                                            case 303:
                                                                return 557844041;
                                                            case 304:
                                                                return 557844043;
                                                            case 305:
                                                                return 557844045;
                                                            case 306:
                                                                return 557844047;
                                                            case 307:
                                                                return 557844049;
                                                            case 308:
                                                                return 557844051;
                                                            case 309:
                                                                return 557844053;
                                                            case 310:
                                                                return 557844055;
                                                            case 311:
                                                                return 557844057;
                                                            default:
                                                                switch (i) {
                                                                    case 501:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_AEB_READ;
                                                                    case 502:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_FCW_SEN_READ;
                                                                    case 503:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_FCW_ON_OFF_READ;
                                                                    case 504:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_IF_EXIT_READ;
                                                                    case 505:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_SLA_ON_OFF_READ;
                                                                    case 506:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_SCF_READ;
                                                                    case 507:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_DAI_READ;
                                                                    case 508:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_IES_READ;
                                                                    case 509:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_TSI_READ;
                                                                    default:
                                                                        switch (i) {
                                                                            case 513:
                                                                                return VehicleProperty.VC_VENDOR_ADAS_LDP_READ;
                                                                            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDP_SEN /* 514 */:
                                                                                return VehicleProperty.VC_VENDOR_ADAS_LDP_SEN_READ;
                                                                            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_ELK /* 515 */:
                                                                                return VehicleProperty.VC_VENDOR_ADAS_ELK_READ;
                                                                            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DWD /* 516 */:
                                                                                return VehicleProperty.VC_VENDOR_ADAS_DWD_READ;
                                                                            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_BSD /* 517 */:
                                                                                return VehicleProperty.VC_VENDOR_ADAS_BSD_READ;
                                                                            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DOW /* 518 */:
                                                                                return VehicleProperty.VC_VENDOR_ADAS_DOW_READ;
                                                                            case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_RCW /* 519 */:
                                                                                return VehicleProperty.VC_VENDOR_ADAS_RCW_READ;
                                                                            default:
                                                                                return -1;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    private int managerToHalPropId_Set(int i) {
        if (i == 164) {
            return 557843995;
        }
        if (i == 165) {
            return 557843997;
        }
        if (i == 203) {
            return 557844007;
        }
        if (i == 204) {
            return 557844009;
        }
        switch (i) {
            case 33:
                return 557844011;
            case 34:
                return 557844013;
            case 35:
                return 557844019;
            default:
                switch (i) {
                    case 38:
                        return 557843979;
                    case 39:
                        return 557843977;
                    case 40:
                        return 557843981;
                    case 41:
                        return 557843983;
                    case 42:
                        return 557843993;
                    default:
                        switch (i) {
                            case 51:
                                return 557844001;
                            case 52:
                                return 557843999;
                            case 53:
                                return 557844003;
                            default:
                                switch (i) {
                                    case 90:
                                        return 557843969;
                                    case 94:
                                        return 557843985;
                                    case 110:
                                        return 557843975;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_BT_PHONE /* 208 */:
                                        return 557844030;
                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ACMAX /* 228 */:
                                        return 557843973;
                                    case 301:
                                        return 557844038;
                                    case 302:
                                        return 557844040;
                                    case 303:
                                        return 557844042;
                                    case 304:
                                        return 557844044;
                                    case 305:
                                        return 557844046;
                                    case 306:
                                        return 557844048;
                                    case 307:
                                        return 557844050;
                                    case 308:
                                        return 557844052;
                                    case 309:
                                        return 557844054;
                                    case 310:
                                        return 557844056;
                                    case 311:
                                        return 557844058;
                                    case 401:
                                        return 557843971;
                                    case 511:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDW_WRITE;
                                    case 513:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDP_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDP_SEN /* 514 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDP_SEN_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_ELK /* 515 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_ELK_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DWD /* 516 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_DWD_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_BSD /* 517 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_BSD_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DOW /* 518 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_DOW_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_RCW /* 519 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_RCW_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ESP /* 522 */:
                                        return VehicleProperty.VC_VENDOR_ESP_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HDC /* 523 */:
                                        return VehicleProperty.VC_VENDOR_HDC_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_AVH /* 524 */:
                                        return VehicleProperty.VC_VENDOR_AVH_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ISS /* 525 */:
                                        return VehicleProperty.VC_VENDOR_ISS_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_HOLD_SWITCH /* 526 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_HOLD_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_FLIP /* 527 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_FLIP_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_HOLD /* 528 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_HOLD_SWITCH_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_LEFT /* 529 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_LEFT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_RIGHT /* 530 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_RIGHT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_DRIVER /* 531 */:
                                        return VehicleProperty.VC_VENDOR_MIRROR_DRIVER_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FL_WINDOW /* 532 */:
                                        return VehicleProperty.VC_VENDOR_FL_WINDOW_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FR_WINDOW /* 533 */:
                                        return VehicleProperty.VC_VENDOR_FR_WINDOW_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_RL_WINDOW /* 534 */:
                                        return VehicleProperty.VC_VENDOR_RL_WINDOW_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_RR_WINDOW /* 535 */:
                                        return VehicleProperty.VC_VENDOR_RR_WINDOW_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SKYLIGHT_PERCENTAGE /* 537 */:
                                        return VehicleProperty.VC_VENDOR_SKYLIGHT_PERCENTAGE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_SUNSHADE /* 538 */:
                                        return VehicleProperty.VC_VENDOR_SUNSHADE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT /* 539 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT_BRIGHTNESS /* 540 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_BRIGHTNESS_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ATMOSPHERE_LIGHT_COLOR /* 541 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_LIGHT_COLOR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_STATIC_MODE /* 542 */:
                                        return VehicleProperty.VC_VENDOR_STATIC_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MUSIC /* 543 */:
                                        return VehicleProperty.VC_VENDOR_MUSIC_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DMS /* 544 */:
                                        return VehicleProperty.VC_VENDOR_DMS_WRITE;
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
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AUTOLOCK /* 552 */:
                                        return VehicleProperty.VC_VENDOR_AUTOLOCK_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AUTOUNLOCK /* 553 */:
                                        return VehicleProperty.VC_VENDOR_AUTOUNLOCK_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_REMOTELOCK /* 554 */:
                                        return VehicleProperty.VC_VENDOR_REMOTELOCK_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME /* 555 */:
                                        return VehicleProperty.VC_VENDOR_WELCOME_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME_FL /* 556 */:
                                        return VehicleProperty.VC_VENDOR_WELCOME_FL_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_REAR_WIPER /* 557 */:
                                        return VehicleProperty.VC_VENDOR_REAR_WIPER_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_PAS /* 558 */:
                                        return VehicleProperty.VC_VENDOR_PAS_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_COOL /* 559 */:
                                        return VehicleProperty.VC_VENDOR_COOL_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_CHILD_LOCK /* 560 */:
                                        return VehicleProperty.VC_VENDOR_CHILD_LOCK_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEAT_FR /* 561 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEAT_FR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEAT_BACK_FR /* 562 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEAT_BACK_FR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEATF_UD /* 563 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEATF_UD_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_SEATR_UD /* 564 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_SEATR_UD_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_LUMBART_FR /* 565 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_LUMBART_FR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_DRIVER_LUMBART_UD /* 566 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_LUMBART_UD_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE /* 570 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE_INTENSITY /* 571 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_INTENSITY_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MASSAGE_MODE /* 572 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MASSAGE_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_PASSENGER_MIRROR_LOCATION /* 573 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_MIRROR_LOCATION_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MFS_HEAT /* 574 */:
                                        return VehicleProperty.VC_VENDOR_MFS_HEAT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MFS_SHAKE /* 575 */:
                                        return VehicleProperty.VC_VENDOR_MFS_SHAKE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_MODE /* 576 */:
                                        return VehicleProperty.VC_VENDOR_EPS_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_DRIVER_MODE /* 577 */:
                                        return VehicleProperty.VC_VENDOR_EPS_DRIVER_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_LIGHT_HEIGHT /* 578 */:
                                        return VehicleProperty.VC_VENDOR_LIGHT_HEIGHT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FOLLOW_ME_HOME /* 579 */:
                                        return VehicleProperty.VC_VENDOR_FOLLOW_ME_HOME_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_BLINK_NO /* 580 */:
                                        return VehicleProperty.VC_VENDOR_BLINK_NO_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HMA /* 581 */:
                                        return VehicleProperty.VC_VENDOR_HMA_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HMA_ON /* 582 */:
                                        return VehicleProperty.VC_VENDOR_HMA_ON_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_SMART_SCENE /* 616 */:
                                        return VehicleProperty.SCENE_VENDOR_SMART_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_SHOW_MODE /* 617 */:
                                        return VehicleProperty.SCENE_VENDOR_SHOW_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SCENE_RANDOM_SHOW /* 618 */:
                                        return VehicleProperty.SCENE_VENDOR_RANDOM_SHOW_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_APA_KEY /* 628 */:
                                        return VehicleProperty.CLUSTER_APA_ONOFF_REQ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_POWER_MODE /* 637 */:
                                        return VehicleProperty.VC_VENDOR_PHEV_POWER_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_REGEBERATE_LEVEL /* 638 */:
                                        return VehicleProperty.VC_VENDOR_PHEV_REGEBERATE_LEVEL_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_WELCOME_FR /* 648 */:
                                        return VehicleProperty.VC_VENDOR_WELCOME_PASSENGER_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_SOC_MANAGE /* 651 */:
                                        return VehicleProperty.VC_EXT_VENDOR_SOC_MANAGE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DRIVE_MODE /* 652 */:
                                        return VehicleProperty.VC_VENDOR_DRIVE_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FACE_ID /* 654 */:
                                        return VehicleProperty.CLUSTER_IHU_DMS_1_DETECT_USER_ID_RESULT;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DISTRACTION_LEVEL /* 655 */:
                                        return VehicleProperty.VC_EXT_VENDOR_DISTRACTION_LEVEL_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FATUGUE_DRIVE /* 656 */:
                                        return VehicleProperty.VC_EXT_VENDOR_FATIGUE_DRIVE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_AEB_T1P /* 657 */:
                                        return VehicleProperty.VC_EXT_VENDOR_AEB_T1P_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCW_OPTION_T1P /* 658 */:
                                        return VehicleProperty.VC_EXT_VENDOR_FCW_OPTION_T1P_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_FCW_T1P /* 659 */:
                                        return VehicleProperty.VC_EXT_VENDOR_FCW_ON_T1P_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_SLA_T1P /* 660 */:
                                        return VehicleProperty.VC_EXT_VENDOR_SLA_T1P_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDW_T1P /* 661 */:
                                        return VehicleProperty.CLUSTER_ICM_1_LDWLKA_LANE_ASSITTYPE_REQ;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_LDW_SEN_T1P /* 662 */:
                                        return VehicleProperty.VC_EXT_VENDOR_LDW_LKA_SEN_T1P_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TJA_ICA_T1P /* 663 */:
                                        return VehicleProperty.VC_EXT_VENDOR_TJA_T1P_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DISTANCE_WARN_T1P /* 664 */:
                                        return VehicleProperty.VC_EXT_VENDOR_DISTANCE_WARNING_T1P_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_CURVE_DEC /* 669 */:
                                        return VehicleProperty.VC_EXT_VENDOR_CURVE_DEC_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_VOICE_WAKE /* 670 */:
                                        return VehicleProperty.VC_VENDOR_VOICE_WAKE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_EPS_MODE_PHEV /* 671 */:
                                        return VehicleProperty.VC_VENDOR_EPS_MODE_WRITE;
                                    case 701:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDW_WRITE;
                                    case 702:
                                        return VehicleProperty.VC_VENDOR_ADAS_LDP_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_IES_ZDC /* 703 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_IES_WRITE;
                                    case 704:
                                        return VehicleProperty.VC_VENDOR_ADAS_RCTB_ZDC_WRITE;
                                    case 705:
                                        return VehicleProperty.VC_VENDOR_ADAS_RCW_ZDC_WRITE;
                                    case 706:
                                        return VehicleProperty.VC_VENDOR_ADAS_DCLC_ZDC_WRITE;
                                    case 707:
                                        return VehicleProperty.VC_VENDOR_ADAS_IF_EXIT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_DAI_ZDC /* 708 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_DAI_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_ELK_ZDC /* 709 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_ELK_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_PAS_ZDC /* 710 */:
                                        return VehicleProperty.VC_VENDOR_ADAS_PAS_ZDC_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_LIGHT_MODE /* 711 */:
                                        return VehicleProperty.VC_EXT_VENDOR_LIGHT_CONTROL_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_REAR_FOG_LIGHT /* 712 */:
                                        return VehicleProperty.VC_EXT_VENDOR_REAR_FOG_LIGHT_CONTROL_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_FRONT_FOG_LIGHT /* 713 */:
                                        return VehicleProperty.VC_EXT_VENDOR_FRONT_FOG_LIGHT_CONTROL_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_STATIC_COLOR /* 715 */:
                                        return VehicleProperty.VC_VENDOR_ATMOSPHERE_STATIC_LIGHT_COLOR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_CST_SEN /* 716 */:
                                        return VehicleProperty.VC_VENDOR_CST_SEN_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_IPB /* 717 */:
                                        return VehicleProperty.VC_VENDOR_IPB_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SOUND_EFFECT_MID /* 726 */:
                                        return VehicleProperty.SET_AMP_SOUND_EFFECT_BASSMID;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SOUND_EFFECT_MIDTREBLE /* 727 */:
                                        return VehicleProperty.SET_AMP_SOUND_EFFECT_MIDTREBLE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVE_ATMOSPHERE_LIGHT /* 728 */:
                                        return VehicleProperty.VC_VENDOR_DRIVE_ATMOSPHERE_LIGHT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PM25_ATMOSPHERE_LIGHT /* 729 */:
                                        return VehicleProperty.VC_VENDOR_PM25_ATMOSPHERE_LIGHT_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_WIPER_SEN /* 730 */:
                                        return VehicleProperty.VC_VENDOR_WIPER_SEN_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_WIPER_MODE /* 731 */:
                                        return VehicleProperty.VC_VENDOR_WIPER_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DOOR_KNOB_TIME /* 735 */:
                                        return VehicleProperty.VC_VENDOR_DOOR_KNOB_TIME_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DOOR_KNOB_MODE /* 736 */:
                                        return VehicleProperty.VC_VENDOR_DOOR_KNOB_MODE_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_HAZARD /* 754 */:
                                        return VehicleProperty.VC_VENDOR_HAZARD_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_FR /* 756 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_FR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_BACK_FR /* 757 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_BACK_FR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_PASSENGER_SEAT_LEG_FR /* 758 */:
                                        return VehicleProperty.VC_VENDOR_PASSENGER_SEAT_LEG_FR_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_DRIVER_UNLOCK /* 760 */:
                                        return VehicleProperty.VC_VENDOR_DRIVER_UNLOCK_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_WELCOME_SOUND /* 766 */:
                                        return VehicleProperty.VC_VENDOR_WELCOME_SOUND_WRITE;
                                    case ALVehicleControlProperty.VEHICLE_PROPERTY_SOUND_OPTION /* 767 */:
                                        return VehicleProperty.VC_VENDOR_SOUND_OPTION_WRITE;
                                    default:
                                        switch (i) {
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_HEAT_AND_WIND /* 138 */:
                                                return 557843989;
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_HEAT_AND_WIND /* 139 */:
                                                return 557843991;
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_CUSTOM /* 140 */:
                                                return 557844021;
                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_AUTO_VENTILATION /* 141 */:
                                                return 557844005;
                                            default:
                                                switch (i) {
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION_PHEV /* 214 */:
                                                        return 557843995;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_ULTRAVIOLET_STERILIZATION_INTENSITY_PHEV /* 215 */:
                                                        return 557843997;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_COOL_PHEV /* 216 */:
                                                        return 557844064;
                                                    case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_PARK_AIR /* 217 */:
                                                        return 557844068;
                                                    default:
                                                        switch (i) {
                                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_AC_MAX_STATUS_PHEV /* 221 */:
                                                                return 557843973;
                                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_ELEC_TEMP /* 222 */:
                                                                return 557844074;
                                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FL_HEAT /* 223 */:
                                                                return 557844076;
                                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_FR_HEAT /* 224 */:
                                                                return 557844078;
                                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_WIND_SCREEN_HEAT /* 225 */:
                                                                return 557843848;
                                                            case ALHvacVehicleProperty.VEHICLE_PROPERTY_HVAC_DEFROSTER_T1K /* 226 */:
                                                                return 557843983;
                                                            default:
                                                                switch (i) {
                                                                    case 501:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_AEB_WRITE;
                                                                    case 502:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_FCW_SEN_WRITE;
                                                                    case 503:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_FCW_ON_OFF_WRITE;
                                                                    case 504:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_IF_EXIT_WRITE;
                                                                    case 505:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_SLA_ON_OFF_WRITE;
                                                                    case 506:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_SCF_WRITE;
                                                                    case 507:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_DAI_WRITE;
                                                                    case 508:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_IES_WRITE;
                                                                    case 509:
                                                                        return VehicleProperty.VC_VENDOR_ADAS_TSI_WRITE;
                                                                    default:
                                                                        return -1;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    private static final class CarHandler extends Handler {
        private static final int MSG_AVM_EVENT = 2;
        private static final int MSG_CAR_ENGINE_SPEED_EVENT = 8;
        private static final int MSG_CAR_SPEED_EVENT = 4;
        private static final int MSG_CAR_STEER_EVENT = 5;
        private static final int MSG_CAR_TYRE_EVENT = 6;
        private static final int MSG_CAR_WIND_EVENT = 7;
        private static final int MSG_EXT_EVENT = 3;
        private static final int MSG_HVAC_EVENT = 0;
        private static final int MSG_VEHICLECONTROL_EVENT = 1;
        private static final String TAG = "CarHandler";
        private final WeakReference<ALCarManager> mCar;

        private CarHandler(Looper looper, ALCarManager aLCarManager) {
            super(looper);
            this.mCar = new WeakReference<>(aLCarManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ALCarManager aLCarManager = this.mCar.get();
            if (aLCarManager == null) {
            }
            switch (message.what) {
                case 0:
                    aLCarManager.handleCarHvacPropertyEvent((ALCarPropertyEvent) message.obj);
                    break;
                case 1:
                    aLCarManager.handleCarVehicleControlPropertyEvent((ALCarPropertyEvent) message.obj);
                    aLCarManager.handleAllTypesVehicleControlPropertyEvent((ALCarPropertyEvent) message.obj);
                    break;
                case 2:
                    aLCarManager.handleAVMPropertyEvent((ALCarPropertyEvent) message.obj);
                    break;
                case 3:
                    aLCarManager.handleExtPropertyEvent((ALCarPropertyEvent) message.obj);
                    break;
                case 4:
                    Bundle data = message.getData();
                    if (data != null) {
                        aLCarManager.handleCarSpeed(data.getFloat("speed"), message.arg1);
                        break;
                    }
                    break;
                case 5:
                    Bundle data2 = message.getData();
                    if (data2 != null) {
                        aLCarManager.handleCarSteer(data2.getFloat("steer"));
                        break;
                    }
                    break;
                case 6:
                    aLCarManager.handleCarTyreData(message.arg1, message.arg2);
                    break;
                case 7:
                    aLCarManager.handleWindPropertyEvent((ALCarPropertyEvent) message.obj);
                    break;
                case 8:
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        aLCarManager.handleCarEngineSpeed(data3.getFloat("enginespeed"), message.arg1);
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCarHvacPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        if (notifyCarHvacPM25PropertyEvent(aLCarPropertyEvent.getId(), ((Integer) aLCarPropertyEvent.getValue()).intValue()) || notifyCarHvacFragPropertyEvent(aLCarPropertyEvent.getId(), ((Integer) aLCarPropertyEvent.getValue()).intValue())) {
            return;
        }
        int halToManagerPropId = halToManagerPropId(aLCarPropertyEvent.getId());
        if (halToManagerPropId == -1) {
            Log.i(TAG, "propId == MANAGER_PROPID_INVALID " + aLCarPropertyEvent.getId());
            return;
        }
        int intValue = ((Integer) aLCarPropertyEvent.getValue()).intValue();
        if (halToManagerPropId >= SHORT_MAX_VALUE || halToManagerPropId <= SHORT_MIN_VALUE) {
            Log.e(TAG, "handleCarHvacPropertyEvent propId is invalid");
        } else {
            notifyCarHvacAndVehicleControlPropertyEvent(BYTE_HVAC_AND_VEHICLECONTROL_MODULAR, (byte) -1, (short) halToManagerPropId, intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCarVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        int halToManagerPropId = halToManagerPropId(aLCarPropertyEvent.getId());
        if ((aLCarPropertyEvent.getId() & 6291456) == 6291456) {
            Log.i(TAG, "handleCarVehicleControlPropertyEvent float return " + halToManagerPropId + " halId " + aLCarPropertyEvent.getId());
            return;
        }
        if (halToManagerPropId == -1) {
            Log.i(TAG, "propId == MANAGER_PROPID_INVALID " + aLCarPropertyEvent.getId());
            return;
        }
        int intValue = ((Integer) aLCarPropertyEvent.getValue()).intValue();
        if (halToManagerPropId >= SHORT_MAX_VALUE || halToManagerPropId <= SHORT_MIN_VALUE) {
            return;
        }
        notifyCarHvacAndVehicleControlPropertyEvent(BYTE_HVAC_AND_VEHICLECONTROL_MODULAR, (byte) -1, (short) halToManagerPropId, intValue);
    }

    private boolean notifyCarHvacPM25PropertyEvent(int i, int i2) {
        Log.d(TAG, "notifyCarHvacPM25PropertyEvent start propId " + i + " value " + i2);
        ALCanPM25 aLCanPM25 = this.mALCanPM25;
        if (aLCanPM25 == null) {
            Log.e(TAG, "mALCanPM25 is null");
            return false;
        }
        switch (i) {
            case 557843986:
                aLCanPM25.setPM25Indensity(i2);
                this.mALCanPM25.setPM25Outdensity(getIntProperty(557843987, 0));
                notifyIALAirPurgeListenerPM25();
                break;
            case 557843987:
                aLCanPM25.setPM25Indensity(getIntProperty(557843986, 0));
                this.mALCanPM25.setPM25Outdensity(i2);
                notifyIALAirPurgeListenerPM25();
                break;
        }
        return false;
    }

    private void notifyIALAirPurgeListenerPM25() {
        Log.i(TAG, "notifyIALAirPurgeListenerPM25 start");
        synchronized (this.mLockForListener) {
            IALAirPurgeListener iALAirPurgeListener = this.mIALAirPurgeListener;
            if (iALAirPurgeListener != null) {
                iALAirPurgeListener.onPMChanged(this.mALCanPM25);
            }
        }
    }

    private boolean notifyCarHvacFragPropertyEvent(int i, int i2) {
        Log.d(TAG, "notifyCarHvacFragPropertyEvent start propId " + i + " value " + i2);
        ALCanVehicleFrag aLCanVehicleFrag = this.mALCanVehicleFrag;
        if (aLCanVehicleFrag == null) {
            Log.e(TAG, "mALCanVehicleFrag is null");
            return false;
        }
        switch (i) {
            case 557844014:
                aLCanVehicleFrag.setFRAG_FraganceBoxALoad(i2);
                notifyIALAirPurgeListener();
                break;
            case 557844015:
                aLCanVehicleFrag.setFRAG_FraganceBoxBLoad(i2);
                notifyIALAirPurgeListener();
                break;
            case 557844016:
                aLCanVehicleFrag.setFRAG_FraganceBoxCLoad(i2);
                notifyIALAirPurgeListener();
                break;
            case 557844017:
                aLCanVehicleFrag.setFRAG_FraganceTaste1RemanentRatio(i2);
                this.mALCanVehicleFrag.setFRAG_FraganceTaste2RemanentRatio(15);
                this.mALCanVehicleFrag.setFRAG_FraganceTaste3RemanentRatio(15);
                notifyIALAirPurgeListener();
                break;
            case 557844018:
            case 557844019:
            case 557844020:
            case 557844021:
            default:
                Log.d(TAG, "notifyCarHvacFragPropertyEvent default ");
                break;
            case 557844022:
                aLCanVehicleFrag.setFRAG_FraganceTaste1RemanentRatio(15);
                this.mALCanVehicleFrag.setFRAG_FraganceTaste2RemanentRatio(i2);
                this.mALCanVehicleFrag.setFRAG_FraganceTaste3RemanentRatio(15);
                notifyIALAirPurgeListener();
                break;
            case 557844023:
                aLCanVehicleFrag.setFRAG_FraganceTaste1RemanentRatio(15);
                this.mALCanVehicleFrag.setFRAG_FraganceTaste2RemanentRatio(15);
                this.mALCanVehicleFrag.setFRAG_FraganceTaste3RemanentRatio(i2);
                notifyIALAirPurgeListener();
                break;
        }
        return false;
    }

    private void notifyIALAirPurgeListener() {
        Log.i(TAG, "notifyIALAirPurgeListener start");
        synchronized (this.mLockForListener) {
            IALAirPurgeListener iALAirPurgeListener = this.mIALAirPurgeListener;
            if (iALAirPurgeListener != null) {
                iALAirPurgeListener.onVehicleLFrag(this.mALCanVehicleFrag);
            }
        }
    }

    private void notifyCarHvacAndVehicleControlPropertyEvent(byte b, byte b2, short s, int i) {
        synchronized (this.mLockForListener) {
            IALCmdListener iALCmdListener = this.mIALCmdListenerMap.get(Integer.valueOf(b));
            if (iALCmdListener != null) {
                Log.i(TAG, "notify onCmdChanged modular is " + ((int) b) + " rev is " + ((int) b2) + " item is " + ((int) s) + " value is " + i);
                iALCmdListener.onCmdChanged(b, b2, s, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAVMPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        int halToManagerAVMPropId = CarUtils.halToManagerAVMPropId(aLCarPropertyEvent.getId());
        if (halToManagerAVMPropId == -1) {
            Log.i(TAG, "propId == MANAGER_PROPID_INVALID " + aLCarPropertyEvent.getId());
        } else if ((aLCarPropertyEvent.getId() & 6291456) == 6291456) {
            notifyAVMPropertyEvent(new ALCarPropertyEvent(halToManagerAVMPropId, Float.valueOf(((Float) aLCarPropertyEvent.getValue()).floatValue())));
        } else {
            notifyAVMPropertyEvent(new ALCarPropertyEvent(halToManagerAVMPropId, Integer.valueOf(((Integer) aLCarPropertyEvent.getValue()).intValue())));
        }
    }

    private void notifyAVMPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        synchronized (this.mLockForListener) {
            IALCarPropListener iALCarPropListener = this.mIALCarPropListener;
            if (iALCarPropListener != null) {
                Log.i(TAG, "notifyAVMPropertyEvent onCmdChanged event.getId() is " + aLCarPropertyEvent.getId());
                iALCarPropListener.onALCarPropChanged(aLCarPropertyEvent);
            }
        }
    }

    private static HandlerThread getHandlerThread(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return handlerThread;
    }

    @Deprecated
    public ALCarManager(Context context) {
        super(context);
        this.flagRegisterHvacPropertyListener = false;
        this.flagRegisterVehicleControlPropertyListener = false;
        HandlerThread handlerThread = getHandlerThread("ALCarManager");
        this.mHandlerThread = handlerThread;
        this.mCarHandler = new CarHandler(handlerThread.getLooper(), this);
        this.mIALCmdListenerMap = new ConcurrentHashMap();
        this.mLockForCarService = new Object();
        this.mLockForListener = new Object();
        Runnable runnable = new Runnable() { // from class: com.autolink.adaptermanager.car.ALCarManager.1
            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALCarManager.TAG, "mInitDataTask start");
                ALCarManager.this.mALCanVehicleFrag = new ALCanVehicleFrag();
                ALCarManager.this.mALCanPM25 = new ALCanPM25();
                ALCarManager.this.mALCanVehicleFrag.setFRAG_FraganceBoxALoad(ALCarManager.this.getIntProperty(557844014, 0));
                ALCarManager.this.mALCanVehicleFrag.setFRAG_FraganceBoxBLoad(ALCarManager.this.getIntProperty(557844015, 0));
                ALCarManager.this.mALCanVehicleFrag.setFRAG_FraganceBoxCLoad(ALCarManager.this.getIntProperty(557844016, 0));
                ALCarManager.this.mALCanPM25.setPM25Indensity(ALCarManager.this.getIntProperty(557843986, 0));
                ALCarManager.this.mALCanPM25.setPM25Outdensity(ALCarManager.this.getIntProperty(557843987, 0));
            }
        };
        this.mInitDataTask = runnable;
        Runnable runnable2 = new Runnable() { // from class: com.autolink.adaptermanager.car.ALCarManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (ALCarManager.mCountForEngineSpeed > 0) {
                    Log.i(ALCarManager.TAG, "mTaskToReduceLog EngineSpeed = " + ALCarManager.mRecordForEngineSpeed + " count = " + ALCarManager.mCountForEngineSpeed + " isValid " + ALCarManager.mRecordForIsEngineSpeedValid);
                    int unused = ALCarManager.mCountForEngineSpeed = 0;
                }
                if (ALCarManager.mCountForCarSteer > 0) {
                    Log.i(ALCarManager.TAG, " CarSteer = " + ALCarManager.mRecordForCarSteer + " count = " + ALCarManager.mCountForCarSteer);
                    int unused2 = ALCarManager.mCountForCarSteer = 0;
                }
                if (ALCarManager.mCountForCarSpeed > 0) {
                    Log.i(ALCarManager.TAG, " CarSpeed = " + ALCarManager.mRecordForCarSpeed + " count = " + ALCarManager.mCountForCarSpeed + " isValid " + ALCarManager.mRecordForIsCarSpeedValid);
                    int unused3 = ALCarManager.mCountForCarSpeed = 0;
                }
                ALCarManager.this.mMainThreadHandler.postDelayed(this, 1000L);
            }
        };
        this.mTaskToReduceLog = runnable2;
        this.mIALCarEngineSpeedListener = new IALCarEngineSpeedListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.3
            @Override // com.autolink.adapterinterface.car.IALCarEngineSpeedListener
            public void notifyEngineSpeedChange(float f, int i) throws RemoteException {
                Message obtain = Message.obtain(ALCarManager.this.mCarHandler, 8, i, 0);
                Bundle bundle = new Bundle();
                bundle.putFloat("enginespeed", f);
                obtain.setData(bundle);
                ALCarManager.this.mCarHandler.sendMessage(obtain);
            }
        };
        this.mIALCarWindListener = new IALCarWindListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.4
            @Override // com.autolink.adapterinterface.car.IALCarWindListener
            public void notifyCarWindEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 7, aLCarPropertyEvent));
            }
        };
        this.mIALCarTyreListener = new IALCarTyreListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.5
            @Override // com.autolink.adapterinterface.car.IALCarTyreListener
            public void notifyTyreFloatChange(int i, float f) {
            }

            @Override // com.autolink.adapterinterface.car.IALCarTyreListener
            public void notifyTyreChange(int i, int i2) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 6, i, i2));
            }
        };
        this.mIALCarSteerListener = new IALCarSteerListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.6
            @Override // com.autolink.adapterinterface.car.IALCarSteerListener
            public void notifySteerChange(float f) throws RemoteException {
                Message obtain = Message.obtain(ALCarManager.this.mCarHandler, 5, 0, 0);
                Bundle bundle = new Bundle();
                bundle.putFloat("steer", f);
                obtain.setData(bundle);
                ALCarManager.this.mCarHandler.sendMessage(obtain);
            }
        };
        this.mIALCarSpeedListener = new IALCarSpeedListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.7
            @Override // com.autolink.adapterinterface.car.IALCarSpeedListener
            public void notifySpeedChange(float f, int i) throws RemoteException {
                Message obtain = Message.obtain(ALCarManager.this.mCarHandler, 4, i, 0);
                Bundle bundle = new Bundle();
                bundle.putFloat("speed", f);
                obtain.setData(bundle);
                ALCarManager.this.mCarHandler.sendMessage(obtain);
            }
        };
        this.mIALCarExtPropertyListener = new IALCarExtPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.8
            @Override // com.autolink.adapterinterface.car.IALCarExtPropertyListener
            public void notifyCarExtPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 3, aLCarPropertyEvent));
            }
        };
        this.mIALCarAVMPropertyListener = new IALCarAVMPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.9
            @Override // com.autolink.adapterinterface.car.IALCarAVMPropertyListener
            public void notifyCarAVMPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 2, aLCarPropertyEvent));
            }
        };
        this.mIALCarHvacPropertyListener = new IALCarHvacPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.10
            @Override // com.autolink.adapterinterface.car.IALCarHvacPropertyListener
            public void notifyCarHvacPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 0, aLCarPropertyEvent));
            }
        };
        this.mIALCarVehicleControlPropertyListener = new IALCarVehicleControlPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.11
            @Override // com.autolink.adapterinterface.car.IALCarVehicleControlPropertyListener
            public void notifyCarVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 1, aLCarPropertyEvent));
            }
        };
        Looper.getMainLooper();
        this.mMainThreadHandler.post(runnable);
        this.mMainThreadHandler.post(runnable2);
        currentProject = getCurrentProject();
        modifyTAG(context);
        Log.i(TAG, "ALCarManager construct");
    }

    public ALCarManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.flagRegisterHvacPropertyListener = false;
        this.flagRegisterVehicleControlPropertyListener = false;
        HandlerThread handlerThread = getHandlerThread("ALCarManager");
        this.mHandlerThread = handlerThread;
        this.mCarHandler = new CarHandler(handlerThread.getLooper(), this);
        this.mIALCmdListenerMap = new ConcurrentHashMap();
        this.mLockForCarService = new Object();
        this.mLockForListener = new Object();
        Runnable runnable = new Runnable() { // from class: com.autolink.adaptermanager.car.ALCarManager.1
            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALCarManager.TAG, "mInitDataTask start");
                ALCarManager.this.mALCanVehicleFrag = new ALCanVehicleFrag();
                ALCarManager.this.mALCanPM25 = new ALCanPM25();
                ALCarManager.this.mALCanVehicleFrag.setFRAG_FraganceBoxALoad(ALCarManager.this.getIntProperty(557844014, 0));
                ALCarManager.this.mALCanVehicleFrag.setFRAG_FraganceBoxBLoad(ALCarManager.this.getIntProperty(557844015, 0));
                ALCarManager.this.mALCanVehicleFrag.setFRAG_FraganceBoxCLoad(ALCarManager.this.getIntProperty(557844016, 0));
                ALCarManager.this.mALCanPM25.setPM25Indensity(ALCarManager.this.getIntProperty(557843986, 0));
                ALCarManager.this.mALCanPM25.setPM25Outdensity(ALCarManager.this.getIntProperty(557843987, 0));
            }
        };
        this.mInitDataTask = runnable;
        Runnable runnable2 = new Runnable() { // from class: com.autolink.adaptermanager.car.ALCarManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (ALCarManager.mCountForEngineSpeed > 0) {
                    Log.i(ALCarManager.TAG, "mTaskToReduceLog EngineSpeed = " + ALCarManager.mRecordForEngineSpeed + " count = " + ALCarManager.mCountForEngineSpeed + " isValid " + ALCarManager.mRecordForIsEngineSpeedValid);
                    int unused = ALCarManager.mCountForEngineSpeed = 0;
                }
                if (ALCarManager.mCountForCarSteer > 0) {
                    Log.i(ALCarManager.TAG, " CarSteer = " + ALCarManager.mRecordForCarSteer + " count = " + ALCarManager.mCountForCarSteer);
                    int unused2 = ALCarManager.mCountForCarSteer = 0;
                }
                if (ALCarManager.mCountForCarSpeed > 0) {
                    Log.i(ALCarManager.TAG, " CarSpeed = " + ALCarManager.mRecordForCarSpeed + " count = " + ALCarManager.mCountForCarSpeed + " isValid " + ALCarManager.mRecordForIsCarSpeedValid);
                    int unused3 = ALCarManager.mCountForCarSpeed = 0;
                }
                ALCarManager.this.mMainThreadHandler.postDelayed(this, 1000L);
            }
        };
        this.mTaskToReduceLog = runnable2;
        this.mIALCarEngineSpeedListener = new IALCarEngineSpeedListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.3
            @Override // com.autolink.adapterinterface.car.IALCarEngineSpeedListener
            public void notifyEngineSpeedChange(float f, int i) throws RemoteException {
                Message obtain = Message.obtain(ALCarManager.this.mCarHandler, 8, i, 0);
                Bundle bundle = new Bundle();
                bundle.putFloat("enginespeed", f);
                obtain.setData(bundle);
                ALCarManager.this.mCarHandler.sendMessage(obtain);
            }
        };
        this.mIALCarWindListener = new IALCarWindListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.4
            @Override // com.autolink.adapterinterface.car.IALCarWindListener
            public void notifyCarWindEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 7, aLCarPropertyEvent));
            }
        };
        this.mIALCarTyreListener = new IALCarTyreListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.5
            @Override // com.autolink.adapterinterface.car.IALCarTyreListener
            public void notifyTyreFloatChange(int i, float f) {
            }

            @Override // com.autolink.adapterinterface.car.IALCarTyreListener
            public void notifyTyreChange(int i, int i2) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 6, i, i2));
            }
        };
        this.mIALCarSteerListener = new IALCarSteerListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.6
            @Override // com.autolink.adapterinterface.car.IALCarSteerListener
            public void notifySteerChange(float f) throws RemoteException {
                Message obtain = Message.obtain(ALCarManager.this.mCarHandler, 5, 0, 0);
                Bundle bundle = new Bundle();
                bundle.putFloat("steer", f);
                obtain.setData(bundle);
                ALCarManager.this.mCarHandler.sendMessage(obtain);
            }
        };
        this.mIALCarSpeedListener = new IALCarSpeedListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.7
            @Override // com.autolink.adapterinterface.car.IALCarSpeedListener
            public void notifySpeedChange(float f, int i) throws RemoteException {
                Message obtain = Message.obtain(ALCarManager.this.mCarHandler, 4, i, 0);
                Bundle bundle = new Bundle();
                bundle.putFloat("speed", f);
                obtain.setData(bundle);
                ALCarManager.this.mCarHandler.sendMessage(obtain);
            }
        };
        this.mIALCarExtPropertyListener = new IALCarExtPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.8
            @Override // com.autolink.adapterinterface.car.IALCarExtPropertyListener
            public void notifyCarExtPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 3, aLCarPropertyEvent));
            }
        };
        this.mIALCarAVMPropertyListener = new IALCarAVMPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.9
            @Override // com.autolink.adapterinterface.car.IALCarAVMPropertyListener
            public void notifyCarAVMPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 2, aLCarPropertyEvent));
            }
        };
        this.mIALCarHvacPropertyListener = new IALCarHvacPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.10
            @Override // com.autolink.adapterinterface.car.IALCarHvacPropertyListener
            public void notifyCarHvacPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 0, aLCarPropertyEvent));
            }
        };
        this.mIALCarVehicleControlPropertyListener = new IALCarVehicleControlPropertyListener.Stub() { // from class: com.autolink.adaptermanager.car.ALCarManager.11
            @Override // com.autolink.adapterinterface.car.IALCarVehicleControlPropertyListener
            public void notifyCarVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                ALCarManager.this.mCarHandler.sendMessage(Message.obtain(ALCarManager.this.mCarHandler, 1, aLCarPropertyEvent));
            }
        };
        Looper.getMainLooper();
        this.mMainThreadHandler.post(runnable);
        this.mMainThreadHandler.post(runnable2);
        currentProject = getCurrentProject();
        modifyTAG(context);
        Log.i(TAG, "ALCarManager construct");
    }

    private void setService(IALCar iALCar) {
        this.mService = iALCar;
        if (iALCar != null) {
            this.mConnectionState = STATE_CONNECTED;
        } else {
            this.mConnectionState = STATE_DISCONNECTED;
        }
    }

    @Deprecated
    public static ALCarManager createCar(Context context) {
        Log.i(TAG, "createCar start " + context.getPackageName());
        boolean z = false;
        ALCarManager aLCarManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(ALCAR_SERVICE_BINDER_SERVICE_NAME);
            if (aLCarManager == null) {
                aLCarManager = new ALCarManager(context);
                aLCarManager.setService(IALCar.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createCar before startCarService first");
                    aLCarManager.bindService();
                    return aLCarManager;
                }
                Log.i(TAG, "createCar end");
                return aLCarManager;
            }
            if (!z) {
                Log.i(TAG, "createCar before startCarService second");
                aLCarManager.bindService();
                z = true;
            }
            i++;
            if (i > CAR_SERVICE_BINDER_POLLING_MAX_RETRY) {
                Log.i(TAG, "retryCount > CAR_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(CAR_SERVICE_BINDER_POLLING_INTERVAL_MS);
            } catch (Exception e) {
                Log.e(TAG, "createCar Exception: " + e);
                return null;
            }
        }
    }

    public static ALCarManager createCar(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        Log.i(TAG, "createCar start " + context.getPackageName());
        boolean z = false;
        ALCarManager aLCarManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(ALCAR_SERVICE_BINDER_SERVICE_NAME);
            if (aLCarManager == null) {
                aLCarManager = new ALCarManager(context, serviceConnectionListenerNew);
                aLCarManager.setService(IALCar.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createCar before startCarService first");
                    aLCarManager.bindService();
                    return aLCarManager;
                }
                Log.i(TAG, "createCar end");
                return aLCarManager;
            }
            if (!z) {
                Log.i(TAG, "createCar before startCarService second");
                aLCarManager.bindService();
                z = true;
            }
            i++;
            if (i > CAR_SERVICE_BINDER_POLLING_MAX_RETRY) {
                Log.i(TAG, "retryCount > CAR_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(CAR_SERVICE_BINDER_POLLING_INTERVAL_MS);
            } catch (Exception e) {
                Log.e(TAG, "createCar Exception: " + e);
                return null;
            }
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent();
        intent.setPackage(ALCAR_SERVICE_PACKAGE);
        intent.setAction(ALCAR_SERVICE_INTERFACE_NAME);
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(TAG, "onServiceConnected start");
        synchronized (this.mLockForCarService) {
            IALCar asInterface = IALCar.Stub.asInterface(iBinder);
            if (asInterface == null) {
                return;
            }
            IALCar iALCar = this.mService;
            if (iALCar != null && iALCar.asBinder().equals(asInterface.asBinder())) {
                Log.i(TAG, "onServiceConnected mService " + this.mService);
                return;
            }
            this.mConnectionState = STATE_CONNECTED;
            this.mService = asInterface;
            checkIsReconnect();
            Log.i(TAG, "onServiceConnected end");
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        Log.e(TAG, "onServiceDisconnected");
        synchronized (this.mLockForCarService) {
            if (this.mConnectionState == STATE_DISCONNECTED) {
                return;
            }
            handleCarDisconnectLocked();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        Log.e(TAG, "ALMiscManager->onBinderDied: ");
    }

    public int canSetVehicleParam(int i, int i2) {
        if (i == 714) {
            setT1KMirrorFlip(i2);
            return 1;
        }
        int managerToHalPropId_Set = managerToHalPropId_Set(i);
        int managerToHalAreaId_Set = managerToHalAreaId_Set(i);
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "canSetVehicleParam propertyId: " + i + " value " + i2 + " halPropertyId: " + managerToHalPropId_Set + " halAreaId " + managerToHalAreaId_Set);
        } else {
            Log.i(TAG, "canSetVehicleParam propertyId: " + i + " value " + i2 + " halPropertyId: " + managerToHalPropId_Set + " halAreaId " + managerToHalAreaId_Set);
        }
        return setIntProperty(managerToHalPropId_Set, managerToHalAreaId_Set, i2);
    }

    public int canGetVehicleParam(int i) {
        int managerToHalPropId_Get = managerToHalPropId_Get(i);
        int intProperty = getIntProperty(managerToHalPropId_Get, managerToHalAreaId_Get(i));
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "canGetVehicleParam propertyId: " + i + " result = " + intProperty + " halPropertyId " + managerToHalPropId_Get);
        } else {
            Log.i(TAG, "canGetVehicleParam propertyId: " + i + " result = " + intProperty + " halPropertyId " + managerToHalPropId_Get);
        }
        return intProperty;
    }

    public void setALCarPropListener(IALCarPropListener iALCarPropListener) {
        Log.i(TAG, "setALCarPropListener listener " + iALCarPropListener);
        synchronized (this.mLockForListener) {
            if (this.mIALCarPropListener == null) {
                registerAVMPropertyListener(this.mIALCarAVMPropertyListener);
            }
            this.mIALCarPropListener = iALCarPropListener;
        }
        Log.i(TAG, "setALCarPropListener mIALCarPropListener " + this.mIALCarPropListener);
    }

    public void removeALCarPropListener() {
        synchronized (this.mLockForListener) {
            this.mIALCarPropListener = null;
        }
        unregisterAVMPropertyListener(this.mIALCarAVMPropertyListener);
        Log.i(TAG, "setALCarPropListener mIALCarPropListener " + this.mIALCarPropListener);
    }

    public void registALCMDListener(int i, IALCmdListener iALCmdListener) {
        Log.i(TAG, "registALCMDListener modular: " + i + " listener " + iALCmdListener);
        synchronized (this.mLockForListener) {
            if (i == 24) {
                if (!this.mIALCmdListenerMap.containsKey(Integer.valueOf(i))) {
                    registerHvacPropertyListener(this.mIALCarHvacPropertyListener);
                    registerVehicleControlPropertyListener(this.mIALCarVehicleControlPropertyListener);
                    Log.i(TAG, "registALCMDListener after registerVehicleControlPropertyListener");
                }
            }
            this.mIALCmdListenerMap.put(Integer.valueOf(i), iALCmdListener);
            Log.i(TAG, "registALCMDListener end " + this.mIALCmdListenerMap.size());
        }
    }

    public void unRegistALCMDListener(int i) {
        Log.i(TAG, "unRegistALCMDListener modular: " + i);
        synchronized (this.mLockForListener) {
            if (!this.mIALCmdListenerMap.containsKey(Integer.valueOf(i))) {
                Log.i(TAG, "unRegistALCMDListener not containsKey " + i);
                return;
            }
            this.mIALCmdListenerMap.remove(Integer.valueOf(i));
            if (this.mIALCmdListenerMap.size() == 0 && this.mIALAirPurgeListener == null && this.mIALCarAllTypesVehicleControlPropListener == null) {
                unregisterHvacPropertyListener(this.mIALCarHvacPropertyListener);
                unregisterVehicleControlPropertyListener(this.mIALCarVehicleControlPropertyListener);
                Log.i(TAG, "unRegistALCMDListener after unregisterVehicleControlPropertyListener");
            }
            Log.i(TAG, "unRegistALCMDListener end " + this.mIALCmdListenerMap.size());
        }
    }

    public void registIALAirPurgeListener(IALAirPurgeListener iALAirPurgeListener) {
        Log.i(TAG, "registIMBAirPurgeListener listener: " + iALAirPurgeListener);
        synchronized (this.mLockForListener) {
            if (this.mIALAirPurgeListener == null) {
                registerHvacPropertyListener(this.mIALCarHvacPropertyListener);
                Log.i(TAG, "registIALAirPurgeListener after registerHvacPropertyListener");
            }
            this.mIALAirPurgeListener = iALAirPurgeListener;
        }
        Log.i(TAG, "registIALAirPurgeListener mIALAirPurgeListener " + this.mIALAirPurgeListener);
    }

    public void unRegistIALAirPurgeListener() {
        Log.i(TAG, "unRegistIMBAirPurgeListener");
        synchronized (this.mLockForListener) {
            if (this.mIALAirPurgeListener == null) {
                Log.i(TAG, "unRegistIMBAirPurgeListener mIALAirPurgeListener is " + this.mIALAirPurgeListener);
                return;
            }
            this.mIALAirPurgeListener = null;
            if (this.mIALCmdListenerMap.size() == 0 && this.mIALAirPurgeListener == null && this.mIALCarAllTypesVehicleControlPropListener == null) {
                unregisterHvacPropertyListener(this.mIALCarHvacPropertyListener);
                unregisterVehicleControlPropertyListener(this.mIALCarVehicleControlPropertyListener);
                Log.i(TAG, "unRegistIALAirPurgeListener after unregisterVehicleControlPropertyListener");
            }
            Log.i(TAG, "unRegistIMBAirPurgeListener end mIALAirPurgeListener " + this.mIALAirPurgeListener);
        }
    }

    private int setIntProperty(int i, int i2, int i3) {
        Log.d(TAG, "setIntProperty propId: " + i + " areaId " + i2 + " val " + i3);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return -1;
        }
        if (i == -1) {
            Log.e(TAG, "prop is invalid");
            return -1;
        }
        try {
            iALCar.setIntProperty(i, i2, i3);
            return 1;
        } catch (RemoteException e) {
            Log.e(TAG, "setIntProperty Exception: " + e);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getIntProperty(int i, int i2) {
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "getIntProperty propId: " + i + " areaId " + i2);
        } else {
            Log.i(TAG, "getIntProperty propId: " + i + " areaId " + i2);
        }
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return CAR_GET_PROPERTY_RESULT_CODE_FAIL;
        }
        if (i == -1) {
            return CAR_GET_PROPERTY_RESULT_CODE_FAIL;
        }
        try {
            return iALCar.getIntProperty(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "getIntProperty Exception: " + e);
            return CAR_GET_PROPERTY_RESULT_CODE_FAIL;
        }
    }

    private float getFloatProperty(int i, int i2) {
        int i3;
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "getFloatProperty propId: " + i + " areaId " + i2);
        } else {
            Log.i(TAG, "getFloatProperty propId: " + i + " areaId " + i2);
        }
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            i3 = CAR_GET_PROPERTY_RESULT_CODE_FAIL;
        } else if (i == -1) {
            i3 = CAR_GET_PROPERTY_RESULT_CODE_FAIL;
        } else {
            try {
                return iALCar.getFloatProperty(i, i2);
            } catch (RemoteException e) {
                Log.e(TAG, "getFloatProperty Exception: " + e);
                i3 = CAR_GET_PROPERTY_RESULT_CODE_FAIL;
            }
        }
        return i3;
    }

    private void registerAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) {
        Log.i(TAG, "registerAVMPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.registerAVMPropertyListener(iALCarAVMPropertyListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerAVMPropertyListener Exception: " + e);
            }
        }
    }

    private void unregisterAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) {
        Log.i(TAG, "unregisterAVMPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterAVMPropertyListener(iALCarAVMPropertyListener);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterAVMPropertyListener Exception: " + e);
            }
        }
    }

    private void registerHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) {
        Log.i(TAG, "registerHvacPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            if (this.flagRegisterHvacPropertyListener) {
                Log.i(TAG, "flagRegisterHvacPropertyListener is " + this.flagRegisterHvacPropertyListener);
                return;
            }
            try {
                this.mService.registerHvacPropertyListener(iALCarHvacPropertyListener);
                this.flagRegisterHvacPropertyListener = DBG;
                Log.i(TAG, "set flagRegisterHvacPropertyListener = " + this.flagRegisterHvacPropertyListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerHvacPropertyListener Exception: " + e);
            }
        }
    }

    private void unregisterHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) {
        Log.i(TAG, "unregisterHvacPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterHvacPropertyListener(iALCarHvacPropertyListener);
                this.flagRegisterHvacPropertyListener = false;
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterHvacPropertyListener Exception: " + e);
            }
        }
    }

    private void registerVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) {
        Log.i(TAG, "registerVehicleControlPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            if (this.flagRegisterVehicleControlPropertyListener) {
                Log.i(TAG, "flagRegisterVehicleControlPropertyListener is " + this.flagRegisterVehicleControlPropertyListener);
                return;
            }
            try {
                this.mService.registerVehicleControlPropertyListener(iALCarVehicleControlPropertyListener);
                this.flagRegisterVehicleControlPropertyListener = DBG;
                Log.i(TAG, "set flagRegisterVehicleControlPropertyListener = " + this.flagRegisterVehicleControlPropertyListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerVehicleControlPropertyListener Exception: " + e);
            }
        }
    }

    private void unregisterVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) {
        Log.i(TAG, "unregisterVehicleControlPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterVehicleControlPropertyListener(iALCarVehicleControlPropertyListener);
                this.flagRegisterVehicleControlPropertyListener = false;
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterVehicleControlPropertyListener Exception: " + e);
            }
        }
    }

    private void handleCarDisconnectLocked() {
        Log.i(TAG, "handleCarDisconnectLocked start");
        unbindService();
        this.mService = null;
        this.mConnectionState = STATE_DISCONNECTED;
    }

    public void release() {
        Log.i(TAG, "release");
        synchronized (this.mLockForListener) {
            this.mIALCmdListenerMap.clear();
        }
        unregisterHvacPropertyListener(this.mIALCarHvacPropertyListener);
        unregisterVehicleControlPropertyListener(this.mIALCarVehicleControlPropertyListener);
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mLockForCarService) {
            z = this.mService != null ? DBG : false;
        }
        Log.i(TAG, "isConnected " + z);
        return z;
    }

    public int setVehicleAVMProp(int i, int i2) {
        int managerToHalAVMPropId_Set = CarUtils.managerToHalAVMPropId_Set(i);
        int managerToHalAVMAreaId_Set = CarUtils.managerToHalAVMAreaId_Set(i);
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "setVehicleAVMProp halPropertyId: " + managerToHalAVMPropId_Set + " halAreaId " + managerToHalAVMAreaId_Set);
        } else {
            Log.i(TAG, "setVehicleAVMProp halPropertyId: " + managerToHalAVMPropId_Set + " halAreaId " + managerToHalAVMAreaId_Set);
        }
        return setIntProperty(managerToHalAVMPropId_Set, managerToHalAVMAreaId_Set, i2);
    }

    public int getVehicleAVMProp(int i) {
        int intProperty = getIntProperty(CarUtils.managerToHalAVMPropId_Get(i), CarUtils.managerToHalAVMAreaId_Get(i));
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "getVehicleAVMProp propertyId: " + i + "getVehicleAVMProp result = " + intProperty);
        } else {
            Log.i(TAG, "getVehicleAVMProp propertyId: " + i + "getVehicleAVMProp result = " + intProperty);
        }
        return intProperty;
    }

    public float getFloatVehicleAVMProp(int i) {
        float floatProperty = getFloatProperty(CarUtils.managerToHalAVMPropId_Get(i), CarUtils.managerToHalAVMAreaId_Get(i));
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "getFloatVehicleAVMProp propertyId: " + i + "getFloatVehicleAVMProp result = " + floatProperty);
        } else {
            Log.i(TAG, "getFloatVehicleAVMProp propertyId: " + i + "getFloatVehicleAVMProp result = " + floatProperty);
        }
        return floatProperty;
    }

    public int setVehiclePowerProp(int i, int i2) {
        int managerToHalPowerPropId_Set = CarUtils.managerToHalPowerPropId_Set(i);
        int managerToHalPowerAreaId_Set = CarUtils.managerToHalPowerAreaId_Set(i);
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "setVehiclePowerProp propertyId: " + i + " value " + i2 + " halPropertyId: " + managerToHalPowerPropId_Set + " halAreaId " + managerToHalPowerAreaId_Set);
        } else {
            Log.i(TAG, "setVehiclePowerProp propertyId: " + i + " value " + i2 + " halPropertyId: " + managerToHalPowerPropId_Set + " halAreaId " + managerToHalPowerAreaId_Set);
        }
        return setIntProperty(managerToHalPowerPropId_Set, managerToHalPowerAreaId_Set, i2);
    }

    public float getFloatVehicleControlProp(int i) {
        float floatProperty = getFloatProperty(managerToHalPropId_Get(i), managerToHalAreaId_Get(i));
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "getFloatVehicleControlProp propertyId: " + i + " result = " + floatProperty);
        } else {
            Log.i(TAG, "getFloatVehicleControlProp propertyId: " + i + " result = " + floatProperty);
        }
        return floatProperty;
    }

    public void factoryReset() {
        Log.i(TAG, "factoryReset start");
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.factoryResetForAL();
        } catch (RemoteException e) {
            Log.e(TAG, "factoryReset Exception: " + e);
        }
    }

    public void setALCarAllTypesVehicleControlPropListener(IALCarAllTypesVehicleControlPropListener iALCarAllTypesVehicleControlPropListener) {
        Log.i(TAG, "setALCarAllTypesVehicleControlPropListener listener " + iALCarAllTypesVehicleControlPropListener);
        synchronized (this.mLockForListener) {
            if (this.mIALCarAllTypesVehicleControlPropListener == null) {
                registerVehicleControlPropertyListener(this.mIALCarVehicleControlPropertyListener);
            }
            this.mIALCarAllTypesVehicleControlPropListener = iALCarAllTypesVehicleControlPropListener;
        }
        Log.i(TAG, "setALCarAllTypesVehicleControlPropListener mIALCarAllTypesVehicleControlPropListener " + this.mIALCarAllTypesVehicleControlPropListener);
    }

    public void removeALCarAllTypesVehicleControlPropListener() {
        synchronized (this.mLockForListener) {
            if (this.mIALCarAllTypesVehicleControlPropListener == null) {
                Log.i(TAG, "removeALCarAllTypesVehicleControlPropListener mIALCarAllTypesVehicleControlPropListener is " + this.mIALCarAllTypesVehicleControlPropListener);
                return;
            }
            this.mIALCarAllTypesVehicleControlPropListener = null;
            if (this.mIALCmdListenerMap.size() == 0 && this.mIALAirPurgeListener == null && this.mIALCarAllTypesVehicleControlPropListener == null) {
                unregisterHvacPropertyListener(this.mIALCarHvacPropertyListener);
                unregisterVehicleControlPropertyListener(this.mIALCarVehicleControlPropertyListener);
                Log.i(TAG, "removeALCarAllTypesVehicleControlPropListener after unregisterVehicleControlPropertyListener");
            }
            Log.i(TAG, "removeALCarAudioPropListener mIALCarAllTypesVehicleControlPropListener " + this.mIALCarAllTypesVehicleControlPropListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAllTypesVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        int halToManagerPropId = halToManagerPropId(aLCarPropertyEvent.getId());
        if (halToManagerPropId == -1) {
            return;
        }
        if ((aLCarPropertyEvent.getId() & 6291456) == 6291456) {
            notifyCarAllTypesVehicleControlPropertyEvent(new ALCarPropertyEvent(halToManagerPropId, Float.valueOf(((Float) aLCarPropertyEvent.getValue()).floatValue())));
        } else {
            notifyCarAllTypesVehicleControlPropertyEvent(new ALCarPropertyEvent(halToManagerPropId, Integer.valueOf(((Integer) aLCarPropertyEvent.getValue()).intValue())));
        }
    }

    private void notifyCarAllTypesVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        synchronized (this.mLockForListener) {
            IALCarAllTypesVehicleControlPropListener iALCarAllTypesVehicleControlPropListener = this.mIALCarAllTypesVehicleControlPropListener;
            if (iALCarAllTypesVehicleControlPropListener != null) {
                Log.i(TAG, "notifyAllTypesEvent onACVCPropChanged Id: " + aLCarPropertyEvent.getId());
                iALCarAllTypesVehicleControlPropListener.onALCarVehicleControlPropChanged(aLCarPropertyEvent);
            } else {
                Log.d(TAG, "mIALCarAllTypesVehicleControlPropListener is " + this.mIALCarAllTypesVehicleControlPropListener);
            }
        }
    }

    private int setIntPropertyReduceLog(int i, int i2) {
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return -1;
        }
        if (i == -1) {
            Log.e(TAG, "prop is invalid");
            return -1;
        }
        try {
            iALCar.setIntPropertyReduceLog(i, i2);
            return 1;
        } catch (RemoteException e) {
            Log.e(TAG, "setIntProperty Exception: " + e);
            return -1;
        }
    }

    public int setVehicleAudioParam(int i, int i2) {
        return setIntPropertyReduceLog(CarUtils.managerToHalMusicLoudnessPropId_Set(i), i2);
    }

    private void setMultiWindow(int i, int i2, int i3, int i4) {
        Log.i(TAG, "setMultiWindow fl = " + i + " fr = " + i2 + " rl = " + i3 + " rr = " + i4);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setMultiWindow(i, i2, i3, i4);
        } catch (RemoteException e) {
            Log.e(TAG, "setMultiWindow Exception: " + e);
        }
    }

    private void controlUltravioletLuminance(int i, int i2) {
        Log.i(TAG, "controlUltravioletLuminance open = " + i + " req = " + i2);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.controlUltravioletLuminance(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "controlUltravioletLuminance Exception: " + e);
        }
    }

    private void controlFraganceConcentration(int i, int i2) {
        Log.i(TAG, "controlFraganceConcentration open = " + i + " req = " + i2);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.controlFraganceConcentration(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "controlFraganceConcentration Exception: " + e);
        }
    }

    public void openAllWindow() {
        setMultiWindow(2, 2, 2, 2);
        Log.i(TAG, "openAllWindow end");
    }

    public void closeAllWindow() {
        setMultiWindow(1, 1, 1, 1);
        Log.i(TAG, "closeAllWindow end");
    }

    public void setUltraviolet(int i) {
        Log.i(TAG, "setUltraviolet req " + i);
        controlUltravioletLuminance(1, i);
    }

    public void setFragance(int i) {
        Log.i(TAG, "setFragance req " + i);
        controlFraganceConcentration(1, i);
    }

    public void setAllWindowVentilation() {
        setMultiWindow(3, 0, 0, 3);
        Log.i(TAG, "setAllWindowVentilation end");
    }

    public void controlMultiWindow(int i, int i2, int i3, int i4) {
        setMultiWindow(i, i2, i3, i4);
        Log.i(TAG, "controlMultiWindow end");
    }

    public int setVehicleExtProp(int i, int i2) {
        int managerToHalExtPropId_Set = CarUtils.managerToHalExtPropId_Set(i);
        int managerToHalExtAreaId_Set = CarUtils.managerToHalExtAreaId_Set(i);
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "setVehicleExtProp propertyId: " + i + " value " + i2 + " halPropertyId: " + managerToHalExtPropId_Set + " halAreaId " + managerToHalExtAreaId_Set);
        } else {
            Log.i(TAG, "setVehicleExtProp propertyId: " + i + " value " + i2 + " halPropertyId: " + managerToHalExtPropId_Set + " halAreaId " + managerToHalExtAreaId_Set);
        }
        return setIntProperty(managerToHalExtPropId_Set, managerToHalExtAreaId_Set, i2);
    }

    public int getVehicleExtProp(int i) {
        int intProperty = getIntProperty(CarUtils.managerToHalExtPropId_Get(i), CarUtils.managerToHalExtAreaId_Get(i));
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "getVehicleExtProp propertyId: " + i + "getVehicleExtProp result = " + intProperty);
        } else {
            Log.i(TAG, "getVehicleExtProp propertyId: " + i + "getVehicleExtProp result = " + intProperty);
        }
        return intProperty;
    }

    public float getFloatVehicleExtProp(int i) {
        float floatProperty = getFloatProperty(CarUtils.managerToHalExtPropId_Get(i), CarUtils.managerToHalExtAreaId_Get(i));
        if (PROJECT_T1P_INT.equals(currentProject) || PROJECT_T1L.equals(currentProject)) {
            Log.d(TAG, "getFloatVehicleExtProp propertyId: " + i + " result = " + floatProperty);
        } else {
            Log.i(TAG, "getFloatVehicleExtProp propertyId: " + i + " result = " + floatProperty);
        }
        return floatProperty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExtPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        int halToManagerExtPropId = CarUtils.halToManagerExtPropId(aLCarPropertyEvent.getId());
        if (halToManagerExtPropId == -1) {
            Log.i(TAG, "propId == MANAGER_PROPID_INVALID " + aLCarPropertyEvent.getId());
        } else if ((aLCarPropertyEvent.getId() & 6291456) == 6291456) {
            notifyExtPropertyEvent(new ALCarPropertyEvent(halToManagerExtPropId, Float.valueOf(((Float) aLCarPropertyEvent.getValue()).floatValue())));
        } else {
            notifyExtPropertyEvent(new ALCarPropertyEvent(halToManagerExtPropId, Integer.valueOf(((Integer) aLCarPropertyEvent.getValue()).intValue())));
        }
    }

    private void notifyExtPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        synchronized (this.mLockForListener) {
            IALExtCarPropListener iALExtCarPropListener = this.mIALExtCarPropListener;
            if (iALExtCarPropListener != null) {
                Log.i(TAG, "notifyExtPropertyEvent onALCarEventChanged event.getId() is " + aLCarPropertyEvent.getId());
                iALExtCarPropListener.onALCarEventChanged(aLCarPropertyEvent);
            }
        }
    }

    private void registerExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) {
        Log.i(TAG, "registerExtPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.registerExtPropertyListener(iALCarExtPropertyListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerExtPropertyListener Exception: " + e);
            }
        }
    }

    private void unregisterExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) {
        Log.i(TAG, "unregisterExtPropertyListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterExtPropertyListener(iALCarExtPropertyListener);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterExtPropertyListener Exception: " + e);
            }
        }
    }

    public void setALCarExtPropListener(IALExtCarPropListener iALExtCarPropListener) {
        Log.i(TAG, "setALCarExtPropListener listener " + iALExtCarPropListener);
        synchronized (this.mLockForListener) {
            if (this.mIALExtCarPropListener == null) {
                registerExtPropertyListener(this.mIALCarExtPropertyListener);
            }
            this.mIALExtCarPropListener = iALExtCarPropListener;
        }
        Log.i(TAG, "setALCarExtPropListener mIALExtCarPropListener " + this.mIALExtCarPropListener);
    }

    public void removeALCarExtPropListener() {
        synchronized (this.mLockForListener) {
            this.mIALExtCarPropListener = null;
        }
        unregisterExtPropertyListener(this.mIALCarExtPropertyListener);
        Log.i(TAG, "removeALCarExtPropListener mIALExtCarPropListener " + this.mIALExtCarPropListener);
    }

    private void registerCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) {
        Log.i(TAG, "registerCarSpeedListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.registerCarSpeedListener(iALCarSpeedListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerCarSpeedListener Exception: " + e);
            }
        }
    }

    private void unregisterCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) {
        Log.i(TAG, "unregisterCarSpeedListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterCarSpeedListener(iALCarSpeedListener);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterCarSpeedListener Exception: " + e);
            }
        }
    }

    public void setCarSpeedListener(CarSpeedListener carSpeedListener) {
        Log.i(TAG, "setCarSpeedListener listener " + carSpeedListener);
        synchronized (this.mLockForListener) {
            if (this.mCarSpeedListener == null) {
                registerCarSpeedListener(this.mIALCarSpeedListener);
            }
            this.mCarSpeedListener = carSpeedListener;
        }
        Log.i(TAG, "setCarSpeedListener mCarSpeedListener " + this.mIALCarSpeedListener);
    }

    public void removeCarSpeedListener() {
        synchronized (this.mLockForListener) {
            this.mCarSpeedListener = null;
        }
        unregisterCarSpeedListener(this.mIALCarSpeedListener);
        Log.i(TAG, "removeCarSpeedListener mCarSpeedListener " + this.mIALCarSpeedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCarSpeed(float f, int i) {
        CarSpeedListener carSpeedListener;
        synchronized (this.mLockForListener) {
            carSpeedListener = this.mCarSpeedListener;
        }
        if (carSpeedListener != null) {
            Log.d(TAG, "handleCarSpeed speed " + f + " isValid " + i);
            carSpeedListener.onCarSpeedChanged(f, i);
            mRecordForCarSpeed = f;
            mRecordForIsCarSpeedValid = i;
            mCountForCarSpeed++;
        }
    }

    private void registerCarSteerListener(IALCarSteerListener iALCarSteerListener) {
        Log.i(TAG, "registerCarSteerListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.registerCarSteerListener(iALCarSteerListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerCarSteerListener Exception: " + e);
            }
        }
    }

    private void unregisterCarSteerListener(IALCarSteerListener iALCarSteerListener) {
        Log.i(TAG, "unregisterCarSteerListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterCarSteerListener(iALCarSteerListener);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterCarSteerListener Exception: " + e);
            }
        }
    }

    public void setCarSteerListener(CarSteerListener carSteerListener) {
        Log.i(TAG, "setCarSteerListener listener " + carSteerListener);
        synchronized (this.mLockForListener) {
            if (this.mCarSteerListener == null) {
                registerCarSteerListener(this.mIALCarSteerListener);
            }
            this.mCarSteerListener = carSteerListener;
        }
        Log.i(TAG, "setCarSteerListener mCarSteerListener " + this.mCarSteerListener);
    }

    public void removeCarSteerListener() {
        synchronized (this.mLockForListener) {
            this.mCarSteerListener = null;
        }
        unregisterCarSteerListener(this.mIALCarSteerListener);
        Log.i(TAG, "removeCarSteerListener mCarSpeedListener " + this.mCarSteerListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCarSteer(float f) {
        CarSteerListener carSteerListener;
        synchronized (this.mLockForListener) {
            carSteerListener = this.mCarSteerListener;
        }
        if (carSteerListener != null) {
            Log.d(TAG, "handleCarSteer steer " + f);
            carSteerListener.onCarSteerChanged(f);
            mRecordForCarSteer = f;
            mCountForCarSteer++;
        }
    }

    private void registerCarTyreListener(IALCarTyreListener iALCarTyreListener) {
        Log.i(TAG, "registerCarTyreListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.registerCarTyreListener(iALCarTyreListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerCarTyreListener Exception: " + e);
            }
        }
    }

    private void unregisterCarTyreListener(IALCarTyreListener iALCarTyreListener) {
        Log.i(TAG, "unregisterCarTyreListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterCarTyreListener(iALCarTyreListener);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterCarTyreListener Exception: " + e);
            }
        }
    }

    public void setCarTyreListener(CarTyreListener carTyreListener) {
        Log.i(TAG, "setCarSteerListener listener " + carTyreListener);
        synchronized (this.mLockForListener) {
            if (this.mCarTyreListener == null) {
                registerCarTyreListener(this.mIALCarTyreListener);
            }
            this.mCarTyreListener = carTyreListener;
        }
        Log.i(TAG, "setCarTyreListener mCarTyreListener " + this.mCarTyreListener);
    }

    public void removeCarTyreListener() {
        synchronized (this.mLockForListener) {
            this.mCarTyreListener = null;
        }
        unregisterCarTyreListener(this.mIALCarTyreListener);
        Log.i(TAG, "removeCarTyreListener mCarTyreListener " + this.mCarTyreListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCarTyreData(int i, int i2) {
        CarTyreListener carTyreListener;
        if ((i & 6291456) == 6291456) {
            Log.i(TAG, "handleCarTyreData float return " + i);
            return;
        }
        int halToManagerPropId = halToManagerPropId(i);
        if (halToManagerPropId == -1) {
            Log.i(TAG, "propId == MANAGER_PROPID_INVALID " + i);
            return;
        }
        synchronized (this.mLockForListener) {
            carTyreListener = this.mCarTyreListener;
        }
        if (carTyreListener != null) {
            Log.i(TAG, "handleCarTyreData propId " + halToManagerPropId + " val " + i2 + " prop " + i);
            carTyreListener.onTyreDataChanged(halToManagerPropId, i2);
        }
    }

    public void setCarWindPropListener(CarWindPropListener carWindPropListener) {
        Log.i(TAG, "setCarWindPropListener listener " + carWindPropListener);
        synchronized (this.mLockForListener) {
            if (this.mCarWindPropListener == null) {
                registerCarWindListener(this.mIALCarWindListener);
            }
            this.mCarWindPropListener = carWindPropListener;
        }
        Log.i(TAG, "setCarWindPropListener mCarWindPropListener " + this.mCarWindPropListener);
    }

    public void removeWindPropListener() {
        synchronized (this.mLockForListener) {
            this.mCarWindPropListener = null;
        }
        unregisterCarWindListener(this.mIALCarWindListener);
        Log.i(TAG, "removeWindPropListener mCarWindPropListener " + this.mCarWindPropListener);
    }

    private void registerCarWindListener(IALCarWindListener iALCarWindListener) {
        Log.i(TAG, "registerCarWindListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.registerCarWindListener(iALCarWindListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerCarWindListener Exception: " + e);
            }
        }
    }

    private void unregisterCarWindListener(IALCarWindListener iALCarWindListener) {
        Log.i(TAG, "unregisterCarWindListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterCarWindListener(iALCarWindListener);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterCarWindListener Exception: " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWindPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        int halToManagerPropId = halToManagerPropId(aLCarPropertyEvent.getId());
        if (halToManagerPropId == -1) {
            Log.i(TAG, "propId == MANAGER_PROPID_INVALID " + aLCarPropertyEvent.getId());
        } else if ((aLCarPropertyEvent.getId() & 6291456) == 6291456) {
            notifyWindPropertyEvent(new ALCarPropertyEvent(halToManagerPropId, Float.valueOf(((Float) aLCarPropertyEvent.getValue()).floatValue())));
        } else {
            notifyWindPropertyEvent(new ALCarPropertyEvent(halToManagerPropId, Integer.valueOf(((Integer) aLCarPropertyEvent.getValue()).intValue())));
        }
    }

    private void notifyWindPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) {
        synchronized (this.mLockForListener) {
            CarWindPropListener carWindPropListener = this.mCarWindPropListener;
            if (carWindPropListener != null) {
                Log.i(TAG, "notifyWindPropertyEvent event.getId() is " + aLCarPropertyEvent.getId());
                carWindPropListener.onALCarWindEventChanged(aLCarPropertyEvent);
            }
        }
    }

    private void registerCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) {
        Log.i(TAG, "registerCarEngineSpeedListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.registerCarEngineSpeedListener(iALCarEngineSpeedListener);
            } catch (RemoteException e) {
                Log.e(TAG, "registerCarEngineSpeedListener Exception: " + e);
            }
        }
    }

    private void unregisterCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) {
        Log.i(TAG, "unregisterCarEngineSpeedListener");
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        synchronized (this.mLockForListener) {
            try {
                this.mService.unregisterCarEngineSpeedListener(iALCarEngineSpeedListener);
            } catch (RemoteException e) {
                Log.e(TAG, "unregisterCarEngineSpeedListener Exception: " + e);
            }
        }
    }

    public void setCarEngineSpeedListener(CarEngineSpeedListener carEngineSpeedListener) {
        Log.i(TAG, "setCarSpeedListener listener " + carEngineSpeedListener);
        synchronized (this.mLockForListener) {
            if (this.mCarEngineSpeedListener == null) {
                registerCarEngineSpeedListener(this.mIALCarEngineSpeedListener);
            }
            this.mCarEngineSpeedListener = carEngineSpeedListener;
        }
        Log.i(TAG, "setCarSpeedListener mCarEngineSpeedListener " + this.mIALCarSpeedListener);
    }

    public void removeCarEngineSpeedListener() {
        synchronized (this.mLockForListener) {
            this.mCarEngineSpeedListener = null;
        }
        unregisterCarEngineSpeedListener(this.mIALCarEngineSpeedListener);
        Log.i(TAG, "removeCarSpeedListener mCarEngineSpeedListener " + this.mIALCarSpeedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCarEngineSpeed(float f, int i) {
        CarEngineSpeedListener carEngineSpeedListener;
        synchronized (this.mLockForListener) {
            carEngineSpeedListener = this.mCarEngineSpeedListener;
        }
        if (carEngineSpeedListener != null) {
            Log.d(TAG, "handleCarEngineSpeed speed " + f + " isValid " + i);
            carEngineSpeedListener.onCarEngineSpeedChanged(f, i);
            mRecordForEngineSpeed = f;
            mRecordForIsEngineSpeedValid = i;
            mCountForEngineSpeed++;
        }
    }

    private void sendHVACsignalsForSmartScene(byte[] bArr) {
        Log.i(TAG, "sendHVACsignalsForSmartScene");
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.sendHVACsignalsForSmartScene(bArr);
        } catch (RemoteException e) {
            Log.e(TAG, "sendHVACsignalsForSmartScene Exception: " + e);
        }
    }

    public void sendHVACsignalsInSmartScene(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        sendHVACsignalsForSmartScene(new byte[]{b, b2, b3, b4, b5, b6, b7, b8});
        Log.i(TAG, "sendHVACsignalsInSmartScene end");
    }

    public void setFraganceInSmartScene(int i, int i2) {
        Log.i(TAG, "setFragance open " + i + " level " + i2);
        controlFraganceConcentration(i, i2);
    }

    public void sendChargeTime(int i, int i2, int i3, int i4) {
        Log.i(TAG, "sendChargeTime startHour = " + i + " startMin = " + i2 + " stopHour = " + i3 + " stopMin = " + i4);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.sendChargeTime(i, i2, i3, i4);
        } catch (RemoteException e) {
            Log.e(TAG, "sendChargeTime Exception: " + e);
        }
    }

    public void sendTboxSignalGroupForT1J(int i, int i2, int i3, int i4, int i5) {
        Log.i(TAG, "sendTboxSignalGroupForT1J startHour = " + i + " startMin = " + i2 + " stopHour = " + i3 + " stopMin = " + i4 + " chargeMode = " + i5);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.sendTboxSignalGroupForT1J(i, i2, i3, i4, i5);
        } catch (RemoteException e) {
            Log.e(TAG, "sendTboxSignalGroupForT1J Exception: " + e);
        }
    }

    public void sendTboxSignalGroupForT1P(int i, int i2, int i3, int i4, int i5) {
        Log.i(TAG, "sendTboxSignalGroupForT1P startHour = " + i + " startMin = " + i2 + " stopHour = " + i3 + " stopMin = " + i4 + " chargeMode = " + i5);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.sendTboxSignalGroupForT1P(i, i2, i3, i4, i5);
        } catch (RemoteException e) {
            Log.e(TAG, "sendTboxSignalGroupForT1P Exception: " + e);
        }
    }

    private void sendIHU11signals(byte[] bArr) {
        Log.i(TAG, "sendIHU11signals");
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.sendIHU11signals(bArr);
        } catch (RemoteException e) {
            Log.e(TAG, "sendIHU11signals Exception: " + e);
        }
    }

    private void sendIHU03signals(byte[] bArr) {
        Log.i(TAG, "sendIHU03signals");
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.sendIHU03signals(bArr);
        } catch (RemoteException e) {
            Log.e(TAG, "sendIHU03signals Exception: " + e);
        }
    }

    public void sendIHU11ForLab(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
        Log.i(TAG, "sendChargeTime arg_aeb = " + ((int) b) + " arg_fcw = " + ((int) b2) + " arg_sla = " + ((int) b3) + " arg_dai = " + ((int) b4) + " arg_tsi = " + ((int) b5) + " arg_ldw = " + ((int) b6) + " arg_elk = " + ((int) b7));
        sendIHU11signals(new byte[]{b, b2, b3, b4, b5, b6, b7});
    }

    public void sendIHU03ForLab(byte b, byte b2, byte b3) {
        Log.i(TAG, "sendChargeTime arg1 = " + ((int) b) + " arg2 = " + ((int) b2) + " arg3 = " + ((int) b3));
        sendIHU03signals(new byte[]{b, 0, b2, b3});
    }

    public void sendFrontCrashWarningSignals(int i, int i2) {
        Log.i(TAG, "sendFrontCrashWarningSignals option = " + i + " switch = " + i2);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.sendFrontCrashWarningSignals(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "sendFrontCrashWarningSignals Exception: " + e);
        }
    }

    private void setGroupPropertyForMusicLoud(byte[] bArr) {
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForMusicLoud(bArr);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForMusicLoud Exception: " + e);
        }
    }

    public void setGroupPropertyForMusicLoud(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
        setGroupPropertyForMusicLoud(new byte[]{b, b2, b3, b4, b5, b6, b7});
    }

    public void checkIsReconnect() {
        Log.e(TAG, "checkIsReconnect start");
        if (this.mIALCmdListenerMap.size() > 0 || this.mIALAirPurgeListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerHvacPropertyListener(this.mIALCarHvacPropertyListener);
                    this.mService.registerVehicleControlPropertyListener(this.mIALCarVehicleControlPropertyListener);
                    Log.e(TAG, "checkIsReconnect after registerVehicleControlPropertyListener");
                } catch (RemoteException e) {
                    Log.e(TAG, "checkIsReconnect Exception1: " + e);
                }
            }
        }
        if (this.mIALCarPropListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerAVMPropertyListener(this.mIALCarAVMPropertyListener);
                    Log.e(TAG, "checkIsReconnect after registerAVMPropertyListener");
                } catch (RemoteException e2) {
                    Log.e(TAG, "checkIsReconnect Exception2: " + e2);
                }
            }
        }
        if (this.mIALExtCarPropListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerExtPropertyListener(this.mIALCarExtPropertyListener);
                    Log.e(TAG, "checkIsReconnect after registerExtPropertyListener");
                } catch (RemoteException e3) {
                    Log.e(TAG, "checkIsReconnect Exception3: " + e3);
                }
            }
        }
        if (this.mCarSpeedListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerCarSpeedListener(this.mIALCarSpeedListener);
                    Log.e(TAG, "checkIsReconnect after registerCarSpeedListener");
                } catch (RemoteException e4) {
                    Log.e(TAG, "checkIsReconnect Exception4: " + e4);
                }
            }
        }
        if (this.mCarSteerListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerCarSteerListener(this.mIALCarSteerListener);
                    Log.e(TAG, "checkIsReconnect after registerCarSteerListener");
                } catch (RemoteException e5) {
                    Log.e(TAG, "checkIsReconnect Exception5: " + e5);
                }
            }
        }
        if (this.mCarTyreListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerCarTyreListener(this.mIALCarTyreListener);
                    Log.e(TAG, "checkIsReconnect after registerCarTyreListener");
                } catch (RemoteException e6) {
                    Log.e(TAG, "checkIsReconnect Exception6: " + e6);
                }
            }
        }
        if (this.mCarWindPropListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerCarWindListener(this.mIALCarWindListener);
                    Log.e(TAG, "checkIsReconnect after registerCarWindListener");
                } catch (RemoteException e7) {
                    Log.e(TAG, "checkIsReconnect Exception7: " + e7);
                }
            }
        }
        if (this.mCarEngineSpeedListener != null) {
            synchronized (this.mLockForListener) {
                try {
                    this.mService.registerCarEngineSpeedListener(this.mIALCarEngineSpeedListener);
                    Log.e(TAG, "checkIsReconnect after registerCarEngineSpeedListener");
                } catch (RemoteException e8) {
                    Log.e(TAG, "checkIsReconnect Exception8: " + e8);
                }
            }
        }
    }

    private void setT1KMirrorFlip(int i) {
        Log.i(TAG, "setT1KMirrorFlip value = " + i);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setT1KMirrorFlip(i);
        } catch (RemoteException e) {
            Log.e(TAG, "setT1KMirrorFlip Exception: " + e);
        }
    }

    public void setGroupPropertyForIHUDVR1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Log.i(TAG, "setGroupPropertyForIHUDVR1 arg0 = " + i + " arg1 = " + i2 + " arg2 = " + i3 + " arg3 = " + i4 + " arg4 = " + i5 + " arg5 = " + i6 + " arg6 = " + i7 + " arg7 = " + i8);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHUDVR1(i, i2, i3, i4, i5, i6, i7, i8);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForIHUDVR1 Exception: " + e);
        }
    }

    public void setGroupPropertyForIHUDVR2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Log.i(TAG, "setGroupPropertyForIHUDVR2 arg0 = " + i + " arg1 = " + i2 + " arg2 = " + i3 + " arg3 = " + i4 + " arg4 = " + i5 + " arg5 = " + i6 + " arg6 = " + i7 + " arg7 = " + i8);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHUDVR2(i, i2, i3, i4, i5, i6, i7, i8);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForIHUDVR2 Exception: " + e);
        }
    }

    public void setGroupPropertyForIHUDVR3(int i, int i2, int i3) {
        Log.i(TAG, "setGroupPropertyForIHUDVR3 arg0 = " + i + " arg1 = " + i2 + " arg2 = " + i3);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHUDVR3(i, i2, i3);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForIHUDVR3 Exception: " + e);
        }
    }

    public void setGroupPropertyForHUD(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Log.i(TAG, "setGroupPropertyForHUD arg0 = " + i + " arg1 = " + i2 + " arg2 = " + i3 + " arg3 = " + i4 + " arg4 = " + i5 + " arg5 = " + i6 + " arg6 = " + i7 + " arg7 = " + i8);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForHUD(i, i2, i3, i4, i5, i6, i7, i8);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForHUD Exception: " + e);
        }
    }

    public void setPropertyForHUD(int i, int i2) {
        Log.i(TAG, "setPropertyForHUD propertyId: " + i + " value " + i2);
        if (this.mService == null) {
            Log.e(TAG, "mService is null");
        }
        switch (i) {
            case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD /* 737 */:
                setGroupPropertyForHUD(i2, 0, 0, 0, 0, 0, 0, 0);
                break;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_MODE /* 738 */:
                setGroupPropertyForHUD(0, i2, 0, 0, 0, 0, 0, 0);
                break;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_HEIGHT /* 739 */:
                setGroupPropertyForHUD(0, 0, i2, 0, 0, 0, 0, 0);
                break;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_BRIGHTNESS_MODE /* 740 */:
                setGroupPropertyForHUD(0, 0, 0, i2, 0, 0, 0, 0);
                break;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_HUD_BRIGHTNESS /* 741 */:
                setGroupPropertyForHUD(0, 0, 0, 0, i2, 0, 0, 0);
                break;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_BLUETOOTH_DISPLAY /* 742 */:
                setGroupPropertyForHUD(0, 0, 0, 0, 0, i2, 0, 0);
                break;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_DAS_DISPLAY /* 743 */:
                setGroupPropertyForHUD(0, 0, 0, 0, 0, 0, i2, 0);
                break;
            case ALVehicleControlProperty.VEHICLE_PROPERTY_NAV_DISPLAY /* 744 */:
                setGroupPropertyForHUD(0, 0, 0, 0, 0, 0, 0, i2);
                break;
            default:
                Log.e(TAG, "setPropertyForHUD invalid propertyId: " + i);
                break;
        }
    }

    public void setGroupPropertyForIHUDVRT1L(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Log.i(TAG, "setGroupPropertyForIHUDVRT1L arg0 = " + i + " arg1 = " + i2 + " arg2 = " + i3 + " arg3 = " + i4 + " arg4 = " + i5 + " arg5 = " + i6 + " arg6 = " + i7 + " arg7 = " + i8);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHUDVRT1L(i, i2, i3, i4, i5, i6, i7, i8);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForIHUDVRT1L Exception: " + e);
        }
    }

    private void setT1PSeatHeatAndVentilationInternal(int i, int i2) {
        Log.i(TAG, "setT1PSeatHeatAndVentilationInternal v1 = " + i + " v2 " + i2);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setT1PSeatHeatAndVentilation(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "setT1PSeatHeatAndVentilationInternal Exception: " + e);
        }
    }

    public void setT1PSeatHeatAndVentilation(int i, int i2) {
        Log.i(TAG, "setT1PSeatHeatAndVentilation v1 = " + i + " v2 = " + i2);
        setT1PSeatHeatAndVentilationInternal(i, i2);
    }

    private String getCurrentProject() {
        String str = null;
        try {
            str = SystemProperties.get("ro.product.build.chery.project", "");
            Log.e(TAG, "getCurrentProject project = " + str);
            return str;
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e);
            return str;
        }
    }

    private static void modifyTAG(Context context) {
        String packageName;
        if (PROJECT_T1L.equals(currentProject) && context != null && (packageName = context.getPackageName()) != null && packageName.length() > 0) {
            String[] split = packageName.split("\\.");
            if (split.length >= 2) {
                TAG += "." + split[split.length - 2] + "." + split[split.length - 1];
            } else if (split.length == 1) {
                TAG += "." + split[0];
            }
        }
    }

    public void setGroupPropertyForAllExtLight(int i, int i2, int i3) {
        Log.i(TAG, "setGroupPropertyForExtLight arg0 = " + i + " arg1 = " + i2 + " arg2 = " + i3);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHU14SUB1(i, i2, i3);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForExtLight Exception: " + e);
        }
    }

    public void setGroupPropertyForControlAndRearFogLight(int i, int i2) {
        Log.i(TAG, "setGroupPropertyForControlAndREARFOGLight arg0 = " + i + " arg1 = " + i2);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHU14SUB2(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForControlAndREARFOGLight Exception: " + e);
        }
    }

    public void setGroupPropertyForControlAndFrontFogLight(int i, int i2) {
        Log.i(TAG, "setGroupPropertyForControlAndFrontFogLight arg0 = " + i + " arg1 = " + i2);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHU14SUB3(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForControlAndFrontFogLight Exception: " + e);
        }
    }

    public void setGroupPropertyForRearlAndFrontFogLight(int i, int i2) {
        Log.i(TAG, "setGroupPropertyForRearlAndFrontFogLight arg0 = " + i + " arg1 = " + i2);
        IALCar iALCar = this.mService;
        if (iALCar == null) {
            Log.e(TAG, "mService is null");
            return;
        }
        try {
            iALCar.setGroupPropertyForIHU14SUB4(i, i2);
        } catch (RemoteException e) {
            Log.e(TAG, "setGroupPropertyForRearlAndFrontFogLight Exception: " + e);
        }
    }
}
