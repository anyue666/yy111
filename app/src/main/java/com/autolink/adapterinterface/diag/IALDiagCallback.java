package com.autolink.adapterinterface.diag;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALDiagCallback extends IInterface {

    public static class Default implements IALDiagCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.diag.IALDiagCallback
        public void readInfoFromHalReport(DiagReadResp diagReadResp) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.diag.IALDiagCallback
        public void writeInfoToHalReport(DiagWriteResp diagWriteResp) throws RemoteException {
        }
    }

    void readInfoFromHalReport(DiagReadResp diagReadResp) throws RemoteException;

    void writeInfoToHalReport(DiagWriteResp diagWriteResp) throws RemoteException;

    public static abstract class Stub extends Binder implements IALDiagCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.diag.IALDiagCallback";
        static final int TRANSACTION_readInfoFromHalReport = 1;
        static final int TRANSACTION_writeInfoToHalReport = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALDiagCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALDiagCallback)) {
                return (IALDiagCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                readInfoFromHalReport(parcel.readInt() != 0 ? DiagReadResp.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                writeInfoToHalReport(parcel.readInt() != 0 ? DiagWriteResp.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IALDiagCallback {
            public static IALDiagCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.diag.IALDiagCallback
            public void readInfoFromHalReport(DiagReadResp diagReadResp) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (diagReadResp != null) {
                        obtain.writeInt(1);
                        diagReadResp.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().readInfoFromHalReport(diagReadResp);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.diag.IALDiagCallback
            public void writeInfoToHalReport(DiagWriteResp diagWriteResp) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (diagWriteResp != null) {
                        obtain.writeInt(1);
                        diagWriteResp.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().writeInfoToHalReport(diagWriteResp);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALDiagCallback iALDiagCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALDiagCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALDiagCallback;
            return true;
        }

        public static IALDiagCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
