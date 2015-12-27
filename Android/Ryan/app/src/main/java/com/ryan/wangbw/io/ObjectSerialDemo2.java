package com.ryan.wangbw.io;

import java.io.Serializable;

/**
 * author: wangbw
 * Date: 2015-12-09
 * Time: 21:38
 * Desc: 对子类
 */
public class ObjectSerialDemo2 {
    public static void main(String[] args) {
        Foo2 foo2 = new Foo2();
    }
}

class Foo implements Serializable {
    public Foo() {
        System.out.println("foo....");
    }
}

class Foo1 extends Foo {
    public Foo1() {
        super();
        System.out.println("foo1...");
    }
}

class Foo2 extends Foo1 {
    public Foo2() {
        System.out.println("foo2...");
    }
}
