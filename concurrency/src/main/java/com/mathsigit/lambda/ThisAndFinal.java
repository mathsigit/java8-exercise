package com.mathsigit.lambda;

public class ThisAndFinal {
    public static void main(String[] args) {

        new Hello().r1.run();
        new Hello().r2.run();
        new Hello().r3.run();
        new Hello().r4.run();
    }
}


class Hello{
    Runnable r1 = new Runnable() {
        public void run() {
            System.out.println(this);
        }
    };
    Runnable r2 = new Runnable() {
        public void run() {
            System.out.println(toString());
        }
    };

    Runnable r3 = () -> System.out.println(this);
    Runnable r4 = () -> System.out.println(toString());

    public String toString() {
        return "Hello, world!";
    }
}