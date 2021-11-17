package Duck.control;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import Duck.entitiy.Duck;
import Duck.entitiy.MallardDuck;
import Duck.entitiy.RedDuck;

public class MyFrame extends JFrame {
    public final int FRAME_WIDTH;
    public final int FRAME_HEIGHT;
    public Image img = null;

    private Duck d = new Duck();
    private MallardDuck[] md = new MallardDuck[10];
    private RedDuck[] rd = new RedDuck[10];

    public MyFrame() {
        FRAME_WIDTH = 800;
        FRAME_HEIGHT = 600;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
    }

    public MyFrame(int FRAME_WIDTH, int FRAME_HEIGHT, MallardDuck m, RedDuck r) {
        super();
        this.FRAME_WIDTH = FRAME_WIDTH;
        this.FRAME_HEIGHT = FRAME_HEIGHT;
        this.m = m;
        this.r = r;

    }

    @Override
    public void paint(Graphics g) {

        // Graphics Context

        for (int i = 0; i < 5; i++) {
            md[i] = new MallardDuck();
            rd[i] = new RedDuck();

            md[i].display(g);
            md[i].swim(g);
            md[i].quack(g);

            rd[i].display(g);
            rd[i].swim(g);
            rd[i].quack(g);

        }

    }

    MallardDuck m = new MallardDuck();
    RedDuck r = new RedDuck();
}
