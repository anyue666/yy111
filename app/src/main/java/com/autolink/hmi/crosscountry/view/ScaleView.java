package com.autolink.hmi.crosscountry.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.autolink.hmi.crosscountry.R;

/* loaded from: classes.dex */
public class ScaleView extends View {
    private Bitmap mBitmap;
    Paint mPaint;

    public ScaleView(Context context) {
        this(context, null);
    }

    public ScaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        initBitmap(context);
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
    }

    public void refreshAngle(float f) {
        setRotation((f / 15.0f) * 22.5f);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void initBitmap(Context context) {
        Drawable drawable = context.getDrawable(R.drawable.altitude_pointer);
        Bitmap createBitmap = Bitmap.createBitmap((int) getResources().getDimension(R.dimen.dp18), (int) getResources().getDimension(R.dimen.dp12), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.mBitmap = createBitmap;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, (getMeasuredHeight() / 2) - (this.mBitmap.getHeight() / 2), this.mPaint);
        }
    }
}
