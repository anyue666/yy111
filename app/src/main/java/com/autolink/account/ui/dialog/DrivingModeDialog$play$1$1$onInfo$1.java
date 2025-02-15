package com.autolink.account.ui.dialog;

import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.autolink.hmi.crosscountry.databinding.DrivingModeDialogLayoutBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DrivingModeDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.account.ui.dialog.DrivingModeDialog$play$1$1$onInfo$1", f = "DrivingModeDialog.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class DrivingModeDialog$play$1$1$onInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DrivingModeDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrivingModeDialog$play$1$1$onInfo$1(DrivingModeDialog drivingModeDialog, Continuation<? super DrivingModeDialog$play$1$1$onInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = drivingModeDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DrivingModeDialog$play$1$1$onInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DrivingModeDialog$play$1$1$onInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: DrivingModeDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.autolink.account.ui.dialog.DrivingModeDialog$play$1$1$onInfo$1$1", f = "DrivingModeDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.autolink.account.ui.dialog.DrivingModeDialog$play$1$1$onInfo$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DrivingModeDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DrivingModeDialog drivingModeDialog, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = drivingModeDialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding;
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                drivingModeDialogLayoutBinding = this.this$0.binding;
                ImageView imageView = drivingModeDialogLayoutBinding != null ? drivingModeDialogLayoutBinding.carImg : null;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                drivingModeDialogLayoutBinding2 = this.this$0.binding;
                CardView cardView = drivingModeDialogLayoutBinding2 != null ? drivingModeDialogLayoutBinding2.carImgLayout : null;
                if (cardView != null) {
                    cardView.setVisibility(8);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
