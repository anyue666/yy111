package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOtaStateListener extends IInterface {

    public static class Default implements IOtaStateListener {
        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void SubNodeReqEnterFactoryAck(boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void SubNodeReqStartFactoryAck(boolean z) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void fotaStateDisplayRequest(FotaStateDisplayReq fotaStateDisplayReq) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void fotaUserComfirmRequest(FotaUserComfirmReq fotaUserComfirmReq) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void otaSubNodeRefreshNowRequest(long j, String str, int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void otaSubNodeReq(OtaSubNodeInfo otaSubNodeInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IOtaStateListener
        public void otaSubNodeStateReportAck(int i) throws RemoteException {
        }
    }

    void SubNodeReqEnterFactoryAck(boolean z) throws RemoteException;

    void SubNodeReqStartFactoryAck(boolean z) throws RemoteException;

    void fotaStateDisplayRequest(FotaStateDisplayReq fotaStateDisplayReq) throws RemoteException;

    void fotaUserComfirmRequest(FotaUserComfirmReq fotaUserComfirmReq) throws RemoteException;

    void otaSubNodeRefreshNowRequest(long j, String str, int i, int i2) throws RemoteException;

    void otaSubNodeReq(OtaSubNodeInfo otaSubNodeInfo) throws RemoteException;

    void otaSubNodeStateReportAck(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IOtaStateListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.IOtaStateListener";
        static final int TRANSACTION_SubNodeReqEnterFactoryAck = 6;
        static final int TRANSACTION_SubNodeReqStartFactoryAck = 7;
        static final int TRANSACTION_fotaStateDisplayRequest = 5;
        static final int TRANSACTION_fotaUserComfirmRequest = 3;
        static final int TRANSACTION_otaSubNodeRefreshNowRequest = 4;
        static final int TRANSACTION_otaSubNodeReq = 1;
        static final int TRANSACTION_otaSubNodeStateReportAck = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOtaStateListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOtaStateListener)) {
                return (IOtaStateListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    otaSubNodeReq(parcel.readInt() != 0 ? OtaSubNodeInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    otaSubNodeStateReportAck(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    fotaUserComfirmRequest(parcel.readInt() != 0 ? FotaUserComfirmReq.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    otaSubNodeRefreshNowRequest(parcel.readLong(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    fotaStateDisplayRequest(parcel.readInt() != 0 ? FotaStateDisplayReq.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    SubNodeReqEnterFactoryAck(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    SubNodeReqStartFactoryAck(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IOtaStateListener {
            public static IOtaStateListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.IOtaStateListener
            public void otaSubNodeReq(OtaSubNodeInfo otaSubNodeInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (otaSubNodeInfo != null) {
                        obtain.writeInt(1);
                        otaSubNodeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().otaSubNodeReq(otaSubNodeInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IOtaStateListener
            public void otaSubNodeStateReportAck(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().otaSubNodeStateReportAck(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IOtaStateListener
            public void fotaUserComfirmRequest(FotaUserComfirmReq fotaUserComfirmReq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (fotaUserComfirmReq != null) {
                        obtain.writeInt(1);
                        fotaUserComfirmReq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().fotaUserComfirmRequest(fotaUserComfirmReq);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IOtaStateListener
            public void otaSubNodeRefreshNowRequest(long j, String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().otaSubNodeRefreshNowRequest(j, str, i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IOtaStateListener
            public void fotaStateDisplayRequest(FotaStateDisplayReq fotaStateDisplayReq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (fotaStateDisplayReq != null) {
                        obtain.writeInt(1);
                        fotaStateDisplayReq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().fotaStateDisplayRequest(fotaStateDisplayReq);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IOtaStateListener
            public void SubNodeReqEnterFactoryAck(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().SubNodeReqEnterFactoryAck(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IOtaStateListener
            public void SubNodeReqStartFactoryAck(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().SubNodeReqStartFactoryAck(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOtaStateListener iOtaStateListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOtaStateListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOtaStateListener;
            return true;
        }

        public static IOtaStateListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
