package com.landmark.hmibase;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FunctionActivity extends SystemUIActivity {
    private static final ArrayList<Activity> activities = new ArrayList<>();

    @Override // com.landmark.hmibase.SystemUIActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addActivity(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        removeActivity(this);
        super.onDestroy();
    }

    private void addActivity(Activity activity) {
        activities.add(activity);
    }

    private void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void clearActivity() {
        Iterator<Activity> it = activities.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
    }
}
