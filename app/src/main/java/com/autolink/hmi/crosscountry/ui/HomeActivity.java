package com.autolink.hmi.crosscountry.ui;

import android.animation.AnimatorSet;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.autolink.account.ui.dialog.DrivingModeDialog;
import com.autolink.adaptermanager.car.ALAVMProperty;
import com.autolink.adaptermanager.car.ALVehicleControlProperty;
import com.autolink.buryservice.bury.consts.BuryKeyConst;
import com.autolink.car.client.CarSettingManager;
import com.autolink.carsetting.data.car.CarContact;
import com.autolink.hmi.crosscountry.ICrossCallback;
import com.autolink.hmi.crosscountry.ICrossService;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.crossviewmodel.HomeViewModel;
import com.autolink.hmi.crosscountry.databinding.ActivityHomeBinding;
import com.autolink.hmi.crosscountry.manager.WadingRadarManager;
import com.autolink.hmi.crosscountry.ui.base.CrossBaseActivity;
import com.autolink.hmi.crosscountry.utils.AnimatorUtils;
import com.autolink.hmi.crosscountry.utils.BuryServiceUtils;
import com.autolink.hmi.crosscountry.utils.CarSettingController;
import com.autolink.hmi.crosscountry.utils.CommonalityUtils;
import com.autolink.hmi.crosscountry.utils.CrossAllUtils;
import com.autolink.hmi.crosscountry.utils.DelayRecoveryUtils;
import com.autolink.hmi.crosscountry.utils.KtExtensionKt;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import com.autolink.hmi.crosscountry.view.AltitudeView;
import com.autolink.hmi.crosscountry.view.CompassView;
import com.autolink.hmi.crosscountry.view.CrossSwitchCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: HomeActivity.kt */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001*\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\u0010\u00102\u001a\u0002002\u0006\u00103\u001a\u000204H\u0002J\u0006\u00105\u001a\u000200J\u0012\u00106\u001a\u0002002\b\u00107\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0002J\b\u0010:\u001a\u000200H\u0003J\b\u0010;\u001a\u000200H\u0003J\b\u0010<\u001a\u000200H\u0002J\b\u0010=\u001a\u000200H\u0002J\b\u0010>\u001a\u000200H\u0002J\u0012\u0010?\u001a\u0002002\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\b\u0010B\u001a\u000200H\u0014J\b\u0010C\u001a\u000200H\u0014J\b\u0010D\u001a\u000200H\u0014J\b\u0010E\u001a\u000200H\u0002J\b\u0010F\u001a\u000200H\u0002J\u0010\u0010G\u001a\u0002002\u0006\u0010H\u001a\u00020\u000eH\u0002J8\u0010I\u001a\u0002002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020K2\u0006\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\bH\u0002J\u0018\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0006H\u0002J\u000e\u0010U\u001a\u0002002\u0006\u00103\u001a\u000204J\u0010\u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020\u0006H\u0002J\b\u0010X\u001a\u000200H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u001a\u0010,\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\f¨\u0006Y"}, d2 = {"Lcom/autolink/hmi/crosscountry/ui/HomeActivity;", "Lcom/autolink/hmi/crosscountry/ui/base/CrossBaseActivity;", "Lcom/autolink/hmi/crosscountry/databinding/ActivityHomeBinding;", "Lcom/autolink/hmi/crosscountry/crossviewmodel/HomeViewModel;", "()V", "TAG", "", "fordingDepth", "", "getFordingDepth", "()I", "setFordingDepth", "(I)V", "frontWheelSwerve", "", "getFrontWheelSwerve", "()F", "setFrontWheelSwerve", "(F)V", "intent", "Landroid/content/Intent;", "mDrivingDialog", "Lcom/autolink/account/ui/dialog/DrivingModeDialog;", "getMDrivingDialog", "()Lcom/autolink/account/ui/dialog/DrivingModeDialog;", "setMDrivingDialog", "(Lcom/autolink/account/ui/dialog/DrivingModeDialog;)V", "mICrossCallback", "Lcom/autolink/hmi/crosscountry/ICrossCallback$Stub;", "getMICrossCallback", "()Lcom/autolink/hmi/crosscountry/ICrossCallback$Stub;", "setMICrossCallback", "(Lcom/autolink/hmi/crosscountry/ICrossCallback$Stub;)V", "mICrossService", "Lcom/autolink/hmi/crosscountry/ICrossService;", "getMICrossService", "()Lcom/autolink/hmi/crosscountry/ICrossService;", "setMICrossService", "(Lcom/autolink/hmi/crosscountry/ICrossService;)V", "mScope", "Lkotlinx/coroutines/CoroutineScope;", "serviceConnection", "com/autolink/hmi/crosscountry/ui/HomeActivity$serviceConnection$1", "Lcom/autolink/hmi/crosscountry/ui/HomeActivity$serviceConnection$1;", "stsStatus", "getStsStatus", "setStsStatus", "bindService", "", "clearAnimation", "clearRotationChanges", "view", "Landroid/view/View;", "getDisplayParameter", "getDrivingMode", "mode", "getPressureAlarm", "getTorqueLock", "init", "initCallbackMonitoring", "initLastAngle", "initView", "initWadingRadar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "refreshStatus", "registerResult", "setSwerveAngle", "swerveAngle", "setTyreValue", "textValue", "Landroid/widget/TextView;", "textUnit", "temperatureTex", "temperatureC", "pressureValue", "temperatureValue", "tireAlarm", "src", "Landroid/widget/ImageView;", NotificationCompat.CATEGORY_MESSAGE, "tireRotationChanges", "visibilityFordingDepth", "value", "wadingRadarSwitch", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HomeActivity extends CrossBaseActivity<ActivityHomeBinding, HomeViewModel> {
    private int fordingDepth;
    private float frontWheelSwerve;
    private Intent intent;
    private DrivingModeDialog mDrivingDialog;
    private ICrossService mICrossService;
    private int stsStatus;
    private final String TAG = "HomeActivity";
    private final CoroutineScope mScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private ICrossCallback.Stub mICrossCallback = new ICrossCallback.Stub() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$mICrossCallback$1
        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onReceived(String msg) {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onSignalState(String key, String msg) {
            CoroutineScope coroutineScope;
            CoroutineScope coroutineScope2;
            CoroutineScope coroutineScope3;
            CoroutineScope coroutineScope4;
            if (key != null && Integer.parseInt(key) == 603) {
                coroutineScope4 = HomeActivity.this.mScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope4, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onSignalState$1(msg, HomeActivity.this, null), 2, null);
            }
            if (key != null && Integer.parseInt(key) == 605) {
                coroutineScope3 = HomeActivity.this.mScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onSignalState$2(msg, HomeActivity.this, null), 2, null);
            }
            if (key != null && Integer.parseInt(key) == 604) {
                coroutineScope2 = HomeActivity.this.mScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onSignalState$3(msg, HomeActivity.this, null), 2, null);
            }
            if (key != null && Integer.parseInt(key) == 606) {
                coroutineScope = HomeActivity.this.mScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onSignalState$4(msg, HomeActivity.this, null), 2, null);
            }
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onXSteerMode(String msg) {
            String str;
            CoroutineScope coroutineScope;
            str = HomeActivity.this.TAG;
            LogUtils.logI(str, "onXSteerMode msg " + msg);
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onXSteerMode$1(HomeActivity.this, msg, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onFetalTemperature(String key, String msg) {
            CoroutineScope coroutineScope;
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onFetalTemperature$1(key, msg, HomeActivity.this, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onCarSteerListener(String v) {
            String str;
            CoroutineScope coroutineScope;
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Intrinsics.checkNotNull(v);
            floatRef.element = Float.parseFloat(v);
            str = HomeActivity.this.TAG;
            LogUtils.logI(str, "onCarSteerListener swerve " + floatRef.element);
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onCarSteerListener$1(HomeActivity.this, floatRef, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onCarTyreListener(String key, String msg) {
            CoroutineScope coroutineScope;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(msg, "msg");
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onCarTyreListener$1(HomeActivity.this, key, msg, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onAngleInclination(String msg) {
            CoroutineScope coroutineScope;
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onAngleInclination$1(HomeActivity.this, msg, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onRollAngle(String msg) {
            CoroutineScope coroutineScope;
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onRollAngle$1(HomeActivity.this, msg, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onDifferentialLock(String msg) {
            CoroutineScope coroutineScope;
            if (msg == null || Intrinsics.areEqual(msg, "")) {
                return;
            }
            LogUtils.logI("onDifferentialLock", "msg " + msg);
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$mICrossCallback$1$onDifferentialLock$1(HomeActivity.this, msg, null), 2, null);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onDrivingMode(String msg) {
            LogUtils.logI("onDrivingMode", "msg " + msg);
            HomeActivity.this.getDrivingMode(msg);
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onWadingDepth(String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            try {
                LogUtils.logI("onWadingDepth", "msg " + msg);
                HomeActivity.this.setFordingDepth(Integer.parseInt(msg));
                HomeActivity.this.wadingRadarSwitch();
            } catch (Exception e) {
                LogUtils.logI("onWadingDepth ", "e");
                e.printStackTrace();
            }
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onSTSChange(String msg) {
            CoroutineScope coroutineScope;
            Intrinsics.checkNotNullParameter(msg, "msg");
            LogUtils.logI("onSTSChange", "msg " + msg);
            HomeActivity.this.setStsStatus(Integer.parseInt(msg));
            coroutineScope = HomeActivity.this.mScope;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new HomeActivity$mICrossCallback$1$onSTSChange$1(msg, HomeActivity.this, null), 2, null);
        }
    };
    private HomeActivity$serviceConnection$1 serviceConnection = new ServiceConnection() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$serviceConnection$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            HomeActivity.this.setMICrossService(ICrossService.Stub.asInterface(service));
            try {
                LogUtils.logI("ServiceConnected ", "onServiceConnected " + name);
                HomeActivity.this.getDisplayParameter();
                ICrossService mICrossService = HomeActivity.this.getMICrossService();
                if (mICrossService != null) {
                    mICrossService.register(HomeActivity.this.getMICrossCallback());
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            ICrossService mICrossService = HomeActivity.this.getMICrossService();
            if (mICrossService != null) {
                mICrossService.unregister(HomeActivity.this.getMICrossCallback());
            }
            LogUtils.logI("ServiceConnected ", "onServiceDisconnected " + name);
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName name) {
            super.onBindingDied(name);
            LogUtils.logI("ServiceConnected ", "onBindingDied " + name);
        }
    };

    public final int getFordingDepth() {
        return this.fordingDepth;
    }

    public final void setFordingDepth(int i) {
        this.fordingDepth = i;
    }

    public final int getStsStatus() {
        return this.stsStatus;
    }

    public final void setStsStatus(int i) {
        this.stsStatus = i;
    }

    public final ICrossCallback.Stub getMICrossCallback() {
        return this.mICrossCallback;
    }

    public final void setMICrossCallback(ICrossCallback.Stub stub) {
        Intrinsics.checkNotNullParameter(stub, "<set-?>");
        this.mICrossCallback = stub;
    }

    public final ICrossService getMICrossService() {
        return this.mICrossService;
    }

    public final void setMICrossService(ICrossService iCrossService) {
        this.mICrossService = iCrossService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.autolink.hmi.crosscountry.ui.base.CrossBaseActivity, com.landmark.hmimvvmbase.BaseActivity, com.landmark.hmibase.LandmarkActivity, com.landmark.hmibase.FunctionActivity, com.landmark.hmibase.SystemUIActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.logI(this.TAG, "onCreate()");
        ((ActivityHomeBinding) getMVB()).crossClose.setOnClickListener(new View.OnClickListener() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.onCreate$lambda$0(HomeActivity.this, view);
            }
        });
        bindService();
        init();
        initCallbackMonitoring();
        initView();
        BuryServiceUtils.getInstance().setBurialPointAppOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(HomeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        if (CrossAllUtils.isDriveTypeFour()) {
            ((ActivityHomeBinding) getMVB()).crossRadiatingLayout.setVisibility(0);
        }
        String property = CrossAllUtils.getProperty(CrossAllUtils.POWER_KEY);
        LogUtils.logI(this.TAG, "powerId " + property);
        if (property.equals("2")) {
            ((ActivityHomeBinding) getMVB()).frontAxleLock.setVisibility(8);
            ((ActivityHomeBinding) getMVB()).rearAxleLock.setVisibility(8);
        }
        String property2 = CrossAllUtils.getProperty(CrossAllUtils.WATER_KEY);
        String property3 = CrossAllUtils.getProperty(CrossAllUtils.ENGINE_KEY);
        ((ActivityHomeBinding) getMVB()).wadingCar.setVisibility(8);
        ((ActivityHomeBinding) getMVB()).constraintMaxName20.setVisibility(8);
        ((ActivityHomeBinding) getMVB()).constraintMaxName15.setVisibility(8);
        ((ActivityHomeBinding) getMVB()).crossLine20.setVisibility(8);
        ((ActivityHomeBinding) getMVB()).crossLine15.setVisibility(8);
        ((ActivityHomeBinding) getMVB()).maskDepth.setVisibility(8);
        if (property2.equals("1")) {
            ((ActivityHomeBinding) getMVB()).wadingCar.setVisibility(0);
            ((ActivityHomeBinding) getMVB()).maskDepth.setVisibility(0);
            if (Intrinsics.areEqual(property3, "5")) {
                ((ActivityHomeBinding) getMVB()).constraintMaxName20.setVisibility(0);
                ((ActivityHomeBinding) getMVB()).crossLine20.setVisibility(0);
            } else if (Intrinsics.areEqual(property3, "4")) {
                ((ActivityHomeBinding) getMVB()).constraintMaxName15.setVisibility(0);
                ((ActivityHomeBinding) getMVB()).crossLine15.setVisibility(0);
            } else {
                ((ActivityHomeBinding) getMVB()).constraintMaxName20.setVisibility(0);
                ((ActivityHomeBinding) getMVB()).crossLine20.setVisibility(0);
            }
            ((ActivityHomeBinding) getMVB()).constraintLiftName.setVisibility(0);
            ((ActivityHomeBinding) getMVB()).wadingGroundShadow.setVisibility(0);
            ((ActivityHomeBinding) getMVB()).wadingRadarLayout.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = ((ActivityHomeBinding) getMVB()).bottomBtItem.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(getResources().getDimensionPixelOffset(R.dimen.dp1008));
            layoutParams2.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.dp62);
            ((ActivityHomeBinding) getMVB()).bottomBtItem.setLayoutParams(layoutParams2);
        } else {
            ((ActivityHomeBinding) getMVB()).constraintLiftName.setVisibility(8);
            ((ActivityHomeBinding) getMVB()).wadingGroundShadow.setVisibility(8);
            ((ActivityHomeBinding) getMVB()).wadingRadarLayout.setVisibility(8);
            ViewGroup.LayoutParams layoutParams3 = ((ActivityHomeBinding) getMVB()).bottomBtItem.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.setMarginStart(getResources().getDimensionPixelOffset(R.dimen.dp104));
            layoutParams4.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.dp62);
            ((ActivityHomeBinding) getMVB()).bottomBtItem.setLayoutParams(layoutParams4);
        }
        if (property.equals("2")) {
            if (CrossAllUtils.isSevenSeat()) {
                ((ActivityHomeBinding) getMVB()).crossLayout.setBackgroundResource(R.mipmap.cross_car_bg_skylight_seven);
            } else {
                ((ActivityHomeBinding) getMVB()).crossLayout.setBackgroundResource(R.mipmap.phev_car);
            }
        } else if (CrossAllUtils.getProperty(CrossAllUtils.SKYLIGHT_KEY).equals("1")) {
            if (CrossAllUtils.isSevenSeat()) {
                ((ActivityHomeBinding) getMVB()).crossLayout.setBackgroundResource(R.mipmap.cross_car_bg_skylight_seven);
            } else {
                ((ActivityHomeBinding) getMVB()).crossLayout.setBackgroundResource(R.mipmap.cross_car_bg_skylight);
            }
        } else {
            ((ActivityHomeBinding) getMVB()).crossLayout.setBackgroundResource(R.mipmap.cross_car_bg_no_skylight);
        }
        SharedPreferences sp = ((HomeViewModel) getMVM()).getSp();
        Float valueOf = sp != null ? Float.valueOf(sp.getFloat("compassDial", 0.0f)) : null;
        LogUtils.logI(this.TAG, "gps 方向后台更新读取 " + valueOf);
        CompassView compassView = ((ActivityHomeBinding) getMVB()).liftTopConstraint.compassView;
        Intrinsics.checkNotNull(valueOf);
        compassView.refreshAngle(valueOf.floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initCallbackMonitoring() {
        ((HomeViewModel) getMVM()).initComponent();
        MutableLiveData<String> compass = ((HomeViewModel) getMVM()).getCompass();
        HomeActivity homeActivity = this;
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$initCallbackMonitoring$1
            {
                super(1);
            }

            /* compiled from: HomeActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.autolink.hmi.crosscountry.ui.HomeActivity$initCallbackMonitoring$1$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.autolink.hmi.crosscountry.ui.HomeActivity$initCallbackMonitoring$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $it;
                int label;
                final /* synthetic */ HomeActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HomeActivity homeActivity, String str, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = homeActivity;
                    this.$it = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$it, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    String str;
                    String str2;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ICrossService mICrossService = this.this$0.getMICrossService();
                    Float boxFloat = mICrossService != null ? Boxing.boxFloat(mICrossService.getFloatVehicleAVMProp(ALAVMProperty.VEHICLE_PROPERTY_AVM_VENDOR_AVM_SPEED)) : null;
                    str = this.this$0.TAG;
                    LogUtils.logI(str, "VEHICLE_PROPERTY_AVM_VENDOR_AVM_SPEED " + boxFloat + " 方向角: " + this.$it);
                    if (boxFloat != null && boxFloat.floatValue() < 1.0f) {
                        str2 = this.this$0.TAG;
                        LogUtils.logI(str2, "车辆静止中不需要更新");
                        return Unit.INSTANCE;
                    }
                    String it = this.$it;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    float parseFloat = 360 - Float.parseFloat(it);
                    ((ActivityHomeBinding) this.this$0.getMVB()).liftTopConstraint.compassView.refreshAngle(parseFloat);
                    BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_compass, "" + parseFloat);
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                CoroutineScope coroutineScope;
                coroutineScope = HomeActivity.this.mScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass1(HomeActivity.this, str, null), 2, null);
            }
        };
        compass.observe(homeActivity, new Observer() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.initCallbackMonitoring$lambda$1(Function1.this, obj);
            }
        });
        ((HomeViewModel) getMVM()).getAirPressure().observe(homeActivity, new Observer() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.initCallbackMonitoring$lambda$2(HomeActivity.this, (String) obj);
            }
        });
        ((HomeViewModel) getMVM()).getAltitude().observe(homeActivity, new Observer() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda10
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.initCallbackMonitoring$lambda$3(HomeActivity.this, (String) obj);
            }
        });
        ((ActivityHomeBinding) getMVB()).rightTopConstraint.rightTopDial.post(new Runnable() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                HomeActivity.initCallbackMonitoring$lambda$4(HomeActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCallbackMonitoring$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initCallbackMonitoring$lambda$2(HomeActivity this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AltitudeView altitudeView = ((ActivityHomeBinding) this$0.getMVB()).rightTopConstraint.rightTopDial;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        altitudeView.setAirPressure(Float.parseFloat(it));
        BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_airpressure, "" + Float.parseFloat(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initCallbackMonitoring$lambda$3(HomeActivity this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AltitudeView altitudeView = ((ActivityHomeBinding) this$0.getMVB()).rightTopConstraint.rightTopDial;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        altitudeView.setAltitude(Float.parseFloat(it));
        BuryServiceUtils.getInstance().setBurialPointAppOptions(BuryKeyConst.CH_BI_Key_altitude, "" + Float.parseFloat(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initCallbackMonitoring$lambda$4(HomeActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ActivityHomeBinding) this$0.getMVB()).rightTopConstraint.rightTopDial.setAltitude(0.0f);
        ((ActivityHomeBinding) this$0.getMVB()).rightTopConstraint.rightTopDial.setAirPressure(0.0f);
    }

    public final DrivingModeDialog getMDrivingDialog() {
        return this.mDrivingDialog;
    }

    public final void setMDrivingDialog(DrivingModeDialog drivingModeDialog) {
        this.mDrivingDialog = drivingModeDialog;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.landmark.hmimvvmbase.BaseActivity, com.landmark.hmibase.FunctionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CarSettingController.getInstance().release();
        CoroutineScopeKt.cancel$default(this.mScope, null, 1, null);
        if (this.intent != null) {
            ICrossService iCrossService = this.mICrossService;
            if (iCrossService != null) {
                iCrossService.unregister(this.mICrossCallback);
            }
            unbindService(this.serviceConnection);
        }
        ((ActivityHomeBinding) getMVB()).fourZoneWheel.stopAnimation(false);
        clearAnimation();
        BuryServiceUtils.getInstance().setBurialPointAppQuit();
    }

    private final void registerResult() {
        CarSettingController.getInstance().setResultCallback(new CarSettingManager.ResultCallback() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$registerResult$1
            @Override // com.autolink.car.client.CarSettingManager.ResultCallback
            public void onResult(String p0, String p1) {
                CoroutineScope coroutineScope;
                coroutineScope = HomeActivity.this.mScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new HomeActivity$registerResult$1$onResult$1(p0, p1, HomeActivity.this, null), 2, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void init() {
        ICrossService iCrossService = this.mICrossService;
        Integer valueOf = iCrossService != null ? Integer.valueOf(iCrossService.canGetVehicleParam(ALVehicleControlProperty.VEHICLE_PROPERTY_KEY_STS)) : null;
        LogUtils.logI(this.TAG, "VEHICLE_PROPERTY_KEY_STS code " + valueOf);
        this.stsStatus = valueOf != null ? valueOf.intValue() : 0;
        initWadingRadar();
        registerResult();
        ((ActivityHomeBinding) getMVB()).wadingRadar.setOnTouchListener(new View.OnTouchListener() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean init$lambda$5;
                init$lambda$5 = HomeActivity.init$lambda$5(HomeActivity.this, view, motionEvent);
                return init$lambda$5;
            }
        });
        CrossSwitchCompat crossSwitchCompat = ((ActivityHomeBinding) getMVB()).wadingRadar;
        Intrinsics.checkNotNullExpressionValue(crossSwitchCompat, "mVB.wadingRadar");
        CrossSwitchCompat crossSwitchCompat2 = ((ActivityHomeBinding) getMVB()).wadingRadar;
        Intrinsics.checkNotNullExpressionValue(crossSwitchCompat2, "mVB.wadingRadar");
        KtExtensionKt.setFastOnClickListener(crossSwitchCompat, crossSwitchCompat2, new View.OnClickListener() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.init$lambda$6(HomeActivity.this, view);
            }
        });
        ((ActivityHomeBinding) getMVB()).crossRadiating.setOnClickListener(new View.OnClickListener() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.init$lambda$7(HomeActivity.this, view);
            }
        });
        ((ActivityHomeBinding) getMVB()).crossSlowDescent.setOnClickListener(new View.OnClickListener() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.init$lambda$8(HomeActivity.this, view);
            }
        });
        ((ActivityHomeBinding) getMVB()).crossDisabledStabilization.setOnClickListener(new View.OnClickListener() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeActivity.init$lambda$9(HomeActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean init$lambda$5(HomeActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 0 || WadingRadarManager.INSTANCE.getInstance().isXMode()) {
            return false;
        }
        LogUtils.logI(this$0.TAG, "VEHICLE_PROPERTY_KEY_STS code" + this$0.stsStatus);
        if (this$0.stsStatus == 2) {
            return false;
        }
        ((ActivityHomeBinding) this$0.getMVB()).wadingRadar.setChecked(false);
        Toast.makeText(this$0.getApplicationContext(), this$0.getResources().getString(R.string.toast_tips_01), 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void init$lambda$6(HomeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (!((ActivityHomeBinding) this$0.getMVB()).wadingRadar.isChecked()) {
                CarSettingController.getInstance().setSettingsProperty(CarContact.WADING_RADAR, "0");
                LogUtils.logI(this$0.TAG, " wadingRadar off");
                this$0.visibilityFordingDepth("0");
                DelayRecoveryUtils companion = DelayRecoveryUtils.INSTANCE.getInstance();
                CrossSwitchCompat crossSwitchCompat = ((ActivityHomeBinding) this$0.getMVB()).wadingRadar;
                Intrinsics.checkNotNullExpressionValue(crossSwitchCompat, "mVB.wadingRadar");
                companion.setEnable(crossSwitchCompat, false, WadingRadarManager.INSTANCE.getWadingRadarDelayKey());
                LogUtils.logI(this$0.TAG, "set  wadingRadar isEnabled false");
            } else {
                CarSettingController.getInstance().setSettingsProperty(CarContact.WADING_RADAR, "1");
                this$0.visibilityFordingDepth("1");
                DelayRecoveryUtils companion2 = DelayRecoveryUtils.INSTANCE.getInstance();
                CrossSwitchCompat crossSwitchCompat2 = ((ActivityHomeBinding) this$0.getMVB()).wadingRadar;
                Intrinsics.checkNotNullExpressionValue(crossSwitchCompat2, "mVB.wadingRadar");
                companion2.setEnable(crossSwitchCompat2, false, WadingRadarManager.INSTANCE.getWadingRadarDelayKey());
                LogUtils.logI(this$0.TAG, "set  wadingRadar isEnabled false");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void init$lambda$7(HomeActivity this$0, View view) {
        Integer valueOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (CrossAllUtils.getProperty(CrossAllUtils.POWER_KEY).equals("0")) {
            ICrossService iCrossService = this$0.mICrossService;
            valueOf = iCrossService != null ? Integer.valueOf(iCrossService.canGetVehicleParam(609)) : null;
            LogUtils.logI("crossRadiating", " code1" + valueOf);
            if (valueOf != null && valueOf.intValue() == 0) {
                ((ActivityHomeBinding) this$0.getMVB()).crossRadiating.setChecked(false);
                Toast.makeText(this$0.getApplicationContext(), this$0.getResources().getString(R.string.toast_tips_03), 0).show();
                return;
            }
        } else {
            ICrossService iCrossService2 = this$0.mICrossService;
            valueOf = iCrossService2 != null ? Integer.valueOf(iCrossService2.canGetVehicleParam(ALVehicleControlProperty.VEHICLE_PROPERTY_PHEV_PTREADY)) : null;
            LogUtils.logI("crossRadiating", " code2" + valueOf);
            if (valueOf == null || valueOf.intValue() != 1) {
                ((ActivityHomeBinding) this$0.getMVB()).crossRadiating.setChecked(false);
                Toast.makeText(this$0.getApplicationContext(), this$0.getResources().getString(R.string.toast_tips_04), 0).show();
                return;
            }
        }
        if (!((ActivityHomeBinding) this$0.getMVB()).crossRadiating.isChecked()) {
            CarSettingController.getInstance().setSettingsProperty("559", CarContact.Status.COMMON_OFF);
        } else {
            CarSettingController.getInstance().setSettingsProperty("559", CarContact.Status.COMMON_ON);
        }
        LogUtils.logI(this$0.TAG, "set  crossRadiating isEnabled false");
        DelayRecoveryUtils companion = DelayRecoveryUtils.INSTANCE.getInstance();
        CrossSwitchCompat crossSwitchCompat = ((ActivityHomeBinding) this$0.getMVB()).crossRadiating;
        Intrinsics.checkNotNullExpressionValue(crossSwitchCompat, "mVB.crossRadiating");
        companion.setEnable(crossSwitchCompat, false, ALVehicleControlProperty.VEHICLE_PROPERTY_VC_COOL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void init$lambda$8(HomeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!((ActivityHomeBinding) this$0.getMVB()).crossSlowDescent.isChecked()) {
            CarSettingController.getInstance().setSettingsProperty("523", "0x2");
        } else {
            CarSettingController.getInstance().setSettingsProperty("523", CarContact.Status.COMMON_ON);
        }
        DelayRecoveryUtils companion = DelayRecoveryUtils.INSTANCE.getInstance();
        CrossSwitchCompat crossSwitchCompat = ((ActivityHomeBinding) this$0.getMVB()).crossSlowDescent;
        Intrinsics.checkNotNullExpressionValue(crossSwitchCompat, "mVB.crossSlowDescent");
        companion.setEnable(crossSwitchCompat, false, ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_HDC);
        LogUtils.logI(this$0.TAG, "set  crossSlowDescent isEnabled false");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void init$lambda$9(HomeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!((ActivityHomeBinding) this$0.getMVB()).crossDisabledStabilization.isChecked()) {
            CarSettingController.getInstance().setSettingsProperty("522", "0x2");
        } else {
            CarSettingController.getInstance().setSettingsProperty("522", CarContact.Status.COMMON_ON);
        }
        DelayRecoveryUtils companion = DelayRecoveryUtils.INSTANCE.getInstance();
        CrossSwitchCompat crossSwitchCompat = ((ActivityHomeBinding) this$0.getMVB()).crossDisabledStabilization;
        Intrinsics.checkNotNullExpressionValue(crossSwitchCompat, "mVB.crossDisabledStabilization");
        companion.setEnable(crossSwitchCompat, false, ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_ESP);
        LogUtils.logI(this$0.TAG, "set  crossDisabledStabilization isEnabled false");
    }

    private final void initWadingRadar() {
        WadingRadarManager.INSTANCE.getInstance().init();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$initWadingRadar$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                LogUtils.logI("HomeActivity", "mShowWadingDepthLiveData observe value = " + it);
                DelayRecoveryUtils companion = DelayRecoveryUtils.INSTANCE.getInstance();
                CrossSwitchCompat crossSwitchCompat = ((ActivityHomeBinding) HomeActivity.this.getMVB()).wadingRadar;
                Intrinsics.checkNotNullExpressionValue(crossSwitchCompat, "mVB.wadingRadar");
                companion.setEnable(crossSwitchCompat, true, WadingRadarManager.INSTANCE.getWadingRadarDelayKey());
                if (HomeActivity.this.getStsStatus() != 2) {
                    ((ActivityHomeBinding) HomeActivity.this.getMVB()).wadingRadar.setChecked(false);
                    HomeActivity.this.visibilityFordingDepth("0");
                    return;
                }
                ((ActivityHomeBinding) HomeActivity.this.getMVB()).wadingRadar.setChecked(Intrinsics.areEqual(it, "1"));
                HomeActivity homeActivity = HomeActivity.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                homeActivity.visibilityFordingDepth(it);
                HomeActivity.this.wadingRadarSwitch();
            }
        };
        WadingRadarManager.INSTANCE.getInstance().getMShowWadingDepthLiveData().observe(this, new Observer() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeActivity.initWadingRadar$lambda$10(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWadingRadar$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void visibilityFordingDepth(final String value) {
        ((ActivityHomeBinding) getMVB()).wadingRadar.post(new Runnable() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                HomeActivity.visibilityFordingDepth$lambda$11(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void visibilityFordingDepth$lambda$11(String value, HomeActivity this$0) {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LogUtils.logI("HomeActivity", "visibilityFordingDepth value = " + value);
        if (Intrinsics.areEqual(value, "1")) {
            this$0.wadingRadarSwitch();
        } else {
            ((ActivityHomeBinding) this$0.getMVB()).maskDepth.showOmit();
        }
    }

    private final void bindService() {
        BuildersKt__Builders_commonKt.launch$default(this.mScope, null, null, new HomeActivity$bindService$1(this, null), 3, null);
    }

    public final void tireRotationChanges(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(AnimatorUtils.startTransparency(view, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearRotationChanges(View view) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof AnimatorSet)) {
            Object tag2 = view.getTag();
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type android.animation.AnimatorSet");
            ((AnimatorSet) tag2).cancel();
        }
        view.clearAnimation();
        view.setAnimation(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void clearAnimation() {
        ImageView imageView = ((ActivityHomeBinding) getMVB()).abnormalLiftTop;
        Intrinsics.checkNotNullExpressionValue(imageView, "mVB.abnormalLiftTop");
        clearRotationChanges(imageView);
        ImageView imageView2 = ((ActivityHomeBinding) getMVB()).abnormalLiftBot;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mVB.abnormalLiftBot");
        clearRotationChanges(imageView2);
        ImageView imageView3 = ((ActivityHomeBinding) getMVB()).abnormalRightTop;
        Intrinsics.checkNotNullExpressionValue(imageView3, "mVB.abnormalRightTop");
        clearRotationChanges(imageView3);
        ImageView imageView4 = ((ActivityHomeBinding) getMVB()).abnormalRightBot;
        Intrinsics.checkNotNullExpressionValue(imageView4, "mVB.abnormalRightBot");
        clearRotationChanges(imageView4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tireAlarm(ImageView src, String msg) {
        BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getMain(), null, new HomeActivity$tireAlarm$1(this, msg, src, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTyreValue(TextView textValue, TextView textUnit, TextView temperatureTex, TextView temperatureC, float pressureValue, int temperatureValue) {
        if (!(pressureValue == -1.0f)) {
            try {
                String formatDoubleValue = CommonalityUtils.getFormatDoubleValue(pressureValue);
                Intrinsics.checkNotNullExpressionValue(formatDoubleValue, "getFormatDoubleValue(pressureValue)");
                if (CommonalityUtils.pressureCompare(Float.parseFloat(formatDoubleValue))) {
                    textValue.setText("--");
                    textValue.setTextColor(getResources().getColor(R.color.color_016));
                    textUnit.setTextColor(getResources().getColor(R.color.color_016));
                } else {
                    textValue.setText(CommonalityUtils.getFormatOriginalValue(pressureValue));
                    textValue.setTextColor(getResources().getColor(R.color.color_024));
                    textUnit.setTextColor(getResources().getColor(R.color.color_023));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (temperatureValue != -1) {
            if (CommonalityUtils.temperatureCompare(temperatureValue)) {
                temperatureTex.setText("--");
                temperatureTex.setTextColor(getResources().getColor(R.color.color_016));
                temperatureC.setTextColor(getResources().getColor(R.color.color_016));
            } else {
                temperatureTex.setText("" + temperatureValue);
                temperatureTex.setTextColor(getResources().getColor(R.color.color_024));
                temperatureC.setTextColor(getResources().getColor(R.color.color_023));
            }
        }
    }

    public final void getDisplayParameter() {
        BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getIO(), null, new HomeActivity$getDisplayParameter$1(this, null), 2, null);
    }

    @Override // com.autolink.hmi.crosscountry.ui.base.CrossBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ((HomeViewModel) getMVM()).setSensorManager();
        initLastAngle();
    }

    private final void initLastAngle() {
        BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getMain(), null, new HomeActivity$initLastAngle$1(this, null), 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ((HomeViewModel) getMVM()).clearCompassListener();
    }

    public final float getFrontWheelSwerve() {
        return this.frontWheelSwerve;
    }

    public final void setFrontWheelSwerve(float f) {
        this.frontWheelSwerve = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void setSwerveAngle(float swerveAngle) {
        if (this.frontWheelSwerve == swerveAngle) {
            return;
        }
        this.frontWheelSwerve = swerveAngle;
        int i = (int) (swerveAngle / 13.56d);
        ((ActivityHomeBinding) getMVB()).crossAltitudeInfo.setText(getResources().getString(R.string.swerve_angle) + i + Typography.degree);
        LogUtils.logI(this.TAG, "convert convertAngle " + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wadingRadarSwitch() {
        BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getIO(), null, new HomeActivity$wadingRadarSwitch$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshStatus() {
        if (this.mICrossService == null) {
            return;
        }
        wadingRadarSwitch();
        BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getIO(), null, new HomeActivity$refreshStatus$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getPressureAlarm() {
        if (this.mICrossService != null) {
            BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getIO(), null, new HomeActivity$getPressureAlarm$1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getTorqueLock() {
        if (this.mICrossService != null) {
            BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getIO(), null, new HomeActivity$getTorqueLock$1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, java.lang.Object, java.lang.String] */
    public final void getDrivingMode(String mode) {
        if (this.mICrossService != null) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            if (mode != null) {
                if (Integer.parseInt(mode) == CrossAllUtils.DRIVER_MODE_X) {
                    ((ActivityHomeBinding) getMVB()).crossPressureInfo.postDelayed(new Runnable() { // from class: com.autolink.hmi.crosscountry.ui.HomeActivity$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomeActivity.getDrivingMode$lambda$12(Ref.ObjectRef.this, intRef, this);
                        }
                    }, 150L);
                } else {
                    ?? steerModeName = CrossAllUtils.getSteerModeName(Integer.parseInt(mode));
                    Intrinsics.checkNotNullExpressionValue(steerModeName, "getSteerModeName(mode.toInt())");
                    objectRef.element = steerModeName;
                    intRef.element = CrossAllUtils.getSteerModeImg(Integer.parseInt(mode));
                }
            } else {
                ICrossService iCrossService = this.mICrossService;
                Integer valueOf = iCrossService != null ? Integer.valueOf(iCrossService.getXModeDisplayStatus()) : null;
                if (valueOf != null && valueOf.intValue() == 1) {
                    ?? steerModeName2 = CrossAllUtils.getSteerModeName(CrossAllUtils.DRIVER_MODE_X);
                    Intrinsics.checkNotNullExpressionValue(steerModeName2, "getSteerModeName(CrossAllUtils.DRIVER_MODE_X)");
                    objectRef.element = steerModeName2;
                    intRef.element = CrossAllUtils.getSteerModeImg(CrossAllUtils.DRIVER_MODE_X);
                } else {
                    ICrossService iCrossService2 = this.mICrossService;
                    Intrinsics.checkNotNull(iCrossService2);
                    int driveMode = iCrossService2.getDriveMode();
                    ?? steerModeName3 = CrossAllUtils.getSteerModeName(driveMode);
                    Intrinsics.checkNotNullExpressionValue(steerModeName3, "getSteerModeName(driveMode)");
                    objectRef.element = steerModeName3;
                    intRef.element = CrossAllUtils.getSteerModeImg(driveMode);
                }
            }
            LogUtils.logI("getDrivingMode", "msg " + ((String) objectRef.element));
            BuildersKt__Builders_commonKt.launch$default(this.mScope, Dispatchers.getMain(), null, new HomeActivity$getDrivingMode$2(this, objectRef, intRef, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object, java.lang.String] */
    public static final void getDrivingMode$lambda$12(Ref.ObjectRef name, Ref.IntRef srcId, HomeActivity this$0) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(srcId, "$srcId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ?? steerModeName = CrossAllUtils.getSteerModeName(CrossAllUtils.DRIVER_MODE_X);
        Intrinsics.checkNotNullExpressionValue(steerModeName, "getSteerModeName(CrossAllUtils.DRIVER_MODE_X)");
        name.element = steerModeName;
        srcId.element = CrossAllUtils.getSteerModeImg(CrossAllUtils.DRIVER_MODE_X);
        ((ActivityHomeBinding) this$0.getMVB()).crossPressureInfo.setText((CharSequence) name.element);
        ((ActivityHomeBinding) this$0.getMVB()).crossPressureIcon.setImageDrawable(this$0.getDrawable(srcId.element));
    }
}
