package com.autolink.hmi.crosscountry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;

/* loaded from: classes.dex */
public abstract class ActivityMainBinding extends ViewDataBinding {
    public final LinearLayout bottomBtItem;
    public final ConstraintLayout centerConstraint;
    public final ImageView crossAltitudeIcon;
    public final TextView crossAltitudeInfo;
    public final ImageView crossClose;
    public final ImageView crossPressureIcon;
    public final TextView crossPressureInfo;
    public final ConstraintLayout liftBottomConstraint;
    public final ConstraintLayout liftTopConstraint;
    public final ConstraintLayout rightBottomConstraint;
    public final ConstraintLayout rightTopConstraint;

    protected ActivityMainBinding(Object obj, View view, int i, LinearLayout linearLayout, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, TextView textView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5) {
        super(obj, view, i);
        this.bottomBtItem = linearLayout;
        this.centerConstraint = constraintLayout;
        this.crossAltitudeIcon = imageView;
        this.crossAltitudeInfo = textView;
        this.crossClose = imageView2;
        this.crossPressureIcon = imageView3;
        this.crossPressureInfo = textView2;
        this.liftBottomConstraint = constraintLayout2;
        this.liftTopConstraint = constraintLayout3;
        this.rightBottomConstraint = constraintLayout4;
        this.rightTopConstraint = constraintLayout5;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, viewGroup, z, obj);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, null, false, obj);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object obj) {
        return (ActivityMainBinding) bind(obj, view, R.layout.activity_main);
    }
}
