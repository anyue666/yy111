package com.autolink.hmi.crosscountry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.view.AltitudeView;
import com.autolink.hmi.crosscountry.view.CrossPointAltitudeView;
import com.autolink.hmi.crosscountry.view.ScaleView;

/* loaded from: classes.dex */
public abstract class AltitudeLayoutBinding extends ViewDataBinding {
    public final View altitudeCenter;
    public final View altitudeId01;
    public final View altitudeId010;
    public final View altitudeId011;
    public final View altitudeId012;
    public final View altitudeId013;
    public final View altitudeId014;
    public final View altitudeId02;
    public final View altitudeId03;
    public final View altitudeId04;
    public final View altitudeId05;
    public final View altitudeId06;
    public final View altitudeId07;
    public final View altitudeId08;
    public final View altitudeId09;
    public final CrossPointAltitudeView altitudeIdLayout;
    public final TextView altitudeM;
    public final View altitudeMiddleLine;
    public final TextView altitudeName;
    public final TextView altitudeNumber;
    public final ConstraintLayout auxiliaryPointer;
    public final ScaleView barometricIndicator;
    public final TextView number02;
    public final TextView number06;
    public final TextView pressure;
    public final TextView pressureUnit;
    public final ProgressBar progressbarStyleVer;
    public final AltitudeView rightTopDial;

    protected AltitudeLayoutBinding(Object obj, View view, int i, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, View view10, View view11, View view12, View view13, View view14, View view15, View view16, CrossPointAltitudeView crossPointAltitudeView, TextView textView, View view17, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, ScaleView scaleView, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ProgressBar progressBar, AltitudeView altitudeView) {
        super(obj, view, i);
        this.altitudeCenter = view2;
        this.altitudeId01 = view3;
        this.altitudeId010 = view4;
        this.altitudeId011 = view5;
        this.altitudeId012 = view6;
        this.altitudeId013 = view7;
        this.altitudeId014 = view8;
        this.altitudeId02 = view9;
        this.altitudeId03 = view10;
        this.altitudeId04 = view11;
        this.altitudeId05 = view12;
        this.altitudeId06 = view13;
        this.altitudeId07 = view14;
        this.altitudeId08 = view15;
        this.altitudeId09 = view16;
        this.altitudeIdLayout = crossPointAltitudeView;
        this.altitudeM = textView;
        this.altitudeMiddleLine = view17;
        this.altitudeName = textView2;
        this.altitudeNumber = textView3;
        this.auxiliaryPointer = constraintLayout;
        this.barometricIndicator = scaleView;
        this.number02 = textView4;
        this.number06 = textView5;
        this.pressure = textView6;
        this.pressureUnit = textView7;
        this.progressbarStyleVer = progressBar;
        this.rightTopDial = altitudeView;
    }

    public static AltitudeLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AltitudeLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AltitudeLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.altitude_layout, viewGroup, z, obj);
    }

    public static AltitudeLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AltitudeLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AltitudeLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.altitude_layout, null, false, obj);
    }

    public static AltitudeLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AltitudeLayoutBinding bind(View view, Object obj) {
        return (AltitudeLayoutBinding) bind(obj, view, R.layout.altitude_layout);
    }
}
