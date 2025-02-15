package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ITBoxRemoteListner extends IInterface {

    public static class Default implements ITBoxRemoteListner {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void lightShowCtrlReq(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onChargeReserveSetResp(boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onInquireChargeReserveResp(InquireCharge inquireCharge) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onPhoneChargeReserveStatuReport(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onPhoneChargeReserveSyncReq(ChargeReserveSync chargeReserveSync) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxRemoteListner
        public void onRemoteHuAwkReq(byte[] bArr) throws RemoteException {
        }
    }

    void lightShowCtrlReq(int i) throws RemoteException;

    void onChargeReserveSetResp(boolean z) throws RemoteException;

    void onInquireChargeReserveResp(InquireCharge inquireCharge) throws RemoteException;

    void onPhoneChargeReserveStatuReport(int i, int i2) throws RemoteException;

    void onPhoneChargeReserveSyncReq(ChargeReserveSync chargeReserveSync) throws RemoteException;

    void onRemoteHuAwkReq(byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements ITBoxRemoteListner {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.ITBoxRemoteListner";
        static final int TRANSACTION_lightShowCtrlReq = 6;
        static final int TRANSACTION_onChargeReserveSetResp = 2;
        static final int TRANSACTION_onInquireChargeReserveResp = 5;
        static final int TRANSACTION_onPhoneChargeReserveStatuReport = 4;
        static final int TRANSACTION_onPhoneChargeReserveSyncReq = 3;
        static final int TRANSACTION_onRemoteHuAwkReq = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITBoxRemoteListner asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITBoxRemoteListner)) {
                return (ITBoxRemoteListner) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRemoteHuAwkReq(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onChargeReserveSetResp(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPhoneChargeReserveSyncReq(parcel.readInt() != 0 ? ChargeReserveSync.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPhoneChargeReserveStatuReport(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onInquireChargeReserveResp(parcel.readInt() != 0 ? InquireCharge.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    lightShowCtrlReq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ITBoxRemoteListner {
            public static ITBoxRemoteListner sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.ITBoxRemoteListner
            public void onRemoteHuAwkReq(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRemoteHuAwkReq(bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxRemoteListner
            public void onChargeReserveSetResp(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onChargeReserveSetResp(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxRemoteListner
            public void onPhoneChargeReserveSyncReq(ChargeReserveSync chargeReserveSync) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (chargeReserveSync != null) {
                        obtain.writeInt(1);
                        chargeReserveSync.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPhoneChargeReserveSyncReq(chargeReserveSync);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxRemoteListner
            public void onPhoneChargeReserveStatuReport(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPhoneChargeReserveStatuReport(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxRemoteListner
            public void onInquireChargeReserveResp(InquireCharge inquireCharge) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (inquireCharge != null) {
                        obtain.writeInt(1);
                        inquireCharge.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInquireChargeReserveResp(inquireCharge);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxRemoteListner
            public void lightShowCtrlReq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().lightShowCtrlReq(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITBoxRemoteListner iTBoxRemoteListner) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iTBoxRemoteListner == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTBoxRemoteListner;
            return true;
        }

        public static ITBoxRemoteListner getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
