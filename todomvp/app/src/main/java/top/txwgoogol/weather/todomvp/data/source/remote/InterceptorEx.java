package top.txwgoogol.weather.todomvp.data.source.remote;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 拦截器
 * 请求头 https://blog.csdn.net/silenceoo/article/details/77460607
 * 公共参数 https://blog.csdn.net/weixin_37577039/article/details/79495797
 * 报文加解密 https://www.jianshu.com/p/83caa619b219
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class InterceptorEx implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        //添加公共请求头
//        Request request = chain.request().newBuilder()
//                //.header("User-Agent", "YourAppName")
//                //.header("Accept", "application/vnd.yourapi.v1.full+json")
//                .header("key","52zpuzgswyulc0w6")
//                .method(original.method(), original.body())
//                .build();

        //添加公共参数
        Request request;
        HttpUrl modifiedUrl = original.url().newBuilder()
                // Provide your custom parameter here
                .addQueryParameter("key", "xhh3kqcmbqibdysj")//WeatherJNI.weatherKey()
                .build();
        request = original.newBuilder().url(modifiedUrl).build();

        //请求前--打印请求信息
        long t1 = System.nanoTime();
        Logger.d(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));

        //网络请求
        Response response = chain.proceed(request);

        //网络响应后--打印响应信息
        long t2 = System.nanoTime();
        Logger.d(String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }

}