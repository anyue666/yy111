package com.autolink.hmi.crosscountry;

import android.app.Application;
import android.content.Intent;
import com.autolink.hmi.crosscountry.server.CrossService;
import com.autolink.hmi.crosscountry.utils.BuryServiceUtils;
import com.autolink.hmi.crosscountry.utils.CarSettingController;
import com.autolink.hmi.crosscountry.utils.LogUtils;

/* loaded from: classes.dex */
public class CrossApplication extends Application {
    public static CrossApplication sInstance;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        startCrossBackgroundService();
        BuryServiceUtils.getInstance().init();
        CarSettingController.getInstance().init();
    }

    public void startCrossBackgroundService() {
        LogUtils.logI("CrossApplication", "start  CrossService");
        startService(new Intent(getApplicationContext(), (Class<?>) CrossService.class));
    }
}
