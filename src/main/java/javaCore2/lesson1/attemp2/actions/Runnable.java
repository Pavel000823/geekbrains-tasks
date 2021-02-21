package javaCore2.lesson1.attemp2.actions;

public interface Runnable {

    default boolean run(String name, int maxRunDistance, int distance) {
        if (maxRunDistance == 0) {
            System.out.println(name + " не может бегать по неким причинам");
            return false;
        }
        if (maxRunDistance >= distance) {
            System.out.println(name + " успешно справился с дистанцией " + distance + "м.");
            return true;
        }
        System.out.println(name + " не смог справился с дистанцией " + distance + "м.");
        return false;
    }
}
