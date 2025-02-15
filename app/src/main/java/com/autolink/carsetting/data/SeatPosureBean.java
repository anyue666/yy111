package com.autolink.carsetting.data;

import com.autolink.carsetting.data.car.CarPageContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SeatPosureBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/autolink/carsetting/data/SeatPosureBean;", "", "name", "", "isUse", "", "(Ljava/lang/String;Z)V", "()Z", "setUse", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", CarPageContact.OTHER, "hashCode", "", "toString", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SeatPosureBean {
    private boolean isUse;
    private String name;

    public static /* synthetic */ SeatPosureBean copy$default(SeatPosureBean seatPosureBean, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = seatPosureBean.name;
        }
        if ((i & 2) != 0) {
            z = seatPosureBean.isUse;
        }
        return seatPosureBean.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsUse() {
        return this.isUse;
    }

    public final SeatPosureBean copy(String name, boolean isUse) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SeatPosureBean(name, isUse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeatPosureBean)) {
            return false;
        }
        SeatPosureBean seatPosureBean = (SeatPosureBean) other;
        return Intrinsics.areEqual(this.name, seatPosureBean.name) && this.isUse == seatPosureBean.isUse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        boolean z = this.isUse;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "SeatPosureBean(name=" + this.name + ", isUse=" + this.isUse + ')';
    }

    public SeatPosureBean(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.isUse = z;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final boolean isUse() {
        return this.isUse;
    }

    public final void setUse(boolean z) {
        this.isUse = z;
    }
}
