package com.ryan.wangbw.test2;

/**
 * author: wangbw
 * Date: 2015-12-07
 * Time: 09:47
 * Desc:
 */
public abstract class FootballMan extends Man{

    public int id;
    private String name;

    public void go() {
        System.out.println("footballman:go()");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
