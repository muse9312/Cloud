package Duck.control;

import Duck.entitiy.Duck;
import Duck.entitiy.MallardDuck;
import Duck.entitiy.RedDuck;

public class Main {
    public static void main(String[] args) throws Exception {
        Duck du = new Duck();

        du.display();
        MallardDuck m = new MallardDuck();

        m.display();
        RedDuck R = new RedDuck();

        R.display();
        // m.swim();
        // m.quack();

    }
}
