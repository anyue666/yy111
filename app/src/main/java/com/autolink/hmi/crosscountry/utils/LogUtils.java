package com.autolink.hmi.crosscountry.utils;

import android.util.Log;

/* loaded from: classes.dex */
public class LogUtils {
    private static boolean DEBUG = false;
    public static final String DEFAULT_TAG = "Cross_";
    private static boolean ERROR = true;
    private static boolean INFO = true;
    private static boolean VERBOSE = true;
    private static boolean WARN = true;

    public static void init(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        DEBUG = z;
        VERBOSE = z2;
        WARN = z3;
        INFO = z4;
        ERROR = z5;
    }

    public static void logD(String str, String str2) {
        if (DEBUG) {
            Log.i(DEFAULT_TAG + str, "[thread:" + Thread.currentThread().getName() + "] - " + str2);
        }
    }

    public static void logV(String str, String str2) {
        if (VERBOSE) {
            Log.v(DEFAULT_TAG + str, "[thread:" + Thread.currentThread().getName() + "] - " + str2);
        }
    }

    public static void logI(String str, String str2) {
        if (INFO) {
            Log.i(DEFAULT_TAG + str, "[thread:" + Thread.currentThread().getName() + "] - " + str2);
        }
    }

    public static void logW(String str, String str2) {
        if (WARN) {
            Log.w(DEFAULT_TAG + str, "[thread:" + Thread.currentThread().getName() + "] - " + str2);
        }
    }

    public static void logE(String str, String str2) {
        if (ERROR) {
            Log.e(DEFAULT_TAG + str, "[thread:" + Thread.currentThread().getName() + "] - " + str2);
        }
    }
}
