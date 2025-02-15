package com.autolink.adapterinterface.clusterinteraction;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MediaInfo implements Parcelable {
    public static final Parcelable.Creator<MediaInfo> CREATOR = new Parcelable.Creator<MediaInfo>() { // from class: com.autolink.adapterinterface.clusterinteraction.MediaInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaInfo createFromParcel(Parcel parcel) {
            return new MediaInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaInfo[] newArray(int i) {
            return new MediaInfo[i];
        }
    };
    private MediaStatus status;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public enum MediaStatus {
        START_MEDIA_PROJECTION_SCREEN(1),
        STOP_MEDIA_PROJECTION_SCREEN(2);

        private final int value;

        MediaStatus(int i) {
            this.value = i;
        }

        public final int getNumber() {
            return this.value;
        }

        public static MediaStatus forNumber(int i) {
            if (i == 1) {
                return START_MEDIA_PROJECTION_SCREEN;
            }
            if (i != 2) {
                return null;
            }
            return STOP_MEDIA_PROJECTION_SCREEN;
        }
    }

    public MediaInfo() {
    }

    protected MediaInfo(Parcel parcel) {
        this.status = MediaStatus.forNumber(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status.getNumber());
    }

    public void setStatus(MediaStatus mediaStatus) {
        this.status = mediaStatus;
    }

    public MediaStatus getStatus() {
        return this.status;
    }

    public String toString() {
        return "MediaInfo [status=" + this.status + "]";
    }
}
