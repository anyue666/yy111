package com.autolink.hmi.crosscountry.stub;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.autolink.adapterinterface.car.ALCarPropertyEvent;
import com.autolink.adaptermanager.IALManager;
import com.autolink.adaptermanager.car.ALCarManager;
import com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager;
import com.autolink.adaptermanager.misc.ALMiscManager;
import com.autolink.hmi.crosscountry.ICrossCallback;
import com.autolink.hmi.crosscountry.ICrossService;
import com.autolink.hmi.crosscountry.crossmanager.CrossAlManager;
import com.autolink.hmi.crosscountry.utils.CrossAllUtils;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class ICrossStub extends ICrossService.Stub {
    private static final int ANGLE_INCLINATION = 12;
    private static final int ATTRIBUTE_CONSTANT_DIFFERENTIAL_LOCK = 0;
    private static final int ATTRIBUTE_CONSTANT_DRIVING_MODE = 2;
    private static final int ATTRIBUTE_CONSTANT_TIRE_TEMPERATURE_PRESSURE = 3;
    private static final int ATTRIBUTE_CONSTANT_WADING_DEPTH = 1;
    private static final int ATTRIBUTE_CONSTANT_X_MODE = 4;
    private static final int FETAL_SWERVE = 10;
    private static final int FETAL_TEMPERATURE = 9;
    public static final int FETAL_TEMPERATURE_LF = 5;
    public static final int FETAL_TEMPERATURE_LR = 6;
    public static final int FETAL_TEMPERATURE_RF = 7;
    public static final int FETAL_TEMPERATURE_RR = 8;
    private static final int ROLL_ANGLE = 13;
    private static final int STS_STATUS = 14;
    private static final String TAG = "ICrossStub";
    private static final int TIRE_ALARM = 11;
    public IPatternChangeListener mPatternChangeListener;
    private Lock mLock = new ReentrantLock();
    private final RemoteCallbackList<ICrossCallback> clients = new RemoteCallbackList<>();
    ALCarManager.CarSteerListener carSteerListener = new ALCarManager.CarSteerListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.2
        @Override // com.autolink.adaptermanager.car.ALCarManager.CarSteerListener
        public void onCarSteerChanged(float f) {
            LogUtils.logI(ICrossStub.TAG, "CarSteerListener  is " + f);
            ICrossStub.this.noteClients(10, f + "", null);
        }
    };
    public ALClusterInteractionManager.ALDriverModeListener drivingModeListener = new ALClusterInteractionManager.ALDriverModeListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.3
        @Override // com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.ALDriverModeListener
        public void onDriverModeChanged(ALClusterInteractionManager.DriverModeType driverModeType) {
            LogUtils.logI("onDriverModeChanged ", " ALClusterInteractionManager driverModeType " + driverModeType);
            if (driverModeType != null) {
                if (driverModeType.getNumber() != 255) {
                    ICrossStub.this.noteClients(2, driverModeType.getNumber() + "", null);
                    if (ICrossStub.this.mPatternChangeListener != null) {
                        ICrossStub.this.mPatternChangeListener.onCallback(driverModeType.getNumber() + "");
                        return;
                    }
                    return;
                }
                LogUtils.logI("onDriverModeChanged ", " DriverModeType getNumber is 255");
                return;
            }
            LogUtils.logI("onDriverModeChanged", " DriverModeType is null ");
        }
    };
    public ALClusterInteractionManager.ALXModeDisplayStatusListener xModeListener = new ALClusterInteractionManager.ALXModeDisplayStatusListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.4
        @Override // com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.ALXModeDisplayStatusListener
        public void onXModeDisplayStatusChanged(ALClusterInteractionManager.XModeDisplayStatus xModeDisplayStatus) {
            LogUtils.logI("onXModeDisplayStatusChanged", "xModeListener getNumber " + xModeDisplayStatus.getNumber());
            ICrossStub.this.noteClients(4, xModeDisplayStatus.getNumber() + "", null);
            if (ICrossStub.this.mPatternChangeListener != null) {
                if (xModeDisplayStatus.getNumber() != 1) {
                    ICrossStub.this.mPatternChangeListener.onCallback(ICrossStub.this.mCrossAlManager.getDriveMode() + "");
                } else {
                    ICrossStub.this.mPatternChangeListener.onCallback(CrossAllUtils.DRIVER_MODE_X + "");
                }
            }
        }
    };
    ALCarManager.CarTyreListener carTyreListener = new ALCarManager.CarTyreListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.5
        @Override // com.autolink.adaptermanager.car.ALCarManager.CarTyreListener
        public void onTyreFloatDataChanged(int i, float f) {
        }

        @Override // com.autolink.adaptermanager.car.ALCarManager.CarTyreListener
        public void onTyreDataChanged(int i, int i2) {
            LogUtils.logI(ICrossStub.TAG, "carTyreListener i " + i + "i1 " + i2);
            ICrossStub.this.noteClients(11, i + "", i2 + "");
        }
    };
    ALClusterInteractionManager.ALTyreTemperatureListener tyreTempListener = new ALClusterInteractionManager.ALTyreTemperatureListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.6
        @Override // com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.ALTyreTemperatureListener
        public void onLFTyreTempChanged(int i) {
            LogUtils.logI(ICrossStub.TAG, "onLFTyreTempChanged " + i);
            ICrossStub.this.noteClients(9, "5", i + "");
        }

        @Override // com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.ALTyreTemperatureListener
        public void onRFTyreTempChanged(int i) {
            LogUtils.logI(ICrossStub.TAG, "onRFTyreTempChanged " + i);
            ICrossStub.this.noteClients(9, "7", i + "");
        }

        @Override // com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.ALTyreTemperatureListener
        public void onLRTyreTempChanged(int i) {
            LogUtils.logI(ICrossStub.TAG, "onLRTyreTempChanged " + i);
            ICrossStub.this.noteClients(9, "6", i + "");
        }

        @Override // com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.ALTyreTemperatureListener
        public void onRRTyreTempChanged(int i) {
            LogUtils.logI(ICrossStub.TAG, "onRRTyreTempChanged " + i);
            ICrossStub.this.noteClients(9, "8", i + "");
        }
    };
    ALCarManager.IALCmdListener listener = new ALCarManager.IALCmdListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.7
        @Override // com.autolink.adaptermanager.car.ALCarManager.IALCmdListener
        public void onCmdChanged(byte b, byte b2, short s, int i) {
            LogUtils.logI("onCmdChanged", "i " + ((int) s));
            if (s == 607) {
                ICrossStub.this.noteClients(1, i + "", null);
            }
            if (s == 650) {
                ICrossStub.this.noteClients(14, i + "", null);
            }
        }
    };
    ALClusterInteractionManager.ALTorqueLockStatusListener aLTorqueLockListener = new ALClusterInteractionManager.ALTorqueLockStatusListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.8
        @Override // com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager.ALTorqueLockStatusListener
        public void onTorqueLockStatusChanged(ALClusterInteractionManager.TorqueLockStatus torqueLockStatus) {
            LogUtils.logI(ICrossStub.TAG, "onTorqueLockStatusChanged = " + torqueLockStatus.getNumber() + "");
            ICrossStub.this.noteClients(0, torqueLockStatus.getNumber() + "", null);
        }
    };
    ALCarManager.IALCarAllTypesVehicleControlPropListener ialCarAllTypesVehicleControlPropListener = new ALCarManager.IALCarAllTypesVehicleControlPropListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.9
        @Override // com.autolink.adaptermanager.car.ALCarManager.IALCarAllTypesVehicleControlPropListener
        public void onALCarVehicleControlPropChanged(ALCarPropertyEvent aLCarPropertyEvent) {
            LogUtils.logI(ICrossStub.TAG, "onALCarVehicleControlPropChanged = id " + aLCarPropertyEvent.getId() + " value " + aLCarPropertyEvent.getValue());
            float parseFloat = Float.parseFloat(aLCarPropertyEvent.getValue() + "");
            ICrossStub.this.noteClients(3, aLCarPropertyEvent.getId() + "", parseFloat + "");
            if (ICrossStub.this.mPatternChangeListener == null || aLCarPropertyEvent.getId() != 650) {
                return;
            }
            ICrossStub.this.mPatternChangeListener.onPowerCondition(parseFloat);
        }
    };
    ALMiscManager.ALPitchRollAngleListener angleListener = new ALMiscManager.ALPitchRollAngleListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.10
        @Override // com.autolink.adaptermanager.misc.ALMiscManager.ALPitchRollAngleListener
        public void onPitchRollAngleChanged(float f, float f2) {
            LogUtils.logI(ICrossStub.TAG, "ROLL_ANGLE = " + f + "");
            ICrossStub.this.noteClients(13, f + "", null);
            CrossAllUtils.LAST_ROLL_ANGEL = f + "";
            LogUtils.logI(ICrossStub.TAG, "ANGLE_INCLINATION = " + f2 + "");
            ICrossStub.this.noteClients(12, f2 + "", null);
            CrossAllUtils.LAST_ANGLE_INCLINATION = f2 + "";
        }
    };
    private CrossAlManager mCrossAlManager = CrossAlManager.getInstance(new IALManager.ServiceConnectionListener() { // from class: com.autolink.hmi.crosscountry.stub.ICrossStub.1
        @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
        public void onServiceConnected() {
            if (ICrossStub.this.mCrossAlManager.isConnected()) {
                LogUtils.logI(ICrossStub.TAG, "ICrossStub Start registering the listening callback");
                ICrossStub.this.signInCallback();
                LogUtils.logI(ICrossStub.TAG, "ICrossStub End of registration");
            } else {
                try {
                    LogUtils.logI(ICrossStub.TAG, "mCrossAlManager service is null");
                    Thread.sleep(300L);
                    ICrossStub.this.signInCallback();
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListener
        public void onServiceDisconnected() {
            LogUtils.logI(ICrossStub.TAG, "ICrossStub  onServiceDisconnected");
        }
    });

    public interface IPatternChangeListener {
        void onCallback(String str);

        void onPowerCondition(float f);
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public void callServer(String str) throws RemoteException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signInCallback() {
        LogUtils.logI(TAG, "signInCallback");
        monitorDifferentialLock();
        monitorWadingDepth();
        monitorDrivingMode();
        monitorTireTemperaturePressure();
        monitorXModeDisplayStatus();
        registerFetalTemperatureStatus();
        registerCarSteerListener();
        registerCarTyreListener();
        LogUtils.logI(TAG, "ICrossStub End of signInCallback");
        monitorCarBodyCondition();
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public void register(ICrossCallback iCrossCallback) throws RemoteException {
        if (iCrossCallback != null) {
            this.clients.register(iCrossCallback);
        }
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public void unregister(ICrossCallback iCrossCallback) throws RemoteException {
        if (iCrossCallback != null) {
            this.clients.unregister(iCrossCallback);
        }
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int getFetalTemperature(int i) throws RemoteException {
        int lFTyreTemperature = i == 5 ? this.mCrossAlManager.getLFTyreTemperature() : -1;
        if (i == 6) {
            lFTyreTemperature = this.mCrossAlManager.getLRTyreTemperature();
        }
        if (i == 7) {
            lFTyreTemperature = this.mCrossAlManager.getRFTyreTemperature();
        }
        return i == 8 ? this.mCrossAlManager.getRRTyreTemperature() : lFTyreTemperature;
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int getXModeDisplayStatus() throws RemoteException {
        return this.mCrossAlManager.getXModeDisplayStatus();
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int getVehicleAVMProp(int i) throws RemoteException {
        return this.mCrossAlManager.getVehicleAVMProp(i);
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int getFrontTorqueLockStatus() throws RemoteException {
        return this.mCrossAlManager.getFrontTorqueLockStatus();
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int getRearTorqueLockStatus() throws RemoteException {
        return this.mCrossAlManager.getRearTorqueLockStatus();
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int canGetVehicleParam(int i) throws RemoteException {
        LogUtils.logI("canGetVehicleParam", "propertyId " + i);
        return this.mCrossAlManager.canGetVehicleParam(i);
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int canSetVehicleParam(int i, int i2) throws RemoteException {
        LogUtils.logI("canSetVehicleParam", "propertyId " + i + " value " + i2);
        return this.mCrossAlManager.canSetVehicleParam(i, i2);
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public float getFloatVehicleControlProp(int i) throws RemoteException {
        LogUtils.logI("getFloatVehicleControlProp", "propertyId " + i);
        return this.mCrossAlManager.getFloatVehicleControlProp(i);
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public float getFloatVehicleAVMProp(int i) throws RemoteException {
        LogUtils.logI("getFloatVehicleControlProp", "propertyId " + i);
        return this.mCrossAlManager.getFloatVehicleAVMProp(i);
    }

    @Override // com.autolink.hmi.crosscountry.ICrossService
    public int getDriveMode() {
        CrossAlManager crossAlManager = this.mCrossAlManager;
        if (crossAlManager != null) {
            int driveMode = crossAlManager.getDriveMode();
            LogUtils.logI("getDriveMode", "mode is " + driveMode);
            return driveMode;
        }
        LogUtils.logI(TAG, "getDriveMode  is null");
        return -1;
    }

    private void monitorDifferentialLock() {
        LogUtils.logI(TAG, "registration  monitorDifferentialLock");
        this.mCrossAlManager.registerTorqueLockListener(this.aLTorqueLockListener);
    }

    private void monitorDrivingMode() {
        LogUtils.logI(TAG, "registration  monitorDrivingMode");
        this.mCrossAlManager.registerDrivingModeListener(this.drivingModeListener);
    }

    private void monitorCarBodyCondition() {
        LogUtils.logI(TAG, "registration  monitorXModeDisplayStatus");
        this.mCrossAlManager.registerCarBodyCondition(this.angleListener);
    }

    private void monitorXModeDisplayStatus() {
        LogUtils.logI(TAG, "registration  monitorXModeDisplayStatus");
        this.mCrossAlManager.registerXModeDisplayStatus(this.xModeListener);
    }

    private void registerCarSteerListener() {
        LogUtils.logI(TAG, "registration  registerCarSteerListener");
        this.mCrossAlManager.registerCarSteerListener(this.carSteerListener);
    }

    private void registerFetalTemperatureStatus() {
        LogUtils.logI(TAG, "registration  registerFetalTemperatureStatus");
        this.mCrossAlManager.registerFetalTemperatureStatus(this.tyreTempListener);
    }

    private void registerCarTyreListener() {
        LogUtils.logI(TAG, "registration  registerCarTyreListener");
        this.mCrossAlManager.registerCarTyreListener(this.carTyreListener);
    }

    private void monitorTireTemperaturePressure() {
        LogUtils.logI(TAG, "registration  monitorTireTemperaturePressure");
        this.mCrossAlManager.registerTireTemperaturePressure(this.ialCarAllTypesVehicleControlPropListener);
    }

    private void monitorWadingDepth() {
        this.mCrossAlManager.registerCMDListener(this.listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noteClients(int i, String str, String str2) {
        try {
            try {
                this.mLock.lock();
                int beginBroadcast = this.clients.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    if (i == 0) {
                        this.clients.getBroadcastItem(i2).onDifferentialLock(str);
                    }
                    if (i == 1) {
                        this.clients.getBroadcastItem(i2).onWadingDepth(str);
                    }
                    if (i == 2) {
                        this.clients.getBroadcastItem(i2).onDrivingMode(str);
                    }
                    if (i == 3) {
                        this.clients.getBroadcastItem(i2).onSignalState(str, str2);
                    }
                    if (i == 4) {
                        this.clients.getBroadcastItem(i2).onXSteerMode(str);
                    }
                    if (i == 9) {
                        this.clients.getBroadcastItem(i2).onFetalTemperature(str, str2);
                    }
                    if (i == 10) {
                        this.clients.getBroadcastItem(i2).onCarSteerListener(str);
                    }
                    if (i == 11) {
                        this.clients.getBroadcastItem(i2).onCarTyreListener(str, str2);
                    }
                    if (i == 12) {
                        this.clients.getBroadcastItem(i2).onAngleInclination(str);
                    }
                    if (i == 13) {
                        this.clients.getBroadcastItem(i2).onRollAngle(str);
                    }
                    if (i == 14) {
                        this.clients.getBroadcastItem(i2).onSTSChange(str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.clients.finishBroadcast();
            this.mLock.unlock();
        }
    }

    public void setPatternChangeListener(IPatternChangeListener iPatternChangeListener) {
        this.mPatternChangeListener = iPatternChangeListener;
    }
}
