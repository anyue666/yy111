package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
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
import com.autolink.adapterinterface.clusterinteraction.IClusterLeftWarningCallback;
import com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback;
import com.autolink.adapterinterface.clusterinteraction.IClusterThemeCallback;
import com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback;
import com.autolink.adapterinterface.clusterinteraction.IDmsCallback;
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
import com.autolink.adapterinterface.clusterinteraction.IOmsCallback;
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

/* loaded from: classes.dex */
public interface IClusterInteraction extends IInterface {

    public static class Default implements IClusterInteraction {
        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void appBootCompleted(int i) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void bootAnimationCompleted() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void chimeTest() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void deleteFaceIdReq(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void driverMonitorReq(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getAFCPHKMValue() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getAFCValue() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getAvgSpd() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public boolean getAvmStatus() throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getCCODisplayStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public float[] getChargingInfo() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getCltcOrWltcMode() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getClusterFont() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getClusterTheme() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public float getCurrentSpeed() throws RemoteException {
            return 0.0f;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void getDmsCameraStatus() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getDriveMode() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getDriveTime() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public float getDteAFCValue() throws RemoteException {
            return 0.0f;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getDteCalculateValue() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getDteValue() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getEnergyCurveProjectionStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getFatigueDriveTime() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getFrontTorqueLockStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getFuelAddEvent() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getFuelTankType() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public float getFuelVolumeDisplay() throws RemoteException {
            return 0.0f;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public float getFuelVolumeSample() throws RemoteException {
            return 0.0f;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getGaugeFuelPercent() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getIFEValue() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getLFTyreTemperature() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getLRTyreTemperature() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getMainTankResistance() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getMotorDteValue() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void getNaviProjectionStatus() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getOverFillState() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getPayloadMaintanceDistance() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getRFTyreTemperature() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getRRTyreTemperature() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getRearTorqueLockStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getSpeedUnit() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getSubTankResistance() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getTemperatureUnit() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getTimeFormat() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getTyrePressureUnit() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void getVehicleFaultInfo() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getWarningSpeed() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getWarningVolumeLevel() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public int getXModeDisplayStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void healthLoginReq(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void healthMonitorReq(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void loginFaceIdReq(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void notifyAVMWindowsStatus(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void notifyClusterLanguageSetting(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void notifyClusterWallpaperChanged(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void notifyFactoryReset(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void omsMonitoringReq(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAFCCallback(IAFCValueCallback iAFCValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAFCPHKMCallback(IAFCPHKMValueCallback iAFCPHKMValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerApaStatusCallback(IApaStatusCallback iApaStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvgElecCallback(IAvgElecCallback iAvgElecCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvgElecCnsCallback(IAvgElecCnsCallback iAvgElecCnsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvgFuCallback(IAvgFuCallback iAvgFuCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvgFuCnsCallback(IAvgFuCnsCallback iAvgFuCnsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvgSpdCallback(IAvgSpdValueCallback iAvgSpdValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvmCameraStatusCallback(IAvmCameraStatusCallback iAvmCameraStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvmLogDataCallback(IAvmLogDataCallback iAvmLogDataCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerAvmStatusCallback(IAvmStatusCallback iAvmStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback iBootMusicPlayStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerCCODisplayStatusCallback(ICCODisplayStatusCallback iCCODisplayStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerChargeViewStatus(IChargeViewStatusCallback iChargeViewStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerChargingCurrentCallback(IChargeCurrentCallback iChargeCurrentCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerChargingInfoCallback(IChargePowerInfoCallback iChargePowerInfoCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerChargingPowerCallback(IChargePowerCallback iChargePowerCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerChargingVoltageCallback(IChargeVoltageCallback iChargeVoltageCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerCltcOrWltcCallback(ICltcOrWltcCallback iCltcOrWltcCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerClusterFontCallback(IClusterFontCallback iClusterFontCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback iThemeSwitchCompleteCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerClusterThemeCallback(IClusterThemeCallback iClusterThemeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDiagDtcCallback(IDiagDtcInfoCallback iDiagDtcInfoCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDmsCallback(IDmsCallback iDmsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDoorOpenCallback(IDoorOpenCallback iDoorOpenCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDriveTimeCallback(IDriveTimeCallback iDriveTimeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDriverModeCallback(IDriverModeCallback iDriverModeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDteAFCValueCallback(IDteAFCValueCallback iDteAFCValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDteCalculateValueCallback(IDteCalculateValueCallback iDteCalculateValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerDteValueCallbackCallback(IDteValueCallback iDteValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback iEnergyCurveProjectionCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerFaceIdReq(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerFuelAddEventCallback(IFuelAddEventCallback iFuelAddEventCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerFuelTankTypeCallback(IFuelTankTypeCallback iFuelTankTypeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback iFuelVolumeDisplayCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerFuelVolumeSampleCallback(IFuelVolumeSampleCallback iFuelVolumeSampleCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerGaugeSpeedCallback(IGaugeSpeedValueCallback iGaugeSpeedValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerIFECallback(IIFECallback iIFECallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerKeytoneCallback(IClusterNotifyKeytoneCallback iClusterNotifyKeytoneCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerLeftSideWarningCallback(IClusterLeftWarningCallback iClusterLeftWarningCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerMainTankResistanceCallback(IMainTankResistanceCallback iMainTankResistanceCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerMotorDteValueCallback(IMotorDteValueCallback iMotorDteValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerNaviInfoStatusCallback(INaviInfoStatusCallback iNaviInfoStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerNaviProjectionStatusCallback(INaviProjectionStatusCallback iNaviProjectionStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerOmsCallback(IOmsCallback iOmsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerOverFillStateCallback(IOverFillStateCallback iOverFillStateCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback iPayloadMaintanceDistanceCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerRadarWarningStatusCallback(IRadarWarningStatusCallback iRadarWarningStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback iRearviewMirrorStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerSteeringAngleCallback(ISteeringAngleCallback iSteeringAngleCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerStrStatusCallback(IStrStatusCallback iStrStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerSubTankResistanceCallback(ISubTankResistanceCallback iSubTankResistanceCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerTemperatureHighCallback(ITemperatureHighCallback iTemperatureHighCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerTimeFormatChangedCallback(ITimeFormatChangedCallback iTimeFormatChangedCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerTorqueLockStatusCallback(ITorqueLockStatusCallback iTorqueLockStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerTyreTemperatureCallback(ITyreTemperatureCallback iTyreTemperatureCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerVehicleFaultInfoChange(IVehicleFaultInfo iVehicleFaultInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void registerXModeDisplayStatusCallback(IXModeDisplayStatusCallback iXModeDisplayStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void requestAvmStatus() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void requestFactoryReset() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void resetMaintenanceMileage() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void sendPitchAngleToCluster(float f, float f2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void sendPitchAngleToMcu(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setActivationLicense(String str) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setAirPressure(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setAltitude(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setApaViewStatus(int i, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setAvmViewStatus(int i, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setCCOFanStatus(boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setCarModelColor(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setCarPlateNumber(String str) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setCltcOrWltcMode(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setClusterFont(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setDayNightMode(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setDmsDriverActionLevel(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setDmsDriverDistractionLevel(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setDmsDriverDrowsinessLevel(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setDmsUserSwitch(boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setDriveMode(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setFatigueDriveTime(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setLaneAssistSetting(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setNaviCmd(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setNaviInfoStatus(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setNaviStartupStatus(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setScheduleChargingTime(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setSpeedUnit(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setStrReadStatus(int i, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setStrWriteStatus(int i, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setSunTime(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setTemperatureUnit(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setThemeMode(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setThemeToCluster(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setTotalMileage(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setTyrePressureUnit(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setWarningSpeed(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setWarningVolumeLevel(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void setXModeStatus(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void systemReset(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAFCCallback(IAFCValueCallback iAFCValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAFCPHKMCallback(IAFCPHKMValueCallback iAFCPHKMValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterApaStatusCallback(IApaStatusCallback iApaStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvgElecCallback(IAvgElecCallback iAvgElecCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvgElecCnsCallback(IAvgElecCnsCallback iAvgElecCnsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvgFuCallback(IAvgFuCallback iAvgFuCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvgFuCnsCallback(IAvgFuCnsCallback iAvgFuCnsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvgSpdCallback(IAvgSpdValueCallback iAvgSpdValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvmCameraStatusCallback(IAvmCameraStatusCallback iAvmCameraStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvmLogDataCallback(IAvmLogDataCallback iAvmLogDataCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterAvmStatusCallback(IAvmStatusCallback iAvmStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback iBootMusicPlayStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterCCODisplayStatusCallback(ICCODisplayStatusCallback iCCODisplayStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterChargeViewStatus(IChargeViewStatusCallback iChargeViewStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterChargingCurrentCallback(IChargeCurrentCallback iChargeCurrentCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterChargingInfoCallback(IChargePowerInfoCallback iChargePowerInfoCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterChargingPowerCallback(IChargePowerCallback iChargePowerCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterChargingVoltageCallback(IChargeVoltageCallback iChargeVoltageCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterCltcOrWltcCallback(ICltcOrWltcCallback iCltcOrWltcCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterClusterFontCallback(IClusterFontCallback iClusterFontCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback iThemeSwitchCompleteCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterClusterThemeCallback(IClusterThemeCallback iClusterThemeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDiagDtcCallback(IDiagDtcInfoCallback iDiagDtcInfoCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDmsCallback(IDmsCallback iDmsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDoorOpenCallback(IDoorOpenCallback iDoorOpenCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDriveTimeCallback(IDriveTimeCallback iDriveTimeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDriverModeCallback(IDriverModeCallback iDriverModeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDteAFCValueCallback(IDteAFCValueCallback iDteAFCValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDteCalculateValueCallback(IDteCalculateValueCallback iDteCalculateValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterDteValueCallbackCallback(IDteValueCallback iDteValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback iEnergyCurveProjectionCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterFuelAddEventCallback(IFuelAddEventCallback iFuelAddEventCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterFuelTankTypeCallback(IFuelTankTypeCallback iFuelTankTypeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback iFuelVolumeDisplayCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterFuelVolumeSampleCallback(IFuelVolumeSampleCallback iFuelVolumeSampleCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterGaugeSpeedCallback(IGaugeSpeedValueCallback iGaugeSpeedValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterIFECallback(IIFECallback iIFECallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterKeytoneCallback(IClusterNotifyKeytoneCallback iClusterNotifyKeytoneCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterLeftSideWarningCallback(IClusterLeftWarningCallback iClusterLeftWarningCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterMainTankResistanceCallback(IMainTankResistanceCallback iMainTankResistanceCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterMotorDteValueCallback(IMotorDteValueCallback iMotorDteValueCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterNaviInfoStatusCallback(INaviInfoStatusCallback iNaviInfoStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterNaviProjectionStatusCallback(INaviProjectionStatusCallback iNaviProjectionStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterOmsCallback(IOmsCallback iOmsCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterOverFillStateCallback(IOverFillStateCallback iOverFillStateCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback iPayloadMaintanceDistanceCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterRadarWarningStatusCallback(IRadarWarningStatusCallback iRadarWarningStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback iRearviewMirrorStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterSteeringAngleCallback(ISteeringAngleCallback iSteeringAngleCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterStrStatusCallback(IStrStatusCallback iStrStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterSubTankResistanceCallback(ISubTankResistanceCallback iSubTankResistanceCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterTemperatureHighCallback(ITemperatureHighCallback iTemperatureHighCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterTimeFormatChangedCallback(ITimeFormatChangedCallback iTimeFormatChangedCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterTorqueLockStatusCallback(ITorqueLockStatusCallback iTorqueLockStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterTyreTemperatureCallback(ITyreTemperatureCallback iTyreTemperatureCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterVehicleFaultInfoChange(IVehicleFaultInfo iVehicleFaultInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void unregisterXModeDisplayStatusCallback(IXModeDisplayStatusCallback iXModeDisplayStatusCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void updateCompassInfo(float f) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void updateFuelUnit(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void updateMediaInfo(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void updatePhoneCallInfo(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void updateRearViewKeyStatus(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
        public void updateTimeFormat(boolean z) throws RemoteException {
        }
    }

    void appBootCompleted(int i) throws RemoteException;

    void bootAnimationCompleted() throws RemoteException;

    void chimeTest() throws RemoteException;

    void deleteFaceIdReq(int i) throws RemoteException;

    void driverMonitorReq(int i) throws RemoteException;

    int getAFCPHKMValue() throws RemoteException;

    int getAFCValue() throws RemoteException;

    int getAvgSpd() throws RemoteException;

    boolean getAvmStatus() throws RemoteException;

    int getCCODisplayStatus() throws RemoteException;

    float[] getChargingInfo() throws RemoteException;

    int getCltcOrWltcMode() throws RemoteException;

    int getClusterFont() throws RemoteException;

    int getClusterTheme() throws RemoteException;

    float getCurrentSpeed() throws RemoteException;

    void getDmsCameraStatus() throws RemoteException;

    int getDriveMode() throws RemoteException;

    int getDriveTime() throws RemoteException;

    float getDteAFCValue() throws RemoteException;

    int getDteCalculateValue() throws RemoteException;

    int getDteValue() throws RemoteException;

    int getEnergyCurveProjectionStatus() throws RemoteException;

    int getFatigueDriveTime() throws RemoteException;

    int getFrontTorqueLockStatus() throws RemoteException;

    int getFuelAddEvent() throws RemoteException;

    int getFuelTankType() throws RemoteException;

    float getFuelVolumeDisplay() throws RemoteException;

    float getFuelVolumeSample() throws RemoteException;

    int getGaugeFuelPercent() throws RemoteException;

    int getIFEValue() throws RemoteException;

    int getLFTyreTemperature() throws RemoteException;

    int getLRTyreTemperature() throws RemoteException;

    int getMainTankResistance() throws RemoteException;

    int getMotorDteValue() throws RemoteException;

    void getNaviProjectionStatus() throws RemoteException;

    int getOverFillState() throws RemoteException;

    int getPayloadMaintanceDistance() throws RemoteException;

    int getRFTyreTemperature() throws RemoteException;

    int getRRTyreTemperature() throws RemoteException;

    int getRearTorqueLockStatus() throws RemoteException;

    int getSpeedUnit() throws RemoteException;

    int getSubTankResistance() throws RemoteException;

    int getTemperatureUnit() throws RemoteException;

    int getTimeFormat() throws RemoteException;

    int getTyrePressureUnit() throws RemoteException;

    void getVehicleFaultInfo() throws RemoteException;

    int getWarningSpeed() throws RemoteException;

    int getWarningVolumeLevel() throws RemoteException;

    int getXModeDisplayStatus() throws RemoteException;

    void healthLoginReq(int i) throws RemoteException;

    void healthMonitorReq(int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void loginFaceIdReq(int i) throws RemoteException;

    void notifyAVMWindowsStatus(int i) throws RemoteException;

    void notifyClusterLanguageSetting(int i) throws RemoteException;

    void notifyClusterWallpaperChanged(int i) throws RemoteException;

    void notifyFactoryReset(int i) throws RemoteException;

    void omsMonitoringReq(int i) throws RemoteException;

    void registerAFCCallback(IAFCValueCallback iAFCValueCallback) throws RemoteException;

    void registerAFCPHKMCallback(IAFCPHKMValueCallback iAFCPHKMValueCallback) throws RemoteException;

    void registerApaStatusCallback(IApaStatusCallback iApaStatusCallback) throws RemoteException;

    void registerAvgElecCallback(IAvgElecCallback iAvgElecCallback) throws RemoteException;

    void registerAvgElecCnsCallback(IAvgElecCnsCallback iAvgElecCnsCallback) throws RemoteException;

    void registerAvgFuCallback(IAvgFuCallback iAvgFuCallback) throws RemoteException;

    void registerAvgFuCnsCallback(IAvgFuCnsCallback iAvgFuCnsCallback) throws RemoteException;

    void registerAvgSpdCallback(IAvgSpdValueCallback iAvgSpdValueCallback) throws RemoteException;

    void registerAvmCameraStatusCallback(IAvmCameraStatusCallback iAvmCameraStatusCallback) throws RemoteException;

    void registerAvmLogDataCallback(IAvmLogDataCallback iAvmLogDataCallback) throws RemoteException;

    void registerAvmStatusCallback(IAvmStatusCallback iAvmStatusCallback) throws RemoteException;

    void registerBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback iBootMusicPlayStatusCallback) throws RemoteException;

    void registerCCODisplayStatusCallback(ICCODisplayStatusCallback iCCODisplayStatusCallback) throws RemoteException;

    void registerChargeViewStatus(IChargeViewStatusCallback iChargeViewStatusCallback) throws RemoteException;

    void registerChargingCurrentCallback(IChargeCurrentCallback iChargeCurrentCallback) throws RemoteException;

    void registerChargingInfoCallback(IChargePowerInfoCallback iChargePowerInfoCallback) throws RemoteException;

    void registerChargingPowerCallback(IChargePowerCallback iChargePowerCallback) throws RemoteException;

    void registerChargingVoltageCallback(IChargeVoltageCallback iChargeVoltageCallback) throws RemoteException;

    void registerCltcOrWltcCallback(ICltcOrWltcCallback iCltcOrWltcCallback) throws RemoteException;

    void registerClusterFontCallback(IClusterFontCallback iClusterFontCallback) throws RemoteException;

    void registerClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback iThemeSwitchCompleteCallback) throws RemoteException;

    void registerClusterThemeCallback(IClusterThemeCallback iClusterThemeCallback) throws RemoteException;

    void registerDiagDtcCallback(IDiagDtcInfoCallback iDiagDtcInfoCallback) throws RemoteException;

    void registerDmsCallback(IDmsCallback iDmsCallback) throws RemoteException;

    void registerDoorOpenCallback(IDoorOpenCallback iDoorOpenCallback) throws RemoteException;

    void registerDriveTimeCallback(IDriveTimeCallback iDriveTimeCallback) throws RemoteException;

    void registerDriverModeCallback(IDriverModeCallback iDriverModeCallback) throws RemoteException;

    void registerDteAFCValueCallback(IDteAFCValueCallback iDteAFCValueCallback) throws RemoteException;

    void registerDteCalculateValueCallback(IDteCalculateValueCallback iDteCalculateValueCallback) throws RemoteException;

    void registerDteValueCallbackCallback(IDteValueCallback iDteValueCallback) throws RemoteException;

    void registerEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback iEnergyCurveProjectionCallback) throws RemoteException;

    void registerFaceIdReq(int i, int i2) throws RemoteException;

    void registerFuelAddEventCallback(IFuelAddEventCallback iFuelAddEventCallback) throws RemoteException;

    void registerFuelTankTypeCallback(IFuelTankTypeCallback iFuelTankTypeCallback) throws RemoteException;

    void registerFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback iFuelVolumeDisplayCallback) throws RemoteException;

    void registerFuelVolumeSampleCallback(IFuelVolumeSampleCallback iFuelVolumeSampleCallback) throws RemoteException;

    void registerGaugeSpeedCallback(IGaugeSpeedValueCallback iGaugeSpeedValueCallback) throws RemoteException;

    void registerIFECallback(IIFECallback iIFECallback) throws RemoteException;

    void registerKeytoneCallback(IClusterNotifyKeytoneCallback iClusterNotifyKeytoneCallback) throws RemoteException;

    void registerLeftSideWarningCallback(IClusterLeftWarningCallback iClusterLeftWarningCallback) throws RemoteException;

    void registerMainTankResistanceCallback(IMainTankResistanceCallback iMainTankResistanceCallback) throws RemoteException;

    void registerMotorDteValueCallback(IMotorDteValueCallback iMotorDteValueCallback) throws RemoteException;

    void registerNaviInfoStatusCallback(INaviInfoStatusCallback iNaviInfoStatusCallback) throws RemoteException;

    void registerNaviProjectionStatusCallback(INaviProjectionStatusCallback iNaviProjectionStatusCallback) throws RemoteException;

    void registerOmsCallback(IOmsCallback iOmsCallback) throws RemoteException;

    void registerOverFillStateCallback(IOverFillStateCallback iOverFillStateCallback) throws RemoteException;

    void registerPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback iPayloadMaintanceDistanceCallback) throws RemoteException;

    void registerRadarWarningStatusCallback(IRadarWarningStatusCallback iRadarWarningStatusCallback) throws RemoteException;

    void registerRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback iRearviewMirrorStatusCallback) throws RemoteException;

    void registerSteeringAngleCallback(ISteeringAngleCallback iSteeringAngleCallback) throws RemoteException;

    void registerStrStatusCallback(IStrStatusCallback iStrStatusCallback) throws RemoteException;

    void registerSubTankResistanceCallback(ISubTankResistanceCallback iSubTankResistanceCallback) throws RemoteException;

    void registerTemperatureHighCallback(ITemperatureHighCallback iTemperatureHighCallback) throws RemoteException;

    void registerTimeFormatChangedCallback(ITimeFormatChangedCallback iTimeFormatChangedCallback) throws RemoteException;

    void registerTorqueLockStatusCallback(ITorqueLockStatusCallback iTorqueLockStatusCallback) throws RemoteException;

    void registerTyreTemperatureCallback(ITyreTemperatureCallback iTyreTemperatureCallback) throws RemoteException;

    void registerVehicleFaultInfoChange(IVehicleFaultInfo iVehicleFaultInfo) throws RemoteException;

    void registerXModeDisplayStatusCallback(IXModeDisplayStatusCallback iXModeDisplayStatusCallback) throws RemoteException;

    void requestAvmStatus() throws RemoteException;

    void requestFactoryReset() throws RemoteException;

    void resetMaintenanceMileage() throws RemoteException;

    void sendPitchAngleToCluster(float f, float f2) throws RemoteException;

    void sendPitchAngleToMcu(int i, int i2) throws RemoteException;

    void setActivationLicense(String str) throws RemoteException;

    void setAirPressure(int i) throws RemoteException;

    void setAltitude(int i) throws RemoteException;

    void setApaViewStatus(int i, boolean z) throws RemoteException;

    void setAvmViewStatus(int i, boolean z) throws RemoteException;

    void setCCOFanStatus(boolean z) throws RemoteException;

    void setCarModelColor(int i, int i2) throws RemoteException;

    void setCarPlateNumber(String str) throws RemoteException;

    void setCltcOrWltcMode(int i) throws RemoteException;

    void setClusterFont(int i) throws RemoteException;

    void setDayNightMode(int i) throws RemoteException;

    void setDmsDriverActionLevel(int i) throws RemoteException;

    void setDmsDriverDistractionLevel(int i) throws RemoteException;

    void setDmsDriverDrowsinessLevel(int i) throws RemoteException;

    void setDmsUserSwitch(boolean z) throws RemoteException;

    void setDriveMode(int i) throws RemoteException;

    void setFatigueDriveTime(int i) throws RemoteException;

    void setLaneAssistSetting(int i) throws RemoteException;

    void setNaviCmd(int i) throws RemoteException;

    void setNaviInfoStatus(int i) throws RemoteException;

    void setNaviStartupStatus(int i) throws RemoteException;

    void setScheduleChargingTime(int i) throws RemoteException;

    void setSpeedUnit(int i) throws RemoteException;

    void setStrReadStatus(int i, boolean z) throws RemoteException;

    void setStrWriteStatus(int i, boolean z) throws RemoteException;

    void setSunTime(int i) throws RemoteException;

    void setTemperatureUnit(int i) throws RemoteException;

    void setThemeMode(int i) throws RemoteException;

    void setThemeToCluster(int i) throws RemoteException;

    void setTotalMileage(int i) throws RemoteException;

    void setTyrePressureUnit(int i) throws RemoteException;

    void setWarningSpeed(int i) throws RemoteException;

    void setWarningVolumeLevel(int i) throws RemoteException;

    void setXModeStatus(int i) throws RemoteException;

    void systemReset(int i) throws RemoteException;

    void unregisterAFCCallback(IAFCValueCallback iAFCValueCallback) throws RemoteException;

    void unregisterAFCPHKMCallback(IAFCPHKMValueCallback iAFCPHKMValueCallback) throws RemoteException;

    void unregisterApaStatusCallback(IApaStatusCallback iApaStatusCallback) throws RemoteException;

    void unregisterAvgElecCallback(IAvgElecCallback iAvgElecCallback) throws RemoteException;

    void unregisterAvgElecCnsCallback(IAvgElecCnsCallback iAvgElecCnsCallback) throws RemoteException;

    void unregisterAvgFuCallback(IAvgFuCallback iAvgFuCallback) throws RemoteException;

    void unregisterAvgFuCnsCallback(IAvgFuCnsCallback iAvgFuCnsCallback) throws RemoteException;

    void unregisterAvgSpdCallback(IAvgSpdValueCallback iAvgSpdValueCallback) throws RemoteException;

    void unregisterAvmCameraStatusCallback(IAvmCameraStatusCallback iAvmCameraStatusCallback) throws RemoteException;

    void unregisterAvmLogDataCallback(IAvmLogDataCallback iAvmLogDataCallback) throws RemoteException;

    void unregisterAvmStatusCallback(IAvmStatusCallback iAvmStatusCallback) throws RemoteException;

    void unregisterBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback iBootMusicPlayStatusCallback) throws RemoteException;

    void unregisterCCODisplayStatusCallback(ICCODisplayStatusCallback iCCODisplayStatusCallback) throws RemoteException;

    void unregisterChargeViewStatus(IChargeViewStatusCallback iChargeViewStatusCallback) throws RemoteException;

    void unregisterChargingCurrentCallback(IChargeCurrentCallback iChargeCurrentCallback) throws RemoteException;

    void unregisterChargingInfoCallback(IChargePowerInfoCallback iChargePowerInfoCallback) throws RemoteException;

    void unregisterChargingPowerCallback(IChargePowerCallback iChargePowerCallback) throws RemoteException;

    void unregisterChargingVoltageCallback(IChargeVoltageCallback iChargeVoltageCallback) throws RemoteException;

    void unregisterCltcOrWltcCallback(ICltcOrWltcCallback iCltcOrWltcCallback) throws RemoteException;

    void unregisterClusterFontCallback(IClusterFontCallback iClusterFontCallback) throws RemoteException;

    void unregisterClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback iThemeSwitchCompleteCallback) throws RemoteException;

    void unregisterClusterThemeCallback(IClusterThemeCallback iClusterThemeCallback) throws RemoteException;

    void unregisterDiagDtcCallback(IDiagDtcInfoCallback iDiagDtcInfoCallback) throws RemoteException;

    void unregisterDmsCallback(IDmsCallback iDmsCallback) throws RemoteException;

    void unregisterDoorOpenCallback(IDoorOpenCallback iDoorOpenCallback) throws RemoteException;

    void unregisterDriveTimeCallback(IDriveTimeCallback iDriveTimeCallback) throws RemoteException;

    void unregisterDriverModeCallback(IDriverModeCallback iDriverModeCallback) throws RemoteException;

    void unregisterDteAFCValueCallback(IDteAFCValueCallback iDteAFCValueCallback) throws RemoteException;

    void unregisterDteCalculateValueCallback(IDteCalculateValueCallback iDteCalculateValueCallback) throws RemoteException;

    void unregisterDteValueCallbackCallback(IDteValueCallback iDteValueCallback) throws RemoteException;

    void unregisterEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback iEnergyCurveProjectionCallback) throws RemoteException;

    void unregisterFuelAddEventCallback(IFuelAddEventCallback iFuelAddEventCallback) throws RemoteException;

    void unregisterFuelTankTypeCallback(IFuelTankTypeCallback iFuelTankTypeCallback) throws RemoteException;

    void unregisterFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback iFuelVolumeDisplayCallback) throws RemoteException;

    void unregisterFuelVolumeSampleCallback(IFuelVolumeSampleCallback iFuelVolumeSampleCallback) throws RemoteException;

    void unregisterGaugeSpeedCallback(IGaugeSpeedValueCallback iGaugeSpeedValueCallback) throws RemoteException;

    void unregisterIFECallback(IIFECallback iIFECallback) throws RemoteException;

    void unregisterKeytoneCallback(IClusterNotifyKeytoneCallback iClusterNotifyKeytoneCallback) throws RemoteException;

    void unregisterLeftSideWarningCallback(IClusterLeftWarningCallback iClusterLeftWarningCallback) throws RemoteException;

    void unregisterMainTankResistanceCallback(IMainTankResistanceCallback iMainTankResistanceCallback) throws RemoteException;

    void unregisterMotorDteValueCallback(IMotorDteValueCallback iMotorDteValueCallback) throws RemoteException;

    void unregisterNaviInfoStatusCallback(INaviInfoStatusCallback iNaviInfoStatusCallback) throws RemoteException;

    void unregisterNaviProjectionStatusCallback(INaviProjectionStatusCallback iNaviProjectionStatusCallback) throws RemoteException;

    void unregisterOmsCallback(IOmsCallback iOmsCallback) throws RemoteException;

    void unregisterOverFillStateCallback(IOverFillStateCallback iOverFillStateCallback) throws RemoteException;

    void unregisterPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback iPayloadMaintanceDistanceCallback) throws RemoteException;

    void unregisterRadarWarningStatusCallback(IRadarWarningStatusCallback iRadarWarningStatusCallback) throws RemoteException;

    void unregisterRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback iRearviewMirrorStatusCallback) throws RemoteException;

    void unregisterSteeringAngleCallback(ISteeringAngleCallback iSteeringAngleCallback) throws RemoteException;

    void unregisterStrStatusCallback(IStrStatusCallback iStrStatusCallback) throws RemoteException;

    void unregisterSubTankResistanceCallback(ISubTankResistanceCallback iSubTankResistanceCallback) throws RemoteException;

    void unregisterTemperatureHighCallback(ITemperatureHighCallback iTemperatureHighCallback) throws RemoteException;

    void unregisterTimeFormatChangedCallback(ITimeFormatChangedCallback iTimeFormatChangedCallback) throws RemoteException;

    void unregisterTorqueLockStatusCallback(ITorqueLockStatusCallback iTorqueLockStatusCallback) throws RemoteException;

    void unregisterTyreTemperatureCallback(ITyreTemperatureCallback iTyreTemperatureCallback) throws RemoteException;

    void unregisterVehicleFaultInfoChange(IVehicleFaultInfo iVehicleFaultInfo) throws RemoteException;

    void unregisterXModeDisplayStatusCallback(IXModeDisplayStatusCallback iXModeDisplayStatusCallback) throws RemoteException;

    void updateCompassInfo(float f) throws RemoteException;

    void updateFuelUnit(int i) throws RemoteException;

    void updateMediaInfo(int i) throws RemoteException;

    void updatePhoneCallInfo(int i) throws RemoteException;

    void updateRearViewKeyStatus(int i) throws RemoteException;

    void updateTimeFormat(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IClusterInteraction {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IClusterInteraction";
        static final int TRANSACTION_appBootCompleted = 64;
        static final int TRANSACTION_bootAnimationCompleted = 53;
        static final int TRANSACTION_chimeTest = 46;
        static final int TRANSACTION_deleteFaceIdReq = 41;
        static final int TRANSACTION_driverMonitorReq = 43;
        static final int TRANSACTION_getAFCPHKMValue = 145;
        static final int TRANSACTION_getAFCValue = 142;
        static final int TRANSACTION_getAvgSpd = 151;
        static final int TRANSACTION_getAvmStatus = 106;
        static final int TRANSACTION_getCCODisplayStatus = 60;
        static final int TRANSACTION_getChargingInfo = 128;
        static final int TRANSACTION_getCltcOrWltcMode = 99;
        static final int TRANSACTION_getClusterFont = 215;
        static final int TRANSACTION_getClusterTheme = 205;
        static final int TRANSACTION_getCurrentSpeed = 102;
        static final int TRANSACTION_getDmsCameraStatus = 104;
        static final int TRANSACTION_getDriveMode = 58;
        static final int TRANSACTION_getDriveTime = 148;
        static final int TRANSACTION_getDteAFCValue = 194;
        static final int TRANSACTION_getDteCalculateValue = 191;
        static final int TRANSACTION_getDteValue = 57;
        static final int TRANSACTION_getEnergyCurveProjectionStatus = 131;
        static final int TRANSACTION_getFatigueDriveTime = 208;
        static final int TRANSACTION_getFrontTorqueLockStatus = 107;
        static final int TRANSACTION_getFuelAddEvent = 203;
        static final int TRANSACTION_getFuelTankType = 197;
        static final int TRANSACTION_getFuelVolumeDisplay = 185;
        static final int TRANSACTION_getFuelVolumeSample = 188;
        static final int TRANSACTION_getGaugeFuelPercent = 56;
        static final int TRANSACTION_getIFEValue = 154;
        static final int TRANSACTION_getLFTyreTemperature = 77;
        static final int TRANSACTION_getLRTyreTemperature = 79;
        static final int TRANSACTION_getMainTankResistance = 157;
        static final int TRANSACTION_getMotorDteValue = 35;
        static final int TRANSACTION_getNaviProjectionStatus = 65;
        static final int TRANSACTION_getOverFillState = 200;
        static final int TRANSACTION_getPayloadMaintanceDistance = 181;
        static final int TRANSACTION_getRFTyreTemperature = 78;
        static final int TRANSACTION_getRRTyreTemperature = 80;
        static final int TRANSACTION_getRearTorqueLockStatus = 108;
        static final int TRANSACTION_getSpeedUnit = 175;
        static final int TRANSACTION_getSubTankResistance = 160;
        static final int TRANSACTION_getTemperatureUnit = 176;
        static final int TRANSACTION_getTimeFormat = 167;
        static final int TRANSACTION_getTyrePressureUnit = 174;
        static final int TRANSACTION_getVehicleFaultInfo = 116;
        static final int TRANSACTION_getWarningSpeed = 209;
        static final int TRANSACTION_getWarningVolumeLevel = 210;
        static final int TRANSACTION_getXModeDisplayStatus = 59;
        static final int TRANSACTION_healthLoginReq = 45;
        static final int TRANSACTION_healthMonitorReq = 42;
        static final int TRANSACTION_loginFaceIdReq = 40;
        static final int TRANSACTION_notifyAVMWindowsStatus = 170;
        static final int TRANSACTION_notifyClusterLanguageSetting = 161;
        static final int TRANSACTION_notifyClusterWallpaperChanged = 218;
        static final int TRANSACTION_notifyFactoryReset = 118;
        static final int TRANSACTION_omsMonitoringReq = 44;
        static final int TRANSACTION_registerAFCCallback = 140;
        static final int TRANSACTION_registerAFCPHKMCallback = 143;
        static final int TRANSACTION_registerApaStatusCallback = 21;
        static final int TRANSACTION_registerAvgElecCallback = 132;
        static final int TRANSACTION_registerAvgElecCnsCallback = 138;
        static final int TRANSACTION_registerAvgFuCallback = 134;
        static final int TRANSACTION_registerAvgFuCnsCallback = 136;
        static final int TRANSACTION_registerAvgSpdCallback = 149;
        static final int TRANSACTION_registerAvmCameraStatusCallback = 95;
        static final int TRANSACTION_registerAvmLogDataCallback = 89;
        static final int TRANSACTION_registerAvmStatusCallback = 19;
        static final int TRANSACTION_registerBootMusicPlayStatusCallback = 91;
        static final int TRANSACTION_registerCCODisplayStatusCallback = 17;
        static final int TRANSACTION_registerChargeViewStatus = 109;
        static final int TRANSACTION_registerChargingCurrentCallback = 122;
        static final int TRANSACTION_registerChargingInfoCallback = 126;
        static final int TRANSACTION_registerChargingPowerCallback = 120;
        static final int TRANSACTION_registerChargingVoltageCallback = 124;
        static final int TRANSACTION_registerCltcOrWltcCallback = 97;
        static final int TRANSACTION_registerClusterFontCallback = 216;
        static final int TRANSACTION_registerClusterSwitchThemeCompleteCallback = 212;
        static final int TRANSACTION_registerClusterThemeCallback = 206;
        static final int TRANSACTION_registerDiagDtcCallback = 31;
        static final int TRANSACTION_registerDmsCallback = 1;
        static final int TRANSACTION_registerDoorOpenCallback = 164;
        static final int TRANSACTION_registerDriveTimeCallback = 146;
        static final int TRANSACTION_registerDriverModeCallback = 5;
        static final int TRANSACTION_registerDteAFCValueCallback = 192;
        static final int TRANSACTION_registerDteCalculateValueCallback = 189;
        static final int TRANSACTION_registerDteValueCallbackCallback = 9;
        static final int TRANSACTION_registerEnergyCurveProjectionCallback = 129;
        static final int TRANSACTION_registerFaceIdReq = 39;
        static final int TRANSACTION_registerFuelAddEventCallback = 201;
        static final int TRANSACTION_registerFuelTankTypeCallback = 195;
        static final int TRANSACTION_registerFuelVolumeDisplayCallback = 183;
        static final int TRANSACTION_registerFuelVolumeSampleCallback = 186;
        static final int TRANSACTION_registerGaugeSpeedCallback = 87;
        static final int TRANSACTION_registerIFECallback = 152;
        static final int TRANSACTION_registerKeytoneCallback = 83;
        static final int TRANSACTION_registerLeftSideWarningCallback = 85;
        static final int TRANSACTION_registerMainTankResistanceCallback = 155;
        static final int TRANSACTION_registerMotorDteValueCallback = 33;
        static final int TRANSACTION_registerNaviInfoStatusCallback = 13;
        static final int TRANSACTION_registerNaviProjectionStatusCallback = 93;
        static final int TRANSACTION_registerOmsCallback = 3;
        static final int TRANSACTION_registerOverFillStateCallback = 198;
        static final int TRANSACTION_registerPayloadMaintanceDistanceCallback = 179;
        static final int TRANSACTION_registerRadarWarningStatusCallback = 27;
        static final int TRANSACTION_registerRearviewMirrorStatusCallback = 25;
        static final int TRANSACTION_registerSteeringAngleCallback = 29;
        static final int TRANSACTION_registerStrStatusCallback = 23;
        static final int TRANSACTION_registerSubTankResistanceCallback = 158;
        static final int TRANSACTION_registerTemperatureHighCallback = 11;
        static final int TRANSACTION_registerTimeFormatChangedCallback = 168;
        static final int TRANSACTION_registerTorqueLockStatusCallback = 7;
        static final int TRANSACTION_registerTyreTemperatureCallback = 81;
        static final int TRANSACTION_registerVehicleFaultInfoChange = 112;
        static final int TRANSACTION_registerXModeDisplayStatusCallback = 15;
        static final int TRANSACTION_requestAvmStatus = 105;
        static final int TRANSACTION_requestFactoryReset = 117;
        static final int TRANSACTION_resetMaintenanceMileage = 178;
        static final int TRANSACTION_sendPitchAngleToCluster = 72;
        static final int TRANSACTION_sendPitchAngleToMcu = 71;
        static final int TRANSACTION_setActivationLicense = 54;
        static final int TRANSACTION_setAirPressure = 162;
        static final int TRANSACTION_setAltitude = 163;
        static final int TRANSACTION_setApaViewStatus = 66;
        static final int TRANSACTION_setAvmViewStatus = 67;
        static final int TRANSACTION_setCCOFanStatus = 55;
        static final int TRANSACTION_setCarModelColor = 177;
        static final int TRANSACTION_setCarPlateNumber = 70;
        static final int TRANSACTION_setCltcOrWltcMode = 100;
        static final int TRANSACTION_setClusterFont = 214;
        static final int TRANSACTION_setDayNightMode = 74;
        static final int TRANSACTION_setDmsDriverActionLevel = 61;
        static final int TRANSACTION_setDmsDriverDistractionLevel = 62;
        static final int TRANSACTION_setDmsDriverDrowsinessLevel = 63;
        static final int TRANSACTION_setDmsUserSwitch = 38;
        static final int TRANSACTION_setDriveMode = 103;
        static final int TRANSACTION_setFatigueDriveTime = 114;
        static final int TRANSACTION_setLaneAssistSetting = 101;
        static final int TRANSACTION_setNaviCmd = 36;
        static final int TRANSACTION_setNaviInfoStatus = 37;
        static final int TRANSACTION_setNaviStartupStatus = 75;
        static final int TRANSACTION_setScheduleChargingTime = 111;
        static final int TRANSACTION_setSpeedUnit = 172;
        static final int TRANSACTION_setStrReadStatus = 68;
        static final int TRANSACTION_setStrWriteStatus = 69;
        static final int TRANSACTION_setSunTime = 76;
        static final int TRANSACTION_setTemperatureUnit = 173;
        static final int TRANSACTION_setThemeMode = 182;
        static final int TRANSACTION_setThemeToCluster = 204;
        static final int TRANSACTION_setTotalMileage = 73;
        static final int TRANSACTION_setTyrePressureUnit = 171;
        static final int TRANSACTION_setWarningSpeed = 115;
        static final int TRANSACTION_setWarningVolumeLevel = 119;
        static final int TRANSACTION_setXModeStatus = 166;
        static final int TRANSACTION_systemReset = 211;
        static final int TRANSACTION_unregisterAFCCallback = 141;
        static final int TRANSACTION_unregisterAFCPHKMCallback = 144;
        static final int TRANSACTION_unregisterApaStatusCallback = 22;
        static final int TRANSACTION_unregisterAvgElecCallback = 133;
        static final int TRANSACTION_unregisterAvgElecCnsCallback = 139;
        static final int TRANSACTION_unregisterAvgFuCallback = 135;
        static final int TRANSACTION_unregisterAvgFuCnsCallback = 137;
        static final int TRANSACTION_unregisterAvgSpdCallback = 150;
        static final int TRANSACTION_unregisterAvmCameraStatusCallback = 96;
        static final int TRANSACTION_unregisterAvmLogDataCallback = 90;
        static final int TRANSACTION_unregisterAvmStatusCallback = 20;
        static final int TRANSACTION_unregisterBootMusicPlayStatusCallback = 92;
        static final int TRANSACTION_unregisterCCODisplayStatusCallback = 18;
        static final int TRANSACTION_unregisterChargeViewStatus = 110;
        static final int TRANSACTION_unregisterChargingCurrentCallback = 123;
        static final int TRANSACTION_unregisterChargingInfoCallback = 127;
        static final int TRANSACTION_unregisterChargingPowerCallback = 121;
        static final int TRANSACTION_unregisterChargingVoltageCallback = 125;
        static final int TRANSACTION_unregisterCltcOrWltcCallback = 98;
        static final int TRANSACTION_unregisterClusterFontCallback = 217;
        static final int TRANSACTION_unregisterClusterSwitchThemeCompleteCallback = 213;
        static final int TRANSACTION_unregisterClusterThemeCallback = 207;
        static final int TRANSACTION_unregisterDiagDtcCallback = 32;
        static final int TRANSACTION_unregisterDmsCallback = 2;
        static final int TRANSACTION_unregisterDoorOpenCallback = 165;
        static final int TRANSACTION_unregisterDriveTimeCallback = 147;
        static final int TRANSACTION_unregisterDriverModeCallback = 6;
        static final int TRANSACTION_unregisterDteAFCValueCallback = 193;
        static final int TRANSACTION_unregisterDteCalculateValueCallback = 190;
        static final int TRANSACTION_unregisterDteValueCallbackCallback = 10;
        static final int TRANSACTION_unregisterEnergyCurveProjectionCallback = 130;
        static final int TRANSACTION_unregisterFuelAddEventCallback = 202;
        static final int TRANSACTION_unregisterFuelTankTypeCallback = 196;
        static final int TRANSACTION_unregisterFuelVolumeDisplayCallback = 184;
        static final int TRANSACTION_unregisterFuelVolumeSampleCallback = 187;
        static final int TRANSACTION_unregisterGaugeSpeedCallback = 88;
        static final int TRANSACTION_unregisterIFECallback = 153;
        static final int TRANSACTION_unregisterKeytoneCallback = 84;
        static final int TRANSACTION_unregisterLeftSideWarningCallback = 86;
        static final int TRANSACTION_unregisterMainTankResistanceCallback = 156;
        static final int TRANSACTION_unregisterMotorDteValueCallback = 34;
        static final int TRANSACTION_unregisterNaviInfoStatusCallback = 14;
        static final int TRANSACTION_unregisterNaviProjectionStatusCallback = 94;
        static final int TRANSACTION_unregisterOmsCallback = 4;
        static final int TRANSACTION_unregisterOverFillStateCallback = 199;
        static final int TRANSACTION_unregisterPayloadMaintanceDistanceCallback = 180;
        static final int TRANSACTION_unregisterRadarWarningStatusCallback = 28;
        static final int TRANSACTION_unregisterRearviewMirrorStatusCallback = 26;
        static final int TRANSACTION_unregisterSteeringAngleCallback = 30;
        static final int TRANSACTION_unregisterStrStatusCallback = 24;
        static final int TRANSACTION_unregisterSubTankResistanceCallback = 159;
        static final int TRANSACTION_unregisterTemperatureHighCallback = 12;
        static final int TRANSACTION_unregisterTimeFormatChangedCallback = 169;
        static final int TRANSACTION_unregisterTorqueLockStatusCallback = 8;
        static final int TRANSACTION_unregisterTyreTemperatureCallback = 82;
        static final int TRANSACTION_unregisterVehicleFaultInfoChange = 113;
        static final int TRANSACTION_unregisterXModeDisplayStatusCallback = 16;
        static final int TRANSACTION_updateCompassInfo = 50;
        static final int TRANSACTION_updateFuelUnit = 49;
        static final int TRANSACTION_updateMediaInfo = 48;
        static final int TRANSACTION_updatePhoneCallInfo = 47;
        static final int TRANSACTION_updateRearViewKeyStatus = 52;
        static final int TRANSACTION_updateTimeFormat = 51;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IClusterInteraction asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IClusterInteraction)) {
                return (IClusterInteraction) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDmsCallback(IDmsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDmsCallback(IDmsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerOmsCallback(IOmsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterOmsCallback(IOmsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDriverModeCallback(IDriverModeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDriverModeCallback(IDriverModeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerTorqueLockStatusCallback(ITorqueLockStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterTorqueLockStatusCallback(ITorqueLockStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDteValueCallbackCallback(IDteValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDteValueCallbackCallback(IDteValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerTemperatureHighCallback(ITemperatureHighCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterTemperatureHighCallback(ITemperatureHighCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerNaviInfoStatusCallback(INaviInfoStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterNaviInfoStatusCallback(INaviInfoStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerXModeDisplayStatusCallback(IXModeDisplayStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterXModeDisplayStatusCallback(IXModeDisplayStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCCODisplayStatusCallback(ICCODisplayStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCCODisplayStatusCallback(ICCODisplayStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvmStatusCallback(IAvmStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvmStatusCallback(IAvmStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerApaStatusCallback(IApaStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterApaStatusCallback(IApaStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerStrStatusCallback(IStrStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterStrStatusCallback(IStrStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerRadarWarningStatusCallback(IRadarWarningStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterRadarWarningStatusCallback(IRadarWarningStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerSteeringAngleCallback(ISteeringAngleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterSteeringAngleCallback(ISteeringAngleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDiagDtcCallback(IDiagDtcInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDiagDtcCallback(IDiagDtcInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerMotorDteValueCallback(IMotorDteValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterMotorDteValueCallback(IMotorDteValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    int motorDteValue = getMotorDteValue();
                    parcel2.writeNoException();
                    parcel2.writeInt(motorDteValue);
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    setNaviCmd(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    setNaviInfoStatus(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDmsUserSwitch(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerFaceIdReq(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    loginFaceIdReq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    deleteFaceIdReq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    healthMonitorReq(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    driverMonitorReq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    omsMonitoringReq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    healthLoginReq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    chimeTest();
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    updatePhoneCallInfo(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateMediaInfo(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateFuelUnit(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateCompassInfo(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateTimeFormat(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 52:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateRearViewKeyStatus(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 53:
                    parcel.enforceInterface(DESCRIPTOR);
                    bootAnimationCompleted();
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface(DESCRIPTOR);
                    setActivationLicense(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 55:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCCOFanStatus(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 56:
                    parcel.enforceInterface(DESCRIPTOR);
                    int gaugeFuelPercent = getGaugeFuelPercent();
                    parcel2.writeNoException();
                    parcel2.writeInt(gaugeFuelPercent);
                    return true;
                case 57:
                    parcel.enforceInterface(DESCRIPTOR);
                    int dteValue = getDteValue();
                    parcel2.writeNoException();
                    parcel2.writeInt(dteValue);
                    return true;
                case 58:
                    parcel.enforceInterface(DESCRIPTOR);
                    int driveMode = getDriveMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(driveMode);
                    return true;
                case 59:
                    parcel.enforceInterface(DESCRIPTOR);
                    int xModeDisplayStatus = getXModeDisplayStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(xModeDisplayStatus);
                    return true;
                case 60:
                    parcel.enforceInterface(DESCRIPTOR);
                    int cCODisplayStatus = getCCODisplayStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(cCODisplayStatus);
                    return true;
                case 61:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDmsDriverActionLevel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 62:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDmsDriverDistractionLevel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 63:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDmsDriverDrowsinessLevel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 64:
                    parcel.enforceInterface(DESCRIPTOR);
                    appBootCompleted(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 65:
                    parcel.enforceInterface(DESCRIPTOR);
                    getNaviProjectionStatus();
                    parcel2.writeNoException();
                    return true;
                case 66:
                    parcel.enforceInterface(DESCRIPTOR);
                    setApaViewStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 67:
                    parcel.enforceInterface(DESCRIPTOR);
                    setAvmViewStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 68:
                    parcel.enforceInterface(DESCRIPTOR);
                    setStrReadStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 69:
                    parcel.enforceInterface(DESCRIPTOR);
                    setStrWriteStatus(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 70:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCarPlateNumber(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 71:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendPitchAngleToMcu(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 72:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendPitchAngleToCluster(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 73:
                    parcel.enforceInterface(DESCRIPTOR);
                    setTotalMileage(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 74:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDayNightMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 75:
                    parcel.enforceInterface(DESCRIPTOR);
                    setNaviStartupStatus(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 76:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSunTime(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 77:
                    parcel.enforceInterface(DESCRIPTOR);
                    int lFTyreTemperature = getLFTyreTemperature();
                    parcel2.writeNoException();
                    parcel2.writeInt(lFTyreTemperature);
                    return true;
                case 78:
                    parcel.enforceInterface(DESCRIPTOR);
                    int rFTyreTemperature = getRFTyreTemperature();
                    parcel2.writeNoException();
                    parcel2.writeInt(rFTyreTemperature);
                    return true;
                case 79:
                    parcel.enforceInterface(DESCRIPTOR);
                    int lRTyreTemperature = getLRTyreTemperature();
                    parcel2.writeNoException();
                    parcel2.writeInt(lRTyreTemperature);
                    return true;
                case 80:
                    parcel.enforceInterface(DESCRIPTOR);
                    int rRTyreTemperature = getRRTyreTemperature();
                    parcel2.writeNoException();
                    parcel2.writeInt(rRTyreTemperature);
                    return true;
                case 81:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerTyreTemperatureCallback(ITyreTemperatureCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 82:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterTyreTemperatureCallback(ITyreTemperatureCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 83:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerKeytoneCallback(IClusterNotifyKeytoneCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 84:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterKeytoneCallback(IClusterNotifyKeytoneCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 85:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerLeftSideWarningCallback(IClusterLeftWarningCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 86:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterLeftSideWarningCallback(IClusterLeftWarningCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 87:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerGaugeSpeedCallback(IGaugeSpeedValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 88:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterGaugeSpeedCallback(IGaugeSpeedValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 89:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvmLogDataCallback(IAvmLogDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 90:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvmLogDataCallback(IAvmLogDataCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 91:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 92:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 93:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerNaviProjectionStatusCallback(INaviProjectionStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 94:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterNaviProjectionStatusCallback(INaviProjectionStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 95:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvmCameraStatusCallback(IAvmCameraStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 96:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvmCameraStatusCallback(IAvmCameraStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 97:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCltcOrWltcCallback(ICltcOrWltcCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 98:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCltcOrWltcCallback(ICltcOrWltcCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 99:
                    parcel.enforceInterface(DESCRIPTOR);
                    int cltcOrWltcMode = getCltcOrWltcMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(cltcOrWltcMode);
                    return true;
                case 100:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCltcOrWltcMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 101:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLaneAssistSetting(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 102:
                    parcel.enforceInterface(DESCRIPTOR);
                    float currentSpeed = getCurrentSpeed();
                    parcel2.writeNoException();
                    parcel2.writeFloat(currentSpeed);
                    return true;
                case 103:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDriveMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 104:
                    parcel.enforceInterface(DESCRIPTOR);
                    getDmsCameraStatus();
                    parcel2.writeNoException();
                    return true;
                case 105:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestAvmStatus();
                    parcel2.writeNoException();
                    return true;
                case 106:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean avmStatus = getAvmStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(avmStatus ? 1 : 0);
                    return true;
                case 107:
                    parcel.enforceInterface(DESCRIPTOR);
                    int frontTorqueLockStatus = getFrontTorqueLockStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(frontTorqueLockStatus);
                    return true;
                case 108:
                    parcel.enforceInterface(DESCRIPTOR);
                    int rearTorqueLockStatus = getRearTorqueLockStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(rearTorqueLockStatus);
                    return true;
                case 109:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerChargeViewStatus(IChargeViewStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 110:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterChargeViewStatus(IChargeViewStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 111:
                    parcel.enforceInterface(DESCRIPTOR);
                    setScheduleChargingTime(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 112:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerVehicleFaultInfoChange(IVehicleFaultInfo.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 113:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterVehicleFaultInfoChange(IVehicleFaultInfo.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 114:
                    parcel.enforceInterface(DESCRIPTOR);
                    setFatigueDriveTime(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 115:
                    parcel.enforceInterface(DESCRIPTOR);
                    setWarningSpeed(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 116:
                    parcel.enforceInterface(DESCRIPTOR);
                    getVehicleFaultInfo();
                    parcel2.writeNoException();
                    return true;
                case 117:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestFactoryReset();
                    parcel2.writeNoException();
                    return true;
                case 118:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyFactoryReset(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 119:
                    parcel.enforceInterface(DESCRIPTOR);
                    setWarningVolumeLevel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 120:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerChargingPowerCallback(IChargePowerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 121:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterChargingPowerCallback(IChargePowerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 122:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerChargingCurrentCallback(IChargeCurrentCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 123:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterChargingCurrentCallback(IChargeCurrentCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 124:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerChargingVoltageCallback(IChargeVoltageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 125:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterChargingVoltageCallback(IChargeVoltageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 126:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerChargingInfoCallback(IChargePowerInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 127:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterChargingInfoCallback(IChargePowerInfoCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 128:
                    parcel.enforceInterface(DESCRIPTOR);
                    float[] chargingInfo = getChargingInfo();
                    parcel2.writeNoException();
                    parcel2.writeFloatArray(chargingInfo);
                    return true;
                case TRANSACTION_registerEnergyCurveProjectionCallback /* 129 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterEnergyCurveProjectionCallback /* 130 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getEnergyCurveProjectionStatus /* 131 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int energyCurveProjectionStatus = getEnergyCurveProjectionStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(energyCurveProjectionStatus);
                    return true;
                case TRANSACTION_registerAvgElecCallback /* 132 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvgElecCallback(IAvgElecCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterAvgElecCallback /* 133 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvgElecCallback(IAvgElecCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_registerAvgFuCallback /* 134 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvgFuCallback(IAvgFuCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterAvgFuCallback /* 135 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvgFuCallback(IAvgFuCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_registerAvgFuCnsCallback /* 136 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvgFuCnsCallback(IAvgFuCnsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterAvgFuCnsCallback /* 137 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvgFuCnsCallback(IAvgFuCnsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 138:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvgElecCnsCallback(IAvgElecCnsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 139:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvgElecCnsCallback(IAvgElecCnsCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 140:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAFCCallback(IAFCValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 141:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAFCCallback(IAFCValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getAFCValue /* 142 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int aFCValue = getAFCValue();
                    parcel2.writeNoException();
                    parcel2.writeInt(aFCValue);
                    return true;
                case TRANSACTION_registerAFCPHKMCallback /* 143 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAFCPHKMCallback(IAFCPHKMValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 144:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAFCPHKMCallback(IAFCPHKMValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 145:
                    parcel.enforceInterface(DESCRIPTOR);
                    int aFCPHKMValue = getAFCPHKMValue();
                    parcel2.writeNoException();
                    parcel2.writeInt(aFCPHKMValue);
                    return true;
                case TRANSACTION_registerDriveTimeCallback /* 146 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDriveTimeCallback(IDriveTimeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterDriveTimeCallback /* 147 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDriveTimeCallback(IDriveTimeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getDriveTime /* 148 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int driveTime = getDriveTime();
                    parcel2.writeNoException();
                    parcel2.writeInt(driveTime);
                    return true;
                case TRANSACTION_registerAvgSpdCallback /* 149 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAvgSpdCallback(IAvgSpdValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterAvgSpdCallback /* 150 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAvgSpdCallback(IAvgSpdValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getAvgSpd /* 151 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int avgSpd = getAvgSpd();
                    parcel2.writeNoException();
                    parcel2.writeInt(avgSpd);
                    return true;
                case TRANSACTION_registerIFECallback /* 152 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerIFECallback(IIFECallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterIFECallback /* 153 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterIFECallback(IIFECallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getIFEValue /* 154 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iFEValue = getIFEValue();
                    parcel2.writeNoException();
                    parcel2.writeInt(iFEValue);
                    return true;
                case TRANSACTION_registerMainTankResistanceCallback /* 155 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerMainTankResistanceCallback(IMainTankResistanceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterMainTankResistanceCallback /* 156 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterMainTankResistanceCallback(IMainTankResistanceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getMainTankResistance /* 157 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int mainTankResistance = getMainTankResistance();
                    parcel2.writeNoException();
                    parcel2.writeInt(mainTankResistance);
                    return true;
                case TRANSACTION_registerSubTankResistanceCallback /* 158 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerSubTankResistanceCallback(ISubTankResistanceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterSubTankResistanceCallback /* 159 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterSubTankResistanceCallback(ISubTankResistanceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getSubTankResistance /* 160 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int subTankResistance = getSubTankResistance();
                    parcel2.writeNoException();
                    parcel2.writeInt(subTankResistance);
                    return true;
                case TRANSACTION_notifyClusterLanguageSetting /* 161 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyClusterLanguageSetting(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setAirPressure /* 162 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setAirPressure(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setAltitude /* 163 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setAltitude(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 164:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDoorOpenCallback(IDoorOpenCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 165:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDoorOpenCallback(IDoorOpenCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setXModeStatus /* 166 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setXModeStatus(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getTimeFormat /* 167 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int timeFormat = getTimeFormat();
                    parcel2.writeNoException();
                    parcel2.writeInt(timeFormat);
                    return true;
                case TRANSACTION_registerTimeFormatChangedCallback /* 168 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerTimeFormatChangedCallback(ITimeFormatChangedCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterTimeFormatChangedCallback /* 169 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterTimeFormatChangedCallback(ITimeFormatChangedCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_notifyAVMWindowsStatus /* 170 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyAVMWindowsStatus(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setTyrePressureUnit /* 171 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setTyrePressureUnit(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setSpeedUnit /* 172 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSpeedUnit(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setTemperatureUnit /* 173 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setTemperatureUnit(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getTyrePressureUnit /* 174 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int tyrePressureUnit = getTyrePressureUnit();
                    parcel2.writeNoException();
                    parcel2.writeInt(tyrePressureUnit);
                    return true;
                case TRANSACTION_getSpeedUnit /* 175 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int speedUnit = getSpeedUnit();
                    parcel2.writeNoException();
                    parcel2.writeInt(speedUnit);
                    return true;
                case TRANSACTION_getTemperatureUnit /* 176 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int temperatureUnit = getTemperatureUnit();
                    parcel2.writeNoException();
                    parcel2.writeInt(temperatureUnit);
                    return true;
                case TRANSACTION_setCarModelColor /* 177 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCarModelColor(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_resetMaintenanceMileage /* 178 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    resetMaintenanceMileage();
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_registerPayloadMaintanceDistanceCallback /* 179 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterPayloadMaintanceDistanceCallback /* 180 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getPayloadMaintanceDistance /* 181 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int payloadMaintanceDistance = getPayloadMaintanceDistance();
                    parcel2.writeNoException();
                    parcel2.writeInt(payloadMaintanceDistance);
                    return true;
                case TRANSACTION_setThemeMode /* 182 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    setThemeMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_registerFuelVolumeDisplayCallback /* 183 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterFuelVolumeDisplayCallback /* 184 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getFuelVolumeDisplay /* 185 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    float fuelVolumeDisplay = getFuelVolumeDisplay();
                    parcel2.writeNoException();
                    parcel2.writeFloat(fuelVolumeDisplay);
                    return true;
                case TRANSACTION_registerFuelVolumeSampleCallback /* 186 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerFuelVolumeSampleCallback(IFuelVolumeSampleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterFuelVolumeSampleCallback /* 187 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterFuelVolumeSampleCallback(IFuelVolumeSampleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getFuelVolumeSample /* 188 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    float fuelVolumeSample = getFuelVolumeSample();
                    parcel2.writeNoException();
                    parcel2.writeFloat(fuelVolumeSample);
                    return true;
                case TRANSACTION_registerDteCalculateValueCallback /* 189 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDteCalculateValueCallback(IDteCalculateValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterDteCalculateValueCallback /* 190 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDteCalculateValueCallback(IDteCalculateValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getDteCalculateValue /* 191 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int dteCalculateValue = getDteCalculateValue();
                    parcel2.writeNoException();
                    parcel2.writeInt(dteCalculateValue);
                    return true;
                case TRANSACTION_registerDteAFCValueCallback /* 192 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDteAFCValueCallback(IDteAFCValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterDteAFCValueCallback /* 193 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDteAFCValueCallback(IDteAFCValueCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getDteAFCValue /* 194 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    float dteAFCValue = getDteAFCValue();
                    parcel2.writeNoException();
                    parcel2.writeFloat(dteAFCValue);
                    return true;
                case TRANSACTION_registerFuelTankTypeCallback /* 195 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerFuelTankTypeCallback(IFuelTankTypeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterFuelTankTypeCallback /* 196 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterFuelTankTypeCallback(IFuelTankTypeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getFuelTankType /* 197 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    int fuelTankType = getFuelTankType();
                    parcel2.writeNoException();
                    parcel2.writeInt(fuelTankType);
                    return true;
                case TRANSACTION_registerOverFillStateCallback /* 198 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerOverFillStateCallback(IOverFillStateCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_unregisterOverFillStateCallback /* 199 */:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterOverFillStateCallback(IOverFillStateCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 200:
                    parcel.enforceInterface(DESCRIPTOR);
                    int overFillState = getOverFillState();
                    parcel2.writeNoException();
                    parcel2.writeInt(overFillState);
                    return true;
                case 201:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerFuelAddEventCallback(IFuelAddEventCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 202:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterFuelAddEventCallback(IFuelAddEventCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 203:
                    parcel.enforceInterface(DESCRIPTOR);
                    int fuelAddEvent = getFuelAddEvent();
                    parcel2.writeNoException();
                    parcel2.writeInt(fuelAddEvent);
                    return true;
                case 204:
                    parcel.enforceInterface(DESCRIPTOR);
                    setThemeToCluster(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 205:
                    parcel.enforceInterface(DESCRIPTOR);
                    int clusterTheme = getClusterTheme();
                    parcel2.writeNoException();
                    parcel2.writeInt(clusterTheme);
                    return true;
                case 206:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerClusterThemeCallback(IClusterThemeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 207:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterClusterThemeCallback(IClusterThemeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 208:
                    parcel.enforceInterface(DESCRIPTOR);
                    int fatigueDriveTime = getFatigueDriveTime();
                    parcel2.writeNoException();
                    parcel2.writeInt(fatigueDriveTime);
                    return true;
                case 209:
                    parcel.enforceInterface(DESCRIPTOR);
                    int warningSpeed = getWarningSpeed();
                    parcel2.writeNoException();
                    parcel2.writeInt(warningSpeed);
                    return true;
                case 210:
                    parcel.enforceInterface(DESCRIPTOR);
                    int warningVolumeLevel = getWarningVolumeLevel();
                    parcel2.writeNoException();
                    parcel2.writeInt(warningVolumeLevel);
                    return true;
                case 211:
                    parcel.enforceInterface(DESCRIPTOR);
                    systemReset(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 212:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 213:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 214:
                    parcel.enforceInterface(DESCRIPTOR);
                    setClusterFont(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 215:
                    parcel.enforceInterface(DESCRIPTOR);
                    int clusterFont = getClusterFont();
                    parcel2.writeNoException();
                    parcel2.writeInt(clusterFont);
                    return true;
                case 216:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerClusterFontCallback(IClusterFontCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 217:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterClusterFontCallback(IClusterFontCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 218:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyClusterWallpaperChanged(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IClusterInteraction {
            public static IClusterInteraction sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDmsCallback(IDmsCallback iDmsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDmsCallback != null ? iDmsCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDmsCallback(iDmsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDmsCallback(IDmsCallback iDmsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDmsCallback != null ? iDmsCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDmsCallback(iDmsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerOmsCallback(IOmsCallback iOmsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOmsCallback != null ? iOmsCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerOmsCallback(iOmsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterOmsCallback(IOmsCallback iOmsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOmsCallback != null ? iOmsCallback.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterOmsCallback(iOmsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDriverModeCallback(IDriverModeCallback iDriverModeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDriverModeCallback != null ? iDriverModeCallback.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDriverModeCallback(iDriverModeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDriverModeCallback(IDriverModeCallback iDriverModeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDriverModeCallback != null ? iDriverModeCallback.asBinder() : null);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDriverModeCallback(iDriverModeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerTorqueLockStatusCallback(ITorqueLockStatusCallback iTorqueLockStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTorqueLockStatusCallback != null ? iTorqueLockStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerTorqueLockStatusCallback(iTorqueLockStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterTorqueLockStatusCallback(ITorqueLockStatusCallback iTorqueLockStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTorqueLockStatusCallback != null ? iTorqueLockStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterTorqueLockStatusCallback(iTorqueLockStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDteValueCallbackCallback(IDteValueCallback iDteValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDteValueCallback != null ? iDteValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDteValueCallbackCallback(iDteValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDteValueCallbackCallback(IDteValueCallback iDteValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDteValueCallback != null ? iDteValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDteValueCallbackCallback(iDteValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerTemperatureHighCallback(ITemperatureHighCallback iTemperatureHighCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTemperatureHighCallback != null ? iTemperatureHighCallback.asBinder() : null);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerTemperatureHighCallback(iTemperatureHighCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterTemperatureHighCallback(ITemperatureHighCallback iTemperatureHighCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTemperatureHighCallback != null ? iTemperatureHighCallback.asBinder() : null);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterTemperatureHighCallback(iTemperatureHighCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerNaviInfoStatusCallback(INaviInfoStatusCallback iNaviInfoStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNaviInfoStatusCallback != null ? iNaviInfoStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerNaviInfoStatusCallback(iNaviInfoStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterNaviInfoStatusCallback(INaviInfoStatusCallback iNaviInfoStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNaviInfoStatusCallback != null ? iNaviInfoStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterNaviInfoStatusCallback(iNaviInfoStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerXModeDisplayStatusCallback(IXModeDisplayStatusCallback iXModeDisplayStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXModeDisplayStatusCallback != null ? iXModeDisplayStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerXModeDisplayStatusCallback(iXModeDisplayStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterXModeDisplayStatusCallback(IXModeDisplayStatusCallback iXModeDisplayStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iXModeDisplayStatusCallback != null ? iXModeDisplayStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterXModeDisplayStatusCallback(iXModeDisplayStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerCCODisplayStatusCallback(ICCODisplayStatusCallback iCCODisplayStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCCODisplayStatusCallback != null ? iCCODisplayStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCCODisplayStatusCallback(iCCODisplayStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterCCODisplayStatusCallback(ICCODisplayStatusCallback iCCODisplayStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCCODisplayStatusCallback != null ? iCCODisplayStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCCODisplayStatusCallback(iCCODisplayStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvmStatusCallback(IAvmStatusCallback iAvmStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvmStatusCallback != null ? iAvmStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvmStatusCallback(iAvmStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvmStatusCallback(IAvmStatusCallback iAvmStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvmStatusCallback != null ? iAvmStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvmStatusCallback(iAvmStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerApaStatusCallback(IApaStatusCallback iApaStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iApaStatusCallback != null ? iApaStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerApaStatusCallback(iApaStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterApaStatusCallback(IApaStatusCallback iApaStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iApaStatusCallback != null ? iApaStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterApaStatusCallback(iApaStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerStrStatusCallback(IStrStatusCallback iStrStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iStrStatusCallback != null ? iStrStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerStrStatusCallback(iStrStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterStrStatusCallback(IStrStatusCallback iStrStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iStrStatusCallback != null ? iStrStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterStrStatusCallback(iStrStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback iRearviewMirrorStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRearviewMirrorStatusCallback != null ? iRearviewMirrorStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerRearviewMirrorStatusCallback(iRearviewMirrorStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterRearviewMirrorStatusCallback(IRearviewMirrorStatusCallback iRearviewMirrorStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRearviewMirrorStatusCallback != null ? iRearviewMirrorStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterRearviewMirrorStatusCallback(iRearviewMirrorStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerRadarWarningStatusCallback(IRadarWarningStatusCallback iRadarWarningStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRadarWarningStatusCallback != null ? iRadarWarningStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerRadarWarningStatusCallback(iRadarWarningStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterRadarWarningStatusCallback(IRadarWarningStatusCallback iRadarWarningStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRadarWarningStatusCallback != null ? iRadarWarningStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterRadarWarningStatusCallback(iRadarWarningStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerSteeringAngleCallback(ISteeringAngleCallback iSteeringAngleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSteeringAngleCallback != null ? iSteeringAngleCallback.asBinder() : null);
                    if (!this.mRemote.transact(29, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerSteeringAngleCallback(iSteeringAngleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterSteeringAngleCallback(ISteeringAngleCallback iSteeringAngleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSteeringAngleCallback != null ? iSteeringAngleCallback.asBinder() : null);
                    if (!this.mRemote.transact(30, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterSteeringAngleCallback(iSteeringAngleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDiagDtcCallback(IDiagDtcInfoCallback iDiagDtcInfoCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDiagDtcInfoCallback != null ? iDiagDtcInfoCallback.asBinder() : null);
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDiagDtcCallback(iDiagDtcInfoCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDiagDtcCallback(IDiagDtcInfoCallback iDiagDtcInfoCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDiagDtcInfoCallback != null ? iDiagDtcInfoCallback.asBinder() : null);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDiagDtcCallback(iDiagDtcInfoCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerMotorDteValueCallback(IMotorDteValueCallback iMotorDteValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMotorDteValueCallback != null ? iMotorDteValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(33, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerMotorDteValueCallback(iMotorDteValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterMotorDteValueCallback(IMotorDteValueCallback iMotorDteValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMotorDteValueCallback != null ? iMotorDteValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterMotorDteValueCallback(iMotorDteValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getMotorDteValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(35, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMotorDteValue();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setNaviCmd(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setNaviCmd(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setNaviInfoStatus(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setNaviInfoStatus(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setDmsUserSwitch(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDmsUserSwitch(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerFaceIdReq(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(39, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerFaceIdReq(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void loginFaceIdReq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(40, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().loginFaceIdReq(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void deleteFaceIdReq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(41, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().deleteFaceIdReq(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void healthMonitorReq(int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.mRemote.transact(42, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().healthMonitorReq(i, i2, i3, i4, i5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void driverMonitorReq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(43, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().driverMonitorReq(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void omsMonitoringReq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(44, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().omsMonitoringReq(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void healthLoginReq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(45, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().healthLoginReq(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void chimeTest() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(46, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().chimeTest();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void updatePhoneCallInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(47, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updatePhoneCallInfo(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void updateMediaInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(48, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateMediaInfo(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void updateFuelUnit(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(49, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateFuelUnit(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void updateCompassInfo(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    if (!this.mRemote.transact(50, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateCompassInfo(f);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void updateTimeFormat(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(51, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateTimeFormat(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void updateRearViewKeyStatus(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(52, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateRearViewKeyStatus(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void bootAnimationCompleted() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(53, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().bootAnimationCompleted();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setActivationLicense(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(54, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setActivationLicense(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setCCOFanStatus(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(55, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setCCOFanStatus(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getGaugeFuelPercent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(56, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGaugeFuelPercent();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getDteValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(57, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDteValue();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getDriveMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(58, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDriveMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getXModeDisplayStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(59, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getXModeDisplayStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getCCODisplayStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(60, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCCODisplayStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setDmsDriverActionLevel(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(61, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDmsDriverActionLevel(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setDmsDriverDistractionLevel(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(62, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDmsDriverDistractionLevel(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setDmsDriverDrowsinessLevel(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(63, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDmsDriverDrowsinessLevel(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void appBootCompleted(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(64, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appBootCompleted(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void getNaviProjectionStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(65, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getNaviProjectionStatus();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setApaViewStatus(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(66, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setApaViewStatus(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setAvmViewStatus(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(67, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAvmViewStatus(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setStrReadStatus(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(68, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setStrReadStatus(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setStrWriteStatus(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(69, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setStrWriteStatus(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setCarPlateNumber(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(70, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setCarPlateNumber(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void sendPitchAngleToMcu(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(71, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendPitchAngleToMcu(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void sendPitchAngleToCluster(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    if (!this.mRemote.transact(72, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendPitchAngleToCluster(f, f2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setTotalMileage(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(73, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setTotalMileage(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setDayNightMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(74, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDayNightMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setNaviStartupStatus(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(75, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setNaviStartupStatus(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setSunTime(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(76, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSunTime(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getLFTyreTemperature() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(77, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLFTyreTemperature();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getRFTyreTemperature() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(78, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRFTyreTemperature();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getLRTyreTemperature() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(79, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLRTyreTemperature();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getRRTyreTemperature() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(80, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRRTyreTemperature();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerTyreTemperatureCallback(ITyreTemperatureCallback iTyreTemperatureCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTyreTemperatureCallback != null ? iTyreTemperatureCallback.asBinder() : null);
                    if (!this.mRemote.transact(81, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerTyreTemperatureCallback(iTyreTemperatureCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterTyreTemperatureCallback(ITyreTemperatureCallback iTyreTemperatureCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTyreTemperatureCallback != null ? iTyreTemperatureCallback.asBinder() : null);
                    if (!this.mRemote.transact(82, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterTyreTemperatureCallback(iTyreTemperatureCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerKeytoneCallback(IClusterNotifyKeytoneCallback iClusterNotifyKeytoneCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterNotifyKeytoneCallback != null ? iClusterNotifyKeytoneCallback.asBinder() : null);
                    if (!this.mRemote.transact(83, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerKeytoneCallback(iClusterNotifyKeytoneCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterKeytoneCallback(IClusterNotifyKeytoneCallback iClusterNotifyKeytoneCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterNotifyKeytoneCallback != null ? iClusterNotifyKeytoneCallback.asBinder() : null);
                    if (!this.mRemote.transact(84, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterKeytoneCallback(iClusterNotifyKeytoneCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerLeftSideWarningCallback(IClusterLeftWarningCallback iClusterLeftWarningCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterLeftWarningCallback != null ? iClusterLeftWarningCallback.asBinder() : null);
                    if (!this.mRemote.transact(85, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerLeftSideWarningCallback(iClusterLeftWarningCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterLeftSideWarningCallback(IClusterLeftWarningCallback iClusterLeftWarningCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterLeftWarningCallback != null ? iClusterLeftWarningCallback.asBinder() : null);
                    if (!this.mRemote.transact(86, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterLeftSideWarningCallback(iClusterLeftWarningCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerGaugeSpeedCallback(IGaugeSpeedValueCallback iGaugeSpeedValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iGaugeSpeedValueCallback != null ? iGaugeSpeedValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(87, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerGaugeSpeedCallback(iGaugeSpeedValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterGaugeSpeedCallback(IGaugeSpeedValueCallback iGaugeSpeedValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iGaugeSpeedValueCallback != null ? iGaugeSpeedValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(88, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterGaugeSpeedCallback(iGaugeSpeedValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvmLogDataCallback(IAvmLogDataCallback iAvmLogDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvmLogDataCallback != null ? iAvmLogDataCallback.asBinder() : null);
                    if (!this.mRemote.transact(89, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvmLogDataCallback(iAvmLogDataCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvmLogDataCallback(IAvmLogDataCallback iAvmLogDataCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvmLogDataCallback != null ? iAvmLogDataCallback.asBinder() : null);
                    if (!this.mRemote.transact(90, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvmLogDataCallback(iAvmLogDataCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback iBootMusicPlayStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBootMusicPlayStatusCallback != null ? iBootMusicPlayStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(91, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerBootMusicPlayStatusCallback(iBootMusicPlayStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterBootMusicPlayStatusCallback(IBootMusicPlayStatusCallback iBootMusicPlayStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBootMusicPlayStatusCallback != null ? iBootMusicPlayStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(92, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterBootMusicPlayStatusCallback(iBootMusicPlayStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerNaviProjectionStatusCallback(INaviProjectionStatusCallback iNaviProjectionStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNaviProjectionStatusCallback != null ? iNaviProjectionStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(93, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerNaviProjectionStatusCallback(iNaviProjectionStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterNaviProjectionStatusCallback(INaviProjectionStatusCallback iNaviProjectionStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNaviProjectionStatusCallback != null ? iNaviProjectionStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(94, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterNaviProjectionStatusCallback(iNaviProjectionStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvmCameraStatusCallback(IAvmCameraStatusCallback iAvmCameraStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvmCameraStatusCallback != null ? iAvmCameraStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(95, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvmCameraStatusCallback(iAvmCameraStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvmCameraStatusCallback(IAvmCameraStatusCallback iAvmCameraStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvmCameraStatusCallback != null ? iAvmCameraStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(96, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvmCameraStatusCallback(iAvmCameraStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerCltcOrWltcCallback(ICltcOrWltcCallback iCltcOrWltcCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCltcOrWltcCallback != null ? iCltcOrWltcCallback.asBinder() : null);
                    if (!this.mRemote.transact(97, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCltcOrWltcCallback(iCltcOrWltcCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterCltcOrWltcCallback(ICltcOrWltcCallback iCltcOrWltcCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCltcOrWltcCallback != null ? iCltcOrWltcCallback.asBinder() : null);
                    if (!this.mRemote.transact(98, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCltcOrWltcCallback(iCltcOrWltcCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getCltcOrWltcMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(99, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCltcOrWltcMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setCltcOrWltcMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(100, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setCltcOrWltcMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setLaneAssistSetting(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(101, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setLaneAssistSetting(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public float getCurrentSpeed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(102, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentSpeed();
                    }
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setDriveMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(103, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDriveMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void getDmsCameraStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(104, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getDmsCameraStatus();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void requestAvmStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(105, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestAvmStatus();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public boolean getAvmStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(106, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAvmStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getFrontTorqueLockStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(107, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFrontTorqueLockStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getRearTorqueLockStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(108, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRearTorqueLockStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerChargeViewStatus(IChargeViewStatusCallback iChargeViewStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargeViewStatusCallback != null ? iChargeViewStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(109, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerChargeViewStatus(iChargeViewStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterChargeViewStatus(IChargeViewStatusCallback iChargeViewStatusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargeViewStatusCallback != null ? iChargeViewStatusCallback.asBinder() : null);
                    if (!this.mRemote.transact(110, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterChargeViewStatus(iChargeViewStatusCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setScheduleChargingTime(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(111, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setScheduleChargingTime(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerVehicleFaultInfoChange(IVehicleFaultInfo iVehicleFaultInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iVehicleFaultInfo != null ? iVehicleFaultInfo.asBinder() : null);
                    if (!this.mRemote.transact(112, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerVehicleFaultInfoChange(iVehicleFaultInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterVehicleFaultInfoChange(IVehicleFaultInfo iVehicleFaultInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iVehicleFaultInfo != null ? iVehicleFaultInfo.asBinder() : null);
                    if (!this.mRemote.transact(113, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterVehicleFaultInfoChange(iVehicleFaultInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setFatigueDriveTime(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(114, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setFatigueDriveTime(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setWarningSpeed(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(115, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setWarningSpeed(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void getVehicleFaultInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(116, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getVehicleFaultInfo();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void requestFactoryReset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(117, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestFactoryReset();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void notifyFactoryReset(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(118, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyFactoryReset(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setWarningVolumeLevel(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(119, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setWarningVolumeLevel(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerChargingPowerCallback(IChargePowerCallback iChargePowerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargePowerCallback != null ? iChargePowerCallback.asBinder() : null);
                    if (!this.mRemote.transact(120, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerChargingPowerCallback(iChargePowerCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterChargingPowerCallback(IChargePowerCallback iChargePowerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargePowerCallback != null ? iChargePowerCallback.asBinder() : null);
                    if (!this.mRemote.transact(121, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterChargingPowerCallback(iChargePowerCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerChargingCurrentCallback(IChargeCurrentCallback iChargeCurrentCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargeCurrentCallback != null ? iChargeCurrentCallback.asBinder() : null);
                    if (!this.mRemote.transact(122, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerChargingCurrentCallback(iChargeCurrentCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterChargingCurrentCallback(IChargeCurrentCallback iChargeCurrentCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargeCurrentCallback != null ? iChargeCurrentCallback.asBinder() : null);
                    if (!this.mRemote.transact(123, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterChargingCurrentCallback(iChargeCurrentCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerChargingVoltageCallback(IChargeVoltageCallback iChargeVoltageCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargeVoltageCallback != null ? iChargeVoltageCallback.asBinder() : null);
                    if (!this.mRemote.transact(124, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerChargingVoltageCallback(iChargeVoltageCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterChargingVoltageCallback(IChargeVoltageCallback iChargeVoltageCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargeVoltageCallback != null ? iChargeVoltageCallback.asBinder() : null);
                    if (!this.mRemote.transact(125, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterChargingVoltageCallback(iChargeVoltageCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerChargingInfoCallback(IChargePowerInfoCallback iChargePowerInfoCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargePowerInfoCallback != null ? iChargePowerInfoCallback.asBinder() : null);
                    if (!this.mRemote.transact(126, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerChargingInfoCallback(iChargePowerInfoCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterChargingInfoCallback(IChargePowerInfoCallback iChargePowerInfoCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iChargePowerInfoCallback != null ? iChargePowerInfoCallback.asBinder() : null);
                    if (!this.mRemote.transact(127, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterChargingInfoCallback(iChargePowerInfoCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public float[] getChargingInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(128, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getChargingInfo();
                    }
                    obtain2.readException();
                    return obtain2.createFloatArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback iEnergyCurveProjectionCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEnergyCurveProjectionCallback != null ? iEnergyCurveProjectionCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerEnergyCurveProjectionCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerEnergyCurveProjectionCallback(iEnergyCurveProjectionCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterEnergyCurveProjectionCallback(IEnergyCurveProjectionCallback iEnergyCurveProjectionCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEnergyCurveProjectionCallback != null ? iEnergyCurveProjectionCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterEnergyCurveProjectionCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterEnergyCurveProjectionCallback(iEnergyCurveProjectionCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getEnergyCurveProjectionStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getEnergyCurveProjectionStatus, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEnergyCurveProjectionStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvgElecCallback(IAvgElecCallback iAvgElecCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgElecCallback != null ? iAvgElecCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerAvgElecCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvgElecCallback(iAvgElecCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvgElecCallback(IAvgElecCallback iAvgElecCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgElecCallback != null ? iAvgElecCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterAvgElecCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvgElecCallback(iAvgElecCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvgFuCallback(IAvgFuCallback iAvgFuCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgFuCallback != null ? iAvgFuCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerAvgFuCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvgFuCallback(iAvgFuCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvgFuCallback(IAvgFuCallback iAvgFuCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgFuCallback != null ? iAvgFuCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterAvgFuCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvgFuCallback(iAvgFuCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvgFuCnsCallback(IAvgFuCnsCallback iAvgFuCnsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgFuCnsCallback != null ? iAvgFuCnsCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerAvgFuCnsCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvgFuCnsCallback(iAvgFuCnsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvgFuCnsCallback(IAvgFuCnsCallback iAvgFuCnsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgFuCnsCallback != null ? iAvgFuCnsCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterAvgFuCnsCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvgFuCnsCallback(iAvgFuCnsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvgElecCnsCallback(IAvgElecCnsCallback iAvgElecCnsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgElecCnsCallback != null ? iAvgElecCnsCallback.asBinder() : null);
                    if (!this.mRemote.transact(138, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvgElecCnsCallback(iAvgElecCnsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvgElecCnsCallback(IAvgElecCnsCallback iAvgElecCnsCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgElecCnsCallback != null ? iAvgElecCnsCallback.asBinder() : null);
                    if (!this.mRemote.transact(139, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvgElecCnsCallback(iAvgElecCnsCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAFCCallback(IAFCValueCallback iAFCValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAFCValueCallback != null ? iAFCValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(140, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAFCCallback(iAFCValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAFCCallback(IAFCValueCallback iAFCValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAFCValueCallback != null ? iAFCValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(141, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAFCCallback(iAFCValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getAFCValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getAFCValue, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAFCValue();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAFCPHKMCallback(IAFCPHKMValueCallback iAFCPHKMValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAFCPHKMValueCallback != null ? iAFCPHKMValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerAFCPHKMCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAFCPHKMCallback(iAFCPHKMValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAFCPHKMCallback(IAFCPHKMValueCallback iAFCPHKMValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAFCPHKMValueCallback != null ? iAFCPHKMValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(144, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAFCPHKMCallback(iAFCPHKMValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getAFCPHKMValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(145, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAFCPHKMValue();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDriveTimeCallback(IDriveTimeCallback iDriveTimeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDriveTimeCallback != null ? iDriveTimeCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerDriveTimeCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDriveTimeCallback(iDriveTimeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDriveTimeCallback(IDriveTimeCallback iDriveTimeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDriveTimeCallback != null ? iDriveTimeCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterDriveTimeCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDriveTimeCallback(iDriveTimeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getDriveTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getDriveTime, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDriveTime();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerAvgSpdCallback(IAvgSpdValueCallback iAvgSpdValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgSpdValueCallback != null ? iAvgSpdValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerAvgSpdCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAvgSpdCallback(iAvgSpdValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterAvgSpdCallback(IAvgSpdValueCallback iAvgSpdValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAvgSpdValueCallback != null ? iAvgSpdValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterAvgSpdCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAvgSpdCallback(iAvgSpdValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getAvgSpd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getAvgSpd, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAvgSpd();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerIFECallback(IIFECallback iIFECallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iIFECallback != null ? iIFECallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerIFECallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerIFECallback(iIFECallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterIFECallback(IIFECallback iIFECallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iIFECallback != null ? iIFECallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterIFECallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterIFECallback(iIFECallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getIFEValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getIFEValue, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIFEValue();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerMainTankResistanceCallback(IMainTankResistanceCallback iMainTankResistanceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMainTankResistanceCallback != null ? iMainTankResistanceCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerMainTankResistanceCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerMainTankResistanceCallback(iMainTankResistanceCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterMainTankResistanceCallback(IMainTankResistanceCallback iMainTankResistanceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMainTankResistanceCallback != null ? iMainTankResistanceCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterMainTankResistanceCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterMainTankResistanceCallback(iMainTankResistanceCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getMainTankResistance() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getMainTankResistance, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMainTankResistance();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerSubTankResistanceCallback(ISubTankResistanceCallback iSubTankResistanceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSubTankResistanceCallback != null ? iSubTankResistanceCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerSubTankResistanceCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerSubTankResistanceCallback(iSubTankResistanceCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterSubTankResistanceCallback(ISubTankResistanceCallback iSubTankResistanceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSubTankResistanceCallback != null ? iSubTankResistanceCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterSubTankResistanceCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterSubTankResistanceCallback(iSubTankResistanceCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getSubTankResistance() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getSubTankResistance, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSubTankResistance();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void notifyClusterLanguageSetting(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_notifyClusterLanguageSetting, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyClusterLanguageSetting(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setAirPressure(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setAirPressure, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAirPressure(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setAltitude(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setAltitude, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAltitude(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDoorOpenCallback(IDoorOpenCallback iDoorOpenCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDoorOpenCallback != null ? iDoorOpenCallback.asBinder() : null);
                    if (!this.mRemote.transact(164, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDoorOpenCallback(iDoorOpenCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDoorOpenCallback(IDoorOpenCallback iDoorOpenCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDoorOpenCallback != null ? iDoorOpenCallback.asBinder() : null);
                    if (!this.mRemote.transact(165, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDoorOpenCallback(iDoorOpenCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setXModeStatus(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setXModeStatus, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setXModeStatus(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getTimeFormat() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getTimeFormat, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTimeFormat();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerTimeFormatChangedCallback(ITimeFormatChangedCallback iTimeFormatChangedCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTimeFormatChangedCallback != null ? iTimeFormatChangedCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerTimeFormatChangedCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerTimeFormatChangedCallback(iTimeFormatChangedCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterTimeFormatChangedCallback(ITimeFormatChangedCallback iTimeFormatChangedCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTimeFormatChangedCallback != null ? iTimeFormatChangedCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterTimeFormatChangedCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterTimeFormatChangedCallback(iTimeFormatChangedCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void notifyAVMWindowsStatus(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_notifyAVMWindowsStatus, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyAVMWindowsStatus(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setTyrePressureUnit(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setTyrePressureUnit, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setTyrePressureUnit(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setSpeedUnit(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setSpeedUnit, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSpeedUnit(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setTemperatureUnit(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setTemperatureUnit, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setTemperatureUnit(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getTyrePressureUnit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getTyrePressureUnit, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTyrePressureUnit();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getSpeedUnit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getSpeedUnit, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSpeedUnit();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getTemperatureUnit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getTemperatureUnit, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTemperatureUnit();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setCarModelColor(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setCarModelColor, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setCarModelColor(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void resetMaintenanceMileage() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_resetMaintenanceMileage, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resetMaintenanceMileage();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback iPayloadMaintanceDistanceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPayloadMaintanceDistanceCallback != null ? iPayloadMaintanceDistanceCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerPayloadMaintanceDistanceCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerPayloadMaintanceDistanceCallback(iPayloadMaintanceDistanceCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterPayloadMaintanceDistanceCallback(IPayloadMaintanceDistanceCallback iPayloadMaintanceDistanceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPayloadMaintanceDistanceCallback != null ? iPayloadMaintanceDistanceCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterPayloadMaintanceDistanceCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterPayloadMaintanceDistanceCallback(iPayloadMaintanceDistanceCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getPayloadMaintanceDistance() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getPayloadMaintanceDistance, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPayloadMaintanceDistance();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setThemeMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(Stub.TRANSACTION_setThemeMode, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setThemeMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback iFuelVolumeDisplayCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelVolumeDisplayCallback != null ? iFuelVolumeDisplayCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerFuelVolumeDisplayCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerFuelVolumeDisplayCallback(iFuelVolumeDisplayCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterFuelVolumeDisplayCallback(IFuelVolumeDisplayCallback iFuelVolumeDisplayCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelVolumeDisplayCallback != null ? iFuelVolumeDisplayCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterFuelVolumeDisplayCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterFuelVolumeDisplayCallback(iFuelVolumeDisplayCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public float getFuelVolumeDisplay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getFuelVolumeDisplay, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFuelVolumeDisplay();
                    }
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerFuelVolumeSampleCallback(IFuelVolumeSampleCallback iFuelVolumeSampleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelVolumeSampleCallback != null ? iFuelVolumeSampleCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerFuelVolumeSampleCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerFuelVolumeSampleCallback(iFuelVolumeSampleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterFuelVolumeSampleCallback(IFuelVolumeSampleCallback iFuelVolumeSampleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelVolumeSampleCallback != null ? iFuelVolumeSampleCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterFuelVolumeSampleCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterFuelVolumeSampleCallback(iFuelVolumeSampleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public float getFuelVolumeSample() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getFuelVolumeSample, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFuelVolumeSample();
                    }
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDteCalculateValueCallback(IDteCalculateValueCallback iDteCalculateValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDteCalculateValueCallback != null ? iDteCalculateValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerDteCalculateValueCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDteCalculateValueCallback(iDteCalculateValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDteCalculateValueCallback(IDteCalculateValueCallback iDteCalculateValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDteCalculateValueCallback != null ? iDteCalculateValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterDteCalculateValueCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDteCalculateValueCallback(iDteCalculateValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getDteCalculateValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getDteCalculateValue, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDteCalculateValue();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerDteAFCValueCallback(IDteAFCValueCallback iDteAFCValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDteAFCValueCallback != null ? iDteAFCValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerDteAFCValueCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerDteAFCValueCallback(iDteAFCValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterDteAFCValueCallback(IDteAFCValueCallback iDteAFCValueCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDteAFCValueCallback != null ? iDteAFCValueCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterDteAFCValueCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDteAFCValueCallback(iDteAFCValueCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public float getDteAFCValue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getDteAFCValue, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDteAFCValue();
                    }
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerFuelTankTypeCallback(IFuelTankTypeCallback iFuelTankTypeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelTankTypeCallback != null ? iFuelTankTypeCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerFuelTankTypeCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerFuelTankTypeCallback(iFuelTankTypeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterFuelTankTypeCallback(IFuelTankTypeCallback iFuelTankTypeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelTankTypeCallback != null ? iFuelTankTypeCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterFuelTankTypeCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterFuelTankTypeCallback(iFuelTankTypeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getFuelTankType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(Stub.TRANSACTION_getFuelTankType, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFuelTankType();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerOverFillStateCallback(IOverFillStateCallback iOverFillStateCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOverFillStateCallback != null ? iOverFillStateCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_registerOverFillStateCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerOverFillStateCallback(iOverFillStateCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterOverFillStateCallback(IOverFillStateCallback iOverFillStateCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOverFillStateCallback != null ? iOverFillStateCallback.asBinder() : null);
                    if (!this.mRemote.transact(Stub.TRANSACTION_unregisterOverFillStateCallback, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterOverFillStateCallback(iOverFillStateCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getOverFillState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(200, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOverFillState();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerFuelAddEventCallback(IFuelAddEventCallback iFuelAddEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelAddEventCallback != null ? iFuelAddEventCallback.asBinder() : null);
                    if (!this.mRemote.transact(201, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerFuelAddEventCallback(iFuelAddEventCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterFuelAddEventCallback(IFuelAddEventCallback iFuelAddEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFuelAddEventCallback != null ? iFuelAddEventCallback.asBinder() : null);
                    if (!this.mRemote.transact(202, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterFuelAddEventCallback(iFuelAddEventCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getFuelAddEvent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(203, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFuelAddEvent();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setThemeToCluster(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(204, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setThemeToCluster(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getClusterTheme() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(205, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getClusterTheme();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerClusterThemeCallback(IClusterThemeCallback iClusterThemeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterThemeCallback != null ? iClusterThemeCallback.asBinder() : null);
                    if (!this.mRemote.transact(206, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerClusterThemeCallback(iClusterThemeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterClusterThemeCallback(IClusterThemeCallback iClusterThemeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterThemeCallback != null ? iClusterThemeCallback.asBinder() : null);
                    if (!this.mRemote.transact(207, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterClusterThemeCallback(iClusterThemeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getFatigueDriveTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(208, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFatigueDriveTime();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getWarningSpeed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(209, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWarningSpeed();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getWarningVolumeLevel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(210, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWarningVolumeLevel();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void systemReset(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(211, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().systemReset(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback iThemeSwitchCompleteCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThemeSwitchCompleteCallback != null ? iThemeSwitchCompleteCallback.asBinder() : null);
                    if (!this.mRemote.transact(212, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerClusterSwitchThemeCompleteCallback(iThemeSwitchCompleteCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterClusterSwitchThemeCompleteCallback(IThemeSwitchCompleteCallback iThemeSwitchCompleteCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThemeSwitchCompleteCallback != null ? iThemeSwitchCompleteCallback.asBinder() : null);
                    if (!this.mRemote.transact(213, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterClusterSwitchThemeCompleteCallback(iThemeSwitchCompleteCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void setClusterFont(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(214, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setClusterFont(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public int getClusterFont() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(215, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getClusterFont();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void registerClusterFontCallback(IClusterFontCallback iClusterFontCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterFontCallback != null ? iClusterFontCallback.asBinder() : null);
                    if (!this.mRemote.transact(216, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerClusterFontCallback(iClusterFontCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void unregisterClusterFontCallback(IClusterFontCallback iClusterFontCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iClusterFontCallback != null ? iClusterFontCallback.asBinder() : null);
                    if (!this.mRemote.transact(217, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterClusterFontCallback(iClusterFontCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterInteraction
            public void notifyClusterWallpaperChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(218, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyClusterWallpaperChanged(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IClusterInteraction iClusterInteraction) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iClusterInteraction == null) {
                return false;
            }
            Proxy.sDefaultImpl = iClusterInteraction;
            return true;
        }

        public static IClusterInteraction getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
