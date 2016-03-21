package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-22
 * Time: 08:59
 * Desc: leader抽象类
 */
public abstract class Leader {

    private int expenses;
    private Leader mSuperiorLeader; //上级领导

    public Leader(int expenses) {
        this.expenses = expenses;
    }

    /**
     * 回应程序猿
     * @param ape
     */
    protected  abstract void reply(ProgramApe ape);

    /**
     * 处理请求
     * @param ape
     */
    public void handleRequest(ProgramApe ape) {
        if (ape.getExpenses() <= expenses) {
            reply(ape);
        } else {
            if (null != mSuperiorLeader) {
                mSuperiorLeader.handleRequest(ape);
            } else {
                System.out.println("Goodbye my money ...... ");
            }
        }
    }

    /**
     * 为当前领导设置一个上级领导
     * @param superiorLeader
     */
    public void setLeader(Leader superiorLeader) {
        this.mSuperiorLeader = superiorLeader;
    }

}
