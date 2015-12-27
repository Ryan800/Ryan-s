package com.ryan.wangbw.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * author: wangbw
 * Date: 2015-12-09
 * Time: 21:09
 * Desc:
 */
public class BrAndBwOrPwDemo {
    public static void main(String[] args) throws IOException{
        //对文件进行读写操作
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("demo/imooc.txt")));
       /* BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
                ("demo/imooc4.txt")));*/

//        PrintWriter pw = new PrintWriter("demo/imooc5.txt");
        PrintWriter pw1 = new PrintWriter(new FileOutputStream("demo/imooc6.txt"), true);
        String line;
        while ((line = br.readLine())!=null) {
            System.out.println(line);   //一次读一行，不能识别换行符
            /*bw.write(line);
            bw.newLine();   //单独写出换行
            bw.flush();*/
//            pw.println(line);
//            pw.flush();
            pw1.println(line);
        }

        /*bw.close();*/
        br.close();
//        pw.flush();
        pw1.flush();
    }
}
