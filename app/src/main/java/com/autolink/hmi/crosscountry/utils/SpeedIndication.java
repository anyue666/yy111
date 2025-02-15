package com.autolink.hmi.crosscountry.utils;

/* loaded from: classes.dex */
public class SpeedIndication {
    public static int getValue(String str, float f, float f2, boolean z) {
        if (Math.abs(f2) != 0.0f) {
            return (int) f2;
        }
        LogUtils.logI("TestJd" + str, "Math.abs(value2) == 0 value1 " + f + " value2 " + f2 + " 返回 " + f2);
        return (int) f2;
    }
}
