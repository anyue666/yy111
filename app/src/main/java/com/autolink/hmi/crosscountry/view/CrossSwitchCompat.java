package com.autolink.hmi.crosscountry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: classes.dex */
public class CrossSwitchCompat extends SwitchCompat {
    boolean markers;
    float slidingDistance;

    public CrossSwitchCompat(Context context) {
        super(context);
        this.markers = false;
        this.slidingDistance = 0.0f;
    }

    public CrossSwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.markers = false;
        this.slidingDistance = 0.0f;
    }

    public CrossSwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.markers = false;
        this.slidingDistance = 0.0f;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.markers = false;
            this.slidingDistance = motionEvent.getX();
        }
        if (motionEvent.getAction() == 2 && Math.abs(motionEvent.getX() - this.slidingDistance) > 10.0f) {
            this.markers = true;
            return false;
        }
        if (motionEvent.getAction() == 1 && this.markers) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }
}
