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
import com.autolink.hmi.crosscountry.view.ChargingLottieAnimation;
import com.autolink.hmi.crosscountry.view.CrossSwitchCompat;
import com.autolink.hmi.crosscountry.view.WadingDepthView;

/* loaded from: classes.dex */
public abstract class ActivityHomeBinding extends ViewDataBinding {
    public final ImageView abnormalLiftBot;
    public final ImageView abnormalLiftTop;
    public final ImageView abnormalRightBot;
    public final ImageView abnormalRightTop;
    public final TextView angleInclination;
    public final TextView angleRoll;
    public final LinearLayout bottomBtItem;
    public final ConstraintLayout centerConstraint;
    public final TextView constraintLiftName;
    public final TextView constraintLiftValue;
    public final TextView constraintMaxName15;
    public final TextView constraintMaxName20;
    public final ImageView crossAltitudeIcon;
    public final TextView crossAltitudeInfo;
    public final View crossClose;
    public final CrossSwitchCompat crossDisabledStabilization;
    public final ConstraintLayout crossLayout;
    public final TextView crossLine15;
    public final TextView crossLine20;
    public final ImageView crossPressureIcon;
    public final TextView crossPressureInfo;
    public final CrossSwitchCompat crossRadiating;
    public final LinearLayout crossRadiatingLayout;
    public final CrossSwitchCompat crossSlowDescent;
    public final ChargingLottieAnimation fourZoneWheel;
    public final ImageView frontAxleLock;
    public final View liftBarBottomLine;
    public final TextView liftBarBottomTemperatureValue;
    public final View liftBarLine;
    public final TextView liftBarTemperatureValue;
    public final TextView liftBarValue;
    public final TextView liftBarValueBar;
    public final ConstraintLayout liftBottomConstraint;
    public final TextView liftBottomValue;
    public final TextView liftBottomValueBar;
    public final CompassBearingLayoutBinding liftTopConstraint;
    public final View mark;
    public final WadingDepthView maskDepth;
    public final ImageView rearAxleLock;
    public final View rightBarLine;
    public final TextView rightBarTemperatureUnit;
    public final TextView rightBarTemperatureValue;
    public final View rightBottomBarLine;
    public final ConstraintLayout rightBottomConstraint;
    public final TextView rightBottomValue;
    public final TextView rightBottomValueUnit;
    public final TextView rightLineBottomUnit;
    public final TextView rightLineBottomValue;
    public final TextView rightLineTopValue;
    public final TextView rightLineTopValueBar;
    public final AltitudeLayoutBinding rightTopConstraint;
    public final ImageView rollOverIcon;
    public final ImageView rollTiltIcon;
    public final TextView unit01;
    public final TextView unit02;
    public final ImageView wadingCar;
    public final ImageView wadingGroundShadow;
    public final CrossSwitchCompat wadingRadar;
    public final LinearLayout wadingRadarLayout;

    protected ActivityHomeBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView5, TextView textView7, View view2, CrossSwitchCompat crossSwitchCompat, ConstraintLayout constraintLayout2, TextView textView8, TextView textView9, ImageView imageView6, TextView textView10, CrossSwitchCompat crossSwitchCompat2, LinearLayout linearLayout2, CrossSwitchCompat crossSwitchCompat3, ChargingLottieAnimation chargingLottieAnimation, ImageView imageView7, View view3, TextView textView11, View view4, TextView textView12, TextView textView13, TextView textView14, ConstraintLayout constraintLayout3, TextView textView15, TextView textView16, CompassBearingLayoutBinding compassBearingLayoutBinding, View view5, WadingDepthView wadingDepthView, ImageView imageView8, View view6, TextView textView17, TextView textView18, View view7, ConstraintLayout constraintLayout4, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, AltitudeLayoutBinding altitudeLayoutBinding, ImageView imageView9, ImageView imageView10, TextView textView25, TextView textView26, ImageView imageView11, ImageView imageView12, CrossSwitchCompat crossSwitchCompat4, LinearLayout linearLayout3) {
        super(obj, view, i);
        this.abnormalLiftBot = imageView;
        this.abnormalLiftTop = imageView2;
        this.abnormalRightBot = imageView3;
        this.abnormalRightTop = imageView4;
        this.angleInclination = textView;
        this.angleRoll = textView2;
        this.bottomBtItem = linearLayout;
        this.centerConstraint = constraintLayout;
        this.constraintLiftName = textView3;
        this.constraintLiftValue = textView4;
        this.constraintMaxName15 = textView5;
        this.constraintMaxName20 = textView6;
        this.crossAltitudeIcon = imageView5;
        this.crossAltitudeInfo = textView7;
        this.crossClose = view2;
        this.crossDisabledStabilization = crossSwitchCompat;
        this.crossLayout = constraintLayout2;
        this.crossLine15 = textView8;
        this.crossLine20 = textView9;
        this.crossPressureIcon = imageView6;
        this.crossPressureInfo = textView10;
        this.crossRadiating = crossSwitchCompat2;
        this.crossRadiatingLayout = linearLayout2;
        this.crossSlowDescent = crossSwitchCompat3;
        this.fourZoneWheel = chargingLottieAnimation;
        this.frontAxleLock = imageView7;
        this.liftBarBottomLine = view3;
        this.liftBarBottomTemperatureValue = textView11;
        this.liftBarLine = view4;
        this.liftBarTemperatureValue = textView12;
        this.liftBarValue = textView13;
        this.liftBarValueBar = textView14;
        this.liftBottomConstraint = constraintLayout3;
        this.liftBottomValue = textView15;
        this.liftBottomValueBar = textView16;
        this.liftTopConstraint = compassBearingLayoutBinding;
        this.mark = view5;
        this.maskDepth = wadingDepthView;
        this.rearAxleLock = imageView8;
        this.rightBarLine = view6;
        this.rightBarTemperatureUnit = textView17;
        this.rightBarTemperatureValue = textView18;
        this.rightBottomBarLine = view7;
        this.rightBottomConstraint = constraintLayout4;
        this.rightBottomValue = textView19;
        this.rightBottomValueUnit = textView20;
        this.rightLineBottomUnit = textView21;
        this.rightLineBottomValue = textView22;
        this.rightLineTopValue = textView23;
        this.rightLineTopValueBar = textView24;
        this.rightTopConstraint = altitudeLayoutBinding;
        this.rollOverIcon = imageView9;
        this.rollTiltIcon = imageView10;
        this.unit01 = textView25;
        this.unit02 = textView26;
        this.wadingCar = imageView11;
        this.wadingGroundShadow = imageView12;
        this.wadingRadar = crossSwitchCompat4;
        this.wadingRadarLayout = linearLayout3;
    }

    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_home, viewGroup, z, obj);
    }

    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_home, null, false, obj);
    }

    public static ActivityHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHomeBinding bind(View view, Object obj) {
        return (ActivityHomeBinding) bind(obj, view, R.layout.activity_home);
    }
}
