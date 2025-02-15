package com.autonavi.amapauto.jsonsdk;

import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class PLogger {
    private static FileLogger fileLogger = new FileLogger();
    private static boolean isLog = false;
    private static String logDirectory = "/AutoProtocolLog";

    public static boolean isLog() {
        return isLog;
    }

    public static void setLog(boolean z) {
        isLog = z;
    }

    public static void setMaxNum(int i) {
        if (fileLogger != null) {
            FileLogger.MAX_LOG_NUMBER = i;
        }
    }

    public static void setWriteLog(boolean z) {
        if (z) {
            try {
                File file = new File(getLogFileDir());
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileLogger fileLogger2 = fileLogger;
        if (fileLogger2 != null) {
            fileLogger2.setWriteLog(z);
        }
    }

    public static void setLogOutPutPath(String str) {
        FileLogger fileLogger2 = fileLogger;
        if (fileLogger2 != null) {
            fileLogger2.setCustomLogPath(str);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (isLog) {
            LoggerThread.getInstance().d(str, str2, objArr);
        }
        if (fileLogger.isLog()) {
            LoggerThread.getInstance().write(str, str2, null, objArr);
        }
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        if (isLog) {
            LoggerThread.getInstance().e(str, str2, th, objArr);
        }
        if (fileLogger.isLog()) {
            LoggerThread.getInstance().write(str, str2, th, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void msgFromParams(StringBuffer stringBuffer, String str, Object... objArr) {
        if (str == null) {
            return;
        }
        if (objArr == null) {
            stringBuffer.append(str);
            return;
        }
        String[] split = str.split("\\{\\?\\}");
        int min = Math.min(split.length, objArr.length);
        for (int i = 0; i < min; i++) {
            stringBuffer.append(split[i]).append(objArr[i]);
        }
        while (min < split.length) {
            stringBuffer.append(split[min]);
            min++;
        }
    }

    public static void d(Class cls, String str, Object... objArr) {
        d(cls.getSimpleName(), str, objArr);
    }

    public static void destory() {
        if (isLog || fileLogger.isLog()) {
            LoggerThread.getInstance().destory();
        }
    }

    public static void checkFile() {
        FileLogger fileLogger2 = fileLogger;
        if (fileLogger2 != null) {
            fileLogger2.checkLogFile();
        }
    }

    public static String getLogFileDir() {
        FileLogger fileLogger2 = fileLogger;
        if (fileLogger2 != null && fileLogger2.getCustomLogPath() != null) {
            return fileLogger.getCustomLogPath();
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + logDirectory;
    }

    private static class FileLogger {
        private static final String FILE_NAME = "protocolSDK.log";
        private static final long MAX_FILE_SIZE = 10485760;
        public static int MAX_LOG_NUMBER = 8;
        private StringBuffer bf;
        private String customLogPath;
        private String filePath;
        private boolean isCheckedLogDir;
        private boolean isLogFileExist;
        private boolean isWriteLog;
        private long lastSaveLogTime;
        private File mCurrentLogFile;

        private FileLogger() {
            this.filePath = null;
            this.customLogPath = null;
            this.isCheckedLogDir = false;
            this.isLogFileExist = false;
            this.isWriteLog = false;
            this.bf = new StringBuffer();
            this.lastSaveLogTime = 0L;
        }

        public String getCustomLogPath() {
            return this.customLogPath;
        }

        public void setCustomLogPath(String str) {
            this.customLogPath = str;
            this.isWriteLog = true;
            this.mCurrentLogFile = null;
            checkLogFile();
            creteFile();
        }

        public boolean isWriteLog() {
            return this.isWriteLog;
        }

        public void setWriteLog(boolean z) {
            this.isWriteLog = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkLogFile() {
            this.filePath = PLogger.getLogFileDir();
            File file = new File(this.filePath);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            this.isCheckedLogDir = true;
            File file2 = new File(this.filePath);
            if (file2.exists() && file2.isDirectory()) {
                this.isLogFileExist = true;
            }
        }

        private boolean writeFile(byte[] bArr, boolean z) {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.mCurrentLogFile, z);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
                return true;
            } catch (Exception unused3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void creteFile() {
            if (this.mCurrentLogFile == null) {
                this.mCurrentLogFile = new File(this.filePath, FILE_NAME);
            }
            try {
                if (this.mCurrentLogFile.exists()) {
                    if (this.mCurrentLogFile.length() > MAX_FILE_SIZE) {
                        resetLogFiles();
                    }
                } else if (this.mCurrentLogFile.getParentFile() == null || this.mCurrentLogFile.getParentFile().exists()) {
                    this.mCurrentLogFile.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void resetLogFiles() throws IOException {
            String parent = this.mCurrentLogFile.getParent();
            String name = this.mCurrentLogFile.getName();
            File file = new File(parent, this.mCurrentLogFile.getName() + "." + (MAX_LOG_NUMBER + 1));
            if (file.exists()) {
                file.delete();
            }
            for (int i = MAX_LOG_NUMBER; i > 0; i--) {
                File file2 = new File(parent, this.mCurrentLogFile.getName() + "." + i);
                if (file2.exists()) {
                    file2.renameTo(new File(parent, this.mCurrentLogFile.getName() + "." + (i + 1)));
                }
            }
            this.mCurrentLogFile.renameTo(new File(parent, this.mCurrentLogFile.getName() + ".1"));
            File file3 = new File(parent, name);
            this.mCurrentLogFile = file3;
            file3.createNewFile();
        }

        public void write(String str, long j, String str2, String str3, Throwable th, Object... objArr) {
            this.bf.append(j).append("##");
            this.bf.append("/").append(str).append(":");
            this.bf.append("[").append(str2).append("]");
            PLogger.msgFromParams(this.bf, str3, objArr);
            this.bf.append("\r\n");
            if (th != null) {
                this.bf.append(Log.getStackTraceString(th));
                this.bf.append("\r\n");
            }
            if (SystemClock.elapsedRealtime() - this.lastSaveLogTime > 2000) {
                try {
                    writeFile(this.bf.toString().getBytes("UTF-8"), true);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                this.lastSaveLogTime = SystemClock.elapsedRealtime();
                this.bf.setLength(0);
            }
        }

        public boolean isLog() {
            if (!this.isCheckedLogDir) {
                checkLogFile();
            }
            if (this.isCheckedLogDir) {
                return this.isWriteLog || this.isLogFileExist;
            }
            return false;
        }
    }

    private static class LoggerThread {
        private static LoggerThread instance;
        private boolean isRunning;
        private List<Runnable> taskLogList = Collections.synchronizedList(new LinkedList());
        private Object locker = new Object();
        private boolean isWait = false;

        public void destory() {
        }

        private LoggerThread() {
            initThread();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LoggerThread getInstance() {
            if (instance == null) {
                instance = new LoggerThread();
            }
            return instance;
        }

        public void d(final String str, final String str2, final Object... objArr) {
            this.taskLogList.add(new Runnable() { // from class: com.autonavi.amapauto.jsonsdk.PLogger.LoggerThread.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuffer stringBuffer = new StringBuffer();
                    PLogger.msgFromParams(stringBuffer, str2, objArr);
                    Log.i(str, stringBuffer.toString());
                }
            });
            notifyLock();
        }

        public void e(final String str, final String str2, final Throwable th, final Object... objArr) {
            this.taskLogList.add(new Runnable() { // from class: com.autonavi.amapauto.jsonsdk.PLogger.LoggerThread.2
                @Override // java.lang.Runnable
                public void run() {
                    StringBuffer stringBuffer = new StringBuffer();
                    PLogger.msgFromParams(stringBuffer, str2, objArr);
                    Log.e(str, stringBuffer.toString(), th);
                }
            });
            notifyLock();
        }

        public void write(final String str, final String str2, final Throwable th, final Object... objArr) {
            final long currentTimeMillis = System.currentTimeMillis();
            final String name = Thread.currentThread().getName();
            this.taskLogList.add(new Runnable() { // from class: com.autonavi.amapauto.jsonsdk.PLogger.LoggerThread.3
                @Override // java.lang.Runnable
                public void run() {
                    LoggerThread.this.setLowThreadPriority();
                    PLogger.fileLogger.creteFile();
                    PLogger.fileLogger.write(str, currentTimeMillis, name, str2, th, objArr);
                }
            });
            notifyLock();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLowThreadPriority() {
            try {
                Process.setThreadPriority(19);
                Thread.currentThread().setPriority(1);
            } catch (Throwable unused) {
            }
        }

        private void initThread() {
            this.isRunning = true;
            new Thread(new Runnable() { // from class: com.autonavi.amapauto.jsonsdk.PLogger.LoggerThread.4
                @Override // java.lang.Runnable
                public void run() {
                    LoggerThread.this.setLowThreadPriority();
                    while (LoggerThread.this.isRunning) {
                        try {
                            LoggerThread.this.excuteTask();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "LoggerThread").start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void excuteTask() throws InterruptedException {
            if (this.taskLogList.size() > 0) {
                try {
                    this.taskLogList.remove(0).run();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            synchronized (this.locker) {
                this.isWait = true;
                this.locker.wait();
                this.isWait = false;
            }
        }

        private void notifyLock() {
            if (this.isWait) {
                try {
                    synchronized (this.locker) {
                        this.locker.notify();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
