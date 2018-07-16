package com.example.weather;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        //将UTC格式的时间转换为日期格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = sdf1.parse("2018-07-16T13:35:00");//拿到Date对象
            String str = sdf2.format(date);//输出格式：2017-01-22 09:28:33
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //获取上午还是下午
        long time = System.currentTimeMillis();
        final Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(time);
        int hour = mCalendar.get(Calendar.HOUR);
        int apm = mCalendar.get(Calendar.AM_PM);
        System.out.print(hour + "   " + (apm == 0 ? "上午" : "下午"));
    }

}