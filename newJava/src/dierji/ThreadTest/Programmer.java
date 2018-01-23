package dierji.ThreadTest;

public class Programmer implements Runnable{
    //185
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("一边hw" + i);
        }
    }
}

