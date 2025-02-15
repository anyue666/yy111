package com.autolink.adapterinterface.audio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IRhythmLampListener extends IInterface {

    public static class Default implements IRhythmLampListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
        public void onRhythmChanged(int[] iArr) throws RemoteException {
        }

        @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
        public void onRhythmStateChange(boolean z) throws RemoteException {
        }
    }

    void onRhythmChanged(int[] iArr) throws RemoteException;

    void onRhythmStateChange(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IRhythmLampListener {
        private static final String DESCRIPTOR = "com.autolink.adapterinterface.audio.IRhythmLampListener";
        static final int TRANSACTION_onRhythmChanged = 1;
        static final int TRANSACTION_onRhythmStateChange = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRhythmLampListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRhythmLampListener)) {
                return (IRhythmLampListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onRhythmChanged(parcel.createIntArray());
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onRhythmStateChange(parcel.readInt() != 0);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IRhythmLampListener {
            public static IRhythmLampListener sDefaultImpl;
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

            @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
            public void onRhythmChanged(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRhythmChanged(iArr);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.autolink.adapterinterface.audio.IRhythmLampListener
            public void onRhythmStateChange(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRhythmStateChange(z);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IRhythmLampListener iRhythmLampListener) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iRhythmLampListener == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRhythmLampListener;
            return true;
        }

        public static IRhythmLampListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
