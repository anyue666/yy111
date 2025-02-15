package com.autolink.voicetts;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStatusCallBack extends IInterface {

    public static class Default implements IStatusCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.voicetts.IStatusCallBack
        public void onStatusChange(String str, int i) throws RemoteException {
        }

        @Override // com.autolink.voicetts.IStatusCallBack
        public void onVoiceIdCreate(String str) throws RemoteException {
        }
    }

    void onStatusChange(String str, int i) throws RemoteException;

    void onVoiceIdCreate(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IStatusCallBack {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.autolink.voicetts.IStatusCallBack");
        }

        public static IStatusCallBack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.autolink.voicetts.IStatusCallBack");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IStatusCallBack)) {
                return (IStatusCallBack) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.autolink.voicetts.IStatusCallBack");
                onStatusChange(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.autolink.voicetts.IStatusCallBack");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.autolink.voicetts.IStatusCallBack");
            onVoiceIdCreate(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        public static class Proxy implements IStatusCallBack {
            public static IStatusCallBack sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.autolink.voicetts.IStatusCallBack
            public void onStatusChange(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autolink.voicetts.IStatusCallBack");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onStatusChange(str, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.voicetts.IStatusCallBack
            public void onVoiceIdCreate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autolink.voicetts.IStatusCallBack");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVoiceIdCreate(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IStatusCallBack iStatusCallBack) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iStatusCallBack == null) {
                return false;
            }
            Proxy.sDefaultImpl = iStatusCallBack;
            return true;
        }

        public static IStatusCallBack getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
