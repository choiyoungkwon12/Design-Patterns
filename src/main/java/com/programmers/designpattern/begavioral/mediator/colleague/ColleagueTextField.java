package com.programmers.designpattern.begavioral.mediator.colleague;

import com.programmers.designpattern.begavioral.mediator.mediator.Mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener,Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns){
        super(text,columns);
    }

    // Mediator 저장
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 유효/무효를 지시
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.WHITE : Color.lightGray);
    }


    // 문자열이 변하면 Mediator에게 통지
    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}
