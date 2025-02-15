package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ITBoxBaseListener extends IInterface {

    public static class Default implements ITBoxBaseListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onCallCommandResp(boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onCallStateChanged(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onConnectStatusChanged(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onFaultStateReport(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onGeneralInfoResp(GeneralInfo generalInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onNetworkStateReport(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxBaseListener
        public void onSignalStrengthChanged(int i) throws RemoteException {
        }
    }

    void onCallCommandResp(boolean z) throws RemoteException;

    void onCallStateChanged(int i, int i2) throws RemoteException;

    void onConnectStatusChanged(int i) throws RemoteException;

    void onFaultStateReport(int i) throws RemoteException;

    void onGeneralInfoResp(GeneralInfo generalInfo) throws RemoteException;

    void onNetworkStateReport(int i, int i2) throws RemoteException;

    void onSignalStrengthChanged(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ITBoxBaseListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.ITBoxBaseListener";
        static final int TRANSACTION_onCallCommandResp = 4;
        static final int TRANSACTION_onCallStateChanged = 3;
        static final int TRANSACTION_onConnectStatusChanged = 5;
        static final int TRANSACTION_onFaultStateReport = 7;
        static final int TRANSACTION_onGeneralInfoResp = 6;
        static final int TRANSACTION_onNetworkStateReport = 1;
        static final int TRANSACTION_onSignalStrengthChanged = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITBoxBaseListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITBoxBaseListener)) {
                return (ITBoxBaseListener) queryLocalInterface;
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
                    onNetworkStateReport(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSignalStrengthChanged(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCallStateChanged(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCallCommandResp(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onConnectStatusChanged(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onGeneralInfoResp(parcel.readInt() != 0 ? GeneralInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onFaultStateReport(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ITBoxBaseListener {
            public static ITBoxBaseListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.ITBoxBaseListener
            public void onNetworkStateReport(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNetworkStateReport(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxBaseListener
            public void onSignalStrengthChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSignalStrengthChanged(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxBaseListener
            public void onCallStateChanged(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCallStateChanged(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxBaseListener
            public void onCallCommandResp(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCallCommandResp(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxBaseListener
            public void onConnectStatusChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onConnectStatusChanged(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxBaseListener
            public void onGeneralInfoResp(GeneralInfo generalInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (generalInfo != null) {
                        obtain.writeInt(1);
                        generalInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onGeneralInfoResp(generalInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxBaseListener
            public void onFaultStateReport(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onFaultStateReport(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITBoxBaseListener iTBoxBaseListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iTBoxBaseListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTBoxBaseListener;
            return true;
        }

        public static ITBoxBaseListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
