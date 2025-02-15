package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOmsCallback extends IInterface {

    public static class Default implements IOmsCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void cameraStatusResp(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void isHaveChildResp(boolean z, int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void isHavePetResp(boolean z, int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
        public void isSafetySeatResp(boolean z, int i) throws RemoteException {
        }
    }

    void cameraStatusResp(int i, int i2) throws RemoteException;

    void isHaveChildResp(boolean z, int i) throws RemoteException;

    void isHavePetResp(boolean z, int i) throws RemoteException;

    void isSafetySeatResp(boolean z, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IOmsCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IOmsCallback";
        static final int TRANSACTION_cameraStatusResp = 4;
        static final int TRANSACTION_isHaveChildResp = 2;
        static final int TRANSACTION_isHavePetResp = 1;
        static final int TRANSACTION_isSafetySeatResp = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOmsCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOmsCallback)) {
                return (IOmsCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                isHavePetResp(parcel.readInt() != 0, parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                isHaveChildResp(parcel.readInt() != 0, parcel.readInt());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                isSafetySeatResp(parcel.readInt() != 0, parcel.readInt());
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                cameraStatusResp(parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IOmsCallback {
            public static IOmsCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHavePetResp(boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().isHavePetResp(z, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isHaveChildResp(boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().isHaveChildResp(z, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void isSafetySeatResp(boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().isSafetySeatResp(z, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IOmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().cameraStatusResp(i, i2);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOmsCallback iOmsCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOmsCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOmsCallback;
            return true;
        }

        public static IOmsCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
