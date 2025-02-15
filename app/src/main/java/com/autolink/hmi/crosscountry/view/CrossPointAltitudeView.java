package com.autolink.hmi.crosscountry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autolink.hmi.crosscountry.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CrossPointAltitudeView.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/autolink/hmi/crosscountry/view/CrossPointAltitudeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setAltitude", "", TypedValues.Custom.S_FLOAT, "", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CrossPointAltitudeView extends ConstraintLayout {
    public /* synthetic */ CrossPointAltitudeView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossPointAltitudeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNull(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossPointAltitudeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
    }

    public final void setAltitude(float r5) {
        View findViewById = findViewById(R.id.altitude_number);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText("" + ((int) r5));
        View findViewById2 = findViewById(R.id.progressbar_style_ver);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        ProgressBar progressBar = (ProgressBar) findViewById2;
        View findViewById3 = findViewById(R.id.altitude_id_layout);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.autolink.hmi.crosscountry.view.CrossPointAltitudeView");
        int height = ((CrossPointAltitudeView) findViewById3).getHeight() - progressBar.getBottom();
        progressBar.setMax(7000);
        progressBar.setProgress((int) (r5 + 1000));
        float height2 = progressBar.getHeight() / (progressBar.getMax() / progressBar.getProgress());
        View findViewById4 = findViewById(R.id.auxiliary_pointer);
        ViewGroup.LayoutParams layoutParams = findViewById4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = (int) ((height - (findViewById4.getHeight() / 2)) + height2);
        findViewById4.setLayoutParams(layoutParams2);
    }
}
