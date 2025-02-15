package kotlinx.coroutines.selects;

import android.car.AoapService;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilder;

/* compiled from: Select.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020Y2\b\u0012\u0004\u0012\u00028\u00000Z2\b\u0012\u0004\u0012\u00028\u00000[2\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060Bj\u0002`C:\u0004TUVWB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\fJ8\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0019H\u0016¢\u0006\u0004\b(\u0010\u001cJ \u0010+\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u001b\u00105\u001a\u0004\u0018\u00010\u000e2\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b5\u00106J5\u00108\u001a\u00020\b*\u0002072\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u00109JG\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010:*\b\u0012\u0004\u0012\u00028\u00010;2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010=J[\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010>\"\u0004\b\u0002\u0010:*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?2\u0006\u0010@\u001a\u00028\u00012\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010AR\u001c\u0010F\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00102R(\u0010R\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\nR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010S\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", "block", "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", AoapService.KEY_RESULT, "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "Lkotlin/coroutines/Continuation;", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _result;
    volatile /* synthetic */ Object _state = SelectKt.getNOT_SELECTED();
    private final Continuation<R> uCont;
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> continuation) {
        Object obj;
        this.uCont = continuation;
        obj = SelectKt.UNDECIDED;
        this._result = obj;
        this._parentHandle = null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.uCont;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void setParentHandle(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Continuation<R> getCompletion() {
        return this;
    }

    private final void doResume(Function0<? extends Object> value, Function0<Unit> block) {
        Object obj;
        Object obj2;
        Object obj3;
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.UNDECIDED;
            if (obj4 == obj) {
                Object invoke = value.invoke();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                obj2 = SelectKt.UNDECIDED;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj2, invoke)) {
                    return;
                }
            } else if (obj4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = SelectKt.RESUMED;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater2, this, coroutine_suspended, obj3)) {
                    block.invoke();
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    public final Object getResult() {
        Object obj;
        Object obj2;
        Object obj3;
        if (!isSelected()) {
            initCancellability();
        }
        Object obj4 = this._result;
        obj = SelectKt.UNDECIDED;
        if (obj4 == obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
            obj3 = SelectKt.UNDECIDED;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj3, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj4 = this._result;
        }
        obj2 = SelectKt.RESUMED;
        if (obj4 == obj2) {
            throw new IllegalStateException("Already resumed");
        }
        if (obj4 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) obj4).cause;
        }
        return obj4;
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new SelectOnCancelling(), 2, null);
        setParentHandle(invokeOnCompletion$default);
        if (isSelected()) {
            invokeOnCompletion$default.dispose();
        }
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class SelectOnCancelling extends JobCancellingNode {
        public SelectOnCancelling() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke */
        public void invoke2(Throwable cause) {
            if (SelectBuilderImpl.this.trySelect()) {
                SelectBuilderImpl.this.resumeSelectWithException(getJob().getCancellationException());
            }
        }
    }

    public final void handleBuilderException(Throwable e) {
        if (trySelect()) {
            Result.Companion companion = Result.INSTANCE;
            resumeWith(Result.m131constructorimpl(ResultKt.createFailure(e)));
        } else {
            if (e instanceof CancellationException) {
                return;
            }
            Object result = getResult();
            if (result instanceof CompletedExceptionally) {
                Throwable th = ((CompletedExceptionally) result).cause;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    th = StackTraceRecoveryKt.unwrapImpl(th);
                }
                if (th == (!DebugKt.getRECOVER_STACK_TRACES() ? e : StackTraceRecoveryKt.unwrapImpl(e))) {
                    return;
                }
            }
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), e);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(DisposableHandle handle) {
        DisposeNode disposeNode = new DisposeNode(handle);
        if (!isSelected()) {
            addLast(disposeNode);
            if (!isSelected()) {
                return;
            }
        }
        handle.dispose();
    }

    public final void doAfterSelect() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle != null) {
            parentHandle.dispose();
        }
        SelectBuilderImpl<R> selectBuilderImpl = this;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) selectBuilderImpl.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, selectBuilderImpl); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof DisposeNode) {
                ((DisposeNode) lockFreeLinkedListNode).handle.dispose();
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object trySelectOther = trySelectOther(null);
        if (trySelectOther == CancellableContinuationImplKt.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected trySelectIdempotent result ", trySelectOther).toString());
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class PairSelectOp extends OpDescriptor {
        public final LockFreeLinkedListNode.PrepareOp otherOp;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.otherOp = prepareOp;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object affected) {
            if (affected != null) {
                SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) affected;
                this.otherOp.finishPrepare();
                Object decide = this.otherOp.getAtomicOp().decide(null);
                LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(SelectBuilderImpl._state$FU, selectBuilderImpl, this, decide == null ? this.otherOp.desc : SelectKt.getNOT_SELECTED());
                return decide;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> getAtomicOp() {
            return this.otherOp.getAtomicOp();
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object performAtomicTrySelect(AtomicDesc desc) {
        return new AtomicSelectOp(this, desc).perform(null);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "impl", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "opSequence", "", "getOpSequence", "()J", "complete", "", "affected", "failure", "completeSelect", "prepare", "prepareSelectOp", "toString", "", "undoPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class AtomicSelectOp extends AtomicOp<Object> {
        public final AtomicDesc desc;
        public final SelectBuilderImpl<?> impl;
        private final long opSequence;

        public AtomicSelectOp(SelectBuilderImpl<?> selectBuilderImpl, AtomicDesc atomicDesc) {
            SeqNumber seqNumber;
            this.impl = selectBuilderImpl;
            this.desc = atomicDesc;
            seqNumber = SelectKt.selectOpSequenceNumber;
            this.opSequence = seqNumber.next();
            atomicDesc.setAtomicOp(this);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long getOpSequence() {
            return this.opSequence;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object prepare(Object affected) {
            Object prepareSelectOp;
            if (affected == null && (prepareSelectOp = prepareSelectOp()) != null) {
                return prepareSelectOp;
            }
            try {
                return this.desc.prepare(this);
            } catch (Throwable th) {
                if (affected == null) {
                    undoPrepare();
                }
                throw th;
            }
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object affected, Object failure) {
            completeSelect(failure);
            this.desc.complete(this, failure);
        }

        private final Object prepareSelectOp() {
            SelectBuilderImpl<?> selectBuilderImpl = this.impl;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this.impl);
                } else if (obj == SelectKt.getNOT_SELECTED()) {
                    if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(SelectBuilderImpl._state$FU, this.impl, SelectKt.getNOT_SELECTED(), this)) {
                        return null;
                    }
                } else {
                    return SelectKt.getALREADY_SELECTED();
                }
            }
        }

        private final void undoPrepare() {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(SelectBuilderImpl._state$FU, this.impl, this, SelectKt.getNOT_SELECTED());
        }

        private final void completeSelect(Object failure) {
            boolean z = failure == null;
            if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(SelectBuilderImpl._state$FU, this.impl, this, z ? null : SelectKt.getNOT_SELECTED()) && z) {
                this.impl.doAfterSelect();
            }
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "AtomicSelectOp(sequence=" + getOpSequence() + ')';
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectClause0.registerSelectClause0(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause2.registerSelectClause2(this, p, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> block) {
        if (timeMillis <= 0) {
            if (trySelect()) {
                UndispatchedKt.startCoroutineUnintercepted(block, getCompletion());
            }
        } else {
            disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(timeMillis, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
                final /* synthetic */ Function1 $block$inlined;

                public SelectBuilderImpl$onTimeout$$inlined$Runnable$1(Function1 block2) {
                    r2 = block2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (SelectBuilderImpl.this.trySelect()) {
                        CancellableKt.startCoroutineCancellable(r2, SelectBuilderImpl.this.getCompletion());
                    }
                }
            }, getContext()));
        }
    }

    /* compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle disposableHandle) {
            this.handle = disposableHandle;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r4) {
        Object obj;
        Object obj2;
        Object obj3;
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.UNDECIDED;
            if (obj4 == obj) {
                Object state$default = CompletionStateKt.toState$default(r4, null, 1, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                obj2 = SelectKt.UNDECIDED;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj2, state$default)) {
                    return;
                }
            } else if (obj4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = SelectKt.RESUMED;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater2, this, coroutine_suspended, obj3)) {
                    if (Result.m137isFailureimpl(r4)) {
                        Continuation<R> continuation = this.uCont;
                        Throwable m134exceptionOrNullimpl = Result.m134exceptionOrNullimpl(r4);
                        Intrinsics.checkNotNull(m134exceptionOrNullimpl);
                        Result.Companion companion = Result.INSTANCE;
                        if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                            m134exceptionOrNullimpl = StackTraceRecoveryKt.recoverFromStackFrame(m134exceptionOrNullimpl, (CoroutineStackFrame) continuation);
                        }
                        continuation.resumeWith(Result.m131constructorimpl(ResultKt.createFailure(m134exceptionOrNullimpl)));
                        return;
                    }
                    this.uCont.resumeWith(r4);
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(Throwable exception) {
        Object obj;
        Object obj2;
        Object obj3;
        if (DebugKt.getASSERTIONS_ENABLED() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = SelectKt.UNDECIDED;
            if (obj4 == obj) {
                Continuation<R> continuation = this.uCont;
                CompletedExceptionally completedExceptionally = new CompletedExceptionally((DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.recoverFromStackFrame(exception, (CoroutineStackFrame) continuation) : exception, false, 2, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _result$FU;
                obj2 = SelectKt.UNDECIDED;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj2, completedExceptionally)) {
                    return;
                }
            } else if (obj4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _result$FU;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                obj3 = SelectKt.RESUMED;
                if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater2, this, coroutine_suspended, obj3)) {
                    Continuation intercepted = IntrinsicsKt.intercepted(this.uCont);
                    Result.Companion companion = Result.INSTANCE;
                    intercepted.resumeWith(Result.m131constructorimpl(ResultKt.createFailure(exception)));
                    return;
                }
            } else {
                throw new IllegalStateException("Already resumed");
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.getNOT_SELECTED()) {
                return false;
            }
            if (!(obj instanceof OpDescriptor)) {
                return true;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0031, code lost:
    
        doAfterSelect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0036, code lost:
    
        return kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN;
     */
    @Override // kotlinx.coroutines.selects.SelectInstance
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object trySelectOther(kotlinx.coroutines.internal.LockFreeLinkedListNode.PrepareOp r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()
            r2 = 0
            if (r0 != r1) goto L37
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.SelectBuilderImpl._state$FU
            java.lang.Object r1 = kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()
            boolean r0 = androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, r3, r1, r2)
            if (r0 != 0) goto L31
            goto L0
        L18:
            kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp r0 = new kotlinx.coroutines.selects.SelectBuilderImpl$PairSelectOp
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.SelectBuilderImpl._state$FU
            java.lang.Object r2 = kotlinx.coroutines.selects.SelectKt.getNOT_SELECTED()
            boolean r1 = androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r1, r3, r2, r0)
            if (r1 != 0) goto L2a
            goto L0
        L2a:
            java.lang.Object r4 = r0.perform(r3)
            if (r4 == 0) goto L31
            return r4
        L31:
            r3.doAfterSelect()
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN
            return r4
        L37:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r1 == 0) goto L6b
            if (r4 == 0) goto L65
            kotlinx.coroutines.internal.AtomicOp r1 = r4.getAtomicOp()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp
            if (r2 == 0) goto L59
            r2 = r1
            kotlinx.coroutines.selects.SelectBuilderImpl$AtomicSelectOp r2 = (kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp) r2
            kotlinx.coroutines.selects.SelectBuilderImpl<?> r2 = r2.impl
            if (r2 == r3) goto L4d
            goto L59
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L59:
            r2 = r0
            kotlinx.coroutines.internal.OpDescriptor r2 = (kotlinx.coroutines.internal.OpDescriptor) r2
            boolean r1 = r1.isEarlierThan(r2)
            if (r1 == 0) goto L65
            java.lang.Object r4 = kotlinx.coroutines.internal.AtomicKt.RETRY_ATOMIC
            return r4
        L65:
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            r0.perform(r3)
            goto L0
        L6b:
            if (r4 != 0) goto L6e
            return r2
        L6e:
            kotlinx.coroutines.internal.LockFreeLinkedListNode$AbstractAtomicDesc r4 = r4.desc
            if (r0 != r4) goto L75
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.CancellableContinuationImplKt.RESUME_TOKEN
            return r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectBuilderImpl.trySelectOther(kotlinx.coroutines.internal.LockFreeLinkedListNode$PrepareOp):java.lang.Object");
    }
}
