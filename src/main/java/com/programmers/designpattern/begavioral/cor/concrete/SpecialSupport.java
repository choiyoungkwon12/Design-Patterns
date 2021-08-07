package com.programmers.designpattern.begavioral.cor.concrete;

import com.programmers.designpattern.begavioral.cor.Trouble;
import com.programmers.designpattern.begavioral.cor.handler.Support;

public class SpecialSupport extends Support {

    // 이 번호만 해결가능하다.
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number){
            return true;
        }else{
            return false;
        }
    }
}
