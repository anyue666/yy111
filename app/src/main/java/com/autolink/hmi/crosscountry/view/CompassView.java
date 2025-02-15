package com.autolink.hmi.crosscountry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewOverlay;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class CompassView extends ConstraintLayout {
    CrossPointAltitudeView mCrossPointAltitudeView;

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public CompassView(Context context) {
        this(context, null);
    }

    public CompassView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CompassView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void refreshAngle(float f) {
        setRotation(f);
        postInvalidate();
    }
}
