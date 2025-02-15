package com.autolink.hmi.crosscountry.ui;

import android.widget.ImageView;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$tireAlarm$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$tireAlarm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    final /* synthetic */ ImageView $src;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$tireAlarm$1(HomeActivity homeActivity, String str, ImageView imageView, Continuation<? super HomeActivity$tireAlarm$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
        this.$msg = str;
        this.$src = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$tireAlarm$1(this.this$0, this.$msg, this.$src, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$tireAlarm$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.this$0.TAG;
            LogUtils.logI(str, "tireAlarm set status  msg " + this.$msg);
            if (Integer.parseInt(this.$msg) == 2 || Integer.parseInt(this.$msg) == 5 || Integer.parseInt(this.$msg) == 6) {
                this.$src.setVisibility(0);
                this.this$0.clearRotationChanges(this.$src);
                this.this$0.tireRotationChanges(this.$src);
                str2 = this.this$0.TAG;
                LogUtils.logI(str2, "胎压报警闪烁");
            } else if (Integer.parseInt(this.$msg) != 0) {
                str3 = this.this$0.TAG;
                LogUtils.logI(str3, "胎压报警不予理睬");
            } else {
                this.$src.setVisibility(8);
                this.this$0.clearRotationChanges(this.$src);
                str4 = this.this$0.TAG;
                LogUtils.logI(str4, "胎压正常，关闭闪烁");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
