package com.landmark.res;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.landmark.res.databinding.DialogSimpleConfirmBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleDialogUtil.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\rJ\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u001c\u0010'\u001a\u00020\t2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007J\u001c\u0010)\u001a\u00020\t2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007J\u0016\u0010*\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010+\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/landmark/res/SimpleDialogUtil;", "", "context", "Landroid/content/Context;", "resId", "", "onConfirmClickListener", "Lkotlin/Function1;", "Landroid/app/Dialog;", "", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)V", "text", "", "(Landroid/content/Context;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)V", "cancelable", "", "dialogSimpleConfirm", "getDialogSimpleConfirm$delegate", "(Lcom/landmark/res/SimpleDialogUtil;)Ljava/lang/Object;", "getDialogSimpleConfirm", "()Landroid/app/Dialog;", "dialogSimpleConfirmLazy", "Lkotlin/Lazy;", "getDialogSimpleConfirmLazy$annotations", "()V", "dismissVisibility", "onCancelClickListener", "onDismissListener", "showVisibility", "simpleConfirmBinding", "Lcom/landmark/res/databinding/DialogSimpleConfirmBinding;", "getSimpleConfirmBinding", "()Lcom/landmark/res/databinding/DialogSimpleConfirmBinding;", "simpleConfirmBinding$delegate", "Lkotlin/Lazy;", "disMiss", "setCanceledOnTouchOutside", "cancel", "setMessage", "setOnCancelClickListener", "listener", "setOnDismissListener", "setSystemUiVisibility", "setTitle", "show", "LibT1JPublicRes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SimpleDialogUtil {
    private boolean cancelable;
    private final Context context;
    private final Lazy<Dialog> dialogSimpleConfirmLazy;
    private int dismissVisibility;
    private Function1<? super Dialog, Unit> onCancelClickListener;
    private final Function1<Dialog, Unit> onConfirmClickListener;
    private Function1<? super Dialog, Unit> onDismissListener;
    private int showVisibility;

    /* renamed from: simpleConfirmBinding$delegate, reason: from kotlin metadata */
    private final Lazy simpleConfirmBinding;
    private final CharSequence text;

    private static /* synthetic */ void getDialogSimpleConfirmLazy$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleDialogUtil(Context context, CharSequence text, Function1<? super Dialog, Unit> onConfirmClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onConfirmClickListener, "onConfirmClickListener");
        this.context = context;
        this.text = text;
        this.onConfirmClickListener = onConfirmClickListener;
        this.cancelable = true;
        this.showVisibility = -1;
        this.dismissVisibility = -1;
        this.simpleConfirmBinding = LazyKt.lazy(new Function0<DialogSimpleConfirmBinding>() { // from class: com.landmark.res.SimpleDialogUtil$simpleConfirmBinding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DialogSimpleConfirmBinding invoke() {
                Context context2;
                context2 = SimpleDialogUtil.this.context;
                DialogSimpleConfirmBinding bind = DialogSimpleConfirmBinding.bind(View.inflate(context2, R.layout.dialog_simple_confirm, null));
                Intrinsics.checkNotNullExpressionValue(bind, "bind(View.inflate(contex…og_simple_confirm, null))");
                return bind;
            }
        });
        this.dialogSimpleConfirmLazy = LazyKt.lazy(new SimpleDialogUtil$dialogSimpleConfirmLazy$1(this));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SimpleDialogUtil(android.content.Context r2, int r3, kotlin.jvm.functions.Function1<? super android.app.Dialog, kotlin.Unit> r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onConfirmClickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.CharSequence r3 = r2.getText(r3)
            java.lang.String r0 = "context.getText(resId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.landmark.res.SimpleDialogUtil.<init>(android.content.Context, int, kotlin.jvm.functions.Function1):void");
    }

    public final DialogSimpleConfirmBinding getSimpleConfirmBinding() {
        return (DialogSimpleConfirmBinding) this.simpleConfirmBinding.getValue();
    }

    public final Dialog getDialogSimpleConfirm() {
        return this.dialogSimpleConfirmLazy.getValue();
    }

    public final void setSystemUiVisibility(int showVisibility, int dismissVisibility) {
        this.showVisibility = showVisibility;
        this.dismissVisibility = dismissVisibility;
    }

    public final void setOnDismissListener(Function1<? super Dialog, Unit> listener) {
        this.onDismissListener = listener;
    }

    public final void setCanceledOnTouchOutside(boolean cancel) {
        this.cancelable = cancel;
        if (this.dialogSimpleConfirmLazy.isInitialized()) {
            getDialogSimpleConfirm().setCanceledOnTouchOutside(cancel);
        }
    }

    public final void setMessage(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        getSimpleConfirmBinding().tvMessage.setText(text);
    }

    public final void setMessage(int resId) {
        getSimpleConfirmBinding().tvMessage.setText(resId);
    }

    public final void setTitle(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        getSimpleConfirmBinding().tvTitle.setText(text);
    }

    public final void setTitle(int resId) {
        getSimpleConfirmBinding().tvTitle.setText(resId);
    }

    public final void setOnCancelClickListener(Function1<? super Dialog, Unit> listener) {
        this.onCancelClickListener = listener;
    }

    public final void show() {
        if (getDialogSimpleConfirm().isShowing()) {
            return;
        }
        getDialogSimpleConfirm().show();
    }

    public final void disMiss() {
        if (getDialogSimpleConfirm().isShowing()) {
            getDialogSimpleConfirm().dismiss();
        }
    }
}
