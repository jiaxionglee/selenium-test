package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiaxiong on 2019-02-24 15:39
 */
public class DateUtil {

    public static String getTime() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss:SSS");
        return format.format(date);
    }
}
