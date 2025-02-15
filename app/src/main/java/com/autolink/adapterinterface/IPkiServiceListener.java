package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPkiServiceListener extends IInterface {

    public static class Default implements IPkiServiceListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.IPkiServiceListener
        public void onRecvCertificateStatusReq() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPkiServiceListener
        public void onRecvDownloadCertificateRltAck(boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPkiServiceListener
        public void onRecvGetCertReq() throws RemoteException {
        }
    }

    void onRecvCertificateStatusReq() throws RemoteException;

    void onRecvDownloadCertificateRltAck(boolean z) throws RemoteException;

    void onRecvGetCertReq() throws RemoteException;

    public static abstract class Stub extends Binder implements IPkiServiceListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.IPkiServiceListener";
        static final int TRANSACTION_onRecvCertificateStatusReq = 3;
        static final int TRANSACTION_onRecvDownloadCertificateRltAck = 2;
        static final int TRANSACTION_onRecvGetCertReq = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPkiServiceListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPkiServiceListener)) {
                return (IPkiServiceListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onRecvGetCertReq();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onRecvDownloadCertificateRltAck(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onRecvCertificateStatusReq();
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IPkiServiceListener {
            public static IPkiServiceListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.IPkiServiceListener
            public void onRecvGetCertReq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecvGetCertReq();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPkiServiceListener
            public void onRecvDownloadCertificateRltAck(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecvDownloadCertificateRltAck(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPkiServiceListener
            public void onRecvCertificateStatusReq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRecvCertificateStatusReq();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPkiServiceListener iPkiServiceListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPkiServiceListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPkiServiceListener;
            return true;
        }

        public static IPkiServiceListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
