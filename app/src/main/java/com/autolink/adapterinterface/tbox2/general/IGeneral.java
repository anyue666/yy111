package com.autolink.adapterinterface.tbox2.general;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IGeneral extends IInterface {

    public static class Default implements IGeneral {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public List<String> getCarModelConfig() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getDate() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public int getDay() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getHardVersion() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getIccid() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getImei() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getImsi() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public int getMonth() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getPartNumber() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getSn() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getSoftVersion() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getSupplierIdertifier() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public String getVinCode() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
        public int getYear() throws RemoteException {
            return 0;
        }
    }

    List<String> getCarModelConfig() throws RemoteException;

    String getDate() throws RemoteException;

    int getDay() throws RemoteException;

    String getHardVersion() throws RemoteException;

    String getIccid() throws RemoteException;

    String getImei() throws RemoteException;

    String getImsi() throws RemoteException;

    int getMonth() throws RemoteException;

    String getPartNumber() throws RemoteException;

    String getSn() throws RemoteException;

    String getSoftVersion() throws RemoteException;

    String getSupplierIdertifier() throws RemoteException;

    String getVinCode() throws RemoteException;

    int getYear() throws RemoteException;

    public static abstract class Stub extends Binder implements IGeneral {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.general.IGeneral";
        static final int TRANSACTION_getCarModelConfig = 13;
        static final int TRANSACTION_getDate = 14;
        static final int TRANSACTION_getDay = 4;
        static final int TRANSACTION_getHardVersion = 7;
        static final int TRANSACTION_getIccid = 6;
        static final int TRANSACTION_getImei = 12;
        static final int TRANSACTION_getImsi = 11;
        static final int TRANSACTION_getMonth = 3;
        static final int TRANSACTION_getPartNumber = 10;
        static final int TRANSACTION_getSn = 5;
        static final int TRANSACTION_getSoftVersion = 8;
        static final int TRANSACTION_getSupplierIdertifier = 9;
        static final int TRANSACTION_getVinCode = 1;
        static final int TRANSACTION_getYear = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGeneral asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGeneral)) {
                return (IGeneral) queryLocalInterface;
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
                    String vinCode = getVinCode();
                    parcel2.writeNoException();
                    parcel2.writeString(vinCode);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int year = getYear();
                    parcel2.writeNoException();
                    parcel2.writeInt(year);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int month = getMonth();
                    parcel2.writeNoException();
                    parcel2.writeInt(month);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int day = getDay();
                    parcel2.writeNoException();
                    parcel2.writeInt(day);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String sn = getSn();
                    parcel2.writeNoException();
                    parcel2.writeString(sn);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String iccid = getIccid();
                    parcel2.writeNoException();
                    parcel2.writeString(iccid);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    String hardVersion = getHardVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(hardVersion);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    String softVersion = getSoftVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(softVersion);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    String supplierIdertifier = getSupplierIdertifier();
                    parcel2.writeNoException();
                    parcel2.writeString(supplierIdertifier);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    String partNumber = getPartNumber();
                    parcel2.writeNoException();
                    parcel2.writeString(partNumber);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    String imsi = getImsi();
                    parcel2.writeNoException();
                    parcel2.writeString(imsi);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    String imei = getImei();
                    parcel2.writeNoException();
                    parcel2.writeString(imei);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<String> carModelConfig = getCarModelConfig();
                    parcel2.writeNoException();
                    parcel2.writeStringList(carModelConfig);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    String date = getDate();
                    parcel2.writeNoException();
                    parcel2.writeString(date);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IGeneral {
            public static IGeneral sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getVinCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVinCode();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public int getYear() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getYear();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public int getMonth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMonth();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public int getDay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDay();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getSn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSn();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getIccid() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIccid();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getHardVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getHardVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getSoftVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSoftVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getSupplierIdertifier() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSupplierIdertifier();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getPartNumber() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPartNumber();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getImsi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getImsi();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getImei() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getImei();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public List<String> getCarModelConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCarModelConfig();
                    }
                    obtain2.readException();
                    return obtain2.createStringArrayList();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.general.IGeneral
            public String getDate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDate();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IGeneral iGeneral) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iGeneral == null) {
                return false;
            }
            Proxy.sDefaultImpl = iGeneral;
            return true;
        }

        public static IGeneral getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
