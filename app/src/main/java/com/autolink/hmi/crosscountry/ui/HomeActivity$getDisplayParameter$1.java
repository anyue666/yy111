package com.autolink.hmi.crosscountry.ui;

import android.widget.TextView;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1", f = "HomeActivity.kt", i = {5}, l = {1044, 1053, 1067, 1081, 1096, 1109, 1124}, m = "invokeSuspend", n = {"warningDistance"}, s = {"L$0"})
/* loaded from: classes.dex */
final class HomeActivity$getDisplayParameter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$getDisplayParameter$1(HomeActivity homeActivity, Continuation<? super HomeActivity$getDisplayParameter$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$getDisplayParameter$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$getDisplayParameter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x02d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x025b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0228 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x015d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f9 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: HomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HomeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HomeActivity homeActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = homeActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((ActivityHomeBinding) this.this$0.getMVB()).crossRadiating.setChecked(true);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$2", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $lf;
        final /* synthetic */ Ref.IntRef $lfValue;
        int label;
        final /* synthetic */ HomeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HomeActivity homeActivity, Ref.FloatRef floatRef, Ref.IntRef intRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = homeActivity;
            this.$lf = floatRef;
            this.$lfValue = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$lf, this.$lfValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            HomeActivity homeActivity = this.this$0;
            TextView textView = ((ActivityHomeBinding) homeActivity.getMVB()).liftBarValue;
            Intrinsics.checkNotNullExpressionValue(textView, "mVB.liftBarValue");
            TextView textView2 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBarValueBar;
            Intrinsics.checkNotNullExpressionValue(textView2, "mVB.liftBarValueBar");
            TextView textView3 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBarTemperatureValue;
            Intrinsics.checkNotNullExpressionValue(textView3, "mVB.liftBarTemperatureValue");
            TextView textView4 = ((ActivityHomeBinding) this.this$0.getMVB()).unit01;
            Intrinsics.checkNotNullExpressionValue(textView4, "mVB.unit01");
            homeActivity.setTyreValue(textView, textView2, textView3, textView4, this.$lf.element, this.$lfValue.element);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$3", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $lr;
        final /* synthetic */ Ref.IntRef $lrValue;
        int label;
        final /* synthetic */ HomeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(HomeActivity homeActivity, Ref.FloatRef floatRef, Ref.IntRef intRef, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = homeActivity;
            this.$lr = floatRef;
            this.$lrValue = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$lr, this.$lrValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            HomeActivity homeActivity = this.this$0;
            TextView textView = ((ActivityHomeBinding) homeActivity.getMVB()).liftBottomValue;
            Intrinsics.checkNotNullExpressionValue(textView, "mVB.liftBottomValue");
            TextView textView2 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBottomValueBar;
            Intrinsics.checkNotNullExpressionValue(textView2, "mVB.liftBottomValueBar");
            TextView textView3 = ((ActivityHomeBinding) this.this$0.getMVB()).liftBarBottomTemperatureValue;
            Intrinsics.checkNotNullExpressionValue(textView3, "mVB.liftBarBottomTemperatureValue");
            TextView textView4 = ((ActivityHomeBinding) this.this$0.getMVB()).unit02;
            Intrinsics.checkNotNullExpressionValue(textView4, "mVB.unit02");
            homeActivity.setTyreValue(textView, textView2, textView3, textView4, this.$lr.element, this.$lrValue.element);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$4", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $rf;
        final /* synthetic */ Ref.IntRef $rfValue;
        int label;
        final /* synthetic */ HomeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(HomeActivity homeActivity, Ref.FloatRef floatRef, Ref.IntRef intRef, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = homeActivity;
            this.$rf = floatRef;
            this.$rfValue = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, this.$rf, this.$rfValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            HomeActivity homeActivity = this.this$0;
            TextView textView = ((ActivityHomeBinding) homeActivity.getMVB()).rightLineTopValue;
            Intrinsics.checkNotNullExpressionValue(textView, "mVB.rightLineTopValue");
            TextView textView2 = ((ActivityHomeBinding) this.this$0.getMVB()).rightLineTopValueBar;
            Intrinsics.checkNotNullExpressionValue(textView2, "mVB.rightLineTopValueBar");
            TextView textView3 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBarTemperatureValue;
            Intrinsics.checkNotNullExpressionValue(textView3, "mVB.rightBarTemperatureValue");
            TextView textView4 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBarTemperatureUnit;
            Intrinsics.checkNotNullExpressionValue(textView4, "mVB.rightBarTemperatureUnit");
            homeActivity.setTyreValue(textView, textView2, textView3, textView4, this.$rf.element, this.$rfValue.element);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$5", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $rr;
        final /* synthetic */ Ref.IntRef $rrValue;
        int label;
        final /* synthetic */ HomeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(HomeActivity homeActivity, Ref.FloatRef floatRef, Ref.IntRef intRef, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.this$0 = homeActivity;
            this.$rr = floatRef;
            this.$rrValue = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.this$0, this.$rr, this.$rrValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            HomeActivity homeActivity = this.this$0;
            TextView textView = ((ActivityHomeBinding) homeActivity.getMVB()).rightLineBottomValue;
            Intrinsics.checkNotNullExpressionValue(textView, "mVB.rightLineBottomValue");
            TextView textView2 = ((ActivityHomeBinding) this.this$0.getMVB()).rightLineBottomUnit;
            Intrinsics.checkNotNullExpressionValue(textView2, "mVB.rightLineBottomUnit");
            TextView textView3 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBottomValue;
            Intrinsics.checkNotNullExpressionValue(textView3, "mVB.rightBottomValue");
            TextView textView4 = ((ActivityHomeBinding) this.this$0.getMVB()).rightBottomValueUnit;
            Intrinsics.checkNotNullExpressionValue(textView4, "mVB.rightBottomValueUnit");
            homeActivity.setTyreValue(textView, textView2, textView3, textView4, this.$rr.element, this.$rrValue.element);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$6", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $warningDistance;
        int label;
        final /* synthetic */ HomeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(HomeActivity homeActivity, Ref.IntRef intRef, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.this$0 = homeActivity;
            this.$warningDistance = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.this$0, this.$warningDistance, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.getMICrossCallback().onWadingDepth(String.valueOf(this.$warningDistance.element));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$7", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$getDisplayParameter$1$7, reason: invalid class name */
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $swerveAngle;
        int label;
        final /* synthetic */ HomeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(HomeActivity homeActivity, Ref.FloatRef floatRef, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.this$0 = homeActivity;
            this.$swerveAngle = floatRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.this$0, this.$swerveAngle, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.setSwerveAngle(this.$swerveAngle.element);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
