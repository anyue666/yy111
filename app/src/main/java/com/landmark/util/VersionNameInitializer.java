package com.landmark.util;

import android.car.Car;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.autolink.adaptermanager.ALManagerFactory;
import com.autolink.carsetting.data.car.SystemContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VersionNameInitializer.kt */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016JK\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001eJ9\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/landmark/util/VersionNameInitializer;", "Landroid/content/ContentProvider;", "()V", "handler", "Landroid/os/Handler;", "packageName", "", "printVersion", "com/landmark/util/VersionNameInitializer$printVersion$1", "Lcom/landmark/util/VersionNameInitializer$printVersion$1;", "printVersionCount", "", "versionName", "delete", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", Car.PROJECTION_SERVICE, "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", ALManagerFactory.UPDATE_SERVICE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "LibComUtil_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VersionNameInitializer extends ContentProvider {
    private int printVersionCount;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private String packageName = "";
    private String versionName = "";
    private final VersionNameInitializer$printVersion$1 printVersion = new Runnable() { // from class: com.landmark.util.VersionNameInitializer$printVersion$1
        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            String str;
            String str2;
            int i3;
            Handler handler;
            i = VersionNameInitializer.this.printVersionCount;
            if (i <= 3) {
                VersionNameInitializer versionNameInitializer = VersionNameInitializer.this;
                i2 = versionNameInitializer.printVersionCount;
                versionNameInitializer.printVersionCount = i2 + 1;
                str = VersionNameInitializer.this.packageName;
                StringBuilder sb = new StringBuilder("current version: ");
                str2 = VersionNameInitializer.this.versionName;
                StringBuilder append = sb.append(str2).append(" printCount = ");
                i3 = VersionNameInitializer.this.printVersionCount;
                Log.e(str, append.append(i3).toString());
                handler = VersionNameInitializer.this.handler;
                handler.postDelayed(this, 60000L);
            }
        }
    };

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            String packageName = context.getPackageName();
            String str = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "packageManager.getPackag…ckageName, 0).versionName");
            this.versionName = str;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            this.packageName = packageName;
            PropertyUtils.set(SystemContact.SS_Persist + packageName + ".version", this.versionName);
            Log.e(this.packageName, "current version: " + this.versionName);
            this.handler.postDelayed(this.printVersion, 60000L);
        }
        return false;
    }
}
