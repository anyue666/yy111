package android.car.hardware;

import android.annotation.SystemApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SystemApi
/* loaded from: classes.dex */
public final class CarHvacFanDirection {
    public static final int DEFROST = 4;
    public static final int DEFROST_AND_FLOOR = 6;
    public static final int FACE = 1;
    public static final int FACE_AND_FLOOR = 3;
    public static final int FLOOR = 2;
    public static final int UNKNOWN = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Enum {
    }

    private CarHvacFanDirection() {
    }
}
