package com.autolink.hmi.crosscountry;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBindingImpl;
import com.autolink.hmi.crosscountry.databinding.ActivityMainBindingImpl;
import com.autolink.hmi.crosscountry.databinding.AltitudeLayoutBindingImpl;
import com.autolink.hmi.crosscountry.databinding.CompassBearingLayoutBindingImpl;
import com.autolink.hmi.crosscountry.databinding.DialogFailureLayoutBindingImpl;
import com.autolink.hmi.crosscountry.databinding.DrivingModeDialogLayoutBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYHOME = 1;
    private static final int LAYOUT_ACTIVITYMAIN = 2;
    private static final int LAYOUT_ALTITUDELAYOUT = 3;
    private static final int LAYOUT_COMPASSBEARINGLAYOUT = 4;
    private static final int LAYOUT_DIALOGFAILURELAYOUT = 5;
    private static final int LAYOUT_DRIVINGMODEDIALOGLAYOUT = 6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(6);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_home, 1);
        sparseIntArray.put(R.layout.activity_main, 2);
        sparseIntArray.put(R.layout.altitude_layout, 3);
        sparseIntArray.put(R.layout.compass_bearing_layout, 4);
        sparseIntArray.put(R.layout.dialog_failure_layout, 5);
        sparseIntArray.put(R.layout.driving_mode_dialog_layout, 6);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_home_0".equals(tag)) {
                    return new ActivityHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_main_0".equals(tag)) {
                    return new ActivityMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
            case 3:
                if ("layout/altitude_layout_0".equals(tag)) {
                    return new AltitudeLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for altitude_layout is invalid. Received: " + tag);
            case 4:
                if ("layout/compass_bearing_layout_0".equals(tag)) {
                    return new CompassBearingLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for compass_bearing_layout is invalid. Received: " + tag);
            case 5:
                if ("layout/dialog_failure_layout_0".equals(tag)) {
                    return new DialogFailureLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_failure_layout is invalid. Received: " + tag);
            case 6:
                if ("layout/driving_mode_dialog_layout_0".equals(tag)) {
                    return new DrivingModeDialogLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for driving_mode_dialog_layout is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.landmark.hmimvvmbase.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(6);
            sKeys = hashMap;
            hashMap.put("layout/activity_home_0", Integer.valueOf(R.layout.activity_home));
            hashMap.put("layout/activity_main_0", Integer.valueOf(R.layout.activity_main));
            hashMap.put("layout/altitude_layout_0", Integer.valueOf(R.layout.altitude_layout));
            hashMap.put("layout/compass_bearing_layout_0", Integer.valueOf(R.layout.compass_bearing_layout));
            hashMap.put("layout/dialog_failure_layout_0", Integer.valueOf(R.layout.dialog_failure_layout));
            hashMap.put("layout/driving_mode_dialog_layout_0", Integer.valueOf(R.layout.driving_mode_dialog_layout));
        }
    }
}
