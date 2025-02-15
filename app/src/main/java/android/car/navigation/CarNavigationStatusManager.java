package android.car.navigation;

import android.annotation.SystemApi;
import android.car.Car;
import android.car.CarManagerBase;
import android.car.cluster.renderer.IInstrumentClusterNavigation;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

@SystemApi
/* loaded from: classes.dex */
public final class CarNavigationStatusManager extends CarManagerBase {
    private static final String TAG = "CAR.L.NAV";
    private final IInstrumentClusterNavigation mService;

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public CarNavigationStatusManager(Car car, IBinder iBinder) {
        super(car);
        this.mService = IInstrumentClusterNavigation.Stub.asInterface(iBinder);
    }

    @Deprecated
    public void sendEvent(int i, Bundle bundle) {
        sendNavigationStateChange(bundle);
    }

    public void sendNavigationStateChange(Bundle bundle) {
        try {
            this.mService.onNavigationStateChanged(bundle);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public CarNavigationInstrumentCluster getInstrumentClusterInfo() {
        try {
            return this.mService.getInstrumentClusterInfo();
        } catch (RemoteException e) {
            return (CarNavigationInstrumentCluster) handleRemoteExceptionFromCarService(e, null);
        }
    }
}
