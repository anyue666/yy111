package com.autolink.hmi.crosscountry.bean;

/* loaded from: classes.dex */
public class HardwareState {
    boolean mSpeed;
    float mXPitchAngle;
    float mYPitchAngle;

    public boolean isSpeed() {
        return this.mSpeed;
    }

    public void setSpeed(boolean z) {
        this.mSpeed = z;
    }

    public float getXPitchAngle() {
        return this.mXPitchAngle;
    }

    public void setXPitchAngle(float f) {
        this.mXPitchAngle = f;
    }

    public float getYPitchAngle() {
        return this.mYPitchAngle;
    }

    public void setYPitchAngle(float f) {
        this.mYPitchAngle = f;
    }
}
