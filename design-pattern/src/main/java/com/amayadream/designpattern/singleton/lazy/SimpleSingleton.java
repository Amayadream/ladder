package com.amayadream.designpattern.singleton.lazy;

/**
 * 简单单例(懒汉式)
 * 优点: 实现简单, 能实现延迟加载
 * 缺点: 线程不安全
 * @author :  Amayadream
 * @date :  2017.10.17 22:10
 */
public class SimpleSingleton {

    private static SimpleSingleton instance = null;

    private SimpleSingleton() {

    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

}
