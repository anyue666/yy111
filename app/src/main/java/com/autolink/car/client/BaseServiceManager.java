package com.autolink.car.client;

import android.car.Car;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
abstract class BaseServiceManager {
    private String mAction;
    private String mAppPackage;
    protected Context mContext;
    private PackageReceiver mReceiver;
    private String mServicePath;
    public final String TAG = "BaseServiceManager";
    private final int MSG_REBIND = 1001;
    private final long DELAY_MILLIS = 5000;
    private Intent mIntent = null;
    private boolean mIsIServiceProfileConnect = false;
    private final HandlerThread mHandlerThread = new HandlerThread("ServiceManage");
    private Handler mBindHandler = null;
    private int mMaxNumber = 100;
    private int mConnectNumber = 0;
    private final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.autolink.car.client.BaseServiceManager.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("BaseServiceManager", "connection success CarSettings...");
            BaseServiceManager.this.mIsIServiceProfileConnect = true;
            BaseServiceManager.this.mConnectNumber = 0;
            if (BaseServiceManager.this.mBindHandler != null) {
                BaseServiceManager.this.mBindHandler.removeCallbacksAndMessages(null);
            }
            BaseServiceManager.this.onConnectedSuccess(componentName, iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            BaseServiceManager.this.mIsIServiceProfileConnect = false;
            BaseServiceManager.this.onDisConnected(componentName);
            BaseServiceManager.this.reBind();
        }
    };

    abstract void create();

    abstract void onConnectedSuccess(ComponentName componentName, IBinder iBinder);

    abstract void onDisConnected(ComponentName componentName);

    BaseServiceManager() {
    }

    static /* synthetic */ int access$008(BaseServiceManager baseServiceManager) {
        int i = baseServiceManager.mConnectNumber;
        baseServiceManager.mConnectNumber = i + 1;
        return i;
    }

    public void initData(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mAppPackage = str;
        this.mAction = str2;
        this.mServicePath = str3;
        registerPackageReceiver();
        initIntent();
    }

    private void initHandler() {
        this.mBindHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.autolink.car.client.BaseServiceManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1001) {
                    BaseServiceManager.access$008(BaseServiceManager.this);
                    Log.i("BaseServiceManager", "rebind service mConnectNumber = " + BaseServiceManager.this.mConnectNumber);
                    if (BaseServiceManager.this.mConnectNumber <= BaseServiceManager.this.mMaxNumber) {
                        BaseServiceManager.this.bindService();
                    }
                }
            }
        };
    }

    private void initIntent() {
        Intent intent = new Intent();
        this.mIntent = intent;
        intent.setComponent(new ComponentName(this.mAppPackage, this.mServicePath));
        this.mIntent.setAction(this.mAction);
    }

    public boolean bindService() {
        if (this.mContext == null) {
            Log.e("BaseServiceManager", "bind fail context is null");
            return false;
        }
        try {
            if (!this.mHandlerThread.isAlive()) {
                Log.e("BaseServiceManager", "HandlerThread not isAlive");
                this.mHandlerThread.start();
            }
            if (this.mContext.getPackageManager().getPackageInfo(this.mAppPackage, 0) == null) {
                return false;
            }
            boolean bindService = this.mContext.bindService(this.mIntent, this.mServiceConnection, 1);
            if (!bindService) {
                reBind();
            }
            return bindService;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("BaseServiceManager", "package name not found exception");
            reBind();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reBind() {
        if (this.mBindHandler == null) {
            initHandler();
        }
        this.mIsIServiceProfileConnect = false;
        Handler handler = this.mBindHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1001, 5000L);
        }
    }

    private void registerPackageReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(Car.PACKAGE_SERVICE);
        this.mContext.registerReceiver(this.mReceiver, intentFilter);
    }

    public void release() {
        Context context = this.mContext;
        if (context != null) {
            PackageReceiver packageReceiver = this.mReceiver;
            if (packageReceiver != null) {
                context.unregisterReceiver(packageReceiver);
            }
            this.mContext.unbindService(this.mServiceConnection);
            this.mContext = null;
        }
    }

    class PackageReceiver extends BroadcastReceiver {
        PackageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (schemeSpecificPart.equals(BaseServiceManager.this.mAppPackage)) {
                    Log.i("BaseServiceManager", "PackageReceiver 应用程序已安装");
                    if (BaseServiceManager.this.mIsIServiceProfileConnect) {
                        return;
                    }
                    BaseServiceManager.this.mConnectNumber = 0;
                    BaseServiceManager.this.reBind();
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.PACKAGE_REMOVED") && schemeSpecificPart.equals(BaseServiceManager.this.mAppPackage)) {
                BaseServiceManager baseServiceManager = BaseServiceManager.this;
                baseServiceManager.mConnectNumber = baseServiceManager.mMaxNumber;
                Log.i("BaseServiceManager", "PackageReceiver 应用程序卸载了");
            }
        }
    }
}
