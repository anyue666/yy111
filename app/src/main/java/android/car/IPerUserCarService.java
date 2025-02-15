package android.car;

import android.car.ICarBluetoothUserService;
import android.car.ILocationManagerProxy;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPerUserCarService extends IInterface {

    public static class Default implements IPerUserCarService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.IPerUserCarService
        public ICarBluetoothUserService getBluetoothUserService() throws RemoteException {
            return null;
        }

        @Override // android.car.IPerUserCarService
        public ILocationManagerProxy getLocationManagerProxy() throws RemoteException {
            return null;
        }
    }

    ICarBluetoothUserService getBluetoothUserService() throws RemoteException;

    ILocationManagerProxy getLocationManagerProxy() throws RemoteException;

    public static abstract class Stub extends Binder implements IPerUserCarService {
        private static final String DESCRIPTOR = "android.car.IPerUserCarService";
        static final int TRANSACTION_getBluetoothUserService = 1;
        static final int TRANSACTION_getLocationManagerProxy = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPerUserCarService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPerUserCarService)) {
                return (IPerUserCarService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                ICarBluetoothUserService bluetoothUserService = getBluetoothUserService();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(bluetoothUserService != null ? bluetoothUserService.asBinder() : null);
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
            ILocationManagerProxy locationManagerProxy = getLocationManagerProxy();
            parcel2.writeNoException();
            parcel2.writeStrongBinder(locationManagerProxy != null ? locationManagerProxy.asBinder() : null);
            return true;
        }

        private static class Proxy implements IPerUserCarService {
            public static IPerUserCarService sDefaultImpl;
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

            @Override // android.car.IPerUserCarService
            public ICarBluetoothUserService getBluetoothUserService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBluetoothUserService();
                    }
                    obtain2.readException();
                    return ICarBluetoothUserService.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.IPerUserCarService
            public ILocationManagerProxy getLocationManagerProxy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLocationManagerProxy();
                    }
                    obtain2.readException();
                    return ILocationManagerProxy.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPerUserCarService iPerUserCarService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPerUserCarService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPerUserCarService;
            return true;
        }

        public static IPerUserCarService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
