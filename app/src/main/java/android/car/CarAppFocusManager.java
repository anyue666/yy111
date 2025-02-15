package android.car;

import android.car.CarAppFocusManager;
import android.car.IAppFocus;
import android.car.IAppFocusListener;
import android.car.IAppFocusOwnershipCallback;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class CarAppFocusManager extends CarManagerBase {
    public static final int APP_FOCUS_MAX = 2;
    public static final int APP_FOCUS_REQUEST_FAILED = 0;
    public static final int APP_FOCUS_REQUEST_SUCCEEDED = 1;
    public static final int APP_FOCUS_TYPE_NAVIGATION = 1;

    @Deprecated
    public static final int APP_FOCUS_TYPE_VOICE_COMMAND = 2;
    private final Map<OnAppFocusChangedListener, IAppFocusListenerImpl> mChangeBinders;
    private final Map<OnAppFocusOwnershipCallback, IAppFocusOwnershipCallbackImpl> mOwnershipBinders;
    private final IAppFocus mService;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusRequestResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusType {
    }

    public interface OnAppFocusChangedListener {
        void onAppFocusChanged(int i, boolean z);
    }

    public interface OnAppFocusOwnershipCallback {
        void onAppFocusOwnershipGranted(int i);

        void onAppFocusOwnershipLost(int i);
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public CarAppFocusManager(Car car, IBinder iBinder) {
        super(car);
        this.mChangeBinders = new HashMap();
        this.mOwnershipBinders = new HashMap();
        this.mService = IAppFocus.Stub.asInterface(iBinder);
    }

    public void addFocusListener(OnAppFocusChangedListener onAppFocusChangedListener, int i) {
        IAppFocusListenerImpl iAppFocusListenerImpl;
        if (onAppFocusChangedListener == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this) {
            iAppFocusListenerImpl = this.mChangeBinders.get(onAppFocusChangedListener);
            if (iAppFocusListenerImpl == null) {
                iAppFocusListenerImpl = new IAppFocusListenerImpl(onAppFocusChangedListener);
                this.mChangeBinders.put(onAppFocusChangedListener, iAppFocusListenerImpl);
            }
            iAppFocusListenerImpl.addAppType(i);
        }
        try {
            this.mService.registerFocusListener(iAppFocusListenerImpl, i);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public void removeFocusListener(OnAppFocusChangedListener onAppFocusChangedListener, int i) {
        synchronized (this) {
            IAppFocusListenerImpl iAppFocusListenerImpl = this.mChangeBinders.get(onAppFocusChangedListener);
            if (iAppFocusListenerImpl == null) {
                return;
            }
            try {
                this.mService.unregisterFocusListener(iAppFocusListenerImpl, i);
            } catch (RemoteException e) {
                handleRemoteExceptionFromCarService(e);
            }
            synchronized (this) {
                iAppFocusListenerImpl.removeAppType(i);
                if (!iAppFocusListenerImpl.hasAppTypes()) {
                    this.mChangeBinders.remove(onAppFocusChangedListener);
                }
            }
        }
    }

    public void removeFocusListener(OnAppFocusChangedListener onAppFocusChangedListener) {
        synchronized (this) {
            IAppFocusListenerImpl remove = this.mChangeBinders.remove(onAppFocusChangedListener);
            if (remove == null) {
                return;
            }
            try {
                Iterator<Integer> it = remove.getAppTypes().iterator();
                while (it.hasNext()) {
                    this.mService.unregisterFocusListener(remove, it.next().intValue());
                }
            } catch (RemoteException e) {
                handleRemoteExceptionFromCarService(e);
            }
        }
    }

    public int[] getActiveAppTypes() {
        try {
            return this.mService.getActiveAppTypes();
        } catch (RemoteException e) {
            return (int[]) handleRemoteExceptionFromCarService(e, new int[0]);
        }
    }

    public boolean isOwningFocus(OnAppFocusOwnershipCallback onAppFocusOwnershipCallback, int i) {
        synchronized (this) {
            IAppFocusOwnershipCallbackImpl iAppFocusOwnershipCallbackImpl = this.mOwnershipBinders.get(onAppFocusOwnershipCallback);
            if (iAppFocusOwnershipCallbackImpl == null) {
                return false;
            }
            try {
                return this.mService.isOwningFocus(iAppFocusOwnershipCallbackImpl, i);
            } catch (RemoteException e) {
                return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
            }
        }
    }

    public int requestAppFocus(int i, OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
        IAppFocusOwnershipCallbackImpl iAppFocusOwnershipCallbackImpl;
        if (onAppFocusOwnershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this) {
            iAppFocusOwnershipCallbackImpl = this.mOwnershipBinders.get(onAppFocusOwnershipCallback);
            if (iAppFocusOwnershipCallbackImpl == null) {
                iAppFocusOwnershipCallbackImpl = new IAppFocusOwnershipCallbackImpl(onAppFocusOwnershipCallback);
                this.mOwnershipBinders.put(onAppFocusOwnershipCallback, iAppFocusOwnershipCallbackImpl);
            }
            iAppFocusOwnershipCallbackImpl.addAppType(i);
        }
        try {
            return this.mService.requestAppFocus(iAppFocusOwnershipCallbackImpl, i);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 0)).intValue();
        }
    }

    public void abandonAppFocus(OnAppFocusOwnershipCallback onAppFocusOwnershipCallback, int i) {
        if (onAppFocusOwnershipCallback == null) {
            throw new IllegalArgumentException("null callback");
        }
        synchronized (this) {
            IAppFocusOwnershipCallbackImpl iAppFocusOwnershipCallbackImpl = this.mOwnershipBinders.get(onAppFocusOwnershipCallback);
            if (iAppFocusOwnershipCallbackImpl == null) {
                return;
            }
            try {
                this.mService.abandonAppFocus(iAppFocusOwnershipCallbackImpl, i);
            } catch (RemoteException e) {
                handleRemoteExceptionFromCarService(e);
            }
            synchronized (this) {
                iAppFocusOwnershipCallbackImpl.removeAppType(i);
                if (!iAppFocusOwnershipCallbackImpl.hasAppTypes()) {
                    this.mOwnershipBinders.remove(onAppFocusOwnershipCallback);
                }
            }
        }
    }

    public void abandonAppFocus(OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
        synchronized (this) {
            IAppFocusOwnershipCallbackImpl remove = this.mOwnershipBinders.remove(onAppFocusOwnershipCallback);
            if (remove == null) {
                return;
            }
            try {
                Iterator<Integer> it = remove.getAppTypes().iterator();
                while (it.hasNext()) {
                    this.mService.abandonAppFocus(remove, it.next().intValue());
                }
            } catch (RemoteException e) {
                handleRemoteExceptionFromCarService(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class IAppFocusListenerImpl extends IAppFocusListener.Stub {
        private final Set<Integer> mAppTypes;
        private final WeakReference<OnAppFocusChangedListener> mListener;
        private final WeakReference<CarAppFocusManager> mManager;

        private IAppFocusListenerImpl(CarAppFocusManager carAppFocusManager, OnAppFocusChangedListener onAppFocusChangedListener) {
            this.mAppTypes = new HashSet();
            this.mManager = new WeakReference<>(carAppFocusManager);
            this.mListener = new WeakReference<>(onAppFocusChangedListener);
        }

        public void addAppType(int i) {
            this.mAppTypes.add(Integer.valueOf(i));
        }

        public void removeAppType(int i) {
            this.mAppTypes.remove(Integer.valueOf(i));
        }

        public Set<Integer> getAppTypes() {
            return this.mAppTypes;
        }

        public boolean hasAppTypes() {
            return !this.mAppTypes.isEmpty();
        }

        @Override // android.car.IAppFocusListener
        public void onAppFocusChanged(final int i, final boolean z) {
            CarAppFocusManager carAppFocusManager = this.mManager.get();
            final OnAppFocusChangedListener onAppFocusChangedListener = this.mListener.get();
            if (carAppFocusManager == null || onAppFocusChangedListener == null) {
                return;
            }
            carAppFocusManager.getEventHandler().post(new Runnable() { // from class: android.car.CarAppFocusManager$IAppFocusListenerImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CarAppFocusManager.OnAppFocusChangedListener.this.onAppFocusChanged(i, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class IAppFocusOwnershipCallbackImpl extends IAppFocusOwnershipCallback.Stub {
        private final Set<Integer> mAppTypes;
        private final WeakReference<OnAppFocusOwnershipCallback> mCallback;
        private final WeakReference<CarAppFocusManager> mManager;

        private IAppFocusOwnershipCallbackImpl(CarAppFocusManager carAppFocusManager, OnAppFocusOwnershipCallback onAppFocusOwnershipCallback) {
            this.mAppTypes = new HashSet();
            this.mManager = new WeakReference<>(carAppFocusManager);
            this.mCallback = new WeakReference<>(onAppFocusOwnershipCallback);
        }

        public void addAppType(int i) {
            this.mAppTypes.add(Integer.valueOf(i));
        }

        public void removeAppType(int i) {
            this.mAppTypes.remove(Integer.valueOf(i));
        }

        public Set<Integer> getAppTypes() {
            return this.mAppTypes;
        }

        public boolean hasAppTypes() {
            return !this.mAppTypes.isEmpty();
        }

        @Override // android.car.IAppFocusOwnershipCallback
        public void onAppFocusOwnershipLost(final int i) {
            CarAppFocusManager carAppFocusManager = this.mManager.get();
            final OnAppFocusOwnershipCallback onAppFocusOwnershipCallback = this.mCallback.get();
            if (carAppFocusManager == null || onAppFocusOwnershipCallback == null) {
                return;
            }
            carAppFocusManager.getEventHandler().post(new Runnable() { // from class: android.car.CarAppFocusManager$IAppFocusOwnershipCallbackImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CarAppFocusManager.OnAppFocusOwnershipCallback.this.onAppFocusOwnershipLost(i);
                }
            });
        }

        @Override // android.car.IAppFocusOwnershipCallback
        public void onAppFocusOwnershipGranted(final int i) {
            CarAppFocusManager carAppFocusManager = this.mManager.get();
            final OnAppFocusOwnershipCallback onAppFocusOwnershipCallback = this.mCallback.get();
            if (carAppFocusManager == null || onAppFocusOwnershipCallback == null) {
                return;
            }
            carAppFocusManager.getEventHandler().post(new Runnable() { // from class: android.car.CarAppFocusManager$IAppFocusOwnershipCallbackImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CarAppFocusManager.OnAppFocusOwnershipCallback.this.onAppFocusOwnershipGranted(i);
                }
            });
        }
    }
}
