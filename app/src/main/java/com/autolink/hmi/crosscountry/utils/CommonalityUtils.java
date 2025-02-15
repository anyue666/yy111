package com.autolink.hmi.crosscountry.utils;

import android.util.Log;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class CommonalityUtils {
    private static volatile CommonalityUtils uniqueSingleton;
    private static DecimalFormat decimalFormat = new DecimalFormat("#.0");
    private static DecimalFormat decimalDoubleFormat = new DecimalFormat("#.00");

    public static boolean pressureCompare(float f) {
        return f > 3.5f || f < 0.0f;
    }

    public static boolean temperatureCompare(int i) {
        float f = i;
        return f < -40.0f || f > 100.0f;
    }

    private CommonalityUtils() {
    }

    public static CommonalityUtils getInstance() {
        if (uniqueSingleton == null) {
            synchronized (CrossAllUtils.class) {
                if (uniqueSingleton == null) {
                    uniqueSingleton = new CommonalityUtils();
                }
            }
        }
        return uniqueSingleton;
    }

    public static String getFormatValue(float f) {
        try {
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat.format(f);
        } catch (Exception e) {
            e.printStackTrace();
            return f + "";
        }
    }

    public static String getFormatOriginalValue(float f) {
        try {
            String format = String.format("%.1f", Double.valueOf(Double.parseDouble(f + "")));
            System.out.println(format);
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return f + "";
        }
    }

    public static String getFormatDoubleValue(float f) {
        try {
            decimalDoubleFormat.setRoundingMode(RoundingMode.DOWN);
            String format = decimalDoubleFormat.format(f);
            Log.i("BarometerformatValue  ", "formatValue " + format);
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return f + "";
        }
    }
}
