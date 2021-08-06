package com.programmers.designpattern.begavioral.cor;

public class NoSupport extends Support{

    public NoSupport(String name) {
        super(name);
    }

    // 이 클래스는 아무것도 처리하지 않는다.
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
