package com.autolink.hmi.crosscountry.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.autolink.hmi.crosscountry.view.CrossSwitchCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelayRecoveryUtils.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/autolink/hmi/crosscountry/utils/DelayRecoveryUtils;", "", "()V", "mHandler", "Landroid/os/Handler;", "cancelTask", "", "key", "", "postCheckTask", "v", "Lcom/autolink/hmi/crosscountry/view/CrossSwitchCompat;", "setEnable", "isEnable", "", "Companion", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DelayRecoveryUtils {
    private static final long DELAY_CHECK_TIME = 2500;
    private static final String TAG = "DelayRecoveryUtils";
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<DelayRecoveryUtils> instance$delegate = LazyKt.lazy(new Function0<DelayRecoveryUtils>() { // from class: com.autolink.hmi.crosscountry.utils.DelayRecoveryUtils$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DelayRecoveryUtils invoke() {
            return new DelayRecoveryUtils();
        }
    });

    /* compiled from: DelayRecoveryUtils.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/autolink/hmi/crosscountry/utils/DelayRecoveryUtils$Companion;", "", "()V", "DELAY_CHECK_TIME", "", "TAG", "", "instance", "Lcom/autolink/hmi/crosscountry/utils/DelayRecoveryUtils;", "getInstance", "()Lcom/autolink/hmi/crosscountry/utils/DelayRecoveryUtils;", "instance$delegate", "Lkotlin/Lazy;", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DelayRecoveryUtils getInstance() {
            return (DelayRecoveryUtils) DelayRecoveryUtils.instance$delegate.getValue();
        }
    }

    public final void setEnable(CrossSwitchCompat v, boolean isEnable, int key) {
        Intrinsics.checkNotNullParameter(v, "v");
        v.setEnabled(isEnable);
        if (isEnable) {
            cancelTask(key);
        } else {
            postCheckTask(v, key);
        }
    }

    private final void postCheckTask(final CrossSwitchCompat v, final int key) {
        Log.i(TAG, "postCheckTask key:" + key + " handle.idle:" + this.mHandler.getLooper().getQueue().isIdle());
        this.mHandler.postDelayed(new Runnable() { // from class: com.autolink.hmi.crosscountry.utils.DelayRecoveryUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DelayRecoveryUtils.postCheckTask$lambda$0(key, v);
            }
        }, key, DELAY_CHECK_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postCheckTask$lambda$0(int i, CrossSwitchCompat v) {
        Intrinsics.checkNotNullParameter(v, "$v");
        Log.i(TAG, "run check task key:" + i);
        v.setEnabled(true);
        v.setChecked(true ^ v.isChecked());
    }

    private final void cancelTask(int key) {
        Log.i(TAG, "cancelTask key:" + key);
        this.mHandler.removeMessages(key);
    }
}
