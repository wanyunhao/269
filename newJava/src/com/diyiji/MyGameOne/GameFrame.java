package com.diyiji.MyGameOne;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 游戏窗口类
 */
public class GameFrame extends Frame {

    Image img = GameUtil.getImage("images/sun.jpg");


    /*
    * 加载窗口
    */

    public void launchFrame(){
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

//    必须要实现父类的方法
    @Override
    public void paint(Graphics g) {
        g.drawLine(100,100,200,200);
        g.drawRect(100,100,200,200);
        g.drawOval(100,100,200,200);
        Font f= new Font("宋体",Font.BOLD,100);
        g.setFont(f);
        g.drawString("我是餍足",200,200);


        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillRect(100,100,20,20);
        g.setColor(c);

        x += 3;
        y += 3;
        //画图像
        g.drawImage(img,(int)x,(int)y,null);
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
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }
}
