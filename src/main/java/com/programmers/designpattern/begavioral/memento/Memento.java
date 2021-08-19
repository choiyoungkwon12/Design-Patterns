package com.programmers.designpattern.begavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    int money;                                      // 소지금
    ArrayList<String> fruits;                       // 과일

    public Memento(int money) {                     // 생성자 (wide Interface)
        this.money = money;
        this.fruits = new ArrayList<String>();
    }

    public int getMoney() {                         // 소지금을 얻는다 (narrow Interface)
        return money;
    }

    List<String> getFruits() {                      // 과일을 얻는다(wide Interface)
        return fruits;
    }

    void addFruit(String fruit) {                   // 과일을 추가한다(wide Interface)
        fruits.add(fruit);
    }


}
