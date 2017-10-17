package com.amayadream.designpattern.factory;

/**
 * @author :  Amayadream
 * @date :  2017.10.17 21:37
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is mail sender!");
    }

}
