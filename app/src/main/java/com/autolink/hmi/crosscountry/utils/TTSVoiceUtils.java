package com.autolink.hmi.crosscountry.utils;

import android.os.RemoteException;
import com.autolink.hmi.crosscountry.CrossApplication;
import com.autolink.voicemanager.ConnectStatus;
import com.autolink.voicemanager.VoiceManager;
import com.autolink.voicetts.IStatusCallBack;

/* loaded from: classes.dex */
public class TTSVoiceUtils {
    private static String TAG = "TTSVoiceUtils";
    private static volatile TTSVoiceUtils uniqueSingleton;
    private VoiceManager mVoiceManager;

    private TTSVoiceUtils() {
    }

    public static TTSVoiceUtils getInstance() {
        if (uniqueSingleton == null) {
            synchronized (TTSVoiceUtils.class) {
                if (uniqueSingleton == null) {
                    uniqueSingleton = new TTSVoiceUtils();
                }
            }
        }
        return uniqueSingleton;
    }

    public void init() {
        new Thread(new Runnable() { // from class: com.autolink.hmi.crosscountry.utils.TTSVoiceUtils.1
            @Override // java.lang.Runnable
            public void run() {
                TTSVoiceUtils.this.mVoiceManager = VoiceManager.getInstance(CrossApplication.sInstance);
                TTSVoiceUtils.this.mVoiceManager.init(new ConnectStatus() { // from class: com.autolink.hmi.crosscountry.utils.TTSVoiceUtils.1.1
                    @Override // com.autolink.voicemanager.ConnectStatus
                    public void connected() {
                        LogUtils.logI(TTSVoiceUtils.TAG, "VoiceManager is connected");
                    }

                    @Override // com.autolink.voicemanager.ConnectStatus
                    public void disconnected() {
                        LogUtils.logI(TTSVoiceUtils.TAG, "VoiceManager is disconnected");
                    }
                });
            }
        }).start();
    }

    public void startSpeak(String str, IStatusCallBack iStatusCallBack) {
        if (this.mVoiceManager == null) {
            init();
        }
        VoiceManager voiceManager = this.mVoiceManager;
        if (voiceManager != null) {
            voiceManager.startSpeak("common_001", str, new IStatusCallBack.Stub() { // from class: com.autolink.hmi.crosscountry.utils.TTSVoiceUtils.2
                @Override // com.autolink.voicetts.IStatusCallBack
                public void onStatusChange(String str2, int i) throws RemoteException {
                    LogUtils.logI(TTSVoiceUtils.TAG, "VoiceManager onStatusChange " + str2);
                }

                @Override // com.autolink.voicetts.IStatusCallBack
                public void onVoiceIdCreate(String str2) throws RemoteException {
                    LogUtils.logI(TTSVoiceUtils.TAG, "VoiceManager onVoiceIdCreate " + str2);
                }
            }, "");
        }
    }
}
