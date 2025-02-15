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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$mICrossCallback$1$onFetalTemperature$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$mICrossCallback$1$onFetalTemperature$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ String $msg;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$mICrossCallback$1$onFetalTemperature$1(String str, String str2, HomeActivity homeActivity, Continuation<? super HomeActivity$mICrossCallback$1$onFetalTemperature$1> continuation) {
        super(2, continuation);
        this.$key = str;
        this.$msg = str2;
        this.this$0 = homeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$mICrossCallback$1$onFetalTemperature$1(this.$key, this.$msg, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$mICrossCallback$1$onFetalTemperature$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (StringsKt.equals$default(this.$key, "5", false, 2, null)) {
            BuryServiceUtils buryServiceUtils = BuryServiceUtils.getInstance();
            StringBuilder sb = new StringBuilder("LF:");
            String str = this.$msg;
            Intrinsics.checkNotNull(str);
            buryServiceUtils.setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_Fetal_temperature, sb.append(Integer.parseInt(str)).toString());
            HomeActivity homeActivity = this.this$0;
            TextView textView = ((ActivityHomeBinding) homeActivity.getMVB()).liftBarValue;
            Intrinsics.checkNotNullExpressionValue(textView, "mVB.liftBarValue");
            TextView textView2 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBarValueBar;
            Intrinsics.checkNotNullExpressionValue(textView2, "mVB.liftBarValueBar");
            TextView textView3 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBarTemperatureValue;
            Intrinsics.checkNotNullExpressionValue(textView3, "mVB.liftBarTemperatureValue");
            TextView textView4 = ((ActivityHomeBinding) this.this$0.getMVB()).unit01;
            Intrinsics.checkNotNullExpressionValue(textView4, "mVB.unit01");
            String str2 = this.$msg;
            Intrinsics.checkNotNull(str2);
            homeActivity.setTyreValue(textView, textView2, textView3, textView4, -1.0f, Integer.parseInt(str2));
        }
        if (StringsKt.equals$default(this.$key, "6", false, 2, null)) {
            BuryServiceUtils buryServiceUtils2 = BuryServiceUtils.getInstance();
            StringBuilder sb2 = new StringBuilder("LR:");
            String str3 = this.$msg;
            Intrinsics.checkNotNull(str3);
            buryServiceUtils2.setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_Fetal_temperature, sb2.append(Integer.parseInt(str3)).toString());
            HomeActivity homeActivity2 = this.this$0;
            TextView textView5 = ((ActivityHomeBinding) homeActivity2.getMVB()).liftBottomValue;
            Intrinsics.checkNotNullExpressionValue(textView5, "mVB.liftBottomValue");
            TextView textView6 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBottomValueBar;
            Intrinsics.checkNotNullExpressionValue(textView6, "mVB.liftBottomValueBar");
            TextView textView7 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBarBottomTemperatureValue;
            Intrinsics.checkNotNullExpressionValue(textView7, "mVB.liftBarBottomTemperatureValue");
            TextView textView8 = ((ActivityHomeBinding) this.this$0.getMVB()).unit02;
            Intrinsics.checkNotNullExpressionValue(textView8, "mVB.unit02");
            String str4 = this.$msg;
            Intrinsics.checkNotNull(str4);
            homeActivity2.setTyreValue(textView5, textView6, textView7, textView8, -1.0f, Integer.parseInt(str4));
        }
        if (StringsKt.equals$default(this.$key, "7", false, 2, null)) {
            BuryServiceUtils buryServiceUtils3 = BuryServiceUtils.getInstance();
            StringBuilder sb3 = new StringBuilder("RF:");
            String str5 = this.$msg;
            Intrinsics.checkNotNull(str5);
            buryServiceUtils3.setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_Fetal_temperature, sb3.append(Integer.parseInt(str5)).toString());
            HomeActivity homeActivity3 = this.this$0;
            TextView textView9 = ((ActivityHomeBinding) homeActivity3.getMVB()).rightLineTopValue;
            Intrinsics.checkNotNullExpressionValue(textView9, "mVB.rightLineTopValue");
            TextView textView10 = ((ActivityHomeBinding) this.this$0.getMVB()).rightLineTopValueBar;
            Intrinsics.checkNotNullExpressionValue(textView10, "mVB.rightLineTopValueBar");
            TextView textView11 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBarTemperatureValue;
            Intrinsics.checkNotNullExpressionValue(textView11, "mVB.rightBarTemperatureValue");
            TextView textView12 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBarTemperatureUnit;
            Intrinsics.checkNotNullExpressionValue(textView12, "mVB.rightBarTemperatureUnit");
            String str6 = this.$msg;
            Intrinsics.checkNotNull(str6);
            homeActivity3.setTyreValue(textView9, textView10, textView11, textView12, -1.0f, Integer.parseInt(str6));
        }
        if (StringsKt.equals$default(this.$key, "8", false, 2, null)) {
            BuryServiceUtils buryServiceUtils4 = BuryServiceUtils.getInstance();
            StringBuilder sb4 = new StringBuilder("RR:");
            String str7 = this.$msg;
            Intrinsics.checkNotNull(str7);
            buryServiceUtils4.setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_Fetal_temperature, sb4.append(Integer.parseInt(str7)).toString());
            HomeActivity homeActivity4 = this.this$0;
            TextView textView13 = ((ActivityHomeBinding) homeActivity4.getMVB()).rightLineBottomValue;
            Intrinsics.checkNotNullExpressionValue(textView13, "mVB.rightLineBottomValue");
            TextView textView14 = ((ActivityHomeBinding) this.this$0.getMVB()).rightLineBottomUnit;
            Intrinsics.checkNotNullExpressionValue(textView14, "mVB.rightLineBottomUnit");
            TextView textView15 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBottomValue;
            Intrinsics.checkNotNullExpressionValue(textView15, "mVB.rightBottomValue");
            TextView textView16 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBottomValueUnit;
            Intrinsics.checkNotNullExpressionValue(textView16, "mVB.rightBottomValueUnit");
            String str8 = this.$msg;
            Intrinsics.checkNotNull(str8);
            homeActivity4.setTyreValue(textView13, textView14, textView15, textView16, -1.0f, Integer.parseInt(str8));
        }
        return Unit.INSTANCE;
    }
}
