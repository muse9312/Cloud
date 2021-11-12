package ex;

public class Player {
    private int x;
    private int y;
    private String myShape;

    public void display(int x, int y, String myShape) {
        System.out.println(x + " ," + y + " = " + myShape);

    }

    public void moveLeft(int x, int y) {

    }

    public void moveRight(int x, int y) {

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
