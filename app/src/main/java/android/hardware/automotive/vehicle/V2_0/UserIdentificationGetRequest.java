package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class UserIdentificationGetRequest {
    public int requestId = 0;
    public UserInfo userInfo = new UserInfo();
    public int numberAssociationTypes = 0;
    public ArrayList<Integer> associationTypes = new ArrayList<>();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != UserIdentificationGetRequest.class) {
            return false;
        }
        UserIdentificationGetRequest userIdentificationGetRequest = (UserIdentificationGetRequest) obj;
        return this.requestId == userIdentificationGetRequest.requestId && HidlSupport.deepEquals(this.userInfo, userIdentificationGetRequest.userInfo) && this.numberAssociationTypes == userIdentificationGetRequest.numberAssociationTypes && HidlSupport.deepEquals(this.associationTypes, userIdentificationGetRequest.associationTypes);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestId))), Integer.valueOf(HidlSupport.deepHashCode(this.userInfo)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.numberAssociationTypes))), Integer.valueOf(HidlSupport.deepHashCode(this.associationTypes)));
    }

    public final String toString() {
        return "{.requestId = " + this.requestId + ", .userInfo = " + this.userInfo + ", .numberAssociationTypes = " + this.numberAssociationTypes + ", .associationTypes = " + this.associationTypes + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(32L), 0L);
    }

    public static final ArrayList<UserIdentificationGetRequest> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<UserIdentificationGetRequest> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 32, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            UserIdentificationGetRequest userIdentificationGetRequest = new UserIdentificationGetRequest();
            userIdentificationGetRequest.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 32);
            arrayList.add(userIdentificationGetRequest);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.requestId = hwBlob.getInt32(j + 0);
        this.userInfo.readEmbeddedFromParcel(hwParcel, hwBlob, j + 4);
        this.numberAssociationTypes = hwBlob.getInt32(j + 12);
        long j2 = j + 16;
        int int32 = hwBlob.getInt32(8 + j2);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 4, hwBlob.handle(), j2 + 0, true);
        this.associationTypes.clear();
        for (int i = 0; i < int32; i++) {
            this.associationTypes.add(Integer.valueOf(readEmbeddedBuffer.getInt32(i * 4)));
        }
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(32);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<UserIdentificationGetRequest> arrayList) {
        HwBlob hwBlob = new HwBlob(16);
        int size = arrayList.size();
        hwBlob.putInt32(8L, size);
        hwBlob.putBool(12L, false);
        HwBlob hwBlob2 = new HwBlob(size * 32);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).writeEmbeddedToBlob(hwBlob2, i * 32);
        }
        hwBlob.putBlob(0L, hwBlob2);
        hwParcel.writeBuffer(hwBlob);
    }

    public final void writeEmbeddedToBlob(HwBlob hwBlob, long j) {
        hwBlob.putInt32(j + 0, this.requestId);
        this.userInfo.writeEmbeddedToBlob(hwBlob, 4 + j);
        hwBlob.putInt32(j + 12, this.numberAssociationTypes);
        int size = this.associationTypes.size();
        long j2 = j + 16;
        hwBlob.putInt32(8 + j2, size);
        hwBlob.putBool(12 + j2, false);
        HwBlob hwBlob2 = new HwBlob(size * 4);
        for (int i = 0; i < size; i++) {
            hwBlob2.putInt32(i * 4, this.associationTypes.get(i).intValue());
        }
        hwBlob.putBlob(j2 + 0, hwBlob2);
    }
}
