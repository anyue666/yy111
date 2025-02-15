package android.car.input;

import android.annotation.SystemApi;
import android.app.Service;
import android.car.Car;
import android.car.input.ICarInputListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;

@SystemApi
/* loaded from: classes.dex */
public abstract class CarInputHandlingService extends Service {
    private static final boolean DBG = false;
    public static final int INPUT_CALLBACK_BINDER_CODE = 1;
    public static final String INPUT_CALLBACK_BINDER_KEY = "callback_binder";
    private static final String TAG = "CAR.L.INPUT";
    private final InputFilter[] mHandledKeys;
    private InputBinder mInputBinder;

    protected abstract void onKeyEvent(KeyEvent keyEvent, int i);

    protected CarInputHandlingService(InputFilter[] inputFilterArr) {
        if (inputFilterArr == null) {
            throw new IllegalArgumentException("handledKeys is null");
        }
        InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length];
        this.mHandledKeys = inputFilterArr2;
        System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, inputFilterArr.length);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        doCallbackIfPossible(intent.getExtras());
        if (this.mInputBinder == null) {
            this.mInputBinder = new InputBinder();
        }
        return this.mInputBinder;
    }

    private void doCallbackIfPossible(Bundle bundle) {
        if (bundle == null) {
            Log.i("CAR.L.INPUT", "doCallbackIfPossible: extras are null");
            return;
        }
        IBinder binder = bundle.getBinder(INPUT_CALLBACK_BINDER_KEY);
        if (binder == null) {
            Log.i("CAR.L.INPUT", "doCallbackIfPossible: callback IBinder is null");
            return;
        }
        Parcel obtain = Parcel.obtain();
        obtain.writeTypedArray(this.mHandledKeys, 0);
        try {
            binder.transact(1, obtain, null, 1);
        } catch (RemoteException e) {
            Car.handleRemoteExceptionFromCarService(this, e);
        }
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println("**" + getClass().getSimpleName() + "**");
        printWriter.println("input binder: " + this.mInputBinder);
    }

    private class InputBinder extends ICarInputListener.Stub {
        private final EventHandler mEventHandler;

        InputBinder() {
            this.mEventHandler = new EventHandler(CarInputHandlingService.this);
        }

        @Override // android.car.input.ICarInputListener
        public void onKeyEvent(KeyEvent keyEvent, int i) throws RemoteException {
            this.mEventHandler.doKeyEvent(keyEvent, i);
        }
    }

    private static class EventHandler extends Handler {
        private static final int KEY_EVENT = 0;
        private final WeakReference<CarInputHandlingService> mRefService;

        EventHandler(CarInputHandlingService carInputHandlingService) {
            this.mRefService = new WeakReference<>(carInputHandlingService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CarInputHandlingService carInputHandlingService = this.mRefService.get();
            if (carInputHandlingService == null) {
                return;
            }
            if (message.what == 0) {
                carInputHandlingService.onKeyEvent((KeyEvent) message.obj, message.arg1);
                return;
            }
            throw new IllegalArgumentException("Unexpected message: " + message);
        }

        void doKeyEvent(KeyEvent keyEvent, int i) {
            sendMessage(obtainMessage(0, i, 0, keyEvent));
        }
    }

    public static final class InputFilter implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: android.car.input.CarInputHandlingService.InputFilter.1
            @Override // android.os.Parcelable.Creator
            public InputFilter createFromParcel(Parcel parcel) {
                return new InputFilter(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public InputFilter[] newArray(int i) {
                return new InputFilter[i];
            }
        };
        public final int mKeyCode;
        public final int mTargetDisplay;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public InputFilter(int i, int i2) {
            this.mKeyCode = i;
            this.mTargetDisplay = i2;
        }

        InputFilter(Parcel parcel) {
            this.mKeyCode = parcel.readInt();
            this.mTargetDisplay = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mKeyCode);
            parcel.writeInt(this.mTargetDisplay);
        }
    }
}
