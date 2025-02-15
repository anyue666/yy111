package com.autolink.adapterinterface;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.IOtaStateListener;
import com.autolink.adapterinterface.IPkiServiceListener;
import com.autolink.adapterinterface.IRpaServiceListener;
import com.autolink.adapterinterface.ITBoxBaseListener;
import com.autolink.adapterinterface.ITBoxRemoteListner;

/* loaded from: classes.dex */
public interface ITBoxManager extends IInterface {

    public static class Default implements ITBoxManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void changeCallStateRequest(int i, int i2, int i3) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void chargeReserveSetRequest(int i, ChargeSetReqeust chargeSetReqeust) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void chargeReserveStatuReportResponse(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void chargeReserveSyncResponse(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void fotaUserComfirmResponse(int i, FotaUserComfResp fotaUserComfResp) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public byte[] getCarModelConfig() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public GeneralInfo getGeneralInfo() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getHardwareVersion() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getICCID() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getIMEI() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getIMSI() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public int getManufactureDate() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public int getNetworkType() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getPartNumber() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getSN() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public int getSignalStrength() throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getSoftVersion() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getSupplierIdertifier() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public String getVinCode() throws RemoteException {
            return null;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void inquireChargeReserveRequest(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void lightShowCtrlResponse(int i, int i2, int i3) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void networkStateRequest(int i, boolean z, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void otaSubNodeRefreshNowResponse(int i, long j, String str) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public boolean registerFotaListener(int i, IOtaStateListener iOtaStateListener) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public boolean registerPkiListner(int i, IPkiServiceListener iPkiServiceListener) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public boolean registerRemoteListner(int i, ITBoxRemoteListner iTBoxRemoteListner) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public boolean registerRpaListner(int i, IRpaServiceListener iRpaServiceListener) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public boolean registerTBoxCallback(int i, ITBoxBaseListener iTBoxBaseListener) throws RemoteException {
            return false;
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void reportOtaSubNodeState(int i, OtaSubNodeState otaSubNodeState) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendCertificateStatusResp(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendCommand(int i, TBoxCommandMsg tBoxCommandMsg) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendDownloadCertificateRltReport(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendGetCertResp(int i, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendGetGeneralInfoRequest(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendRpaReport(int i, int i2, byte[] bArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendRpaResp(int i, int i2, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendSlotReport1(int i, int i2, byte[] bArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendSlotReport2(int i, int i2, byte[] bArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendSubNodeEnterFactory(int i, SubNodeEnter subNodeEnter) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void sendSubNodeStartFactory(int i, boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void unregisterFotaListener(int i, IOtaStateListener iOtaStateListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void unregisterPkiListner(int i, IPkiServiceListener iPkiServiceListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void unregisterRemoteListner(int i, ITBoxRemoteListner iTBoxRemoteListner) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void unregisterRpaListner(int i, IRpaServiceListener iRpaServiceListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.ITBoxManager
        public void unregisterTBoxCallback(int i, ITBoxBaseListener iTBoxBaseListener) throws RemoteException {
        }
    }

    void changeCallStateRequest(int i, int i2, int i3) throws RemoteException;

    void chargeReserveSetRequest(int i, ChargeSetReqeust chargeSetReqeust) throws RemoteException;

    void chargeReserveStatuReportResponse(int i, int i2) throws RemoteException;

    void chargeReserveSyncResponse(int i, int i2) throws RemoteException;

    void fotaUserComfirmResponse(int i, FotaUserComfResp fotaUserComfResp) throws RemoteException;

    byte[] getCarModelConfig() throws RemoteException;

    GeneralInfo getGeneralInfo() throws RemoteException;

    String getHardwareVersion() throws RemoteException;

    String getICCID() throws RemoteException;

    String getIMEI() throws RemoteException;

    String getIMSI() throws RemoteException;

    int getManufactureDate() throws RemoteException;

    int getNetworkType() throws RemoteException;

    String getPartNumber() throws RemoteException;

    String getSN() throws RemoteException;

    int getSignalStrength() throws RemoteException;

    String getSoftVersion() throws RemoteException;

    String getSupplierIdertifier() throws RemoteException;

    String getVinCode() throws RemoteException;

    void inquireChargeReserveRequest(int i) throws RemoteException;

    void lightShowCtrlResponse(int i, int i2, int i3) throws RemoteException;

    void networkStateRequest(int i, boolean z, int i2) throws RemoteException;

    void otaSubNodeRefreshNowResponse(int i, long j, String str) throws RemoteException;

    boolean registerFotaListener(int i, IOtaStateListener iOtaStateListener) throws RemoteException;

    boolean registerPkiListner(int i, IPkiServiceListener iPkiServiceListener) throws RemoteException;

    boolean registerRemoteListner(int i, ITBoxRemoteListner iTBoxRemoteListner) throws RemoteException;

    boolean registerRpaListner(int i, IRpaServiceListener iRpaServiceListener) throws RemoteException;

    boolean registerTBoxCallback(int i, ITBoxBaseListener iTBoxBaseListener) throws RemoteException;

    void reportOtaSubNodeState(int i, OtaSubNodeState otaSubNodeState) throws RemoteException;

    void sendCertificateStatusResp(int i, int i2) throws RemoteException;

    void sendCommand(int i, TBoxCommandMsg tBoxCommandMsg) throws RemoteException;

    void sendDownloadCertificateRltReport(int i, int i2) throws RemoteException;

    void sendGetCertResp(int i, boolean z) throws RemoteException;

    void sendGetGeneralInfoRequest(int i) throws RemoteException;

    void sendRpaReport(int i, int i2, byte[] bArr) throws RemoteException;

    void sendRpaResp(int i, int i2, boolean z) throws RemoteException;

    void sendSlotReport1(int i, int i2, byte[] bArr) throws RemoteException;

    void sendSlotReport2(int i, int i2, byte[] bArr) throws RemoteException;

    void sendSubNodeEnterFactory(int i, SubNodeEnter subNodeEnter) throws RemoteException;

    void sendSubNodeStartFactory(int i, boolean z) throws RemoteException;

    void unregisterFotaListener(int i, IOtaStateListener iOtaStateListener) throws RemoteException;

    void unregisterPkiListner(int i, IPkiServiceListener iPkiServiceListener) throws RemoteException;

    void unregisterRemoteListner(int i, ITBoxRemoteListner iTBoxRemoteListner) throws RemoteException;

    void unregisterRpaListner(int i, IRpaServiceListener iRpaServiceListener) throws RemoteException;

    void unregisterTBoxCallback(int i, ITBoxBaseListener iTBoxBaseListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ITBoxManager {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.ITBoxManager";
        static final int TRANSACTION_changeCallStateRequest = 21;
        static final int TRANSACTION_chargeReserveSetRequest = 16;
        static final int TRANSACTION_chargeReserveStatuReportResponse = 18;
        static final int TRANSACTION_chargeReserveSyncResponse = 17;
        static final int TRANSACTION_fotaUserComfirmResponse = 14;
        static final int TRANSACTION_getCarModelConfig = 12;
        static final int TRANSACTION_getGeneralInfo = 26;
        static final int TRANSACTION_getHardwareVersion = 6;
        static final int TRANSACTION_getICCID = 5;
        static final int TRANSACTION_getIMEI = 11;
        static final int TRANSACTION_getIMSI = 10;
        static final int TRANSACTION_getManufactureDate = 3;
        static final int TRANSACTION_getNetworkType = 22;
        static final int TRANSACTION_getPartNumber = 9;
        static final int TRANSACTION_getSN = 4;
        static final int TRANSACTION_getSignalStrength = 23;
        static final int TRANSACTION_getSoftVersion = 7;
        static final int TRANSACTION_getSupplierIdertifier = 8;
        static final int TRANSACTION_getVinCode = 2;
        static final int TRANSACTION_inquireChargeReserveRequest = 19;
        static final int TRANSACTION_lightShowCtrlResponse = 20;
        static final int TRANSACTION_networkStateRequest = 24;
        static final int TRANSACTION_otaSubNodeRefreshNowResponse = 15;
        static final int TRANSACTION_registerFotaListener = 38;
        static final int TRANSACTION_registerPkiListner = 44;
        static final int TRANSACTION_registerRemoteListner = 40;
        static final int TRANSACTION_registerRpaListner = 42;
        static final int TRANSACTION_registerTBoxCallback = 36;
        static final int TRANSACTION_reportOtaSubNodeState = 13;
        static final int TRANSACTION_sendCertificateStatusResp = 35;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendDownloadCertificateRltReport = 34;
        static final int TRANSACTION_sendGetCertResp = 33;
        static final int TRANSACTION_sendGetGeneralInfoRequest = 25;
        static final int TRANSACTION_sendRpaReport = 28;
        static final int TRANSACTION_sendRpaResp = 27;
        static final int TRANSACTION_sendSlotReport1 = 29;
        static final int TRANSACTION_sendSlotReport2 = 30;
        static final int TRANSACTION_sendSubNodeEnterFactory = 31;
        static final int TRANSACTION_sendSubNodeStartFactory = 32;
        static final int TRANSACTION_unregisterFotaListener = 39;
        static final int TRANSACTION_unregisterPkiListner = 45;
        static final int TRANSACTION_unregisterRemoteListner = 41;
        static final int TRANSACTION_unregisterRpaListner = 43;
        static final int TRANSACTION_unregisterTBoxCallback = 37;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITBoxManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITBoxManager)) {
                return (ITBoxManager) queryLocalInterface;
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
                    sendCommand(parcel.readInt(), parcel.readInt() != 0 ? TBoxCommandMsg.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    String vinCode = getVinCode();
                    parcel2.writeNoException();
                    parcel2.writeString(vinCode);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int manufactureDate = getManufactureDate();
                    parcel2.writeNoException();
                    parcel2.writeInt(manufactureDate);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    String sn = getSN();
                    parcel2.writeNoException();
                    parcel2.writeString(sn);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String iccid = getICCID();
                    parcel2.writeNoException();
                    parcel2.writeString(iccid);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String hardwareVersion = getHardwareVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(hardwareVersion);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    String softVersion = getSoftVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(softVersion);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    String supplierIdertifier = getSupplierIdertifier();
                    parcel2.writeNoException();
                    parcel2.writeString(supplierIdertifier);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    String partNumber = getPartNumber();
                    parcel2.writeNoException();
                    parcel2.writeString(partNumber);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    String imsi = getIMSI();
                    parcel2.writeNoException();
                    parcel2.writeString(imsi);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    String imei = getIMEI();
                    parcel2.writeNoException();
                    parcel2.writeString(imei);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    byte[] carModelConfig = getCarModelConfig();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(carModelConfig);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    reportOtaSubNodeState(parcel.readInt(), parcel.readInt() != 0 ? OtaSubNodeState.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    fotaUserComfirmResponse(parcel.readInt(), parcel.readInt() != 0 ? FotaUserComfResp.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    otaSubNodeRefreshNowResponse(parcel.readInt(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    chargeReserveSetRequest(parcel.readInt(), parcel.readInt() != 0 ? ChargeSetReqeust.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    chargeReserveSyncResponse(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    chargeReserveStatuReportResponse(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    inquireChargeReserveRequest(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    lightShowCtrlResponse(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    changeCallStateRequest(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    int networkType = getNetworkType();
                    parcel2.writeNoException();
                    parcel2.writeInt(networkType);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    int signalStrength = getSignalStrength();
                    parcel2.writeNoException();
                    parcel2.writeInt(signalStrength);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    networkStateRequest(parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendGetGeneralInfoRequest(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    GeneralInfo generalInfo = getGeneralInfo();
                    parcel2.writeNoException();
                    if (generalInfo != null) {
                        parcel2.writeInt(1);
                        generalInfo.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendRpaResp(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendRpaReport(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendSlotReport1(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendSlotReport2(parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendSubNodeEnterFactory(parcel.readInt(), parcel.readInt() != 0 ? SubNodeEnter.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendSubNodeStartFactory(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendGetCertResp(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendDownloadCertificateRltReport(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendCertificateStatusResp(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean registerTBoxCallback = registerTBoxCallback(parcel.readInt(), ITBoxBaseListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerTBoxCallback ? 1 : 0);
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterTBoxCallback(parcel.readInt(), ITBoxBaseListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean registerFotaListener = registerFotaListener(parcel.readInt(), IOtaStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerFotaListener ? 1 : 0);
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterFotaListener(parcel.readInt(), IOtaStateListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean registerRemoteListner = registerRemoteListner(parcel.readInt(), ITBoxRemoteListner.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerRemoteListner ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterRemoteListner(parcel.readInt(), ITBoxRemoteListner.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean registerRpaListner = registerRpaListner(parcel.readInt(), IRpaServiceListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerRpaListner ? 1 : 0);
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterRpaListner(parcel.readInt(), IRpaServiceListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean registerPkiListner = registerPkiListner(parcel.readInt(), IPkiServiceListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerPkiListner ? 1 : 0);
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterPkiListner(parcel.readInt(), IPkiServiceListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ITBoxManager {
            public static ITBoxManager sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendCommand(int i, TBoxCommandMsg tBoxCommandMsg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (tBoxCommandMsg != null) {
                        obtain.writeInt(1);
                        tBoxCommandMsg.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendCommand(i, tBoxCommandMsg);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getVinCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVinCode();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public int getManufactureDate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getManufactureDate();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getSN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSN();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getICCID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getICCID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getHardwareVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getHardwareVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getSoftVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSoftVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getSupplierIdertifier() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSupplierIdertifier();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getPartNumber() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPartNumber();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getIMSI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIMSI();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public String getIMEI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIMEI();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public byte[] getCarModelConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCarModelConfig();
                    }
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void reportOtaSubNodeState(int i, OtaSubNodeState otaSubNodeState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (otaSubNodeState != null) {
                        obtain.writeInt(1);
                        otaSubNodeState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().reportOtaSubNodeState(i, otaSubNodeState);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void fotaUserComfirmResponse(int i, FotaUserComfResp fotaUserComfResp) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (fotaUserComfResp != null) {
                        obtain.writeInt(1);
                        fotaUserComfResp.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().fotaUserComfirmResponse(i, fotaUserComfResp);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void otaSubNodeRefreshNowResponse(int i, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().otaSubNodeRefreshNowResponse(i, j, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void chargeReserveSetRequest(int i, ChargeSetReqeust chargeSetReqeust) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (chargeSetReqeust != null) {
                        obtain.writeInt(1);
                        chargeSetReqeust.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().chargeReserveSetRequest(i, chargeSetReqeust);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void chargeReserveSyncResponse(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().chargeReserveSyncResponse(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void chargeReserveStatuReportResponse(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().chargeReserveStatuReportResponse(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void inquireChargeReserveRequest(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().inquireChargeReserveRequest(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void lightShowCtrlResponse(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().lightShowCtrlResponse(i, i2, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void changeCallStateRequest(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().changeCallStateRequest(i, i2, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public int getNetworkType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNetworkType();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public int getSignalStrength() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSignalStrength();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void networkStateRequest(int i, boolean z, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().networkStateRequest(i, z, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendGetGeneralInfoRequest(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendGetGeneralInfoRequest(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public GeneralInfo getGeneralInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGeneralInfo();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? GeneralInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendRpaResp(int i, int i2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendRpaResp(i, i2, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendRpaReport(int i, int i2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendRpaReport(i, i2, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendSlotReport1(int i, int i2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(29, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendSlotReport1(i, i2, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendSlotReport2(int i, int i2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(30, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendSlotReport2(i, i2, bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendSubNodeEnterFactory(int i, SubNodeEnter subNodeEnter) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (subNodeEnter != null) {
                        obtain.writeInt(1);
                        subNodeEnter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendSubNodeEnterFactory(i, subNodeEnter);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendSubNodeStartFactory(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendSubNodeStartFactory(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendGetCertResp(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(33, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendGetCertResp(i, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendDownloadCertificateRltReport(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendDownloadCertificateRltReport(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void sendCertificateStatusResp(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(35, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendCertificateStatusResp(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public boolean registerTBoxCallback(int i, ITBoxBaseListener iTBoxBaseListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iTBoxBaseListener != null ? iTBoxBaseListener.asBinder() : null);
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerTBoxCallback(i, iTBoxBaseListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void unregisterTBoxCallback(int i, ITBoxBaseListener iTBoxBaseListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iTBoxBaseListener != null ? iTBoxBaseListener.asBinder() : null);
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterTBoxCallback(i, iTBoxBaseListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public boolean registerFotaListener(int i, IOtaStateListener iOtaStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iOtaStateListener != null ? iOtaStateListener.asBinder() : null);
                    if (!this.mRemote.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerFotaListener(i, iOtaStateListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void unregisterFotaListener(int i, IOtaStateListener iOtaStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iOtaStateListener != null ? iOtaStateListener.asBinder() : null);
                    if (!this.mRemote.transact(39, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterFotaListener(i, iOtaStateListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public boolean registerRemoteListner(int i, ITBoxRemoteListner iTBoxRemoteListner) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iTBoxRemoteListner != null ? iTBoxRemoteListner.asBinder() : null);
                    if (!this.mRemote.transact(40, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerRemoteListner(i, iTBoxRemoteListner);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void unregisterRemoteListner(int i, ITBoxRemoteListner iTBoxRemoteListner) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iTBoxRemoteListner != null ? iTBoxRemoteListner.asBinder() : null);
                    if (!this.mRemote.transact(41, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterRemoteListner(i, iTBoxRemoteListner);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public boolean registerRpaListner(int i, IRpaServiceListener iRpaServiceListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iRpaServiceListener != null ? iRpaServiceListener.asBinder() : null);
                    if (!this.mRemote.transact(42, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerRpaListner(i, iRpaServiceListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void unregisterRpaListner(int i, IRpaServiceListener iRpaServiceListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iRpaServiceListener != null ? iRpaServiceListener.asBinder() : null);
                    if (!this.mRemote.transact(43, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterRpaListner(i, iRpaServiceListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public boolean registerPkiListner(int i, IPkiServiceListener iPkiServiceListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iPkiServiceListener != null ? iPkiServiceListener.asBinder() : null);
                    if (!this.mRemote.transact(44, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerPkiListner(i, iPkiServiceListener);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.ITBoxManager
            public void unregisterPkiListner(int i, IPkiServiceListener iPkiServiceListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iPkiServiceListener != null ? iPkiServiceListener.asBinder() : null);
                    if (!this.mRemote.transact(45, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterPkiListner(i, iPkiServiceListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITBoxManager iTBoxManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iTBoxManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTBoxManager;
            return true;
        }

        public static ITBoxManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
