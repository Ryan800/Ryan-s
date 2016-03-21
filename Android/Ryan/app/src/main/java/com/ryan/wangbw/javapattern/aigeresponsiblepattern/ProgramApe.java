package com.ryan.wangbw.javapattern.aigeresponsiblepattern;

/**
 * author: wangbw
 * Date: 2015-12-22
 * Time: 09:23
 * Desc:
 */
public class ProgramApe {
    private int expenses;
    private String apply = "爹要点钱出差";

    public ProgramApe(int expenses) {
        this.expenses = expenses;
    }

    public int getExpenses() {
        return expenses;
    }

    public String getApply() {
        return  apply;
    }
}
