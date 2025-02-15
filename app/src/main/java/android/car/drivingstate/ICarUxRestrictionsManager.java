package android.car.drivingstate;

import android.car.drivingstate.ICarUxRestrictionsChangeListener;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.IRemoteCallback;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarUxRestrictionsManager extends IInterface {

    public static class Default implements ICarUxRestrictionsManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public List<CarUxRestrictionsConfiguration> getConfigs() throws RemoteException {
            return null;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public CarUxRestrictions getCurrentUxRestrictions(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public int getMappedPhysicalDisplayOfVirtualDisplay(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public String getRestrictionMode() throws RemoteException {
            return null;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public List<CarUxRestrictionsConfiguration> getStagedConfigs() throws RemoteException {
            return null;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener, int i) throws RemoteException {
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public void reportVirtualDisplayToPhysicalDisplay(IRemoteCallback iRemoteCallback, int i, int i2) throws RemoteException {
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public boolean saveUxRestrictionsConfigurationForNextBoot(List<CarUxRestrictionsConfiguration> list) throws RemoteException {
            return false;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public boolean setRestrictionMode(String str) throws RemoteException {
            return false;
        }

        @Override // android.car.drivingstate.ICarUxRestrictionsManager
        public void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener) throws RemoteException {
        }
    }

    List<CarUxRestrictionsConfiguration> getConfigs() throws RemoteException;

    CarUxRestrictions getCurrentUxRestrictions(int i) throws RemoteException;

    int getMappedPhysicalDisplayOfVirtualDisplay(int i) throws RemoteException;

    String getRestrictionMode() throws RemoteException;

    List<CarUxRestrictionsConfiguration> getStagedConfigs() throws RemoteException;

    void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener, int i) throws RemoteException;

    void reportVirtualDisplayToPhysicalDisplay(IRemoteCallback iRemoteCallback, int i, int i2) throws RemoteException;

    boolean saveUxRestrictionsConfigurationForNextBoot(List<CarUxRestrictionsConfiguration> list) throws RemoteException;

    boolean setRestrictionMode(String str) throws RemoteException;

    void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarUxRestrictionsManager {
        private static final String DESCRIPTOR = "android.car.drivingstate.ICarUxRestrictionsManager";
        static final int TRANSACTION_getConfigs = 6;
        static final int TRANSACTION_getCurrentUxRestrictions = 3;
        static final int TRANSACTION_getMappedPhysicalDisplayOfVirtualDisplay = 10;
        static final int TRANSACTION_getRestrictionMode = 12;
        static final int TRANSACTION_getStagedConfigs = 5;
        static final int TRANSACTION_registerUxRestrictionsChangeListener = 1;
        static final int TRANSACTION_reportVirtualDisplayToPhysicalDisplay = 9;
        static final int TRANSACTION_saveUxRestrictionsConfigurationForNextBoot = 4;
        static final int TRANSACTION_setRestrictionMode = 11;
        static final int TRANSACTION_unregisterUxRestrictionsChangeListener = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarUxRestrictionsManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarUxRestrictionsManager)) {
                return (ICarUxRestrictionsManager) queryLocalInterface;
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
                    registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    CarUxRestrictions currentUxRestrictions = getCurrentUxRestrictions(parcel.readInt());
                    parcel2.writeNoException();
                    if (currentUxRestrictions != null) {
                        parcel2.writeInt(1);
                        currentUxRestrictions.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean saveUxRestrictionsConfigurationForNextBoot = saveUxRestrictionsConfigurationForNextBoot(parcel.createTypedArrayList(CarUxRestrictionsConfiguration.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(saveUxRestrictionsConfigurationForNextBoot ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<CarUxRestrictionsConfiguration> stagedConfigs = getStagedConfigs();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(stagedConfigs);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<CarUxRestrictionsConfiguration> configs = getConfigs();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(configs);
                    return true;
                default:
                    switch (i) {
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            reportVirtualDisplayToPhysicalDisplay(IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            int mappedPhysicalDisplayOfVirtualDisplay = getMappedPhysicalDisplayOfVirtualDisplay(parcel.readInt());
                            parcel2.writeNoException();
                            parcel2.writeInt(mappedPhysicalDisplayOfVirtualDisplay);
                            return true;
                        case 11:
                            parcel.enforceInterface(DESCRIPTOR);
                            boolean restrictionMode = setRestrictionMode(parcel.readString());
                            parcel2.writeNoException();
                            parcel2.writeInt(restrictionMode ? 1 : 0);
                            return true;
                        case 12:
                            parcel.enforceInterface(DESCRIPTOR);
                            String restrictionMode2 = getRestrictionMode();
                            parcel2.writeNoException();
                            parcel2.writeString(restrictionMode2);
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
            }
        }

        private static class Proxy implements ICarUxRestrictionsManager {
            public static ICarUxRestrictionsManager sDefaultImpl;
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

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarUxRestrictionsChangeListener != null ? iCarUxRestrictionsChangeListener.asBinder() : null);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerUxRestrictionsChangeListener(iCarUxRestrictionsChangeListener, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarUxRestrictionsChangeListener != null ? iCarUxRestrictionsChangeListener.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterUxRestrictionsChangeListener(iCarUxRestrictionsChangeListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public CarUxRestrictions getCurrentUxRestrictions(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentUxRestrictions(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CarUxRestrictions.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public boolean saveUxRestrictionsConfigurationForNextBoot(List<CarUxRestrictionsConfiguration> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().saveUxRestrictionsConfigurationForNextBoot(list);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public List<CarUxRestrictionsConfiguration> getStagedConfigs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getStagedConfigs();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(CarUxRestrictionsConfiguration.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public List<CarUxRestrictionsConfiguration> getConfigs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConfigs();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(CarUxRestrictionsConfiguration.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public void reportVirtualDisplayToPhysicalDisplay(IRemoteCallback iRemoteCallback, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteCallback != null ? iRemoteCallback.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().reportVirtualDisplayToPhysicalDisplay(iRemoteCallback, i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public int getMappedPhysicalDisplayOfVirtualDisplay(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMappedPhysicalDisplayOfVirtualDisplay(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public boolean setRestrictionMode(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setRestrictionMode(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.drivingstate.ICarUxRestrictionsManager
            public String getRestrictionMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRestrictionMode();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarUxRestrictionsManager iCarUxRestrictionsManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarUxRestrictionsManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarUxRestrictionsManager;
            return true;
        }

        public static ICarUxRestrictionsManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
