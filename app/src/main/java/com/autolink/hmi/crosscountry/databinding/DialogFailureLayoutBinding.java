package com.autolink.hmi.crosscountry.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;

/* loaded from: classes.dex */
public abstract class DialogFailureLayoutBinding extends ViewDataBinding {
    public final TextView cancel;
    public final ImageView icon;
    public final TextView title;

    protected DialogFailureLayoutBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.cancel = textView;
        this.icon = imageView;
        this.title = textView2;
    }

    public static DialogFailureLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFailureLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFailureLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_failure_layout, viewGroup, z, obj);
    }

    public static DialogFailureLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFailureLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFailureLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_failure_layout, null, false, obj);
    }

    public static DialogFailureLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogFailureLayoutBinding bind(View view, Object obj) {
        return (DialogFailureLayoutBinding) bind(obj, view, R.layout.dialog_failure_layout);
    }
}
