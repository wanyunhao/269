package com.diyiji;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.set(2001,1,10);
        Date d = c.getTime();

        //测试日期计算
        c.add(Calendar.YEAR, 30);




    }
}
