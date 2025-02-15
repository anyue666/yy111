package com.autolink.hmi.crosscountry.bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class CrossLocationBean implements Serializable {
    private DataBean data;
    private String message;
    private String messageType;
    private boolean needResponse;
    private int protocolId;
    private String requestAuthor;
    private String requestCode;
    private String responseCode;
    private int statusCode;
    private String versionName;

    public String getRequestAuthor() {
        return this.requestAuthor;
    }

    public void setRequestAuthor(String str) {
        this.requestAuthor = str;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public int getProtocolId() {
        return this.protocolId;
    }

    public void setProtocolId(int i) {
        this.protocolId = i;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public String getRequestCode() {
        return this.requestCode;
    }

    public void setRequestCode(String str) {
        this.requestCode = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public boolean isNeedResponse() {
        return this.needResponse;
    }

    public void setNeedResponse(boolean z) {
        this.needResponse = z;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public static class DataBean implements Serializable {
        private String address;
        private String cityCode;
        private String cityName;
        private String countryCode;
        private String countryName;
        private String districtCode;
        private String districtName;
        private String errorMessage;
        private String fullAddress;
        private double latitude;
        private double longitude;
        private String myLocationName;
        private String poiName;
        private String provinceCode;
        private String provinceName;
        private int resultCode;

        public String getDistrictCode() {
            return this.districtCode;
        }

        public void setDistrictCode(String str) {
            this.districtCode = str;
        }

        public String getCityCode() {
            return this.cityCode;
        }

        public void setCityCode(String str) {
            this.cityCode = str;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public String getProvinceName() {
            return this.provinceName;
        }

        public void setProvinceName(String str) {
            this.provinceName = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getMyLocationName() {
            return this.myLocationName;
        }

        public void setMyLocationName(String str) {
            this.myLocationName = str;
        }

        public String getFullAddress() {
            return this.fullAddress;
        }

        public void setFullAddress(String str) {
            this.fullAddress = str;
        }

        public String getDistrictName() {
            return this.districtName;
        }

        public void setDistrictName(String str) {
            this.districtName = str;
        }

        public String getCityName() {
            return this.cityName;
        }

        public void setCityName(String str) {
            this.cityName = str;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public void setLongitude(double d) {
            this.longitude = d;
        }

        public String getCountryName() {
            return this.countryName;
        }

        public void setCountryName(String str) {
            this.countryName = str;
        }

        public String getProvinceCode() {
            return this.provinceCode;
        }

        public void setProvinceCode(String str) {
            this.provinceCode = str;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public void setLatitude(double d) {
            this.latitude = d;
        }

        public String getPoiName() {
            return this.poiName;
        }

        public void setPoiName(String str) {
            this.poiName = str;
        }

        public int getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(int i) {
            this.resultCode = i;
        }
    }
}
