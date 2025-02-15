package com.autolink.adapterinterface.tbox2.callcommand;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback;

/* loaded from: classes.dex */
public interface ICallCommand extends IInterface {

    public static class Default implements ICallCommand {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommand
        public void callRequest(byte b, byte b2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommand
        public void registerCallback(ICallCommandCallback iCallCommandCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommand
        public void unregisterCallback(ICallCommandCallback iCallCommandCallback) throws RemoteException {
        }
    }

    void callRequest(byte b, byte b2) throws RemoteException;

    void registerCallback(ICallCommandCallback iCallCommandCallback) throws RemoteException;

    void unregisterCallback(ICallCommandCallback iCallCommandCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements ICallCommand {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.callcommand.ICallCommand";
        static final int TRANSACTION_callRequest = 1;
        static final int TRANSACTION_registerCallback = 2;
        static final int TRANSACTION_unregisterCallback = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallCommand asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICallCommand)) {
                return (ICallCommand) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                callRequest(parcel.readByte(), parcel.readByte());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                registerCallback(ICallCommandCallback.Stub.asInterface(parcel.readStrongBinder()));
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
            unregisterCallback(ICallCommandCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements ICallCommand {
            public static ICallCommand sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommand
            public void callRequest(byte b, byte b2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeByte(b2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().callRequest(b, b2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommand
            public void registerCallback(ICallCommandCallback iCallCommandCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallCommandCallback != null ? iCallCommandCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iCallCommandCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommand
            public void unregisterCallback(ICallCommandCallback iCallCommandCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCallCommandCallback != null ? iCallCommandCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iCallCommandCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICallCommand iCallCommand) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCallCommand == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCallCommand;
            return true;
        }

        public static ICallCommand getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
