package com.autolink.hmi.crosscountry.utils.networkutils;

import android.util.Log;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/* loaded from: classes.dex */
public class RetrofitUtils {
    private static RetrofitUtils httpUtils;
    private final API API;
    private static final Gson gson = new Gson();
    private static final HashMap<String, Object> h = new HashMap<>();
    private static final HashMap<String, Object> p = new HashMap<>();
    private final String TAG = " ===> RetrofitUtils";
    private boolean isOpenLog = true;
    private String classname = "";
    private final MultipartBody.Builder builder = new MultipartBody.Builder();

    interface API {
        @GET
        Observable<ResponseBody> doGet(@Url String str);

        @GET
        Observable<ResponseBody> doGet(@Url String str, @QueryMap Map<String, Object> map);

        @GET
        Observable<ResponseBody> doGet(@Url String str, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map2);

        @GET
        Observable<ResponseBody> doGetArray(@Url String str);

        @FormUrlEncoded
        @POST
        Observable<ResponseBody> doPost(@Url String str);

        @FormUrlEncoded
        @POST
        Observable<ResponseBody> doPost(@Url String str, @FieldMap Map<String, Object> map);

        @FormUrlEncoded
        @POST
        Observable<ResponseBody> doPost(@Url String str, @HeaderMap Map<String, Object> map, @FieldMap Map<String, Object> map2);

        @POST
        Observable<ResponseBody> doPost(@Url String str, @Body RequestBody requestBody, @HeaderMap Map<String, Object> map);

        @POST
        @Multipart
        Observable<ResponseBody> upload(@Url String str, @Part List<MultipartBody.Part> list);

        @POST
        @Multipart
        Observable<ResponseBody> upload(@Url String str, @HeaderMap Map<String, Object> map, @Part List<MultipartBody.Part> list);
    }

    interface ArrayCallBack {
        void onError(String str);

        void onSuccess(String str);
    }

    public interface CallBack<T> {
        void onError(String str);

        void onSuccess(T t);
    }

