package com.programmers.designpattern.begavioral.command.drawer;

import com.programmers.designpattern.begavioral.command.command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {

    // 그림 그리는 색
    private Color color = Color.red;

    // 그림 그리는 점의 변경
    private int radius = 6;

    // 이력
    private MacroCommand history;

    // 폭, 높이, 그림 내용(history)을 받아서 DrawCanvas의 인스턴스를 초기화
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 이력 전체 다시 그리기
    // 이 DrawCanvas를 다시 그릴 필요가 생겼을 때 java.awt 프레임워크로부터 호출되는 메서드입니다.
    // 실행하는 처리는 history에 기록되어 있는 명령의 집합이 재실행됩니다.
    public void paint(Graphics g) {
        history.execute();
    }


    // Drawable 인터페이스 구현
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        // 점 색깔 지정
        g.setColor(color);

        // 점의 크기(원을 표시)
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
