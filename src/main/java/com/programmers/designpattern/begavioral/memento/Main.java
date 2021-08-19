package com.programmers.designpattern.begavioral.memento;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("====" + i);             // 개수 표시
            System.out.println("현상 : " + gamer);       // 현재 게이머 상태 표시

            gamer.bet();

            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");

            // Memento의 취급 결정
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("돈이 많이 증가했으므로 상태 저장");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("돈이 많이 감소했으므로 상태 복원");
                gamer.restoreMemento(memento);
            }

            Thread.sleep(50);
        }
    }
}
