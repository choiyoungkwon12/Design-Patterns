package com.programmers.designpattern.structural.adapter.instance;

import com.programmers.designpattern.structural.adapter.Banner;
import com.programmers.designpattern.structural.adapter.instance.Print;

public class PrintBanner extends Print {

    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
