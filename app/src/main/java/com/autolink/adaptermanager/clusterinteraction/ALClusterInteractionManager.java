package com.autolink.adaptermanager.clusterinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.clusterinteraction.IAFCPHKMValueCallback;
import com.autolink.adapterinterface.clusterinteraction.IAFCValueCallback;
import com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvgElecCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvgElecCnsCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvgFuCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvgFuCnsCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvgSpdValueCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvmCameraStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvmLogDataCallback;
import com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.IBootMusicPlayStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.ICCODisplayStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.IChargeCurrentCallback;
import com.autolink.adapterinterface.clusterinteraction.IChargePowerCallback;
import com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback;
import com.autolink.adapterinterface.clusterinteraction.IChargeViewStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.IChargeVoltageCallback;
import com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback;
import com.autolink.adapterinterface.clusterinteraction.IClusterFontCallback;
import com.autolink.adapterinterface.clusterinteraction.IClusterInteraction;
import com.autolink.adapterinterface.clusterinteraction.IClusterLeftWarningCallback;
import com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback;
import com.autolink.adapterinterface.clusterinteraction.IClusterThemeCallback;
import com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback;
import com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback;
import com.autolink.adapterinterface.clusterinteraction.IDriveTimeCallback;
import com.autolink.adapterinterface.clusterinteraction.IDriverModeCallback;
import com.autolink.adapterinterface.clusterinteraction.IDteAFCValueCallback;
import com.autolink.adapterinterface.clusterinteraction.IDteCalculateValueCallback;
import com.autolink.adapterinterface.clusterinteraction.IDteValueCallback;
import com.autolink.adapterinterface.clusterinteraction.IEnergyCurveProjectionCallback;
import com.autolink.adapterinterface.clusterinteraction.IFuelAddEventCallback;
import com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback;
import com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback;
import com.autolink.adapterinterface.clusterinteraction.IFuelVolumeSampleCallback;
import com.autolink.adapterinterface.clusterinteraction.IGaugeSpeedValueCallback;
import com.autolink.adapterinterface.clusterinteraction.IIFECallback;
import com.autolink.adapterinterface.clusterinteraction.IMainTankResistanceCallback;
import com.autolink.adapterinterface.clusterinteraction.IMotorDteValueCallback;
import com.autolink.adapterinterface.clusterinteraction.INaviInfoStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.INaviProjectionStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.IOverFillStateCallback;
import com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback;
import com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.IRearviewMirrorStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.ISteeringAngleCallback;
import com.autolink.adapterinterface.clusterinteraction.IStrStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.ISubTankResistanceCallback;
import com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback;
import com.autolink.adapterinterface.clusterinteraction.IThemeSwitchCompleteCallback;
import com.autolink.adapterinterface.clusterinteraction.ITimeFormatChangedCallback;
import com.autolink.adapterinterface.clusterinteraction.ITorqueLockStatusCallback;
import com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback;
import com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo;
import com.autolink.adapterinterface.clusterinteraction.IXModeDisplayStatusCallback;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.ALLog;
import com.autolink.adaptermanager.IALManager;
import com.autolink.hmi.crosscountry.utils.networkutils.Constant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/* loaded from: classes.dex */
public class ALClusterInteractionManager extends ALBaseManager implements IALManager {
    private static final String TAG = "ALClusterInteractionManager";
    private HandlerThread handlerThread;
    private CopyOnWriteArrayList<ALAFCListener> mAFCListeners;
    private CopyOnWriteArrayList<ALAFCPHKMListener> mAFCPHKMListeners;
    private IAFCPHKMValueCallback mAFCPHKMValueCallback;
    private IAFCValueCallback mAFCValueCallback;
    private IApaStatusCallback mApaStatusCallback;
    private CopyOnWriteArrayList<ALApaStatusListener> mApaStatusListeners;
    private IAvgElecCallback mAvgElecCallback;
    private IAvgElecCnsCallback mAvgElecCnsCallback;
    private CopyOnWriteArrayList<ALAvgElecCnsListener> mAvgElecCnsListeners;
    private CopyOnWriteArrayList<ALAvgElecListener> mAvgElecListeners;
    private IAvgFuCallback mAvgFuCallback;
    private IAvgFuCnsCallback mAvgFuCnsCallback;
    private CopyOnWriteArrayList<ALAvgFuCnsListener> mAvgFuCnsListeners;
    private CopyOnWriteArrayList<ALAvgFuListener> mAvgFuListeners;
    private IAvgSpdValueCallback mAvgSpdCallback;
    private CopyOnWriteArrayList<ALAvgSpdListener> mAvgSpdListeners;
    private IAvmCameraStatusCallback mAvmCameraStatusCallback;
    private CopyOnWriteArrayList<ALAvmCameraStatusListener> mAvmCameraStatusListeners;
    private IAvmLogDataCallback mAvmLogDataCallback;
    private CopyOnWriteArrayList<ALAvmLogDataListener> mAvmLogDataListeners;
    private IAvmStatusCallback mAvmStatusCallback;
    private CopyOnWriteArrayList<ALAvmStatusListener> mAvmStatusListeners;
    private IBootMusicPlayStatusCallback mBootMusicPlayStatusCallback;
    private CopyOnWriteArrayList<ALBootMusicPlayStatusListener> mBootMusicPlayStatusListeners;
    private ICCODisplayStatusCallback mCCODisplayStatusCallback;
    private CopyOnWriteArrayList<ALCCODisplayStatusListener> mCCODisplayStatusListeners;
    private IChargeCurrentCallback mChargeCurrentCallback;
    private CopyOnWriteArrayList<ALChargeCurrentListener> mChargeCurrentListeners;
    private CopyOnWriteArrayList<ALChargeInfoListener> mChargeInfoListeners;
    private IChargePowerCallback mChargePowerCallback;
    private IChargePowerInfoCallback mChargePowerInfoCallback;
    private CopyOnWriteArrayList<ALChargePowerListener> mChargePowerListeners;
    private IChargeViewStatusCallback mChargeViewStatusCallback;
    private CopyOnWriteArrayList<ALChargeViewStatusListener> mChargeViewStatusListeners;
    private IChargeVoltageCallback mChargeVoltageCallback;
    private CopyOnWriteArrayList<ALChargeVoltageListener> mChargeVoltageListeners;
    private ICltcOrWltcCallback mCltcOrWltcCallback;
    private CopyOnWriteArrayList<ALCltcOrWltcListener> mCltcOrWltcListeners;
    private IClusterFontCallback mClusterFontCallback;
    private CopyOnWriteArrayList<ALClusterFontListener> mClusterFontListeners;
    private IClusterThemeCallback mClusterThemeCallback;
    private CopyOnWriteArrayList<ALClusterThemeListener> mClusterThemeListeners;
    private IDiagDtcInfoCallback mDiagDtcInfoCallback;
    private CopyOnWriteArrayList<ALDiagDtcInfoListener> mDiagDtcInfoListeners;
    private IDoorOpenCallback mDoorOpenCallback;
    private CopyOnWriteArrayList<ALDoorOpenListener> mDoorOpenListeners;
    private IDriveTimeCallback mDriveTimeCallback;
    private CopyOnWriteArrayList<ALDriveTimeListener> mDriveTimeListeners;
    private IDriverModeCallback mDriverModeCallback;
    private CopyOnWriteArrayList<ALDriverModeListener> mDriverModeListeners;
    private CopyOnWriteArrayList<ALDteAFCListener> mDteAFCListeners;
    private IDteAFCValueCallback mDteAfcCallback;
    private CopyOnWriteArrayList<ALDteCalculateValueListener> mDteCalValueListeners;
    private IDteCalculateValueCallback mDteCalculateValueCallback;
    private IDteValueCallback mDteValueCallback;
    private CopyOnWriteArrayList<ALDteValueListener> mDteValueListeners;
    private IEnergyCurveProjectionCallback mEnergyCurveProjectionCallback;
    private CopyOnWriteArrayList<ALEnergyCurveProjectionListener> mEnergyCurveProjectionListeners;
    private IFuelAddEventCallback mFuelAddEventCallback;
    private CopyOnWriteArrayList<ALFuelAddEventListener> mFuelAddEventListeners;
    private IFuelTankTypeCallback mFuelTankTypeCallback;
    private CopyOnWriteArrayList<ALFuelTankTypeListener> mFuelTankTypeListeners;
    private CopyOnWriteArrayList<ALFuelVolumeDisplayListener> mFuelVolumeDisplayListeners;
    private IFuelVolumeDisplayCallback mFuelVolumeDspCallback;
    private CopyOnWriteArrayList<ALFuelVolumeSampleListener> mFuelVolumeSampleListeners;
    private IFuelVolumeSampleCallback mFuelVolumeSpCallback;
    private IGaugeSpeedValueCallback mGaugeSpeedCallback;
    private CopyOnWriteArrayList<ALGaugeSpeedListener> mGaugeSpeedListeners;
    private IIFECallback mIFECallback;
    private CopyOnWriteArrayList<ALIFEListener> mIFEListeners;
    private IClusterNotifyKeytoneCallback mKeytoneCallback;
    private CopyOnWriteArrayList<ALKeytoneListener> mKeytoneListeners;
    private CopyOnWriteArrayList<ALLeftSideWarningListener> mLeftSideWarningListeners;
    private IClusterLeftWarningCallback mLeftWarningCallback;
    private IMainTankResistanceCallback mMainTankResistanceCallback;
    private CopyOnWriteArrayList<ALMainTankResistanceListener> mMainTankResistanceListeners;
    private IPayloadMaintanceDistanceCallback mMaintanceDistanceCallback;
    private CopyOnWriteArrayList<ALPayloadMaintanceDistanceListener> mMaintanceDistanceListeners;
    private ManagerHandler mManagerHandler;
    private IMotorDteValueCallback mMotorDteValueCallback;
    private CopyOnWriteArrayList<ALMotorDteValueListener> mMotorDteValueListeners;
    private INaviInfoStatusCallback mNaviInfoCallback;
    private CopyOnWriteArrayList<ALNaviInfoStatusListener> mNaviInfoListeners;
    private INaviProjectionStatusCallback mNaviProjectionStatusCallback;
    private CopyOnWriteArrayList<ALNaviProjectionStatusListener> mNaviProjectionStatusListeners;
    private IOverFillStateCallback mOverFillStateCallback;
    private CopyOnWriteArrayList<ALOverFillStateListener> mOverFillStateListeners;
    private IRadarWarningStatusCallback mRadarWarningStatusCallback;
    private CopyOnWriteArrayList<ALRadarWarningStatusListener> mRadarWarningStatusListeners;
    private IRearviewMirrorStatusCallback mRearviewMirrorStatusCallback;
    private CopyOnWriteArrayList<ALRearviewMirrorStatusListener> mRearviewMirrorStatusListeners;
    private IClusterInteraction mService;
    private ISteeringAngleCallback mSteeringAngleCallback;
    private CopyOnWriteArrayList<ALSteeringAngleListener> mSteeringAngleListeners;
    private IStrStatusCallback mStrStatusCallback;
    private CopyOnWriteArrayList<ALStrStatusListener> mStrStatusListeners;
    private ISubTankResistanceCallback mSubTankResistanceCallback;
    private CopyOnWriteArrayList<ALSubTankResistanceListener> mSubTankResistanceListeners;
    private ITemperatureHighCallback mTemperatureHighCallback;
    private CopyOnWriteArrayList<ALTemperatureHighListener> mTemperatureHighListeners;
    private IThemeSwitchCompleteCallback mThemeSwitchCallback;
    private CopyOnWriteArrayList<ALThemeSwitchCompleteListener> mThemeSwitchListeners;
    private ITimeFormatChangedCallback mTimeFormatCallback;
    private CopyOnWriteArrayList<ALTimeFormatListener> mTimeFormatListeners;
    private ITorqueLockStatusCallback mTorqueLockStatusCallback;
    private CopyOnWriteArrayList<ALTorqueLockStatusListener> mTorqueLockStatusListeners;
    private ITyreTemperatureCallback mTyreTemperatureCallback;
    private CopyOnWriteArrayList<ALTyreTemperatureListener> mTyreTemperatureListeners;
    private IVehicleFaultInfo mVehicleFaultInfo;
    private CopyOnWriteArrayList<ALVehicleFaultInfoListener> mVehicleFaultInfoListeners;
    private IXModeDisplayStatusCallback mXModeDisplayStatusCallback;
    private CopyOnWriteArrayList<ALXModeDisplayStatusListener> mXModeDisplayStatusListeners;

    public interface ALAFCListener {
        void onAFCValueChanged(int i);
    }

    public interface ALAFCPHKMListener {
        void onAFCPHKMValueChanged(int i);
    }

    public interface ALApaStatusListener {
        void onApaClosedBySpeed();

        void onApaStatusChanged(boolean z);
    }

    public interface ALAvgElecCnsListener {
        void onAvgElecCnsChanged(float f);
    }

    public interface ALAvgElecListener {
        void onAvgElecChanged(float f);
    }

    public interface ALAvgFuCnsListener {
        void onAvgFuCnsChanged(float f);
    }

    public interface ALAvgFuListener {
        void onAvgFuChanged(float f);
    }

    public interface ALAvgSpdListener {
        void onAvgSpdValueChanged(int i);
    }

    public interface ALAvmCameraStatusListener {
        void onAvmCameraStatusCallback(AvmCameraPos avmCameraPos, int i);
    }

    public interface ALAvmLogDataListener {
        void onAvmLogDataCallback(LogType logType, int i);
    }

    public interface ALAvmStatusListener {
        void onAvmClosedBySpeed();

        void onAvmStatusChanged(boolean z);
    }

    public interface ALBootMusicPlayStatusListener {
        void onBootMusicPlayStatus(BootSoundStatus bootSoundStatus);
    }

    public interface ALCCODisplayStatusListener {
        void onCCODisplayStatusChanged(CCODisplayStatus cCODisplayStatus);
    }

    public interface ALChargeCurrentListener {
        void onChargeCurrentChanged(float f);
    }

    public interface ALChargeInfoListener {
        void onChargePowerInfoChanged(float f, float f2, float f3);
    }

    public interface ALChargePowerListener {
        void onChargePowerChanged(float f);
    }

    public interface ALChargeViewStatusListener {
        void onChargeViewStatusChanged(int i);
    }

    public interface ALChargeVoltageListener {
        void onChargeVoltageChanged(float f);
    }

    public interface ALCltcOrWltcListener {
        void onCltcOrWltcModeChanged(CltcOrWltcMode cltcOrWltcMode);
    }

    public interface ALClusterFontListener {
        void onClusterFontChanged(int i);
    }

    public interface ALClusterThemeListener {
        void onClusterThemeChanged(ClusterThemeMode clusterThemeMode);
    }

    public interface ALDiagDtcInfoListener {
        void onDiagDtcInfoCb(DtcInfo dtcInfo, int i);
    }

    public interface ALDoorOpenListener {
        void onDoorOpen();
    }

    public interface ALDriveTimeListener {
        void onDriveTimeChanged(int i);
    }

    public interface ALDriverModeListener {
        void onDriverModeChanged(DriverModeType driverModeType);
    }

    public interface ALDteAFCListener {
        void onDteAFCValueChanged(float f);
    }

    public interface ALDteCalculateValueListener {
        void onDteCalculateValueChanged(int i);
    }

    public interface ALDteValueListener {
        void onDteValueChanged(int i);

        void onGaugeFuelPercentChanged(int i);
    }

    public interface ALEnergyCurveProjectionListener {
        void onEnergyCurveProjectionStatusChanged(EnergyCurveProjectionStatus energyCurveProjectionStatus);
    }

    public interface ALFuelAddEventListener {
        void onFuelAddEventCallback(int i);
    }

    public interface ALFuelTankTypeListener {
        void onFuelTankTypeChanged(int i);
    }

    public interface ALFuelVolumeDisplayListener {
        void onFuelVolumeDisplayValueChanged(float f);
    }

    public interface ALFuelVolumeSampleListener {
        void onFuelVolumeSampleValueChanged(float f);
    }

    public interface ALGaugeSpeedListener {
        void onSpeedValueChanged(float f);
    }

    public interface ALIFEListener {
        void onIFEValueChanged(int i);
    }

    public interface ALKeytoneListener {
        void onKeytone();
    }

    public interface ALLeftSideWarningListener {
        void onLeftSideWarningDisplay(boolean z);
    }

    public interface ALMainTankResistanceListener {
        void onMainTankResistanceChanged(int i);
    }

    public interface ALMotorDteValueListener {
        void onMotorDteValueChanged(int i);
    }

    public interface ALNaviInfoStatusListener {
        void onNaviInfoStatusChanged(NaviCmd naviCmd);
    }

    public interface ALNaviProjectionStatusListener {
        void onNaviProjectionStatusChanged(NaviProjectionStatus naviProjectionStatus);
    }

    public interface ALOverFillStateListener {
        void onOverFillStateCallback(int i);
    }

    public interface ALPayloadMaintanceDistanceListener {
        void onPayloadMaintanceDistanceChanged(int i);
    }

    public interface ALRadarWarningStatusListener {
        void onRadarWarningStatusChanged(boolean z);
    }

    public interface ALRearviewMirrorStatusListener {
        void onRearviewMirrorStatusChanged(RearViewKeyStatus rearViewKeyStatus);
    }

    public interface ALSteeringAngleListener {
        void onSteeringAngleChanged(int i);
    }

    public interface ALStrStatusListener {
        void onStrStatusChanged(StrSwitchStatusCmd strSwitchStatusCmd, boolean z);
    }

    public interface ALSubTankResistanceListener {
        void onSubTankResistanceChanged(int i);
    }

    public interface ALTemperatureHighListener {
        void onIviTemperatureHigh();
    }

    public interface ALThemeSwitchCompleteListener {
        void onSwitchComplete(int i);
    }

    public interface ALTimeFormatListener {
        void onTimeFormatChanged(int i);
    }

    public interface ALTorqueLockStatusListener {
        void onTorqueLockStatusChanged(TorqueLockStatus torqueLockStatus);
    }

    public interface ALTyreTemperatureListener {
        void onLFTyreTempChanged(int i);

        void onLRTyreTempChanged(int i);

        void onRFTyreTempChanged(int i);

        void onRRTyreTempChanged(int i);
    }

    public interface ALVehicleFaultInfoListener {
        void onVehicleFaultInfoChanged(int[] iArr);
    }

    public interface ALXModeDisplayStatusListener {
        void onXModeDisplayStatusChanged(XModeDisplayStatus xModeDisplayStatus);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
    }

    public enum DriverModeType {
        DRIVER_MODE_ECO(0),
        DRIVER_MODE_NORMAL(1),
        DRIVER_MODE_SPORT(2),
        DRIVER_MODE_SNOW(3),
        DRIVER_MODE_MUD(4),
        DRIVER_MODE_ROCK(5),
        DRIVER_MODE_OFF_LOAD(6),
        DRIVER_MODE_SAND(7),
        DRIVER_MODE_INVALD(8),
        INVALID_VALUE(-1);

        private final int value;

        DriverModeType(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriverModeType forNumber(int i) {
            switch (i) {
                case -1:
                    return INVALID_VALUE;
                case 0:
                    return DRIVER_MODE_ECO;
                case 1:
                    return DRIVER_MODE_NORMAL;
                case 2:
                    return DRIVER_MODE_SPORT;
                case 3:
                    return DRIVER_MODE_SNOW;
                case 4:
                    return DRIVER_MODE_MUD;
                case 5:
                    return DRIVER_MODE_ROCK;
                case 6:
                    return DRIVER_MODE_OFF_LOAD;
                case 7:
                    return DRIVER_MODE_SAND;
                case 8:
                    return DRIVER_MODE_INVALD;
                default:
                    return null;
            }
        }
    }

    public enum RearViewKeyStatus {
        REARVIEWKEY_ON(0),
        REARVIEWKEY_OFF(1);

        private final int value;

        RearViewKeyStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static RearViewKeyStatus forNumber(int i) {
            if (i == 0) {
                return REARVIEWKEY_ON;
            }
            if (i != 1) {
                return null;
            }
            return REARVIEWKEY_OFF;
        }
    }

    public enum FuelUnit {
        KM_L(1),
        L_100KM(2);

        private final int value;

        FuelUnit(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static FuelUnit forNumber(int i) {
            if (i == 1) {
                return KM_L;
            }
            if (i != 2) {
                return null;
            }
            return L_100KM;
        }
    }

    public enum TorqueLockStatus {
        AWD_LOCK_STATUS_NO_DISPLAY(0),
        AWD_LOCK_STATUS_CLOSE(1),
        AWD_LOCK_STATUS_OPEN(2),
        ELSD_LOCK_STATUS_NO_DISPLAY(3),
        ELSD_LOCK_STATUS_CLOSE(4),
        ELSD_LOCK_STATUS_OPEN(5),
        PHEV_ELSD_LOCK_STATUS_NO_DISPLAY(6),
        PHEV_ELSD_LOCK_STATUS_CLOSE_1(7),
        PHEV_ELSD_LOCK_STATUS_CLOSE_2(8),
        ELSD_LOCK_STATUS_OPEN_1(9),
        ELSD_LOCK_STATUS_OPEN_2(10),
        PHEV_ELSD_LOCK_STATUS_CLOSE_3(11);

        private final int value;

        TorqueLockStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static TorqueLockStatus forNumber(int i) {
            switch (i) {
                case 0:
                    return AWD_LOCK_STATUS_NO_DISPLAY;
                case 1:
                    return AWD_LOCK_STATUS_CLOSE;
                case 2:
                    return AWD_LOCK_STATUS_OPEN;
                case 3:
                    return ELSD_LOCK_STATUS_NO_DISPLAY;
                case 4:
                    return ELSD_LOCK_STATUS_CLOSE;
                case 5:
                    return ELSD_LOCK_STATUS_OPEN;
                case 6:
                    return PHEV_ELSD_LOCK_STATUS_NO_DISPLAY;
                case 7:
                    return PHEV_ELSD_LOCK_STATUS_CLOSE_1;
                case 8:
                    return PHEV_ELSD_LOCK_STATUS_CLOSE_2;
                case 9:
                    return ELSD_LOCK_STATUS_OPEN_1;
                case 10:
                    return ELSD_LOCK_STATUS_OPEN_2;
                case 11:
                    return PHEV_ELSD_LOCK_STATUS_CLOSE_3;
                default:
                    return null;
            }
        }
    }

    public enum NaviInfoStatus {
        NAVIGATION_INFO_VALID(1),
        NAVIGATION_INFO_INVALID(2);

        private final int value;

        NaviInfoStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static NaviInfoStatus forNumber(int i) {
            if (i == 1) {
                return NAVIGATION_INFO_VALID;
            }
            if (i != 2) {
                return null;
            }
            return NAVIGATION_INFO_INVALID;
        }
    }

    public enum NaviCmd {
        FULL_SCREEN_ENTER(1),
        FULL_SCREEN_EXIT(2),
        MINI_SCREEN_ENTER(3),
        MINI_SCREEN_EXIT(4),
        PULL_SCREEN_FAILED(5);

        private final int value;

        NaviCmd(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static NaviCmd forNumber(int i) {
            if (i == 1) {
                return FULL_SCREEN_ENTER;
            }
            if (i == 2) {
                return FULL_SCREEN_EXIT;
            }
            if (i == 3) {
                return MINI_SCREEN_ENTER;
            }
            if (i == 4) {
                return MINI_SCREEN_EXIT;
            }
            if (i != 5) {
                return null;
            }
            return PULL_SCREEN_FAILED;
        }
    }

    public enum DriverAction {
        DRIVER_ACTION_NONE(1),
        DRIVER_ACTION_CALL(2),
        DRIVER_ACTION_DRINK(3),
        DRIVER_ACTION_SMOKE(4),
        DRIVER_ACTION_INVALID(255);

        private final int value;

        DriverAction(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriverAction forNumber(int i) {
            if (i == 1) {
                return DRIVER_ACTION_NONE;
            }
            if (i == 2) {
                return DRIVER_ACTION_CALL;
            }
            if (i == 3) {
                return DRIVER_ACTION_DRINK;
            }
            if (i == 4) {
                return DRIVER_ACTION_SMOKE;
            }
            if (i != 255) {
                return null;
            }
            return DRIVER_ACTION_INVALID;
        }
    }

    public enum DriverDistractionLevel {
        DRIVER_DISTRACTION_LEVEL_NONE(1),
        DRIVER_DISTRACTION_LEVEL_LIGHT(2),
        DRIVER_DISTRACTION_LEVEL_MEDIUM(3),
        DRIVER_DISTRACTION_LEVEL_HEAVEY(4),
        DRIVER_DISTRACTION_LEVEL_INVALID(255);

        private final int value;

        DriverDistractionLevel(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriverDistractionLevel forNumber(int i) {
            if (i == 1) {
                return DRIVER_DISTRACTION_LEVEL_NONE;
            }
            if (i == 2) {
                return DRIVER_DISTRACTION_LEVEL_LIGHT;
            }
            if (i == 3) {
                return DRIVER_DISTRACTION_LEVEL_MEDIUM;
            }
            if (i == 4) {
                return DRIVER_DISTRACTION_LEVEL_HEAVEY;
            }
            if (i != 255) {
                return null;
            }
            return DRIVER_DISTRACTION_LEVEL_INVALID;
        }
    }

    public enum DriverDrowsinessLevel {
        DRIVER_DROWSINESS_LEVEL_NONE(1),
        DRIVER_DROWSINESS_LEVEL_LIGHT(2),
        DRIVER_DROWSINESS_LEVEL_MEDIUM(3),
        DRIVER_DROWSINESS_LEVEL_HEAVEY(4),
        DRIVER_DROWSINESS_LEVEL_INVALID(255);

        private final int value;

        DriverDrowsinessLevel(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriverDrowsinessLevel forNumber(int i) {
            if (i == 1) {
                return DRIVER_DROWSINESS_LEVEL_NONE;
            }
            if (i == 2) {
                return DRIVER_DROWSINESS_LEVEL_LIGHT;
            }
            if (i == 3) {
                return DRIVER_DROWSINESS_LEVEL_MEDIUM;
            }
            if (i == 4) {
                return DRIVER_DROWSINESS_LEVEL_HEAVEY;
            }
            if (i != 255) {
                return null;
            }
            return DRIVER_DROWSINESS_LEVEL_INVALID;
        }
    }

    public enum FunctionRoler {
        QNX_ROLER(1),
        ANDROID_ACCOUNT_ROLER(2),
        ANDROID_HEATLTH_ROLER(3),
        ANDROID_DRIVER_ROLER(4),
        ANDROID_OMS_ROLER(5),
        ROLER_ALL(6);

        private final int value;

        FunctionRoler(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static FunctionRoler forNumber(int i) {
            switch (i) {
                case 1:
                    return QNX_ROLER;
                case 2:
                    return ANDROID_ACCOUNT_ROLER;
                case 3:
                    return ANDROID_HEATLTH_ROLER;
                case 4:
                    return ANDROID_DRIVER_ROLER;
                case 5:
                    return ANDROID_OMS_ROLER;
                case 6:
                    return ROLER_ALL;
                default:
                    return null;
            }
        }
    }

    public enum XModeDisplayStatus {
        OFF(0),
        ON(1),
        CCO_ON(2);

        private final int value;

        XModeDisplayStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static XModeDisplayStatus forNumber(int i) {
            if (i == 0) {
                return OFF;
            }
            if (i == 1) {
                return ON;
            }
            if (i != 2) {
                return null;
            }
            return CCO_ON;
        }
    }

    public enum CCODisplayStatus {
        ACTIVE(0),
        OFF(1),
        ATCM_OFF(2),
        ENGINE_NOT_START(3),
        GEAR_NOT_D_OR_M1(4),
        DRIVER_DOOR_NOT_CLOSED(5),
        ACC_NOT_CLOSE(6),
        APA_NOT_CLOSE(7),
        XMODE_NOT_CLOSE(8),
        SPEED_OVER_15(9),
        DRIVE_MODE_NOT_MUD_OR_ROCK(10),
        ESP_OFF_NOT_START(11),
        CCO_STAND_BY(12),
        CCO_TRY_TO_START(13);

        private final int value;

        CCODisplayStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static CCODisplayStatus forNumber(int i) {
            switch (i) {
                case 0:
                    return ACTIVE;
                case 1:
                    return OFF;
                case 2:
                    return ATCM_OFF;
                case 3:
                    return ENGINE_NOT_START;
                case 4:
                    return GEAR_NOT_D_OR_M1;
                case 5:
                    return DRIVER_DOOR_NOT_CLOSED;
                case 6:
                    return ACC_NOT_CLOSE;
                case 7:
                    return APA_NOT_CLOSE;
                case 8:
                    return XMODE_NOT_CLOSE;
                case 9:
                    return SPEED_OVER_15;
                case 10:
                    return DRIVE_MODE_NOT_MUD_OR_ROCK;
                case 11:
                    return ESP_OFF_NOT_START;
                case 12:
                    return CCO_STAND_BY;
                case 13:
                    return CCO_TRY_TO_START;
                default:
                    return null;
            }
        }
    }

    public enum ApaEnterStyle {
        APA_ENTER_BY_APP(1),
        APA_ENTER_BY_VOICE(2),
        APA_CLOSE_BY_SPEED(3);

        private final int value;

        ApaEnterStyle(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ApaEnterStyle forNumber(int i) {
            if (i == 1) {
                return APA_ENTER_BY_APP;
            }
            if (i == 2) {
                return APA_ENTER_BY_VOICE;
            }
            if (i != 3) {
                return null;
            }
            return APA_CLOSE_BY_SPEED;
        }
    }

    public enum AvmEnterStyle {
        AVM_ENTER_BY_APP(1),
        AVM_ENTER_BY_VOICE(2),
        AVM_CLOSE_BY_SPEED(3);

        private final int value;

        AvmEnterStyle(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static AvmEnterStyle forNumber(int i) {
            if (i == 1) {
                return AVM_ENTER_BY_APP;
            }
            if (i == 2) {
                return AVM_ENTER_BY_VOICE;
            }
            if (i != 3) {
                return null;
            }
            return AVM_CLOSE_BY_SPEED;
        }
    }

    public enum StrSwitchStatusCmd {
        READ_STATUS_CMD(1),
        WRITE_STATUS_CMD(2);

        private final int value;

        StrSwitchStatusCmd(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static StrSwitchStatusCmd forNumber(int i) {
            if (i == 1) {
                return READ_STATUS_CMD;
            }
            if (i != 2) {
                return null;
            }
            return WRITE_STATUS_CMD;
        }
    }

    public enum DayNightModeValue {
        DAY_MODE(0),
        NIGHT_MODE(1),
        INVALID_MODE(2);

        private final int value;

        DayNightModeValue(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DayNightModeValue forNumber(int i) {
            if (i == 0) {
                return DAY_MODE;
            }
            if (i == 1) {
                return NIGHT_MODE;
            }
            if (i != 2) {
                return null;
            }
            return INVALID_MODE;
        }
    }

    public enum NaviStartupStatus {
        NAVI_STARTUP_COMPLETED(1),
        NAVI_STARTUP_NOT_COMPLETED(2);

        private final int value;

        NaviStartupStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static NaviStartupStatus forNumber(int i) {
            if (i == 1) {
                return NAVI_STARTUP_COMPLETED;
            }
            if (i != 2) {
                return null;
            }
            return NAVI_STARTUP_NOT_COMPLETED;
        }
    }

    public enum DriveMode {
        ECO_MODE(0),
        NORMAL_MODE(1),
        SPORT_MODE(2);

        private final int value;

        DriveMode(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriveMode forNumber(int i) {
            if (i == 0) {
                return ECO_MODE;
            }
            if (i == 1) {
                return NORMAL_MODE;
            }
            if (i != 2) {
                return null;
            }
            return SPORT_MODE;
        }
    }

    public enum CltcOrWltcMode {
        CLTC_MODE(0),
        WLTC_MODE(1);

        private final int value;

        CltcOrWltcMode(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static CltcOrWltcMode forNumber(int i) {
            if (i == 0) {
                return CLTC_MODE;
            }
            if (i != 1) {
                return null;
            }
            return WLTC_MODE;
        }
    }

    public enum LaneAssistMode {
        LDW(1),
        LKA(2),
        OFF(3);

        private final int value;

        LaneAssistMode(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static LaneAssistMode forNumber(int i) {
            if (i == 1) {
                return LDW;
            }
            if (i == 2) {
                return LKA;
            }
            if (i != 3) {
                return null;
            }
            return OFF;
        }
    }

    public enum LogType {
        AVM_OPEN_TYPE(1),
        AVM_CLOSE_TYPE(2),
        AVM_TURN_ACTIVE(3),
        AVM_STEER_ACTIVE(4),
        AVM_CAR_UNDER_SETTING(5),
        AVM_CAR_BODY_SETTING(6),
        AVM_RADAR_SETTING(7),
        AVM_CARPLATE_SETTING(8),
        AVM_RESET_SETTING(9),
        AVM_VIEW_TYPE(10),
        AVM_VIEW_TYPE_3D(11),
        AVM_VIEW_TYPE_2D(12),
        AVM_MIRRO_TYPE(13);

        private final int value;

        LogType(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static LogType forNumber(int i) {
            switch (i) {
                case 1:
                    return AVM_OPEN_TYPE;
                case 2:
                    return AVM_CLOSE_TYPE;
                case 3:
                    return AVM_TURN_ACTIVE;
                case 4:
                    return AVM_STEER_ACTIVE;
                case 5:
                    return AVM_CAR_UNDER_SETTING;
                case 6:
                    return AVM_CAR_BODY_SETTING;
                case 7:
                    return AVM_RADAR_SETTING;
                case 8:
                    return AVM_CARPLATE_SETTING;
                case 9:
                    return AVM_RESET_SETTING;
                case 10:
                    return AVM_VIEW_TYPE;
                case 11:
                    return AVM_VIEW_TYPE_3D;
                case 12:
                    return AVM_VIEW_TYPE_2D;
                case 13:
                    return AVM_MIRRO_TYPE;
                default:
                    return null;
            }
        }
    }

    public enum DtcInfo {
        CENTRAL_CONTROL_DISPLAY_FUNCTION_FAILURE(9640452),
        CENTRAL_CONTROL_DISPLAY_MODULE_FAILURE(9640708),
        CENTRAL_CONTROL_DISPLAY_TOUCH_FAILURE(9640964),
        CENTRAL_CONTROL_DISPLAY_BACKLIGHT_MODULE_FAILURE(9641220),
        CENTRAL_CONTROL_DISPLAY_VIDEO_SIGNAL_FAILURE(9641476),
        CENTRAL_CONTROL_DISPLAY_BACKLIGHT_LEVEL_MISSING(9641732),
        ICM_DISPLAY_FUNCTION_FAILURE(9571844),
        ICM_DISPLAY_MODULE_FAILURE(9572100),
        ICM_DISPLAY_BACKLIGHT_MODULE_FAILURE(9572356),
        ICM_DISPLAY_VIDEO_SIGNAL_FAILURE(9572612),
        ICM_DISPLAY_BACKLIGHT_LEVEL_MISSING(9572868);

        private final int value;

        DtcInfo(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DtcInfo forNumber(int i) {
            switch (i) {
                case 9571844:
                    return ICM_DISPLAY_FUNCTION_FAILURE;
                case 9572100:
                    return ICM_DISPLAY_MODULE_FAILURE;
                case 9572356:
                    return ICM_DISPLAY_BACKLIGHT_MODULE_FAILURE;
                case 9572612:
                    return ICM_DISPLAY_VIDEO_SIGNAL_FAILURE;
                case 9572868:
                    return ICM_DISPLAY_BACKLIGHT_LEVEL_MISSING;
                case 9640452:
                    return CENTRAL_CONTROL_DISPLAY_FUNCTION_FAILURE;
                case 9640708:
                    return CENTRAL_CONTROL_DISPLAY_MODULE_FAILURE;
                case 9640964:
                    return CENTRAL_CONTROL_DISPLAY_TOUCH_FAILURE;
                case 9641220:
                    return CENTRAL_CONTROL_DISPLAY_BACKLIGHT_MODULE_FAILURE;
                case 9641476:
                    return CENTRAL_CONTROL_DISPLAY_VIDEO_SIGNAL_FAILURE;
                case 9641732:
                    return CENTRAL_CONTROL_DISPLAY_BACKLIGHT_LEVEL_MISSING;
                default:
                    return null;
            }
        }
    }

    public enum BootSoundStatus {
        BOOT_SOUND_STATUS_OFF(1),
        BOOT_SOUND_STATUS_ON(2);

        private final int value;

        BootSoundStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static BootSoundStatus forNumber(int i) {
            if (i == 1) {
                return BOOT_SOUND_STATUS_OFF;
            }
            if (i != 2) {
                return null;
            }
            return BOOT_SOUND_STATUS_ON;
        }
    }

    public enum NaviProjectionStatus {
        NAVI_PROJECTION_SCREEN_NONE(1),
        NAVI_PROJECTION_SCREEN_MINI(2),
        NAVI_PROJECTION_SCREEN_FULL(3);

        private final int value;

        NaviProjectionStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static NaviProjectionStatus forNumber(int i) {
            if (i == 1) {
                return NAVI_PROJECTION_SCREEN_NONE;
            }
            if (i == 2) {
                return NAVI_PROJECTION_SCREEN_MINI;
            }
            if (i != 3) {
                return null;
            }
            return NAVI_PROJECTION_SCREEN_FULL;
        }
    }

    public enum AvmCameraPos {
        CAMERA_POS_RIGHT(1),
        CAMERA_POS_LEFT(2);

        private final int value;

        AvmCameraPos(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static AvmCameraPos forNumber(int i) {
            if (i == 1) {
                return CAMERA_POS_RIGHT;
            }
            if (i != 2) {
                return null;
            }
            return CAMERA_POS_LEFT;
        }
    }

    public enum ThemeMode {
        STANDARD(1),
        CROSS_COUNTRY(2),
        NAVIGATION(3);

        private final int value;

        ThemeMode(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ThemeMode forNumber(int i) {
            if (i == 1) {
                return STANDARD;
            }
            if (i == 2) {
                return CROSS_COUNTRY;
            }
            if (i != 3) {
                return null;
            }
            return NAVIGATION;
        }
    }

    public enum ClusterThemeMode {
        DIGITAL(1),
        CLASSIC(2),
        NAVIGATION(3);

        private final int value;

        ClusterThemeMode(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ClusterThemeMode forNumber(int i) {
            if (i == 1) {
                return DIGITAL;
            }
            if (i == 2) {
                return CLASSIC;
            }
            if (i != 3) {
                return null;
            }
            return NAVIGATION;
        }
    }

    public enum LanguageType {
        CHINESE(0),
        ENGLISH(1),
        ARABIC(2),
        SPANISH(3),
        RUSSIAN(4),
        UKRAINIAN(5),
        FARSI(6),
        PORTUGUESE(7),
        KAZAKH(8),
        ITALIAN(9),
        GERMAN(10),
        FRENCH(11),
        UZBEK(12);

        private final int value;

        LanguageType(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static LanguageType forNumber(int i) {
            switch (i) {
                case 0:
                    return CHINESE;
                case 1:
                    return ENGLISH;
                case 2:
                    return ARABIC;
                case 3:
                    return SPANISH;
                case 4:
                    return RUSSIAN;
                case 5:
                    return UKRAINIAN;
                case 6:
                    return FARSI;
                case 7:
                    return PORTUGUESE;
                case 8:
                    return KAZAKH;
                case 9:
                    return ITALIAN;
                case 10:
                    return GERMAN;
                case 11:
                    return FRENCH;
                case 12:
                    return UZBEK;
                default:
                    return null;
            }
        }
    }

    public enum EnergyCurveProjectionStatus {
        START_PROJECTION(1),
        STOP_PROJECTION(2);

        private final int value;

        EnergyCurveProjectionStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static EnergyCurveProjectionStatus forNumber(int i) {
            if (i == 1) {
                return START_PROJECTION;
            }
            if (i != 2) {
                return null;
            }
            return STOP_PROJECTION;
        }
    }

    public enum CarModelColor {
        WHITE(0),
        BLACK(1),
        GRAY(2),
        ORANGE(3),
        GREEN(4),
        LAKEBLUE(5),
        GOLDEN_PHEV(6),
        STEPLESSDIMMING(7);

        private final int value;

        CarModelColor(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static CarModelColor forNumber(int i) {
            switch (i) {
                case 0:
                    return WHITE;
                case 1:
                    return BLACK;
                case 2:
                    return GRAY;
                case 3:
                    return ORANGE;
                case 4:
                    return GREEN;
                case 5:
                    return LAKEBLUE;
                case 6:
                    return GOLDEN_PHEV;
                case 7:
                    return STEPLESSDIMMING;
                default:
                    return null;
            }
        }
    }

    public enum WallpaperStyle {
        STYLE_1(0),
        STYLE_2(1),
        STYLE_3(2);

        private final int value;

        WallpaperStyle(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static WallpaperStyle forNumber(int i) {
            if (i == 0) {
                return STYLE_1;
            }
            if (i == 1) {
                return STYLE_2;
            }
            if (i != 2) {
                return null;
            }
            return STYLE_3;
        }
    }

