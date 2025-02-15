package android.car.test;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.autolink.hmi.crosscountry.utils.networkutils.Constant;

/* loaded from: classes.dex */
public class CarLocationTestHelper {
    public static boolean injectLocation(Location location, Context context) {
        return ((LocationManager) context.getSystemService(Constant.MY_LOCATION)).injectLocation(location);
    }
}
