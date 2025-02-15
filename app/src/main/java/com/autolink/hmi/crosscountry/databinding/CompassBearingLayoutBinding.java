package com.autolink.hmi.crosscountry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.view.CompassView;

/* loaded from: classes.dex */
public abstract class CompassBearingLayoutBinding extends ViewDataBinding {
    public final ImageView bearingIcon01;
    public final ImageView bearingIcon02;
    public final ImageView bearingIcon03;
    public final ImageView bearingIcon04;
    public final TextView bearingTex01;
    public final TextView bearingTex02;
    public final TextView bearingTex03;
    public final TextView bearingTex04;
    public final CompassView compassView;

    protected CompassBearingLayoutBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, CompassView compassView) {
        super(obj, view, i);
        this.bearingIcon01 = imageView;
        this.bearingIcon02 = imageView2;
        this.bearingIcon03 = imageView3;
        this.bearingIcon04 = imageView4;
        this.bearingTex01 = textView;
        this.bearingTex02 = textView2;
        this.bearingTex03 = textView3;
        this.bearingTex04 = textView4;
        this.compassView = compassView;
    }

    public static CompassBearingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompassBearingLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CompassBearingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compass_bearing_layout, viewGroup, z, obj);
    }

    public static CompassBearingLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompassBearingLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CompassBearingLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.compass_bearing_layout, null, false, obj);
    }

    public static CompassBearingLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CompassBearingLayoutBinding bind(View view, Object obj) {
        return (CompassBearingLayoutBinding) bind(obj, view, R.layout.compass_bearing_layout);
    }
}
