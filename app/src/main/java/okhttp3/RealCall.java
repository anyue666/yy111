package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

/* loaded from: classes2.dex */
final class RealCall implements Call {
    final OkHttpClient client;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    private Transmitter transmitter;

    private RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, request, z);
        realCall.transmitter = new Transmitter(okHttpClient, realCall);
        return realCall;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.transmitter.timeoutEnter();
        this.transmitter.callStart();
        try {
            this.client.dispatcher().executed(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.transmitter.callStart();
        this.client.dispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // okhttp3.Call
    public void cancel() {
        this.transmitter.cancel();
    }

    @Override // okhttp3.Call
    public Timeout timeout() {
        return this.transmitter.timeout();
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.transmitter.isCanceled();
    }

    @Override // okhttp3.Call
    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.callsPerHost = new AtomicInteger(0);
            this.responseCallback = callback;
        }

        AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
        }

        String host() {
            return RealCall.this.originalRequest.url().host();
        }

        Request request() {
            return RealCall.this.originalRequest;
        }

        RealCall get() {
            return RealCall.this;
        }

        void executeOn(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    RealCall.this.transmitter.noMoreExchanges(interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.client.dispatcher().finished(this);
                }
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            RealCall.this.transmitter.timeoutEnter();
            boolean z = false;
            try {
                try {
                    try {
                        this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
                    } catch (IOException e) {
                        e = e;
                        z = true;
                        if (z) {
                            Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                        } else {
                            this.responseCallback.onFailure(RealCall.this, e);
                        }
                        RealCall.this.client.dispatcher().finished(this);
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        RealCall.this.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.responseCallback.onFailure(RealCall.this, iOException);
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                }
                RealCall.this.client.dispatcher().finished(this);
            } catch (Throwable th3) {
                RealCall.this.client.dispatcher().finished(this);
                throw th3;
            }
        }
    }

    String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + redactedUrl();
    }

    String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    okhttp3.Response getResponseWithInterceptorChain() throws java.io.IOException {
        /*
            r12 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            okhttp3.OkHttpClient r0 = r12.client
            java.util.List r0 = r0.interceptors()
            r1.addAll(r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            okhttp3.CookieJar r2 = r2.cookieJar()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            okhttp3.internal.cache.InternalCache r2 = r2.internalCache()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = new okhttp3.internal.connection.ConnectInterceptor
            okhttp3.OkHttpClient r2 = r12.client
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r12.forWebSocket
            if (r0 != 0) goto L4b
            okhttp3.OkHttpClient r0 = r12.client
            java.util.List r0 = r0.networkInterceptors()
            r1.addAll(r0)
        L4b:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r2 = r12.forWebSocket
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.RealInterceptorChain r10 = new okhttp3.internal.http.RealInterceptorChain
            okhttp3.internal.connection.Transmitter r2 = r12.transmitter
            r3 = 0
            r4 = 0
            okhttp3.Request r5 = r12.originalRequest
            okhttp3.OkHttpClient r0 = r12.client
            int r7 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r12.client
            int r8 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r12.client
            int r9 = r0.writeTimeoutMillis()
            r0 = r10
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r12.originalRequest     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            okhttp3.Response r2 = r10.proceed(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            okhttp3.internal.connection.Transmitter r3 = r12.transmitter     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            boolean r3 = r3.isCanceled()     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            if (r3 != 0) goto L8a
            okhttp3.internal.connection.Transmitter r1 = r12.transmitter
            r1.noMoreExchanges(r0)
            return r2
        L8a:
            okhttp3.internal.Util.closeQuietly(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            throw r2     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
        L95:
            r2 = move-exception
            goto La4
        L97:
            r1 = move-exception
            r2 = 1
            okhttp3.internal.connection.Transmitter r3 = r12.transmitter     // Catch: java.lang.Throwable -> La0
            java.io.IOException r1 = r3.noMoreExchanges(r1)     // Catch: java.lang.Throwable -> La0
            throw r1     // Catch: java.lang.Throwable -> La0
        La0:
            r1 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
        La4:
            if (r1 != 0) goto Lab
            okhttp3.internal.connection.Transmitter r1 = r12.transmitter
            r1.noMoreExchanges(r0)
        Lab:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.getResponseWithInterceptorChain():okhttp3.Response");
    }
}
