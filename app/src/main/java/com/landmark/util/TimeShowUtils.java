package com.landmark.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.landmark.util.TimeShowUtils$timeSetChangedReceiverLazy$1;
import com.landmark.util.TimeShowUtils$timeZoneChangedReceiverLazy$1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeShowUtils.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0002+0\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u00103\u001a\u00020\u00102!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u00107\u001a\u00020\u00102\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018J\u0010\u00108\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u00109\u001a\u00020\u0010H\u0002J\b\u0010:\u001a\u00020\u0010H\u0002J\b\u0010;\u001a\u00020\u0010H\u0002J\u0006\u0010<\u001a\u00020\u0010J)\u0010=\u001a\u00020\u00102!\u00104\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010>\u001a\u00020\u00102\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018J\"\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020 2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010 J \u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020DJ\"\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R&\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00180\u000e8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u001a\u0010\u0014*\u0004\b\u0019\u0010\u0012R \u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00180\u000e0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010 0\u001f0\u001d8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\"\u0010#*\u0004\b!\u0010\u0012R.\u0010$\u001a\"\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010 0\u001f0\u001d0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b(\u0010)*\u0004\b'\u0010\u0012R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b.\u0010)*\u0004\b-\u0010\u0012R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/landmark/util/TimeShowUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "is24HourFormat", "", "onTimeSetChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "getOnTimeSetChangedListeners$delegate", "(Lcom/landmark/util/TimeShowUtils;)Ljava/lang/Object;", "getOnTimeSetChangedListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "onTimeSetChangedListenersLazy", "Lkotlin/Lazy;", "onTimeZoneChangedListeners", "Lkotlin/Function0;", "getOnTimeZoneChangedListeners$delegate", "getOnTimeZoneChangedListeners", "onTimeZoneChangedListenersLazy", "timeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/widget/TextView;", "Lkotlin/Pair;", "Ljava/text/DateFormat;", "getTimeMap$delegate", "getTimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "timeMapLazy", "timeSetChangedReceiver", "Landroid/content/BroadcastReceiver;", "getTimeSetChangedReceiver$delegate", "getTimeSetChangedReceiver", "()Landroid/content/BroadcastReceiver;", "timeSetChangedReceiverLazy", "com/landmark/util/TimeShowUtils$timeSetChangedReceiverLazy$1$1", "timeZoneChangedReceiver", "getTimeZoneChangedReceiver$delegate", "getTimeZoneChangedReceiver", "timeZoneChangedReceiverLazy", "com/landmark/util/TimeShowUtils$timeZoneChangedReceiverLazy$1$1", "updateTime", "Ljava/lang/Runnable;", "addOnTimeSetChangeListener", "listener", "Lkotlin/ParameterName;", "name", "addOnTimeZoneChangedListener", "onTimeSetChanged", "onTimeZoneChanged", "registerTimeChanged", "registerTimeZoneChanged", "release", "removeOnTimeSetChangeListener", "removeOnTimeZoneChangedListener", "showTime", "textView", "sdf24Hour", "sdf12Hour", "patternStrId24Hour", "", "patternStrId12Hour", "pattern24Hour", "", "pattern12Hour", "LibComUtil_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimeShowUtils {
    private final Context context;

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private final Lazy handler;
    private boolean is24HourFormat;
    private final Lazy<CopyOnWriteArrayList<Function1<Boolean, Unit>>> onTimeSetChangedListenersLazy;
    private final Lazy<CopyOnWriteArrayList<Function0<Unit>>> onTimeZoneChangedListenersLazy;
    private final Lazy<ConcurrentHashMap<TextView, Pair<DateFormat, DateFormat>>> timeMapLazy;
    private final Lazy<TimeShowUtils$timeSetChangedReceiverLazy$1.AnonymousClass1> timeSetChangedReceiverLazy;
    private final Lazy<TimeShowUtils$timeZoneChangedReceiverLazy$1.AnonymousClass1> timeZoneChangedReceiverLazy;
    private final Runnable updateTime;

    public TimeShowUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.onTimeSetChangedListenersLazy = LazyKt.lazy(new Function0<CopyOnWriteArrayList<Function1<? super Boolean, ? extends Unit>>>() { // from class: com.landmark.util.TimeShowUtils$onTimeSetChangedListenersLazy$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CopyOnWriteArrayList<Function1<? super Boolean, ? extends Unit>> invoke() {
                TimeShowUtils.this.registerTimeChanged();
                return new CopyOnWriteArrayList<>();
            }
        });
        this.timeSetChangedReceiverLazy = LazyKt.lazy(new Function0<TimeShowUtils$timeSetChangedReceiverLazy$1.AnonymousClass1>() { // from class: com.landmark.util.TimeShowUtils$timeSetChangedReceiverLazy$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.landmark.util.TimeShowUtils$timeSetChangedReceiverLazy$1$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final TimeShowUtils timeShowUtils = TimeShowUtils.this;
                return new BroadcastReceiver() { // from class: com.landmark.util.TimeShowUtils$timeSetChangedReceiverLazy$1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        CopyOnWriteArrayList onTimeSetChangedListeners;
                        if (Intrinsics.areEqual("android.intent.action.TIME_SET", intent != null ? intent.getAction() : null)) {
                            boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(context2);
                            TimeShowUtils.this.onTimeSetChanged(is24HourFormat);
                            onTimeSetChangedListeners = TimeShowUtils.this.getOnTimeSetChangedListeners();
                            Iterator it = onTimeSetChangedListeners.iterator();
                            while (it.hasNext()) {
                                ((Function1) it.next()).invoke(Boolean.valueOf(is24HourFormat));
                            }
                        }
                    }
                };
            }
        });
        this.onTimeZoneChangedListenersLazy = LazyKt.lazy(new Function0<CopyOnWriteArrayList<Function0<? extends Unit>>>() { // from class: com.landmark.util.TimeShowUtils$onTimeZoneChangedListenersLazy$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CopyOnWriteArrayList<Function0<? extends Unit>> invoke() {
                TimeShowUtils.this.registerTimeZoneChanged();
                return new CopyOnWriteArrayList<>();
            }
        });
        this.timeZoneChangedReceiverLazy = LazyKt.lazy(new Function0<TimeShowUtils$timeZoneChangedReceiverLazy$1.AnonymousClass1>() { // from class: com.landmark.util.TimeShowUtils$timeZoneChangedReceiverLazy$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.landmark.util.TimeShowUtils$timeZoneChangedReceiverLazy$1$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final TimeShowUtils timeShowUtils = TimeShowUtils.this;
                return new BroadcastReceiver() { // from class: com.landmark.util.TimeShowUtils$timeZoneChangedReceiverLazy$1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        CopyOnWriteArrayList onTimeZoneChangedListeners;
                        if (Intrinsics.areEqual("android.intent.action.TIMEZONE_CHANGED", intent != null ? intent.getAction() : null)) {
                            TimeShowUtils.this.onTimeZoneChanged();
                            onTimeZoneChangedListeners = TimeShowUtils.this.getOnTimeZoneChangedListeners();
                            Iterator it = onTimeZoneChangedListeners.iterator();
                            while (it.hasNext()) {
                                ((Function0) it.next()).invoke();
                            }
                        }
                    }
                };
            }
        });
        this.timeMapLazy = LazyKt.lazy(new Function0<ConcurrentHashMap<TextView, Pair<? extends DateFormat, ? extends DateFormat>>>() { // from class: com.landmark.util.TimeShowUtils$timeMapLazy$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<TextView, Pair<? extends DateFormat, ? extends DateFormat>> invoke() {
                TimeShowUtils.this.registerTimeChanged();
                TimeShowUtils.this.registerTimeZoneChanged();
                return new ConcurrentHashMap<>();
            }
        });
        this.handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.landmark.util.TimeShowUtils$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);
        this.updateTime = new Runnable() { // from class: com.landmark.util.TimeShowUtils$updateTime$1
            /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
            
                if (r6 == false) goto L11;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                    long r0 = java.lang.System.currentTimeMillis()
                    com.landmark.util.TimeShowUtils r2 = com.landmark.util.TimeShowUtils.this
                    java.util.concurrent.ConcurrentHashMap r2 = com.landmark.util.TimeShowUtils.access$getTimeMap(r2)
                    java.util.Set r2 = r2.keySet()
                    java.util.Iterator r2 = r2.iterator()
                L12:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L61
                    java.lang.Object r3 = r2.next()
                    android.widget.TextView r3 = (android.widget.TextView) r3
                    com.landmark.util.TimeShowUtils r4 = com.landmark.util.TimeShowUtils.this
                    java.util.concurrent.ConcurrentHashMap r4 = com.landmark.util.TimeShowUtils.access$getTimeMap(r4)
                    java.lang.Object r4 = r4.get(r3)
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
                    kotlin.Pair r4 = (kotlin.Pair) r4
                    java.lang.Object r5 = r4.getSecond()
                    java.text.DateFormat r5 = (java.text.DateFormat) r5
                    if (r5 == 0) goto L3e
                    com.landmark.util.TimeShowUtils r6 = com.landmark.util.TimeShowUtils.this
                    boolean r6 = com.landmark.util.TimeShowUtils.access$is24HourFormat$p(r6)
                    if (r6 != 0) goto L3e
                    goto L45
                L3e:
                    java.lang.Object r4 = r4.getFirst()
                    r5 = r4
                    java.text.DateFormat r5 = (java.text.DateFormat) r5
                L45:
                    java.lang.Long r4 = java.lang.Long.valueOf(r0)
                    java.lang.String r4 = r5.format(r4)
                    java.lang.CharSequence r5 = r3.getText()
                    java.lang.String r5 = r5.toString()
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                    if (r5 != 0) goto L12
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    r3.setText(r4)
                    goto L12
                L61:
                    com.landmark.util.TimeShowUtils r0 = com.landmark.util.TimeShowUtils.this
                    android.os.Handler r0 = com.landmark.util.TimeShowUtils.access$getHandler(r0)
                    r1 = r7
                    java.lang.Runnable r1 = (java.lang.Runnable) r1
                    r2 = 1000(0x3e8, double:4.94E-321)
                    r0.postDelayed(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.landmark.util.TimeShowUtils$updateTime$1.run():void");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CopyOnWriteArrayList<Function1<Boolean, Unit>> getOnTimeSetChangedListeners() {
        return this.onTimeSetChangedListenersLazy.getValue();
    }

    private final BroadcastReceiver getTimeSetChangedReceiver() {
        return this.timeSetChangedReceiverLazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CopyOnWriteArrayList<Function0<Unit>> getOnTimeZoneChangedListeners() {
        return this.onTimeZoneChangedListenersLazy.getValue();
    }

    private final BroadcastReceiver getTimeZoneChangedReceiver() {
        return this.timeZoneChangedReceiverLazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<TextView, Pair<DateFormat, DateFormat>> getTimeMap() {
        return this.timeMapLazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    public final void addOnTimeZoneChangedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getOnTimeZoneChangedListeners().add(listener);
    }

    public final void removeOnTimeZoneChangedListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getOnTimeZoneChangedListeners().remove(listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addOnTimeSetChangeListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getOnTimeSetChangedListeners().add(listener);
    }

    public final void removeOnTimeSetChangeListener(Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getOnTimeSetChangedListeners().remove(listener);
    }

    public final void release() {
        if (this.timeSetChangedReceiverLazy.isInitialized()) {
            this.context.unregisterReceiver(getTimeSetChangedReceiver());
            if (this.onTimeSetChangedListenersLazy.isInitialized()) {
                getOnTimeSetChangedListeners().clear();
            }
        }
        if (this.timeZoneChangedReceiverLazy.isInitialized()) {
            this.context.unregisterReceiver(getTimeZoneChangedReceiver());
            if (this.onTimeZoneChangedListenersLazy.isInitialized()) {
                getOnTimeZoneChangedListeners().clear();
            }
        }
        if (this.timeMapLazy.isInitialized()) {
            getTimeMap().clear();
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public static /* synthetic */ void showTime$default(TimeShowUtils timeShowUtils, TextView textView, DateFormat dateFormat, DateFormat dateFormat2, int i, Object obj) {
        if ((i & 4) != 0) {
            dateFormat2 = null;
        }
        timeShowUtils.showTime(textView, dateFormat, dateFormat2);
    }

    public final void showTime(TextView textView, DateFormat sdf24Hour, DateFormat sdf12Hour) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(sdf24Hour, "sdf24Hour");
        if (!this.timeMapLazy.isInitialized()) {
            getHandler().post(this.updateTime);
        }
        getTimeMap().put(textView, new Pair<>(sdf24Hour, sdf12Hour));
    }

    public static /* synthetic */ void showTime$default(TimeShowUtils timeShowUtils, TextView textView, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        timeShowUtils.showTime(textView, str, str2);
    }

    public final void showTime(TextView textView, String pattern24Hour, String pattern12Hour) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(pattern24Hour, "pattern24Hour");
        showTime(textView, new SimpleDateFormat(pattern24Hour, Locale.getDefault()), pattern12Hour == null ? null : new SimpleDateFormat(pattern24Hour, Locale.getDefault()));
    }

    public static /* synthetic */ void showTime$default(TimeShowUtils timeShowUtils, TextView textView, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        timeShowUtils.showTime(textView, i, i2);
    }

    public final void showTime(TextView textView, int patternStrId24Hour, int patternStrId12Hour) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        String string = this.context.getString(patternStrId24Hour);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(patternStrId24Hour)");
        showTime(textView, string, patternStrId12Hour == -1 ? null : this.context.getString(patternStrId12Hour));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerTimeChanged() {
        if (this.timeSetChangedReceiverLazy.isInitialized()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        this.context.registerReceiver(getTimeSetChangedReceiver(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerTimeZoneChanged() {
        if (this.timeZoneChangedReceiverLazy.isInitialized()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.context.registerReceiver(getTimeZoneChangedReceiver(), intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTimeZoneChanged() {
        getHandler().removeCallbacks(this.updateTime);
        Iterator<TextView> it = getTimeMap().keySet().iterator();
        while (it.hasNext()) {
            Pair<DateFormat, DateFormat> pair = getTimeMap().get(it.next());
            Intrinsics.checkNotNull(pair);
            Pair<DateFormat, DateFormat> pair2 = pair;
            pair2.getFirst().setTimeZone(TimeZone.getDefault());
            DateFormat second = pair2.getSecond();
            if (second != null) {
                second.setTimeZone(TimeZone.getDefault());
            }
        }
        getHandler().post(this.updateTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTimeSetChanged(boolean is24HourFormat) {
        getHandler().removeCallbacks(this.updateTime);
        this.is24HourFormat = is24HourFormat;
        getHandler().post(this.updateTime);
    }
}
