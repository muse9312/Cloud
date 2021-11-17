package Duck.entitiy;

import java.util.Random;

public class Duck {

    protected int x;

    protected int y;

    private int size;

    public Duck() {
        Random rand = new Random();
        x = rand.nextInt(800);
        y = rand.nextInt(600);
        size = 30;

    }

    public void display() {
        System.out.println("Duck_Display : " + x + " " + y);
    }

    /**
     * 
     */
    public void swim() {
        System.out.println("수영");
    }

    /**
     * 
     */
    public void quack() {
        System.out.println("꽥");
    }

}
