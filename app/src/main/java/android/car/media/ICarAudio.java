package android.car.media;

import android.media.AudioDeviceAttributes;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface ICarAudio extends IInterface {

    public static class Default implements ICarAudio {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public boolean clearZoneIdForUid(int i) throws RemoteException {
            return false;
        }

        @Override // android.car.media.ICarAudio
        public CarAudioPatchHandle createAudioPatch(String str, int i, int i2) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public int getActiveAudioFocusUsage(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public int[] getAudioZoneIds() throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public String[] getCustomSetting(int i, int i2, String[] strArr) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public String[] getExternalSources() throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public int getGroupDefaultVolume(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public int getGroupMaxVolume(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public int getGroupMinVolume(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public int getGroupVolume(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public List<AudioDeviceAttributes> getInputDevicesForZoneId(int i) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public String getOutputDeviceAddressForUsage(int i, int i2) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public int[] getUsagesForVolumeGroupId(int i, int i2) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public int getVolumeGroupCount(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public int getVolumeGroupIdForUsage(int i, int i2) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public int getZoneIdForUid(int i) throws RemoteException {
            return 0;
        }

        @Override // android.car.media.ICarAudio
        public boolean isDynamicRoutingEnabled() throws RemoteException {
            return false;
        }

        @Override // android.car.media.ICarAudio
        public boolean isGroupMute(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // android.car.media.ICarAudio
        public boolean isGroupMuteByPower(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // android.car.media.ICarAudio
        public boolean isGroupSupportMute(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // android.car.media.ICarAudio
        public void registerAudioFocusCallback(int i, IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void registerCustomSettingCallback(IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void registerExtVolumeCallback(IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void registerVolumeCallback(IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void releaseAudioPatch(CarAudioPatchHandle carAudioPatchHandle) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void setBalanceTowardRight(float f) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public String[] setCustomSetting(int i, int i2, String[] strArr) throws RemoteException {
            return null;
        }

        @Override // android.car.media.ICarAudio
        public void setEcnrConfiguration(int i, int i2) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void setFadeTowardFront(float f) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void setGroupMute(int i, int i2, boolean z, int i3) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void setGroupMuteByPower(int i, int i2, boolean z) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void setGroupVolume(int i, int i2, int i3, int i4) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public boolean setZoneIdForUid(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // android.car.media.ICarAudio
        public void unregisterAudioFocusCallback(int i, IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void unregisterCustomSettingCallback(IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void unregisterExtVolumeCallback(IBinder iBinder) throws RemoteException {
        }

        @Override // android.car.media.ICarAudio
        public void unregisterVolumeCallback(IBinder iBinder) throws RemoteException {
        }
    }

    boolean clearZoneIdForUid(int i) throws RemoteException;

    CarAudioPatchHandle createAudioPatch(String str, int i, int i2) throws RemoteException;

    int getActiveAudioFocusUsage(int i) throws RemoteException;

    int[] getAudioZoneIds() throws RemoteException;

    String[] getCustomSetting(int i, int i2, String[] strArr) throws RemoteException;

    String[] getExternalSources() throws RemoteException;

    int getGroupDefaultVolume(int i, int i2) throws RemoteException;

    int getGroupMaxVolume(int i, int i2) throws RemoteException;

    int getGroupMinVolume(int i, int i2) throws RemoteException;

    int getGroupVolume(int i, int i2) throws RemoteException;

    List<AudioDeviceAttributes> getInputDevicesForZoneId(int i) throws RemoteException;

    String getOutputDeviceAddressForUsage(int i, int i2) throws RemoteException;

    int[] getUsagesForVolumeGroupId(int i, int i2) throws RemoteException;

    int getVolumeGroupCount(int i) throws RemoteException;

    int getVolumeGroupIdForUsage(int i, int i2) throws RemoteException;

    int getZoneIdForUid(int i) throws RemoteException;

    boolean isDynamicRoutingEnabled() throws RemoteException;

    boolean isGroupMute(int i, int i2) throws RemoteException;

    boolean isGroupMuteByPower(int i, int i2) throws RemoteException;

    boolean isGroupSupportMute(int i, int i2) throws RemoteException;

    void registerAudioFocusCallback(int i, IBinder iBinder) throws RemoteException;

    void registerCustomSettingCallback(IBinder iBinder) throws RemoteException;

    void registerExtVolumeCallback(IBinder iBinder) throws RemoteException;

    void registerVolumeCallback(IBinder iBinder) throws RemoteException;

    void releaseAudioPatch(CarAudioPatchHandle carAudioPatchHandle) throws RemoteException;

    void setBalanceTowardRight(float f) throws RemoteException;

    String[] setCustomSetting(int i, int i2, String[] strArr) throws RemoteException;

    void setEcnrConfiguration(int i, int i2) throws RemoteException;

    void setFadeTowardFront(float f) throws RemoteException;

    void setGroupMute(int i, int i2, boolean z, int i3) throws RemoteException;

    void setGroupMuteByPower(int i, int i2, boolean z) throws RemoteException;

    void setGroupVolume(int i, int i2, int i3, int i4) throws RemoteException;

    boolean setZoneIdForUid(int i, int i2) throws RemoteException;

    void unregisterAudioFocusCallback(int i, IBinder iBinder) throws RemoteException;

    void unregisterCustomSettingCallback(IBinder iBinder) throws RemoteException;

    void unregisterExtVolumeCallback(IBinder iBinder) throws RemoteException;

    void unregisterVolumeCallback(IBinder iBinder) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarAudio {
        private static final String DESCRIPTOR = "android.car.media.ICarAudio";
        static final int TRANSACTION_clearZoneIdForUid = 18;
        static final int TRANSACTION_createAudioPatch = 10;
        static final int TRANSACTION_getActiveAudioFocusUsage = 31;
        static final int TRANSACTION_getAudioZoneIds = 15;
        static final int TRANSACTION_getCustomSetting = 29;
        static final int TRANSACTION_getExternalSources = 9;
        static final int TRANSACTION_getGroupDefaultVolume = 6;
        static final int TRANSACTION_getGroupMaxVolume = 3;
        static final int TRANSACTION_getGroupMinVolume = 4;
        static final int TRANSACTION_getGroupVolume = 5;
        static final int TRANSACTION_getInputDevicesForZoneId = 20;
        static final int TRANSACTION_getOutputDeviceAddressForUsage = 19;
        static final int TRANSACTION_getUsagesForVolumeGroupId = 14;
        static final int TRANSACTION_getVolumeGroupCount = 12;
        static final int TRANSACTION_getVolumeGroupIdForUsage = 13;
        static final int TRANSACTION_getZoneIdForUid = 16;
        static final int TRANSACTION_isDynamicRoutingEnabled = 1;
        static final int TRANSACTION_isGroupMute = 26;
        static final int TRANSACTION_isGroupMuteByPower = 23;
        static final int TRANSACTION_isGroupSupportMute = 27;
        static final int TRANSACTION_registerAudioFocusCallback = 34;
        static final int TRANSACTION_registerCustomSettingCallback = 36;
        static final int TRANSACTION_registerExtVolumeCallback = 32;
        static final int TRANSACTION_registerVolumeCallback = 21;
        static final int TRANSACTION_releaseAudioPatch = 11;
        static final int TRANSACTION_setBalanceTowardRight = 8;
        static final int TRANSACTION_setCustomSetting = 28;
        static final int TRANSACTION_setEcnrConfiguration = 30;
        static final int TRANSACTION_setFadeTowardFront = 7;
        static final int TRANSACTION_setGroupMute = 25;
        static final int TRANSACTION_setGroupMuteByPower = 24;
        static final int TRANSACTION_setGroupVolume = 2;
        static final int TRANSACTION_setZoneIdForUid = 17;
        static final int TRANSACTION_unregisterAudioFocusCallback = 35;
        static final int TRANSACTION_unregisterCustomSettingCallback = 37;
        static final int TRANSACTION_unregisterExtVolumeCallback = 33;
        static final int TRANSACTION_unregisterVolumeCallback = 22;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarAudio asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICarAudio)) {
                return (ICarAudio) queryLocalInterface;
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
                    boolean isDynamicRoutingEnabled = isDynamicRoutingEnabled();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDynamicRoutingEnabled ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupVolume(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int groupMaxVolume = getGroupMaxVolume(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(groupMaxVolume);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int groupMinVolume = getGroupMinVolume(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(groupMinVolume);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    int groupVolume = getGroupVolume(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(groupVolume);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int groupDefaultVolume = getGroupDefaultVolume(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(groupDefaultVolume);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setFadeTowardFront(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    setBalanceTowardRight(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    String[] externalSources = getExternalSources();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(externalSources);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    CarAudioPatchHandle createAudioPatch = createAudioPatch(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (createAudioPatch != null) {
                        parcel2.writeInt(1);
                        createAudioPatch.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    releaseAudioPatch(parcel.readInt() != 0 ? CarAudioPatchHandle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    int volumeGroupCount = getVolumeGroupCount(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(volumeGroupCount);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int volumeGroupIdForUsage = getVolumeGroupIdForUsage(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(volumeGroupIdForUsage);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    int[] usagesForVolumeGroupId = getUsagesForVolumeGroupId(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(usagesForVolumeGroupId);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int[] audioZoneIds = getAudioZoneIds();
                    parcel2.writeNoException();
                    parcel2.writeIntArray(audioZoneIds);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    int zoneIdForUid = getZoneIdForUid(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zoneIdForUid);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zoneIdForUid2 = setZoneIdForUid(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zoneIdForUid2 ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean clearZoneIdForUid = clearZoneIdForUid(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(clearZoneIdForUid ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    String outputDeviceAddressForUsage = getOutputDeviceAddressForUsage(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(outputDeviceAddressForUsage);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<AudioDeviceAttributes> inputDevicesForZoneId = getInputDevicesForZoneId(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(inputDevicesForZoneId);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerVolumeCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterVolumeCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isGroupMuteByPower = isGroupMuteByPower(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isGroupMuteByPower ? 1 : 0);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupMuteByPower(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    setGroupMute(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isGroupMute = isGroupMute(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isGroupMute ? 1 : 0);
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isGroupSupportMute = isGroupSupportMute(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(isGroupSupportMute ? 1 : 0);
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    String[] customSetting = setCustomSetting(parcel.readInt(), parcel.readInt(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(customSetting);
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    String[] customSetting2 = getCustomSetting(parcel.readInt(), parcel.readInt(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(customSetting2);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    setEcnrConfiguration(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    int activeAudioFocusUsage = getActiveAudioFocusUsage(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(activeAudioFocusUsage);
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerExtVolumeCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterExtVolumeCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerAudioFocusCallback(parcel.readInt(), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterAudioFocusCallback(parcel.readInt(), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCustomSettingCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCustomSettingCallback(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements ICarAudio {
            public static ICarAudio sDefaultImpl;
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

            @Override // android.car.media.ICarAudio
            public boolean isDynamicRoutingEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDynamicRoutingEnabled();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void setGroupVolume(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupVolume(i, i2, i3, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getGroupMaxVolume(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGroupMaxVolume(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getGroupMinVolume(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGroupMinVolume(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getGroupVolume(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGroupVolume(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getGroupDefaultVolume(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGroupDefaultVolume(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void setFadeTowardFront(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setFadeTowardFront(f);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void setBalanceTowardRight(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setBalanceTowardRight(f);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public String[] getExternalSources() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getExternalSources();
                    }
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public CarAudioPatchHandle createAudioPatch(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createAudioPatch(str, i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CarAudioPatchHandle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void releaseAudioPatch(CarAudioPatchHandle carAudioPatchHandle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (carAudioPatchHandle != null) {
                        obtain.writeInt(1);
                        carAudioPatchHandle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().releaseAudioPatch(carAudioPatchHandle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getVolumeGroupCount(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVolumeGroupCount(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getVolumeGroupIdForUsage(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVolumeGroupIdForUsage(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int[] getUsagesForVolumeGroupId(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUsagesForVolumeGroupId(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int[] getAudioZoneIds() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAudioZoneIds();
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getZoneIdForUid(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getZoneIdForUid(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public boolean setZoneIdForUid(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setZoneIdForUid(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public boolean clearZoneIdForUid(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearZoneIdForUid(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public String getOutputDeviceAddressForUsage(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOutputDeviceAddressForUsage(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public List<AudioDeviceAttributes> getInputDevicesForZoneId(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getInputDevicesForZoneId(i);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(AudioDeviceAttributes.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void registerVolumeCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerVolumeCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void unregisterVolumeCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterVolumeCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public boolean isGroupMuteByPower(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isGroupMuteByPower(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void setGroupMuteByPower(int i, int i2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupMuteByPower(i, i2, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void setGroupMute(int i, int i2, boolean z, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setGroupMute(i, i2, z, i3);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public boolean isGroupMute(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isGroupMute(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public boolean isGroupSupportMute(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isGroupSupportMute(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public String[] setCustomSetting(int i, int i2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setCustomSetting(i, i2, strArr);
                    }
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public String[] getCustomSetting(int i, int i2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(29, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCustomSetting(i, i2, strArr);
                    }
                    obtain2.readException();
                    return obtain2.createStringArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void setEcnrConfiguration(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(30, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setEcnrConfiguration(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public int getActiveAudioFocusUsage(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveAudioFocusUsage(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void registerExtVolumeCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerExtVolumeCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void unregisterExtVolumeCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(33, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterExtVolumeCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void registerAudioFocusCallback(int i, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerAudioFocusCallback(i, iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void unregisterAudioFocusCallback(int i, IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(35, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterAudioFocusCallback(i, iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void registerCustomSettingCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCustomSettingCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.car.media.ICarAudio
            public void unregisterCustomSettingCallback(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCustomSettingCallback(iBinder);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICarAudio iCarAudio) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iCarAudio == null) {
                return false;
            }
            Proxy.sDefaultImpl = iCarAudio;
            return true;
        }

        public static ICarAudio getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
