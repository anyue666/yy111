package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IVehicleFaultInfo extends IInterface {

    public static class Default implements IVehicleFaultInfo {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo
        public void onVehicleFaultInfoChanged(int[] iArr) throws RemoteException {
        }
    }

    void onVehicleFaultInfoChanged(int[] iArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IVehicleFaultInfo {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo";
        static final int TRANSACTION_onVehicleFaultInfoChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVehicleFaultInfo asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IVehicleFaultInfo)) {
                return (IVehicleFaultInfo) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onVehicleFaultInfoChanged(parcel.createIntArray());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IVehicleFaultInfo {
            public static IVehicleFaultInfo sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IVehicleFaultInfo
            public void onVehicleFaultInfoChanged(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onVehicleFaultInfoChanged(iArr);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IVehicleFaultInfo iVehicleFaultInfo) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iVehicleFaultInfo == null) {
                return false;
            }
            Proxy.sDefaultImpl = iVehicleFaultInfo;
            return true;
        }

        public static IVehicleFaultInfo getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
