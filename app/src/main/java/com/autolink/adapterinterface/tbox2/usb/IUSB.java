package com.autolink.adapterinterface.tbox2.usb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autolink.adapterinterface.tbox2.usb.IUSBCallback;

/* loaded from: classes.dex */
public interface IUSB extends IInterface {

    public static class Default implements IUSB {
        @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
        public void SubNodeStartFactory(byte b) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
        public void registerCallback(IUSBCallback iUSBCallback) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
        public void subNodeEnterFactory(TboxUsbSubNodeEnterFactoryInfo tboxUsbSubNodeEnterFactoryInfo) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
        public void unregisterCallback(IUSBCallback iUSBCallback) throws RemoteException {
        }
    }

    void SubNodeStartFactory(byte b) throws RemoteException;

    void registerCallback(IUSBCallback iUSBCallback) throws RemoteException;

    void subNodeEnterFactory(TboxUsbSubNodeEnterFactoryInfo tboxUsbSubNodeEnterFactoryInfo) throws RemoteException;

    void unregisterCallback(IUSBCallback iUSBCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IUSB {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.tbox2.usb.IUSB";
        static final int TRANSACTION_SubNodeStartFactory = 2;
        static final int TRANSACTION_registerCallback = 3;
        static final int TRANSACTION_subNodeEnterFactory = 1;
        static final int TRANSACTION_unregisterCallback = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IUSB asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUSB)) {
                return (IUSB) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                subNodeEnterFactory(parcel.readInt() != 0 ? TboxUsbSubNodeEnterFactoryInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                SubNodeStartFactory(parcel.readByte());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                registerCallback(IUSBCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            unregisterCallback(IUSBCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IUSB {
            public static IUSB sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
            public void subNodeEnterFactory(TboxUsbSubNodeEnterFactoryInfo tboxUsbSubNodeEnterFactoryInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (tboxUsbSubNodeEnterFactoryInfo != null) {
                        obtain.writeInt(1);
                        tboxUsbSubNodeEnterFactoryInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().subNodeEnterFactory(tboxUsbSubNodeEnterFactoryInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
            public void SubNodeStartFactory(byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().SubNodeStartFactory(b);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
            public void registerCallback(IUSBCallback iUSBCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iUSBCallback != null ? iUSBCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallback(iUSBCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.tbox2.usb.IUSB
            public void unregisterCallback(IUSBCallback iUSBCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iUSBCallback != null ? iUSBCallback.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallback(iUSBCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IUSB iusb) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iusb == null) {
                return false;
            }
            Proxy.sDefaultImpl = iusb;
            return true;
        }

        public static IUSB getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
