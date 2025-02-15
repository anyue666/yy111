package com.autolink.hmi.crosscountry.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;

/* loaded from: classes.dex */
public class ActivityMainBindingImpl extends ActivityMainBinding {
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
        sparseIntArray.put(R.id.cross_close, 1);
        sparseIntArray.put(R.id.cross_pressure_icon, 2);
        sparseIntArray.put(R.id.cross_pressure_info, 3);
        sparseIntArray.put(R.id.cross_altitude_icon, 4);
        sparseIntArray.put(R.id.cross_altitude_info, 5);
        sparseIntArray.put(R.id.lift_top_constraint, 6);
        sparseIntArray.put(R.id.lift_bottom_constraint, 7);
        sparseIntArray.put(R.id.right_top_constraint, 8);
        sparseIntArray.put(R.id.center_constraint, 9);
        sparseIntArray.put(R.id.right_bottom_constraint, 10);
        sparseIntArray.put(R.id.bottom_bt_item, 11);
    }

    public ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ActivityMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[11], (ConstraintLayout) objArr[9], (ImageView) objArr[4], (TextView) objArr[5], (ImageView) objArr[1], (ImageView) objArr[2], (TextView) objArr[3], (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[8]);
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
