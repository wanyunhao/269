package com.diyiji;

public class MyException extends Exception {
    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }

}

class TestMyException {

    void test()throws MyException {

    }

    public static void main(String[] args) throws MyException {
        new TestMyException().test();
    }
}