package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IMultiWindowCallback extends IInterface {

    public static class Default implements IMultiWindowCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.IMultiWindowCallback
        public void onAppDied(String str) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IMultiWindowCallback
        public void onDown() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IMultiWindowCallback
        public void onThreeFingersFling(int i) throws RemoteException {
        }
    }

    void onAppDied(String str) throws RemoteException;

    void onDown() throws RemoteException;

    void onThreeFingersFling(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IMultiWindowCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.IMultiWindowCallback";
        static final int TRANSACTION_onAppDied = 3;
        static final int TRANSACTION_onDown = 1;
        static final int TRANSACTION_onThreeFingersFling = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMultiWindowCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMultiWindowCallback)) {
                return (IMultiWindowCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onDown();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onThreeFingersFling(parcel.readInt());
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
            onAppDied(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IMultiWindowCallback {
            public static IMultiWindowCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onDown() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDown();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onThreeFingersFling(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onThreeFingersFling(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IMultiWindowCallback
            public void onAppDied(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAppDied(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMultiWindowCallback iMultiWindowCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMultiWindowCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMultiWindowCallback;
            return true;
        }

        public static IMultiWindowCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
