package dierji.ThreadTest;

public class createThreadDemo01 {
    public static void main(String[] args) {
        Rabit rabit = new Rabit();
        //不用调用run方法
        rabit.start();
    }
}

class Rabit extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("第" + (i + 1) + "步");
        }
    }
}