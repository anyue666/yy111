package com.autolink.adaptermanager;

import android.util.Log;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ALLog {
    private static final boolean DEBUG = Log.isLoggable("ALLog", 2);
    private static String TAG = "ALLog";

    public static void v(String str) {
        if (DEBUG) {
            Log.v(TAG, str);
        }
    }

    public static void v(String str, String str2) {
        if (DEBUG) {
            Log.v(TAG, str2);
        }
    }

    public static void d(String str) {
        if (DEBUG) {
            Log.d(TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (DEBUG) {
            Log.d(TAG, str2);
        }
    }

    public static void e(String str) {
        Log.e(TAG, str);
    }

    public static void e(String str, String str2) {
        Log.e(TAG, str2);
    }

    public static void i(String str) {
        Log.i(TAG, str);
    }

    public static void i(String str, String str2) {
        Log.i(TAG, str2);
    }

    public static void e(Throwable th, String str, String str2) {
        Log.e(TAG, str2, th);
    }

    public static void w(String str) {
        Log.w(TAG, str);
    }

    public static void w(String str, String str2) {
        Log.w(TAG, str2);
    }

    private static String buildMessage(String str, String str2) {
        String str3;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str3 = "<unknown>";
                break;
            }
            if (stackTrace[i].getClass().equals(ALLog.class)) {
                i++;
            } else {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                if (!isNumeric(substring2)) {
                    substring = substring2;
                }
                str3 = substring + "." + stackTrace[i].getMethodName();
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str3, str2);
    }

    private static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]+").matcher(str).matches();
    }
}
