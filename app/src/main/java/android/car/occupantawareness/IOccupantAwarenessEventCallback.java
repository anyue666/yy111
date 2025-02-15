package android.car.occupantawareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOccupantAwarenessEventCallback extends IInterface {

    public static class Default implements IOccupantAwarenessEventCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.occupantawareness.IOccupantAwarenessEventCallback
        public void onDetectionEvent(OccupantAwarenessDetection occupantAwarenessDetection) throws RemoteException {
        }

        @Override // android.car.occupantawareness.IOccupantAwarenessEventCallback
        public void onStatusChanged(SystemStatusEvent systemStatusEvent) throws RemoteException {
        }
    }

    void onDetectionEvent(OccupantAwarenessDetection occupantAwarenessDetection) throws RemoteException;

    void onStatusChanged(SystemStatusEvent systemStatusEvent) throws RemoteException;

    public static abstract class Stub extends Binder implements IOccupantAwarenessEventCallback {
        private static final String DESCRIPTOR = "android.car.occupantawareness.IOccupantAwarenessEventCallback";
        static final int TRANSACTION_onDetectionEvent = 2;
        static final int TRANSACTION_onStatusChanged = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOccupantAwarenessEventCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOccupantAwarenessEventCallback)) {
                return (IOccupantAwarenessEventCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onStatusChanged(parcel.readInt() != 0 ? SystemStatusEvent.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onDetectionEvent(parcel.readInt() != 0 ? OccupantAwarenessDetection.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IOccupantAwarenessEventCallback {
            public static IOccupantAwarenessEventCallback sDefaultImpl;
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

            @Override // android.car.occupantawareness.IOccupantAwarenessEventCallback
            public void onStatusChanged(SystemStatusEvent systemStatusEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (systemStatusEvent != null) {
                        obtain.writeInt(1);
                        systemStatusEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onStatusChanged(systemStatusEvent);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.car.occupantawareness.IOccupantAwarenessEventCallback
            public void onDetectionEvent(OccupantAwarenessDetection occupantAwarenessDetection) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (occupantAwarenessDetection != null) {
                        obtain.writeInt(1);
                        occupantAwarenessDetection.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDetectionEvent(occupantAwarenessDetection);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOccupantAwarenessEventCallback iOccupantAwarenessEventCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOccupantAwarenessEventCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOccupantAwarenessEventCallback;
            return true;
        }

        public static IOccupantAwarenessEventCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
