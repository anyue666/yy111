package com.autolink.buryservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.buryservice.bury.bean.CarUpdateBean;
import com.autolink.buryservice.bury.bean.HealthResultBean;
import com.autolink.buryservice.bury.bean.LocationGPSBean;
import com.autolink.buryservice.bury.bean.SystemSettingsBean;

/* loaded from: classes.dex */
public interface IBuryService extends IInterface {

    public static class Default implements IBuryService {
        @Override // com.autolink.buryservice.IBuryService
        public void appListACSettupBury1(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListACSettupBury2(String str, String str2, float f) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListBcallBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListCarUpdateBury(CarUpdateBean carUpdateBean) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListCommonBury(String str, String str2, int i, String str3) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListEcallBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListHealthBury(HealthResultBean healthResultBean) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListIntelligentSceneBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListOMSBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListUserCenterBury1(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListUserCenterBury2(String str, String str2, int i, String str3, int i2) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListUserCenterBury3(String str, String str2, int i, String str3, int i2, String str4, String str5) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void appListXmodeBury(String str, String str2, String str3) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.buryservice.IBuryService
        public void bTPhoneBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void errorEscalationBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void launcherCardBarBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void launcherDockBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void launcherDropdownBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void locationGpsBury(LocationGPSBean locationGPSBean) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void panoramicImage540Bury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void panoramicImageDVRBury(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void vehicleSettingsBury1(String str, String str2, int i) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void vehicleSettingsBury2(String str, String str2, String str3) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void vehicleSettingsBury3(String str, String str2, int i, String str3, int i2) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void vehicleSettingsBury4(SystemSettingsBean systemSettingsBean) throws RemoteException {
        }

        @Override // com.autolink.buryservice.IBuryService
        public void wheelBury(String str, String str2, int i) throws RemoteException {
        }
    }

    void appListACSettupBury1(String str, String str2, int i) throws RemoteException;

    void appListACSettupBury2(String str, String str2, float f) throws RemoteException;

    void appListBcallBury(String str, String str2, int i) throws RemoteException;

    void appListCarUpdateBury(CarUpdateBean carUpdateBean) throws RemoteException;

    void appListCommonBury(String str, String str2, int i, String str3) throws RemoteException;

    void appListEcallBury(String str, String str2, int i) throws RemoteException;

    void appListHealthBury(HealthResultBean healthResultBean) throws RemoteException;

    void appListIntelligentSceneBury(String str, String str2, int i) throws RemoteException;

    void appListOMSBury(String str, String str2, int i) throws RemoteException;

    void appListUserCenterBury1(String str, String str2, int i) throws RemoteException;

    void appListUserCenterBury2(String str, String str2, int i, String str3, int i2) throws RemoteException;

    void appListUserCenterBury3(String str, String str2, int i, String str3, int i2, String str4, String str5) throws RemoteException;

    void appListXmodeBury(String str, String str2, String str3) throws RemoteException;

    void bTPhoneBury(String str, String str2, int i) throws RemoteException;

    void errorEscalationBury(String str, String str2, int i) throws RemoteException;

    void launcherCardBarBury(String str, String str2, int i) throws RemoteException;

    void launcherDockBury(String str, String str2, int i) throws RemoteException;

    void launcherDropdownBury(String str, String str2, int i) throws RemoteException;

    void locationGpsBury(LocationGPSBean locationGPSBean) throws RemoteException;

    void panoramicImage540Bury(String str, String str2, int i) throws RemoteException;

    void panoramicImageDVRBury(String str, String str2, int i) throws RemoteException;

    void vehicleSettingsBury1(String str, String str2, int i) throws RemoteException;

    void vehicleSettingsBury2(String str, String str2, String str3) throws RemoteException;

    void vehicleSettingsBury3(String str, String str2, int i, String str3, int i2) throws RemoteException;

    void vehicleSettingsBury4(SystemSettingsBean systemSettingsBean) throws RemoteException;

    void wheelBury(String str, String str2, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IBuryService {
        private static final String DESCRIPTOR = "com.autolink.buryservice.IBuryService";
        static final int TRANSACTION_appListACSettupBury1 = 14;
        static final int TRANSACTION_appListACSettupBury2 = 15;
        static final int TRANSACTION_appListBcallBury = 17;
        static final int TRANSACTION_appListCarUpdateBury = 18;
        static final int TRANSACTION_appListCommonBury = 1;
        static final int TRANSACTION_appListEcallBury = 16;
        static final int TRANSACTION_appListHealthBury = 20;
        static final int TRANSACTION_appListIntelligentSceneBury = 3;
        static final int TRANSACTION_appListOMSBury = 9;
        static final int TRANSACTION_appListUserCenterBury1 = 11;
        static final int TRANSACTION_appListUserCenterBury2 = 12;
        static final int TRANSACTION_appListUserCenterBury3 = 13;
        static final int TRANSACTION_appListXmodeBury = 21;
        static final int TRANSACTION_bTPhoneBury = 4;
        static final int TRANSACTION_errorEscalationBury = 10;
        static final int TRANSACTION_launcherCardBarBury = 23;
        static final int TRANSACTION_launcherDockBury = 24;
        static final int TRANSACTION_launcherDropdownBury = 22;
        static final int TRANSACTION_locationGpsBury = 25;
        static final int TRANSACTION_panoramicImage540Bury = 2;
        static final int TRANSACTION_panoramicImageDVRBury = 19;
        static final int TRANSACTION_vehicleSettingsBury1 = 5;
        static final int TRANSACTION_vehicleSettingsBury2 = 6;
        static final int TRANSACTION_vehicleSettingsBury3 = 7;
        static final int TRANSACTION_vehicleSettingsBury4 = 8;
        static final int TRANSACTION_wheelBury = 26;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBuryService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBuryService)) {
                return (IBuryService) queryLocalInterface;
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
                    appListCommonBury(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    panoramicImage540Bury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListIntelligentSceneBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    bTPhoneBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    vehicleSettingsBury1(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    vehicleSettingsBury2(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    vehicleSettingsBury3(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    vehicleSettingsBury4(parcel.readInt() != 0 ? SystemSettingsBean.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListOMSBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    errorEscalationBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListUserCenterBury1(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListUserCenterBury2(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListUserCenterBury3(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListACSettupBury1(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListACSettupBury2(parcel.readString(), parcel.readString(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListEcallBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListBcallBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListCarUpdateBury(parcel.readInt() != 0 ? CarUpdateBean.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    panoramicImageDVRBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListHealthBury(parcel.readInt() != 0 ? HealthResultBean.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    appListXmodeBury(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    launcherDropdownBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    launcherCardBarBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    launcherDockBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    locationGpsBury(parcel.readInt() != 0 ? LocationGPSBean.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    wheelBury(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IBuryService {
            public static IBuryService sDefaultImpl;
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

            @Override // com.autolink.buryservice.IBuryService
            public void appListCommonBury(String str, String str2, int i, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListCommonBury(str, str2, i, str3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void panoramicImage540Bury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().panoramicImage540Bury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListIntelligentSceneBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListIntelligentSceneBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void bTPhoneBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().bTPhoneBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void vehicleSettingsBury1(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().vehicleSettingsBury1(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void vehicleSettingsBury2(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().vehicleSettingsBury2(str, str2, str3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void vehicleSettingsBury3(String str, String str2, int i, String str3, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().vehicleSettingsBury3(str, str2, i, str3, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void vehicleSettingsBury4(SystemSettingsBean systemSettingsBean) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (systemSettingsBean != null) {
                        obtain.writeInt(1);
                        systemSettingsBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().vehicleSettingsBury4(systemSettingsBean);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListOMSBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListOMSBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void errorEscalationBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().errorEscalationBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListUserCenterBury1(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListUserCenterBury1(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListUserCenterBury2(String str, String str2, int i, String str3, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListUserCenterBury2(str, str2, i, str3, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListUserCenterBury3(String str, String str2, int i, String str3, int i2, String str4, String str5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    obtain.writeInt(i2);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListUserCenterBury3(str, str2, i, str3, i2, str4, str5);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListACSettupBury1(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListACSettupBury1(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListACSettupBury2(String str, String str2, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeFloat(f);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListACSettupBury2(str, str2, f);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListEcallBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListEcallBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListBcallBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListBcallBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListCarUpdateBury(CarUpdateBean carUpdateBean) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (carUpdateBean != null) {
                        obtain.writeInt(1);
                        carUpdateBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListCarUpdateBury(carUpdateBean);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void panoramicImageDVRBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().panoramicImageDVRBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListHealthBury(HealthResultBean healthResultBean) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (healthResultBean != null) {
                        obtain.writeInt(1);
                        healthResultBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListHealthBury(healthResultBean);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void appListXmodeBury(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().appListXmodeBury(str, str2, str3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void launcherDropdownBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().launcherDropdownBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void launcherCardBarBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().launcherCardBarBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void launcherDockBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().launcherDockBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void locationGpsBury(LocationGPSBean locationGPSBean) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (locationGPSBean != null) {
                        obtain.writeInt(1);
                        locationGPSBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().locationGpsBury(locationGPSBean);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.buryservice.IBuryService
            public void wheelBury(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().wheelBury(str, str2, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IBuryService iBuryService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iBuryService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iBuryService;
            return true;
        }

        public static IBuryService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
