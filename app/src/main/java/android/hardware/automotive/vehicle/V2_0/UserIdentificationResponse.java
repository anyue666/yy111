package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class UserIdentificationResponse {
    public int requestId = 0;
    public int numberAssociation = 0;
    public ArrayList<UserIdentificationAssociation> associations = new ArrayList<>();
    public String errorMessage = new String();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != UserIdentificationResponse.class) {
            return false;
        }
        UserIdentificationResponse userIdentificationResponse = (UserIdentificationResponse) obj;
        return this.requestId == userIdentificationResponse.requestId && this.numberAssociation == userIdentificationResponse.numberAssociation && HidlSupport.deepEquals(this.associations, userIdentificationResponse.associations) && HidlSupport.deepEquals(this.errorMessage, userIdentificationResponse.errorMessage);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.numberAssociation))), Integer.valueOf(HidlSupport.deepHashCode(this.associations)), Integer.valueOf(HidlSupport.deepHashCode(this.errorMessage)));
    }

    public final String toString() {
        return "{.requestId = " + this.requestId + ", .numberAssociation = " + this.numberAssociation + ", .associations = " + this.associations + ", .errorMessage = " + this.errorMessage + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(40L), 0L);
    }

    public static final ArrayList<UserIdentificationResponse> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<UserIdentificationResponse> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 40, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            UserIdentificationResponse userIdentificationResponse = new UserIdentificationResponse();
            userIdentificationResponse.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 40);
            arrayList.add(userIdentificationResponse);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.requestId = hwBlob.getInt32(j + 0);
        this.numberAssociation = hwBlob.getInt32(j + 4);
        long j2 = j + 8;
        int int32 = hwBlob.getInt32(8 + j2);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 8, hwBlob.handle(), j2 + 0, true);
        this.associations.clear();
        for (int i = 0; i < int32; i++) {
            UserIdentificationAssociation userIdentificationAssociation = new UserIdentificationAssociation();
            userIdentificationAssociation.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 8);
            this.associations.add(userIdentificationAssociation);
        }
        long j3 = j + 24;
        this.errorMessage = hwBlob.getString(j3);
        hwParcel.readEmbeddedBuffer(r6.getBytes().length + 1, hwBlob.handle(), j3 + 0, false);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(40);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<UserIdentificationResponse> arrayList) {
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
        hwBlob.putInt32(j + 0, this.requestId);
        hwBlob.putInt32(4 + j, this.numberAssociation);
        int size = this.associations.size();
        long j2 = j + 8;
        hwBlob.putInt32(8 + j2, size);
        hwBlob.putBool(12 + j2, false);
        HwBlob hwBlob2 = new HwBlob(size * 8);
        for (int i = 0; i < size; i++) {
            this.associations.get(i).writeEmbeddedToBlob(hwBlob2, i * 8);
        }
        hwBlob.putBlob(j2 + 0, hwBlob2);
        hwBlob.putString(j + 24, this.errorMessage);
    }
}
