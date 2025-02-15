package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class OtaSubNodeState implements Parcelable {
    public static final Parcelable.Creator<OtaSubNodeState> CREATOR = new Parcelable.Creator<OtaSubNodeState>() { // from class: com.autolink.adapterinterface.OtaSubNodeState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OtaSubNodeState createFromParcel(Parcel parcel) {
            return new OtaSubNodeState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OtaSubNodeState[] newArray(int i) {
            return new OtaSubNodeState[i];
        }
    };
    public int code;
    public int ecuId;
    public String hardwareAfterVersion;
    public String hardwareBeforeVersion;
    public int result;
    public String sessionId;
    public String softwareAfterVersion;
    public String softwareBeforeVersion;
    public long taskId;
    public int updateProgress;
    public int updateState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OtaSubNodeState() {
    }

    protected OtaSubNodeState(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.ecuId = parcel.readInt();
        this.updateState = parcel.readInt();
        this.updateProgress = parcel.readInt();
        this.result = parcel.readInt();
        this.code = parcel.readInt();
        this.taskId = parcel.readLong();
        this.sessionId = parcel.readString();
        this.hardwareBeforeVersion = parcel.readString();
        this.softwareBeforeVersion = parcel.readString();
        this.hardwareAfterVersion = parcel.readString();
        this.softwareAfterVersion = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ecuId);
        parcel.writeInt(this.updateState);
        parcel.writeInt(this.updateProgress);
        parcel.writeInt(this.result);
        parcel.writeInt(this.code);
        parcel.writeLong(this.taskId);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.hardwareBeforeVersion);
        parcel.writeString(this.softwareBeforeVersion);
        parcel.writeString(this.hardwareAfterVersion);
        parcel.writeString(this.softwareAfterVersion);
    }

    public String toString() {
        return "OtaSubNodeState{ecuId=" + this.ecuId + ", updateState=" + this.updateState + ", updateProgress=" + this.updateProgress + ", result=" + this.result + ", code=" + this.code + ", taskId=" + this.taskId + ", sessionId='" + this.sessionId + "', hardwareBeforeVersion='" + this.hardwareBeforeVersion + "', softwareBeforeVersion='" + this.softwareBeforeVersion + "', hardwareAfterVersion='" + this.hardwareAfterVersion + "', softwareAfterVersion='" + this.softwareAfterVersion + "'}";
    }
}
