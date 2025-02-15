package com.autolink.hmi.crosscountry.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.view.AltitudeView;
import com.autolink.hmi.crosscountry.view.CrossPointAltitudeView;
import com.autolink.hmi.crosscountry.view.ScaleView;

/* loaded from: classes.dex */
public class AltitudeLayoutBindingImpl extends AltitudeLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.barometric_indicator, 1);
        sparseIntArray.put(R.id.pressure, 2);
        sparseIntArray.put(R.id.pressure_unit, 3);
        sparseIntArray.put(R.id.altitude_id_layout, 4);
        sparseIntArray.put(R.id.altitude_name, 5);
        sparseIntArray.put(R.id.altitude_number, 6);
        sparseIntArray.put(R.id.altitude_m, 7);
        sparseIntArray.put(R.id.altitude_id_01, 8);
        sparseIntArray.put(R.id.number_06, 9);
        sparseIntArray.put(R.id.altitude_id_02, 10);
        sparseIntArray.put(R.id.altitude_id_03, 11);
        sparseIntArray.put(R.id.altitude_id_04, 12);
        sparseIntArray.put(R.id.altitude_id_05, 13);
        sparseIntArray.put(R.id.altitude_id_06, 14);
        sparseIntArray.put(R.id.altitude_id_07, 15);
        sparseIntArray.put(R.id.altitude_middle_line, 16);
        sparseIntArray.put(R.id.altitude_id_08, 17);
        sparseIntArray.put(R.id.number_02, 18);
        sparseIntArray.put(R.id.altitude_id_09, 19);
        sparseIntArray.put(R.id.altitude_id_010, 20);
        sparseIntArray.put(R.id.altitude_id_011, 21);
        sparseIntArray.put(R.id.altitude_id_012, 22);
        sparseIntArray.put(R.id.altitude_id_013, 23);
        sparseIntArray.put(R.id.altitude_id_014, 24);
        sparseIntArray.put(R.id.altitude_center, 25);
        sparseIntArray.put(R.id.progressbar_style_ver, 26);
        sparseIntArray.put(R.id.auxiliary_pointer, 27);
    }

    public AltitudeLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 28, sIncludes, sViewsWithIds));
    }

    private AltitudeLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[25], (View) objArr[8], (View) objArr[20], (View) objArr[21], (View) objArr[22], (View) objArr[23], (View) objArr[24], (View) objArr[10], (View) objArr[11], (View) objArr[12], (View) objArr[13], (View) objArr[14], (View) objArr[15], (View) objArr[17], (View) objArr[19], (CrossPointAltitudeView) objArr[4], (TextView) objArr[7], (View) objArr[16], (TextView) objArr[5], (TextView) objArr[6], (ConstraintLayout) objArr[27], (ScaleView) objArr[1], (TextView) objArr[18], (TextView) objArr[9], (TextView) objArr[2], (TextView) objArr[3], (ProgressBar) objArr[26], (AltitudeView) objArr[0]);
        this.mDirtyFlags = -1L;
        this.rightTopDial.setTag(null);
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
