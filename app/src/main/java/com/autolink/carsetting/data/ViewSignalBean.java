package com.autolink.carsetting.data;

import com.autolink.carsetting.data.car.CarPageContact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewSignalBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/autolink/carsetting/data/ViewSignalBean;", "", "name", "", "value", "id", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getValue", "setValue", "component1", "component2", "component3", "copy", "equals", "", CarPageContact.OTHER, "hashCode", "toString", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ViewSignalBean {
    private int id;
    private String name;
    private String value;

    public static /* synthetic */ ViewSignalBean copy$default(ViewSignalBean viewSignalBean, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = viewSignalBean.name;
        }
        if ((i2 & 2) != 0) {
            str2 = viewSignalBean.value;
        }
        if ((i2 & 4) != 0) {
            i = viewSignalBean.id;
        }
        return viewSignalBean.copy(str, str2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final ViewSignalBean copy(String name, String value, int id) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new ViewSignalBean(name, value, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewSignalBean)) {
            return false;
        }
        ViewSignalBean viewSignalBean = (ViewSignalBean) other;
        return Intrinsics.areEqual(this.name, viewSignalBean.name) && Intrinsics.areEqual(this.value, viewSignalBean.value) && this.id == viewSignalBean.id;
    }

    public int hashCode() {
        String str = this.name;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.value.hashCode()) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        return "ViewSignalBean(name=" + this.name + ", value=" + this.value + ", id=" + this.id + ')';
    }

    public ViewSignalBean(String str, String value, int i) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = str;
        this.value = value;
        this.id = i;
    }

    public /* synthetic */ ViewSignalBean(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? -1 : i);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }
}
