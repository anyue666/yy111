package com.autolink.account.ui.dialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;
import com.autolink.hmi.crosscountry.CrossApplication;
import com.autolink.hmi.crosscountry.R;
import com.autolink.hmi.crosscountry.databinding.DrivingModeDialogLayoutBinding;
import com.autolink.hmi.crosscountry.utils.AnimatorUtils;
import com.autolink.hmi.crosscountry.utils.CrossAllUtils;
import com.autolink.hmi.crosscountry.utils.LogUtils;
import com.autolink.hmi.crosscountry.utils.ReflectUtil;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DrivingModeDialog.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0003678B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0003J\b\u0010$\u001a\u00020#H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020#J\u0006\u0010+\u001a\u00020#J\u000e\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0006J\u0010\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\u0011J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u000fJ\u000e\u00102\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0006J\u0006\u00103\u001a\u00020#J\b\u00104\u001a\u00020#H\u0016J\b\u00105\u001a\u00020#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/autolink/account/ui/dialog/DrivingModeDialog;", "Lcom/autolink/account/ui/dialog/AbsWindowDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DRIVER_MODE_OFF_LOAD", "", "TAG", "", "binding", "Lcom/autolink/hmi/crosscountry/databinding/DrivingModeDialogLayoutBinding;", "mAnimatorUtils", "Lcom/autolink/hmi/crosscountry/utils/AnimatorUtils;", "mContext", "mDismissListener", "Lcom/autolink/account/ui/dialog/DrivingModeDialog$DismissListener;", "mDrivingModeDialogCallback", "Lcom/autolink/account/ui/dialog/DrivingModeDialog$DrivingModeDialogCallback;", "getMDrivingModeDialogCallback", "()Lcom/autolink/account/ui/dialog/DrivingModeDialog$DrivingModeDialogCallback;", "setMDrivingModeDialogCallback", "(Lcom/autolink/account/ui/dialog/DrivingModeDialog$DrivingModeDialogCallback;)V", "mHandler", "Lcom/autolink/account/ui/dialog/DrivingModeDialog$DrivingHandler;", "mScope", "Lkotlinx/coroutines/CoroutineScope;", "mSurface", "Landroid/view/Surface;", "mediaPlayer", "Landroid/media/MediaPlayer;", "powerType", "valueColor", "Landroid/content/res/ColorStateList;", "kotlin.jvm.PlatformType", "initData", "", "onClick", "onCreateView", "Landroid/view/View;", "play", "pathId", "playModeVideo", "releaseVideoView", "removeCountdown", "setCarModel", "mode", "setDialogCallback", "callback", "setDismissListener", "lis", "setMode", "updateView", "windowDismiss", "windowShow", "DismissListener", "DrivingHandler", "DrivingModeDialogCallback", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrivingModeDialog extends AbsWindowDialog {
    private int DRIVER_MODE_OFF_LOAD;
    private final String TAG;
    private DrivingModeDialogLayoutBinding binding;
    private AnimatorUtils mAnimatorUtils;
    private Context mContext;
    private DismissListener mDismissListener;
    private DrivingModeDialogCallback mDrivingModeDialogCallback;
    private DrivingHandler mHandler;
    private final CoroutineScope mScope;
    private Surface mSurface;
    private MediaPlayer mediaPlayer;
    private String powerType;
    private final ColorStateList valueColor;

    /* compiled from: DrivingModeDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/autolink/account/ui/dialog/DrivingModeDialog$DismissListener;", "", "onDismiss", "", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DismissListener {
        void onDismiss();
    }

    /* compiled from: DrivingModeDialog.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/autolink/account/ui/dialog/DrivingModeDialog$DrivingModeDialogCallback;", "", "onModeName", "", "name", "", "mode", "", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DrivingModeDialogCallback {
        void onModeName(String name, int mode);
    }

    private final void initData() {
    }

    private final void onClick() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrivingModeDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "DrivingModeDialog";
        this.mContext = context;
        this.mHandler = new DrivingHandler(this);
        this.DRIVER_MODE_OFF_LOAD = 6;
        this.valueColor = ColorStateList.valueOf(Color.parseColor("#65DEE2"));
        this.mScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.mediaPlayer = new MediaPlayer();
    }

    @Override // com.autolink.account.ui.dialog.AbsWindowDialog
    public void windowShow() {
        ImageView imageView;
        DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding = this.binding;
        if (drivingModeDialogLayoutBinding != null && (imageView = drivingModeDialogLayoutBinding.icClose) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.autolink.account.ui.dialog.DrivingModeDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DrivingModeDialog.windowShow$lambda$0(DrivingModeDialog.this, view);
                }
            });
        }
        removeCountdown();
        updateView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void windowShow$lambda$0(DrivingModeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.autolink.account.ui.dialog.AbsWindowDialog
    public void windowDismiss() {
        DismissListener dismissListener = this.mDismissListener;
        if (dismissListener != null && dismissListener != null) {
            dismissListener.onDismiss();
        }
        releaseVideoView();
        removeCountdown();
    }

    public final void updateView() {
        this.mHandler.sendEmptyMessageDelayed(0, 4000L);
    }

    public final void setDismissListener(DismissListener lis) {
        Intrinsics.checkNotNullParameter(lis, "lis");
        this.mDismissListener = lis;
    }

    public final void removeCountdown() {
        this.mHandler.removeMessages(0);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public final void releaseVideoView() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                Intrinsics.checkNotNull(mediaPlayer);
                if (mediaPlayer.isPlaying()) {
                    LogUtils.logI(this.TAG, "releaseVideoView release ");
                    MediaPlayer mediaPlayer2 = this.mediaPlayer;
                    if (mediaPlayer2 != null) {
                        mediaPlayer2.stop();
                    }
                    MediaPlayer mediaPlayer3 = this.mediaPlayer;
                    if (mediaPlayer3 != null) {
                        mediaPlayer3.release();
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.logI(this.TAG, "releaseVideoView e" + e);
        }
    }

    @Override // com.autolink.account.ui.dialog.AbsWindowDialog
    public View onCreateView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogUtils.logI("DrivingModeDialog", "onCreateView");
        this.binding = (DrivingModeDialogLayoutBinding) DataBindingUtil.bind(LayoutInflater.from(context).inflate(R.layout.driving_mode_dialog_layout, (ViewGroup) null));
        this.mAnimatorUtils = new AnimatorUtils();
        initData();
        onClick();
        String property = ReflectUtil.getProperty("persist.vendor.oem.cfg.cc.ihu.power.type", "null");
        Intrinsics.checkNotNull(property, "null cannot be cast to non-null type kotlin.String");
        this.powerType = property;
        DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding = this.binding;
        if (drivingModeDialogLayoutBinding != null) {
            return drivingModeDialogLayoutBinding.getRoot();
        }
        return null;
    }

    public final void setMode(int mode) {
        TextView textView;
        initData();
        DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding = this.binding;
        CharSequence charSequence = null;
        ImageView imageView = drivingModeDialogLayoutBinding != null ? drivingModeDialogLayoutBinding.carImg : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding2 = this.binding;
        CardView cardView = drivingModeDialogLayoutBinding2 != null ? drivingModeDialogLayoutBinding2.carImgLayout : null;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        if (mode == CrossAllUtils.DRIVER_MODE_INVALD) {
            LogUtils.logI(this.TAG, "模式切换失败进入标准模式");
            mode = CrossAllUtils.DRIVER_MODE_NORMAL;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_X) {
            setCarModel(CrossAllUtils.DRIVER_MODE_X);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding3 = this.binding;
            TextView textView2 = drivingModeDialogLayoutBinding3 != null ? drivingModeDialogLayoutBinding3.name : null;
            if (textView2 != null) {
                textView2.setText(CrossApplication.sInstance.getString(R.string.x_model));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding4 = this.binding;
            TextView textView3 = drivingModeDialogLayoutBinding4 != null ? drivingModeDialogLayoutBinding4.info : null;
            if (textView3 != null) {
                textView3.setText(CrossApplication.sInstance.getString(R.string.x_model_info));
            }
        }
        if (mode == CrossAllUtils.DRIVER_MODE_ECO) {
            setCarModel(CrossAllUtils.DRIVER_MODE_ECO);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding5 = this.binding;
            TextView textView4 = drivingModeDialogLayoutBinding5 != null ? drivingModeDialogLayoutBinding5.name : null;
            if (textView4 != null) {
                textView4.setText(CrossApplication.sInstance.getString(R.string.economic_model));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding6 = this.binding;
            TextView textView5 = drivingModeDialogLayoutBinding6 != null ? drivingModeDialogLayoutBinding6.info : null;
            if (textView5 != null) {
                textView5.setText(CrossApplication.sInstance.getString(R.string.economic_model_info));
            }
        }
        if (mode == CrossAllUtils.DRIVER_MODE_NORMAL) {
            setCarModel(CrossAllUtils.DRIVER_MODE_NORMAL);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding7 = this.binding;
            TextView textView6 = drivingModeDialogLayoutBinding7 != null ? drivingModeDialogLayoutBinding7.name : null;
            if (textView6 != null) {
                textView6.setText(CrossApplication.sInstance.getString(R.string.standard_mode));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding8 = this.binding;
            TextView textView7 = drivingModeDialogLayoutBinding8 != null ? drivingModeDialogLayoutBinding8.info : null;
            if (textView7 != null) {
                textView7.setText(CrossApplication.sInstance.getString(R.string.standard_mode_info));
            }
        }
        if (mode == CrossAllUtils.DRIVER_MODE_ROCK) {
            setCarModel(CrossAllUtils.DRIVER_MODE_ROCK);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding9 = this.binding;
            TextView textView8 = drivingModeDialogLayoutBinding9 != null ? drivingModeDialogLayoutBinding9.name : null;
            if (textView8 != null) {
                textView8.setText(CrossApplication.sInstance.getString(R.string.rock_model));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding10 = this.binding;
            TextView textView9 = drivingModeDialogLayoutBinding10 != null ? drivingModeDialogLayoutBinding10.info : null;
            if (textView9 != null) {
                textView9.setText(CrossApplication.sInstance.getString(R.string.rock_model_info));
            }
        }
        if (mode == CrossAllUtils.DRIVER_MODE_SNOW) {
            setCarModel(CrossAllUtils.DRIVER_MODE_SNOW);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding11 = this.binding;
            TextView textView10 = drivingModeDialogLayoutBinding11 != null ? drivingModeDialogLayoutBinding11.name : null;
            if (textView10 != null) {
                textView10.setText(CrossApplication.sInstance.getString(R.string.snow_pattern));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding12 = this.binding;
            TextView textView11 = drivingModeDialogLayoutBinding12 != null ? drivingModeDialogLayoutBinding12.info : null;
            if (textView11 != null) {
                textView11.setText(CrossApplication.sInstance.getString(R.string.snow_pattern_info));
            }
        }
        if (mode == CrossAllUtils.DRIVER_MODE_SPORT) {
            setCarModel(CrossAllUtils.DRIVER_MODE_SPORT);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding13 = this.binding;
            TextView textView12 = drivingModeDialogLayoutBinding13 != null ? drivingModeDialogLayoutBinding13.name : null;
            if (textView12 != null) {
                textView12.setText(CrossApplication.sInstance.getString(R.string.motion_pattern));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding14 = this.binding;
            TextView textView13 = drivingModeDialogLayoutBinding14 != null ? drivingModeDialogLayoutBinding14.info : null;
            if (textView13 != null) {
                textView13.setText(CrossApplication.sInstance.getString(R.string.motion_pattern_info));
            }
        }
        if (mode == CrossAllUtils.DRIVER_MODE_MUD) {
            setCarModel(CrossAllUtils.DRIVER_MODE_MUD);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding15 = this.binding;
            TextView textView14 = drivingModeDialogLayoutBinding15 != null ? drivingModeDialogLayoutBinding15.name : null;
            if (textView14 != null) {
                textView14.setText(CrossApplication.sInstance.getString(R.string.muddy_mode));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding16 = this.binding;
            TextView textView15 = drivingModeDialogLayoutBinding16 != null ? drivingModeDialogLayoutBinding16.info : null;
            if (textView15 != null) {
                textView15.setText(CrossApplication.sInstance.getString(R.string.muddy_mode_info));
            }
        }
        if (mode == CrossAllUtils.DRIVER_MODE_SAND) {
            setCarModel(CrossAllUtils.DRIVER_MODE_SAND);
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding17 = this.binding;
            TextView textView16 = drivingModeDialogLayoutBinding17 != null ? drivingModeDialogLayoutBinding17.name : null;
            if (textView16 != null) {
                textView16.setText(CrossApplication.sInstance.getString(R.string.sand_pattern));
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding18 = this.binding;
            TextView textView17 = drivingModeDialogLayoutBinding18 != null ? drivingModeDialogLayoutBinding18.info : null;
            if (textView17 != null) {
                textView17.setText(CrossApplication.sInstance.getString(R.string.sand_mode_info));
            }
        }
        DrivingModeDialogCallback drivingModeDialogCallback = this.mDrivingModeDialogCallback;
        if (drivingModeDialogCallback != null) {
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding19 = this.binding;
            if (drivingModeDialogLayoutBinding19 != null && (textView = drivingModeDialogLayoutBinding19.name) != null) {
                charSequence = textView.getText();
            }
            drivingModeDialogCallback.onModeName(String.valueOf(charSequence), mode);
        }
    }

    public final void setCarModel(int mode) {
        char c;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        ImageView imageView13;
        ImageView imageView14;
        ImageView imageView15;
        ImageView imageView16;
        ImageView imageView17;
        ImageView imageView18;
        ImageView imageView19;
        ImageView imageView20;
        ImageView imageView21;
        ImageView imageView22;
        ImageView imageView23;
        ImageView imageView24;
        ImageView imageView25;
        ImageView imageView26;
        ImageView imageView27;
        ImageView imageView28;
        ImageView imageView29;
        ImageView imageView30;
        ImageView imageView31;
        ImageView imageView32;
        String property = CrossAllUtils.getProperty(CrossAllUtils.POWER_KEY);
        if (CrossAllUtils.isSevenSeat()) {
            if (property.equals("2") && CrossAllUtils.isDriveTypeFour()) {
                LogUtils.logI(this.TAG, "SEVEN_SEATER_PHEV_FOURWHEEL");
                c = 1;
            } else {
                LogUtils.logI(this.TAG, "SEVEN_SEATER_FUEL");
                c = 3;
            }
        } else if (property.equals("2") && CrossAllUtils.isDriveTypeFour()) {
            LogUtils.logI(this.TAG, "FIVE_SEATER_PHEV_FOURWHEEL");
            c = 2;
        } else {
            c = 0;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_X) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding = this.binding;
                if (drivingModeDialogLayoutBinding != null && (imageView29 = drivingModeDialogLayoutBinding.carImg) != null) {
                    imageView29.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_x_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.x_mode_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding2 = this.binding;
                if (drivingModeDialogLayoutBinding2 != null && (imageView30 = drivingModeDialogLayoutBinding2.carImg) != null) {
                    imageView30.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_x));
                }
                playModeVideo(R.raw.x_mode);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding3 = this.binding;
                if (drivingModeDialogLayoutBinding3 != null && (imageView31 = drivingModeDialogLayoutBinding3.carImg) != null) {
                    imageView31.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_x_seven_seater_fuel));
                }
                playModeVideo(R.raw.x_mode_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding4 = this.binding;
            if (drivingModeDialogLayoutBinding4 != null && (imageView32 = drivingModeDialogLayoutBinding4.carImg) != null) {
                imageView32.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_x));
            }
            playModeVideo(R.raw.x_mode);
            return;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_ECO) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding5 = this.binding;
                if (drivingModeDialogLayoutBinding5 != null && (imageView25 = drivingModeDialogLayoutBinding5.carImg) != null) {
                    imageView25.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_eco_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.economic_model_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding6 = this.binding;
                if (drivingModeDialogLayoutBinding6 != null && (imageView26 = drivingModeDialogLayoutBinding6.carImg) != null) {
                    imageView26.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_eco));
                }
                playModeVideo(R.raw.economic_model);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding7 = this.binding;
                if (drivingModeDialogLayoutBinding7 != null && (imageView27 = drivingModeDialogLayoutBinding7.carImg) != null) {
                    imageView27.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_eco_seven_seater_fuel));
                }
                playModeVideo(R.raw.economic_model_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding8 = this.binding;
            if (drivingModeDialogLayoutBinding8 != null && (imageView28 = drivingModeDialogLayoutBinding8.carImg) != null) {
                imageView28.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_eco));
            }
            playModeVideo(R.raw.economic_model);
            return;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_NORMAL) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding9 = this.binding;
                if (drivingModeDialogLayoutBinding9 != null && (imageView21 = drivingModeDialogLayoutBinding9.carImg) != null) {
                    imageView21.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_normal_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.standard_mode_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding10 = this.binding;
                if (drivingModeDialogLayoutBinding10 != null && (imageView22 = drivingModeDialogLayoutBinding10.carImg) != null) {
                    imageView22.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_normal));
                }
                playModeVideo(R.raw.standard_mode);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding11 = this.binding;
                if (drivingModeDialogLayoutBinding11 != null && (imageView23 = drivingModeDialogLayoutBinding11.carImg) != null) {
                    imageView23.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_normal_seven_seater_fuel));
                }
                playModeVideo(R.raw.standard_mode_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding12 = this.binding;
            if (drivingModeDialogLayoutBinding12 != null && (imageView24 = drivingModeDialogLayoutBinding12.carImg) != null) {
                imageView24.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_normal));
            }
            playModeVideo(R.raw.standard_mode);
            return;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_ROCK) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding13 = this.binding;
                if (drivingModeDialogLayoutBinding13 != null && (imageView17 = drivingModeDialogLayoutBinding13.carImg) != null) {
                    imageView17.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_rock_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.rock_model_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding14 = this.binding;
                if (drivingModeDialogLayoutBinding14 != null && (imageView18 = drivingModeDialogLayoutBinding14.carImg) != null) {
                    imageView18.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_rock));
                }
                playModeVideo(R.raw.rock_model);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding15 = this.binding;
                if (drivingModeDialogLayoutBinding15 != null && (imageView19 = drivingModeDialogLayoutBinding15.carImg) != null) {
                    imageView19.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_rock_seven_seater_fuel));
                }
                playModeVideo(R.raw.rock_model_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding16 = this.binding;
            if (drivingModeDialogLayoutBinding16 != null && (imageView20 = drivingModeDialogLayoutBinding16.carImg) != null) {
                imageView20.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_rock));
            }
            playModeVideo(R.raw.rock_model);
            return;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_SNOW) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding17 = this.binding;
                if (drivingModeDialogLayoutBinding17 != null && (imageView13 = drivingModeDialogLayoutBinding17.carImg) != null) {
                    imageView13.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_snow_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.snow_pattern_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding18 = this.binding;
                if (drivingModeDialogLayoutBinding18 != null && (imageView14 = drivingModeDialogLayoutBinding18.carImg) != null) {
                    imageView14.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_snow));
                }
                playModeVideo(R.raw.snow_pattern);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding19 = this.binding;
                if (drivingModeDialogLayoutBinding19 != null && (imageView15 = drivingModeDialogLayoutBinding19.carImg) != null) {
                    imageView15.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_snow_seven_seater_fuel));
                }
                playModeVideo(R.raw.snow_pattern_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding20 = this.binding;
            if (drivingModeDialogLayoutBinding20 != null && (imageView16 = drivingModeDialogLayoutBinding20.carImg) != null) {
                imageView16.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_snow));
            }
            playModeVideo(R.raw.snow_pattern);
            return;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_SPORT) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding21 = this.binding;
                if (drivingModeDialogLayoutBinding21 != null && (imageView9 = drivingModeDialogLayoutBinding21.carImg) != null) {
                    imageView9.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_move_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.motion_pattern_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding22 = this.binding;
                if (drivingModeDialogLayoutBinding22 != null && (imageView10 = drivingModeDialogLayoutBinding22.carImg) != null) {
                    imageView10.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_move));
                }
                playModeVideo(R.raw.motion_pattern);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding23 = this.binding;
                if (drivingModeDialogLayoutBinding23 != null && (imageView11 = drivingModeDialogLayoutBinding23.carImg) != null) {
                    imageView11.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_move_seven_seater_fuel));
                }
                playModeVideo(R.raw.motion_pattern_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding24 = this.binding;
            if (drivingModeDialogLayoutBinding24 != null && (imageView12 = drivingModeDialogLayoutBinding24.carImg) != null) {
                imageView12.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_move));
            }
            playModeVideo(R.raw.motion_pattern);
            return;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_MUD) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding25 = this.binding;
                if (drivingModeDialogLayoutBinding25 != null && (imageView5 = drivingModeDialogLayoutBinding25.carImg) != null) {
                    imageView5.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_muddy_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.muddy_pattern_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding26 = this.binding;
                if (drivingModeDialogLayoutBinding26 != null && (imageView6 = drivingModeDialogLayoutBinding26.carImg) != null) {
                    imageView6.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_muddy));
                }
                playModeVideo(R.raw.muddy_pattern);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding27 = this.binding;
                if (drivingModeDialogLayoutBinding27 != null && (imageView7 = drivingModeDialogLayoutBinding27.carImg) != null) {
                    imageView7.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_muddy_seven_seater_fuel));
                }
                playModeVideo(R.raw.muddy_pattern_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding28 = this.binding;
            if (drivingModeDialogLayoutBinding28 != null && (imageView8 = drivingModeDialogLayoutBinding28.carImg) != null) {
                imageView8.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_muddy));
            }
            playModeVideo(R.raw.muddy_pattern);
            return;
        }
        if (mode == CrossAllUtils.DRIVER_MODE_SAND) {
            if (c == 1) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding29 = this.binding;
                if (drivingModeDialogLayoutBinding29 != null && (imageView = drivingModeDialogLayoutBinding29.carImg) != null) {
                    imageView.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_sedi_seven_seater_phev_fourwheel));
                }
                playModeVideo(R.raw.sediment_pattern_seven_seater_phev_fourwheel);
                return;
            }
            if (c == 2) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding30 = this.binding;
                if (drivingModeDialogLayoutBinding30 != null && (imageView2 = drivingModeDialogLayoutBinding30.carImg) != null) {
                    imageView2.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_sedi));
                }
                playModeVideo(R.raw.sediment_pattern);
                return;
            }
            if (c == 3) {
                DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding31 = this.binding;
                if (drivingModeDialogLayoutBinding31 != null && (imageView3 = drivingModeDialogLayoutBinding31.carImg) != null) {
                    imageView3.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_sedi_seven_seater_fuel));
                }
                playModeVideo(R.raw.sediment_pattern_seven_seater_fuel);
                return;
            }
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding32 = this.binding;
            if (drivingModeDialogLayoutBinding32 != null && (imageView4 = drivingModeDialogLayoutBinding32.carImg) != null) {
                imageView4.setImageDrawable(CrossApplication.sInstance.getDrawable(R.mipmap.mode_sedi));
            }
            playModeVideo(R.raw.sediment_pattern);
        }
    }

    public final DrivingModeDialogCallback getMDrivingModeDialogCallback() {
        return this.mDrivingModeDialogCallback;
    }

    public final void setMDrivingModeDialogCallback(DrivingModeDialogCallback drivingModeDialogCallback) {
        this.mDrivingModeDialogCallback = drivingModeDialogCallback;
    }

    public final void setDialogCallback(DrivingModeDialogCallback callback) {
        this.mDrivingModeDialogCallback = callback;
    }

    public final void playModeVideo(final int pathId) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.reset();
        }
        if (this.mSurface != null) {
            play(pathId);
        }
        if (this.mSurface == null) {
            DrivingModeDialogLayoutBinding drivingModeDialogLayoutBinding = this.binding;
            TextureView textureView = drivingModeDialogLayoutBinding != null ? drivingModeDialogLayoutBinding.textureView : null;
            if (textureView == null) {
                return;
            }
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.autolink.account.ui.dialog.DrivingModeDialog$playModeVideo$1
                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    return true;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
                    Intrinsics.checkNotNullParameter(surface, "surface");
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                    Intrinsics.checkNotNullParameter(surface, "surface");
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                    Intrinsics.checkNotNullParameter(surface, "surface");
                    DrivingModeDialog.this.mSurface = new Surface(surface);
                    DrivingModeDialog.this.play(pathId);
                }
            });
        }
    }

    public final void play(int pathId) {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + '/' + pathId));
            }
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setSurface(this.mSurface);
            }
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setLooping(true);
            }
            MediaPlayer mediaPlayer4 = this.mediaPlayer;
            if (mediaPlayer4 != null) {
                mediaPlayer4.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.autolink.account.ui.dialog.DrivingModeDialog$$ExternalSyntheticLambda1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer5) {
                        DrivingModeDialog.play$lambda$1(DrivingModeDialog.this, mediaPlayer5);
                    }
                });
            }
            MediaPlayer mediaPlayer5 = this.mediaPlayer;
            if (mediaPlayer5 != null) {
                mediaPlayer5.prepareAsync();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$1(final DrivingModeDialog this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.autolink.account.ui.dialog.DrivingModeDialog$play$1$1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                CoroutineScope coroutineScope;
                if (what != 3) {
                    return true;
                }
                coroutineScope = DrivingModeDialog.this.mScope;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DrivingModeDialog$play$1$1$onInfo$1(DrivingModeDialog.this, null), 3, null);
                return true;
            }
        });
        mediaPlayer.start();
    }

    /* compiled from: DrivingModeDialog.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/autolink/account/ui/dialog/DrivingModeDialog$DrivingHandler;", "Landroid/os/Handler;", "context", "Lcom/autolink/account/ui/dialog/DrivingModeDialog;", "(Lcom/autolink/account/ui/dialog/DrivingModeDialog;)V", "reference", "Ljava/lang/ref/WeakReference;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DrivingHandler extends Handler {
        private final WeakReference<DrivingModeDialog> reference;

        public DrivingHandler(DrivingModeDialog drivingModeDialog) {
            this.reference = new WeakReference<>(drivingModeDialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            DrivingModeDialog drivingModeDialog;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != 0 || this.reference.get() == null || (drivingModeDialog = this.reference.get()) == null) {
                return;
            }
            drivingModeDialog.dismiss();
        }
    }
}
