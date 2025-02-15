package android.car.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICarAudioFocusCallback extends IInterface {

    public static class Default implements ICarAudioFocusCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.media.ICarAudioFocusCallback
        public void onAudioFocusGrant(String str, int i, int i2, int i3) throws RemoteException {
        }

        @Override // android.car.media.ICarAudioFocusCallback
        public void onAudioFocusLoss(String str, int i, int i2, boolean z) throws RemoteException {
        }
    }

    void onAudioFocusGrant(String str, int i, int i2, int i3) throws RemoteException;

    void onAudioFocusLoss(String str, int i, int i2, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarAudioFocusCallback {
        private static final String DESCRIPTOR = "android.car.media.ICarAudioFocusCallback";
        static final int TRANSACTION_onAudioFocusGrant = 1;
        static final int TRANSACTION_onAudioFocusLoss = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarAudioFocusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarAudioFocusCallback)) {
                return (ICarAudioFocusCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onAudioFocusGrant(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAudioFocusLoss(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarAudioFocusCallback {
            public static ICarAudioFocusCallback sDefaultImpl;
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

            @Override // android.car.media.ICarAudioFocusCallback
            public void onAudioFocusGrant(String str, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAudioFocusGrant(str, i, i2, i3);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudioFocusCallback
            public void onAudioFocusLoss(String str, int i, int i2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onAudioFocusLoss(str, i, i2, z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarAudioFocusCallback iCarAudioFocusCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarAudioFocusCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarAudioFocusCallback;
            return true;
        }

        public static ICarAudioFocusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
