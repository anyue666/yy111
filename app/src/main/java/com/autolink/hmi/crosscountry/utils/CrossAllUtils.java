package com.autolink.hmi.crosscountry.utils;

import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.autolink.hmi.crosscountry.CrossApplication;
import com.autolink.hmi.crosscountry.ICrossService;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.crossinterface.CrossSensorEventListener;

/* loaded from: classes.dex */
public class CrossAllUtils {
    public static int DRIVER_MODE_ECO = 0;
    public static int DRIVER_MODE_INVALD = 8;
    public static int DRIVER_MODE_MUD = 4;
    public static int DRIVER_MODE_NORMAL = 1;
    public static int DRIVER_MODE_ROCK = 5;
    public static int DRIVER_MODE_SAND = 7;
    public static int DRIVER_MODE_SNOW = 3;
    public static int DRIVER_MODE_SPORT = 2;
    public static int DRIVER_MODE_X = 9;
    public static final String DRIVE_TYPE_KEY = "persist.vendor.oem.cfg.cc.icm.drive.type";
    private static final double EARTH_RADIUS = 6378.137d;
    public static String ENGINE_KEY = "persist.vendor.oem.cfg.cc.ihu.engine.type";
    public static final int FIVE_SEATER_PHEV_FOURWHEEL = 2;
    public static String LAST_ANGLE_INCLINATION = null;
    public static String LAST_ROLL_ANGEL = null;
    public static String POWER_KEY = "persist.vendor.oem.cfg.cc.ihu.power.type";
    public static final String SEAT_NUMBERS_KEY = "persist.vendor.oem.cfg.cc.ihu.number.of.sitting.positions";
    public static final String SECOND_SEAT_KEY = "persist.vendor.oem.cfg.cc.ihu.number.of.seating.rows.second.row";
    public static final int SEVEN_SEATER_FUEL = 3;
    public static final int SEVEN_SEATER_PHEV_FOURWHEEL = 1;
    public static String SKYLIGHT_KEY = "persist.vendor.oem.cfg.cc.ihu.wade.radar";
    private static String TAG = "CrossAllUtils";
    public static final String THIRD_SEAT_KEY = "persist.vendor.oem.cfg.cc.ihu.number.of.seating.rows.third.row";
    public static String WATER_KEY = "persist.vendor.oem.cfg.cc.ihu.wade.radar";
    private static volatile CrossAllUtils uniqueSingleton;
    private CrossSensorEventListener mCrossEventListener;
    SharedPreferences mSp;

    public void setCrossService(ICrossService iCrossService) {
    }

    public CrossAllUtils(SharedPreferences sharedPreferences) {
        this.mSp = sharedPreferences;
    }

