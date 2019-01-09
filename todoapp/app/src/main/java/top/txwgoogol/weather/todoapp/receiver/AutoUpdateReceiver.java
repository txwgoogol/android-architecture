package top.txwgoogol.weather.todoapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoUpdateReceiver extends BroadcastReceiver {

    /**
     * 当广播接收器接收到意图的时候调用此方法
     *
     * @param context 接收器正在运行的上下文参数
     * @param intent  正在接收的意图
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case "":
                break;
        }
    }

}