package com.autolink.adaptermanager.audio;

import android.car.Car;
import android.car.media.CarAudioManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioPatch;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.autolink.adapterinterface.audio.IALAudio;
import com.autolink.adapterinterface.audio.IRhythmLampListener;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ALAudioManager extends ALBaseManager implements IALManager {
    public static final String ALAUDIO_SERVICE_BINDER_SERVICE_NAME = "alaudio_service";
    private static final String ALAUDIO_SERVICE_INTERFACE_NAME = "android.autolink.IAutoLinkAudio";
    private static final String ALAUDIO_SERVICE_PACKAGE = "com.autolink.audioservice";
    private static final long AUDIO_SERVICE_BINDER_POLLING_INTERVAL_MS = 50;
    private static final long AUDIO_SERVICE_BINDER_POLLING_MAX_RETRY = 100;
    private static final long AUDIO_SERVICE_BIND_MAX_RETRY = 20;
    private static final long AUDIO_SERVICE_BIND_RETRY_INTERVAL_MS = 500;
    public static final int DTS_FIELD_MODE_DRIVER = 1;
    public static final int DTS_FIELD_MODE_PASSENGER = 0;
    public static final int DTS_MODE_BASS = 2;
    public static final int DTS_MODE_LEISURE = 3;
    public static final int DTS_MODE_NATURAL = 0;
    public static final int DTS_MODE_VOCAL = 1;
    public static final int EFFECT_MODE_DTS = 1;
    public static final int EFFECT_MODE_EQUALIZER = 0;
    public static final int EFFECT_MODE_SONY = 2;
    public static final int EQ_BAND_BASS = 0;
    public static final int EQ_BAND_MIDDLE = 1;
    public static final int EQ_BAND_TREBLE = 2;
    public static final int EQ_MODE_CLASSIC = 3;
    public static final int EQ_MODE_CUSTOM = 0;
    public static final int EQ_MODE_JAZZ = 2;
    public static final int EQ_MODE_POP = 1;
    public static final int EQ_MODE_ROCK = 4;
    public static final int EQ_MODE_VOCAL = 5;
    public static final int RHYTHM_SPEED_100MS = 0;
    public static final int RHYTHM_SPEED_200MS = 1;
    public static final int RHYTHM_SPEED_300MS = 2;
    public static final int RHYTHM_SPEED_400MS = 3;
    public static final int RHYTHM_SPEED_600MS = 4;
    public static final int RHYTHM_SPEED_800MS = 5;
    public static final int SOUND_FIELD_BABY = 1;
    public static final int SOUND_FIELD_BOSS = 6;
    public static final int SOUND_FIELD_CUSTOM = 0;
    public static final int SOUND_FIELD_DRIVER = 2;
    public static final int SOUND_FIELD_FRONT_SEAT = 4;
    public static final int SOUND_FIELD_PASSENGER = 3;
    public static final int SOUND_FIELD_REAR_SEAT = 5;
    public static final int SPEED_VOLUME_HIGH = 3;
    public static final int SPEED_VOLUME_LOW = 1;
    public static final int SPEED_VOLUME_MID = 2;
    public static final int SPEED_VOLUME_OFF = 0;
    public static final int SYSTEM_FACTOR_OTA = 1;
    public static final int SYSTEM_FACTOR_POWER = 0;
    private static final String TAG = "ALAudioManager";
    private final CopyOnWriteArrayList<IAudioEffectCallback> mAudioEffectCallbacks;
    private final AudioManager mAudioManager;
    private AudioPatch mAudioPatch;
    private Car mCar;
    private final CarAudioManager mCarAudioManager;
    private int mConnectionState;
    private CustomSettingCallback mCustomSettingCallback;
    private final Object mLockForAudioService;
    private final CopyOnWriteArrayList<RhythmLampChangeListener> mRhythmLampChangeListener;
    private final IRhythmLampListener mRhythmLampListener;
    private IALAudio mService;
    private boolean mServiceBound;
    public static final int[] EQ_MODES = {0, 1, 2, 3, 4, 5};
    public static final int[] EQ_BANDS = {0, 1, 2};
    private static int STATE_DISCONNECTED = 0;
    private static int STATE_CONNECTING = 1;
    private static int STATE_CONNECTED = 2;
    public static int ECNR_TYPE_CP_SIRI = 7;
    public static int ECNR_TYPE_CP_FACETIME = 17;
    public static int ECNR_TYPE_CP_PHONE_NB = 15;
    public static int ECNR_CONFIG_CARPLAY_TELEPHONY_WB = 13;
    public static int ECNR_TYPE_WIRELESS_CP_PHONE_WB = 14;
    public static int ECNR_TYPE_WIRELESS_CP_PHONE_NB = 16;
    public static int ECNR_TYPE_WIRELESS_CP_SIRI = 8;
    public static int ECNR_TYPE_WIRELESS_CP_FACETIME = 18;
    public static int ECNR_TYPE_HICAR_ECNR_VR_MIC = 27;
    public static int ECNR_TYPE_WIRELESS_HICAR_ECNR_VR_MIC = 28;
    public static int ECNR_TYPE_HICAR_ECNR_PHONE_MIC = 29;
    public static int ECNR_TYPE_WIRELESS_HICAR_ECNR_PHONE_MIC = 30;
    public static int ECNR_CONFIG_CARPLAY_CALL_SWB_MIC = 31;
    public static int ECNR_CONFIG_WIFI_CARPLAY_CALL_SWB_MIC = 32;
    public static int ECNR_CONFIG_CARPLAY_CALL_FB_MIC = 33;
    public static int ECNR_CONFIG_WIFI_CARPLAY_CALL_FB_MIC = 34;
    public static int ECNR_TYPE_PHONE_VR_ESIRI_MIC = 35;
    public static int ECNR_TYPE_PHONE_WIFI_VR_ESIRI_MIC = 36;

    public static class CarExtVolumeCallback extends CarAudioManager.CarExtVolumeCallback {
    }

    public interface IAudioEffectCallback {
        void onDTSModeChange(int i);

        void onEffectModeChange(int i);

        void onEqBandFreqChange(int i, float f);

        void onEqModeChange(int i);

        void onFieldModeChange(int i);
    }

    public static abstract class RhythmLampChangeListener {
        public void onRhythmChanged(int[] iArr) {
        }

        public void onRhythmStateChange(boolean z) {
        }
    }

    private int sourceToUsecaseType(int i) {
        int i2 = 12;
        if (i != 12) {
            i2 = 19;
            if (i != 19) {
                i2 = 1996;
                if (i != 1996) {
                    i2 = 24;
                    if (i != 24) {
                        i2 = 25;
                        if (i != 25) {
                            switch (i) {
                                case 15:
                                    return 15;
                                case 16:
                                    return 16;
                                case 17:
                                    return 17;
                                default:
                                    switch (i) {
                                        case 28:
                                            return 28;
                                        case 29:
                                            return 29;
                                        case 30:
                                            return 30;
                                        case 31:
                                            return 31;
                                        default:
                                            return 1;
                                    }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    /* renamed from: com.autolink.adaptermanager.audio.ALAudioManager$1 */
    class AnonymousClass1 extends IRhythmLampListener.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
        public void onRhythmChanged(int[] iArr) {
            Iterator it = ALAudioManager.this.mRhythmLampChangeListener.iterator();
            while (it.hasNext()) {
                ((RhythmLampChangeListener) it.next()).onRhythmChanged(iArr);
            }
        }

        @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
        public void onRhythmStateChange(boolean z) {
            Iterator it = ALAudioManager.this.mRhythmLampChangeListener.iterator();
            while (it.hasNext()) {
                ((RhythmLampChangeListener) it.next()).onRhythmStateChange(z);
            }
        }
    }

    @Deprecated
    public ALAudioManager(Context context) {
        super(context);
        this.mLockForAudioService = new Object();
        this.mRhythmLampListener = new IRhythmLampListener.Stub() { // from class: com.autolink.adaptermanager.audio.ALAudioManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
            public void onRhythmChanged(int[] iArr) {
                Iterator it = ALAudioManager.this.mRhythmLampChangeListener.iterator();
                while (it.hasNext()) {
                    ((RhythmLampChangeListener) it.next()).onRhythmChanged(iArr);
                }
            }

            @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
            public void onRhythmStateChange(boolean z) {
                Iterator it = ALAudioManager.this.mRhythmLampChangeListener.iterator();
                while (it.hasNext()) {
                    ((RhythmLampChangeListener) it.next()).onRhythmStateChange(z);
                }
            }
        };
        this.mAudioPatch = null;
        Car createCar = Car.createCar(this.mContext);
        this.mCar = createCar;
        this.mCarAudioManager = (CarAudioManager) createCar.getCarManager("audio");
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mAudioEffectCallbacks = new CopyOnWriteArrayList<>();
        this.mRhythmLampChangeListener = new CopyOnWriteArrayList<>();
    }

    public ALAudioManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.mLockForAudioService = new Object();
        this.mRhythmLampListener = new IRhythmLampListener.Stub() { // from class: com.autolink.adaptermanager.audio.ALAudioManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
            public void onRhythmChanged(int[] iArr) {
                Iterator it = ALAudioManager.this.mRhythmLampChangeListener.iterator();
                while (it.hasNext()) {
                    ((RhythmLampChangeListener) it.next()).onRhythmChanged(iArr);
                }
            }

            @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
            public void onRhythmStateChange(boolean z) {
                Iterator it = ALAudioManager.this.mRhythmLampChangeListener.iterator();
                while (it.hasNext()) {
                    ((RhythmLampChangeListener) it.next()).onRhythmStateChange(z);
                }
            }
        };
        this.mAudioPatch = null;
        Car createCar = Car.createCar(this.mContext);
        this.mCar = createCar;
        this.mCarAudioManager = (CarAudioManager) createCar.getCarManager("audio");
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mAudioEffectCallbacks = new CopyOnWriteArrayList<>();
        this.mRhythmLampChangeListener = new CopyOnWriteArrayList<>();
    }

    private void setService(IALAudio iALAudio) {
        this.mService = iALAudio;
        if (iALAudio != null) {
            this.mConnectionState = STATE_CONNECTED;
        } else {
            this.mConnectionState = STATE_DISCONNECTED;
        }
    }

    @Deprecated
    public static ALAudioManager createAudio(Context context) {
        boolean z = false;
        ALAudioManager aLAudioManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(ALAUDIO_SERVICE_BINDER_SERVICE_NAME);
            if (aLAudioManager == null) {
                aLAudioManager = new ALAudioManager(context);
                aLAudioManager.setService(IALAudio.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createAudio before startAudioService first");
                    aLAudioManager.bindService();
                    return aLAudioManager;
                }
                Log.i(TAG, "createAudio end");
                return aLAudioManager;
            }
            if (!z) {
                Log.i(TAG, "createAudio before startAudioService second");
                aLAudioManager.bindService();
                z = true;
            }
            i++;
            if (i > AUDIO_SERVICE_BINDER_POLLING_MAX_RETRY) {
                Log.i(TAG, "retryCount > AUDIO_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(AUDIO_SERVICE_BINDER_POLLING_INTERVAL_MS);
            } catch (Exception e) {
                Log.e(TAG, "createAudio Exception: " + e);
                return null;
            }
        }
    }

    public static ALAudioManager createAudio(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        boolean z = false;
        ALAudioManager aLAudioManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(ALAUDIO_SERVICE_BINDER_SERVICE_NAME);
            if (aLAudioManager == null) {
                aLAudioManager = new ALAudioManager(context, serviceConnectionListenerNew);
                aLAudioManager.setService(IALAudio.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createAudio before startAudioService first");
                    aLAudioManager.bindService();
                    return aLAudioManager;
                }
                Log.i(TAG, "createAudio end");
                return aLAudioManager;
            }
            if (!z) {
                Log.i(TAG, "createAudio before startAudioService second");
                aLAudioManager.bindService();
                z = true;
            }
            i++;
            if (i > AUDIO_SERVICE_BINDER_POLLING_MAX_RETRY) {
                Log.i(TAG, "retryCount > AUDIO_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(AUDIO_SERVICE_BINDER_POLLING_INTERVAL_MS);
            } catch (Exception e) {
                Log.e(TAG, "createAudio Exception: " + e);
                return null;
            }
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent();
        intent.setPackage(ALAUDIO_SERVICE_PACKAGE);
        intent.setAction(ALAUDIO_SERVICE_INTERFACE_NAME);
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.mLockForAudioService) {
            IALAudio asInterface = IALAudio.Stub.asInterface(iBinder);
            if (asInterface == null) {
                return;
            }
            registerRhythmLampListener(asInterface);
            IALAudio iALAudio = this.mService;
            if (iALAudio != null && iALAudio.asBinder().equals(asInterface.asBinder())) {
                Log.i(TAG, "onServiceConnected mService " + this.mService);
                return;
            }
            Log.i(TAG, "onServiceConnected mService = newService");
            this.mService = asInterface;
            this.mConnectionState = STATE_CONNECTED;
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        Log.e(TAG, "onServiceDisconnected");
        synchronized (this.mLockForAudioService) {
            if (this.mConnectionState == STATE_DISCONNECTED) {
                return;
            }
            handleAudioDisconnectLocked();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        Log.e(TAG, "ALAudioManager->onBinderDied: ");
    }

    private void handleAudioDisconnectLocked() {
        Log.i(TAG, "handleAudioDisconnectLocked start");
        unregisterRhythmLampListener();
        this.mService = null;
        this.mConnectionState = STATE_DISCONNECTED;
    }

    public boolean setRhythmLampOpen(boolean z) {
        Log.i(TAG, "setRhythmLampOpen: open=" + z);
        if (this.mService == null) {
            Log.e(TAG, "setRhythmLampOpen mService is null");
        }
        try {
            return this.mService.setRhythmLampOpen(z);
        } catch (RemoteException e) {
            Log.e(TAG, "setRhythmLampOpen Exception: " + e);
            return false;
        }
    }

    public boolean isRhythmLampOpen() {
        Log.i(TAG, "isRhythmLampOpen");
        if (this.mService == null) {
            Log.e(TAG, "isRhythmLampOpen mService is null");
        }
        try {
            return this.mService.isRhythmLampOpen();
        } catch (RemoteException e) {
            Log.e(TAG, "isRhythmLampOpen Exception: " + e);
            return false;
        }
    }

    public void setRhythmLampChangeSpeed(int i) {
        Log.i(TAG, "setRhythmLampChangeSpeed  level=" + i);
        if (this.mService == null) {
            Log.e(TAG, "setRhythmLampChangeSpeed mService is null");
        }
        try {
            this.mService.setRhythmLampChangeSpeed(i);
        } catch (RemoteException e) {
            Log.e(TAG, "setRhythmLampChangeSpeed Exception: " + e);
        }
    }

    public boolean setVoiceLampOpen(boolean z) {
        Log.i(TAG, "setVoiceLampOpen: open=" + z);
        if (this.mService == null) {
            Log.e(TAG, "setVoiceLampOpen mService is null");
        }
        try {
            return this.mService.setVoiceLampOpen(z);
        } catch (RemoteException e) {
            Log.e(TAG, "setVoiceLampOpen Exception: " + e);
            return false;
        }
    }

    public void registerRhythmLampChangeListener(RhythmLampChangeListener rhythmLampChangeListener) {
        Objects.requireNonNull(rhythmLampChangeListener);
        Log.i(TAG, "registerRhythmLampChangeListener listener=" + rhythmLampChangeListener);
        this.mRhythmLampChangeListener.add(rhythmLampChangeListener);
    }

    public void unregisterRhythmLampChangeListener(RhythmLampChangeListener rhythmLampChangeListener) {
        Objects.requireNonNull(rhythmLampChangeListener);
        this.mRhythmLampChangeListener.remove(rhythmLampChangeListener);
    }

    private void registerRhythmLampListener(IALAudio iALAudio) {
        Log.i(TAG, "registerRhythmLampListener");
        try {
            iALAudio.registerRhythmLampListener(this.mRhythmLampListener.asBinder());
        } catch (RemoteException e) {
            Log.e(TAG, "registerRhythmLampListener failed", e);
        }
    }

    private void unregisterRhythmLampListener() {
        try {
            this.mService.unregisterRhythmLampListener(this.mRhythmLampListener.asBinder());
        } catch (RemoteException e) {
            Log.e(TAG, "unregisterRhythmLampListener failed", e);
        }
    }

    public void setGroupVolume(int i, int i2) {
        Log.i(TAG, "setGroupVolume: groupId=" + i + " volume" + i2);
        this.mCarAudioManager.setGroupVolume(i, i2, 0);
    }

    public void setGroupVolume(int i, int i2, int i3) {
        Log.i(TAG, "setGroupVolume: groupId=" + i + " volume" + i2);
        this.mCarAudioManager.setGroupVolume(i, i2, i3);
    }

    public int getGroupMaxVolume(int i) {
        return getGroupMaxVolume(0, i);
    }

    public int getGroupMaxVolume(int i, int i2) {
        return this.mCarAudioManager.getGroupMaxVolume(i, i2);
    }

    public int getGroupMinVolume(int i) {
        return getGroupMinVolume(0, i);
    }

    public int getGroupMinVolume(int i, int i2) {
        return this.mCarAudioManager.getGroupMinVolume(i, i2);
    }

    public int getGroupDefaultVolume(int i) {
        return getGroupDefaultVolume(0, i);
    }

    public int getGroupDefaultVolume(int i, int i2) {
        return this.mCarAudioManager.getGroupDefaultVolume(i, i2);
    }

    public void resetVolume() {
        resetVolume(0);
    }

    public void resetVolume(int i) {
        Log.i(TAG, "resetVolume zoneId = " + i);
        for (int i2 = 0; i2 < this.mCarAudioManager.getVolumeGroupCount(i); i2++) {
            if (i2 != this.mCarAudioManager.getVolumeGroupIdForUsage(13)) {
                CarAudioManager carAudioManager = this.mCarAudioManager;
                carAudioManager.setGroupVolume(i, i2, carAudioManager.getGroupDefaultVolume(i, i2), 0);
            }
        }
    }

    public int getGroupVolume(int i) {
        return getGroupVolume(0, i);
    }

    public int getGroupVolume(int i, int i2) {
        int groupVolume = this.mCarAudioManager.getGroupVolume(i, i2);
        Log.i(TAG, "getGroupVolume groupId = " + i2 + " volume = " + groupVolume + "  zoneId=" + i);
        return groupVolume;
    }

    public boolean isGroupMuteByPower(int i) {
        return isGroupMuteByPower(0, i);
    }

    public boolean isGroupMuteByPower(int i, int i2) {
        return this.mCarAudioManager.isGroupMuteByPower(i, i2);
    }

    public void setGroupMuteByPower(int i, boolean z) {
        setGroupMuteByPower(0, i, z);
    }

    public void setGroupMuteByPower(int i, int i2, boolean z) {
        Log.i(TAG, "setGroupMuteByPower  mute=" + z + " groupId=" + i2);
        this.mCarAudioManager.setGroupMuteByPower(i, i2, z);
    }

    public void setGroupMute(int i, boolean z, int i2) {
        setGroupMute(0, i, z, i2);
    }

    public void setGroupMute(int i, int i2, boolean z, int i3) {
        Log.i(TAG, "setGroupMute  mute=" + z + " groupId = " + i2);
        this.mCarAudioManager.setGroupMute(i, i2, z, i3);
    }

    public boolean getGroupMute(int i) {
        return isGroupMute(0, i);
    }

    public boolean isGroupMute(int i) {
        return isGroupMute(0, i);
    }

    public boolean isGroupMute(int i, int i2) {
        return this.mCarAudioManager.isGroupMute(i, i2);
    }

    public boolean isGroupSupportMute(int i) {
        return isGroupSupportMute(0, i);
    }

    public boolean isGroupSupportMute(int i, int i2) {
        return this.mCarAudioManager.isGroupSupportMute(i, i2);
    }

    public void setRadarLevel(int i) {
        Log.i(TAG, "setRadarLevel  level=" + i);
        this.mCarAudioManager.setCustomSetting(26, new String[]{i + ""});
    }

    public int getRadarLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(30, new String[0])[0]).intValue();
    }

    public int getRadarVolumeMaxLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(27, new String[0])[0]).intValue();
    }

    public int getRadarVolumeMinLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(28, new String[0])[0]).intValue();
    }

    public int getRadarVolumeDefaultLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(29, new String[0])[0]).intValue();
    }

    public String getRadarVolumeLevelName(int i) {
        return this.mCarAudioManager.getCustomSetting(31, new String[]{i + ""})[0];
    }

    public String[] getRadarVolumeNames(int i) {
        return this.mCarAudioManager.getCustomSetting(32, new String[]{i + ""});
    }

    public void setMicMute(boolean z) {
        Log.i(TAG, "setMicMute  mute=" + z);
        this.mCarAudioManager.setCustomSetting(34, new String[]{z + ""});
    }

    public boolean getMicMute() {
        return Boolean.valueOf(this.mCarAudioManager.getCustomSetting(35, new String[0])[0]).booleanValue();
    }

    public void setSystemMute(int i, boolean z) {
        Log.i(TAG, "setSystemMute  factor=" + i + " mute=" + z);
        this.mCarAudioManager.setCustomSetting(63, new String[]{i + "", (z ? 1 : 0) + ""});
    }

    public void setPowerMute(boolean z) {
        Log.i(TAG, "setPowerMute mute=" + z);
        setSystemMute(0, z);
    }

    public void setOTAMute(boolean z) {
        Log.i(TAG, "setOTAMute  mute=" + z);
        setSystemMute(1, z);
    }

    public void setKTVMode(int i) {
        Log.i(TAG, "setKTVMode  mode=" + i);
        this.mCarAudioManager.setCustomSetting(61, new String[]{i + ""});
    }

    public int getKTVMode() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(62, new String[0])[0]).intValue();
    }

    public void setBeepState(int i) {
        Log.i(TAG, "setBeepState  state=" + i);
        this.mCarAudioManager.setCustomSetting(49, new String[]{i + ""});
    }

    public int getBeepState() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(50, new String[0])[0]).intValue();
    }

    public void setESEState(int i) {
        Log.i(TAG, "setESEState  state=" + i);
        this.mCarAudioManager.setCustomSetting(51, new String[]{i + ""});
    }

    public int getESEState() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(52, new String[0])[0]).intValue();
    }

    public boolean setLoudnessState(int i) {
        Log.i(TAG, "setLoudnessState  state=" + i);
        String[] customSetting = this.mCarAudioManager.setCustomSetting(53, new String[]{i + ""});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public int getLoudnessState() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(54, new String[0])[0]).intValue();
    }

    public boolean startCarPlayDuck(boolean z) {
        Log.i(TAG, "startCarPlayDuck  duck=" + z);
        String[] customSetting = this.mCarAudioManager.setCustomSetting(65, new String[]{(z ? 1 : 0) + ""});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public void setSpeedVolumeLevel(int i) {
        Log.i(TAG, "setSpeedVolumeLevel  level=" + i);
        this.mCarAudioManager.setCustomSetting(1, new String[]{i + ""});
    }

    public int getSpeedVolumeLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(5, new String[0])[0]).intValue();
    }

    public int getSpeedVolumeMaxLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(2, new String[0])[0]).intValue();
    }

    public int getSpeedVolumeMinLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(3, new String[0])[0]).intValue();
    }

    public int getSpeedVolumeDefaultLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(4, new String[0])[0]).intValue();
    }

    public String getSpeedVolumeLevelName(int i) {
        return this.mCarAudioManager.getCustomSetting(6, new String[]{i + ""})[0];
    }

    public String[] getSpeedVolumeNames() {
        return this.mCarAudioManager.getCustomSetting(7, new String[0]);
    }

    public boolean setSoundFieldMode(int i) {
        Log.i(TAG, "setSoundFieldMode  mode=" + i);
        String[] customSetting = this.mCarAudioManager.setCustomSetting(55, new String[]{i + ""});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public int getSoundFieldMode() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(56, new String[0])[0]).intValue();
    }

    public int getSoundFieldNumber() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(57, new String[0])[0]).intValue();
    }

    public int getSoundFieldDefault() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(58, new String[0])[0]).intValue();
    }

    public String getSoundFieldName(int i) {
        return this.mCarAudioManager.getCustomSetting(59, new String[]{i + ""})[0];
    }

    public String[] getSoundFieldNames() {
        return this.mCarAudioManager.getCustomSetting(60, new String[0]);
    }

    public int getFadeTowardFront() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(8, new String[0])[0]).intValue();
    }

    public int getBalanceTowardRight() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(9, new String[0])[0]).intValue();
    }

    public void setBalanceTowardRight(int i) {
        Log.i(TAG, "setBalanceTowardRight  level=" + i);
        this.mCarAudioManager.setBalanceTowardRight(i);
    }

    public void setFadeTowardFront(int i) {
        Log.i(TAG, "setFadeTowardFront  level=" + i);
        this.mCarAudioManager.setFadeTowardFront(i);
    }

    public int getFadeBalanceDefaultLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(12, new String[0])[0]).intValue();
    }

    public int getFadeBalanceMaxLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(10, new String[0])[0]).intValue();
    }

    public int getFadeBalanceMinLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(11, new String[0])[0]).intValue();
    }

    public int getEqualizerMaxLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(13, new String[0])[0]).intValue();
    }

    public int getEqualizerMinLevel() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(14, new String[0])[0]).intValue();
    }

    public float getEqBandFreq(int i) {
        return getEqualizerBandLevel(i);
    }

    public int getEqualizerBandLevel(int i) {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(16, new String[]{i + ""})[0]).intValue();
    }

    public int getEqualizerCenterFreq(int i) {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(17, new String[]{i + ""})[0]).intValue();
    }

    public int[] supportEqBands() {
        return EQ_BANDS;
    }

    public int getEqualizerNumberOfBands() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(18, new String[0])[0]).intValue();
    }

    public int[] getEqualizerBandLevelRange() {
        String[] customSetting = this.mCarAudioManager.getCustomSetting(19, new String[0]);
        return new int[]{Integer.valueOf(customSetting[0]).intValue(), Integer.valueOf(customSetting[1]).intValue()};
    }

    public int[] getEqualizerBandFreqRange(int i) {
        String[] customSetting = this.mCarAudioManager.getCustomSetting(20, new String[]{i + ""});
        return new int[]{Integer.valueOf(customSetting[0]).intValue(), Integer.valueOf(customSetting[1]).intValue()};
    }

    public int getEqualizerBand(int i) {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(21, new String[]{i + ""})[0]).intValue();
    }

    public int getEqMode() {
        return getEqualizerCurrentPreset();
    }

    public int getEqualizerCurrentPreset() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(22, new String[0])[0]).intValue();
    }

    public int[] supportEqModes() {
        return EQ_MODES;
    }

    public int getEqualizerNumberOfPresets() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(24, new String[0])[0]).intValue();
    }

    public String getEqualizerPresetName(int i) {
        return this.mCarAudioManager.getCustomSetting(25, new String[]{i + ""})[0];
    }

    public void setEqBandFreq(int i, float f) {
        setEqualizerBandLevel(i, (int) f);
    }

    public void setEqualizerBandLevel(int i, int i2) {
        Log.i(TAG, "setEqualizerBandLevel  band=" + i + "  level" + i2);
        this.mCarAudioManager.setCustomSetting(15, new String[]{i + "", i2 + ""});
    }

    public void setEqMode(int i) {
        setEqualizerPreset(i);
    }

    public void setEqualizerPreset(int i) {
        Log.i(TAG, "setEqualizerPreset  preset=" + i);
        this.mCarAudioManager.setCustomSetting(23, new String[]{i + ""});
    }

    public boolean openSONYEffect() {
        Log.i(TAG, "openSONYEffect ");
        String[] customSetting = this.mCarAudioManager.setCustomSetting(36, new String[]{"2"});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public boolean closeSONYEffect() {
        Log.i(TAG, "closeSONYEffect ");
        String[] customSetting = this.mCarAudioManager.setCustomSetting(36, new String[]{"0"});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public boolean setEffectMode(int i) {
        Log.i(TAG, "setEffectMode  mode = " + i);
        String[] customSetting = this.mCarAudioManager.setCustomSetting(36, new String[]{i + ""});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public int getEffectMode() {
        String[] customSetting = this.mCarAudioManager.getCustomSetting(37, new String[0]);
        Log.i(TAG, "setEffectMode  mode = " + Integer.valueOf(customSetting[0]));
        return Integer.valueOf(customSetting[0]).intValue();
    }

    public boolean setDtsMode(int i) {
        Log.i(TAG, "setDtsMode  mode = " + i);
        String[] customSetting = this.mCarAudioManager.setCustomSetting(39, new String[]{i + ""});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public boolean setDtsFieldMode(int i) {
        Log.i(TAG, "setDtsFieldMode  mode = " + i);
        String[] customSetting = this.mCarAudioManager.setCustomSetting(40, new String[]{i + ""});
        if (customSetting == null || customSetting.length == 0) {
            return false;
        }
        return Boolean.valueOf(customSetting[0]).booleanValue();
    }

    public int getDtsMode() {
        String[] customSetting = this.mCarAudioManager.getCustomSetting(41, new String[0]);
        Log.i(TAG, "getDtsMode  mode = " + Integer.valueOf(customSetting[0]));
        return Integer.valueOf(customSetting[0]).intValue();
    }

    public int getDtsFieldMode() {
        String[] customSetting = this.mCarAudioManager.getCustomSetting(42, new String[0]);
        Log.i(TAG, "getDtsFieldMode  mode = " + Integer.valueOf(customSetting[0]));
        return Integer.valueOf(customSetting[0]).intValue();
    }

    public String[] getDtsNames() {
        return this.mCarAudioManager.getCustomSetting(43, new String[0]);
    }

    public String[] getDtsFieldNames() {
        return this.mCarAudioManager.getCustomSetting(44, new String[0]);
    }

    public String getDtsName(int i) {
        return this.mCarAudioManager.getCustomSetting(45, new String[]{i + ""})[0];
    }

    public String getDtsFieldName(int i) {
        return this.mCarAudioManager.getCustomSetting(46, new String[]{i + ""})[0];
    }

    public int getDtsDefaultMode() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(47, new String[0])[0]).intValue();
    }

    public int getDtsFieldDefaultMode() {
        return Integer.valueOf(this.mCarAudioManager.getCustomSetting(48, new String[0])[0]).intValue();
    }

    public void setEcnrConfiguration(int i, int i2) {
        Log.i(TAG, "setEcnrConfiguration  usecaseType = " + i + "  configType" + i2);
        this.mCarAudioManager.setEcnrConfiguration(i, i2);
    }

    public void linkRecordPatch(int i) {
        Log.i(TAG, "linkRecordPatch  source = " + i);
        setEcnrConfiguration(sourceToUsecaseType(i), sourceToConfigType(i));
    }

    public void closeRecordPatch() {
        setEcnrConfiguration(0, 0);
    }

    public void closeRecordPatch(int i) {
        setEcnrConfiguration(sourceToUsecaseType(i), 0);
    }

    private int sourceToConfigType(int i) {
        if (i == 11) {
            return ECNR_TYPE_CP_SIRI;
        }
        if (i == 12) {
            return ECNR_TYPE_CP_FACETIME;
        }
        if (i != 1996) {
            switch (i) {
                case 15:
                    return ECNR_TYPE_CP_PHONE_NB;
                case 16:
                    return ECNR_TYPE_WIRELESS_CP_PHONE_WB;
                case 17:
                    return ECNR_TYPE_WIRELESS_CP_PHONE_NB;
                case 18:
                    return ECNR_TYPE_WIRELESS_CP_SIRI;
                case 19:
                    return ECNR_TYPE_WIRELESS_CP_FACETIME;
                default:
                    switch (i) {
                        case 22:
                            return ECNR_TYPE_HICAR_ECNR_VR_MIC;
                        case 23:
                            return ECNR_TYPE_WIRELESS_HICAR_ECNR_VR_MIC;
                        case 24:
                            return ECNR_TYPE_HICAR_ECNR_PHONE_MIC;
                        case 25:
                            return ECNR_TYPE_WIRELESS_HICAR_ECNR_PHONE_MIC;
                        case 26:
                            return ECNR_TYPE_PHONE_VR_ESIRI_MIC;
                        case 27:
                            return ECNR_TYPE_PHONE_WIFI_VR_ESIRI_MIC;
                        case 28:
                            return ECNR_CONFIG_CARPLAY_CALL_SWB_MIC;
                        case 29:
                            return ECNR_CONFIG_WIFI_CARPLAY_CALL_SWB_MIC;
                        case 30:
                            return ECNR_CONFIG_CARPLAY_CALL_FB_MIC;
                        case 31:
                            return ECNR_CONFIG_WIFI_CARPLAY_CALL_FB_MIC;
                        default:
                            return 0;
                    }
            }
        }
        return ECNR_CONFIG_CARPLAY_TELEPHONY_WB;
    }

    public boolean getAudioFocusStatus() {
        return getActiveAudioFocusUsage(0) != 0;
    }

    public int getCurrentUsage() {
        int activeAudioFocusUsage = getActiveAudioFocusUsage(0);
        if (activeAudioFocusUsage == 0) {
            return 1;
        }
        return activeAudioFocusUsage;
    }

    public int getActiveAudioFocusUsage() {
        return getActiveAudioFocusUsage(0);
    }

    public int getActiveAudioFocusUsage(int i) {
        int activeAudioFocusUsage = this.mCarAudioManager.getActiveAudioFocusUsage(i);
        if (activeAudioFocusUsage == 20 || activeAudioFocusUsage == 25) {
            Log.i(TAG, "getActiveAudioFocusUsage usage == AudioAttributes.USAGE_ECAL || usage == AudioAttributes.USAGE_BCALL ");
            activeAudioFocusUsage = 0;
        }
        Log.i(TAG, "getActiveAudioFocusUsage  usage = " + activeAudioFocusUsage);
        return activeAudioFocusUsage;
    }

    public int getRealActiveFocusUsage(int i) {
        int activeAudioFocusUsage = this.mCarAudioManager.getActiveAudioFocusUsage(i);
        Log.i(TAG, "getRealActiveFocusUsage  usage = " + activeAudioFocusUsage);
        return activeAudioFocusUsage;
    }

    public int getVolumeGroupCount() {
        return getVolumeGroupCount(0);
    }

    public int getVolumeGroupCount(int i) {
        return this.mCarAudioManager.getVolumeGroupCount(i);
    }

    public int getVolumeGroupIdForUsage(int i) {
        return getVolumeGroupIdForUsage(0, i);
    }

    public int getVolumeGroupIdForUsage(int i, int i2) {
        return this.mCarAudioManager.getVolumeGroupIdForUsage(i, i2);
    }

    public int[] getUsagesForVolumeGroupId(int i) {
        return getUsagesForVolumeGroupId(0, i);
    }

    public int[] getUsagesForVolumeGroupId(int i, int i2) {
        return this.mCarAudioManager.getUsagesForVolumeGroupId(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (r6.role() != 2) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        if ((r6 instanceof android.media.AudioDevicePort) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
    
        if (r6.address().equals("bus4_call_out") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        r5 = r6.buildConfig(16000, 1, 1, (android.media.AudioGainConfig) null);
        android.util.Log.d(com.autolink.adaptermanager.audio.ALAudioManager.TAG, "Found sinkPortConfig : " + r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean linkEcallPatch() {
        /*
            r11 = this;
            java.lang.String r0 = "linkEcallPatch"
            java.lang.String r1 = "ALAudioManager"
            android.util.Log.d(r1, r0)
            android.media.AudioPatch r0 = r11.mAudioPatch
            r2 = 0
            if (r0 == 0) goto L12
            java.lang.String r0 = " mAudioPatch != null  can not create second patch"
            android.util.Log.e(r1, r0)
            return r2
        L12:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.media.AudioManager.listAudioPorts(r0)
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
            r4 = r3
            r5 = r4
        L21:
            boolean r6 = r0.hasNext()
            r7 = 1
            if (r6 == 0) goto L95
            java.lang.Object r6 = r0.next()
            android.media.AudioPort r6 = (android.media.AudioPort) r6
            r8 = 16000(0x3e80, float:2.2421E-41)
            if (r4 != 0) goto L62
            int r9 = r6.role()
            if (r9 != r7) goto L62
            boolean r9 = r6 instanceof android.media.AudioDevicePort
            if (r9 == 0) goto L62
            r9 = r6
            android.media.AudioDevicePort r9 = (android.media.AudioDevicePort) r9
            java.lang.String r10 = "bus9_tcp_phone_emerg_dnlink_in"
            java.lang.String r9 = r9.address()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L21
            android.media.AudioPortConfig r4 = r6.buildConfig(r8, r7, r7, r3)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Found srcPortConfig : "
            r6.<init>(r7)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r1, r6)
            goto L21
        L62:
            if (r5 != 0) goto L21
            int r9 = r6.role()
            r10 = 2
            if (r9 != r10) goto L21
            boolean r9 = r6 instanceof android.media.AudioDevicePort
            if (r9 == 0) goto L21
            r9 = r6
            android.media.AudioDevicePort r9 = (android.media.AudioDevicePort) r9
            java.lang.String r10 = "bus4_call_out"
            java.lang.String r9 = r9.address()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L21
            android.media.AudioPortConfig r5 = r6.buildConfig(r8, r7, r7, r3)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Found sinkPortConfig : "
            r6.<init>(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r1, r6)
            goto L21
        L95:
            if (r4 == 0) goto Lb5
            if (r5 == 0) goto Lb5
            android.media.AudioPatch[] r0 = new android.media.AudioPatch[r7]
            android.media.AudioPatch r3 = r11.mAudioPatch
            r0[r2] = r3
            android.media.AudioPortConfig[] r3 = new android.media.AudioPortConfig[r7]
            r3[r2] = r4
            android.media.AudioPortConfig[] r4 = new android.media.AudioPortConfig[r7]
            r4[r2] = r5
            android.media.AudioManager.createAudioPatch(r0, r3, r4)
            r0 = r0[r2]
            r11.mAudioPatch = r0
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        Lb5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autolink.adaptermanager.audio.ALAudioManager.linkEcallPatch():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (r6.role() != 2) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        if ((r6 instanceof android.media.AudioDevicePort) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
    
        if (r6.address().equals("bus4_call_out") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        r5 = r6.buildConfig(16000, 1, 1, (android.media.AudioGainConfig) null);
        android.util.Log.d(com.autolink.adaptermanager.audio.ALAudioManager.TAG, "Found sinkPortConfig : " + r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean linkINTEcallPatch() {
        /*
            r11 = this;
            java.lang.String r0 = "linkINTEcallPatch"
            java.lang.String r1 = "ALAudioManager"
            android.util.Log.d(r1, r0)
            android.media.AudioPatch r0 = r11.mAudioPatch
            r2 = 0
            if (r0 == 0) goto L12
            java.lang.String r0 = " mAudioPatch != null  can not create second patch"
            android.util.Log.e(r1, r0)
            return r2
        L12:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.media.AudioManager.listAudioPorts(r0)
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
            r4 = r3
            r5 = r4
        L21:
            boolean r6 = r0.hasNext()
            r7 = 1
            if (r6 == 0) goto L95
            java.lang.Object r6 = r0.next()
            android.media.AudioPort r6 = (android.media.AudioPort) r6
            r8 = 16000(0x3e80, float:2.2421E-41)
            if (r4 != 0) goto L62
            int r9 = r6.role()
            if (r9 != r7) goto L62
            boolean r9 = r6 instanceof android.media.AudioDevicePort
            if (r9 == 0) goto L62
            r9 = r6
            android.media.AudioDevicePort r9 = (android.media.AudioDevicePort) r9
            java.lang.String r10 = "bus9_glonass_ecall_in"
            java.lang.String r9 = r9.address()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L21
            android.media.AudioPortConfig r4 = r6.buildConfig(r8, r7, r7, r3)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Found srcPortConfig : "
            r6.<init>(r7)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r1, r6)
            goto L21
        L62:
            if (r5 != 0) goto L21
            int r9 = r6.role()
            r10 = 2
            if (r9 != r10) goto L21
            boolean r9 = r6 instanceof android.media.AudioDevicePort
            if (r9 == 0) goto L21
            r9 = r6
            android.media.AudioDevicePort r9 = (android.media.AudioDevicePort) r9
            java.lang.String r10 = "bus4_call_out"
            java.lang.String r9 = r9.address()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L21
            android.media.AudioPortConfig r5 = r6.buildConfig(r8, r7, r7, r3)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Found sinkPortConfig : "
            r6.<init>(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r1, r6)
            goto L21
        L95:
            if (r4 == 0) goto Lb5
            if (r5 == 0) goto Lb5
            android.media.AudioPatch[] r0 = new android.media.AudioPatch[r7]
            android.media.AudioPatch r3 = r11.mAudioPatch
            r0[r2] = r3
            android.media.AudioPortConfig[] r3 = new android.media.AudioPortConfig[r7]
            r3[r2] = r4
            android.media.AudioPortConfig[] r4 = new android.media.AudioPortConfig[r7]
            r4[r2] = r5
            android.media.AudioManager.createAudioPatch(r0, r3, r4)
            r0 = r0[r2]
            r11.mAudioPatch = r0
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        Lb5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autolink.adaptermanager.audio.ALAudioManager.linkINTEcallPatch():boolean");
    }

    public void releaseAudioPatch() {
        AudioPatch audioPatch = this.mAudioPatch;
        if (audioPatch != null) {
            Log.d(TAG, "releaseAudioPatch" + this.mAudioPatch.toString() + "state =" + AudioManager.releaseAudioPatch(audioPatch));
            this.mAudioPatch = null;
        }
    }

    public void registerCarVolumeCallback(CarAudioManager.CarVolumeCallback carVolumeCallback) {
        Log.i(TAG, "registerCarVolumeCallback");
        this.mCarAudioManager.registerCarVolumeCallback(carVolumeCallback);
    }

    public void unregisterCarVolumeCallback(CarAudioManager.CarVolumeCallback carVolumeCallback) {
        Log.i(TAG, "unregisterCarVolumeCallback");
        this.mCarAudioManager.unregisterCarVolumeCallback(carVolumeCallback);
    }

    public void registerCarVolumeCallback(CarAudioManager.CarExtVolumeCallback carExtVolumeCallback) {
        Log.i(TAG, "registerCarVolumeCallback   CarExtVolumeCallback");
        this.mCarAudioManager.registerCarVolumeCallback(carExtVolumeCallback);
    }

    public void unregisterCarVolumeCallback(CarAudioManager.CarExtVolumeCallback carExtVolumeCallback) {
        Log.i(TAG, "unregisterCarVolumeCallback   CarExtVolumeCallback");
        this.mCarAudioManager.unregisterCarVolumeCallback(carExtVolumeCallback);
    }

    public void registerAudioFieldCallback(CarAudioManager.CarAudioFocusCallback carAudioFocusCallback) {
        Log.i(TAG, "registerAudioFieldCallback ");
        registerCarAudioFocusCallback(carAudioFocusCallback);
    }

    public void unregisterAudioFieldCallback(CarAudioManager.CarAudioFocusCallback carAudioFocusCallback) {
        Log.i(TAG, "unregisterAudioFieldCallback ");
        unregisterCarAudioFocusCallback(carAudioFocusCallback);
    }

    public void registerCarAudioFocusCallback(CarAudioManager.CarAudioFocusCallback carAudioFocusCallback) {
        this.mCarAudioManager.registerCarAudioFocusCallback(carAudioFocusCallback);
    }

    public void unregisterCarAudioFocusCallback(CarAudioManager.CarAudioFocusCallback carAudioFocusCallback) {
        this.mCarAudioManager.unregisterCarAudioFocusCallback(carAudioFocusCallback);
    }

    public void registerCarCustomSettingCallback(CarAudioManager.CarCustomSettingCallback carCustomSettingCallback) {
        this.mCarAudioManager.registerCarCustomSettingCallback(carCustomSettingCallback);
    }

    public void unregisterCarCustomSettingCallback(CarAudioManager.CarCustomSettingCallback carCustomSettingCallback) {
        this.mCarAudioManager.unregisterCarCustomSettingCallback(carCustomSettingCallback);
    }

    public void registerAudioEffectCallback(IAudioEffectCallback iAudioEffectCallback) {
        this.mAudioEffectCallbacks.add(iAudioEffectCallback);
        if (this.mCustomSettingCallback == null) {
            CustomSettingCallback customSettingCallback = new CustomSettingCallback();
            this.mCustomSettingCallback = customSettingCallback;
            registerCarCustomSettingCallback(customSettingCallback);
        }
    }

    public void unregisterAudioEffectCallback(IAudioEffectCallback iAudioEffectCallback) {
        this.mAudioEffectCallbacks.remove(iAudioEffectCallback);
        if (this.mCustomSettingCallback == null || !checkCallbackNull()) {
            return;
        }
        unregisterCarCustomSettingCallback(this.mCustomSettingCallback);
    }

    private boolean checkCallbackNull() {
        return this.mAudioEffectCallbacks.isEmpty();
    }

    public class CustomSettingCallback extends CarAudioManager.CarCustomSettingCallback {
        public CustomSettingCallback() {
        }

        @Override // android.car.media.CarAudioManager.CarCustomSettingCallback
        public void onValueChanged(int i, int i2, String[] strArr) {
            super.onValueChanged(i, i2, strArr);
            if (i2 == 15) {
                Iterator it = ALAudioManager.this.mAudioEffectCallbacks.iterator();
                while (it.hasNext()) {
                    ((IAudioEffectCallback) it.next()).onEqBandFreqChange(Integer.valueOf(strArr[0]).intValue(), Integer.valueOf(strArr[1]).intValue());
                }
                return;
            }
            if (i2 == 23) {
                Iterator it2 = ALAudioManager.this.mAudioEffectCallbacks.iterator();
                while (it2.hasNext()) {
                    ((IAudioEffectCallback) it2.next()).onEqModeChange(Integer.valueOf(strArr[0]).intValue());
                }
                return;
            }
            if (i2 == 36) {
                Iterator it3 = ALAudioManager.this.mAudioEffectCallbacks.iterator();
                while (it3.hasNext()) {
                    ((IAudioEffectCallback) it3.next()).onEffectModeChange(Integer.valueOf(strArr[0]).intValue());
                }
            } else if (i2 == 39) {
                Iterator it4 = ALAudioManager.this.mAudioEffectCallbacks.iterator();
                while (it4.hasNext()) {
                    ((IAudioEffectCallback) it4.next()).onDTSModeChange(Integer.valueOf(strArr[0]).intValue());
                }
            } else {
                if (i2 != 40) {
                    return;
                }
                Iterator it5 = ALAudioManager.this.mAudioEffectCallbacks.iterator();
                while (it5.hasNext()) {
                    ((IAudioEffectCallback) it5.next()).onFieldModeChange(Integer.valueOf(strArr[0]).intValue());
                }
            }
        }
    }
}
