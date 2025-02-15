package com.autonavi.amapauto.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.autonavi.amapauto.a.b;

/* compiled from: IJsonProtocolInterface.java */
/* loaded from: classes.dex */
public interface a extends IInterface {
    void a(String str, b bVar) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void b(String str, b bVar) throws RemoteException;

    /* compiled from: IJsonProtocolInterface.java */
    /* renamed from: com.autonavi.amapauto.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0006a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0007a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
                a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
                a(parcel.readString(), b.a.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
            b(parcel.readString(), b.a.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* compiled from: IJsonProtocolInterface.java */
        /* renamed from: com.autonavi.amapauto.a.a$a$a, reason: collision with other inner class name */
        private static class C0007a implements a {
            private IBinder a;

            C0007a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.autonavi.amapauto.a.a
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autonavi.amapauto.a.a
            public void a(String str, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.autonavi.amapauto.a.a
            public void b(String str, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.autonavi.amapauto.aidl.IJsonProtocolInterface");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
