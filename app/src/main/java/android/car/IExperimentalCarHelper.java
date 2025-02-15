package android.car;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IExperimentalCarHelper extends IInterface {

    public static class Default implements IExperimentalCarHelper {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.IExperimentalCarHelper
        public void onInitComplete(List<String> list, List<String> list2, List<String> list3, List<IBinder> list4) throws RemoteException {
        }
    }

    void onInitComplete(List<String> list, List<String> list2, List<String> list3, List<IBinder> list4) throws RemoteException;

    public static abstract class Stub extends Binder implements IExperimentalCarHelper {
        private static final String DESCRIPTOR = "android.car.IExperimentalCarHelper";
        static final int TRANSACTION_onInitComplete = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IExperimentalCarHelper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IExperimentalCarHelper)) {
                return (IExperimentalCarHelper) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            onInitComplete(parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.createBinderArrayList());
            parcel2.writeNoException();
            return true;
        }

        private static class Proxy implements IExperimentalCarHelper {
            public static IExperimentalCarHelper sDefaultImpl;
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

            @Override // android.car.IExperimentalCarHelper
            public void onInitComplete(List<String> list, List<String> list2, List<String> list3, List<IBinder> list4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    obtain.writeStringList(list2);
                    obtain.writeStringList(list3);
                    obtain.writeBinderList(list4);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInitComplete(list, list2, list3, list4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IExperimentalCarHelper iExperimentalCarHelper) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iExperimentalCarHelper == null) {
                return false;
            }
            Proxy.sDefaultImpl = iExperimentalCarHelper;
            return true;
        }

        public static IExperimentalCarHelper getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
