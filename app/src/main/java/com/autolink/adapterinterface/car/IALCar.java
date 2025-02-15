package com.autolink.adapterinterface.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.car.IALCarAVMPropertyListener;
import com.autolink.adapterinterface.car.IALCarEngineSpeedListener;
import com.autolink.adapterinterface.car.IALCarExtPropertyListener;
import com.autolink.adapterinterface.car.IALCarHvacPropertyListener;
import com.autolink.adapterinterface.car.IALCarSpeedListener;
import com.autolink.adapterinterface.car.IALCarSteerListener;
import com.autolink.adapterinterface.car.IALCarTyreListener;
import com.autolink.adapterinterface.car.IALCarVehicleControlPropertyListener;
import com.autolink.adapterinterface.car.IALCarWindListener;

/* loaded from: classes.dex */
public interface IALCar extends IInterface {

    public static class Default implements IALCar {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void controlFraganceConcentration(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void controlUltravioletLuminance(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void factoryResetForAL() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public float getFloatProperty(int i, int i2) throws RemoteException {
            return 0.0f;
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public int getIntProperty(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerCarSteerListener(IALCarSteerListener iALCarSteerListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerCarTyreListener(IALCarTyreListener iALCarTyreListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerCarWindListener(IALCarWindListener iALCarWindListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void registerVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void sendChargeTime(int i, int i2, int i3, int i4) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void sendFrontCrashWarningSignals(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void sendHVACsignalsForSmartScene(byte[] bArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void sendIHU03signals(byte[] bArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void sendIHU11signals(byte[] bArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void sendTboxSignalGroupForT1J(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void sendTboxSignalGroupForT1P(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForHUD(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHU14SUB1(int i, int i2, int i3) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHU14SUB2(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHU14SUB3(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHU14SUB4(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHUDVR1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHUDVR2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHUDVR3(int i, int i2, int i3) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForIHUDVRT1L(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setGroupPropertyForMusicLoud(byte[] bArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public int setIntProperty(int i, int i2, int i3) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public int setIntPropertyReduceLog(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setMultiWindow(int i, int i2, int i3, int i4) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setT1KMirrorFlip(int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void setT1PSeatHeatAndVentilation(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterCarSteerListener(IALCarSteerListener iALCarSteerListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterCarTyreListener(IALCarTyreListener iALCarTyreListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterCarWindListener(IALCarWindListener iALCarWindListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.car.IALCar
        public void unregisterVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) throws RemoteException {
        }
    }

    void controlFraganceConcentration(int i, int i2) throws RemoteException;

    void controlUltravioletLuminance(int i, int i2) throws RemoteException;

    void factoryResetForAL() throws RemoteException;

    float getFloatProperty(int i, int i2) throws RemoteException;

    int getIntProperty(int i, int i2) throws RemoteException;

    void registerAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) throws RemoteException;

    void registerCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) throws RemoteException;

    void registerCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) throws RemoteException;

    void registerCarSteerListener(IALCarSteerListener iALCarSteerListener) throws RemoteException;

    void registerCarTyreListener(IALCarTyreListener iALCarTyreListener) throws RemoteException;

    void registerCarWindListener(IALCarWindListener iALCarWindListener) throws RemoteException;

    void registerExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) throws RemoteException;

    void registerHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) throws RemoteException;

    void registerVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) throws RemoteException;

    void sendChargeTime(int i, int i2, int i3, int i4) throws RemoteException;

    void sendFrontCrashWarningSignals(int i, int i2) throws RemoteException;

    void sendHVACsignalsForSmartScene(byte[] bArr) throws RemoteException;

    void sendIHU03signals(byte[] bArr) throws RemoteException;

    void sendIHU11signals(byte[] bArr) throws RemoteException;

    void sendTboxSignalGroupForT1J(int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void sendTboxSignalGroupForT1P(int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void setGroupPropertyForHUD(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException;

    void setGroupPropertyForIHU14SUB1(int i, int i2, int i3) throws RemoteException;

    void setGroupPropertyForIHU14SUB2(int i, int i2) throws RemoteException;

    void setGroupPropertyForIHU14SUB3(int i, int i2) throws RemoteException;

    void setGroupPropertyForIHU14SUB4(int i, int i2) throws RemoteException;

    void setGroupPropertyForIHUDVR1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException;

    void setGroupPropertyForIHUDVR2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException;

    void setGroupPropertyForIHUDVR3(int i, int i2, int i3) throws RemoteException;

    void setGroupPropertyForIHUDVRT1L(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException;

    void setGroupPropertyForMusicLoud(byte[] bArr) throws RemoteException;

    int setIntProperty(int i, int i2, int i3) throws RemoteException;

    int setIntPropertyReduceLog(int i, int i2) throws RemoteException;

    void setMultiWindow(int i, int i2, int i3, int i4) throws RemoteException;

    void setT1KMirrorFlip(int i) throws RemoteException;

    void setT1PSeatHeatAndVentilation(int i, int i2) throws RemoteException;

    void unregisterAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) throws RemoteException;

    void unregisterCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) throws RemoteException;

    void unregisterCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) throws RemoteException;

    void unregisterCarSteerListener(IALCarSteerListener iALCarSteerListener) throws RemoteException;

    void unregisterCarTyreListener(IALCarTyreListener iALCarTyreListener) throws RemoteException;

    void unregisterCarWindListener(IALCarWindListener iALCarWindListener) throws RemoteException;

    void unregisterExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) throws RemoteException;

    void unregisterHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) throws RemoteException;

    void unregisterVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) throws RemoteException;

    public static abstract class Stub extends Binder implements IALCar {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.car.IALCar";
        static final int TRANSACTION_controlFraganceConcentration = 14;
        static final int TRANSACTION_controlUltravioletLuminance = 13;
        static final int TRANSACTION_factoryResetForAL = 10;
        static final int TRANSACTION_getFloatProperty = 9;
        static final int TRANSACTION_getIntProperty = 2;
        static final int TRANSACTION_registerAVMPropertyListener = 7;
        static final int TRANSACTION_registerCarEngineSpeedListener = 25;
        static final int TRANSACTION_registerCarSpeedListener = 17;
        static final int TRANSACTION_registerCarSteerListener = 19;
        static final int TRANSACTION_registerCarTyreListener = 21;
        static final int TRANSACTION_registerCarWindListener = 23;
        static final int TRANSACTION_registerExtPropertyListener = 15;
        static final int TRANSACTION_registerHvacPropertyListener = 3;
        static final int TRANSACTION_registerVehicleControlPropertyListener = 5;
        static final int TRANSACTION_sendChargeTime = 28;
        static final int TRANSACTION_sendFrontCrashWarningSignals = 33;
        static final int TRANSACTION_sendHVACsignalsForSmartScene = 27;
        static final int TRANSACTION_sendIHU03signals = 32;
        static final int TRANSACTION_sendIHU11signals = 31;
        static final int TRANSACTION_sendTboxSignalGroupForT1J = 29;
        static final int TRANSACTION_sendTboxSignalGroupForT1P = 30;
        static final int TRANSACTION_setGroupPropertyForHUD = 39;
        static final int TRANSACTION_setGroupPropertyForIHU14SUB1 = 42;
        static final int TRANSACTION_setGroupPropertyForIHU14SUB2 = 43;
        static final int TRANSACTION_setGroupPropertyForIHU14SUB3 = 44;
        static final int TRANSACTION_setGroupPropertyForIHU14SUB4 = 45;
        static final int TRANSACTION_setGroupPropertyForIHUDVR1 = 36;
        static final int TRANSACTION_setGroupPropertyForIHUDVR2 = 37;
        static final int TRANSACTION_setGroupPropertyForIHUDVR3 = 38;
        static final int TRANSACTION_setGroupPropertyForIHUDVRT1L = 40;
        static final int TRANSACTION_setGroupPropertyForMusicLoud = 34;
        static final int TRANSACTION_setIntProperty = 1;
        static final int TRANSACTION_setIntPropertyReduceLog = 11;
        static final int TRANSACTION_setMultiWindow = 12;
        static final int TRANSACTION_setT1KMirrorFlip = 35;
        static final int TRANSACTION_setT1PSeatHeatAndVentilation = 41;
        static final int TRANSACTION_unregisterAVMPropertyListener = 8;
        static final int TRANSACTION_unregisterCarEngineSpeedListener = 26;
        static final int TRANSACTION_unregisterCarSpeedListener = 18;
        static final int TRANSACTION_unregisterCarSteerListener = 20;
        static final int TRANSACTION_unregisterCarTyreListener = 22;
        static final int TRANSACTION_unregisterCarWindListener = 24;
        static final int TRANSACTION_unregisterExtPropertyListener = 16;
        static final int TRANSACTION_unregisterHvacPropertyListener = 4;
        static final int TRANSACTION_unregisterVehicleControlPropertyListener = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALCar asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALCar)) {
                return (IALCar) queryLocalInterface;
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
                    int intProperty = setIntProperty(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(intProperty);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int intProperty2 = getIntProperty(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(intProperty2);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerHvacPropertyListener(IALCarHvacPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterHvacPropertyListener(IALCarHvacPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerVehicleControlPropertyListener(IALCarVehicleControlPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterVehicleControlPropertyListener(IALCarVehicleControlPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAVMPropertyListener(IALCarAVMPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAVMPropertyListener(IALCarAVMPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    float floatProperty = getFloatProperty(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeFloat(floatProperty);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    factoryResetForAL();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int intPropertyReduceLog = setIntPropertyReduceLog(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(intPropertyReduceLog);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMultiWindow(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    controlUltravioletLuminance(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    controlFraganceConcentration(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerExtPropertyListener(IALCarExtPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterExtPropertyListener(IALCarExtPropertyListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCarSpeedListener(IALCarSpeedListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCarSpeedListener(IALCarSpeedListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCarSteerListener(IALCarSteerListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCarSteerListener(IALCarSteerListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCarTyreListener(IALCarTyreListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCarTyreListener(IALCarTyreListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCarWindListener(IALCarWindListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCarWindListener(IALCarWindListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCarEngineSpeedListener(IALCarEngineSpeedListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCarEngineSpeedListener(IALCarEngineSpeedListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendHVACsignalsForSmartScene(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendChargeTime(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendTboxSignalGroupForT1J(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendTboxSignalGroupForT1P(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendIHU11signals(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendIHU03signals(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendFrontCrashWarningSignals(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForMusicLoud(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    setT1KMirrorFlip(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHUDVR1(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHUDVR2(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHUDVR3(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForHUD(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHUDVRT1L(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    setT1PSeatHeatAndVentilation(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHU14SUB1(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHU14SUB2(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHU14SUB3(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupPropertyForIHU14SUB4(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IALCar {
            public static IALCar sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.car.IALCar
            public int setIntProperty(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setIntProperty(i, i2, i3);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public int getIntProperty(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getIntProperty(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarHvacPropertyListener != null ? iALCarHvacPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerHvacPropertyListener(iALCarHvacPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterHvacPropertyListener(IALCarHvacPropertyListener iALCarHvacPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarHvacPropertyListener != null ? iALCarHvacPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterHvacPropertyListener(iALCarHvacPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarVehicleControlPropertyListener != null ? iALCarVehicleControlPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerVehicleControlPropertyListener(iALCarVehicleControlPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterVehicleControlPropertyListener(IALCarVehicleControlPropertyListener iALCarVehicleControlPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarVehicleControlPropertyListener != null ? iALCarVehicleControlPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterVehicleControlPropertyListener(iALCarVehicleControlPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarAVMPropertyListener != null ? iALCarAVMPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAVMPropertyListener(iALCarAVMPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterAVMPropertyListener(IALCarAVMPropertyListener iALCarAVMPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarAVMPropertyListener != null ? iALCarAVMPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAVMPropertyListener(iALCarAVMPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public float getFloatProperty(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFloatProperty(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void factoryResetForAL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().factoryResetForAL();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public int setIntPropertyReduceLog(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setIntPropertyReduceLog(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setMultiWindow(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMultiWindow(i, i2, i3, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void controlUltravioletLuminance(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().controlUltravioletLuminance(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void controlFraganceConcentration(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().controlFraganceConcentration(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarExtPropertyListener != null ? iALCarExtPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerExtPropertyListener(iALCarExtPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterExtPropertyListener(IALCarExtPropertyListener iALCarExtPropertyListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarExtPropertyListener != null ? iALCarExtPropertyListener.asBinder() : null);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterExtPropertyListener(iALCarExtPropertyListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarSpeedListener != null ? iALCarSpeedListener.asBinder() : null);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCarSpeedListener(iALCarSpeedListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterCarSpeedListener(IALCarSpeedListener iALCarSpeedListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarSpeedListener != null ? iALCarSpeedListener.asBinder() : null);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCarSpeedListener(iALCarSpeedListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerCarSteerListener(IALCarSteerListener iALCarSteerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarSteerListener != null ? iALCarSteerListener.asBinder() : null);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCarSteerListener(iALCarSteerListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterCarSteerListener(IALCarSteerListener iALCarSteerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarSteerListener != null ? iALCarSteerListener.asBinder() : null);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCarSteerListener(iALCarSteerListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerCarTyreListener(IALCarTyreListener iALCarTyreListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarTyreListener != null ? iALCarTyreListener.asBinder() : null);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCarTyreListener(iALCarTyreListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterCarTyreListener(IALCarTyreListener iALCarTyreListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarTyreListener != null ? iALCarTyreListener.asBinder() : null);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCarTyreListener(iALCarTyreListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerCarWindListener(IALCarWindListener iALCarWindListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarWindListener != null ? iALCarWindListener.asBinder() : null);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCarWindListener(iALCarWindListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterCarWindListener(IALCarWindListener iALCarWindListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarWindListener != null ? iALCarWindListener.asBinder() : null);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCarWindListener(iALCarWindListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void registerCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarEngineSpeedListener != null ? iALCarEngineSpeedListener.asBinder() : null);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCarEngineSpeedListener(iALCarEngineSpeedListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void unregisterCarEngineSpeedListener(IALCarEngineSpeedListener iALCarEngineSpeedListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iALCarEngineSpeedListener != null ? iALCarEngineSpeedListener.asBinder() : null);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCarEngineSpeedListener(iALCarEngineSpeedListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void sendHVACsignalsForSmartScene(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendHVACsignalsForSmartScene(bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void sendChargeTime(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendChargeTime(i, i2, i3, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void sendTboxSignalGroupForT1J(int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.mRemote.transact(29, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendTboxSignalGroupForT1J(i, i2, i3, i4, i5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void sendTboxSignalGroupForT1P(int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.mRemote.transact(30, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendTboxSignalGroupForT1P(i, i2, i3, i4, i5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void sendIHU11signals(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendIHU11signals(bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void sendIHU03signals(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendIHU03signals(bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void sendFrontCrashWarningSignals(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(33, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendFrontCrashWarningSignals(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForMusicLoud(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForMusicLoud(bArr);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setT1KMirrorFlip(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(35, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setT1KMirrorFlip(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHUDVR1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHUDVR1(i, i2, i3, i4, i5, i6, i7, i8);
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

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHUDVR2(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHUDVR2(i, i2, i3, i4, i5, i6, i7, i8);
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

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHUDVR3(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHUDVR3(i, i2, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForHUD(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.mRemote.transact(39, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForHUD(i, i2, i3, i4, i5, i6, i7, i8);
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

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHUDVRT1L(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    obtain.writeInt(i8);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.mRemote.transact(40, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHUDVRT1L(i, i2, i3, i4, i5, i6, i7, i8);
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

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setT1PSeatHeatAndVentilation(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(41, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setT1PSeatHeatAndVentilation(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHU14SUB1(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(42, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHU14SUB1(i, i2, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHU14SUB2(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(43, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHU14SUB2(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHU14SUB3(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(44, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHU14SUB3(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.car.IALCar
            public void setGroupPropertyForIHU14SUB4(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(45, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupPropertyForIHU14SUB4(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALCar iALCar) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALCar == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALCar;
            return true;
        }

        public static IALCar getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
