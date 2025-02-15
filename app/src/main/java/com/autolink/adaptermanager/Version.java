package com.autolink.adaptermanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class Version {
    public static String getVersionCode() {
        String str = "";
        try {
            InputStream resourceAsStream = Version.class.getResourceAsStream("/ReleaseNote.txt");
            str = new BufferedReader(new InputStreamReader(resourceAsStream)).readLine();
            resourceAsStream.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return str;
        }
    }
}
