package com.autolink.adapterinterface.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALCarVehicleControlPropertyListener extends IInterface {

    public static class Default implements IALCarVehicleControlPropertyListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.car.IALCarVehicleControlPropertyListener
        public void notifyCarVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
        }
    }

    void notifyCarVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException;

    public static abstract class Stub extends Binder implements IALCarVehicleControlPropertyListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.car.IALCarVehicleControlPropertyListener";
        static final int TRANSACTION_notifyCarVehicleControlPropertyEvent = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALCarVehicleControlPropertyListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALCarVehicleControlPropertyListener)) {
                return (IALCarVehicleControlPropertyListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notifyCarVehicleControlPropertyEvent(parcel.readInt() != 0 ? ALCarPropertyEvent.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IALCarVehicleControlPropertyListener {
            public static IALCarVehicleControlPropertyListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.car.IALCarVehicleControlPropertyListener
            public void notifyCarVehicleControlPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (aLCarPropertyEvent != null) {
                        obtain.writeInt(1);
                        aLCarPropertyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().notifyCarVehicleControlPropertyEvent(aLCarPropertyEvent);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALCarVehicleControlPropertyListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALCarVehicleControlPropertyListener;
            return true;
        }

        public static IALCarVehicleControlPropertyListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
