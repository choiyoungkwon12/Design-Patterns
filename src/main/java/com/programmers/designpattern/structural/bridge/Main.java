package com.programmers.designpattern.structural.bridge;

import com.programmers.designpattern.structural.bridge.function.CountDisplay;
import com.programmers.designpattern.structural.bridge.function.Display;
import com.programmers.designpattern.structural.bridge.implement.HyphenStringDisplayImpl;
import com.programmers.designpattern.structural.bridge.implement.EqualsStringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        Display display = new Display(new HyphenStringDisplayImpl("Hello, Korea."));
        Display display1 = new Display(new EqualsStringDisplayImpl("Hello, Korea."));
        Display display2 = new CountDisplay(new HyphenStringDisplayImpl("Hello, World."));
        CountDisplay display3 = new CountDisplay(new HyphenStringDisplayImpl("Hello, Universe."));

        display.display();
        display1.display();
        display2.display();
        display3.display();
        display3.multiDisplay(5);

    }
}
