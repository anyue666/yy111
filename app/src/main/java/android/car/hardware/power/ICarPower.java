package android.car.hardware.power;

import android.car.hardware.power.ICarPowerStateListener;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarPower extends IInterface {

    public static class Default implements ICarPower {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.hardware.power.ICarPower
        public void finished(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
        }

        @Override // android.car.hardware.power.ICarPower
        public int getPowerState() throws RemoteException {
            return 0;
        }

        @Override // android.car.hardware.power.ICarPower
        public void registerListener(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
        }

        @Override // android.car.hardware.power.ICarPower
        public void registerListenerWithCompletion(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
        }

        @Override // android.car.hardware.power.ICarPower
        public void requestShutdownOnNextSuspend() throws RemoteException {
        }

        @Override // android.car.hardware.power.ICarPower
        public void scheduleNextWakeupTime(int i) throws RemoteException {
        }

        @Override // android.car.hardware.power.ICarPower
        public void unregisterListener(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
        }
    }

    void finished(ICarPowerStateListener iCarPowerStateListener) throws RemoteException;

    int getPowerState() throws RemoteException;

    void registerListener(ICarPowerStateListener iCarPowerStateListener) throws RemoteException;

    void registerListenerWithCompletion(ICarPowerStateListener iCarPowerStateListener) throws RemoteException;

    void requestShutdownOnNextSuspend() throws RemoteException;

    void scheduleNextWakeupTime(int i) throws RemoteException;

    void unregisterListener(ICarPowerStateListener iCarPowerStateListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarPower {
        private static final String DESCRIPTOR = "android.car.hardware.power.ICarPower";
        static final int TRANSACTION_finished = 4;
        static final int TRANSACTION_getPowerState = 7;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_registerListenerWithCompletion = 6;
        static final int TRANSACTION_requestShutdownOnNextSuspend = 3;
        static final int TRANSACTION_scheduleNextWakeupTime = 5;
        static final int TRANSACTION_unregisterListener = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarPower asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarPower)) {
                return (ICarPower) queryLocalInterface;
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
                    registerListener(ICarPowerStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterListener(ICarPowerStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestShutdownOnNextSuspend();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    finished(ICarPowerStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    scheduleNextWakeupTime(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerListenerWithCompletion(ICarPowerStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int powerState = getPowerState();
                    parcel2.writeNoException();
                    parcel2.writeInt(powerState);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarPower {
            public static ICarPower sDefaultImpl;
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

            @Override // android.car.hardware.power.ICarPower
            public void registerListener(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarPowerStateListener != null ? iCarPowerStateListener.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListener(iCarPowerStateListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.power.ICarPower
            public void unregisterListener(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarPowerStateListener != null ? iCarPowerStateListener.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterListener(iCarPowerStateListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.power.ICarPower
            public void requestShutdownOnNextSuspend() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestShutdownOnNextSuspend();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.power.ICarPower
            public void finished(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarPowerStateListener != null ? iCarPowerStateListener.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().finished(iCarPowerStateListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.power.ICarPower
            public void scheduleNextWakeupTime(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().scheduleNextWakeupTime(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.power.ICarPower
            public void registerListenerWithCompletion(ICarPowerStateListener iCarPowerStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarPowerStateListener != null ? iCarPowerStateListener.asBinder() : null);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListenerWithCompletion(iCarPowerStateListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.power.ICarPower
            public int getPowerState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPowerState();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarPower iCarPower) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarPower == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarPower;
            return true;
        }

        public static ICarPower getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
