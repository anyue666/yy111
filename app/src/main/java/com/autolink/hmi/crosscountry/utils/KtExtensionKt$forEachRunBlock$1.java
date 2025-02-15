package com.autolink.hmi.crosscountry.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KtExtension.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.autolink.hmi.crosscountry.utils.KtExtensionKt", f = "KtExtension.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4}, l = {85, 88, 90, 92, 97}, m = "forEachRunBlock", n = {"$this$forEachRunBlock", "start", "center", "end", "run", "t", "index$iv", "index", "$this$forEachRunBlock", "start", "center", "end", "run", "index$iv", "$this$forEachRunBlock", "start", "center", "end", "run", "index$iv", "$this$forEachRunBlock", "start", "center", "end", "run", "index$iv", "run"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0"})
/* loaded from: classes.dex */
final class KtExtensionKt$forEachRunBlock$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    KtExtensionKt$forEachRunBlock$1(Continuation<? super KtExtensionKt$forEachRunBlock$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KtExtensionKt.forEachRunBlock(null, null, null, null, null, this);
    }
}
