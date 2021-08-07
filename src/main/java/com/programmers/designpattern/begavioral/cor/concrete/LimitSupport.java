package com.programmers.designpattern.begavioral.cor.concrete;

import com.programmers.designpattern.begavioral.cor.Trouble;
import com.programmers.designpattern.begavioral.cor.handler.Support;

public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}
