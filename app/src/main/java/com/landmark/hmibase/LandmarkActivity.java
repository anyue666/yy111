package com.landmark.hmibase;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class LandmarkActivity extends FunctionActivity {
    @Override // com.landmark.hmibase.SystemUIActivity
    public boolean defaultSystemBar() {
        return true;
    }

    public void setTheme() {
    }

    @Override // com.landmark.hmibase.SystemUIActivity
    public boolean translucentStatusBar() {
        return false;
    }

    @Override // com.landmark.hmibase.FunctionActivity, com.landmark.hmibase.SystemUIActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        setTheme();
        super.setContentView(i);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        setTheme();
        super.setContentView(view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        setTheme();
        super.setContentView(view, layoutParams);
    }
}
