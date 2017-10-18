package com.amayadream.designpattern.singleton.hungry;

/**
 * 单例模式(枚举)
 * 优点: 1.线程安全 2.实现简单 3.JVM保证单个实例(在反序列化/反射等情况下)
 * 缺点: 不常见
 * @author :  Amayadream
 * @date :  2017.10.18 21:51
 */
public enum EnumSingleton {

    INSTANCE;

    public void doSomething() {
        EnumSingleton.INSTANCE.doSomething();
    }

}
