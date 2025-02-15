package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class SwitchUserRequest {
    public int requestId = 0;
    public int messageType = 0;
    public UserInfo targetUser = new UserInfo();
    public UsersInfo usersInfo = new UsersInfo();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != SwitchUserRequest.class) {
            return false;
        }
        SwitchUserRequest switchUserRequest = (SwitchUserRequest) obj;
        return this.requestId == switchUserRequest.requestId && this.messageType == switchUserRequest.messageType && HidlSupport.deepEquals(this.targetUser, switchUserRequest.targetUser) && HidlSupport.deepEquals(this.usersInfo, switchUserRequest.usersInfo);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.messageType))), Integer.valueOf(HidlSupport.deepHashCode(this.targetUser)), Integer.valueOf(HidlSupport.deepHashCode(this.usersInfo)));
    }

    public final String toString() {
        return "{.requestId = " + this.requestId + ", .messageType = " + SwitchUserMessageType.toString(this.messageType) + ", .targetUser = " + this.targetUser + ", .usersInfo = " + this.usersInfo + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(48L), 0L);
    }

    public static final ArrayList<SwitchUserRequest> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<SwitchUserRequest> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 48, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            SwitchUserRequest switchUserRequest = new SwitchUserRequest();
            switchUserRequest.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 48);
            arrayList.add(switchUserRequest);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.requestId = hwBlob.getInt32(0 + j);
        this.messageType = hwBlob.getInt32(4 + j);
        this.targetUser.readEmbeddedFromParcel(hwParcel, hwBlob, 8 + j);
        this.usersInfo.readEmbeddedFromParcel(hwParcel, hwBlob, j + 16);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(48);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<SwitchUserRequest> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 48);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 48);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(0 + j, this.requestId);
        hwBlob.putInt32(4 + j, this.messageType);
        this.targetUser.writeEmbeddedToBlob(hwBlob, 8 + j);
        this.usersInfo.writeEmbeddedToBlob(hwBlob, j + 16);
    }
}
