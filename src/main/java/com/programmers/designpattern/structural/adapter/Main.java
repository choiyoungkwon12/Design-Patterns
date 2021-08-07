package com.programmers.designpattern.structural.adapter;

import com.programmers.designpattern.structural.adapter.instance.PrintBanner;
import com.programmers.designpattern.structural.adapter.instance.Print;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
