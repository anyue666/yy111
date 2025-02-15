package android.car;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ILocationManagerProxy extends IInterface {

    public static class Default implements ILocationManagerProxy {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ILocationManagerProxy
        public Location getLastKnownLocation(String str) throws RemoteException {
            return null;
        }

        @Override // android.car.ILocationManagerProxy
        public boolean injectLocation(Location location) throws RemoteException {
            return false;
        }

        @Override // android.car.ILocationManagerProxy
        public boolean isLocationEnabled() throws RemoteException {
            return false;
        }
    }

    Location getLastKnownLocation(String str) throws RemoteException;

    boolean injectLocation(Location location) throws RemoteException;

    boolean isLocationEnabled() throws RemoteException;

    public static abstract class Stub extends Binder implements ILocationManagerProxy {
        private static final String DESCRIPTOR = "android.car.ILocationManagerProxy";
        static final int TRANSACTION_getLastKnownLocation = 3;
        static final int TRANSACTION_injectLocation = 2;
        static final int TRANSACTION_isLocationEnabled = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ILocationManagerProxy asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ILocationManagerProxy)) {
                return (ILocationManagerProxy) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isLocationEnabled = isLocationEnabled();
                parcel2.writeNoException();
                parcel2.writeInt(isLocationEnabled ? 1 : 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean injectLocation = injectLocation(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(injectLocation ? 1 : 0);
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            Location lastKnownLocation = getLastKnownLocation(parcel.readString());
            parcel2.writeNoException();
            if (lastKnownLocation != null) {
                parcel2.writeInt(1);
                lastKnownLocation.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        private static class Proxy implements ILocationManagerProxy {
            public static ILocationManagerProxy sDefaultImpl;
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

            @Override // android.car.ILocationManagerProxy
            public boolean isLocationEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLocationEnabled();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ILocationManagerProxy
            public boolean injectLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().injectLocation(location);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ILocationManagerProxy
            public Location getLastKnownLocation(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLastKnownLocation(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ILocationManagerProxy iLocationManagerProxy) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iLocationManagerProxy == null) {
                return false;
            }
            Proxy.sDefaultImpl = iLocationManagerProxy;
            return true;
        }

        public static ILocationManagerProxy getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
