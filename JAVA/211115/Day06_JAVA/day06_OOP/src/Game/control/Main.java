package Game.control;

import Game.entity.Enemy;
import Game.entity.Player;

public class Main {

    public static void main(String[] args) throws Exception {

        // p1 = 참조변수
        Player p1 = new Player();
        p1.display();

        Player p2 = new Player();
        p2.display();
        p2.moveLeft();

        // =================================================================

        // enermy 참조변수
        Enemy e1 = new Enemy();
        e1.display();
        e1.moveRight();

        Enemy e2 = new Enemy();
        e2.display();
        e2.moveLeft();

        Enemy e3 = new Enemy();
        e3.display();
        e3.moveLeft();

        Enemy e4 = new Enemy();
        e4.display();
        e4.moveRight();

    }
}
