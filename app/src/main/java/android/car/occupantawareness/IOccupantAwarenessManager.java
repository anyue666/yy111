package android.car.occupantawareness;

import android.car.occupantawareness.IOccupantAwarenessEventCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOccupantAwarenessManager extends IInterface {

    public static class Default implements IOccupantAwarenessManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.occupantawareness.IOccupantAwarenessManager
        public int getCapabilityForRole(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.occupantawareness.IOccupantAwarenessManager
        public void registerEventListener(IOccupantAwarenessEventCallback iOccupantAwarenessEventCallback) throws RemoteException {
        }

        @Override // android.car.occupantawareness.IOccupantAwarenessManager
        public void unregisterEventListener(IOccupantAwarenessEventCallback iOccupantAwarenessEventCallback) throws RemoteException {
        }
    }

    int getCapabilityForRole(int i) throws RemoteException;

    void registerEventListener(IOccupantAwarenessEventCallback iOccupantAwarenessEventCallback) throws RemoteException;

    void unregisterEventListener(IOccupantAwarenessEventCallback iOccupantAwarenessEventCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IOccupantAwarenessManager {
        private static final String DESCRIPTOR = "android.car.occupantawareness.IOccupantAwarenessManager";
        static final int TRANSACTION_getCapabilityForRole = 1;
        static final int TRANSACTION_registerEventListener = 2;
        static final int TRANSACTION_unregisterEventListener = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOccupantAwarenessManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOccupantAwarenessManager)) {
                return (IOccupantAwarenessManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int capabilityForRole = getCapabilityForRole(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(capabilityForRole);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                registerEventListener(IOccupantAwarenessEventCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
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
            unregisterEventListener(IOccupantAwarenessEventCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IOccupantAwarenessManager {
            public static IOccupantAwarenessManager sDefaultImpl;
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

            @Override // android.car.occupantawareness.IOccupantAwarenessManager
            public int getCapabilityForRole(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCapabilityForRole(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.occupantawareness.IOccupantAwarenessManager
            public void registerEventListener(IOccupantAwarenessEventCallback iOccupantAwarenessEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOccupantAwarenessEventCallback != null ? iOccupantAwarenessEventCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerEventListener(iOccupantAwarenessEventCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.occupantawareness.IOccupantAwarenessManager
            public void unregisterEventListener(IOccupantAwarenessEventCallback iOccupantAwarenessEventCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOccupantAwarenessEventCallback != null ? iOccupantAwarenessEventCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterEventListener(iOccupantAwarenessEventCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOccupantAwarenessManager iOccupantAwarenessManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOccupantAwarenessManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOccupantAwarenessManager;
            return true;
        }

        public static IOccupantAwarenessManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
