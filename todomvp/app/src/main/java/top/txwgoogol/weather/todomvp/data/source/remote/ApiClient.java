package top.txwgoogol.weather.todomvp.data.source.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import top.txwgoogol.weather.todomvp.common.Constant;

/**
 * 网络请求客户端
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class ApiClient {

    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;

    public ApiClient() {
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
//      builder.writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        // 自定义拦截器
        builder.addInterceptor(new InterceptorEx());

        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static final class SingleHolder {
        private static final ApiClient INSTANCE = new ApiClient();
    }

    public static ApiClient getInstance() {
        return SingleHolder.INSTANCE;
    }

    //获取对应的接口 反射！[Java 反射和映射](https://blog.csdn.net/qq_33023933/article/details/78710753)  
    public <T> T create(Class<T> cls) {
        return mRetrofit.create(cls);
    }

}