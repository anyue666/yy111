package android.car.user;

import android.annotation.SystemApi;
import android.car.Car;
import android.car.CarManagerBase;
import android.car.ICarUserService;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.sysprop.CarProperties;
import android.util.ArrayMap;
import android.util.EventLog;
import android.util.Log;
import com.android.internal.car.EventLogTags;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

@SystemApi
/* loaded from: classes.dex */
public final class CarUserManager extends CarManagerBase {
    public static final String BUNDLE_PARAM_ACTION = "action";
    public static final String BUNDLE_PARAM_PREVIOUS_USER_ID = "previous_user";
    private static final boolean DBG = false;
    private static final int HAL_TIMEOUT_MS = ((Integer) CarProperties.user_hal_timeout().orElse(5000)).intValue();
    private static final String TAG = "CarUserManager";

    @SystemApi
    public static final int USER_LIFECYCLE_EVENT_TYPE_STARTING = 1;

    @SystemApi
    public static final int USER_LIFECYCLE_EVENT_TYPE_STOPPED = 6;

    @SystemApi
    public static final int USER_LIFECYCLE_EVENT_TYPE_STOPPING = 5;

    @SystemApi
    public static final int USER_LIFECYCLE_EVENT_TYPE_SWITCHING = 2;

    @SystemApi
    public static final int USER_LIFECYCLE_EVENT_TYPE_UNLOCKED = 4;

    @SystemApi
    public static final int USER_LIFECYCLE_EVENT_TYPE_UNLOCKING = 3;
    private ArrayMap<UserLifecycleListener, Executor> mListeners;
    private final Object mLock;
    private LifecycleResultReceiver mReceiver;
    private final ICarUserService mService;
    private final UserManager mUserManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserLifecycleEventType {
    }

    @SystemApi
    public interface UserLifecycleListener {
        void onEvent(UserLifecycleEvent userLifecycleEvent);
    }

    public interface UserSwitchUiCallback {
        void showUserSwitchDialog(int i);
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
    }

    public CarUserManager(Car car, IBinder iBinder) {
        this(car, ICarUserService.Stub.asInterface(iBinder), UserManager.get(car.getContext()));
    }

    public CarUserManager(Car car, ICarUserService iCarUserService, UserManager userManager) {
        super(car);
        this.mLock = new Object();
        this.mService = iCarUserService;
        this.mUserManager = userManager;
    }

    public AndroidFuture<UserSwitchResult> switchUser(int i) {
        int myUid = Process.myUid();
        if (this.mUserManager.getUserSwitchability() != 0) {
            return newSwitchResuiltForFailure(104);
        }
        try {
            AnonymousClass1 anonymousClass1 = new AndroidFuture<UserSwitchResult>() { // from class: android.car.user.CarUserManager.1
                final /* synthetic */ int val$targetUserId;
                final /* synthetic */ int val$uid;

                AnonymousClass1(int myUid2, int i2) {
                    r2 = myUid2;
                    r3 = i2;
                }

                public void onCompleted(UserSwitchResult userSwitchResult, Throwable th) {
                    if (userSwitchResult == null) {
                        Log.w(CarUserManager.TAG, "switchUser(" + r3 + ") failed: " + th);
                    } else {
                        EventLog.writeEvent(EventLogTags.CAR_USER_MGR_SWITCH_USER_RESP, Integer.valueOf(r2), Integer.valueOf(userSwitchResult.getStatus()), userSwitchResult.getErrorMessage());
                    }
                    super.onCompleted(userSwitchResult, th);
                }
            };
            EventLog.writeEvent(EventLogTags.CAR_USER_MGR_SWITCH_USER_REQ, Integer.valueOf(myUid2), Integer.valueOf(i2));
            this.mService.switchUser(i2, HAL_TIMEOUT_MS, anonymousClass1);
            return anonymousClass1;
        } catch (RemoteException e) {
            return (AndroidFuture) handleRemoteExceptionFromCarService(e, newSwitchResuiltForFailure(4));
        }
    }

    /* renamed from: android.car.user.CarUserManager$1 */
    class AnonymousClass1 extends AndroidFuture<UserSwitchResult> {
        final /* synthetic */ int val$targetUserId;
        final /* synthetic */ int val$uid;

        AnonymousClass1(int myUid2, int i2) {
            r2 = myUid2;
            r3 = i2;
        }

