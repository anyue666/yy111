package com.autolink.carsetting.data;

import com.autolink.carsetting.data.car.CarPageContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiyKeyBean.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/autolink/carsetting/data/DiyKeyBean;", "", "name", "", "key", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", CarPageContact.OTHER, "hashCode", "", "toString", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DiyKeyBean {
    private final String key;
    private final String name;

    public static /* synthetic */ DiyKeyBean copy$default(DiyKeyBean diyKeyBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diyKeyBean.name;
        }
        if ((i & 2) != 0) {
            str2 = diyKeyBean.key;
        }
        return diyKeyBean.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final DiyKeyBean copy(String name, String key) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(key, "key");
        return new DiyKeyBean(name, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiyKeyBean)) {
            return false;
        }
        DiyKeyBean diyKeyBean = (DiyKeyBean) other;
        return Intrinsics.areEqual(this.name, diyKeyBean.name) && Intrinsics.areEqual(this.key, diyKeyBean.key);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.key.hashCode();
    }

    public String toString() {
        return "DiyKeyBean(name=" + this.name + ", key=" + this.key + ')';
    }

    public DiyKeyBean(String name, String key) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(key, "key");
        this.name = name;
        this.key = key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getKey() {
        return this.key;
    }
}
