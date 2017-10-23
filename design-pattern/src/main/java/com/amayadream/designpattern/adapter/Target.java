package com.amayadream.designpattern.adapter;

/**
 * 目标抽象类
 * @author :  Amayadream
 * @date :  2017.10.23 21:55
 */
public interface Target {

    /**
     * Adaptee具有的方法
     */
    void operation1();

    /**
     * Adaptee没有的方法
     */
    void operation2();

}
