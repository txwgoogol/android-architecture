package top.txwgoogol.weather.todomvp.service;

import android.app.IntentService;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.orhanobut.logger.Logger;

/**
 * 用于后台更新/下载/开平广告/天气信息/天气壁纸等
 * IntentService优先级比单纯的线程高很多 适合处理一些高优先级的后台任务 高优先级不容易被系统杀死
 * 内部封装了HandlerThread 和 Handler 具体看源码
 * 第一次启动 onCreate被调用 同时创建一个HandlerThread，然后使用它的Looper构造一个Handler对象
 * 通过Handler对象发送消息(Handler收到消息传递给onHandleIntent处理消息)最终在HandlerThread中执行
 * <p>
 * 每启动一次 IntentService onStartCommand都会被调用一次 在onStartCommand处理每个后台任务的Intent
 */
public class AutoUpdateService extends IntentService {

    //本地广播管理类 用于注册和发送内容到相关类中
    private LocalBroadcastManager mLocalBroadcastManager;

    /**
     * 必须重写
     * 构造函数 这个函数必须是空的 否则不能成功实例化
     *
     * @param super(name) 命名工作线程,用于调试
     */
    public AutoUpdateService() {
        super("AutoUpdateService");
        Logger.d("在这里定义工作线程名称");
    }

    /**
     * 创建服务
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d("开始创建");
        //创建服务管理类
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    /**
     * 启动服务
     *
     * @param intent  Intent 意图
     * @param startId 启动的ID

     @Override public void onStart(@Nullable Intent intent, int startId) {
     super.onStart(intent, startId);
     }
     */

    /**
     * 不应该为IntentService重写此方法（注释自己说的:) ）
     * @param intent
     * @param flags
     * @param startId
     * @return

     @Override public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
     return super.onStartCommand(intent, flags, startId);
     }
     */

    /**
     * 绑定服务
     *
     * @param intent
     * @return

     @Nullable
     @Override public IBinder onBind(Intent intent) {
     return super.onBind(intent);
     }
     */

    /**
     * 必须重写
     * 实现异步任务的方法
     *
     * @param intent Activity传过来的Intent，数据封装在Intent中
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Logger.d("在这里开始处理一些耗时的任务了");
    }

    /**
     * 设置意图偏好
     *
     * @param enabled

     @Override public void setIntentRedelivery(boolean enabled) {
     super.setIntentRedelivery(enabled);
     }
     */

    /**
     * 销毁服务
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d("IntentService服务销毁了 <这是一个多线程的服务> :) ");
    }

}