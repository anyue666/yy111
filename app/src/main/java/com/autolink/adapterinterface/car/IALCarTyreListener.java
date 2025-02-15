package com.autolink.adapterinterface.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALCarTyreListener extends IInterface {

    public static class Default implements IALCarTyreListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.car.IALCarTyreListener
        public void notifyTyreChange(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCarTyreListener
        public void notifyTyreFloatChange(int i, float f) throws RemoteException {
        }
    }

    void notifyTyreChange(int i, int i2) throws RemoteException;

    void notifyTyreFloatChange(int i, float f) throws RemoteException;

    public static abstract class Stub extends Binder implements IALCarTyreListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.car.IALCarTyreListener";
        static final int TRANSACTION_notifyTyreChange = 1;
        static final int TRANSACTION_notifyTyreFloatChange = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALCarTyreListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALCarTyreListener)) {
                return (IALCarTyreListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                notifyTyreChange(parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                notifyTyreFloatChange(parcel.readInt(), parcel.readFloat());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IALCarTyreListener {
            public static IALCarTyreListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.car.IALCarTyreListener
            public void notifyTyreChange(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().notifyTyreChange(i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCarTyreListener
            public void notifyTyreFloatChange(int i, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().notifyTyreFloatChange(i, f);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALCarTyreListener iALCarTyreListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALCarTyreListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALCarTyreListener;
            return true;
        }

        public static IALCarTyreListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
