package android.car.media;

import android.annotation.SystemApi;
import android.car.Car;
import android.car.CarManagerBase;
import android.car.media.ICarMedia;
import android.car.media.ICarMediaSourceListener;
import android.content.ComponentName;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SystemApi
/* loaded from: classes.dex */
public final class CarMediaManager extends CarManagerBase {
    public static final int MEDIA_SOURCE_MODE_BROWSE = 1;
    public static final int MEDIA_SOURCE_MODE_PLAYBACK = 0;
    private Map<MediaSourceChangedListener, ICarMediaSourceListener> mCallbackMap;
    private final Object mLock;
    private final ICarMedia mService;

    public interface MediaSourceChangedListener {
        void onMediaSourceChanged(ComponentName componentName);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaSourceMode {
    }

    public CarMediaManager(Car car, IBinder iBinder) {
        super(car);
        this.mLock = new Object();
        this.mCallbackMap = new HashMap();
        this.mService = ICarMedia.Stub.asInterface(iBinder);
    }

    public ComponentName getMediaSource(int i) {
        try {
            return this.mService.getMediaSource(i);
        } catch (RemoteException e) {
            return (ComponentName) handleRemoteExceptionFromCarService(e, null);
        }
    }

    public void setMediaSource(ComponentName componentName, int i) {
        try {
            this.mService.setMediaSource(componentName, i);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public void addMediaSourceListener(final MediaSourceChangedListener mediaSourceChangedListener, int i) {
        try {
            ICarMediaSourceListener.Stub stub = new ICarMediaSourceListener.Stub() { // from class: android.car.media.CarMediaManager.1
                @Override // android.car.media.ICarMediaSourceListener
                public void onMediaSourceChanged(ComponentName componentName) {
                    mediaSourceChangedListener.onMediaSourceChanged(componentName);
                }
            };
            synchronized (this.mLock) {
                this.mCallbackMap.put(mediaSourceChangedListener, stub);
            }
            this.mService.registerMediaSourceListener(stub, i);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public void removeMediaSourceListener(MediaSourceChangedListener mediaSourceChangedListener, int i) {
        try {
            synchronized (this.mLock) {
                this.mService.unregisterMediaSourceListener(this.mCallbackMap.remove(mediaSourceChangedListener), i);
            }
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }

    public List<ComponentName> getLastMediaSources(int i) {
        try {
            return this.mService.getLastMediaSources(i);
        } catch (RemoteException e) {
            return (List) handleRemoteExceptionFromCarService(e, null);
        }
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized (this.mLock) {
            this.mCallbackMap.clear();
        }
    }

    public boolean isIndependentPlaybackConfig() {
        try {
            return this.mService.isIndependentPlaybackConfig();
        } catch (RemoteException e) {
            return ((Boolean) handleRemoteExceptionFromCarService(e, null)).booleanValue();
        }
    }

    public void setIndependentPlaybackConfig(boolean z) {
        try {
            this.mService.setIndependentPlaybackConfig(z);
        } catch (RemoteException e) {
            handleRemoteExceptionFromCarService(e);
        }
    }
}
