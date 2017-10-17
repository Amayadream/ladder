package com.amayadream.designpattern.factory;

/**
 * @author :  Amayadream
 * @date :  2017.10.17 21:38
 */
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is sms sender!");
    }

}
