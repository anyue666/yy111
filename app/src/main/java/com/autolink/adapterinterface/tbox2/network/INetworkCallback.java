package com.autolink.adapterinterface.tbox2.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface INetworkCallback extends IInterface {

    public static class Default implements INetworkCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
        public void onNetworkResponse(byte b, byte b2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
        public void onNetworkRestartResult(TboxNetworkRestartResultInfo tboxNetworkRestartResultInfo) throws RemoteException {
        }
    }

    void onNetworkResponse(byte b, byte b2) throws RemoteException;

    void onNetworkRestartResult(TboxNetworkRestartResultInfo tboxNetworkRestartResultInfo) throws RemoteException;

    public static abstract class Stub extends Binder implements INetworkCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.network.INetworkCallback";
        static final int TRANSACTION_onNetworkResponse = 1;
        static final int TRANSACTION_onNetworkRestartResult = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INetworkCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INetworkCallback)) {
                return (INetworkCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onNetworkResponse(parcel.readByte(), parcel.readByte());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onNetworkRestartResult(parcel.readInt() != 0 ? TboxNetworkRestartResultInfo.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements INetworkCallback {
            public static INetworkCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
            public void onNetworkResponse(byte b, byte b2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeByte(b2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNetworkResponse(b, b2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.network.INetworkCallback
            public void onNetworkRestartResult(TboxNetworkRestartResultInfo tboxNetworkRestartResultInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxNetworkRestartResultInfo != null) {
                        obtain.writeInt(1);
                        tboxNetworkRestartResultInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNetworkRestartResult(tboxNetworkRestartResultInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(INetworkCallback iNetworkCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iNetworkCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNetworkCallback;
            return true;
        }

        public static INetworkCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
