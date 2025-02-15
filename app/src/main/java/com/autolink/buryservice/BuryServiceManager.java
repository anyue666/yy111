package com.autolink.buryservice;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.buryservice.IBuryService;
import com.autolink.buryservice.bury.bean.CarUpdateBean;
import com.autolink.buryservice.bury.bean.HealthResultBean;
import com.autolink.buryservice.bury.bean.LocationGPSBean;
import com.autolink.buryservice.bury.bean.SystemSettingsBean;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class BuryServiceManager {
    private static final String TAG = "BuryServiceManager";
    private static BuryServiceManager sInstance;
    private IBuryService mService;
    private final Object mLock = new Object();
    private final ServiceDeathRecipient mServiceDeathRecipient = new ServiceDeathRecipient();

    private BuryServiceManager() {
        getService();
    }

    public static synchronized BuryServiceManager getInstance() {
        BuryServiceManager buryServiceManager;
        synchronized (BuryServiceManager.class) {
            if (sInstance == null) {
                sInstance = new BuryServiceManager();
            }
            buryServiceManager = sInstance;
        }
        return buryServiceManager;
    }

    public void appListCommonBury(String str, String str2, int i, String str3) {
        Log.d(TAG, "appListCommonBury packageName = " + str3 + ", event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().appListCommonBury(str, str2, i, str3);
            } catch (Exception e) {
                Log.e(TAG, "appListCommonBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListCommonBury end");
        }
    }

    public void panoramicImage540Bury(String str, String str2, int i) {
        Log.d(TAG, "panoramicImage540Bury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().panoramicImage540Bury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "panoramicImage540Bury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "panoramicImage540Bury end");
        }
    }

    public void appListIntelligentSceneBury(String str, String str2, int i) {
        Log.d(TAG, "appListIntelligentSceneBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().appListIntelligentSceneBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "appListIntelligentSceneBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListIntelligentSceneBury end");
        }
    }

    public void bTPhoneBury(String str, String str2, int i) {
        Log.d(TAG, "bTPhoneBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().bTPhoneBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "bTPhoneBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "bTPhoneBury end");
        }
    }

    public void vehicleSettingsBury1(String str, String str2, int i) {
        Log.d(TAG, "vehicleSettingsBury1 event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().vehicleSettingsBury1(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "vehicleSettingsBury1 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "vehicleSettingsBury1 end");
        }
    }

    public void vehicleSettingsBury2(String str, String str2, String str3) {
        Log.d(TAG, "vehicleSettingsBury2 event = " + str + ", key = " + str2 + ", value = " + str3);
        try {
            try {
                getService().vehicleSettingsBury2(str, str2, str3);
            } catch (Exception e) {
                Log.e(TAG, "vehicleSettingsBury2 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "vehicleSettingsBury2 end");
        }
    }

    public void vehicleSettingsBury3(String str, String str2, int i, String str3, int i2) {
        Log.d(TAG, "vehicleSettingsBury3 event = " + str + ", key1 = " + str2 + ", value1 = " + i + ", key2 = " + str3 + ", value2 = " + i2);
        try {
            try {
                getService().vehicleSettingsBury3(str, str2, i, str3, i2);
            } catch (Exception e) {
                Log.e(TAG, "vehicleSettingsBury3 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "vehicleSettingsBury3 end");
        }
    }

    public void vehicleSettingsBury4(SystemSettingsBean systemSettingsBean) {
        Log.d(TAG, "vehicleSettingsBury4 systemSettings = " + systemSettingsBean);
        try {
            try {
                getService().vehicleSettingsBury4(systemSettingsBean);
            } catch (Exception e) {
                Log.e(TAG, "vehicleSettingsBury4 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "vehicleSettingsBury4 end");
        }
    }

    public void appListOMSBury(String str, String str2, int i) {
        Log.d(TAG, "appListOMSBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().appListOMSBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "appListOMSBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListOMSBury end");
        }
    }

    public void errorEscalationBury(String str, String str2, int i) {
        Log.d(TAG, "errorEscalationBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().errorEscalationBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "errorEscalationBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "errorEscalationBury end");
        }
    }

    public void appListUserCenterBury1(String str, String str2, int i) {
        Log.d(TAG, "appListUserCenterBury1 event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().appListUserCenterBury1(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "appListUserCenterBury1 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListUserCenterBury1 end");
        }
    }

    public void appListUserCenterBury2(String str, String str2, int i, String str3, int i2) {
        Log.d(TAG, "appListUserCenterBury2 event = " + str + ", key1 = " + str2 + ", value1 = " + i + ", key2 = " + str3 + ", value2 = " + i2);
        try {
            try {
                getService().appListUserCenterBury2(str, str2, i, str3, i2);
            } catch (Exception e) {
                Log.e(TAG, "appListUserCenterBury2 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListUserCenterBury2 end");
        }
    }

    public void appListUserCenterBury3(String str, String str2, int i, String str3, int i2, String str4, String str5) {
        Log.d(TAG, "appListUserCenterBury3 event = " + str + ", key1 = " + str2 + ", value1 = " + i + ", key2 = " + str3 + ", value2 = " + i2 + ", key3 = " + str4 + ", value3 = " + str5);
        try {
            try {
                getService().appListUserCenterBury3(str, str2, i, str3, i2, str4, str5);
            } catch (Exception e) {
                Log.e(TAG, "appListUserCenterBury3 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListUserCenterBury3 end");
        }
    }

    public void appListACSettupBury1(String str, String str2, int i) {
        Log.d(TAG, "appListACSettupBury1 event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().appListACSettupBury1(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "appListACSettupBury1 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListACSettupBury1 end");
        }
    }

    public void appListACSettupBury2(String str, String str2, float f) {
        Log.d(TAG, "appListACSettupBury2 event = " + str + ", key = " + str2 + ", value = " + f);
        try {
            try {
                getService().appListACSettupBury2(str, str2, f);
            } catch (Exception e) {
                Log.e(TAG, "appListACSettupBury2 Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListACSettupBury2 end");
        }
    }

    public void appListEcallBury(String str, String str2, int i) {
        Log.d(TAG, "appListEcallBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().appListEcallBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "appListEcallBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListEcallBury end");
        }
    }

    public void appListBcallBury(String str, String str2, int i) {
        Log.d(TAG, "appListBcallBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().appListBcallBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "appListBcallBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListBcallBury end");
        }
    }

    public void appListCarUpdateBury(CarUpdateBean carUpdateBean) {
        Log.d(TAG, "appListBcallBury carUpdate = " + carUpdateBean);
        try {
            try {
                getService().appListCarUpdateBury(carUpdateBean);
            } catch (Exception e) {
                Log.e(TAG, "appListCarUpdateBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListCarUpdateBury end");
        }
    }

    public void panoramicImageDVRBury(String str, String str2, int i) {
        Log.d(TAG, "panoramicImageDVRBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().panoramicImageDVRBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "panoramicImageDVRBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "panoramicImageDVRBury end");
        }
    }

    public void appListHealthBury(HealthResultBean healthResultBean) {
        Log.d(TAG, "appListHealthBury healthResult = " + healthResultBean);
        try {
            try {
                getService().appListHealthBury(healthResultBean);
            } catch (Exception e) {
                Log.e(TAG, "appListHealthBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListHealthBury end");
        }
    }

    public void appListXmodeBury(String str, String str2, String str3) {
        Log.d(TAG, "appListXmodeBury event = " + str + ", key = " + str2 + ", value = " + str3);
        try {
            try {
                getService().appListXmodeBury(str, str2, str3);
            } catch (Exception e) {
                Log.e(TAG, "appListXmodeBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "appListXmodeBury end");
        }
    }

    public void launcherDropdownBury(String str, String str2, int i) {
        Log.d(TAG, "launcherDropdownBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().launcherDropdownBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "launcherDropdownBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "launcherDropdownBury end");
        }
    }

    public void launcherCardBarBury(String str, String str2, int i) {
        Log.d(TAG, "launcherCardBarBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().launcherCardBarBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "launcherCardBarBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "launcherCardBarBury end");
        }
    }

    public void launcherDockBury(String str, String str2, int i) {
        Log.d(TAG, "launcherDockBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().launcherDockBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "launcherDockBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "launcherDockBury end");
        }
    }

    public void locationGpsBury(LocationGPSBean locationGPSBean) {
        Log.d(TAG, "locationGpsBury locationGPSBean = " + locationGPSBean);
        try {
            try {
                getService().locationGpsBury(locationGPSBean);
            } catch (Exception e) {
                Log.e(TAG, "locationGpsBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "locationGpsBury end");
        }
    }

    public void wheelBury(String str, String str2, int i) {
        Log.d(TAG, "wheelBury event = " + str + ", key = " + str2 + ", value = " + i);
        try {
            try {
                getService().wheelBury(str, str2, i);
            } catch (Exception e) {
                Log.e(TAG, "wheelBury Exception e = " + e);
            }
        } finally {
            Log.d(TAG, "wheelBury end");
        }
    }

    private IBuryService getService() {
        Log.d(TAG, "getService");
        IBuryService iBuryService = this.mService;
        if (iBuryService != null) {
            return iBuryService;
        }
        synchronized (this.mLock) {
            try {
                try {
                    try {
                        IBuryService asInterface = IBuryService.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "bury_service"));
                        this.mService = asInterface;
                        if (asInterface == null) {
                            Log.e(TAG, "getService no bury service");
                            return null;
                        }
                    } catch (IllegalAccessException e) {
                        Log.e(TAG, "getService IllegalAccessException = " + e);
                    } catch (NoSuchMethodException e2) {
                        Log.e(TAG, "getService NoSuchMethodException = " + e2);
                    }
                } catch (ClassNotFoundException e3) {
                    Log.e(TAG, "getService ClassNotFoundException = " + e3);
                } catch (InvocationTargetException e4) {
                    Log.e(TAG, "getService InvocationTargetException = " + e4);
                }
                linkToDeath(this.mService, this.mServiceDeathRecipient);
                return this.mService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void linkToDeath(IBuryService iBuryService, IBinder.DeathRecipient deathRecipient) {
        Log.i(TAG, "linkToDeath");
        try {
            iBuryService.asBinder().linkToDeath(deathRecipient, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    private class ServiceDeathRecipient implements IBinder.DeathRecipient {
        private ServiceDeathRecipient() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            BuryServiceManager.this.mService.asBinder().unlinkToDeath(this, 0);
            BuryServiceManager.this.mService = null;
            BuryServiceManager.this.tryGetService();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryGetService() {
        while (this.mService == null) {
            try {
                Thread.sleep(60L);
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                Log.d(TAG, "tryGetService finally end");
                throw th;
            }
            Log.d(TAG, "tryGetService finally end");
            getService();
        }
    }
}
