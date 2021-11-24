package Duck.control;

import javax.swing.JFrame;

import java.awt.*;

public class MyFrame extends JFrame {

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;

    DuckManger dm = new DuckManger();

    public MyFrame() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);

    }

    public void paint(Graphics g) {
        dm.displayAllDucks(g);

    }

}
