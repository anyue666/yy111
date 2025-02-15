package com.autolink.hmi.crosscountry.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChargingLottieAnimation extends AppCompatImageView {
    ValueAnimator animator;
    private ArrayList arrayList;
    private int mNameResource;
    boolean mShowFirstFrame;
    int time;

    public ChargingLottieAnimation(Context context) {
        this(context, null);
    }

    public ChargingLottieAnimation(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChargingLottieAnimation(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShowFirstFrame = false;
        this.time = 45;
        this.arrayList = new ArrayList();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GroupId);
        this.mNameResource = obtainStyledAttributes.getResourceId(3, -1);
        this.time = obtainStyledAttributes.getInt(1, 45);
        boolean z = obtainStyledAttributes.getBoolean(2, false);
        this.mShowFirstFrame = z;
        if (z) {
            setAnimationResource(this.mNameResource);
            setFirstFrame();
        }
        obtainStyledAttributes.recycle();
    }

    public void setAnimationResource(int i) {
        ValueAnimator valueAnimator;
        if (i != -1) {
            if (this.mNameResource == i && (valueAnimator = this.animator) != null && valueAnimator.isRunning()) {
                return;
            }
            if (this.animator != null) {
                onDetached();
            }
            TypedArray obtainTypedArray = getResources().obtainTypedArray(i);
            this.arrayList.clear();
            for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                int resourceId = obtainTypedArray.getResourceId(i2, 0);
                if (resourceId > 0) {
                    this.arrayList.add(Integer.valueOf(resourceId));
                }
            }
            obtainTypedArray.recycle();
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.arrayList.size() - 1);
            this.animator = ofInt;
            ofInt.setDuration(r1 * this.time);
            this.animator.setRepeatCount(-1);
            this.animator.setInterpolator(new LinearInterpolator());
            this.animator.setRepeatMode(1);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.autolink.hmi.crosscountry.view.ChargingLottieAnimation$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ChargingLottieAnimation.this.m73x3fedac6d(valueAnimator2);
                }
            });
            this.mNameResource = i;
        }
    }

    /* renamed from: lambda$setAnimationResource$0$com-autolink-hmi-crosscountry-view-ChargingLottieAnimation, reason: not valid java name */
    /* synthetic */ void m73x3fedac6d(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        LogUtils.logI("=====iui", intValue + "");
        setImageDrawable(ContextCompat.getDrawable(getContext(), ((Integer) this.arrayList.get(intValue)).intValue()));
    }

    public void setFirstFrame() {
        if (this.animator == null) {
            setAnimationResource(this.mNameResource);
        }
        ArrayList arrayList = this.arrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        try {
            setImageDrawable(ContextCompat.getDrawable(getContext(), ((Integer) this.arrayList.get(1)).intValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAnimating() {
        if (getDrawable() instanceof AnimationDrawable) {
            return ((AnimationDrawable) getDrawable()).isRunning();
        }
        return false;
    }

    public void startAnimation() {
        if (this.animator == null) {
            setAnimationResource(this.mNameResource);
        }
        setVisibility(0);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.animator.start();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDetached();
    }

    public void onDetached() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.arrayList.clear();
            this.animator = null;
        }
    }

    public void stopAnimation(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z) {
            setVisibility(8);
        } else {
            setVisibility(0);
            setFirstFrame();
        }
    }
}
