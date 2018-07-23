#include "com_example_android_architecture_blueprints_todoapp_jni_WeatherJNI.h"

JNIEXPORT jstring JNICALL Java_com_example_android_architecture_blueprints_todoapp_jni_WeatherJNI_weatherKey(JNIEnv *env, jclass jclass1){
    //天气请求密钥
    return env -> NewStringUTF("52zpuzgswyulc0w6");
}