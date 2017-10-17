package com.amayadream.designpattern.factory.multi;

import com.amayadream.designpattern.factory.MailSender;
import com.amayadream.designpattern.factory.Sender;
import com.amayadream.designpattern.factory.SmsSender;

/**
 * 工厂模式(多方法)
 * 优点: 相比较简单工厂模式更优雅, 降低硬编码或null的可能性, 利于调用
 * 缺点: 需要创建factory实体(可以通过将produce改为静态方法优化)
 * @author :  Amayadream
 * @date :  2017.10.17 21:43
 */
public class SendFactory {

    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }

}
