package android.car.user;

import android.car.Car;
import android.car.CarManagerBase;
import android.car.ICarUserService;
import android.content.pm.UserInfo;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.infra.AndroidFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class ExperimentalCarUserManager extends CarManagerBase {
    private static final int INVALID_USER_ID = -10000;
    private static final String TAG = "ExperimentalCarUserManager";
    private final ICarUserService mService;

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public static ExperimentalCarUserManager from(CarUserManager carUserManager) {
        return carUserManager.newExperimentalCarUserManager();
    }

    ExperimentalCarUserManager(Car car, ICarUserService iCarUserService) {
        super(car);
        this.mService = iCarUserService;
    }

    public AndroidFuture<UserCreationResult> createDriver(String str, boolean z) {
        try {
            return this.mService.createDriver(str, z);
        } catch (RemoteException e) {
            AndroidFuture<UserCreationResult> androidFuture = new AndroidFuture<>();
            androidFuture.complete(new UserCreationResult(4, null, null));
            handleRemoteExceptionFromCarService(e);
            return androidFuture;
        }
    }

    public int createPassenger(String str, int i) {
        try {
            UserInfo createPassenger = this.mService.createPassenger(str, i);
            return createPassenger != null ? createPassenger.id : INVALID_USER_ID;
        } catch (RemoteException e) {
            return ((Integer) handleRemoteExceptionFromCarService(e, null)).intValue();
        }
    }

    public AndroidFuture<UserSwitchResult> switchDriver(final int i) {
        try {
            AndroidFuture<UserSwitchResult> androidFuture = new AndroidFuture<UserSwitchResult>() { // from class: android.car.user.ExperimentalCarUserManager.1
                /* JADX INFO: Access modifiers changed from: protected */
                public void onCompleted(UserSwitchResult userSwitchResult, Throwable th) {
                    if (userSwitchResult == null) {
                        Log.w(ExperimentalCarUserManager.TAG, "switchDriver(" + i + ") failed: " + th);
                    }
                    super.onCompleted(userSwitchResult, th);
                }
            };
            this.mService.switchDriver(i, androidFuture);
            return androidFuture;
        } catch (RemoteException e) {
            AndroidFuture<UserSwitchResult> androidFuture2 = new AndroidFuture<>();
            androidFuture2.complete(new UserSwitchResult(4, null));
            handleRemoteExceptionFromCarService(e);
            return androidFuture2;
        }
    }

    public List<Integer> getAllDrivers() {
        try {
            return getUserIdsFromUserInfos(this.mService.getAllDrivers());
        } catch (RemoteException e) {
            return (List) handleRemoteExceptionFromCarService(e, Collections.emptyList());
        }
    }

    public List<Integer> getPassengers(int i) {
        try {
            return getUserIdsFromUserInfos(this.mService.getPassengers(i));
        } catch (RemoteException e) {
            return (List) handleRemoteExceptionFromCarService(e, Collections.emptyList());
        }
    }

    public boolean startPassenger(int i, int i2) {
        try {
            return this.mService.startPassenger(i, i2);
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    public boolean stopPassenger(int i) {
        try {
            return this.mService.stopPassenger(i);
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    private List<Integer> getUserIdsFromUserInfos(List<UserInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<UserInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().id));
        }
        return arrayList;
    }
}
