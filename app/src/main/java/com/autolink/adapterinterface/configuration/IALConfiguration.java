package com.autolink.adapterinterface.configuration;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IALConfiguration extends IInterface {

    public static class Default implements IALConfiguration {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.configuration.IALConfiguration
        public void notifyUpdateTimeZone() throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.configuration.IALConfiguration
        public void updateCountryCodeForWifiAndTuner(int i) throws RemoteException {
        }
    }

    void notifyUpdateTimeZone() throws RemoteException;

    void updateCountryCodeForWifiAndTuner(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IALConfiguration {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.configuration.IALConfiguration";
        static final int TRANSACTION_notifyUpdateTimeZone = 2;
        static final int TRANSACTION_updateCountryCodeForWifiAndTuner = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IALConfiguration asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IALConfiguration)) {
                return (IALConfiguration) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                updateCountryCodeForWifiAndTuner(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            notifyUpdateTimeZone();
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IALConfiguration {
            public static IALConfiguration sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.configuration.IALConfiguration
            public void updateCountryCodeForWifiAndTuner(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateCountryCodeForWifiAndTuner(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.configuration.IALConfiguration
            public void notifyUpdateTimeZone() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notifyUpdateTimeZone();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IALConfiguration iALConfiguration) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iALConfiguration == null) {
                return false;
            }
            Proxy.sDefaultImpl = iALConfiguration;
            return true;
        }

        public static IALConfiguration getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
