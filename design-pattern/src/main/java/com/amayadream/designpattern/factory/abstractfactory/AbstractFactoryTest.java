package com.amayadream.designpattern.factory.abstractfactory;

import com.amayadream.designpattern.factory.Sender;

/**
 * 抽象工厂模式
 * 优点: 在工厂模式的基础上将工厂类也抽象出接口, 可以在无修改原先代码的基础上拓展程序, 符合开闭原则
 * 缺点: 过于复杂, 在简单应用中强套抽象工厂模式有滥用设计模式的嫌疑
 * @author :  Amayadream
 * @date :  2017.10.17 21:48
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }

}
