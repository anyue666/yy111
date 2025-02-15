package com.autolink.voicetts;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.voicetts.IStatusCallBack;

/* loaded from: classes.dex */
public interface IVoiceServiceInterface extends IInterface {

    public static class Default implements IVoiceServiceInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.voicetts.IVoiceServiceInterface
        public void closeVpa() throws RemoteException {
        }

        @Override // com.autolink.voicetts.IVoiceServiceInterface
        public void showTtsContent(String str) throws RemoteException {
        }

        @Override // com.autolink.voicetts.IVoiceServiceInterface
        public void startSpeak(String str, String str2, IStatusCallBack iStatusCallBack, String str3) throws RemoteException {
        }

        @Override // com.autolink.voicetts.IVoiceServiceInterface
        public void stopSpeak(String str) throws RemoteException {
        }
    }

    void closeVpa() throws RemoteException;

    void showTtsContent(String str) throws RemoteException;

    void startSpeak(String str, String str2, IStatusCallBack iStatusCallBack, String str3) throws RemoteException;

    void stopSpeak(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IVoiceServiceInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.autolink.voicetts.IVoiceServiceInterface");
        }

        public static IVoiceServiceInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.autolink.voicetts.IVoiceServiceInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IVoiceServiceInterface)) {
                return (IVoiceServiceInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.autolink.voicetts.IVoiceServiceInterface");
                startSpeak(parcel.readString(), parcel.readString(), IStatusCallBack.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.autolink.voicetts.IVoiceServiceInterface");
                stopSpeak(parcel.readString());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.autolink.voicetts.IVoiceServiceInterface");
                closeVpa();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.autolink.voicetts.IVoiceServiceInterface");
                showTtsContent(parcel.readString());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("com.autolink.voicetts.IVoiceServiceInterface");
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        public static class Proxy implements IVoiceServiceInterface {
            public static IVoiceServiceInterface sDefaultImpl;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.autolink.voicetts.IVoiceServiceInterface
            public void startSpeak(String str, String str2, IStatusCallBack iStatusCallBack, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autolink.voicetts.IVoiceServiceInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iStatusCallBack != null ? iStatusCallBack.asBinder() : null);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().startSpeak(str, str2, iStatusCallBack, str3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.voicetts.IVoiceServiceInterface
            public void stopSpeak(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autolink.voicetts.IVoiceServiceInterface");
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().stopSpeak(str);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.voicetts.IVoiceServiceInterface
            public void closeVpa() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autolink.voicetts.IVoiceServiceInterface");
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().closeVpa();
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.voicetts.IVoiceServiceInterface
            public void showTtsContent(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autolink.voicetts.IVoiceServiceInterface");
                    obtain.writeString(str);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().showTtsContent(str);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IVoiceServiceInterface iVoiceServiceInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iVoiceServiceInterface == null) {
                return false;
            }
            Proxy.sDefaultImpl = iVoiceServiceInterface;
            return true;
        }

        public static IVoiceServiceInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
