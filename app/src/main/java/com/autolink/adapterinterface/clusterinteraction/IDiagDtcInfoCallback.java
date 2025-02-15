package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IDiagDtcInfoCallback extends IInterface {

    public static class Default implements IDiagDtcInfoCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback
        public void onDiagDtcInfoCb(int i, int i2) throws RemoteException {
        }
    }

    void onDiagDtcInfoCb(int i, int i2) throws RemoteException;

    public static abstract class Stub extends Binder implements IDiagDtcInfoCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback";
        static final int TRANSACTION_onDiagDtcInfoCb = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDiagDtcInfoCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDiagDtcInfoCallback)) {
                return (IDiagDtcInfoCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onDiagDtcInfoCb(parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IDiagDtcInfoCallback {
            public static IDiagDtcInfoCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IDiagDtcInfoCallback
            public void onDiagDtcInfoCb(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDiagDtcInfoCb(i, i2);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDiagDtcInfoCallback iDiagDtcInfoCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDiagDtcInfoCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDiagDtcInfoCallback;
            return true;
        }

        public static IDiagDtcInfoCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
