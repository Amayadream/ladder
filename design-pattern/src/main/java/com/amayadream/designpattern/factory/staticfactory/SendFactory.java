package com.amayadream.designpattern.factory.staticfactory;

import com.amayadream.designpattern.factory.MailSender;
import com.amayadream.designpattern.factory.Sender;
import com.amayadream.designpattern.factory.SmsSender;

/**
 * 静态工厂模式
 * 优点: 在简单工厂模式/多方法工厂模式基础上将工厂方法静态化, 便于调用
 * 缺点: 工厂方法的通用缺陷, 即拓展必须修改工厂类(实际上我觉得一般情况下可以接受)
 * @author :  Amayadream
 * @date :  2017.10.17 21:44
 */
public class SendFactory {

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.send();
    }

}
