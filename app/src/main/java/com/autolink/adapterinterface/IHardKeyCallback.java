package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IHardKeyCallback extends IInterface {

    public static class Default implements IHardKeyCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.IHardKeyCallback
        public void onKeyEvent(int i, int i2, int i3) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IHardKeyCallback
        public void onKeyPressed(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IHardKeyCallback
        public void onKeyReleased(int i) throws RemoteException {
        }
    }

    void onKeyEvent(int i, int i2, int i3) throws RemoteException;

    void onKeyPressed(int i) throws RemoteException;

    void onKeyReleased(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IHardKeyCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.IHardKeyCallback";
        static final int TRANSACTION_onKeyEvent = 3;
        static final int TRANSACTION_onKeyPressed = 1;
        static final int TRANSACTION_onKeyReleased = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHardKeyCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IHardKeyCallback)) {
                return (IHardKeyCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onKeyPressed(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onKeyReleased(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onKeyEvent(parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IHardKeyCallback {
            public static IHardKeyCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyPressed(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onKeyPressed(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyReleased(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onKeyReleased(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyCallback
            public void onKeyEvent(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onKeyEvent(i, i2, i3);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IHardKeyCallback iHardKeyCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iHardKeyCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iHardKeyCallback;
            return true;
        }

        public static IHardKeyCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
