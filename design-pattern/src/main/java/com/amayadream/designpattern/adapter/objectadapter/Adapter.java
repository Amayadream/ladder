package com.amayadream.designpattern.adapter.objectadapter;

import com.amayadream.designpattern.adapter.Adaptee;
import com.amayadream.designpattern.adapter.Target;

/**
 * 对象适配器
 * @author :  Amayadream
 * @date :  2017.10.23 22:01
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void operation1() {
        adaptee.operation1();
    }

    @Override
    public void operation2() {
        System.out.println("this is operation2");
    }

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.operation1();
        adapter.operation2();
    }

}
