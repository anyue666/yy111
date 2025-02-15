package com.autolink.hmi.crosscountry.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.view.CompassView;

/* loaded from: classes.dex */
public class CompassBearingLayoutBindingImpl extends CompassBearingLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.compass_view, 1);
        sparseIntArray.put(R.id.bearing_tex_01, 2);
        sparseIntArray.put(R.id.bearing_icon_01, 3);
        sparseIntArray.put(R.id.bearing_icon_02, 4);
        sparseIntArray.put(R.id.bearing_tex_02, 5);
        sparseIntArray.put(R.id.bearing_tex_03, 6);
        sparseIntArray.put(R.id.bearing_icon_03, 7);
        sparseIntArray.put(R.id.bearing_icon_04, 8);
        sparseIntArray.put(R.id.bearing_tex_04, 9);
    }

    public CompassBearingLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private CompassBearingLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[7], (ImageView) objArr[8], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[9], (CompassView) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
