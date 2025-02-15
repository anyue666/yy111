package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ITemperatureHighCallback extends IInterface {

    public static class Default implements ITemperatureHighCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback
        public void onIviTemperatureHigh() throws RemoteException {
        }
    }

    void onIviTemperatureHigh() throws RemoteException;

    public static abstract class Stub extends Binder implements ITemperatureHighCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback";
        static final int TRANSACTION_onIviTemperatureHigh = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITemperatureHighCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITemperatureHighCallback)) {
                return (ITemperatureHighCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onIviTemperatureHigh();
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ITemperatureHighCallback {
            public static ITemperatureHighCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.ITemperatureHighCallback
            public void onIviTemperatureHigh() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onIviTemperatureHigh();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITemperatureHighCallback iTemperatureHighCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iTemperatureHighCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTemperatureHighCallback;
            return true;
        }

        public static ITemperatureHighCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
