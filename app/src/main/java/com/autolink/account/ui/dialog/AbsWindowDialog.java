package com.autolink.account.ui.dialog;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsWindowDialog.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0006\u0010\u001c\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001aH&J\b\u0010\u001e\u001a\u00020\u001aH&R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/autolink/account/ui/dialog/AbsWindowDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dialogView", "Landroid/view/View;", "getDialogView", "()Landroid/view/View;", "setDialogView", "(Landroid/view/View;)V", "isTranslucent", "", "()Z", "mLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "getMLayoutParams", "()Landroid/view/WindowManager$LayoutParams;", "mLayoutParams$delegate", "Lkotlin/Lazy;", "windowManager", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager$delegate", "dismiss", "", "onCreateView", "show", "windowDismiss", "windowShow", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AbsWindowDialog {
    private View dialogView;
    private final boolean isTranslucent;

    /* renamed from: mLayoutParams$delegate, reason: from kotlin metadata */
    private final Lazy mLayoutParams;

    /* renamed from: windowManager$delegate, reason: from kotlin metadata */
    private final Lazy windowManager;

    public abstract View onCreateView(Context context);

    public abstract void windowDismiss();

    public abstract void windowShow();

    public AbsWindowDialog(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.windowManager = LazyKt.lazy(new Function0<WindowManager>() { // from class: com.autolink.account.ui.dialog.AbsWindowDialog$windowManager$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WindowManager invoke() {
                Object systemService = context.getSystemService((Class<Object>) WindowManager.class);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                return (WindowManager) systemService;
            }
        });
        this.isTranslucent = true;
        this.mLayoutParams = LazyKt.lazy(new Function0<WindowManager.LayoutParams>() { // from class: com.autolink.account.ui.dialog.AbsWindowDialog$mLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WindowManager.LayoutParams invoke() {
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.type = 2046;
                layoutParams.flags = 264;
                layoutParams.format = -3;
                layoutParams.gravity = 49;
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.x = 0;
                layoutParams.setFitInsetsTypes(0);
                layoutParams.y = 0;
                return layoutParams;
            }
        });
        this.dialogView = onCreateView(context);
        getIsTranslucent();
    }

    public final View getDialogView() {
        return this.dialogView;
    }

    public final void setDialogView(View view) {
        this.dialogView = view;
    }

    public final WindowManager getWindowManager() {
        return (WindowManager) this.windowManager.getValue();
    }

    /* renamed from: isTranslucent, reason: from getter */
    public boolean getIsTranslucent() {
        return this.isTranslucent;
    }

    private final WindowManager.LayoutParams getMLayoutParams() {
        return (WindowManager.LayoutParams) this.mLayoutParams.getValue();
    }

    public final void show() {
        if (this.dialogView != null) {
            getWindowManager().addView(this.dialogView, getMLayoutParams());
        }
        windowShow();
    }

    public final void dismiss() {
        View view = this.dialogView;
        if (view != null && view != null) {
            getWindowManager().removeView(this.dialogView);
            this.dialogView = null;
        }
        windowDismiss();
    }
}
