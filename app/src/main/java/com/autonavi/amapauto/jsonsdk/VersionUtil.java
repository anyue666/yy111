package com.autonavi.amapauto.jsonsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VersionUtil {
    public static final String CLIENT_VERSION = "3.2.0.20190521";
    private static String serverVersion = "";

    public static String getServerVersion() {
        return serverVersion;
    }

    public static void requestVersion(String str) {
        if (TextUtils.isEmpty(serverVersion)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("requestCode", "0");
                jSONObject.put("responseCode", "0");
                jSONObject.put("needResponse", true);
                jSONObject.put("protocolId", ProtocolID.PROTOCOL_GET_VERSION);
                jSONObject.put("versionName", "0");
                jSONObject.put("requestAuthor", str);
                jSONObject.put("message", "");
                jSONObject.put("messageType", "request");
                jSONObject.put("statusCode", 0);
                jSONObject2.put("versionName", CLIENT_VERSION);
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e) {
                Log.e("VersionUtil", "requestVersion fail", e);
            }
            JsonProtocolManager.getInstance().request(jSONObject.toString());
        }
    }

    public static void dealVersionCallback(JSONObject jSONObject, Context context) {
        serverVersion = jSONObject.optJSONObject("data").optString("versionName", "null");
        Log.i("VersionUtil", "jsonSdk clientVersion = 3.2.0.20190521 serverVersion = " + serverVersion);
        int businessVersion = getBusinessVersion(CLIENT_VERSION);
        int timeVersion = getTimeVersion(CLIENT_VERSION);
        int businessVersion2 = getBusinessVersion(serverVersion);
        int timeVersion2 = getTimeVersion(serverVersion);
        if (businessVersion > businessVersion2 || timeVersion > timeVersion2) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.autonavi.amapauto.jsonsdk.VersionUtil.1
                final /* synthetic */ Context val$context;

                AnonymousClass1(Context context2) {
                    r1 = context2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(r1, "Auto版本号太低，协议调用可能出现异常，请更新新版本", 1).show();
                }
            });
        }
    }

    /* renamed from: com.autonavi.amapauto.jsonsdk.VersionUtil$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context2) {
            r1 = context2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(r1, "Auto版本号太低，协议调用可能出现异常，请更新新版本", 1).show();
        }
    }

    private static int getBusinessVersion(String str) {
        try {
            return Integer.parseInt(str.substring(0, str.lastIndexOf(".")).replace(".", ""));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int getTimeVersion(String str) {
        try {
            return Integer.parseInt(str.substring(str.lastIndexOf(".") + 1, str.length()));
        } catch (Exception unused) {
            return 0;
        }
    }
}
