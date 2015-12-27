package com.ryan.wangbw.javapattern.abstractfactory;

/**
 * @author wangbw
 * @desc 具体工厂，创建各种应用，这里为文本编辑器和图像编辑器
 * @date 2015/10/29.
 */
public class MacAppFactory extends AppFactory {
    @Override
    public TextEditor createTextEditor() {
        return new MacTextEditor();
    }

    @Override
    public ImageEditor createImageEditor() {
        return new MacImageEditor();
    }
}
