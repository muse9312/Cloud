package Duck.entitiy;

import java.awt.*;

public class RedDuck extends Duck {

    public RedDuck() {
        super();

    }

    public RedDuck(int x, int y, int Size) {
        super(x, y, Size);
    }

    @Override
    public void display(Graphics g) {
        Color color = new Color(255, 0, 0);
        g.setColor(color);
        g.fillOval(x, y, Size, Size);

        super.display(g);
    }

    @Override
    public void swim(Graphics g) {
        g.drawString("빨강수영", x - 2, y);
        super.swim(g);
    }

    @Override
    public void quack(Graphics g) {
        g.drawString("빨강꽥", x + 2, y);
        super.quack(g);
    }

}
