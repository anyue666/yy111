package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAppFocusListener extends IInterface {

    public static class Default implements IAppFocusListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.IAppFocusListener
        public void onAppFocusChanged(int i, boolean z) throws RemoteException {
        }
    }

    void onAppFocusChanged(int i, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IAppFocusListener {
        private static final String DESCRIPTOR = "android.car.IAppFocusListener";
        static final int TRANSACTION_onAppFocusChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAppFocusListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAppFocusListener)) {
                return (IAppFocusListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onAppFocusChanged(parcel.readInt(), parcel.readInt() != 0);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IAppFocusListener {
            public static IAppFocusListener sDefaultImpl;
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

            @Override // android.car.IAppFocusListener
            public void onAppFocusChanged(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAppFocusChanged(i, z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAppFocusListener iAppFocusListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAppFocusListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iAppFocusListener;
            return true;
        }

        public static IAppFocusListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
