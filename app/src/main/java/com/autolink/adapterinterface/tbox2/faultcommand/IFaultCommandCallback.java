package com.autolink.adapterinterface.tbox2.faultcommand;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IFaultCommandCallback extends IInterface {

    public static class Default implements IFaultCommandCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
        public void onFaultCommandResponse(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
        public void onTboxDisconnected(int i) throws RemoteException {
        }
    }

    void onFaultCommandResponse(int i) throws RemoteException;

    void onTboxDisconnected(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IFaultCommandCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback";
        static final int TRANSACTION_onFaultCommandResponse = 1;
        static final int TRANSACTION_onTboxDisconnected = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFaultCommandCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFaultCommandCallback)) {
                return (IFaultCommandCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onFaultCommandResponse(parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onTboxDisconnected(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IFaultCommandCallback {
            public static IFaultCommandCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
            public void onFaultCommandResponse(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onFaultCommandResponse(i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.faultcommand.IFaultCommandCallback
            public void onTboxDisconnected(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onTboxDisconnected(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFaultCommandCallback iFaultCommandCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iFaultCommandCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iFaultCommandCallback;
            return true;
        }

        public static IFaultCommandCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
