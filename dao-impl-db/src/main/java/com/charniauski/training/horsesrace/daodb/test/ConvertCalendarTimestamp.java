package com.charniauski.training.horsesrace.daodb.test;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConvertCalendarTimestamp {

//    yyyy-mm-dd hh[:mm[:ss[.nnnnnn]]]
//    yyyy-mm-dd-hh[.mm[.ss[.nnnnnn]]]
//    https://www.postgresql.org/docs/8.0/static/functions-formatting.html



    private java.util.Date parseDate(String date) {

        SimpleDateFormat[] possibleFormats = new SimpleDateFormat[]{
                new SimpleDateFormat("yyyy-MM-dd"),
                new SimpleDateFormat("yyyy,MM,dd"),
                new SimpleDateFormat("yyyy,MM,dd,HH,mm"),
                new SimpleDateFormat("yyyy-MM-dd HH-mm"),
                new SimpleDateFormat("yyyy-MM-dd HH:mm")};

        java.util.Date retVal = null;
        for (SimpleDateFormat f : possibleFormats) {
            f.setLenient(false);
            try {
                retVal = f.parse(date);
            } catch (ParseException e) {
            }
        }
        return retVal;
    }

    public static void main(String[] a) throws SQLException {


//            System.out.println(makeTimestamp(2002,02,02,02,02,02,02));
//        }
//
//        public static Timestamp makeTimestamp(int year, int month, int day, int hour, int minute,
//                                              int second, int millisecond) {
//            Calendar cal = new GregorianCalendar();
//            cal.set(Calendar.YEAR, year);
//            cal.set(Calendar.MONTH, month - 1);
//            cal.set(Calendar.DATE, day);
//            cal.set(Calendar.HOUR_OF_DAY, hour);
//            cal.set(Calendar.MINUTE, minute);
//            cal.set(Calendar.SECOND, second);
//            cal.set(Calendar.MILLISECOND, millisecond);
//
//            // now convert GregorianCalendar object to Timestamp object
//            return new Timestamp(cal.getTimeInMillis());
//        }
//
////convert data
//
//    private static final SimpleDateFormat monthDayYearformatter = new SimpleDateFormat(
//            "MMMMM dd, yyyy");
//
//    private static final SimpleDateFormat monthDayformatter = new SimpleDateFormat("MMMMM dd");
//
//    public static String timestampToMonthDayYear(Timestamp timestamp) {
//        if (timestamp == null) {
//            return null;
//        } else {
//            return monthDayYearformatter.format((java.util.Date) timestamp);
//        }
//    }
//
//    public static String timestampToMonthDay(Timestamp timestamp) {
//        if (timestamp == null) {
//            return null;
//        } else {
//            return monthDayformatter.format((java.util.Date) timestamp);
//        }
//    }
//
//    public static Timestamp getTimestamp() {
//        java.util.Date today = new java.util.Date();
//        return new Timestamp(today.getTime());
    }

    }

