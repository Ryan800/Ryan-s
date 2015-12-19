package com.ryan.wangbw.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * author: wangbw
 * Date: 2015-12-09
 * Time: 21:20
 * Desc:
 */
public class Student implements Serializable{
    private String stuno;
    private String stuname;
    private transient int stuage;   //该元素不会进行jvm默认的序列化，也可以自己完成这个元素的序列化

    public Student() {}

    public Student(String stuno, String stuname, int stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public String getStuno() {

        return stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public int getStuage() {
        return stuage;
    }


    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(stuage);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.stuage = s.readInt();  //自己完成反序列化操作
    }
}
