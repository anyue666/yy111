package com.autolink.carsetting.data;

import com.autolink.carsetting.data.car.CarPageContact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LayoutParmBean.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/autolink/carsetting/data/LayoutParmBean;", "", "height", "", "width", "marginLeft", "marginRight", "marginTop", "marginBottom", "(IIIIII)V", "getHeight", "()I", "setHeight", "(I)V", "getMarginBottom", "setMarginBottom", "getMarginLeft", "setMarginLeft", "getMarginRight", "setMarginRight", "getMarginTop", "setMarginTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", CarPageContact.OTHER, "hashCode", "toString", "", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LayoutParmBean {
    private int height;
    private int marginBottom;
    private int marginLeft;
    private int marginRight;
    private int marginTop;
    private int width;

    public LayoutParmBean() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ LayoutParmBean copy$default(LayoutParmBean layoutParmBean, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = layoutParmBean.height;
        }
        if ((i7 & 2) != 0) {
            i2 = layoutParmBean.width;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = layoutParmBean.marginLeft;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = layoutParmBean.marginRight;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = layoutParmBean.marginTop;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = layoutParmBean.marginBottom;
        }
        return layoutParmBean.copy(i, i8, i9, i10, i11, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMarginLeft() {
        return this.marginLeft;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMarginRight() {
        return this.marginRight;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMarginTop() {
        return this.marginTop;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final LayoutParmBean copy(int height, int width, int marginLeft, int marginRight, int marginTop, int marginBottom) {
        return new LayoutParmBean(height, width, marginLeft, marginRight, marginTop, marginBottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayoutParmBean)) {
            return false;
        }
        LayoutParmBean layoutParmBean = (LayoutParmBean) other;
        return this.height == layoutParmBean.height && this.width == layoutParmBean.width && this.marginLeft == layoutParmBean.marginLeft && this.marginRight == layoutParmBean.marginRight && this.marginTop == layoutParmBean.marginTop && this.marginBottom == layoutParmBean.marginBottom;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.height) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.marginLeft)) * 31) + Integer.hashCode(this.marginRight)) * 31) + Integer.hashCode(this.marginTop)) * 31) + Integer.hashCode(this.marginBottom);
    }

    public String toString() {
        return "LayoutParmBean(height=" + this.height + ", width=" + this.width + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ')';
    }

    public LayoutParmBean(int i, int i2, int i3, int i4, int i5, int i6) {
        this.height = i;
        this.width = i2;
        this.marginLeft = i3;
        this.marginRight = i4;
        this.marginTop = i5;
        this.marginBottom = i6;
    }

    public /* synthetic */ LayoutParmBean(int i, int i2, int i3, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? -2 : i, (i7 & 2) != 0 ? 70 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) == 0 ? i6 : 0);
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final void setMarginLeft(int i) {
        this.marginLeft = i;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final void setMarginRight(int i) {
        this.marginRight = i;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public final void setMarginTop(int i) {
        this.marginTop = i;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final void setMarginBottom(int i) {
        this.marginBottom = i;
    }
}
