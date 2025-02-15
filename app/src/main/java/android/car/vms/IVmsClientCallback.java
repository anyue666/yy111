package android.car.vms;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SharedMemory;

/* loaded from: classes.dex */
public interface IVmsClientCallback extends IInterface {

    public static class Default implements IVmsClientCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onLargePacketReceived(int i, VmsLayer vmsLayer, SharedMemory sharedMemory) throws RemoteException {
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onLayerAvailabilityChanged(VmsAvailableLayers vmsAvailableLayers) throws RemoteException {
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onPacketReceived(int i, VmsLayer vmsLayer, byte[] bArr) throws RemoteException {
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onSubscriptionStateChanged(VmsSubscriptionState vmsSubscriptionState) throws RemoteException {
        }
    }

    void onLargePacketReceived(int i, VmsLayer vmsLayer, SharedMemory sharedMemory) throws RemoteException;

    void onLayerAvailabilityChanged(VmsAvailableLayers vmsAvailableLayers) throws RemoteException;

    void onPacketReceived(int i, VmsLayer vmsLayer, byte[] bArr) throws RemoteException;

    void onSubscriptionStateChanged(VmsSubscriptionState vmsSubscriptionState) throws RemoteException;

    public static abstract class Stub extends Binder implements IVmsClientCallback {
        private static final String DESCRIPTOR = "android.car.vms.IVmsClientCallback";
        static final int TRANSACTION_onLargePacketReceived = 4;
        static final int TRANSACTION_onLayerAvailabilityChanged = 1;
        static final int TRANSACTION_onPacketReceived = 3;
        static final int TRANSACTION_onSubscriptionStateChanged = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVmsClientCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IVmsClientCallback)) {
                return (IVmsClientCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onLayerAvailabilityChanged(parcel.readInt() != 0 ? VmsAvailableLayers.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onSubscriptionStateChanged(parcel.readInt() != 0 ? VmsSubscriptionState.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                onPacketReceived(parcel.readInt(), parcel.readInt() != 0 ? VmsLayer.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                onLargePacketReceived(parcel.readInt(), parcel.readInt() != 0 ? VmsLayer.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (SharedMemory) SharedMemory.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IVmsClientCallback {
            public static IVmsClientCallback sDefaultImpl;
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

            @Override // android.car.vms.IVmsClientCallback
            public void onLayerAvailabilityChanged(VmsAvailableLayers vmsAvailableLayers) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vmsAvailableLayers != null) {
                        obtain.writeInt(1);
                        vmsAvailableLayers.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onLayerAvailabilityChanged(vmsAvailableLayers);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsClientCallback
            public void onSubscriptionStateChanged(VmsSubscriptionState vmsSubscriptionState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vmsSubscriptionState != null) {
                        obtain.writeInt(1);
                        vmsSubscriptionState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSubscriptionStateChanged(vmsSubscriptionState);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsClientCallback
            public void onPacketReceived(int i, VmsLayer vmsLayer, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (vmsLayer != null) {
                        obtain.writeInt(1);
                        vmsLayer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPacketReceived(i, vmsLayer, bArr);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsClientCallback
            public void onLargePacketReceived(int i, VmsLayer vmsLayer, SharedMemory sharedMemory) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (vmsLayer != null) {
                        obtain.writeInt(1);
                        vmsLayer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (sharedMemory != null) {
                        obtain.writeInt(1);
                        sharedMemory.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onLargePacketReceived(i, vmsLayer, sharedMemory);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IVmsClientCallback iVmsClientCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iVmsClientCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iVmsClientCallback;
            return true;
        }

        public static IVmsClientCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
