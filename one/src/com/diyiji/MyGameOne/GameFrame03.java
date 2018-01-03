package com.diyiji.MyGameOne;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 游戏窗口类
 */
public class GameFrame03 extends Frame {

    Image img = GameUtil.getImage("images/sun.jpg");


    /*
    * 加载窗口
    */

    public void launchFrame02(){
        setSize(500,500);
        setLocation(100,100);
        setVisible(true);

        new PaintThread().start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    private double x = 100,y = 100;
    private double degree = 3.14/3;//[0,2pi]
    private double speed = 10;
    //    必须要实现父类的方法
    @Override
    public void paint(Graphics g) {
        //画图像
        g.drawImage(img,(int)x,(int)y,null);
        x += speed *Math.cos(degree);
        y += speed *Math.sin(degree);

        if (speed > 0) {
            speed -= 0.05;
        }else {
            speed = 0;
        }
        if (y > 500 - 30 || y < 30) {
            degree = - degree;
        }
        if (x < 0 || x > 470) {
            degree = Math.PI - degree;
        }



    }

    /*
    * 定义一个重画窗口的线程类,是一个内部类
    */
    class PaintThread extends Thread {
        public void run() {
            while (true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        GameFrame03 gf = new GameFrame03();
        gf.launchFrame02();
    }
}
