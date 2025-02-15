package android.car.media;

import android.annotation.SystemApi;
import android.car.Car;
import android.car.CarLibLog;
import android.car.CarManagerBase;
import android.car.media.ICarAudio;
import android.car.media.ICarAudioFocusCallback;
import android.car.media.ICarCustomSettingCallback;
import android.car.media.ICarExtVolumeCallback;
import android.car.media.ICarVolumeCallback;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class CarAudioManager extends CarManagerBase {

    @SystemApi
    public static final String AUDIOFOCUS_EXTRA_RECEIVE_DUCKING_EVENTS = "android.car.media.AUDIOFOCUS_EXTRA_RECEIVE_DUCKING_EVENTS";
    public static final String AUDIOFOCUS_EXTRA_REQUEST_ZONE_ID = "android.car.media.AUDIOFOCUS_EXTRA_REQUEST_ZONE_ID";

    @SystemApi
    public static final int ECNR_CONFIG_TYPE_BT_CALL_NB = 1;

    @SystemApi
    public static final int ECNR_CONFIG_TYPE_BT_CALL_WB = 2;

    @SystemApi
    public static final int ECNR_CONFIG_TYPE_NONE = 0;

    @SystemApi
    public static final int ECNR_USE_CASE_TYPE_BT_CALL = 1;

    @SystemApi
    public static final int ECNR_USE_CASE_TYPE_NONE = 0;
    public static final int EFFECT_MODE_DTS = 1;
    public static final int EFFECT_MODE_EQUALIZER = 0;
    public static final int EFFECT_MODE_SONY = 2;

    @SystemApi
    public static final int INVALID_AUDIO_ZONE = -1;
    public static final int INVALID_VOLUME_GROUP_ID = -1;

    @SystemApi
    public static final int PARAM_GET_BALANCE_LEVEL = 9;

    @SystemApi
    public static final int PARAM_GET_BEEP_STATE = 50;

    @SystemApi
    public static final int PARAM_GET_DTS_DEFAULT_MODE = 47;

    @SystemApi
    public static final int PARAM_GET_DTS_MODE = 41;

    @SystemApi
    public static final int PARAM_GET_DTS_NAME = 45;

    @SystemApi
    public static final int PARAM_GET_DTS_NAMES = 43;

    @SystemApi
    public static final int PARAM_GET_EFFECT_MODE = 37;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_BAND = 21;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_BAND_FREQ_RANGE = 20;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_BAND_LEVEL = 16;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_BAND_LEVEL_RANGE = 19;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_CENTER_FREQ = 17;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_CURRENT_PRESET = 22;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_MAX_LEVEL = 13;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_MIN_LEVEL = 14;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_NUMBER_BANDS = 18;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_NUMBER_PRESETS = 24;

    @SystemApi
    public static final int PARAM_GET_EQUALIZER_PRESET_NAME = 25;

    @SystemApi
    public static final int PARAM_GET_ESE_STATE = 52;

    @SystemApi
    public static final int PARAM_GET_FADE_BALANCE_DEFAULT_LEVEL = 12;

    @SystemApi
    public static final int PARAM_GET_FADE_BALANCE_MAX_LEVEL = 10;

    @SystemApi
    public static final int PARAM_GET_FADE_BALANCE_MIN_LEVEL = 11;

    @SystemApi
    public static final int PARAM_GET_FADE_LEVEL = 8;

    @SystemApi
    public static final int PARAM_GET_FIELD_DEFAULT_MODE = 48;

    @SystemApi
    public static final int PARAM_GET_FIELD_MODE = 42;

    @SystemApi
    public static final int PARAM_GET_FIELD_NAME = 46;

    @SystemApi
    public static final int PARAM_GET_FIELD_NAMES = 44;

    @SystemApi
    public static final int PARAM_GET_LOUDNESS_STATE = 54;

    @SystemApi
    public static final int PARAM_GET_MIC_MUTE = 35;

    @SystemApi
    public static final int PARAM_GET_RADAR_VOLUME_CURRENT_LEVEL = 30;

    @SystemApi
    public static final int PARAM_GET_RADAR_VOLUME_DEFAULT_LEVEL = 29;

    @SystemApi
    public static final int PARAM_GET_RADAR_VOLUME_LEVEL = 33;

    @SystemApi
    public static final int PARAM_GET_RADAR_VOLUME_LEVEL_NAME = 31;

    @SystemApi
    public static final int PARAM_GET_RADAR_VOLUME_MAX_LEVEL = 27;

    @SystemApi
    public static final int PARAM_GET_RADAR_VOLUME_MIN_LEVEL = 28;

    @SystemApi
    public static final int PARAM_GET_RADAR_VOLUME_NAMES = 32;

    @SystemApi
    public static final int PARAM_GET_SOUND_FIELD_CURRENT_MODE = 56;

    @SystemApi
    public static final int PARAM_GET_SOUND_FIELD_DEFAULT_MODE = 58;

    @SystemApi
    public static final int PARAM_GET_SOUND_FIELD_NAME = 59;

    @SystemApi
    public static final int PARAM_GET_SOUND_FIELD_NAMES = 60;

    @SystemApi
    public static final int PARAM_GET_SOUND_FIELD_NUMBER = 57;

    @SystemApi
    public static final int PARAM_GET_SPEED_VOLUME_CURRENT_LEVEL = 5;

    @SystemApi
    public static final int PARAM_GET_SPEED_VOLUME_DEFAULT_LEVEL = 4;

    @SystemApi
    public static final int PARAM_GET_SPEED_VOLUME_LEVEL_NAME = 6;

    @SystemApi
    public static final int PARAM_GET_SPEED_VOLUME_MAX_LEVEL = 2;

    @SystemApi
    public static final int PARAM_GET_SPEED_VOLUME_MIN_LEVEL = 3;

    @SystemApi
    public static final int PARAM_GET_SPEED_VOLUME_NAMES = 7;

    @SystemApi
    public static final int PARAM_SET_BEEP_STATE = 49;

    @SystemApi
    public static final int PARAM_SET_DTS_MODE = 39;

    @SystemApi
    public static final int PARAM_SET_EFFECT_MODE = 36;

    @SystemApi
    public static final int PARAM_SET_EQUALIZER_BAND_LEVEL = 15;

    @SystemApi
    public static final int PARAM_SET_EQUALIZER_CURRENT_PRESET = 23;

    @SystemApi
    public static final int PARAM_SET_ESE_STATE = 51;

    @SystemApi
    public static final int PARAM_SET_FIELD_MODE = 40;

    @SystemApi
    public static final int PARAM_SET_LOUDNESS_STATE = 53;

    @SystemApi
    public static final int PARAM_SET_MIC_MUTE = 34;

    @SystemApi
    public static final int PARAM_SET_RADAR_VOLUME_LEVEL = 26;

    @SystemApi
    public static final int PARAM_SET_SOUND_FIELD_MODE = 55;

    @SystemApi
    public static final int PARAM_SET_SPEED_VOLUME_LEVEL = 1;

    @SystemApi
    public static final int PRIMARY_AUDIO_ZONE = 0;
    public static final int RADAR_HIGH = 2;
    public static final int RADAR_LOW = 0;
    public static final int RADAR_MID = 1;
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
    private final AudioManager mAudioManager;
    private final ICarAudioFocusCallback mCarAudioFocusCallbackImpl;
    private final CopyOnWriteArrayList<CarAudioFocusCallback> mCarAudioFocusCallbacks;
    private final ICarCustomSettingCallback mCarCustomSettingCallbackImpl;
    private final CopyOnWriteArrayList<CarCustomSettingCallback> mCarCustomSettingCallbacks;
    private final ICarExtVolumeCallback mCarExtVolumeCallbackImpl;
    private final CopyOnWriteArrayList<CarExtVolumeCallback> mCarExtVolumeCallbacks;
    private final ICarVolumeCallback mCarVolumeCallbackImpl;
    private final CopyOnWriteArrayList<CarVolumeCallback> mCarVolumeCallbacks;
    private final ICarAudio mService;

    public static abstract class CarAudioFocusCallback {
        public void onAudioFocusGrant(String str, int i, int i2, int i3) {
        }

        public void onAudioFocusLoss(String str, int i, int i2, boolean z) {
        }
    }

    public static abstract class CarCustomSettingCallback {
        public void onEnableChanged(int i, int i2, boolean z) {
        }

        public void onValueChanged(int i, int i2, String[] strArr) {
        }
    }

    public static abstract class CarExtVolumeCallback {
        public void onGroupMuteChanged(int i, int i2, boolean z, int i3) {
        }

        public void onGroupVolumeChanged(int i, int i2, int i3, int i4) {
        }
    }

    public static abstract class CarVolumeCallback {
        public void onGroupVolumeChanged(int i, int i2, int i3) {
        }

        public void onMasterMuteChanged(int i, int i2) {
        }
    }

    @SystemApi
    public int getBalanceTowardRight() {
        return 0;
    }

    @SystemApi
    public int getFadeTowardFront() {
        return 0;
    }

    public boolean isDynamicRoutingEnabled() {
        try {
            return this.mService.isDynamicRoutingEnabled();
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    @SystemApi
    public void setGroupVolume(int i, int i2, int i3) {
        setGroupVolume(0, i, i2, i3);
    }

    @SystemApi
    public void setGroupVolume(int i, int i2, int i3, int i4) {
        try {
            this.mService.setGroupVolume(i, i2, i3, i4);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    @SystemApi
    public int getGroupMaxVolume(int i) {
        return getGroupMaxVolume(0, i);
    }

    @SystemApi
    public int getGroupMaxVolume(int i, int i2) {
        try {
            return this.mService.getGroupMaxVolume(i, i2);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    @SystemApi
    public int getGroupMinVolume(int i) {
        return getGroupMinVolume(0, i);
    }

    @SystemApi
    public int getGroupMinVolume(int i, int i2) {
        try {
            return this.mService.getGroupMinVolume(i, i2);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    @SystemApi
    public int getGroupDefaultVolume(int i) {
        return getGroupDefaultVolume(0, i);
    }

    @SystemApi
    public int getGroupDefaultVolume(int i, int i2) {
        try {
            return this.mService.getGroupDefaultVolume(i, i2);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    @SystemApi
    public int getGroupVolume(int i) {
        return getGroupVolume(0, i);
    }

    @SystemApi
    public int getGroupVolume(int i, int i2) {
        try {
            return this.mService.getGroupVolume(i, i2);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    @SystemApi
    public boolean isGroupMuteByPower(int i) {
        return isGroupMuteByPower(0, i);
    }

    @SystemApi
    public boolean isGroupMuteByPower(int i, int i2) {
        try {
            return this.mService.isGroupMuteByPower(i, i2);
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    @SystemApi
    public void setGroupMuteByPower(int i, boolean z) {
        setGroupMuteByPower(0, i, z);
    }

    @SystemApi
    public void setGroupMuteByPower(int i, int i2, boolean z) {
        try {
            this.mService.setGroupMuteByPower(i, i2, z);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    @SystemApi
    public void setGroupMute(int i, boolean z, int i2) {
        setGroupMute(0, i, z, i2);
    }

    @SystemApi
    public void setGroupMute(int i, int i2, boolean z, int i3) {
        try {
            this.mService.setGroupMute(i, i2, z, i3);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    @SystemApi
    public boolean isGroupMute(int i) {
        return isGroupMute(0, i);
    }

    @SystemApi
    public boolean isGroupMute(int i, int i2) {
        try {
            return this.mService.isGroupMute(i, i2);
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    @SystemApi
    public boolean isGroupSupportMute(int i) {
        return isGroupSupportMute(0, i);
    }

    @SystemApi
    public boolean isGroupSupportMute(int i, int i2) {
        try {
            return this.mService.isGroupSupportMute(i, i2);
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    @SystemApi
    public void setFadeTowardFront(float f) {
        try {
            this.mService.setFadeTowardFront(f);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    @SystemApi
    public String[] setCustomSetting(int i, String[] strArr) {
        return setCustomSetting(0, i, strArr);
    }

    @SystemApi
    public String[] setCustomSetting(int i, int i2, String[] strArr) {
        try {
            return this.mService.setCustomSetting(i, i2, strArr);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
            return new String[0];
        }
    }

    @SystemApi
    public String[] getCustomSetting(int i, String[] strArr) {
        return getCustomSetting(0, i, strArr);
    }

    @SystemApi
    public String[] getCustomSetting(int i, int i2, String[] strArr) {
        try {
            return this.mService.getCustomSetting(i, i2, strArr);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
            return new String[0];
        }
    }

    @SystemApi
    public void setEcnrConfiguration(int i, int i2) {
        try {
            this.mService.setEcnrConfiguration(i, i2);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    @SystemApi
    public int getActiveAudioFocusUsage() {
        return getActiveAudioFocusUsage(0);
    }

    @SystemApi
    public int getActiveAudioFocusUsage(int i) {
        try {
            return this.mService.getActiveAudioFocusUsage(i);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
            return 0;
        }
    }

    @SystemApi
    public void setBalanceTowardRight(float f) {
        try {
            this.mService.setBalanceTowardRight(f);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    @SystemApi
    public String[] getExternalSources() {
        try {
            return this.mService.getExternalSources();
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
            return new String[0];
        }
    }

    @SystemApi
    public CarAudioPatchHandle createAudioPatch(String str, int i, int i2) {
        try {
            return this.mService.createAudioPatch(str, i, i2);
        } catch (RemoteException e) {
            return (CarAudioPatchHandle) handleRemoteExceptionFromCarService(e, null);
        }
    }

    @SystemApi
    public void releaseAudioPatch(CarAudioPatchHandle carAudioPatchHandle) {
        try {
            this.mService.releaseAudioPatch(carAudioPatchHandle);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    @SystemApi
    public int getVolumeGroupCount() {
        return getVolumeGroupCount(0);
    }

    @SystemApi
    public int getVolumeGroupCount(int i) {
        try {
            return this.mService.getVolumeGroupCount(i);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    @SystemApi
    public int getVolumeGroupIdForUsage(int i) {
        return getVolumeGroupIdForUsage(0, i);
    }

    @SystemApi
    public int getVolumeGroupIdForUsage(int i, int i2) {
        try {
            return this.mService.getVolumeGroupIdForUsage(i, i2);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    @SystemApi
    public int[] getUsagesForVolumeGroupId(int i) {
        return getUsagesForVolumeGroupId(0, i);
    }

    @SystemApi
    public int[] getUsagesForVolumeGroupId(int i, int i2) {
        try {
            return this.mService.getUsagesForVolumeGroupId(i, i2);
        } catch (RemoteException e) {
            return (int[]) handleRemoteExceptionFromCarService(e, new int[0]);
        }
    }

    @SystemApi
    public List<Integer> getAudioZoneIds() {
        try {
            int[] audioZoneIds = this.mService.getAudioZoneIds();
            ArrayList arrayList = new ArrayList(audioZoneIds.length);
            for (int i : audioZoneIds) {
                arrayList.add(Integer.valueOf(i));
            }
            return arrayList;
        } catch (RemoteException e) {
            return (List) handleRemoteExceptionFromCarService(e, Collections.emptyList());
        }
    }

    public int getZoneIdForUid(int i) {
        try {
            return this.mService.getZoneIdForUid(i);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    public boolean setZoneIdForUid(int i, int i2) {
        try {
            return this.mService.setZoneIdForUid(i, i2);
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    public boolean clearZoneIdForUid(int i) {
        try {
            return this.mService.clearZoneIdForUid(i);
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    @SystemApi
    public AudioDeviceInfo getOutputDeviceForUsage(int i, int i2) {
        try {
            String outputDeviceAddressForUsage = this.mService.getOutputDeviceAddressForUsage(i, i2);
            if (outputDeviceAddressForUsage == null) {
                return null;
            }
            for (AudioDeviceInfo audioDeviceInfo : this.mAudioManager.getDevices(2)) {
                if (audioDeviceInfo.getAddress().equals(outputDeviceAddressForUsage)) {
                    return audioDeviceInfo;
                }
            }
            return null;
        } catch (RemoteException e) {
            return (AudioDeviceInfo) handleRemoteExceptionFromCarService(e, null);
        }
    }

    @SystemApi
    public List<AudioDeviceInfo> getInputDevicesForZoneId(int i) {
        try {
            return convertInputDevicesToDeviceInfos(this.mService.getInputDevicesForZoneId(i), 1);
        } catch (RemoteException e) {
            return (List) handleRemoteExceptionFromCarService(e, new ArrayList());
        }
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
        if (this.mService != null) {
            unregisterVolumeCallback();
        }
    }

    public CarAudioManager(Car car, IBinder iBinder) {
        super(car);
        this.mCarVolumeCallbackImpl = new ICarVolumeCallback.Stub() { // from class: android.car.media.CarAudioManager.1
            @Override // android.car.media.ICarVolumeCallback
            public void onGroupVolumeChanged(int i, int i2, int i3) {
                Iterator it = CarAudioManager.this.mCarVolumeCallbacks.iterator();
                while (it.hasNext()) {
                    ((CarVolumeCallback) it.next()).onGroupVolumeChanged(i, i2, i3);
                }
            }

            @Override // android.car.media.ICarVolumeCallback
            public void onMasterMuteChanged(int i, int i2) {
                Iterator it = CarAudioManager.this.mCarVolumeCallbacks.iterator();
                while (it.hasNext()) {
                    ((CarVolumeCallback) it.next()).onMasterMuteChanged(i, i2);
                }
            }
        };
        this.mCarExtVolumeCallbackImpl = new ICarExtVolumeCallback.Stub() { // from class: android.car.media.CarAudioManager.2
            @Override // android.car.media.ICarExtVolumeCallback
            public void onGroupVolumeChanged(int i, int i2, int i3, int i4) {
                Iterator it = CarAudioManager.this.mCarExtVolumeCallbacks.iterator();
                while (it.hasNext()) {
                    ((CarExtVolumeCallback) it.next()).onGroupVolumeChanged(i, i2, i3, i4);
                }
            }

            @Override // android.car.media.ICarExtVolumeCallback
            public void onGroupMuteChanged(int i, int i2, boolean z, int i3) {
                Iterator it = CarAudioManager.this.mCarExtVolumeCallbacks.iterator();
                while (it.hasNext()) {
                    ((CarExtVolumeCallback) it.next()).onGroupMuteChanged(i, i2, z, i3);
                }
            }
        };
        this.mCarAudioFocusCallbackImpl = new ICarAudioFocusCallback.Stub() { // from class: android.car.media.CarAudioManager.3
            @Override // android.car.media.ICarAudioFocusCallback
            public void onAudioFocusGrant(String str, int i, int i2, int i3) {
                Iterator it = CarAudioManager.this.mCarAudioFocusCallbacks.iterator();
                while (it.hasNext()) {
                    ((CarAudioFocusCallback) it.next()).onAudioFocusGrant(str, i, i2, i3);
                }
            }

            @Override // android.car.media.ICarAudioFocusCallback
            public void onAudioFocusLoss(String str, int i, int i2, boolean z) {
                Iterator it = CarAudioManager.this.mCarAudioFocusCallbacks.iterator();
                while (it.hasNext()) {
                    ((CarAudioFocusCallback) it.next()).onAudioFocusLoss(str, i, i2, z);
                }
            }
        };
        this.mCarCustomSettingCallbackImpl = new ICarCustomSettingCallback.Stub() { // from class: android.car.media.CarAudioManager.4
            @Override // android.car.media.ICarCustomSettingCallback
            public void onEnableChanged(int i, int i2, boolean z) {
                Iterator it = CarAudioManager.this.mCarCustomSettingCallbacks.iterator();
                while (it.hasNext()) {
                    CarCustomSettingCallback carCustomSettingCallback = (CarCustomSettingCallback) it.next();
                    Log.i(CarLibLog.TAG_CAR, "onEnableChanged callback=" + carCustomSettingCallback);
                    carCustomSettingCallback.onEnableChanged(i, i2, z);
                }
            }

            @Override // android.car.media.ICarCustomSettingCallback
            public void onValueChanged(int i, int i2, String[] strArr) {
                Iterator it = CarAudioManager.this.mCarCustomSettingCallbacks.iterator();
                while (it.hasNext()) {
                    CarCustomSettingCallback carCustomSettingCallback = (CarCustomSettingCallback) it.next();
                    Log.i(CarLibLog.TAG_CAR, "onValueChanged callback=" + carCustomSettingCallback);
                    carCustomSettingCallback.onValueChanged(i, i2, strArr);
                }
            }
        };
        this.mService = ICarAudio.Stub.asInterface(iBinder);
        this.mAudioManager = (AudioManager) getContext().getSystemService(AudioManager.class);
        this.mCarVolumeCallbacks = new CopyOnWriteArrayList<>();
        this.mCarExtVolumeCallbacks = new CopyOnWriteArrayList<>();
        this.mCarAudioFocusCallbacks = new CopyOnWriteArrayList<>();
        this.mCarCustomSettingCallbacks = new CopyOnWriteArrayList<>();
    }

    public void registerCarVolumeCallback(CarVolumeCallback carVolumeCallback) {
        Objects.requireNonNull(carVolumeCallback);
        if (this.mCarVolumeCallbacks.isEmpty()) {
            registerVolumeCallback();
        }
        this.mCarVolumeCallbacks.add(carVolumeCallback);
    }

    public void unregisterCarVolumeCallback(CarVolumeCallback carVolumeCallback) {
        Objects.requireNonNull(carVolumeCallback);
        if (this.mCarVolumeCallbacks.remove(carVolumeCallback) && this.mCarVolumeCallbacks.isEmpty()) {
            unregisterVolumeCallback();
        }
    }

    public void registerCarVolumeCallback(CarExtVolumeCallback carExtVolumeCallback) {
        Objects.requireNonNull(carExtVolumeCallback);
        if (this.mCarExtVolumeCallbacks.isEmpty()) {
            registerExtVolumeCallback();
        }
        this.mCarExtVolumeCallbacks.add(carExtVolumeCallback);
    }

    public void unregisterCarVolumeCallback(CarExtVolumeCallback carExtVolumeCallback) {
        Objects.requireNonNull(carExtVolumeCallback);
        if (this.mCarExtVolumeCallbacks.remove(carExtVolumeCallback) && this.mCarExtVolumeCallbacks.isEmpty()) {
            unregisterExtVolumeCallback();
        }
    }

    private void registerVolumeCallback() {
        try {
            this.mService.registerVolumeCallback(this.mCarVolumeCallbackImpl.asBinder());
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "registerVolumeCallback failed", e);
        }
    }

    private void unregisterVolumeCallback() {
        try {
            this.mService.unregisterVolumeCallback(this.mCarVolumeCallbackImpl.asBinder());
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    private void registerExtVolumeCallback() {
        try {
            this.mService.registerExtVolumeCallback(this.mCarExtVolumeCallbackImpl.asBinder());
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "registerVolumeCallback failed", e);
        }
    }

    private void unregisterExtVolumeCallback() {
        try {
            this.mService.unregisterExtVolumeCallback(this.mCarExtVolumeCallbackImpl.asBinder());
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public void registerCarAudioFocusCallback(CarAudioFocusCallback carAudioFocusCallback) {
        Objects.requireNonNull(carAudioFocusCallback);
        if (this.mCarAudioFocusCallbacks.isEmpty()) {
            registerAudioFocusCallback();
        }
        this.mCarAudioFocusCallbacks.add(carAudioFocusCallback);
    }

    public void unregisterCarAudioFocusCallback(CarAudioFocusCallback carAudioFocusCallback) {
        Objects.requireNonNull(carAudioFocusCallback);
        if (this.mCarAudioFocusCallbacks.remove(carAudioFocusCallback) && this.mCarAudioFocusCallbacks.isEmpty()) {
            unregisterAudioFocusCallback();
        }
    }

    private void registerAudioFocusCallback() {
        try {
            this.mService.registerAudioFocusCallback(0, this.mCarAudioFocusCallbackImpl.asBinder());
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "registerAudioFocusCallback failed", e);
        }
    }

    private void unregisterAudioFocusCallback() {
        try {
            this.mService.unregisterAudioFocusCallback(0, this.mCarAudioFocusCallbackImpl.asBinder());
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public void registerCarCustomSettingCallback(CarCustomSettingCallback carCustomSettingCallback) {
        Objects.requireNonNull(carCustomSettingCallback);
        Log.i(CarLibLog.TAG_CAR, "registerCarCustomSettingCallback callback=" + carCustomSettingCallback);
        if (this.mCarCustomSettingCallbacks.isEmpty()) {
            registerCustomSettingCallback();
        }
        this.mCarCustomSettingCallbacks.add(carCustomSettingCallback);
    }

    public void unregisterCarCustomSettingCallback(CarCustomSettingCallback carCustomSettingCallback) {
        Objects.requireNonNull(carCustomSettingCallback);
        if (this.mCarCustomSettingCallbacks.remove(carCustomSettingCallback) && this.mCarCustomSettingCallbacks.isEmpty()) {
            unregisterCustomSettingCallback();
        }
    }

    private void registerCustomSettingCallback() {
        try {
            this.mService.registerCustomSettingCallback(this.mCarCustomSettingCallbackImpl.asBinder());
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "registerCustomSettingCallback failed", e);
        }
    }

    private void unregisterCustomSettingCallback() {
        try {
            this.mService.unregisterCustomSettingCallback(this.mCarCustomSettingCallbackImpl.asBinder());
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    private List<AudioDeviceInfo> convertInputDevicesToDeviceInfos(List<AudioDeviceAttributes> list, int i) {
        int size = list.size();
        HashSet hashSet = new HashSet(size);
        for (int i2 = 0; i2 < size; i2++) {
            hashSet.add(list.get(i2).getAddress());
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (AudioDeviceInfo audioDeviceInfo : this.mAudioManager.getDevices(i)) {
            if (audioDeviceInfo.isSource() && hashSet.contains(audioDeviceInfo.getAddress())) {
                arrayList.add(audioDeviceInfo);
            }
        }
        return arrayList;
    }
}
