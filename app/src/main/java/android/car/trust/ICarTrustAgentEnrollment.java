package android.car.trust;

import android.bluetooth.BluetoothDevice;
import android.car.trust.ICarTrustAgentBleCallback;
import android.car.trust.ICarTrustAgentEnrollmentCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarTrustAgentEnrollment extends IInterface {

    public static class Default implements ICarTrustAgentEnrollment {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void enrollmentHandshakeAccepted(BluetoothDevice bluetoothDevice) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public List<TrustedDeviceInfo> getEnrolledDeviceInfosForUser(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public boolean isEscrowTokenActive(long j, int i) throws RemoteException {
            return false;
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void registerBleCallback(ICarTrustAgentBleCallback iCarTrustAgentBleCallback) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void registerEnrollmentCallback(ICarTrustAgentEnrollmentCallback iCarTrustAgentEnrollmentCallback) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void removeAllTrustedDevices(int i) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void removeEscrowToken(long j, int i) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void setTrustedDeviceEnrollmentEnabled(boolean z) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void setTrustedDeviceUnlockEnabled(boolean z) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void startEnrollmentAdvertising() throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void stopEnrollmentAdvertising() throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void terminateEnrollmentHandshake() throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void unregisterBleCallback(ICarTrustAgentBleCallback iCarTrustAgentBleCallback) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollment
        public void unregisterEnrollmentCallback(ICarTrustAgentEnrollmentCallback iCarTrustAgentEnrollmentCallback) throws RemoteException {
        }
    }

    void enrollmentHandshakeAccepted(BluetoothDevice bluetoothDevice) throws RemoteException;

    List<TrustedDeviceInfo> getEnrolledDeviceInfosForUser(int i) throws RemoteException;

    boolean isEscrowTokenActive(long j, int i) throws RemoteException;

    void registerBleCallback(ICarTrustAgentBleCallback iCarTrustAgentBleCallback) throws RemoteException;

    void registerEnrollmentCallback(ICarTrustAgentEnrollmentCallback iCarTrustAgentEnrollmentCallback) throws RemoteException;

    void removeAllTrustedDevices(int i) throws RemoteException;

    void removeEscrowToken(long j, int i) throws RemoteException;

    void setTrustedDeviceEnrollmentEnabled(boolean z) throws RemoteException;

    void setTrustedDeviceUnlockEnabled(boolean z) throws RemoteException;

    void startEnrollmentAdvertising() throws RemoteException;

    void stopEnrollmentAdvertising() throws RemoteException;

    void terminateEnrollmentHandshake() throws RemoteException;

    void unregisterBleCallback(ICarTrustAgentBleCallback iCarTrustAgentBleCallback) throws RemoteException;

    void unregisterEnrollmentCallback(ICarTrustAgentEnrollmentCallback iCarTrustAgentEnrollmentCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarTrustAgentEnrollment {
        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentEnrollment";
        static final int TRANSACTION_enrollmentHandshakeAccepted = 3;
        static final int TRANSACTION_getEnrolledDeviceInfosForUser = 10;
        static final int TRANSACTION_isEscrowTokenActive = 5;
        static final int TRANSACTION_registerBleCallback = 13;
        static final int TRANSACTION_registerEnrollmentCallback = 11;
        static final int TRANSACTION_removeAllTrustedDevices = 7;
        static final int TRANSACTION_removeEscrowToken = 6;
        static final int TRANSACTION_setTrustedDeviceEnrollmentEnabled = 8;
        static final int TRANSACTION_setTrustedDeviceUnlockEnabled = 9;
        static final int TRANSACTION_startEnrollmentAdvertising = 1;
        static final int TRANSACTION_stopEnrollmentAdvertising = 2;
        static final int TRANSACTION_terminateEnrollmentHandshake = 4;
        static final int TRANSACTION_unregisterBleCallback = 14;
        static final int TRANSACTION_unregisterEnrollmentCallback = 12;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarTrustAgentEnrollment asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarTrustAgentEnrollment)) {
                return (ICarTrustAgentEnrollment) queryLocalInterface;
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
                    startEnrollmentAdvertising();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopEnrollmentAdvertising();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    enrollmentHandshakeAccepted(parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    terminateEnrollmentHandshake();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isEscrowTokenActive = isEscrowTokenActive(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isEscrowTokenActive ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeEscrowToken(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeAllTrustedDevices(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    setTrustedDeviceEnrollmentEnabled(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    setTrustedDeviceUnlockEnabled(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<TrustedDeviceInfo> enrolledDeviceInfosForUser = getEnrolledDeviceInfosForUser(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(enrolledDeviceInfosForUser);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerEnrollmentCallback(ICarTrustAgentEnrollmentCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterEnrollmentCallback(ICarTrustAgentEnrollmentCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerBleCallback(ICarTrustAgentBleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterBleCallback(ICarTrustAgentBleCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarTrustAgentEnrollment {
            public static ICarTrustAgentEnrollment sDefaultImpl;
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

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void startEnrollmentAdvertising() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().startEnrollmentAdvertising();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void stopEnrollmentAdvertising() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stopEnrollmentAdvertising();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void enrollmentHandshakeAccepted(BluetoothDevice bluetoothDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().enrollmentHandshakeAccepted(bluetoothDevice);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void terminateEnrollmentHandshake() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().terminateEnrollmentHandshake();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public boolean isEscrowTokenActive(long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isEscrowTokenActive(j, i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void removeEscrowToken(long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeEscrowToken(j, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void removeAllTrustedDevices(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeAllTrustedDevices(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void setTrustedDeviceEnrollmentEnabled(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setTrustedDeviceEnrollmentEnabled(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void setTrustedDeviceUnlockEnabled(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setTrustedDeviceUnlockEnabled(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public List<TrustedDeviceInfo> getEnrolledDeviceInfosForUser(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEnrolledDeviceInfosForUser(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(TrustedDeviceInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void registerEnrollmentCallback(ICarTrustAgentEnrollmentCallback iCarTrustAgentEnrollmentCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarTrustAgentEnrollmentCallback != null ? iCarTrustAgentEnrollmentCallback.asBinder() : null);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerEnrollmentCallback(iCarTrustAgentEnrollmentCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void unregisterEnrollmentCallback(ICarTrustAgentEnrollmentCallback iCarTrustAgentEnrollmentCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarTrustAgentEnrollmentCallback != null ? iCarTrustAgentEnrollmentCallback.asBinder() : null);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterEnrollmentCallback(iCarTrustAgentEnrollmentCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void registerBleCallback(ICarTrustAgentBleCallback iCarTrustAgentBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarTrustAgentBleCallback != null ? iCarTrustAgentBleCallback.asBinder() : null);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerBleCallback(iCarTrustAgentBleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollment
            public void unregisterBleCallback(ICarTrustAgentBleCallback iCarTrustAgentBleCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarTrustAgentBleCallback != null ? iCarTrustAgentBleCallback.asBinder() : null);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterBleCallback(iCarTrustAgentBleCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarTrustAgentEnrollment iCarTrustAgentEnrollment) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarTrustAgentEnrollment == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarTrustAgentEnrollment;
            return true;
        }

        public static ICarTrustAgentEnrollment getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
