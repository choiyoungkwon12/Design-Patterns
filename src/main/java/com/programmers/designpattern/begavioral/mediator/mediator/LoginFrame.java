package com.programmers.designpattern.begavioral.mediator.mediator;

import com.programmers.designpattern.begavioral.mediator.colleague.ColleagueButton;
import com.programmers.designpattern.begavioral.mediator.colleague.ColleagueCheckbox;
import com.programmers.designpattern.begavioral.mediator.colleague.ColleagueTextField;
import com.programmers.designpattern.begavioral.mediator.Mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고, 배치후에 표시를 실행한다.
    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해서 4x2의 그리드를 만든다
        setLayout(new GridLayout(4, 2));
        //Colleague들의 생성
        createColleagues();
        // 배치
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username"));
        add(textUser);
        add(new Label("password"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        // 유효/무효의 초기 지정
        colleagueChanged();
        //표시
        pack();
        setVisible(true);
    }

    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, true);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator 설정
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleague에서의 통지로 Colleage의 유효/무효를 판정
    @Override
    public void colleagueChanged() {
        System.out.println("colleagueChanged 호출");
        // 게스트 모드
        if (checkGuest.getState()) {
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {
            textUser.setColleagueEnabled(true);
            userPassChanged();
        }

    }

    // textUser 또는 textPass의 변경이 있었다.
    // 각 Colleague의 유효/무료를 판정한다.
    private void userPassChanged() {
        if (textUser.getText().length() > 0){
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length()>0){
                buttonOk.setColleagueEnabled(true);
            }else{
                buttonOk.setColleagueEnabled(false);
            }
        }else{
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
