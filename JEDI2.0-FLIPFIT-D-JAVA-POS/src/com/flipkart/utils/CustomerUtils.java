package com.flipkart.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CustomerUtils {

    public static void showCurrentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime-->" + localDateTime);
    }

}
