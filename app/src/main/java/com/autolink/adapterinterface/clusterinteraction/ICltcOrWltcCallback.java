package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICltcOrWltcCallback extends IInterface {

    public static class Default implements ICltcOrWltcCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback
        public void onCltcOrWltcModeChanged(int i) throws RemoteException {
        }
    }

    void onCltcOrWltcModeChanged(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ICltcOrWltcCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback";
        static final int TRANSACTION_onCltcOrWltcModeChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICltcOrWltcCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICltcOrWltcCallback)) {
                return (ICltcOrWltcCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onCltcOrWltcModeChanged(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICltcOrWltcCallback {
            public static ICltcOrWltcCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.ICltcOrWltcCallback
            public void onCltcOrWltcModeChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCltcOrWltcModeChanged(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICltcOrWltcCallback iCltcOrWltcCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCltcOrWltcCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCltcOrWltcCallback;
            return true;
        }

        public static ICltcOrWltcCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
