package com.autolink.adapterinterface.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALCarEngineSpeedListener extends IInterface {

    public static class Default implements IALCarEngineSpeedListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.car.IALCarEngineSpeedListener
        public void notifyEngineSpeedChange(float f, int i) throws RemoteException {
        }
    }

    void notifyEngineSpeedChange(float f, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IALCarEngineSpeedListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.car.IALCarEngineSpeedListener";
        static final int TRANSACTION_notifyEngineSpeedChange = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALCarEngineSpeedListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALCarEngineSpeedListener)) {
                return (IALCarEngineSpeedListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notifyEngineSpeedChange(parcel.readFloat(), parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IALCarEngineSpeedListener {
            public static IALCarEngineSpeedListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.car.IALCarEngineSpeedListener
            public void notifyEngineSpeedChange(float f, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().notifyEngineSpeedChange(f, i);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALCarEngineSpeedListener iALCarEngineSpeedListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALCarEngineSpeedListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALCarEngineSpeedListener;
            return true;
        }

        public static IALCarEngineSpeedListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
