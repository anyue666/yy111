package android.car.content.pm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarPackageManager extends IInterface {

    public static class Default implements ICarPackageManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.content.pm.ICarPackageManager
        public boolean isActivityBackedBySafeActivity(ComponentName componentName) throws RemoteException {
            return false;
        }

        @Override // android.car.content.pm.ICarPackageManager
        public boolean isActivityDistractionOptimized(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // android.car.content.pm.ICarPackageManager
        public boolean isPendingIntentDistractionOptimized(PendingIntent pendingIntent) throws RemoteException {
            return false;
        }

        @Override // android.car.content.pm.ICarPackageManager
        public boolean isServiceDistractionOptimized(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // android.car.content.pm.ICarPackageManager
        public void restartTask(int i) throws RemoteException {
        }

        @Override // android.car.content.pm.ICarPackageManager
        public void setAppBlockingPolicy(String str, CarAppBlockingPolicy carAppBlockingPolicy, int i) throws RemoteException {
        }

        @Override // android.car.content.pm.ICarPackageManager
        public void setEnableActivityBlocking(boolean z) throws RemoteException {
        }
    }

    boolean isActivityBackedBySafeActivity(ComponentName componentName) throws RemoteException;

    boolean isActivityDistractionOptimized(String str, String str2) throws RemoteException;

    boolean isPendingIntentDistractionOptimized(PendingIntent pendingIntent) throws RemoteException;

    boolean isServiceDistractionOptimized(String str, String str2) throws RemoteException;

    void restartTask(int i) throws RemoteException;

    void setAppBlockingPolicy(String str, CarAppBlockingPolicy carAppBlockingPolicy, int i) throws RemoteException;

    void setEnableActivityBlocking(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarPackageManager {
        private static final String DESCRIPTOR = "android.car.content.pm.ICarPackageManager";
        static final int TRANSACTION_isActivityBackedBySafeActivity = 4;
        static final int TRANSACTION_isActivityDistractionOptimized = 2;
        static final int TRANSACTION_isPendingIntentDistractionOptimized = 7;
        static final int TRANSACTION_isServiceDistractionOptimized = 3;
        static final int TRANSACTION_restartTask = 6;
        static final int TRANSACTION_setAppBlockingPolicy = 1;
        static final int TRANSACTION_setEnableActivityBlocking = 5;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarPackageManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarPackageManager)) {
                return (ICarPackageManager) queryLocalInterface;
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
                    setAppBlockingPolicy(parcel.readString(), parcel.readInt() != 0 ? CarAppBlockingPolicy.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isActivityDistractionOptimized = isActivityDistractionOptimized(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(isActivityDistractionOptimized ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isServiceDistractionOptimized = isServiceDistractionOptimized(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(isServiceDistractionOptimized ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isActivityBackedBySafeActivity = isActivityBackedBySafeActivity(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(isActivityBackedBySafeActivity ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    setEnableActivityBlocking(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    restartTask(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isPendingIntentDistractionOptimized = isPendingIntentDistractionOptimized(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(isPendingIntentDistractionOptimized ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarPackageManager {
            public static ICarPackageManager sDefaultImpl;
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

            @Override // android.car.content.pm.ICarPackageManager
            public void setAppBlockingPolicy(String str, CarAppBlockingPolicy carAppBlockingPolicy, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (carAppBlockingPolicy != null) {
                        obtain.writeInt(1);
                        carAppBlockingPolicy.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setAppBlockingPolicy(str, carAppBlockingPolicy, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.content.pm.ICarPackageManager
            public boolean isActivityDistractionOptimized(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isActivityDistractionOptimized(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.content.pm.ICarPackageManager
            public boolean isServiceDistractionOptimized(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isServiceDistractionOptimized(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.content.pm.ICarPackageManager
            public boolean isActivityBackedBySafeActivity(ComponentName componentName) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isActivityBackedBySafeActivity(componentName);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.content.pm.ICarPackageManager
            public void setEnableActivityBlocking(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setEnableActivityBlocking(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.content.pm.ICarPackageManager
            public void restartTask(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().restartTask(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.content.pm.ICarPackageManager
            public boolean isPendingIntentDistractionOptimized(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isPendingIntentDistractionOptimized(pendingIntent);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarPackageManager iCarPackageManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarPackageManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarPackageManager;
            return true;
        }

        public static ICarPackageManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
