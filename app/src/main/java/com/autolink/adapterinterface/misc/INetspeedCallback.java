package com.autolink.adapterinterface.misc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface INetspeedCallback extends IInterface {

    public static class Default implements INetspeedCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.misc.INetspeedCallback
        public void onNetspeedChanged(String str) throws RemoteException {
        }
    }

    void onNetspeedChanged(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements INetspeedCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.misc.INetspeedCallback";
        static final int TRANSACTION_onNetspeedChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static INetspeedCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof INetspeedCallback)) {
                return (INetspeedCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onNetspeedChanged(parcel.readString());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements INetspeedCallback {
            public static INetspeedCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.misc.INetspeedCallback
            public void onNetspeedChanged(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onNetspeedChanged(str);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(INetspeedCallback iNetspeedCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iNetspeedCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iNetspeedCallback;
            return true;
        }

        public static INetspeedCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
