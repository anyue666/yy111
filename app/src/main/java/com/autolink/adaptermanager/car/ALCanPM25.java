package com.autolink.adaptermanager.car;

/* loaded from: classes.dex */
public class ALCanPM25 {
    private static final int SHORT_MAX_VALUE = 32767;
    private static final int SHORT_MIN_VALUE = -32768;
    private short nPM25Indensity;
    private short nPM25outdensity;

    public short getPM25Indensity() {
        return this.nPM25Indensity;
    }

    public short getPM25outdensity() {
        return this.nPM25outdensity;
    }

    public void setPM25Indensity(int i) {
        if (i > SHORT_MAX_VALUE || i < SHORT_MIN_VALUE) {
            return;
        }
        this.nPM25Indensity = (short) i;
    }

    public void setPM25Outdensity(int i) {
        if (i > SHORT_MAX_VALUE || i < SHORT_MIN_VALUE) {
            return;
        }
        this.nPM25outdensity = (short) i;
    }

    public String toString() {
        return new StringBuffer("ALCanPM25{nPM25Indensity").append((int) this.nPM25Indensity).append("nPM25outdensity").append((int) this.nPM25outdensity).append("\n}").toString();
    }
}
