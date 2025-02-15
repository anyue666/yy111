package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.autolink.adaptermanager.car.ALVehicleControlProperty;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final String TAG = "LottieDrawable";
    private int alpha;
    private final LottieValueAnimator animator;
    private final Set<ColorFilterData> colorFilterData;
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    private boolean enableMergePaths;
    FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private final Matrix matrix = new Matrix();
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private float scale;
    private boolean systemAnimationsEnabled;
    TextDelegate textDelegate;

    private interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$1 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.compositionLayer != null) {
                LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getAnimatedValueAbsolute());
            }
        }
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        this.scale = 1.0f;
        this.systemAnimationsEnabled = true;
        this.colorFilterData = new HashSet();
        this.lazyCompositionTasks = new ArrayList<>();
        AnonymousClass1 anonymousClass1 = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.compositionLayer != null) {
                    LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getAnimatedValueAbsolute());
                }
            }
        };
        this.progressUpdateListener = anonymousClass1;
        this.alpha = 255;
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(anonymousClass1);
    }

    public boolean hasMasks() {
        CompositionLayer compositionLayer = this.compositionLayer;
        return compositionLayer != null && compositionLayer.hasMasks();
    }

    public boolean hasMatte() {
        CompositionLayer compositionLayer = this.compositionLayer;
        return compositionLayer != null && compositionLayer.hasMatte();
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.enableMergePaths == z) {
            return;
        }
        this.enableMergePaths = z;
        if (this.composition != null) {
            buildCompositionLayer();
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void setImagesAssetsFolder(String str) {
        this.imageAssetsFolder = str;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.composition == lottieComposition) {
            return false;
        }
        this.isDirty = false;
        clearComposition();
        this.composition = lottieComposition;
        buildCompositionLayer();
        this.animator.setComposition(lottieComposition);
        setProgress(this.animator.getAnimatedFraction());
        setScale(this.scale);
        updateBounds();
        Iterator it = new ArrayList(this.lazyCompositionTasks).iterator();
        while (it.hasNext()) {
            ((LazyCompositionTask) it.next()).run(lottieComposition);
            it.remove();
        }
        this.lazyCompositionTasks.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTrackingEnabled = z;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z);
        }
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.isApplyingOpacityToLayersEnabled = z;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    private void buildCompositionLayer() {
        this.compositionLayer = new CompositionLayer(this, LayerParser.parse(this.composition), this.composition.getLayers(), this.composition);
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        int i;
        this.isDirty = false;
        L.beginSection("Drawable#draw");
        if (this.compositionLayer == null) {
            return;
        }
        float f2 = this.scale;
        float maxScale = getMaxScale(canvas);
        if (f2 > maxScale) {
            f = this.scale / maxScale;
        } else {
            maxScale = f2;
            f = 1.0f;
        }
        if (f > 1.0f) {
            i = canvas.save();
            float width = this.composition.getBounds().width() / 2.0f;
            float height = this.composition.getBounds().height() / 2.0f;
            float f3 = width * maxScale;
            float f4 = height * maxScale;
            canvas.translate((getScale() * width) - f3, (getScale() * height) - f4);
            canvas.scale(f, f, f3, f4);
        } else {
            i = -1;
        }
        this.matrix.reset();
        this.matrix.preScale(maxScale, maxScale);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        L.endSection("Drawable#draw");
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$2 */
    class AnonymousClass2 implements LazyCompositionTask {
        AnonymousClass2() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.playAnimation();
        }
    }

    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.2
                AnonymousClass2() {
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.playAnimation();
                }
            });
            return;
        }
        if (this.systemAnimationsEnabled || getRepeatCount() == 0) {
            this.animator.playAnimation();
        }
        if (this.systemAnimationsEnabled) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$3 */
    class AnonymousClass3 implements LazyCompositionTask {
        AnonymousClass3() {
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.resumeAnimation();
        }
    }

    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.3
                AnonymousClass3() {
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.resumeAnimation();
                }
            });
        } else if (this.systemAnimationsEnabled) {
            this.animator.resumeAnimation();
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$4 */
    class AnonymousClass4 implements LazyCompositionTask {
        final /* synthetic */ int val$minFrame;

        AnonymousClass4(int i) {
            r2 = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinFrame(r2);
        }
    }

    public void setMinFrame(int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.4
                final /* synthetic */ int val$minFrame;

                AnonymousClass4(int i2) {
                    r2 = i2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinFrame(r2);
                }
            });
        } else {
            this.animator.setMinFrame(i2);
        }
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$5 */
    class AnonymousClass5 implements LazyCompositionTask {
        final /* synthetic */ float val$minProgress;

        AnonymousClass5(float f) {
            r2 = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinProgress(r2);
        }
    }

    public void setMinProgress(float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.5
                final /* synthetic */ float val$minProgress;

                AnonymousClass5(float f2) {
                    r2 = f2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinProgress(r2);
                }
            });
        } else {
            setMinFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f2));
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$6 */
    class AnonymousClass6 implements LazyCompositionTask {
        final /* synthetic */ int val$maxFrame;

        AnonymousClass6(int i) {
            r2 = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMaxFrame(r2);
        }
    }

    public void setMaxFrame(int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.6
                final /* synthetic */ int val$maxFrame;

                AnonymousClass6(int i2) {
                    r2 = i2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxFrame(r2);
                }
            });
        } else {
            this.animator.setMaxFrame(i2 + 0.99f);
        }
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$7 */
    class AnonymousClass7 implements LazyCompositionTask {
        final /* synthetic */ float val$maxProgress;

        AnonymousClass7(float f) {
            r2 = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMaxProgress(r2);
        }
    }

    public void setMaxProgress(float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.7
                final /* synthetic */ float val$maxProgress;

                AnonymousClass7(float f2) {
                    r2 = f2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMaxProgress(r2);
                }
            });
        } else {
            setMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f2));
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$8 */
    class AnonymousClass8 implements LazyCompositionTask {
        final /* synthetic */ String val$markerName;

        AnonymousClass8(String str) {
            r2 = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinFrame(r2);
        }
    }

    public void setMinFrame(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.8
                final /* synthetic */ String val$markerName;

                AnonymousClass8(String str2) {
                    r2 = str2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinFrame(r2);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str2);
        if (marker == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        setMinFrame((int) marker.startFrame);
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$9 */
    class AnonymousClass9 implements LazyCompositionTask {
        final /* synthetic */ String val$markerName;

        AnonymousClass9(String str) {
            r2 = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMaxFrame(r2);
        }
    }

    public void setMaxFrame(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.9
                final /* synthetic */ String val$markerName;

                AnonymousClass9(String str2) {
                    r2 = str2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMaxFrame(r2);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str2);
        if (marker == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        setMaxFrame((int) (marker.startFrame + marker.durationFrames));
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$10 */
    class AnonymousClass10 implements LazyCompositionTask {
        final /* synthetic */ String val$markerName;

        AnonymousClass10(String str) {
            r2 = str;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinAndMaxFrame(r2);
        }
    }

    public void setMinAndMaxFrame(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.10
                final /* synthetic */ String val$markerName;

                AnonymousClass10(String str2) {
                    r2 = str2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinAndMaxFrame(r2);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str2);
        if (marker == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        int i = (int) marker.startFrame;
        setMinAndMaxFrame(i, ((int) marker.durationFrames) + i);
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$11 */
    class AnonymousClass11 implements LazyCompositionTask {
        final /* synthetic */ int val$maxFrame;
        final /* synthetic */ int val$minFrame;

        AnonymousClass11(int i, int i2) {
            r2 = i;
            r3 = i2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinAndMaxFrame(r2, r3);
        }
    }

    public void setMinAndMaxFrame(int i, int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.11
                final /* synthetic */ int val$maxFrame;
                final /* synthetic */ int val$minFrame;

                AnonymousClass11(int i3, int i22) {
                    r2 = i3;
                    r3 = i22;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxFrame(r2, r3);
                }
            });
        } else {
            this.animator.setMinAndMaxFrames(i3, i22 + 0.99f);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$12 */
    class AnonymousClass12 implements LazyCompositionTask {
        final /* synthetic */ float val$maxProgress;
        final /* synthetic */ float val$minProgress;

        AnonymousClass12(float f, float f2) {
            r2 = f;
            r3 = f2;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setMinAndMaxProgress(r2, r3);
        }
    }

    public void setMinAndMaxProgress(float f, float f2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.12
                final /* synthetic */ float val$maxProgress;
                final /* synthetic */ float val$minProgress;

                AnonymousClass12(float f3, float f22) {
                    r2 = f3;
                    r3 = f22;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinAndMaxProgress(r2, r3);
                }
            });
        } else {
            setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f3), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f22));
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.animator.setSpeed(f);
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$13 */
    class AnonymousClass13 implements LazyCompositionTask {
        final /* synthetic */ int val$frame;

        AnonymousClass13(int i) {
            r2 = i;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setFrame(r2);
        }
    }

    public void setFrame(int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.13
                final /* synthetic */ int val$frame;

                AnonymousClass13(int i2) {
                    r2 = i2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setFrame(r2);
                }
            });
        } else {
            this.animator.setFrame(i2);
        }
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$14 */
    class AnonymousClass14 implements LazyCompositionTask {
        final /* synthetic */ float val$progress;

        AnonymousClass14(float f) {
            r2 = f;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.setProgress(r2);
        }
    }

    public void setProgress(float f) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.14
                final /* synthetic */ float val$progress;

                AnonymousClass14(float f2) {
                    r2 = f2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setProgress(r2);
                }
            });
            return;
        }
        L.beginSection("Drawable#setProgress");
        this.animator.setFrame(MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f2));
        L.endSection("Drawable#setProgress");
    }

    @Deprecated
    public void loop(boolean z) {
        this.animator.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.animator.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.animator.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.animator.isRunning();
    }

    void setSystemAnimationsAreEnabled(Boolean bool) {
        this.systemAnimationsEnabled = bool.booleanValue();
    }

    public void setScale(float f) {
        this.scale = f;
        updateBounds();
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.imageAssetDelegate = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.fontAssetDelegate = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.fontAssetManager;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.textDelegate = textDelegate;
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public boolean useTextGlyphs() {
        return this.textDelegate == null && this.composition.getCharacters().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    private void updateBounds() {
        if (this.composition == null) {
            return;
        }
        float scale = getScale();
        setBounds(0, 0, (int) (this.composition.getBounds().width() * scale), (int) (this.composition.getBounds().height() * scale));
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (r0.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (r0.getBounds().height() * getScale());
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.compositionLayer == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$15 */
    class AnonymousClass15 implements LazyCompositionTask {
        final /* synthetic */ LottieValueCallback val$callback;
        final /* synthetic */ KeyPath val$keyPath;
        final /* synthetic */ Object val$property;

        AnonymousClass15(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
            r2 = keyPath;
            r3 = obj;
            r4 = lottieValueCallback;
        }

        @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
        public void run(LottieComposition lottieComposition) {
            LottieDrawable.this.addValueCallback(r2, (KeyPath) r3, (LottieValueCallback<KeyPath>) r4);
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.LottieDrawable.15
                final /* synthetic */ LottieValueCallback val$callback;
                final /* synthetic */ KeyPath val$keyPath;
                final /* synthetic */ Object val$property;

                AnonymousClass15(KeyPath keyPath2, Object t2, LottieValueCallback lottieValueCallback2) {
                    r2 = keyPath2;
                    r3 = t2;
                    r4 = lottieValueCallback2;
                }

                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.addValueCallback(r2, (KeyPath) r3, (LottieValueCallback<KeyPath>) r4);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath2.getResolvedElement() != null) {
            keyPath2.getResolvedElement().addValueCallback(t2, lottieValueCallback2);
        } else {
            List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath2);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).getResolvedElement().addValueCallback(t2, lottieValueCallback2);
            }
            z = true ^ resolveKeyPath.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t2 == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    /* renamed from: com.airbnb.lottie.LottieDrawable$16 */
    class AnonymousClass16<T> extends LottieValueCallback<T> {
        final /* synthetic */ SimpleLottieValueCallback val$callback;

        AnonymousClass16(SimpleLottieValueCallback simpleLottieValueCallback) {
            r2 = simpleLottieValueCallback;
        }

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
            return (T) r2.getValue(lottieFrameInfo);
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>() { // from class: com.airbnb.lottie.LottieDrawable.16
            final /* synthetic */ SimpleLottieValueCallback val$callback;

            AnonymousClass16(SimpleLottieValueCallback simpleLottieValueCallback2) {
                r2 = simpleLottieValueCallback2;
            }

            @Override // com.airbnb.lottie.value.LottieValueCallback
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return (T) r2.getValue(lottieFrameInfo);
            }
        });
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = imageAssetManager.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    public Bitmap getImageAsset(String str) {
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.bitmapForId(str);
        }
        return null;
    }

    private ImageAssetManager getImageAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null && !imageAssetManager.hasSameContext(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
        }
        return this.imageAssetManager;
    }

    public Typeface getTypeface(String str, String str2) {
        FontAssetManager fontAssetManager = getFontAssetManager();
        if (fontAssetManager != null) {
            return fontAssetManager.getTypeface(str, str2);
        }
        return null;
    }

    private FontAssetManager getFontAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
        }
        return this.fontAssetManager;
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private float getMaxScale(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.composition.getBounds().width(), canvas.getHeight() / this.composition.getBounds().height());
    }

    private static class ColorFilterData {
        final ColorFilter colorFilter;
        final String contentName;
        final String layerName;

        ColorFilterData(String str, String str2, ColorFilter colorFilter) {
            this.layerName = str;
            this.contentName = str2;
            this.colorFilter = colorFilter;
        }

        public int hashCode() {
            String str = this.layerName;
            int hashCode = str != null ? ALVehicleControlProperty.VEHICLE_PROPERTY_VC_VENDOR_MIRROR_FLIP * str.hashCode() : 17;
            String str2 = this.contentName;
            return str2 != null ? hashCode * 31 * str2.hashCode() : hashCode;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ColorFilterData)) {
                return false;
            }
            ColorFilterData colorFilterData = (ColorFilterData) obj;
            return hashCode() == colorFilterData.hashCode() && this.colorFilter == colorFilterData.colorFilter;
        }
    }
}
