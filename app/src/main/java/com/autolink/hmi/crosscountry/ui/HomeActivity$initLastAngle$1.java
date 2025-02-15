package com.autolink.hmi.crosscountry.ui;

import android.widget.ImageView;
import com.autolink.buryservice.bury.consts.BuryKeyConst;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
import com.autolink.hmi.crosscountry.utils.BuryServiceUtils;
import com.autolink.hmi.crosscountry.utils.CrossAllUtils;
import com.autolink.hmi.crosscountry.utils.LogUtils;
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
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$initLastAngle$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$initLastAngle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$initLastAngle$1(HomeActivity homeActivity, Continuation<? super HomeActivity$initLastAngle$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$initLastAngle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$initLastAngle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            if (CrossAllUtils.LAST_ANGLE_INCLINATION != null) {
                str3 = this.this$0.TAG;
                LogUtils.logI(str3, "initLastAngle LAST_ANGLE_INCLINATION " + CrossAllUtils.LAST_ANGLE_INCLINATION);
                BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_Pitchangle, CrossAllUtils.LAST_ANGLE_INCLINATION);
                ((ActivityHomeBinding) this.this$0.getMVB()).angleRoll.setText(CrossAllUtils.LAST_ANGLE_INCLINATION);
                ImageView imageView = ((ActivityHomeBinding) this.this$0.getMVB()).rollTiltIcon;
                String LAST_ANGLE_INCLINATION = CrossAllUtils.LAST_ANGLE_INCLINATION;
                Intrinsics.checkNotNullExpressionValue(LAST_ANGLE_INCLINATION, "LAST_ANGLE_INCLINATION");
                imageView.setRotation(Float.parseFloat(LAST_ANGLE_INCLINATION));
            }
            if (CrossAllUtils.LAST_ROLL_ANGEL != null) {
                str2 = this.this$0.TAG;
                LogUtils.logI(str2, "initLastAngle LAST_ROLL_ANGEL " + CrossAllUtils.LAST_ROLL_ANGEL);
                BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_RollAngle, CrossAllUtils.LAST_ROLL_ANGEL);
                ImageView imageView2 = ((ActivityHomeBinding) this.this$0.getMVB()).rollOverIcon;
                String LAST_ROLL_ANGEL = CrossAllUtils.LAST_ROLL_ANGEL;
                Intrinsics.checkNotNullExpressionValue(LAST_ROLL_ANGEL, "LAST_ROLL_ANGEL");
                imageView2.setRotation(Float.parseFloat(LAST_ROLL_ANGEL));
                ((ActivityHomeBinding) this.this$0.getMVB()).angleInclination.setText(CrossAllUtils.LAST_ROLL_ANGEL);
            }
        } catch (Exception e) {
            str = this.this$0.TAG;
            LogUtils.logI(str, "initLastAngle 倾斜角异常 " + e);
        }
        return Unit.INSTANCE;
    }
}
