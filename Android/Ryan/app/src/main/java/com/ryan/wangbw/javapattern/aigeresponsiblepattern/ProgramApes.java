package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-19
 * Time: 10:41
 * Desc: 程序猿抽象接口
 */
public abstract class ProgramApes {
    /**
     * 获取程序员具体的差旅费用
     *
     * @return 要多少钱
     */
    public abstract int getExpenses();

    /**
     * 获取差旅费申请
     *
     * @return Just a request
     */
    public abstract String getApply();
}
