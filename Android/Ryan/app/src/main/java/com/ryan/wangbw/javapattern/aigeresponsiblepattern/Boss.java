package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-22
 * Time: 09:18
 * Desc:
 */
public class Boss extends Leader {
    public Boss() {
        super(40000);
    }

    @Override
    protected void reply(ProgramApe ape) {
        System.out.println(ape.getApply());
        System.out.println("Boss: Of course Yes!");
    }
}
