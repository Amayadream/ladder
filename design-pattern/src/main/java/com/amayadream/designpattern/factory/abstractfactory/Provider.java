package com.amayadream.designpattern.factory.abstractfactory;

import com.amayadream.designpattern.factory.Sender;

/**
 * @author :  Amayadream
 * @date :  2017.10.17 21:46
 */
public interface Provider {

    Sender produce();

}
