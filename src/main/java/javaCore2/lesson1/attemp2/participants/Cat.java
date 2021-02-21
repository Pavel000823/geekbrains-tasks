package javaCore2.lesson1.attemp2.participants;

import javaCore2.lesson1.attemp2.actions.Actionable;

public class Cat implements Actionable {

    private final String name;
    private int maxRunDistance;
    private int maxHeightJump;

    public Cat(String name, int maxRunDistance, int maxHeightJump) {
        this.name = name;
        this.maxRunDistance = getMaxRunDistance(maxRunDistance);
        this.maxHeightJump = getMaxJumpDistance(maxHeightJump);
    }

    private int getMaxRunDistance(int maxRunDistance) {
        if (maxRunDistance <= 0) {
            return 0;
        }
        return maxRunDistance;
    }

    private int getMaxJumpDistance(int maxHeightJump) {
        if (maxHeightJump <= 0) {
            return 0;
        }
        return maxHeightJump;
    }
}
