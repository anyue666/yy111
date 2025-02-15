package com.landmark.hmibase;

import android.hardware.automotive.vehicle.V2_0.VehicleArea;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: SystemUIActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/landmark/hmibase/SystemUIActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "colorPrimary", "", "getColorPrimary", "()I", "colorPrimary$delegate", "Lkotlin/Lazy;", "colorPrimaryDark", "getColorPrimaryDark", "colorPrimaryDark$delegate", "defaultSystemBar", "", "initSystemBarTint", "", "navigationBarColor", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setTranslucentStatusBar", "statusBarColor", "statusBarLight", "translucentStatusBar", "hmibase_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SystemUIActivity extends AppCompatActivity {

    /* renamed from: colorPrimary$delegate, reason: from kotlin metadata */
    private final Lazy colorPrimary = LazyKt.lazy(new Function0<Integer>() { // from class: com.landmark.hmibase.SystemUIActivity$colorPrimary$2
        SystemUIActivity$colorPrimary$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            TypedValue typedValue = new TypedValue();
            SystemUIActivity.this.getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
            return Integer.valueOf(typedValue.data);
        }
    });

    /* renamed from: colorPrimaryDark$delegate, reason: from kotlin metadata */
    private final Lazy colorPrimaryDark = LazyKt.lazy(new Function0<Integer>() { // from class: com.landmark.hmibase.SystemUIActivity$colorPrimaryDark$2
        SystemUIActivity$colorPrimaryDark$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            TypedValue typedValue = new TypedValue();
            SystemUIActivity.this.getTheme().resolveAttribute(android.R.attr.colorPrimaryDark, typedValue, true);
            return Integer.valueOf(typedValue.data);
        }
    });

    public boolean defaultSystemBar() {
        return false;
    }

    public boolean statusBarLight() {
        return false;
    }

    public boolean translucentStatusBar() {
        return false;
    }

    private final int getColorPrimary() {
        return ((Number) this.colorPrimary.getValue()).intValue();
    }

    private final int getColorPrimaryDark() {
        return ((Number) this.colorPrimaryDark.getValue()).intValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        initSystemBarTint();
        super.onCreate(savedInstanceState);
    }

    public int statusBarColor() {
        return getColorPrimaryDark();
    }

    public int navigationBarColor() {
        return getColorPrimary();
    }

    private final void setTranslucentStatusBar() {
        Window window = getWindow();
        window.clearFlags(VehicleArea.MIRROR);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    private final void initSystemBarTint() {
        if (defaultSystemBar()) {
            return;
        }
        if (translucentStatusBar()) {
            setTranslucentStatusBar();
            return;
        }
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(8192);
        window.clearFlags(VehicleArea.MIRROR);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(statusBarColor());
        window.setNavigationBarColor(navigationBarColor());
    }
}
