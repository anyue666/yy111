package com.autolink.adaptermanager.tbox2;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes.dex */
public abstract class TboxManagerBase {
    protected static final String TAG = "TboxManager";
    protected final TboxManager mTbox;

    protected void clearDeadBinder() {
    }

    public TboxManagerBase(TboxManager tboxManager) {
        this.mTbox = tboxManager;
    }

    protected Context getContext() {
        return this.mTbox.getContext();
    }

    protected Handler getHandler() {
        return this.mTbox.getHandler();
    }
}
