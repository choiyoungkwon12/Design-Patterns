package com.programmers.designpattern.begavioral.cor;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("bob",100);
        Support charlie = new SpecialSupport("charlie",429);
        Support diana = new LimitSupport("diana",200);
        Support elmo = new OddSupport("elmo");
        Support fred = new LimitSupport("fred",300);

        // 사슬 형성
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        // 다양한 트러블 발생
        for (int i = 0; i < 500; i++) {
            alice.support(new Trouble(i));
        }


    }
}
