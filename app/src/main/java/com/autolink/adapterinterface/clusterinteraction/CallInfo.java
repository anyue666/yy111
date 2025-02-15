package com.autolink.adapterinterface.clusterinteraction;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class CallInfo implements Parcelable {
    public static final Parcelable.Creator<CallInfo> CREATOR = new Parcelable.Creator<CallInfo>() { // from class: com.autolink.adapterinterface.clusterinteraction.CallInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallInfo createFromParcel(Parcel parcel) {
            return new CallInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallInfo[] newArray(int i) {
            return new CallInfo[i];
        }
    };
    private CallStatus status;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public enum CallStatus {
        START_CALL_PROJECTION_SCREEN(1),
        STOP_CALL_PROJECTION_SCREEN(2);

        private final int value;

        CallStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static CallStatus forNumber(int i) {
            if (i == 1) {
                return START_CALL_PROJECTION_SCREEN;
            }
            if (i != 2) {
                return null;
            }
            return STOP_CALL_PROJECTION_SCREEN;
        }
    }

    public CallInfo() {
    }

    protected CallInfo(Parcel parcel) {
        this.status = CallStatus.forNumber(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status.getNumber());
    }

    public void setStatus(CallStatus callStatus) {
        this.status = callStatus;
    }

    public CallStatus getStatus() {
        return this.status;
    }

    public String toString() {
        return "CallInfo{status=" + this.status.name() + '}';
    }
}
