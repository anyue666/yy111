package com.autolink.adaptermanager.tbox2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.autolink.adapterinterface.tbox2.usb.IUSB;
import com.autolink.adapterinterface.tbox2.usb.IUSBCallback;
import com.autolink.adapterinterface.tbox2.usb.TboxUsbSubNodeEnterFactoryInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TboxUSBManager extends TboxManagerBase {
    private static final boolean DBG = true;
    private static int DEFAULT_REMOTE_CALL_FAIL = -1;
    private final HandlerThread mHandlerThread;
    IUSBCallback mIUSBCallback;
    private final Object mLock;
    private IUSB mService;
    private USBListener mUSBListener;
    private final USBManagerHandler mUSBManagerHandler;

    public interface USBListener {
        void subNodeReqEnterFactoryResp(byte b);

        void subNodeReqStartFactoryResp(byte b);
    }

    /* renamed from: com.autolink.adaptermanager.tbox2.TboxUSBManager$1 */
    class AnonymousClass1 extends IUSBCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
        public void subNodeReqEnterFactoryResp(byte b) {
            TboxUSBManager.this.mUSBManagerHandler.sendMessage(Message.obtain(TboxUSBManager.this.mUSBManagerHandler, 1, b, 0));
        }

        @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
        public void subNodeReqStartFactoryResp(byte b) {
            TboxUSBManager.this.mUSBManagerHandler.sendMessage(Message.obtain(TboxUSBManager.this.mUSBManagerHandler, 2, b, 0));
        }
    }

    private static final class USBManagerHandler extends Handler {
        private static final int MSG_ENTER_FACTORY_RESPONSE = 1;
        private static final int MSG_START_FACTORY_RESPONSE = 2;
        private final WeakReference<TboxUSBManager> mManager;

        /* synthetic */ USBManagerHandler(Looper looper, TboxUSBManager tboxUSBManager, AnonymousClass1 anonymousClass1) {
            this(looper, tboxUSBManager);
        }

        private USBManagerHandler(Looper looper, TboxUSBManager tboxUSBManager) {
            super(looper);
            Log.i("TboxManager", "USBManagerHandler start");
            this.mManager = new WeakReference<>(tboxUSBManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TboxUSBManager tboxUSBManager = this.mManager.get();
            if (tboxUSBManager == null) {
                Log.e("TboxManager", "handleMessage manager is null");
                return;
            }
            int i = message.what;
            if (i == 1) {
                tboxUSBManager.notifyListenerSubNodeReqEnterFactoryResp((byte) message.arg1);
            } else {
                if (i != 2) {
                    return;
                }
                tboxUSBManager.notifyListenerSubNodeReqStartFactoryResp((byte) message.arg1);
            }
        }
    }

    public void notifyListenerSubNodeReqEnterFactoryResp(byte b) {
        USBListener uSBListener;
        synchronized (this.mLock) {
            uSBListener = this.mUSBListener;
        }
        uSBListener.subNodeReqEnterFactoryResp(b);
    }

    public void notifyListenerSubNodeReqStartFactoryResp(byte b) {
        USBListener uSBListener;
        synchronized (this.mLock) {
            uSBListener = this.mUSBListener;
        }
        uSBListener.subNodeReqStartFactoryResp(b);
    }

    public TboxUSBManager(TboxManager tboxManager, IBinder iBinder) {
        super(tboxManager);
        this.mLock = new Object();
        HandlerThread handlerThread = TboxManagerUtils.getHandlerThread("TboxUSBManager");
        this.mHandlerThread = handlerThread;
        this.mUSBManagerHandler = new USBManagerHandler(handlerThread.getLooper(), this);
        this.mIUSBCallback = new IUSBCallback.Stub() { // from class: com.autolink.adaptermanager.tbox2.TboxUSBManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
            public void subNodeReqEnterFactoryResp(byte b) {
                TboxUSBManager.this.mUSBManagerHandler.sendMessage(Message.obtain(TboxUSBManager.this.mUSBManagerHandler, 1, b, 0));
            }

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
            public void subNodeReqStartFactoryResp(byte b) {
                TboxUSBManager.this.mUSBManagerHandler.sendMessage(Message.obtain(TboxUSBManager.this.mUSBManagerHandler, 2, b, 0));
            }
        };
        this.mService = IUSB.Stub.asInterface(iBinder);
    }

    public void setListener(USBListener uSBListener) {
        Log.i("TboxManager", "setListener in TboxUSBManager start ");
        synchronized (this.mLock) {
            if (this.mUSBListener == null) {
                registerCallback(this.mIUSBCallback);
            }
            this.mUSBListener = uSBListener;
        }
    }

    public void removeListener() {
        synchronized (this.mLock) {
            this.mUSBListener = null;
            unregisterCallback(this.mIUSBCallback);
        }
    }

    public void subNodeEnterFactory(TboxUsbSubNodeEnterFactoryInfo tboxUsbSubNodeEnterFactoryInfo) {
        if (tboxUsbSubNodeEnterFactoryInfo == null) {
            Log.e("TboxManager", "subNodeEnterFactory in TboxUSBManager req is null");
            return;
        }
        Log.i("TboxManager", "subNodeEnterFactory in TboxUSBManager start " + tboxUsbSubNodeEnterFactoryInfo.toString());
        try {
            this.mService.subNodeEnterFactory(tboxUsbSubNodeEnterFactoryInfo);
        } catch (RemoteException e) {
            Log.e("TboxManager", "subNodeEnterFactory RemoteException " + e);
        }
    }

    public void SubNodeStartFactory(byte b) {
        Log.i("TboxManager", "SubNodeStartFactory in manager " + ((int) b));
        try {
            this.mService.SubNodeStartFactory(b);
        } catch (RemoteException e) {
            Log.e("TboxManager", "SubNodeStartFactory RemoteException " + e);
        }
    }

    private void registerCallback(IUSBCallback iUSBCallback) {
        Log.i("TboxManager", "registerCallback in TboxUSBManager start");
        try {
            this.mService.registerCallback(iUSBCallback);
        } catch (RemoteException e) {
            Log.e("TboxManager", "registerCallback RemoteException " + e);
        }
    }

    private void unregisterCallback(IUSBCallback iUSBCallback) {
        Log.i("TboxManager", "unregisterCallback in TboxUSBManager start");
        try {
            IUSB iusb = this.mService;
            if (iusb != null) {
                iusb.unregisterCallback(iUSBCallback);
            }
        } catch (RemoteException e) {
            Log.e("TboxManager", "unregisterCallback RemoteException " + e);
        }
    }

    @Override // com.autolink.adaptermanager.tbox2.TboxManagerBase
    protected void clearDeadBinder() {
        if (this.mService != null) {
            Log.d("TboxManager", "TboxRemoteManager clearDeadBinder");
            this.mService = null;
        }
    }
}
