package android.car.cluster.renderer;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IInstrumentClusterHelper extends IInterface {

    public static class Default implements IInstrumentClusterHelper {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.cluster.renderer.IInstrumentClusterHelper
        public boolean startFixedActivityModeForDisplayAndUser(Intent intent, Bundle bundle, int i) throws RemoteException {
            return false;
        }

        @Override // android.car.cluster.renderer.IInstrumentClusterHelper
        public void stopFixedActivityMode(int i) throws RemoteException {
        }
    }

    boolean startFixedActivityModeForDisplayAndUser(Intent intent, Bundle bundle, int i) throws RemoteException;

    void stopFixedActivityMode(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IInstrumentClusterHelper {
        private static final String DESCRIPTOR = "android.car.cluster.renderer.IInstrumentClusterHelper";
        static final int TRANSACTION_startFixedActivityModeForDisplayAndUser = 1;
        static final int TRANSACTION_stopFixedActivityMode = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.car.cluster.renderer.IInstrumentClusterHelper");
        }

        public static IInstrumentClusterHelper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.car.cluster.renderer.IInstrumentClusterHelper");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInstrumentClusterHelper)) {
                return (IInstrumentClusterHelper) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.car.cluster.renderer.IInstrumentClusterHelper");
                boolean startFixedActivityModeForDisplayAndUser = startFixedActivityModeForDisplayAndUser(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(startFixedActivityModeForDisplayAndUser ? 1 : 0);
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("android.car.cluster.renderer.IInstrumentClusterHelper");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("android.car.cluster.renderer.IInstrumentClusterHelper");
            stopFixedActivityMode(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IInstrumentClusterHelper {
            public static IInstrumentClusterHelper sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "android.car.cluster.renderer.IInstrumentClusterHelper";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.car.cluster.renderer.IInstrumentClusterHelper
            public boolean startFixedActivityModeForDisplayAndUser(Intent intent, Bundle bundle, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterHelper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startFixedActivityModeForDisplayAndUser(intent, bundle, i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.cluster.renderer.IInstrumentClusterHelper
            public void stopFixedActivityMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterHelper");
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopFixedActivityMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IInstrumentClusterHelper iInstrumentClusterHelper) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iInstrumentClusterHelper == null) {
                return false;
            }
            Proxy.sDefaultImpl = iInstrumentClusterHelper;
            return true;
        }

        public static IInstrumentClusterHelper getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
