package com.dimdark.cn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理日期(主要是商品的生产日期)的工具类<br/>
 * @author dimdark
 * @date 2017-03-28
 * @time 11:09 PM
 */
public class DateUtil {

    private static SimpleDateFormat format = new SimpleDateFormat("E yyyy-MM-dd HH:mm");

    /**
     * 解析字符串得到对应格式的日期对象<br/>
     * 若解析出错则会向上抛出异常ParseException<br/>
     * 注意:该方法是同步的,因此在多个线程调用该解析方法时并不会
     * 出现解析后格式错误的现象<br/>
     * @param pattern String 日期的指定格式的字符串形式
     * @return date Date 日期的指定格式
     * @throws ParseException
     */
    public static Date parse(String pattern) throws ParseException{
        synchronized (format){
            Date date = format.parse(pattern);
            return date;
        }
    }

    /**
     * 将日期对象转换为指定格式(EEE yyyy-MM-dd HH:mm)的字符串<br/>
     * 当日期对象错误(如:为null时)会向上抛出异常ParseException<br/>
     * @param date 日期对象
     * @return s String 日期对应的指定格式的字符串
     * @throws ParseException 日期对象为null时抛出该异常
     */
    public static String formatDate(Date date) throws ParseException{
        synchronized (format){
            String s = format.format(date);
            return s;
        }
    }

}
