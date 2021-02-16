package javaCore2.lesson1.attemp1;

import javaCore2.lesson1.attemp1.obstracles.Obstacle;
import javaCore2.lesson1.attemp1.obstracles.RunningTrack;
import javaCore2.lesson1.attemp1.obstracles.Wall;
import javaCore2.lesson1.attemp1.participants.Cat;
import javaCore2.lesson1.attemp1.participants.Human;
import javaCore2.lesson1.attemp1.participants.Robot;

public class MainApp {

    public static void main(String[] args) {
        Object[] party = {new Human("Павел", 50, 0),
                new Cat("Филя", 500, 4),
                new Robot("Бендер", 1000, 10),
                new Human("Иван", 550, 1),
                new Cat("Маркел", 500, 0)};

        Obstacle[] obstacles = {new RunningTrack(500), new Wall(2)};

        for (Object participant : party) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    break;
                }
            }
        }
    }
}
