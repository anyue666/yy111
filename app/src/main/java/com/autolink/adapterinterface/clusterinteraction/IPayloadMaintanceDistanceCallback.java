package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPayloadMaintanceDistanceCallback extends IInterface {

    public static class Default implements IPayloadMaintanceDistanceCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback
        public void onPayloadMaintanceDistanceChanged(int i) throws RemoteException {
        }
    }

    void onPayloadMaintanceDistanceChanged(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IPayloadMaintanceDistanceCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback";
        static final int TRANSACTION_onPayloadMaintanceDistanceChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPayloadMaintanceDistanceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPayloadMaintanceDistanceCallback)) {
                return (IPayloadMaintanceDistanceCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onPayloadMaintanceDistanceChanged(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IPayloadMaintanceDistanceCallback {
            public static IPayloadMaintanceDistanceCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IPayloadMaintanceDistanceCallback
            public void onPayloadMaintanceDistanceChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPayloadMaintanceDistanceChanged(i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPayloadMaintanceDistanceCallback iPayloadMaintanceDistanceCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPayloadMaintanceDistanceCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPayloadMaintanceDistanceCallback;
            return true;
        }

        public static IPayloadMaintanceDistanceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
