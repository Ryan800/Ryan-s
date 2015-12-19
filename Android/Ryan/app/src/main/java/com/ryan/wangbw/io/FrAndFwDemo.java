package com.ryan.wangbw.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-09
 * Time: 21:04
 * Desc:
 */
public class FrAndFwDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("demo/imooc.txt");
        FileWriter fw = new FileWriter("demo/imooc3.txt", true);
        char[] buffer = new char[2056];
        int count;
        while((count = fr.read(buffer, 0, buffer.length))!=-1) {
            fw.write(buffer, 0, count);
            fw.flush();
        }

        fr.close();
        fw.close();
    }
}
