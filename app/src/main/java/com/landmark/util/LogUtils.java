package com.landmark.util;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/* loaded from: classes.dex */
public class LogUtils {
    private static final String DEFAULT_TAG = "UndefineApp";
    private static final boolean LOGD_ON = true;
    private static final boolean LOGE_ON = true;
    private static final boolean LOGI_ON = true;
    private static final boolean LOGV_ON = true;
    private static final boolean LOGWTF_ON = true;
    private static final boolean LOGW_ON = true;
    private static final boolean LOG_ENABLE = true;
    private String sLogTag;

    private LogUtils() {
        this.sLogTag = "";
    }

    private static class LogUtilsHolder {
        private static final LogUtils INSTANCE = new LogUtils();

        private LogUtilsHolder() {
        }
    }

    public static LogUtils getInstance() {
        return LogUtilsHolder.INSTANCE;
    }

    @Deprecated
    public void init() {
        init(DEFAULT_TAG);
    }

    public void init(String str) {
        init(str, false, 0, 0, true);
    }

    public void init(String str, boolean z, int i, int i2, final boolean z2) {
        this.sLogTag = str;
        PrettyFormatStrategy build = PrettyFormatStrategy.newBuilder().showThreadInfo(z).methodCount(i).methodOffset(i2).tag(str).build();
        Logger.clearLogAdapters();
        Logger.addLogAdapter(new AndroidLogAdapter(build) { // from class: com.landmark.util.LogUtils.1
            public boolean isLoggable(int i3, String str2) {
                return z2;
            }
        });
    }

    public void d(String str, Object... objArr) {
        Logger.d(str, objArr);
    }

    public void d(String str, String str2, Object... objArr) {
        Logger.t(str).d(str2, objArr);
    }

    public void d(Object obj) {
        Logger.d(obj);
    }

    public void d(String str, Object obj) {
        Logger.t(str).d(obj);
    }

    public void json(String str) {
        Logger.json(str);
    }

    public void xml(String str) {
        Logger.xml(str);
    }

    public void w(String str, String str2, Object... objArr) {
        Logger.t(str).w(str2, objArr);
    }

    public void w(String str, Object... objArr) {
        Logger.w(str, objArr);
    }

    public void e(String str, Object... objArr) {
        Logger.e(str, objArr);
    }

    public void e(Throwable th, String str, Object... objArr) {
        Logger.e(th, str, objArr);
    }

    public void e(String str, String str2, Object... objArr) {
        Logger.t(str).e(str2, objArr);
    }

    public void e(Throwable th, String str, String str2, Object... objArr) {
        Logger.t(str2).e(th, str, objArr);
    }

    public void i(String str, Object... objArr) {
        Logger.i(str, objArr);
    }

    public void i(String str, String str2, Object... objArr) {
        Logger.t(str).i(str2, objArr);
    }

    public void wtf(String str, Object... objArr) {
        Logger.wtf(str, objArr);
    }

    public void wtf(String str, String str2, Object... objArr) {
        Logger.t(str).wtf(str2, objArr);
    }

    public void v(String str, Object... objArr) {
        Logger.v(str, objArr);
    }

    public void v(String str, String str2, Object... objArr) {
        Logger.t(str).v(str2, objArr);
    }
}
