package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-22
 * Time: 09:16
 * Desc:
 */
public class Director extends Leader {
    public Director() {
        super(5000);
    }

    @Override
    protected void reply(ProgramApe ape) {
        System.out.println(ape.getApply());
        System.out.println("Director: Of course Yes!");
    }
}
