package com.autolink.adapterinterface.tbox2.callcommand;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICallCommandCallback extends IInterface {

    public static class Default implements ICallCommandCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
        public void onCallCommandResponse(TboxCallInfo tboxCallInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
        public void onMuteNotify(boolean z) throws RemoteException {
        }
    }

    void onCallCommandResponse(TboxCallInfo tboxCallInfo) throws RemoteException;

    void onMuteNotify(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements ICallCommandCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback";
        static final int TRANSACTION_onCallCommandResponse = 1;
        static final int TRANSACTION_onMuteNotify = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICallCommandCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICallCommandCallback)) {
                return (ICallCommandCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onCallCommandResponse(parcel.readInt() != 0 ? TboxCallInfo.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onMuteNotify(parcel.readInt() != 0);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICallCommandCallback {
            public static ICallCommandCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
            public void onCallCommandResponse(TboxCallInfo tboxCallInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxCallInfo != null) {
                        obtain.writeInt(1);
                        tboxCallInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCallCommandResponse(tboxCallInfo);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.callcommand.ICallCommandCallback
            public void onMuteNotify(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onMuteNotify(z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICallCommandCallback iCallCommandCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCallCommandCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCallCommandCallback;
            return true;
        }

        public static ICallCommandCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
