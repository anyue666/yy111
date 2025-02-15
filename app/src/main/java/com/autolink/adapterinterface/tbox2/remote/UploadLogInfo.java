package com.autolink.adapterinterface.tbox2.remote;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class UploadLogInfo implements Parcelable {
    public static final Parcelable.Creator<UploadLogInfo> CREATOR = new Parcelable.Creator<UploadLogInfo>() { // from class: com.autolink.adapterinterface.tbox2.remote.UploadLogInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UploadLogInfo createFromParcel(Parcel parcel) {
            return new UploadLogInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UploadLogInfo[] newArray(int i) {
            return new UploadLogInfo[i];
        }
    };
    public long endTime;
    public LogType mLogType;
    public long msgId;
    public long startTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UploadLogInfo() {
    }

    public UploadLogInfo(long j, long j2, long j3, LogType logType) {
        this.msgId = j;
        this.startTime = j2;
        this.endTime = j3;
        this.mLogType = logType;
    }

    protected UploadLogInfo(Parcel parcel) {
        this.msgId = parcel.readLong();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.mLogType = (LogType) parcel.readParcelable(LogType.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.msgId);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeParcelable(this.mLogType, i);
    }

    public void readFromParcel(Parcel parcel) {
        this.msgId = parcel.readLong();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.mLogType = (LogType) parcel.readParcelable(LogType.class.getClassLoader());
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public LogType getmLogType() {
        return this.mLogType;
    }

    public void setmLogType(LogType logType) {
        this.mLogType = logType;
    }

    public static class LogType implements Parcelable {
        public static final Parcelable.Creator<LogType> CREATOR = new Parcelable.Creator<LogType>() { // from class: com.autolink.adapterinterface.tbox2.remote.UploadLogInfo.LogType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LogType createFromParcel(Parcel parcel) {
                return new LogType(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LogType[] newArray(int i) {
                return new LogType[i];
            }
        };

        /* renamed from: android, reason: collision with root package name */
        public int f5android;
        public int mcu;
        public int qnx;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LogType() {
        }

        public LogType(int i, int i2, int i3) {
            this.f5android = i;
            this.qnx = i2;
            this.mcu = i3;
        }

        protected LogType(Parcel parcel) {
            this.f5android = parcel.readInt();
            this.qnx = parcel.readInt();
            this.mcu = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5android);
            parcel.writeInt(this.qnx);
            parcel.writeInt(this.mcu);
        }

        public int getAndroid() {
            return this.f5android;
        }

        public void setAndroid(int i) {
            this.f5android = i;
        }

        public int getQnx() {
            return this.qnx;
        }

        public void setQnx(int i) {
            this.qnx = i;
        }

        public int getMcu() {
            return this.mcu;
        }

        public void setMcu(int i) {
            this.mcu = i;
        }

        public String toString() {
            return "LogType{android=" + this.f5android + ", qnx=" + this.qnx + ", mcu=" + this.mcu + '}';
        }
    }
}
