package javaCore2.lesson1.participants;

public class Human {

    private final String name;
    private int maxRunDistance;
    private int maxHeightJump;
    private final String type;

    public Human(String name, int maxRunDistance, int maxRunJump) {
        type = "Человек";
        this.name = name;
        this.maxRunDistance = getMaxRunDistance(maxRunDistance);
        this.maxHeightJump = getMaxJumpDistance(maxRunJump);
    }

    public boolean run(int distance) {
        if (maxRunDistance == 0) {
            System.out.println(type + " : " + name + " не может бегать по неким причинам");
            return false;
        }
        if (maxRunDistance >= distance) {
            System.out.println(type + " : " + name + " успешно справился с дистанцией " + distance + "м.");
            return true;
        }
        System.out.println(type + " : " + name + " не смог справился с дистанцией " + distance + "м.");
        return false;
    }

    public boolean jump(int height) {
        if (maxHeightJump == 0) {
            System.out.println(type + " : " + name + " не может прыгать по неким причинам");
            return false;
        }
        if (maxHeightJump >= height) {
            System.out.println(type + " : " + name + " успешно справился с высотой " + height + "м.");
            return true;
        }
        System.out.println(type + " : " + name + " не смог справился с высотой " + height + "м.");
        return false;
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

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", maxRunDistance=" + maxRunDistance +
                ", maxHeightJump=" + maxHeightJump +
                ", type='" + type + '\'' +
                '}';
    }
}
