package com.autolink.hmi.crosscountry.utils.networkutils;

import android.text.TextUtils;
import android.util.Log;
import com.autolink.hmi.crosscountry.CrossApplication;
import com.autolink.hmi.crosscountry.bean.CrossLocationBean;
import com.autolink.hmi.crosscountry.bean.IWeather;
import com.autolink.hmi.crosscountry.crossinterface.CrossPressureListener;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils;
import com.autonavi.amapauto.jsonsdk.IJsonProtocolReceive;
import com.autonavi.amapauto.jsonsdk.JsonProtocolManager;
import com.autonavi.amapauto.jsonsdk.ProtocolID;
import com.google.gson.Gson;
import java.util.HashMap;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AtmosphericUtils {
    public static String TAG = "AtmosphericUtils";
    private static AtmosphericUtils instance;
    private static JsonProtocolManager mJsonProtocolManager;
    private CrossPressureListener mCrossPressureListener;
    private String location = "";
    private IJsonProtocolReceive jsonProtocolReceive = new IJsonProtocolReceive() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.AtmosphericUtils.1
        @Override // com.autonavi.amapauto.jsonsdk.IJsonProtocolReceive
        public String receivedSync(String str) {
            return null;
        }

        @Override // com.autonavi.amapauto.jsonsdk.IJsonProtocolReceive
        public void received(String str) {
            if (TextUtils.isEmpty(str)) {
                Log.e(AtmosphericUtils.TAG, "空数据！！！！！！！！！！！！！！！！！");
                return;
            }
            try {
                String optString = new JSONObject(str).optString("protocolId");
                LogUtils.logI("高德key ", optString + "  ");
                if (optString.equals("30002")) {
                    CrossLocationBean crossLocationBean = (CrossLocationBean) new Gson().fromJson(str, CrossLocationBean.class);
                    Log.i(AtmosphericUtils.TAG, "当前定位信息 : " + str);
                    int resultCode = crossLocationBean.getData().getResultCode();
                    if (resultCode == 10000) {
                        String cityName = crossLocationBean.getData().getCityName();
                        String districtName = crossLocationBean.getData().getDistrictName();
                        if (!AtmosphericUtils.this.location.equals(districtName)) {
                            Log.w(AtmosphericUtils.TAG, "定位从 " + AtmosphericUtils.this.location + " 变更为: " + districtName);
                            AtmosphericUtils.this.location = cityName + districtName;
                        } else {
                            Log.w(AtmosphericUtils.TAG, "定位没变!!!");
                        }
                        Log.e(AtmosphericUtils.TAG, " location " + AtmosphericUtils.this.location);
                        if (AtmosphericUtils.this.location == null || AtmosphericUtils.this.location.equals("")) {
                            return;
                        }
                        AtmosphericUtils.this.getPressure();
                        return;
                    }
                    Log.e(AtmosphericUtils.TAG, "resultCode  =  " + resultCode + "-------" + crossLocationBean.getData().getErrorMessage());
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static AtmosphericUtils getInstance() {
        if (instance == null) {
            synchronized (AtmosphericUtils.class) {
                if (instance == null) {
                    instance = new AtmosphericUtils();
                }
            }
        }
        return instance;
    }

    public void init() {
        JsonProtocolManager jsonProtocolManager = JsonProtocolManager.getInstance();
        mJsonProtocolManager = jsonProtocolManager;
        jsonProtocolManager.init(CrossApplication.sInstance, new JsonProtocolManager.OnInitListener() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.AtmosphericUtils.2
            @Override // com.autonavi.amapauto.jsonsdk.JsonProtocolManager.OnInitListener
            public void onInit() {
                Log.w(AtmosphericUtils.TAG, "onInit: SUCCESS！！！！！！");
            }
        });
        JsonProtocolManager.getInstance().setJsonProtocolReceive(this.jsonProtocolReceive);
    }

    private void getMyLocation() {
        Log.i(TAG, "getMyLocation :  =====================> start");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 1);
            jSONObject.put("data", jSONObject2);
            jSONObject.put("protocolId", ProtocolID.PROTOCOL_SHOW_MY_LOCATION);
            jSONObject.put("versionName", "v_20200320");
            jSONObject.put("requestAuthor", CrossApplication.sInstance.getApplicationContext().getPackageName());
            jSONObject.put("messageType", "request");
            jSONObject.put("statusCode", 0);
            jSONObject.put("message", "");
            jSONObject.put("requestCode", "1");
            jSONObject.put("responseCode", "1");
            jSONObject.put("needResponse", true);
        } catch (JSONException e) {
            Log.e("request", e.getMessage(), e);
        }
        JsonProtocolManager.getInstance().request(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPressure() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put(Constant.MY_LOCATION, this.location);
        hashMap.put("appId", Constant.APPID);
        hashMap.put("vin", Constant.VIN);
        Log.w(TAG, "postCurrent: vin = " + Constant.VIN);
        hashMap.put("uuid", Constant.UUID);
        hashMap.put("altitude", "");
        Log.w(TAG, "postCurrent: UUID = " + Constant.UUID);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("Accenpt", "application/json");
        RetrofitUtils.getHttpUtils(Constant.HOST_ADDRESS).doPost("autosee-weather-service/weather/anon/current", RequestBody.create(Constant.FORM_CONTENT_TYPE, new Gson().toJson(hashMap).toString()), hashMap2, new RetrofitUtils.CallBack<IWeather>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.AtmosphericUtils.3
            @Override // com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.CallBack
            public void onSuccess(IWeather iWeather) {
                try {
                    if (AtmosphericUtils.this.mCrossPressureListener != null && iWeather != null) {
                        if (iWeather.getCode().intValue() == 200) {
                            AtmosphericUtils.this.mCrossPressureListener.onPressure(iWeather.getData().getNow().getPressure());
                        }
                        Log.i(AtmosphericUtils.TAG, "postCurrent Success");
                        return;
                    }
                    Log.i(AtmosphericUtils.TAG, " bean is null");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(AtmosphericUtils.TAG, "城市查询错误 location " + AtmosphericUtils.this.location);
                }
            }

            @Override // com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.CallBack
            public void onError(String str) {
                Log.e(AtmosphericUtils.TAG, str);
            }
        });
    }

    public void getAcquiredPressure(CrossPressureListener crossPressureListener) {
        this.mCrossPressureListener = crossPressureListener;
        if (mJsonProtocolManager == null) {
            init();
        }
        getMyLocation();
    }
}
