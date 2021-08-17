package com.programmers.designpattern.begavioral.mediator.colleague;

import com.programmers.designpattern.begavioral.mediator.mediator.Mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener,Colleague {
    private Mediator mediator;
    public ColleagueCheckbox(String caption, CheckboxGroup group,boolean state){
        super(caption,group,state);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    // 상태가 바뀌면 Mediator에게 통지
    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}
