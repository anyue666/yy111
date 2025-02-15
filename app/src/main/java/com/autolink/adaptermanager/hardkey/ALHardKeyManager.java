package com.autolink.adaptermanager.hardkey;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import com.autolink.adapterinterface.IHardKeyCallback;
import com.autolink.adapterinterface.IHardKeyService;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

/* loaded from: classes.dex */
public class ALHardKeyManager extends ALBaseManager implements IALManager {
    private static final String PACKAGE_NAME = "com.autolink.hardkeyservice";
    private static final String SERVICE_NAME = "com.autolink.hardkeyservice/.core.ALHardKeyService";
    private static final String TAG = "ALHardKeyManager";
    private IHardKeyCallback iHardKeyCallback;
    private IHardKeyService iHardKeyService;
    private Map<Integer, ALHardKeyPressListener> mCallbacksMap;
    private Map<Integer, ALHardKeyEventListener> mCookieCallbacksMap;
    private Map<Integer, Integer[]> mCookieKeyCodesMap;
    private boolean mDispatchEnable;
    private Map<Integer, Integer[]> mKeyCodesMap;

    public interface ALHardKeyEventListener {
        void onKeyEventCallback(int i, int i2, int i3);
    }

    public interface ALHardKeyPressListener {
        void onKeyPressed(int i);

        void onKeyReleased(int i);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
    }

    public void enableDispatch(boolean z) {
        this.mDispatchEnable = z;
        enableDispatchIfConnected();
    }

