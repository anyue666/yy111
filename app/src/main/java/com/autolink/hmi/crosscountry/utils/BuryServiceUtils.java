package com.autolink.hmi.crosscountry.utils;

import com.autolink.buryservice.BuryServiceManager;
import com.autolink.buryservice.bury.consts.BuryEventConst;
import com.autolink.hmi.crosscountry.CrossApplication;

/* loaded from: classes.dex */
public class BuryServiceUtils {
    private static volatile BuryServiceUtils INSTANCE;
    private BuryServiceManager mBuryServiceManager;

    private BuryServiceUtils() {
    }

    public static BuryServiceUtils getInstance() {
        if (INSTANCE == null) {
            synchronized (BuryServiceUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BuryServiceUtils();
                }
            }
        }
        return INSTANCE;
    }

    public void setBurialPointAppOpen() {
        BuryServiceManager buryServiceManager = this.mBuryServiceManager;
        if (buryServiceManager != null) {
            buryServiceManager.appListCommonBury(BuryEventConst.CH_BI_Event_APPList_Xmode_Open, null, 0, CrossApplication.sInstance.getPackageName());
        }
    }

    public void setBurialPointAppQuit() {
        BuryServiceManager buryServiceManager = this.mBuryServiceManager;
        if (buryServiceManager != null) {
            buryServiceManager.appListCommonBury(BuryEventConst.CH_BI_Event_APPList_Xmode_Quit, null, 0, CrossApplication.sInstance.getPackageName());
        }
    }

    public void setBurialPointAppOptions(String str, String str2) {
        if (this.mBuryServiceManager != null) {
            LogUtils.logI("BuryServiceUtils", "setBurialPointAppOptions key " + str + " value " + str2);
            this.mBuryServiceManager.appListXmodeBury(BuryEventConst.CH_BI_Event_APPList_Xmode_Options, str, str2);
        } else {
            LogUtils.logI("BuryServiceUtils", "mBuryServiceManager is null ");
        }
    }

    public void init() {
        new Thread(new Runnable() { // from class: com.autolink.hmi.crosscountry.utils.BuryServiceUtils.1
            @Override // java.lang.Runnable
            public void run() {
                LogUtils.logI("BuryServiceUtils", "init BuryServiceManager");
                BuryServiceUtils.this.mBuryServiceManager = BuryServiceManager.getInstance();
            }
        }).start();
    }
}
