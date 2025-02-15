package android.car.drivingstate;

import android.car.drivingstate.CarUxRestrictions;
import android.car.drivingstate.CarUxRestrictionsConfiguration;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public final class CarUxRestrictionsConfiguration implements Parcelable {
    private static final String JSON_NAME_IDLING_RESTRICTIONS = "idling_restrictions";
    private static final String JSON_NAME_MAX_CONTENT_DEPTH = "max_content_depth";
    private static final String JSON_NAME_MAX_CUMULATIVE_CONTENT_ITEMS = "max_cumulative_content_items";
    private static final String JSON_NAME_MAX_SPEED = "max_speed";
    private static final String JSON_NAME_MAX_STRING_LENGTH = "max_string_length";
    private static final String JSON_NAME_MIN_SPEED = "min_speed";
    private static final String JSON_NAME_MOVING_RESTRICTIONS = "moving_restrictions";
    private static final String JSON_NAME_PARKED_RESTRICTIONS = "parked_restrictions";
    private static final String JSON_NAME_PHYSICAL_PORT = "physical_port";
    private static final String JSON_NAME_REQ_OPT = "req_opt";
    private static final String JSON_NAME_RESTRICTIONS = "restrictions";
    private static final String JSON_NAME_SPEED_RANGE = "speed_range";
    private static final String JSON_NAME_UNKNOWN_RESTRICTIONS = "unknown_restrictions";
    private static final String TAG = "CarUxRConfig";
    private final int mMaxContentDepth;
    private final int mMaxCumulativeContentItems;
    private final int mMaxStringLength;
    private final Byte mPhysicalPort;
    private final Map<String, RestrictionModeContainer> mRestrictionModes;
    private static final int[] DRIVING_STATES = {-1, 0, 1, 2};
    public static final Parcelable.Creator<CarUxRestrictionsConfiguration> CREATOR = new Parcelable.Creator<CarUxRestrictionsConfiguration>() { // from class: android.car.drivingstate.CarUxRestrictionsConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarUxRestrictionsConfiguration createFromParcel(Parcel parcel) {
            return new CarUxRestrictionsConfiguration(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarUxRestrictionsConfiguration[] newArray(int i) {
            return new CarUxRestrictionsConfiguration[i];
        }
    };

    private interface RestrictionConfigurationParser {
        void readJson(JsonReader jsonReader, String str, Builder builder) throws IOException;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CarUxRestrictionsConfiguration(Builder builder) {
        this.mRestrictionModes = new ArrayMap();
        this.mPhysicalPort = builder.mPhysicalPort;
        this.mMaxContentDepth = builder.mMaxContentDepth;
        this.mMaxCumulativeContentItems = builder.mMaxCumulativeContentItems;
        this.mMaxStringLength = builder.mMaxStringLength;
        for (Map.Entry<String, RestrictionModeContainer> entry : builder.mRestrictionModes.entrySet()) {
            String key = entry.getKey();
            RestrictionModeContainer restrictionModeContainer = new RestrictionModeContainer();
            for (int i : DRIVING_STATES) {
                restrictionModeContainer.setRestrictionsForDriveState(i, Collections.unmodifiableList(entry.getValue().getRestrictionsForDriveState(i)));
            }
            this.mRestrictionModes.put(key, restrictionModeContainer);
        }
    }

    public CarUxRestrictions getUxRestrictions(int i, float f) {
        return getUxRestrictions(i, f, CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE);
    }

    public CarUxRestrictions getUxRestrictions(int i, float f, String str) {
        Objects.requireNonNull(str, "mode must not be null");
        RestrictionsPerSpeedRange findUxRestrictionsInList = this.mRestrictionModes.containsKey(str) ? findUxRestrictionsInList(f, this.mRestrictionModes.get(str).getRestrictionsForDriveState(i)) : null;
        if (findUxRestrictionsInList == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, String.format("No restrictions specified for (mode: %s, drive state: %s)", str, Integer.valueOf(i)));
            }
            findUxRestrictionsInList = findUxRestrictionsInList(f, this.mRestrictionModes.get(CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE).getRestrictionsForDriveState(i));
        }
        if (findUxRestrictionsInList == null) {
            if (Build.IS_ENG || Build.IS_USERDEBUG) {
                throw new IllegalStateException("No restrictions for driving state " + getDrivingStateName(i));
            }
            return createDefaultUxRestrictionsEvent();
        }
        return createUxRestrictionsEvent(findUxRestrictionsInList.mReqOpt, findUxRestrictionsInList.mRestrictions);
    }

    public Byte getPhysicalPort() {
        return this.mPhysicalPort;
    }

    private static RestrictionsPerSpeedRange findUxRestrictionsInList(float f, List<RestrictionsPerSpeedRange> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1 && list.get(0).mSpeedRange == null) {
            return list.get(0);
        }
        for (RestrictionsPerSpeedRange restrictionsPerSpeedRange : list) {
            if (restrictionsPerSpeedRange.mSpeedRange != null && restrictionsPerSpeedRange.mSpeedRange.includes(f)) {
                return restrictionsPerSpeedRange;
            }
        }
        return null;
    }

    private CarUxRestrictions createDefaultUxRestrictionsEvent() {
        return createUxRestrictionsEvent(true, 511);
    }

    private CarUxRestrictions createUxRestrictionsEvent(boolean z, int i) {
        if (i != 0) {
            z = true;
        }
        CarUxRestrictions.Builder builder = new CarUxRestrictions.Builder(z, i, SystemClock.elapsedRealtimeNanos());
        int i2 = this.mMaxStringLength;
        if (i2 != -1) {
            builder.setMaxStringLength(i2);
        }
        int i3 = this.mMaxCumulativeContentItems;
        if (i3 != -1) {
            builder.setMaxCumulativeContentItems(i3);
        }
        int i4 = this.mMaxContentDepth;
        if (i4 != -1) {
            builder.setMaxContentDepth(i4);
        }
        return builder.build();
    }

    public void writeJson(JsonWriter jsonWriter) throws IOException {
        Objects.requireNonNull(jsonWriter, "writer must not be null");
        jsonWriter.setLenient(true);
        jsonWriter.beginObject();
        if (this.mPhysicalPort == null) {
            jsonWriter.name(JSON_NAME_PHYSICAL_PORT).nullValue();
        } else {
            jsonWriter.name(JSON_NAME_PHYSICAL_PORT).value(this.mPhysicalPort.byteValue());
        }
        jsonWriter.name(JSON_NAME_MAX_CONTENT_DEPTH).value(this.mMaxContentDepth);
        jsonWriter.name(JSON_NAME_MAX_CUMULATIVE_CONTENT_ITEMS).value(this.mMaxCumulativeContentItems);
        jsonWriter.name(JSON_NAME_MAX_STRING_LENGTH).value(this.mMaxStringLength);
        for (Map.Entry<String, RestrictionModeContainer> entry : this.mRestrictionModes.entrySet()) {
            jsonWriter.name(entry.getKey());
            writeRestrictionMode(jsonWriter, entry.getValue());
        }
        jsonWriter.endObject();
    }

    private void writeRestrictionMode(JsonWriter jsonWriter, RestrictionModeContainer restrictionModeContainer) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name(JSON_NAME_PARKED_RESTRICTIONS);
        writeRestrictionsList(jsonWriter, restrictionModeContainer.getRestrictionsForDriveState(0));
        jsonWriter.name(JSON_NAME_IDLING_RESTRICTIONS);
        writeRestrictionsList(jsonWriter, restrictionModeContainer.getRestrictionsForDriveState(1));
        jsonWriter.name(JSON_NAME_MOVING_RESTRICTIONS);
        writeRestrictionsList(jsonWriter, restrictionModeContainer.getRestrictionsForDriveState(2));
        jsonWriter.name(JSON_NAME_UNKNOWN_RESTRICTIONS);
        writeRestrictionsList(jsonWriter, restrictionModeContainer.getRestrictionsForDriveState(-1));
        jsonWriter.endObject();
    }

    private void writeRestrictionsList(JsonWriter jsonWriter, List<RestrictionsPerSpeedRange> list) throws IOException {
        jsonWriter.beginArray();
        Iterator<RestrictionsPerSpeedRange> it = list.iterator();
        while (it.hasNext()) {
            writeRestrictions(jsonWriter, it.next());
        }
        jsonWriter.endArray();
    }

    private void writeRestrictions(JsonWriter jsonWriter, RestrictionsPerSpeedRange restrictionsPerSpeedRange) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name(JSON_NAME_REQ_OPT).value(restrictionsPerSpeedRange.mReqOpt);
        jsonWriter.name(JSON_NAME_RESTRICTIONS).value(restrictionsPerSpeedRange.mRestrictions);
        if (restrictionsPerSpeedRange.mSpeedRange != null) {
            jsonWriter.name(JSON_NAME_SPEED_RANGE);
            jsonWriter.beginObject();
            jsonWriter.name(JSON_NAME_MIN_SPEED).value(restrictionsPerSpeedRange.mSpeedRange.mMinSpeed);
            jsonWriter.name(JSON_NAME_MAX_SPEED).value(restrictionsPerSpeedRange.mSpeedRange.mMaxSpeed);
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }

    public String toString() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        JsonWriter jsonWriter = new JsonWriter(charArrayWriter);
        jsonWriter.setIndent("\t");
        try {
            writeJson(jsonWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charArrayWriter.toString();
    }

    public static CarUxRestrictionsConfiguration readJson(JsonReader jsonReader, int i) throws IOException {
        String nextName;
        Objects.requireNonNull(jsonReader, "reader must not be null");
        jsonReader.setLenient(true);
        RestrictionConfigurationParser createConfigurationParser = createConfigurationParser(i);
        Builder builder = new Builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "max_cumulative_content_items":
                    builder.setMaxCumulativeContentItems(jsonReader.nextInt());
                    break;
                case "max_content_depth":
                    builder.setMaxContentDepth(jsonReader.nextInt());
                    break;
                case "max_string_length":
                    builder.setMaxStringLength(jsonReader.nextInt());
                    break;
                case "physical_port":
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                        break;
                    } else {
                        builder.setPhysicalPort(Builder.validatePort(jsonReader.nextInt()));
                        break;
                    }
                default:
                    createConfigurationParser.readJson(jsonReader, nextName, builder);
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static RestrictionConfigurationParser createConfigurationParser(int i) {
        if (i == 1) {
            return new V1RestrictionConfigurationParser();
        }
        if (i == 2) {
            return new V2RestrictionConfigurationParser();
        }
        throw new IllegalArgumentException("No parser supported for schemaVersion " + i);
    }

    private static class V2RestrictionConfigurationParser implements RestrictionConfigurationParser {
        private V2RestrictionConfigurationParser() {
        }

        @Override // android.car.drivingstate.CarUxRestrictionsConfiguration.RestrictionConfigurationParser
        public void readJson(JsonReader jsonReader, String str, Builder builder) throws IOException {
            CarUxRestrictionsConfiguration.readRestrictionsMode(jsonReader, str, builder);
        }
    }

    private static class V1RestrictionConfigurationParser implements RestrictionConfigurationParser {
        private static final String JSON_NAME_PASSENGER_IDLING_RESTRICTIONS = "passenger_idling_restrictions";
        private static final String JSON_NAME_PASSENGER_MOVING_RESTRICTIONS = "passenger_moving_restrictions";
        private static final String JSON_NAME_PASSENGER_PARKED_RESTRICTIONS = "passenger_parked_restrictions";
        private static final String JSON_NAME_PASSENGER_UNKNOWN_RESTRICTIONS = "passenger_unknown_restrictions";
        private static final String PASSENGER_MODE_NAME_FOR_MIGRATION = "passenger";

        private V1RestrictionConfigurationParser() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.car.drivingstate.CarUxRestrictionsConfiguration.RestrictionConfigurationParser
        public void readJson(JsonReader jsonReader, String str, Builder builder) throws IOException {
            char c;
            str.hashCode();
            switch (str.hashCode()) {
                case -1828817279:
                    if (str.equals(JSON_NAME_PASSENGER_UNKNOWN_RESTRICTIONS)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1781561187:
                    if (str.equals(CarUxRestrictionsConfiguration.JSON_NAME_PARKED_RESTRICTIONS)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -321131524:
                    if (str.equals(CarUxRestrictionsConfiguration.JSON_NAME_UNKNOWN_RESTRICTIONS)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 242100051:
                    if (str.equals(JSON_NAME_PASSENGER_MOVING_RESTRICTIONS)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 983471736:
                    if (str.equals(CarUxRestrictionsConfiguration.JSON_NAME_MOVING_RESTRICTIONS)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1054686448:
                    if (str.equals(JSON_NAME_PASSENGER_IDLING_RESTRICTIONS)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1772034424:
                    if (str.equals(JSON_NAME_PASSENGER_PARKED_RESTRICTIONS)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1796058133:
                    if (str.equals(CarUxRestrictionsConfiguration.JSON_NAME_IDLING_RESTRICTIONS)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, -1, PASSENGER_MODE_NAME_FOR_MIGRATION, builder);
                    break;
                case 1:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, 0, CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE, builder);
                    break;
                case 2:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, -1, CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE, builder);
                    break;
                case 3:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, 2, PASSENGER_MODE_NAME_FOR_MIGRATION, builder);
                    break;
                case 4:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, 2, CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE, builder);
                    break;
                case 5:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, 1, PASSENGER_MODE_NAME_FOR_MIGRATION, builder);
                    break;
                case 6:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, 0, PASSENGER_MODE_NAME_FOR_MIGRATION, builder);
                    break;
                case 7:
                    CarUxRestrictionsConfiguration.readRestrictionsList(jsonReader, 1, CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE, builder);
                    break;
                default:
                    Log.e(CarUxRestrictionsConfiguration.TAG, "Unknown name parsing json config: " + str);
                    jsonReader.skipValue();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void readRestrictionsMode(JsonReader jsonReader, String str, Builder builder) throws IOException {
        char c;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case -1781561187:
                    if (nextName.equals(JSON_NAME_PARKED_RESTRICTIONS)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -321131524:
                    if (nextName.equals(JSON_NAME_UNKNOWN_RESTRICTIONS)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 983471736:
                    if (nextName.equals(JSON_NAME_MOVING_RESTRICTIONS)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1796058133:
                    if (nextName.equals(JSON_NAME_IDLING_RESTRICTIONS)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    readRestrictionsList(jsonReader, 0, str, builder);
                    break;
                case 1:
                    readRestrictionsList(jsonReader, -1, str, builder);
                    break;
                case 2:
                    readRestrictionsList(jsonReader, 2, str, builder);
                    break;
                case 3:
                    readRestrictionsList(jsonReader, 1, str, builder);
                    break;
                default:
                    Log.e(TAG, "Unknown name parsing restriction mode json config: " + nextName);
                    break;
            }
        }
        jsonReader.endObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readRestrictionsList(JsonReader jsonReader, int i, String str, Builder builder) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            DrivingStateRestrictions readRestrictions = readRestrictions(jsonReader);
            readRestrictions.setMode(str);
            builder.setUxRestrictions(i, readRestrictions);
        }
        jsonReader.endArray();
    }

    private static DrivingStateRestrictions readRestrictions(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        boolean z = false;
        Builder.SpeedRange speedRange = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(JSON_NAME_REQ_OPT)) {
                z = jsonReader.nextBoolean();
            } else if (nextName.equals(JSON_NAME_RESTRICTIONS)) {
                i = jsonReader.nextInt();
            } else if (nextName.equals(JSON_NAME_SPEED_RANGE)) {
                jsonReader.beginObject();
                float f = Float.POSITIVE_INFINITY;
                float f2 = Float.POSITIVE_INFINITY;
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals(JSON_NAME_MIN_SPEED)) {
                        f = Double.valueOf(jsonReader.nextDouble()).floatValue();
                    } else if (nextName2.equals(JSON_NAME_MAX_SPEED)) {
                        f2 = Double.valueOf(jsonReader.nextDouble()).floatValue();
                    } else {
                        Log.e(TAG, "Unknown name parsing json config: " + nextName2);
                        jsonReader.skipValue();
                    }
                }
                Builder.SpeedRange speedRange2 = new Builder.SpeedRange(f, f2);
                jsonReader.endObject();
                speedRange = speedRange2;
            }
        }
        jsonReader.endObject();
        DrivingStateRestrictions restrictions = new DrivingStateRestrictions().setDistractionOptimizationRequired(z).setRestrictions(i);
        if (speedRange != null) {
            restrictions.setSpeedRange(speedRange);
        }
        return restrictions;
    }

    public int hashCode() {
        return Objects.hash(this.mPhysicalPort, Integer.valueOf(this.mMaxStringLength), Integer.valueOf(this.mMaxCumulativeContentItems), Integer.valueOf(this.mMaxContentDepth), this.mRestrictionModes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarUxRestrictionsConfiguration)) {
            return false;
        }
        CarUxRestrictionsConfiguration carUxRestrictionsConfiguration = (CarUxRestrictionsConfiguration) obj;
        return this.mPhysicalPort == carUxRestrictionsConfiguration.mPhysicalPort && hasSameParameters(carUxRestrictionsConfiguration) && this.mRestrictionModes.equals(carUxRestrictionsConfiguration.mRestrictionModes);
    }

    public boolean hasSameParameters(CarUxRestrictionsConfiguration carUxRestrictionsConfiguration) {
        Objects.requireNonNull(carUxRestrictionsConfiguration, "other must not be null");
        return this.mMaxContentDepth == carUxRestrictionsConfiguration.mMaxContentDepth && this.mMaxCumulativeContentItems == carUxRestrictionsConfiguration.mMaxCumulativeContentItems && this.mMaxStringLength == carUxRestrictionsConfiguration.mMaxStringLength;
    }

    public void dump(PrintWriter printWriter) {
        Objects.requireNonNull(printWriter, "writer must not be null");
        printWriter.println("Physical display port: " + this.mPhysicalPort);
        for (Map.Entry<String, RestrictionModeContainer> entry : this.mRestrictionModes.entrySet()) {
            printWriter.println("===========================================");
            printWriter.println(entry.getKey() + " mode UXR:");
            printWriter.println("-------------------------------------------");
            dumpRestrictions(printWriter, entry.getValue().mDriveStateUxRestrictions);
        }
        printWriter.println("Max String length: " + this.mMaxStringLength);
        printWriter.println("Max Cumulative Content Items: " + this.mMaxCumulativeContentItems);
        printWriter.println("Max Content depth: " + this.mMaxContentDepth);
        printWriter.println("===========================================");
    }

    private void dumpRestrictions(PrintWriter printWriter, Map<Integer, List<RestrictionsPerSpeedRange>> map) {
        for (Integer num : map.keySet()) {
            List<RestrictionsPerSpeedRange> list = map.get(num);
            printWriter.println("State:" + getDrivingStateName(num.intValue()) + " num restrictions:" + list.size());
            for (RestrictionsPerSpeedRange restrictionsPerSpeedRange : list) {
                printWriter.println("Requires DO? " + restrictionsPerSpeedRange.mReqOpt + "\nRestrictions: 0x" + Integer.toHexString(restrictionsPerSpeedRange.mRestrictions) + "\nSpeed Range: " + (restrictionsPerSpeedRange.mSpeedRange == null ? "None" : restrictionsPerSpeedRange.mSpeedRange.mMinSpeed + " - " + restrictionsPerSpeedRange.mSpeedRange.mMaxSpeed));
                printWriter.println("-------------------------------------------");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDrivingStateName(int i) {
        if (i == -1) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (i == 0) {
            return "parked";
        }
        if (i == 1) {
            return "idling";
        }
        if (i == 2) {
            return "moving";
        }
        throw new IllegalArgumentException("Unrecognized state value: " + i);
    }

    private CarUxRestrictionsConfiguration(Parcel parcel) {
        this.mRestrictionModes = new ArrayMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            String readString = parcel.readString();
            RestrictionModeContainer restrictionModeContainer = new RestrictionModeContainer();
            for (int i2 : DRIVING_STATES) {
                ArrayList arrayList = new ArrayList();
                parcel.readTypedList(arrayList, RestrictionsPerSpeedRange.CREATOR);
                restrictionModeContainer.setRestrictionsForDriveState(i2, arrayList);
            }
            this.mRestrictionModes.put(readString, restrictionModeContainer);
        }
        this.mPhysicalPort = parcel.readBoolean() ? null : Byte.valueOf(parcel.readByte());
        this.mMaxContentDepth = parcel.readInt();
        this.mMaxCumulativeContentItems = parcel.readInt();
        this.mMaxStringLength = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRestrictionModes.size());
        Iterator<Map.Entry<String, RestrictionModeContainer>> it = this.mRestrictionModes.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, RestrictionModeContainer> next = it.next();
            parcel.writeString(next.getKey());
            for (int i2 : DRIVING_STATES) {
                parcel.writeTypedList(next.getValue().getRestrictionsForDriveState(i2));
            }
        }
        boolean z = this.mPhysicalPort == null;
        parcel.writeBoolean(z);
        parcel.writeByte(z ? (byte) 0 : this.mPhysicalPort.byteValue());
        parcel.writeInt(this.mMaxContentDepth);
        parcel.writeInt(this.mMaxCumulativeContentItems);
        parcel.writeInt(this.mMaxStringLength);
    }

    public static final class Builder {
        private static final int UX_RESTRICTIONS_UNKNOWN = -1;
        private int mMaxContentDepth = -1;
        private int mMaxCumulativeContentItems = -1;
        private int mMaxStringLength = -1;
        private Byte mPhysicalPort;
        public final Map<String, RestrictionModeContainer> mRestrictionModes;

        public static byte validatePort(int i) {
            if (-128 > i || i > 127) {
                throw new IllegalArgumentException("Port value should be within the range of a byte. Input is " + i);
            }
            return (byte) i;
        }

        public Builder() {
            ArrayMap arrayMap = new ArrayMap();
            this.mRestrictionModes = arrayMap;
            arrayMap.put(CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE, new RestrictionModeContainer());
        }

        public Builder setPhysicalPort(byte b) {
            this.mPhysicalPort = Byte.valueOf(b);
            return this;
        }

        public Builder setUxRestrictions(int i, boolean z, int i2) {
            return setUxRestrictions(i, new DrivingStateRestrictions().setDistractionOptimizationRequired(z).setRestrictions(i2));
        }

        @Deprecated
        public Builder setUxRestrictions(int i, SpeedRange speedRange, boolean z, int i2) {
            return setUxRestrictions(i, new DrivingStateRestrictions().setDistractionOptimizationRequired(z).setRestrictions(i2).setSpeedRange(speedRange));
        }

        public Builder setUxRestrictions(int i, DrivingStateRestrictions drivingStateRestrictions) {
            SpeedRange speedRange = drivingStateRestrictions.mSpeedRange;
            if (i != 2 && speedRange != null) {
                throw new IllegalArgumentException("Non-moving driving state should not specify speed range.");
            }
            this.mRestrictionModes.computeIfAbsent(drivingStateRestrictions.mMode, new Function() { // from class: android.car.drivingstate.CarUxRestrictionsConfiguration$Builder$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return CarUxRestrictionsConfiguration.Builder.lambda$setUxRestrictions$0((String) obj);
                }
            }).getRestrictionsForDriveState(i).add(new RestrictionsPerSpeedRange(drivingStateRestrictions.mMode, drivingStateRestrictions.mReqOpt, drivingStateRestrictions.mRestrictions, speedRange));
            return this;
        }

        static /* synthetic */ RestrictionModeContainer lambda$setUxRestrictions$0(String str) {
            return new RestrictionModeContainer();
        }

        public Builder setMaxStringLength(int i) {
            this.mMaxStringLength = i;
            return this;
        }

        public Builder setMaxCumulativeContentItems(int i) {
            this.mMaxCumulativeContentItems = i;
            return this;
        }

        public Builder setMaxContentDepth(int i) {
            this.mMaxContentDepth = i;
            return this;
        }

        public CarUxRestrictionsConfiguration build() {
            addDefaultRestrictionsToBaseline();
            validateBaselineModeRestrictions();
            for (String str : this.mRestrictionModes.keySet()) {
                if (!CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE.equals(str)) {
                    validateModeRestrictions(str);
                }
            }
            return new CarUxRestrictionsConfiguration(this);
        }

        private void addDefaultRestrictionsToBaseline() {
            RestrictionModeContainer restrictionModeContainer = this.mRestrictionModes.get(CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE);
            for (int i : CarUxRestrictionsConfiguration.DRIVING_STATES) {
                List<RestrictionsPerSpeedRange> restrictionsForDriveState = restrictionModeContainer.getRestrictionsForDriveState(i);
                if (restrictionsForDriveState.size() == 0) {
                    Log.i(CarUxRestrictionsConfiguration.TAG, "Using default restrictions for driving state: " + CarUxRestrictionsConfiguration.getDrivingStateName(i));
                    restrictionsForDriveState.add(new RestrictionsPerSpeedRange(true, 511));
                }
            }
        }

        private void validateBaselineModeRestrictions() {
            RestrictionModeContainer restrictionModeContainer = this.mRestrictionModes.get(CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE);
            for (int i : CarUxRestrictionsConfiguration.DRIVING_STATES) {
                List<RestrictionsPerSpeedRange> restrictionsForDriveState = restrictionModeContainer.getRestrictionsForDriveState(i);
                if (i != 2 && restrictionsForDriveState.size() != 1) {
                    throw new IllegalStateException("Non-moving driving state should contain one set of restriction rules.");
                }
                if (restrictionsForDriveState.size() > 1 && restrictionsForDriveState.stream().anyMatch(new Predicate() { // from class: android.car.drivingstate.CarUxRestrictionsConfiguration$Builder$$ExternalSyntheticLambda2
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return CarUxRestrictionsConfiguration.Builder.lambda$validateBaselineModeRestrictions$1((CarUxRestrictionsConfiguration.RestrictionsPerSpeedRange) obj);
                    }
                })) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<RestrictionsPerSpeedRange> it = restrictionsForDriveState.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().toString()).append('\n');
                    }
                    throw new IllegalStateException("Every restriction in MOVING state should contain driving state.\n" + sb.toString());
                }
                Collections.sort(restrictionsForDriveState, Comparator.comparing(new CarUxRestrictionsConfiguration$Builder$$ExternalSyntheticLambda1()));
                validateRangeOfSpeed(restrictionsForDriveState);
                validateContinuousSpeedRange(restrictionsForDriveState);
            }
        }

        static /* synthetic */ boolean lambda$validateBaselineModeRestrictions$1(RestrictionsPerSpeedRange restrictionsPerSpeedRange) {
            return restrictionsPerSpeedRange.mSpeedRange == null;
        }

        private void validateModeRestrictions(String str) {
            if (this.mRestrictionModes.containsKey(str)) {
                List<RestrictionsPerSpeedRange> restrictionsForDriveState = this.mRestrictionModes.get(str).getRestrictionsForDriveState(2);
                Collections.sort(restrictionsForDriveState, Comparator.comparing(new CarUxRestrictionsConfiguration$Builder$$ExternalSyntheticLambda1()));
                validateContinuousSpeedRange(restrictionsForDriveState);
            }
        }

        private void validateRangeOfSpeed(List<RestrictionsPerSpeedRange> list) {
            if (list.size() == 1 && list.get(0).mSpeedRange == null) {
                return;
            }
            if (Float.compare(list.get(0).mSpeedRange.mMinSpeed, 0.0f) != 0) {
                throw new IllegalStateException("Speed range min speed should start at 0.");
            }
            if (Float.compare(list.get(list.size() - 1).mSpeedRange.mMaxSpeed, Float.POSITIVE_INFINITY) != 0) {
                throw new IllegalStateException("Max speed of last restriction should be MAX_SPEED.");
            }
        }

        private void validateContinuousSpeedRange(List<RestrictionsPerSpeedRange> list) {
            for (int i = 1; i < list.size(); i++) {
                if (Float.compare(list.get(i).mSpeedRange.mMinSpeed, list.get(i - 1).mSpeedRange.mMaxSpeed) != 0) {
                    throw new IllegalArgumentException("Mis-configured speed range. Possibly speed range overlap or gap.");
                }
            }
        }

        public static final class SpeedRange implements Comparable<SpeedRange> {
            public static final float MAX_SPEED = Float.POSITIVE_INFINITY;
            private float mMaxSpeed;
            private float mMinSpeed;

            public SpeedRange(float f) {
                this(f, Float.POSITIVE_INFINITY);
            }

            public SpeedRange(float f, float f2) {
                if (Float.compare(f, 0.0f) < 0 || Float.compare(f2, 0.0f) < 0) {
                    throw new IllegalArgumentException("Speed cannot be negative.");
                }
                if (f == Float.POSITIVE_INFINITY) {
                    throw new IllegalArgumentException("Min speed cannot be MAX_SPEED.");
                }
                if (f > f2) {
                    throw new IllegalArgumentException("Min speed " + f + " should not be greater than max speed " + f2);
                }
                this.mMinSpeed = f;
                this.mMaxSpeed = f2;
            }

            public boolean includes(float f) {
                return this.mMinSpeed <= f && f < this.mMaxSpeed;
            }

            @Override // java.lang.Comparable
            public int compareTo(SpeedRange speedRange) {
                int compare = Float.compare(this.mMinSpeed, speedRange.mMinSpeed);
                return compare != 0 ? compare : Float.compare(this.mMaxSpeed, speedRange.mMaxSpeed);
            }

            public int hashCode() {
                return Objects.hash(Float.valueOf(this.mMinSpeed), Float.valueOf(this.mMaxSpeed));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SpeedRange) && compareTo((SpeedRange) obj) == 0;
            }

            public String toString() {
                StringBuilder append = new StringBuilder("[min: ").append(this.mMinSpeed).append("; max: ");
                float f = this.mMaxSpeed;
                return append.append(f == Float.POSITIVE_INFINITY ? CarUxRestrictionsConfiguration.JSON_NAME_MAX_SPEED : Float.valueOf(f)).append("]").toString();
            }
        }
    }

    public static final class DrivingStateRestrictions {
        private String mMode = CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE;
        private boolean mReqOpt = true;
        private int mRestrictions = 511;
        private Builder.SpeedRange mSpeedRange;

        public DrivingStateRestrictions setDistractionOptimizationRequired(boolean z) {
            this.mReqOpt = z;
            return this;
        }

        public DrivingStateRestrictions setRestrictions(int i) {
            this.mRestrictions = i;
            return this;
        }

        public DrivingStateRestrictions setMode(String str) {
            this.mMode = (String) Objects.requireNonNull(str, "mode must not be null");
            return this;
        }

        public DrivingStateRestrictions setSpeedRange(Builder.SpeedRange speedRange) {
            this.mSpeedRange = speedRange;
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder("Mode: ").append(this.mMode).append(". Requires DO? ").append(this.mReqOpt).append(". Restrictions: ").append(Integer.toBinaryString(this.mRestrictions)).append(". SpeedRange: ");
            Builder.SpeedRange speedRange = this.mSpeedRange;
            return append.append(speedRange == null ? "null" : speedRange.toString()).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class RestrictionsPerSpeedRange implements Parcelable {
        public static final Parcelable.Creator<RestrictionsPerSpeedRange> CREATOR = new Parcelable.Creator<RestrictionsPerSpeedRange>() { // from class: android.car.drivingstate.CarUxRestrictionsConfiguration.RestrictionsPerSpeedRange.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RestrictionsPerSpeedRange createFromParcel(Parcel parcel) {
                return new RestrictionsPerSpeedRange(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RestrictionsPerSpeedRange[] newArray(int i) {
                return new RestrictionsPerSpeedRange[i];
            }
        };
        final String mMode;
        final boolean mReqOpt;
        final int mRestrictions;
        final Builder.SpeedRange mSpeedRange;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        RestrictionsPerSpeedRange(boolean z, int i) {
            this(CarUxRestrictionsManager.UX_RESTRICTION_MODE_BASELINE, z, i, null);
        }

        RestrictionsPerSpeedRange(String str, boolean z, int i, Builder.SpeedRange speedRange) {
            if (!z && i != 0) {
                throw new IllegalArgumentException("Driving optimization is not required but UX restrictions is required.");
            }
            this.mMode = (String) Objects.requireNonNull(str, "mode must not be null");
            this.mReqOpt = z;
            this.mRestrictions = i;
            this.mSpeedRange = speedRange;
        }

        public Builder.SpeedRange getSpeedRange() {
            return this.mSpeedRange;
        }

        public int hashCode() {
            return Objects.hash(this.mMode, Boolean.valueOf(this.mReqOpt), Integer.valueOf(this.mRestrictions), this.mSpeedRange);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof RestrictionsPerSpeedRange)) {
                return false;
            }
            RestrictionsPerSpeedRange restrictionsPerSpeedRange = (RestrictionsPerSpeedRange) obj;
            return Objects.equals(this.mMode, restrictionsPerSpeedRange.mMode) && this.mReqOpt == restrictionsPerSpeedRange.mReqOpt && this.mRestrictions == restrictionsPerSpeedRange.mRestrictions && Objects.equals(this.mSpeedRange, restrictionsPerSpeedRange.mSpeedRange);
        }

        public String toString() {
            StringBuilder append = new StringBuilder("[Mode is ").append(this.mMode).append("; Requires DO? ").append(this.mReqOpt).append("; Restrictions: ").append(Integer.toBinaryString(this.mRestrictions)).append("; Speed range: ");
            Builder.SpeedRange speedRange = this.mSpeedRange;
            return append.append(speedRange == null ? "null" : speedRange.toString()).append(']').toString();
        }

        protected RestrictionsPerSpeedRange(Parcel parcel) {
            this.mMode = parcel.readString();
            this.mReqOpt = parcel.readBoolean();
            this.mRestrictions = parcel.readInt();
            this.mSpeedRange = parcel.readBoolean() ? new Builder.SpeedRange(parcel.readFloat(), parcel.readFloat()) : null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mMode);
            parcel.writeBoolean(this.mReqOpt);
            parcel.writeInt(this.mRestrictions);
            parcel.writeBoolean(this.mSpeedRange != null);
            Builder.SpeedRange speedRange = this.mSpeedRange;
            if (speedRange != null) {
                parcel.writeFloat(speedRange.mMinSpeed);
                parcel.writeFloat(this.mSpeedRange.mMaxSpeed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class RestrictionModeContainer {
        private final Map<Integer, List<RestrictionsPerSpeedRange>> mDriveStateUxRestrictions = new ArrayMap(CarUxRestrictionsConfiguration.DRIVING_STATES.length);

        RestrictionModeContainer() {
            for (int i : CarUxRestrictionsConfiguration.DRIVING_STATES) {
                this.mDriveStateUxRestrictions.put(Integer.valueOf(i), new ArrayList());
            }
        }

        List<RestrictionsPerSpeedRange> getRestrictionsForDriveState(int i) {
            return this.mDriveStateUxRestrictions.get(Integer.valueOf(i));
        }

        void setRestrictionsForDriveState(int i, List<RestrictionsPerSpeedRange> list) {
            Objects.requireNonNull(list, "null restrictions are not allows");
            this.mDriveStateUxRestrictions.put(Integer.valueOf(i), list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RestrictionModeContainer) {
                return Objects.equals(this.mDriveStateUxRestrictions, ((RestrictionModeContainer) obj).mDriveStateUxRestrictions);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.mDriveStateUxRestrictions);
        }
    }
}
