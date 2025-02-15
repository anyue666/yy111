package com.autolink.hmi.crosscountry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autolink.buryservice.bury.consts.BuryKeyConst;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.utils.BuryServiceUtils;
import com.autolink.hmi.crosscountry.utils.CrossAllUtils;
import com.autolink.hmi.crosscountry.utils.LogUtils;

/* loaded from: classes.dex */
public class WadingDepthView extends AppCompatImageView {
    private View crossLineYout;
    private ImageView maskDepth;
    public float max_water_level;
    DrivingModeDialogCallback sdad;
    private TextView texDepth;
    private String value;

    interface DrivingModeDialogCallback {
        String onModeName(String str);
    }

    public void setDialogCallback(DrivingModeDialogCallback drivingModeDialogCallback) {
    }

    public WadingDepthView(Context context) {
        this(context, null);
    }

    public WadingDepthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WadingDepthView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.max_water_level = 14.0f;
        this.value = "3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinStatus() {
        this.maskDepth.setImageDrawable(getResources().getDrawable(R.mipmap.cross_wading_green));
        this.texDepth.setTextColor(getResources().getColor(R.color.color_02));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMiddleStatus() {
        this.maskDepth.setImageDrawable(getResources().getDrawable(R.mipmap.wading_yellow));
        this.texDepth.setTextColor(getResources().getColor(R.color.color_026));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxStatus() {
        this.texDepth.setTextColor(getResources().getColor(R.color.color_01));
        this.maskDepth.setImageDrawable(getResources().getDrawable(R.mipmap.cross_wading_red));
    }

    public void showOmit() {
        post(new Runnable() { // from class: com.autolink.hmi.crosscountry.view.WadingDepthView.1
            @Override // java.lang.Runnable
            public void run() {
                ViewParent parent = WadingDepthView.this.getParent();
                WadingDepthView wadingDepthView = WadingDepthView.this;
                wadingDepthView.maskDepth = (ImageView) wadingDepthView.findViewById(R.id.mask_depth);
                WadingDepthView.this.texDepth = (TextView) ((ContentFrameLayout) parent.getParent()).findViewById(R.id.constraint_lift_value);
                WadingDepthView.this.texDepth.setText("-- cm");
                WadingDepthView.this.maskDepth.setVisibility(8);
            }
        });
    }

    public void setWadingDepth(final int i) {
        LogUtils.logI("setWadingDepth", "depth " + i);
        if (i > 30) {
            return;
        }
        post(new Runnable() { // from class: com.autolink.hmi.crosscountry.view.WadingDepthView.2
            @Override // java.lang.Runnable
            public void run() {
                BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_Wadingheight, "" + i);
                ViewParent parent = WadingDepthView.this.getParent();
                WadingDepthView wadingDepthView = WadingDepthView.this;
                wadingDepthView.maskDepth = (ImageView) wadingDepthView.findViewById(R.id.mask_depth);
                WadingDepthView.this.texDepth = (TextView) ((ContentFrameLayout) parent.getParent()).findViewById(R.id.constraint_lift_value);
                WadingDepthView.this.crossLineYout = ((ContentFrameLayout) parent.getParent()).findViewById(R.id.mark);
                WadingDepthView.this.value = CrossAllUtils.getProperty(CrossAllUtils.ENGINE_KEY);
                LogUtils.logI("setWadingDepth", "ENGINE_KEY " + WadingDepthView.this.value);
                if (WadingDepthView.this.value.equals("4")) {
                    WadingDepthView.this.max_water_level = 11.0f;
                }
                if (WadingDepthView.this.value.equals("5")) {
                    WadingDepthView.this.max_water_level = 14.0f;
                }
                if (i <= 1) {
                    WadingDepthView.this.texDepth.setText(WadingDepthView.this.getResources().getString(R.string.fording_depth));
                } else {
                    WadingDepthView.this.texDepth.setText((i * 5) + "cm");
                }
                int i2 = i;
                if (i2 <= 1) {
                    WadingDepthView.this.setMinStatus();
                } else if (i2 > WadingDepthView.this.max_water_level) {
                    WadingDepthView.this.setMaxStatus();
                } else {
                    if (WadingDepthView.this.value.equals("4")) {
                        if (i > WadingDepthView.this.max_water_level || i < 8) {
                            WadingDepthView.this.setMinStatus();
                        } else {
                            WadingDepthView.this.setMiddleStatus();
                        }
                    }
                    if (WadingDepthView.this.value.equals("5")) {
                        if (i > WadingDepthView.this.max_water_level || i < 9) {
                            WadingDepthView.this.setMinStatus();
                        } else {
                            WadingDepthView.this.setMiddleStatus();
                        }
                    }
                }
                if (i != 0) {
                    WadingDepthView.this.maskDepth.setVisibility(0);
                    int i3 = i;
                    if (i3 % 2 != 0) {
                        i3++;
                    }
                    if (i3 > 24) {
                        i3 = 24;
                    }
                    float f = 24.0f / i3;
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) WadingDepthView.this.maskDepth.getLayoutParams();
                    float measuredHeight = WadingDepthView.this.crossLineYout.getMeasuredHeight() / f;
                    layoutParams.bottomMargin = (int) measuredHeight;
                    LogUtils.logI("setWadingDepth", "viewHeight " + measuredHeight);
                    WadingDepthView.this.setLayoutParams(layoutParams);
                    return;
                }
                WadingDepthView.this.maskDepth.setVisibility(8);
            }
        });
    }
}
