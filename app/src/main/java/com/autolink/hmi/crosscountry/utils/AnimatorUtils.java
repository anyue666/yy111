package com.autolink.hmi.crosscountry.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AnimatorUtils {
    public static void startConversion(ImageView imageView, Animation.AnimationListener animationListener) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 60.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500L);
        rotateAnimation.setAnimationListener(animationListener);
        rotateAnimation.startNow();
        imageView.setAnimation(rotateAnimation);
    }

    public static AnimatorSet startTransparency(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        ofFloat.setRepeatCount(-1);
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.start();
        return animatorSet;
    }

    public void startScaleLessen(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.5f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(animatorListener);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    public void startScaleEnlarge(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    public void startScaleAnimation(View view, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.5f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(animatorListener);
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3).before(ofFloat4);
        animatorSet.setDuration(3000L);
        animatorSet.start();
    }
}
