package com.autolink.adapterinterface.audio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALAudio extends IInterface {

    public static class Default implements IALAudio {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.audio.IALAudio
        public boolean isRhythmLampOpen() throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.audio.IALAudio
        public void registerRhythmLampListener(IBinder iBinder) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.audio.IALAudio
        public void setRhythmLampChangeSpeed(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.audio.IALAudio
        public boolean setRhythmLampOpen(boolean z) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.audio.IALAudio
        public boolean setVoiceLampOpen(boolean z) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.audio.IALAudio
        public void unregisterRhythmLampListener(IBinder iBinder) throws RemoteException {
        }
    }

    boolean isRhythmLampOpen() throws RemoteException;

    void registerRhythmLampListener(IBinder iBinder) throws RemoteException;

    void setRhythmLampChangeSpeed(int i) throws RemoteException;

    boolean setRhythmLampOpen(boolean z) throws RemoteException;

    boolean setVoiceLampOpen(boolean z) throws RemoteException;

    void unregisterRhythmLampListener(IBinder iBinder) throws RemoteException;

    public static abstract class Stub extends Binder implements IALAudio {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.audio.IALAudio";
        static final int TRANSACTION_isRhythmLampOpen = 2;
        static final int TRANSACTION_registerRhythmLampListener = 5;
        static final int TRANSACTION_setRhythmLampChangeSpeed = 4;
        static final int TRANSACTION_setRhythmLampOpen = 1;
        static final int TRANSACTION_setVoiceLampOpen = 3;
        static final int TRANSACTION_unregisterRhythmLampListener = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALAudio asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALAudio)) {
                return (IALAudio) queryLocalInterface;
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
                    boolean rhythmLampOpen = setRhythmLampOpen(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(rhythmLampOpen ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isRhythmLampOpen = isRhythmLampOpen();
                    parcel2.writeNoException();
                    parcel2.writeInt(isRhythmLampOpen ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voiceLampOpen = setVoiceLampOpen(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(voiceLampOpen ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRhythmLampChangeSpeed(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerRhythmLampListener(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterRhythmLampListener(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IALAudio {
            public static IALAudio sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.audio.IALAudio
            public boolean setRhythmLampOpen(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setRhythmLampOpen(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.audio.IALAudio
            public boolean isRhythmLampOpen() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isRhythmLampOpen();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.audio.IALAudio
            public boolean setVoiceLampOpen(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setVoiceLampOpen(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.audio.IALAudio
            public void setRhythmLampChangeSpeed(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRhythmLampChangeSpeed(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.audio.IALAudio
            public void registerRhythmLampListener(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerRhythmLampListener(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.audio.IALAudio
            public void unregisterRhythmLampListener(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterRhythmLampListener(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALAudio iALAudio) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALAudio == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALAudio;
            return true;
        }

        public static IALAudio getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
