package com.autolink.carsetting.data;

import com.autolink.carsetting.data.car.CarPageContact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleSignalBean.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/autolink/carsetting/data/SingleSignalBean;", "", "name", "", "values", "Ljava/util/ArrayList;", "Lcom/autolink/carsetting/data/ViewSignalBean;", "Lkotlin/collections/ArrayList;", "content", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getName", "setName", "getValues", "()Ljava/util/ArrayList;", "setValues", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "equals", "", CarPageContact.OTHER, "hashCode", "", "toString", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SingleSignalBean {
    private String content;
    private String name;
    private ArrayList<ViewSignalBean> values;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleSignalBean copy$default(SingleSignalBean singleSignalBean, String str, ArrayList arrayList, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = singleSignalBean.name;
        }
        if ((i & 2) != 0) {
            arrayList = singleSignalBean.values;
        }
        if ((i & 4) != 0) {
            str2 = singleSignalBean.content;
        }
        return singleSignalBean.copy(str, arrayList, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ArrayList<ViewSignalBean> component2() {
        return this.values;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final SingleSignalBean copy(String name, ArrayList<ViewSignalBean> values, String content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(content, "content");
        return new SingleSignalBean(name, values, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleSignalBean)) {
            return false;
        }
        SingleSignalBean singleSignalBean = (SingleSignalBean) other;
        return Intrinsics.areEqual(this.name, singleSignalBean.name) && Intrinsics.areEqual(this.values, singleSignalBean.values) && Intrinsics.areEqual(this.content, singleSignalBean.content);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.values.hashCode()) * 31) + this.content.hashCode();
    }

    public String toString() {
        return "SingleSignalBean(name=" + this.name + ", values=" + this.values + ", content=" + this.content + ')';
    }

    public SingleSignalBean(String name, ArrayList<ViewSignalBean> values, String content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(content, "content");
        this.name = name;
        this.values = values;
        this.content = content;
    }

    public /* synthetic */ SingleSignalBean(String str, ArrayList arrayList, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, arrayList, (i & 4) != 0 ? "" : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final ArrayList<ViewSignalBean> getValues() {
        return this.values;
    }

    public final void setValues(ArrayList<ViewSignalBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.values = arrayList;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }
}
