package com.autolink.adapterinterface.tbox2.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.remote.IRemoteCallback;

/* loaded from: classes.dex */
public interface IRemote extends IInterface {

    public static class Default implements IRemote {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
        public void getEcuVersion(int[] iArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
        public void lightShowCtrlResp(byte b, byte b2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
        public void registerCallback(IRemoteCallback iRemoteCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
        public void unregisterCallback(IRemoteCallback iRemoteCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
        public void uploadResult(long j) throws RemoteException {
        }
    }

    void getEcuVersion(int[] iArr) throws RemoteException;

    void lightShowCtrlResp(byte b, byte b2) throws RemoteException;

    void registerCallback(IRemoteCallback iRemoteCallback) throws RemoteException;

    void unregisterCallback(IRemoteCallback iRemoteCallback) throws RemoteException;

    void uploadResult(long j) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemote {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.remote.IRemote";
        static final int TRANSACTION_getEcuVersion = 2;
        static final int TRANSACTION_lightShowCtrlResp = 1;
        static final int TRANSACTION_registerCallback = 4;
        static final int TRANSACTION_unregisterCallback = 5;
        static final int TRANSACTION_uploadResult = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemote asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemote)) {
                return (IRemote) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                lightShowCtrlResp(parcel.readByte(), parcel.readByte());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                getEcuVersion(parcel.createIntArray());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                uploadResult(parcel.readLong());
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                registerCallback(IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            unregisterCallback(IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IRemote {
            public static IRemote sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
            public void lightShowCtrlResp(byte b, byte b2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeByte(b2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().lightShowCtrlResp(b, b2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
            public void getEcuVersion(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getEcuVersion(iArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
            public void uploadResult(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().uploadResult(j);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
            public void registerCallback(IRemoteCallback iRemoteCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteCallback != null ? iRemoteCallback.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iRemoteCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemote
            public void unregisterCallback(IRemoteCallback iRemoteCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteCallback != null ? iRemoteCallback.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iRemoteCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemote iRemote) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemote == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemote;
            return true;
        }

        public static IRemote getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
