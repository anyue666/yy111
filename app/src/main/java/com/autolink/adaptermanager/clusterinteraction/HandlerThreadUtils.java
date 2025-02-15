package com.autolink.adaptermanager.clusterinteraction;

import android.os.HandlerThread;
import android.util.ArrayMap;
import com.autolink.adaptermanager.ALLog;

/* loaded from: classes.dex */
public final class HandlerThreadUtils {
    private static final ArrayMap<String, HandlerThread> sHandlerThreads = new ArrayMap<>();

    private HandlerThreadUtils() {
    }

    public static HandlerThread getHandlerThread(String str) {
        HandlerThread handlerThread;
        ArrayMap<String, HandlerThread> arrayMap = sHandlerThreads;
        synchronized (arrayMap) {
            handlerThread = arrayMap.get(str);
            if (handlerThread == null || !handlerThread.isAlive()) {
                ALLog.i("Starting HandlerThread:" + str);
                handlerThread = new HandlerThread(str);
                handlerThread.start();
                arrayMap.put(str, handlerThread);
            }
        }
        return handlerThread;
    }
}
