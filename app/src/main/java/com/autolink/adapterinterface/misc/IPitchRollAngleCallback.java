package com.autolink.adapterinterface.misc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPitchRollAngleCallback extends IInterface {

    public static class Default implements IPitchRollAngleCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.misc.IPitchRollAngleCallback
        public void onPitchRollAngleChanged(float f, float f2) throws RemoteException {
        }
    }

    void onPitchRollAngleChanged(float f, float f2) throws RemoteException;

    public static abstract class Stub extends Binder implements IPitchRollAngleCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.misc.IPitchRollAngleCallback";
        static final int TRANSACTION_onPitchRollAngleChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPitchRollAngleCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPitchRollAngleCallback)) {
                return (IPitchRollAngleCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onPitchRollAngleChanged(parcel.readFloat(), parcel.readFloat());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IPitchRollAngleCallback {
            public static IPitchRollAngleCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.misc.IPitchRollAngleCallback
            public void onPitchRollAngleChanged(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPitchRollAngleChanged(f, f2);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPitchRollAngleCallback iPitchRollAngleCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPitchRollAngleCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPitchRollAngleCallback;
            return true;
        }

        public static IPitchRollAngleCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
