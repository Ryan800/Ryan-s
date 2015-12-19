package com.ryan.wangbw.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: wangbw
 * Date: 2015-12-11
 * Time: 16:19
 * Desc:
 */
public class Demo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("22bb23");
//        System.out.println(matcher.matches());
//
//        System.out.println(matcher.lookingAt());
//        System.out.println(matcher.group());

        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }

}
