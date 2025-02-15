package com.autolink.hmi.crosscountry.utils;

import android.util.Log;
import com.autolink.car.client.CarSettingManager;
import com.autolink.car.client.IConnectCallback;
import com.autolink.hmi.crosscountry.CrossApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CarSettingController {
    private static CarSettingController instance;
    private final String TAG = "CarSettingController";
    private boolean isConnected = false;
    private CarSettingManager.ResultCallback resultCallback = null;
    public ArrayList<CarSettingManager.ResultCallback> callbacks = new ArrayList<>();

    public static CarSettingController getInstance() {
        if (instance == null) {
            synchronized (CarSettingController.class) {
                if (instance == null) {
                    instance = new CarSettingController();
                }
            }
        }
        return instance;
    }

    public void setResultCallback(CarSettingManager.ResultCallback resultCallback) {
        if (resultCallback != null) {
            this.callbacks.add(resultCallback);
        }
    }

    public void init() {
        CarSettingManager.getInstance().init(CrossApplication.sInstance, new IConnectCallback() { // from class: com.autolink.hmi.crosscountry.utils.CarSettingController$$ExternalSyntheticLambda0
            @Override // com.autolink.car.client.IConnectCallback
            public final void onConnect(boolean z) {
                CarSettingController.this.m70x125c34b5(z);
            }
        });
        this.resultCallback = new CarSettingManager.ResultCallback() { // from class: com.autolink.hmi.crosscountry.utils.CarSettingController$$ExternalSyntheticLambda1
            @Override // com.autolink.car.client.CarSettingManager.ResultCallback
            public final void onResult(String str, String str2) {
                CarSettingController.this.m71x9f494bd4(str, str2);
            }
        };
        CarSettingManager.getInstance().register(this.resultCallback);
    }

    /* renamed from: lambda$init$0$com-autolink-hmi-crosscountry-utils-CarSettingController, reason: not valid java name */
    /* synthetic */ void m70x125c34b5(boolean z) {
        Log.d("CarSettingController", "onConnect:" + z);
        this.isConnected = z;
    }

    /* renamed from: lambda$init$1$com-autolink-hmi-crosscountry-utils-CarSettingController, reason: not valid java name */
    /* synthetic */ void m71x9f494bd4(String str, String str2) {
        Log.d("CarSettingController", "onResult: key=" + str + " value= " + str2);
        ArrayList<CarSettingManager.ResultCallback> arrayList = this.callbacks;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<CarSettingManager.ResultCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onResult(str, str2);
        }
    }

    public void release() {
        this.callbacks.clear();
    }

    public void setSettingsProperty(String str, String str2) {
        CarSettingManager.getInstance().set(str, str2);
        Log.d("CarSettingController", "setSettingsProperty:key= " + str + " value= " + str2 + "isConnect = " + this.isConnected);
    }

    public String getSettingsProperty(String str) {
        String str2 = CarSettingManager.getInstance().get(str);
        Log.d("CarSettingController", "getSettingsProperty:key=" + str + " value= " + str2 + "isConnect = " + this.isConnected);
        return str2;
    }
}
