package com.autolink.adaptermanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import com.autolink.adaptermanager.IALManager;

/* loaded from: classes.dex */
public abstract class ALBaseManager {
    private static final long SERVICE_BINDER_POLLING_INTERVAL_MS = 50;
    private static final long SERVICE_BINDER_POLLING_MAX_RETRY = 100;
    private static final long SERVICE_BIND_MAX_RETRY = 20;
    private static final long SERVICE_BIND_RETRY_INTERVAL_MS = 500;
    private final String TAG;
    private ServiceConnection mConnection;
    private IALManager.ServiceConnectionListener mConnectionListener;
    private IALManager.ServiceConnectionListenerNew mConnectionListenerNew;
    private final Runnable mConnectionRetryFailedRunnable;
    private final Runnable mConnectionRetryRunnable;
    protected Context mContext;
    private DeathRecipient mDeathRecipient;
    protected int mFlag;
    protected IBinder mIBinderService;
    protected Intent mIntent;
    private final Object mLock;
    protected Handler mMainThreadHandler;

    protected abstract int getServiceFlag();

    protected abstract Intent getServiceIntent();

    public abstract void onBinderDied();

    public abstract void onConnected(ComponentName componentName, IBinder iBinder);

    public abstract void onDisconnected();

    @Deprecated
    private ALBaseManager() {
        this.TAG = getClass().getSimpleName();
        this.mLock = new Object();
        this.mDeathRecipient = new DeathRecipient();
        this.mConnectionRetryRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryRunnable run start");
                ALBaseManager.this.bindService();
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryFailedRunnable run start");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
            }
        };
        this.mConnection = new ServiceConnection() { // from class: com.autolink.adaptermanager.ALBaseManager.3
            AnonymousClass3() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i(ALBaseManager.this.TAG, "onServiceConnected: name=" + ALBaseManager.this.mContext.getPackageName());
                ALBaseManager.this.mIBinderService = iBinder;
                ALBaseManager.this.onConnected(componentName, iBinder);
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceConnected(ALBaseManager.this);
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceConnected();
                }
                try {
                    ALBaseManager.this.mIBinderService.linkToDeath(ALBaseManager.this.mDeathRecipient, 0);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(ALBaseManager.this.TAG, "onServiceDisconnected: ");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryRunnable);
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryFailedRunnable);
            }
        };
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    @Deprecated
    public ALBaseManager(Context context) {
        String simpleName = getClass().getSimpleName();
        this.TAG = simpleName;
        this.mLock = new Object();
        this.mDeathRecipient = new DeathRecipient();
        this.mConnectionRetryRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryRunnable run start");
                ALBaseManager.this.bindService();
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryFailedRunnable run start");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
            }
        };
        this.mConnection = new ServiceConnection() { // from class: com.autolink.adaptermanager.ALBaseManager.3
            AnonymousClass3() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i(ALBaseManager.this.TAG, "onServiceConnected: name=" + ALBaseManager.this.mContext.getPackageName());
                ALBaseManager.this.mIBinderService = iBinder;
                ALBaseManager.this.onConnected(componentName, iBinder);
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceConnected(ALBaseManager.this);
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceConnected();
                }
                try {
                    ALBaseManager.this.mIBinderService.linkToDeath(ALBaseManager.this.mDeathRecipient, 0);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(ALBaseManager.this.TAG, "onServiceDisconnected: ");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryRunnable);
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryFailedRunnable);
            }
        };
        Log.d(simpleName, "ALBaseManager context=" + context);
        this.mContext = context;
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    @Deprecated
    public ALBaseManager(Context context, IALManager.ServiceConnectionListener serviceConnectionListener) {
        String simpleName = getClass().getSimpleName();
        this.TAG = simpleName;
        this.mLock = new Object();
        this.mDeathRecipient = new DeathRecipient();
        this.mConnectionRetryRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryRunnable run start");
                ALBaseManager.this.bindService();
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryFailedRunnable run start");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
            }
        };
        this.mConnection = new ServiceConnection() { // from class: com.autolink.adaptermanager.ALBaseManager.3
            AnonymousClass3() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i(ALBaseManager.this.TAG, "onServiceConnected: name=" + ALBaseManager.this.mContext.getPackageName());
                ALBaseManager.this.mIBinderService = iBinder;
                ALBaseManager.this.onConnected(componentName, iBinder);
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceConnected(ALBaseManager.this);
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceConnected();
                }
                try {
                    ALBaseManager.this.mIBinderService.linkToDeath(ALBaseManager.this.mDeathRecipient, 0);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(ALBaseManager.this.TAG, "onServiceDisconnected: ");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryRunnable);
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryFailedRunnable);
            }
        };
        Log.d(simpleName, "ALBaseManager context= " + context);
        this.mContext = context;
        this.mConnectionListener = serviceConnectionListener;
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public ALBaseManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        String simpleName = getClass().getSimpleName();
        this.TAG = simpleName;
        this.mLock = new Object();
        this.mDeathRecipient = new DeathRecipient();
        this.mConnectionRetryRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryRunnable run start");
                ALBaseManager.this.bindService();
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: com.autolink.adaptermanager.ALBaseManager.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i(ALBaseManager.this.TAG, "mConnectionRetryFailedRunnable run start");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
            }
        };
        this.mConnection = new ServiceConnection() { // from class: com.autolink.adaptermanager.ALBaseManager.3
            AnonymousClass3() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i(ALBaseManager.this.TAG, "onServiceConnected: name=" + ALBaseManager.this.mContext.getPackageName());
                ALBaseManager.this.mIBinderService = iBinder;
                ALBaseManager.this.onConnected(componentName, iBinder);
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceConnected(ALBaseManager.this);
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceConnected();
                }
                try {
                    ALBaseManager.this.mIBinderService.linkToDeath(ALBaseManager.this.mDeathRecipient, 0);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i(ALBaseManager.this.TAG, "onServiceDisconnected: ");
                ALBaseManager.this.onDisconnected();
                if (ALBaseManager.this.mConnectionListenerNew != null) {
                    ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
                }
                if (ALBaseManager.this.mConnectionListener != null) {
                    ALBaseManager.this.mConnectionListener.onServiceDisconnected();
                }
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryRunnable);
                ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryFailedRunnable);
            }
        };
        Log.d(simpleName, "ALBaseManager context=" + context);
        this.mContext = context;
        this.mConnectionListenerNew = serviceConnectionListenerNew;
        this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    /* renamed from: com.autolink.adaptermanager.ALBaseManager$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(ALBaseManager.this.TAG, "mConnectionRetryRunnable run start");
            ALBaseManager.this.bindService();
        }
    }

    /* renamed from: com.autolink.adaptermanager.ALBaseManager$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(ALBaseManager.this.TAG, "mConnectionRetryFailedRunnable run start");
            ALBaseManager.this.onDisconnected();
            if (ALBaseManager.this.mConnectionListenerNew != null) {
                ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
            }
            if (ALBaseManager.this.mConnectionListener != null) {
                ALBaseManager.this.mConnectionListener.onServiceDisconnected();
            }
        }
    }

    protected void bindService() {
        Log.i(this.TAG, "bindService mContext=" + this.mContext);
        boolean bindServiceAsUser = this.mContext.bindServiceAsUser(getServiceIntent(), this.mConnection, getServiceFlag(), UserHandle.CURRENT_OR_SELF);
        synchronized (this.mLock) {
            if (!bindServiceAsUser) {
                Log.i(this.TAG, "postDelayed mConnectionRetryRunnable");
                this.mMainThreadHandler.postDelayed(this.mConnectionRetryRunnable, SERVICE_BIND_RETRY_INTERVAL_MS);
            } else {
                Log.i(this.TAG, "startAudioService removeCallbacks");
                this.mMainThreadHandler.removeCallbacks(this.mConnectionRetryRunnable);
                this.mMainThreadHandler.removeCallbacks(this.mConnectionRetryFailedRunnable);
            }
        }
    }

    protected void unbindService() {
        this.mContext.unbindService(this.mConnection);
    }

    protected void setServiceConnectionListenerNew(IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        this.mConnectionListenerNew = serviceConnectionListenerNew;
    }

    protected void setContext(Context context) {
        this.mContext = context;
    }

    /* renamed from: com.autolink.adaptermanager.ALBaseManager$3 */
    class AnonymousClass3 implements ServiceConnection {
        AnonymousClass3() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(ALBaseManager.this.TAG, "onServiceConnected: name=" + ALBaseManager.this.mContext.getPackageName());
            ALBaseManager.this.mIBinderService = iBinder;
            ALBaseManager.this.onConnected(componentName, iBinder);
            if (ALBaseManager.this.mConnectionListenerNew != null) {
                ALBaseManager.this.mConnectionListenerNew.onServiceConnected(ALBaseManager.this);
            }
            if (ALBaseManager.this.mConnectionListener != null) {
                ALBaseManager.this.mConnectionListener.onServiceConnected();
            }
            try {
                ALBaseManager.this.mIBinderService.linkToDeath(ALBaseManager.this.mDeathRecipient, 0);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(ALBaseManager.this.TAG, "onServiceDisconnected: ");
            ALBaseManager.this.onDisconnected();
            if (ALBaseManager.this.mConnectionListenerNew != null) {
                ALBaseManager.this.mConnectionListenerNew.onServiceDisconnected();
            }
            if (ALBaseManager.this.mConnectionListener != null) {
                ALBaseManager.this.mConnectionListener.onServiceDisconnected();
            }
            ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryRunnable);
            ALBaseManager.this.mMainThreadHandler.removeCallbacks(ALBaseManager.this.mConnectionRetryFailedRunnable);
        }
    }

    private class DeathRecipient implements IBinder.DeathRecipient {
        private DeathRecipient() {
        }

        /* synthetic */ DeathRecipient(ALBaseManager aLBaseManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.i(ALBaseManager.this.TAG, "Service is died  PackageName = " + ALBaseManager.this.mContext.getPackageName());
            if (ALBaseManager.this.mIBinderService == null) {
                Log.e(ALBaseManager.this.TAG, "mIBinderService is null");
                return;
            }
            ALBaseManager.this.onBinderDied();
            ALBaseManager.this.mIBinderService.unlinkToDeath(ALBaseManager.this.mDeathRecipient, 0);
            ALBaseManager.this.mIBinderService = null;
            ALBaseManager.this.bindService();
        }
    }
}
