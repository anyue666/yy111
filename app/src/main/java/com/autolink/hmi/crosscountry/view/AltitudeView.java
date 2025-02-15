package com.autolink.hmi.crosscountry.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewOverlay;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autolink.hmi.crosscountry.R;

/* loaded from: classes.dex */
public class AltitudeView extends ConstraintLayout {
    ScaleView mBarometricIndicator;
    CrossPointAltitudeView mCrossPointAltitudeView;

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public AltitudeView(Context context) {
        this(context, null);
    }

    public AltitudeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        initView();
    }

    public AltitudeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void refreshAngle(float f) {
        setRotation(f);
        postInvalidate();
    }

    public void setAltitude(float f) {
        CrossPointAltitudeView crossPointAltitudeView = this.mCrossPointAltitudeView;
        if (crossPointAltitudeView != null) {
            crossPointAltitudeView.setAltitude(f);
        }
    }

    public void setAirPressure(float f) {
        ScaleView scaleView = this.mBarometricIndicator;
        if (scaleView != null) {
            scaleView.refreshAngle(f - 15.0f);
        }
    }

    private void initView() {
        post(new Runnable() { // from class: com.autolink.hmi.crosscountry.view.AltitudeView.1
            @Override // java.lang.Runnable
            public void run() {
                AltitudeView altitudeView = AltitudeView.this;
                altitudeView.mCrossPointAltitudeView = (CrossPointAltitudeView) altitudeView.findViewById(R.id.altitude_id_layout);
                AltitudeView altitudeView2 = AltitudeView.this;
                altitudeView2.mBarometricIndicator = (ScaleView) altitudeView2.findViewById(R.id.barometric_indicator);
            }
        });
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
