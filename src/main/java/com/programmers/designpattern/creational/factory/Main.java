package com.programmers.designpattern.creational.factory;

import com.programmers.designpattern.creational.factory.framework.Factory;
import com.programmers.designpattern.creational.factory.framework.Product;
import com.programmers.designpattern.creational.factory.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product idCard1 = factory.create("Zlatan");
        Product idCard2 = factory.create("Son");
        Product idCard3 = factory.create("Messi");
        idCard1.use();
        idCard2.use();
        idCard3.use();
    }
}
