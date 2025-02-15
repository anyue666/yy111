package com.autolink.hmi.crosscountry.utils.networkutils;

import com.autolink.carsetting.data.car.VoiceContact;
import com.autolink.hmi.crosscountry.utils.ReflectUtil;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;

/* loaded from: classes.dex */
public class Constant {
    public static final String AIR = "air";
    public static final String APPID = "34a44d12ffcf44749d881a68ccaecb49";
    public static final String CURRENT = "current";
    public static final String CURRENT2 = "current2";
    public static final int GAODE_TASK_PERIOD = 600000;
    public static final String HOST_ADDRESS = "https://api.auto-link.com.cn/api/";
    public static final String HOURS_DATA = "hours";
    public static final String MY_LOCATION = "location";
    public static final String NEXT_DAYS = "nextDays";
    public static final String SP_FILE_NAME = "com.autolink.weather";
    public static final String SUGGESTION = "suggestion";
    public static final int WEATHER_TASK_DELAY = 10800000;
    public static final int WEATHER_TASK_PERIOD = 10800000;
    public Map<String, String> map = new HashMap();
    public static final String VIN = ReflectUtil.getProperty("persist.vendor.bosch.cfg.diag.vin", "null");
    public static final String UUID = ReflectUtil.getProperty("persist.vendor.bosch.cfg.diag.sn", "null");
    public static final MediaType FORM_CONTENT_TYPE = MediaType.parse("application/json; charset=utf-8");

    public Constant() {
        HashMap hashMap = new HashMap();
        hashMap.put("AirConditionerIndex", "ac");
        hashMap.put("AllergyIndex", "allergy");
        hashMap.put("AnglingIndex", "fishing");
        hashMap.put("AQIIndex", "air_pollution");
        hashMap.put("BoatingIndex", "boating");
        hashMap.put("CarWashingIndex", "car_washing");
        hashMap.put("ColdRiskIndex", "flu");
        hashMap.put("ComfortIndex", "comfort");
        hashMap.put("DatingIndex", "dating");
        hashMap.put("DressingIndex", "dressing");
        hashMap.put("DrinkingIndex", "beer");
        hashMap.put("DryingIndex", "airing");
        hashMap.put("HairdressingIndex", "hair_dressing");
        hashMap.put("HeatstrokeIndex", "sunscreen");
        hashMap.put("KiteIndex", "kiteflying");
        hashMap.put("MakeUpIndex", "makeup");
        hashMap.put("MoodIndex", "mood");
        hashMap.put("MorningExerciseIndex", "morning_sport");
        hashMap.put("NightLifeIndex", "night_life");
        hashMap.put("RainGearIndex", "umbrella");
        hashMap.put("RoadConditionIndex", "road_condition");
        hashMap.put("ShoppingIndex", "shopping");
        hashMap.put("SportIndex", "sport");
        hashMap.put("TrafficIndex", "traffic");
        hashMap.put("TravelIndex", "travel");
        hashMap.put("UltravioletIndex", "uv");
        hashMap.put("WashClothesIndex", "");
        hashMap.put("WindColdIndex", "chill");
        hashMap.put("CLEAR_DAY", "0");
        hashMap.put("CLEAR_NIGHT", "1");
        hashMap.put("PARTLY_CLOUDY_DAY", "50");
        hashMap.put("PARTLY_CLOUDY_NIGHT", "51");
        hashMap.put("CLOUDY", "9");
        hashMap.put("LIGHT_HAZE", "52");
        hashMap.put("MODERATE_HAZE", "53");
        hashMap.put("HEAVY_HAZE", "54");
        hashMap.put("LIGHT_RAIN", "13");
        hashMap.put("MODERATE_RAIN", "14");
        hashMap.put("HEAVY_RAIN", VoiceContact.SUSTAIN_WAIT_TIME_15);
        hashMap.put("STORM_RAIN", "16");
        hashMap.put("FOG", VoiceContact.SUSTAIN_WAIT_TIME_30);
        hashMap.put("LIGHT_SNOW", "22");
        hashMap.put("MODERATE_SNOW", "23");
        hashMap.put("HEAVY_SNOW", "24");
        hashMap.put("STORM_SNOW", "25");
        hashMap.put("DUST", "26");
        hashMap.put("SAND", "28");
        hashMap.put("WIND", "33");
    }
}
