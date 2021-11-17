
package Game.entity;

import java.util.Random;

public class Player {

    /**
     * 
     */
    private int x;

    /**
     * 
     */
    private int y;

    /**
     * 
     */
    public String myShape;

    /**
     * Default constructor
     */
    public Player() {
        Random rand = new Random();
        x = rand.nextInt(400);
        y = rand.nextInt(600);
        myShape = "Player";
    }

    /**
     * 
     */
    public void display() {
        System.out.println(" x = " + x);
        System.out.println(" y = " + y);
        System.out.println(" : " + myShape);
    }

    /**
     * 
     */
    public void moveLeft() {

    }

    /**
     * 
     */
    public void moveRight() {

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

    public String getMyShape() {
        return this.myShape;
    }

    public void setMyShape(String myShape) {
        this.myShape = myShape;
    }

}