package javaCore2.lesson1.obstracles;

import javaCore2.lesson1.participants.Cat;
import javaCore2.lesson1.participants.Human;
import javaCore2.lesson1.participants.Robot;

public class Wall implements Obstacle {

    private final int height;


    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Object participant) {
        if (participant instanceof Cat) {
            return ((Cat) participant).jump(height);
        }
        if (participant instanceof Robot) {
            return ((Robot) participant).jump(height);
        }
        if (participant instanceof Human) {
            return ((Human) participant).jump(height);
        }
        System.out.println("Ничего не знаем об участнике " + participant.toString());
        return false;
    }
}
