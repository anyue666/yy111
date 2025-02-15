package com.autolink.hmi.crosscountry.ui;

import com.autolink.adaptermanager.car.ALVehicleControlProperty;
import com.autolink.carsetting.data.car.CarContact;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
import com.autolink.hmi.crosscountry.utils.DelayRecoveryUtils;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import com.autolink.hmi.crosscountry.view.CrossSwitchCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$registerResult$1$onResult$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$registerResult$1$onResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $p0;
    final /* synthetic */ String $p1;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$registerResult$1$onResult$1(String str, String str2, HomeActivity homeActivity, Continuation<? super HomeActivity$registerResult$1$onResult$1> continuation) {
        super(2, continuation);
        this.$p0 = str;
        this.$p1 = str2;
        this.this$0 = homeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$registerResult$1$onResult$1(this.$p0, this.$p1, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$registerResult$1$onResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CrossSwitchCompat crossSwitchCompat;
        String str;
        String str2;
        String str3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str4 = this.$p0;
        if (str4 != null && this.$p1 != null) {
            if (str4.equals("559")) {
                if (this.$p1.equals(CarContact.Status.COMMON_ON)) {
                    ActivityHomeBinding activityHomeBinding = (ActivityHomeBinding) this.this$0.getMVB();
                    CrossSwitchCompat crossSwitchCompat2 = activityHomeBinding != null ? activityHomeBinding.crossRadiating : null;
                    if (crossSwitchCompat2 != null) {
                        crossSwitchCompat2.setChecked(true);
                    }
                } else if (this.$p1.equals(CarContact.Status.COMMON_OFF)) {
                    ActivityHomeBinding activityHomeBinding2 = (ActivityHomeBinding) this.this$0.getMVB();
                    CrossSwitchCompat crossSwitchCompat3 = activityHomeBinding2 != null ? activityHomeBinding2.crossRadiating : null;
                    if (crossSwitchCompat3 != null) {
                        crossSwitchCompat3.setChecked(false);
                    }
                }
                DelayRecoveryUtils companion = DelayRecoveryUtils.INSTANCE.getInstance();
                CrossSwitchCompat crossSwitchCompat4 = ((ActivityHomeBinding) this.this$0.getMVB()).crossRadiating;
                Intrinsics.checkNotNullExpressionValue(crossSwitchCompat4, "mVB.crossRadiating");
                companion.setEnable(crossSwitchCompat4, true, ALVehicleControlProperty.VEHICLE_PROPERTY_VC_COOL);
                str3 = this.this$0.TAG;
                LogUtils.logI(str3, "crossRadiating isEnabled true");
            }
            if (this.$p0.equals("523")) {
                if (this.$p1.equals(CarContact.Status.COMMON_ON) || this.$p1.equals("0x2")) {
                    ActivityHomeBinding activityHomeBinding3 = (ActivityHomeBinding) this.this$0.getMVB();
                    CrossSwitchCompat crossSwitchCompat5 = activityHomeBinding3 != null ? activityHomeBinding3.crossSlowDescent : null;
                    if (crossSwitchCompat5 != null) {
                        crossSwitchCompat5.setChecked(true);
                    }
                } else if (this.$p1.equals(CarContact.Status.COMMON_OFF)) {
                    ActivityHomeBinding activityHomeBinding4 = (ActivityHomeBinding) this.this$0.getMVB();
                    CrossSwitchCompat crossSwitchCompat6 = activityHomeBinding4 != null ? activityHomeBinding4.crossSlowDescent : null;
                    if (crossSwitchCompat6 != null) {
                        crossSwitchCompat6.setChecked(false);
                    }
                }
                DelayRecoveryUtils companion2 = DelayRecoveryUtils.INSTANCE.getInstance();
                CrossSwitchCompat crossSwitchCompat7 = ((ActivityHomeBinding) this.this$0.getMVB()).crossSlowDescent;
                Intrinsics.checkNotNullExpressionValue(crossSwitchCompat7, "mVB.crossSlowDescent");
                companion2.setEnable(crossSwitchCompat7, true, ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HDC);
                str2 = this.this$0.TAG;
                LogUtils.logI(str2, "crossSlowDescent isEnabled true");
            }
            if (this.$p0.equals("522")) {
                if (this.$p1.equals(CarContact.Status.COMMON_ON)) {
                    ActivityHomeBinding activityHomeBinding5 = (ActivityHomeBinding) this.this$0.getMVB();
                    crossSwitchCompat = activityHomeBinding5 != null ? activityHomeBinding5.crossDisabledStabilization : null;
                    if (crossSwitchCompat != null) {
                        crossSwitchCompat.setChecked(true);
                    }
                } else if (this.$p1.equals(CarContact.Status.COMMON_OFF)) {
                    ActivityHomeBinding activityHomeBinding6 = (ActivityHomeBinding) this.this$0.getMVB();
                    crossSwitchCompat = activityHomeBinding6 != null ? activityHomeBinding6.crossDisabledStabilization : null;
                    if (crossSwitchCompat != null) {
                        crossSwitchCompat.setChecked(false);
                    }
                }
                DelayRecoveryUtils companion3 = DelayRecoveryUtils.INSTANCE.getInstance();
                CrossSwitchCompat crossSwitchCompat8 = ((ActivityHomeBinding) this.this$0.getMVB()).crossDisabledStabilization;
                Intrinsics.checkNotNullExpressionValue(crossSwitchCompat8, "mVB.crossDisabledStabilization");
                companion3.setEnable(crossSwitchCompat8, true, ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ESP);
                str = this.this$0.TAG;
                LogUtils.logI(str, "crossDisabledStabilization isEnabled true");
            }
        }
        return Unit.INSTANCE;
    }
}
