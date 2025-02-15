package com.autolink.hmi.crosscountry.crossmanager;

import android.util.Log;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.ALManagerFactory;
import com.autolink.adaptermanager.IALManager;
import com.autolink.adaptermanager.car.ALCanPM25;
import com.autolink.adaptermanager.car.ALCanVehicleFrag;
import com.autolink.adaptermanager.car.ALCarManager;
import com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager;
import com.autolink.adaptermanager.misc.ALMiscManager;
import com.autolink.hmi.crosscountry.CrossApplication;
import com.autolink.hmi.crosscountry.utils.LogUtils;

/* loaded from: classes.dex */
public class CrossAlManager implements ALCarManager.IALAirPurgeListener {
    private static volatile CrossAlManager uniqueSingleton;
    String TAG = "CrossAlManager";
    ALCarManager mAlCarManager = ALCarManager.createCar(CrossApplication.sInstance);
    ALClusterInteractionManager mAlClusterInteractionManager;

    public interface InitialCompleteListener {
        void onComplete();
    }

    private CrossAlManager(IALManager.ServiceConnectionListener serviceConnectionListener) {
        LogUtils.logI("CrossAlManager", " mAlCarManager " + this.mAlCarManager);
        ALCarManager aLCarManager = this.mAlCarManager;
        if (aLCarManager != null) {
            aLCarManager.registIALAirPurgeListener(this);
        }
        this.mAlClusterInteractionManager = (ALClusterInteractionManager) ALManagerFactory.getInstance(CrossApplication.sInstance).getManager(ALManagerFactory.CI_SERVICE, serviceConnectionListener);
        LogUtils.logI("CrossAlManager", " mAlClusterInteractionManager " + this.mAlClusterInteractionManager);
    }

    public boolean isConnected() {
        ALCarManager aLCarManager = this.mAlCarManager;
        if (aLCarManager != null) {
            return aLCarManager.isConnected();
        }
        return true;
    }

    public int getLFTyreTemperature() {
        ALClusterInteractionManager aLClusterInteractionManager = this.mAlClusterInteractionManager;
        if (aLClusterInteractionManager != null) {
            int lFTyreTemperature = aLClusterInteractionManager.getLFTyreTemperature();
            LogUtils.logI("CrossAlManager", " getLFTyreTemperature value " + lFTyreTemperature);
            return lFTyreTemperature;
        }
        LogUtils.logI("CrossAlManager", " getLFTyreTemperature -1");
        return -1;
    }

    public int getLRTyreTemperature() {
        ALClusterInteractionManager aLClusterInteractionManager = this.mAlClusterInteractionManager;
        if (aLClusterInteractionManager != null) {
            return aLClusterInteractionManager.getLRTyreTemperature();
        }
        return -1;
    }

    public int getRFTyreTemperature() {
        ALClusterInteractionManager aLClusterInteractionManager = this.mAlClusterInteractionManager;
        if (aLClusterInteractionManager != null) {
            return aLClusterInteractionManager.getRFTyreTemperature();
        }
        return -1;
    }

    public int getRRTyreTemperature() {
        ALClusterInteractionManager aLClusterInteractionManager = this.mAlClusterInteractionManager;
        if (aLClusterInteractionManager != null) {
            return aLClusterInteractionManager.getRRTyreTemperature();
        }
        return -1;
    }

    public static CrossAlManager getInstance(IALManager.ServiceConnectionListener serviceConnectionListener) {
        if (uniqueSingleton == null) {
            synchronized (CrossAlManager.class) {
                if (uniqueSingleton == null) {
                    uniqueSingleton = new CrossAlManager(serviceConnectionListener);
                }
            }
        }
        return uniqueSingleton;
    }

    public void registerDrivingModeListener(ALClusterInteractionManager.ALDriverModeListener aLDriverModeListener) {
        if (this.mAlClusterInteractionManager != null) {
            LogUtils.logI("CrossAlManager ", "registerDrivingModeListener");
            this.mAlClusterInteractionManager.registerDriverModeListener(aLDriverModeListener);
        } else {
            LogUtils.logI("CrossAlManager ", "registerDriverModeListener is null");
        }
    }

    public void registerXModeDisplayStatus(ALClusterInteractionManager.ALXModeDisplayStatusListener aLXModeDisplayStatusListener) {
        if (this.mAlClusterInteractionManager != null) {
            LogUtils.logI("CrossAlManager ", "registerXModeDisplayStatus");
            this.mAlClusterInteractionManager.registerXModeStatusListener(aLXModeDisplayStatusListener);
        } else {
            LogUtils.logI("CrossAlManager ", "registerXModeDisplayStatus is null");
        }
    }

    public void registerCarBodyCondition(final ALMiscManager.ALPitchRollAngleListener aLPitchRollAngleListener) {
        LogUtils.logI("CrossAlManager ", "registerCarBodyCondition");
        ALMiscManager.createMisc(CrossApplication.sInstance, new IALManager.ServiceConnectionListenerNew() { // from class: com.autolink.hmi.crosscountry.crossmanager.CrossAlManager.1
            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListenerNew
            public void onServiceConnected(ALBaseManager aLBaseManager) {
                LogUtils.logI("CrossAlManager ", "registerCarBodyCondition onServiceConnected");
                ((ALMiscManager) aLBaseManager).registerPitchRollAngleCallback(aLPitchRollAngleListener);
            }

            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListenerNew
            public void onServiceDisconnected() {
                LogUtils.logI("CrossAlManager ", "registerCarBodyCondition onServiceDisconnected");
            }
        });
    }

    public void registerCarSteerListener(ALCarManager.CarSteerListener carSteerListener) {
        if (this.mAlCarManager != null) {
            LogUtils.logI("CrossAlManager ", "registerCarSteerListener");
            this.mAlCarManager.setCarSteerListener(carSteerListener);
        } else {
            LogUtils.logI("CrossAlManager ", "registerCarSteerListener is null");
        }
    }

