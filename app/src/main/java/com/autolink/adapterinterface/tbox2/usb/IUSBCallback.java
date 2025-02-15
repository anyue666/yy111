package com.autolink.adapterinterface.tbox2.usb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IUSBCallback extends IInterface {

    public static class Default implements IUSBCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
        public void subNodeReqEnterFactoryResp(byte b) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
        public void subNodeReqStartFactoryResp(byte b) throws RemoteException {
        }
    }

    void subNodeReqEnterFactoryResp(byte b) throws RemoteException;

    void subNodeReqStartFactoryResp(byte b) throws RemoteException;

    public static abstract class Stub extends Binder implements IUSBCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.usb.IUSBCallback";
        static final int TRANSACTION_subNodeReqEnterFactoryResp = 1;
        static final int TRANSACTION_subNodeReqStartFactoryResp = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUSBCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUSBCallback)) {
                return (IUSBCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                subNodeReqEnterFactoryResp(parcel.readByte());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            subNodeReqStartFactoryResp(parcel.readByte());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IUSBCallback {
            public static IUSBCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
            public void subNodeReqEnterFactoryResp(byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().subNodeReqEnterFactoryResp(b);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSBCallback
            public void subNodeReqStartFactoryResp(byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().subNodeReqStartFactoryResp(b);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IUSBCallback iUSBCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iUSBCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iUSBCallback;
            return true;
        }

        public static IUSBCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
