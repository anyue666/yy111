package android.car.vms;

import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseBooleanArray;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* loaded from: classes.dex */
public final class VmsSubscriptionHelper {
    private boolean mPendingUpdate;
    private final Consumer<Set<VmsAssociatedLayer>> mUpdateHandler;
    private final Object mLock = new Object();
    private final Set<VmsLayer> mLayerSubscriptions = new ArraySet();
    private final Map<VmsLayer, SparseBooleanArray> mPublisherSubscriptions = new ArrayMap();

    public VmsSubscriptionHelper(Consumer<Set<VmsAssociatedLayer>> consumer) {
        this.mUpdateHandler = (Consumer) Objects.requireNonNull(consumer, "updateHandler cannot be null");
    }

    public void subscribe(VmsLayer vmsLayer) {
        Objects.requireNonNull(vmsLayer, "layer cannot be null");
        synchronized (this.mLock) {
            if (this.mLayerSubscriptions.add(vmsLayer)) {
                this.mPendingUpdate = true;
            }
            publishSubscriptionUpdate();
        }
    }

    public void subscribe(VmsLayer vmsLayer, int i) {
        Objects.requireNonNull(vmsLayer, "layer cannot be null");
        synchronized (this.mLock) {
            SparseBooleanArray computeIfAbsent = this.mPublisherSubscriptions.computeIfAbsent(vmsLayer, new Function() { // from class: android.car.vms.VmsSubscriptionHelper$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return VmsSubscriptionHelper.lambda$subscribe$0((VmsLayer) obj);
                }
            });
            if (!computeIfAbsent.get(i)) {
                computeIfAbsent.put(i, true);
                this.mPendingUpdate = true;
            }
            publishSubscriptionUpdate();
        }
    }

    static /* synthetic */ SparseBooleanArray lambda$subscribe$0(VmsLayer vmsLayer) {
        return new SparseBooleanArray();
    }

    public void unsubscribe(VmsLayer vmsLayer) {
        Objects.requireNonNull(vmsLayer, "layer cannot be null");
        synchronized (this.mLock) {
            if (this.mLayerSubscriptions.remove(vmsLayer)) {
                this.mPendingUpdate = true;
            }
            publishSubscriptionUpdate();
        }
    }

    public void unsubscribe(VmsLayer vmsLayer, int i) {
        Objects.requireNonNull(vmsLayer, "layer cannot be null");
        synchronized (this.mLock) {
            SparseBooleanArray sparseBooleanArray = this.mPublisherSubscriptions.get(vmsLayer);
            if (sparseBooleanArray != null && sparseBooleanArray.get(i)) {
                sparseBooleanArray.delete(i);
                if (sparseBooleanArray.size() == 0) {
                    this.mPublisherSubscriptions.remove(vmsLayer);
                }
                this.mPendingUpdate = true;
            }
            publishSubscriptionUpdate();
        }
    }

    public Set<VmsAssociatedLayer> getSubscriptions() {
        return (Set) Stream.concat(this.mLayerSubscriptions.stream().map(new Function() { // from class: android.car.vms.VmsSubscriptionHelper$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return VmsSubscriptionHelper.lambda$getSubscriptions$1((VmsLayer) obj);
            }
        }), this.mPublisherSubscriptions.entrySet().stream().filter(new Predicate() { // from class: android.car.vms.VmsSubscriptionHelper$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return VmsSubscriptionHelper.this.m13lambda$getSubscriptions$2$androidcarvmsVmsSubscriptionHelper((Map.Entry) obj);
            }
        }).map(new Function() { // from class: android.car.vms.VmsSubscriptionHelper$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                VmsAssociatedLayer associatedLayer;
                associatedLayer = VmsSubscriptionHelper.toAssociatedLayer((Map.Entry) obj);
                return associatedLayer;
            }
        })).collect(Collectors.toSet());
    }

    static /* synthetic */ VmsAssociatedLayer lambda$getSubscriptions$1(VmsLayer vmsLayer) {
        return new VmsAssociatedLayer(vmsLayer, Collections.emptySet());
    }

    /* renamed from: lambda$getSubscriptions$2$android-car-vms-VmsSubscriptionHelper, reason: not valid java name */
    /* synthetic */ boolean m13lambda$getSubscriptions$2$androidcarvmsVmsSubscriptionHelper(Map.Entry entry) {
        return !this.mLayerSubscriptions.contains(entry.getKey());
    }

    private void publishSubscriptionUpdate() {
        synchronized (this.mLock) {
            if (this.mPendingUpdate) {
                this.mUpdateHandler.accept(getSubscriptions());
            }
            this.mPendingUpdate = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static VmsAssociatedLayer toAssociatedLayer(Map.Entry<VmsLayer, SparseBooleanArray> entry) {
        SparseBooleanArray value = entry.getValue();
        ArraySet arraySet = new ArraySet(value.size());
        for (int i = 0; i < value.size(); i++) {
            arraySet.add(Integer.valueOf(value.keyAt(i)));
        }
        return new VmsAssociatedLayer(entry.getKey(), arraySet);
    }
}
