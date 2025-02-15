package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IFuelVolumeDisplayCallback extends IInterface {

    public static class Default implements IFuelVolumeDisplayCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback
        public void onFuelVolumeDisplayValueChanged(float f) throws RemoteException {
        }
    }

    void onFuelVolumeDisplayValueChanged(float f) throws RemoteException;

    public static abstract class Stub extends Binder implements IFuelVolumeDisplayCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback";
        static final int TRANSACTION_onFuelVolumeDisplayValueChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFuelVolumeDisplayCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFuelVolumeDisplayCallback)) {
                return (IFuelVolumeDisplayCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onFuelVolumeDisplayValueChanged(parcel.readFloat());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IFuelVolumeDisplayCallback {
            public static IFuelVolumeDisplayCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IFuelVolumeDisplayCallback
            public void onFuelVolumeDisplayValueChanged(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onFuelVolumeDisplayValueChanged(f);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFuelVolumeDisplayCallback iFuelVolumeDisplayCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iFuelVolumeDisplayCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iFuelVolumeDisplayCallback;
            return true;
        }

        public static IFuelVolumeDisplayCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
