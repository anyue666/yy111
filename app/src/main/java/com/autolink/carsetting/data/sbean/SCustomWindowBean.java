package com.autolink.carsetting.data.sbean;

import com.autolink.carsetting.data.car.CarPageContact;
import kotlin.Metadata;

/* compiled from: SCustomWindowBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/autolink/carsetting/data/sbean/SCustomWindowBean;", "", "fl", "", "fr", "rl", "rr", "(IIII)V", "getFl", "()I", "getFr", "getRl", "getRr", "component1", "component2", "component3", "component4", "copy", "equals", "", CarPageContact.OTHER, "hashCode", "toString", "", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SCustomWindowBean {
    private final int fl;
    private final int fr;
    private final int rl;
    private final int rr;

    public static /* synthetic */ SCustomWindowBean copy$default(SCustomWindowBean sCustomWindowBean, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = sCustomWindowBean.fl;
        }
        if ((i5 & 2) != 0) {
            i2 = sCustomWindowBean.fr;
        }
        if ((i5 & 4) != 0) {
            i3 = sCustomWindowBean.rl;
        }
        if ((i5 & 8) != 0) {
            i4 = sCustomWindowBean.rr;
        }
        return sCustomWindowBean.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFl() {
        return this.fl;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFr() {
        return this.fr;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRl() {
        return this.rl;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRr() {
        return this.rr;
    }

    public final SCustomWindowBean copy(int fl, int fr, int rl, int rr) {
        return new SCustomWindowBean(fl, fr, rl, rr);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SCustomWindowBean)) {
            return false;
        }
        SCustomWindowBean sCustomWindowBean = (SCustomWindowBean) other;
        return this.fl == sCustomWindowBean.fl && this.fr == sCustomWindowBean.fr && this.rl == sCustomWindowBean.rl && this.rr == sCustomWindowBean.rr;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.fl) * 31) + Integer.hashCode(this.fr)) * 31) + Integer.hashCode(this.rl)) * 31) + Integer.hashCode(this.rr);
    }

    public String toString() {
        return "SCustomWindowBean(fl=" + this.fl + ", fr=" + this.fr + ", rl=" + this.rl + ", rr=" + this.rr + ')';
    }

    public SCustomWindowBean(int i, int i2, int i3, int i4) {
        this.fl = i;
        this.fr = i2;
        this.rl = i3;
        this.rr = i4;
    }

    public final int getFl() {
        return this.fl;
    }

    public final int getFr() {
        return this.fr;
    }

    public final int getRl() {
        return this.rl;
    }

    public final int getRr() {
        return this.rr;
    }
}
