package com.autolink.carsetting.data.car;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalWarp.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/autolink/carsetting/data/car/LocalWarp;", "", "locale", "Ljava/util/Locale;", "value", "", "(Ljava/util/Locale;I)V", "getLocale", "()Ljava/util/Locale;", "getValue", "()I", "component1", "component2", "copy", "equals", "", CarPageContact.OTHER, "hashCode", "toString", "", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LocalWarp {
    private final Locale locale;
    private final int value;

    public static /* synthetic */ LocalWarp copy$default(LocalWarp localWarp, Locale locale, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            locale = localWarp.locale;
        }
        if ((i2 & 2) != 0) {
            i = localWarp.value;
        }
        return localWarp.copy(locale, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Locale getLocale() {
        return this.locale;
    }

    /* renamed from: component2, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final LocalWarp copy(Locale locale, int value) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new LocalWarp(locale, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalWarp)) {
            return false;
        }
        LocalWarp localWarp = (LocalWarp) other;
        return Intrinsics.areEqual(this.locale, localWarp.locale) && this.value == localWarp.value;
    }

    public int hashCode() {
        return (this.locale.hashCode() * 31) + Integer.hashCode(this.value);
    }

    public String toString() {
        return "LocalWarp(locale=" + this.locale + ", value=" + this.value + ')';
    }

    public LocalWarp(Locale locale, int i) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.locale = locale;
        this.value = i;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final int getValue() {
        return this.value;
    }
}
