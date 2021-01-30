package lesson6.animals;

public class Cat extends Animal {

    public static int count;

    public Cat(String name) {
        super("Кот", name, 200, 0);
        count++;
    }
}
