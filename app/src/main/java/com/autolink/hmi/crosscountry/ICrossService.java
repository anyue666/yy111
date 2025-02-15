package com.autolink.hmi.crosscountry;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.hmi.crosscountry.ICrossCallback;

/* loaded from: classes.dex */
public interface ICrossService extends IInterface {

    public static class Default implements ICrossService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public void callServer(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int canGetVehicleParam(int i) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int canSetVehicleParam(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int getDriveMode() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int getFetalTemperature(int i) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public float getFloatVehicleAVMProp(int i) throws RemoteException {
            return 0.0f;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public float getFloatVehicleControlProp(int i) throws RemoteException {
            return 0.0f;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int getFrontTorqueLockStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int getRearTorqueLockStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int getVehicleAVMProp(int i) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public int getXModeDisplayStatus() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public void register(ICrossCallback iCrossCallback) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossService
        public void unregister(ICrossCallback iCrossCallback) throws RemoteException {
        }
    }

    void callServer(String str) throws RemoteException;

    int canGetVehicleParam(int i) throws RemoteException;

    int canSetVehicleParam(int i, int i2) throws RemoteException;

    int getDriveMode() throws RemoteException;

    int getFetalTemperature(int i) throws RemoteException;

    float getFloatVehicleAVMProp(int i) throws RemoteException;

    float getFloatVehicleControlProp(int i) throws RemoteException;

    int getFrontTorqueLockStatus() throws RemoteException;

    int getRearTorqueLockStatus() throws RemoteException;

    int getVehicleAVMProp(int i) throws RemoteException;

    int getXModeDisplayStatus() throws RemoteException;

    void register(ICrossCallback iCrossCallback) throws RemoteException;

    void unregister(ICrossCallback iCrossCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements ICrossService {
        private static final String DESCRIPTOR = "com.autolink.hmi.crosscountry.ICrossService";
        static final int TRANSACTION_callServer = 3;
        static final int TRANSACTION_canGetVehicleParam = 4;
        static final int TRANSACTION_canSetVehicleParam = 5;
        static final int TRANSACTION_getDriveMode = 8;
        static final int TRANSACTION_getFetalTemperature = 9;
        static final int TRANSACTION_getFloatVehicleAVMProp = 7;
        static final int TRANSACTION_getFloatVehicleControlProp = 6;
        static final int TRANSACTION_getFrontTorqueLockStatus = 12;
        static final int TRANSACTION_getRearTorqueLockStatus = 13;
        static final int TRANSACTION_getVehicleAVMProp = 11;
        static final int TRANSACTION_getXModeDisplayStatus = 10;
        static final int TRANSACTION_register = 1;
        static final int TRANSACTION_unregister = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICrossService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICrossService)) {
                return (ICrossService) queryLocalInterface;
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
                    register(ICrossCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregister(ICrossCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    callServer(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int canGetVehicleParam = canGetVehicleParam(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(canGetVehicleParam);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    int canSetVehicleParam = canSetVehicleParam(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(canSetVehicleParam);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    float floatVehicleControlProp = getFloatVehicleControlProp(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeFloat(floatVehicleControlProp);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    float floatVehicleAVMProp = getFloatVehicleAVMProp(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeFloat(floatVehicleAVMProp);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int driveMode = getDriveMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(driveMode);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int fetalTemperature = getFetalTemperature(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(fetalTemperature);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int xModeDisplayStatus = getXModeDisplayStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(xModeDisplayStatus);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int vehicleAVMProp = getVehicleAVMProp(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(vehicleAVMProp);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    int frontTorqueLockStatus = getFrontTorqueLockStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(frontTorqueLockStatus);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int rearTorqueLockStatus = getRearTorqueLockStatus();
                    parcel2.writeNoException();
                    parcel2.writeInt(rearTorqueLockStatus);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICrossService {
            public static ICrossService sDefaultImpl;
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

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public void register(ICrossCallback iCrossCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCrossCallback != null ? iCrossCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().register(iCrossCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public void unregister(ICrossCallback iCrossCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCrossCallback != null ? iCrossCallback.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregister(iCrossCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public void callServer(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().callServer(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int canGetVehicleParam(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().canGetVehicleParam(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int canSetVehicleParam(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().canSetVehicleParam(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public float getFloatVehicleControlProp(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFloatVehicleControlProp(i);
                    }
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public float getFloatVehicleAVMProp(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFloatVehicleAVMProp(i);
                    }
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int getDriveMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDriveMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int getFetalTemperature(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFetalTemperature(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int getXModeDisplayStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getXModeDisplayStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int getVehicleAVMProp(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVehicleAVMProp(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int getFrontTorqueLockStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFrontTorqueLockStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossService
            public int getRearTorqueLockStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRearTorqueLockStatus();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICrossService iCrossService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCrossService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCrossService;
            return true;
        }

        public static ICrossService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
