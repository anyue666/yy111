package com.autolink.hmi.crosscountry;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICrossCallback extends IInterface {

    public static class Default implements ICrossCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onAngleInclination(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onCarSteerListener(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onCarTyreListener(String str, String str2) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onDifferentialLock(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onDrivingMode(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onFetalTemperature(String str, String str2) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onReceived(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onRollAngle(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onSTSChange(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onSignalState(String str, String str2) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onWadingDepth(String str) throws RemoteException {
        }

        @Override // com.autolink.hmi.crosscountry.ICrossCallback
        public void onXSteerMode(String str) throws RemoteException {
        }
    }

    void onAngleInclination(String str) throws RemoteException;

    void onCarSteerListener(String str) throws RemoteException;

    void onCarTyreListener(String str, String str2) throws RemoteException;

    void onDifferentialLock(String str) throws RemoteException;

    void onDrivingMode(String str) throws RemoteException;

    void onFetalTemperature(String str, String str2) throws RemoteException;

    void onReceived(String str) throws RemoteException;

    void onRollAngle(String str) throws RemoteException;

    void onSTSChange(String str) throws RemoteException;

    void onSignalState(String str, String str2) throws RemoteException;

    void onWadingDepth(String str) throws RemoteException;

    void onXSteerMode(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements ICrossCallback {
        private static final String DESCRIPTOR = "com.autolink.hmi.crosscountry.ICrossCallback";
        static final int TRANSACTION_onAngleInclination = 10;
        static final int TRANSACTION_onCarSteerListener = 8;
        static final int TRANSACTION_onCarTyreListener = 9;
        static final int TRANSACTION_onDifferentialLock = 2;
        static final int TRANSACTION_onDrivingMode = 4;
        static final int TRANSACTION_onFetalTemperature = 7;
        static final int TRANSACTION_onReceived = 1;
        static final int TRANSACTION_onRollAngle = 11;
        static final int TRANSACTION_onSTSChange = 12;
        static final int TRANSACTION_onSignalState = 5;
        static final int TRANSACTION_onWadingDepth = 3;
        static final int TRANSACTION_onXSteerMode = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICrossCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICrossCallback)) {
                return (ICrossCallback) queryLocalInterface;
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
                    onReceived(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDifferentialLock(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onWadingDepth(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDrivingMode(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSignalState(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onXSteerMode(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onFetalTemperature(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCarSteerListener(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCarTyreListener(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAngleInclination(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRollAngle(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSTSChange(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICrossCallback {
            public static ICrossCallback sDefaultImpl;
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

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onReceived(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onReceived(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onDifferentialLock(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDifferentialLock(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onWadingDepth(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onWadingDepth(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onDrivingMode(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDrivingMode(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onSignalState(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSignalState(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onXSteerMode(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onXSteerMode(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onFetalTemperature(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onFetalTemperature(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onCarSteerListener(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCarSteerListener(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onCarTyreListener(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCarTyreListener(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onAngleInclination(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAngleInclination(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onRollAngle(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRollAngle(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.hmi.crosscountry.ICrossCallback
            public void onSTSChange(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSTSChange(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICrossCallback iCrossCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCrossCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCrossCallback;
            return true;
        }

        public static ICrossCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
