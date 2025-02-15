package com.autolink.hmi.crosscountry.crossviewmodel;

import android.content.SharedPreferences;
import androidx.lifecycle.MutableLiveData;
import com.autolink.hmi.crosscountry.CrossApplication;
import com.autolink.hmi.crosscountry.crossinterface.CrossSensorEventListener;
import com.autolink.hmi.crosscountry.utils.CrossAllUtils;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import com.landmark.hmimvvmbase.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020,H\u0002J\u0006\u0010.\u001a\u00020,J\u0006\u0010/\u001a\u00020,R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/autolink/hmi/crosscountry/crossviewmodel/HomeViewModel;", "Lcom/landmark/hmimvvmbase/BaseViewModel;", "()V", "PREFERENCES_NAME", "", "getPREFERENCES_NAME", "()Ljava/lang/String;", "setPREFERENCES_NAME", "(Ljava/lang/String;)V", "airPressure", "Landroidx/lifecycle/MutableLiveData;", "getAirPressure", "()Landroidx/lifecycle/MutableLiveData;", "setAirPressure", "(Landroidx/lifecycle/MutableLiveData;)V", "altitude", "getAltitude", "setAltitude", "compass", "getCompass", "setCompass", "crossEventListener", "Lcom/autolink/hmi/crosscountry/crossinterface/CrossSensorEventListener;", "getCrossEventListener", "()Lcom/autolink/hmi/crosscountry/crossinterface/CrossSensorEventListener;", "setCrossEventListener", "(Lcom/autolink/hmi/crosscountry/crossinterface/CrossSensorEventListener;)V", "mCrossAllUtils", "Lcom/autolink/hmi/crosscountry/utils/CrossAllUtils;", "getMCrossAllUtils", "()Lcom/autolink/hmi/crosscountry/utils/CrossAllUtils;", "setMCrossAllUtils", "(Lcom/autolink/hmi/crosscountry/utils/CrossAllUtils;)V", "mScope", "Lkotlinx/coroutines/CoroutineScope;", "getMScope", "()Lkotlinx/coroutines/CoroutineScope;", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "setSp", "(Landroid/content/SharedPreferences;)V", "clearCompassListener", "", "getAltitudeInfo", "initComponent", "setSensorManager", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HomeViewModel extends BaseViewModel {
    private CrossAllUtils mCrossAllUtils;
    private SharedPreferences sp;
    private MutableLiveData<String> airPressure = new MutableLiveData<>();
    private MutableLiveData<String> altitude = new MutableLiveData<>();
    private String PREFERENCES_NAME = "cross_sp";
    private MutableLiveData<String> compass = new MutableLiveData<>();
    private final CoroutineScope mScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    private CrossSensorEventListener crossEventListener = new CrossSensorEventListener() { // from class: com.autolink.hmi.crosscountry.crossviewmodel.HomeViewModel$crossEventListener$1
        @Override // com.autolink.hmi.crosscountry.crossinterface.CrossSensorEventListener
        public void onAltitude(float event) {
            BuildersKt__Builders_commonKt.launch$default(HomeViewModel.this.getMScope(), Dispatchers.getMain(), null, new HomeViewModel$crossEventListener$1$onAltitude$1(HomeViewModel.this, event, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.crossinterface.CrossSensorEventListener
        public void onCompass(float event) {
            LogUtils.logI("===", "gps 方向后台更新 刷新前台 value: " + event);
            HomeViewModel.this.getCompass().postValue("" + event);
        }
    };

    public final MutableLiveData<String> getAirPressure() {
        return this.airPressure;
    }

    public final void setAirPressure(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.airPressure = mutableLiveData;
    }

    public final MutableLiveData<String> getAltitude() {
        return this.altitude;
    }

    public final void setAltitude(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.altitude = mutableLiveData;
    }

    public final SharedPreferences getSp() {
        return this.sp;
    }

    public final void setSp(SharedPreferences sharedPreferences) {
        this.sp = sharedPreferences;
    }

    public final String getPREFERENCES_NAME() {
        return this.PREFERENCES_NAME;
    }

    public final void setPREFERENCES_NAME(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.PREFERENCES_NAME = str;
    }

    public final MutableLiveData<String> getCompass() {
        return this.compass;
    }

    public final void setCompass(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.compass = mutableLiveData;
    }

    public final CoroutineScope getMScope() {
        return this.mScope;
    }

    public final CrossAllUtils getMCrossAllUtils() {
        return this.mCrossAllUtils;
    }

    public final void setMCrossAllUtils(CrossAllUtils crossAllUtils) {
        this.mCrossAllUtils = crossAllUtils;
    }

    public final void initComponent() {
        this.sp = CrossApplication.sInstance.getSharedPreferences(this.PREFERENCES_NAME, 0);
        this.mCrossAllUtils = new CrossAllUtils(this.sp);
        BuildersKt__Builders_commonKt.launch$default(this.mScope, null, null, new HomeViewModel$initComponent$1(this, null), 3, null);
        getAltitudeInfo();
    }

    private final void getAltitudeInfo() {
        CrossAllUtils crossAllUtils = this.mCrossAllUtils;
        if (crossAllUtils != null) {
            crossAllUtils.startLocationSensorOnce();
        }
    }

    public final void setSensorManager() {
        CrossAllUtils crossAllUtils = this.mCrossAllUtils;
        if (crossAllUtils != null) {
            crossAllUtils.setCrossSensorEventListener(this.crossEventListener);
        }
    }

    public final void clearCompassListener() {
        CrossAllUtils crossAllUtils = this.mCrossAllUtils;
        if (crossAllUtils != null) {
            crossAllUtils.clearSensorManager();
        }
    }

    public final CrossSensorEventListener getCrossEventListener() {
        return this.crossEventListener;
    }

    public final void setCrossEventListener(CrossSensorEventListener crossSensorEventListener) {
        Intrinsics.checkNotNullParameter(crossSensorEventListener, "<set-?>");
        this.crossEventListener = crossSensorEventListener;
    }
}
