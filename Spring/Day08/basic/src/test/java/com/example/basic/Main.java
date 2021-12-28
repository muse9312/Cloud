package com.example.basic;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

class MyListener implements MouseInputListener  {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        int num = (int) (Math.random() * 45 + 1);
        System.out.println(num);
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}

public class Main {
    // public static void main(String[] args) {
    //     JFrame j = new JFrame("윈도우~~!!!!");
    //     JButton btn = new JButton("버튼");

    //     btn.addMouseListener(  new MyListener()  );

    //     j.add(btn);
    //     j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     j.setSize(300, 150);
    //     j.setVisible(true);
    // }
}
