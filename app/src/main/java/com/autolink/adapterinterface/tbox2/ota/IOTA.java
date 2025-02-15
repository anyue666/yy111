package com.autolink.adapterinterface.tbox2.ota;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.ota.IOTACallback;

/* loaded from: classes.dex */
public interface IOTA extends IInterface {

    public static class Default implements IOTA {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
        public int cancelFotaAck(byte b) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
        public void fotaUserComfirmResponse(TboxFotaUserComfirm tboxFotaUserComfirm) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
        public void otaSubNodeRefreshNowResponse(long j, String str) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
        public void otaSubNodeStateReport(TboxOtaSubNodeState tboxOtaSubNodeState) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
        public void registerCallback(IOTACallback iOTACallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
        public void unregisterCallback(IOTACallback iOTACallback) throws RemoteException {
        }
    }

    int cancelFotaAck(byte b) throws RemoteException;

    void fotaUserComfirmResponse(TboxFotaUserComfirm tboxFotaUserComfirm) throws RemoteException;

    void otaSubNodeRefreshNowResponse(long j, String str) throws RemoteException;

    void otaSubNodeStateReport(TboxOtaSubNodeState tboxOtaSubNodeState) throws RemoteException;

    void registerCallback(IOTACallback iOTACallback) throws RemoteException;

    void unregisterCallback(IOTACallback iOTACallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IOTA {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.ota.IOTA";
        static final int TRANSACTION_cancelFotaAck = 6;
        static final int TRANSACTION_fotaUserComfirmResponse = 2;
        static final int TRANSACTION_otaSubNodeRefreshNowResponse = 3;
        static final int TRANSACTION_otaSubNodeStateReport = 1;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_unregisterCallback = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOTA asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOTA)) {
                return (IOTA) queryLocalInterface;
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
                    otaSubNodeStateReport(parcel.readInt() != 0 ? TboxOtaSubNodeState.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    fotaUserComfirmResponse(parcel.readInt() != 0 ? TboxFotaUserComfirm.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    otaSubNodeRefreshNowResponse(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(IOTACallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(IOTACallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int cancelFotaAck = cancelFotaAck(parcel.readByte());
                    parcel2.writeNoException();
                    parcel2.writeInt(cancelFotaAck);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IOTA {
            public static IOTA sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
            public void otaSubNodeStateReport(TboxOtaSubNodeState tboxOtaSubNodeState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxOtaSubNodeState != null) {
                        obtain.writeInt(1);
                        tboxOtaSubNodeState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().otaSubNodeStateReport(tboxOtaSubNodeState);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
            public void fotaUserComfirmResponse(TboxFotaUserComfirm tboxFotaUserComfirm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxFotaUserComfirm != null) {
                        obtain.writeInt(1);
                        tboxFotaUserComfirm.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().fotaUserComfirmResponse(tboxFotaUserComfirm);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
            public void otaSubNodeRefreshNowResponse(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().otaSubNodeRefreshNowResponse(j, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
            public void registerCallback(IOTACallback iOTACallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOTACallback != null ? iOTACallback.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iOTACallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
            public void unregisterCallback(IOTACallback iOTACallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOTACallback != null ? iOTACallback.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iOTACallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.ota.IOTA
            public int cancelFotaAck(byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancelFotaAck(b);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOTA iota) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iota == null) {
                return false;
            }
            Proxy.sDefaultImpl = iota;
            return true;
        }

        public static IOTA getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
