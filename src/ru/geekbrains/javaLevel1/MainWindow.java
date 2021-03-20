package ru.geekbrains.javaLevel1;

public class MainWindow {

    public static void main(String[] args) {
        A a1 = new A() {
            @Override
            public int foo(String s) {
                return s.length();
            }
        };

        // lambda
        f(s -> s.length());
        f(s -> (s + "hello").length());

//        B b1 = (a, b)-> {
//            b *= 2;
//            return a.length() + b;
//        };

    }

    public static void f(A a) {
        System.out.println(a.foo("hlo"));
    }

}

@FunctionalInterface
interface A {
    int foo(String str);
}
interface B {

    int foo1(String a, int b);
}
