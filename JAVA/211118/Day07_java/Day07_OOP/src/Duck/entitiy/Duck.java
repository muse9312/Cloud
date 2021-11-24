package Duck.entitiy;

import java.awt.*;
import java.util.Random;

import Duck.control.MyFrame;

public class Duck {

    Duck d1[] = new MallardDuck[5];
    Duck d2[] = new RedDuck[5];

    // 인스터스 변수
    protected int x;
    protected int y;
    // 클래스 변수 = static
    static int Size = 30;

    public Duck() {
        Random rand = new Random();
        x = rand.nextInt(MyFrame.FRAME_WIDTH - 100) + 50;
        y = rand.nextInt(MyFrame.FRAME_HEIGHT - 140) + 70;

    }

    public Duck(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display(Graphics g) {

    }

    public final void swim(Graphics g) {
        g.drawString("수영", x + 6, y - 2);
    }

    public final void quack(Graphics g) {
        g.drawString("꽥", x - 6, y - 2);
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

}
