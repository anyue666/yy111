package android.car.cluster;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IInstrumentClusterManagerCallback extends IInterface {

    public static class Default implements IInstrumentClusterManagerCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.cluster.IInstrumentClusterManagerCallback
        public void setClusterActivityState(String str, Bundle bundle) throws RemoteException {
        }
    }

    void setClusterActivityState(String str, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IInstrumentClusterManagerCallback {
        private static final String DESCRIPTOR = "android.car.cluster.IInstrumentClusterManagerCallback";
        static final int TRANSACTION_setClusterActivityState = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInstrumentClusterManagerCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInstrumentClusterManagerCallback)) {
                return (IInstrumentClusterManagerCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                setClusterActivityState(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IInstrumentClusterManagerCallback {
            public static IInstrumentClusterManagerCallback sDefaultImpl;
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

            @Override // android.car.cluster.IInstrumentClusterManagerCallback
            public void setClusterActivityState(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setClusterActivityState(str, bundle);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iInstrumentClusterManagerCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iInstrumentClusterManagerCallback;
            return true;
        }

        public static IInstrumentClusterManagerCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
