package android.car.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarExtVolumeCallback extends IInterface {

    public static class Default implements ICarExtVolumeCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.media.ICarExtVolumeCallback
        public void onGroupMuteChanged(int i, int i2, boolean z, int i3) throws RemoteException {
        }

        @Override // android.car.media.ICarExtVolumeCallback
        public void onGroupVolumeChanged(int i, int i2, int i3, int i4) throws RemoteException {
        }
    }

    void onGroupMuteChanged(int i, int i2, boolean z, int i3) throws RemoteException;

    void onGroupVolumeChanged(int i, int i2, int i3, int i4) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarExtVolumeCallback {
        private static final String DESCRIPTOR = "android.car.media.ICarExtVolumeCallback";
        static final int TRANSACTION_onGroupMuteChanged = 2;
        static final int TRANSACTION_onGroupVolumeChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarExtVolumeCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarExtVolumeCallback)) {
                return (ICarExtVolumeCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onGroupVolumeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onGroupMuteChanged(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarExtVolumeCallback {
            public static ICarExtVolumeCallback sDefaultImpl;
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

            @Override // android.car.media.ICarExtVolumeCallback
            public void onGroupVolumeChanged(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onGroupVolumeChanged(i, i2, i3, i4);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarExtVolumeCallback
            public void onGroupMuteChanged(int i, int i2, boolean z, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onGroupMuteChanged(i, i2, z, i3);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarExtVolumeCallback iCarExtVolumeCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarExtVolumeCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarExtVolumeCallback;
            return true;
        }

        public static ICarExtVolumeCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
