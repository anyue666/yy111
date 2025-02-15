package com.landmark.res;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.autolink.adaptermanager.car.ALExtProperty;
import com.autolink.carsetting.data.car.CarPageContact;
import com.landmark.res.databinding.LayoutToastBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Toast.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u0007J4\u0010%\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u0004J4\u0010%\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010*\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b \u0010!¨\u0006,"}, d2 = {"Lcom/landmark/res/Toast;", "", "()V", "LENGTH_LONG", "", "LENGTH_SHORT", "context", "Landroid/content/Context;", "dismiss", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "heightMeasureSpec", "isShowing", "", "()Z", "setShowing", "(Z)V", "layoutToastBinding", "Lcom/landmark/res/databinding/LayoutToastBinding;", "getLayoutToastBinding", "()Lcom/landmark/res/databinding/LayoutToastBinding;", "layoutToastBinding$delegate", "Lkotlin/Lazy;", "params", "Landroid/view/WindowManager$LayoutParams;", "getParams", "()Landroid/view/WindowManager$LayoutParams;", "params$delegate", "widthMeasureSpec", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "", "init", "show", "text", "", "leftDrawableRes", "showNormalLeftDrawable", TypedValues.TransitionType.S_DURATION, "resId", "LibT1JPublicRes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Toast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static Context context;
    private static volatile boolean isShowing;
    public static final Toast INSTANCE = new Toast();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final Runnable dismiss = new Runnable() { // from class: com.landmark.res.Toast$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            Toast.dismiss$lambda$0();
        }
    };

    /* renamed from: params$delegate, reason: from kotlin metadata */
    private static final Lazy params = LazyKt.lazy(new Function0<WindowManager.LayoutParams>() { // from class: com.landmark.res.Toast$params$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WindowManager.LayoutParams invoke() {
            Context context2;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AIRBAG_FAIL;
            layoutParams.flags = 264;
            layoutParams.format = -3;
            layoutParams.gravity = 49;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.x = 0;
            layoutParams.setFitInsetsTypes(0);
            context2 = Toast.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            layoutParams.y = (int) (context2.getResources().getDimension(R.dimen.dp16) + 0.5f);
            return layoutParams;
        }
    });

    /* renamed from: layoutToastBinding$delegate, reason: from kotlin metadata */
    private static final Lazy layoutToastBinding = LazyKt.lazy(new Function0<LayoutToastBinding>() { // from class: com.landmark.res.Toast$layoutToastBinding$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutToastBinding invoke() {
            Context context2;
            context2 = Toast.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            LayoutToastBinding bind = LayoutToastBinding.bind(View.inflate(context2, R.layout.layout_toast, null));
            Intrinsics.checkNotNullExpressionValue(bind, "bind(View.inflate(contex…yout.layout_toast, null))");
            return bind;
        }
    });

    /* renamed from: windowManager$delegate, reason: from kotlin metadata */
    private static final Lazy windowManager = LazyKt.lazy(new Function0<WindowManager>() { // from class: com.landmark.res.Toast$windowManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WindowManager invoke() {
            Context context2;
            context2 = Toast.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            Object systemService = context2.getApplicationContext().getSystemService(CarPageContact.WINDOW);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            return (WindowManager) systemService;
        }
    });
    private static final int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(1920, Integer.MIN_VALUE);
    private static final int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(1080, Integer.MIN_VALUE);

    private Toast() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$0() {
        Toast toast = INSTANCE;
        toast.getWindowManager().removeView(toast.getLayoutToastBinding().getRoot());
        isShowing = false;
    }

    private final WindowManager.LayoutParams getParams() {
        return (WindowManager.LayoutParams) params.getValue();
    }

    public final void init(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        if (context == null) {
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            context = applicationContext;
        }
    }

    private final LayoutToastBinding getLayoutToastBinding() {
        return (LayoutToastBinding) layoutToastBinding.getValue();
    }

    private final WindowManager getWindowManager() {
        return (WindowManager) windowManager.getValue();
    }

    public final boolean isShowing() {
        return isShowing;
    }

    public final void setShowing(boolean z) {
        isShowing = z;
    }

    public static /* synthetic */ void show$default(Toast toast, Context context2, CharSequence charSequence, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = -1;
        }
        toast.show(context2, charSequence, i, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? 0 : i2);
    }

    public final synchronized void show(final Context context2, final CharSequence text, final int leftDrawableRes, final boolean showNormalLeftDrawable, int duration) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        if (context == null) {
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            context = applicationContext;
        }
        if (!isShowing) {
            isShowing = true;
            handler.post(new Runnable() { // from class: com.landmark.res.Toast$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.show$lambda$1();
                }
            });
        }
        Handler handler2 = handler;
        handler2.post(new Runnable() { // from class: com.landmark.res.Toast$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Toast.show$lambda$2(context2, text, leftDrawableRes, showNormalLeftDrawable);
            }
        });
        Runnable runnable = dismiss;
        handler2.removeCallbacks(runnable);
        handler2.postDelayed(runnable, duration == 0 ? 2000L : 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1() {
        Toast toast = INSTANCE;
        toast.getWindowManager().addView(toast.getLayoutToastBinding().getRoot(), toast.getParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(Context context2, CharSequence text, int i, boolean z) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(context2, "$context");
        Intrinsics.checkNotNullParameter(text, "$text");
        Toast toast = INSTANCE;
        toast.getLayoutToastBinding().flContent.setBackground(AppCompatResources.getDrawable(context2, R.drawable.shape_toast_bg_radius12));
        toast.getLayoutToastBinding().tvContent.setTextColor(context2.getColor(R.color.colorText));
        toast.getLayoutToastBinding().tvContent.setText(text);
        if (i != -1) {
            drawable = AppCompatResources.getDrawable(context2, i);
            Intrinsics.checkNotNull(drawable);
        } else if (z) {
            drawable = AppCompatResources.getDrawable(context2, R.drawable.vector_icon_success);
            Intrinsics.checkNotNull(drawable);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        toast.getLayoutToastBinding().tvContent.setCompoundDrawables(drawable, null, null, null);
        toast.getWindowManager().updateViewLayout(toast.getLayoutToastBinding().getRoot(), toast.getParams());
    }

    public static /* synthetic */ void show$default(Toast toast, Context context2, int i, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = -1;
        }
        toast.show(context2, i, i2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? 0 : i3);
    }

    public final void show(Context context2, int resId, int leftDrawableRes, boolean showNormalLeftDrawable, int duration) {
        Intrinsics.checkNotNullParameter(context2, "context");
        String string = context2.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        show(context2, string, leftDrawableRes, showNormalLeftDrawable, duration);
    }

    public final synchronized void dismiss() {
        if (isShowing) {
            Handler handler2 = handler;
            Runnable runnable = dismiss;
            handler2.removeCallbacks(runnable);
            handler2.post(runnable);
        }
    }
}
