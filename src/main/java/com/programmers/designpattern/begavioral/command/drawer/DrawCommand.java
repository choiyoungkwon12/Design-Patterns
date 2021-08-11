package com.programmers.designpattern.begavioral.command.drawer;

import com.programmers.designpattern.begavioral.command.command.Command;

import java.awt.*;

public class DrawCommand implements Command {

    // 그림 그리는 대상
    protected Drawable drawable;

    // 그림 그리는 위치
    private Point position;

    // 생성자
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
