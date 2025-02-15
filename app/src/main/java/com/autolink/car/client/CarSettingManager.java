package com.autolink.car.client;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.service.carsettings.ALCarSetting;
import com.autolink.service.carsettings.OnCarSettingCall;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CarSettingManager extends BaseServiceManager {
    private static final String ACTION = "com.autolink.car.service";
    private static final String PACKAGE = "com.autolink.hmi.carsettings";
    private static final String SERVICE_PATH = "com.autolink.service.carsettings.CarSettingService";
    private static final String TAG = "CarSettingManager";
    private static final String VERSION_NAME = "1.1.7";
    private static volatile CarSettingManager instance = null;
    private static String packageName = "";
    private IConnectCallback mConnectCallback;
    private ALCarSetting mSettingCall;
    private final int MSG_REBIND = 1001;
    private final long DELAY_MILLIS = 3000;
    private boolean mIsIServiceProfileConnect = false;
    private final ArrayList<ResultCallback> registers = new ArrayList<>();

    public interface ResultCallback {
        void onResult(String str, String str2);
    }

    @Override // com.autolink.car.client.BaseServiceManager
    public /* bridge */ /* synthetic */ boolean bindService() {
        return super.bindService();
    }

    @Override // com.autolink.car.client.BaseServiceManager
    public /* bridge */ /* synthetic */ void initData(Context context, String str, String str2, String str3) {
        super.initData(context, str, str2, str3);
    }

    @Override // com.autolink.car.client.BaseServiceManager
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    @Override // com.autolink.car.client.BaseServiceManager
    void create() {
        if (this.mContext != null) {
            packageName = this.mContext.getPackageName();
        }
        Log.i(TAG, "create" + getInfoStr());
        initData(this.mContext, PACKAGE, ACTION, SERVICE_PATH);
    }

    private CarSettingManager() {
    }

    public static CarSettingManager getInstance() {
        if (instance == null) {
            synchronized (TAG) {
                if (instance == null) {
                    instance = new CarSettingManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        Log.i(TAG, "init(Context context)");
        this.mContext = context;
        create();
        bindService();
    }

    public void init(Context context, IConnectCallback iConnectCallback) {
        Log.i(TAG, "init context == null:" + (context == null) + " connectCallback == null:" + (iConnectCallback == null));
        this.mConnectCallback = iConnectCallback;
        this.mContext = context;
        create();
        bindService();
    }

    @Override // com.autolink.car.client.BaseServiceManager
    void onConnectedSuccess(ComponentName componentName, IBinder iBinder) {
        this.mSettingCall = ALCarSetting.Stub.asInterface(iBinder);
        Log.i(TAG, "onConnectedSuccess mSettingCall == null:" + (this.mSettingCall == null) + getInfoStr());
        Log.i(TAG, "onConnectedSuccess mConnectCallback == null:" + (this.mConnectCallback == null));
        ALCarSetting aLCarSetting = this.mSettingCall;
        if (aLCarSetting != null) {
            try {
                aLCarSetting.register(new OnCarSettingCall.Stub() { // from class: com.autolink.car.client.CarSettingManager.1
                    @Override // com.autolink.service.carsettings.OnCarSettingCall
                    public void onStateChange(String str, String str2) throws RemoteException {
                        Log.i(CarSettingManager.TAG, "onStateChange key:" + str + "value:" + str2 + CarSettingManager.this.getInfoStr());
                        Iterator it = CarSettingManager.this.registers.iterator();
                        while (it.hasNext()) {
                            ResultCallback resultCallback = (ResultCallback) it.next();
                            if (str != null && str2 != null) {
                                if (resultCallback == null) {
                                    Log.e(CarSettingManager.TAG, "onStateChange ResultCallback = null" + CarSettingManager.this.getInfoStr());
                                } else {
                                    resultCallback.onResult(str, str2);
                                }
                            }
                        }
                    }
                });
            } catch (RemoteException e) {
                Log.e(TAG, "CarSettingManager register error:" + e.getMessage());
            }
            IConnectCallback iConnectCallback = this.mConnectCallback;
            if (iConnectCallback != null) {
                iConnectCallback.onConnect(true);
            }
        }
    }

    @Override // com.autolink.car.client.BaseServiceManager
    void onDisConnected(ComponentName componentName) {
        Log.i(TAG, "onDisConnected conCallIsEmpty:" + (this.mConnectCallback == null) + getInfoStr());
        IConnectCallback iConnectCallback = this.mConnectCallback;
        if (iConnectCallback != null) {
            iConnectCallback.onConnect(false);
        }
    }

    public void set(String str, String str2) {
        Log.i(TAG, "set key:" + str + " value:" + str2 + " callIsEmpty:" + (this.mSettingCall == null) + getInfoStr());
        ALCarSetting aLCarSetting = this.mSettingCall;
        if (aLCarSetting != null) {
            try {
                aLCarSetting.set(str, str2);
            } catch (RemoteException e) {
                Log.i(TAG, "set error:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public String get(String str) {
        Log.i(TAG, "get key:" + str + " callIsEmpty:" + (this.mSettingCall == null) + getInfoStr());
        ALCarSetting aLCarSetting = this.mSettingCall;
        if (aLCarSetting == null) {
            return "";
        }
        try {
            return aLCarSetting.get(str);
        } catch (RemoteException e) {
            Log.i(TAG, "get error:" + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    public void register(ResultCallback resultCallback) {
        Log.i(TAG, "register size:" + this.registers.size() + getInfoStr());
        if (resultCallback == null) {
            Log.e(TAG, "register ResultCallback = null" + getInfoStr());
        } else {
            this.registers.add(resultCallback);
        }
    }

    public void unRegister(ResultCallback resultCallback) {
        Log.i(TAG, "unRegister size:" + this.registers.size() + getInfoStr());
        if (resultCallback == null) {
            Log.e(TAG, "unRegister ResultCallback = null" + getInfoStr());
        } else {
            this.registers.remove(resultCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getInfoStr() {
        return "  packageName:" + packageName + " VERSION_NAME:1.1.7";
    }
}
