package com.autolink.adapterinterface.tbox2.pki;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.pki.IPKICallback;

/* loaded from: classes.dex */
public interface IPKI extends IInterface {

    public static class Default implements IPKI {
        @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
        public void CertificateStatusResponse(int i) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
        public void certificateRltReport(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
        public void registerPKICallback(IPKICallback iPKICallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
        public void unregisterPKICallback(IPKICallback iPKICallback) throws RemoteException {
        }
    }

    void CertificateStatusResponse(int i) throws RemoteException;

    void certificateRltReport(int i) throws RemoteException;

    void registerPKICallback(IPKICallback iPKICallback) throws RemoteException;

    void unregisterPKICallback(IPKICallback iPKICallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IPKI {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.pki.IPKI";
        static final int TRANSACTION_CertificateStatusResponse = 2;
        static final int TRANSACTION_certificateRltReport = 1;
        static final int TRANSACTION_registerPKICallback = 3;
        static final int TRANSACTION_unregisterPKICallback = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPKI asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPKI)) {
                return (IPKI) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                certificateRltReport(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                CertificateStatusResponse(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                registerPKICallback(IPKICallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
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
            unregisterPKICallback(IPKICallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IPKI {
            public static IPKI sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
            public void certificateRltReport(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().certificateRltReport(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
            public void CertificateStatusResponse(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().CertificateStatusResponse(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
            public void registerPKICallback(IPKICallback iPKICallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPKICallback != null ? iPKICallback.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerPKICallback(iPKICallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.pki.IPKI
            public void unregisterPKICallback(IPKICallback iPKICallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPKICallback != null ? iPKICallback.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterPKICallback(iPKICallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPKI ipki) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (ipki == null) {
                return false;
            }
            Proxy.sDefaultImpl = ipki;
            return true;
        }

        public static IPKI getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
