package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarBugreportCallback extends IInterface {

    public static class Default implements ICarBugreportCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICarBugreportCallback
        public void onError(int i) throws RemoteException {
        }

        @Override // android.car.ICarBugreportCallback
        public void onFinished() throws RemoteException {
        }

        @Override // android.car.ICarBugreportCallback
        public void onProgress(float f) throws RemoteException {
        }
    }

    void onError(int i) throws RemoteException;

    void onFinished() throws RemoteException;

    void onProgress(float f) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarBugreportCallback {
        private static final String DESCRIPTOR = "android.car.ICarBugreportCallback";
        static final int TRANSACTION_onError = 1;
        static final int TRANSACTION_onFinished = 3;
        static final int TRANSACTION_onProgress = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarBugreportCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarBugreportCallback)) {
                return (ICarBugreportCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onError(parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onProgress(parcel.readFloat());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onFinished();
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarBugreportCallback {
            public static ICarBugreportCallback sDefaultImpl;
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

            @Override // android.car.ICarBugreportCallback
            public void onError(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onError(i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBugreportCallback
            public void onProgress(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onProgress(f);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarBugreportCallback
            public void onFinished() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onFinished();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarBugreportCallback iCarBugreportCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarBugreportCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarBugreportCallback;
            return true;
        }

        public static ICarBugreportCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
