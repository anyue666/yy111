package com.autolink.adapterinterface;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FotaUserComfirmReq implements Parcelable {
    public static final Parcelable.Creator<FotaUserComfirmReq> CREATOR = new Parcelable.Creator<FotaUserComfirmReq>() { // from class: com.autolink.adapterinterface.FotaUserComfirmReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaUserComfirmReq createFromParcel(Parcel parcel) {
            return new FotaUserComfirmReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FotaUserComfirmReq[] newArray(int i) {
            return new FotaUserComfirmReq[i];
        }
    };
    public int ecuNumber;
    public String sessionId;
    public long taskId;
    public ArrayList<UpdateEcuMessage> updateEcuMsgs = new ArrayList<>();

    public static class UpdateEcuMessage {
        public String ecuName;
        public int estimateUpgradeTime;
        public String partNo;
        public String releaseNote;
        public String targetVersion;
        public int updateModel;

        public String toString() {
            return "UpdateEcuMessage msg TODO";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FotaUserComfirmReq msg TODO";
    }

    public FotaUserComfirmReq() {
    }

    public FotaUserComfirmReq(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.taskId = parcel.readLong();
        this.sessionId = parcel.readString();
        this.ecuNumber = parcel.readInt();
        for (int i = 0; i < this.ecuNumber; i++) {
            UpdateEcuMessage updateEcuMessage = new UpdateEcuMessage();
            updateEcuMessage.updateModel = parcel.readInt();
            updateEcuMessage.targetVersion = parcel.readString();
            updateEcuMessage.partNo = parcel.readString();
            updateEcuMessage.releaseNote = parcel.readString();
            updateEcuMessage.estimateUpgradeTime = parcel.readInt();
            updateEcuMessage.ecuName = parcel.readString();
            this.updateEcuMsgs.add(updateEcuMessage);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.taskId);
        parcel.writeString(this.sessionId);
        parcel.writeInt(this.ecuNumber);
        for (int i2 = 0; i2 < this.ecuNumber; i2++) {
            parcel.writeInt(this.updateEcuMsgs.get(i2).updateModel);
            parcel.writeString(this.updateEcuMsgs.get(i2).targetVersion);
            parcel.writeString(this.updateEcuMsgs.get(i2).partNo);
            parcel.writeString(this.updateEcuMsgs.get(i2).releaseNote);
            parcel.writeInt(this.updateEcuMsgs.get(i2).estimateUpgradeTime);
            parcel.writeString(this.updateEcuMsgs.get(i2).ecuName);
        }
    }
}
