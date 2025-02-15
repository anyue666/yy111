package com.autolink.adapterinterface.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALCarAVMPropertyListener extends IInterface {

    public static class Default implements IALCarAVMPropertyListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.car.IALCarAVMPropertyListener
        public void notifyCarAVMPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
        }
    }

    void notifyCarAVMPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException;

    public static abstract class Stub extends Binder implements IALCarAVMPropertyListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.car.IALCarAVMPropertyListener";
        static final int TRANSACTION_notifyCarAVMPropertyEvent = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALCarAVMPropertyListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALCarAVMPropertyListener)) {
                return (IALCarAVMPropertyListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notifyCarAVMPropertyEvent(parcel.readInt() != 0 ? ALCarPropertyEvent.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IALCarAVMPropertyListener {
            public static IALCarAVMPropertyListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.car.IALCarAVMPropertyListener
            public void notifyCarAVMPropertyEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
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
                    Stub.getDefaultImpl().notifyCarAVMPropertyEvent(aLCarPropertyEvent);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALCarAVMPropertyListener iALCarAVMPropertyListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALCarAVMPropertyListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALCarAVMPropertyListener;
            return true;
        }

        public static IALCarAVMPropertyListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
