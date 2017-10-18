package com.amayadream.designpattern.singleton.lazy;

/**
 * 单例模式(懒汉式), 主要利用静态内部类来实现延迟加载
 * 优点: 线程安全, 延迟加载
 * 缺点: 代码较为复杂
 * @author :  Amayadream
 * @date :  2017.10.18 21:41
 */
public class StaticInnerClassSingleton {

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {

    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
