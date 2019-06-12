package top.txwgoogol.weather.todomvp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class AppService extends Service {

    /**
     * 创建服务
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 用户通过显示调用启动服务
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 绑定服务
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    /**
     * 解绑服务
     * @param intent
     * @return
     */
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /**
     * 销毁服务
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}