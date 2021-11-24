package Duck.entitiy;

import java.awt.Color;
import java.awt.Graphics;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super();
    }

    public MallardDuck(int x, int y) {
        super(x, y);
    }

    @Override
    public void display(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(x, y, Size, Size);
        super.display(g);
    }

}
