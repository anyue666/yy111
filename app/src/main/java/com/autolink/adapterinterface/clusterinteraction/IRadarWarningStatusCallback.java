package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IRadarWarningStatusCallback extends IInterface {

    public static class Default implements IRadarWarningStatusCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback
        public void onRadarWarningStatusChanged(boolean z) throws RemoteException {
        }
    }

    void onRadarWarningStatusChanged(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IRadarWarningStatusCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback";
        static final int TRANSACTION_onRadarWarningStatusChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRadarWarningStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRadarWarningStatusCallback)) {
                return (IRadarWarningStatusCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onRadarWarningStatusChanged(parcel.readInt() != 0);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IRadarWarningStatusCallback {
            public static IRadarWarningStatusCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IRadarWarningStatusCallback
            public void onRadarWarningStatusChanged(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRadarWarningStatusChanged(z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRadarWarningStatusCallback iRadarWarningStatusCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRadarWarningStatusCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRadarWarningStatusCallback;
            return true;
        }

        public static IRadarWarningStatusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
