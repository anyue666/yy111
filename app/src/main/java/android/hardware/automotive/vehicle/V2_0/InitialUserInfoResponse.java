package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class InitialUserInfoResponse {
    public int requestId = 0;
    public int action = 0;
    public UserInfo userToSwitchOrCreate = new UserInfo();
    public String userLocales = new String();
    public String userNameToCreate = new String();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != InitialUserInfoResponse.class) {
            return false;
        }
        InitialUserInfoResponse initialUserInfoResponse = (InitialUserInfoResponse) obj;
        return this.requestId == initialUserInfoResponse.requestId && this.action == initialUserInfoResponse.action && HidlSupport.deepEquals(this.userToSwitchOrCreate, initialUserInfoResponse.userToSwitchOrCreate) && HidlSupport.deepEquals(this.userLocales, initialUserInfoResponse.userLocales) && HidlSupport.deepEquals(this.userNameToCreate, initialUserInfoResponse.userNameToCreate);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.requestId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.action))), Integer.valueOf(HidlSupport.deepHashCode(this.userToSwitchOrCreate)), Integer.valueOf(HidlSupport.deepHashCode(this.userLocales)), Integer.valueOf(HidlSupport.deepHashCode(this.userNameToCreate)));
    }

    public final String toString() {
        return "{.requestId = " + this.requestId + ", .action = " + InitialUserInfoResponseAction.toString(this.action) + ", .userToSwitchOrCreate = " + this.userToSwitchOrCreate + ", .userLocales = " + this.userLocales + ", .userNameToCreate = " + this.userNameToCreate + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(48L), 0L);
    }

    public static final ArrayList<InitialUserInfoResponse> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<InitialUserInfoResponse> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 48, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            InitialUserInfoResponse initialUserInfoResponse = new InitialUserInfoResponse();
            initialUserInfoResponse.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 48);
            arrayList.add(initialUserInfoResponse);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.requestId = hwBlob.getInt32(j + 0);
        this.action = hwBlob.getInt32(j + 4);
        this.userToSwitchOrCreate.readEmbeddedFromParcel(hwParcel, hwBlob, j + 8);
        long j2 = j + 16;
        this.userLocales = hwBlob.getString(j2);
        hwParcel.readEmbeddedBuffer(r6.getBytes().length + 1, hwBlob.handle(), j2 + 0, false);
        long j3 = j + 32;
        this.userNameToCreate = hwBlob.getString(j3);
        hwParcel.readEmbeddedBuffer(r6.getBytes().length + 1, hwBlob.handle(), j3 + 0, false);
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(48);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<InitialUserInfoResponse> arrayList) {
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
        hwBlob.putInt32(4 + j, this.action);
        this.userToSwitchOrCreate.writeEmbeddedToBlob(hwBlob, 8 + j);
        hwBlob.putString(16 + j, this.userLocales);
        hwBlob.putString(j + 32, this.userNameToCreate);
    }
}
