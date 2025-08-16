package org.example.web;

import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class Test {
    public static void main(String[] args) {
        String str2 = "UTC2";
        String timed;
        try {

            String normalized = str2.replace("UTC", "").replace("GMT", "");
            System.out.println(normalized);
            ZoneOffset offset = ZoneOffset.of(normalized); // умеет парсить "+02", "-05", "+02:30"
            System.out.println(offset);
            OffsetTime time = OffsetTime.now(offset);
            timed = time.toString();

        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid timezone format: " + str2);
        }


        System.out.println(timed);
    }
    }

