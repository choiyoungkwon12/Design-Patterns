package com.programmers.designpattern.structural.bridge.implement;

public class HyphenStringDisplayImpl extends DisplayImpl {
    // 표시해야 할 문자열
    private String string;

    // 바이트 단위로 계산할 문자열의 '길이'
    private int width;

    // 생성자에서 전달된 문자열 string을 필드에 저장
    public HyphenStringDisplayImpl(String string) {
        this.string = string;

        // 바이트 단위의 길이도 필드에 저장 후 나중에 사용
        this.width = string.getBytes().length;
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|"); // 앞 뒤에 |를 붙여서 표시
    }

    @Override
    public void rawClose() {
        printLine();
    }


    private void printLine() {
        System.out.print("+");  // 테두리의 모서리를 표현하는 "+" 마크를 표시한다.
        for (int i = 0; i < width; i++) {   // width개의 "-"를 표시해서
            System.out.print("-");          // 테두리 선으로 이용한다.
        }
        System.out.println("+");
    }
}
