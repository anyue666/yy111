package com.autolink.adaptermanager;

/* loaded from: classes.dex */
public interface IALManager {

    public interface ServiceConnectionListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public interface ServiceConnectionListenerNew {
        void onServiceConnected(ALBaseManager aLBaseManager);

        void onServiceDisconnected();
    }
}
