package com.programmers.designpattern.begavioral.command;

import com.programmers.designpattern.begavioral.command.command.Command;
import com.programmers.designpattern.begavioral.command.drawer.DrawCanvas;
import com.programmers.designpattern.begavioral.command.drawer.DrawCommand;
import com.programmers.designpattern.begavioral.command.command.MacroCommand;

import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

    // 그림 그린 이력
    private MacroCommand history = new MacroCommand();

    // 그림 그리는 영역 설정
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    // 제거 버튼
    private JButton clearButton = new JButton("clear");

    // Undo 버튼
    private JButton undoButton = new JButton("undo");

    // 마우스 클릭등의 이벤트를 받아들이기 위한 리스너 설정
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    // 버튼 클릭 시 발동 되는 메소드
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        } else if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        }
    }

    // 마우스 드래그 이벤트
    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void windowOpened(WindowEvent e) {

    }


    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
