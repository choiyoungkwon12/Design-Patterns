package com.programmers.designpattern.begavioral.cor;

/**
 * 발생한 트러블을 표현하는 클래스.
 * number는 트러블 번호입니다.
 */

public class Trouble {
    private int number;

    public Trouble(int number) { // 트러블 생성
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public String toString() {
        return "[Trouble " + number + "]";
    }
}
