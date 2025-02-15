package android.car;

import android.car.user.UserCreationResult;
import android.car.user.UserIdentificationAssociationResponse;
import android.car.user.UserRemovalResult;
import android.car.user.UserSwitchResult;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.os.IResultReceiver;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarUserService extends IInterface {

    public static class Default implements ICarUserService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICarUserService
        public AndroidFuture<UserCreationResult> createDriver(String str, boolean z) throws RemoteException {
            return null;
        }

        @Override // android.car.ICarUserService
        public UserInfo createPassenger(String str, int i) throws RemoteException {
            return null;
        }

        @Override // android.car.ICarUserService
        public void createUser(String str, String str2, int i, int i2, AndroidFuture<UserCreationResult> androidFuture) throws RemoteException {
        }

        @Override // android.car.ICarUserService
        public List<UserInfo> getAllDrivers() throws RemoteException {
            return null;
        }

        @Override // android.car.ICarUserService
        public void getInitialUserInfo(int i, int i2, IResultReceiver iResultReceiver) throws RemoteException {
        }

        @Override // android.car.ICarUserService
        public List<UserInfo> getPassengers(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.ICarUserService
        public UserIdentificationAssociationResponse getUserIdentificationAssociation(int[] iArr) throws RemoteException {
            return null;
        }

        @Override // android.car.ICarUserService
        public boolean isUserHalUserAssociationSupported() throws RemoteException {
            return false;
        }

        @Override // android.car.ICarUserService
        public UserRemovalResult removeUser(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.ICarUserService
        public void resetLifecycleListenerForUid() throws RemoteException {
        }

        @Override // android.car.ICarUserService
        public void setLifecycleListenerForUid(IResultReceiver iResultReceiver) throws RemoteException {
        }

        @Override // android.car.ICarUserService
        public void setUserIdentificationAssociation(int i, int[] iArr, int[] iArr2, AndroidFuture<UserIdentificationAssociationResponse> androidFuture) throws RemoteException {
        }

        @Override // android.car.ICarUserService
        public void setUserSwitchUiCallback(IResultReceiver iResultReceiver) throws RemoteException {
        }

        @Override // android.car.ICarUserService
        public boolean startPassenger(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // android.car.ICarUserService
        public boolean stopPassenger(int i) throws RemoteException {
            return false;
        }

        @Override // android.car.ICarUserService
        public void switchDriver(int i, AndroidFuture<UserSwitchResult> androidFuture) throws RemoteException {
        }

        @Override // android.car.ICarUserService
        public void switchUser(int i, int i2, AndroidFuture<UserSwitchResult> androidFuture) throws RemoteException {
        }
    }

    AndroidFuture<UserCreationResult> createDriver(String str, boolean z) throws RemoteException;

    UserInfo createPassenger(String str, int i) throws RemoteException;

    void createUser(String str, String str2, int i, int i2, AndroidFuture<UserCreationResult> androidFuture) throws RemoteException;

    List<UserInfo> getAllDrivers() throws RemoteException;

    void getInitialUserInfo(int i, int i2, IResultReceiver iResultReceiver) throws RemoteException;

    List<UserInfo> getPassengers(int i) throws RemoteException;

    UserIdentificationAssociationResponse getUserIdentificationAssociation(int[] iArr) throws RemoteException;

    boolean isUserHalUserAssociationSupported() throws RemoteException;

    UserRemovalResult removeUser(int i) throws RemoteException;

    void resetLifecycleListenerForUid() throws RemoteException;

    void setLifecycleListenerForUid(IResultReceiver iResultReceiver) throws RemoteException;

    void setUserIdentificationAssociation(int i, int[] iArr, int[] iArr2, AndroidFuture<UserIdentificationAssociationResponse> androidFuture) throws RemoteException;

    void setUserSwitchUiCallback(IResultReceiver iResultReceiver) throws RemoteException;

    boolean startPassenger(int i, int i2) throws RemoteException;

    boolean stopPassenger(int i) throws RemoteException;

    void switchDriver(int i, AndroidFuture<UserSwitchResult> androidFuture) throws RemoteException;

    void switchUser(int i, int i2, AndroidFuture<UserSwitchResult> androidFuture) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarUserService {
        private static final String DESCRIPTOR = "android.car.ICarUserService";
        static final int TRANSACTION_createDriver = 1;
        static final int TRANSACTION_createPassenger = 2;
        static final int TRANSACTION_createUser = 6;
        static final int TRANSACTION_getAllDrivers = 8;
        static final int TRANSACTION_getInitialUserInfo = 14;
        static final int TRANSACTION_getPassengers = 9;
        static final int TRANSACTION_getUserIdentificationAssociation = 15;
        static final int TRANSACTION_isUserHalUserAssociationSupported = 17;
        static final int TRANSACTION_removeUser = 7;
        static final int TRANSACTION_resetLifecycleListenerForUid = 13;
        static final int TRANSACTION_setLifecycleListenerForUid = 12;
        static final int TRANSACTION_setUserIdentificationAssociation = 16;
        static final int TRANSACTION_setUserSwitchUiCallback = 5;
        static final int TRANSACTION_startPassenger = 10;
        static final int TRANSACTION_stopPassenger = 11;
        static final int TRANSACTION_switchDriver = 3;
        static final int TRANSACTION_switchUser = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarUserService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarUserService)) {
                return (ICarUserService) queryLocalInterface;
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
                    AndroidFuture<UserCreationResult> createDriver = createDriver(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (createDriver != null) {
                        parcel2.writeInt(1);
                        createDriver.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    UserInfo createPassenger = createPassenger(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (createPassenger != null) {
                        parcel2.writeInt(1);
                        createPassenger.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchDriver(parcel.readInt(), parcel.readInt() != 0 ? (AndroidFuture) AndroidFuture.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchUser(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (AndroidFuture) AndroidFuture.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    setUserSwitchUiCallback(IResultReceiver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    createUser(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (AndroidFuture) AndroidFuture.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    UserRemovalResult removeUser = removeUser(parcel.readInt());
                    parcel2.writeNoException();
                    if (removeUser != null) {
                        parcel2.writeInt(1);
                        removeUser.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<UserInfo> allDrivers = getAllDrivers();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allDrivers);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<UserInfo> passengers = getPassengers(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(passengers);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean startPassenger = startPassenger(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(startPassenger ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean stopPassenger = stopPassenger(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(stopPassenger ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLifecycleListenerForUid(IResultReceiver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    resetLifecycleListenerForUid();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    getInitialUserInfo(parcel.readInt(), parcel.readInt(), IResultReceiver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    UserIdentificationAssociationResponse userIdentificationAssociation = getUserIdentificationAssociation(parcel.createIntArray());
                    parcel2.writeNoException();
                    if (userIdentificationAssociation != null) {
                        parcel2.writeInt(1);
                        userIdentificationAssociation.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    setUserIdentificationAssociation(parcel.readInt(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt() != 0 ? (AndroidFuture) AndroidFuture.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isUserHalUserAssociationSupported = isUserHalUserAssociationSupported();
                    parcel2.writeNoException();
                    parcel2.writeInt(isUserHalUserAssociationSupported ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarUserService {
            public static ICarUserService sDefaultImpl;
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

            @Override // android.car.ICarUserService
            public AndroidFuture<UserCreationResult> createDriver(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createDriver(str, z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (AndroidFuture) AndroidFuture.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public UserInfo createPassenger(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createPassenger(str, i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (UserInfo) UserInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void switchDriver(int i, AndroidFuture<UserSwitchResult> androidFuture) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (androidFuture != null) {
                        obtain.writeInt(1);
                        androidFuture.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().switchDriver(i, androidFuture);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void switchUser(int i, int i2, AndroidFuture<UserSwitchResult> androidFuture) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (androidFuture != null) {
                        obtain.writeInt(1);
                        androidFuture.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().switchUser(i, i2, androidFuture);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void setUserSwitchUiCallback(IResultReceiver iResultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iResultReceiver != null ? iResultReceiver.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setUserSwitchUiCallback(iResultReceiver);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void createUser(String str, String str2, int i, int i2, AndroidFuture<UserCreationResult> androidFuture) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (androidFuture != null) {
                        obtain.writeInt(1);
                        androidFuture.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().createUser(str, str2, i, i2, androidFuture);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public UserRemovalResult removeUser(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeUser(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? UserRemovalResult.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public List<UserInfo> getAllDrivers() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllDrivers();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(UserInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public List<UserInfo> getPassengers(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPassengers(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(UserInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public boolean startPassenger(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startPassenger(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public boolean stopPassenger(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopPassenger(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void setLifecycleListenerForUid(IResultReceiver iResultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iResultReceiver != null ? iResultReceiver.asBinder() : null);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setLifecycleListenerForUid(iResultReceiver);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void resetLifecycleListenerForUid() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().resetLifecycleListenerForUid();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void getInitialUserInfo(int i, int i2, IResultReceiver iResultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(iResultReceiver != null ? iResultReceiver.asBinder() : null);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getInitialUserInfo(i, i2, iResultReceiver);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public UserIdentificationAssociationResponse getUserIdentificationAssociation(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUserIdentificationAssociation(iArr);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? UserIdentificationAssociationResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public void setUserIdentificationAssociation(int i, int[] iArr, int[] iArr2, AndroidFuture<UserIdentificationAssociationResponse> androidFuture) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    if (androidFuture != null) {
                        obtain.writeInt(1);
                        androidFuture.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setUserIdentificationAssociation(i, iArr, iArr2, androidFuture);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarUserService
            public boolean isUserHalUserAssociationSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isUserHalUserAssociationSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarUserService iCarUserService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarUserService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarUserService;
            return true;
        }

        public static ICarUserService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
