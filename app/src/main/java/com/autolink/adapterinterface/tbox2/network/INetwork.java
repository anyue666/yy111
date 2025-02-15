package com.autolink.adapterinterface.tbox2.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.network.INetworkCallback;

/* loaded from: classes.dex */
public interface INetwork extends IInterface {

    public static class Default implements INetwork {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetwork
        public byte getCsq() throws RemoteException {
            return (byte) 0;
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetwork
        public byte getNetworkState() throws RemoteException {
            return (byte) 0;
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetwork
        public void networkDnsReq(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetwork
        public void networkRestartReq(int i, byte b) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetwork
        public void registerCallback(INetworkCallback iNetworkCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetwork
        public void unregisterCallback(INetworkCallback iNetworkCallback) throws RemoteException {
        }
    }

    byte getCsq() throws RemoteException;

    byte getNetworkState() throws RemoteException;

    void networkDnsReq(int i) throws RemoteException;

    void networkRestartReq(int i, byte b) throws RemoteException;

    void registerCallback(INetworkCallback iNetworkCallback) throws RemoteException;

    void unregisterCallback(INetworkCallback iNetworkCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements INetwork {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.network.INetwork";
        static final int TRANSACTION_getCsq = 2;
        static final int TRANSACTION_getNetworkState = 1;
        static final int TRANSACTION_networkDnsReq = 5;
        static final int TRANSACTION_networkRestartReq = 6;
        static final int TRANSACTION_registerCallback = 3;
        static final int TRANSACTION_unregisterCallback = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INetwork asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INetwork)) {
                return (INetwork) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    byte networkState = getNetworkState();
                    parcel2.writeNoException();
                    parcel2.writeByte(networkState);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    byte csq = getCsq();
                    parcel2.writeNoException();
                    parcel2.writeByte(csq);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(INetworkCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(INetworkCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    networkDnsReq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    networkRestartReq(parcel.readInt(), parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements INetwork {
            public static INetwork sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.network.INetwork
            public byte getNetworkState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNetworkState();
                    }
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetwork
            public byte getCsq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCsq();
                    }
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetwork
            public void registerCallback(INetworkCallback iNetworkCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNetworkCallback != null ? iNetworkCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iNetworkCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetwork
            public void unregisterCallback(INetworkCallback iNetworkCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNetworkCallback != null ? iNetworkCallback.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iNetworkCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetwork
            public void networkDnsReq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().networkDnsReq(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetwork
            public void networkRestartReq(int i, byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeByte(b);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().networkRestartReq(i, b);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(INetwork iNetwork) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iNetwork == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNetwork;
            return true;
        }

        public static INetwork getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
