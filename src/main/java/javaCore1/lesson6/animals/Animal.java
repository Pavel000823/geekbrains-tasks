package javaCore1.lesson6.animals;

public abstract class Animal {

    private String name;
    private int maxSwimDistance;
    private int maxRunDistance;
    private String typeAnimal;
    public static int count;

    public Animal(String typeAnimal, String name, int maxRunDistance, int maxSwimDistance) {
        this.typeAnimal = typeAnimal;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        count++;
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(typeAnimal + " по кличке " + name + " не умеет плавать ");
            return;
        }
        if (maxSwimDistance >= distance) {
            System.out.println(typeAnimal + " по кличке " + name + " смог проплыть " + distance + " м.");
            return;
        }
        System.out.println(typeAnimal + " по кличке " + name + " не смог проплыть " + distance + " м.");
    }

    public void run(int distance) {
        if (maxRunDistance >= distance) {
            System.out.println(typeAnimal + " по кличке " + name + " смог пробежать " + distance + " м.");
            return;
        }
        System.out.println(typeAnimal + " по кличке " + name + " не смог пробежать " + distance + " м.");
    }
}
