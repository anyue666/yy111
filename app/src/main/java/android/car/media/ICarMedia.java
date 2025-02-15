package android.car.media;

import android.car.media.ICarMediaSourceListener;
import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarMedia extends IInterface {

    public static class Default implements ICarMedia {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.media.ICarMedia
        public List<ComponentName> getLastMediaSources(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarMedia
        public ComponentName getMediaSource(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarMedia
        public boolean isIndependentPlaybackConfig() throws RemoteException {
            return false;
        }

        @Override // android.car.media.ICarMedia
        public void registerMediaSourceListener(ICarMediaSourceListener iCarMediaSourceListener, int i) throws RemoteException {
        }

        @Override // android.car.media.ICarMedia
        public void setIndependentPlaybackConfig(boolean z) throws RemoteException {
        }

        @Override // android.car.media.ICarMedia
        public void setMediaSource(ComponentName componentName, int i) throws RemoteException {
        }

        @Override // android.car.media.ICarMedia
        public void unregisterMediaSourceListener(ICarMediaSourceListener iCarMediaSourceListener, int i) throws RemoteException {
        }
    }

    List<ComponentName> getLastMediaSources(int i) throws RemoteException;

    ComponentName getMediaSource(int i) throws RemoteException;

    boolean isIndependentPlaybackConfig() throws RemoteException;

    void registerMediaSourceListener(ICarMediaSourceListener iCarMediaSourceListener, int i) throws RemoteException;

    void setIndependentPlaybackConfig(boolean z) throws RemoteException;

    void setMediaSource(ComponentName componentName, int i) throws RemoteException;

    void unregisterMediaSourceListener(ICarMediaSourceListener iCarMediaSourceListener, int i) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarMedia {
        private static final String DESCRIPTOR = "android.car.media.ICarMedia";
        static final int TRANSACTION_getLastMediaSources = 5;
        static final int TRANSACTION_getMediaSource = 1;
        static final int TRANSACTION_isIndependentPlaybackConfig = 6;
        static final int TRANSACTION_registerMediaSourceListener = 3;
        static final int TRANSACTION_setIndependentPlaybackConfig = 7;
        static final int TRANSACTION_setMediaSource = 2;
        static final int TRANSACTION_unregisterMediaSourceListener = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarMedia asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarMedia)) {
                return (ICarMedia) queryLocalInterface;
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
                    ComponentName mediaSource = getMediaSource(parcel.readInt());
                    parcel2.writeNoException();
                    if (mediaSource != null) {
                        parcel2.writeInt(1);
                        mediaSource.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMediaSource(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerMediaSourceListener(ICarMediaSourceListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterMediaSourceListener(ICarMediaSourceListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<ComponentName> lastMediaSources = getLastMediaSources(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(lastMediaSources);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isIndependentPlaybackConfig = isIndependentPlaybackConfig();
                    parcel2.writeNoException();
                    parcel2.writeInt(isIndependentPlaybackConfig ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setIndependentPlaybackConfig(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarMedia {
            public static ICarMedia sDefaultImpl;
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

            @Override // android.car.media.ICarMedia
            public ComponentName getMediaSource(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMediaSource(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarMedia
            public void setMediaSource(ComponentName componentName, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setMediaSource(componentName, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarMedia
            public void registerMediaSourceListener(ICarMediaSourceListener iCarMediaSourceListener, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarMediaSourceListener != null ? iCarMediaSourceListener.asBinder() : null);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerMediaSourceListener(iCarMediaSourceListener, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarMedia
            public void unregisterMediaSourceListener(ICarMediaSourceListener iCarMediaSourceListener, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCarMediaSourceListener != null ? iCarMediaSourceListener.asBinder() : null);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterMediaSourceListener(iCarMediaSourceListener, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarMedia
            public List<ComponentName> getLastMediaSources(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLastMediaSources(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ComponentName.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarMedia
            public boolean isIndependentPlaybackConfig() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isIndependentPlaybackConfig();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarMedia
            public void setIndependentPlaybackConfig(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setIndependentPlaybackConfig(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarMedia iCarMedia) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarMedia == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarMedia;
            return true;
        }

        public static ICarMedia getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
