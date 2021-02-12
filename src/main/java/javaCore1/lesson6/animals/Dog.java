package javaCore1.lesson6.animals;

public class Dog extends Animal {

    public static int count;

    public Dog(String name) {
        super("Пес", name, 500, 10);
        count++;
    }

}
