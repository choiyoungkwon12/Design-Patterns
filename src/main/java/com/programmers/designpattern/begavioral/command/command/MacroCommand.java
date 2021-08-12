package com.programmers.designpattern.begavioral.command.command;

import java.util.Stack;

// 명령 집합
public class MacroCommand implements Command {

    private Stack<Command> commands = new Stack<>();

    // 명령들을 하나씩 실행
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    // 추가
    public void append(Command cmd) {
        // 자기 자신을 실수로 add 하는 것 방지, 영원히 종료되지 않음
        if (cmd != this) {
            commands.push(cmd);
        }
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }

    // 전부 삭제
    public void clear() {
        commands.clear();
    }
}
