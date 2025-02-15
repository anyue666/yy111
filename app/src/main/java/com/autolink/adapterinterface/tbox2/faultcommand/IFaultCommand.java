package com.autolink.adapterinterface.tbox2.faultcommand;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback;

/* loaded from: classes.dex */
public interface IFaultCommand extends IInterface {

    public static class Default implements IFaultCommand {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
        public int getFaultCommand() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
        public int getTboxConnectedState() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
        public void registerCallback(IFaultCommandCallback iFaultCommandCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
        public void unregisterCallback(IFaultCommandCallback iFaultCommandCallback) throws RemoteException {
        }
    }

    int getFaultCommand() throws RemoteException;

    int getTboxConnectedState() throws RemoteException;

    void registerCallback(IFaultCommandCallback iFaultCommandCallback) throws RemoteException;

    void unregisterCallback(IFaultCommandCallback iFaultCommandCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IFaultCommand {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand";
        static final int TRANSACTION_getFaultCommand = 3;
        static final int TRANSACTION_getTboxConnectedState = 4;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFaultCommand asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFaultCommand)) {
                return (IFaultCommand) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                registerCallback(IFaultCommandCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                unregisterCallback(IFaultCommandCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                int faultCommand = getFaultCommand();
                parcel2.writeNoException();
                parcel2.writeInt(faultCommand);
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
            int tboxConnectedState = getTboxConnectedState();
            parcel2.writeNoException();
            parcel2.writeInt(tboxConnectedState);
            return true;
        }

        private static class Proxy implements IFaultCommand {
            public static IFaultCommand sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
            public void registerCallback(IFaultCommandCallback iFaultCommandCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFaultCommandCallback != null ? iFaultCommandCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iFaultCommandCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
            public void unregisterCallback(IFaultCommandCallback iFaultCommandCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFaultCommandCallback != null ? iFaultCommandCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iFaultCommandCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
            public int getFaultCommand() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFaultCommand();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommand
            public int getTboxConnectedState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTboxConnectedState();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFaultCommand iFaultCommand) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iFaultCommand == null) {
                return false;
            }
            Proxy.sDefaultImpl = iFaultCommand;
            return true;
        }

        public static IFaultCommand getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
