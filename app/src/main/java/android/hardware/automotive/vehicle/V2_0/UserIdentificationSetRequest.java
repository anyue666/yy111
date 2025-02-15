package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class UserIdentificationSetRequest {
    public int requestId = 0;
    public UserInfo userInfo = new UserInfo();
    public int numberAssociations = 0;
    public ArrayList<UserIdentificationSetAssociation> associations = new ArrayList<>();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != UserIdentificationSetRequest.class) {
            return false;
        }
        UserIdentificationSetRequest userIdentificationSetRequest = (UserIdentificationSetRequest) obj;
        return this.requestId == userIdentificationSetRequest.requestId && HidlSupport.deepEquals(this.userInfo, userIdentificationSetRequest.userInfo) && this.numberAssociations == userIdentificationSetRequest.numberAssociations && HidlSupport.deepEquals(this.associations, userIdentificationSetRequest.associations);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestId))), Integer.valueOf(HidlSupport.deepHashCode(this.userInfo)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.numberAssociations))), Integer.valueOf(HidlSupport.deepHashCode(this.associations)));
    }

    public final String toString() {
        return "{.requestId = " + this.requestId + ", .userInfo = " + this.userInfo + ", .numberAssociations = " + this.numberAssociations + ", .associations = " + this.associations + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(32L), 0L);
    }

    public static final ArrayList<UserIdentificationSetRequest> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<UserIdentificationSetRequest> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 32, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            UserIdentificationSetRequest userIdentificationSetRequest = new UserIdentificationSetRequest();
            userIdentificationSetRequest.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 32);
            arrayList.add(userIdentificationSetRequest);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.requestId = hwBlob.getInt32(j + 0);
        this.userInfo.readEmbeddedFromParcel(hwParcel, hwBlob, j + 4);
        this.numberAssociations = hwBlob.getInt32(j + 12);
        long j2 = j + 16;
        int int32 = hwBlob.getInt32(8 + j2);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 8, hwBlob.handle(), j2 + 0, true);
        this.associations.clear();
        for (int i = 0; i < int32; i++) {
            UserIdentificationSetAssociation userIdentificationSetAssociation = new UserIdentificationSetAssociation();
            userIdentificationSetAssociation.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 8);
            this.associations.add(userIdentificationSetAssociation);
        }
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(32);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<UserIdentificationSetRequest> arrayList) {
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
        hwBlob.putInt32(j + 12, this.numberAssociations);
        int size = this.associations.size();
        long j2 = j + 16;
        hwBlob.putInt32(8 + j2, size);
        hwBlob.putBool(12 + j2, false);
        HwBlob hwBlob2 = new HwBlob(size * 8);
        for (int i = 0; i < size; i++) {
            this.associations.get(i).writeEmbeddedToBlob(hwBlob2, i * 8);
        }
        hwBlob.putBlob(j2 + 0, hwBlob2);
    }
}
