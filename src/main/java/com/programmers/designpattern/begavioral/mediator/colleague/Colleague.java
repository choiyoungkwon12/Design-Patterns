package com.programmers.designpattern.begavioral.mediator.colleague;

import com.programmers.designpattern.begavioral.mediator.mediator.Mediator;

public interface Colleague {
    public abstract void setMediator(Mediator mediator);


    public abstract void setColleagueEnabled(boolean enabled);
}
