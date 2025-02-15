package com.autolink.adaptermanager.diag;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.autolink.adapterinterface.diag.DiagListInfo;
import com.autolink.adapterinterface.diag.DiagReadResp;
import com.autolink.adapterinterface.diag.DiagWriteReq;
import com.autolink.adapterinterface.diag.DiagWriteResp;
import com.autolink.adapterinterface.diag.IALDiag;
import com.autolink.adapterinterface.diag.IALDiagCallback;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.ALLog;
import com.autolink.adaptermanager.IALManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;
import kotlin.UShort;

/* loaded from: classes.dex */
public class ALDiagManager extends ALBaseManager implements IALManager {
    private Map<String, IALDiagListener> mCallbackMap;
    private Map<String, Integer[]> mDidMap;
    private IALDiag mIALDiag;
    private IALDiagCallback mIALDiagCallback;

    public interface IALDiagListener {
        void onReadInfoFromHalReport(DiagReadResp diagReadResp);

        void onWriteInfoToHalReport(DiagWriteResp diagWriteResp);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    public ALDiagManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.mDidMap = new HashMap();
        this.mCallbackMap = new HashMap();
        this.mIALDiagCallback = new IALDiagCallback.Stub() { // from class: com.autolink.adaptermanager.diag.ALDiagManager.1
            @Override // com.autolink.adapterinterface.diag.IALDiagCallback
            public void readInfoFromHalReport(DiagReadResp diagReadResp) {
                ALLog.d("readInfoFromHalReport ");
                for (Map.Entry entry : ALDiagManager.this.mCallbackMap.entrySet()) {
                    IALDiagListener iALDiagListener = (IALDiagListener) entry.getValue();
                    Integer[] numArr = (Integer[]) ALDiagManager.this.mDidMap.get(entry.getKey());
                    int did = diagReadResp.getDid() & UShort.MAX_VALUE;
                    if (Arrays.asList(numArr).contains(Integer.valueOf(did))) {
                        ALLog.d("readInfoFromHalReport did " + did);
                        iALDiagListener.onReadInfoFromHalReport(diagReadResp);
                    }
                }
            }

            @Override // com.autolink.adapterinterface.diag.IALDiagCallback
            public void writeInfoToHalReport(DiagWriteResp diagWriteResp) {
                for (Map.Entry entry : ALDiagManager.this.mCallbackMap.entrySet()) {
                    IALDiagListener iALDiagListener = (IALDiagListener) entry.getValue();
                    Integer[] numArr = (Integer[]) ALDiagManager.this.mDidMap.get(entry.getKey());
                    int did = diagWriteResp.getDid() & UShort.MAX_VALUE;
                    if (Arrays.asList(numArr).contains(Integer.valueOf(did))) {
                        ALLog.d("writeInfoToHalReport did " + did);
                        iALDiagListener.onWriteInfoToHalReport(diagWriteResp);
                    }
                }
            }
        };
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent("com.autolink.diagservice.DiagService");
        intent.setPackage("com.autolink.diagservice");
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        this.mIALDiag = IALDiag.Stub.asInterface(iBinder);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        this.mIALDiag = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        this.mIALDiag = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void unbindService() {
        super.unbindService();
    }

    static /* synthetic */ Integer[] lambda$registerIALDiagListener$0(int i) {
        return new Integer[i];
    }

    public void registerIALDiagListener(IALDiagListener iALDiagListener, DiagListInfo diagListInfo, String str) {
        this.mDidMap.put(str, (Integer[]) Arrays.stream(diagListInfo.getDids()).boxed().toArray(new IntFunction() { // from class: com.autolink.adaptermanager.diag.ALDiagManager$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return ALDiagManager.lambda$registerIALDiagListener$0(i);
            }
        }));
        this.mCallbackMap.put(str, iALDiagListener);
        IALDiag iALDiag = this.mIALDiag;
        if (iALDiag == null) {
            ALLog.e("the binder is null !");
            return;
        }
        try {
            iALDiag.registerDiagCallback(this.mIALDiagCallback, diagListInfo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void unregisterIALDiagListener(IALDiagListener iALDiagListener, String str) {
        this.mDidMap.remove(str);
        this.mCallbackMap.remove(str);
        IALDiag iALDiag = this.mIALDiag;
        if (iALDiag == null) {
            ALLog.e("the binder is null !");
            return;
        }
        try {
            iALDiag.unregisterDiagCallback(this.mIALDiagCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void readInfoFromHal(int i) {
        IALDiag iALDiag = this.mIALDiag;
        if (iALDiag == null) {
            ALLog.e("the binder is null !");
            return;
        }
        try {
            iALDiag.readInfoFromHal(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void writeInfoToHal(DiagWriteReq diagWriteReq) {
        IALDiag iALDiag = this.mIALDiag;
        if (iALDiag == null) {
            ALLog.e("the binder is null !");
            return;
        }
        try {
            iALDiag.writeInfoToHal(diagWriteReq);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
