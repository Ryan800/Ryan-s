package com.ryan.wangbw.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 21:47
 * Desc:
 */
public class FileOutDemo {
    public static void main(String[] args) throws IOException{
        //如果该文件不存在，则直接创建，如果存在，删除后创建
        FileOutputStream out = new FileOutputStream("demo/out.dat");
        out.write('A'); //写出了A的低八位
        out.write('B');
        int a = 10;//
        out.write(a>>>24);
        out.write(a>>>16);
        out.write(a>>>8);
        out.write(a);

        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();
    }
}
