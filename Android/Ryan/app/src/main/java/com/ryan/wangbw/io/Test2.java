package com.ryan.wangbw.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 16:39
 * Desc:
 */
public class Test2 {
    public static void main(String[] args) {
        concennateFile("D:/files/copy1.txt");
    }

    public static void concennateFile(String...fileName) {
        String str;
        try {
//            InputStream
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/files/copy2.txt"));
            for (String name:fileName) {
                BufferedReader reader = new BufferedReader(new FileReader(name));
                while ((str =reader.readLine())!=null) {
                    writer.write(str);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
