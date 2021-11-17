package Duck.entitiy;

import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Duck {
    protected int x;
    protected int y;
    protected int Size;

    JFrame frame = new JFrame();

    // Overloding = 하나의 객체안에 동일한 이름의 메소드가 존재가능, 다 인수의 갯수, 타입이 달라야 한다.
    public Duck() {
        Random rnd = new Random();
        x = rnd.nextInt(800);
        y = rnd.nextInt(600);
        Size = 30;

    }

    public Duck(int x, int y, int Size) {
        this.x = x;
        this.y = y;
        this.Size = Size;
    }

    // public void dukimg() throws IOException {
    // File file = new File("./img/duckimg.jpeg");
    // BufferedImage img = ImageIO.read(file);
    // JLabel lb = new JLabel(new ImageIcon(img));

    // }

    public void display(Graphics g) {
        // JPanel myPanel = new JPanel();

        // ImageIcon icon = new ImageIcon("./img/duckimg.jpeg");

        // Image img = icon.getImage();

        // Image img = Toolkit.getDefaultToolkit().getImage("./img/duckimg.jpeg");
        // g.drawImage(img, 0, 0, null);
        // g.fillOval(x, y, Size, Size);

    }

    public void swim(Graphics g) {

    }

    public void quack(Graphics g) {

    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return this.Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

}
