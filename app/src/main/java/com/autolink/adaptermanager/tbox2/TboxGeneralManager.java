package com.autolink.adaptermanager.tbox2;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.general.IGeneral;
import com.autolink.adaptermanager.hardkey.KeyCodeExt;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TboxGeneralManager extends TboxManagerBase {
    private static final boolean DBG = true;
    private final Object mLock;
    private final IGeneral mService;

    public TboxGeneralManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        this.mLock = new Object();
        this.mService = IGeneral.Stub.asInterface(iBinder);
    }

    public String getVinCode() {
        Log.i("TboxManager", "getVinCode start");
        try {
            return this.mService.getVinCode();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getVinCode RemoteException " + e);
            return null;
        }
    }

    public int getYear() {
        Log.i("TboxManager", "getYear start");
        try {
            return this.mService.getYear();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getYear RemoteException " + e);
            return KeyCodeExt.KEYCODE_AL_R_LEFT;
        }
    }

    public int getMonth() {
        Log.i("TboxManager", "getMonth start");
        try {
            return this.mService.getMonth();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getMonth RemoteException " + e);
            return 1;
        }
    }

    public int getDay() {
        Log.i("TboxManager", "getDay start");
        try {
            return this.mService.getDay();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getDay RemoteException " + e);
            return 1;
        }
    }

    public String getSn() {
        Log.i("TboxManager", "getSn start");
        try {
            return this.mService.getSn();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getSn RemoteException " + e);
            return null;
        }
    }

    public String getIccid() {
        Log.i("TboxManager", "getIccid start");
        try {
            return this.mService.getIccid();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getIccid RemoteException " + e);
            return null;
        }
    }

    public String getHardVersion() {
        Log.i("TboxManager", "getHardVersion start");
        try {
            return this.mService.getHardVersion();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getHardVersion RemoteException " + e);
            return null;
        }
    }

    public String getSoftVersion() {
        Log.i("TboxManager", "getSoftVersion start");
        try {
            return this.mService.getSoftVersion();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getSoftVersion RemoteException " + e);
            return null;
        }
    }

    public String getSupplierIdertifier() {
        Log.i("TboxManager", "getSupplierIdertifier start");
        try {
            return this.mService.getSupplierIdertifier();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getSupplierIdertifier RemoteException " + e);
            return null;
        }
    }

    public String getPartNumber() {
        Log.i("TboxManager", "getPartNumber start");
        try {
            return this.mService.getPartNumber();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getPartNumber RemoteException " + e);
            return null;
        }
    }

    public String getImsi() {
        Log.i("TboxManager", "getImsi start");
        try {
            return this.mService.getImsi();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getImsi RemoteException " + e);
            return null;
        }
    }

    public String getImei() {
        Log.i("TboxManager", "getImei start");
        try {
            return this.mService.getImei();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getImei RemoteException " + e);
            return null;
        }
    }

    public ArrayList<String> getCarModelConfig() {
        Log.i("TboxManager", "getCarModelConfig start");
        try {
            return (ArrayList) this.mService.getCarModelConfig();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getCarModelConfig RemoteException " + e);
            return null;
        }
    }

    public String getDate() {
        Log.i("TboxManager", "getDate start");
        try {
            return this.mService.getDate();
        } catch (RemoteException e) {
            Log.e("TboxManager", "getDate RemoteException " + e);
            return null;
        }
    }
}
