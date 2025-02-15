package com.landmark.res;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.autolink.adaptermanager.car.ALExtProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SimpleDialogUtil.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/Dialog;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SimpleDialogUtil$dialogSimpleConfirmLazy$1 extends Lambda implements Function0<Dialog> {
    final /* synthetic */ SimpleDialogUtil this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimpleDialogUtil$dialogSimpleConfirmLazy$1(SimpleDialogUtil simpleDialogUtil) {
        super(0);
        this.this$0 = simpleDialogUtil;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Dialog invoke() {
        Context context;
        boolean z;
        int i;
        CharSequence charSequence;
        WindowManager.LayoutParams attributes;
        int i2;
        context = this.this$0.context;
        final Dialog dialog = new Dialog(context, R.style.DialogGeneral);
        dialog.setContentView(this.this$0.getSimpleConfirmBinding().getRoot());
        z = this.this$0.cancelable;
        dialog.setCanceledOnTouchOutside(z);
        i = this.this$0.showVisibility;
        if (i != -1) {
            Window window = dialog.getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView != null) {
                i2 = this.this$0.showVisibility;
                decorView.setSystemUiVisibility(i2);
            }
        }
        final SimpleDialogUtil simpleDialogUtil = this.this$0;
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.landmark.res.SimpleDialogUtil$dialogSimpleConfirmLazy$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SimpleDialogUtil$dialogSimpleConfirmLazy$1.invoke$lambda$0(SimpleDialogUtil.this, dialog, dialogInterface);
            }
        });
        TextView textView = this.this$0.getSimpleConfirmBinding().tvMessage;
        charSequence = this.this$0.text;
        textView.setText(charSequence);
        TextView textView2 = this.this$0.getSimpleConfirmBinding().tvCancel;
        final SimpleDialogUtil simpleDialogUtil2 = this.this$0;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.landmark.res.SimpleDialogUtil$dialogSimpleConfirmLazy$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleDialogUtil$dialogSimpleConfirmLazy$1.invoke$lambda$1(SimpleDialogUtil.this, dialog, view);
            }
        });
        TextView textView3 = this.this$0.getSimpleConfirmBinding().tvConfirm;
        final SimpleDialogUtil simpleDialogUtil3 = this.this$0;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.landmark.res.SimpleDialogUtil$dialogSimpleConfirmLazy$1$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleDialogUtil$dialogSimpleConfirmLazy$1.invoke$lambda$2(SimpleDialogUtil.this, dialog, view);
            }
        });
        Window window2 = dialog.getWindow();
        if (window2 != null && (attributes = window2.getAttributes()) != null) {
            attributes.type = ALExtProperty.VEHICLE_PROPERTY_EXT_VENDOR_AIRBAG_FAIL;
            attributes.setFitInsetsTypes(0);
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setAttributes(attributes);
            }
        }
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(SimpleDialogUtil this$0, Dialog dialog, DialogInterface dialogInterface) {
        int i;
        Function1 function1;
        int i2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        i = this$0.dismissVisibility;
        if (i != -1) {
            Window window = dialog.getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView != null) {
                i2 = this$0.dismissVisibility;
                decorView.setSystemUiVisibility(i2);
            }
        }
        function1 = this$0.onDismissListener;
        if (function1 != null) {
            function1.invoke(dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(SimpleDialogUtil this$0, Dialog dialog, View view) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        function1 = this$0.onCancelClickListener;
        if (function1 != null) {
            function1.invoke(dialog);
        } else {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(SimpleDialogUtil this$0, Dialog dialog, View view) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        function1 = this$0.onConfirmClickListener;
        function1.invoke(dialog);
    }
}
