package com.amayadream.designpattern.singleton.lazy;

/**
 * 双重检查单例(饿汉式)
 * 优点: 相比较同步方法控制了加锁粒度, 性能比较好
 * 缺点: 单例引用对象需要用volatile修饰, 这种安全隐患可能很难排查
 * @author :  Amayadream
 * @date :  2017.10.17 22:46
 */
public class DoubleCheckSingleton {

    //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
