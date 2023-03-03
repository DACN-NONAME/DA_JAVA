/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noname.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author phatv
 */
public class Utils {

    public static String TZ = "Asia/Ho_Chi_Minh";
    public static String DB_MYSQL = "jdbc:mysql://pma.phatnef.me/phatdevx_dat_ve_phim?user=phatdevx_noname&password=Noname@2023&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    public static int LIMIT_ROWS = 10;

    public static int Page(String page) {
        try {
            int p = Integer.parseInt(page);
            if (p < 1) {
                p = 1;
            }
            return p;
        } catch (NumberFormatException ex) {
            return 1;
        }
    }

    public static String Offset(int page, int limit) {
        if (limit == 0) {
            return "";
        }
        if (page < 1) {
            page = 1;
        }
        return " LIMIT " + ((page - 1) * limit) + "," + limit;
    }

    public static String Offset(int page) {
        return Offset(page, LIMIT_ROWS);
    }

    public static String SHA1(String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String StrDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String StrDate(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
