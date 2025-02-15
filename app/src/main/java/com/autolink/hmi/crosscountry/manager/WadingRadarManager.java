package com.autolink.hmi.crosscountry.manager;

import androidx.lifecycle.MutableLiveData;
import com.autolink.car.client.CarSettingManager;
import com.autolink.carsetting.data.car.CarContact;
import com.autolink.carsetting.data.car.SystemContact;
import com.autolink.hmi.crosscountry.utils.CarSettingController;
import com.autolink.hmi.crosscountry.utils.KtExtensionKt;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WadingRadarManager.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/autolink/hmi/crosscountry/manager/WadingRadarManager;", "", "()V", "mCarSettingController", "Lcom/autolink/hmi/crosscountry/utils/CarSettingController;", "kotlin.jvm.PlatformType", "mShowWadingDepthLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getMShowWadingDepthLiveData", "()Landroidx/lifecycle/MutableLiveData;", "init", "", "isXMode", "", "Companion", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WadingRadarManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<WadingRadarManager> instance$delegate = LazyKt.lazy(new Function0<WadingRadarManager>() { // from class: com.autolink.hmi.crosscountry.manager.WadingRadarManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WadingRadarManager invoke() {
            return new WadingRadarManager();
        }
    });
    private static final int wadingRadarDelayKey = 456;
    private final MutableLiveData<String> mShowWadingDepthLiveData = new MutableLiveData<>("0");
    private final CarSettingController mCarSettingController = CarSettingController.getInstance();

    /* compiled from: WadingRadarManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/autolink/hmi/crosscountry/manager/WadingRadarManager$Companion;", "", "()V", "instance", "Lcom/autolink/hmi/crosscountry/manager/WadingRadarManager;", "getInstance", "()Lcom/autolink/hmi/crosscountry/manager/WadingRadarManager;", "instance$delegate", "Lkotlin/Lazy;", "wadingRadarDelayKey", "", "getWadingRadarDelayKey", "()I", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WadingRadarManager getInstance() {
            return (WadingRadarManager) WadingRadarManager.instance$delegate.getValue();
        }

        public final int getWadingRadarDelayKey() {
            return WadingRadarManager.wadingRadarDelayKey;
        }
    }

    public final MutableLiveData<String> getMShowWadingDepthLiveData() {
        return this.mShowWadingDepthLiveData;
    }

    public final void init() {
        this.mShowWadingDepthLiveData.postValue(CarSettingManager.getInstance().get(CarContact.WADING_RADAR));
        this.mCarSettingController.setResultCallback(new CarSettingManager.ResultCallback() { // from class: com.autolink.hmi.crosscountry.manager.WadingRadarManager$$ExternalSyntheticLambda0
            @Override // com.autolink.car.client.CarSettingManager.ResultCallback
            public final void onResult(String str, String str2) {
                WadingRadarManager.init$lambda$0(WadingRadarManager.this, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(WadingRadarManager this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, CarContact.WADING_RADAR)) {
            this$0.mShowWadingDepthLiveData.postValue(str2);
        }
    }

    public final boolean isXMode() {
        String xMode = CarSettingManager.getInstance().get(SystemContact.SS_X_MODE);
        LogUtils.logI("WadingRadarManager", "isXMode xMode = " + xMode);
        Intrinsics.checkNotNullExpressionValue(xMode, "xMode");
        return KtExtensionKt.to10Int(xMode) == KtExtensionKt.to10Int(CarContact.Status.COMMON_ON);
    }
}
