package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarConnectionListener extends IInterface {

    public static class Default implements ICarConnectionListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICarConnectionListener
        public void onConnected() throws RemoteException {
        }

        @Override // android.car.ICarConnectionListener
        public void onDisconnected() throws RemoteException {
        }
    }

    void onConnected() throws RemoteException;

    void onDisconnected() throws RemoteException;

    public static abstract class Stub extends Binder implements ICarConnectionListener {
        private static final String DESCRIPTOR = "android.car.ICarConnectionListener";
        static final int TRANSACTION_onConnected = 1;
        static final int TRANSACTION_onDisconnected = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarConnectionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarConnectionListener)) {
                return (ICarConnectionListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onConnected();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onDisconnected();
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarConnectionListener {
            public static ICarConnectionListener sDefaultImpl;
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

            @Override // android.car.ICarConnectionListener
            public void onConnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onConnected();
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarConnectionListener
            public void onDisconnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDisconnected();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarConnectionListener iCarConnectionListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarConnectionListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarConnectionListener;
            return true;
        }

        public static ICarConnectionListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
