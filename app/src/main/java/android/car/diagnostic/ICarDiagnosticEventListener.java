package android.car.diagnostic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarDiagnosticEventListener extends IInterface {

    public static class Default implements ICarDiagnosticEventListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.diagnostic.ICarDiagnosticEventListener
        public void onDiagnosticEvents(List<CarDiagnosticEvent> list) throws RemoteException {
        }
    }

    void onDiagnosticEvents(List<CarDiagnosticEvent> list) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarDiagnosticEventListener {
        private static final String DESCRIPTOR = "android.car.diagnostic.ICarDiagnosticEventListener";
        static final int TRANSACTION_onDiagnosticEvents = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarDiagnosticEventListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarDiagnosticEventListener)) {
                return (ICarDiagnosticEventListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onDiagnosticEvents(parcel.createTypedArrayList(CarDiagnosticEvent.CREATOR));
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ICarDiagnosticEventListener {
            public static ICarDiagnosticEventListener sDefaultImpl;
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

            @Override // android.car.diagnostic.ICarDiagnosticEventListener
            public void onDiagnosticEvents(List<CarDiagnosticEvent> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onDiagnosticEvents(list);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarDiagnosticEventListener iCarDiagnosticEventListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarDiagnosticEventListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarDiagnosticEventListener;
            return true;
        }

        public static ICarDiagnosticEventListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
