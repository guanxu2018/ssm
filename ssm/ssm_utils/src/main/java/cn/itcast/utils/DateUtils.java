package cn.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date getDate(String date,String patt) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date d = sdf.parse(date);
        return d;
    }

    public static String getString(Date date,String patt) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
}
