package Duck.entitiy;

import java.awt.*;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super();

    }

    public MallardDuck(int x, int y, int Size) {
        super(x, y, Size);
    }

    @Override
    public void display(Graphics g) {
        Color color = new Color(0, 0, 255);
        g.setColor(color);
        g.fillOval(x, y, Size, Size);

        super.display(g);

    }

    @Override
    public void swim(Graphics g) {
        g.drawString("파랑수영", x - 2, y);
        super.swim(g);
    }

    @Override
    public void quack(Graphics g) {
        g.drawString("파랑꽥", x + 2, y);
        super.quack(g);
    }

}
