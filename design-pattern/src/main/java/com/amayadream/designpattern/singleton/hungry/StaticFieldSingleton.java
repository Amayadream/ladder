package com.amayadream.designpattern.singleton.hungry;

/**
 * 单例模式(饿汉式), 主要利用Java的静态域
 * 优点: 实现简单, 天生线程安全
 * 缺点: 在单例类被加载后就实例化并持有自身引用, 无法实现延迟加载
 * @author :  Amayadream
 * @date :  2017.10.18 21:33
 */
public class StaticFieldSingleton {

    private static StaticFieldSingleton instance = null;

    static {
        instance = new StaticFieldSingleton();
    }

    private StaticFieldSingleton() {

    }

    public static StaticFieldSingleton getInstance() {
        return instance;
    }

}
