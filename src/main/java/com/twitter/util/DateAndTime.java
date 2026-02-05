package com.twitter.util;

import java.sql.Date;

public class DateAndTime {
    public  java.sql.Date CurrentDate(){
        java.util.Date date = new java.util.Date();
        Date currentDate = new java.sql.Date(date.getTime());
        return currentDate;
    }
}
