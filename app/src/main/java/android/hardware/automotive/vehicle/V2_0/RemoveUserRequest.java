package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class RemoveUserRequest {
    public int requestId = 0;
    public UserInfo removedUserInfo = new UserInfo();
    public UsersInfo usersInfo = new UsersInfo();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != RemoveUserRequest.class) {
            return false;
        }
        RemoveUserRequest removeUserRequest = (RemoveUserRequest) obj;
        return this.requestId == removeUserRequest.requestId && HidlSupport.deepEquals(this.removedUserInfo, removeUserRequest.removedUserInfo) && HidlSupport.deepEquals(this.usersInfo, removeUserRequest.usersInfo);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestId))), Integer.valueOf(HidlSupport.deepHashCode(this.removedUserInfo)), Integer.valueOf(HidlSupport.deepHashCode(this.usersInfo)));
    }

    public final String toString() {
        return "{.requestId = " + this.requestId + ", .removedUserInfo = " + this.removedUserInfo + ", .usersInfo = " + this.usersInfo + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(48L), 0L);
    }

    public static final ArrayList<RemoveUserRequest> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<RemoveUserRequest> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 48, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            RemoveUserRequest removeUserRequest = new RemoveUserRequest();
            removeUserRequest.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 48);
            arrayList.add(removeUserRequest);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.requestId = hwBlob.getInt32(0 + j);
        this.removedUserInfo.readEmbeddedFromParcel(hwParcel, hwBlob, 4 + j);
        this.usersInfo.readEmbeddedFromParcel(hwParcel, hwBlob, j + 16);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(48);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<RemoveUserRequest> arrayList) {
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
        this.removedUserInfo.writeEmbeddedToBlob(hwBlob, 4 + j);
        this.usersInfo.writeEmbeddedToBlob(hwBlob, j + 16);
    }
}
