package javaCore2.lesson1.attemp2.actions;

public interface Jumble {

    default boolean jump(String name,int maxJumpDistance,int height){
        if (maxJumpDistance == 0) {
            System.out.println(name + " не может прыгать по неким причинам");
            return false;
        }
        if (maxJumpDistance >= height) {
            System.out.println( name + " успешно справился с высотой " + height + "м.");
            return true;
        }
        System.out.println(name + " не смог справился с высотой " + height + "м.");
        return false;
    }
}
