package android.car;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarBluetoothUserService extends IInterface {

    public static class Default implements ICarBluetoothUserService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICarBluetoothUserService
        public boolean bluetoothConnectToProfile(int i, BluetoothDevice bluetoothDevice) throws RemoteException {
            return false;
        }

        @Override // android.car.ICarBluetoothUserService
        public boolean bluetoothDisconnectFromProfile(int i, BluetoothDevice bluetoothDevice) throws RemoteException {
            return false;
        }

        @Override // android.car.ICarBluetoothUserService
        public void closeBluetoothConnectionProxies() throws RemoteException {
        }

        @Override // android.car.ICarBluetoothUserService
        public int getProfilePriority(int i, BluetoothDevice bluetoothDevice) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICarBluetoothUserService
        public boolean isBluetoothConnectionProxyAvailable(int i) throws RemoteException {
            return false;
        }

        @Override // android.car.ICarBluetoothUserService
        public void setProfilePriority(int i, BluetoothDevice bluetoothDevice, int i2) throws RemoteException {
        }

        @Override // android.car.ICarBluetoothUserService
        public void setupBluetoothConnectionProxies() throws RemoteException {
        }
    }

    boolean bluetoothConnectToProfile(int i, BluetoothDevice bluetoothDevice) throws RemoteException;

    boolean bluetoothDisconnectFromProfile(int i, BluetoothDevice bluetoothDevice) throws RemoteException;

    void closeBluetoothConnectionProxies() throws RemoteException;

    int getProfilePriority(int i, BluetoothDevice bluetoothDevice) throws RemoteException;

    boolean isBluetoothConnectionProxyAvailable(int i) throws RemoteException;

    void setProfilePriority(int i, BluetoothDevice bluetoothDevice, int i2) throws RemoteException;

    void setupBluetoothConnectionProxies() throws RemoteException;

    public static abstract class Stub extends Binder implements ICarBluetoothUserService {
        private static final String DESCRIPTOR = "android.car.ICarBluetoothUserService";
        static final int TRANSACTION_bluetoothConnectToProfile = 4;
        static final int TRANSACTION_bluetoothDisconnectFromProfile = 5;
        static final int TRANSACTION_closeBluetoothConnectionProxies = 2;
        static final int TRANSACTION_getProfilePriority = 6;
        static final int TRANSACTION_isBluetoothConnectionProxyAvailable = 3;
        static final int TRANSACTION_setProfilePriority = 7;
        static final int TRANSACTION_setupBluetoothConnectionProxies = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarBluetoothUserService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarBluetoothUserService)) {
                return (ICarBluetoothUserService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    setupBluetoothConnectionProxies();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    closeBluetoothConnectionProxies();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isBluetoothConnectionProxyAvailable = isBluetoothConnectionProxyAvailable(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isBluetoothConnectionProxyAvailable ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean bluetoothConnectToProfile = bluetoothConnectToProfile(parcel.readInt(), parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(bluetoothConnectToProfile ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean bluetoothDisconnectFromProfile = bluetoothDisconnectFromProfile(parcel.readInt(), parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(bluetoothDisconnectFromProfile ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int profilePriority = getProfilePriority(parcel.readInt(), parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(profilePriority);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setProfilePriority(parcel.readInt(), parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarBluetoothUserService {
            public static ICarBluetoothUserService sDefaultImpl;
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

            @Override // android.car.ICarBluetoothUserService
            public void setupBluetoothConnectionProxies() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setupBluetoothConnectionProxies();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBluetoothUserService
            public void closeBluetoothConnectionProxies() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().closeBluetoothConnectionProxies();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBluetoothUserService
            public boolean isBluetoothConnectionProxyAvailable(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isBluetoothConnectionProxyAvailable(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBluetoothUserService
            public boolean bluetoothConnectToProfile(int i, BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().bluetoothConnectToProfile(i, bluetoothDevice);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBluetoothUserService
            public boolean bluetoothDisconnectFromProfile(int i, BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().bluetoothDisconnectFromProfile(i, bluetoothDevice);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBluetoothUserService
            public int getProfilePriority(int i, BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProfilePriority(i, bluetoothDevice);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBluetoothUserService
            public void setProfilePriority(int i, BluetoothDevice bluetoothDevice, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setProfilePriority(i, bluetoothDevice, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarBluetoothUserService iCarBluetoothUserService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarBluetoothUserService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarBluetoothUserService;
            return true;
        }

        public static ICarBluetoothUserService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
