package com.diyiji;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class AutoBoxing {
    public static void main(String[] args) throws ParseException {

        String timsStamp = "1999-3-3 10:23:14";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = df.parse(timsStamp);
        System.out.println(date);

        HashMap map = new HashMap();

    }
}
