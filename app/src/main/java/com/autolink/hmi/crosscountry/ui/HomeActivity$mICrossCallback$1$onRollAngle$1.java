package com.autolink.hmi.crosscountry.ui;

import android.widget.ImageView;
import com.autolink.buryservice.bury.consts.BuryKeyConst;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
import com.autolink.hmi.crosscountry.utils.BuryServiceUtils;
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
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$mICrossCallback$1$onRollAngle$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$mICrossCallback$1$onRollAngle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$mICrossCallback$1$onRollAngle$1(HomeActivity homeActivity, String str, Continuation<? super HomeActivity$mICrossCallback$1$onRollAngle$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
        this.$msg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$mICrossCallback$1$onRollAngle$1(this.this$0, this.$msg, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$mICrossCallback$1$onRollAngle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            if (!((ActivityHomeBinding) this.this$0.getMVB()).angleInclination.getText().equals(String.valueOf(this.$msg))) {
                BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_RollAngle, "" + this.$msg);
                ImageView imageView = ((ActivityHomeBinding) this.this$0.getMVB()).rollOverIcon;
                String str2 = this.$msg;
                Intrinsics.checkNotNull(str2);
                imageView.setRotation(Float.parseFloat(str2));
                ((ActivityHomeBinding) this.this$0.getMVB()).angleInclination.setText("" + this.$msg);
            }
        } catch (Exception e) {
            str = this.this$0.TAG;
            LogUtils.logI(str, "翻滚角异常 " + e);
        }
        return Unit.INSTANCE;
    }
}
