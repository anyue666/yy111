package android.car.cluster;

import android.car.cluster.IInstrumentClusterManagerCallback;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IInstrumentClusterManagerService extends IInterface {

    public static class Default implements IInstrumentClusterManagerService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.cluster.IInstrumentClusterManagerService
        public void registerCallback(IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback) throws RemoteException {
        }

        @Override // android.car.cluster.IInstrumentClusterManagerService
        public void startClusterActivity(Intent intent) throws RemoteException {
        }

        @Override // android.car.cluster.IInstrumentClusterManagerService
        public void unregisterCallback(IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback) throws RemoteException {
        }
    }

    void registerCallback(IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback) throws RemoteException;

    void startClusterActivity(Intent intent) throws RemoteException;

    void unregisterCallback(IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IInstrumentClusterManagerService {
        private static final String DESCRIPTOR = "android.car.cluster.IInstrumentClusterManagerService";
        static final int TRANSACTION_registerCallback = 2;
        static final int TRANSACTION_startClusterActivity = 1;
        static final int TRANSACTION_unregisterCallback = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInstrumentClusterManagerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInstrumentClusterManagerService)) {
                return (IInstrumentClusterManagerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                startClusterActivity(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                registerCallback(IInstrumentClusterManagerCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                unregisterCallback(IInstrumentClusterManagerCallback.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IInstrumentClusterManagerService {
            public static IInstrumentClusterManagerService sDefaultImpl;
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

            @Override // android.car.cluster.IInstrumentClusterManagerService
            public void startClusterActivity(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().startClusterActivity(intent);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.cluster.IInstrumentClusterManagerService
            public void registerCallback(IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iInstrumentClusterManagerCallback != null ? iInstrumentClusterManagerCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().registerCallback(iInstrumentClusterManagerCallback);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.cluster.IInstrumentClusterManagerService
            public void unregisterCallback(IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iInstrumentClusterManagerCallback != null ? iInstrumentClusterManagerCallback.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().unregisterCallback(iInstrumentClusterManagerCallback);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IInstrumentClusterManagerService iInstrumentClusterManagerService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iInstrumentClusterManagerService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iInstrumentClusterManagerService;
            return true;
        }

        public static IInstrumentClusterManagerService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
