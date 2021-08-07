package com.programmers.designpattern.creational.factory.idcard;

import com.programmers.designpattern.creational.factory.framework.Factory;
import com.programmers.designpattern.creational.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {

    private List<String> owners = new ArrayList<>();

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    public List<String> getOwners() {
        return owners;
    }
}
