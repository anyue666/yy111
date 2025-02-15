package android.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class RotaryInputType {
    public static final int ROTARY_INPUT_TYPE_AUDIO_VOLUME = 1;
    public static final int ROTARY_INPUT_TYPE_SYSTEM_NAVIGATION = 0;

    public static final String toString(int i) {
        return i == 0 ? "ROTARY_INPUT_TYPE_SYSTEM_NAVIGATION" : i == 1 ? "ROTARY_INPUT_TYPE_AUDIO_VOLUME" : "0x" + Integer.toHexString(i);
    }

    public static final String dumpBitfield(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ROTARY_INPUT_TYPE_SYSTEM_NAVIGATION");
        int i2 = 1;
        if ((i & 1) == 1) {
            arrayList.add("ROTARY_INPUT_TYPE_AUDIO_VOLUME");
        } else {
            i2 = 0;
        }
        if (i != i2) {
            arrayList.add("0x" + Integer.toHexString(i & (~i2)));
        }
        return String.join(" | ", arrayList);
    }
}
