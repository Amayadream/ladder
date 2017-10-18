package com.amayadream.designpattern.singleton.hungry;

/**
 * 单例模式(饿汉式)
 * 优点: 实现简单, 天生线程安全
 * 缺点: 在单例类被加载时就实例化并持有自身引用, 无法实现延迟加载
 * @author :  Amayadream
 * @date :  2017.10.17 22:23
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
