package com.programmers.designpattern.begavioral.observer;

import java.util.Observable; // 이 부분이 옵저버에게 신호를 보내는 주체입니다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EventSource extends Observable implements Runnable {
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                final String response = br.readLine();
                setChanged();
                notifyObservers(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}