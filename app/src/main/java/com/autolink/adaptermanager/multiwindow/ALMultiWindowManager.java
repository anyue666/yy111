package com.autolink.adaptermanager.multiwindow;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.IMultiWindow;
import com.autolink.adapterinterface.IMultiWindowCallback;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ALMultiWindowManager extends ALBaseManager implements IALManager {
    private static final String TAG = "ALMultiWindowManager";
    private CopyOnWriteArrayList<ALAppStateListener> mAppStateListeners;
    private IMultiWindowCallback mCallback;
    private CopyOnWriteArrayList<ALMultiWindowListener> mListeners;
    private IMultiWindow mService;

    public interface ALAppStateListener {
        void onAppDied(String str);
    }

    public interface ALMultiWindowListener {
        void onDown();

        void onThreeFingersFling(int i);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    @Deprecated
    public ALMultiWindowManager(Context context) {
        super(context);
        this.mCallback = new IMultiWindowCallback.Stub() { // from class: com.autolink.adaptermanager.multiwindow.ALMultiWindowManager.1
            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onDown() throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onDown");
                Iterator it = ALMultiWindowManager.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((ALMultiWindowListener) it.next()).onDown();
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onThreeFingersFling(int i) throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onThreeFingersFling");
                Iterator it = ALMultiWindowManager.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((ALMultiWindowListener) it.next()).onThreeFingersFling(i);
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onAppDied(String str) throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onAppDied packageName=" + str);
                Iterator it = ALMultiWindowManager.this.mAppStateListeners.iterator();
                while (it.hasNext()) {
                    ((ALAppStateListener) it.next()).onAppDied(str);
                }
            }
        };
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mAppStateListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    @Deprecated
    public ALMultiWindowManager(Context context, IALManager.ServiceConnectionListener serviceConnectionListener) {
        super(context, serviceConnectionListener);
        this.mCallback = new IMultiWindowCallback.Stub() { // from class: com.autolink.adaptermanager.multiwindow.ALMultiWindowManager.1
            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onDown() throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onDown");
                Iterator it = ALMultiWindowManager.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((ALMultiWindowListener) it.next()).onDown();
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onThreeFingersFling(int i) throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onThreeFingersFling");
                Iterator it = ALMultiWindowManager.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((ALMultiWindowListener) it.next()).onThreeFingersFling(i);
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onAppDied(String str) throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onAppDied packageName=" + str);
                Iterator it = ALMultiWindowManager.this.mAppStateListeners.iterator();
                while (it.hasNext()) {
                    ((ALAppStateListener) it.next()).onAppDied(str);
                }
            }
        };
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mAppStateListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    public ALMultiWindowManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.mCallback = new IMultiWindowCallback.Stub() { // from class: com.autolink.adaptermanager.multiwindow.ALMultiWindowManager.1
            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onDown() throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onDown");
                Iterator it = ALMultiWindowManager.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((ALMultiWindowListener) it.next()).onDown();
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onThreeFingersFling(int i) throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onThreeFingersFling");
                Iterator it = ALMultiWindowManager.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((ALMultiWindowListener) it.next()).onThreeFingersFling(i);
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onAppDied(String str) throws RemoteException {
                Log.d(ALMultiWindowManager.TAG, "onAppDied packageName=" + str);
                Iterator it = ALMultiWindowManager.this.mAppStateListeners.iterator();
                while (it.hasNext()) {
                    ((ALAppStateListener) it.next()).onAppDied(str);
                }
            }
        };
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mAppStateListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent("com.autolink.multiwindowservice.MultiWindowService");
        intent.setPackage("com.autolink.multiwindowservice");
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        IMultiWindow asInterface = IMultiWindow.Stub.asInterface(iBinder);
        this.mService = asInterface;
        try {
            asInterface.registerCallback(this.mCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        try {
            this.mService.unregisterCallback(this.mCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.mService = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        this.mService = null;
    }

    public void registerListener(ALMultiWindowListener aLMultiWindowListener) {
        if (this.mListeners.contains(aLMultiWindowListener)) {
            return;
        }
        this.mListeners.add(aLMultiWindowListener);
    }

    public void unregisterListener(ALMultiWindowListener aLMultiWindowListener) {
        if (this.mListeners.contains(aLMultiWindowListener)) {
            this.mListeners.remove(aLMultiWindowListener);
        }
    }

    public void registerAppStateListener(ALAppStateListener aLAppStateListener) {
        if (this.mAppStateListeners.contains(aLAppStateListener)) {
            return;
        }
        this.mAppStateListeners.add(aLAppStateListener);
    }

    public void unregisterAppStateListener(ALAppStateListener aLAppStateListener) {
        if (this.mAppStateListeners.contains(aLAppStateListener)) {
            this.mAppStateListeners.remove(aLAppStateListener);
        }
    }

    public boolean isNaviBarVisable() {
        Log.d(TAG, "isNaviBarVisable: ");
        try {
            return this.mService.isNaviBarVisable();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
