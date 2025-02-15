package com.autolink.adapterinterface.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALCarWindListener extends IInterface {

    public static class Default implements IALCarWindListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.car.IALCarWindListener
        public void notifyCarWindEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
        }
    }

    void notifyCarWindEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException;

    public static abstract class Stub extends Binder implements IALCarWindListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.car.IALCarWindListener";
        static final int TRANSACTION_notifyCarWindEvent = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALCarWindListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALCarWindListener)) {
                return (IALCarWindListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notifyCarWindEvent(parcel.readInt() != 0 ? ALCarPropertyEvent.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IALCarWindListener {
            public static IALCarWindListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.car.IALCarWindListener
            public void notifyCarWindEvent(ALCarPropertyEvent aLCarPropertyEvent) throws RemoteException {
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
                    Stub.getDefaultImpl().notifyCarWindEvent(aLCarPropertyEvent);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALCarWindListener iALCarWindListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALCarWindListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALCarWindListener;
            return true;
        }

        public static IALCarWindListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