    @Deprecated
    public ALClusterInteractionManager(Context context) {
        super(context);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mDriverModeCallback = new IDriverModeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDriverModeCallback
            public void onDriverModeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 1, i, 0));
            }
        };
        this.mTorqueLockStatusCallback = new ITorqueLockStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.2
            AnonymousClass2() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITorqueLockStatusCallback
            public void onTorqueLockStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 2, i, 0));
            }
        };
        this.mDteCalculateValueCallback = new IDteCalculateValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.3
            AnonymousClass3() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteCalculateValueCallback
            public void onDteCalculateValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 49, i, 0));
            }
        };
        this.mDteValueCallback = new IDteValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.4
            AnonymousClass4() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
            public void onDteValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 3, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
            public void onGaugeFuelPercentChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 4, i, 0));
            }
        };
        this.mMotorDteValueCallback = new IMotorDteValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.5
            AnonymousClass5() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IMotorDteValueCallback
            public void onMotorDteValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 29, i, 0));
            }
        };
        this.mTemperatureHighCallback = new ITemperatureHighCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.6
            AnonymousClass6() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback
            public void onIviTemperatureHigh() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 5));
            }
        };
        this.mDiagDtcInfoCallback = new IDiagDtcInfoCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.7
            AnonymousClass7() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback
            public void onDiagDtcInfoCb(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 25, i, i2));
            }
        };
        this.mNaviInfoCallback = new INaviInfoStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.8
            AnonymousClass8() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.INaviInfoStatusCallback
            public void onNaviInfoStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 6, i, 0));
            }
        };
        this.mXModeDisplayStatusCallback = new IXModeDisplayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.9
            AnonymousClass9() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IXModeDisplayStatusCallback
            public void onXModeDisplayStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 7, i, 0));
            }
        };
        this.mCCODisplayStatusCallback = new ICCODisplayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.10
            AnonymousClass10() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ICCODisplayStatusCallback
            public void onCCODisplayStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 8, i, 0));
            }
        };
        this.mAvmStatusCallback = new IAvmStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.11
            AnonymousClass11() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
            public void onAvmStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 9, !z ? 0 : 1, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
            public void onAvmClosedBySpeed() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 10));
            }
        };
        this.mApaStatusCallback = new IApaStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.12
            AnonymousClass12() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 11, !z ? 0 : 1, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaClosedBySpeed() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 12));
            }
        };
        this.mStrStatusCallback = new IStrStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.13
            AnonymousClass13() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IStrStatusCallback
            public void onStrStatusChanged(int i, boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 13, i, !z ? 0 : 1));
            }
        };
        this.mRearviewMirrorStatusCallback = new IRearviewMirrorStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.14
            AnonymousClass14() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IRearviewMirrorStatusCallback
            public void onRearviewMirrorStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 14, i, 0));
            }
        };
        this.mRadarWarningStatusCallback = new IRadarWarningStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.15
            AnonymousClass15() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback
            public void onRadarWarningStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 15, !z ? 0 : 1, 0));
            }
        };
        this.mSteeringAngleCallback = new ISteeringAngleCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.16
            AnonymousClass16() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ISteeringAngleCallback
            public void onSteeringAngleChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 16, i, 0));
            }
        };
        this.mTyreTemperatureCallback = new ITyreTemperatureCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.17
            AnonymousClass17() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLFTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 17, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRFTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 18, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLRTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 19, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRRTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 20, i, 0));
            }
        };
        this.mKeytoneCallback = new IClusterNotifyKeytoneCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.18
            AnonymousClass18() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback
            public void onKeytone() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 21));
            }
        };
        this.mDoorOpenCallback = new IDoorOpenCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.19
            AnonymousClass19() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback
            public void onDoorOpen() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 58));
            }
        };
        this.mLeftWarningCallback = new IClusterLeftWarningCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.20
            AnonymousClass20() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterLeftWarningCallback
            public void onLeftSideWarningDisplay(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 22, !z ? 0 : 1, 0));
            }
        };
        this.mGaugeSpeedCallback = new IGaugeSpeedValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.21
            AnonymousClass21() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IGaugeSpeedValueCallback
            public void onSpeedValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("speed", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 23, bundle));
            }
        };
        this.mAvmLogDataCallback = new IAvmLogDataCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.22
            AnonymousClass22() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmLogDataCallback
            public void onAvmLogDataCallback(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 24, i, i2));
            }
        };
        this.mBootMusicPlayStatusCallback = new IBootMusicPlayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.23
            AnonymousClass23() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IBootMusicPlayStatusCallback
            public void onBootMusicPlayStatus(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 26, i, 0));
            }
        };
        this.mNaviProjectionStatusCallback = new INaviProjectionStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.24
            AnonymousClass24() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.INaviProjectionStatusCallback
            public void onNaviProjectionStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 27, i, 0));
            }
        };
        this.mCltcOrWltcCallback = new ICltcOrWltcCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.25
            AnonymousClass25() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback
            public void onCltcOrWltcModeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 28, i, 0));
            }
        };
        this.mAvmCameraStatusCallback = new IAvmCameraStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.26
            AnonymousClass26() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmCameraStatusCallback
            public void onAvmCameraStatusCallback(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 30, i, i2));
            }
        };
        this.mChargeViewStatusCallback = new IChargeViewStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.27
            AnonymousClass27() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeViewStatusCallback
            public void onChargeViewStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 31, i, 0));
            }
        };
        this.mVehicleFaultInfo = new IVehicleFaultInfo.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.28
            AnonymousClass28() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo
            public void onVehicleFaultInfoChanged(int[] iArr) throws RemoteException {
                ArrayList<Integer> arrayList = new ArrayList<>((List) Arrays.stream(iArr).boxed().collect(Collectors.toList()));
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("bundleInfo", arrayList);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 32, bundle));
            }
        };
        this.mChargePowerCallback = new IChargePowerCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.29
            AnonymousClass29() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerCallback
            public void onChargePowerChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("power", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 33, bundle));
            }
        };
        this.mChargeCurrentCallback = new IChargeCurrentCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.30
            AnonymousClass30() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeCurrentCallback
            public void onChargeCurrentChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat(Constant.CURRENT, f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 34, bundle));
            }
        };
        this.mChargeVoltageCallback = new IChargeVoltageCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.31
            AnonymousClass31() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeVoltageCallback
            public void onChargeVoltageChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("voltage", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 35, bundle));
            }
        };
        this.mAFCValueCallback = new IAFCValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.32
            AnonymousClass32() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAFCValueCallback
            public void onAFCValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 36, i, 0));
            }
        };
        this.mAFCPHKMValueCallback = new IAFCPHKMValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.33
            AnonymousClass33() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAFCPHKMValueCallback
            public void onAFCPHKMValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 37, i, 0));
            }
        };
        this.mDriveTimeCallback = new IDriveTimeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.34
            AnonymousClass34() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDriveTimeCallback
            public void onDriveTimeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 38, i, 0));
            }
        };
        this.mAvgSpdCallback = new IAvgSpdValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.35
            AnonymousClass35() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgSpdValueCallback
            public void onAvgSpdValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 39, i, 0));
            }
        };
        this.mChargePowerInfoCallback = new IChargePowerInfoCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.36
            AnonymousClass36() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback
            public void onChargePowerInfoChanged(float f, float f2, float f3) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("chargingCurrent", f);
                bundle.putFloat("chargingVoltage", f2);
                bundle.putFloat("chargingPower", f3);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 40, bundle));
            }
        };
        this.mMaintanceDistanceCallback = new IPayloadMaintanceDistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.37
            AnonymousClass37() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback
            public void onPayloadMaintanceDistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 41, i, 0));
            }
        };
        this.mIFECallback = new IIFECallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.38
            AnonymousClass38() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IIFECallback
            public void onIFEValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 42, i, 0));
            }
        };
        this.mMainTankResistanceCallback = new IMainTankResistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.39
            AnonymousClass39() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IMainTankResistanceCallback
            public void onMainTankResistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 43, i, 0));
            }
        };
        this.mSubTankResistanceCallback = new ISubTankResistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.40
            AnonymousClass40() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ISubTankResistanceCallback
            public void onSubTankResistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 44, i, 0));
            }
        };
        this.mAvgElecCallback = new IAvgElecCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.41
            AnonymousClass41() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCallback
            public void onAvgElecChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("AvgElec", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
            }
        };
        this.mAvgFuCallback = new IAvgFuCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.42
            AnonymousClass42() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCallback
            public void onAvgFuChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("AvgFu", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 46, bundle));
            }
        };
        this.mAvgElecCnsCallback = new IAvgElecCnsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.43
            AnonymousClass43() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCnsCallback
            public void onAvgElecCnsChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("ElecCns", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 54, bundle));
            }
        };
        this.mAvgFuCnsCallback = new IAvgFuCnsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.44
            AnonymousClass44() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCnsCallback
            public void onAvgFuCnsChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuCns", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 55, bundle));
            }
        };
        this.mFuelVolumeDspCallback = new IFuelVolumeDisplayCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.45
            AnonymousClass45() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback
            public void onFuelVolumeDisplayValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuelVolumeDsp", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 47, bundle));
            }
        };
        this.mFuelVolumeSpCallback = new IFuelVolumeSampleCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.46
            AnonymousClass46() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeSampleCallback
            public void onFuelVolumeSampleValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuelVolumeSp", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 48, bundle));
            }
        };
        this.mDteAfcCallback = new IDteAFCValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.47
            AnonymousClass47() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteAFCValueCallback
            public void onDteAFCValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("DTEAFC", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
            }
        };
        this.mFuelTankTypeCallback = new IFuelTankTypeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.48
            AnonymousClass48() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback
            public void onFuelTankTypeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 51, i, 0));
            }
        };
        this.mOverFillStateCallback = new IOverFillStateCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.49
            AnonymousClass49() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOverFillStateCallback
            public void onOverFillStateCallback(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 52, i, 0));
            }
        };
        this.mEnergyCurveProjectionCallback = new IEnergyCurveProjectionCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.50
            AnonymousClass50() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IEnergyCurveProjectionCallback
            public void onEnergyCurveProjectionStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 56, i, 0));
            }
        };
        this.mFuelAddEventCallback = new IFuelAddEventCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.51
            AnonymousClass51() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelAddEventCallback
            public void onFuelAddEventCallback(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 53, i, 0));
            }
        };
        this.mClusterThemeCallback = new IClusterThemeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.52
            AnonymousClass52() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterThemeCallback
            public void onClusterThemeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 57, i, 0));
            }
        };
        this.mTimeFormatCallback = new ITimeFormatChangedCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.53
            AnonymousClass53() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITimeFormatChangedCallback
            public void onTimeFormatChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 60, i, 0));
            }
        };
        this.mThemeSwitchCallback = new IThemeSwitchCompleteCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.54
            AnonymousClass54() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IThemeSwitchCompleteCallback
            public void onSwitchComplete(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 59, i, 0));
            }
        };
        this.mClusterFontCallback = new IClusterFontCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.55
            AnonymousClass55() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterFontCallback
            public void onClusterFontChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 61, i, 0));
            }
        };
        init();
        bindService();
    }

    @Deprecated
    public ALClusterInteractionManager(Context context, IALManager.ServiceConnectionListener serviceConnectionListener) {
        super(context, serviceConnectionListener);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mDriverModeCallback = new IDriverModeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDriverModeCallback
            public void onDriverModeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 1, i, 0));
            }
        };
        this.mTorqueLockStatusCallback = new ITorqueLockStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.2
            AnonymousClass2() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITorqueLockStatusCallback
            public void onTorqueLockStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 2, i, 0));
            }
        };
        this.mDteCalculateValueCallback = new IDteCalculateValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.3
            AnonymousClass3() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteCalculateValueCallback
            public void onDteCalculateValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 49, i, 0));
            }
        };
        this.mDteValueCallback = new IDteValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.4
            AnonymousClass4() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
            public void onDteValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 3, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
            public void onGaugeFuelPercentChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 4, i, 0));
            }
        };
        this.mMotorDteValueCallback = new IMotorDteValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.5
            AnonymousClass5() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IMotorDteValueCallback
            public void onMotorDteValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 29, i, 0));
            }
        };
        this.mTemperatureHighCallback = new ITemperatureHighCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.6
            AnonymousClass6() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback
            public void onIviTemperatureHigh() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 5));
            }
        };
        this.mDiagDtcInfoCallback = new IDiagDtcInfoCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.7
            AnonymousClass7() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback
            public void onDiagDtcInfoCb(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 25, i, i2));
            }
        };
        this.mNaviInfoCallback = new INaviInfoStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.8
            AnonymousClass8() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.INaviInfoStatusCallback
            public void onNaviInfoStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 6, i, 0));
            }
        };
        this.mXModeDisplayStatusCallback = new IXModeDisplayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.9
            AnonymousClass9() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IXModeDisplayStatusCallback
            public void onXModeDisplayStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 7, i, 0));
            }
        };
        this.mCCODisplayStatusCallback = new ICCODisplayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.10
            AnonymousClass10() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ICCODisplayStatusCallback
            public void onCCODisplayStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 8, i, 0));
            }
        };
        this.mAvmStatusCallback = new IAvmStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.11
            AnonymousClass11() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
            public void onAvmStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 9, !z ? 0 : 1, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
            public void onAvmClosedBySpeed() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 10));
            }
        };
        this.mApaStatusCallback = new IApaStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.12
            AnonymousClass12() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 11, !z ? 0 : 1, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaClosedBySpeed() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 12));
            }
        };
        this.mStrStatusCallback = new IStrStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.13
            AnonymousClass13() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IStrStatusCallback
            public void onStrStatusChanged(int i, boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 13, i, !z ? 0 : 1));
            }
        };
        this.mRearviewMirrorStatusCallback = new IRearviewMirrorStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.14
            AnonymousClass14() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IRearviewMirrorStatusCallback
            public void onRearviewMirrorStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 14, i, 0));
            }
        };
        this.mRadarWarningStatusCallback = new IRadarWarningStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.15
            AnonymousClass15() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback
            public void onRadarWarningStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 15, !z ? 0 : 1, 0));
            }
        };
        this.mSteeringAngleCallback = new ISteeringAngleCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.16
            AnonymousClass16() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ISteeringAngleCallback
            public void onSteeringAngleChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 16, i, 0));
            }
        };
        this.mTyreTemperatureCallback = new ITyreTemperatureCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.17
            AnonymousClass17() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLFTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 17, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRFTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 18, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLRTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 19, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRRTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 20, i, 0));
            }
        };
        this.mKeytoneCallback = new IClusterNotifyKeytoneCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.18
            AnonymousClass18() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback
            public void onKeytone() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 21));
            }
        };
        this.mDoorOpenCallback = new IDoorOpenCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.19
            AnonymousClass19() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback
            public void onDoorOpen() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 58));
            }
        };
        this.mLeftWarningCallback = new IClusterLeftWarningCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.20
            AnonymousClass20() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterLeftWarningCallback
            public void onLeftSideWarningDisplay(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 22, !z ? 0 : 1, 0));
            }
        };
        this.mGaugeSpeedCallback = new IGaugeSpeedValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.21
            AnonymousClass21() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IGaugeSpeedValueCallback
            public void onSpeedValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("speed", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 23, bundle));
            }
        };
        this.mAvmLogDataCallback = new IAvmLogDataCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.22
            AnonymousClass22() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmLogDataCallback
            public void onAvmLogDataCallback(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 24, i, i2));
            }
        };
        this.mBootMusicPlayStatusCallback = new IBootMusicPlayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.23
            AnonymousClass23() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IBootMusicPlayStatusCallback
            public void onBootMusicPlayStatus(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 26, i, 0));
            }
        };
        this.mNaviProjectionStatusCallback = new INaviProjectionStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.24
            AnonymousClass24() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.INaviProjectionStatusCallback
            public void onNaviProjectionStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 27, i, 0));
            }
        };
        this.mCltcOrWltcCallback = new ICltcOrWltcCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.25
            AnonymousClass25() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback
            public void onCltcOrWltcModeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 28, i, 0));
            }
        };
        this.mAvmCameraStatusCallback = new IAvmCameraStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.26
            AnonymousClass26() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmCameraStatusCallback
            public void onAvmCameraStatusCallback(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 30, i, i2));
            }
        };
        this.mChargeViewStatusCallback = new IChargeViewStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.27
            AnonymousClass27() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeViewStatusCallback
            public void onChargeViewStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 31, i, 0));
            }
        };
        this.mVehicleFaultInfo = new IVehicleFaultInfo.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.28
            AnonymousClass28() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo
            public void onVehicleFaultInfoChanged(int[] iArr) throws RemoteException {
                ArrayList<Integer> arrayList = new ArrayList<>((List) Arrays.stream(iArr).boxed().collect(Collectors.toList()));
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("bundleInfo", arrayList);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 32, bundle));
            }
        };
        this.mChargePowerCallback = new IChargePowerCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.29
            AnonymousClass29() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerCallback
            public void onChargePowerChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("power", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 33, bundle));
            }
        };
        this.mChargeCurrentCallback = new IChargeCurrentCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.30
            AnonymousClass30() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeCurrentCallback
            public void onChargeCurrentChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat(Constant.CURRENT, f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 34, bundle));
            }
        };
        this.mChargeVoltageCallback = new IChargeVoltageCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.31
            AnonymousClass31() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeVoltageCallback
            public void onChargeVoltageChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("voltage", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 35, bundle));
            }
        };
        this.mAFCValueCallback = new IAFCValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.32
            AnonymousClass32() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAFCValueCallback
            public void onAFCValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 36, i, 0));
            }
        };
        this.mAFCPHKMValueCallback = new IAFCPHKMValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.33
            AnonymousClass33() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAFCPHKMValueCallback
            public void onAFCPHKMValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 37, i, 0));
            }
        };
        this.mDriveTimeCallback = new IDriveTimeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.34
            AnonymousClass34() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDriveTimeCallback
            public void onDriveTimeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 38, i, 0));
            }
        };
        this.mAvgSpdCallback = new IAvgSpdValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.35
            AnonymousClass35() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgSpdValueCallback
            public void onAvgSpdValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 39, i, 0));
            }
        };
        this.mChargePowerInfoCallback = new IChargePowerInfoCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.36
            AnonymousClass36() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback
            public void onChargePowerInfoChanged(float f, float f2, float f3) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("chargingCurrent", f);
                bundle.putFloat("chargingVoltage", f2);
                bundle.putFloat("chargingPower", f3);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 40, bundle));
            }
        };
        this.mMaintanceDistanceCallback = new IPayloadMaintanceDistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.37
            AnonymousClass37() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback
            public void onPayloadMaintanceDistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 41, i, 0));
            }
        };
        this.mIFECallback = new IIFECallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.38
            AnonymousClass38() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IIFECallback
            public void onIFEValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 42, i, 0));
            }
        };
        this.mMainTankResistanceCallback = new IMainTankResistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.39
            AnonymousClass39() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IMainTankResistanceCallback
            public void onMainTankResistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 43, i, 0));
            }
        };
        this.mSubTankResistanceCallback = new ISubTankResistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.40
            AnonymousClass40() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ISubTankResistanceCallback
            public void onSubTankResistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 44, i, 0));
            }
        };
        this.mAvgElecCallback = new IAvgElecCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.41
            AnonymousClass41() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCallback
            public void onAvgElecChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("AvgElec", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
            }
        };
        this.mAvgFuCallback = new IAvgFuCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.42
            AnonymousClass42() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCallback
            public void onAvgFuChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("AvgFu", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 46, bundle));
            }
        };
        this.mAvgElecCnsCallback = new IAvgElecCnsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.43
            AnonymousClass43() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCnsCallback
            public void onAvgElecCnsChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("ElecCns", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 54, bundle));
            }
        };
        this.mAvgFuCnsCallback = new IAvgFuCnsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.44
            AnonymousClass44() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCnsCallback
            public void onAvgFuCnsChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuCns", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 55, bundle));
            }
        };
        this.mFuelVolumeDspCallback = new IFuelVolumeDisplayCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.45
            AnonymousClass45() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback
            public void onFuelVolumeDisplayValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuelVolumeDsp", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 47, bundle));
            }
        };
        this.mFuelVolumeSpCallback = new IFuelVolumeSampleCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.46
            AnonymousClass46() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeSampleCallback
            public void onFuelVolumeSampleValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuelVolumeSp", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 48, bundle));
            }
        };
        this.mDteAfcCallback = new IDteAFCValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.47
            AnonymousClass47() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteAFCValueCallback
            public void onDteAFCValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("DTEAFC", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
            }
        };
        this.mFuelTankTypeCallback = new IFuelTankTypeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.48
            AnonymousClass48() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback
            public void onFuelTankTypeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 51, i, 0));
            }
        };
        this.mOverFillStateCallback = new IOverFillStateCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.49
            AnonymousClass49() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOverFillStateCallback
            public void onOverFillStateCallback(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 52, i, 0));
            }
        };
        this.mEnergyCurveProjectionCallback = new IEnergyCurveProjectionCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.50
            AnonymousClass50() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IEnergyCurveProjectionCallback
            public void onEnergyCurveProjectionStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 56, i, 0));
            }
        };
        this.mFuelAddEventCallback = new IFuelAddEventCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.51
            AnonymousClass51() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelAddEventCallback
            public void onFuelAddEventCallback(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 53, i, 0));
            }
        };
        this.mClusterThemeCallback = new IClusterThemeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.52
            AnonymousClass52() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterThemeCallback
            public void onClusterThemeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 57, i, 0));
            }
        };
        this.mTimeFormatCallback = new ITimeFormatChangedCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.53
            AnonymousClass53() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITimeFormatChangedCallback
            public void onTimeFormatChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 60, i, 0));
            }
        };
        this.mThemeSwitchCallback = new IThemeSwitchCompleteCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.54
            AnonymousClass54() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IThemeSwitchCompleteCallback
            public void onSwitchComplete(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 59, i, 0));
            }
        };
        this.mClusterFontCallback = new IClusterFontCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.55
            AnonymousClass55() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterFontCallback
            public void onClusterFontChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 61, i, 0));
            }
        };
        init();
        bindService();
    }

    public ALClusterInteractionManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mDriverModeCallback = new IDriverModeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDriverModeCallback
            public void onDriverModeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 1, i, 0));
            }
        };
        this.mTorqueLockStatusCallback = new ITorqueLockStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.2
            AnonymousClass2() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITorqueLockStatusCallback
            public void onTorqueLockStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 2, i, 0));
            }
        };
        this.mDteCalculateValueCallback = new IDteCalculateValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.3
            AnonymousClass3() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteCalculateValueCallback
            public void onDteCalculateValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 49, i, 0));
            }
        };
        this.mDteValueCallback = new IDteValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.4
            AnonymousClass4() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
            public void onDteValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 3, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
            public void onGaugeFuelPercentChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 4, i, 0));
            }
        };
        this.mMotorDteValueCallback = new IMotorDteValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.5
            AnonymousClass5() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IMotorDteValueCallback
            public void onMotorDteValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 29, i, 0));
            }
        };
        this.mTemperatureHighCallback = new ITemperatureHighCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.6
            AnonymousClass6() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback
            public void onIviTemperatureHigh() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 5));
            }
        };
        this.mDiagDtcInfoCallback = new IDiagDtcInfoCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.7
            AnonymousClass7() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback
            public void onDiagDtcInfoCb(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 25, i, i2));
            }
        };
        this.mNaviInfoCallback = new INaviInfoStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.8
            AnonymousClass8() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.INaviInfoStatusCallback
            public void onNaviInfoStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 6, i, 0));
            }
        };
        this.mXModeDisplayStatusCallback = new IXModeDisplayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.9
            AnonymousClass9() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IXModeDisplayStatusCallback
            public void onXModeDisplayStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 7, i, 0));
            }
        };
        this.mCCODisplayStatusCallback = new ICCODisplayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.10
            AnonymousClass10() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ICCODisplayStatusCallback
            public void onCCODisplayStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 8, i, 0));
            }
        };
        this.mAvmStatusCallback = new IAvmStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.11
            AnonymousClass11() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
            public void onAvmStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 9, !z ? 0 : 1, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
            public void onAvmClosedBySpeed() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 10));
            }
        };
        this.mApaStatusCallback = new IApaStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.12
            AnonymousClass12() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 11, !z ? 0 : 1, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaClosedBySpeed() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 12));
            }
        };
        this.mStrStatusCallback = new IStrStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.13
            AnonymousClass13() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IStrStatusCallback
            public void onStrStatusChanged(int i, boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 13, i, !z ? 0 : 1));
            }
        };
        this.mRearviewMirrorStatusCallback = new IRearviewMirrorStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.14
            AnonymousClass14() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IRearviewMirrorStatusCallback
            public void onRearviewMirrorStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 14, i, 0));
            }
        };
        this.mRadarWarningStatusCallback = new IRadarWarningStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.15
            AnonymousClass15() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback
            public void onRadarWarningStatusChanged(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 15, !z ? 0 : 1, 0));
            }
        };
        this.mSteeringAngleCallback = new ISteeringAngleCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.16
            AnonymousClass16() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ISteeringAngleCallback
            public void onSteeringAngleChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 16, i, 0));
            }
        };
        this.mTyreTemperatureCallback = new ITyreTemperatureCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.17
            AnonymousClass17() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLFTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 17, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRFTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 18, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLRTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 19, i, 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRRTyreTempChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 20, i, 0));
            }
        };
        this.mKeytoneCallback = new IClusterNotifyKeytoneCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.18
            AnonymousClass18() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback
            public void onKeytone() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 21));
            }
        };
        this.mDoorOpenCallback = new IDoorOpenCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.19
            AnonymousClass19() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback
            public void onDoorOpen() throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 58));
            }
        };
        this.mLeftWarningCallback = new IClusterLeftWarningCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.20
            AnonymousClass20() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterLeftWarningCallback
            public void onLeftSideWarningDisplay(boolean z) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 22, !z ? 0 : 1, 0));
            }
        };
        this.mGaugeSpeedCallback = new IGaugeSpeedValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.21
            AnonymousClass21() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IGaugeSpeedValueCallback
            public void onSpeedValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("speed", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 23, bundle));
            }
        };
        this.mAvmLogDataCallback = new IAvmLogDataCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.22
            AnonymousClass22() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmLogDataCallback
            public void onAvmLogDataCallback(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 24, i, i2));
            }
        };
        this.mBootMusicPlayStatusCallback = new IBootMusicPlayStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.23
            AnonymousClass23() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IBootMusicPlayStatusCallback
            public void onBootMusicPlayStatus(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 26, i, 0));
            }
        };
        this.mNaviProjectionStatusCallback = new INaviProjectionStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.24
            AnonymousClass24() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.INaviProjectionStatusCallback
            public void onNaviProjectionStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 27, i, 0));
            }
        };
        this.mCltcOrWltcCallback = new ICltcOrWltcCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.25
            AnonymousClass25() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback
            public void onCltcOrWltcModeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 28, i, 0));
            }
        };
        this.mAvmCameraStatusCallback = new IAvmCameraStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.26
            AnonymousClass26() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvmCameraStatusCallback
            public void onAvmCameraStatusCallback(int i, int i2) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 30, i, i2));
            }
        };
        this.mChargeViewStatusCallback = new IChargeViewStatusCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.27
            AnonymousClass27() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeViewStatusCallback
            public void onChargeViewStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 31, i, 0));
            }
        };
        this.mVehicleFaultInfo = new IVehicleFaultInfo.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.28
            AnonymousClass28() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo
            public void onVehicleFaultInfoChanged(int[] iArr) throws RemoteException {
                ArrayList<Integer> arrayList = new ArrayList<>((List) Arrays.stream(iArr).boxed().collect(Collectors.toList()));
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("bundleInfo", arrayList);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 32, bundle));
            }
        };
        this.mChargePowerCallback = new IChargePowerCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.29
            AnonymousClass29() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerCallback
            public void onChargePowerChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("power", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 33, bundle));
            }
        };
        this.mChargeCurrentCallback = new IChargeCurrentCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.30
            AnonymousClass30() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeCurrentCallback
            public void onChargeCurrentChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat(Constant.CURRENT, f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 34, bundle));
            }
        };
        this.mChargeVoltageCallback = new IChargeVoltageCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.31
            AnonymousClass31() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargeVoltageCallback
            public void onChargeVoltageChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("voltage", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 35, bundle));
            }
        };
        this.mAFCValueCallback = new IAFCValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.32
            AnonymousClass32() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAFCValueCallback
            public void onAFCValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 36, i, 0));
            }
        };
        this.mAFCPHKMValueCallback = new IAFCPHKMValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.33
            AnonymousClass33() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAFCPHKMValueCallback
            public void onAFCPHKMValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 37, i, 0));
            }
        };
        this.mDriveTimeCallback = new IDriveTimeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.34
            AnonymousClass34() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDriveTimeCallback
            public void onDriveTimeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 38, i, 0));
            }
        };
        this.mAvgSpdCallback = new IAvgSpdValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.35
            AnonymousClass35() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgSpdValueCallback
            public void onAvgSpdValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 39, i, 0));
            }
        };
        this.mChargePowerInfoCallback = new IChargePowerInfoCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.36
            AnonymousClass36() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback
            public void onChargePowerInfoChanged(float f, float f2, float f3) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("chargingCurrent", f);
                bundle.putFloat("chargingVoltage", f2);
                bundle.putFloat("chargingPower", f3);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 40, bundle));
            }
        };
        this.mMaintanceDistanceCallback = new IPayloadMaintanceDistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.37
            AnonymousClass37() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback
            public void onPayloadMaintanceDistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 41, i, 0));
            }
        };
        this.mIFECallback = new IIFECallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.38
            AnonymousClass38() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IIFECallback
            public void onIFEValueChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 42, i, 0));
            }
        };
        this.mMainTankResistanceCallback = new IMainTankResistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.39
            AnonymousClass39() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IMainTankResistanceCallback
            public void onMainTankResistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 43, i, 0));
            }
        };
        this.mSubTankResistanceCallback = new ISubTankResistanceCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.40
            AnonymousClass40() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ISubTankResistanceCallback
            public void onSubTankResistanceChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 44, i, 0));
            }
        };
        this.mAvgElecCallback = new IAvgElecCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.41
            AnonymousClass41() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCallback
            public void onAvgElecChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("AvgElec", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
            }
        };
        this.mAvgFuCallback = new IAvgFuCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.42
            AnonymousClass42() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCallback
            public void onAvgFuChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("AvgFu", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 46, bundle));
            }
        };
        this.mAvgElecCnsCallback = new IAvgElecCnsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.43
            AnonymousClass43() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCnsCallback
            public void onAvgElecCnsChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("ElecCns", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 54, bundle));
            }
        };
        this.mAvgFuCnsCallback = new IAvgFuCnsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.44
            AnonymousClass44() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCnsCallback
            public void onAvgFuCnsChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuCns", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 55, bundle));
            }
        };
        this.mFuelVolumeDspCallback = new IFuelVolumeDisplayCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.45
            AnonymousClass45() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback
            public void onFuelVolumeDisplayValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuelVolumeDsp", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 47, bundle));
            }
        };
        this.mFuelVolumeSpCallback = new IFuelVolumeSampleCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.46
            AnonymousClass46() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeSampleCallback
            public void onFuelVolumeSampleValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("FuelVolumeSp", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 48, bundle));
            }
        };
        this.mDteAfcCallback = new IDteAFCValueCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.47
            AnonymousClass47() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDteAFCValueCallback
            public void onDteAFCValueChanged(float f) throws RemoteException {
                Bundle bundle = new Bundle();
                bundle.putFloat("DTEAFC", f);
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
            }
        };
        this.mFuelTankTypeCallback = new IFuelTankTypeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.48
            AnonymousClass48() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback
            public void onFuelTankTypeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 51, i, 0));
            }
        };
        this.mOverFillStateCallback = new IOverFillStateCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.49
            AnonymousClass49() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOverFillStateCallback
            public void onOverFillStateCallback(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 52, i, 0));
            }
        };
        this.mEnergyCurveProjectionCallback = new IEnergyCurveProjectionCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.50
            AnonymousClass50() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IEnergyCurveProjectionCallback
            public void onEnergyCurveProjectionStatusChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 56, i, 0));
            }
        };
        this.mFuelAddEventCallback = new IFuelAddEventCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.51
            AnonymousClass51() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelAddEventCallback
            public void onFuelAddEventCallback(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 53, i, 0));
            }
        };
        this.mClusterThemeCallback = new IClusterThemeCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.52
            AnonymousClass52() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterThemeCallback
            public void onClusterThemeChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 57, i, 0));
            }
        };
        this.mTimeFormatCallback = new ITimeFormatChangedCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.53
            AnonymousClass53() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITimeFormatChangedCallback
            public void onTimeFormatChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 60, i, 0));
            }
        };
        this.mThemeSwitchCallback = new IThemeSwitchCompleteCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.54
            AnonymousClass54() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IThemeSwitchCompleteCallback
            public void onSwitchComplete(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 59, i, 0));
            }
        };
        this.mClusterFontCallback = new IClusterFontCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.55
            AnonymousClass55() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterFontCallback
            public void onClusterFontChanged(int i) throws RemoteException {
                ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 61, i, 0));
            }
        };
        init();
        bindService();
    }

    private void init() {
        this.mDriverModeListeners = new CopyOnWriteArrayList<>();
        this.mDteValueListeners = new CopyOnWriteArrayList<>();
        this.mMotorDteValueListeners = new CopyOnWriteArrayList<>();
        this.mTorqueLockStatusListeners = new CopyOnWriteArrayList<>();
        this.mTemperatureHighListeners = new CopyOnWriteArrayList<>();
        this.mDiagDtcInfoListeners = new CopyOnWriteArrayList<>();
        this.mNaviInfoListeners = new CopyOnWriteArrayList<>();
        this.mXModeDisplayStatusListeners = new CopyOnWriteArrayList<>();
        this.mCCODisplayStatusListeners = new CopyOnWriteArrayList<>();
        this.mAvmStatusListeners = new CopyOnWriteArrayList<>();
        this.mApaStatusListeners = new CopyOnWriteArrayList<>();
        this.mStrStatusListeners = new CopyOnWriteArrayList<>();
        this.mRearviewMirrorStatusListeners = new CopyOnWriteArrayList<>();
        this.mRadarWarningStatusListeners = new CopyOnWriteArrayList<>();
        this.mSteeringAngleListeners = new CopyOnWriteArrayList<>();
        this.mTyreTemperatureListeners = new CopyOnWriteArrayList<>();
        this.mKeytoneListeners = new CopyOnWriteArrayList<>();
        this.mLeftSideWarningListeners = new CopyOnWriteArrayList<>();
        this.mGaugeSpeedListeners = new CopyOnWriteArrayList<>();
        this.mAvmLogDataListeners = new CopyOnWriteArrayList<>();
        this.mBootMusicPlayStatusListeners = new CopyOnWriteArrayList<>();
        this.mNaviProjectionStatusListeners = new CopyOnWriteArrayList<>();
        this.mCltcOrWltcListeners = new CopyOnWriteArrayList<>();
        this.mAvmCameraStatusListeners = new CopyOnWriteArrayList<>();
        this.mChargeViewStatusListeners = new CopyOnWriteArrayList<>();
        this.mVehicleFaultInfoListeners = new CopyOnWriteArrayList<>();
        this.mChargeCurrentListeners = new CopyOnWriteArrayList<>();
        this.mChargePowerListeners = new CopyOnWriteArrayList<>();
        this.mChargeVoltageListeners = new CopyOnWriteArrayList<>();
        this.mAFCListeners = new CopyOnWriteArrayList<>();
        this.mAFCPHKMListeners = new CopyOnWriteArrayList<>();
        this.mDriveTimeListeners = new CopyOnWriteArrayList<>();
        this.mAvgSpdListeners = new CopyOnWriteArrayList<>();
        this.mChargeInfoListeners = new CopyOnWriteArrayList<>();
        this.mMaintanceDistanceListeners = new CopyOnWriteArrayList<>();
        this.mIFEListeners = new CopyOnWriteArrayList<>();
        this.mMainTankResistanceListeners = new CopyOnWriteArrayList<>();
        this.mSubTankResistanceListeners = new CopyOnWriteArrayList<>();
        this.mAvgElecListeners = new CopyOnWriteArrayList<>();
        this.mAvgFuListeners = new CopyOnWriteArrayList<>();
        this.mAvgElecCnsListeners = new CopyOnWriteArrayList<>();
        this.mAvgFuCnsListeners = new CopyOnWriteArrayList<>();
        this.mFuelVolumeDisplayListeners = new CopyOnWriteArrayList<>();
        this.mFuelVolumeSampleListeners = new CopyOnWriteArrayList<>();
        this.mDteCalValueListeners = new CopyOnWriteArrayList<>();
        this.mDteAFCListeners = new CopyOnWriteArrayList<>();
        this.mFuelTankTypeListeners = new CopyOnWriteArrayList<>();
        this.mOverFillStateListeners = new CopyOnWriteArrayList<>();
        this.mFuelAddEventListeners = new CopyOnWriteArrayList<>();
        this.mEnergyCurveProjectionListeners = new CopyOnWriteArrayList<>();
        this.mClusterThemeListeners = new CopyOnWriteArrayList<>();
        this.mDoorOpenListeners = new CopyOnWriteArrayList<>();
        this.mThemeSwitchListeners = new CopyOnWriteArrayList<>();
        this.mTimeFormatListeners = new CopyOnWriteArrayList<>();
        this.mClusterFontListeners = new CopyOnWriteArrayList<>();
    }

    public void unbindService(Context context) {
        Log.i(TAG, "ALClusterInteractionManager unbindService");
        unbindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent("com.autolink.clusterinteraction.CiService");
        intent.setPackage("com.autolink.clusterinteraction");
        intent.setClassName("com.autolink.clusterinteraction", "com.autolink.clusterinteraction.CiService");
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(TAG, "ALClusterInteractionManager->onServiceConnected: " + componentName.toString());
        this.mService = IClusterInteraction.Stub.asInterface(iBinder);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        this.mService = null;
    }

    static final class ManagerHandler extends Handler {
        private static final int MSG_500M_AVG_ELEC_CHANGED = 45;
        private static final int MSG_500M_AVG_FU_CHANGED = 46;
        private static final int MSG_AFC_PHKM_VALUE_CHANGED = 37;
        private static final int MSG_AFC_VALUE_CHANGED = 36;
        private static final int MSG_APA_CLOSED_BY_SPEED = 12;
        private static final int MSG_APA_STATUS_CHANGED = 11;
        private static final int MSG_AVG_ELEC_CNS_CHANGED = 54;
        private static final int MSG_AVG_FU_CNS_CHANGED = 55;
        private static final int MSG_AVG_SPD_CHANGED = 39;
        private static final int MSG_AVM_CAMERA_STATUS_CHANGED = 30;
        private static final int MSG_AVM_CLOSED_BY_SPEED = 10;
        private static final int MSG_AVM_LOG_DATA = 24;
        private static final int MSG_AVM_STATUS_CHANGED = 9;
        private static final int MSG_BOOT_MUSIC_STATUS = 26;
        private static final int MSG_CCO_DISPLAY_STATUS_CHANGED = 8;
        private static final int MSG_CHARGE_CURRENT_CHANGED = 34;
        private static final int MSG_CHARGE_INFO_CHANGED = 40;
        private static final int MSG_CHARGE_POWER_CHANGED = 33;
        private static final int MSG_CHARGE_VIEW_STATUS_CHANGED = 31;
        private static final int MSG_CHARGE_VOLTAGE_CHANGED = 35;
        private static final int MSG_CLTC_OR_WLTC_MODE = 28;
        private static final int MSG_CLUSTER_FONT_CHANGED = 61;
        private static final int MSG_CLUSTER_THEME_CHANGED = 57;
        private static final int MSG_DIAG_DTC_INFO = 25;
        private static final int MSG_DOOR_OPEN = 58;
        private static final int MSG_DRIVER_MODE_CHANGED = 1;
        private static final int MSG_DRIVE_TIME_CHANGED = 38;
        private static final int MSG_DTE_AFC_VALUE_CHANGED = 50;
        private static final int MSG_DTE_CALCULATE_VALUE_CHANGED = 49;
        private static final int MSG_DTE_VALUE_CHANGED = 3;
        private static final int MSG_ENERGY_CURVE_PROJECTION_STATUS_CHANGED = 56;
        private static final int MSG_FUEL_ADD_EVENT_CHANGED = 53;
        private static final int MSG_FUEL_TANK_TYPE_CHANGED = 51;
        private static final int MSG_FUEL_VOLUME_DISPLAY_CHANGED = 47;
        private static final int MSG_FUEL_VOLUME_SAMPLE_CHANGED = 48;
        private static final int MSG_GAUGE_FUEL_PERCENT_CHANGED = 4;
        private static final int MSG_IFE_CHANGED = 42;
        private static final int MSG_IVI_TEMPERATURE_HIGH = 5;
        private static final int MSG_KEYTONE = 21;
        private static final int MSG_LEFT_SIDE_WARNING_DISPLAY = 22;
        private static final int MSG_LFTYRE_TEMP_CHANGED = 17;
        private static final int MSG_LRTYRE_TEMP_CHANGED = 19;
        private static final int MSG_MAINTANCE_DISTANCE_CHANGED = 41;
        private static final int MSG_MAIN_TANK_RESISTANCE_CHANGED = 43;
        private static final int MSG_MOTOR_DTE_VALUE_CHANGED = 29;
        private static final int MSG_NAVI_INFO_STATUS_CHANGED = 6;
        private static final int MSG_NAVI_PROJECTION_STATUS = 27;
        private static final int MSG_OVER_FILL_STATE_CHANGED = 52;
        private static final int MSG_RADAR_WARNING_STATUS_CHANGED = 15;
        private static final int MSG_REARVIEW_MIRROR_STATUS_CHANGED = 14;
        private static final int MSG_RFTYRE_TEMP_CHANGED = 18;
        private static final int MSG_RRTYRE_TEMP_CHANGED = 20;
        private static final int MSG_SPEED_VALUE_CHANGED = 23;
        private static final int MSG_STEERING_ANGLE_CHANGED = 16;
        private static final int MSG_STR_STATUS_CHANGED = 13;
        private static final int MSG_SUB_TANK_RESISTANCE_CHANGED = 44;
        private static final int MSG_THEME_SWITCH_COMPLETE = 59;
        private static final int MSG_TIME_FORMAT_CHANGED = 60;
        private static final int MSG_TORQUE_LOCK_STATUS_CHANGED = 2;
        private static final int MSG_VEHICLE_FAULT_INFO_CHANGED = 32;
        private static final int MSG_XMODE_DISPLAY_STATUS_CHANGED = 7;
        private final WeakReference<ALClusterInteractionManager> mManager;

        public ManagerHandler(Looper looper, ALClusterInteractionManager aLClusterInteractionManager) {
            super(looper);
            this.mManager = new WeakReference<>(aLClusterInteractionManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ALClusterInteractionManager aLClusterInteractionManager = this.mManager.get();
            if (aLClusterInteractionManager != null) {
                switch (message.what) {
                    case 1:
                        aLClusterInteractionManager.notifyDriverModeChanged(message.arg1);
                        break;
                    case 2:
                        aLClusterInteractionManager.notifyTorqueLockStatusChanged(message.arg1);
                        break;
                    case 3:
                        aLClusterInteractionManager.notifyDteValueChanged(message.arg1);
                        break;
                    case 4:
                        aLClusterInteractionManager.notifyGaugeFuelPercentChanged(message.arg1);
                        break;
                    case 5:
                        aLClusterInteractionManager.notifyIviTemperatureHigh();
                        break;
                    case 6:
                        aLClusterInteractionManager.notifyNaviInfoStatusChanged(message.arg1);
                        break;
                    case 7:
                        aLClusterInteractionManager.notifyXModeDisplayStatusChanged(message.arg1);
                        break;
                    case 8:
                        aLClusterInteractionManager.notifyCCODisplayStatusChanged(message.arg1);
                        break;
                    case 9:
                        aLClusterInteractionManager.notifyAvmStatusChanged(message.arg1 == 1);
                        break;
                    case 10:
                        aLClusterInteractionManager.notifyAvmClosedBySpeed();
                        break;
                    case 11:
                        aLClusterInteractionManager.notifyApaStatusChanged(message.arg1 == 1);
                        break;
                    case 12:
                        aLClusterInteractionManager.notifyApaClosedBySpeed();
                        break;
                    case 13:
                        aLClusterInteractionManager.notifyStrStatusChanged(message.arg1, message.arg2 == 1);
                        break;
                    case 14:
                        aLClusterInteractionManager.notifyRearviewMirrorStatusChanged(message.arg1);
                        break;
                    case 15:
                        aLClusterInteractionManager.notifyRadarWarningStatusChanged(message.arg1 == 1);
                        break;
                    case 16:
                        aLClusterInteractionManager.notifySteeringAngleChanged(message.arg1);
                        break;
                    case 17:
                        aLClusterInteractionManager.notifyLFTyreTempChanged(message.arg1);
                        break;
                    case 18:
                        aLClusterInteractionManager.notifyRFTyreTempChanged(message.arg1);
                        break;
                    case 19:
                        aLClusterInteractionManager.notifyLRTyreTempChanged(message.arg1);
                        break;
                    case 20:
                        aLClusterInteractionManager.notifyRRTyreTempChanged(message.arg1);
                        break;
                    case 21:
                        aLClusterInteractionManager.notifyKeytone();
                        break;
                    case 22:
                        aLClusterInteractionManager.notifyLeftSideWarningDisplay(message.arg1 == 1);
                        break;
                    case 23:
                        aLClusterInteractionManager.notifySpeedValueChanged(((Bundle) message.obj).getFloat("speed"));
                        break;
                    case 24:
                        aLClusterInteractionManager.notifyAvmLogDataChanged(message.arg1, message.arg2);
                        break;
                    case 25:
                        aLClusterInteractionManager.notifyDiagDtcInfo(message.arg1, message.arg2);
                        break;
                    case 26:
                        aLClusterInteractionManager.notifyBootMusicPlayStatusChanged(message.arg1);
                        break;
                    case 27:
                        aLClusterInteractionManager.notifyNaviProjectionStatusChanged(message.arg1);
                        break;
                    case 28:
                        aLClusterInteractionManager.notifyCltcOrWltcModeChanged(message.arg1);
                        break;
                    case 29:
                        aLClusterInteractionManager.notifyMotorDteValueChanged(message.arg1);
                        break;
                    case 30:
                        aLClusterInteractionManager.notifyAvmCameraStatusChanged(message.arg1, message.arg2);
                        break;
                    case 31:
                        aLClusterInteractionManager.notifyChargeViewStatusChanged(message.arg1);
                        break;
                    case 32:
                        new ArrayList();
                        aLClusterInteractionManager.notifyVehicleFaultChanged(((Bundle) message.obj).getIntegerArrayList("bundleInfo").stream().mapToInt(new ToIntFunction() { // from class: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$ManagerHandler$$ExternalSyntheticLambda0
                            @Override // java.util.function.ToIntFunction
                            public final int applyAsInt(Object obj) {
                                Integer valueOf;
                                valueOf = Integer.valueOf(((Integer) obj).intValue());
                                return valueOf.intValue();
                            }
                        }).toArray());
                        break;
                    case 33:
                        aLClusterInteractionManager.notifyChargePowerChanged(((Bundle) message.obj).getFloat("power"));
                        break;
                    case 34:
                        aLClusterInteractionManager.notifyChargeCurrentChanged(((Bundle) message.obj).getFloat(Constant.CURRENT));
                        break;
                    case 35:
                        aLClusterInteractionManager.notifyChargeVoltageChanged(((Bundle) message.obj).getFloat("voltage"));
                        break;
                    case 36:
                        aLClusterInteractionManager.notifyAFCValueChanged(message.arg1);
                        break;
                    case 37:
                        aLClusterInteractionManager.notifyAFCPHKMValueChanged(message.arg1);
                        break;
                    case 38:
                        aLClusterInteractionManager.notifyDriveTimeChanged(message.arg1);
                        break;
                    case 39:
                        aLClusterInteractionManager.notifyAvgSpdChanged(message.arg1);
                        break;
                    case 40:
                        Bundle bundle = (Bundle) message.obj;
                        aLClusterInteractionManager.notifyChargeInfoChanged(bundle.getFloat("chargingCurrent"), bundle.getFloat("chargingPower"), bundle.getFloat("chargingVoltage"));
                        break;
                    case 41:
                        aLClusterInteractionManager.notifyMaintanceDistanceChanged(message.arg1);
                        break;
                    case 42:
                        aLClusterInteractionManager.notifyIFEChanged(message.arg1);
                        break;
                    case 43:
                        aLClusterInteractionManager.notifyMainTankResistanceChanged(message.arg1);
                        break;
                    case 44:
                        aLClusterInteractionManager.notifySubTankResistanceChanged(message.arg1);
                        break;
                    case 45:
                        aLClusterInteractionManager.notifyAvgElecChanged(((Bundle) message.obj).getFloat("AvgElec"));
                        break;
                    case 46:
                        aLClusterInteractionManager.notifyAvgFuChanged(((Bundle) message.obj).getFloat("AvgFu"));
                        break;
                    case 47:
                        aLClusterInteractionManager.notifyFuelVolumeDspChanged(((Bundle) message.obj).getFloat("FuelVolumeDsp"));
                        break;
                    case 48:
                        aLClusterInteractionManager.notifyFuelVolumeSpChanged(((Bundle) message.obj).getFloat("FuelVolumeSp"));
                        break;
                    case 49:
                        aLClusterInteractionManager.notifyDteCalculateValueChanged(message.arg1);
                        break;
                    case 50:
                        aLClusterInteractionManager.notifyDteAFCValueChanged(((Bundle) message.obj).getFloat("DTEAFC"));
                        break;
                    case 51:
                        aLClusterInteractionManager.notifyFuelTankTypeChanged(message.arg1);
                        break;
                    case 52:
                        aLClusterInteractionManager.notifyOverFillStateChanged(message.arg1);
                        break;
                    case 53:
                        aLClusterInteractionManager.notifyFuelAddEventChanged(message.arg1);
                        break;
                    case 54:
                        aLClusterInteractionManager.notifyAvgElecCnsChanged(((Bundle) message.obj).getFloat("ElecCns"));
                        break;
                    case 55:
                        aLClusterInteractionManager.notifyAvgFuCnsChanged(((Bundle) message.obj).getFloat("FuCns"));
                        break;
                    case 56:
                        aLClusterInteractionManager.notifyEnergyCurveProjectionStatusChanged(message.arg1);
                        break;
                    case 57:
                        aLClusterInteractionManager.notifyClusterThemeChanged(message.arg1);
                        break;
                    case 58:
                        aLClusterInteractionManager.notifyDoorOpen();
                        break;
                    case 59:
                        aLClusterInteractionManager.notifyThemeSwitchComplete(message.arg1);
                        break;
                    case 60:
                        aLClusterInteractionManager.notifyTimeFormatChanged(message.arg1);
                        break;
                    case 61:
                        aLClusterInteractionManager.notifyClusterFontChanged(message.arg1);
                        break;
                }
            }
            Log.e(ALClusterInteractionManager.TAG, "handleMessage in ALClusterInteractionManager is null");
        }
    }

    public void notifyDriverModeChanged(int i) {
        Log.i(TAG, "notifyDriverModeChanged");
        if (!this.mDriverModeListeners.isEmpty()) {
            Iterator<ALDriverModeListener> it = this.mDriverModeListeners.iterator();
            while (it.hasNext()) {
                it.next().onDriverModeChanged(DriverModeType.forNumber(i));
                Log.i(TAG, "notifyDriverModeChanged,mode = " + i);
            }
            return;
        }
        Log.i(TAG, "notifyDriverModeChanged,mDriverModeListeners is empty!");
    }

    public void notifyClusterFontChanged(int i) {
        Log.i(TAG, "notifyClusterFontChanged");
        if (!this.mClusterFontListeners.isEmpty()) {
            Iterator<ALClusterFontListener> it = this.mClusterFontListeners.iterator();
            while (it.hasNext()) {
                it.next().onClusterFontChanged(i);
                Log.i(TAG, "notifyClusterFontChanged,style = " + i);
            }
            return;
        }
        Log.i(TAG, "notifyClusterFontChanged,mClusterFontListeners is empty!");
    }

    public void notifyTimeFormatChanged(int i) {
        Log.i(TAG, "notifyTimeFormatChanged");
        if (!this.mTimeFormatListeners.isEmpty()) {
            Iterator<ALTimeFormatListener> it = this.mTimeFormatListeners.iterator();
            while (it.hasNext()) {
                it.next().onTimeFormatChanged(i);
                Log.i(TAG, "notifyTimeFormatChanged,format = " + i);
            }
            return;
        }
        Log.i(TAG, "notifyTimeFormatChanged,mTimeFormatListeners is empty!");
    }

    public void notifyOverFillStateChanged(int i) {
        Log.i(TAG, "notifyOverFillStateChanged");
        if (!this.mOverFillStateListeners.isEmpty()) {
            Iterator<ALOverFillStateListener> it = this.mOverFillStateListeners.iterator();
            while (it.hasNext()) {
                it.next().onOverFillStateCallback(i);
                Log.i(TAG, "notifyOverFillStateChanged,state = " + i);
            }
            return;
        }
        Log.i(TAG, "notifyOverFillStateChanged,mOverFillStateListeners is empty!");
    }

    public void notifyEnergyCurveProjectionStatusChanged(int i) {
        Log.i(TAG, "notifyEnergyCurveProjectionStatusChanged");
        if (!this.mEnergyCurveProjectionListeners.isEmpty()) {
            Iterator<ALEnergyCurveProjectionListener> it = this.mEnergyCurveProjectionListeners.iterator();
            while (it.hasNext()) {
                it.next().onEnergyCurveProjectionStatusChanged(EnergyCurveProjectionStatus.forNumber(i));
                Log.i(TAG, "notifyEnergyCurveProjectionStatusChanged,status = " + i);
            }
            return;
        }
        Log.i(TAG, "notifyEnergyCurveProjectionStatusChanged,mEnergyCurveProjectionListeners is empty!");
    }

    public void notifyClusterThemeChanged(int i) {
        Log.i(TAG, "notifyClusterThemeChanged");
        if (!this.mClusterThemeListeners.isEmpty()) {
            Iterator<ALClusterThemeListener> it = this.mClusterThemeListeners.iterator();
            while (it.hasNext()) {
                it.next().onClusterThemeChanged(ClusterThemeMode.forNumber(i));
                Log.i(TAG, "notifyClusterThemeChanged,theme = " + i);
            }
            return;
        }
        Log.i(TAG, "notifyClusterThemeChanged,mClusterThemeListeners is empty!");
    }

    public void notifyFuelTankTypeChanged(int i) {
        if (!this.mFuelTankTypeListeners.isEmpty()) {
            Iterator<ALFuelTankTypeListener> it = this.mFuelTankTypeListeners.iterator();
            while (it.hasNext()) {
                it.next().onFuelTankTypeChanged(i);
            }
            return;
        }
        Log.i(TAG, "notifyFuelTankTypeChanged,mFuelTankTypeListeners is empty!");
    }

    public void notifyFuelAddEventChanged(int i) {
        if (!this.mFuelAddEventListeners.isEmpty()) {
            Iterator<ALFuelAddEventListener> it = this.mFuelAddEventListeners.iterator();
            while (it.hasNext()) {
                it.next().onFuelAddEventCallback(i);
            }
            return;
        }
        Log.i(TAG, "notifyFuelAddEventChanged,mFuelAddEventListeners is empty!");
    }

    public void notifyTorqueLockStatusChanged(int i) {
        if (this.mTorqueLockStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALTorqueLockStatusListener> it = this.mTorqueLockStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onTorqueLockStatusChanged(TorqueLockStatus.forNumber(i));
        }
    }

    public void notifyDteValueChanged(int i) {
        if (this.mDteValueListeners.isEmpty()) {
            return;
        }
        Iterator<ALDteValueListener> it = this.mDteValueListeners.iterator();
        while (it.hasNext()) {
            it.next().onDteValueChanged(i);
        }
    }

    public void notifyMotorDteValueChanged(int i) {
        if (this.mMotorDteValueListeners.isEmpty()) {
            return;
        }
        Iterator<ALMotorDteValueListener> it = this.mMotorDteValueListeners.iterator();
        while (it.hasNext()) {
            it.next().onMotorDteValueChanged(i);
        }
    }

    public void notifyGaugeFuelPercentChanged(int i) {
        if (this.mDteValueListeners.isEmpty()) {
            return;
        }
        Iterator<ALDteValueListener> it = this.mDteValueListeners.iterator();
        while (it.hasNext()) {
            it.next().onGaugeFuelPercentChanged(i);
        }
    }

    public void notifyIviTemperatureHigh() {
        if (this.mTemperatureHighListeners.isEmpty()) {
            return;
        }
        Iterator<ALTemperatureHighListener> it = this.mTemperatureHighListeners.iterator();
        while (it.hasNext()) {
            it.next().onIviTemperatureHigh();
        }
    }

    public void notifyDiagDtcInfo(int i, int i2) {
        if (this.mDiagDtcInfoListeners.isEmpty()) {
            return;
        }
        Iterator<ALDiagDtcInfoListener> it = this.mDiagDtcInfoListeners.iterator();
        while (it.hasNext()) {
            it.next().onDiagDtcInfoCb(DtcInfo.forNumber(i), i2);
        }
    }

    public void notifyNaviInfoStatusChanged(int i) {
        if (this.mNaviInfoListeners.isEmpty()) {
            return;
        }
        Iterator<ALNaviInfoStatusListener> it = this.mNaviInfoListeners.iterator();
        while (it.hasNext()) {
            it.next().onNaviInfoStatusChanged(NaviCmd.forNumber(i));
        }
    }

    public void notifyXModeDisplayStatusChanged(int i) {
        if (this.mXModeDisplayStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALXModeDisplayStatusListener> it = this.mXModeDisplayStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onXModeDisplayStatusChanged(XModeDisplayStatus.forNumber(i));
        }
    }

    public void notifyCCODisplayStatusChanged(int i) {
        if (this.mCCODisplayStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALCCODisplayStatusListener> it = this.mCCODisplayStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onCCODisplayStatusChanged(CCODisplayStatus.forNumber(i));
        }
    }

    public void notifyAvmStatusChanged(boolean z) {
        if (this.mAvmStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvmStatusListener> it = this.mAvmStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvmStatusChanged(z);
        }
    }

    public void notifyAvmClosedBySpeed() {
        if (this.mAvmStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvmStatusListener> it = this.mAvmStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvmClosedBySpeed();
        }
    }

    public void notifyApaStatusChanged(boolean z) {
        if (this.mApaStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALApaStatusListener> it = this.mApaStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onApaStatusChanged(z);
        }
    }

    public void notifyApaClosedBySpeed() {
        if (this.mApaStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALApaStatusListener> it = this.mApaStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onApaClosedBySpeed();
        }
    }

    public void notifyStrStatusChanged(int i, boolean z) {
        if (this.mStrStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALStrStatusListener> it = this.mStrStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onStrStatusChanged(StrSwitchStatusCmd.forNumber(i), z);
        }
    }

    public void notifyRearviewMirrorStatusChanged(int i) {
        if (this.mRearviewMirrorStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALRearviewMirrorStatusListener> it = this.mRearviewMirrorStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onRearviewMirrorStatusChanged(RearViewKeyStatus.forNumber(i));
        }
    }

    public void notifyRadarWarningStatusChanged(boolean z) {
        if (this.mRadarWarningStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALRadarWarningStatusListener> it = this.mRadarWarningStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onRadarWarningStatusChanged(z);
        }
    }

    public void notifySteeringAngleChanged(int i) {
        if (this.mSteeringAngleListeners.isEmpty()) {
            return;
        }
        Iterator<ALSteeringAngleListener> it = this.mSteeringAngleListeners.iterator();
        while (it.hasNext()) {
            it.next().onSteeringAngleChanged(i);
        }
    }

    public void notifyLFTyreTempChanged(int i) {
        if (this.mTyreTemperatureListeners.isEmpty()) {
            return;
        }
        Iterator<ALTyreTemperatureListener> it = this.mTyreTemperatureListeners.iterator();
        while (it.hasNext()) {
            it.next().onLFTyreTempChanged(i);
        }
    }

    public void notifyRFTyreTempChanged(int i) {
        if (this.mTyreTemperatureListeners.isEmpty()) {
            return;
        }
        Iterator<ALTyreTemperatureListener> it = this.mTyreTemperatureListeners.iterator();
        while (it.hasNext()) {
            it.next().onRFTyreTempChanged(i);
        }
    }

    public void notifyLRTyreTempChanged(int i) {
        if (this.mTyreTemperatureListeners.isEmpty()) {
            return;
        }
        Iterator<ALTyreTemperatureListener> it = this.mTyreTemperatureListeners.iterator();
        while (it.hasNext()) {
            it.next().onLRTyreTempChanged(i);
        }
    }

    public void notifyRRTyreTempChanged(int i) {
        if (this.mTyreTemperatureListeners.isEmpty()) {
            return;
        }
        Iterator<ALTyreTemperatureListener> it = this.mTyreTemperatureListeners.iterator();
        while (it.hasNext()) {
            it.next().onRRTyreTempChanged(i);
        }
    }

    public void notifyKeytone() {
        if (this.mKeytoneListeners.isEmpty()) {
            return;
        }
        Iterator<ALKeytoneListener> it = this.mKeytoneListeners.iterator();
        while (it.hasNext()) {
            it.next().onKeytone();
        }
    }

    public void notifyDoorOpen() {
        if (this.mDoorOpenListeners.isEmpty()) {
            return;
        }
        Iterator<ALDoorOpenListener> it = this.mDoorOpenListeners.iterator();
        while (it.hasNext()) {
            it.next().onDoorOpen();
        }
    }

    public void notifyLeftSideWarningDisplay(boolean z) {
        if (this.mLeftSideWarningListeners.isEmpty()) {
            return;
        }
        Iterator<ALLeftSideWarningListener> it = this.mLeftSideWarningListeners.iterator();
        while (it.hasNext()) {
            it.next().onLeftSideWarningDisplay(z);
        }
    }

    public void notifySpeedValueChanged(float f) {
        if (this.mGaugeSpeedListeners.isEmpty()) {
            return;
        }
        Iterator<ALGaugeSpeedListener> it = this.mGaugeSpeedListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpeedValueChanged(f);
        }
    }

    public void notifyAvmLogDataChanged(int i, int i2) {
        if (this.mAvmLogDataListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvmLogDataListener> it = this.mAvmLogDataListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvmLogDataCallback(LogType.forNumber(i), i2);
        }
    }

    public void notifyBootMusicPlayStatusChanged(int i) {
        if (this.mBootMusicPlayStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALBootMusicPlayStatusListener> it = this.mBootMusicPlayStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onBootMusicPlayStatus(BootSoundStatus.forNumber(i));
        }
    }

    public void notifyNaviProjectionStatusChanged(int i) {
        if (this.mNaviProjectionStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALNaviProjectionStatusListener> it = this.mNaviProjectionStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onNaviProjectionStatusChanged(NaviProjectionStatus.forNumber(i));
        }
    }

    public void notifyCltcOrWltcModeChanged(int i) {
        if (this.mCltcOrWltcListeners.isEmpty()) {
            return;
        }
        Iterator<ALCltcOrWltcListener> it = this.mCltcOrWltcListeners.iterator();
        while (it.hasNext()) {
            it.next().onCltcOrWltcModeChanged(CltcOrWltcMode.forNumber(i));
        }
    }

    public void notifyAvmCameraStatusChanged(int i, int i2) {
        if (this.mAvmCameraStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvmCameraStatusListener> it = this.mAvmCameraStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvmCameraStatusCallback(AvmCameraPos.forNumber(i), i2);
        }
    }

    public void notifyChargeViewStatusChanged(int i) {
        if (this.mChargeViewStatusListeners.isEmpty()) {
            return;
        }
        Iterator<ALChargeViewStatusListener> it = this.mChargeViewStatusListeners.iterator();
        while (it.hasNext()) {
            it.next().onChargeViewStatusChanged(i);
        }
    }

    public void notifyVehicleFaultChanged(int[] iArr) {
        if (this.mVehicleFaultInfoListeners.isEmpty()) {
            return;
        }
        Iterator<ALVehicleFaultInfoListener> it = this.mVehicleFaultInfoListeners.iterator();
        while (it.hasNext()) {
            it.next().onVehicleFaultInfoChanged(iArr);
        }
    }

    public void notifyChargePowerChanged(float f) {
        if (this.mChargePowerListeners.isEmpty()) {
            return;
        }
        Iterator<ALChargePowerListener> it = this.mChargePowerListeners.iterator();
        while (it.hasNext()) {
            it.next().onChargePowerChanged(f);
        }
    }

    public void notifyChargeCurrentChanged(float f) {
        if (this.mChargeCurrentListeners.isEmpty()) {
            return;
        }
        Iterator<ALChargeCurrentListener> it = this.mChargeCurrentListeners.iterator();
        while (it.hasNext()) {
            it.next().onChargeCurrentChanged(f);
        }
    }

    public void notifyChargeVoltageChanged(float f) {
        if (this.mChargeVoltageListeners.isEmpty()) {
            return;
        }
        Iterator<ALChargeVoltageListener> it = this.mChargeVoltageListeners.iterator();
        while (it.hasNext()) {
            it.next().onChargeVoltageChanged(f);
        }
    }

    public void notifyAFCValueChanged(int i) {
        if (this.mAFCListeners.isEmpty()) {
            return;
        }
        Iterator<ALAFCListener> it = this.mAFCListeners.iterator();
        while (it.hasNext()) {
            it.next().onAFCValueChanged(i);
        }
    }

    public void notifyAFCPHKMValueChanged(int i) {
        if (this.mAFCPHKMListeners.isEmpty()) {
            return;
        }
        Iterator<ALAFCPHKMListener> it = this.mAFCPHKMListeners.iterator();
        while (it.hasNext()) {
            it.next().onAFCPHKMValueChanged(i);
        }
    }

    public void notifyDriveTimeChanged(int i) {
        if (this.mDriveTimeListeners.isEmpty()) {
            return;
        }
        Iterator<ALDriveTimeListener> it = this.mDriveTimeListeners.iterator();
        while (it.hasNext()) {
            it.next().onDriveTimeChanged(i);
        }
    }

    public void notifyAvgSpdChanged(int i) {
        if (this.mAvgSpdListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvgSpdListener> it = this.mAvgSpdListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvgSpdValueChanged(i);
        }
    }

    public void notifyChargeInfoChanged(float f, float f2, float f3) {
        if (this.mChargeInfoListeners.isEmpty()) {
            return;
        }
        Iterator<ALChargeInfoListener> it = this.mChargeInfoListeners.iterator();
        while (it.hasNext()) {
            it.next().onChargePowerInfoChanged(f, f3, f2);
        }
    }

    public void notifyMaintanceDistanceChanged(int i) {
        if (this.mMaintanceDistanceListeners.isEmpty()) {
            return;
        }
        Iterator<ALPayloadMaintanceDistanceListener> it = this.mMaintanceDistanceListeners.iterator();
        while (it.hasNext()) {
            it.next().onPayloadMaintanceDistanceChanged(i);
        }
    }

    public void notifyIFEChanged(int i) {
        if (this.mIFEListeners.isEmpty()) {
            return;
        }
        Iterator<ALIFEListener> it = this.mIFEListeners.iterator();
        while (it.hasNext()) {
            it.next().onIFEValueChanged(i);
        }
    }

    public void notifyMainTankResistanceChanged(int i) {
        if (this.mMainTankResistanceListeners.isEmpty()) {
            return;
        }
        Iterator<ALMainTankResistanceListener> it = this.mMainTankResistanceListeners.iterator();
        while (it.hasNext()) {
            it.next().onMainTankResistanceChanged(i);
        }
    }

    public void notifySubTankResistanceChanged(int i) {
        if (this.mSubTankResistanceListeners.isEmpty()) {
            return;
        }
        Iterator<ALSubTankResistanceListener> it = this.mSubTankResistanceListeners.iterator();
        while (it.hasNext()) {
            it.next().onSubTankResistanceChanged(i);
        }
    }

    public void notifyAvgElecChanged(float f) {
        if (this.mAvgElecListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvgElecListener> it = this.mAvgElecListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvgElecChanged(f);
        }
    }

    public void notifyAvgFuChanged(float f) {
        if (this.mAvgFuListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvgFuListener> it = this.mAvgFuListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvgFuChanged(f);
        }
    }

    public void notifyAvgElecCnsChanged(float f) {
        if (this.mAvgElecCnsListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvgElecCnsListener> it = this.mAvgElecCnsListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvgElecCnsChanged(f);
        }
    }

    public void notifyAvgFuCnsChanged(float f) {
        if (this.mAvgFuCnsListeners.isEmpty()) {
            return;
        }
        Iterator<ALAvgFuCnsListener> it = this.mAvgFuCnsListeners.iterator();
        while (it.hasNext()) {
            it.next().onAvgFuCnsChanged(f);
        }
    }

    public void notifyFuelVolumeDspChanged(float f) {
        if (this.mFuelVolumeDisplayListeners.isEmpty()) {
            return;
        }
        Iterator<ALFuelVolumeDisplayListener> it = this.mFuelVolumeDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().onFuelVolumeDisplayValueChanged(f);
        }
    }

    public void notifyFuelVolumeSpChanged(float f) {
        if (this.mFuelVolumeSampleListeners.isEmpty()) {
            return;
        }
        Iterator<ALFuelVolumeSampleListener> it = this.mFuelVolumeSampleListeners.iterator();
        while (it.hasNext()) {
            it.next().onFuelVolumeSampleValueChanged(f);
        }
    }

    public void notifyDteCalculateValueChanged(int i) {
        if (this.mDteCalValueListeners.isEmpty()) {
            return;
        }
        Iterator<ALDteCalculateValueListener> it = this.mDteCalValueListeners.iterator();
        while (it.hasNext()) {
            it.next().onDteCalculateValueChanged(i);
        }
    }

    public void notifyDteAFCValueChanged(float f) {
        if (this.mDteAFCListeners.isEmpty()) {
            return;
        }
        Iterator<ALDteAFCListener> it = this.mDteAFCListeners.iterator();
        while (it.hasNext()) {
            it.next().onDteAFCValueChanged(f);
        }
    }

    public void notifyThemeSwitchComplete(int i) {
        if (this.mThemeSwitchListeners.isEmpty()) {
            return;
        }
        Iterator<ALThemeSwitchCompleteListener> it = this.mThemeSwitchListeners.iterator();
        while (it.hasNext()) {
            it.next().onSwitchComplete(i);
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$1 */
    class AnonymousClass1 extends IDriverModeCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDriverModeCallback
        public void onDriverModeChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 1, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$2 */
    class AnonymousClass2 extends ITorqueLockStatusCallback.Stub {
        AnonymousClass2() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITorqueLockStatusCallback
        public void onTorqueLockStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 2, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$3 */
    class AnonymousClass3 extends IDteCalculateValueCallback.Stub {
        AnonymousClass3() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDteCalculateValueCallback
        public void onDteCalculateValueChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 49, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$4 */
    class AnonymousClass4 extends IDteValueCallback.Stub {
        AnonymousClass4() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
        public void onDteValueChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 3, i, 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDteValueCallback
        public void onGaugeFuelPercentChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 4, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$5 */
    class AnonymousClass5 extends IMotorDteValueCallback.Stub {
        AnonymousClass5() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IMotorDteValueCallback
        public void onMotorDteValueChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 29, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$6 */
    class AnonymousClass6 extends ITemperatureHighCallback.Stub {
        AnonymousClass6() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback
        public void onIviTemperatureHigh() throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 5));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$7 */
    class AnonymousClass7 extends IDiagDtcInfoCallback.Stub {
        AnonymousClass7() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback
        public void onDiagDtcInfoCb(int i, int i2) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 25, i, i2));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$8 */
    class AnonymousClass8 extends INaviInfoStatusCallback.Stub {
        AnonymousClass8() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.INaviInfoStatusCallback
        public void onNaviInfoStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 6, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$9 */
    class AnonymousClass9 extends IXModeDisplayStatusCallback.Stub {
        AnonymousClass9() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IXModeDisplayStatusCallback
        public void onXModeDisplayStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 7, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$10 */
    class AnonymousClass10 extends ICCODisplayStatusCallback.Stub {
        AnonymousClass10() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ICCODisplayStatusCallback
        public void onCCODisplayStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 8, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$11 */
    class AnonymousClass11 extends IAvmStatusCallback.Stub {
        AnonymousClass11() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
        public void onAvmStatusChanged(boolean z) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 9, !z ? 0 : 1, 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvmStatusCallback
        public void onAvmClosedBySpeed() throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 10));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$12 */
    class AnonymousClass12 extends IApaStatusCallback.Stub {
        AnonymousClass12() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
        public void onApaStatusChanged(boolean z) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 11, !z ? 0 : 1, 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
        public void onApaClosedBySpeed() throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 12));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$13 */
    class AnonymousClass13 extends IStrStatusCallback.Stub {
        AnonymousClass13() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IStrStatusCallback
        public void onStrStatusChanged(int i, boolean z) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 13, i, !z ? 0 : 1));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$14 */
    class AnonymousClass14 extends IRearviewMirrorStatusCallback.Stub {
        AnonymousClass14() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IRearviewMirrorStatusCallback
        public void onRearviewMirrorStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 14, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$15 */
    class AnonymousClass15 extends IRadarWarningStatusCallback.Stub {
        AnonymousClass15() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback
        public void onRadarWarningStatusChanged(boolean z) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 15, !z ? 0 : 1, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$16 */
    class AnonymousClass16 extends ISteeringAngleCallback.Stub {
        AnonymousClass16() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ISteeringAngleCallback
        public void onSteeringAngleChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 16, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$17 */
    class AnonymousClass17 extends ITyreTemperatureCallback.Stub {
        AnonymousClass17() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onLFTyreTempChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 17, i, 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onRFTyreTempChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 18, i, 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onLRTyreTempChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 19, i, 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onRRTyreTempChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 20, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$18 */
    class AnonymousClass18 extends IClusterNotifyKeytoneCallback.Stub {
        AnonymousClass18() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback
        public void onKeytone() throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 21));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$19 */
    class AnonymousClass19 extends IDoorOpenCallback.Stub {
        AnonymousClass19() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback
        public void onDoorOpen() throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 58));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$20 */
    class AnonymousClass20 extends IClusterLeftWarningCallback.Stub {
        AnonymousClass20() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterLeftWarningCallback
        public void onLeftSideWarningDisplay(boolean z) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 22, !z ? 0 : 1, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$21 */
    class AnonymousClass21 extends IGaugeSpeedValueCallback.Stub {
        AnonymousClass21() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IGaugeSpeedValueCallback
        public void onSpeedValueChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("speed", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 23, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$22 */
    class AnonymousClass22 extends IAvmLogDataCallback.Stub {
        AnonymousClass22() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvmLogDataCallback
        public void onAvmLogDataCallback(int i, int i2) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 24, i, i2));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$23 */
    class AnonymousClass23 extends IBootMusicPlayStatusCallback.Stub {
        AnonymousClass23() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IBootMusicPlayStatusCallback
        public void onBootMusicPlayStatus(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 26, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$24 */
    class AnonymousClass24 extends INaviProjectionStatusCallback.Stub {
        AnonymousClass24() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.INaviProjectionStatusCallback
        public void onNaviProjectionStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 27, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$25 */
    class AnonymousClass25 extends ICltcOrWltcCallback.Stub {
        AnonymousClass25() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback
        public void onCltcOrWltcModeChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 28, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$26 */
    class AnonymousClass26 extends IAvmCameraStatusCallback.Stub {
        AnonymousClass26() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvmCameraStatusCallback
        public void onAvmCameraStatusCallback(int i, int i2) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 30, i, i2));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$27 */
    class AnonymousClass27 extends IChargeViewStatusCallback.Stub {
        AnonymousClass27() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IChargeViewStatusCallback
        public void onChargeViewStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 31, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$28 */
    class AnonymousClass28 extends IVehicleFaultInfo.Stub {
        AnonymousClass28() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo
        public void onVehicleFaultInfoChanged(int[] iArr) throws RemoteException {
            ArrayList<Integer> arrayList = new ArrayList<>((List) Arrays.stream(iArr).boxed().collect(Collectors.toList()));
            Bundle bundle = new Bundle();
            bundle.putIntegerArrayList("bundleInfo", arrayList);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 32, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$29 */
    class AnonymousClass29 extends IChargePowerCallback.Stub {
        AnonymousClass29() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerCallback
        public void onChargePowerChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("power", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 33, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$30 */
    class AnonymousClass30 extends IChargeCurrentCallback.Stub {
        AnonymousClass30() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IChargeCurrentCallback
        public void onChargeCurrentChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat(Constant.CURRENT, f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 34, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$31 */
    class AnonymousClass31 extends IChargeVoltageCallback.Stub {
        AnonymousClass31() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IChargeVoltageCallback
        public void onChargeVoltageChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("voltage", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 35, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$32 */
    class AnonymousClass32 extends IAFCValueCallback.Stub {
        AnonymousClass32() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAFCValueCallback
        public void onAFCValueChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 36, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$33 */
    class AnonymousClass33 extends IAFCPHKMValueCallback.Stub {
        AnonymousClass33() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAFCPHKMValueCallback
        public void onAFCPHKMValueChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 37, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$34 */
    class AnonymousClass34 extends IDriveTimeCallback.Stub {
        AnonymousClass34() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDriveTimeCallback
        public void onDriveTimeChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 38, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$35 */
    class AnonymousClass35 extends IAvgSpdValueCallback.Stub {
        AnonymousClass35() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvgSpdValueCallback
        public void onAvgSpdValueChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 39, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$36 */
    class AnonymousClass36 extends IChargePowerInfoCallback.Stub {
        AnonymousClass36() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback
        public void onChargePowerInfoChanged(float f, float f2, float f3) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("chargingCurrent", f);
            bundle.putFloat("chargingVoltage", f2);
            bundle.putFloat("chargingPower", f3);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 40, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$37 */
    class AnonymousClass37 extends IPayloadMaintanceDistanceCallback.Stub {
        AnonymousClass37() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback
        public void onPayloadMaintanceDistanceChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 41, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$38 */
    class AnonymousClass38 extends IIFECallback.Stub {
        AnonymousClass38() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IIFECallback
        public void onIFEValueChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 42, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$39 */
    class AnonymousClass39 extends IMainTankResistanceCallback.Stub {
        AnonymousClass39() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IMainTankResistanceCallback
        public void onMainTankResistanceChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 43, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$40 */
    class AnonymousClass40 extends ISubTankResistanceCallback.Stub {
        AnonymousClass40() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ISubTankResistanceCallback
        public void onSubTankResistanceChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 44, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$41 */
    class AnonymousClass41 extends IAvgElecCallback.Stub {
        AnonymousClass41() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCallback
        public void onAvgElecChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("AvgElec", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$42 */
    class AnonymousClass42 extends IAvgFuCallback.Stub {
        AnonymousClass42() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCallback
        public void onAvgFuChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("AvgFu", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 46, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$43 */
    class AnonymousClass43 extends IAvgElecCnsCallback.Stub {
        AnonymousClass43() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvgElecCnsCallback
        public void onAvgElecCnsChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("ElecCns", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 54, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$44 */
    class AnonymousClass44 extends IAvgFuCnsCallback.Stub {
        AnonymousClass44() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IAvgFuCnsCallback
        public void onAvgFuCnsChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("FuCns", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 55, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$45 */
    class AnonymousClass45 extends IFuelVolumeDisplayCallback.Stub {
        AnonymousClass45() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback
        public void onFuelVolumeDisplayValueChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("FuelVolumeDsp", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 47, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$46 */
    class AnonymousClass46 extends IFuelVolumeSampleCallback.Stub {
        AnonymousClass46() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeSampleCallback
        public void onFuelVolumeSampleValueChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("FuelVolumeSp", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 48, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$47 */
    class AnonymousClass47 extends IDteAFCValueCallback.Stub {
        AnonymousClass47() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDteAFCValueCallback
        public void onDteAFCValueChanged(float f) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putFloat("DTEAFC", f);
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 45, bundle));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$48 */
    class AnonymousClass48 extends IFuelTankTypeCallback.Stub {
        AnonymousClass48() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback
        public void onFuelTankTypeChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 51, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$49 */
    class AnonymousClass49 extends IOverFillStateCallback.Stub {
        AnonymousClass49() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOverFillStateCallback
        public void onOverFillStateCallback(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 52, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$50 */
    class AnonymousClass50 extends IEnergyCurveProjectionCallback.Stub {
        AnonymousClass50() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IEnergyCurveProjectionCallback
        public void onEnergyCurveProjectionStatusChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 56, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$51 */
    class AnonymousClass51 extends IFuelAddEventCallback.Stub {
        AnonymousClass51() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IFuelAddEventCallback
        public void onFuelAddEventCallback(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 53, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$52 */
    class AnonymousClass52 extends IClusterThemeCallback.Stub {
        AnonymousClass52() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterThemeCallback
        public void onClusterThemeChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 57, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$53 */
    class AnonymousClass53 extends ITimeFormatChangedCallback.Stub {
        AnonymousClass53() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITimeFormatChangedCallback
        public void onTimeFormatChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 60, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$54 */
    class AnonymousClass54 extends IThemeSwitchCompleteCallback.Stub {
        AnonymousClass54() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IThemeSwitchCompleteCallback
        public void onSwitchComplete(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 59, i, 0));
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager$55 */
    class AnonymousClass55 extends IClusterFontCallback.Stub {
        AnonymousClass55() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterFontCallback
        public void onClusterFontChanged(int i) throws RemoteException {
            ALClusterInteractionManager.this.mManagerHandler.sendMessage(Message.obtain(ALClusterInteractionManager.this.mManagerHandler, 61, i, 0));
        }
    }

    public void registerRearviewMirrorStatusListener(ALRearviewMirrorStatusListener aLRearviewMirrorStatusListener) {
        if (this.mRearviewMirrorStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerRearviewMirrorStatusCallback(this.mRearviewMirrorStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mRearviewMirrorStatusListeners.contains(aLRearviewMirrorStatusListener)) {
            return;
        }
        this.mRearviewMirrorStatusListeners.add(aLRearviewMirrorStatusListener);
    }

    public void unregisterRearviewMirrorStatusListener(ALRearviewMirrorStatusListener aLRearviewMirrorStatusListener) {
        if (this.mRearviewMirrorStatusListeners.contains(aLRearviewMirrorStatusListener)) {
            this.mRearviewMirrorStatusListeners.remove(aLRearviewMirrorStatusListener);
            if (this.mRearviewMirrorStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterRearviewMirrorStatusCallback(this.mRearviewMirrorStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerXModeStatusListener(ALXModeDisplayStatusListener aLXModeDisplayStatusListener) {
        if (this.mXModeDisplayStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerXModeDisplayStatusCallback(this.mXModeDisplayStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mXModeDisplayStatusListeners.contains(aLXModeDisplayStatusListener)) {
            return;
        }
        this.mXModeDisplayStatusListeners.add(aLXModeDisplayStatusListener);
    }

    public void unregisterXModeStatusListener(ALXModeDisplayStatusListener aLXModeDisplayStatusListener) {
        if (this.mXModeDisplayStatusListeners.contains(aLXModeDisplayStatusListener)) {
            this.mXModeDisplayStatusListeners.remove(aLXModeDisplayStatusListener);
            if (this.mXModeDisplayStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterXModeDisplayStatusCallback(this.mXModeDisplayStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerCCOStatusListener(ALCCODisplayStatusListener aLCCODisplayStatusListener) {
        if (this.mCCODisplayStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerCCODisplayStatusCallback(this.mCCODisplayStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mCCODisplayStatusListeners.contains(aLCCODisplayStatusListener)) {
            return;
        }
        this.mCCODisplayStatusListeners.add(aLCCODisplayStatusListener);
    }

    public void unregisterCCOStatusListener(ALCCODisplayStatusListener aLCCODisplayStatusListener) {
        if (this.mCCODisplayStatusListeners.contains(aLCCODisplayStatusListener)) {
            this.mCCODisplayStatusListeners.remove(aLCCODisplayStatusListener);
            if (this.mCCODisplayStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterCCODisplayStatusCallback(this.mCCODisplayStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerDriverModeListener(ALDriverModeListener aLDriverModeListener) {
        Log.d(TAG, "registerDriverModeListener");
        if (this.mDriverModeListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerDriverModeCallback(this.mDriverModeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Log.d(TAG, "registerDriverModeListener:mDriverModeListeners is not empty!");
        }
        if (this.mDriverModeListeners.contains(aLDriverModeListener)) {
            return;
        }
        this.mDriverModeListeners.add(aLDriverModeListener);
    }

    public void unregisterDriverModeListener(ALDriverModeListener aLDriverModeListener) {
        if (this.mDriverModeListeners.contains(aLDriverModeListener)) {
            this.mDriverModeListeners.remove(aLDriverModeListener);
            if (this.mDriverModeListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterDriverModeCallback(this.mDriverModeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerTorqueLockStatusListener(ALTorqueLockStatusListener aLTorqueLockStatusListener) {
        if (this.mTorqueLockStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerTorqueLockStatusCallback(this.mTorqueLockStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mTorqueLockStatusListeners.contains(aLTorqueLockStatusListener)) {
            return;
        }
        this.mTorqueLockStatusListeners.add(aLTorqueLockStatusListener);
    }

    public void unregisterTorqueLockStatusListener(ALTorqueLockStatusListener aLTorqueLockStatusListener) {
        if (this.mTorqueLockStatusListeners.contains(aLTorqueLockStatusListener)) {
            this.mTorqueLockStatusListeners.remove(aLTorqueLockStatusListener);
            if (this.mTorqueLockStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterTorqueLockStatusCallback(this.mTorqueLockStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerDteValueListener(ALDteValueListener aLDteValueListener) {
        if (this.mDteValueListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerDteValueCallbackCallback(this.mDteValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mDteValueListeners.contains(aLDteValueListener)) {
            return;
        }
        this.mDteValueListeners.add(aLDteValueListener);
    }

    public void unregisterDteValueListener(ALDteValueListener aLDteValueListener) {
        if (this.mDteValueListeners.contains(aLDteValueListener)) {
            this.mDteValueListeners.remove(aLDteValueListener);
            if (this.mDteValueListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterDteValueCallbackCallback(this.mDteValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerDteCalculateValueCallback(ALDteCalculateValueListener aLDteCalculateValueListener) {
        if (this.mDteCalValueListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerDteCalculateValueCallback(this.mDteCalculateValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mDteCalValueListeners.contains(aLDteCalculateValueListener)) {
            return;
        }
        this.mDteCalValueListeners.add(aLDteCalculateValueListener);
    }

    public void unregisterDteCalculateValueCallback(ALDteCalculateValueListener aLDteCalculateValueListener) {
        if (this.mDteCalValueListeners.contains(aLDteCalculateValueListener)) {
            this.mDteCalValueListeners.remove(aLDteCalculateValueListener);
            if (this.mDteCalValueListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterDteCalculateValueCallback(this.mDteCalculateValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerMotorDteValueListener(ALMotorDteValueListener aLMotorDteValueListener) {
        if (this.mMotorDteValueListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerMotorDteValueCallback(this.mMotorDteValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMotorDteValueListeners.contains(aLMotorDteValueListener)) {
            return;
        }
        this.mMotorDteValueListeners.add(aLMotorDteValueListener);
    }

    public void unregisterMotorDteValueListener(ALMotorDteValueListener aLMotorDteValueListener) {
        if (this.mMotorDteValueListeners.contains(aLMotorDteValueListener)) {
            this.mMotorDteValueListeners.remove(aLMotorDteValueListener);
            if (this.mMotorDteValueListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterMotorDteValueCallback(this.mMotorDteValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerTemperatureHighListener(ALTemperatureHighListener aLTemperatureHighListener) {
        if (this.mTemperatureHighListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerTemperatureHighCallback(this.mTemperatureHighCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mTemperatureHighListeners.contains(aLTemperatureHighListener)) {
            return;
        }
        this.mTemperatureHighListeners.add(aLTemperatureHighListener);
    }

    public void unregisterTemperatureHighListener(ALTemperatureHighListener aLTemperatureHighListener) {
        if (this.mTemperatureHighListeners.contains(aLTemperatureHighListener)) {
            this.mTemperatureHighListeners.remove(aLTemperatureHighListener);
            if (this.mTemperatureHighListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterTemperatureHighCallback(this.mTemperatureHighCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerDiagDtcInfoListener(ALDiagDtcInfoListener aLDiagDtcInfoListener) {
        if (this.mDiagDtcInfoListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerDiagDtcCallback(this.mDiagDtcInfoCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mDiagDtcInfoListeners.contains(aLDiagDtcInfoListener)) {
            return;
        }
        this.mDiagDtcInfoListeners.add(aLDiagDtcInfoListener);
    }

    public void unregisterDiagDtcInfoListener(ALDiagDtcInfoListener aLDiagDtcInfoListener) {
        if (this.mDiagDtcInfoListeners.contains(aLDiagDtcInfoListener)) {
            this.mDiagDtcInfoListeners.remove(aLDiagDtcInfoListener);
            if (this.mDiagDtcInfoListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterDiagDtcCallback(this.mDiagDtcInfoCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerNaviInfoStatusListener(ALNaviInfoStatusListener aLNaviInfoStatusListener) {
        if (this.mNaviInfoListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerNaviInfoStatusCallback(this.mNaviInfoCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mNaviInfoListeners.contains(aLNaviInfoStatusListener)) {
            return;
        }
        this.mNaviInfoListeners.add(aLNaviInfoStatusListener);
    }

    public void unregisterNaviInfoStatusListener(ALNaviInfoStatusListener aLNaviInfoStatusListener) {
        if (this.mNaviInfoListeners.contains(aLNaviInfoStatusListener)) {
            this.mNaviInfoListeners.remove(aLNaviInfoStatusListener);
            if (this.mNaviInfoListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterNaviInfoStatusCallback(this.mNaviInfoCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerAvmStatusListener(ALAvmStatusListener aLAvmStatusListener) {
        if (this.mAvmStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvmStatusCallback(this.mAvmStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvmStatusListeners.contains(aLAvmStatusListener)) {
            return;
        }
        this.mAvmStatusListeners.add(aLAvmStatusListener);
    }

    public void unregisterAvmStatusListener(ALAvmStatusListener aLAvmStatusListener) {
        if (this.mAvmStatusListeners.contains(aLAvmStatusListener)) {
            this.mAvmStatusListeners.remove(aLAvmStatusListener);
            if (this.mAvmStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvmStatusCallback(this.mAvmStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerApaStatusListener(ALApaStatusListener aLApaStatusListener) {
        if (this.mApaStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerApaStatusCallback(this.mApaStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mApaStatusListeners.contains(aLApaStatusListener)) {
            return;
        }
        this.mApaStatusListeners.add(aLApaStatusListener);
    }

    public void unregisterApaStatusListener(ALApaStatusListener aLApaStatusListener) {
        if (this.mApaStatusListeners.contains(aLApaStatusListener)) {
            this.mApaStatusListeners.remove(aLApaStatusListener);
            if (this.mApaStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterApaStatusCallback(this.mApaStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerStrStatusListener(ALStrStatusListener aLStrStatusListener) {
        if (this.mStrStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerStrStatusCallback(this.mStrStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mStrStatusListeners.contains(aLStrStatusListener)) {
            return;
        }
        this.mStrStatusListeners.add(aLStrStatusListener);
    }

    public void unregisterStrStatusListener(ALStrStatusListener aLStrStatusListener) {
        if (this.mStrStatusListeners.contains(aLStrStatusListener)) {
            this.mStrStatusListeners.remove(aLStrStatusListener);
            if (this.mStrStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterStrStatusCallback(this.mStrStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerRadarWarningStatusCallback(ALRadarWarningStatusListener aLRadarWarningStatusListener) {
        if (this.mRadarWarningStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerRadarWarningStatusCallback(this.mRadarWarningStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mRadarWarningStatusListeners.contains(aLRadarWarningStatusListener)) {
            return;
        }
        this.mRadarWarningStatusListeners.add(aLRadarWarningStatusListener);
    }

    public void unregisterRadarWarningStatusCallback(ALRadarWarningStatusListener aLRadarWarningStatusListener) {
        if (this.mRadarWarningStatusListeners.contains(aLRadarWarningStatusListener)) {
            this.mRadarWarningStatusListeners.remove(aLRadarWarningStatusListener);
            if (this.mRadarWarningStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterRadarWarningStatusCallback(this.mRadarWarningStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerSteeringAngleCallback(ALSteeringAngleListener aLSteeringAngleListener) {
        if (this.mSteeringAngleListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerSteeringAngleCallback(this.mSteeringAngleCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mSteeringAngleListeners.contains(aLSteeringAngleListener)) {
            return;
        }
        this.mSteeringAngleListeners.add(aLSteeringAngleListener);
    }

    public void unregisterSteeringAngleCallback(ALSteeringAngleListener aLSteeringAngleListener) {
        if (this.mSteeringAngleListeners.contains(aLSteeringAngleListener)) {
            this.mSteeringAngleListeners.remove(aLSteeringAngleListener);
            if (this.mSteeringAngleListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterSteeringAngleCallback(this.mSteeringAngleCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerTyreTemperatureListeners(ALTyreTemperatureListener aLTyreTemperatureListener) {
        if (this.mTyreTemperatureListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerTyreTemperatureCallback(this.mTyreTemperatureCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mTyreTemperatureListeners.contains(aLTyreTemperatureListener)) {
            return;
        }
        this.mTyreTemperatureListeners.add(aLTyreTemperatureListener);
    }

    public void unregisterTyreTemperatureListeners(ALTyreTemperatureListener aLTyreTemperatureListener) {
        if (this.mTyreTemperatureListeners.contains(aLTyreTemperatureListener)) {
            this.mTyreTemperatureListeners.remove(aLTyreTemperatureListener);
            if (this.mTyreTemperatureListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterTyreTemperatureCallback(this.mTyreTemperatureCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerKeytoneCallback(ALKeytoneListener aLKeytoneListener) {
        if (this.mKeytoneListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerKeytoneCallback(this.mKeytoneCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mKeytoneListeners.contains(aLKeytoneListener)) {
            return;
        }
        this.mKeytoneListeners.add(aLKeytoneListener);
    }

    public void unregisterKeytoneCallback(ALKeytoneListener aLKeytoneListener) {
        if (this.mKeytoneListeners.contains(aLKeytoneListener)) {
            this.mKeytoneListeners.remove(aLKeytoneListener);
            if (this.mKeytoneListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterKeytoneCallback(this.mKeytoneCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerLeftSideWarningCallback(ALLeftSideWarningListener aLLeftSideWarningListener) {
        if (this.mLeftSideWarningListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerLeftSideWarningCallback(this.mLeftWarningCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mLeftSideWarningListeners.contains(aLLeftSideWarningListener)) {
            return;
        }
        this.mLeftSideWarningListeners.add(aLLeftSideWarningListener);
    }

    public void unregisterLeftSideWarningCallback(ALLeftSideWarningListener aLLeftSideWarningListener) {
        if (this.mLeftSideWarningListeners.contains(aLLeftSideWarningListener)) {
            this.mLeftSideWarningListeners.remove(aLLeftSideWarningListener);
            if (this.mLeftSideWarningListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterLeftSideWarningCallback(this.mLeftWarningCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerBootMusicPlayStatusCallback(ALBootMusicPlayStatusListener aLBootMusicPlayStatusListener) {
        if (this.mBootMusicPlayStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerBootMusicPlayStatusCallback(this.mBootMusicPlayStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mBootMusicPlayStatusListeners.contains(aLBootMusicPlayStatusListener)) {
            return;
        }
        this.mBootMusicPlayStatusListeners.add(aLBootMusicPlayStatusListener);
    }

    public void unregisterBootMusicPlayStatusCallback(ALBootMusicPlayStatusListener aLBootMusicPlayStatusListener) {
        if (this.mBootMusicPlayStatusListeners.contains(aLBootMusicPlayStatusListener)) {
            this.mBootMusicPlayStatusListeners.remove(aLBootMusicPlayStatusListener);
            if (this.mBootMusicPlayStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterBootMusicPlayStatusCallback(this.mBootMusicPlayStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerGaugeSpeedCallback(ALGaugeSpeedListener aLGaugeSpeedListener) {
        if (this.mGaugeSpeedListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerGaugeSpeedCallback(this.mGaugeSpeedCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mGaugeSpeedListeners.contains(aLGaugeSpeedListener)) {
            return;
        }
        this.mGaugeSpeedListeners.add(aLGaugeSpeedListener);
    }

    public void unregisterGaugeSpeedCallback(ALGaugeSpeedListener aLGaugeSpeedListener) {
        if (this.mGaugeSpeedListeners.contains(aLGaugeSpeedListener)) {
            this.mGaugeSpeedListeners.remove(aLGaugeSpeedListener);
            if (this.mGaugeSpeedListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterGaugeSpeedCallback(this.mGaugeSpeedCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerAvmLogDataCallback(ALAvmLogDataListener aLAvmLogDataListener) {
        if (this.mAvmLogDataListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvmLogDataCallback(this.mAvmLogDataCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvmLogDataListeners.contains(aLAvmLogDataListener)) {
            return;
        }
        this.mAvmLogDataListeners.add(aLAvmLogDataListener);
    }

    public void unregisterAvmLogDataCallback(ALAvmLogDataListener aLAvmLogDataListener) {
        if (this.mAvmLogDataListeners.contains(aLAvmLogDataListener)) {
            this.mAvmLogDataListeners.remove(aLAvmLogDataListener);
            if (this.mAvmLogDataListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvmLogDataCallback(this.mAvmLogDataCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerAvmCameraStatusCallback(ALAvmCameraStatusListener aLAvmCameraStatusListener) {
        if (this.mAvmCameraStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvmCameraStatusCallback(this.mAvmCameraStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvmCameraStatusListeners.contains(aLAvmCameraStatusListener)) {
            return;
        }
        this.mAvmCameraStatusListeners.add(aLAvmCameraStatusListener);
    }

    public void unregisterAvmCameraStatusCallback(ALAvmCameraStatusListener aLAvmCameraStatusListener) {
        if (this.mAvmCameraStatusListeners.contains(aLAvmCameraStatusListener)) {
            this.mAvmCameraStatusListeners.remove(aLAvmCameraStatusListener);
            if (this.mAvmCameraStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvmCameraStatusCallback(this.mAvmCameraStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void chimeTest() {
        if (this.mService != null) {
            try {
                Log.i(TAG, "chimeTest.");
                this.mService.chimeTest();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updatePhoneCallInfo(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.updatePhoneCallInfo(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateMediaInfo(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.updateMediaInfo(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateFuelUnit(FuelUnit fuelUnit) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.updateFuelUnit(fuelUnit.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCompassInfo(float f) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.updateCompassInfo(f);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateTimeFormat(boolean z) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.updateTimeFormat(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateRearViewKeyStatus(RearViewKeyStatus rearViewKeyStatus) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.updateRearViewKeyStatus(rearViewKeyStatus.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void bootAnimationCompleted() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.bootAnimationCompleted();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void appBootCompleted(FunctionRoler functionRoler) {
        if (this.mService != null) {
            try {
                Log.i(TAG, "appBootCompleted.");
                this.mService.appBootCompleted(functionRoler.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCCOFanStatus(boolean z) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setCCOFanStatus(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAirPressure(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setAirPressure(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAltitude(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setAltitude(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNaviCmd(NaviCmd naviCmd) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setNaviCmd(naviCmd.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNaviInfoStatus(NaviInfoStatus naviInfoStatus) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setNaviInfoStatus(naviInfoStatus.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDmsUserSwitch(boolean z) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setDmsUserSwitch(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDteValue() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getDteValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getGaugeFuelPercent() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getGaugeFuelPercent();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getMotorDteValue() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getMotorDteValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getDriveMode() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getDriveMode();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getXModeDisplayStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getXModeDisplayStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getCCODisplayStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getCCODisplayStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getFrontTorqueLockStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getFrontTorqueLockStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getRearTorqueLockStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getRearTorqueLockStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setDmsDriverActionLevel(DriverAction driverAction) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setDmsDriverActionLevel(driverAction.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDmsDriverDistractionLevel(DriverDistractionLevel driverDistractionLevel) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setDmsDriverDistractionLevel(driverDistractionLevel.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDmsDriverDrowsinessLevel(DriverDrowsinessLevel driverDrowsinessLevel) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setDmsDriverDrowsinessLevel(driverDrowsinessLevel.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setApaViewStatus(ApaEnterStyle apaEnterStyle, boolean z) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setApaViewStatus(apaEnterStyle.getNumber(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setAvmViewStatus(AvmEnterStyle avmEnterStyle, boolean z) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setAvmViewStatus(avmEnterStyle.getNumber(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStrReadStatus(StrSwitchStatusCmd strSwitchStatusCmd, boolean z) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setStrReadStatus(strSwitchStatusCmd.getNumber(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStrWriteStatus(StrSwitchStatusCmd strSwitchStatusCmd, boolean z) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setStrWriteStatus(strSwitchStatusCmd.getNumber(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCarPlateNumber(String str) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setCarPlateNumber(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendPitchAngleToMcu(int i, int i2) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.sendPitchAngleToMcu(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendPitchAngleToCluster(float f, float f2) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.sendPitchAngleToCluster(f, f2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTotalMileage(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setTotalMileage(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDriveMode(DriveMode driveMode) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setDriveMode(driveMode.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDriveMode(DriverModeType driverModeType) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setDriveMode(driverModeType.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setXModeStatus(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setXModeStatus(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDayNightMode(DayNightModeValue dayNightModeValue) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setDayNightMode(dayNightModeValue.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setNaviStartupStatus(NaviStartupStatus naviStartupStatus) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setNaviStartupStatus(naviStartupStatus.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setSunTime(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setSunTime(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int getLFTyreTemperature() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getLFTyreTemperature();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getRFTyreTemperature() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getRFTyreTemperature();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getLRTyreTemperature() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getLRTyreTemperature();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getRRTyreTemperature() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getRRTyreTemperature();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public float getCurrentSpeed() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1.0f;
        }
        try {
            return iClusterInteraction.getCurrentSpeed();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    public void getNaviProjectionStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.getNaviProjectionStatus();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerNaviProjectionStatusCallback(ALNaviProjectionStatusListener aLNaviProjectionStatusListener) {
        if (this.mNaviProjectionStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerNaviProjectionStatusCallback(this.mNaviProjectionStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mNaviProjectionStatusListeners.contains(aLNaviProjectionStatusListener)) {
            return;
        }
        this.mNaviProjectionStatusListeners.add(aLNaviProjectionStatusListener);
    }

    public void unregisterNaviProjectionStatusCallback(ALNaviProjectionStatusListener aLNaviProjectionStatusListener) {
        if (this.mNaviProjectionStatusListeners.contains(aLNaviProjectionStatusListener)) {
            this.mNaviProjectionStatusListeners.remove(aLNaviProjectionStatusListener);
            if (this.mNaviProjectionStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterNaviProjectionStatusCallback(this.mNaviProjectionStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean getAvmStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                return iClusterInteraction.getAvmStatus();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        Log.e(TAG, "service is null, can't get Avm status!");
        return false;
    }

    public void registerCltcOrWltcCallback(ALCltcOrWltcListener aLCltcOrWltcListener) {
        if (this.mCltcOrWltcListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerCltcOrWltcCallback(this.mCltcOrWltcCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mCltcOrWltcListeners.contains(aLCltcOrWltcListener)) {
            return;
        }
        this.mCltcOrWltcListeners.add(aLCltcOrWltcListener);
    }

    public void unregisterCltcOrWltcCallback(ALCltcOrWltcListener aLCltcOrWltcListener) {
        if (this.mCltcOrWltcListeners.contains(aLCltcOrWltcListener)) {
            this.mCltcOrWltcListeners.remove(aLCltcOrWltcListener);
            if (this.mCltcOrWltcListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterCltcOrWltcCallback(this.mCltcOrWltcCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setCltcOrWltcMode(CltcOrWltcMode cltcOrWltcMode) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setCltcOrWltcMode(cltcOrWltcMode.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCltcOrWltcMode() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getCltcOrWltcMode();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerChargeViewStatus(ALChargeViewStatusListener aLChargeViewStatusListener) {
        if (this.mChargeViewStatusListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerChargeViewStatus(this.mChargeViewStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mChargeViewStatusListeners.contains(aLChargeViewStatusListener)) {
            return;
        }
        this.mChargeViewStatusListeners.add(aLChargeViewStatusListener);
    }

    public void unregisterChargeViewStatus(ALChargeViewStatusListener aLChargeViewStatusListener) {
        if (this.mChargeViewStatusListeners.contains(aLChargeViewStatusListener)) {
            this.mChargeViewStatusListeners.remove(aLChargeViewStatusListener);
            if (this.mChargeViewStatusListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterChargeViewStatus(this.mChargeViewStatusCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setLaneAssistSetting(LaneAssistMode laneAssistMode) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setLaneAssistSetting(laneAssistMode.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setScheduleChargingTime(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setScheduleChargingTime(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerVehicleFaultInfoChange(ALVehicleFaultInfoListener aLVehicleFaultInfoListener) {
        if (this.mVehicleFaultInfoListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerVehicleFaultInfoChange(this.mVehicleFaultInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mVehicleFaultInfoListeners.contains(aLVehicleFaultInfoListener)) {
            return;
        }
        this.mVehicleFaultInfoListeners.add(aLVehicleFaultInfoListener);
    }

    public void unregisterVehicleFaultInfoChange(ALVehicleFaultInfoListener aLVehicleFaultInfoListener) {
        if (this.mVehicleFaultInfoListeners.contains(aLVehicleFaultInfoListener)) {
            this.mVehicleFaultInfoListeners.remove(aLVehicleFaultInfoListener);
            if (this.mVehicleFaultInfoListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterVehicleFaultInfoChange(this.mVehicleFaultInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setFatigueDriveTime(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setFatigueDriveTime(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setWarningSpeed(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setWarningSpeed(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setThemeMode(ThemeMode themeMode) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setThemeMode(themeMode.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setThemeToCluster(ClusterThemeMode clusterThemeMode) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setThemeToCluster(clusterThemeMode.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getVehicleFaultInfo() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.getVehicleFaultInfo();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void requestFactoryReset() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.requestFactoryReset();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyFactoryReset(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.notifyFactoryReset(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setWarningVolumeLevel(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setWarningVolumeLevel(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerChargingPowerCallback(ALChargePowerListener aLChargePowerListener) {
        if (this.mChargePowerListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerChargingPowerCallback(this.mChargePowerCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mChargePowerListeners.contains(aLChargePowerListener)) {
            return;
        }
        this.mChargePowerListeners.add(aLChargePowerListener);
    }

    public void unregisterChargingPowerCallback(ALChargePowerListener aLChargePowerListener) {
        if (this.mChargePowerListeners.contains(aLChargePowerListener)) {
            this.mChargePowerListeners.remove(aLChargePowerListener);
            if (this.mChargePowerListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterChargingPowerCallback(this.mChargePowerCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerChargingCurrentCallback(ALChargeCurrentListener aLChargeCurrentListener) {
        if (this.mChargeCurrentListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerChargingCurrentCallback(this.mChargeCurrentCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mChargeCurrentListeners.contains(aLChargeCurrentListener)) {
            return;
        }
        this.mChargeCurrentListeners.add(aLChargeCurrentListener);
    }

    public void unregisterChargingCurrentCallback(ALChargeCurrentListener aLChargeCurrentListener) {
        if (this.mChargeCurrentListeners.contains(aLChargeCurrentListener)) {
            this.mChargeCurrentListeners.remove(aLChargeCurrentListener);
            if (this.mChargeCurrentListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterChargingCurrentCallback(this.mChargeCurrentCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerChargingVoltageCallback(ALChargeVoltageListener aLChargeVoltageListener) {
        if (this.mChargeVoltageListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerChargingVoltageCallback(this.mChargeVoltageCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mChargeVoltageListeners.contains(aLChargeVoltageListener)) {
            return;
        }
        this.mChargeVoltageListeners.add(aLChargeVoltageListener);
    }

    public void unregisterChargingVoltageCallback(ALChargeVoltageListener aLChargeVoltageListener) {
        if (this.mChargeVoltageListeners.contains(aLChargeVoltageListener)) {
            this.mChargeVoltageListeners.remove(aLChargeVoltageListener);
            if (this.mChargeVoltageListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterChargingVoltageCallback(this.mChargeVoltageCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerChargingInfoCallback(ALChargeInfoListener aLChargeInfoListener) {
        if (this.mChargeInfoListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerChargingInfoCallback(this.mChargePowerInfoCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mChargeInfoListeners.contains(aLChargeInfoListener)) {
            return;
        }
        this.mChargeInfoListeners.add(aLChargeInfoListener);
    }

    public void unregisterChargingInfoCallback(ALChargeInfoListener aLChargeInfoListener) {
        if (this.mChargeInfoListeners.contains(aLChargeInfoListener)) {
            this.mChargeInfoListeners.remove(aLChargeInfoListener);
            if (this.mChargeInfoListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterChargingInfoCallback(this.mChargePowerInfoCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerAFCCallback(ALAFCListener aLAFCListener) {
        if (this.mAFCListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAFCCallback(this.mAFCValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAFCListeners.contains(aLAFCListener)) {
            return;
        }
        this.mAFCListeners.add(aLAFCListener);
    }

    public void unregisterAFCCallback(ALAFCListener aLAFCListener) {
        if (this.mAFCListeners.contains(aLAFCListener)) {
            this.mAFCListeners.remove(aLAFCListener);
            if (this.mAFCListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAFCCallback(this.mAFCValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getAFCValue() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getAFCValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerAFCPHKMCallback(ALAFCPHKMListener aLAFCPHKMListener) {
        if (this.mAFCPHKMListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAFCPHKMCallback(this.mAFCPHKMValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAFCPHKMListeners.contains(aLAFCPHKMListener)) {
            return;
        }
        this.mAFCPHKMListeners.add(aLAFCPHKMListener);
    }

    public void unregisterAFCPHKMCallback(ALAFCPHKMListener aLAFCPHKMListener) {
        if (this.mAFCPHKMListeners.contains(aLAFCPHKMListener)) {
            this.mAFCPHKMListeners.remove(aLAFCPHKMListener);
            if (this.mAFCPHKMListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAFCPHKMCallback(this.mAFCPHKMValueCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getAFCPHKMValue() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getAFCPHKMValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerDriveTimeCallback(ALDriveTimeListener aLDriveTimeListener) {
        if (this.mDriveTimeListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerDriveTimeCallback(this.mDriveTimeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mDriveTimeListeners.contains(aLDriveTimeListener)) {
            return;
        }
        this.mDriveTimeListeners.add(aLDriveTimeListener);
    }

    public void unregisterDriveTimeCallback(ALDriveTimeListener aLDriveTimeListener) {
        if (this.mDriveTimeListeners.contains(aLDriveTimeListener)) {
            this.mDriveTimeListeners.remove(aLDriveTimeListener);
            if (this.mDriveTimeListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterDriveTimeCallback(this.mDriveTimeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getDriveTime() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getDriveTime();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getTimeFormat() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getTimeFormat();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerAvgSpdCallback(ALAvgSpdListener aLAvgSpdListener) {
        if (this.mAvgSpdListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvgSpdCallback(this.mAvgSpdCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvgSpdListeners.contains(aLAvgSpdListener)) {
            return;
        }
        this.mAvgSpdListeners.add(aLAvgSpdListener);
    }

    public void unregisterAvgSpdCallback(ALAvgSpdListener aLAvgSpdListener) {
        if (this.mAvgSpdListeners.contains(aLAvgSpdListener)) {
            this.mAvgSpdListeners.remove(aLAvgSpdListener);
            if (this.mAvgSpdListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvgSpdCallback(this.mAvgSpdCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getAvgSpd() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getAvgSpd();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public float[] getChargingInfo() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                return iClusterInteraction.getChargingInfo();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return new float[0];
    }

    public void registerPayloadMaintanceDistanceCallback(ALPayloadMaintanceDistanceListener aLPayloadMaintanceDistanceListener) {
        if (this.mMaintanceDistanceListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerPayloadMaintanceDistanceCallback(this.mMaintanceDistanceCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMaintanceDistanceListeners.contains(aLPayloadMaintanceDistanceListener)) {
            return;
        }
        this.mMaintanceDistanceListeners.add(aLPayloadMaintanceDistanceListener);
    }

    public void unregisterPayloadMaintanceDistanceCallback(ALPayloadMaintanceDistanceListener aLPayloadMaintanceDistanceListener) {
        if (this.mMaintanceDistanceListeners.contains(aLPayloadMaintanceDistanceListener)) {
            this.mMaintanceDistanceListeners.remove(aLPayloadMaintanceDistanceListener);
            if (this.mMaintanceDistanceListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterPayloadMaintanceDistanceCallback(this.mMaintanceDistanceCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getPayloadMaintanceDistance() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getPayloadMaintanceDistance();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerIFECallback(ALIFEListener aLIFEListener) {
        if (this.mIFEListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerIFECallback(this.mIFECallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mIFEListeners.contains(aLIFEListener)) {
            return;
        }
        this.mIFEListeners.add(aLIFEListener);
    }

    public void unregisterIFECallback(ALIFEListener aLIFEListener) {
        if (this.mIFEListeners.contains(aLIFEListener)) {
            this.mIFEListeners.remove(aLIFEListener);
            if (this.mIFEListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.registerIFECallback(this.mIFECallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getIFEValue() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getIFEValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerMainTankResistanceCallback(ALMainTankResistanceListener aLMainTankResistanceListener) {
        if (this.mMainTankResistanceListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerMainTankResistanceCallback(this.mMainTankResistanceCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mMainTankResistanceListeners.contains(aLMainTankResistanceListener)) {
            return;
        }
        this.mMainTankResistanceListeners.add(aLMainTankResistanceListener);
    }

    public void unregisterMainTankResistanceCallback(ALMainTankResistanceListener aLMainTankResistanceListener) {
        if (this.mMainTankResistanceListeners.contains(aLMainTankResistanceListener)) {
            this.mMainTankResistanceListeners.remove(aLMainTankResistanceListener);
            if (this.mMainTankResistanceListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterMainTankResistanceCallback(this.mMainTankResistanceCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getMainTankResistance() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getMainTankResistance();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerSubTankResistanceCallback(ALSubTankResistanceListener aLSubTankResistanceListener) {
        if (this.mSubTankResistanceListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerSubTankResistanceCallback(this.mSubTankResistanceCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mSubTankResistanceListeners.contains(aLSubTankResistanceListener)) {
            return;
        }
        this.mSubTankResistanceListeners.add(aLSubTankResistanceListener);
    }

    public void unregisterSubTankResistanceCallback(ALSubTankResistanceListener aLSubTankResistanceListener) {
        if (this.mSubTankResistanceListeners.contains(aLSubTankResistanceListener)) {
            this.mSubTankResistanceListeners.remove(aLSubTankResistanceListener);
            if (this.mSubTankResistanceListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterSubTankResistanceCallback(this.mSubTankResistanceCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getSubTankResistance() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getSubTankResistance();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerAvgElecCallback(ALAvgElecListener aLAvgElecListener) {
        if (this.mAvgElecListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvgElecCallback(this.mAvgElecCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvgElecListeners.contains(aLAvgElecListener)) {
            return;
        }
        this.mAvgElecListeners.add(aLAvgElecListener);
    }

    public void unregisterAvgElecCallback(ALAvgElecListener aLAvgElecListener) {
        if (this.mAvgElecListeners.contains(aLAvgElecListener)) {
            this.mAvgElecListeners.remove(aLAvgElecListener);
            if (this.mAvgElecListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvgElecCallback(this.mAvgElecCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerAvgFuCallback(ALAvgFuListener aLAvgFuListener) {
        if (this.mAvgFuListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvgFuCallback(this.mAvgFuCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvgFuListeners.contains(aLAvgFuListener)) {
            return;
        }
        this.mAvgFuListeners.add(aLAvgFuListener);
    }

    public void unregisterAvgFuCallback(ALAvgFuListener aLAvgFuListener) {
        if (this.mAvgFuListeners.contains(aLAvgFuListener)) {
            this.mAvgFuListeners.remove(aLAvgFuListener);
            if (this.mAvgFuListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvgFuCallback(this.mAvgFuCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerFuelVolumeDisplayCallback(ALFuelVolumeDisplayListener aLFuelVolumeDisplayListener) {
        if (this.mFuelVolumeDisplayListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerFuelVolumeDisplayCallback(this.mFuelVolumeDspCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mFuelVolumeDisplayListeners.contains(aLFuelVolumeDisplayListener)) {
            return;
        }
        this.mFuelVolumeDisplayListeners.add(aLFuelVolumeDisplayListener);
    }

    public void unregisterFuelVolumeDisplayCallback(ALFuelVolumeDisplayListener aLFuelVolumeDisplayListener) {
        if (this.mFuelVolumeDisplayListeners.contains(aLFuelVolumeDisplayListener)) {
            this.mFuelVolumeDisplayListeners.remove(aLFuelVolumeDisplayListener);
            if (this.mFuelVolumeDisplayListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterFuelVolumeDisplayCallback(this.mFuelVolumeDspCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public float getFuelVolumeDisplay() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return 0.0f;
        }
        try {
            return iClusterInteraction.getFuelVolumeDisplay();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public void registerFuelVolumeSampleCallback(ALFuelVolumeSampleListener aLFuelVolumeSampleListener) {
        if (this.mFuelVolumeSampleListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerFuelVolumeSampleCallback(this.mFuelVolumeSpCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mFuelVolumeSampleListeners.contains(aLFuelVolumeSampleListener)) {
            return;
        }
        this.mFuelVolumeSampleListeners.add(aLFuelVolumeSampleListener);
    }

    public void unregisterFuelVolumeSampleCallback(ALFuelVolumeSampleListener aLFuelVolumeSampleListener) {
        if (this.mFuelVolumeSampleListeners.contains(aLFuelVolumeSampleListener)) {
            this.mFuelVolumeSampleListeners.remove(aLFuelVolumeSampleListener);
            if (this.mFuelVolumeSampleListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterFuelVolumeSampleCallback(this.mFuelVolumeSpCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public float getFuelVolumeSample() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return 0.0f;
        }
        try {
            return iClusterInteraction.getFuelVolumeSample();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public int getDteCalculateValue() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getDteCalculateValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerDteAFCValueCallback(ALDteAFCListener aLDteAFCListener) {
        if (this.mDteAFCListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerDteAFCValueCallback(this.mDteAfcCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mDteAFCListeners.contains(aLDteAFCListener)) {
            return;
        }
        this.mDteAFCListeners.add(aLDteAFCListener);
    }

    public void unregisterDteAFCValueCallback(ALDteAFCListener aLDteAFCListener) {
        if (this.mDteAFCListeners.contains(aLDteAFCListener)) {
            this.mDteAFCListeners.remove(aLDteAFCListener);
            if (this.mDteAFCListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterDteAFCValueCallback(this.mDteAfcCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public float getDteAFCValue() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return 0.0f;
        }
        try {
            return iClusterInteraction.getDteAFCValue();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public void registerFuelTankTypeCallback(ALFuelTankTypeListener aLFuelTankTypeListener) {
        if (this.mFuelTankTypeListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerFuelTankTypeCallback(this.mFuelTankTypeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mFuelTankTypeListeners.contains(aLFuelTankTypeListener)) {
            return;
        }
        this.mFuelTankTypeListeners.add(aLFuelTankTypeListener);
    }

    public void unregisterFuelTankTypeCallback(ALFuelTankTypeListener aLFuelTankTypeListener) {
        if (this.mFuelTankTypeListeners.contains(aLFuelTankTypeListener)) {
            this.mFuelTankTypeListeners.remove(aLFuelTankTypeListener);
            if (this.mFuelTankTypeListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterFuelTankTypeCallback(this.mFuelTankTypeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getFuelTankType() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getFuelTankType();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerOverFillStateCallback(ALOverFillStateListener aLOverFillStateListener) {
        if (this.mOverFillStateListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerOverFillStateCallback(this.mOverFillStateCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mOverFillStateListeners.contains(aLOverFillStateListener)) {
            return;
        }
        this.mOverFillStateListeners.add(aLOverFillStateListener);
    }

    public void unregisterOverFillStateCallback(ALOverFillStateListener aLOverFillStateListener) {
        if (this.mOverFillStateListeners.contains(aLOverFillStateListener)) {
            this.mOverFillStateListeners.remove(aLOverFillStateListener);
            if (this.mOverFillStateListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterOverFillStateCallback(this.mOverFillStateCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getOverFillState() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getOverFillState();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerFuelAddEventCallback(ALFuelAddEventListener aLFuelAddEventListener) {
        if (this.mFuelAddEventListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerFuelAddEventCallback(this.mFuelAddEventCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mFuelAddEventListeners.contains(aLFuelAddEventListener)) {
            return;
        }
        this.mFuelAddEventListeners.add(aLFuelAddEventListener);
    }

    public void unregisterFuelAddEventCallback(ALFuelAddEventListener aLFuelAddEventListener) {
        if (this.mFuelAddEventListeners.contains(aLFuelAddEventListener)) {
            this.mFuelAddEventListeners.remove(aLFuelAddEventListener);
            if (this.mFuelAddEventListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterFuelAddEventCallback(this.mFuelAddEventCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getFuelAddEvent() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getFuelAddEvent();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerAvgElecCnsCallback(ALAvgElecCnsListener aLAvgElecCnsListener) {
        if (this.mAvgElecCnsListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvgElecCnsCallback(this.mAvgElecCnsCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvgElecCnsListeners.contains(aLAvgElecCnsListener)) {
            return;
        }
        this.mAvgElecCnsListeners.add(aLAvgElecCnsListener);
    }

    public void unregisterAvgElecCnsCallback(ALAvgElecCnsListener aLAvgElecCnsListener) {
        if (this.mAvgElecCnsListeners.contains(aLAvgElecCnsListener)) {
            this.mAvgElecCnsListeners.remove(aLAvgElecCnsListener);
            if (this.mAvgElecCnsListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvgElecCnsCallback(this.mAvgElecCnsCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerAvgFuCnsCallback(ALAvgFuCnsListener aLAvgFuCnsListener) {
        if (this.mAvgFuCnsListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerAvgFuCnsCallback(this.mAvgFuCnsCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mAvgFuCnsListeners.contains(aLAvgFuCnsListener)) {
            return;
        }
        this.mAvgFuCnsListeners.add(aLAvgFuCnsListener);
    }

    public void unregisterAvgFuCnsCallback(ALAvgFuCnsListener aLAvgFuCnsListener) {
        if (this.mAvgFuCnsListeners.contains(aLAvgFuCnsListener)) {
            this.mAvgFuCnsListeners.remove(aLAvgFuCnsListener);
            if (this.mAvgFuCnsListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterAvgFuCnsCallback(this.mAvgFuCnsCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void notifyClusterLanguageSetting(LanguageType languageType) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.notifyClusterLanguageSetting(languageType.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerEnergyCurveProjectionCallback(ALEnergyCurveProjectionListener aLEnergyCurveProjectionListener) {
        if (this.mEnergyCurveProjectionListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerEnergyCurveProjectionCallback(this.mEnergyCurveProjectionCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mEnergyCurveProjectionListeners.contains(aLEnergyCurveProjectionListener)) {
            return;
        }
        this.mEnergyCurveProjectionListeners.add(aLEnergyCurveProjectionListener);
    }

    public void unregisterEnergyCurveProjectionCallback(ALEnergyCurveProjectionListener aLEnergyCurveProjectionListener) {
        if (this.mEnergyCurveProjectionListeners.contains(aLEnergyCurveProjectionListener)) {
            this.mEnergyCurveProjectionListeners.remove(aLEnergyCurveProjectionListener);
            if (this.mEnergyCurveProjectionListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterEnergyCurveProjectionCallback(this.mEnergyCurveProjectionCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getEnergyCurveProjectionStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getEnergyCurveProjectionStatus();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerClusterThemeCallback(ALClusterThemeListener aLClusterThemeListener) {
        if (this.mClusterThemeListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                ALLog.e("service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerClusterThemeCallback(this.mClusterThemeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mClusterThemeListeners.contains(aLClusterThemeListener)) {
            return;
        }
        this.mClusterThemeListeners.add(aLClusterThemeListener);
    }

    public void unregisterClusterThemeCallback(ALClusterThemeListener aLClusterThemeListener) {
        if (this.mClusterThemeListeners.contains(aLClusterThemeListener)) {
            this.mClusterThemeListeners.remove(aLClusterThemeListener);
            if (this.mClusterThemeListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    ALLog.e("service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterClusterThemeCallback(this.mClusterThemeCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getClusterTheme() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getClusterTheme();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getFatigueDriveTime() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getFatigueDriveTime();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getWarningSpeed() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getWarningSpeed();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getWarningVolumeLevel() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getWarningVolumeLevel();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerDoorOpenCallback(ALDoorOpenListener aLDoorOpenListener) {
        if (this.mDoorOpenListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerDoorOpenCallback(this.mDoorOpenCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mDoorOpenListeners.contains(aLDoorOpenListener)) {
            return;
        }
        this.mDoorOpenListeners.add(aLDoorOpenListener);
    }

    public void unregisterDoorOpenCallback(ALDoorOpenListener aLDoorOpenListener) {
        if (this.mDoorOpenListeners.contains(aLDoorOpenListener)) {
            this.mDoorOpenListeners.remove(aLDoorOpenListener);
            if (this.mDoorOpenListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterDoorOpenCallback(this.mDoorOpenCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void notifyAVMWindowsStatus(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.notifyAVMWindowsStatus(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTyrePressureUnit(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setTyrePressureUnit(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setSpeedUnit(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setSpeedUnit(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTemperatureUnit(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setTemperatureUnit(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int getTyrePressureUnit() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getTyrePressureUnit();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getSpeedUnit() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getSpeedUnit();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getTemperatureUnit() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getTemperatureUnit();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void setCarModelColor(CarModelColor carModelColor, int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setCarModelColor(carModelColor.getNumber(), i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void systemReset(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.systemReset(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void resetMaintenanceMileage() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.resetMaintenanceMileage();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void requestAvmStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.requestAvmStatus();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerClusterSwitchThemeCompleteCallback(ALThemeSwitchCompleteListener aLThemeSwitchCompleteListener) {
        if (this.mThemeSwitchListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerClusterSwitchThemeCompleteCallback(this.mThemeSwitchCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mThemeSwitchListeners.contains(aLThemeSwitchCompleteListener)) {
            return;
        }
        this.mThemeSwitchListeners.add(aLThemeSwitchCompleteListener);
    }

    public void unregisterClusterSwitchThemeCompleteCallback(ALThemeSwitchCompleteListener aLThemeSwitchCompleteListener) {
        if (this.mThemeSwitchListeners.contains(aLThemeSwitchCompleteListener)) {
            this.mThemeSwitchListeners.remove(aLThemeSwitchCompleteListener);
            if (this.mThemeSwitchListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterClusterSwitchThemeCompleteCallback(this.mThemeSwitchCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void registerTimeFormatChangedCallback(ALTimeFormatListener aLTimeFormatListener) {
        if (this.mTimeFormatListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerTimeFormatChangedCallback(this.mTimeFormatCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mTimeFormatListeners.contains(aLTimeFormatListener)) {
            return;
        }
        this.mTimeFormatListeners.add(aLTimeFormatListener);
    }

    public void unregisterTimeFormatChangedCallback(ALTimeFormatListener aLTimeFormatListener) {
        if (this.mTimeFormatListeners.contains(aLTimeFormatListener)) {
            this.mTimeFormatListeners.remove(aLTimeFormatListener);
            if (this.mTimeFormatListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterTimeFormatChangedCallback(this.mTimeFormatCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setClusterFont(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setClusterFont(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyClusterWallpaperChanged(WallpaperStyle wallpaperStyle) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.notifyClusterWallpaperChanged(wallpaperStyle.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerClusterFontCallback(ALClusterFontListener aLClusterFontListener) {
        if (this.mClusterFontListeners.isEmpty()) {
            IClusterInteraction iClusterInteraction = this.mService;
            if (iClusterInteraction == null) {
                Log.e(TAG, "service is null, please call after onServiceConnect!");
                return;
            } else {
                try {
                    iClusterInteraction.registerClusterFontCallback(this.mClusterFontCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.mClusterFontListeners.contains(aLClusterFontListener)) {
            return;
        }
        this.mClusterFontListeners.add(aLClusterFontListener);
    }

    public void unregisterClusterFontCallback(ALClusterFontListener aLClusterFontListener) {
        if (this.mClusterFontListeners.contains(aLClusterFontListener)) {
            this.mClusterFontListeners.remove(aLClusterFontListener);
            if (this.mClusterFontListeners.isEmpty()) {
                IClusterInteraction iClusterInteraction = this.mService;
                if (iClusterInteraction == null) {
                    Log.e(TAG, "service is null, please call after onServiceConnect!");
                    return;
                }
                try {
                    iClusterInteraction.unregisterClusterFontCallback(this.mClusterFontCallback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getClusterFont() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction == null) {
            return -1;
        }
        try {
            return iClusterInteraction.getClusterFont();
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
