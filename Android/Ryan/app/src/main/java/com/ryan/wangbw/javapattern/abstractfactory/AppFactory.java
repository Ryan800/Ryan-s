package com.ryan.wangbw.javapattern.abstractfactory;

/**
 * @author wangbw
 * @desc 应用软件抽象工厂
 * @date 2015/10/29.
 */
public abstract class AppFactory {
    public abstract TextEditor createTextEditor();

    public abstract ImageEditor createImageEditor();
}
