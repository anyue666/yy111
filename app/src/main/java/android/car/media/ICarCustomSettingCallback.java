package android.car.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarCustomSettingCallback extends IInterface {

    public static class Default implements ICarCustomSettingCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.media.ICarCustomSettingCallback
        public void onEnableChanged(int i, int i2, boolean z) throws RemoteException {
        }

        @Override // android.car.media.ICarCustomSettingCallback
        public void onValueChanged(int i, int i2, String[] strArr) throws RemoteException {
        }
    }

    void onEnableChanged(int i, int i2, boolean z) throws RemoteException;

    void onValueChanged(int i, int i2, String[] strArr) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarCustomSettingCallback {
        private static final String DESCRIPTOR = "android.car.media.ICarCustomSettingCallback";
        static final int TRANSACTION_onEnableChanged = 1;
        static final int TRANSACTION_onValueChanged = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarCustomSettingCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarCustomSettingCallback)) {
                return (ICarCustomSettingCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onEnableChanged(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onValueChanged(parcel.readInt(), parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarCustomSettingCallback {
            public static ICarCustomSettingCallback sDefaultImpl;
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

            @Override // android.car.media.ICarCustomSettingCallback
            public void onEnableChanged(int i, int i2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onEnableChanged(i, i2, z);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarCustomSettingCallback
            public void onValueChanged(int i, int i2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onValueChanged(i, i2, strArr);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarCustomSettingCallback iCarCustomSettingCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarCustomSettingCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarCustomSettingCallback;
            return true;
        }

        public static ICarCustomSettingCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
