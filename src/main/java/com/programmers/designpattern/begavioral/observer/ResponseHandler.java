package com.programmers.designpattern.begavioral.observer;

import java.util.Observable;
import java.util.Observer; /* 여기가 옵저버 */

public class ResponseHandler implements Observer {
    private String resp;

    @Override
    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            resp = (String) arg;
            System.out.println("\nReceived Response: " + resp);
        }
    }
}