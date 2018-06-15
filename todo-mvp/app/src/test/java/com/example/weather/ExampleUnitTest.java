package com.example.weather;

import com.example.android.architecture.blueprints.todoapp.data.Results;
import com.example.android.architecture.blueprints.todoapp.data.location.Location;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void gson_test() throws Exception{

        //像对象中添加数据
        Location location = new Location();
        location.setId("WX4FBXXFKE4F");
        location.setName("北京");
        location.setCountry("CN");
        location.setPath("北京,北京,中国");
        location.setTimezone("Asia/Shanghai");
        location.setTimezone_offset("+08:00");
        Now now = new Now();
//        now.setText("晴");
//        now.setCode("0");
//        now.setTemperature("26");
        Results<Now> results = new Results<>();
        results.setLocation(location);
        results.setT(now);
        results.setLast_update("2018-06-15T11:00:00+08:00");

        //将json对象转换为json字符串
        Gson gson = new Gson();
        String res = gson.toJson(results);
        System.out.println("res="+res);

        //打印json对象
        System.out.println(results.getLocation().getId()
                + results.getLocation().getId()
                + results.getLocation().getName()
                + results.getLocation().getCountry()
                + results.getLocation().getPath()
                + results.getLocation().getTimezone()
                + results.getLocation().getTimezone_offset()
//                + results.getT().getText()
//                + results.getT().getCode()
//                + results.getT().getTemperature()
                + results.getLast_update()
        );

    }

}