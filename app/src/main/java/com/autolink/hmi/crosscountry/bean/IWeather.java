package com.autolink.hmi.crosscountry.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class IWeather implements Parcelable {
    public static final Parcelable.Creator<IWeather> CREATOR = new Parcelable.Creator<IWeather>() { // from class: com.autolink.hmi.crosscountry.bean.IWeather.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IWeather createFromParcel(Parcel parcel) {
            return new IWeather(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IWeather[] newArray(int i) {
            return new IWeather[i];
        }
    };
    private Integer code;
    private WeatherDataBean data;
    private String message;
    private String randomstr;
    private String sign;
    private String timestamp;
    private String transactionid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherDataBean getData() {
        return this.data;
    }

    public void setData(WeatherDataBean weatherDataBean) {
        this.data = weatherDataBean;
    }

    public String getRandomstr() {
        return this.randomstr;
    }

    public void setRandomstr(String str) {
        this.randomstr = str;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getTransactionid() {
        return this.transactionid;
    }

    public void setTransactionid(String str) {
        this.transactionid = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public IWeather() {
    }

    protected IWeather(Parcel parcel) {
        this.data = (WeatherDataBean) parcel.readParcelable(WeatherDataBean.class.getClassLoader());
        this.code = Integer.valueOf(parcel.readInt());
        this.randomstr = parcel.readString();
        this.sign = parcel.readString();
        this.message = parcel.readString();
        this.transactionid = parcel.readString();
        this.timestamp = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.data, 0);
        parcel.writeInt(this.code.intValue());
        parcel.writeString(this.randomstr);
        parcel.writeString(this.sign);
        parcel.writeString(this.message);
        parcel.writeString(this.transactionid);
        parcel.writeString(this.timestamp);
    }

    public static class WeatherDataBean implements Parcelable {
        public static final Parcelable.Creator<WeatherDataBean> CREATOR = new Parcelable.Creator<WeatherDataBean>() { // from class: com.autolink.hmi.crosscountry.bean.IWeather.WeatherDataBean.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WeatherDataBean createFromParcel(Parcel parcel) {
                return new WeatherDataBean(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WeatherDataBean[] newArray(int i) {
                return new WeatherDataBean[i];
            }
        };
        private Air air;
        private LocationBean location;
        private NowDataBean now;
        private List<SuggestionDataBean> suggestion;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public NowDataBean getNow() {
            return this.now;
        }

        public void setNow(NowDataBean nowDataBean) {
            this.now = nowDataBean;
        }

        public LocationBean getLocation() {
            return this.location;
        }

        public void setLocation(LocationBean locationBean) {
            this.location = locationBean;
        }

        public List<SuggestionDataBean> getSuggestion() {
            return this.suggestion;
        }

        public void setSuggestion(List<SuggestionDataBean> list) {
            this.suggestion = list;
        }

        public Air getAir() {
            return this.air;
        }

        public void setAir(Air air) {
            this.air = air;
        }

        protected WeatherDataBean(Parcel parcel) {
            this.now = (NowDataBean) parcel.readParcelable(NowDataBean.class.getClassLoader());
            this.location = (LocationBean) parcel.readParcelable(LocationBean.class.getClassLoader());
            this.suggestion = parcel.createTypedArrayList(SuggestionDataBean.CREATOR);
            this.air = (Air) parcel.readParcelable(Air.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.now, i);
            parcel.writeParcelable(this.location, i);
            parcel.writeTypedList(this.suggestion);
            parcel.writeParcelable(this.air, i);
        }
    }
}
