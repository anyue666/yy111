package android.car.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarAppBlockingPolicySetter extends IInterface {

    public static class Default implements ICarAppBlockingPolicySetter {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.content.pm.ICarAppBlockingPolicySetter
        public void setAppBlockingPolicy(CarAppBlockingPolicy carAppBlockingPolicy) throws RemoteException {
        }
    }

    void setAppBlockingPolicy(CarAppBlockingPolicy carAppBlockingPolicy) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarAppBlockingPolicySetter {
        private static final String DESCRIPTOR = "android.car.content.pm.ICarAppBlockingPolicySetter";
        static final int TRANSACTION_setAppBlockingPolicy = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarAppBlockingPolicySetter asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarAppBlockingPolicySetter)) {
                return (ICarAppBlockingPolicySetter) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            setAppBlockingPolicy(parcel.readInt() != 0 ? CarAppBlockingPolicy.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements ICarAppBlockingPolicySetter {
            public static ICarAppBlockingPolicySetter sDefaultImpl;
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

            @Override // android.car.content.pm.ICarAppBlockingPolicySetter
            public void setAppBlockingPolicy(CarAppBlockingPolicy carAppBlockingPolicy) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (carAppBlockingPolicy != null) {
                        obtain.writeInt(1);
                        carAppBlockingPolicy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAppBlockingPolicy(carAppBlockingPolicy);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarAppBlockingPolicySetter iCarAppBlockingPolicySetter) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarAppBlockingPolicySetter == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarAppBlockingPolicySetter;
            return true;
        }

        public static ICarAppBlockingPolicySetter getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
