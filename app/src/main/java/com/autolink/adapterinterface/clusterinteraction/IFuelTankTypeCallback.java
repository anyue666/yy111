package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IFuelTankTypeCallback extends IInterface {

    public static class Default implements IFuelTankTypeCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback
        public void onFuelTankTypeChanged(int i) throws RemoteException {
        }
    }

    void onFuelTankTypeChanged(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IFuelTankTypeCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback";
        static final int TRANSACTION_onFuelTankTypeChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFuelTankTypeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFuelTankTypeCallback)) {
                return (IFuelTankTypeCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onFuelTankTypeChanged(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IFuelTankTypeCallback {
            public static IFuelTankTypeCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelTankTypeCallback
            public void onFuelTankTypeChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onFuelTankTypeChanged(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFuelTankTypeCallback iFuelTankTypeCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iFuelTankTypeCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iFuelTankTypeCallback;
            return true;
        }

        public static IFuelTankTypeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
