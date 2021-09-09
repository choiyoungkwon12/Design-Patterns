package com.programmers.designpattern.begavioral.visitor.dispatch;

import java.util.Arrays;
import java.util.List;

public class Dispatch {
    static abstract class Service {
        abstract void run();
    }

    static class MyService1 extends Service {
        @Override
        void run() {
            System.out.println("run1");
        }
    }

    static class MyService2 extends Service {
        @Override
        void run() {
            System.out.println("run2");
        }
    }

    public static void main(String[] args) {
        Service service = new MyService1();

        // note : run 이라는 코드는 여기서만 봤을 때 둘중(구현클래스)에 어떤것을 실행시킬지 컴파일 타임에는 결정되어잇지 않다
        //  하지만 MyService1의 메서드가 실행되는데 이때 다이나믹 디스패치가 일어나게 된다.
        //  메서드 호출 과정에서 첫번째로 들어가는 것이 receiver parameter 라는 것이 들어간다.
        //  모든 클래스에 this가 정의되어 있는데 그것이 receiver parameter로 들어가 있다.
        //  그래서 실제 어떤것을 실행시킬지는 런타임시점에서 service에 할당되어있는 객체에 따라서 결정된다.
        service.run();

        // 예시
        List<Service> services = Arrays.asList(new MyService1(), new MyService2());
        // note : 이렇게 생성했을 떄는 어떤 클래스가 사용될지 한눈에 보이지 않는데
        //  런타임에서 실제로 어떤 객체가 할당 되어 있는지에 따라 컬렉션을 반복할 때 해당 객체의 메서드가 실행된다.
        services.forEach(Service::run);

    }
}
