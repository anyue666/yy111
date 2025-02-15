package android.car.settings;

import android.car.Car;
import android.car.CarManagerBase;
import android.car.settings.ICarConfigurationManager;
import android.os.IBinder;
import android.os.RemoteException;

@Deprecated
/* loaded from: classes.dex */
public class CarConfigurationManager extends CarManagerBase {
    private static final String TAG = "CarConfigurationManager";
    private final ICarConfigurationManager mConfigurationService;

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public CarConfigurationManager(Car car, IBinder iBinder) {
        super(car);
        this.mConfigurationService = ICarConfigurationManager.Stub.asInterface(iBinder);
    }

    public SpeedBumpConfiguration getSpeedBumpConfiguration() {
        try {
            return this.mConfigurationService.getSpeedBumpConfiguration();
        } catch (RemoteException e) {
            return (SpeedBumpConfiguration) handleRemoteExceptionFromCarService(e, null);
        }
    }
}
