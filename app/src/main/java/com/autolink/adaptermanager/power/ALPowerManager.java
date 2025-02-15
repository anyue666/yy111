package com.autolink.adaptermanager.power;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.autolink.adapterinterface.IPower;
import com.autolink.adapterinterface.IPowerCallback;
import com.autolink.adaptermanager.ALBaseManager;
import com.autolink.adaptermanager.IALManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ALPowerManager extends ALBaseManager implements IALManager {
    private static final String TAG = "ALPowerManager";
    private CopyOnWriteArrayList<DisplayPowerStateListener> mDisPowerStateListeners;
    private IPowerCallback mIPowerCallback;
    private IPower mIPowerService;
    private CopyOnWriteArrayList<ALPowerManagerListener> mPowerListeners;

    public interface ALPowerManagerListener {
        void onBrightnessModeChanged(BrightnessMode brightnessMode);

        void onDisplayDayNightModeChanged(ThemeMode themeMode);

        void onHmiBrightnessChanged(int i);

        void onIviBrightnessChanged(int i);

        void onPowerEventChanged(PowerMode powerMode, VoltageState voltageState);

        void onScreensaverChanged(boolean z);
    }

    public enum BrightnessMode {
        MANUAL_MODE,
        AUTO_MODE
    }

    public interface DisplayPowerStateListener {
        void onIviDisplayPowerStateChanged(DisplayPowerState displayPowerState);
    }

    public enum ScreensaverEventId {
        SYSTEMUI_EVENT,
        TOUCH_EVENT,
        HAVC_EVENT,
        TTS_BY_HARDKEY_EVENT,
        SETTINGS_EVENT
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected int getServiceFlag() {
        return 1;
    }

    public enum DisplayPowerState {
        DISPLAY_POWER_OFF(0),
        DISPLAY_POWER_ON(1);

        private final int value;

        DisplayPowerState(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static DisplayPowerState forNumber(int i) {
            if (i == 0) {
                return DISPLAY_POWER_OFF;
            }
            if (i != 1) {
                return null;
            }
            return DISPLAY_POWER_ON;
        }
    }

    public enum ThemeMode {
        DAYTIME_MODE(1),
        DARK_MODE(2),
        AUTO_MODE(3);

        private final int value;

        ThemeMode(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static ThemeMode forNumber(int i) {
            if (i == 1) {
                return DAYTIME_MODE;
            }
            if (i == 2) {
                return DARK_MODE;
            }
            if (i != 3) {
                return null;
            }
            return AUTO_MODE;
        }
    }

    public enum PowerMode {
        STARTUP(0),
        STANDBY(1),
        NORMAL(2),
        HALF(3),
        STR(4),
        SLEEP(5),
        OTA(6);

        private final int value;

        PowerMode(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static PowerMode forNumber(int i) {
            switch (i) {
                case 0:
                    return STARTUP;
                case 1:
                    return STANDBY;
                case 2:
                    return NORMAL;
                case 3:
                    return HALF;
                case 4:
                    return STR;
                case 5:
                    return SLEEP;
                case 6:
                    return OTA;
                default:
                    return null;
            }
        }
    }

    public enum VoltageState {
        CRITICAL_HIGH(1),
        HIGH(2),
        NORMAL(3),
        LOW(4),
        CRITICAL_LOW(5),
        BEYOND_CRITICAL_HIGH(6);

        private final int value;

        VoltageState(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static VoltageState forNumber(int i) {
            switch (i) {
                case 1:
                    return CRITICAL_HIGH;
                case 2:
                    return HIGH;
                case 3:
                    return NORMAL;
                case 4:
                    return LOW;
                case 5:
                    return CRITICAL_LOW;
                case 6:
                    return BEYOND_CRITICAL_HIGH;
                default:
                    return null;
            }
        }
    }

    @Deprecated
    public ALPowerManager(Context context) {
        super(context);
        this.mIPowerCallback = new IPowerCallback.Stub() { // from class: com.autolink.adaptermanager.power.ALPowerManager.1
            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onIviBrightnessChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onIviBrightnessChanged(i);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onDisplayDayNightModeChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onDisplayDayNightModeChanged(ThemeMode.forNumber(i));
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onHmiBrightnessChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onHmiBrightnessChanged(i);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onBrightnessModeChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onBrightnessModeChanged(BrightnessMode.values()[i]);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onScreensaverChanged(boolean z) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onScreensaverChanged(z);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onPowerEventChanged(int i, int i2) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onPowerEventChanged(PowerMode.forNumber(i), VoltageState.forNumber(i2));
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onIviDisplayPowerStateChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mDisPowerStateListeners.iterator();
                while (it.hasNext()) {
                    ((DisplayPowerStateListener) it.next()).onIviDisplayPowerStateChanged(DisplayPowerState.forNumber(i));
                }
            }
        };
        this.mPowerListeners = new CopyOnWriteArrayList<>();
        this.mDisPowerStateListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    @Deprecated
    public ALPowerManager(Context context, IALManager.ServiceConnectionListener serviceConnectionListener) {
        super(context, serviceConnectionListener);
        this.mIPowerCallback = new IPowerCallback.Stub() { // from class: com.autolink.adaptermanager.power.ALPowerManager.1
            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onIviBrightnessChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onIviBrightnessChanged(i);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onDisplayDayNightModeChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onDisplayDayNightModeChanged(ThemeMode.forNumber(i));
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onHmiBrightnessChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onHmiBrightnessChanged(i);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onBrightnessModeChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onBrightnessModeChanged(BrightnessMode.values()[i]);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onScreensaverChanged(boolean z) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onScreensaverChanged(z);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onPowerEventChanged(int i, int i2) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onPowerEventChanged(PowerMode.forNumber(i), VoltageState.forNumber(i2));
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onIviDisplayPowerStateChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mDisPowerStateListeners.iterator();
                while (it.hasNext()) {
                    ((DisplayPowerStateListener) it.next()).onIviDisplayPowerStateChanged(DisplayPowerState.forNumber(i));
                }
            }
        };
        this.mPowerListeners = new CopyOnWriteArrayList<>();
        this.mDisPowerStateListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    public ALPowerManager(Context context, IALManager.ServiceConnectionListenerNew serviceConnectionListenerNew) {
        super(context, serviceConnectionListenerNew);
        this.mIPowerCallback = new IPowerCallback.Stub() { // from class: com.autolink.adaptermanager.power.ALPowerManager.1
            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onIviBrightnessChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onIviBrightnessChanged(i);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onDisplayDayNightModeChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onDisplayDayNightModeChanged(ThemeMode.forNumber(i));
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onHmiBrightnessChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onHmiBrightnessChanged(i);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onBrightnessModeChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onBrightnessModeChanged(BrightnessMode.values()[i]);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onScreensaverChanged(boolean z) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onScreensaverChanged(z);
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onPowerEventChanged(int i, int i2) throws RemoteException {
                Iterator it = ALPowerManager.this.mPowerListeners.iterator();
                while (it.hasNext()) {
                    ((ALPowerManagerListener) it.next()).onPowerEventChanged(PowerMode.forNumber(i), VoltageState.forNumber(i2));
                }
            }

            @Override // com.autolink.adapterinterface.IPowerCallback
            public void onIviDisplayPowerStateChanged(int i) throws RemoteException {
                Iterator it = ALPowerManager.this.mDisPowerStateListeners.iterator();
                while (it.hasNext()) {
                    ((DisplayPowerStateListener) it.next()).onIviDisplayPowerStateChanged(DisplayPowerState.forNumber(i));
                }
            }
        };
        this.mPowerListeners = new CopyOnWriteArrayList<>();
        this.mDisPowerStateListeners = new CopyOnWriteArrayList<>();
        bindService();
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    protected Intent getServiceIntent() {
        Intent intent = new Intent("com.autolink.powerservice.PowerService");
        intent.setPackage("com.autolink.powerservice");
        return intent;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        IPower asInterface = IPower.Stub.asInterface(iBinder);
        this.mIPowerService = asInterface;
        try {
            asInterface.registerPowerCallback(this.mIPowerCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onDisconnected() {
        this.mIPowerService = null;
    }

    @Override // com.autolink.adaptermanager.ALBaseManager
    public void onBinderDied() {
        this.mIPowerService = null;
    }

    public void registerListener(ALPowerManagerListener aLPowerManagerListener) {
        if (this.mPowerListeners.contains(aLPowerManagerListener)) {
            return;
        }
        this.mPowerListeners.add(aLPowerManagerListener);
    }

    public void unregisterPowerCallback(ALPowerManagerListener aLPowerManagerListener) {
        if (this.mPowerListeners.contains(aLPowerManagerListener)) {
            this.mPowerListeners.remove(aLPowerManagerListener);
        }
    }

    public void setIviBrightness(int i) {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.setIviBrightness(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int getIviBrightness() {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                return iPower.getIviBrightness();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public void setHmiBrightness(int i) {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.setHmiBrightness(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int getHmiBrightness() {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                return iPower.getHmiBrightness();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public void setIviThemeMode(ThemeMode themeMode) {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.setIviThemeMode(themeMode.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public ThemeMode getIviThemeMode() {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                return ThemeMode.forNumber(iPower.getIviThemeMode());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setIviBrightnessMode(BrightnessMode brightnessMode) {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.setIviBrightnessMode(brightnessMode.ordinal());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public BrightnessMode getIviBrightnessMode() {
        if (this.mIPowerService != null) {
            try {
                return BrightnessMode.values()[this.mIPowerService.getIviBrightnessMode()];
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void sendScreensaverEvent(ScreensaverEventId screensaverEventId, boolean z) {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.sendScreensaverEvent(screensaverEventId.ordinal(), z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void enterUpgradeState() {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.enterUpgradeState();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void exitUpgradeState() {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.exitUpgradeState();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerDisplayPowerListener(DisplayPowerStateListener displayPowerStateListener) {
        if (this.mDisPowerStateListeners.contains(displayPowerStateListener)) {
            return;
        }
        this.mDisPowerStateListeners.add(displayPowerStateListener);
    }

    public void unregisterDisplayPowerCallback(DisplayPowerStateListener displayPowerStateListener) {
        if (this.mDisPowerStateListeners.contains(displayPowerStateListener)) {
            this.mDisPowerStateListeners.remove(displayPowerStateListener);
        }
    }

    public void setIviDisplayPowerState(DisplayPowerState displayPowerState) {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                iPower.setIviDisplayPowerState(displayPowerState.getNumber());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public DisplayPowerState getIviDisplayPowerState() {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                return DisplayPowerState.forNumber(iPower.getIviDisplayPowerState());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean isCurScreenSaver() {
        IPower iPower = this.mIPowerService;
        if (iPower != null) {
            try {
                return iPower.isCurScreenSaver();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
