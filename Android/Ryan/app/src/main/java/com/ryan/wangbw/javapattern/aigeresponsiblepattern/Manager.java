package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-22
 * Time: 09:17
 * Desc:
 */
public class Manager extends Leader {
    public Manager() {
        super(10000);
    }

    @Override
    protected void reply(ProgramApe ape) {
        System.out.println(ape.getApply());
        System.out.println("Manager：Of course Yes!");
    }
}
