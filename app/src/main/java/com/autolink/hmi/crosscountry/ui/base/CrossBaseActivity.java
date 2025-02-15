package com.autolink.hmi.crosscountry.ui.base;

import android.os.Bundle;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import com.landmark.hmimvvmbase.BaseActivity;
import com.landmark.hmimvvmbase.BaseViewModel;

/* loaded from: classes.dex */
public class CrossBaseActivity<ViewDataBinding extends ViewDataBinding, BaseViewModel extends BaseViewModel> extends BaseActivity<ViewDataBinding, BaseViewModel> {
    @Override // com.landmark.hmimvvmbase.BaseActivity, com.landmark.hmibase.LandmarkActivity, com.landmark.hmibase.FunctionActivity, com.landmark.hmibase.SystemUIActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        transparentStatusBar(getWindow());
    }

    private void transparentStatusBar(Window window) {
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(5122);
        window.setStatusBarColor(0);
    }
}
