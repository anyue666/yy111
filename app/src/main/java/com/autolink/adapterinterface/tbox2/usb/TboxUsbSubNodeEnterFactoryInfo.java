package com.autolink.adapterinterface.tbox2.usb;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class TboxUsbSubNodeEnterFactoryInfo implements Parcelable {
    private byte checkMethod;
    private String checkSumCode;
    private int ecuId;
    private String filename;
    private long filesize;
    private long taskId;
    private byte updateModel;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final Parcelable.Creator<TboxUsbSubNodeEnterFactoryInfo> CREATOR = new Parcelable.Creator<TboxUsbSubNodeEnterFactoryInfo>() { // from class: com.autolink.adapterinterface.tbox2.usb.TboxUsbSubNodeEnterFactoryInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxUsbSubNodeEnterFactoryInfo createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            builder.setUpdateModel(parcel.readByte());
            builder.setCheckMethod(parcel.readByte());
            builder.setEcuId(parcel.readInt());
            builder.setTaskId(parcel.readLong());
            builder.setFilesize(parcel.readLong());
            if (parcel.readInt() == 1) {
                builder.setFilename(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                builder.setCheckSumCode(parcel.readString());
            }
            return builder.build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TboxUsbSubNodeEnterFactoryInfo[] newArray(int i) {
            return new TboxUsbSubNodeEnterFactoryInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TboxUsbSubNodeEnterFactoryInfo(byte b, byte b2, int i, long j, long j2, String str, String str2) {
        this.updateModel = b;
        this.checkMethod = b2;
        this.ecuId = i;
        this.taskId = j;
        this.filesize = j2;
        this.filename = str;
        this.checkSumCode = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.updateModel);
        parcel.writeByte(this.checkMethod);
        parcel.writeInt(this.ecuId);
        parcel.writeLong(this.taskId);
        parcel.writeLong(this.filesize);
        parcel.writeInt(this.filename == null ? 0 : 1);
        String str = this.filename;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.checkSumCode != null ? 1 : 0);
        String str2 = this.checkSumCode;
        if (str2 != null) {
            parcel.writeString(str2);
        }
    }

    public static final class Builder {
        private byte mCheckMethod;
        private String mCheckSumCode;
        private int mEcuId;
        private String mFilename;
        private long mFilesize;
        private long mTaskId;
        private byte mUpdateModel;

        public Builder setUpdateModel(byte b) {
            this.mUpdateModel = b;
            return this;
        }

        public Builder setCheckMethod(byte b) {
            this.mCheckMethod = b;
            return this;
        }

        public Builder setEcuId(int i) {
            this.mEcuId = i;
            return this;
        }

        public Builder setTaskId(long j) {
            this.mTaskId = j;
            return this;
        }

        public Builder setFilesize(long j) {
            this.mFilesize = j;
            return this;
        }

        public Builder setFilename(String str) {
            this.mFilename = str;
            return this;
        }

        public Builder setCheckSumCode(String str) {
            this.mCheckSumCode = str;
            return this;
        }

        public TboxUsbSubNodeEnterFactoryInfo build() {
            return new TboxUsbSubNodeEnterFactoryInfo(this.mUpdateModel, this.mCheckMethod, this.mEcuId, this.mTaskId, this.mFilesize, this.mFilename, this.mCheckSumCode);
        }
    }

    public String toString() {
        return "TboxUsbSubNodeEnterFactoryInfo {updateModel=" + ((int) this.updateModel) + ", checkMethod=" + ((int) this.checkMethod) + ", ecuId=" + this.ecuId + ", taskId=" + this.taskId + ", filesize=" + this.filesize + ", filename=" + this.filename + ", checkSumCode=" + this.checkSumCode + "}";
    }

    public byte getUpdateModel() {
        return this.updateModel;
    }

    public byte getCheckMethod() {
        return this.checkMethod;
    }

    public int getEcuId() {
        return this.ecuId;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getCheckSumCode() {
        return this.checkSumCode;
    }
}
