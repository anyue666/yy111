package com.landmark.hmimvvmbase;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.landmark.hmibase.LandmarkActivity;
import com.landmark.hmimvvmbase.BaseViewModel;
import com.landmark.hmimvvmbase.IBaseComponents;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseActivity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014R\u001b\u0010\b\u001a\u00028\u00008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00028\u00018VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/landmark/hmimvvmbase/BaseActivity;", "VB", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/landmark/hmimvvmbase/BaseViewModel;", "Lcom/landmark/hmibase/LandmarkActivity;", "Lcom/landmark/hmimvvmbase/IBaseComponents;", "()V", "mVB", "getMVB", "()Landroidx/databinding/ViewDataBinding;", "mVB$delegate", "Lkotlin/Lazy;", "mVM", "getMVM", "()Lcom/landmark/hmimvvmbase/BaseViewModel;", "mVM$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRestart", "hmiMvvmBase_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseActivity<VB extends ViewDataBinding, VM extends BaseViewModel> extends LandmarkActivity implements IBaseComponents<VB, VM> {

    /* renamed from: mVB$delegate, reason: from kotlin metadata */
    private final Lazy mVB = LazyKt.lazy(new Function0<VB>(this) { // from class: com.landmark.hmimvvmbase.BaseActivity$mVB$2
        final /* synthetic */ BaseActivity<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVB; */
        @Override // kotlin.jvm.functions.Function0
        public final ViewDataBinding invoke() {
            BaseActivity<VB, VM> baseActivity = this.this$0;
            ViewDataBinding contentView = DataBindingUtil.setContentView(baseActivity, baseActivity.onLayoutId(baseActivity));
            Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, onLayoutId(this))");
            return contentView;
        }
    });

    /* renamed from: mVM$delegate, reason: from kotlin metadata */
    private final Lazy mVM = LazyKt.lazy(new Function0<VM>(this) { // from class: com.landmark.hmimvvmbase.BaseActivity$mVM$2
        final /* synthetic */ BaseActivity<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVM; */
        @Override // kotlin.jvm.functions.Function0
        public final BaseViewModel invoke() {
            Type genericSuperclass = this.this$0.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
                Class<BaseViewModel> cls = type instanceof Class ? (Class) type : null;
                if (cls == null) {
                    cls = BaseViewModel.class;
                }
                ViewModel viewModel = new ViewModelProvider(this.this$0).get(cls);
                Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type VM of com.landmark.hmimvvmbase.BaseActivity");
                return (BaseViewModel) viewModel;
            }
            ViewModel viewModel2 = new ViewModelProvider(this.this$0).get(BaseViewModel.class);
            Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type VM of com.landmark.hmimvvmbase.BaseActivity");
            return (BaseViewModel) viewModel2;
        }
    });

    @Override // com.landmark.hmimvvmbase.IBaseComponents
    public int onLayoutId(Context context) {
        return IBaseComponents.DefaultImpls.onLayoutId(this, context);
    }

    @Override // com.landmark.hmimvvmbase.IBaseComponents
    public VB getMVB() {
        Object value = this.mVB.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mVB>(...)");
        return (VB) value;
    }

    @Override // com.landmark.hmimvvmbase.IBaseComponents
    public VM getMVM() {
        return (VM) this.mVM.getValue();
    }

    @Override // com.landmark.hmibase.LandmarkActivity, com.landmark.hmibase.FunctionActivity, com.landmark.hmibase.SystemUIActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMVM();
        getLifecycle().addObserver(getMVM());
        getMVB();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        getMVM().onRestart();
    }

    @Override // com.landmark.hmibase.FunctionActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(getMVM());
    }
}
