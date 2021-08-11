package com.programmers.designpattern.begavioral.command;

import java.util.Stack;

public class MacroCommand implements Command {

    private Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    // 추가
    public void append(Command cmd) {
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
