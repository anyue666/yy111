package com.autolink.adapterinterface.misc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IMiscCustomSettingCallback extends IInterface {

    public static class Default implements IMiscCustomSettingCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.misc.IMiscCustomSettingCallback
        public void onValueChanged(int i, String[] strArr) throws RemoteException {
        }
    }

    void onValueChanged(int i, String[] strArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IMiscCustomSettingCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.misc.IMiscCustomSettingCallback";
        static final int TRANSACTION_onValueChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMiscCustomSettingCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMiscCustomSettingCallback)) {
                return (IMiscCustomSettingCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onValueChanged(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IMiscCustomSettingCallback {
            public static IMiscCustomSettingCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.misc.IMiscCustomSettingCallback
            public void onValueChanged(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onValueChanged(i, strArr);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMiscCustomSettingCallback iMiscCustomSettingCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMiscCustomSettingCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMiscCustomSettingCallback;
            return true;
        }

        public static IMiscCustomSettingCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
