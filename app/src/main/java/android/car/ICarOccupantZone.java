package android.car;

import android.car.CarOccupantZoneManager;
import android.car.ICarOccupantZoneCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarOccupantZone extends IInterface {

    public static class Default implements ICarOccupantZone {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.ICarOccupantZone
        public boolean assignProfileUserToOccupantZone(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // android.car.ICarOccupantZone
        public int[] getAllDisplaysForOccupantZone(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.ICarOccupantZone
        public List<CarOccupantZoneManager.OccupantZoneInfo> getAllOccupantZones() throws RemoteException {
            return null;
        }

        @Override // android.car.ICarOccupantZone
        public int getAudioZoneIdForOccupant(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICarOccupantZone
        public int getDisplayForOccupant(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICarOccupantZone
        public int getDisplayType(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICarOccupantZone
        public CarOccupantZoneManager.OccupantZoneInfo getOccupantForAudioZoneId(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.ICarOccupantZone
        public int getOccupantZoneIdForUserId(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICarOccupantZone
        public int getUserForOccupant(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.ICarOccupantZone
        public void registerCallback(ICarOccupantZoneCallback iCarOccupantZoneCallback) throws RemoteException {
        }

        @Override // android.car.ICarOccupantZone
        public void unregisterCallback(ICarOccupantZoneCallback iCarOccupantZoneCallback) throws RemoteException {
        }
    }

    boolean assignProfileUserToOccupantZone(int i, int i2) throws RemoteException;

    int[] getAllDisplaysForOccupantZone(int i) throws RemoteException;

    List<CarOccupantZoneManager.OccupantZoneInfo> getAllOccupantZones() throws RemoteException;

    int getAudioZoneIdForOccupant(int i) throws RemoteException;

    int getDisplayForOccupant(int i, int i2) throws RemoteException;

    int getDisplayType(int i) throws RemoteException;

    CarOccupantZoneManager.OccupantZoneInfo getOccupantForAudioZoneId(int i) throws RemoteException;

    int getOccupantZoneIdForUserId(int i) throws RemoteException;

    int getUserForOccupant(int i) throws RemoteException;

    void registerCallback(ICarOccupantZoneCallback iCarOccupantZoneCallback) throws RemoteException;

    void unregisterCallback(ICarOccupantZoneCallback iCarOccupantZoneCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarOccupantZone {
        private static final String DESCRIPTOR = "android.car.ICarOccupantZone";
        static final int TRANSACTION_assignProfileUserToOccupantZone = 11;
        static final int TRANSACTION_getAllDisplaysForOccupantZone = 3;
        static final int TRANSACTION_getAllOccupantZones = 1;
        static final int TRANSACTION_getAudioZoneIdForOccupant = 2;
        static final int TRANSACTION_getDisplayForOccupant = 4;
        static final int TRANSACTION_getDisplayType = 6;
        static final int TRANSACTION_getOccupantForAudioZoneId = 5;
        static final int TRANSACTION_getOccupantZoneIdForUserId = 8;
        static final int TRANSACTION_getUserForOccupant = 7;
        static final int TRANSACTION_registerCallback = 9;
        static final int TRANSACTION_unregisterCallback = 10;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarOccupantZone asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarOccupantZone)) {
                return (ICarOccupantZone) queryLocalInterface;
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
                    List<CarOccupantZoneManager.OccupantZoneInfo> allOccupantZones = getAllOccupantZones();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allOccupantZones);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int audioZoneIdForOccupant = getAudioZoneIdForOccupant(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(audioZoneIdForOccupant);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int[] allDisplaysForOccupantZone = getAllDisplaysForOccupantZone(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(allDisplaysForOccupantZone);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int displayForOccupant = getDisplayForOccupant(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(displayForOccupant);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    CarOccupantZoneManager.OccupantZoneInfo occupantForAudioZoneId = getOccupantForAudioZoneId(parcel.readInt());
                    parcel2.writeNoException();
                    if (occupantForAudioZoneId != null) {
                        parcel2.writeInt(1);
                        occupantForAudioZoneId.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int displayType = getDisplayType(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(displayType);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int userForOccupant = getUserForOccupant(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(userForOccupant);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int occupantZoneIdForUserId = getOccupantZoneIdForUserId(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(occupantZoneIdForUserId);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(ICarOccupantZoneCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(ICarOccupantZoneCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean assignProfileUserToOccupantZone = assignProfileUserToOccupantZone(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(assignProfileUserToOccupantZone ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarOccupantZone {
            public static ICarOccupantZone sDefaultImpl;
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

            @Override // android.car.ICarOccupantZone
            public List<CarOccupantZoneManager.OccupantZoneInfo> getAllOccupantZones() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllOccupantZones();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(CarOccupantZoneManager.OccupantZoneInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public int getAudioZoneIdForOccupant(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAudioZoneIdForOccupant(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public int[] getAllDisplaysForOccupantZone(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllDisplaysForOccupantZone(i);
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public int getDisplayForOccupant(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDisplayForOccupant(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public CarOccupantZoneManager.OccupantZoneInfo getOccupantForAudioZoneId(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOccupantForAudioZoneId(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CarOccupantZoneManager.OccupantZoneInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public int getDisplayType(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDisplayType(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public int getUserForOccupant(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUserForOccupant(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public int getOccupantZoneIdForUserId(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOccupantZoneIdForUserId(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public void registerCallback(ICarOccupantZoneCallback iCarOccupantZoneCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarOccupantZoneCallback != null ? iCarOccupantZoneCallback.asBinder() : null);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iCarOccupantZoneCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public void unregisterCallback(ICarOccupantZoneCallback iCarOccupantZoneCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarOccupantZoneCallback != null ? iCarOccupantZoneCallback.asBinder() : null);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iCarOccupantZoneCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.ICarOccupantZone
            public boolean assignProfileUserToOccupantZone(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().assignProfileUserToOccupantZone(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarOccupantZone iCarOccupantZone) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarOccupantZone == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarOccupantZone;
            return true;
        }

        public static ICarOccupantZone getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
