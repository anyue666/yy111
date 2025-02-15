package com.autolink.adapterinterface.tbox2.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxFotaStateDisplayInfo;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxFotaUserComfirmInfo;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxOtaSubNodeInfo;
import com.autolink.adapterinterface.tbox2.ota.hidlresponse.TboxOtaSubNodeRefreshNowInfo;

/* loaded from: classes.dex */
public interface IOTACallback extends IInterface {

    public static class Default implements IOTACallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onCancelFotaReq() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onFotaStateDisplayReq(TboxFotaStateDisplayInfo tboxFotaStateDisplayInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onFotaUserComfirmReq(TboxFotaUserComfirmInfo tboxFotaUserComfirmInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onOtaSubNodeRefreshNowReq(TboxOtaSubNodeRefreshNowInfo tboxOtaSubNodeRefreshNowInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
        public void onOtaSubNodeReq(TboxOtaSubNodeInfo tboxOtaSubNodeInfo) throws RemoteException {
        }
    }

    void onCancelFotaReq() throws RemoteException;

    void onFotaStateDisplayReq(TboxFotaStateDisplayInfo tboxFotaStateDisplayInfo) throws RemoteException;

    void onFotaUserComfirmReq(TboxFotaUserComfirmInfo tboxFotaUserComfirmInfo) throws RemoteException;

    void onOtaSubNodeRefreshNowReq(TboxOtaSubNodeRefreshNowInfo tboxOtaSubNodeRefreshNowInfo) throws RemoteException;

    void onOtaSubNodeReq(TboxOtaSubNodeInfo tboxOtaSubNodeInfo) throws RemoteException;

    public static abstract class Stub extends Binder implements IOTACallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.ota.IOTACallback";
        static final int TRANSACTION_onCancelFotaReq = 5;
        static final int TRANSACTION_onFotaStateDisplayReq = 4;
        static final int TRANSACTION_onFotaUserComfirmReq = 2;
        static final int TRANSACTION_onOtaSubNodeRefreshNowReq = 3;
        static final int TRANSACTION_onOtaSubNodeReq = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOTACallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOTACallback)) {
                return (IOTACallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onOtaSubNodeReq(parcel.readInt() != 0 ? TboxOtaSubNodeInfo.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onFotaUserComfirmReq(parcel.readInt() != 0 ? TboxFotaUserComfirmInfo.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onOtaSubNodeRefreshNowReq(parcel.readInt() != 0 ? TboxOtaSubNodeRefreshNowInfo.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onFotaStateDisplayReq(parcel.readInt() != 0 ? TboxFotaStateDisplayInfo.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 5) {
                parcel.enforceInterface(DESCRIPTOR);
                onCancelFotaReq();
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IOTACallback {
            public static IOTACallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onOtaSubNodeReq(TboxOtaSubNodeInfo tboxOtaSubNodeInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxOtaSubNodeInfo != null) {
                        obtain.writeInt(1);
                        tboxOtaSubNodeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onOtaSubNodeReq(tboxOtaSubNodeInfo);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onFotaUserComfirmReq(TboxFotaUserComfirmInfo tboxFotaUserComfirmInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxFotaUserComfirmInfo != null) {
                        obtain.writeInt(1);
                        tboxFotaUserComfirmInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onFotaUserComfirmReq(tboxFotaUserComfirmInfo);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onOtaSubNodeRefreshNowReq(TboxOtaSubNodeRefreshNowInfo tboxOtaSubNodeRefreshNowInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxOtaSubNodeRefreshNowInfo != null) {
                        obtain.writeInt(1);
                        tboxOtaSubNodeRefreshNowInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onOtaSubNodeRefreshNowReq(tboxOtaSubNodeRefreshNowInfo);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onFotaStateDisplayReq(TboxFotaStateDisplayInfo tboxFotaStateDisplayInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxFotaStateDisplayInfo != null) {
                        obtain.writeInt(1);
                        tboxFotaStateDisplayInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onFotaStateDisplayReq(tboxFotaStateDisplayInfo);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTACallback
            public void onCancelFotaReq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCancelFotaReq();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOTACallback iOTACallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOTACallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOTACallback;
            return true;
        }

        public static IOTACallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
