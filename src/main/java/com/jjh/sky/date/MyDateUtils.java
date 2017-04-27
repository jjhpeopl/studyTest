package com.jjh.sky.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by huangshitao on 15/12/17.
 */
public class MyDateUtils {
    public static final int SECONDS_PER_DAY = 60 * 60 * 24;
    public static final int SECONDS_PER_HOUR = 60 * 60;
    public static final long MILLISECONDS_PER_DAY = (long) SECONDS_PER_DAY * 1000;

    public static long getTodayStartTime(long currentTimeMillis) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        calendar.setTimeInMillis(currentTimeMillis);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() / 1000;
    }

    public static long getTodayEndTime(long currentTimeMillis) {
        return getTodayStartTime(currentTimeMillis) + SECONDS_PER_DAY - 1;
    }

    public static long getYesterdayStartTime(long currentTimeMillis) {
        return getTodayStartTime(currentTimeMillis) - SECONDS_PER_DAY;
    }

    public static long getYesterdayEndTime(long currentTimeMillis) {
        return getTodayEndTime(currentTimeMillis) - SECONDS_PER_DAY;
    }

    public static String getDate(long currentTimeMillis) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date now = new Date(currentTimeMillis);
        return df.format(now);
    }

    public static String getDateFormate(long currentTimeMillis) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date(currentTimeMillis);
        return df.format(now);
    }

    public static int getDaysBetween(long fTime, long tTime) {
        //因为是在东八区，所以加八小时做差可以得到整天
        return (int) ((tTime + 8 * SECONDS_PER_HOUR * 1000) / MILLISECONDS_PER_DAY - (fTime + 8 * SECONDS_PER_HOUR * 1000) / MILLISECONDS_PER_DAY);
    }

    public static int daysBetween(Date start, Date end) {
        long statL = start.getTime();
        long endL = end.getTime();
//        return Days.daysBetween(new DateTime(start), new DateTime(end)).getDays();
        return getDaysBetween(statL, endL);
    }

    /**
     * 整点
     * @return
     */
    public static boolean isHourTime(){
        Date d = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
        if( (gc.get(gc.MINUTE)==0) && (gc.get(gc.SECOND)==0) )
            return true;
        else return false;
    }

    public static void main(String[] args) {
        // 得到今天的时间
        long todayTime = System.currentTimeMillis();
        // 得到2016-11-24的时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 24);
        System.out.println(calendar.getTimeInMillis());
        long endTime = calendar.getTimeInMillis();

        System.out.println(getDaysBetween(todayTime, endTime));
    }

}
