package com.programmers.designpattern.begavioral.cor.handler;

import com.programmers.designpattern.begavioral.cor.Trouble;

public abstract class Support {
    private final String name;    // 트러블 해결자 이름
    private Support next;  // 떠넘기는 곳

    public Support(String name) {
        this.name = name;
    }

    // 위임할 곳 지점
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        }else if(next != null){
            next.support(trouble);
        }else{
            fail(trouble);
        }
    }

    // 미해결
    protected void fail(Trouble trouble){
        System.out.println(trouble + " cannot be resolved");
    }

    @Override
    public String toString() {
        return "[" + name + ']';
    }

    // 해결 됐을 때
    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected abstract boolean resolve(Trouble trouble);
}
