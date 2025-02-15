package com.autolink.hmi.crosscountry.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.autolink.hmi.crosscountry.R;

/* loaded from: classes.dex */
public class PressureScale extends View {
    private static String TAG = "PressureScale";
    float lineLength;
    private Bitmap mBitmap;
    Paint mPaint;
    float mSumAngle;
    Paint mTextPaint;
    int number;
    int offset;

    private void initBitmap(Context context) {
    }

    public PressureScale(Context context) {
        this(context, null);
    }

    public PressureScale(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressureScale(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lineLength = 0.0f;
        this.mSumAngle = 0.0f;
        this.number = 0;
        this.offset = 10;
        init();
        initBitmap(context);
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStrokeWidth(1.0f);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(getResources().getDimension(R.dimen.sp30));
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setStrokeWidth(1.0f);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setColor(getResources().getColor(R.color.color_05));
        this.mTextPaint.setTextSize(getResources().getDimension(R.dimen.sp12));
        this.lineLength = getResources().getDimension(R.dimen.dp4);
    }

    public void refreshAngle(float f) {
        setRotation(f);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void testDroaw(Canvas canvas, int i) {
        String str = i + "";
        canvas.save();
        Rect rect = new Rect();
        this.mTextPaint.getTextBounds(str, 0, str.length(), rect);
        int height = rect.height();
        canvas.rotate(-90.0f, rect.width() / 2, getHeight() / 2);
        if (i > 100) {
            canvas.translate(0.0f, -4.0f);
            canvas.drawText(str, 0.0f, (getHeight() / 2) + (height / 2), this.mTextPaint);
        } else {
            canvas.drawText(str, 0.0f, (getHeight() / 2) + (height / 2), this.mTextPaint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float measureText = this.mTextPaint.measureText("00", 0, 2);
        float f = this.mTextPaint.getFontMetrics().top;
        float f2 = this.mTextPaint.getFontMetrics().bottom;
        float measuredWidth = getMeasuredWidth() / 2;
        float measuredHeight = getMeasuredHeight() / 2;
        for (int i = 0; i < 16; i++) {
            this.number += 15;
            if (this.mSumAngle <= 202.5d) {
                if (i % 2 != 0) {
                    this.mPaint.setStrokeWidth(2.0f);
                    this.mPaint.setColor(getResources().getColor(R.color.color_018));
                    testDroaw(canvas, this.number);
                    canvas.drawLine(4.0f + measureText, measuredHeight, this.lineLength + measureText + 6.0f, measuredHeight, this.mPaint);
                } else {
                    this.mPaint.setColor(getResources().getColor(R.color.color_019));
                    canvas.drawLine(4.0f + measureText, measuredHeight, this.lineLength + measureText + 6.0f, measuredHeight, this.mPaint);
                }
            }
            if (this.mSumAngle == 337.5d) {
                testDroaw(canvas, 0);
                canvas.drawLine(measureText + 5.0f, measuredHeight, this.lineLength + measureText + 6.0f, measuredHeight, this.mPaint);
            }
            Log.e(TAG, this.mSumAngle + "");
            this.mSumAngle += 22.5f;
            canvas.rotate(22.5f, measuredWidth, measuredHeight);
        }
        this.number = 0;
        this.mSumAngle = 0.0f;
        super.onDraw(canvas);
    }
}
