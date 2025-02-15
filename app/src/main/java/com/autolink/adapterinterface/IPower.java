package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.IPowerCallback;

/* loaded from: classes.dex */
public interface IPower extends IInterface {

    public static class Default implements IPower {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.IPower
        public void enterUpgradeState() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void exitUpgradeState() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public int getHmiBrightness() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.IPower
        public int getIviBrightness() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.IPower
        public int getIviBrightnessMode() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.IPower
        public int getIviDisplayPowerState() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.IPower
        public int getIviThemeMode() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.IPower
        public boolean isCurScreenSaver() throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.IPower
        public void registerPowerCallback(IPowerCallback iPowerCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void sendScreensaverEvent(int i, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void setHmiBrightness(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void setIviBrightness(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void setIviBrightnessMode(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void setIviDisplayPowerState(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void setIviThemeMode(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.IPower
        public void unregisterPowerCallback(IPowerCallback iPowerCallback) throws RemoteException {
        }
    }

    void enterUpgradeState() throws RemoteException;

    void exitUpgradeState() throws RemoteException;

    int getHmiBrightness() throws RemoteException;

    int getIviBrightness() throws RemoteException;

    int getIviBrightnessMode() throws RemoteException;

    int getIviDisplayPowerState() throws RemoteException;

    int getIviThemeMode() throws RemoteException;

    boolean isCurScreenSaver() throws RemoteException;

    void registerPowerCallback(IPowerCallback iPowerCallback) throws RemoteException;

    void sendScreensaverEvent(int i, boolean z) throws RemoteException;

    void setHmiBrightness(int i) throws RemoteException;

    void setIviBrightness(int i) throws RemoteException;

    void setIviBrightnessMode(int i) throws RemoteException;

    void setIviDisplayPowerState(int i) throws RemoteException;

    void setIviThemeMode(int i) throws RemoteException;

    void unregisterPowerCallback(IPowerCallback iPowerCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IPower {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.IPower";
        static final int TRANSACTION_enterUpgradeState = 12;
        static final int TRANSACTION_exitUpgradeState = 13;
        static final int TRANSACTION_getHmiBrightness = 6;
        static final int TRANSACTION_getIviBrightness = 4;
        static final int TRANSACTION_getIviBrightnessMode = 10;
        static final int TRANSACTION_getIviDisplayPowerState = 15;
        static final int TRANSACTION_getIviThemeMode = 8;
        static final int TRANSACTION_isCurScreenSaver = 16;
        static final int TRANSACTION_registerPowerCallback = 1;
        static final int TRANSACTION_sendScreensaverEvent = 11;
        static final int TRANSACTION_setHmiBrightness = 5;
        static final int TRANSACTION_setIviBrightness = 3;
        static final int TRANSACTION_setIviBrightnessMode = 9;
        static final int TRANSACTION_setIviDisplayPowerState = 14;
        static final int TRANSACTION_setIviThemeMode = 7;
        static final int TRANSACTION_unregisterPowerCallback = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPower asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPower)) {
                return (IPower) queryLocalInterface;
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
                    registerPowerCallback(IPowerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterPowerCallback(IPowerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    setIviBrightness(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iviBrightness = getIviBrightness();
                    parcel2.writeNoException();
                    parcel2.writeInt(iviBrightness);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    setHmiBrightness(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int hmiBrightness = getHmiBrightness();
                    parcel2.writeNoException();
                    parcel2.writeInt(hmiBrightness);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setIviThemeMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iviThemeMode = getIviThemeMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(iviThemeMode);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    setIviBrightnessMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iviBrightnessMode = getIviBrightnessMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(iviBrightnessMode);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendScreensaverEvent(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    enterUpgradeState();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    exitUpgradeState();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    setIviDisplayPowerState(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int iviDisplayPowerState = getIviDisplayPowerState();
                    parcel2.writeNoException();
                    parcel2.writeInt(iviDisplayPowerState);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isCurScreenSaver = isCurScreenSaver();
                    parcel2.writeNoException();
                    parcel2.writeInt(isCurScreenSaver ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IPower {
            public static IPower sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.IPower
            public void registerPowerCallback(IPowerCallback iPowerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPowerCallback != null ? iPowerCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerPowerCallback(iPowerCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void unregisterPowerCallback(IPowerCallback iPowerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iPowerCallback != null ? iPowerCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterPowerCallback(iPowerCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void setIviBrightness(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setIviBrightness(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public int getIviBrightness() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIviBrightness();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void setHmiBrightness(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setHmiBrightness(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public int getHmiBrightness() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getHmiBrightness();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void setIviThemeMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setIviThemeMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public int getIviThemeMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIviThemeMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void setIviBrightnessMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setIviBrightnessMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public int getIviBrightnessMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIviBrightnessMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void sendScreensaverEvent(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendScreensaverEvent(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void enterUpgradeState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enterUpgradeState();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void exitUpgradeState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().exitUpgradeState();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public void setIviDisplayPowerState(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setIviDisplayPowerState(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public int getIviDisplayPowerState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIviDisplayPowerState();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.IPower
            public boolean isCurScreenSaver() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isCurScreenSaver();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IPower iPower) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iPower == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPower;
            return true;
        }

        public static IPower getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