        public void onCompleted(UserSwitchResult userSwitchResult, Throwable th) {
            if (userSwitchResult == null) {
                Log.w(CarUserManager.TAG, "switchUser(" + r3 + ") failed: " + th);
            } else {
                EventLog.writeEvent(EventLogTags.CAR_USER_MGR_SWITCH_USER_RESP, Integer.valueOf(r2), Integer.valueOf(userSwitchResult.getStatus()), userSwitchResult.getErrorMessage());
            }
            super.onCompleted(userSwitchResult, th);
        }
    }

    private AndroidFuture<UserSwitchResult> newSwitchResuiltForFailure(int i) {
        AndroidFuture<UserSwitchResult> androidFuture = new AndroidFuture<>();
        androidFuture.complete(new UserSwitchResult(i, null));
        return androidFuture;
    }

    public AndroidFuture<UserCreationResult> createUser(String str, String str2, int i) {
        int myUid = Process.myUid();
        try {
            AnonymousClass2 anonymousClass2 = new AndroidFuture<UserCreationResult>() { // from class: android.car.user.CarUserManager.2
                final /* synthetic */ int val$flags;
                final /* synthetic */ int val$uid;
                final /* synthetic */ String val$userType;

                AnonymousClass2(int myUid2, String str22, int i2) {
                    r2 = myUid2;
                    r3 = str22;
                    r4 = i2;
                }

                public void onCompleted(UserCreationResult userCreationResult, Throwable th) {
                    if (userCreationResult == null) {
                        Log.w(CarUserManager.TAG, "createUser(" + r3 + "," + UserInfo.flagsToString(r4) + ") failed: " + th);
                    } else {
                        EventLog.writeEvent(EventLogTags.CAR_USER_MGR_CREATE_USER_RESP, Integer.valueOf(r2), Integer.valueOf(userCreationResult.getStatus()), userCreationResult.getErrorMessage());
                        UserInfo user = userCreationResult.getUser();
                        if (userCreationResult.isSuccess() && user != null && user.isGuest()) {
                            CarUserManager.this.onGuestCreated(user);
                        }
                    }
                    super.onCompleted(userCreationResult, th);
                }
            };
            EventLog.writeEvent(EventLogTags.CAR_USER_MGR_CREATE_USER_REQ, Integer.valueOf(myUid2), safeName(str), str22, Integer.valueOf(i2));
            this.mService.createUser(str, str22, i2, HAL_TIMEOUT_MS, anonymousClass2);
            return anonymousClass2;
        } catch (RemoteException e) {
            AndroidFuture androidFuture = new AndroidFuture();
            androidFuture.complete(new UserCreationResult(4, null, null));
            return (AndroidFuture) handleRemoteExceptionFromCarService(e, androidFuture);
        }
    }

    /* renamed from: android.car.user.CarUserManager$2 */
    class AnonymousClass2 extends AndroidFuture<UserCreationResult> {
        final /* synthetic */ int val$flags;
        final /* synthetic */ int val$uid;
        final /* synthetic */ String val$userType;

        AnonymousClass2(int myUid2, String str22, int i2) {
            r2 = myUid2;
            r3 = str22;
            r4 = i2;
        }

        public void onCompleted(UserCreationResult userCreationResult, Throwable th) {
            if (userCreationResult == null) {
                Log.w(CarUserManager.TAG, "createUser(" + r3 + "," + UserInfo.flagsToString(r4) + ") failed: " + th);
            } else {
                EventLog.writeEvent(EventLogTags.CAR_USER_MGR_CREATE_USER_RESP, Integer.valueOf(r2), Integer.valueOf(userCreationResult.getStatus()), userCreationResult.getErrorMessage());
                UserInfo user = userCreationResult.getUser();
                if (userCreationResult.isSuccess() && user != null && user.isGuest()) {
                    CarUserManager.this.onGuestCreated(user);
                }
            }
            super.onCompleted(userCreationResult, th);
        }
    }

    public AndroidFuture<UserCreationResult> createGuest(String str) {
        return createUser(str, "android.os.usertype.full.GUEST", 0);
    }

    public AndroidFuture<UserCreationResult> createUser(String str, int i) {
        return createUser(str, "android.os.usertype.full.SECONDARY", i);
    }

    public void onGuestCreated(UserInfo userInfo) {
        Settings.Secure.putStringForUser(getContext().getContentResolver(), "skip_first_use_hints", "1", userInfo.id);
    }

