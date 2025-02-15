package com.autolink.hmi.crosscountry.ui;

import com.autolink.adaptermanager.clusterinteraction.ALClusterInteractionManager;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$mICrossCallback$1$onDifferentialLock$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class HomeActivity$mICrossCallback$1$onDifferentialLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeActivity$mICrossCallback$1$onDifferentialLock$1(HomeActivity homeActivity, String str, Continuation<? super HomeActivity$mICrossCallback$1$onDifferentialLock$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
        this.$msg = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$mICrossCallback$1$onDifferentialLock$1(this.this$0, this.$msg, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$mICrossCallback$1$onDifferentialLock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object tag = ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.getTag();
        if (tag != null && tag.equals(this.$msg)) {
            return Unit.INSTANCE;
        }
        Object tag2 = ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.getTag();
        if (tag2 != null && tag2.equals(this.$msg)) {
            return Unit.INSTANCE;
        }
        String property = CrossAllUtils.getProperty(CrossAllUtils.POWER_KEY);
        str = this.this$0.TAG;
        LogUtils.logI(str, "powerId " + property);
        if (property.equals("2") && CrossAllUtils.isDriveTypeFour()) {
            if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.ELSD_LOCK_STATUS_OPEN_1.getNumber())) || this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.ELSD_LOCK_STATUS_OPEN_2.getNumber()))) {
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setVisibility(0);
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setImageDrawable(this.this$0.getDrawable(R.drawable.differential_lock_open));
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setTag(this.$msg);
            }
            if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.PHEV_ELSD_LOCK_STATUS_CLOSE_1.getNumber())) || this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.PHEV_ELSD_LOCK_STATUS_CLOSE_2.getNumber())) || this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.PHEV_ELSD_LOCK_STATUS_CLOSE_3.getNumber()))) {
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setVisibility(0);
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setImageDrawable(this.this$0.getDrawable(R.drawable.differential_lock_close));
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setTag(this.$msg);
            }
            if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.PHEV_ELSD_LOCK_STATUS_NO_DISPLAY.getNumber()))) {
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setVisibility(8);
                ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setTag(this.$msg);
            }
            return Unit.INSTANCE;
        }
        if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.ELSD_LOCK_STATUS_CLOSE.getNumber()))) {
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setVisibility(0);
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setImageDrawable(this.this$0.getDrawable(R.drawable.differential_lock_close));
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setTag(this.$msg);
        }
        if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.ELSD_LOCK_STATUS_OPEN.getNumber()))) {
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setVisibility(0);
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setImageDrawable(this.this$0.getDrawable(R.drawable.differential_lock_open));
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setTag(this.$msg);
        }
        if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.ELSD_LOCK_STATUS_NO_DISPLAY.getNumber()))) {
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setVisibility(8);
            ((ActivityHomeBinding) this.this$0.getMVB()).rearAxleLock.setTag(this.$msg);
        }
        if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.AWD_LOCK_STATUS_CLOSE.getNumber()))) {
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setVisibility(0);
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setImageDrawable(this.this$0.getDrawable(R.drawable.differential_lock_close));
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setTag(this.$msg);
            ((ActivityHomeBinding) this.this$0.getMVB()).fourZoneWheel.startAnimation();
        }
        if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.AWD_LOCK_STATUS_OPEN.getNumber()))) {
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setVisibility(0);
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setImageDrawable(this.this$0.getDrawable(R.drawable.differential_lock_open));
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setTag(this.$msg);
            ((ActivityHomeBinding) this.this$0.getMVB()).fourZoneWheel.stopAnimation(false);
        }
        if (this.$msg.equals(String.valueOf(ALClusterInteractionManager.TorqueLockStatus.AWD_LOCK_STATUS_NO_DISPLAY.getNumber()))) {
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setVisibility(8);
            ((ActivityHomeBinding) this.this$0.getMVB()).frontAxleLock.setTag(this.$msg);
            ((ActivityHomeBinding) this.this$0.getMVB()).fourZoneWheel.stopAnimation(false);
        }
        return Unit.INSTANCE;
    }
}
