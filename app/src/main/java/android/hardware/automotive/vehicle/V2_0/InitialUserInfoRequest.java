package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class InitialUserInfoRequest {
    public int requestId = 0;
    public int requestType = 0;
    public UsersInfo usersInfo = new UsersInfo();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != InitialUserInfoRequest.class) {
            return false;
        }
        InitialUserInfoRequest initialUserInfoRequest = (InitialUserInfoRequest) obj;
        return this.requestId == initialUserInfoRequest.requestId && this.requestType == initialUserInfoRequest.requestType && HidlSupport.deepEquals(this.usersInfo, initialUserInfoRequest.usersInfo);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestType))), Integer.valueOf(HidlSupport.deepHashCode(this.usersInfo)));
    }

    public final String toString() {
        return "{.requestId = " + this.requestId + ", .requestType = " + InitialUserInfoRequestType.toString(this.requestType) + ", .usersInfo = " + this.usersInfo + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(40L), 0L);
    }

    public static final ArrayList<InitialUserInfoRequest> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<InitialUserInfoRequest> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 40, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            InitialUserInfoRequest initialUserInfoRequest = new InitialUserInfoRequest();
            initialUserInfoRequest.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 40);
            arrayList.add(initialUserInfoRequest);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.requestId = hwBlob.getInt32(0 + j);
        this.requestType = hwBlob.getInt32(4 + j);
        this.usersInfo.readEmbeddedFromParcel(hwParcel, hwBlob, j + 8);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(40);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<InitialUserInfoRequest> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 40);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 40);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(0 + j, this.requestId);
        hwBlob.putInt32(4 + j, this.requestType);
        this.usersInfo.writeEmbeddedToBlob(hwBlob, j + 8);
    }
}
