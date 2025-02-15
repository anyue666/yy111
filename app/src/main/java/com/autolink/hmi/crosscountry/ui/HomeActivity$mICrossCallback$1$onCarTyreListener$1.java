package com.autolink.hmi.crosscountry.ui;

import android.widget.ImageView;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
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
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$mICrossCallback$1$onCarTyreListener$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$mICrossCallback$1$onCarTyreListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ String $msg;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$mICrossCallback$1$onCarTyreListener$1(HomeActivity homeActivity, String str, String str2, Continuation<? super HomeActivity$mICrossCallback$1$onCarTyreListener$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
        this.$key = str;
        this.$msg = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$mICrossCallback$1$onCarTyreListener$1(this.this$0, this.$key, this.$msg, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$mICrossCallback$1$onCarTyreListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.this$0.TAG;
            LogUtils.logI(str, "onCarTyreListener key " + this.$key + "  value" + this.$msg + ' ');
            if (Integer.parseInt(this.$key) == 665) {
                HomeActivity homeActivity = this.this$0;
                ImageView imageView = ((ActivityHomeBinding) homeActivity.getMVB()).abnormalLiftTop;
                Intrinsics.checkNotNullExpressionValue(imageView, "mVB.abnormalLiftTop");
                homeActivity.tireAlarm(imageView, this.$msg);
            }
            if (Integer.parseInt(this.$key) == 667) {
                HomeActivity homeActivity2 = this.this$0;
                ImageView imageView2 = ((ActivityHomeBinding) homeActivity2.getMVB()).abnormalLiftBot;
                Intrinsics.checkNotNullExpressionValue(imageView2, "mVB.abnormalLiftBot");
                homeActivity2.tireAlarm(imageView2, this.$msg);
            }
            if (Integer.parseInt(this.$key) == 666) {
                HomeActivity homeActivity3 = this.this$0;
                ImageView imageView3 = ((ActivityHomeBinding) homeActivity3.getMVB()).abnormalRightTop;
                Intrinsics.checkNotNullExpressionValue(imageView3, "mVB.abnormalRightTop");
                homeActivity3.tireAlarm(imageView3, this.$msg);
            }
            if (Integer.parseInt(this.$key) == 668) {
                HomeActivity homeActivity4 = this.this$0;
                ImageView imageView4 = ((ActivityHomeBinding) homeActivity4.getMVB()).abnormalRightBot;
                Intrinsics.checkNotNullExpressionValue(imageView4, "mVB.abnormalRightBot");
                homeActivity4.tireAlarm(imageView4, this.$msg);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
