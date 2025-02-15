package com.autolink.hmi.crosscountry.ui;

import android.widget.ImageView;
import com.autolink.adaptermanager.car.ALVehicleControlProperty;
import com.autolink.hmi.crosscountry.ICrossService;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getPressureAlarm$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$getPressureAlarm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$getPressureAlarm$1(HomeActivity homeActivity, Continuation<? super HomeActivity$getPressureAlarm$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$getPressureAlarm$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$getPressureAlarm$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ICrossService mICrossService = this.this$0.getMICrossService();
        Integer boxInt = mICrossService != null ? Boxing.boxInt(mICrossService.canGetVehicleParam(ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_LF)) : null;
        str = this.this$0.TAG;
        LogUtils.logI(str, " tireWarnLf" + boxInt);
        HomeActivity homeActivity = this.this$0;
        ImageView imageView = ((ActivityHomeBinding) homeActivity.getMVB()).abnormalLiftTop;
        Intrinsics.checkNotNullExpressionValue(imageView, "mVB.abnormalLiftTop");
        homeActivity.tireAlarm(imageView, String.valueOf(boxInt));
        ICrossService mICrossService2 = this.this$0.getMICrossService();
        Integer boxInt2 = mICrossService2 != null ? Boxing.boxInt(mICrossService2.canGetVehicleParam(ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_LR)) : null;
        str2 = this.this$0.TAG;
        LogUtils.logI(str2, " tireWarnLr" + boxInt2);
        HomeActivity homeActivity2 = this.this$0;
        ImageView imageView2 = ((ActivityHomeBinding) homeActivity2.getMVB()).abnormalLiftBot;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mVB.abnormalLiftBot");
        homeActivity2.tireAlarm(imageView2, String.valueOf(boxInt2));
        ICrossService mICrossService3 = this.this$0.getMICrossService();
        Integer boxInt3 = mICrossService3 != null ? Boxing.boxInt(mICrossService3.canGetVehicleParam(ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_RF)) : null;
        str3 = this.this$0.TAG;
        LogUtils.logI(str3, " tireWarnRf" + boxInt3);
        HomeActivity homeActivity3 = this.this$0;
        ImageView imageView3 = ((ActivityHomeBinding) homeActivity3.getMVB()).abnormalRightTop;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mVB.abnormalRightTop");
        homeActivity3.tireAlarm(imageView3, String.valueOf(boxInt3));
        ICrossService mICrossService4 = this.this$0.getMICrossService();
        Integer boxInt4 = mICrossService4 != null ? Boxing.boxInt(mICrossService4.canGetVehicleParam(ALVehicleControlProperty.VEHICLE_PROPERTY_VC_TIRE_WARN_RR)) : null;
        str4 = this.this$0.TAG;
        LogUtils.logI(str4, " tireWarnRR" + boxInt4);
        HomeActivity homeActivity4 = this.this$0;
        ImageView imageView4 = ((ActivityHomeBinding) homeActivity4.getMVB()).abnormalRightBot;
        Intrinsics.checkNotNullExpressionValue(imageView4, "mVB.abnormalRightBot");
        homeActivity4.tireAlarm(imageView4, String.valueOf(boxInt4));
        return Unit.INSTANCE;
    }
}
