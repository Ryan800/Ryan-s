package com.ryan.wangbw.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * author: wangbw
 * Date: 2015-12-09
 * Time: 19:52
 * Desc: InputStreamReader byte解析为char
 *       OutputStreamWriter
 */
public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream("demo/imooc.txt");
        InputStreamReader isr = new InputStreamReader(in, "utf-8");  //默认项目编码

        FileOutputStream out = new FileOutputStream("demo/imoocutf-81.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");

        /*int c;
        while ((c = isr.read()) != -1) {
            System.out.print((char) c);
        }*/

        char[] buffer = new char[8*1024];
        int count ;
        while ((count = isr.read(buffer, 0, buffer.length))!=-1) {
            String s = new String(buffer, 0, count);
            System.out.print(s);
            osw.write(buffer, 0, count);
            osw.flush();
        }

        in.close();
        isr.close();
        out.close();
        osw.close();
    }
}
