package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IChargePowerInfoCallback extends IInterface {

    public static class Default implements IChargePowerInfoCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback
        public void onChargePowerInfoChanged(float f, float f2, float f3) throws RemoteException {
        }
    }

    void onChargePowerInfoChanged(float f, float f2, float f3) throws RemoteException;

    public static abstract class Stub extends Binder implements IChargePowerInfoCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback";
        static final int TRANSACTION_onChargePowerInfoChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IChargePowerInfoCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IChargePowerInfoCallback)) {
                return (IChargePowerInfoCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onChargePowerInfoChanged(parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IChargePowerInfoCallback {
            public static IChargePowerInfoCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IChargePowerInfoCallback
            public void onChargePowerInfoChanged(float f, float f2, float f3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    obtain.writeFloat(f3);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onChargePowerInfoChanged(f, f2, f3);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IChargePowerInfoCallback iChargePowerInfoCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iChargePowerInfoCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iChargePowerInfoCallback;
            return true;
        }

        public static IChargePowerInfoCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
