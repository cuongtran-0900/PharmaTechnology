/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmatechno.Control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hongo
 */

public class Xdate {
    // Định dạng mặc định
    private static final String DEFAULT_FORMAT = "dd/MM/yyyy";
    static SimpleDateFormat formater = new SimpleDateFormat(DEFAULT_FORMAT);

    /**
     * Chuyển đổi String sang Date
     * @param date là String cần chuyển
     * @param pattern là định dạng thời gian
     * @return Date kết quả
     */
    public static Date toDate(String date, String pattern) {
        try {
            formater.applyPattern(pattern);
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Chuyển đổi String sang Date với định dạng mặc định
     * @param date là String cần chuyển
     * @return Date kết quả
     */
    public static Date toDate(String date) {
        try {
            return formater.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Chuyển đổi từ Date sang String với định dạng tùy chỉnh
     * @param date là Date cần chuyển đổi
     * @param pattern là định dạng thời gian
     * @return String kết quả
     */
    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    /**
     * Chuyển đổi từ Date sang String với định dạng mặc định
     * @param date là Date cần chuyển đổi
     * @return String kết quả
     */
    public static String toString(Date date) {
        return toString(date, DEFAULT_FORMAT);
    }

    /**
     * Lấy thời gian hiện tại 
     * @return Date kết quả   
     */
    public static Date now() { 
        return new Date();
    } 

    /**
     * Bổ sung số ngày vào thời gian
     * @param date thời gian hiện có
     * @param days số ngày cần bổ sung vào date
     * @return Date kết quả
     */
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    /**
     * Bổ sung số ngày vào thời gian hiện tại
     * @param days số ngày cần bổ sung vào thời gian hiện tại
     * @return Date kết quả
     */
    public static Date add(int days) {
        Date now = Xdate.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }
}
