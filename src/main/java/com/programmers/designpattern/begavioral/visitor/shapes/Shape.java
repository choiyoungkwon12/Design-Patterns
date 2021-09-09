package com.programmers.designpattern.begavioral.visitor.shapes;

import com.programmers.designpattern.begavioral.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}