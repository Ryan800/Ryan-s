package com.ryan.wangbw.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 21:59
 * Desc:
 */
public class DosDisDemo {
    public static void main(String[] args) throws IOException{
        String file = "demo/dos.dat";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        dos.writeUTF("中国");
        //采用utf-16be编码写出
        dos.writeChars("中国");
        dos.close();


        DataInputStream dis = new DataInputStream(new FileInputStream(file));

        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        String s1 = dis.readUTF();
        System.out.println(s1);
        dis.close();
    }
}
