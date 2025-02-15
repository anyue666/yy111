package com.autolink.adapterinterface.misc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.misc.INetspeedCallback;
import com.autolink.adapterinterface.misc.IPitchRollAngleCallback;

/* loaded from: classes.dex */
public interface IALMisc extends IInterface {

    public static class Default implements IALMisc {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public String[] getCustomSetting(int i, String[] strArr) throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public void registerCustomSettingCallback(IBinder iBinder) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public void registerNetspeedCallback(INetspeedCallback iNetspeedCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public void registerPitchRollAngleCallback(IPitchRollAngleCallback iPitchRollAngleCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public String[] setCustomSetting(int i, String[] strArr) throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public void unregisterCustomSettingCallback(IBinder iBinder) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public void unregisterNetspeedCallback(INetspeedCallback iNetspeedCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.misc.IALMisc
        public void unregisterPitchRollAngleCallback(IPitchRollAngleCallback iPitchRollAngleCallback) throws RemoteException {
        }
    }

    String[] getCustomSetting(int i, String[] strArr) throws RemoteException;

    void registerCustomSettingCallback(IBinder iBinder) throws RemoteException;

    void registerNetspeedCallback(INetspeedCallback iNetspeedCallback) throws RemoteException;

    void registerPitchRollAngleCallback(IPitchRollAngleCallback iPitchRollAngleCallback) throws RemoteException;

    String[] setCustomSetting(int i, String[] strArr) throws RemoteException;

    void unregisterCustomSettingCallback(IBinder iBinder) throws RemoteException;

    void unregisterNetspeedCallback(INetspeedCallback iNetspeedCallback) throws RemoteException;

    void unregisterPitchRollAngleCallback(IPitchRollAngleCallback iPitchRollAngleCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IALMisc {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.misc.IALMisc";
        static final int TRANSACTION_getCustomSetting = 2;
        static final int TRANSACTION_registerCustomSettingCallback = 3;
        static final int TRANSACTION_registerNetspeedCallback = 7;
        static final int TRANSACTION_registerPitchRollAngleCallback = 5;
        static final int TRANSACTION_setCustomSetting = 1;
        static final int TRANSACTION_unregisterCustomSettingCallback = 4;
        static final int TRANSACTION_unregisterNetspeedCallback = 8;
        static final int TRANSACTION_unregisterPitchRollAngleCallback = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALMisc asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALMisc)) {
                return (IALMisc) queryLocalInterface;
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
                    String[] customSetting = setCustomSetting(parcel.readInt(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(customSetting);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    String[] customSetting2 = getCustomSetting(parcel.readInt(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(customSetting2);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCustomSettingCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCustomSettingCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerPitchRollAngleCallback(IPitchRollAngleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterPitchRollAngleCallback(IPitchRollAngleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerNetspeedCallback(INetspeedCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterNetspeedCallback(INetspeedCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IALMisc {
            public static IALMisc sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public String[] setCustomSetting(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setCustomSetting(i, strArr);
                    }
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public String[] getCustomSetting(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCustomSetting(i, strArr);
                    }
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public void registerCustomSettingCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCustomSettingCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public void unregisterCustomSettingCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCustomSettingCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public void registerPitchRollAngleCallback(IPitchRollAngleCallback iPitchRollAngleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPitchRollAngleCallback != null ? iPitchRollAngleCallback.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerPitchRollAngleCallback(iPitchRollAngleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public void unregisterPitchRollAngleCallback(IPitchRollAngleCallback iPitchRollAngleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPitchRollAngleCallback != null ? iPitchRollAngleCallback.asBinder() : null);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterPitchRollAngleCallback(iPitchRollAngleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public void registerNetspeedCallback(INetspeedCallback iNetspeedCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNetspeedCallback != null ? iNetspeedCallback.asBinder() : null);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerNetspeedCallback(iNetspeedCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.misc.IALMisc
            public void unregisterNetspeedCallback(INetspeedCallback iNetspeedCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iNetspeedCallback != null ? iNetspeedCallback.asBinder() : null);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterNetspeedCallback(iNetspeedCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALMisc iALMisc) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALMisc == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALMisc;
            return true;
        }

        public static IALMisc getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
