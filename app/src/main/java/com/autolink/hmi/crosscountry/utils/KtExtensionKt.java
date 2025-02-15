package com.autolink.hmi.crosscountry.utils;

import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.autolink.carsetting.data.ViewSignalBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: KtExtension.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u001a*\u0010\u0006\u001a\u00020\u0007*\u000e\u0012\u0002\b\u00030\bj\u0006\u0012\u0002\b\u0003`\t2\u0012\u0010\n\u001a\u000e\u0012\u0002\b\u00030\bj\u0006\u0012\u0002\b\u0003`\t\u001aÃ\u0001\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\u0012\u0012\u0004\u0012\u0002H\f0\bj\b\u0012\u0004\u0012\u0002H\f`\t2$\b\u0002\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2$\b\u0002\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2$\b\u0002\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2$\b\u0002\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018\u001a\"\u0010\u0019\u001a\u00020\u0007*\u0012\u0012\u0004\u0012\u00020\u001a0\bj\b\u0012\u0004\u0012\u00020\u001a`\t2\u0006\u0010\u001b\u001a\u00020\u0003\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u0003\u001a\n\u0010\u001e\u001a\u00020\u0003*\u00020\u001d\u001a&\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\f0\bj\b\u0012\u0004\u0012\u0002H\f`\t\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0 \u001a\u0012\u0010!\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"elapsedTimeRun", "", "prefix", "", "run", "Lkotlin/Function0;", "equalAll", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", TypedValues.AttributesType.S_TARGET, "forEachRunBlock", "T", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "center", "end", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFastOnClickListener", "Landroidx/appcompat/widget/SwitchCompat;", "view", "onClickListener", "Landroid/view/View$OnClickListener;", "signalContains", "Lcom/autolink/carsetting/data/ViewSignalBean;", "signalValue", "to10Int", "", "to16String", "toArrayList", "", "trim", "indexStr", "ALXMode_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KtExtensionKt {
    public static final int to10Int(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "0x", false, 2, (Object) null)) {
            return Integer.parseInt(StringsKt.replace$default(str, "0x", "", false, 4, (Object) null), CharsKt.checkRadix(16));
        }
        if (!(str2.length() > 0)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            LogUtils.logE("to10Int", "to10Int error value:" + str);
            return 0;
        }
    }

    public static final String trim(String str, String indexStr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(indexStr, "indexStr");
        String str2 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, indexStr, 0, false, 6, (Object) null) + 1;
        if (indexOf$default >= 0 && indexOf$default < str.length()) {
            str = str.substring(indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str2, indexStr, 0, false, 6, (Object) null) - 1;
        if (lastIndexOf$default < 0) {
            return str;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String to16String(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String hexString = Integer.toHexString(i);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String upperCase = hexString.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return sb.append(upperCase).toString();
    }

    public static final boolean equalAll(ArrayList<?> arrayList, ArrayList<?> target) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        ArrayList<?> arrayList2 = arrayList;
        ArrayList<?> arrayList3 = target;
        return arrayList2.containsAll(arrayList3) && arrayList3.containsAll(arrayList2);
    }

    public static final <T> ArrayList<T> toArrayList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList<>(collection);
    }

    public static final void elapsedTimeRun(String prefix, Function0<Unit> run) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(run, "run");
        long currentTimeMillis = System.currentTimeMillis();
        LogUtils.logI("elapsedTimeRun", prefix + " originTime:" + currentTimeMillis);
        run.invoke();
        long currentTimeMillis2 = System.currentTimeMillis();
        LogUtils.logI("elapsedTimeRun", prefix + " offset:" + (currentTimeMillis2 - currentTimeMillis) + " endTime:" + currentTimeMillis2);
    }

    public static final boolean signalContains(ArrayList<ViewSignalBean> arrayList, String signalValue) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(signalValue, "signalValue");
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((ViewSignalBean) obj).getValue(), signalValue)) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x010b -> B:25:0x010f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object forEachRunBlock(java.util.ArrayList<T> r20, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r21, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r22, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r23, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autolink.hmi.crosscountry.utils.KtExtensionKt.forEachRunBlock(java.util.ArrayList, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object forEachRunBlock$default(ArrayList arrayList, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new KtExtensionKt$forEachRunBlock$2(null);
        }
        Function2 function25 = function2;
        if ((i & 2) != 0) {
            function22 = new KtExtensionKt$forEachRunBlock$3(null);
        }
        Function2 function26 = function22;
        if ((i & 4) != 0) {
            function23 = new KtExtensionKt$forEachRunBlock$4(null);
        }
        Function2 function27 = function23;
        if ((i & 8) != 0) {
            function24 = new KtExtensionKt$forEachRunBlock$5(null);
        }
        return forEachRunBlock(arrayList, function25, function26, function27, function24, continuation);
    }

    public static final void setFastOnClickListener(SwitchCompat switchCompat, final SwitchCompat view, final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(switchCompat, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        switchCompat.setOnClickListener(new View.OnClickListener() { // from class: com.autolink.hmi.crosscountry.utils.KtExtensionKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                KtExtensionKt.setFastOnClickListener$lambda$3(SwitchCompat.this, onClickListener, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFastOnClickListener$lambda$3(SwitchCompat view, View.OnClickListener onClickListener, View view2) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        if (ClickUtil.isFastClick$default(ClickUtil.INSTANCE, null, 1, null)) {
            view.setChecked(!view.isChecked());
            LogUtils.logI("KtExtension", "SwitchCompat.setFastOnClickListener 判定为快速点击");
        } else {
            onClickListener.onClick(view2);
        }
    }
}
