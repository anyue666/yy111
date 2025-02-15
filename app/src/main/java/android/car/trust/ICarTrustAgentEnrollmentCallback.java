package android.car.trust;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarTrustAgentEnrollmentCallback extends IInterface {

    public static class Default implements ICarTrustAgentEnrollmentCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
        public void onAuthStringAvailable(BluetoothDevice bluetoothDevice, String str) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
        public void onEnrollmentHandshakeFailure(BluetoothDevice bluetoothDevice, int i) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
        public void onEscrowTokenActiveStateChanged(long j, boolean z) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
        public void onEscrowTokenAdded(long j) throws RemoteException {
        }

        @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
        public void onEscrowTokenRemoved(long j) throws RemoteException {
        }
    }

    void onAuthStringAvailable(BluetoothDevice bluetoothDevice, String str) throws RemoteException;

    void onEnrollmentHandshakeFailure(BluetoothDevice bluetoothDevice, int i) throws RemoteException;

    void onEscrowTokenActiveStateChanged(long j, boolean z) throws RemoteException;

    void onEscrowTokenAdded(long j) throws RemoteException;

    void onEscrowTokenRemoved(long j) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarTrustAgentEnrollmentCallback {
        private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentEnrollmentCallback";
        static final int TRANSACTION_onAuthStringAvailable = 2;
        static final int TRANSACTION_onEnrollmentHandshakeFailure = 1;
        static final int TRANSACTION_onEscrowTokenActiveStateChanged = 5;
        static final int TRANSACTION_onEscrowTokenAdded = 3;
        static final int TRANSACTION_onEscrowTokenRemoved = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarTrustAgentEnrollmentCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarTrustAgentEnrollmentCallback)) {
                return (ICarTrustAgentEnrollmentCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onEnrollmentHandshakeFailure(parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAuthStringAvailable(parcel.readInt() != 0 ? (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onEscrowTokenAdded(parcel.readLong());
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onEscrowTokenRemoved(parcel.readLong());
                return true;
            }
            if (i == 5) {
                parcel.enforceInterface(DESCRIPTOR);
                onEscrowTokenActiveStateChanged(parcel.readLong(), parcel.readInt() != 0);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarTrustAgentEnrollmentCallback {
            public static ICarTrustAgentEnrollmentCallback sDefaultImpl;
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

            @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
            public void onEnrollmentHandshakeFailure(BluetoothDevice bluetoothDevice, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onEnrollmentHandshakeFailure(bluetoothDevice, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
            public void onAuthStringAvailable(BluetoothDevice bluetoothDevice, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothDevice != null) {
                        obtain.writeInt(1);
                        bluetoothDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAuthStringAvailable(bluetoothDevice, str);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
            public void onEscrowTokenAdded(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onEscrowTokenAdded(j);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
            public void onEscrowTokenRemoved(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onEscrowTokenRemoved(j);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.trust.ICarTrustAgentEnrollmentCallback
            public void onEscrowTokenActiveStateChanged(long j, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(5, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onEscrowTokenActiveStateChanged(j, z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarTrustAgentEnrollmentCallback iCarTrustAgentEnrollmentCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarTrustAgentEnrollmentCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarTrustAgentEnrollmentCallback;
            return true;
        }

        public static ICarTrustAgentEnrollmentCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
