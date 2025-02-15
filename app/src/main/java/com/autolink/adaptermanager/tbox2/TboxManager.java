package com.autolink.adaptermanager.tbox2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.ITbox;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TboxManager extends ALBaseManager implements IALManager {
    public static final String CALLCOMMAND_SERVICE = "callcommand";
    private static final boolean DBG = true;
    public static final String FAULT_COMMAND_SERVICE = "faultcommand";
    public static final String GENERAL_SERVICE = "general";
    public static final String NETWORK_SERVICE = "network";
    public static final String OTA_SERVICE = "ota";
    public static final String PKI_SERVICE = "pki";
    public static final String REMOTE_SERVICE = "remote";
    private static int STATE_CONNECTED = 2;
    private static int STATE_CONNECTING = 1;
    private static int STATE_DISCONNECTED = 0;
    private static final String TAG = "TboxManager";
    private static final long TBOX_SERVICE_BINDER_POLLING_INTERVAL_MS = 100;
    private static final long TBOX_SERVICE_BINDER_POLLING_MAX_RETRY = 100;
    public static final String TBOX_SERVICE_BINDER_SERVICE_NAME = "tbox2_service";
    private static final long TBOX_SERVICE_BIND_MAX_RETRY = 20;
    private static final long TBOX_SERVICE_BIND_RETRY_INTERVAL_MS = 500;
    private static final String TBOX_SERVICE_INTERFACE_NAME = "android.autolink.ITbox";
    private static final String TBOX_SERVICE_PACKAGE = "com.autolink.tboxservice2";
    public static final String USBUPGRADE_SERVICE = "usbupgrade";
    private List<TboxServiceConnectedListener> listenerList;
    private int mConnectionState;
    private final Object mLock;
    private ITbox mService;
    private boolean mServiceBound;
    private HashMap<String, TboxManagerBase> mServiceMap;

    public interface TboxServiceConnectedListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    public void registerTboxServiceConnectedListener(TboxServiceConnectedListener tboxServiceConnectedListener) {
        Log.d(TAG, "registerTboxServiceConnectedListener mConnectionState = " + this.mConnectionState + "  PackageName = " + this.mContext.getPackageName());
        if (this.mConnectionState == STATE_CONNECTED) {
            tboxServiceConnectedListener.onServiceConnected();
        }
        if (this.listenerList.contains(tboxServiceConnectedListener)) {
            return;
        }
        this.listenerList.add(tboxServiceConnectedListener);
    }

    public void unregisterTboxServiceConnectedListener(TboxServiceConnectedListener tboxServiceConnectedListener) {
        Log.d(TAG, "unregisterTboxServiceConnectedListener = " + this.mContext.getPackageName());
        if (this.listenerList.contains(tboxServiceConnectedListener)) {
            this.listenerList.remove(tboxServiceConnectedListener);
        }
    }

    @Deprecated
    public TboxManager(Context context) {
        super(context);
        this.mLock = new Object();
        this.mServiceMap = new HashMap<>();
        this.listenerList = new ArrayList();
    }

    public TboxManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.mLock = new Object();
        this.mServiceMap = new HashMap<>();
        this.listenerList = new ArrayList();
    }

    private void setService(ITbox iTbox) {
        this.mService = iTbox;
        if (iTbox != null) {
            this.mConnectionState = STATE_CONNECTED;
        } else {
            this.mConnectionState = STATE_DISCONNECTED;
        }
    }

    @Deprecated
    public static TboxManager createTbox(Context context) {
        Log.i(TAG, "createTbox start");
        boolean z = false;
        TboxManager tboxManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(TBOX_SERVICE_BINDER_SERVICE_NAME);
            if (tboxManager == null) {
                tboxManager = new TboxManager(context);
                tboxManager.setService(ITbox.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createTbox before startTboxService first");
                    tboxManager.startTboxService();
                    return tboxManager;
                }
                Log.i(TAG, "createTbox end");
                return tboxManager;
            }
            if (!z) {
                Log.i(TAG, "createTbox before startTboxService second");
                tboxManager.startTboxService();
                z = true;
            }
            i++;
            if (i > 100) {
                Log.i(TAG, "retryCount > TBOX_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(100L);
            } catch (Exception e) {
                Log.e(TAG, "createTbox Exception: " + e);
                return null;
            }
        }
    }

    public static TboxManager createTbox(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        Log.i(TAG, "createTbox start");
        boolean z = false;
        TboxManager tboxManager = null;
        int i = 0;
        while (true) {
            IBinder service = ServiceManager.getService(TBOX_SERVICE_BINDER_SERVICE_NAME);
            if (tboxManager == null) {
                tboxManager = new TboxManager(context, serviceConnectionListenerNew);
                tboxManager.setService(ITbox.Stub.asInterface(service));
            }
            if (service != null) {
                if (!z) {
                    Log.i(TAG, "createTbox before startTboxService first");
                    tboxManager.startTboxService();
                    return tboxManager;
                }
                Log.i(TAG, "createTbox end");
                return tboxManager;
            }
            if (!z) {
                Log.i(TAG, "createTbox before startTboxService second");
                tboxManager.startTboxService();
                z = true;
            }
            i++;
            if (i > 100) {
                Log.i(TAG, "retryCount > TBOX_SERVICE_BINDER_POLLING_MAX_RETRY");
                return null;
            }
            try {
                Thread.sleep(100L);
            } catch (Exception e) {
                Log.e(TAG, "createTbox Exception: " + e);
                return null;
            }
        }
    }

    public void disconnectTboxService() {
        synchronized (this.mLock) {
            handleTboxDisconnectLocked();
            if (this.mServiceBound) {
                unbindService();
                this.mServiceBound = false;
            }
        }
    }

    private void startTboxService() {
        if (this.mServiceMap == null) {
            this.mServiceMap = new HashMap<>();
        }
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent();
        intent.setPackage(TBOX_SERVICE_PACKAGE);
        intent.setAction(TBOX_SERVICE_INTERFACE_NAME);
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.mLock) {
            ITbox asInterface = ITbox.Stub.asInterface(iBinder);
            if (asInterface == null) {
                Log.d(TAG, "=============newService is null=============");
                return;
            }
            ITbox iTbox = this.mService;
            if (iTbox != null && iTbox.asBinder().equals(asInterface.asBinder())) {
                Log.i(TAG, "onServiceConnected mService " + this.mService);
            } else {
                this.mService = asInterface;
            }
            this.mConnectionState = STATE_CONNECTED;
            if (!this.listenerList.isEmpty()) {
                for (TboxServiceConnectedListener tboxServiceConnectedListener : this.listenerList) {
                    Log.d(TAG, "=============onServiceConnected=============");
                    tboxServiceConnectedListener.onServiceConnected();
                }
            }
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        synchronized (this.mLock) {
            if (this.mConnectionState == STATE_DISCONNECTED) {
                return;
            }
            handleTboxDisconnectLocked();
            if (!this.listenerList.isEmpty()) {
                for (TboxServiceConnectedListener tboxServiceConnectedListener : this.listenerList) {
                    Log.i(TAG, "=============onServiceDisconnected=============");
                    tboxServiceConnectedListener.onServiceDisconnected();
                }
            }
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        HashMap<String, TboxManagerBase> hashMap = this.mServiceMap;
        if (hashMap != null) {
            Iterator<Map.Entry<String, TboxManagerBase>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().clearDeadBinder();
            }
        }
    }

    private void handleTboxDisconnectLocked() {
        Log.i(TAG, "handleTboxDisconnectLocked start");
        this.mService = null;
        this.mServiceMap = null;
        this.mConnectionState = STATE_DISCONNECTED;
    }

    public Object getTboxManager(String str) {
        Log.d(TAG, "getTboxManager start >>> serviceName = " + str);
        synchronized (this.mLock) {
            if (this.mService == null) {
                Log.e(TAG, "getTboxManager not working while demo service not ready");
                return null;
            }
            HashMap<String, TboxManagerBase> hashMap = this.mServiceMap;
            TboxManagerBase tboxManagerBase = hashMap != null ? hashMap.get(str) : null;
            if (tboxManagerBase == null) {
                try {
                    IBinder tboxService = this.mService.getTboxService(str);
                    if (tboxService == null) {
                        Log.e(TAG, "getTboxManager could not get binder for service:" + str);
                        return null;
                    }
                    tboxManagerBase = createTboxManager(str, tboxService);
                    if (tboxManagerBase == null) {
                        Log.e(TAG, "getTboxManager could not create manager for service:" + str);
                        return null;
                    }
                    HashMap<String, TboxManagerBase> hashMap2 = this.mServiceMap;
                    if (hashMap2 != null) {
                        hashMap2.put(str, tboxManagerBase);
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "getTboxManager RemoteException: " + e);
                }
            }
            return tboxManagerBase;
        }
    }

    private TboxManagerBase createTboxManager(String str, IBinder iBinder) {
        Log.d(TAG, "createTboxManager start " + str);
        str.hashCode();
        switch (str) {
            case "callcommand":
                return new TboxCallCommandManager(this, iBinder);
            case "remote":
                return new TboxRemoteManager(this, iBinder);
            case "usbupgrade":
                return new TboxUSBManager(this, iBinder);
            case "faultcommand":
                return new TboxFaultCommandManager(this, iBinder);
            case "general":
                return new TboxGeneralManager(this, iBinder);
            case "ota":
                return new TboxOTAManager(this, iBinder);
            case "pki":
                return new TboxPKIManager(this, iBinder);
            case "network":
                return new TboxNetworkManager(this, iBinder);
            default:
                return null;
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Handler getHandler() {
        return this.mMainThreadHandler;
    }
}
