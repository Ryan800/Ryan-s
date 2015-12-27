package com.ryan.wangbw.io;

import java.io.File;
import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 20:23
 * Desc:
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:\\files\\imooc");
        System.out.println(file.exists());
        if (!file.exists()) {
            file.mkdir();
        } else {
            file.delete();
        }
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

//        File file2 = new File("d:\\files\\日记1.txt");
        File file2 = new File("D:\\files", "riji1.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file2.delete();
        }
        System.out.println(file);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
    }
}
