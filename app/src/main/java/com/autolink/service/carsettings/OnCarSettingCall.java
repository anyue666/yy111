package com.autolink.service.carsettings;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface OnCarSettingCall extends IInterface {

    public static class Default implements OnCarSettingCall {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.service.carsettings.OnCarSettingCall
        public void onStateChange(String str, String str2) throws RemoteException {
        }
    }

    void onStateChange(String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements OnCarSettingCall {
        private static final String DESCRIPTOR = "com.autolink.service.carsettings.OnCarSettingCall";
        static final int TRANSACTION_onStateChange = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static OnCarSettingCall asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof OnCarSettingCall)) {
                return (OnCarSettingCall) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onStateChange(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements OnCarSettingCall {
            public static OnCarSettingCall sDefaultImpl;
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

            @Override // com.autolink.service.carsettings.OnCarSettingCall
            public void onStateChange(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onStateChange(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(OnCarSettingCall onCarSettingCall) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (onCarSettingCall == null) {
                return false;
            }
            Proxy.sDefaultImpl = onCarSettingCall;
            return true;
        }

        public static OnCarSettingCall getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
