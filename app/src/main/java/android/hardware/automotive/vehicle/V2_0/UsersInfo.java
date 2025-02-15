package android.hardware.automotive.vehicle.V2_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes.dex */
public final class UsersInfo {
    public UserInfo currentUser = new UserInfo();
    public int numberUsers = 0;
    public ArrayList<UserInfo> existingUsers = new ArrayList<>();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != UsersInfo.class) {
            return false;
        }
        UsersInfo usersInfo = (UsersInfo) obj;
        return HidlSupport.deepEquals(this.currentUser, usersInfo.currentUser) && this.numberUsers == usersInfo.numberUsers && HidlSupport.deepEquals(this.existingUsers, usersInfo.existingUsers);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(this.currentUser)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.numberUsers))), Integer.valueOf(HidlSupport.deepHashCode(this.existingUsers)));
    }

    public final String toString() {
        return "{.currentUser = " + this.currentUser + ", .numberUsers = " + this.numberUsers + ", .existingUsers = " + this.existingUsers + "}";
    }

    public final void readFromParcel(HwParcel hwParcel) {
        readEmbeddedFromParcel(hwParcel, hwParcel.readBuffer(32L), 0L);
    }

    public static final ArrayList<UsersInfo> readVectorFromParcel(HwParcel hwParcel) {
        ArrayList<UsersInfo> arrayList = new ArrayList<>();
        HwBlob readBuffer = hwParcel.readBuffer(16L);
        int int32 = readBuffer.getInt32(8L);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 32, readBuffer.handle(), 0L, true);
        arrayList.clear();
        for (int i = 0; i < int32; i++) {
            UsersInfo usersInfo = new UsersInfo();
            usersInfo.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 32);
            arrayList.add(usersInfo);
        }
        return arrayList;
    }

    public final void readEmbeddedFromParcel(HwParcel hwParcel, HwBlob hwBlob, long j) {
        this.currentUser.readEmbeddedFromParcel(hwParcel, hwBlob, j + 0);
        this.numberUsers = hwBlob.getInt32(j + 8);
        long j2 = j + 16;
        int int32 = hwBlob.getInt32(8 + j2);
        HwBlob readEmbeddedBuffer = hwParcel.readEmbeddedBuffer(int32 * 8, hwBlob.handle(), j2 + 0, true);
        this.existingUsers.clear();
        for (int i = 0; i < int32; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.readEmbeddedFromParcel(hwParcel, readEmbeddedBuffer, i * 8);
            this.existingUsers.add(userInfo);
        }
    }

    public final void writeToParcel(HwParcel hwParcel) {
        HwBlob hwBlob = new HwBlob(32);
        writeEmbeddedToBlob(hwBlob, 0L);
        hwParcel.writeBuffer(hwBlob);
    }

    public static final void writeVectorToParcel(HwParcel hwParcel, ArrayList<UsersInfo> arrayList) {
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
        this.currentUser.writeEmbeddedToBlob(hwBlob, j + 0);
        hwBlob.putInt32(j + 8, this.numberUsers);
        int size = this.existingUsers.size();
        long j2 = j + 16;
        hwBlob.putInt32(8 + j2, size);
        hwBlob.putBool(12 + j2, false);
        HwBlob hwBlob2 = new HwBlob(size * 8);
        for (int i = 0; i < size; i++) {
            this.existingUsers.get(i).writeEmbeddedToBlob(hwBlob2, i * 8);
        }
        hwBlob.putBlob(j2 + 0, hwBlob2);
    }
}
