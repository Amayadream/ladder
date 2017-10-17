package com.amayadream.designpattern.factory.abstractfactory;

import com.amayadream.designpattern.factory.MailSender;
import com.amayadream.designpattern.factory.Sender;

/**
 * @author :  Amayadream
 * @date :  2017.10.17 21:47
 */
public class SendMailFactory implements Provider {

    @Override
    public Sender produce() {
        return new MailSender();
    }

}
