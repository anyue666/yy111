package com.landmark.hmimvvmbase;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.landmark.hmimvvmbase.BaseAndroidViewModel;
import com.landmark.hmimvvmbase.IBaseComponents;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAndroidFragment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0006B\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00028\u00008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00028\u00018VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/landmark/hmimvvmbase/BaseAndroidFragment;", "VB", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/landmark/hmimvvmbase/BaseAndroidViewModel;", "Landroidx/fragment/app/Fragment;", "Lcom/landmark/hmimvvmbase/IBaseComponents;", "()V", "container", "Landroid/view/ViewGroup;", "inflater", "Landroid/view/LayoutInflater;", "mContext", "Landroid/content/Context;", "mVB", "getMVB", "()Landroidx/databinding/ViewDataBinding;", "mVB$delegate", "Lkotlin/Lazy;", "mVM", "getMVM", "()Lcom/landmark/hmimvvmbase/BaseAndroidViewModel;", "mVM$delegate", "getContext", "onAttach", "", "context", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "hmiMvvmBase_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseAndroidFragment<VB extends ViewDataBinding, VM extends BaseAndroidViewModel> extends Fragment implements IBaseComponents<VB, VM> {
    private ViewGroup container;
    private LayoutInflater inflater;
    private Context mContext;

    /* renamed from: mVB$delegate, reason: from kotlin metadata */
    private final Lazy mVB = LazyKt.lazy(new Function0<VB>(this) { // from class: com.landmark.hmimvvmbase.BaseAndroidFragment$mVB$2
        final /* synthetic */ BaseAndroidFragment<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVB; */
        @Override // kotlin.jvm.functions.Function0
        public final ViewDataBinding invoke() {
            LayoutInflater layoutInflater;
            Context context;
            ViewGroup viewGroup;
            layoutInflater = ((BaseAndroidFragment) this.this$0).inflater;
            Context context2 = null;
            if (layoutInflater == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inflater");
                layoutInflater = null;
            }
            BaseAndroidFragment<VB, VM> baseAndroidFragment = this.this$0;
            context = ((BaseAndroidFragment) baseAndroidFragment).mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context2 = context;
            }
            int onLayoutId = baseAndroidFragment.onLayoutId(context2);
            viewGroup = ((BaseAndroidFragment) this.this$0).container;
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, onLayoutId, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, onLayo…ntext), container, false)");
            return inflate;
        }
    });

    /* renamed from: mVM$delegate, reason: from kotlin metadata */
    private final Lazy mVM = LazyKt.lazy(new Function0<VM>(this) { // from class: com.landmark.hmimvvmbase.BaseAndroidFragment$mVM$2
        final /* synthetic */ BaseAndroidFragment<VB, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVM; */
        @Override // kotlin.jvm.functions.Function0
        public final BaseAndroidViewModel invoke() {
            Type genericSuperclass = this.this$0.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
                Class<BaseAndroidViewModel> cls = type instanceof Class ? (Class) type : null;
                if (cls == null) {
                    cls = BaseAndroidViewModel.class;
                }
                ViewModelStoreOwner viewModelStoreOwner = this.this$0;
                ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.INSTANCE;
                Application application = this.this$0.requireActivity().getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "requireActivity().application");
                ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, companion.getInstance(application)).get(cls);
                Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type VM of com.landmark.hmimvvmbase.BaseAndroidFragment");
                return (BaseAndroidViewModel) viewModel;
            }
            ViewModel viewModel2 = new ViewModelProvider(this.this$0).get(BaseAndroidViewModel.class);
            Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type VM of com.landmark.hmimvvmbase.BaseAndroidFragment");
            return (BaseAndroidViewModel) viewModel2;
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

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.mContext = context;
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        this.inflater = inflater;
        this.container = container;
        getMVB();
        getLifecycle().addObserver(getMVM());
        getMVM().onCreateView();
        return getMVB().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(getMVM());
    }
}