    public UserRemovalResult removeUser(int i) {
        int myUid = Process.myUid();
        EventLog.writeEvent(EventLogTags.CAR_USER_MGR_REMOVE_USER_REQ, Integer.valueOf(myUid), Integer.valueOf(i));
        try {
            try {
                UserRemovalResult removeUser = this.mService.removeUser(i);
                EventLog.writeEvent(EventLogTags.CAR_USER_MGR_REMOVE_USER_RESP, Integer.valueOf(myUid), Integer.valueOf(removeUser.getStatus()));
                return removeUser;
            } catch (RemoteException e) {
                UserRemovalResult userRemovalResult = (UserRemovalResult) handleRemoteExceptionFromCarService(e, new UserRemovalResult(4));
                EventLog.writeEvent(EventLogTags.CAR_USER_MGR_REMOVE_USER_RESP, Integer.valueOf(myUid), 4);
                return userRemovalResult;
            }
        } catch (Throwable th) {
            EventLog.writeEvent(EventLogTags.CAR_USER_MGR_REMOVE_USER_RESP, Integer.valueOf(myUid), 4);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0016, B:10:0x0020, B:12:0x0029, B:15:0x0034, B:18:0x0040, B:19:0x0043, B:21:0x0047, B:22:0x004e, B:23:0x0053), top: B:3:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047 A[Catch: all -> 0x0055, TryCatch #0 {, blocks: (B:4:0x0011, B:6:0x0016, B:10:0x0020, B:12:0x0029, B:15:0x0034, B:18:0x0040, B:19:0x0043, B:21:0x0047, B:22:0x004e, B:23:0x0053), top: B:3:0x0011, inners: #1 }] */
    @android.annotation.SystemApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addListener(java.util.concurrent.Executor r6, android.car.user.CarUserManager.UserLifecycleListener r7) {
        /*
            r5 = this;
            java.lang.String r0 = "executor cannot be null"
            java.util.Objects.requireNonNull(r6, r0)
            java.lang.String r0 = "listener cannot be null"
            java.util.Objects.requireNonNull(r7, r0)
            int r0 = android.os.Process.myUid()
            java.lang.Object r1 = r5.mLock
            monitor-enter(r1)
            android.util.ArrayMap<android.car.user.CarUserManager$UserLifecycleListener, java.util.concurrent.Executor> r2 = r5.mListeners     // Catch: java.lang.Throwable -> L55
            r3 = 1
            if (r2 == 0) goto L1f
            boolean r2 = r2.containsKey(r7)     // Catch: java.lang.Throwable -> L55
            if (r2 != 0) goto L1d
            goto L1f
        L1d:
            r2 = 0
            goto L20
        L1f:
            r2 = r3
        L20:
            java.lang.String r4 = "already called for this listener"
            com.android.internal.util.Preconditions.checkState(r2, r4)     // Catch: java.lang.Throwable -> L55
            android.car.user.CarUserManager$LifecycleResultReceiver r2 = r5.mReceiver     // Catch: java.lang.Throwable -> L55
            if (r2 != 0) goto L43
            android.car.user.CarUserManager$LifecycleResultReceiver r2 = new android.car.user.CarUserManager$LifecycleResultReceiver     // Catch: java.lang.Throwable -> L55
            r4 = 0
            r2.<init>()     // Catch: java.lang.Throwable -> L55
            r5.mReceiver = r2     // Catch: java.lang.Throwable -> L55
            r2 = 150171(0x24a9b, float:2.10434E-40)
            android.util.EventLog.writeEvent(r2, r0)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L55
            android.car.ICarUserService r0 = r5.mService     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L55
            android.car.user.CarUserManager$LifecycleResultReceiver r2 = r5.mReceiver     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L55
            r0.setLifecycleListenerForUid(r2)     // Catch: android.os.RemoteException -> L3f java.lang.Throwable -> L55
            goto L43
        L3f:
            r0 = move-exception
            r5.handleRemoteExceptionFromCarService(r0)     // Catch: java.lang.Throwable -> L55
        L43:
            android.util.ArrayMap<android.car.user.CarUserManager$UserLifecycleListener, java.util.concurrent.Executor> r0 = r5.mListeners     // Catch: java.lang.Throwable -> L55
            if (r0 != 0) goto L4e
            android.util.ArrayMap r0 = new android.util.ArrayMap     // Catch: java.lang.Throwable -> L55
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L55
            r5.mListeners = r0     // Catch: java.lang.Throwable -> L55
        L4e:
            android.util.ArrayMap<android.car.user.CarUserManager$UserLifecycleListener, java.util.concurrent.Executor> r0 = r5.mListeners     // Catch: java.lang.Throwable -> L55
            r0.put(r7, r6)     // Catch: java.lang.Throwable -> L55
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L55
            return
        L55:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L55
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.car.user.CarUserManager.addListener(java.util.concurrent.Executor, android.car.user.CarUserManager$UserLifecycleListener):void");
    }

    @SystemApi
    public void removeListener(UserLifecycleListener userLifecycleListener) {
        Objects.requireNonNull(userLifecycleListener, "listener cannot be null");
        int myUid = Process.myUid();
        synchronized (this.mLock) {
            ArrayMap<UserLifecycleListener, Executor> arrayMap = this.mListeners;
            Preconditions.checkState(arrayMap != null && arrayMap.containsKey(userLifecycleListener), "not called for this listener yet");
            this.mListeners.remove(userLifecycleListener);
            if (this.mListeners.isEmpty()) {
                this.mListeners = null;
                if (this.mReceiver == null) {
                    Log.wtf(TAG, "removeListener(): receiver already null");
                    return;
                }
                EventLog.writeEvent(EventLogTags.CAR_USER_MGR_REMOVE_LISTENER, myUid);
                try {
                    this.mService.resetLifecycleListenerForUid();
                    this.mReceiver = null;
                } catch (RemoteException e) {
                    handleRemoteExceptionFromCarService(e);
                }
            }
        }
    }

    public boolean isUserHalUserAssociationSupported() {
        try {
            return this.mService.isUserHalUserAssociationSupported();
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, false)).booleanValue();
        }
    }

    public UserIdentificationAssociationResponse getUserIdentificationAssociation(int... iArr) {
        Preconditions.checkArgument(!ArrayUtils.isEmpty(iArr), "must have at least one type");
        EventLog.writeEvent(EventLogTags.CAR_USER_MGR_GET_USER_AUTH_REQ, iArr.length);
        try {
            UserIdentificationAssociationResponse userIdentificationAssociation = this.mService.getUserIdentificationAssociation(iArr);
            if (userIdentificationAssociation != null) {
                int[] values = userIdentificationAssociation.getValues();
                EventLog.writeEvent(EventLogTags.CAR_USER_MGR_GET_USER_AUTH_RESP, values != null ? values.length : 0);
            }
            return userIdentificationAssociation;
        } catch (RemoteException e) {
            return (UserIdentificationAssociationResponse) handleRemoteExceptionFromCarService(e, null);
        }
    }

    public AndroidFuture<UserIdentificationAssociationResponse> setUserIdentificationAssociation(int[] iArr, int[] iArr2) {
        Preconditions.checkArgument(!ArrayUtils.isEmpty(iArr), "must have at least one type");
        Preconditions.checkArgument(!ArrayUtils.isEmpty(iArr2), "must have at least one value");
        if (iArr.length != iArr2.length) {
            throw new IllegalArgumentException("types (" + Arrays.toString(iArr) + ") and values (" + Arrays.toString(iArr2) + ") should have the same length");
        }
        Integer[] numArr = new Integer[iArr.length * 2];
        for (int i = 0; i < iArr.length; i++) {
            int i2 = i * 2;
            numArr[i2] = Integer.valueOf(iArr[i]);
            numArr[i2 + 1] = Integer.valueOf(iArr2[i]);
        }
        EventLog.writeEvent(EventLogTags.CAR_USER_MGR_SET_USER_AUTH_REQ, numArr);
        try {
            AnonymousClass3 anonymousClass3 = new AndroidFuture<UserIdentificationAssociationResponse>() { // from class: android.car.user.CarUserManager.3
                final /* synthetic */ int[] val$types;
                final /* synthetic */ int[] val$values;

                AnonymousClass3(int[] iArr3, int[] iArr22) {
                    r2 = iArr3;
                    r3 = iArr22;
                }

                public void onCompleted(UserIdentificationAssociationResponse userIdentificationAssociationResponse, Throwable th) {
                    if (userIdentificationAssociationResponse != null) {
                        int[] values = userIdentificationAssociationResponse.getValues();
                        if (values != null) {
                            Object[] objArr = new Object[values.length];
                            for (int i3 = 0; i3 < values.length; i3++) {
                                objArr[i3] = Integer.valueOf(values[i3]);
                            }
                            EventLog.writeEvent(EventLogTags.CAR_USER_MGR_SET_USER_AUTH_RESP, objArr);
                        }
                    } else {
                        Log.w(CarUserManager.TAG, "setUserIdentificationAssociation(" + Arrays.toString(r2) + ", " + Arrays.toString(r3) + ") failed: " + th);
                    }
                    super.onCompleted(userIdentificationAssociationResponse, th);
                }
            };
            this.mService.setUserIdentificationAssociation(HAL_TIMEOUT_MS, iArr3, iArr22, anonymousClass3);
            return anonymousClass3;
        } catch (RemoteException e) {
            AndroidFuture androidFuture = new AndroidFuture();
            androidFuture.complete(UserIdentificationAssociationResponse.forFailure());
            return (AndroidFuture) handleRemoteExceptionFromCarService(e, androidFuture);
        }
    }

