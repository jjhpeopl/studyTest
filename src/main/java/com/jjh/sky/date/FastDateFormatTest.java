package com.jjh.sky.date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * Created by jiajianhong on 16/8/29.
 */
public class FastDateFormatTest {

    public static void main(String[] args) {

        FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));

        // 可以使用DateFormatUtils类来操作,方法里面也是使用的FastDateFormat类来做的
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

}
