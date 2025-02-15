package com.autolink.voicemanager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.autolink.voicetts.IStatusCallBack;
import com.autolink.voicetts.IVoiceServiceInterface;

/* loaded from: classes.dex */
public class VoiceManager {
    public static final String TAG = "VoiceManager";
    public static Context mContext;
    public static volatile VoiceManager mInstance;
    public ConnectStatus mConnectStatus;
    public IVoiceServiceInterface mIVoiceServiceInterface;
    public IBinder.DeathRecipient mDeathProxy = new IBinder.DeathRecipient() { // from class: com.autolink.voicemanager.VoiceManager.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            VoiceManager voiceManager = VoiceManager.this;
            if (voiceManager.mIVoiceServiceInterface == null) {
                return;
            }
            ConnectStatus connectStatus = voiceManager.mConnectStatus;
            if (connectStatus != null) {
                connectStatus.disconnected();
            }
            VoiceManager.this.mIVoiceServiceInterface.asBinder().unlinkToDeath(VoiceManager.this.mDeathProxy, 0);
            VoiceManager.this.mIVoiceServiceInterface = null;
            VoiceManager.mContext = null;
        }
    };
    public ServiceConnection mServiceConn = new ServiceConnection() { // from class: com.autolink.voicemanager.VoiceManager.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VoiceManager.this.mIVoiceServiceInterface = IVoiceServiceInterface.Stub.asInterface(iBinder);
            ConnectStatus connectStatus = VoiceManager.this.mConnectStatus;
            if (connectStatus != null) {
                connectStatus.connected();
            }
            try {
                VoiceManager.this.mIVoiceServiceInterface.asBinder().linkToDeath(VoiceManager.this.mDeathProxy, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(VoiceManager.TAG, "onServiceDisconnected");
            VoiceManager voiceManager = VoiceManager.this;
            voiceManager.mIVoiceServiceInterface = null;
            ConnectStatus connectStatus = voiceManager.mConnectStatus;
            if (connectStatus != null) {
                connectStatus.disconnected();
            }
            VoiceManager.mContext = null;
        }
    };

    public static VoiceManager getInstance(Context context) {
        mContext = context.getApplicationContext();
        Log.e(TAG, "onContextSet:" + context.getPackageName());
        if (mInstance == null) {
            synchronized (VoiceManager.class) {
                if (mInstance == null) {
                    mInstance = new VoiceManager();
                }
            }
        }
        return mInstance;
    }

    public void init(ConnectStatus connectStatus) {
        this.mConnectStatus = connectStatus;
        Intent intent = new Intent();
        intent.setAction("com.autolink.voicetts.aidl.starttts");
        intent.setPackage("com.autolink.voiceassistant");
        Context context = mContext;
        if (context != null) {
            context.bindService(intent, this.mServiceConn, 1);
            Log.e(TAG, "onBindService:" + mContext.getPackageName());
        }
    }

    public void startSpeak(String str, String str2, IStatusCallBack iStatusCallBack, String str3) {
        try {
            this.mIVoiceServiceInterface.startSpeak(str, str2, iStatusCallBack, str3);
        } catch (Exception e) {
            Log.e(TAG, "Exception:" + e);
        }
    }

    public void stopSpeak(String str) {
        try {
            this.mIVoiceServiceInterface.stopSpeak(str);
        } catch (Exception e) {
            Log.e(TAG, "Exception:" + e);
        }
    }

    public void closeVpa() {
        try {
            this.mIVoiceServiceInterface.closeVpa();
        } catch (Exception e) {
            Log.e(TAG, "Exception:" + e);
        }
    }

    public void showTtsContent(String str) {
        try {
            this.mIVoiceServiceInterface.showTtsContent(str);
        } catch (Exception e) {
            Log.e(TAG, "Exception:" + e);
        }
    }

    public void release() {
        Context context = mContext;
        if (context != null) {
            context.unbindService(this.mServiceConn);
            Log.e(TAG, "onUnBindService:" + mContext.getPackageName());
            mContext = null;
        }
    }
}
