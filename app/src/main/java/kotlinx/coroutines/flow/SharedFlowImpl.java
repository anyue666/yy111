package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* compiled from: SharedFlow.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020,H\u0002J\u001f\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\bH\u0014¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020,H\u0002J\u0019\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000¢\u0006\u0002\bgR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006i"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        return emit$suspendImpl(this, t, continuation);
    }

    public SharedFlowImpl(int i, int i2, BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i2;
        this.onBufferOverflow = bufferOverflow;
    }

    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    protected final T getLastReplayedLocked() {
        Object bufferAt;
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        bufferAt = SharedFlowKt.getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
        return (T) bufferAt;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:42|43))(1:44)|12|13|14|15|(3:16|(4:26|(1:28)(1:34)|29|(2:31|32)(1:33))(3:18|19|(2:21|22)(1:24))|25))(4:45|46|47|48)|38|39)(5:54|55|56|(2:58|(1:60))|62)|49|50|15|(3:16|(0)(0)|25)))|65|6|(0)(0)|49|50|15|(3:16|(0)(0)|25)) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d6, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
    
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        int i;
        boolean z;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            i = 0;
            if (tryEmitLocked(value)) {
                continuationArr = findSlotsToResumeLocked(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        int length = continuationArr.length;
        while (i < length) {
            Continuation<Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m131constructorimpl(Unit.INSTANCE));
            }
        }
        return z;
    }

    static /* synthetic */ Object emit$suspendImpl(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        Object emitSuspend;
        return (!sharedFlowImpl.tryEmit(obj) && (emitSuspend = sharedFlowImpl.emitSuspend(obj, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? emitSuspend : Unit.INSTANCE;
    }

    public final boolean tryEmitLocked(T value) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        enqueueLocked(value);
        int i2 = this.bufferSize + 1;
        this.bufferSize = i2;
        if (i2 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getNCollectors() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(value);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getHead() == head)) {
                throw new AssertionError();
            }
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowImpl<T> sharedFlowImpl = this;
        if (((AbstractSharedFlow) sharedFlowImpl).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) sharedFlowImpl).slots) != null) {
            int length = abstractSharedFlowSlotArr.length;
            int i = 0;
            while (i < length) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                i++;
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    if (sharedFlowSlot.index >= 0 && sharedFlowSlot.index < newHead) {
                        sharedFlowSlot.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    public final void enqueueLocked(Object item) {
        int totalSize = getTotalSize();
        Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = growBuffer(null, 0, 2);
        } else if (totalSize >= objArr.length) {
            objArr = growBuffer(objArr, totalSize, objArr.length * 2);
        }
        SharedFlowKt.setBufferAt(objArr, getHead() + totalSize, item);
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        Object bufferAt;
        int i = 0;
        if (!(newSize > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer == null) {
            return objArr;
        }
        long head = getHead();
        while (i < curSize) {
            int i2 = i + 1;
            long j = i + head;
            bufferAt = SharedFlowKt.getBufferAt(curBuffer, j);
            SharedFlowKt.setBufferAt(objArr, j, bufferAt);
            i = i2;
        }
        return objArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j = this.replayIndex;
        if (j < this.minCollectorIndex) {
            this.minCollectorIndex = j;
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f0, code lost:
    
        r7 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long r23) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.updateCollectorIndexLocked$kotlinx_coroutines_core(long):kotlin.coroutines.Continuation[]");
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long min = Math.min(newMinCollectorIndex, newReplayIndex);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(min >= getHead())) {
                throw new AssertionError();
            }
        }
        for (long head = getHead(); head < min; head = 1 + head) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.setBufferAt(objArr, head, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - min);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.bufferSize >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.queueSize >= 0)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.replayIndex <= getHead() + ((long) this.bufferSize))) {
                throw new AssertionError();
            }
        }
    }

    private final void cleanupTailLocked() {
        Object bufferAt;
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            while (this.queueSize > 0) {
                bufferAt = SharedFlowKt.getBufferAt(objArr, (getHead() + getTotalSize()) - 1);
                if (bufferAt != SharedFlowKt.NO_VALUE) {
                    return;
                }
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + getTotalSize(), null);
            }
        }
    }

    private final Object tryTakeValue(SharedFlowSlot slot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long tryPeekLocked = tryPeekLocked(slot);
            if (tryPeekLocked < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j = slot.index;
                Object peekedValueLockedAt = getPeekedValueLockedAt(tryPeekLocked);
                slot.index = tryPeekLocked + 1;
                continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j);
                obj = peekedValueLockedAt;
            }
        }
        int length = continuationArr.length;
        int i = 0;
        while (i < length) {
            Continuation<Unit> continuation = continuationArr[i];
            i++;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m131constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    public final long tryPeekLocked(SharedFlowSlot slot) {
        long j = slot.index;
        if (j < getBufferEndIndex()) {
            return j;
        }
        if (this.bufferCapacity <= 0 && j <= getHead() && this.queueSize != 0) {
            return j;
        }
        return -1L;
    }

    private final Object getPeekedValueLockedAt(long index) {
        Object bufferAt;
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        bufferAt = SharedFlowKt.getBufferAt(objArr, index);
        return bufferAt instanceof Emitter ? ((Emitter) bufferAt).value : bufferAt;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object, java.lang.Object[]] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] resumesIn) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = resumesIn.length;
        SharedFlowImpl<T> sharedFlowImpl = this;
        if (((AbstractSharedFlow) sharedFlowImpl).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) sharedFlowImpl).slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i = 0;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                i++;
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    Continuation<Unit>[] continuationArr = resumesIn;
                    resumesIn = resumesIn;
                    if (length >= continuationArr.length) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        resumesIn = copyOf;
                    }
                    resumesIn[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
            }
        }
        return resumesIn;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    /* compiled from: SharedFlow.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j, Object obj, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        Object bufferAt;
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            int i = 0;
            while (i < replaySize) {
                int i2 = i + 1;
                bufferAt = SharedFlowKt.getBufferAt(objArr, this.replayIndex + i);
                arrayList.add(bufferAt);
                i = i2;
            }
            return arrayList;
        }
    }

    public final Object emitSuspend(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t)) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m131constructorimpl(Unit.INSTANCE));
                continuationArr = findSlotsToResumeLocked(continuationArr2);
                emitter = null;
            } else {
                Emitter emitter2 = new Emitter(this, getTotalSize() + getHead(), t, cancellableContinuationImpl2);
                enqueueLocked(emitter2);
                this.queueSize++;
                if (this.bufferCapacity == 0) {
                    continuationArr2 = findSlotsToResumeLocked(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl2, emitter);
        }
        int length = continuationArr.length;
        int i = 0;
        while (i < length) {
            Continuation<Unit> continuation2 = continuationArr[i];
            i++;
            if (continuation2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m131constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public final void cancelEmitter(Emitter emitter) {
        Object bufferAt;
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            bufferAt = SharedFlowKt.getBufferAt(objArr, emitter.index);
            if (bufferAt != emitter) {
                return;
            }
            SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        synchronized (this) {
            if (tryPeekLocked(sharedFlowSlot) < 0) {
                sharedFlowSlot.cont = cancellableContinuationImpl2;
                sharedFlowSlot.cont = cancellableContinuationImpl2;
            } else {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m131constructorimpl(Unit.INSTANCE));
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }
}