    private void enableDispatchIfConnected() {
        Log.i(TAG, "enableDispatchIfConnected.");
        IHardKeyService iHardKeyService = this.iHardKeyService;
        if (iHardKeyService == null) {
            Log.i(TAG, "Remote service is not running.");
            return;
        }
        try {
            iHardKeyService.enableDispatch(this.mDispatchEnable);
        } catch (RemoteException e) {
            Log.i(TAG, "enableDispatch fail: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void processKeyEvent(KeyEvent keyEvent, int i) {
        IHardKeyService iHardKeyService = this.iHardKeyService;
        if (iHardKeyService == null) {
            Log.i(TAG, "Remote service is not running.");
            return;
        }
        try {
            iHardKeyService.processHardKeyEvent(keyEvent, i);
        } catch (RemoteException e) {
            Log.i(TAG, "enableDispatch fail: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Deprecated
    public ALHardKeyManager(Context context) {
        super(context);
        this.mDispatchEnable = true;
        this.iHardKeyCallback = new IHardKeyCallback.Stub() { // from class: com.autolink.adaptermanager.hardkey.ALHardKeyManager.1
            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyEvent(int i, int i2, int i3) {
                Log.i(ALHardKeyManager.TAG, "ALHardKeyManager onKeyEvent keyCode = " + i + " Action = " + i2);
                for (Map.Entry entry : ALHardKeyManager.this.mCookieCallbacksMap.entrySet()) {
                    ALHardKeyEventListener aLHardKeyEventListener = (ALHardKeyEventListener) entry.getValue();
                    if (Arrays.asList((Integer[]) ALHardKeyManager.this.mCookieKeyCodesMap.get(entry.getKey())).contains(Integer.valueOf(i))) {
                        aLHardKeyEventListener.onKeyEventCallback(i, i2, i3);
                    }
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyPressed(int i) {
                for (Map.Entry entry : ALHardKeyManager.this.mCallbacksMap.entrySet()) {
                    ALHardKeyPressListener aLHardKeyPressListener = (ALHardKeyPressListener) entry.getValue();
                    if (Arrays.asList((Integer[]) ALHardKeyManager.this.mKeyCodesMap.get(entry.getKey())).contains(Integer.valueOf(i))) {
                        aLHardKeyPressListener.onKeyPressed(i);
                    }
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyReleased(int i) {
                for (Map.Entry entry : ALHardKeyManager.this.mCallbacksMap.entrySet()) {
                    ALHardKeyPressListener aLHardKeyPressListener = (ALHardKeyPressListener) entry.getValue();
                    if (Arrays.asList((Integer[]) ALHardKeyManager.this.mKeyCodesMap.get(entry.getKey())).contains(Integer.valueOf(i))) {
                        aLHardKeyPressListener.onKeyReleased(i);
                    }
                }
            }
        };
        this.mCookieKeyCodesMap = new HashMap();
        this.mCookieCallbacksMap = new HashMap();
        this.mKeyCodesMap = new HashMap();
        this.mCallbacksMap = new HashMap();
        bindService();
    }

    public ALHardKeyManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.mDispatchEnable = true;
        this.iHardKeyCallback = new IHardKeyCallback.Stub() { // from class: com.autolink.adaptermanager.hardkey.ALHardKeyManager.1
            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyEvent(int i, int i2, int i3) {
                Log.i(ALHardKeyManager.TAG, "ALHardKeyManager onKeyEvent keyCode = " + i + " Action = " + i2);
                for (Map.Entry entry : ALHardKeyManager.this.mCookieCallbacksMap.entrySet()) {
                    ALHardKeyEventListener aLHardKeyEventListener = (ALHardKeyEventListener) entry.getValue();
                    if (Arrays.asList((Integer[]) ALHardKeyManager.this.mCookieKeyCodesMap.get(entry.getKey())).contains(Integer.valueOf(i))) {
                        aLHardKeyEventListener.onKeyEventCallback(i, i2, i3);
                    }
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyPressed(int i) {
                for (Map.Entry entry : ALHardKeyManager.this.mCallbacksMap.entrySet()) {
                    ALHardKeyPressListener aLHardKeyPressListener = (ALHardKeyPressListener) entry.getValue();
                    if (Arrays.asList((Integer[]) ALHardKeyManager.this.mKeyCodesMap.get(entry.getKey())).contains(Integer.valueOf(i))) {
                        aLHardKeyPressListener.onKeyPressed(i);
                    }
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyReleased(int i) {
                for (Map.Entry entry : ALHardKeyManager.this.mCallbacksMap.entrySet()) {
                    ALHardKeyPressListener aLHardKeyPressListener = (ALHardKeyPressListener) entry.getValue();
                    if (Arrays.asList((Integer[]) ALHardKeyManager.this.mKeyCodesMap.get(entry.getKey())).contains(Integer.valueOf(i))) {
                        aLHardKeyPressListener.onKeyReleased(i);
                    }
                }
            }
        };
        this.mCookieKeyCodesMap = new HashMap();
        this.mCookieCallbacksMap = new HashMap();
        this.mKeyCodesMap = new HashMap();
        this.mCallbacksMap = new HashMap();
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent();
        intent.setPackage(PACKAGE_NAME);
        intent.setComponent(ComponentName.unflattenFromString(SERVICE_NAME));
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        this.iHardKeyService = IHardKeyService.Stub.asInterface(iBinder);
        enableDispatchIfConnected();
        try {
            this.iHardKeyService.registerHardKeyEvent(this.iHardKeyCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        this.iHardKeyService = null;
    }

    static /* synthetic */ Integer[] lambda$requestHardKeyEvent$0(int i) {
        return new Integer[i];
    }

    public int[] requestHardKeyEvent(int[] iArr, ALHardKeyEventListener aLHardKeyEventListener, int i) {
        this.mCookieKeyCodesMap.put(Integer.valueOf(i), (Integer[]) Arrays.stream(iArr).boxed().toArray(new IntFunction() { // from class: com.autolink.adaptermanager.hardkey.ALHardKeyManager$$ExternalSyntheticLambda1
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return ALHardKeyManager.lambda$requestHardKeyEvent$0(i2);
            }
        }));
        this.mCookieCallbacksMap.put(Integer.valueOf(i), aLHardKeyEventListener);
        return new int[0];
    }

    public void abandonHardKeyEvent(ALHardKeyEventListener aLHardKeyEventListener, int i) {
        this.mCookieKeyCodesMap.remove(Integer.valueOf(i));
        this.mCookieCallbacksMap.remove(Integer.valueOf(i));
    }

    static /* synthetic */ Integer[] lambda$registerHardKeyPressListener$1(int i) {
        return new Integer[i];
    }

    public void registerHardKeyPressListener(int[] iArr, ALHardKeyPressListener aLHardKeyPressListener, int i) {
        this.mKeyCodesMap.put(Integer.valueOf(i), (Integer[]) Arrays.stream(iArr).boxed().toArray(new IntFunction() { // from class: com.autolink.adaptermanager.hardkey.ALHardKeyManager$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return ALHardKeyManager.lambda$registerHardKeyPressListener$1(i2);
            }
        }));
        this.mCallbacksMap.put(Integer.valueOf(i), aLHardKeyPressListener);
    }

    public void unregisterHardKeyPressListener(ALHardKeyPressListener aLHardKeyPressListener, int i) {
        this.mKeyCodesMap.remove(Integer.valueOf(i));
        this.mCallbacksMap.remove(Integer.valueOf(i));
    }
}
