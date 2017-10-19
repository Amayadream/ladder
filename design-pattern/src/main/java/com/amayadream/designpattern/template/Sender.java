package com.amayadream.designpattern.template;

/**
 * @author :  Amayadream
 * @date :  2017.10.19 22:27
 */
public class Sender extends AbstractSender {

    @Override
    public String getMessage() {
        return "hello, world";
    }

    @Override
    protected boolean isSend() {
        return true;
    }

    public static void main(String[] args) {
        AbstractSender sender = new Sender();
        sender.send();
    }


}
