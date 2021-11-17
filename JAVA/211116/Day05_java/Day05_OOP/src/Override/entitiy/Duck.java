package Override.entitiy;

import java.awt.*;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.*;

public class Duck extends JFrame {

    protected int x;

    protected int y;

    public Duck() {

    }

    class MyPanel extends JPanel {
        ImageIcon icon = new ImageIcon(
                "/Users/majestyharia/Cloud/JAVA/211116/Day07_java/Day07_OOP/src/Override/img/duckimg.jpeg");
        Image img = icon.getImage();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 20, 20, this);
        }
    }

    // public void display(Graphics g) {

    // ImageIcon icon = new ImageIcon(
    // "/Users/majestyharia/Cloud/JAVA/211116/Day07_java/Day07_OOP/src/Override/img/duckimg.jpeg");
    // Image img = icon.getImage();

    // // JLabel imgLabel = new JLabel();

    // // ImageIcon icon = new ImageIcon(
    // //
    // "/Users/majestyharia/Cloud/JAVA/211116/Day07_java/Day07_OOP/src/Override/img/duckimg.jpeg");
    // // g.drawImage(icon, x, y, ;

    // }

    /**
     * 
     */
    public void swim() {
        System.out.println("수영");
    }

    /**
     * 
     */
    public void quack() {
        System.out.println("꽥");
    }

}
