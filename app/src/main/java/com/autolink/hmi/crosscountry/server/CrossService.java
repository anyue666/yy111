package com.autolink.hmi.crosscountry.server;

import android.app.Service;
import android.car.Car;
import android.car.hardware.power.CarPowerManager;
import android.car.hardware.property.CarPropertyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.autolink.account.ui.dialog.DrivingModeDialog;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.ALManagerFactory;
import com.autolink.adaptermanager.IALManager;
import com.autolink.adaptermanager.car.ALVehicleControlProperty;
import com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager;
import com.autolink.buryservice.bury.consts.BuryKeyConst;
import com.autolink.car.client.CarSettingManager;
import com.autolink.carsetting.data.car.CarContact;
import com.autolink.hmi.crosscountry.CrossApplication;
import com.autolink.hmi.crosscountry.stub.ICrossStub;
import com.autolink.hmi.crosscountry.utils.BuryServiceUtils;
import com.autolink.hmi.crosscountry.utils.CarSettingController;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.CompletableFuture;

/* loaded from: classes.dex */
public class CrossService extends Service implements ServiceConnection {
    private static final String TAG = "CrossService";
    private CarPropertyManager carPropertyManager;
    private DrivingModeDialog drivingModeDialog;
    ALClusterInteractionManager mAlClusterInteractionManager;
    private ICrossStub mICrossStub;
    private SharedPreferences ps;
    private Handler handler = new Handler();
    private CrossServiceHandler mCrossServiceHandler = new CrossServiceHandler(this);
    private float mLastState = -1.0f;
    private float mCurrentState = -1.0f;
    private Car mCar = null;
    boolean mStatus = false;
    boolean mPowerStatus = false;
    private CarPowerManager mCarPowerManager = null;
    int code = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void modifiedState() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mICrossStub;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.ps = getSharedPreferences("CrossServiceSP", 0);
        this.mICrossStub = new ICrossStub();
        super.onCreate();
        ALManagerFactory.getInstance(CrossApplication.sInstance).getManager(ALManagerFactory.CI_SERVICE, new IALManager.ServiceConnectionListenerNew() { // from class: com.autolink.hmi.crosscountry.server.CrossService.1
            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListenerNew
            public void onServiceDisconnected() {
            }

            @Override // com.autolink.adaptermanager.IALManager.ServiceConnectionListenerNew
            public void onServiceConnected(ALBaseManager aLBaseManager) {
                CrossService.this.mAlClusterInteractionManager = (ALClusterInteractionManager) aLBaseManager;
            }
        });
        setChangeListener();
        initSTR();
        initCarSettingListener();
    }

    private void initSTR() {
        new Thread(new Runnable() { // from class: com.autolink.hmi.crosscountry.server.CrossService.2
            @Override // java.lang.Runnable
            public void run() {
                CrossService crossService = CrossService.this;
                crossService.mCar = Car.createCar(crossService.getApplicationContext(), CrossService.this);
                CrossService.this.mCar.connect();
            }
        }).start();
    }

    private void initCarSettingListener() {
        CarSettingController.getInstance().setResultCallback(new CarSettingManager.ResultCallback() { // from class: com.autolink.hmi.crosscountry.server.CrossService.3
            @Override // com.autolink.car.client.CarSettingManager.ResultCallback
            public void onResult(String str, String str2) {
                if (str == null || str2 == null) {
                    return;
                }
                LogUtils.logI(CrossService.TAG, "initCarSettingListener onResult() key = " + str + " , value = " + str2 + " , mAlClusterInteractionManager = " + CrossService.this.mAlClusterInteractionManager);
                if (str.equals(String.valueOf(ALVehicleControlProperty.VEHICLE_PROPERTY_VC_COOL))) {
                    if (str2.equals(CarContact.Status.COMMON_ON)) {
                        if (CrossService.this.mAlClusterInteractionManager != null) {
                            CrossService.this.mAlClusterInteractionManager.setCCOFanStatus(true);
                        }
                    } else {
                        if (!str2.equals(CarContact.Status.COMMON_OFF) || CrossService.this.mAlClusterInteractionManager == null) {
                            return;
                        }
                        CrossService.this.mAlClusterInteractionManager.setCCOFanStatus(false);
                    }
                }
            }
        });
    }

    public void addHandle(String str) {
        this.mCrossServiceHandler.removeMessages(1);
        Message message = new Message();
        message.what = 1;
        message.obj = str;
        this.mCrossServiceHandler.sendMessageDelayed(message, 100L);
    }

    public void test01() {
        new Thread(new Runnable() { // from class: com.autolink.hmi.crosscountry.server.CrossService.4
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000L);
                        CrossService.this.code++;
                        int random = (int) ((Math.random() * 6.0d) + 1.0d);
                        if (random == 1) {
                            CrossService.this.mICrossStub.drivingModeListener.onDriverModeChanged(ALClusterInteractionManager.DriverModeType.DRIVER_MODE_ECO);
                        }
                        if (random == 2) {
                            CrossService.this.mICrossStub.drivingModeListener.onDriverModeChanged(ALClusterInteractionManager.DriverModeType.DRIVER_MODE_ROCK);
                        }
                        if (random == 3) {
                            CrossService.this.mICrossStub.drivingModeListener.onDriverModeChanged(ALClusterInteractionManager.DriverModeType.DRIVER_MODE_INVALD);
                        }
                        if (random == 4) {
                            CrossService.this.mICrossStub.drivingModeListener.onDriverModeChanged(ALClusterInteractionManager.DriverModeType.DRIVER_MODE_NORMAL);
                        }
                        if (random == 5) {
                            CrossService.this.mICrossStub.drivingModeListener.onDriverModeChanged(ALClusterInteractionManager.DriverModeType.DRIVER_MODE_SAND);
                        }
                        if (random == 6) {
                            CrossService.this.mICrossStub.drivingModeListener.onDriverModeChanged(ALClusterInteractionManager.DriverModeType.DRIVER_MODE_SPORT);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    public void test02() {
        new Thread(new Runnable() { // from class: com.autolink.hmi.crosscountry.server.CrossService.5
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000L);
                        CrossService.this.code++;
                        CrossService.this.mICrossStub.xModeListener.onXModeDisplayStatusChanged(ALClusterInteractionManager.XModeDisplayStatus.ON);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(final String str) {
        LogUtils.logI(TAG, "mode is " + str + " Power mode  new 3/2  mLastState" + this.mLastState + " mCurrentState " + this.mCurrentState);
        this.handler.post(new Runnable() { // from class: com.autolink.hmi.crosscountry.server.CrossService.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LogUtils.logI(CrossService.TAG, " profile is : " + str);
                    String str2 = str;
                    if (str2 != null && str2.equals("-1")) {
                        LogUtils.logI(CrossService.TAG, "showDialog profile is -1 ");
                        return;
                    }
                    if ((CrossService.this.mLastState == 0.0d && CrossService.this.mCurrentState == 1.0d) || ((CrossService.this.mLastState == 1.0d && CrossService.this.mCurrentState == 2.0d) || ((CrossService.this.mLastState == 2.0d && CrossService.this.mCurrentState == 3.0d) || ((CrossService.this.mLastState == 3.0d && CrossService.this.mCurrentState == 2.0d) || ((CrossService.this.mLastState == 2.0d && CrossService.this.mCurrentState == 1.0d) || (CrossService.this.mLastState == 1.0d && CrossService.this.mCurrentState == 0.0d)))))) {
                        LogUtils.logI(CrossService.TAG, "  showDialog new 3/2   D3->D2 || D3->D1    ");
                        CrossService.this.mLastState = -1.0f;
                        CrossService.this.mCurrentState = -1.0f;
                        return;
                    }
                    LogUtils.logI(CrossService.TAG, "DrivingModeDialog at Thread name " + Thread.currentThread().getName());
                    BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_drivemode, "" + str);
                    if (CrossService.this.drivingModeDialog != null) {
                        LogUtils.logI("新模式", "new mode  " + Integer.parseInt(str));
                        CrossService.this.drivingModeDialog.removeCountdown();
                        CrossService.this.drivingModeDialog.setMode(Integer.parseInt(str));
                        CrossService.this.drivingModeDialog.updateView();
                        return;
                    }
                    CrossService.this.drivingModeDialog = new DrivingModeDialog(CrossService.this.getApplicationContext());
                    CrossService.this.drivingModeDialog.setDismissListener(new DrivingModeDialog.DismissListener() { // from class: com.autolink.hmi.crosscountry.server.CrossService.6.1
                        @Override // com.autolink.account.ui.dialog.DrivingModeDialog.DismissListener
                        public void onDismiss() {
                            CrossService.this.drivingModeDialog = null;
                        }
                    });
                    String str3 = str;
                    if (str3 == null || str3.equals("")) {
                        return;
                    }
                    LogUtils.logI("新模式", "new mode  " + Integer.parseInt(str));
                    CrossService.this.drivingModeDialog.setMode(Integer.parseInt(str));
                    CrossService.this.drivingModeDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setChangeListener() {
        ICrossStub iCrossStub = this.mICrossStub;
        if (iCrossStub != null) {
            iCrossStub.setPatternChangeListener(new ICrossStub.IPatternChangeListener() { // from class: com.autolink.hmi.crosscountry.server.CrossService.7
                @Override // com.autolink.hmi.crosscountry.stub.ICrossStub.IPatternChangeListener
                public void onCallback(String str) {
                    CrossService.this.addHandle(str);
                }

                @Override // com.autolink.hmi.crosscountry.stub.ICrossStub.IPatternChangeListener
                public void onPowerCondition(float f) {
                    LogUtils.logI(CrossService.TAG, "onPowerCondition status " + f);
                    CrossService crossService = CrossService.this;
                    crossService.mLastState = crossService.mCurrentState;
                    CrossService.this.mCurrentState = f;
                    CrossService.this.mPowerStatus = true;
                    CrossService.this.modifiedState();
                }
            });
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        LogUtils.logI(TAG, " STR onServiceConnected");
        Car car = this.mCar;
        if (car != null) {
            this.carPropertyManager = (CarPropertyManager) car.getCarManager(Car.PROPERTY_SERVICE);
            CarPowerManager carPowerManager = (CarPowerManager) this.mCar.getCarManager("power");
            this.mCarPowerManager = carPowerManager;
            if (carPowerManager != null) {
                LogUtils.logI(TAG, " STR mCarPowerManager setListenerWithCompletion");
                this.mCarPowerManager.setListenerWithCompletion(new CarPowerManager.CarPowerStateListenerWithCompletion() { // from class: com.autolink.hmi.crosscountry.server.CrossService.8
                    @Override // android.car.hardware.power.CarPowerManager.CarPowerStateListenerWithCompletion
                    public void onStateChanged(int i, CompletableFuture<Void> completableFuture) {
                        LogUtils.logI(CrossService.TAG, " STR onStateChanged status " + i);
                        if (i == 2) {
                            LogUtils.logI(CrossService.TAG, " STR MODE SUSPEND_ENTER ");
                            if (CrossService.this.drivingModeDialog != null) {
                                LogUtils.logI(CrossService.TAG, "SUSPEND_ENTER STR to release drivingModeDialog ");
                                CrossService.this.drivingModeDialog.dismiss();
                            } else {
                                LogUtils.logI(CrossService.TAG, "SUSPEND_ENTER STR No need to release");
                            }
                        }
                        if (i == 3) {
                            LogUtils.logI(CrossService.TAG, "STR SUSPEND_EXIT");
                            CrossService.this.mStatus = true;
                        }
                    }
                });
                return;
            } else {
                LogUtils.logI(TAG, "mCarPowerManager is null");
                return;
            }
        }
        LogUtils.logI(TAG, "mCar is null");
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        LogUtils.logI(TAG, "STR onServiceDisconnected");
    }

    private static class CrossServiceHandler extends Handler {
        private WeakReference<CrossService> reference;

        CrossServiceHandler(CrossService crossService) {
            this.reference = new WeakReference<>(crossService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                if (this.reference.get() != null) {
                    this.reference.get().showDialog((String) message.obj);
                }
            } else if (i == 2 && this.reference.get() != null) {
                LogUtils.logI(CrossService.TAG, " Power caused changes, reset status");
                this.reference.get().mPowerStatus = false;
            }
        }
    }
}
