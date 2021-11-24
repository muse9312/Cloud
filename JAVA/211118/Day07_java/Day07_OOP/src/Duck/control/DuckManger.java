package Duck.control;

import java.util.Random;
import java.awt.*;

import Duck.entitiy.Duck;

import Duck.entitiy.MallardDuck;
import Duck.entitiy.RedDuck;

public class DuckManger {

    Duck darr[] = new Duck[10];

    public DuckManger() {
        makeDuck();
    }

    private void makeDuck() {
        // 10마리를 랜덤하게
        Random rand = new Random();

        int type = 0;

        for (int i = 0; i < darr.length; i++) {
            type = rand.nextInt(2);
            switch (type) {
            case 0:
                darr[i] = new MallardDuck();
                break;
            case 1:
                darr[i] = new RedDuck();
                break;
            default:
                darr[i] = new MallardDuck();
            }

        }

    }

    public void displayAllDucks(Graphics g) {
        for (Duck d : darr) {
            if (d != null) {
                d.display(g);
                d.swim(g);
                d.quack(g);
            }

        }
    }

    public void swimAllDucks(Graphics g) {

    }

    public void quackAllDucks(Graphics g) {

    }

}
