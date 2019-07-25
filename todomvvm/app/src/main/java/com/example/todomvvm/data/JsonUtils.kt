package com.example.todomvvm.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//json解析工具类
object JsonUtils {

    //将json对象解析成相应的映射对象
    fun <T> parseJsonWithJson(str: String, type: Class<T>): T {
        val json = Gson()
        return json.fromJson(str, type)
    }

    //将json对象解析成相应的映射对象列表
    fun <T> parsJsonArrayWithJson(str: String, type: Class<T>): List<T>? {

        val json = Gson()

        /* GSON提供了 TypeToken 这个类来帮助我们捕获（capture）像List<Model>这样的泛型信息。
       上文创建了一个匿名内部类，这样，Java编译器就会把泛型信息编译到这个匿名内部类里，然后在运行时就可以被
       getType()方法用反射API提取到。*/
        return json.fromJson<List<T>>(str, object : TypeToken<List<T>>() {}.type)
    }

}