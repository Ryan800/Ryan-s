package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-19
 * Time: 10:42
 * Desc: Android程序猿类
 */
public class AndroidApe extends ProgramApes {

    private int expenses;
    private String apply = "爹要点钱出差";

    public AndroidApe(int expenses) {
        this.expenses = expenses;
    }

    @Override
    public int getExpenses() {
        return expenses;
    }

    @Override
    public String getApply() {
        return apply;
    }
}
