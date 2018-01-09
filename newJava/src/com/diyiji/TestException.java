package com.diyiji;

public class TestException {
    public static void main(String[] args) {
        System.out.println("begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");

        Computer c = null;
        if (c == null) {
            c = new Computer();
            c.start();
        }
    }
}

class Computer {
    void start () {
        System.out.println("windows start");
    }
}
