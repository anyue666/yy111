package com.autolink.adapterinterface.upgrade;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IUpgradeResultCallback extends IInterface {

    public static class Default implements IUpgradeResultCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeResultCallback
        public void onUpgradeResult(int i) throws RemoteException {
        }
    }

    void onUpgradeResult(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IUpgradeResultCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.upgrade.IUpgradeResultCallback";
        static final int TRANSACTION_onUpgradeResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUpgradeResultCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUpgradeResultCallback)) {
                return (IUpgradeResultCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onUpgradeResult(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IUpgradeResultCallback {
            public static IUpgradeResultCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeResultCallback
            public void onUpgradeResult(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onUpgradeResult(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IUpgradeResultCallback iUpgradeResultCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iUpgradeResultCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iUpgradeResultCallback;
            return true;
        }

        public static IUpgradeResultCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
