package com.neuedu.main;

import com.neuedu.constant.Frameconstant;
import com.neuedu.runtime.Background;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gameframe extends Frame {

    private Background background = new Background();

    @Override
    public void paint(Graphics g) {
        background.draw(g);
    }

    /**
     * 使用这个方法初始化窗口
     */
    public void init(){
        //设置好窗口尺寸
    setSize(Frameconstant.FRAME_WIDTH, Frameconstant.FRAME_HEIGHT);

    //设置窗口居中
    setLocationRelativeTo(null);

    enableInputMethods(false);

    addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });

    setVisible(true);

    new Thread() {

        @Override
        public void run() {
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }.start();
    }

}
