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

        Duck[] d = new Duck[10];
        for (int i = 0; i < 10; i++) {
            d[i] = new Duck();
            d[i].paintComponents(g);
        }

    }
}
