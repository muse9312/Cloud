package Game.entity;

import java.util.Random;

/**
 * 
 */
public class Enemy {

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
    private String myShape;

    // =================================================================================

    // 생성자

    /**
     * Default constructor
     */
    public Enemy() {
        Random rand = new Random();
        x = rand.nextInt(400);
        y = rand.nextInt(600);
        myShape = "Enermy";
    }

    /**
     * 
     */
    public void display() { // display = 메서드
        System.out.println(" x = " + x);
        System.out.println(" y = " + y);
        System.out.println(" : " + myShape); // 인스턴스 변수
    }

    /**
     * 
     */
    public void moveLeft() {
        x = x - 10;
        display();
    }

    /**
     * 
     */
    public void moveRight() {
        x = x + 10;
        display();
    }

    /**
     * 
     */
    public void moveUp() {
        y = y + 10;
        display();
    }

    /**
     * 
     */
    public void moveDown() {
        y = y - 10;
        display();
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