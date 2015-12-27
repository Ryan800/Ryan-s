package com.ryan.wangbw.io;

import java.io.File;
import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 21:54
 * Desc:
 */
public class IOUtilTest {
    public static void main(String[] args) throws IOException{
        long start = System.currentTimeMillis();
        IOUtil.copyFileByByte(new File("d:/test.rar"), new File("d:/test2.rar"));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
//        IOUtil
    }
}
