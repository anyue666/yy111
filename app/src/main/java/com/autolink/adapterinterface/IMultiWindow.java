package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.IMultiWindowCallback;

/* loaded from: classes.dex */
public interface IMultiWindow extends IInterface {

    public static class Default implements IMultiWindow {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.IMultiWindow
        public boolean isNaviBarVisable() throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.IMultiWindow
        public void registerCallback(IMultiWindowCallback iMultiWindowCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IMultiWindow
        public void unregisterCallback(IMultiWindowCallback iMultiWindowCallback) throws RemoteException {
        }
    }

    boolean isNaviBarVisable() throws RemoteException;

    void registerCallback(IMultiWindowCallback iMultiWindowCallback) throws RemoteException;

    void unregisterCallback(IMultiWindowCallback iMultiWindowCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IMultiWindow {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.IMultiWindow";
        static final int TRANSACTION_isNaviBarVisable = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMultiWindow asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMultiWindow)) {
                return (IMultiWindow) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                registerCallback(IMultiWindowCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                unregisterCallback(IMultiWindowCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean isNaviBarVisable = isNaviBarVisable();
            parcel2.writeNoException();
            parcel2.writeInt(isNaviBarVisable ? 1 : 0);
            return true;
        }

        private static class Proxy implements IMultiWindow {
            public static IMultiWindow sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.IMultiWindow
            public void registerCallback(IMultiWindowCallback iMultiWindowCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMultiWindowCallback != null ? iMultiWindowCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iMultiWindowCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindow
            public void unregisterCallback(IMultiWindowCallback iMultiWindowCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMultiWindowCallback != null ? iMultiWindowCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iMultiWindowCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindow
            public boolean isNaviBarVisable() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isNaviBarVisable();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMultiWindow iMultiWindow) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMultiWindow == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMultiWindow;
            return true;
        }

        public static IMultiWindow getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
