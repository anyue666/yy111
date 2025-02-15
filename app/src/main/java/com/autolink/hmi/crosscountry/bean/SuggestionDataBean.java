package com.autolink.hmi.crosscountry.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class SuggestionDataBean implements Parcelable {
    public static final Parcelable.Creator<SuggestionDataBean> CREATOR = new Parcelable.Creator<SuggestionDataBean>() { // from class: com.autolink.hmi.crosscountry.bean.SuggestionDataBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestionDataBean createFromParcel(Parcel parcel) {
            return new SuggestionDataBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestionDataBean[] newArray(int i) {
            return new SuggestionDataBean[i];
        }
    };
    private String brief;
    private String details;
    private String type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBrief() {
        return this.brief;
    }

    public void setBrief(String str) {
        this.brief = str;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    protected SuggestionDataBean(Parcel parcel) {
        this.brief = parcel.readString();
        this.details = parcel.readString();
        this.type = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.brief);
        parcel.writeString(this.details);
        parcel.writeString(this.type);
    }
}
