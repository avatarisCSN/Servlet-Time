package org.example.web;

import java.time.OffsetTime;
import java.time.ZoneOffset;

public class Parser {
    public static OffsetTime parse(String str){
        String sign = str.contains("+") ? "+" : (str.contains("-") ? "-" : "+");
        String numberPart = str.replaceAll("[^0-9]", ""); // "2"

        int offsetHours = Integer.parseInt(numberPart);
        if (sign.equals("-")) {
            offsetHours = -offsetHours;
        }

        OffsetTime timeWithOffset = OffsetTime.now(ZoneOffset.ofHours(offsetHours));
        System.out.println(timeWithOffset);
        return  timeWithOffset;
    }
}
