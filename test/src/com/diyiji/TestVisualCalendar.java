package com.diyiji;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//可视化日历
public class TestVisualCalendar {
    public static void main(String[] args) throws ParseException {
        //获取键盘输入
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(time);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int nowDate = calendar.get(Calendar.DATE);
        //获得当月的一号
        calendar.set(Calendar.DATE,1);
        //获得星期几
        int max = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int count = 0;

        //获取当前月份最大天数
        int days = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1 - max;i <= days; i++) {
            if (i < 1 ) {
                System.out.print("" + "\t");
            }else {
                if (nowDate != i) {
                    System.out.print(i + "\t");
                }else {
                    System.out.print("*" + i + "\t");
                }

            }

            count++;
            if (count%7 == 0) {
                System.out.print('\n');
            }
        }
    }
}
