package com.autolink.adaptermanager.clusterinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.autolink.adapterinterface.clusterinteraction.IClusterInteraction;
import com.autolink.adapterinterface.clusterinteraction.IDmsCallback;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ALDmsManager extends ALBaseManager implements IALManager {
    private static final String TAG = "ALDmsManager";
    private HandlerThread handlerThread;
    private IDmsCallback mCallback;
    private CopyOnWriteArrayList<ALDmsDataListener> mListeners;
    private ManagerHandler mManagerHandler;
    private IClusterInteraction mService;

    public interface ALDmsDataListener {
        void activationLicenseResp();

        void androidSetupCompleteResp(int i, FaceIdStatus faceIdStatus);

        void bloodOxygenResultResp(boolean z, int i);

        void cameraOcclusionValueResp(boolean z, boolean z2);

        void cameraStatusResp(DmsStatus dmsStatus, FunctionRoler functionRoler);

        void distractionLevelValueResp(boolean z, DriverDistractionLevel driverDistractionLevel);

        void driverActionValueResp(boolean z, DriverActionStatus driverActionStatus);

        void driverMissingValueResp(boolean z, boolean z2);

        void drowsinessLevelValueResp(boolean z, DriverDrowsinessLevel driverDrowsinessLevel);

        void faceIdResp(FaceIdRequestType faceIdRequestType, FaceIdStatus faceIdStatus, int i);

        void faceStatusResultResp(boolean z);

        void healthLoginResp(boolean z, int i, FaceIdSex faceIdSex);

        void healthRateResultResp(boolean z, float f);

        void heartRateVarResultResp(boolean z, float f);

        void onServiceConnected();

        void onServiceDisconnected();

        void pressureResultResp(boolean z, int i, int i2);

        void respiratoryRateResultResp(boolean z, float f);
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    public enum FaceIdRequestType {
        FACE_ID_REGISTER(1),
        FACE_ID_LOGIN(2),
        FACE_ID_DELETE(4);

        private final int value;

        FaceIdRequestType(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static FaceIdRequestType forNumber(int i) {
            if (i == 1) {
                return FACE_ID_REGISTER;
            }
            if (i == 2) {
                return FACE_ID_LOGIN;
            }
            if (i != 4) {
                return null;
            }
            return FACE_ID_DELETE;
        }
    }

    public enum FaceIdStatus {
        FACEID_OK(0),
        FACEID_WAITING(1),
        FACEID_NO_FACE(2),
        FACEID_TRACK_SCORE_LOW(3),
        FACEID_TOO_BRIGHT(4),
        FACEID_TOO_DARK(5),
        FACEID_BLURRED(6),
        FACEID_FACE_TOO_SMALL(7),
        FACEID_YAW_TOO_BIG(8),
        FACEID_PITCH_TOO_BIG(9),
        FACEID_NON_LIVING(10),
        FACEID_NOT_FOUND(11),
        FACEID_OCCLUSION(12),
        FACEID_LANDMARK_OUTBOUND(13),
        FACEID_DELETE_FAILED(14),
        FACEID_TIMEOUT(15),
        FACEID_CANCEL(16),
        FACEID_INVALID(255);

        private final int value;

        FaceIdStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static FaceIdStatus forNumber(int i) {
            if (i != 255) {
                switch (i) {
                    case 0:
                        return FACEID_OK;
                    case 1:
                        return FACEID_WAITING;
                    case 2:
                        return FACEID_NO_FACE;
                    case 3:
                        return FACEID_TRACK_SCORE_LOW;
                    case 4:
                        return FACEID_TOO_BRIGHT;
                    case 5:
                        return FACEID_TOO_DARK;
                    case 6:
                        return FACEID_BLURRED;
                    case 7:
                        return FACEID_FACE_TOO_SMALL;
                    case 8:
                        return FACEID_YAW_TOO_BIG;
                    case 9:
                        return FACEID_PITCH_TOO_BIG;
                    case 10:
                        return FACEID_NON_LIVING;
                    case 11:
                        return FACEID_NOT_FOUND;
                    case 12:
                        return FACEID_OCCLUSION;
                    case 13:
                        return FACEID_LANDMARK_OUTBOUND;
                    case 14:
                        return FACEID_DELETE_FAILED;
                    case 15:
                        return FACEID_TIMEOUT;
                    case 16:
                        return FACEID_CANCEL;
                    default:
                        return null;
                }
            }
            return FACEID_INVALID;
        }
    }

    public enum ResultStatus {
        RESULT_VALID(1),
        RESULT_INVALID(2);

        private final int value;

        ResultStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ResultStatus forNumber(int i) {
            if (i == 1) {
                return RESULT_VALID;
            }
            if (i != 2) {
                return null;
            }
            return RESULT_INVALID;
        }
    }

    public enum DmsFunctionStatus {
        STATUS_ON(1),
        STATUS_OFF(2);

        private final int value;

        DmsFunctionStatus(int i) {
            this.value = i;
        }

        public static DmsFunctionStatus forNumber(int i) {
            if (i == 1) {
                return STATUS_ON;
            }
            if (i != 2) {
                return null;
            }
            return STATUS_OFF;
        }

        public final int getNumber() {
            return this.value;
        }
    }

    public enum DriverActionStatus {
        DRIVER_ACTION_NONE(1),
        DRIVER_ACTION_CALL(2),
        DRIVER_ACTION_DRINK(3),
        DRIVER_ACTION_SMOKE(4),
        DRIVER_ACTION_INVALID(255);

        private final int value;

        DriverActionStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriverActionStatus forNumber(int i) {
            if (i == 1) {
                return DRIVER_ACTION_NONE;
            }
            if (i == 2) {
                return DRIVER_ACTION_CALL;
            }
            if (i == 3) {
                return DRIVER_ACTION_DRINK;
            }
            if (i == 4) {
                return DRIVER_ACTION_SMOKE;
            }
            if (i != 255) {
                return null;
            }
            return DRIVER_ACTION_INVALID;
        }
    }

    public enum DriverDistractionLevel {
        DRIVER_DISTRACTION_LEVEL_NONE(1),
        DRIVER_DISTRACTION_LEVEL_LIGHT(2),
        DRIVER_DISTRACTION_LEVEL_MEDIUM(3),
        DRIVER_DISTRACTION_LEVEL_HEAVEY(4),
        DRIVER_DISTRACTION_LEVEL_INVALID(255);

        private final int value;

        DriverDistractionLevel(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriverDistractionLevel forNumber(int i) {
            if (i == 1) {
                return DRIVER_DISTRACTION_LEVEL_NONE;
            }
            if (i == 2) {
                return DRIVER_DISTRACTION_LEVEL_LIGHT;
            }
            if (i == 3) {
                return DRIVER_DISTRACTION_LEVEL_MEDIUM;
            }
            if (i == 4) {
                return DRIVER_DISTRACTION_LEVEL_HEAVEY;
            }
            if (i != 255) {
                return null;
            }
            return DRIVER_DISTRACTION_LEVEL_INVALID;
        }
    }

    public enum DriverDrowsinessLevel {
        DRIVER_DROWSINESS_LEVEL_NONE(1),
        DRIVER_DROWSINESS_LEVEL_LIGHT(2),
        DRIVER_DROWSINESS_LEVEL_MEDIUM(3),
        DRIVER_DROWSINESS_LEVEL_HEAVEY(4),
        DRIVER_DROWSINESS_LEVEL_INVALID(255);

        private final int value;

        DriverDrowsinessLevel(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DriverDrowsinessLevel forNumber(int i) {
            if (i == 1) {
                return DRIVER_DROWSINESS_LEVEL_NONE;
            }
            if (i == 2) {
                return DRIVER_DROWSINESS_LEVEL_LIGHT;
            }
            if (i == 3) {
                return DRIVER_DROWSINESS_LEVEL_MEDIUM;
            }
            if (i == 4) {
                return DRIVER_DROWSINESS_LEVEL_HEAVEY;
            }
            if (i != 255) {
                return null;
            }
            return DRIVER_DROWSINESS_LEVEL_INVALID;
        }
    }

    public enum FaceIdSex {
        SEX_MALE(1),
        SEX_FEMALE(2),
        SEX_INVALID(255);

        private final int value;

        FaceIdSex(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static FaceIdSex forNumber(int i) {
            if (i == 1) {
                return SEX_MALE;
            }
            if (i == 2) {
                return SEX_FEMALE;
            }
            if (i != 255) {
                return null;
            }
            return SEX_INVALID;
        }
    }

    public enum DmsStatus {
        DMS_STATUS_DEFAULT(1),
        DMS_SDK_INIT_SUCCESS(2),
        DMS_SDK_INIT_ERROR(3),
        DMS_CAMERA_OK(4),
        DMS_CAMERA_ERROR(5),
        ACTIVATION_CODE_NOT_EXIST(6),
        ACTIVATION_CODE_WRITE_SUCCESS(7);

        private final int value;

        DmsStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DmsStatus forNumber(int i) {
            switch (i) {
                case 1:
                    return DMS_STATUS_DEFAULT;
                case 2:
                    return DMS_SDK_INIT_SUCCESS;
                case 3:
                    return DMS_SDK_INIT_ERROR;
                case 4:
                    return DMS_CAMERA_OK;
                case 5:
                    return DMS_CAMERA_ERROR;
                case 6:
                    return ACTIVATION_CODE_NOT_EXIST;
                case 7:
                    return ACTIVATION_CODE_WRITE_SUCCESS;
                default:
                    return null;
            }
        }
    }

    public enum FunctionRoler {
        QNX_ROLER(1),
        ANDROID_ACCOUNT_ROLER(2),
        ANDROID_HEATLTH_ROLER(3),
        ANDROID_DRIVER_ROLER(4),
        ANDROID_OMS_ROLER(5),
        ROLER_ALL(6);

        private final int value;

        FunctionRoler(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static FunctionRoler forNumber(int i) {
            switch (i) {
                case 1:
                    return QNX_ROLER;
                case 2:
                    return ANDROID_ACCOUNT_ROLER;
                case 3:
                    return ANDROID_HEATLTH_ROLER;
                case 4:
                    return ANDROID_DRIVER_ROLER;
                case 5:
                    return ANDROID_OMS_ROLER;
                case 6:
                    return ROLER_ALL;
                default:
                    return null;
            }
        }
    }

    @Deprecated
    public ALDmsManager(Context context) {
        super(context);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mCallback = new IDmsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALDmsManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceIdResp(int i, int i2, int i3) throws RemoteException {
                Log.i(ALDmsManager.TAG, "faceIdResp type=" + i + " status=" + i2 + " index=" + i3);
                Bundle bundle = new Bundle();
                bundle.putInt("type", i);
                bundle.putInt(NotificationCompat.CATEGORY_STATUS, i2);
                bundle.putInt("index", i3);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 1, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthRateResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "healthRateResultResp isValid=" + z + " heartRate=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("heartRate", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 2, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void heartRateVarResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "heartRateVarResultResp isValid=" + z + " heartRateVariability=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("heartRateVariability", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 3, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void respiratoryRateResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "respiratoryRateResultResp isValid=" + z + " respiratoryRate=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("respiratoryRate", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 4, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void pressureResultResp(boolean z, int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "pressureResultResp isValid=" + z + " diastolicPressure=" + i + " systolicPressure=" + i2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putInt("diastolicPressure", i);
                bundle.putInt("systolicPressure", i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 5, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void bloodOxygenResultResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "bloodOxygenResultResp isValid=" + z + " bloodOxygen=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 6, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverActionValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "driverActionValueResp isValid=" + z + " action=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 7, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverMissingValueResp(boolean z, boolean z2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "driverMissingValueResp isValid=" + z + " isMissing=" + z2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 8, z ? 1 : 0, z2 ? 1 : 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraOcclusionValueResp(boolean z, boolean z2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "cameraOcclusionValueResp isValid=" + z + " isOcclustion=" + z2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 9, z ? 1 : 0, z2 ? 1 : 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void distractionLevelValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "distractionLevelValueResp isValid=" + z + " distractionLevel=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 10, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void drowsinessLevelValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "drowsinessLevelValueResp isValid=" + z + " drowsinessLevel=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 11, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void androidSetupCompleteResp(int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "androidSetupCompleteResp index=" + i + " status=" + i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 12, i, i2));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthLoginResp(boolean z, int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "healthLoginResp isValid=" + z + " age=" + i + " sex=" + i2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putInt("age", i);
                bundle.putInt("sex", i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 13, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "cameraStatusResp status=" + i + "roler=" + i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 14, i, i2));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void activationLicenseResp() throws RemoteException {
                Log.i(ALDmsManager.TAG, "activationLicenseResp");
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 15));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceStatusResultResp(boolean z) throws RemoteException {
                Log.i(ALDmsManager.TAG, "faceStatusResultResp");
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 16, !z ? 0 : 1, 0));
            }
        };
        Log.i(TAG, TAG);
        this.mListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    @Deprecated
    public ALDmsManager(Context context, IALManager.ServiceConnectionListener serviceConnectionListener) {
        super(context, serviceConnectionListener);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mCallback = new IDmsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALDmsManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceIdResp(int i, int i2, int i3) throws RemoteException {
                Log.i(ALDmsManager.TAG, "faceIdResp type=" + i + " status=" + i2 + " index=" + i3);
                Bundle bundle = new Bundle();
                bundle.putInt("type", i);
                bundle.putInt(NotificationCompat.CATEGORY_STATUS, i2);
                bundle.putInt("index", i3);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 1, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthRateResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "healthRateResultResp isValid=" + z + " heartRate=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("heartRate", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 2, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void heartRateVarResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "heartRateVarResultResp isValid=" + z + " heartRateVariability=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("heartRateVariability", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 3, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void respiratoryRateResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "respiratoryRateResultResp isValid=" + z + " respiratoryRate=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("respiratoryRate", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 4, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void pressureResultResp(boolean z, int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "pressureResultResp isValid=" + z + " diastolicPressure=" + i + " systolicPressure=" + i2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putInt("diastolicPressure", i);
                bundle.putInt("systolicPressure", i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 5, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void bloodOxygenResultResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "bloodOxygenResultResp isValid=" + z + " bloodOxygen=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 6, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverActionValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "driverActionValueResp isValid=" + z + " action=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 7, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverMissingValueResp(boolean z, boolean z2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "driverMissingValueResp isValid=" + z + " isMissing=" + z2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 8, z ? 1 : 0, z2 ? 1 : 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraOcclusionValueResp(boolean z, boolean z2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "cameraOcclusionValueResp isValid=" + z + " isOcclustion=" + z2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 9, z ? 1 : 0, z2 ? 1 : 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void distractionLevelValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "distractionLevelValueResp isValid=" + z + " distractionLevel=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 10, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void drowsinessLevelValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "drowsinessLevelValueResp isValid=" + z + " drowsinessLevel=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 11, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void androidSetupCompleteResp(int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "androidSetupCompleteResp index=" + i + " status=" + i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 12, i, i2));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthLoginResp(boolean z, int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "healthLoginResp isValid=" + z + " age=" + i + " sex=" + i2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putInt("age", i);
                bundle.putInt("sex", i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 13, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "cameraStatusResp status=" + i + "roler=" + i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 14, i, i2));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void activationLicenseResp() throws RemoteException {
                Log.i(ALDmsManager.TAG, "activationLicenseResp");
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 15));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceStatusResultResp(boolean z) throws RemoteException {
                Log.i(ALDmsManager.TAG, "faceStatusResultResp");
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 16, !z ? 0 : 1, 0));
            }
        };
        Log.i(TAG, TAG);
        this.mListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    public ALDmsManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.handlerThread = HandlerThreadUtils.getHandlerThread(TAG);
        this.mManagerHandler = new ManagerHandler(this.handlerThread.getLooper(), this);
        this.mCallback = new IDmsCallback.Stub() { // from class: com.autolink.adaptermanager.clusterinteraction.ALDmsManager.1
            AnonymousClass1() {
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceIdResp(int i, int i2, int i3) throws RemoteException {
                Log.i(ALDmsManager.TAG, "faceIdResp type=" + i + " status=" + i2 + " index=" + i3);
                Bundle bundle = new Bundle();
                bundle.putInt("type", i);
                bundle.putInt(NotificationCompat.CATEGORY_STATUS, i2);
                bundle.putInt("index", i3);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 1, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthRateResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "healthRateResultResp isValid=" + z + " heartRate=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("heartRate", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 2, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void heartRateVarResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "heartRateVarResultResp isValid=" + z + " heartRateVariability=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("heartRateVariability", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 3, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void respiratoryRateResultResp(boolean z, float f) throws RemoteException {
                Log.i(ALDmsManager.TAG, "respiratoryRateResultResp isValid=" + z + " respiratoryRate=" + f);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putFloat("respiratoryRate", f);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 4, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void pressureResultResp(boolean z, int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "pressureResultResp isValid=" + z + " diastolicPressure=" + i + " systolicPressure=" + i2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putInt("diastolicPressure", i);
                bundle.putInt("systolicPressure", i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 5, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void bloodOxygenResultResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "bloodOxygenResultResp isValid=" + z + " bloodOxygen=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 6, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverActionValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "driverActionValueResp isValid=" + z + " action=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 7, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void driverMissingValueResp(boolean z, boolean z2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "driverMissingValueResp isValid=" + z + " isMissing=" + z2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 8, z ? 1 : 0, z2 ? 1 : 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraOcclusionValueResp(boolean z, boolean z2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "cameraOcclusionValueResp isValid=" + z + " isOcclustion=" + z2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 9, z ? 1 : 0, z2 ? 1 : 0));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void distractionLevelValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "distractionLevelValueResp isValid=" + z + " distractionLevel=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 10, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void drowsinessLevelValueResp(boolean z, int i) throws RemoteException {
                Log.i(ALDmsManager.TAG, "drowsinessLevelValueResp isValid=" + z + " drowsinessLevel=" + i);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 11, !z ? 0 : 1, i));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void androidSetupCompleteResp(int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "androidSetupCompleteResp index=" + i + " status=" + i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 12, i, i2));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void healthLoginResp(boolean z, int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "healthLoginResp isValid=" + z + " age=" + i + " sex=" + i2);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isValid", z);
                bundle.putInt("age", i);
                bundle.putInt("sex", i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 13, bundle));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void cameraStatusResp(int i, int i2) throws RemoteException {
                Log.i(ALDmsManager.TAG, "cameraStatusResp status=" + i + "roler=" + i2);
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 14, i, i2));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void activationLicenseResp() throws RemoteException {
                Log.i(ALDmsManager.TAG, "activationLicenseResp");
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 15));
            }

            @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
            public void faceStatusResultResp(boolean z) throws RemoteException {
                Log.i(ALDmsManager.TAG, "faceStatusResultResp");
                ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 16, !z ? 0 : 1, 0));
            }
        };
        Log.i(TAG, TAG);
        this.mListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent("com.autolink.clusterinteraction.CiService");
        intent.setPackage("com.autolink.clusterinteraction");
        intent.setClassName("com.autolink.clusterinteraction", "com.autolink.clusterinteraction.CiService");
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onServiceConnected();
        }
        IClusterInteraction asInterface = IClusterInteraction.Stub.asInterface(iBinder);
        this.mService = asInterface;
        try {
            asInterface.registerDmsCallback(this.mCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        this.mService = null;
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onServiceDisconnected();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        this.mService = null;
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onServiceDisconnected();
        }
    }

    public void registerListener(ALDmsDataListener aLDmsDataListener) {
        Log.i(TAG, "ALDmsManager->registerListener");
        if (this.mListeners.contains(aLDmsDataListener)) {
            return;
        }
        this.mListeners.add(aLDmsDataListener);
    }

    public void unregisterCallback(ALDmsDataListener aLDmsDataListener) {
        if (this.mListeners.contains(aLDmsDataListener)) {
            this.mListeners.remove(aLDmsDataListener);
        }
    }

    public void registerFaceIdReq(int i, int i2) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.registerFaceIdReq(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void loginFaceIdReq(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.loginFaceIdReq(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFaceIdReq(int i) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.deleteFaceIdReq(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void healthMonitorReq(DmsFunctionStatus dmsFunctionStatus, int i, FaceIdSex faceIdSex, int i2, int i3) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.healthMonitorReq(dmsFunctionStatus.getNumber(), i, faceIdSex.getNumber(), i2, i3);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void driverMonitorReq(DmsFunctionStatus dmsFunctionStatus) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.driverMonitorReq(dmsFunctionStatus.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void healthLoginReq(DmsFunctionStatus dmsFunctionStatus) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.healthLoginReq(dmsFunctionStatus.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setActivationLicense(String str) {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.setActivationLicense(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getDmsCameraStatus() {
        IClusterInteraction iClusterInteraction = this.mService;
        if (iClusterInteraction != null) {
            try {
                iClusterInteraction.getDmsCameraStatus();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private static final class ManagerHandler extends Handler {
        private static final int MSG_ACTIVATION_LICENSE_RESP = 15;
        private static final int MSG_ANDROID_SETUP_COMPLETE_RESP = 12;
        private static final int MSG_BLOOD_OXYGEN_RESULT_RESP = 6;
        private static final int MSG_CAMERA_OCCLUSION_VALUE_RESP = 9;
        private static final int MSG_CAMERA_STATUS_RESP = 14;
        private static final int MSG_DISTRACTION_LEVEL_VALUE_RESP = 10;
        private static final int MSG_DRIVER_ACTION_VALUE_RESP = 7;
        private static final int MSG_DRIVER_MISSING_VALUE_RESP = 8;
        private static final int MSG_DROWSINESS_LEVEL_VALUE_RESP = 11;
        private static final int MSG_FACEID_RESP = 1;
        private static final int MSG_FACE_STATUS_RESULT_RESP = 16;
        private static final int MSG_HEALTH_LOGIN_RESP = 13;
        private static final int MSG_HEALTH_RATE_RESULT_RESP = 2;
        private static final int MSG_HEART_RATE_VAR_RESULT_RESP = 3;
        private static final int MSG_PRESSURE_RESULT_RESP = 5;
        private static final int MSG_RESPIRATORY_RATE_RESULT_RESP = 4;
        private final WeakReference<ALDmsManager> mManager;

        public ManagerHandler(Looper looper, ALDmsManager aLDmsManager) {
            super(looper);
            this.mManager = new WeakReference<>(aLDmsManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ALDmsManager aLDmsManager = this.mManager.get();
            if (aLDmsManager == null) {
                Log.e(ALDmsManager.TAG, "handleMessage in ALDmsManager is null");
            }
            switch (message.what) {
                case 1:
                    Bundle bundle = (Bundle) message.obj;
                    aLDmsManager.notifyFaceIdResp(bundle.getInt("type"), bundle.getInt(NotificationCompat.CATEGORY_STATUS), bundle.getInt("index"));
                    break;
                case 2:
                    Bundle bundle2 = (Bundle) message.obj;
                    aLDmsManager.notifyHealthRateResultResp(bundle2.getBoolean("isValid"), bundle2.getFloat("heartRate"));
                    break;
                case 3:
                    Bundle bundle3 = (Bundle) message.obj;
                    aLDmsManager.notifyHeartRateVarResultResp(bundle3.getBoolean("isValid"), bundle3.getFloat("heartRateVariability"));
                    break;
                case 4:
                    Bundle bundle4 = (Bundle) message.obj;
                    aLDmsManager.notifyRespiratoryRateResultResp(bundle4.getBoolean("isValid"), bundle4.getFloat("respiratoryRate"));
                    break;
                case 5:
                    Bundle bundle5 = (Bundle) message.obj;
                    aLDmsManager.notifyPressureResultResp(bundle5.getBoolean("isValid"), bundle5.getInt("diastolicPressure"), bundle5.getInt("systolicPressure"));
                    break;
                case 6:
                    aLDmsManager.notifyBloodOxygenResultResp(message.arg1 == 1, message.arg2);
                    break;
                case 7:
                    aLDmsManager.notifyDriverActionValueResp(message.arg1 == 1, message.arg2);
                    break;
                case 8:
                    aLDmsManager.notifyDriverMissingValueResp(message.arg1 == 1, message.arg2 == 1);
                    break;
                case 9:
                    aLDmsManager.notifyCameraOcclusionValueResp(message.arg1 == 1, message.arg2 == 1);
                    break;
                case 10:
                    aLDmsManager.notifyDistractionLevelValueResp(message.arg1 == 1, message.arg2);
                    break;
                case 11:
                    aLDmsManager.notifyDrowsinessLevelValueResp(message.arg1 == 1, message.arg2);
                    break;
                case 12:
                    aLDmsManager.notifyAndroidSetupCompleteResp(message.arg1, message.arg2);
                    break;
                case 13:
                    Bundle bundle6 = (Bundle) message.obj;
                    aLDmsManager.notifyHealthLoginResp(bundle6.getBoolean("isValid"), bundle6.getInt("age"), bundle6.getInt("sex"));
                    break;
                case 14:
                    aLDmsManager.notifyCameraStatusResp(message.arg1, message.arg2);
                    break;
                case 15:
                    aLDmsManager.notifyActivationLicenseResp();
                    break;
                case 16:
                    aLDmsManager.notifyFaceStatusResultResp(message.arg1 == 1);
                    break;
            }
        }
    }

    public void notifyFaceIdResp(int i, int i2, int i3) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().faceIdResp(FaceIdRequestType.forNumber(i), FaceIdStatus.forNumber(i2), i3);
        }
    }

    public void notifyHealthRateResultResp(boolean z, float f) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().healthRateResultResp(z, f);
        }
    }

    public void notifyHeartRateVarResultResp(boolean z, float f) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().heartRateVarResultResp(z, f);
        }
    }

    public void notifyRespiratoryRateResultResp(boolean z, float f) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().respiratoryRateResultResp(z, f);
        }
    }

    public void notifyPressureResultResp(boolean z, int i, int i2) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().pressureResultResp(z, i, i2);
        }
    }

    public void notifyBloodOxygenResultResp(boolean z, int i) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().bloodOxygenResultResp(z, i);
        }
    }

    public void notifyDriverActionValueResp(boolean z, int i) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().driverActionValueResp(z, DriverActionStatus.forNumber(i));
        }
    }

    public void notifyDriverMissingValueResp(boolean z, boolean z2) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().driverMissingValueResp(z, z2);
        }
    }

    public void notifyCameraOcclusionValueResp(boolean z, boolean z2) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().cameraOcclusionValueResp(z, z2);
        }
    }

    public void notifyDistractionLevelValueResp(boolean z, int i) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().distractionLevelValueResp(z, DriverDistractionLevel.forNumber(i));
        }
    }

    public void notifyDrowsinessLevelValueResp(boolean z, int i) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().drowsinessLevelValueResp(z, DriverDrowsinessLevel.forNumber(i));
        }
    }

    public void notifyAndroidSetupCompleteResp(int i, int i2) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().androidSetupCompleteResp(i, FaceIdStatus.forNumber(i2));
        }
    }

    public void notifyHealthLoginResp(boolean z, int i, int i2) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().healthLoginResp(z, i, FaceIdSex.forNumber(i2));
        }
    }

    public void notifyCameraStatusResp(int i, int i2) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().cameraStatusResp(DmsStatus.forNumber(i), FunctionRoler.forNumber(i2));
        }
    }

    public void notifyActivationLicenseResp() {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().activationLicenseResp();
        }
    }

    public void notifyFaceStatusResultResp(boolean z) {
        if (this.mListeners.isEmpty()) {
            return;
        }
        Iterator<ALDmsDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().faceStatusResultResp(z);
        }
    }

    /* renamed from: com.autolink.adaptermanager.clusterinteraction.ALDmsManager$1 */
    class AnonymousClass1 extends IDmsCallback.Stub {
        AnonymousClass1() {
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void faceIdResp(int i, int i2, int i3) throws RemoteException {
            Log.i(ALDmsManager.TAG, "faceIdResp type=" + i + " status=" + i2 + " index=" + i3);
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            bundle.putInt(NotificationCompat.CATEGORY_STATUS, i2);
            bundle.putInt("index", i3);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 1, bundle));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void healthRateResultResp(boolean z, float f) throws RemoteException {
            Log.i(ALDmsManager.TAG, "healthRateResultResp isValid=" + z + " heartRate=" + f);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isValid", z);
            bundle.putFloat("heartRate", f);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 2, bundle));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void heartRateVarResultResp(boolean z, float f) throws RemoteException {
            Log.i(ALDmsManager.TAG, "heartRateVarResultResp isValid=" + z + " heartRateVariability=" + f);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isValid", z);
            bundle.putFloat("heartRateVariability", f);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 3, bundle));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void respiratoryRateResultResp(boolean z, float f) throws RemoteException {
            Log.i(ALDmsManager.TAG, "respiratoryRateResultResp isValid=" + z + " respiratoryRate=" + f);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isValid", z);
            bundle.putFloat("respiratoryRate", f);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 4, bundle));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void pressureResultResp(boolean z, int i, int i2) throws RemoteException {
            Log.i(ALDmsManager.TAG, "pressureResultResp isValid=" + z + " diastolicPressure=" + i + " systolicPressure=" + i2);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isValid", z);
            bundle.putInt("diastolicPressure", i);
            bundle.putInt("systolicPressure", i2);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 5, bundle));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void bloodOxygenResultResp(boolean z, int i) throws RemoteException {
            Log.i(ALDmsManager.TAG, "bloodOxygenResultResp isValid=" + z + " bloodOxygen=" + i);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 6, !z ? 0 : 1, i));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void driverActionValueResp(boolean z, int i) throws RemoteException {
            Log.i(ALDmsManager.TAG, "driverActionValueResp isValid=" + z + " action=" + i);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 7, !z ? 0 : 1, i));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void driverMissingValueResp(boolean z, boolean z2) throws RemoteException {
            Log.i(ALDmsManager.TAG, "driverMissingValueResp isValid=" + z + " isMissing=" + z2);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 8, z ? 1 : 0, z2 ? 1 : 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void cameraOcclusionValueResp(boolean z, boolean z2) throws RemoteException {
            Log.i(ALDmsManager.TAG, "cameraOcclusionValueResp isValid=" + z + " isOcclustion=" + z2);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 9, z ? 1 : 0, z2 ? 1 : 0));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void distractionLevelValueResp(boolean z, int i) throws RemoteException {
            Log.i(ALDmsManager.TAG, "distractionLevelValueResp isValid=" + z + " distractionLevel=" + i);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 10, !z ? 0 : 1, i));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void drowsinessLevelValueResp(boolean z, int i) throws RemoteException {
            Log.i(ALDmsManager.TAG, "drowsinessLevelValueResp isValid=" + z + " drowsinessLevel=" + i);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 11, !z ? 0 : 1, i));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void androidSetupCompleteResp(int i, int i2) throws RemoteException {
            Log.i(ALDmsManager.TAG, "androidSetupCompleteResp index=" + i + " status=" + i2);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 12, i, i2));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void healthLoginResp(boolean z, int i, int i2) throws RemoteException {
            Log.i(ALDmsManager.TAG, "healthLoginResp isValid=" + z + " age=" + i + " sex=" + i2);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isValid", z);
            bundle.putInt("age", i);
            bundle.putInt("sex", i2);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 13, bundle));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void cameraStatusResp(int i, int i2) throws RemoteException {
            Log.i(ALDmsManager.TAG, "cameraStatusResp status=" + i + "roler=" + i2);
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 14, i, i2));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void activationLicenseResp() throws RemoteException {
            Log.i(ALDmsManager.TAG, "activationLicenseResp");
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 15));
        }

        @Override // com.autolink.adapterinterface.clusterinteraction.IDmsCallback
        public void faceStatusResultResp(boolean z) throws RemoteException {
            Log.i(ALDmsManager.TAG, "faceStatusResultResp");
            ALDmsManager.this.mManagerHandler.sendMessage(Message.obtain(ALDmsManager.this.mManagerHandler, 16, !z ? 0 : 1, 0));
        }
    }
}
