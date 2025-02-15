package android.car.vms;

import android.annotation.SystemApi;
import android.car.vms.IVmsClientCallback;
import android.car.vms.VmsClient;
import android.car.vms.VmsClientManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@SystemApi
/* loaded from: classes.dex */
public final class VmsClient {
    private static final boolean DBG = false;
    private static final VmsAvailableLayers DEFAULT_AVAILABLE_LAYERS = new VmsAvailableLayers((Set<VmsAssociatedLayer>) Collections.emptySet(), 0);
    private static final VmsSubscriptionState DEFAULT_SUBSCRIPTIONS = new VmsSubscriptionState(0, Collections.emptySet(), Collections.emptySet());
    private static final int LARGE_PACKET_THRESHOLD = 16384;
    private static final String TAG = "VmsClient";
    private final VmsClientManager.VmsClientCallback mCallback;
    private final IVmsClientCallback mClientCallback;
    private final Consumer<RemoteException> mExceptionHandler;
    private final Executor mExecutor;
    private final boolean mLegacyClient;
    private boolean mMonitoringEnabled;
    private final IVmsBrokerService mService;
    private final Object mLock = new Object();
    private VmsAvailableLayers mAvailableLayers = DEFAULT_AVAILABLE_LAYERS;
    private VmsSubscriptionState mSubscriptionState = DEFAULT_SUBSCRIPTIONS;
    private final IBinder mClientToken = new Binder();

    public VmsClient(IVmsBrokerService iVmsBrokerService, Executor executor, VmsClientManager.VmsClientCallback vmsClientCallback, boolean z, boolean z2, Consumer<RemoteException> consumer) {
        this.mService = iVmsBrokerService;
        this.mExecutor = executor;
        this.mCallback = vmsClientCallback;
        this.mLegacyClient = z;
        this.mClientCallback = new IVmsClientCallbackImpl(z2);
        this.mExceptionHandler = consumer;
    }

    public byte[] getProviderDescription(int i) {
        try {
            return this.mService.getProviderInfo(this.mClientToken, i).getDescription();
        } catch (RemoteException e) {
            Log.e(TAG, "While getting publisher information for " + i, e);
            this.mExceptionHandler.accept(e);
            return null;
        }
    }

    public void setSubscriptions(Set<VmsAssociatedLayer> set) {
        try {
            this.mService.setSubscriptions(this.mClientToken, new ArrayList(set));
        } catch (RemoteException e) {
            Log.e(TAG, "While setting subscriptions", e);
            this.mExceptionHandler.accept(e);
        }
    }

    public void setMonitoringEnabled(boolean z) {
        try {
            this.mService.setMonitoringEnabled(this.mClientToken, z);
            synchronized (this.mLock) {
                this.mMonitoringEnabled = z;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "While setting monitoring state to " + z, e);
            this.mExceptionHandler.accept(e);
        }
    }

