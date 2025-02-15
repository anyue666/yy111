package com.autolink.adapterinterface.diag;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.diag.IALDiagCallback;

/* loaded from: classes.dex */
public interface IALDiag extends IInterface {

    public static class Default implements IALDiag {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.diag.IALDiag
        public int readInfoFromHal(int i) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.diag.IALDiag
        public int registerDiagCallback(IALDiagCallback iALDiagCallback, DiagListInfo diagListInfo) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.diag.IALDiag
        public int unregisterDiagCallback(IALDiagCallback iALDiagCallback) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.diag.IALDiag
        public int writeInfoToHal(DiagWriteReq diagWriteReq) throws RemoteException {
            return 0;
        }
    }

    int readInfoFromHal(int i) throws RemoteException;

    int registerDiagCallback(IALDiagCallback iALDiagCallback, DiagListInfo diagListInfo) throws RemoteException;

    int unregisterDiagCallback(IALDiagCallback iALDiagCallback) throws RemoteException;

    int writeInfoToHal(DiagWriteReq diagWriteReq) throws RemoteException;

    public static abstract class Stub extends Binder implements IALDiag {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.diag.IALDiag";
        static final int TRANSACTION_readInfoFromHal = 3;
        static final int TRANSACTION_registerDiagCallback = 1;
        static final int TRANSACTION_unregisterDiagCallback = 2;
        static final int TRANSACTION_writeInfoToHal = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALDiag asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALDiag)) {
                return (IALDiag) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int registerDiagCallback = registerDiagCallback(IALDiagCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? DiagListInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(registerDiagCallback);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                int unregisterDiagCallback = unregisterDiagCallback(IALDiagCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(unregisterDiagCallback);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                int readInfoFromHal = readInfoFromHal(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(readInfoFromHal);
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            int writeInfoToHal = writeInfoToHal(parcel.readInt() != 0 ? DiagWriteReq.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(writeInfoToHal);
            return true;
        }

        private static class Proxy implements IALDiag {
            public static IALDiag sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.diag.IALDiag
            public int registerDiagCallback(IALDiagCallback iALDiagCallback, DiagListInfo diagListInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALDiagCallback != null ? iALDiagCallback.asBinder() : null);
                    if (diagListInfo != null) {
                        obtain.writeInt(1);
                        diagListInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerDiagCallback(iALDiagCallback, diagListInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.diag.IALDiag
            public int unregisterDiagCallback(IALDiagCallback iALDiagCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALDiagCallback != null ? iALDiagCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().unregisterDiagCallback(iALDiagCallback);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.diag.IALDiag
            public int readInfoFromHal(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().readInfoFromHal(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.diag.IALDiag
            public int writeInfoToHal(DiagWriteReq diagWriteReq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (diagWriteReq != null) {
                        obtain.writeInt(1);
                        diagWriteReq.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().writeInfoToHal(diagWriteReq);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALDiag iALDiag) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALDiag == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALDiag;
            return true;
        }

        public static IALDiag getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
