package com.jjh.sky.date;

import org.joda.time.DateTime;

/**
 * Created by jiajianhong on 16/9/1.
 */
public class DateUtils {

    public static void main(String[] args) {
        // 先生成指定时间
        DateTime dateTime = new DateTime(2016, 10, 16, 0, 0, 0);
        System.out.println(dateTime.getMillis() / 1000);
    }

}
