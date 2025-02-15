package com.landmark.util;

import android.os.SystemProperties;

/* loaded from: classes.dex */
public class PropertyUtils {
    public static boolean set(String str, CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        try {
            SystemProperties.set(str, charSequence.toString());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean set(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        try {
            SystemProperties.set(str, str2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean set(String str, int i) {
        return set(str, "" + i);
    }

    public static boolean set(String str, short s) {
        return set(str, "" + ((int) s));
    }

    public static boolean set(String str, byte b) {
        return set(str, "" + ((int) b));
    }

    public static boolean set(String str, float f) {
        return set(str, "" + f);
    }

    public static boolean set(String str, long j) {
        return set(str, "" + j);
    }

    public static boolean set(String str, double d) {
        return set(str, "" + d);
    }

    public static boolean set(String str, boolean z) {
        return set(str, "" + z);
    }

    public static String get(String str) {
        return SystemProperties.get(str, "");
    }

    public static String get(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return SystemProperties.get(str, str2);
    }

    public static short getShort(String str) {
        try {
            return Short.parseShort(SystemProperties.get(str, ""));
        } catch (Exception unused) {
            return (short) -1;
        }
    }

    public static int getInt(String str) {
        return SystemProperties.getInt(str, -1);
    }

    public static int getInt(String str, int i) {
        return SystemProperties.getInt(str, i);
    }

    public static float getFloat(String str) {
        try {
            return Float.parseFloat(SystemProperties.get(str, ""));
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    public static long getLong(String str) {
        return SystemProperties.getLong(str, -1L);
    }

    public static long getLong(String str, long j) {
        return SystemProperties.getLong(str, j);
    }

    public static double getDouble(String str) {
        try {
            return Double.parseDouble(SystemProperties.get(str, ""));
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    public static boolean getBoolean(String str) {
        return SystemProperties.getBoolean(str, false);
    }

    public static boolean getBoolean(String str, boolean z) {
        return SystemProperties.getBoolean(str, z);
    }
}
