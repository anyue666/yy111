package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAppFocusOwnershipCallback extends IInterface {

    public static class Default implements IAppFocusOwnershipCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.IAppFocusOwnershipCallback
        public void onAppFocusOwnershipGranted(int i) throws RemoteException {
        }

        @Override // android.car.IAppFocusOwnershipCallback
        public void onAppFocusOwnershipLost(int i) throws RemoteException {
        }
    }

    void onAppFocusOwnershipGranted(int i) throws RemoteException;

    void onAppFocusOwnershipLost(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IAppFocusOwnershipCallback {
        private static final String DESCRIPTOR = "android.car.IAppFocusOwnershipCallback";
        static final int TRANSACTION_onAppFocusOwnershipGranted = 2;
        static final int TRANSACTION_onAppFocusOwnershipLost = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAppFocusOwnershipCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAppFocusOwnershipCallback)) {
                return (IAppFocusOwnershipCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onAppFocusOwnershipLost(parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAppFocusOwnershipGranted(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IAppFocusOwnershipCallback {
            public static IAppFocusOwnershipCallback sDefaultImpl;
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

            @Override // android.car.IAppFocusOwnershipCallback
            public void onAppFocusOwnershipLost(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAppFocusOwnershipLost(i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.IAppFocusOwnershipCallback
            public void onAppFocusOwnershipGranted(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAppFocusOwnershipGranted(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAppFocusOwnershipCallback iAppFocusOwnershipCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAppFocusOwnershipCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAppFocusOwnershipCallback;
            return true;
        }

        public static IAppFocusOwnershipCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
