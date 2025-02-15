package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IClusterNotifyKeytoneCallback extends IInterface {

    public static class Default implements IClusterNotifyKeytoneCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback
        public void onKeytone() throws RemoteException {
        }
    }

    void onKeytone() throws RemoteException;

    public static abstract class Stub extends Binder implements IClusterNotifyKeytoneCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback";
        static final int TRANSACTION_onKeytone = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IClusterNotifyKeytoneCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IClusterNotifyKeytoneCallback)) {
                return (IClusterNotifyKeytoneCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onKeytone();
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IClusterNotifyKeytoneCallback {
            public static IClusterNotifyKeytoneCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IClusterNotifyKeytoneCallback
            public void onKeytone() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onKeytone();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IClusterNotifyKeytoneCallback iClusterNotifyKeytoneCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iClusterNotifyKeytoneCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iClusterNotifyKeytoneCallback;
            return true;
        }

        public static IClusterNotifyKeytoneCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
