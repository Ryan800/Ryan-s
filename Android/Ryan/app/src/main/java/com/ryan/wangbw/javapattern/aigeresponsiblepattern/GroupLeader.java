package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-22
 * Time: 09:14
 * Desc: 小组长类
 */
public class GroupLeader extends Leader {

    public GroupLeader() {
        super(1000);
    }

    @Override
    protected void reply(ProgramApe ape) {
        System.out.println(ape.getApply());
        System.out.println("GroupLeader: Of course Yes!");
    }
}
