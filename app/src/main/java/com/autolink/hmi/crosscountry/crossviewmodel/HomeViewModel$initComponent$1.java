package com.autolink.hmi.crosscountry.crossviewmodel;

import com.autolink.hmi.crosscountry.crossinterface.CrossPressureListener;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import com.autolink.hmi.crosscountry.utils.networkutils.AtmosphericUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.crossviewmodel.HomeViewModel$initComponent$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeViewModel$initComponent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$initComponent$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$initComponent$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$initComponent$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$initComponent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AtmosphericUtils.getInstance().getAcquiredPressure(new CrossPressureListener() { // from class: com.autolink.hmi.crosscountry.crossviewmodel.HomeViewModel$initComponent$1.1
            AnonymousClass1() {
            }

            @Override // com.autolink.hmi.crosscountry.crossinterface.CrossPressureListener
            public void onPressure(String pressure) {
                LogUtils.logI("getAcquiredPressure", "pressure" + pressure);
                if (pressure == null || pressure.equals("")) {
                    return;
                }
                if (Integer.parseInt(pressure) > 0) {
                    HomeViewModel.this.getAirPressure().postValue("" + (Float.parseFloat(pressure) / 10));
                } else {
                    HomeViewModel.this.getAirPressure().postValue(pressure);
                }
            }
        });
        return Unit.INSTANCE;
    }

    /* compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/autolink/hmi/crosscountry/crossviewmodel/HomeViewModel$initComponent$1$1", "Lcom/autolink/hmi/crosscountry/crossinterface/CrossPressureListener;", "onPressure", "", "pressure", "", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.autolink.hmi.crosscountry.crossviewmodel.HomeViewModel$initComponent$1$1 */
    public static final class AnonymousClass1 implements CrossPressureListener {
        AnonymousClass1() {
        }

        @Override // com.autolink.hmi.crosscountry.crossinterface.CrossPressureListener
        public void onPressure(String pressure) {
            LogUtils.logI("getAcquiredPressure", "pressure" + pressure);
            if (pressure == null || pressure.equals("")) {
                return;
            }
            if (Integer.parseInt(pressure) > 0) {
                HomeViewModel.this.getAirPressure().postValue("" + (Float.parseFloat(pressure) / 10));
            } else {
                HomeViewModel.this.getAirPressure().postValue(pressure);
            }
        }
    }
}
