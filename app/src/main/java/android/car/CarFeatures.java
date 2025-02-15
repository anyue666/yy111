package android.car;

import android.os.RemoteException;
import android.util.ArrayMap;

/* loaded from: classes.dex */
public final class CarFeatures {
    public static String FEATURE_CAR_USER_NOTICE_SERVICE = "com.android.car.user.CarUserNoticeService";
    private final ArrayMap<String, Boolean> mCachedFeatures = new ArrayMap<>();

    boolean isFeatureEnabled(ICar iCar, String str) {
        synchronized (this.mCachedFeatures) {
            Boolean bool = this.mCachedFeatures.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            try {
                boolean isFeatureEnabled = iCar.isFeatureEnabled(str);
                synchronized (this.mCachedFeatures) {
                    this.mCachedFeatures.put(str, Boolean.valueOf(isFeatureEnabled));
                }
                return isFeatureEnabled;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    void resetCache() {
        synchronized (this.mCachedFeatures) {
            this.mCachedFeatures.clear();
        }
    }
}
