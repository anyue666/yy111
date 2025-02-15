package android.car.cluster.renderer;

import android.annotation.SystemApi;
import android.content.Context;

@SystemApi
@Deprecated
/* loaded from: classes.dex */
public abstract class InstrumentClusterRenderer {
    private final Object mLock = new Object();
    private NavigationRenderer mNavigationRenderer;

    protected abstract NavigationRenderer createNavigationRenderer();

    public abstract void onCreate(Context context);

    public abstract void onStart();

    public abstract void onStop();

    public NavigationRenderer getNavigationRenderer() {
        NavigationRenderer navigationRenderer;
        synchronized (this.mLock) {
            navigationRenderer = this.mNavigationRenderer;
        }
        return navigationRenderer;
    }

    public final void initialize() {
        synchronized (this.mLock) {
            this.mNavigationRenderer = createNavigationRenderer();
        }
    }
}
