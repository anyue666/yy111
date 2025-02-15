package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ITyreTemperatureCallback extends IInterface {

    public static class Default implements ITyreTemperatureCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onLFTyreTempChanged(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onLRTyreTempChanged(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onRFTyreTempChanged(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
        public void onRRTyreTempChanged(int i) throws RemoteException {
        }
    }

    void onLFTyreTempChanged(int i) throws RemoteException;

    void onLRTyreTempChanged(int i) throws RemoteException;

    void onRFTyreTempChanged(int i) throws RemoteException;

    void onRRTyreTempChanged(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ITyreTemperatureCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback";
        static final int TRANSACTION_onLFTyreTempChanged = 1;
        static final int TRANSACTION_onLRTyreTempChanged = 3;
        static final int TRANSACTION_onRFTyreTempChanged = 2;
        static final int TRANSACTION_onRRTyreTempChanged = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITyreTemperatureCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITyreTemperatureCallback)) {
                return (ITyreTemperatureCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onLFTyreTempChanged(parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onRFTyreTempChanged(parcel.readInt());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onLRTyreTempChanged(parcel.readInt());
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onRRTyreTempChanged(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ITyreTemperatureCallback {
            public static ITyreTemperatureCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLFTyreTempChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onLFTyreTempChanged(i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRFTyreTempChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRFTyreTempChanged(i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onLRTyreTempChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onLRTyreTempChanged(i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.ITyreTemperatureCallback
            public void onRRTyreTempChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRRTyreTempChanged(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITyreTemperatureCallback iTyreTemperatureCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iTyreTemperatureCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTyreTemperatureCallback;
            return true;
        }

        public static ITyreTemperatureCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
