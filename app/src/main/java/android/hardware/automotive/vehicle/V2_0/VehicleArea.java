package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VehicleArea {
    public static final int DOOR = 100663296;
    public static final int GLOBAL = 16777216;
    public static final int MASK = 251658240;
    public static final int MIRROR = 67108864;
    public static final int SEAT = 83886080;
    public static final int WHEEL = 117440512;
    public static final int WINDOW = 50331648;

    public static final String toString(int i) {
        return i == 16777216 ? "GLOBAL" : i == 50331648 ? "WINDOW" : i == 67108864 ? "MIRROR" : i == 83886080 ? "SEAT" : i == 100663296 ? "DOOR" : i == 117440512 ? "WHEEL" : i == 251658240 ? "MASK" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 16777216;
        if ((i & 16777216) == 16777216) {
            arrayList.add("GLOBAL");
        } else {
            i2 = 0;
        }
        if ((i & WINDOW) == 50331648) {
            arrayList.add("WINDOW");
            i2 |= WINDOW;
        }
        if ((i & MIRROR) == 67108864) {
            arrayList.add("MIRROR");
            i2 |= MIRROR;
        }
        if ((i & SEAT) == 83886080) {
            arrayList.add("SEAT");
            i2 |= SEAT;
        }
        if ((i & DOOR) == 100663296) {
            arrayList.add("DOOR");
            i2 |= DOOR;
        }
        if ((i & WHEEL) == 117440512) {
            arrayList.add("WHEEL");
            i2 |= WHEEL;
        }
        if ((i & MASK) == 251658240) {
            arrayList.add("MASK");
            i2 |= MASK;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
