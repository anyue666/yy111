package android.car.diagnostic;

import android.car.diagnostic.ICarDiagnosticEventListener;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarDiagnostic extends IInterface {

    public static class Default implements ICarDiagnostic {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public boolean clearFreezeFrames(long[] jArr) throws RemoteException {
            return false;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public CarDiagnosticEvent getFreezeFrame(long j) throws RemoteException {
            return null;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public long[] getFreezeFrameTimestamps() throws RemoteException {
            return null;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public CarDiagnosticEvent getLatestLiveFrame() throws RemoteException {
            return null;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public boolean isClearFreezeFramesSupported() throws RemoteException {
            return false;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public boolean isFreezeFrameNotificationSupported() throws RemoteException {
            return false;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public boolean isGetFreezeFrameSupported() throws RemoteException {
            return false;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public boolean isLiveFrameSupported() throws RemoteException {
            return false;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public boolean isSelectiveClearFreezeFramesSupported() throws RemoteException {
            return false;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public boolean registerOrUpdateDiagnosticListener(int i, int i2, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException {
            return false;
        }

        @Override // android.car.diagnostic.ICarDiagnostic
        public void unregisterDiagnosticListener(int i, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException {
        }
    }

    boolean clearFreezeFrames(long[] jArr) throws RemoteException;

    CarDiagnosticEvent getFreezeFrame(long j) throws RemoteException;

    long[] getFreezeFrameTimestamps() throws RemoteException;

    CarDiagnosticEvent getLatestLiveFrame() throws RemoteException;

    boolean isClearFreezeFramesSupported() throws RemoteException;

    boolean isFreezeFrameNotificationSupported() throws RemoteException;

    boolean isGetFreezeFrameSupported() throws RemoteException;

    boolean isLiveFrameSupported() throws RemoteException;

    boolean isSelectiveClearFreezeFramesSupported() throws RemoteException;

    boolean registerOrUpdateDiagnosticListener(int i, int i2, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException;

    void unregisterDiagnosticListener(int i, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarDiagnostic {
        private static final String DESCRIPTOR = "android.car.diagnostic.ICarDiagnostic";
        static final int TRANSACTION_clearFreezeFrames = 6;
        static final int TRANSACTION_getFreezeFrame = 5;
        static final int TRANSACTION_getFreezeFrameTimestamps = 4;
        static final int TRANSACTION_getLatestLiveFrame = 3;
        static final int TRANSACTION_isClearFreezeFramesSupported = 11;
        static final int TRANSACTION_isFreezeFrameNotificationSupported = 9;
        static final int TRANSACTION_isGetFreezeFrameSupported = 10;
        static final int TRANSACTION_isLiveFrameSupported = 8;
        static final int TRANSACTION_isSelectiveClearFreezeFramesSupported = 12;
        static final int TRANSACTION_registerOrUpdateDiagnosticListener = 2;
        static final int TRANSACTION_unregisterDiagnosticListener = 7;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarDiagnostic asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarDiagnostic)) {
                return (ICarDiagnostic) queryLocalInterface;
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
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean registerOrUpdateDiagnosticListener = registerOrUpdateDiagnosticListener(parcel.readInt(), parcel.readInt(), ICarDiagnosticEventListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerOrUpdateDiagnosticListener ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    CarDiagnosticEvent latestLiveFrame = getLatestLiveFrame();
                    parcel2.writeNoException();
                    if (latestLiveFrame != null) {
                        parcel2.writeInt(1);
                        latestLiveFrame.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    long[] freezeFrameTimestamps = getFreezeFrameTimestamps();
                    parcel2.writeNoException();
                    parcel2.writeLongArray(freezeFrameTimestamps);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    CarDiagnosticEvent freezeFrame = getFreezeFrame(parcel.readLong());
                    parcel2.writeNoException();
                    if (freezeFrame != null) {
                        parcel2.writeInt(1);
                        freezeFrame.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean clearFreezeFrames = clearFreezeFrames(parcel.createLongArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(clearFreezeFrames ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDiagnosticListener(parcel.readInt(), ICarDiagnosticEventListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isLiveFrameSupported = isLiveFrameSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(isLiveFrameSupported ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isFreezeFrameNotificationSupported = isFreezeFrameNotificationSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(isFreezeFrameNotificationSupported ? 1 : 0);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isGetFreezeFrameSupported = isGetFreezeFrameSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(isGetFreezeFrameSupported ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isClearFreezeFramesSupported = isClearFreezeFramesSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(isClearFreezeFramesSupported ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isSelectiveClearFreezeFramesSupported = isSelectiveClearFreezeFramesSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(isSelectiveClearFreezeFramesSupported ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarDiagnostic {
            public static ICarDiagnostic sDefaultImpl;
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

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean registerOrUpdateDiagnosticListener(int i, int i2, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iCarDiagnosticEventListener != null ? iCarDiagnosticEventListener.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerOrUpdateDiagnosticListener(i, i2, iCarDiagnosticEventListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public CarDiagnosticEvent getLatestLiveFrame() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLatestLiveFrame();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CarDiagnosticEvent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public long[] getFreezeFrameTimestamps() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFreezeFrameTimestamps();
                    }
                    obtain2.readException();
                    return obtain2.createLongArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public CarDiagnosticEvent getFreezeFrame(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFreezeFrame(j);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CarDiagnosticEvent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean clearFreezeFrames(long[] jArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLongArray(jArr);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearFreezeFrames(jArr);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public void unregisterDiagnosticListener(int i, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iCarDiagnosticEventListener != null ? iCarDiagnosticEventListener.asBinder() : null);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterDiagnosticListener(i, iCarDiagnosticEventListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isLiveFrameSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLiveFrameSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isFreezeFrameNotificationSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isFreezeFrameNotificationSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isGetFreezeFrameSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isGetFreezeFrameSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isClearFreezeFramesSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isClearFreezeFramesSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isSelectiveClearFreezeFramesSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSelectiveClearFreezeFramesSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarDiagnostic iCarDiagnostic) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarDiagnostic == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarDiagnostic;
            return true;
        }

        public static ICarDiagnostic getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
