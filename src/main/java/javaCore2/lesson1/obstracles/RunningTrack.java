package javaCore2.lesson1.obstracles;

import javaCore2.lesson1.participants.Cat;
import javaCore2.lesson1.participants.Human;
import javaCore2.lesson1.participants.Robot;

public class RunningTrack implements Obstacle {

    private final int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Object participant) {
        if (participant instanceof Cat) {
            return ((Cat) participant).run(length);
        }
        if (participant instanceof Robot) {
            return ((Robot) participant).run(length);
        }
        if (participant instanceof Human) {
            return ((Human) participant).run(length);
        }
        System.out.println("Ничего не знаем об участнике " + participant.toString());
        return false;
    }
}
