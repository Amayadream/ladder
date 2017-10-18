package com.amayadream.designpattern.singleton.hungry;

/**
 * 单例模式(饿汉式), 主要利用Java的Classloader机制
 * 优点: 实现简单, 天生线程安全
 * 缺点: 在单例类被加载时就实例化并持有自身引用, 无法实现延迟加载
 * @author :  Amayadream
 * @date :  2017.10.17 22:23
 */
public class ClassloaderSingleton {

    private static ClassloaderSingleton instance = new ClassloaderSingleton();

    private ClassloaderSingleton() {

    }

    public static ClassloaderSingleton getInstance() {
        return instance;
    }

}
