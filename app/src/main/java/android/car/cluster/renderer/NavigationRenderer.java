package android.car.cluster.renderer;

import android.annotation.SystemApi;
import android.car.navigation.CarNavigationInstrumentCluster;
import android.os.Bundle;

@SystemApi
/* loaded from: classes.dex */
public abstract class NavigationRenderer {
    public abstract CarNavigationInstrumentCluster getNavigationProperties();

    public void onEvent(int i, Bundle bundle) {
    }

    public void onNavigationStateChanged(Bundle bundle) {
    }
}
