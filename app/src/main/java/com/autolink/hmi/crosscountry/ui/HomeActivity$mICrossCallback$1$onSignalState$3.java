package com.autolink.hmi.crosscountry.ui;

import android.widget.TextView;
import com.autolink.buryservice.bury.consts.BuryKeyConst;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
import com.autolink.hmi.crosscountry.utils.BuryServiceUtils;
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
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$mICrossCallback$1$onSignalState$3", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$mICrossCallback$1$onSignalState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$mICrossCallback$1$onSignalState$3(String str, HomeActivity homeActivity, Continuation<? super HomeActivity$mICrossCallback$1$onSignalState$3> continuation) {
        super(2, continuation);
        this.$msg = str;
        this.this$0 = homeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$mICrossCallback$1$onSignalState$3(this.$msg, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$mICrossCallback$1$onSignalState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BuryServiceUtils buryServiceUtils = BuryServiceUtils.getInstance();
        StringBuilder sb = new StringBuilder("RF:");
        String str = this.$msg;
        Intrinsics.checkNotNull(str);
        buryServiceUtils.setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_Fetalpress, sb.append(Float.parseFloat(str)).toString());
        HomeActivity homeActivity = this.this$0;
        TextView textView = ((ActivityHomeBinding) homeActivity.getMVB()).rightLineTopValue;
        Intrinsics.checkNotNullExpressionValue(textView, "mVB.rightLineTopValue");
        TextView textView2 = ((ActivityHomeBinding) this.this$0.getMVB()).rightLineTopValueBar;
        Intrinsics.checkNotNullExpressionValue(textView2, "mVB.rightLineTopValueBar");
        TextView textView3 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBarTemperatureValue;
        Intrinsics.checkNotNullExpressionValue(textView3, "mVB.rightBarTemperatureValue");
        TextView textView4 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBarTemperatureUnit;
        Intrinsics.checkNotNullExpressionValue(textView4, "mVB.rightBarTemperatureUnit");
        String str2 = this.$msg;
        Intrinsics.checkNotNull(str2);
        homeActivity.setTyreValue(textView, textView2, textView3, textView4, Float.parseFloat(str2), -1);
        return Unit.INSTANCE;
    }
}
