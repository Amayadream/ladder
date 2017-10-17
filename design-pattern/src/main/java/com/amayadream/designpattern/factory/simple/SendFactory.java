package com.amayadream.designpattern.factory.simple;

import com.amayadream.designpattern.factory.MailSender;
import com.amayadream.designpattern.factory.Sender;
import com.amayadream.designpattern.factory.SmsSender;

/**
 * 简单工厂模式
 * 优点: 简单, 无须复杂的封装
 * 缺点: 1.可能返回null 2.type可能硬编码或增加多余枚举 3.需要创建factory实体(可以通过将produce改为静态方法优化)
 * @author :  Amayadream
 * @date :  2017.10.17 21:39
 */
public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("mail");
        sender.send();
    }

}