    public void registerFetalTemperatureStatus(ALClusterInteractionManager.ALTyreTemperatureListener aLTyreTemperatureListener) {
        if (this.mAlClusterInteractionManager != null) {
            LogUtils.logI("CrossAlManager ", "registerFetalTemperatureStatus");
            this.mAlClusterInteractionManager.registerTyreTemperatureListeners(aLTyreTemperatureListener);
        } else {
            LogUtils.logI("CrossAlManager ", "registerFetalTemperatureStatus mAlClusterInteractionManager is null");
        }
    }

    public void registerCarTyreListener(ALCarManager.CarTyreListener carTyreListener) {
        if (this.mAlCarManager != null) {
            LogUtils.logI("CrossAlManager ", "registerCarTyreListener");
            this.mAlCarManager.setCarTyreListener(carTyreListener);
        } else {
            LogUtils.logI("CrossAlManager ", "registerCarTyreListener mAlCarManager is null");
        }
    }

    public int getXModeDisplayStatus() {
        ALClusterInteractionManager aLClusterInteractionManager = this.mAlClusterInteractionManager;
        if (aLClusterInteractionManager != null) {
            int xModeDisplayStatus = aLClusterInteractionManager.getXModeDisplayStatus();
            LogUtils.logI("CrossAlManager ", " getXModeDisplayStatus" + xModeDisplayStatus);
            return xModeDisplayStatus;
        }
        LogUtils.logI("CrossAlManager ", "getXModeDisplayStatus mAlClusterInteractionManager");
        return -1;
    }

    public int getDriveMode() {
        if (this.mAlClusterInteractionManager != null) {
            LogUtils.logI("CrossAlManager ", "getDriveMode");
            return this.mAlClusterInteractionManager.getDriveMode();
        }
        LogUtils.logI("CrossAlManager ", "getDriveMode  is null");
        return -1;
    }

    public void registerTorqueLockListener(ALClusterInteractionManager.ALTorqueLockStatusListener aLTorqueLockStatusListener) {
        if (this.mAlClusterInteractionManager != null) {
            LogUtils.logI(this.TAG, "registerTorqueLockListener");
            this.mAlClusterInteractionManager.registerTorqueLockStatusListener(aLTorqueLockStatusListener);
        } else {
            LogUtils.logI("CrossAlManager ", "registerTorqueLockStatusListener is null");
        }
    }

    public void registerTireTemperaturePressure(ALCarManager.IALCarAllTypesVehicleControlPropListener iALCarAllTypesVehicleControlPropListener) {
        if (this.mAlCarManager != null) {
            LogUtils.logI(this.TAG, "registerTireTemperaturePressure");
            this.mAlCarManager.setALCarAllTypesVehicleControlPropListener(iALCarAllTypesVehicleControlPropListener);
        } else {
            LogUtils.logI("CrossAlManager ", "setALCarAllTypesVehicleControlPropListener is null");
        }
    }

    public void registerCMDListener(ALCarManager.IALCmdListener iALCmdListener) {
        if (this.mAlCarManager != null) {
            LogUtils.logI("CMDListener ", " CrossAlManager registerCMDListener");
            this.mAlCarManager.registALCMDListener(24, iALCmdListener);
        } else {
            LogUtils.logI("CrossAlManager ", "registALCMDListener is null");
        }
    }

    public int canGetVehicleParam(int i) {
        ALCarManager aLCarManager = this.mAlCarManager;
        if (aLCarManager != null) {
            return aLCarManager.canGetVehicleParam(i);
        }
        return 0;
    }

    public int canSetVehicleParam(int i, int i2) {
        ALCarManager aLCarManager = this.mAlCarManager;
        if (aLCarManager != null) {
            return aLCarManager.canSetVehicleParam(i, i2);
        }
        return 0;
    }

    public float getFloatVehicleControlProp(int i) {
        ALCarManager aLCarManager = this.mAlCarManager;
        if (aLCarManager != null) {
            return aLCarManager.getFloatVehicleControlProp(i);
        }
        return 0.0f;
    }

    public float getFloatVehicleAVMProp(int i) {
        ALCarManager aLCarManager = this.mAlCarManager;
        if (aLCarManager != null) {
            return aLCarManager.getFloatVehicleAVMProp(i);
        }
        return 0.0f;
    }

    public int getFrontTorqueLockStatus() {
        ALClusterInteractionManager aLClusterInteractionManager = this.mAlClusterInteractionManager;
        if (aLClusterInteractionManager != null) {
            return aLClusterInteractionManager.getFrontTorqueLockStatus();
        }
        return -1;
    }

    public int getRearTorqueLockStatus() {
        ALClusterInteractionManager aLClusterInteractionManager = this.mAlClusterInteractionManager;
        if (aLClusterInteractionManager != null) {
            return aLClusterInteractionManager.getRearTorqueLockStatus();
        }
        return -1;
    }

    public int getVehicleAVMProp(int i) {
        ALCarManager aLCarManager = this.mAlCarManager;
        if (aLCarManager != null) {
            return aLCarManager.getVehicleAVMProp(i);
        }
        return 0;
    }

    @Override // com.autolink.adaptermanager.car.ALCarManager.IALAirPurgeListener
    public void onVehicleLFrag(ALCanVehicleFrag aLCanVehicleFrag) {
        Log.d(this.TAG, "onVehicleLFrag");
    }

    @Override // com.autolink.adaptermanager.car.ALCarManager.IALAirPurgeListener
    public void onPMChanged(ALCanPM25 aLCanPM25) {
        Log.d(this.TAG, "onPMChanged");
    }
}
