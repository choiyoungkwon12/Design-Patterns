package com.programmers.designpattern.structural.bridge;

import com.programmers.designpattern.structural.bridge.function.CountDisplay;
import com.programmers.designpattern.structural.bridge.function.Display;
import com.programmers.designpattern.structural.bridge.implement.StringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(new StringDisplayImpl("Hello, Korea."));
        Display display2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        CountDisplay display3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));

        display1.display();
        display2.display();
        display3.display();
        display3.multiDisplay(5);

    }
}
