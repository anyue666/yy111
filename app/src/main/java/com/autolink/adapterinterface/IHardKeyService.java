package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;
import com.autolink.adapterinterface.IHardKeyCallback;

/* loaded from: classes.dex */
public interface IHardKeyService extends IInterface {

    public static class Default implements IHardKeyService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.IHardKeyService
        public boolean enableDispatch(boolean z) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.IHardKeyService
        public void processHardKeyEvent(KeyEvent keyEvent, int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IHardKeyService
        public void registerHardKeyEvent(IHardKeyCallback iHardKeyCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IHardKeyService
        public void unregisterHardKeyEvent(IHardKeyCallback iHardKeyCallback) throws RemoteException {
        }
    }

    boolean enableDispatch(boolean z) throws RemoteException;

    void processHardKeyEvent(KeyEvent keyEvent, int i) throws RemoteException;

    void registerHardKeyEvent(IHardKeyCallback iHardKeyCallback) throws RemoteException;

    void unregisterHardKeyEvent(IHardKeyCallback iHardKeyCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IHardKeyService {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.IHardKeyService";
        static final int TRANSACTION_enableDispatch = 3;
        static final int TRANSACTION_processHardKeyEvent = 4;
        static final int TRANSACTION_registerHardKeyEvent = 1;
        static final int TRANSACTION_unregisterHardKeyEvent = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHardKeyService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IHardKeyService)) {
                return (IHardKeyService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                registerHardKeyEvent(IHardKeyCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                unregisterHardKeyEvent(IHardKeyCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean enableDispatch = enableDispatch(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(enableDispatch ? 1 : 0);
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            processHardKeyEvent(parcel.readInt() != 0 ? (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IHardKeyService {
            public static IHardKeyService sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.IHardKeyService
            public void registerHardKeyEvent(IHardKeyCallback iHardKeyCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iHardKeyCallback != null ? iHardKeyCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerHardKeyEvent(iHardKeyCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyService
            public void unregisterHardKeyEvent(IHardKeyCallback iHardKeyCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iHardKeyCallback != null ? iHardKeyCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterHardKeyEvent(iHardKeyCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyService
            public boolean enableDispatch(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().enableDispatch(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IHardKeyService
            public void processHardKeyEvent(KeyEvent keyEvent, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().processHardKeyEvent(keyEvent, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IHardKeyService iHardKeyService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iHardKeyService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iHardKeyService;
            return true;
        }

        public static IHardKeyService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
