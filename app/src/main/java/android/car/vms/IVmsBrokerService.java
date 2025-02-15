package android.car.vms;

import android.car.vms.IVmsClientCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SharedMemory;
import java.util.List;

/* loaded from: classes.dex */
public interface IVmsBrokerService extends IInterface {

    public static class Default implements IVmsBrokerService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.vms.IVmsBrokerService
        public VmsProviderInfo getProviderInfo(IBinder iBinder, int i) throws RemoteException {
            return null;
        }

        @Override // android.car.vms.IVmsBrokerService
        public void publishLargePacket(IBinder iBinder, int i, VmsLayer vmsLayer, SharedMemory sharedMemory) throws RemoteException {
        }

        @Override // android.car.vms.IVmsBrokerService
        public void publishPacket(IBinder iBinder, int i, VmsLayer vmsLayer, byte[] bArr) throws RemoteException {
        }

        @Override // android.car.vms.IVmsBrokerService
        public VmsRegistrationInfo registerClient(IBinder iBinder, IVmsClientCallback iVmsClientCallback, boolean z) throws RemoteException {
            return null;
        }

        @Override // android.car.vms.IVmsBrokerService
        public int registerProvider(IBinder iBinder, VmsProviderInfo vmsProviderInfo) throws RemoteException {
            return 0;
        }

        @Override // android.car.vms.IVmsBrokerService
        public void setMonitoringEnabled(IBinder iBinder, boolean z) throws RemoteException {
        }

        @Override // android.car.vms.IVmsBrokerService
        public void setProviderOfferings(IBinder iBinder, int i, List<VmsLayerDependency> list) throws RemoteException {
        }

        @Override // android.car.vms.IVmsBrokerService
        public void setSubscriptions(IBinder iBinder, List<VmsAssociatedLayer> list) throws RemoteException {
        }

        @Override // android.car.vms.IVmsBrokerService
        public void unregisterClient(IBinder iBinder) throws RemoteException {
        }
    }

    VmsProviderInfo getProviderInfo(IBinder iBinder, int i) throws RemoteException;

    void publishLargePacket(IBinder iBinder, int i, VmsLayer vmsLayer, SharedMemory sharedMemory) throws RemoteException;

    void publishPacket(IBinder iBinder, int i, VmsLayer vmsLayer, byte[] bArr) throws RemoteException;

    VmsRegistrationInfo registerClient(IBinder iBinder, IVmsClientCallback iVmsClientCallback, boolean z) throws RemoteException;

    int registerProvider(IBinder iBinder, VmsProviderInfo vmsProviderInfo) throws RemoteException;

    void setMonitoringEnabled(IBinder iBinder, boolean z) throws RemoteException;

    void setProviderOfferings(IBinder iBinder, int i, List<VmsLayerDependency> list) throws RemoteException;

    void setSubscriptions(IBinder iBinder, List<VmsAssociatedLayer> list) throws RemoteException;

    void unregisterClient(IBinder iBinder) throws RemoteException;

    public static abstract class Stub extends Binder implements IVmsBrokerService {
        private static final String DESCRIPTOR = "android.car.vms.IVmsBrokerService";
        static final int TRANSACTION_getProviderInfo = 3;
        static final int TRANSACTION_publishLargePacket = 9;
        static final int TRANSACTION_publishPacket = 8;
        static final int TRANSACTION_registerClient = 1;
        static final int TRANSACTION_registerProvider = 6;
        static final int TRANSACTION_setMonitoringEnabled = 5;
        static final int TRANSACTION_setProviderOfferings = 7;
        static final int TRANSACTION_setSubscriptions = 4;
        static final int TRANSACTION_unregisterClient = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVmsBrokerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IVmsBrokerService)) {
                return (IVmsBrokerService) queryLocalInterface;
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
                    VmsRegistrationInfo registerClient = registerClient(parcel.readStrongBinder(), IVmsClientCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (registerClient != null) {
                        parcel2.writeInt(1);
                        registerClient.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterClient(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    VmsProviderInfo providerInfo = getProviderInfo(parcel.readStrongBinder(), parcel.readInt());
                    parcel2.writeNoException();
                    if (providerInfo != null) {
                        parcel2.writeInt(1);
                        providerInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSubscriptions(parcel.readStrongBinder(), parcel.createTypedArrayList(VmsAssociatedLayer.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMonitoringEnabled(parcel.readStrongBinder(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int registerProvider = registerProvider(parcel.readStrongBinder(), parcel.readInt() != 0 ? VmsProviderInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(registerProvider);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setProviderOfferings(parcel.readStrongBinder(), parcel.readInt(), parcel.createTypedArrayList(VmsLayerDependency.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    publishPacket(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt() != 0 ? VmsLayer.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    publishLargePacket(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt() != 0 ? VmsLayer.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (SharedMemory) SharedMemory.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IVmsBrokerService {
            public static IVmsBrokerService sDefaultImpl;
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

            @Override // android.car.vms.IVmsBrokerService
            public VmsRegistrationInfo registerClient(IBinder iBinder, IVmsClientCallback iVmsClientCallback, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeStrongBinder(iVmsClientCallback != null ? iVmsClientCallback.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerClient(iBinder, iVmsClientCallback, z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? VmsRegistrationInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public void unregisterClient(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterClient(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public VmsProviderInfo getProviderInfo(IBinder iBinder, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProviderInfo(iBinder, i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? VmsProviderInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public void setSubscriptions(IBinder iBinder, List<VmsAssociatedLayer> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeTypedList(list);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSubscriptions(iBinder, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public void setMonitoringEnabled(IBinder iBinder, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMonitoringEnabled(iBinder, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public int registerProvider(IBinder iBinder, VmsProviderInfo vmsProviderInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (vmsProviderInfo != null) {
                        obtain.writeInt(1);
                        vmsProviderInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerProvider(iBinder, vmsProviderInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public void setProviderOfferings(IBinder iBinder, int i, List<VmsLayerDependency> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setProviderOfferings(iBinder, i, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public void publishPacket(IBinder iBinder, int i, VmsLayer vmsLayer, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    if (vmsLayer != null) {
                        obtain.writeInt(1);
                        vmsLayer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().publishPacket(iBinder, i, vmsLayer, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.vms.IVmsBrokerService
            public void publishLargePacket(IBinder iBinder, int i, VmsLayer vmsLayer, SharedMemory sharedMemory) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
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
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().publishLargePacket(iBinder, i, vmsLayer, sharedMemory);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IVmsBrokerService iVmsBrokerService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iVmsBrokerService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iVmsBrokerService;
            return true;
        }

        public static IVmsBrokerService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
