package com.autolink.hmi.crosscountry.bean;

import java.io.Serializable;

/* loaded from: classes.dex */
public class FrontAngleBean implements Serializable {
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

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
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

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String str) {
        this.versionName = str;
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
        private LocationInfoBean locationInfo;

        public LocationInfoBean getLocationInfo() {
            return this.locationInfo;
        }

        public void setLocationInfo(LocationInfoBean locationInfoBean) {
            this.locationInfo = locationInfoBean;
        }

        public static class LocationInfoBean implements Serializable {
            private double accuracy;
            private double bearing;
            private String provider;
            private double speed;
            private long time;

            public double getBearing() {
                return this.bearing;
            }

            public void setBearing(double d) {
                this.bearing = d;
            }

            public double getAccuracy() {
                return this.accuracy;
            }

            public void setAccuracy(double d) {
                this.accuracy = d;
            }

            public double getSpeed() {
                return this.speed;
            }

            public void setSpeed(double d) {
                this.speed = d;
            }

            public long getTime() {
                return this.time;
            }

            public void setTime(long j) {
                this.time = j;
            }

            public String getProvider() {
                return this.provider;
            }

            public void setProvider(String str) {
                this.provider = str;
            }
        }
    }
}
