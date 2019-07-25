package com.example.todomvvm.data.callback;

import com.example.todomvvm.data.convert.Converter;
import okhttp3.Request;
import retrofit2.Response;

public interface Callback<T> extends Converter<T> {

    /** 请求网络开始前，UI线程 */
//    void onStart(Request<T, ? extends Request> request);

    /** 对返回数据进行操作的回调， UI线程 */
    void onSuccess(Response<T> response);

    /** 缓存成功的回调,UI线程 */
    void onCacheSuccess(Response<T> response);

    /** 请求失败，响应错误，数据解析错误等，都会回调该方法， UI线程 */
    void onError(Response<T> response);

    /** 请求网络结束后，UI线程 */
    void onFinish();

    /** 上传过程中的进度回调，get请求不回调，UI线程 */
//    void uploadProgress(Progress progress);

    /** 下载过程中的进度回调，UI线程 */
//    void downloadProgress(Progress progress);
}
