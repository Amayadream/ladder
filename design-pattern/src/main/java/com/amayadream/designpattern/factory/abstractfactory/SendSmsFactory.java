package com.amayadream.designpattern.factory.abstractfactory;

import com.amayadream.designpattern.factory.Sender;
import com.amayadream.designpattern.factory.SmsSender;

/**
 * @author :  Amayadream
 * @date :  2017.10.17 21:47
 */
public class SendSmsFactory implements Provider {

    @Override
    public Sender produce() {
        return new SmsSender();
    }

}
