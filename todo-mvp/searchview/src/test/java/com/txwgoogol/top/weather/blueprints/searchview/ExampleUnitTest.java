package com.txwgoogol.android.architecture.blueprints.searchview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    /**
     * List转数组
     */
    @Test
    public void ListToArray(){
        ArrayList<String> list=new ArrayList<String>();
        list.add("1");
        list.add("a");
        list.add("P");
        list.add("9");
        String[] strings = new String[list.size()];
        list.toArray(strings);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(strings[i]);
        }
    }

    /**
     * 数组转List
     */
    @Test
    public void ArrayToList(){
        String[] s = {"a","b","c"};
        List list = java.util.Arrays.asList(s);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}