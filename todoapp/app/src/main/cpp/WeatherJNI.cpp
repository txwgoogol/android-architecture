#include "com_txwgoogol_top_weather_todoapp_data_source_jni_WeatherJNI.h"
JNIEXPORT jstring JNICALL Java_com_txwgoogol_top_weather_todoapp_data_source_jni_WeatherJNI_weatherKey(JNIEnv *env, jclass jclass1){
    //天气请求密钥
    return env -> NewStringUTF("52zpuzgswyulc0w6");
}