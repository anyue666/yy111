package com.autolink.service.carsettings;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.service.carsettings.OnCarSettingCall;

/* loaded from: classes.dex */
public interface ALCarSetting extends IInterface {

    public static class Default implements ALCarSetting {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.service.carsettings.ALCarSetting
        public String get(String str) throws RemoteException {
            return null;
        }

        @Override // com.autolink.service.carsettings.ALCarSetting
        public void register(OnCarSettingCall onCarSettingCall) throws RemoteException {
        }

        @Override // com.autolink.service.carsettings.ALCarSetting
        public void set(String str, String str2) throws RemoteException {
        }

        @Override // com.autolink.service.carsettings.ALCarSetting
        public void unRegister(OnCarSettingCall onCarSettingCall) throws RemoteException {
        }
    }

    String get(String str) throws RemoteException;

    void register(OnCarSettingCall onCarSettingCall) throws RemoteException;

    void set(String str, String str2) throws RemoteException;

    void unRegister(OnCarSettingCall onCarSettingCall) throws RemoteException;

    public static abstract class Stub extends Binder implements ALCarSetting {
        private static final String DESCRIPTOR = "com.autolink.service.carsettings.ALCarSetting";
        static final int TRANSACTION_get = 4;
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_set = 3;
        static final int TRANSACTION_unRegister = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ALCarSetting asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ALCarSetting)) {
                return (ALCarSetting) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                register(OnCarSettingCall.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                unRegister(OnCarSettingCall.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                set(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            String str = get(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(str);
            return true;
        }

        private static class Proxy implements ALCarSetting {
            public static ALCarSetting sDefaultImpl;
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

            @Override // com.autolink.service.carsettings.ALCarSetting
            public void register(OnCarSettingCall onCarSettingCall) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(onCarSettingCall != null ? onCarSettingCall.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().register(onCarSettingCall);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.service.carsettings.ALCarSetting
            public void unRegister(OnCarSettingCall onCarSettingCall) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(onCarSettingCall != null ? onCarSettingCall.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unRegister(onCarSettingCall);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.service.carsettings.ALCarSetting
            public void set(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().set(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.service.carsettings.ALCarSetting
            public String get(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().get(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ALCarSetting aLCarSetting) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aLCarSetting == null) {
                return false;
            }
            Proxy.sDefaultImpl = aLCarSetting;
            return true;
        }

        public static ALCarSetting getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
