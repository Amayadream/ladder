package com.amayadream.designpattern.singleton.lazy;

/**
 * 同步单例模式(饿汉式)
 * 优点: 相比较基础的饿汉式单例而言, 具有了线程安全的特性
 * 缺点: 同步方法粒度太大, 性能较差
 * @author :  Amayadream
 * @date :  2017.10.17 22:40
 */
public class SyncSingleton {

    private static SyncSingleton instance = null;

    private SyncSingleton() {

    }

    public static synchronized SyncSingleton getInstance() {
        if (instance == null) {
            instance = new SyncSingleton();
        }
        return instance;
    }

}
