package com.amayadream.designpattern.template;

/**
 * @author :  Amayadream
 * @date :  2017.10.19 22:10
 */
public abstract class AbstractSender {

    protected boolean isSend() {
        return false;
    }

    public abstract String getMessage();

    public void send() {
        if (isSend()) {
            String message = getMessage();
            System.out.println(message);
        }
    }

}
