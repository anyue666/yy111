package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarProjectionKeyEventHandler extends IInterface {

    public static class Default implements ICarProjectionKeyEventHandler {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICarProjectionKeyEventHandler
        public void onKeyEvent(int i) throws RemoteException {
        }
    }

    void onKeyEvent(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarProjectionKeyEventHandler {
        private static final String DESCRIPTOR = "android.car.ICarProjectionKeyEventHandler";
        static final int TRANSACTION_onKeyEvent = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarProjectionKeyEventHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarProjectionKeyEventHandler)) {
                return (ICarProjectionKeyEventHandler) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onKeyEvent(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarProjectionKeyEventHandler {
            public static ICarProjectionKeyEventHandler sDefaultImpl;
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

            @Override // android.car.ICarProjectionKeyEventHandler
            public void onKeyEvent(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onKeyEvent(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarProjectionKeyEventHandler iCarProjectionKeyEventHandler) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarProjectionKeyEventHandler == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarProjectionKeyEventHandler;
            return true;
        }

        public static ICarProjectionKeyEventHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
