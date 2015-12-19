package com.ryan.wangbw.io;

import java.io.File;
import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 20:31
 * Desc: 列出file类的常用操作比如过滤，遍历等操作
 */
public class FileUtil {
    /**
     * 列出指定目录包括其子目录下的所有文件
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录："+dir+"不存在！");
        }

        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir+"不是目录");
        }

//        String[] fileNames = dir.list();
//        for (String string:fileNames) {
//            System.out.println(dir+"\\"+string);
//        }

        File[] files = dir.listFiles();//返回直接子目录的对象
        if (files!=null && files.length>0) {
            for (File file : files) {
//            System.out.println(file);
                if (file.isDirectory()) {
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }

    }
}