    private RetrofitUtils(String str) {
        this.API = (API) new Retrofit.Builder().baseUrl(str).client(new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).addInterceptor(new RetryInterceptor()).connectTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).build()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(API.class);
    }

    public static RetrofitUtils getHttpUtils(String str) {
        if (httpUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new RetrofitUtils(str);
                }
            }
        }
        return httpUtils;
    }

    public <T> void doGet(String str, Map<String, Object> map, CallBack<T> callBack) {
        this.API.doGet(str, map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.1
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass1(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r3.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$1 */
    class AnonymousClass1 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass1(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r3.onError(th.toString());
        }
    }

    public <T> void doGet(String str, Map<String, Object> map, Map<String, Object> map2, CallBack<T> callBack) {
        this.API.doGet(str, map, map2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.2
            final /* synthetic */ CallBack val$callBack;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass2(CallBack callBack2) {
                r2 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "onNext: " + RetrofitUtils.this.classname + "\n" + string);
                    }
                    r2.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r2.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r2.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$2 */
    class AnonymousClass2 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass2(CallBack callBack2) {
            r2 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "onNext: " + RetrofitUtils.this.classname + "\n" + string);
                }
                r2.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r2.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r2.onError(th.toString());
        }
    }

    public <T> void doGetArray(String str, ArrayCallBack arrayCallBack) {
        this.API.doGetArray(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.3
            final /* synthetic */ ArrayCallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass3(String str2, ArrayCallBack arrayCallBack2) {
                r2 = str2;
                r3 = arrayCallBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r3.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$3 */
    class AnonymousClass3 implements Observer<ResponseBody> {
        final /* synthetic */ ArrayCallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass3(String str2, ArrayCallBack arrayCallBack2) {
            r2 = str2;
            r3 = arrayCallBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r3.onError(th.toString());
        }
    }

    public <T> void doGet(String str, CallBack<T> callBack) {
        this.API.doGet(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.4
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass4(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r3.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$4 */
    class AnonymousClass4 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass4(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r3.onError(th.toString());
        }
    }

    public <T> void doPost(String str, Map<String, Object> map, CallBack<T> callBack) {
        this.API.doPost(str, map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.5
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass5(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r3.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$5 */
    class AnonymousClass5 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass5(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r3.onError(th.toString());
        }
    }

    public <T> void doPost(String str, CallBack<T> callBack) {
        this.API.doPost(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.6
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass6(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r3.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$6 */
    class AnonymousClass6 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass6(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r3.onError(th.toString());
        }
    }

    public <T> void doPost(String str, Map<String, Object> map, Map<String, Object> map2, CallBack<T> callBack) {
        this.API.doPost(str, map, map2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.7
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass7(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r3.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$7 */
    class AnonymousClass7 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass7(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r3.onError(th.toString());
        }
    }

    public <T> void doFile(String str, File file, CallBack<T> callBack) {
        this.API.upload(str, this.builder.setType(MultipartBody.FORM).addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file)).build().parts()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.8
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass8(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$8 */
    class AnonymousClass8 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass8(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> void doFile(String str, Map<String, Object> map, File file, CallBack<T> callBack) {
        this.API.upload(str, map, this.builder.setType(MultipartBody.FORM).addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file)).build().parts()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.9
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass9(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$9 */
    class AnonymousClass9 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass9(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doPostString(String str, Map<String, Object> map, Map<String, Object> map2, CallBack<String> callBack) {
        this.API.doPost(str, map, map2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.10
            final /* synthetic */ CallBack val$callBack;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass10(CallBack callBack2) {
                r2 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                String str2;
                try {
                    str2 = responseBody.string();
                } catch (IOException e) {
                    e = e;
                    str2 = null;
                }
                try {
                    r2.onSuccess(str2);
                } catch (IOException e2) {
                    e = e2;
                    Log.e(RetrofitUtils.this.TAG, "onNext: " + RetrofitUtils.this.classname + "\n" + e.toString() + "\n" + str2);
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r2.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$10 */
    class AnonymousClass10 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass10(CallBack callBack2) {
            r2 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            String str2;
            try {
                str2 = responseBody.string();
            } catch (IOException e) {
                e = e;
                str2 = null;
            }
            try {
                r2.onSuccess(str2);
            } catch (IOException e2) {
                e = e2;
                Log.e(RetrofitUtils.this.TAG, "onNext: " + RetrofitUtils.this.classname + "\n" + e.toString() + "\n" + str2);
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r2.onError(th.toString());
        }
    }

    public <T> void doPost(String str, RequestBody requestBody, Map<String, Object> map, CallBack<T> callBack) {
        this.API.doPost(str, requestBody, map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ResponseBody>() { // from class: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils.11
            final /* synthetic */ CallBack val$callBack;
            final /* synthetic */ String val$url;

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            AnonymousClass11(String str2, CallBack callBack2) {
                r2 = str2;
                r3 = callBack2;
            }

            @Override // io.reactivex.Observer
            public void onNext(ResponseBody responseBody) {
                try {
                    String string = responseBody.string();
                    if (RetrofitUtils.this.isOpenLog) {
                        Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                        Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                    }
                    r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                r3.onError(th.toString());
            }
        });
    }

    /* renamed from: com.autolink.hmi.crosscountry.utils.networkutils.RetrofitUtils$11 */
    class AnonymousClass11 implements Observer<ResponseBody> {
        final /* synthetic */ CallBack val$callBack;
        final /* synthetic */ String val$url;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        AnonymousClass11(String str2, CallBack callBack2) {
            r2 = str2;
            r3 = callBack2;
        }

        @Override // io.reactivex.Observer
        public void onNext(ResponseBody responseBody) {
            try {
                String string = responseBody.string();
                if (RetrofitUtils.this.isOpenLog) {
                    Log.e(RetrofitUtils.this.TAG, "url = " + r2);
                    Log.e(RetrofitUtils.this.TAG, "responseBody.string() = " + string);
                }
                r3.onSuccess(RetrofitUtils.gson.fromJson(string, ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            r3.onError(th.toString());
        }
    }

    public RetrofitUtils setClassName(String str) {
        this.classname = str;
        return httpUtils;
    }

    public RetrofitUtils isOpenLog(boolean z) {
        this.isOpenLog = z;
        return httpUtils;
    }

    public static HashMap<String, Object> header(String str, String str2) {
        clearHMap();
        HashMap<String, Object> hashMap = h;
        hashMap.put("appid", str);
        hashMap.put("version", str2);
        return hashMap;
    }

    public static HashMap<String, Object> header(String str, String... strArr) {
        clearHMap();
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            h.put(split[i], strArr[i]);
        }
        return h;
    }

    public static HashMap<String, Object> parameter(String str, String... strArr) {
        clearPMap();
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            p.put(split[i], strArr[i]);
        }
        return p;
    }

    public static HashMap<String, Object> parameter() {
        clearPMap();
        return p;
    }

    private static void clearPMap() {
        HashMap<String, Object> hashMap = p;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        hashMap.clear();
    }

    private static void clearHMap() {
        HashMap<String, Object> hashMap = h;
        if (hashMap == null || hashMap.size() <= 0) {
            return;
        }
        hashMap.clear();
    }

    static class LoggingInterceptor implements Interceptor {
        private static final String TAG = "LoggingInterceptor";

        LoggingInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            long nanoTime = System.nanoTime();
            Log.d(TAG, String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
            Response proceed = chain.proceed(request);
            Log.d(TAG, String.format("Received response for %s in %.1fms%n%s", proceed.request().url(), Double.valueOf((System.nanoTime() - nanoTime) / 1000000.0d), proceed.headers()));
            return proceed;
        }
    }

    public class RetryInterceptor implements Interceptor {
        private static final int MAX_RETRIES = 3;
        private static final int RETRY_DELAY_MS = 3000;

        public RetryInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            int i = 0;
            while (!proceed.isSuccessful() && i < 3) {
                i++;
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                proceed = chain.proceed(request);
            }
            return proceed;
        }
    }
}
