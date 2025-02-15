package com.autolink.adaptermanager.tbox2;

import android.os.HandlerThread;
import android.util.ArrayMap;
import android.util.Log;

/* loaded from: classes.dex */
public final class TboxManagerUtils {
    private static final String TAG = "TBOXM.UTIL";
    private static final ArrayMap<String, HandlerThread> sHandlerThreads = new ArrayMap<>();

    private TboxManagerUtils() {
    }

    public static HandlerThread getHandlerThread(String str) {
        HandlerThread handlerThread;
        ArrayMap<String, HandlerThread> arrayMap = sHandlerThreads;
        synchronized (arrayMap) {
            handlerThread = arrayMap.get(str);
            if (handlerThread == null || !handlerThread.isAlive()) {
                Log.i(TAG, "Starting HandlerThread:" + str);
                handlerThread = new HandlerThread(str);
                handlerThread.start();
                arrayMap.put(str, handlerThread);
            }
        }
        return handlerThread;
    }
}
