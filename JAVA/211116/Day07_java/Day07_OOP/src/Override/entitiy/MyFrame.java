package Override.entitiy;

import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;

public class MyFrame extends JFrame {
    int Frame_width = 800;
    int Frame_height = 600;

    public MyFrame() {
        super(); // JFrame f = new JFrame();
        this.setSize(Frame_width, Frame_height);
        this.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {

            int x = rand.nextInt(800);
            int y = rand.nextInt(600);

            int red = rand.nextInt(256);
            int green = rand.nextInt(256);
            int blue = rand.nextInt(256);
            Color c = new Color(red, green, blue);
            g.setColor(c);
            g.fillOval(x, y, 30, 30);

        }

    }
}
