package com.autonavi.amapauto.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IJsonProtocolReceiveInterface.java */
/* loaded from: classes.dex */
public interface b extends IInterface {
    void received(String str) throws RemoteException;

    String receivedSync(String str) throws RemoteException;

    /* compiled from: IJsonProtocolReceiveInterface.java */
    public static abstract class a extends Binder implements b {
        private static final String DESCRIPTOR = "com.autonavi.amapauto.aidl.IJsonProtocolReceiveInterface";
        static final int TRANSACTION_received = 1;
        static final int TRANSACTION_receivedSync = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0008a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                received(parcel.readString());
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
            String receivedSync = receivedSync(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(receivedSync);
            return true;
        }

        /* compiled from: IJsonProtocolReceiveInterface.java */
        /* renamed from: com.autonavi.amapauto.a.b$a$a, reason: collision with other inner class name */
        private static class C0008a implements b {
            private IBinder a;

            C0008a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.autonavi.amapauto.a.b
            public void received(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autonavi.amapauto.a.b
            public String receivedSync(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
