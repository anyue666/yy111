package com.autolink.adaptermanager;

import android.content.Context;
import com.autolink.adaptermanager.IALManager;
import com.autolink.adaptermanager.audio.ALAudioManager;
import com.autolink.adaptermanager.car.ALCarManager;
import com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager;
import com.autolink.adaptermanager.clusterinteraction.ALDmsManager;
import com.autolink.adaptermanager.clusterinteraction.ALOmsManager;
import com.autolink.adaptermanager.configuration.ALConfigurationManager;
import com.autolink.adaptermanager.diag.ALDiagManager;
import com.autolink.adaptermanager.hardkey.ALHardKeyManager;
import com.autolink.adaptermanager.misc.ALMiscManager;
import com.autolink.adaptermanager.multiwindow.ALMultiWindowManager;
import com.autolink.adaptermanager.power.ALPowerManager;
import com.autolink.adaptermanager.tbox2.TboxManager;
import com.autolink.adaptermanager.upgrade.ALUpdateManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ALManagerFactory {
    public static final String AUDIO_SERVICE = "audio";
    public static final String CAR_SERVICE = "car";
    public static final String CI_SERVICE = "cluster_interaction";
    public static final String CONFIGURATION_SERVICE = "configuration";
    public static final String DIAG_SERVICE = "Diag";
    public static final String DMS_SERVICE = "dms";
    public static final String HARDKEY_SERVICE = "hardkey";
    public static final String MISC_SERVICE = "misc";
    public static final String MULTI_WINDOW_SERVICE = "multi_window";
    public static final String OMS_SERVICE = "oms";
    public static final String POWER_SERVICE = "power";
    private static final String TAG = "ALManagerFactory";
    public static final String TBOX2_SERVICE = "tbox2";
    public static final String UPDATE_SERVICE = "update";
    private static final Object mLock = new Object();
    private static final HashMap<String, IALManager> mServiceMap = new HashMap<>();
    private static volatile ALManagerFactory sInstance;
    private Context mContext;

    public void init(Context context) {
    }

    public static synchronized ALManagerFactory getInstance(Context context) {
        ALManagerFactory aLManagerFactory;
        synchronized (ALManagerFactory.class) {
            if (sInstance == null) {
                sInstance = new ALManagerFactory(context);
            }
            aLManagerFactory = sInstance;
        }
        return aLManagerFactory;
    }

    private ALManagerFactory(Context context) {
        ALLog.i(TAG, Version.getVersionCode());
        this.mContext = context;
    }

    @Deprecated
    public IALManager getManager(String str) {
        synchronized (mLock) {
            HashMap<String, IALManager> hashMap = mServiceMap;
            IALManager iALManager = hashMap.get(str);
            if (iALManager == null) {
                iALManager = createManager(str, this.mContext, null);
                if (iALManager == null) {
                    ALLog.i(TAG, "could not create manager for service:" + str);
                    return null;
                }
                hashMap.put(str, iALManager);
            }
            return iALManager;
        }
    }

    @Deprecated
    public IALManager getManager(String str, IALManager.ServiceConnectionListener serviceConnectionListener) {
        synchronized (mLock) {
            HashMap<String, IALManager> hashMap = mServiceMap;
            IALManager iALManager = hashMap.get(str);
            if (iALManager == null) {
                iALManager = createManager(str, this.mContext, serviceConnectionListener);
                if (iALManager == null) {
                    ALLog.i(TAG, "could not create manager for service:" + str);
                    return null;
                }
                hashMap.put(str, iALManager);
            }
            return iALManager;
        }
    }

    public IALManager getManager(String str, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        IALManager createManager = createManager(str, serviceConnectionListenerNew);
        if (createManager != null) {
            return createManager;
        }
        ALLog.e(TAG, "could not create manager for service:" + str);
        return null;
    }

    private IALManager createManager(String str, Context context, IALManager.ServiceConnectionListener serviceConnectionListener) {
        str.hashCode();
        switch (str) {
            case "multi_window":
                return new ALMultiWindowManager(context, serviceConnectionListener);
            case "update":
                return new ALUpdateManager(context);
            case "cluster_interaction":
                return new ALClusterInteractionManager(context, serviceConnectionListener);
            case "car":
                return ALCarManager.createCar(context);
            case "dms":
                return new ALDmsManager(context);
            case "oms":
                return new ALOmsManager(context);
            case "misc":
                return ALMiscManager.createMisc(context);
            case "audio":
                return ALAudioManager.createAudio(context);
            case "power":
                return new ALPowerManager(context, serviceConnectionListener);
            case "tbox2":
                return TboxManager.createTbox(context);
            case "hardkey":
                return new ALHardKeyManager(context);
            default:
                return null;
        }
    }

    private IALManager createManager(String str, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        str.hashCode();
        switch (str) {
            case "multi_window":
                return new ALMultiWindowManager(this.mContext, serviceConnectionListenerNew);
            case "update":
                return new ALUpdateManager(this.mContext, serviceConnectionListenerNew);
            case "cluster_interaction":
                return new ALClusterInteractionManager(this.mContext, serviceConnectionListenerNew);
            case "car":
                return ALCarManager.createCar(this.mContext, serviceConnectionListenerNew);
            case "dms":
                return new ALDmsManager(this.mContext, serviceConnectionListenerNew);
            case "oms":
                return new ALOmsManager(this.mContext, serviceConnectionListenerNew);
            case "Diag":
                return new ALDiagManager(this.mContext, serviceConnectionListenerNew);
            case "misc":
                return ALMiscManager.createMisc(this.mContext, serviceConnectionListenerNew);
            case "audio":
                return ALAudioManager.createAudio(this.mContext, serviceConnectionListenerNew);
            case "power":
                return new ALPowerManager(this.mContext, serviceConnectionListenerNew);
            case "tbox2":
                return TboxManager.createTbox(this.mContext, serviceConnectionListenerNew);
            case "hardkey":
                return new ALHardKeyManager(this.mContext, serviceConnectionListenerNew);
            case "configuration":
                return new ALConfigurationManager(this.mContext, serviceConnectionListenerNew);
            default:
                return null;
        }
    }
}
