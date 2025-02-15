package android.car;

import android.car.ICarBluetooth;
import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class CarBluetoothManager extends CarManagerBase {
    private static final String TAG = "CarBluetoothManager";
    private final ICarBluetooth mService;

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public void connectDevices() {
        try {
            this.mService.connectDevices();
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public CarBluetoothManager(Car car, IBinder iBinder) {
        super(car);
        this.mService = ICarBluetooth.Stub.asInterface(iBinder);
    }
}
