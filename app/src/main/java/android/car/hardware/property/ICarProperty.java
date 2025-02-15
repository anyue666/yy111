package android.car.hardware.property;

import android.car.hardware.CarPropertyConfig;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.property.ICarPropertyEventListener;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarProperty extends IInterface {

    public static class Default implements ICarProperty {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.hardware.property.ICarProperty
        public CarPropertyValue getProperty(int i, int i2) throws RemoteException {
            return null;
        }

        @Override // android.car.hardware.property.ICarProperty
        public List<CarPropertyConfig> getPropertyList() throws RemoteException {
            return null;
        }

        @Override // android.car.hardware.property.ICarProperty
        public String getReadPermission(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.hardware.property.ICarProperty
        public String getWritePermission(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.hardware.property.ICarProperty
        public void registerListener(int i, float f, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException {
        }

        @Override // android.car.hardware.property.ICarProperty
        public void setProperty(CarPropertyValue carPropertyValue, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException {
        }

        @Override // android.car.hardware.property.ICarProperty
        public void unregisterListener(int i, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException {
        }
    }

    CarPropertyValue getProperty(int i, int i2) throws RemoteException;

    List<CarPropertyConfig> getPropertyList() throws RemoteException;

    String getReadPermission(int i) throws RemoteException;

    String getWritePermission(int i) throws RemoteException;

    void registerListener(int i, float f, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException;

    void setProperty(CarPropertyValue carPropertyValue, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException;

    void unregisterListener(int i, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarProperty {
        private static final String DESCRIPTOR = "android.car.hardware.property.ICarProperty";
        static final int TRANSACTION_getProperty = 4;
        static final int TRANSACTION_getPropertyList = 3;
        static final int TRANSACTION_getReadPermission = 6;
        static final int TRANSACTION_getWritePermission = 7;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_setProperty = 5;
        static final int TRANSACTION_unregisterListener = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarProperty asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarProperty)) {
                return (ICarProperty) queryLocalInterface;
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
                    registerListener(parcel.readInt(), parcel.readFloat(), ICarPropertyEventListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterListener(parcel.readInt(), ICarPropertyEventListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<CarPropertyConfig> propertyList = getPropertyList();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(propertyList);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    CarPropertyValue property = getProperty(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (property != null) {
                        parcel2.writeInt(1);
                        property.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    setProperty(parcel.readInt() != 0 ? CarPropertyValue.CREATOR.createFromParcel(parcel) : null, ICarPropertyEventListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String readPermission = getReadPermission(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(readPermission);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    String writePermission = getWritePermission(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(writePermission);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarProperty {
            public static ICarProperty sDefaultImpl;
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

            @Override // android.car.hardware.property.ICarProperty
            public void registerListener(int i, float f, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeFloat(f);
                    obtain.writeStrongBinder(iCarPropertyEventListener != null ? iCarPropertyEventListener.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListener(i, f, iCarPropertyEventListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.property.ICarProperty
            public void unregisterListener(int i, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iCarPropertyEventListener != null ? iCarPropertyEventListener.asBinder() : null);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterListener(i, iCarPropertyEventListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.property.ICarProperty
            public List<CarPropertyConfig> getPropertyList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPropertyList();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(CarPropertyConfig.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.property.ICarProperty
            public CarPropertyValue getProperty(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getProperty(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CarPropertyValue.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.property.ICarProperty
            public void setProperty(CarPropertyValue carPropertyValue, ICarPropertyEventListener iCarPropertyEventListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (carPropertyValue != null) {
                        obtain.writeInt(1);
                        carPropertyValue.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iCarPropertyEventListener != null ? iCarPropertyEventListener.asBinder() : null);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setProperty(carPropertyValue, iCarPropertyEventListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.property.ICarProperty
            public String getReadPermission(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getReadPermission(i);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.hardware.property.ICarProperty
            public String getWritePermission(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWritePermission(i);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarProperty iCarProperty) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarProperty == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarProperty;
            return true;
        }

        public static ICarProperty getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
