package com.autolink.adapterinterface.tbox2.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IRemoteCallback extends IInterface {

    public static class Default implements IRemoteCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
        public void ecuVersion(List<TboxEcuVersion> list) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
        public void lightShowCtrlReq(byte b) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
        public void uploadLogReq(UploadLogInfo uploadLogInfo) throws RemoteException {
        }
    }

    void ecuVersion(List<TboxEcuVersion> list) throws RemoteException;

    void lightShowCtrlReq(byte b) throws RemoteException;

    void uploadLogReq(UploadLogInfo uploadLogInfo) throws RemoteException;

    public static abstract class Stub extends Binder implements IRemoteCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.remote.IRemoteCallback";
        static final int TRANSACTION_ecuVersion = 2;
        static final int TRANSACTION_lightShowCtrlReq = 1;
        static final int TRANSACTION_uploadLogReq = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemoteCallback)) {
                return (IRemoteCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                lightShowCtrlReq(parcel.readByte());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                ecuVersion(parcel.createTypedArrayList(TboxEcuVersion.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            uploadLogReq(parcel.readInt() != 0 ? UploadLogInfo.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IRemoteCallback {
            public static IRemoteCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
            public void lightShowCtrlReq(byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().lightShowCtrlReq(b);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
            public void ecuVersion(List<TboxEcuVersion> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().ecuVersion(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.remote.IRemoteCallback
            public void uploadLogReq(UploadLogInfo uploadLogInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uploadLogInfo != null) {
                        obtain.writeInt(1);
                        uploadLogInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().uploadLogReq(uploadLogInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRemoteCallback iRemoteCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRemoteCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteCallback;
            return true;
        }

        public static IRemoteCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
