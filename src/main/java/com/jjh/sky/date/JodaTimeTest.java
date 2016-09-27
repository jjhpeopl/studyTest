package com.jjh.sky.date;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jiajianhong on 16/8/29.
 */
public class JodaTimeTest {

    public static void main(String[] args) {
        // 得到当前时间
        Date currentDate = new Date();
        DateTime dateTime = new DateTime();  // DateTime.now()

        System.out.println(currentDate.getTime());
        System.out.println(dateTime.getMillis());

        // 指定某一个时间,如2016-08-29 15:57:02
        Date oneDate = new Date(1472457422728L);
        DateTime oneDateTime = new DateTime(1472457422728L);
        DateTime oneDateTime1 = new DateTime(2016, 8, 29, 15, 57, 2, 728);

        System.out.println(oneDate.toString());
        System.out.println(oneDateTime.toString());  // datetime默认的输出格式为yyyy-MM-ddTHH:mm:ss.SSS
        System.out.println(oneDateTime1.toString("MM/dd/yyyy hh:mm:ss.SSSa"));  // 直接就可以输出规定的格式

        // DateTime和Date之间的转换
        Date convertDate = new Date();
        DateTime dt1 = new DateTime(convertDate);
        System.out.println(dt1.toString());

        Date d1 = dt1.toDate();
        System.out.println(d1.toString());

        // DateTime和Calendar之间的转换
        Calendar c1 = Calendar.getInstance();
        DateTime dt2 = new DateTime(c1);
        System.out.println(dt2.toString());

        Calendar c2 = dt2.toCalendar(null);  // 默认时区Asia/Shanghai
        System.out.println(c2.getTimeZone());

        // 时间格式化
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dt3 = DateTime.parse("2016-08-29 13:32:33", formatter);
        System.out.println(dt3.toString());
        // 若是不指定格式,会采用默认的格式,yyyy-MM-ddTHH:mm:ss.SSS,若被解析字符串只到年月日,后面的时分秒会全部默认为0
        DateTime dt4 = DateTime.parse("2016-08-29T");
        System.out.println(dt4.toString());
        // 输出locale 输出2016年08月29日 16:43:14 星期一
        System.out.println(new DateTime().toString("yyyy年MM月dd日 HH:mm:ss EE", Locale.CHINESE));

        // 计算两个日期间隔的天数
        LocalDate start = new DateTime().toLocalDate();
        LocalDate end = new LocalDate(2016, 8, 25);
        System.out.println(Days.daysBetween(start ,end).getDays()); // 这里要求start必须早于end,否则计算出来的是个负数
        // 相同的还有间隔年数、月数、小时数、分钟数、秒数等计算
        // 类如Years、Hours等

        // 对日期的加减操作
        DateTime dt5 = new DateTime();
        dt5 = dt5.plusYears(1)          // 增加年
                .plusMonths(1)          // 增加月
                .plusDays(1)            // 增加日
                .minusHours(1)          // 减小时
                .minusMinutes(1)        // 减分钟
                .minusSeconds(1);       // 减秒数
        System.out.println(dt5.toString());

        // 判断是否闰月
        DateTime dt6 = new DateTime();
        DateTime.Property month = dt6.monthOfYear();
        System.out.println(month.isLeap());

    }

}
