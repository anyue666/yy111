package com.autolink.adaptermanager.configuration;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.autolink.adapterinterface.configuration.IALConfiguration;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;

/* loaded from: classes.dex */
public class ALConfigurationManager extends ALBaseManager implements IALManager {
    private IALConfiguration mIALConfiguration;

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    public ALConfigurationManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent("com.autolink.configurationservice.ConfigurationService");
        intent.setPackage("com.autolink.configurationservice");
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        this.mIALConfiguration = IALConfiguration.Stub.asInterface(iBinder);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        this.mIALConfiguration = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        this.mIALConfiguration = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void unbindService() {
        super.unbindService();
    }

    public void updateCountryCodeForWifiAndTuner(int i) {
        IALConfiguration iALConfiguration = this.mIALConfiguration;
        if (iALConfiguration != null) {
            try {
                iALConfiguration.updateCountryCodeForWifiAndTuner(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyUpdateTimeZone() {
        IALConfiguration iALConfiguration = this.mIALConfiguration;
        if (iALConfiguration != null) {
            try {
                iALConfiguration.notifyUpdateTimeZone();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
