package com.amayadream.designpattern.adapter.interfaceadapter;

import com.amayadream.designpattern.adapter.Target;

/**
 * @author :  Amayadream
 * @date :  2017.10.24 22:21
 */
public class SampleTest {

    public static void main(String[] args) {
        Target target1 = new Wrapper1();
        Target target2 = new Wrapper2();
        target1.operation1();
        target1.operation2();
        target2.operation1();
        target2.operation2();
    }

}
