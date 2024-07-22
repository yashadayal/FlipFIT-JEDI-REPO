package com.flipkart.utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CustomerUtils {

    /**
     * Method for showing current date and time
     */
    public static void showCurrentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime-->" + localDateTime);
    }

}
