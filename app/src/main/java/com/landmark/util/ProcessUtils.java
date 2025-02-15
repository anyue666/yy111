package com.landmark.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessUtils.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J<\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ@\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ@\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ@\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00132\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ \u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n¨\u0006\u0017"}, d2 = {"Lcom/landmark/util/ProcessUtils;", "", "()V", "openHome", "", "context", "Landroid/content/Context;", "startNormalApp", "", "packageName", "", "activityPath", "extras", "Landroid/os/Bundle;", "onFailedListener", "Lkotlin/Function0;", "key", "value", "", "", "startService", "Landroid/content/ComponentName;", "servicePath", "LibComUtil_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ProcessUtils {
    public static final ProcessUtils INSTANCE = new ProcessUtils();

    private ProcessUtils() {
    }

    public final boolean startNormalApp(Context context, String packageName, String activityPath, Bundle extras, Function0<Unit> onFailedListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(activityPath, "activityPath");
        Intent intent = new Intent();
        String str = packageName;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String obj = str.subSequence(i, length + 1).toString();
        String str2 = activityPath;
        int length2 = str2.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    break;
                }
                length2--;
            } else if (z4) {
                i2++;
            } else {
                z3 = true;
            }
        }
        intent.setComponent(new ComponentName(obj, str2.subSequence(i2, length2 + 1).toString()));
        intent.setAction("android.intent.action.MAIN");
        intent.addFlags(335544320);
        if (extras != null) {
            intent.putExtras(extras);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            if (onFailedListener != null) {
                onFailedListener.invoke();
            }
            return false;
        }
    }

    public static /* synthetic */ boolean startNormalApp$default(ProcessUtils processUtils, Context context, String str, String str2, String str3, CharSequence charSequence, Function0 function0, int i, Object obj) {
        if ((i & 32) != 0) {
            function0 = null;
        }
        return processUtils.startNormalApp(context, str, str2, str3, charSequence, (Function0<Unit>) function0);
    }

    public final boolean startNormalApp(Context context, String packageName, String activityPath, String key, CharSequence value, Function0<Unit> onFailedListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(activityPath, "activityPath");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundle = new Bundle();
        bundle.putCharSequence(key, value);
        return startNormalApp(context, packageName, activityPath, bundle, onFailedListener);
    }

    public static /* synthetic */ boolean startNormalApp$default(ProcessUtils processUtils, Context context, String str, String str2, String str3, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            function0 = null;
        }
        return processUtils.startNormalApp(context, str, str2, str3, i, (Function0<Unit>) function0);
    }

    public final boolean startNormalApp(Context context, String packageName, String activityPath, String key, int value, Function0<Unit> onFailedListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(activityPath, "activityPath");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = new Bundle();
        bundle.putInt(key, value);
        return startNormalApp(context, packageName, activityPath, bundle, onFailedListener);
    }

    public static /* synthetic */ boolean startNormalApp$default(ProcessUtils processUtils, Context context, String str, String str2, String str3, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 32) != 0) {
            function0 = null;
        }
        return processUtils.startNormalApp(context, str, str2, str3, z, (Function0<Unit>) function0);
    }

    public final boolean startNormalApp(Context context, String packageName, String activityPath, String key, boolean value, Function0<Unit> onFailedListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(activityPath, "activityPath");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = new Bundle();
        bundle.putBoolean(key, value);
        return startNormalApp(context, packageName, activityPath, bundle, onFailedListener);
    }

    public final void openHome(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(335544320);
        intent.addCategory("android.intent.category.HOME");
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final ComponentName startService(Context context, String packageName, String servicePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(servicePath, "servicePath");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, servicePath));
        intent.addFlags(268435456);
        try {
            return context.startService(intent);
        } catch (Exception unused) {
            return null;
        }
    }
}
