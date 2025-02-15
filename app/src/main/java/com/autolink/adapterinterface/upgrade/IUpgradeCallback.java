package com.autolink.adapterinterface.upgrade;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IUpgradeCallback extends IInterface {

    public static class Default implements IUpgradeCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
        public void onStatusUpdate(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
        public void onUpdateComplete(int i) throws RemoteException {
        }
    }

    void onStatusUpdate(int i, int i2) throws RemoteException;

    void onUpdateComplete(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IUpgradeCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.upgrade.IUpgradeCallback";
        static final int TRANSACTION_onStatusUpdate = 1;
        static final int TRANSACTION_onUpdateComplete = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUpgradeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUpgradeCallback)) {
                return (IUpgradeCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onStatusUpdate(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onUpdateComplete(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IUpgradeCallback {
            public static IUpgradeCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
            public void onStatusUpdate(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onStatusUpdate(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeCallback
            public void onUpdateComplete(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onUpdateComplete(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IUpgradeCallback iUpgradeCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iUpgradeCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iUpgradeCallback;
            return true;
        }

        public static IUpgradeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
