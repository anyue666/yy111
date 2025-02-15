package android.car.input;

import android.car.Car;
import android.car.CarManagerBase;
import android.car.input.ICarInput;
import android.car.input.ICarInputCallback;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.KeyEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public final class CarInputManager extends CarManagerBase {
    public static final int CAPTURE_REQ_FLAGS_ALLOW_DELAYED_GRANT = 1;
    public static final int CAPTURE_REQ_FLAGS_TAKE_ALL_EVENTS_FOR_DISPLAY = 2;
    public static final int INPUT_CAPTURE_RESPONSE_DELAYED = 2;
    public static final int INPUT_CAPTURE_RESPONSE_FAILED = 1;
    public static final int INPUT_CAPTURE_RESPONSE_SUCCEEDED = 0;
    public static final int INPUT_TYPE_ALL_INPUTS = 1;
    public static final int INPUT_TYPE_DPAD_KEYS = 100;
    public static final int INPUT_TYPE_NAVIGATE_KEYS = 101;
    public static final int INPUT_TYPE_ROTARY_NAVIGATION = 10;
    public static final int INPUT_TYPE_ROTARY_VOLUME = 11;
    public static final int INPUT_TYPE_SYSTEM_NAVIGATE_KEYS = 102;
    public static final int TARGET_DISPLAY_TYPE_CLUSTER = 1;
    public static final int TARGET_DISPLAY_TYPE_MAIN = 0;
    private final SparseArray<CarInputCaptureCallback> mCarInputCaptureCallbacks;
    private final Object mLock;
    private final ICarInput mService;
    private final ICarInputCallback mServiceCallback;

    @Retention(RetentionPolicy.SOURCE)
    @interface CaptureRequestFlags {
    }

    public interface CarInputCaptureCallback {
        void onCaptureStateChanged(int i, int[] iArr);

        void onKeyEvents(int i, List<KeyEvent> list);

        void onRotaryEvents(int i, List<RotaryEvent> list);
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputCaptureResponseEnum {
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputTypeEnum {
    }

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TargetDisplayTypeEnum {
    }

    public CarInputManager(Car car, IBinder iBinder) {
        super(car);
        this.mServiceCallback = new ICarInputCallbackImpl();
        this.mLock = new Object();
        this.mCarInputCaptureCallbacks = new SparseArray<>(1);
        this.mService = ICarInput.Stub.asInterface(iBinder);
    }

    public int requestInputEventCapture(CarInputCaptureCallback carInputCaptureCallback, int i, int[] iArr, int i2) {
        synchronized (this.mLock) {
            this.mCarInputCaptureCallbacks.put(i, carInputCaptureCallback);
        }
        try {
            return this.mService.requestInputEventCapture(this.mServiceCallback, i, iArr, i2);
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, 1)).intValue();
        }
    }

    public void releaseInputEventCapture(int i) {
        CarInputCaptureCallback carInputCaptureCallback;
        synchronized (this.mLock) {
            carInputCaptureCallback = (CarInputCaptureCallback) this.mCarInputCaptureCallbacks.removeReturnOld(i);
        }
        if (carInputCaptureCallback == null) {
            return;
        }
        try {
            this.mService.releaseInputEventCapture(this.mServiceCallback, i);
        } catch (RemoteException unused) {
        }
    }

    @Override // android.car.CarManagerBase
    protected void onCarDisconnected() {
        synchronized (this.mLock) {
            this.mCarInputCaptureCallbacks.clear();
        }
    }

    private CarInputCaptureCallback getCallback(int i) {
        CarInputCaptureCallback carInputCaptureCallback;
        synchronized (this.mLock) {
            carInputCaptureCallback = this.mCarInputCaptureCallbacks.get(i);
        }
        return carInputCaptureCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchKeyEvents(final int i, final List<KeyEvent> list) {
        getEventHandler().post(new Runnable() { // from class: android.car.input.CarInputManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CarInputManager.this.m9lambda$dispatchKeyEvents$0$androidcarinputCarInputManager(i, list);
            }
        });
    }

    /* renamed from: lambda$dispatchKeyEvents$0$android-car-input-CarInputManager, reason: not valid java name */
    /* synthetic */ void m9lambda$dispatchKeyEvents$0$androidcarinputCarInputManager(int i, List list) {
        CarInputCaptureCallback callback = getCallback(i);
        if (callback != null) {
            callback.onKeyEvents(i, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRotaryEvents(final int i, final List<RotaryEvent> list) {
        getEventHandler().post(new Runnable() { // from class: android.car.input.CarInputManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CarInputManager.this.m11lambda$dispatchRotaryEvents$1$androidcarinputCarInputManager(i, list);
            }
        });
    }

    /* renamed from: lambda$dispatchRotaryEvents$1$android-car-input-CarInputManager, reason: not valid java name */
    /* synthetic */ void m11lambda$dispatchRotaryEvents$1$androidcarinputCarInputManager(int i, List list) {
        CarInputCaptureCallback callback = getCallback(i);
        if (callback != null) {
            callback.onRotaryEvents(i, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnCaptureStateChanged(final int i, final int[] iArr) {
        getEventHandler().post(new Runnable() { // from class: android.car.input.CarInputManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CarInputManager.this.m10xf601859a(i, iArr);
            }
        });
    }

    /* renamed from: lambda$dispatchOnCaptureStateChanged$2$android-car-input-CarInputManager, reason: not valid java name */
    /* synthetic */ void m10xf601859a(int i, int[] iArr) {
        CarInputCaptureCallback callback = getCallback(i);
        if (callback != null) {
            callback.onCaptureStateChanged(i, iArr);
        }
    }

    private static final class ICarInputCallbackImpl extends ICarInputCallback.Stub {
        private final WeakReference<CarInputManager> mManager;

        private ICarInputCallbackImpl(CarInputManager carInputManager) {
            this.mManager = new WeakReference<>(carInputManager);
        }

        @Override // android.car.input.ICarInputCallback
        public void onKeyEvents(int i, List<KeyEvent> list) {
            CarInputManager carInputManager = this.mManager.get();
            if (carInputManager == null) {
                return;
            }
            carInputManager.dispatchKeyEvents(i, list);
        }

        @Override // android.car.input.ICarInputCallback
        public void onRotaryEvents(int i, List<RotaryEvent> list) {
            CarInputManager carInputManager = this.mManager.get();
            if (carInputManager == null) {
                return;
            }
            carInputManager.dispatchRotaryEvents(i, list);
        }

        @Override // android.car.input.ICarInputCallback
        public void onCaptureStateChanged(int i, int[] iArr) {
            CarInputManager carInputManager = this.mManager.get();
            if (carInputManager == null) {
                return;
            }
            carInputManager.dispatchOnCaptureStateChanged(i, iArr);
        }
    }
}