    public boolean isMonitoringEnabled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mMonitoringEnabled;
        }
        return z;
    }

    public VmsAvailableLayers getAvailableLayers() {
        VmsAvailableLayers vmsAvailableLayers;
        synchronized (this.mLock) {
            vmsAvailableLayers = this.mAvailableLayers;
        }
        return vmsAvailableLayers;
    }

    public int registerProvider(byte[] bArr) {
        Objects.requireNonNull(bArr, "providerDescription cannot be null");
        try {
            return this.mService.registerProvider(this.mClientToken, new VmsProviderInfo(bArr));
        } catch (RemoteException e) {
            Log.e(TAG, "While registering provider", e);
            this.mExceptionHandler.accept(e);
            return -1;
        }
    }

    public void unregisterProvider(int i) {
        try {
            setProviderOfferings(i, Collections.emptySet());
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "While unregistering provider " + i, e);
        }
    }

    public void setProviderOfferings(int i, Set<VmsLayerDependency> set) {
        Objects.requireNonNull(set, "offerings cannot be null");
        try {
            this.mService.setProviderOfferings(this.mClientToken, i, new ArrayList(set));
        } catch (RemoteException e) {
            Log.e(TAG, "While setting provider offerings for " + i, e);
            this.mExceptionHandler.accept(e);
        }
    }

    public void publishPacket(int i, VmsLayer vmsLayer, byte[] bArr) {
        Objects.requireNonNull(vmsLayer, "layer cannot be null");
        Objects.requireNonNull(bArr, "packet cannot be null");
        try {
            if (bArr.length < 16384) {
                this.mService.publishPacket(this.mClientToken, i, vmsLayer, bArr);
                return;
            }
            SharedMemory packetToSharedMemory = packetToSharedMemory(bArr);
            try {
                this.mService.publishLargePacket(this.mClientToken, i, vmsLayer, packetToSharedMemory);
                if (packetToSharedMemory != null) {
                    packetToSharedMemory.close();
                }
            } finally {
            }
        } catch (RemoteException e) {
            Log.e(TAG, "While publishing packet as " + i);
            this.mExceptionHandler.accept(e);
        }
    }

    public VmsSubscriptionState getSubscriptionState() {
        VmsSubscriptionState vmsSubscriptionState;
        synchronized (this.mLock) {
            vmsSubscriptionState = this.mSubscriptionState;
        }
        return vmsSubscriptionState;
    }

    public void register() throws RemoteException {
        VmsRegistrationInfo registerClient = this.mService.registerClient(this.mClientToken, this.mClientCallback, this.mLegacyClient);
        synchronized (this.mLock) {
            this.mAvailableLayers = registerClient.getAvailableLayers();
            this.mSubscriptionState = registerClient.getSubscriptionState();
        }
    }

    public void unregister() throws RemoteException {
        this.mService.unregisterClient(this.mClientToken);
    }

    static class IVmsClientCallbackImpl extends IVmsClientCallback.Stub {
        private final boolean mAutoCloseMemory;
        private final WeakReference<VmsClient> mClient;

        /* synthetic */ IVmsClientCallbackImpl(VmsClient vmsClient, boolean z, AnonymousClass1 anonymousClass1) {
            this(vmsClient, z);
        }

        private IVmsClientCallbackImpl(VmsClient vmsClient, boolean z) {
            this.mClient = new WeakReference<>(vmsClient);
            this.mAutoCloseMemory = z;
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onLayerAvailabilityChanged(VmsAvailableLayers vmsAvailableLayers) {
            executeCallback(new BiConsumer() { // from class: android.car.vms.VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda1
                public /* synthetic */ VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda1() {
                }

                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    VmsClient.IVmsClientCallbackImpl.lambda$onLayerAvailabilityChanged$0(VmsAvailableLayers.this, (VmsClient) obj, (VmsClientManager.VmsClientCallback) obj2);
                }
            });
        }

        static /* synthetic */ void lambda$onLayerAvailabilityChanged$0(VmsAvailableLayers vmsAvailableLayers, VmsClient vmsClient, VmsClientManager.VmsClientCallback vmsClientCallback) {
            synchronized (vmsClient.mLock) {
                vmsClient.mAvailableLayers = vmsAvailableLayers;
            }
            vmsClientCallback.onLayerAvailabilityChanged(vmsAvailableLayers);
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onSubscriptionStateChanged(VmsSubscriptionState vmsSubscriptionState) {
            executeCallback(new BiConsumer() { // from class: android.car.vms.VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda0
                public /* synthetic */ VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda0() {
                }

                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    VmsClient.IVmsClientCallbackImpl.lambda$onSubscriptionStateChanged$1(VmsSubscriptionState.this, (VmsClient) obj, (VmsClientManager.VmsClientCallback) obj2);
                }
            });
        }

        static /* synthetic */ void lambda$onSubscriptionStateChanged$1(VmsSubscriptionState vmsSubscriptionState, VmsClient vmsClient, VmsClientManager.VmsClientCallback vmsClientCallback) {
            synchronized (vmsClient.mLock) {
                vmsClient.mSubscriptionState = vmsSubscriptionState;
            }
            vmsClientCallback.onSubscriptionStateChanged(vmsSubscriptionState);
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onPacketReceived(int i, VmsLayer vmsLayer, byte[] bArr) {
            executeCallback(new BiConsumer() { // from class: android.car.vms.VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda3
                public final /* synthetic */ int f$0;
                public final /* synthetic */ VmsLayer f$1;
                public final /* synthetic */ byte[] f$2;

                public /* synthetic */ VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda3(int i2, VmsLayer vmsLayer2, byte[] bArr2) {
                    r1 = i2;
                    r2 = vmsLayer2;
                    r3 = bArr2;
                }

                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((VmsClientManager.VmsClientCallback) obj2).onPacketReceived(r1, r2, r3);
                }
            });
        }

        @Override // android.car.vms.IVmsClientCallback
        public void onLargePacketReceived(int i, VmsLayer vmsLayer, SharedMemory sharedMemory) {
            byte[] sharedMemoryToPacket;
            if (this.mAutoCloseMemory) {
                try {
                    sharedMemoryToPacket = VmsClient.sharedMemoryToPacket(sharedMemory);
                    if (sharedMemory != null) {
                        sharedMemory.close();
                    }
                } catch (Throwable th) {
                    if (sharedMemory != null) {
                        try {
                            sharedMemory.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } else {
                sharedMemoryToPacket = VmsClient.sharedMemoryToPacket(sharedMemory);
            }
            executeCallback(new BiConsumer() { // from class: android.car.vms.VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda2
                public final /* synthetic */ int f$0;
                public final /* synthetic */ VmsLayer f$1;
                public final /* synthetic */ byte[] f$2;

                public /* synthetic */ VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda2(int i2, VmsLayer vmsLayer2, byte[] sharedMemoryToPacket2) {
                    r1 = i2;
                    r2 = vmsLayer2;
                    r3 = sharedMemoryToPacket2;
                }

                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((VmsClientManager.VmsClientCallback) obj2).onPacketReceived(r1, r2, r3);
                }
            });
        }

        private void executeCallback(BiConsumer<VmsClient, VmsClientManager.VmsClientCallback> biConsumer) {
            VmsClient vmsClient = this.mClient.get();
            if (vmsClient == null) {
                Log.w(VmsClient.TAG, "VmsClient unavailable");
                return;
            }
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                vmsClient.mExecutor.execute(new Runnable() { // from class: android.car.vms.VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda4
                    public final /* synthetic */ BiConsumer f$0;
                    public final /* synthetic */ VmsClient f$1;

                    public /* synthetic */ VmsClient$IVmsClientCallbackImpl$$ExternalSyntheticLambda4(BiConsumer biConsumer2, VmsClient vmsClient2) {
                        r1 = biConsumer2;
                        r2 = vmsClient2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        r1.accept(r1, r2.mCallback);
                    }
                });
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    private static SharedMemory packetToSharedMemory(byte[] bArr) {
        try {
            SharedMemory create = SharedMemory.create(TAG, bArr.length);
            ByteBuffer byteBuffer = null;
            try {
                try {
                    byteBuffer = create.mapReadWrite();
                    byteBuffer.put(bArr);
                    if (create.setProtect(OsConstants.PROT_READ)) {
                        return create;
                    }
                    create.close();
                    throw new SecurityException("Failed to set read-only protection on shared memory");
                } catch (ErrnoException e) {
                    create.close();
                    throw new IllegalStateException("Failed to create write buffer", e);
                }
            } finally {
                if (byteBuffer != null) {
                    SharedMemory.unmap(byteBuffer);
                }
            }
        } catch (ErrnoException e2) {
            throw new IllegalStateException("Failed to allocate shared memory", e2);
        }
    }

    public static byte[] sharedMemoryToPacket(SharedMemory sharedMemory) {
        try {
            ByteBuffer mapReadOnly = sharedMemory.mapReadOnly();
            try {
                byte[] bArr = new byte[mapReadOnly.capacity()];
                mapReadOnly.get(bArr);
                return bArr;
            } finally {
                SharedMemory.unmap(mapReadOnly);
            }
        } catch (ErrnoException e) {
            throw new IllegalStateException("Failed to create read buffer", e);
        }
    }
}
