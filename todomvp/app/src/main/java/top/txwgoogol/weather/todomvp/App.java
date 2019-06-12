package top.txwgoogol.weather.todomvp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.umeng.commonsdk.UMConfigure;

import io.reactivex.annotations.Nullable;

/**
 * 自定义Application类
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class App extends Application {

    //记录Activity数量
    private int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        //============ umeng 使用 start ============

        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数3:Push推送业务的secret
         */
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "");

        /**
         * 初始化
         * 参数1:上下文，必须的参数，不能为空。
         * 参数2:【友盟+】 AppKey，非必须参数，如果Manifest文件中已配置AppKey，该参数可以传空，则使用Manifest中配置的AppKey，否则该参数必须传入。
         * 参数3:【友盟+】 Channel，非必须参数，如果Manifest文件中已配置Channel，该参数可以传空，则使用Manifest中配置的Channel，否则该参数必须传入，Channel命名请详见Channel渠道命名规范。
         * 参数4:设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机。
         * 参数5:Push推送业务的secret，需要集成Push功能时必须传入Push的secret，否则传空。
         */
        //UMConfigure.init(this, getResources().getString(R.string.umeng_key), "Channel", UMConfigure.DEVICE_TYPE_PHONE, null);

        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(BuildConfig.DEBUG);

        /**
         * 设置日志加密
         * 参数：boolean 默认为false（不加密）
         */
        //UMConfigure.setEncryptEnabled(BuildConfig.DEBUG);


        /**
         * 场景类型设置接口
         * context 当前宿主进程的ApplicationContext上下文。
         * etype EScenarioType.E_UM_NORMAL 普通统计场景，如果您在埋点过程中没有使用到U-Game统计接口，请使用普通统计场景。
         * EScenarioType.E_UM_GAME 游戏场景 ，如果您在埋点过程中需要使用到U-Game统计接口，则必须设置游戏场景，否则所有的U-Game统计接口不会生效。
         */
        //MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);

        /**
         * secretkey设置接口，防止AppKey被盗用 企业用户才能用
         * context 当前宿主进程的ApplicationContext上下文。
         * secretkey secretkey需要在【友盟+】网站申请。
         */
        //MobclickAgent.setSecret(this, "s10bacedtyz");

        // 将默认Session间隔时长改为40秒。
        //MobclickAgent.setSessionContinueMillis(1000*40);
        //============ umeng 使用 end ============

        if (BuildConfig.DEBUG) {

            //============ LeakCanary 使用 start ============
            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(this);
            // Normal app init code...
            //============ LeakCanary 使用 end ============

            //============ StrictMode 使用 start ============
            /*
            //是否进行执行严苛模式去检查代码
            //线程相关
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls() //API等级11，使用StrictMode.noteSlowCode
                    .detectDiskReads() //检测硬盘读
                    .detectDiskWrites() //检测硬盘写
                    .detectNetwork()  //检测网络 // or .detectAll() for all detectable problems
                    //.penaltyDialog() //弹出违规提示对话框
                    .penaltyLog() //在 Logcat 中打印违规异常信息
                    .penaltyFlashScreen() //API等级11
                    .build());
            //虚拟机相关
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects() //检测数据操作对象
                    .detectLeakedClosableObjects() //检测对象关闭
                    .penaltyLog() //将警告或者错误信息显示到logcat
                    .penaltyDeath() //有警告或者错误发生，停止应用
                    .build());
            */
            //============ StrictMode 使用 end ============
        }

        //是否在后台运行
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override
            public void onActivityStarted(Activity activity) {
                count++;
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
                if (count > 0) {
                    count--;
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });

        //============ Logger的使用 使用 start ============
        // https://blog.csdn.net/AsiaLYF/article/details/79067374
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG; //默认返回true:打印日志 false:隐藏日志
            }
        });
        //============ Logger的使用 使用 end ============

    }

    /**
     * 判断app是否在后台
     *
     * @return true | false
     */
    public boolean isBackground() {
        if (count <= 0) {
            return true;
        } else {
            return false;
        }
    }

}