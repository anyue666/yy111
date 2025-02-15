package android.car.cluster.renderer;

import android.car.navigation.CarNavigationInstrumentCluster;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IInstrumentClusterNavigation extends IInterface {

    public static class Default implements IInstrumentClusterNavigation {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.cluster.renderer.IInstrumentClusterNavigation
        public CarNavigationInstrumentCluster getInstrumentClusterInfo() throws RemoteException {
            return null;
        }

        @Override // android.car.cluster.renderer.IInstrumentClusterNavigation
        public void onNavigationStateChanged(Bundle bundle) throws RemoteException {
        }
    }

    CarNavigationInstrumentCluster getInstrumentClusterInfo() throws RemoteException;

    void onNavigationStateChanged(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IInstrumentClusterNavigation {
        private static final String DESCRIPTOR = "android.car.cluster.renderer.IInstrumentClusterNavigation";
        static final int TRANSACTION_getInstrumentClusterInfo = 2;
        static final int TRANSACTION_onNavigationStateChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInstrumentClusterNavigation asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInstrumentClusterNavigation)) {
                return (IInstrumentClusterNavigation) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onNavigationStateChanged(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
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
            CarNavigationInstrumentCluster instrumentClusterInfo = getInstrumentClusterInfo();
            parcel2.writeNoException();
            if (instrumentClusterInfo != null) {
                parcel2.writeInt(1);
                instrumentClusterInfo.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        private static class Proxy implements IInstrumentClusterNavigation {
            public static IInstrumentClusterNavigation sDefaultImpl;
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

            @Override // android.car.cluster.renderer.IInstrumentClusterNavigation
            public void onNavigationStateChanged(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNavigationStateChanged(bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.cluster.renderer.IInstrumentClusterNavigation
            public CarNavigationInstrumentCluster getInstrumentClusterInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInstrumentClusterInfo();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CarNavigationInstrumentCluster.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IInstrumentClusterNavigation iInstrumentClusterNavigation) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iInstrumentClusterNavigation == null) {
                return false;
            }
            Proxy.sDefaultImpl = iInstrumentClusterNavigation;
            return true;
        }

        public static IInstrumentClusterNavigation getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
