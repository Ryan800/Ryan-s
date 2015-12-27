package com.ryan.wangbw.javapattern.abstractfactory;

/**
 * @author wangbw
 * @desc MAC系统下图像编辑器的实现
 * @date 2015/10/29.
 */
public class MacImageEditor extends ImageEditor {
    @Override
    public void edit() {
        System.out.println("图片处理编辑器，edit -- Mac版");
    }

    @Override
    public void save() {
        System.out.println("图片处理编辑器，save -- Mac版");
    }
}
