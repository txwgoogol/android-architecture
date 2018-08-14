# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

### Android Progurad 代码混淆
#混淆相关好的文章
#待验证 https://www.cnblogs.com/bluestorm/p/6755943.html
#待验证 https://www.jianshu.com/p/be7ec1819d2f

#APK混淆的步骤
#(1)开启混淆。
#(2)混淆的公共部分。
#(3)不能混淆的代码(项目中的代码和引用的第三方代码)。
#(4)libs下的第三方Jar包的混淆方式。
#(5)complie的第三方Jar包的混淆方式。
#(6)注解代码的混淆方式。

#不能混淆的项
#在AndroidManifest中配置的类，比如四大组件
#JNI调用的方法
#反射用到的类
#WebView中JavaScript调用的方法
#Layout文件引用到的自定义View
#一些引入的第三方库

# 一些基本语法
# https://www.guardsquare.com/en/products/proguard#manual/usage.html

#################### 固定不变的 ####################
#1.基本指令区
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-ignorewarning
-printmapping proguardMapping.txt
-optimizations !code/simplification/cast,!field/*,!class/merging/*
-keepattributes *Annotation*,InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable

#2.默认保留区
-keep public class * extends android.view.View
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.content.BroadcastReceiver

-keep public class * extends android.app.Application
-keep public class * extends android.preference.Preference
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class com.android.vending.licensing.ILicensingService

# 保留support下的所有类及其内部类
-keep class android.support.** {*;}

# nactiv不参与混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# Activity中的View不参与混淆
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

# 枚举类不参与混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 自定义view不参与混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# 自定义view
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# 继承 Parcelable 的序列化实体类
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# 继承 Serializable 的序列化实体类
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# R文件不参与混淆
-keep class **.R$* {
 *;
}

# 一些事件不参与混淆
-keepclassmembers class * {
    void *(**On*Event);
}

# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**

#3.webview
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

#################### 固定不变的 ####################

#################### 需要自己确定不参与混淆的 ####################
#3.需要我们不混淆的代码
#不混淆用关键字-keep来修饰。不混淆的部分大概分为如下几个模块：
#(1) 实体类，json解析类
#(2) 第三方jar包
#(3) js和webview的调用模块
#(4) 与反射相关的类和方法

# ==(1)== 实体类
#-keep class com.example.android.architecture.blueprints.todoapp.data.bean.** { *; }
# ==(2)== 第三方包

#BUTTERKNIFE
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#-------- SQUARE --------
#RETROFIT
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

#OKHTTP
# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*
# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform
#-------- SQUARE --------

# 高德相关依赖
# 集合包:3D地图3.3.2 导航1.8.0 定位2.5.0
#-dontwarn com.amap.api.**
#-dontwarn com.autonavi.**
#-keep class com.amap.api.**{*;}
#-keep class com.autonavi.**{*;}
# 地图服务
#-dontwarn com.amap.api.services.**
#-keep class com.map.api.services.** {*;}
# 3D地图
#-dontwarn com.amap.api.mapcore.**
#-dontwarn com.amap.api.maps.**
#-dontwarn com.autonavi.amap.mapcore.**
#-keep class com.amap.api.mapcore.**{*;}
#-keep class com.amap.api.maps.**{*;}
#-keep class com.autonavi.amap.mapcore.**{*;}
# 定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}
# 导航
#-dontwarn com.amap.api.navi.**
#-dontwarn com.autonavi.**
#-keep class com.amap.api.navi.** {*;}
#-keep class com.autonavi.** {*;}

# Glide
#-keep public class * implements com.bumptech.glide.module.GlideModule
#-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
#  **[] $VALUES;
#  public *;
#}

# GSON
-keep class com.google.gson.** {*;}
-keep class com.google.**{*;}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.qiancheng.carsmangersystem.**{*;}
# 使用Gson时需要配置Gson的解析对象及变量都不混淆。不然Gson会找不到变量。
# 将下面替换成自己的实体类
-keep class com.txwgoogol.top.weather.todoapp.data.bean.** { *; }

#EventBus
#-keepattributes *Annotation*
#-keepclassmembers class ** {
#    @org.greenrobot.eventbus.Subscribe <methods>;
#}
#-keep enum org.greenrobot.eventbus.** { *; }
#-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
#    <init>(java.lang.Throwable);
#}
#-keep class com.example.android.architecture.blueprints.todoapp.data.bean.** { *; }

#UMENG
-keep class com.umeng.** {*;}
-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#SDK需要引用导入工程的资源文件，通过了反射机制得到资源引用文件R.java，但是在开发者通过proguard等混淆/优化工具处理apk时，proguard可能会将R.java删除，如果遇到这个问题，请添加如下配置：
-keep public class com.txwgoogol.top.weather.todoapp.R$*{
    public static final int *;
}

# ==(3)== 与js互相调用的类
#没有可不写
# ==(4)== 反射相关的类和方法
#-keep class com.xx.xx.xx.xx.view.** { *; }
#-keep class com.xx.xx.xx.xx.xx.** { *; }
#################### 需要自己确定不参与混淆的 ####################

#################### libs下的第三方Jar包的混淆方式 ####################
# libs下的第三方Jar包的混淆方式
#-keep class com.txwgoogol.top.weather.widget.searchview.** { *; }
-keep class com.txwgoogol.top.weather.widget.** { *; }
#################### libs下的第三方Jar包的混淆方式 ####################

#################### complie的第三方Jar包的混淆方式 ####################
#-keep class 包名.** { *; }
#################### complie的第三方Jar包的混淆方式 ####################










#忽略所有警告
#-ignorewarning

#-keepclassmembernames class *{
#    native <methods>;
#}

#-keepclassmembernames class *{
#    public <init>(android.context.Context,android.util.AttributeSet);
#}

#-keepclassmembernames class *{
#    public <init>(android.context.Context,android.util.AttributeSet,int);
#}

#-keepclassmembers class *{
#    void set*(***);
#    *** get();
#}

#-keepclassmembers class * extends android.app.Activity{
#    public void * (android.view.View);
#}

#-keepclassmembers enum * {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}

#-keepclassmembers class **.R$* {
#    public static <fields>;
#}

#-keep class * implements android.os.Parcelable {
#  public static final android.os.Parcelable$Creator *;
#}

#-keepclasseswithmembers class * {
#    public <init>(android.content.Context);
#}

#不需要混淆的Android原生代码类
#-keep public class * extends android.view.View
#-keep public class * extends android.app.Fragment
#-keep public class * extends android.app.Activity
#-keep public class * extends android.app.Application
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#-keep public class * extends android.database.sqlite.SQLiteOpenhelper{*;}

#-keepclassmembers class * {
#    public <init> (org.json.JSONObject);
#}

#-dontwarn android.support.**
#-keep class android.support.v4.**{*;}
#-keep public class * extends android.support.v4.**
#-keep class android.support.v7.**{*;}
#-keep public class * extends android.support.v7.**

#-keep public class * extends android.support.annotation.**
#-keep public class * extends android.preference.Preference

################################################
# AndroidEventBus
#-keep class org.simple.** { *; }
#-keep interface org.simple.** { *; }
#-keepclassmembers class * {
#    @org.simple.eventbus.Subscriber <methods>;
#}

# 百度地图（jar包换成自己的版本，记得签名要匹配）
#-libraryjars libs/baidumapapi_v2_1_3.jar
#-keep class com.baidu.** {*;}
#-keep class vi.com.** {*;}
#-keep class com.sinovoice.** {*;}
#-keep class pvi.com.** {*;}
#-dontwarn com.baidu.**
#-dontwarn vi.com.**
#-dontwarn pvi.com.**

# Bugly
#-dontwarn com.tencent.bugly.**
#-keep class com.tencent.bugly.** {*;}

# ButterKnife
#-keep class butterknife.** { *; }
#-dontwarn butterknife.internal.**
#-keep class **$$ViewBinder { *; }
#-keepclasseswithmembernames class * {
#    @butterknife.* <fields>;
#}
#-keepclasseswithmembernames class * {
#    @butterknife.* <methods>;
#}

# EventBus
#-keepattributes *Annotation*
#-keepclassmembers class ** {
#    @org.greenrobot.eventbus.Subscribe <methods>;
#}
#-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Facebook
#-keep class com.facebook.** {*;}
#-keep interface com.facebook.** {*;}
#-keep enum com.facebook.** {*;}

#gosn
#-keepattributes Signature-keepattributes *Annotation*
#-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
# 使用Gson时需要配置Gson的解析对象及变量都不混淆。不然Gson会找不到变量。
# 将下面替换成自己的实体类
#-keep class com.example.android.architecture.blueprints.todoapp.data.bean.** { *; }

# Jackson
#-dontwarn org.codehaus.jackson.**
#-dontwarn com.fasterxml.jackson.databind.**
#-keep class org.codehaus.jackson.** { *;}
#-keep class com.fasterxml.jackson.** { *; }

# 极光推送
#-dontoptimize
#-dontpreverify
#-dontwarn cn.jpush.**
#-keep class cn.jpush.** { *; }

# Okio
#-dontwarn com.squareup.**
#-dontwarn okio.**
#-keep public class org.codehaus.* { *; }
#-keep public class java.nio.* { *; }

# OrmLite
#-keepattributes *DatabaseField*
#-keepattributes *DatabaseTable*
#-keepattributes *SerializedName*
#-keep class com.j256.**
#-keepclassmembers class com.j256.** { *; }
#-keep enum com.j256.**
#-keepclassmembers enum com.j256.** { *; }
#-keep interface com.j256.**
#-keepclassmembers interface com.j256.** { *; }

# Realm
#-keep class io.realm.annotations.RealmModule
#-keep @io.realm.annotations.RealmModule class *
#-keep class io.realm.internal.Keep
#-keep @io.realm.internal.Keep class * { *; }
#-dontwarn javax.**
#-dontwarn io.realm.**

# 微信支付
#-dontwarn com.tencent.mm.**
#-dontwarn com.tencent.wxop.stat.**
#-keep class com.tencent.mm.** {*;}
#-keep class com.tencent.wxop.stat.**{*;}

# 信鸽
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep class com.tencent.android.tpush.**  {* ;}
#-keep class com.tencent.mid.**  {* ;}
#-keepattributes *Annotation*

# 新浪微博
#-keep class com.sina.weibo.sdk.* { *; }
#-keep class android.support.v4.* { *; }
#-keep class com.tencent.* { *; }
#-keep class com.baidu.* { *; }
#-keep class lombok.ast.ecj.* { *; }
#-dontwarn android.support.v4.**
#-dontwarn com.tencent.**s
#-dontwarn com.baidu.**

# 讯飞语音
#-dontwarn com.iflytek.**
#-keep class com.iflytek.** {*;}

# 银联
#-dontwarn com.unionpay.**
#-keep class com.unionpay.** { *; }

# 友盟统计分析
#-keepclassmembers class * { public <init>(org.json.JSONObject); }
#-keepclassmembers enum com.umeng.analytics.** {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}

# 友盟自动更新
#-keepclassmembers class * { public <init>(org.json.JSONObject); }
#-keep public class cn.irains.parking.cloud.pub.R$*{ public static final int *; }
#-keep public class * extends com.umeng.**
#-keep class com.umeng.** { *; }

# 支付宝钱包
#-dontwarn com.alipay.**
#-dontwarn HttpUtils.HttpFetcher
#-dontwarn com.ta.utdid2.**
#-dontwarn com.ut.device.**
#-keep class com.alipay.android.app.IAlixPay{*;}
#-keep class com.alipay.android.app.IAlixPay$Stub{*;}
#-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
#-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
#-keep class com.alipay.sdk.app.PayTask{ public *;}
#-keep class com.alipay.sdk.app.AuthTask{ public *;}
#-keep class com.alipay.mobilesecuritysdk.*
#-keep class com.ut.*