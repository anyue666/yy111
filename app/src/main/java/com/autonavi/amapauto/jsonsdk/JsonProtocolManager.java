package com.autonavi.amapauto.jsonsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.amapauto.a.a;
import com.autonavi.amapauto.a.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonProtocolManager {
    private static final String AIDL_BINDSERVICE_ACTION = "com.autonavi.amapauto.aidl.json_protocol_service";
    private static final String AIDL_BINDSERVICE_PACKAGENAME = "com.autonavi.amapauto";
    private static final String AIDL_BINDSERVICE_SERVICENAME = "com.autonavi.amapauto.protocol.service.JsonProtocolService";
    private static final String TAG = "JsonProtocolManager";
    private a iJsonProtocolInterface;
    private Context mContext;
    private IJsonProtocolReceive mJsonProtocolReceive;
    private String mServicePkgName;
    private String mWaitingProtocol;
    private String requestAuthor;
    private boolean isBind = false;
    private OnInitListener mOnInitListener = null;
    private IServiceConnectListener mServiceConnectListener = null;
    private final Object mLockInterface = new Object();
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.autonavi.amapauto.jsonsdk.JsonProtocolManager.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.i(JsonProtocolManager.TAG, "binderDied");
            if (JsonProtocolManager.this.mServiceConnectListener != null) {
                JsonProtocolManager.this.mServiceConnectListener.onServiceDied();
            }
            synchronized (JsonProtocolManager.this.mLockInterface) {
                if (JsonProtocolManager.this.iJsonProtocolInterface == null) {
                    JsonProtocolManager.this.bindService();
                    return;
                }
                JsonProtocolManager.this.iJsonProtocolInterface.asBinder().unlinkToDeath(JsonProtocolManager.this.mDeathRecipient, 0);
                JsonProtocolManager.this.iJsonProtocolInterface = null;
                JsonProtocolManager.this.bindService();
            }
        }
    };
    private ServiceConnection jsonServerConn = new ServiceConnection() { // from class: com.autonavi.amapauto.jsonsdk.JsonProtocolManager.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(JsonProtocolManager.TAG, "onServiceConnected isBinderAlive " + iBinder.isBinderAlive());
            try {
                synchronized (JsonProtocolManager.this.mLockInterface) {
                    JsonProtocolManager.this.iJsonProtocolInterface = a.AbstractBinderC0006a.a(iBinder);
                    JsonProtocolManager.this.iJsonProtocolInterface.a(JsonProtocolManager.this.requestAuthor, JsonProtocolManager.this.jsonProtocolReceiveInterface);
                }
            } catch (RemoteException e) {
                Log.e(JsonProtocolManager.TAG, e.getMessage(), e);
            }
            try {
                iBinder.linkToDeath(JsonProtocolManager.this.mDeathRecipient, 0);
            } catch (RemoteException e2) {
                Log.e(JsonProtocolManager.TAG, "linkToDeath RemoteException", e2);
            }
            VersionUtil.requestVersion(JsonProtocolManager.this.requestAuthor);
            if (!TextUtils.isEmpty(JsonProtocolManager.this.mWaitingProtocol)) {
                Log.i(JsonProtocolManager.TAG, "start executing waiting protocol,json=" + JsonProtocolManager.this.mWaitingProtocol);
                JsonProtocolManager jsonProtocolManager = JsonProtocolManager.this;
                jsonProtocolManager.request(jsonProtocolManager.mWaitingProtocol);
                JsonProtocolManager.this.mWaitingProtocol = null;
            }
            if (JsonProtocolManager.this.mServiceConnectListener != null) {
                JsonProtocolManager.this.mServiceConnectListener.onServiceConnected();
            }
            JsonProtocolManager.this.notifyInitChanage();
            Log.i(JsonProtocolManager.TAG, "onServiceConnected done");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(JsonProtocolManager.TAG, "onServiceDisconnected");
            synchronized (JsonProtocolManager.this.mLockInterface) {
                JsonProtocolManager.this.iJsonProtocolInterface = null;
            }
            if (JsonProtocolManager.this.mServiceConnectListener != null) {
                JsonProtocolManager.this.mServiceConnectListener.onServiceDisconnected();
            }
        }
    };
    private b.a jsonProtocolReceiveInterface = new b.a() { // from class: com.autonavi.amapauto.jsonsdk.JsonProtocolManager.3
        @Override // com.autonavi.amapauto.a.b
        public void received(String str) throws RemoteException {
            PLogger.d(JsonProtocolManager.TAG, "received : = " + str, new Object[0]);
            JsonProtocolManager.this.checkVersion(str);
            if (JsonProtocolManager.this.mJsonProtocolReceive != null) {
                JsonProtocolManager.this.mJsonProtocolReceive.received(str);
            }
        }

        @Override // com.autonavi.amapauto.a.b
        public String receivedSync(String str) throws RemoteException {
            Log.i(JsonProtocolManager.TAG, "receivedSync:" + str);
            JsonProtocolManager.this.checkVersion(str);
            if (JsonProtocolManager.this.mJsonProtocolReceive != null) {
                Log.i(JsonProtocolManager.TAG, "mJsonProtocolReceive receivedSync:" + str);
                return JsonProtocolManager.this.mJsonProtocolReceive.receivedSync(str);
            }
            Log.i(JsonProtocolManager.TAG, "receivedSyn cmJsonProtocolReceive is null");
            return null;
        }
    };

    public interface OnInitListener {
        void onInit();
    }

    public String getSDKVersion() {
        return "1.0.485.59fcd225";
    }

    private static class Holder {
        private static final JsonProtocolManager INSTANCE = new JsonProtocolManager();

        private Holder() {
        }
    }

    public static JsonProtocolManager getInstance() {
        return Holder.INSTANCE;
    }

    public boolean init(Context context) {
        Log.i(TAG, "init start");
        this.mContext = context;
        String str = this.requestAuthor;
        if (str == null || str.isEmpty()) {
            this.requestAuthor = this.mContext.getPackageName();
        }
        boolean bindService = bindService();
        Log.i(TAG, "JsonClient version = 3.2.0.20190521 package = " + this.mContext.getPackageName());
        this.mWaitingProtocol = null;
        Log.i(TAG, "init end");
        return bindService;
    }

    public boolean init(Context context, OnInitListener onInitListener) {
        this.mOnInitListener = onInitListener;
        return init(context);
    }

    public boolean init(Context context, OnInitListener onInitListener, String str) {
        this.mServicePkgName = str;
        return init(context, onInitListener);
    }

    public a getJsonProtocolInterface() {
        a aVar;
        synchronized (this.mLockInterface) {
            aVar = this.iJsonProtocolInterface;
        }
        return aVar;
    }

    public void setServiceConnectListener(IServiceConnectListener iServiceConnectListener) {
        this.mServiceConnectListener = iServiceConnectListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bindService() {
        if (this.mContext == null) {
            Log.i(TAG, "bindService mContext is null");
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(AIDL_BINDSERVICE_ACTION);
            if (TextUtils.isEmpty(this.mServicePkgName)) {
                this.mServicePkgName = AIDL_BINDSERVICE_PACKAGENAME;
            }
            intent.setComponent(new ComponentName(this.mServicePkgName, AIDL_BINDSERVICE_SERVICENAME));
            this.isBind = this.mContext.getApplicationContext().bindService(intent, this.jsonServerConn, 1);
            Log.i(TAG, "bindService, service pkg = " + this.mServicePkgName + ", result = " + this.isBind);
        } catch (Exception e) {
            Log.e(TAG, "bindService Exception", e);
        }
        return this.isBind;
    }

    public void destroy() {
        unregisterCallback();
        unBindService();
    }

    public boolean unregisterCallback() {
        if (this.mContext == null) {
            Log.i(TAG, "mContext is null value");
            return false;
        }
        Log.i(TAG, "unregisterCallback");
        try {
            synchronized (this.mLockInterface) {
                a aVar = this.iJsonProtocolInterface;
                if (aVar != null) {
                    aVar.b(this.requestAuthor, this.jsonProtocolReceiveInterface);
                    return true;
                }
                Log.i(TAG, "iJsonProtocolInterface is null value");
                return false;
            }
        } catch (RemoteException e) {
            String message = e.getMessage();
            if (TextUtils.isEmpty(message)) {
                Log.e(TAG, "unregisterCallback catch RemoteException");
                return true;
            }
            Log.e(TAG, message);
            return true;
        } catch (UnsupportedOperationException e2) {
            String message2 = e2.getMessage();
            if (TextUtils.isEmpty(message2)) {
                Log.e(TAG, "unregisterCallback catch UnsupportedOperationException");
                return true;
            }
            Log.e(TAG, message2);
            return true;
        }
    }

    private boolean unBindService() {
        if (this.mContext == null || !this.isBind) {
            Log.i(TAG, "unBindService isBind = {?}" + this.isBind);
            return false;
        }
        Log.i(TAG, "unBindService");
        this.isBind = false;
        try {
            this.mContext.getApplicationContext().unbindService(this.jsonServerConn);
        } catch (UnsupportedOperationException e) {
            Log.e(TAG, "unBindService UnsupportedOperationException", e);
        }
        synchronized (this.mLockInterface) {
            this.iJsonProtocolInterface = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVersion(String str) {
        if (TextUtils.isEmpty(VersionUtil.getServerVersion())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("protocolId", 0) == 99999) {
                    VersionUtil.dealVersionCallback(jSONObject, this.mContext);
                }
            } catch (JSONException e) {
                Log.e(TAG, "checkVersion fail", e);
            }
        }
    }

    public void request(String str) {
        a aVar;
        synchronized (this.mLockInterface) {
            aVar = this.iJsonProtocolInterface;
        }
        if (aVar == null) {
            Log.i(TAG, "jsonProtocolManager.getJsonProtocolInterface() is null");
            this.mWaitingProtocol = str;
            bindService();
        } else {
            Log.i(TAG, "request jsonData:" + str);
            try {
                aVar.a(this.requestAuthor, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setJsonProtocolReceive(IJsonProtocolReceive iJsonProtocolReceive) {
        boolean z;
        Log.i(TAG, "setJsonProtocolReceive jsonProtocolReceive:" + iJsonProtocolReceive);
        synchronized (this.mLockInterface) {
            this.mJsonProtocolReceive = iJsonProtocolReceive;
            a aVar = this.iJsonProtocolInterface;
            if (aVar == null) {
                this.requestAuthor = iJsonProtocolReceive.toString();
                z = false;
            } else {
                try {
                    aVar.b(this.requestAuthor, this.jsonProtocolReceiveInterface);
                    String obj = iJsonProtocolReceive.toString();
                    this.requestAuthor = obj;
                    this.iJsonProtocolInterface.a(obj, this.jsonProtocolReceiveInterface);
                } catch (RemoteException e) {
                    Log.e(TAG, e.getMessage(), e);
                }
                z = true;
            }
        }
        if (z) {
            VersionUtil.requestVersion(this.requestAuthor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInitChanage() {
        OnInitListener onInitListener = this.mOnInitListener;
        if (onInitListener != null) {
            onInitListener.onInit();
        }
    }
}
