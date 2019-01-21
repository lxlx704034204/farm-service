package com.yiyi.farm.jpa;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Kevin.Z on 2018/3/1.
 */
public class Utils {
    public static Date getGTM8() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        return new Date();
    }

    public static Date getBeginTimeOfDay(){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        LocalDate localDate = LocalDate.now();
        return LocalDateToDate(localDate);
    }

    public static Date getEndTimeOfDay(){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(1);
        return LocalDateToDate(localDate);
    }

    private static Date LocalDateToDate(LocalDate localDate){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return date;
    }

    public static Date StringToDate(String stringDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(stringDate);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String replaceLineCharacter(String text) {
        return text.replaceAll("\\r\\n", "<br/>");
    }
}
