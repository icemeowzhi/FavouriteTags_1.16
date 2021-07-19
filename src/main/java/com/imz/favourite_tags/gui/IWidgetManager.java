package com.imz.favourite_tags.gui;

import com.imz.favourite_tags.gui.widget.IWidget;
import com.mojang.blaze3d.matrix.MatrixStack;

import java.util.List;

/*
一个实现组件批量添加的接口。
实现这个接口的类需要继承Screen，需要维护一个组件列表。
在构造方法中构造组件的实例。
将initAll()放入render()方法中。
 */
public interface IWidgetManager {

    List<IWidget> getWidgets();

    default void initAll(MatrixStack matrixStack){
        for (IWidget widget:getWidgets()){
            widget.init(matrixStack);
        }
    }

}
