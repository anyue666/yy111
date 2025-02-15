package com.autolink.hmi.crosscountry.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;

/* loaded from: classes.dex */
public abstract class DrivingModeDialogLayoutBinding extends ViewDataBinding {
    public final ImageView carImg;
    public final CardView carImgLayout;
    public final ImageView icClose;
    public final TextView info;
    public final TextView name;
    public final TextureView textureView;

    protected DrivingModeDialogLayoutBinding(Object obj, View view, int i, ImageView imageView, CardView cardView, ImageView imageView2, TextView textView, TextView textView2, TextureView textureView) {
        super(obj, view, i);
        this.carImg = imageView;
        this.carImgLayout = cardView;
        this.icClose = imageView2;
        this.info = textView;
        this.name = textView2;
        this.textureView = textureView;
    }

    public static DrivingModeDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DrivingModeDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DrivingModeDialogLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.driving_mode_dialog_layout, viewGroup, z, obj);
    }

    public static DrivingModeDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DrivingModeDialogLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DrivingModeDialogLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.driving_mode_dialog_layout, null, false, obj);
    }

    public static DrivingModeDialogLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DrivingModeDialogLayoutBinding bind(View view, Object obj) {
        return (DrivingModeDialogLayoutBinding) bind(obj, view, R.layout.driving_mode_dialog_layout);
    }
}
