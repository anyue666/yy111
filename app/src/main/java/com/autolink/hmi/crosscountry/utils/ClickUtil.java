package com.autolink.hmi.crosscountry.utils;

import kotlin.Metadata;

/* compiled from: ClickUtil.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/autolink/hmi/crosscountry/utils/ClickUtil;", "", "()V", "MIN_CLICK_DELAY_TIME", "", "mLastClickTime", "", "isFastClick", "", "minClickDelayTime", "(Ljava/lang/Integer;)Z", "ALXMode_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClickUtil {
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    public static final ClickUtil INSTANCE = new ClickUtil();
    private static long mLastClickTime = -1;

    private ClickUtil() {
    }

    public static /* synthetic */ boolean isFastClick$default(ClickUtil clickUtil, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return clickUtil.isFastClick(num);
    }

    public final boolean isFastClick(Integer minClickDelayTime) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = mLastClickTime;
        if (j != currentTimeMillis) {
            if (currentTimeMillis - j < 0) {
                mLastClickTime = -1L;
            }
            r5 = currentTimeMillis - mLastClickTime <= ((long) (minClickDelayTime != null ? minClickDelayTime.intValue() : 1000));
            if (!r5) {
                mLastClickTime = currentTimeMillis;
            }
        }
        return r5;
    }
}
