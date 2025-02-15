package com.autolink.hmi.crosscountry.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.view.ChargingLottieAnimation;
import com.autolink.hmi.crosscountry.view.CrossSwitchCompat;
import com.autolink.hmi.crosscountry.view.WadingDepthView;

/* loaded from: classes.dex */
public class ActivityHomeBindingImpl extends ActivityHomeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(59);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"compass_bearing_layout", "altitude_layout"}, new int[]{1, 2}, new int[]{R.layout.compass_bearing_layout, R.layout.altitude_layout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cross_close, 3);
        sparseIntArray.put(R.id.cross_pressure_icon, 4);
        sparseIntArray.put(R.id.cross_pressure_info, 5);
        sparseIntArray.put(R.id.lift_bottom_constraint, 6);
        sparseIntArray.put(R.id.roll_over_icon, 7);
        sparseIntArray.put(R.id.angle_inclination, 8);
        sparseIntArray.put(R.id.four_zone_wheel, 9);
        sparseIntArray.put(R.id.center_constraint, 10);
        sparseIntArray.put(R.id.cross_altitude_icon, 11);
        sparseIntArray.put(R.id.cross_altitude_info, 12);
        sparseIntArray.put(R.id.abnormal_lift_top, 13);
        sparseIntArray.put(R.id.abnormal_right_top, 14);
        sparseIntArray.put(R.id.abnormal_lift_bot, 15);
        sparseIntArray.put(R.id.abnormal_right_bot, 16);
        sparseIntArray.put(R.id.lift_bar_value, 17);
        sparseIntArray.put(R.id.lift_bar_value_bar, 18);
        sparseIntArray.put(R.id.lift_bar_line, 19);
        sparseIntArray.put(R.id.lift_bar_temperature_value, 20);
        sparseIntArray.put(R.id.unit_01, 21);
        sparseIntArray.put(R.id.lift_bottom_value, 22);
        sparseIntArray.put(R.id.lift_bottom_value_bar, 23);
        sparseIntArray.put(R.id.lift_bar_bottom_line, 24);
        sparseIntArray.put(R.id.lift_bar_bottom_temperature_value, 25);
        sparseIntArray.put(R.id.unit02, 26);
        sparseIntArray.put(R.id.right_line_top_value, 27);
        sparseIntArray.put(R.id.right_line_top_value_bar, 28);
        sparseIntArray.put(R.id.right_bar_line, 29);
        sparseIntArray.put(R.id.right_bar_temperature_value, 30);
        sparseIntArray.put(R.id.right_bar_temperature_unit, 31);
        sparseIntArray.put(R.id.right_line_bottom_value, 32);
        sparseIntArray.put(R.id.right_line_bottom_unit, 33);
        sparseIntArray.put(R.id.right_bottom_bar_line, 34);
        sparseIntArray.put(R.id.right_bottom_value, 35);
        sparseIntArray.put(R.id.right_bottom_value_unit, 36);
        sparseIntArray.put(R.id.front_axle_lock, 37);
        sparseIntArray.put(R.id.rear_axle_lock, 38);
        sparseIntArray.put(R.id.right_bottom_constraint, 39);
        sparseIntArray.put(R.id.roll_tilt_icon, 40);
        sparseIntArray.put(R.id.angle_roll, 41);
        sparseIntArray.put(R.id.wading_car, 42);
        sparseIntArray.put(R.id.mark, 43);
        sparseIntArray.put(R.id.constraint_max_name_20, 44);
        sparseIntArray.put(R.id.cross_line_20, 45);
        sparseIntArray.put(R.id.constraint_max_name_15, 46);
        sparseIntArray.put(R.id.cross_line_15, 47);
        sparseIntArray.put(R.id.mask_depth, 48);
        sparseIntArray.put(R.id.constraint_lift_name, 49);
        sparseIntArray.put(R.id.constraint_lift_value, 50);
        sparseIntArray.put(R.id.wading_ground_shadow, 51);
        sparseIntArray.put(R.id.wading_radar_layout, 52);
        sparseIntArray.put(R.id.wading_radar, 53);
        sparseIntArray.put(R.id.bottom_bt_item, 54);
        sparseIntArray.put(R.id.cross_disabled_stabilization, 55);
        sparseIntArray.put(R.id.cross_slow_descent, 56);
        sparseIntArray.put(R.id.cross_radiating_layout, 57);
        sparseIntArray.put(R.id.cross_radiating, 58);
    }

    public ActivityHomeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 59, sIncludes, sViewsWithIds));
    }

    private ActivityHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[15], (ImageView) objArr[13], (ImageView) objArr[16], (ImageView) objArr[14], (TextView) objArr[8], (TextView) objArr[41], (LinearLayout) objArr[54], (ConstraintLayout) objArr[10], (TextView) objArr[49], (TextView) objArr[50], (TextView) objArr[46], (TextView) objArr[44], (ImageView) objArr[11], (TextView) objArr[12], (View) objArr[3], (CrossSwitchCompat) objArr[55], (ConstraintLayout) objArr[0], (TextView) objArr[47], (TextView) objArr[45], (ImageView) objArr[4], (TextView) objArr[5], (CrossSwitchCompat) objArr[58], (LinearLayout) objArr[57], (CrossSwitchCompat) objArr[56], (ChargingLottieAnimation) objArr[9], (ImageView) objArr[37], (View) objArr[24], (TextView) objArr[25], (View) objArr[19], (TextView) objArr[20], (TextView) objArr[17], (TextView) objArr[18], (ConstraintLayout) objArr[6], (TextView) objArr[22], (TextView) objArr[23], (CompassBearingLayoutBinding) objArr[1], (View) objArr[43], (WadingDepthView) objArr[48], (ImageView) objArr[38], (View) objArr[29], (TextView) objArr[31], (TextView) objArr[30], (View) objArr[34], (ConstraintLayout) objArr[39], (TextView) objArr[35], (TextView) objArr[36], (TextView) objArr[33], (TextView) objArr[32], (TextView) objArr[27], (TextView) objArr[28], (AltitudeLayoutBinding) objArr[2], (ImageView) objArr[7], (ImageView) objArr[40], (TextView) objArr[21], (TextView) objArr[26], (ImageView) objArr[42], (ImageView) objArr[51], (CrossSwitchCompat) objArr[53], (LinearLayout) objArr[52]);
        this.mDirtyFlags = -1L;
        this.crossLayout.setTag(null);
        setContainedBinding(this.liftTopConstraint);
        setContainedBinding(this.rightTopConstraint);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.liftTopConstraint.invalidateAll();
        this.rightTopConstraint.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.liftTopConstraint.hasPendingBindings() || this.rightTopConstraint.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.liftTopConstraint.setLifecycleOwner(lifecycleOwner);
        this.rightTopConstraint.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeLiftTopConstraint((CompassBearingLayoutBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeRightTopConstraint((AltitudeLayoutBinding) obj, i2);
    }

    private boolean onChangeLiftTopConstraint(CompassBearingLayoutBinding compassBearingLayoutBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeRightTopConstraint(AltitudeLayoutBinding altitudeLayoutBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        executeBindingsOn(this.liftTopConstraint);
        executeBindingsOn(this.rightTopConstraint);
    }
}
