package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IApaStatusCallback extends IInterface {

    public static class Default implements IApaStatusCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
        public void onApaClosedBySpeed() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
        public void onApaStatusChanged(boolean z) throws RemoteException {
        }
    }

    void onApaClosedBySpeed() throws RemoteException;

    void onApaStatusChanged(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IApaStatusCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback";
        static final int TRANSACTION_onApaClosedBySpeed = 2;
        static final int TRANSACTION_onApaStatusChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IApaStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IApaStatusCallback)) {
                return (IApaStatusCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onApaStatusChanged(parcel.readInt() != 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onApaClosedBySpeed();
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IApaStatusCallback {
            public static IApaStatusCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaStatusChanged(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onApaStatusChanged(z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IApaStatusCallback
            public void onApaClosedBySpeed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onApaClosedBySpeed();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IApaStatusCallback iApaStatusCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iApaStatusCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iApaStatusCallback;
            return true;
        }

        public static IApaStatusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
