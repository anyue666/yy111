package com.autolink.adaptermanager.car;

/* loaded from: classes.dex */
public class ALCanVehicleFrag {
    private static final int BYTE_MAX_VALUE = 255;
    private static final int BYTE_MIN_VALUE = 0;
    private static final int SHORT_MAX_VALUE = 32767;
    private static final int SHORT_MIN_VALUE = -32768;
    private short nFRAG_FraganceBoxALoad;
    private short nFRAG_FraganceBoxBLoad;
    private short nFRAG_FraganceBoxCLoad;
    private byte nFRAG_FraganceTaste1RemanentRatio;
    private byte nFRAG_FraganceTaste2RemanentRatio;
    private byte nFRAG_FraganceTaste3RemanentRatio;
    private short nRev1;

    public void setFRAG_FraganceTaste1RemanentRatio(int i) {
        if (i > 255 || i < 0) {
            return;
        }
        this.nFRAG_FraganceTaste1RemanentRatio = (byte) (i & 255);
    }

    public void setFRAG_FraganceTaste2RemanentRatio(int i) {
        byte b = this.nFRAG_FraganceTaste1RemanentRatio;
        if (b > 255 || b < 0) {
            return;
        }
        this.nFRAG_FraganceTaste2RemanentRatio = (byte) (i & 255);
    }

    public void setFRAG_FraganceTaste3RemanentRatio(int i) {
        byte b = this.nFRAG_FraganceTaste1RemanentRatio;
        if (b > 255 || b < 0) {
            return;
        }
        this.nFRAG_FraganceTaste3RemanentRatio = (byte) (i & 255);
    }

    public void setFRAG_FraganceBoxALoad(int i) {
        if (i > SHORT_MAX_VALUE || i < SHORT_MIN_VALUE) {
            return;
        }
        this.nFRAG_FraganceBoxALoad = (short) i;
    }

    public void setFRAG_FraganceBoxBLoad(int i) {
        short s = this.nFRAG_FraganceBoxALoad;
        if (s > SHORT_MAX_VALUE || s < SHORT_MIN_VALUE) {
            return;
        }
        this.nFRAG_FraganceBoxBLoad = (short) i;
    }

    public void setFRAG_FraganceBoxCLoad(int i) {
        short s = this.nFRAG_FraganceBoxALoad;
        if (s > SHORT_MAX_VALUE || s < SHORT_MIN_VALUE) {
            return;
        }
        this.nFRAG_FraganceBoxCLoad = (short) i;
    }

    public byte getFRAG_FraganceTaste1RemanentRatio() {
        return this.nFRAG_FraganceTaste1RemanentRatio;
    }

    public byte getFRAG_FraganceTaste2RemanentRatio() {
        return this.nFRAG_FraganceTaste2RemanentRatio;
    }

    public byte getFRAG_FraganceTaste3RemanentRatio() {
        return this.nFRAG_FraganceTaste3RemanentRatio;
    }

    public short getFRAG_FraganceBoxALoad() {
        return this.nFRAG_FraganceBoxALoad;
    }

    public short getFRAG_FraganceBoxBLoad() {
        return this.nFRAG_FraganceBoxBLoad;
    }

    public short getFRAG_FraganceBoxCLoad() {
        return this.nFRAG_FraganceBoxCLoad;
    }

    public short getRev1() {
        return this.nRev1;
    }

    public String toString() {
        return new StringBuffer("ALCanVehicleFrag{nFRAG_FraganceTaste1RemanentRatio").append((int) this.nFRAG_FraganceTaste1RemanentRatio).append("nFRAG_FraganceTaste2RemanentRatio").append((int) this.nFRAG_FraganceTaste2RemanentRatio).append("nFRAG_FraganceTaste3RemanentRatio").append((int) this.nFRAG_FraganceTaste3RemanentRatio).append("nFRAG_FraganceBoxALoad").append((int) this.nFRAG_FraganceBoxALoad).append("nFRAG_FraganceBoxBLoad").append((int) this.nFRAG_FraganceBoxBLoad).append("nFRAG_FraganceBoxCLoad").append((int) this.nFRAG_FraganceBoxCLoad).append("nRev1").append((int) this.nRev1).append("\n}").toString();
    }
}
