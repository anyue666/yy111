package com.autolink.carsetting.data;

import android.graphics.drawable.Drawable;
import com.autolink.carsetting.data.car.CarPageContact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MenuBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/autolink/carsetting/data/MenuBean;", "", "name", "", "icon", "Landroid/graphics/drawable/Drawable;", "id", "", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;I)V", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", CarPageContact.OTHER, "hashCode", "toString", "Data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MenuBean {
    private Drawable icon;
    private int id;
    private String name;

    public static /* synthetic */ MenuBean copy$default(MenuBean menuBean, String str, Drawable drawable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = menuBean.name;
        }
        if ((i2 & 2) != 0) {
            drawable = menuBean.icon;
        }
        if ((i2 & 4) != 0) {
            i = menuBean.id;
        }
        return menuBean.copy(str, drawable, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final Drawable getIcon() {
        return this.icon;
    }

    /* renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final MenuBean copy(String name, Drawable icon, int id) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new MenuBean(name, icon, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuBean)) {
            return false;
        }
        MenuBean menuBean = (MenuBean) other;
        return Intrinsics.areEqual(this.name, menuBean.name) && Intrinsics.areEqual(this.icon, menuBean.icon) && this.id == menuBean.id;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Drawable drawable = this.icon;
        return ((hashCode + (drawable == null ? 0 : drawable.hashCode())) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        return "MenuBean(name=" + this.name + ", icon=" + this.icon + ", id=" + this.id + ')';
    }

    public MenuBean(String name, Drawable drawable, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.icon = drawable;
        this.id = i;
    }

    public /* synthetic */ MenuBean(String str, Drawable drawable, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, drawable, (i2 & 4) != 0 ? -1 : i);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }
}
