package android.car.drivingstate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarUxRestrictionsChangeListener extends IInterface {

    public static class Default implements ICarUxRestrictionsChangeListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsChangeListener
        public void onUxRestrictionsChanged(CarUxRestrictions carUxRestrictions) throws RemoteException {
        }
    }

    void onUxRestrictionsChanged(CarUxRestrictions carUxRestrictions) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarUxRestrictionsChangeListener {
        private static final String DESCRIPTOR = "android.car.drivingstate.ICarUxRestrictionsChangeListener";
        static final int TRANSACTION_onUxRestrictionsChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarUxRestrictionsChangeListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarUxRestrictionsChangeListener)) {
                return (ICarUxRestrictionsChangeListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onUxRestrictionsChanged(parcel.readInt() != 0 ? CarUxRestrictions.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarUxRestrictionsChangeListener {
            public static ICarUxRestrictionsChangeListener sDefaultImpl;
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

            @Override // android.car.drivingstate.ICarUxRestrictionsChangeListener
            public void onUxRestrictionsChanged(CarUxRestrictions carUxRestrictions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (carUxRestrictions != null) {
                        obtain.writeInt(1);
                        carUxRestrictions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onUxRestrictionsChanged(carUxRestrictions);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarUxRestrictionsChangeListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarUxRestrictionsChangeListener;
            return true;
        }

        public static ICarUxRestrictionsChangeListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
