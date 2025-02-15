package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarOccupantZoneCallback extends IInterface {

    public static class Default implements ICarOccupantZoneCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICarOccupantZoneCallback
        public void onOccupantZoneConfigChanged(int i) throws RemoteException {
        }
    }

    void onOccupantZoneConfigChanged(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarOccupantZoneCallback {
        private static final String DESCRIPTOR = "android.car.ICarOccupantZoneCallback";
        static final int TRANSACTION_onOccupantZoneConfigChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarOccupantZoneCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarOccupantZoneCallback)) {
                return (ICarOccupantZoneCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onOccupantZoneConfigChanged(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarOccupantZoneCallback {
            public static ICarOccupantZoneCallback sDefaultImpl;
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

            @Override // android.car.ICarOccupantZoneCallback
            public void onOccupantZoneConfigChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onOccupantZoneConfigChanged(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarOccupantZoneCallback iCarOccupantZoneCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarOccupantZoneCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarOccupantZoneCallback;
            return true;
        }

        public static ICarOccupantZoneCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
