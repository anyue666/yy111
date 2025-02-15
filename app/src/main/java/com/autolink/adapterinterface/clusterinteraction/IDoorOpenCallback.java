package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IDoorOpenCallback extends IInterface {

    public static class Default implements IDoorOpenCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback
        public void onDoorOpen() throws RemoteException {
        }
    }

    void onDoorOpen() throws RemoteException;

    public static abstract class Stub extends Binder implements IDoorOpenCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback";
        static final int TRANSACTION_onDoorOpen = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDoorOpenCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDoorOpenCallback)) {
                return (IDoorOpenCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onDoorOpen();
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IDoorOpenCallback {
            public static IDoorOpenCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IDoorOpenCallback
            public void onDoorOpen() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDoorOpen();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDoorOpenCallback iDoorOpenCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDoorOpenCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDoorOpenCallback;
            return true;
        }

        public static IDoorOpenCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
