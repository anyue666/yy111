package com.autolink.adapterinterface.clusterinteraction;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IDmsCallback extends IInterface {

    public static class Default implements IDmsCallback {
        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void activationLicenseResp() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void androidSetupCompleteResp(int i, int i2) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void bloodOxygenResultResp(boolean z, int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void cameraOcclusionValueResp(boolean z, boolean z2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void cameraStatusResp(int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void distractionLevelValueResp(boolean z, int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void driverActionValueResp(boolean z, int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void driverMissingValueResp(boolean z, boolean z2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void drowsinessLevelValueResp(boolean z, int i) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void faceIdResp(int i, int i2, int i3) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void faceStatusResultResp(boolean z) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void healthLoginResp(boolean z, int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void healthRateResultResp(boolean z, float f) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void heartRateVarResultResp(boolean z, float f) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void pressureResultResp(boolean z, int i, int i2) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void respiratoryRateResultResp(boolean z, float f) throws RemoteException {
        }
    }

    void activationLicenseResp() throws RemoteException;

    void androidSetupCompleteResp(int i, int i2) throws RemoteException;

    void bloodOxygenResultResp(boolean z, int i) throws RemoteException;

    void cameraOcclusionValueResp(boolean z, boolean z2) throws RemoteException;

    void cameraStatusResp(int i, int i2) throws RemoteException;

    void distractionLevelValueResp(boolean z, int i) throws RemoteException;

    void driverActionValueResp(boolean z, int i) throws RemoteException;

    void driverMissingValueResp(boolean z, boolean z2) throws RemoteException;

    void drowsinessLevelValueResp(boolean z, int i) throws RemoteException;

    void faceIdResp(int i, int i2, int i3) throws RemoteException;

    void faceStatusResultResp(boolean z) throws RemoteException;

    void healthLoginResp(boolean z, int i, int i2) throws RemoteException;

    void healthRateResultResp(boolean z, float f) throws RemoteException;

    void heartRateVarResultResp(boolean z, float f) throws RemoteException;

    void pressureResultResp(boolean z, int i, int i2) throws RemoteException;

    void respiratoryRateResultResp(boolean z, float f) throws RemoteException;

    public static abstract class Stub extends Binder implements IDmsCallback {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.clusterinteraction.IDmsCallback";
        static final int TRANSACTION_activationLicenseResp = 15;
        static final int TRANSACTION_androidSetupCompleteResp = 12;
        static final int TRANSACTION_bloodOxygenResultResp = 6;
        static final int TRANSACTION_cameraOcclusionValueResp = 9;
        static final int TRANSACTION_cameraStatusResp = 14;
        static final int TRANSACTION_distractionLevelValueResp = 10;
        static final int TRANSACTION_driverActionValueResp = 7;
        static final int TRANSACTION_driverMissingValueResp = 8;
        static final int TRANSACTION_drowsinessLevelValueResp = 11;
        static final int TRANSACTION_faceIdResp = 1;
        static final int TRANSACTION_faceStatusResultResp = 16;
        static final int TRANSACTION_healthLoginResp = 13;
        static final int TRANSACTION_healthRateResultResp = 2;
        static final int TRANSACTION_heartRateVarResultResp = 3;
        static final int TRANSACTION_pressureResultResp = 5;
        static final int TRANSACTION_respiratoryRateResultResp = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDmsCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDmsCallback)) {
                return (IDmsCallback) queryLocalInterface;
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
                    faceIdResp(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    healthRateResultResp(parcel.readInt() != 0, parcel.readFloat());
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    heartRateVarResultResp(parcel.readInt() != 0, parcel.readFloat());
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    respiratoryRateResultResp(parcel.readInt() != 0, parcel.readFloat());
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    pressureResultResp(parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    bloodOxygenResultResp(parcel.readInt() != 0, parcel.readInt());
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    driverActionValueResp(parcel.readInt() != 0, parcel.readInt());
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    driverMissingValueResp(parcel.readInt() != 0, parcel.readInt() != 0);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    cameraOcclusionValueResp(parcel.readInt() != 0, parcel.readInt() != 0);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    distractionLevelValueResp(parcel.readInt() != 0, parcel.readInt());
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    drowsinessLevelValueResp(parcel.readInt() != 0, parcel.readInt());
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    androidSetupCompleteResp(parcel.readInt(), parcel.readInt());
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    healthLoginResp(parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    cameraStatusResp(parcel.readInt(), parcel.readInt());
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    activationLicenseResp();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    faceStatusResultResp(parcel.readInt() != 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IDmsCallback {
            public static IDmsCallback sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceIdResp(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().faceIdResp(i, i2, i3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthRateResultResp(boolean z, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().healthRateResultResp(z, f);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void heartRateVarResultResp(boolean z, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().heartRateVarResultResp(z, f);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void respiratoryRateResultResp(boolean z, float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().respiratoryRateResultResp(z, f);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void pressureResultResp(boolean z, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(5, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().pressureResultResp(z, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void bloodOxygenResultResp(boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(6, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().bloodOxygenResultResp(z, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverActionValueResp(boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(7, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().driverActionValueResp(z, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverMissingValueResp(boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(8, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().driverMissingValueResp(z, z2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraOcclusionValueResp(boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (this.mRemote.transact(9, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().cameraOcclusionValueResp(z, z2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void distractionLevelValueResp(boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(10, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().distractionLevelValueResp(z, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void drowsinessLevelValueResp(boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(11, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().drowsinessLevelValueResp(z, i);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void androidSetupCompleteResp(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(12, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().androidSetupCompleteResp(i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthLoginResp(boolean z, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(13, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().healthLoginResp(z, i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(14, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().cameraStatusResp(i, i2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void activationLicenseResp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(15, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().activationLicenseResp();
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceStatusResultResp(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(16, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().faceStatusResultResp(z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDmsCallback iDmsCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDmsCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDmsCallback;
            return true;
        }

        public static IDmsCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
