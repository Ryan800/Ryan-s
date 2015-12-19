package com.ryan.wangbw.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * author: wangbw
 * Date: 2015-12-09
 * Time: 21:22
 * Desc:
 */
public class ObjectSerialDemo1 {
    public static void main(String[] args) throws IOException{
        String file = "demo/obj.dat";
        //1.对象序列化
       /* ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student stu = new Student("10001", "张三", 20);
        oos.writeObject(stu);
        oos.flush();
        oos.close();*/

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        try {
            Student stu = (Student) ois.readObject();
            System.out.println(stu);
            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