    /* renamed from: android.car.user.CarUserManager$3 */
    class AnonymousClass3 extends AndroidFuture<UserIdentificationAssociationResponse> {
        final /* synthetic */ int[] val$types;
        final /* synthetic */ int[] val$values;

        AnonymousClass3(int[] iArr3, int[] iArr22) {
            r2 = iArr3;
            r3 = iArr22;
        }

        public void onCompleted(UserIdentificationAssociationResponse userIdentificationAssociationResponse, Throwable th) {
            if (userIdentificationAssociationResponse != null) {
                int[] values = userIdentificationAssociationResponse.getValues();
                if (values != null) {
                    Object[] objArr = new Object[values.length];
                    for (int i3 = 0; i3 < values.length; i3++) {
                        objArr[i3] = Integer.valueOf(values[i3]);
                    }
                    EventLog.writeEvent(EventLogTags.CAR_USER_MGR_SET_USER_AUTH_RESP, objArr);
                }
            } else {
                Log.w(CarUserManager.TAG, "setUserIdentificationAssociation(" + Arrays.toString(r2) + ", " + Arrays.toString(r3) + ") failed: " + th);
            }
            super.onCompleted(userIdentificationAssociationResponse, th);
        }
    }

    public void setUserSwitchUiCallback(UserSwitchUiCallback userSwitchUiCallback) {
        Preconditions.checkArgument(userSwitchUiCallback != null, "Null callback");
        try {
            this.mService.setUserSwitchUiCallback(new UserSwitchUiCallbackReceiver(userSwitchUiCallback));
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    private final class UserSwitchUiCallbackReceiver extends IResultReceiver.Stub {
        private final UserSwitchUiCallback mUserSwitchUiCallback;

        UserSwitchUiCallbackReceiver(UserSwitchUiCallback userSwitchUiCallback) {
            this.mUserSwitchUiCallback = userSwitchUiCallback;
        }

        public void send(int i, Bundle bundle) throws RemoteException {
            this.mUserSwitchUiCallback.showUserSwitchDialog(i);
        }
    }

    class LifecycleResultReceiver extends IResultReceiver.Stub {
        private LifecycleResultReceiver() {
        }

        /* synthetic */ LifecycleResultReceiver(CarUserManager carUserManager, AnonymousClass1 anonymousClass1) {
            this();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: android.car.user.CarUserManager$LifecycleResultReceiver$$ExternalSyntheticLambda0.<init>(android.car.user.CarUserManager$UserLifecycleListener, android.car.user.CarUserManager$UserLifecycleEvent):void, class status: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
            	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
            	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
            */
        public void send(int r8, android.os.Bundle r9) {
            /*
                r7 = this;
                if (r9 != 0) goto L1f
                java.lang.String r9 = android.car.user.CarUserManager.access$000()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Received result ("
                r0.<init>(r1)
                java.lang.StringBuilder r8 = r0.append(r8)
                java.lang.String r0 = ") without data"
                java.lang.StringBuilder r8 = r8.append(r0)
                java.lang.String r8 = r8.toString()
                android.util.Log.w(r9, r8)
                return
            L1f:
                java.lang.String r0 = "previous_user"
                r1 = -10000(0xffffffffffffd8f0, float:NaN)
                int r0 = r9.getInt(r0, r1)
                java.lang.String r1 = "action"
                int r9 = r9.getInt(r1)
                android.car.user.CarUserManager$UserLifecycleEvent r1 = new android.car.user.CarUserManager$UserLifecycleEvent
                r1.<init>(r9, r0, r8)
                android.car.user.CarUserManager r2 = android.car.user.CarUserManager.this
                java.lang.Object r2 = android.car.user.CarUserManager.access$300(r2)
                monitor-enter(r2)
                android.car.user.CarUserManager r3 = android.car.user.CarUserManager.this     // Catch: java.lang.Throwable -> L9c
                android.util.ArrayMap r3 = android.car.user.CarUserManager.access$400(r3)     // Catch: java.lang.Throwable -> L9c
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L9c
                if (r3 != 0) goto L59
                java.lang.String r8 = android.car.user.CarUserManager.access$000()
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                java.lang.String r0 = "No listeners for event "
                r9.<init>(r0)
                java.lang.StringBuilder r9 = r9.append(r1)
                java.lang.String r9 = r9.toString()
                android.util.Log.w(r8, r9)
                return
            L59:
                int r2 = r3.size()
                r4 = 4
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
                r6 = 0
                r4[r6] = r5
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                r5 = 1
                r4[r5] = r9
                r9 = 2
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r4[r9] = r0
                r9 = 3
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                r4[r9] = r8
                r8 = 150184(0x24aa8, float:2.10453E-40)
                android.util.EventLog.writeEvent(r8, r4)
            L82:
                if (r6 >= r2) goto L9b
                java.lang.Object r8 = r3.keyAt(r6)
                android.car.user.CarUserManager$UserLifecycleListener r8 = (android.car.user.CarUserManager.UserLifecycleListener) r8
                java.lang.Object r9 = r3.valueAt(r6)
                java.util.concurrent.Executor r9 = (java.util.concurrent.Executor) r9
                android.car.user.CarUserManager$LifecycleResultReceiver$$ExternalSyntheticLambda0 r0 = new android.car.user.CarUserManager$LifecycleResultReceiver$$ExternalSyntheticLambda0
                r0.<init>()
                r9.execute(r0)
                int r6 = r6 + 1
                goto L82
            L9b:
                return
            L9c:
                r8 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L9c
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: android.car.user.CarUserManager.LifecycleResultReceiver.send(int, android.os.Bundle):void");
        }
    }

    public static String lifecycleEventTypeToString(int i) {
        switch (i) {
            case 1:
                return "STARTING";
            case 2:
                return "SWITCHING";
            case 3:
                return "UNLOCKING";
            case 4:
                return "UNLOCKED";
            case 5:
                return "STOPPING";
            case 6:
                return "STOPPED";
            default:
                return "UNKNOWN-" + i;
        }
    }

    ExperimentalCarUserManager newExperimentalCarUserManager() {
        return new ExperimentalCarUserManager(this.mCar, this.mService);
    }

    public boolean isValidUser(int i) {
        List users = this.mUserManager.getUsers(true);
        for (int i2 = 0; i2 < users.size(); i2++) {
            if (((UserInfo) users.get(i2)).id == i && (i != 0 || !UserManager.isHeadlessSystemUserMode())) {
                return true;
            }
        }
        return false;
    }

    private boolean isHeadlessSystemUser(int i) {
        return i == 0 && UserManager.isHeadlessSystemUserMode();
    }

    private static String safeName(String str) {
        return str == null ? str : str.length() + "_chars";
    }

    @SystemApi
    public static final class UserLifecycleEvent {
        private final int mEventType;
        private final int mPreviousUserId;
        private final int mUserId;

        public UserLifecycleEvent(int i, int i2, int i3) {
            this.mEventType = i;
            this.mPreviousUserId = i2;
            this.mUserId = i3;
        }

        public UserLifecycleEvent(int i, int i2) {
            this(i, -10000, i2);
        }

        public int getEventType() {
            return this.mEventType;
        }

        public int getUserId() {
            return this.mUserId;
        }

        public UserHandle getUserHandle() {
            return UserHandle.of(this.mUserId);
        }

        public int getPreviousUserId() {
            return this.mPreviousUserId;
        }

        public UserHandle getPreviousUserHandle() {
            int i = this.mPreviousUserId;
            if (i == -10000) {
                return null;
            }
            return UserHandle.of(i);
        }

        public String toString() {
            StringBuilder append = new StringBuilder("Event[type=").append(CarUserManager.lifecycleEventTypeToString(this.mEventType));
            if (this.mPreviousUserId != -10000) {
                append.append(",from=").append(this.mPreviousUserId).append(",to=").append(this.mUserId);
            } else {
                append.append(",user=").append(this.mUserId);
            }
            return append.append(']').toString();
        }
    }
}
