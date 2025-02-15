package com.autolink.adapterinterface.upgrade;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.upgrade.IUpgradeCallback;
import com.autolink.adapterinterface.upgrade.IUpgradeResultCallback;

/* loaded from: classes.dex */
public interface IUpgradeService extends IInterface {

    public static class Default implements IUpgradeService {
        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public void applyDisplayPayload(Bundle bundle) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public void applyOTAPayload(Bundle bundle) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public void applyUSBPayload(Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public void registerUpgradeCallback(IUpgradeCallback iUpgradeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public void registerUpgradeResultCallback(IUpgradeResultCallback iUpgradeResultCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public int requestUpgradeResult(int i, String str) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public void unregisterUpgradeCallback(IUpgradeCallback iUpgradeCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
        public void unregisterUpgradeResultCallback(IUpgradeResultCallback iUpgradeResultCallback) throws RemoteException {
        }
    }

    void applyDisplayPayload(Bundle bundle) throws RemoteException;

    void applyOTAPayload(Bundle bundle) throws RemoteException;

    void applyUSBPayload(Bundle bundle) throws RemoteException;

    void registerUpgradeCallback(IUpgradeCallback iUpgradeCallback) throws RemoteException;

    void registerUpgradeResultCallback(IUpgradeResultCallback iUpgradeResultCallback) throws RemoteException;

    int requestUpgradeResult(int i, String str) throws RemoteException;

    void unregisterUpgradeCallback(IUpgradeCallback iUpgradeCallback) throws RemoteException;

    void unregisterUpgradeResultCallback(IUpgradeResultCallback iUpgradeResultCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IUpgradeService {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.upgrade.IUpgradeService";
        static final int TRANSACTION_applyDisplayPayload = 7;
        static final int TRANSACTION_applyOTAPayload = 5;
        static final int TRANSACTION_applyUSBPayload = 6;
        static final int TRANSACTION_registerUpgradeCallback = 1;
        static final int TRANSACTION_registerUpgradeResultCallback = 3;
        static final int TRANSACTION_requestUpgradeResult = 8;
        static final int TRANSACTION_unregisterUpgradeCallback = 2;
        static final int TRANSACTION_unregisterUpgradeResultCallback = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUpgradeService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUpgradeService)) {
                return (IUpgradeService) queryLocalInterface;
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
                    registerUpgradeCallback(IUpgradeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterUpgradeCallback(IUpgradeCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerUpgradeResultCallback(IUpgradeResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterUpgradeResultCallback(IUpgradeResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    applyOTAPayload(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    applyUSBPayload(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    applyDisplayPayload(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int requestUpgradeResult = requestUpgradeResult(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(requestUpgradeResult);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IUpgradeService {
            public static IUpgradeService sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public void registerUpgradeCallback(IUpgradeCallback iUpgradeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iUpgradeCallback != null ? iUpgradeCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerUpgradeCallback(iUpgradeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public void unregisterUpgradeCallback(IUpgradeCallback iUpgradeCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iUpgradeCallback != null ? iUpgradeCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterUpgradeCallback(iUpgradeCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public void registerUpgradeResultCallback(IUpgradeResultCallback iUpgradeResultCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iUpgradeResultCallback != null ? iUpgradeResultCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerUpgradeResultCallback(iUpgradeResultCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public void unregisterUpgradeResultCallback(IUpgradeResultCallback iUpgradeResultCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iUpgradeResultCallback != null ? iUpgradeResultCallback.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterUpgradeResultCallback(iUpgradeResultCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public void applyOTAPayload(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().applyOTAPayload(bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public void applyUSBPayload(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().applyUSBPayload(bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public void applyDisplayPayload(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().applyDisplayPayload(bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.upgrade.IUpgradeService
            public int requestUpgradeResult(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestUpgradeResult(i, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IUpgradeService iUpgradeService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iUpgradeService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iUpgradeService;
            return true;
        }

        public static IUpgradeService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
