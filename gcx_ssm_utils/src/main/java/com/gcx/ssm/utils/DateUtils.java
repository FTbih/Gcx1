package com.gcx.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期转换成字符串
    public static String date2String(Date date){
        return date.toString();
    }
    //字符串转换成日期
    public static Date string2Date(String departureTimeStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(departureTimeStr);
        return date;
    }
}
