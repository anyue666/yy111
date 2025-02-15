package com.landmark.hmimvvmbase;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import com.autolink.carsetting.data.car.SystemContact;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IBaseComponents.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u0012\u0010\u0006\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/landmark/hmimvvmbase/IBaseComponents;", "VB", "Landroidx/databinding/ViewDataBinding;", "VM", "Landroidx/lifecycle/ViewModel;", "", "mVB", "getMVB", "()Landroidx/databinding/ViewDataBinding;", "mVM", "getMVM", "()Landroidx/lifecycle/ViewModel;", "onLayoutId", "", "context", "Landroid/content/Context;", "hmiMvvmBase_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IBaseComponents<VB extends ViewDataBinding, VM extends ViewModel> {
    VB getMVB();

    VM getMVM();

    int onLayoutId(Context context);

    /* compiled from: IBaseComponents.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <VB extends ViewDataBinding, VM extends ViewModel> int onLayoutId(IBaseComponents<VB, VM> iBaseComponents, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Type genericSuperclass = iBaseComponents.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                int i = 0;
                String obj = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0].toString();
                String substring = obj.substring(StringsKt.lastIndexOf$default((CharSequence) obj, ".", 0, false, 6, (Object) null) + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                String substring2 = substring.substring(0, StringsKt.lastIndexOf$default((CharSequence) substring, "Binding", 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                StringBuilder sb = new StringBuilder();
                char[] charArray = substring2.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                int length = charArray.length;
                int i2 = 0;
                while (i < length) {
                    char c = charArray[i];
                    int i3 = i2 + 1;
                    if (Character.isUpperCase(c) && i2 != 0) {
                        sb.append(SystemContact.VOICE_AREA_PARTITION);
                    }
                    String valueOf = String.valueOf(c);
                    Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase = valueOf.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    sb.append(lowerCase);
                    i++;
                    i2 = i3;
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "binding.lastIndexOf(\".\")….toString()\n            }");
                return context.getResources().getIdentifier(sb2, "layout", context.getPackageName());
            }
            throw new RuntimeException("Incorrect layout naming");
        }
    }
}