    public void startLocationSensorOnce() {
        if (ActivityCompat.checkSelfPermission(CrossApplication.sInstance, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        LocationManager locationManager = (LocationManager) CrossApplication.sInstance.getSystemService(LocationManager.class);
        insureGPSisOpen(locationManager);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        Log.i(TAG, " bestProvider " + bestProvider);
        locationManager.requestLocationUpdates(bestProvider, 3000L, 0.0f, new LocationListener() { // from class: com.autolink.hmi.crosscountry.utils.CrossAllUtils.1
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location == null) {
                    Log.i(CrossAllUtils.TAG, "Location is null");
                    return;
                }
                Log.i(CrossAllUtils.TAG, "getAltitude " + location.getAltitude() + " 高度方向 getBearing " + location.getBearing());
                if (location.hasBearing() && CrossAllUtils.this.mSp != null) {
                    float bearing = 360.0f - location.getBearing();
                    CrossAllUtils.this.mSp.edit().putFloat("compassDial", bearing).commit();
                    LogUtils.logI(CrossAllUtils.TAG, "gps 方向后台更新 " + bearing);
                }
                if (CrossAllUtils.this.mCrossEventListener != null) {
                    CrossAllUtils.this.mCrossEventListener.onAltitude((float) location.getAltitude());
                    LogUtils.logI(CrossAllUtils.TAG, "location.getBearing() " + location.getBearing() + " hasBearing " + location.hasBearing());
                    if (location.hasBearing()) {
                        LogUtils.logI(CrossAllUtils.TAG, "location.getBearing() hasBearing is true " + location.getBearing());
                        CrossAllUtils.this.mCrossEventListener.onCompass(location.getBearing());
                        LogUtils.logI(CrossAllUtils.TAG, "gps 方向后台更新 刷新前台");
                    }
                }
            }
        });
        locationManager.registerGnssStatusCallback(new GnssStatus.Callback() { // from class: com.autolink.hmi.crosscountry.utils.CrossAllUtils.2
            @Override // android.location.GnssStatus.Callback
            public void onStarted() {
                super.onStarted();
            }

            @Override // android.location.GnssStatus.Callback
            public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
                super.onSatelliteStatusChanged(gnssStatus);
                Log.i(CrossAllUtils.TAG, gnssStatus.getSatelliteCount() + "satellite number ");
            }
        });
    }

    void insureGPSisOpen(LocationManager locationManager) {
        if (locationManager.getProvider("gps") == null) {
            LogUtils.logI(TAG, "Provider GPS_PROVIDER is null");
        }
        if (!locationManager.isProviderEnabled("gps")) {
            LogUtils.logI(TAG, "GPS no open");
        } else {
            LogUtils.logI(TAG, "GPS is open");
        }
    }

    public void setCrossSensorEventListener(CrossSensorEventListener crossSensorEventListener) {
        this.mCrossEventListener = crossSensorEventListener;
    }

    public void clearSensorManager() {
        this.mCrossEventListener = null;
    }

    public static int getSteerModeImg(int i) {
        LogUtils.logI("getSteerModeImg", i + "");
        if (i == DRIVER_MODE_INVALD) {
            LogUtils.logI("SteerMode", "模式切换失败进入标准模式");
            i = R.drawable.normal;
        }
        return i == DRIVER_MODE_ECO ? R.drawable.eco : i == DRIVER_MODE_NORMAL ? R.drawable.normal : i == DRIVER_MODE_ROCK ? R.drawable.rock : i == DRIVER_MODE_SNOW ? R.drawable.snow : i == DRIVER_MODE_SPORT ? R.drawable.sport : i == DRIVER_MODE_X ? R.drawable.x : i == DRIVER_MODE_MUD ? R.drawable.mud : i == DRIVER_MODE_SAND ? R.drawable.sand : R.drawable.normal;
    }

    public static String getSteerModeName(int i) {
        LogUtils.logI("SteerMode", i + "");
        if (i == DRIVER_MODE_INVALD) {
            LogUtils.logI("SteerMode", "模式切换失败进入标准模式");
            i = DRIVER_MODE_NORMAL;
        }
        if (i == DRIVER_MODE_X) {
            return CrossApplication.sInstance.getString(R.string.x_model);
        }
        if (i == DRIVER_MODE_ECO) {
            return CrossApplication.sInstance.getString(R.string.economic_model);
        }
        if (i == DRIVER_MODE_NORMAL) {
            return CrossApplication.sInstance.getString(R.string.standard_mode);
        }
        if (i == DRIVER_MODE_ROCK) {
            return CrossApplication.sInstance.getString(R.string.rock_model);
        }
        if (i == DRIVER_MODE_SNOW) {
            return CrossApplication.sInstance.getString(R.string.snow_pattern);
        }
        if (i == DRIVER_MODE_SPORT) {
            return CrossApplication.sInstance.getString(R.string.motion_pattern);
        }
        if (i == DRIVER_MODE_MUD) {
            return CrossApplication.sInstance.getString(R.string.muddy_mode);
        }
        return i == DRIVER_MODE_SAND ? CrossApplication.sInstance.getString(R.string.sand_pattern) : "";
    }

    public static String getProperty(String str) {
        String property = ReflectUtil.getProperty(str, "0");
        LogUtils.logI("getSupportWade", "" + property);
        return property;
    }

    public static boolean isDriveTypeFour() {
        String str = SystemProperties.get(DRIVE_TYPE_KEY);
        LogUtils.logI("isDriveTypeFour", "isDriveTypeFour:DRIVE_TYPE_KEY=persist.vendor.oem.cfg.cc.icm.drive.type value= " + str);
        return !TextUtils.isEmpty(str) && str.equals("1");
    }

    public static boolean isSevenSeat() {
        if (("2".equals(SystemProperties.get(THIRD_SEAT_KEY)) && "0".equals(SystemProperties.get(SECOND_SEAT_KEY))) || ("1".equals(SystemProperties.get(THIRD_SEAT_KEY)) && "1".equals(SystemProperties.get(SECOND_SEAT_KEY)))) {
            LogUtils.logI("NumSeatUtil", "seven_seat_carmodel");
            return true;
        }
        if ("0".equals(SystemProperties.get(THIRD_SEAT_KEY)) && "1".equals(SystemProperties.get(SECOND_SEAT_KEY))) {
            LogUtils.logI("NumSeatUtil", "five_seat_carmodel");
        }
        return false;
    }
}
