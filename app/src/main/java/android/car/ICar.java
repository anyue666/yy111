package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICar extends IInterface {

    public static class Default implements ICar {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICar
        public int disableFeature(String str) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICar
        public int enableFeature(String str) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICar
        public List<String> getAllEnabledFeatures() throws RemoteException {
            return null;
        }

        @Override // android.car.ICar
        public List<String> getAllPendingDisabledFeatures() throws RemoteException {
            return null;
        }

        @Override // android.car.ICar
        public List<String> getAllPendingEnabledFeatures() throws RemoteException {
            return null;
        }

        @Override // android.car.ICar
        public int getCarConnectionType() throws RemoteException {
            return 0;
        }

        @Override // android.car.ICar
        public String getCarManagerClassForFeature(String str) throws RemoteException {
            return null;
        }

        @Override // android.car.ICar
        public IBinder getCarService(String str) throws RemoteException {
            return null;
        }

        @Override // android.car.ICar
        public void getInitialUserInfo(int i, int i2, IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.ICar
        public boolean isFeatureEnabled(String str) throws RemoteException {
            return false;
        }

        @Override // android.car.ICar
        public void onFirstUserUnlocked(int i, long j, long j2, int i2) throws RemoteException {
        }

        @Override // android.car.ICar
        public void onUserLifecycleEvent(int i, long j, int i2, int i3) throws RemoteException {
        }

        @Override // android.car.ICar
        public void setCarServiceHelper(IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.ICar
        public void setInitialUser(int i) throws RemoteException {
        }
    }

    int disableFeature(String str) throws RemoteException;

    int enableFeature(String str) throws RemoteException;

    List<String> getAllEnabledFeatures() throws RemoteException;

    List<String> getAllPendingDisabledFeatures() throws RemoteException;

    List<String> getAllPendingEnabledFeatures() throws RemoteException;

    int getCarConnectionType() throws RemoteException;

    String getCarManagerClassForFeature(String str) throws RemoteException;

    IBinder getCarService(String str) throws RemoteException;

    void getInitialUserInfo(int i, int i2, IBinder iBinder) throws RemoteException;

    boolean isFeatureEnabled(String str) throws RemoteException;

    void onFirstUserUnlocked(int i, long j, long j2, int i2) throws RemoteException;

    void onUserLifecycleEvent(int i, long j, int i2, int i3) throws RemoteException;

    void setCarServiceHelper(IBinder iBinder) throws RemoteException;

    void setInitialUser(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ICar {
        private static final String DESCRIPTOR = "android.car.ICar";
        static final int TRANSACTION_disableFeature = 16;
        static final int TRANSACTION_enableFeature = 15;
        static final int TRANSACTION_getAllEnabledFeatures = 17;
        static final int TRANSACTION_getAllPendingDisabledFeatures = 18;
        static final int TRANSACTION_getAllPendingEnabledFeatures = 19;
        static final int TRANSACTION_getCarConnectionType = 13;
        static final int TRANSACTION_getCarManagerClassForFeature = 20;
        static final int TRANSACTION_getCarService = 12;
        static final int TRANSACTION_getInitialUserInfo = 4;
        static final int TRANSACTION_isFeatureEnabled = 14;
        static final int TRANSACTION_onFirstUserUnlocked = 3;
        static final int TRANSACTION_onUserLifecycleEvent = 2;
        static final int TRANSACTION_setCarServiceHelper = 1;
        static final int TRANSACTION_setInitialUser = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "android.car.ICar");
        }

        public static ICar asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.car.ICar");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICar)) {
                return (ICar) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.car.ICar");
                setCarServiceHelper(parcel.readStrongBinder());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("android.car.ICar");
                onUserLifecycleEvent(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("android.car.ICar");
                onFirstUserUnlocked(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt());
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("android.car.ICar");
                getInitialUserInfo(parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                return true;
            }
            if (i == 5) {
                parcel.enforceInterface("android.car.ICar");
                setInitialUser(parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString("android.car.ICar");
                return true;
            }
            switch (i) {
                case 12:
                    parcel.enforceInterface("android.car.ICar");
                    IBinder carService = getCarService(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(carService);
                    return true;
                case 13:
                    parcel.enforceInterface("android.car.ICar");
                    int carConnectionType = getCarConnectionType();
                    parcel2.writeNoException();
                    parcel2.writeInt(carConnectionType);
                    return true;
                case 14:
                    parcel.enforceInterface("android.car.ICar");
                    boolean isFeatureEnabled = isFeatureEnabled(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(isFeatureEnabled ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("android.car.ICar");
                    int enableFeature = enableFeature(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(enableFeature);
                    return true;
                case 16:
                    parcel.enforceInterface("android.car.ICar");
                    int disableFeature = disableFeature(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(disableFeature);
                    return true;
                case 17:
                    parcel.enforceInterface("android.car.ICar");
                    List<String> allEnabledFeatures = getAllEnabledFeatures();
                    parcel2.writeNoException();
                    parcel2.writeStringList(allEnabledFeatures);
                    return true;
                case 18:
                    parcel.enforceInterface("android.car.ICar");
                    List<String> allPendingDisabledFeatures = getAllPendingDisabledFeatures();
                    parcel2.writeNoException();
                    parcel2.writeStringList(allPendingDisabledFeatures);
                    return true;
                case 19:
                    parcel.enforceInterface("android.car.ICar");
                    List<String> allPendingEnabledFeatures = getAllPendingEnabledFeatures();
                    parcel2.writeNoException();
                    parcel2.writeStringList(allPendingEnabledFeatures);
                    return true;
                case 20:
                    parcel.enforceInterface("android.car.ICar");
                    String carManagerClassForFeature = getCarManagerClassForFeature(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(carManagerClassForFeature);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICar {
            public static ICar sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "android.car.ICar";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.car.ICar
            public void setCarServiceHelper(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setCarServiceHelper(iBinder);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public void onUserLifecycleEvent(int i, long j, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onUserLifecycleEvent(i, j, i2, i3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public void onFirstUserUnlocked(int i, long j, long j2, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onFirstUserUnlocked(i, j, j2, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public void getInitialUserInfo(int i, int i2, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iBinder);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getInitialUserInfo(i, i2, iBinder);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public void setInitialUser(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeInt(i);
                    if (this.mRemote.transact(5, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setInitialUser(i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public IBinder getCarService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCarService(str);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public int getCarConnectionType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCarConnectionType();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public boolean isFeatureEnabled(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isFeatureEnabled(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public int enableFeature(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().enableFeature(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public int disableFeature(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().disableFeature(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public List<String> getAllEnabledFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllEnabledFeatures();
                    }
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public List<String> getAllPendingDisabledFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllPendingDisabledFeatures();
                    }
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public List<String> getAllPendingEnabledFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllPendingEnabledFeatures();
                    }
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICar
            public String getCarManagerClassForFeature(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.car.ICar");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCarManagerClassForFeature(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICar iCar) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCar == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCar;
            return true;
        }

        public static ICar getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
