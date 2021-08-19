package com.programmers.designpattern.begavioral.memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;                                                              // 소지금
    private List<String> fruits = new ArrayList<>();                                // 과일
    private Random random = new Random();                                           // 난수
    private static String[] fruitsname = {"apple", "banana", "orange", "grape"};    // 과일 이름

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {                                                          // 현재의 소지금 얻음
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        System.out.println("주사위 숫자 : " + dice);
        if (dice == 1) {
            money += 100;
            System.out.println("소지금이 증가했습니다.");
        }else if (dice == 2){
            money /= 2;
            System.out.println("소지금이 절반이 되었습니다.");
        }else if (dice == 6) {
            String f = getFruit();
            System.out.println("과일 (" + f + ")을 받았습니다.");
            fruits.add(f);
        }else{
            System.out.println("변한 것이 없습니다.");
        }
    }

    public Memento createMemento(){
        Memento memento = new Memento(money);
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()){
            String fruit = iterator.next();
            if (fruit.startsWith("맛있는 ")){
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento){
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }

    private String getFruit(){
        return fruitsname[random.nextInt(fruitsname.length)];
    }
}
