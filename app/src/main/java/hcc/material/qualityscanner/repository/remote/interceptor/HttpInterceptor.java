package hcc.material.qualityscanner.repository.remote.interceptor;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import hcc.material.qualityscanner.repository.converter.NullOnEmptyConverterFactory;
import hcc.material.qualityscanner.repository.local.SharedPreferenceManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpInterceptor implements Interceptor {

    private final String BASE_API = "http://121.168.9.79:80/";


    private final String INOUT_MANAGE_URL = "users/";

    private Context mContext;

    private SharedPreferenceManager mSharedPreferenceManager;

    public Retrofit retrofit;
    private OkHttpClient okHttpClient;
    private Gson gson = new GsonBuilder().setLenient().create();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = null;

        request = request.newBuilder().build();
        Response response = chain.proceed(request);

        return response;
    }


    public HttpInterceptor(Context context) {
        this.mContext = context;
        this.mSharedPreferenceManager = new SharedPreferenceManager(context);

        this.okHttpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(this)
                .build();
    }

    public HttpInterceptor() {
        this.okHttpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(this)
                .build();
    }


    public Retrofit getRetrofitForVisitScanRepository(String URL) {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL).addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        return retrofit;
    }


}
