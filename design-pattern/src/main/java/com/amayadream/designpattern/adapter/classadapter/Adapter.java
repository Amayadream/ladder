package com.amayadream.designpattern.adapter.classadapter;

import com.amayadream.designpattern.adapter.Adaptee;
import com.amayadream.designpattern.adapter.Target;

/**
 * 类适配器
 * @author :  Amayadream
 * @date :  2017.10.23 21:57
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void operation2() {
        System.out.println("this is operation2");
    }

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.operation1();
        adapter.operation2();
    }

}
